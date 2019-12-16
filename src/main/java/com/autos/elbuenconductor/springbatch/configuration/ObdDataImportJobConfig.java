package com.autos.elbuenconductor.springbatch.configuration;

import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.autos.elbuenconductor.model.Cliente;
import com.autos.elbuenconductor.model.Trayecto;
import com.autos.elbuenconductor.model.Vehiculo;
import com.autos.elbuenconductor.springbatch.TrayectoDTO;

@Configuration
public class ObdDataImportJobConfig {

	@Autowired
	protected DataSource dataSource;
	
	@Autowired
	protected JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	protected StepBuilderFactory stepBuilderFactory;
	
	public FlatFileItemReader<TrayectoDTO> reader(){
		
		return new FlatFileItemReaderBuilder<TrayectoDTO>()
			.name("reader_trayecto")
			.resource(new FileSystemResource("io/entradas/datos_obd_3_3.csv"))
			.linesToSkip(1)
			.delimited()
			.delimiter(";")
			.names(new String[] {"id","dni","matricula","kmRecorridos","nAcelerones","nFrenazos","rpmMedias","inicio","fin"})
			.fieldSetMapper(new BeanWrapperFieldSetMapper<TrayectoDTO>(){{
				setTargetType(TrayectoDTO.class);
			}}).build();
	}
	
	public ItemProcessor<TrayectoDTO, Trayecto> itemProcessor(){
		return new ItemProcessor<TrayectoDTO, Trayecto>(){

			@Override
			public Trayecto process(TrayectoDTO item) throws Exception {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
				
				Vehiculo vehiculo = new Vehiculo();
				Cliente cliente = new Cliente();
				
				vehiculo.setMatricula(item.getMatricula());
				cliente.setDNI(item.getDni());
				
				Trayecto trayecto = new Trayecto();
				trayecto.setId(item.getId());
				trayecto.setCliente(cliente);
				trayecto.setVehiculo(vehiculo);
				trayecto.setnAcelerones(item.getnAcelerones());
				trayecto.setnFrenazos(item.getnFrenazos());
				trayecto.setKmRecorridos(Double.parseDouble(item.getKmRecorridos().replace(",", ".")));
				trayecto.setRpmMedias(Double.parseDouble(item.getRpmMedias().replace(",", ".")));
				trayecto.setInicio(sdf.parse(item.getInicio()));
				trayecto.setFin(sdf.parse(item.getFin()));
		
				return trayecto;
			}
			
		};
	}
	
	@Bean
	public JdbcBatchItemWriter<Trayecto> writer(){
		return new JdbcBatchItemWriterBuilder<Trayecto>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO TRAYECTOS (ID, DNI, MATRICULA, KM_RECORRIDOS, N_ACELERONES, N_FRENAZOS, RPM_MEDIAS, INICIO, FIN) VALUES (:id, :cliente.DNI, :vehiculo.matricula, :kmRecorridos, :nAcelerones, :nFrenazos, :rpmMedias, :inicio, :fin)")
				.dataSource(dataSource)
				.build();
	}
	
 	@Bean
	public Step step() {
		return stepBuilderFactory.get("step")
				.<TrayectoDTO,Trayecto> chunk(5)
				.reader(reader())
				.processor(itemProcessor())
				.writer(writer())
				.build();
	}
	
	
	// configurar el job
	
	@Bean
	public Job job2() {
		return jobBuilderFactory.get("job_obd_import")
				.flow(step())
				.end()
				.build();
	}
	
}

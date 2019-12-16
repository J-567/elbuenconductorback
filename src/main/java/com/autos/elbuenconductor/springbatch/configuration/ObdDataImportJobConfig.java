package com.autos.elbuenconductor.springbatch.configuration;

import java.util.Date;

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
		
		//LineTokenizer tokenizer = new DelimitedLineTokenizer(";");
		//System.out.println();
		//tokenizer.setDelimiter(";");
		//tokenizer.setNames(new String[]{"id", "name"});
		
		return new FlatFileItemReaderBuilder<TrayectoDTO>()
			.name("reader_trayecto")
			.resource(new FileSystemResource("io/entradas/datos_obd_6c.csv"))
			.linesToSkip(1)
			//.lineTokenizer(tokenizer)
			//.lineTokenizer(new DelimitedLineTokenizer(";"))
			.delimited()
			.delimiter(";")
			.names(new String[] {"id","matricula","kmRecorridos","nAcelerones","nFrenazos","rpmMedias"})
			.fieldSetMapper(new BeanWrapperFieldSetMapper<TrayectoDTO>(){{
				setTargetType(TrayectoDTO.class);
			}}).build();
	}
	
	public ItemProcessor<TrayectoDTO, Trayecto> itemProcessor(){
		return new ItemProcessor<TrayectoDTO, Trayecto>(){

			@Override
			public Trayecto process(TrayectoDTO item) throws Exception {
				
				System.out.println(item);
				
				Trayecto trayecto = new Trayecto();
				trayecto.setId(item.getId());
				trayecto.setMatricula(item.getMatricula());
				trayecto.setnAcelerones(item.getnAcelerones());
				trayecto.setnFrenazos(item.getnFrenazos());
				trayecto.setKmRecorridos(Double.parseDouble(item.getKmRecorridos().replace(",", ".")));
				
				trayecto.setRpmMedias(3500.0);  // double?
				trayecto.setInicio(new Date());
				trayecto.setFin(new Date());
		
				return trayecto;
			}
			
		};
	}
	
	
	@Bean
	public JdbcBatchItemWriter<Trayecto> writer(){
		return new JdbcBatchItemWriterBuilder<Trayecto>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO TRAYECTOS (ID, MATRICULA, KM_RECORRIDOS, N_ACELERONES, N_FRENAZOS, RPM_MEDIAS, INICIO, FIN) VALUES (:id, :matricula, :kmRecorridos, :nAcelerones, :nFrenazos, :rpmMedias, :inicio, :fin)")
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
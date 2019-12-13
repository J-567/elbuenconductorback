package com.autos.elbuenconductor.springbatch.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.RegexLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ObdDataImportJobConfig {

	@Autowired
	protected DataSource dataSource;
	
	@Autowired
	protected JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	protected StepBuilderFactory stepBuilderFactory;
	
	public FlatFileItemReader<Trayecto> reader(){
		return new FlatFileItemReaderBuilder<Trayecto>()
			.name("reader_trayecto")
			.resource(new FileSystemResource("io/entradas/datos_obd_6c.csv"))
			.linesToSkip(1)
			//.lineTokenizer(new RegexLineTokenizer().setRegex(";"))
			.delimited()
			.names(new String[] {"id","matricula","kmRecorridos","nAcelerones","nFrenazos","rpmMedias"})
			.fieldSetMapper(new BeanWrapperFieldSetMapper<Trayecto>(){{
				setTargetType(Trayecto.class);
			}}).build();
	}
	
	
	@Bean
	public JdbcBatchItemWriter<Trayecto> writer(){
		return new JdbcBatchItemWriterBuilder<Trayecto>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO TRAYECTOS (ID,MATRICULA,KM_RECORRIDOS,N_ACELERONES,N_FRENAZOS,RPM_MEDIAS) VALUES (:id,:matricula,:kmRecorridos,:nAcelerones,:nFrenazos,:rpmMedias)")
				.dataSource(dataSource)
				.build();
	}
	
 	@Bean
	public Step step() {
		return stepBuilderFactory.get("step")
				.<Trayecto,Trayecto> chunk(5)
				.reader(reader())
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

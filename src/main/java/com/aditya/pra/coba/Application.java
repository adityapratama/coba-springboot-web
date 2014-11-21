package com.aditya.pra.coba;

import org.joda.time.DateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import com.fasterxml.jackson.datatype.joda.ser.JacksonJodaFormat;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorAwareImpl")
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
	public static void main(String[] args) throws Exception {
	    SpringApplication.run(Application.class, args);
	}
	
	@Bean
    public JodaModule jacksonJodaModule() {
        JodaModule module = new JodaModule();
        DateTimeFormatterFactory formatterFactory = new DateTimeFormatterFactory();
        formatterFactory.setIso(ISO.DATE);
        module.addSerializer(DateTime.class, new DateTimeSerializer(
            new JacksonJodaFormat(formatterFactory.createDateTimeFormatter()
                .withZoneUTC())));
        return module;
    }
}

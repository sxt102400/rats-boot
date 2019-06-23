package com.rats;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootApplication(exclude={
		MongoAutoConfiguration.class,
		SecurityAutoConfiguration.class
})
@MapperScan("com.rats.**.dao")
@ComponentScan("com.rats")
public class SpringBootCMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCMSApplication.class, args);
	}

}

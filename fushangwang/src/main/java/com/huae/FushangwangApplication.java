package com.huae;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huae.dao")
public class FushangwangApplication {

	public static void main(String[] args) {
		SpringApplication.run(FushangwangApplication.class, args);
	}
}

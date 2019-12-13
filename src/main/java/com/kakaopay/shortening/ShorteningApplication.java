package com.kakaopay.shortening;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy //Aop 활성화
public class ShorteningApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShorteningApplication.class, args);
	}

}

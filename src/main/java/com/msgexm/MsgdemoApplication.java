package com.msgexm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.msgexm.demo_my_service.StudentDataService;

@SpringBootApplication
public class MsgdemoApplication implements CommandLineRunner {
	StudentDataService stdService;
	public static void main(String[] args) {
		SpringApplication.run(MsgdemoApplication.class, args);

	}
	@Override
	  public void run(String... arg) throws Exception {
//		if(stdService!=null)
		{
	
//		stdService.deleteAll();
//		stdService.init();
	  }
	}
}

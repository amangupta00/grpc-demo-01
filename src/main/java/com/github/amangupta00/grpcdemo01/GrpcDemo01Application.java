package com.github.amangupta00.grpcdemo01;

import com.github.amangupta00.grpcdemo01.model.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(User.class)
@MapperScan("com.github.amangupta00.grpcdemo01.dao")
@SpringBootApplication
public class GrpcDemo01Application {

	public static void main(String[] args) {
		SpringApplication.run(GrpcDemo01Application.class, args);
	}
}

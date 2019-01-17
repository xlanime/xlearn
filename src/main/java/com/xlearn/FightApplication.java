package com.xlearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 程序入口类
 * @Author 谢轩辚
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.xlearn.dao")
public class FightApplication {
	public static void main(String[] args) {
		SpringApplication.run(FightApplication.class, args);
	}
}

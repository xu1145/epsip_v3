package com.anlogy.epsip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.anlogy.epsip.mapper")
public class EpsipApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpsipApplication.class, args);
    }

}

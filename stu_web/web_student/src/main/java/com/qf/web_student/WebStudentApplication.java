package com.qf.web_student;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qf")
@DubboComponentScan("com.qf.serviceimpl")
@MapperScan("com.qf.dao")
public class WebStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebStudentApplication.class, args);
    }

}

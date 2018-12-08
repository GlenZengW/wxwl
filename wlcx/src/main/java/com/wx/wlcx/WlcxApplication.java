package com.wx.wlcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.wx.wlcx.mapper")
@EnableSwagger2
public class WlcxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlcxApplication.class, args);
	}
}

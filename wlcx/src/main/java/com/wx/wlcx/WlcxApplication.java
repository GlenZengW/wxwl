package com.wx.wlcx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wx.wlcx.mapper")
public class WlcxApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlcxApplication.class, args);
	}
}

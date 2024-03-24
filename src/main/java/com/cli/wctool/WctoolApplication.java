package com.cli.wctool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan
public class WctoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(WctoolApplication.class, args);
	}

}

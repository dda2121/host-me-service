package com.di.hostme.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {HostMeServiceApplication.class})
public class HostMeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(HostMeServiceApplication.class, args);
  }
}

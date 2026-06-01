package br.com.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContainerServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(ContainerServiceApplication.class);
  }
}

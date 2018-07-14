package com.shivaji.SampleMicroService;

import com.shivaji.SampleMicroService.entity.Car;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SampleMicroServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SampleMicroServiceApplication.class, args);
  }

  /*@Bean
  public CommandLineRunner init(CarRepository carRepository) {
    return (args) -> {
      carRepository.save(new Car("pirus", "hybrid"));
    };
  }*/
}

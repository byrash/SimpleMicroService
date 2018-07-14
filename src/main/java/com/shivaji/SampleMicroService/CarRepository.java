package com.shivaji.SampleMicroService;

import com.shivaji.SampleMicroService.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Shivaji Byrapaneni */
public interface CarRepository extends JpaRepository<Car, Long> {
  Car findByName(String name);
}

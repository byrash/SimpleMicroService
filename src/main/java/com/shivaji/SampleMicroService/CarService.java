package com.shivaji.SampleMicroService;

import com.shivaji.SampleMicroService.entity.Car;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/** @author Shivaji Byrapaneni */
@Service
public class CarService {

  private CarRepository carRepository;

  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Cacheable("cars")
  public Car getCarDetails(String name) {
    Car car = carRepository.findByName(name);
    if (car == null) {
      throw new CarNotFoundException();
    }
    return car;
  }
}

package com.shivaji.SampleMicroService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.shivaji.SampleMicroService.CarNotFoundException;
import com.shivaji.SampleMicroService.CarRepository;
import com.shivaji.SampleMicroService.CarService;
import com.shivaji.SampleMicroService.entity.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

  @Mock private CarRepository carRepository;

  private CarService carService;

  @Before
  public void setup() {
    carService = new CarService(carRepository);
  }

  @Test
  public void getCarDetails_returnCarInfo() {
    given(carRepository.findByName("pirus")).willReturn(new Car("pirus", "hybrid"));

    Car car = carService.getCarDetails("pirus");

    assertThat(car.getName()).isEqualTo("pirus");
    assertThat(car.getType()).isEqualTo("hybrid");
  }

  @Test(expected = CarNotFoundException.class)
  public void getCarDetails_whenCarNotFound() {
    given(carRepository.findByName("pirus")).willReturn(null);
    carService.getCarDetails("pirus");
  }
}

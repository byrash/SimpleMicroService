package com.shivaji.SampleMicroService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.shivaji.SampleMicroService.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/** @author Shivaji Byrapaneni */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {

  @Autowired private CarService carService;

  @MockBean private CarRepository carRepository;

  @Test
  public void caching() {
    given(carRepository.findByName(anyString()))
        .willReturn(new Car("pirus", "hybrid"));

    carService.getCarDetails("pirus");
    carService.getCarDetails("pirus");
    carService.getCarDetails("pirus");
    carService.getCarDetails("pirus");

    verify(carRepository,times(1)).findByName("pirus");
  }
}

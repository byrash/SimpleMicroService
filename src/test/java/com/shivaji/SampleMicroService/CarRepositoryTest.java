package com.shivaji.SampleMicroService;

import com.shivaji.SampleMicroService.CarRepository;
import com.shivaji.SampleMicroService.entity.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class CarRepositoryTest {

  @Autowired private CarRepository carRepository;

  @Autowired private TestEntityManager entityManager;

  @Test
  public void getCar_returnsCarDetails() {

    //This ensures first level cache is not used ot get the b=object back
    //i.e repository save method adds the object to first level cache
    Car savedCar = entityManager.persistFlushFind(new Car("pirus", "hybrid"));

    Car car = carRepository.findByName("pirus");
    Assertions.assertThat(car.getName()).isEqualTo("pirus");
    Assertions.assertThat(car.getType()).isEqualTo("hybrid");
  }
}

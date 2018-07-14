package com.shivaji.SampleMicroService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.shivaji.SampleMicroService.entity.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/** @author Shivaji Byrapaneni */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {

  @Autowired private TestRestTemplate restTemplate;
  @Autowired private CarRepository carRepository;

  @Before
  public void init() {
    carRepository.saveAndFlush(new Car("pirus", "hybrid"));
  }

  @Test
  public void getCar_returnsCarDetails() {
    ResponseEntity<Car> responseEntity = restTemplate.getForEntity("/cars/pirus", Car.class);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody().getName()).isEqualTo("pirus");
    assertThat(responseEntity.getBody().getType()).isEqualTo("hybrid");
  }
}

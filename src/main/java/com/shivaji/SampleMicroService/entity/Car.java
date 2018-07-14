package com.shivaji.SampleMicroService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/** @author Shivaji Byrapaneni */
@Entity
public class Car {

  private Long id;
  private String name;
  private String type;

  public Car() {
  }

  public Car(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Column
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

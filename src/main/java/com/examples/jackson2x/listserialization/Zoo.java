package com.examples.jackson2x.listserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
  public String name;
  public String city;


  @JsonCreator
  public Zoo(@JsonProperty("name") String name, @JsonProperty("city") String city) {
    this.name = name;
    this.city = city;
  }

  public List<Animal> animals = new ArrayList<Animal>();

  public List<Animal> addAnimal(Animal animal) {
    animals.add(animal);
    return animals;
  }

  @Override
  public String toString() {
    return "Zoo [name=" + name + ", city=" + city + ", animals=" + animals + "]";
  }

}


package com.examples.jackson2x.polymorphism;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Elephant extends Animal {
  @JsonCreator
  public Elephant(@JsonProperty("name") String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getSound() {
    return "trumpet";
  }

  public String getType() {
    return "herbivorous";
  }

  public boolean isEndangered() {
    return false;
  }

  @Override
  public String toString() {
    return "Elephant [name=" + name + ", getName()="
        + getName() + ", getSound()=" + getSound()
        + ", getType()=" + getType()
        + ", isEndangered()=" + isEndangered() + "]";
  }

}

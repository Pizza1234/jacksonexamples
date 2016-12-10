package com.examples.jackson2x.polymorphism;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class SerializeExample {
  private static String outputFile = "zoo.json";

  public static void main(String[] args) throws IOException {
    // let start creating the zoo
    Zoo zoo = new Zoo("Samba Wild Park", "Paz");
    Lion lion = new Lion("Simba");
    Elephant elephant = new Elephant("Manny");
    List<Animal> animals = new ArrayList<>();
    animals.add(lion);
    animals.add(elephant);
    zoo.setAnimals(animals);

    ObjectMapper mapper = new ObjectMapper();
    mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(new File(outputFile)), zoo);
  }
}
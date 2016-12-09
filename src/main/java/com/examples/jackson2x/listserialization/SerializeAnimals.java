package com.examples.jackson2x.listserialization;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializeAnimals {
  public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
    List<Animal> animals = new ArrayList<Animal>();
    Lion lion = new Lion("Samba");
    Elephant elephant = new Elephant("Manny");
    animals.add(lion);
    animals.add(elephant);
    ObjectMapper mapper = new ObjectMapper();

    //mapper.writeValue(System.out, animals);
    mapper.writerWithType(new TypeReference<List<Animal>>() {
    }).writeValue(System.out, animals);
    mapper.writerFor(new TypeReference<List<Animal>>() {
    }).writeValue(System.out, animals);


  }
}

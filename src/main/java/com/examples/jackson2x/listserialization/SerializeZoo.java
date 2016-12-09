package com.examples.jackson2x.listserialization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeZoo {
  public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
    Zoo zoo = new Zoo("London Zoo", "London");
    Lion lion = new Lion("Simba");
    Elephant elephant = new Elephant("Manny");
    zoo.addAnimal(elephant).add(lion);
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(System.out, zoo);
  }
}

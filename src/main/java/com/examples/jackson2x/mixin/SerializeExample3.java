package com.examples.jackson2x.mixin;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeExample3 {
  public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    //mapper.addMixInAnnotations(Bird.class, BirdMixIn.class);
    mapper.addMixIn(Bird.class, BirdMixIn.class);
    Bird bird = new Bird("scarlet Ibis");
    bird.setSound("eee");
    bird.setHabitat("water");

    mapper.writerWithDefaultPrettyPrinter().writeValue(new File("bird.json"), bird);
  }

}

package com.examples.jackson2x.polymorphism;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeSerializeExample {

  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Zoo zoo = mapper.readValue(FileUtils.readFileToByteArray(new File("zoo.json")), Zoo.class);
    System.out.println(zoo);
  }
}
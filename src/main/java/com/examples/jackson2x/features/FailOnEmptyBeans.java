package com.examples.jackson2x.features;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class FailOnEmptyBeans {
  public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    Artist artist = new Artist("Rick", "Morty");
    objectMapper.writeValue(new File("json-empty-bean.json"), artist);

  }
}

class Artist {
  private String firstname;
  private String lastname;

  public Artist(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }
}

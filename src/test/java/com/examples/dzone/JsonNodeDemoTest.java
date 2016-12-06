package com.examples.dzone;

import org.junit.Test;

import static org.junit.Assert.*;

public class JsonNodeDemoTest {
  @Test
  public void readJsonWithJsonNode() throws Exception {
    JsonNodeDemo obj= new JsonNodeDemo();
    obj.readJsonWithJsonNode();
  }

  @Test
  public void readPersonalInformation() throws Exception {
    JsonNodeDemo obj= new JsonNodeDemo();
    obj.readPersonalInformation();
  }

  @Test
  public void readPhoneNumbers() throws Exception {
    JsonNodeDemo obj= new JsonNodeDemo();
    obj.readPhoneNumbers();
  }

}
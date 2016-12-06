package com.examples.dzone;

import org.junit.Test;
import static org.junit.Assert.*;
public class ObjectMapperDemoTest {
  @Test
  public void testReadJsonWithObjectMapper() throws Exception {
    ObjectMapperDemo obj= new ObjectMapperDemo();
    obj.readJsonWithObjectMapper();
  }
}
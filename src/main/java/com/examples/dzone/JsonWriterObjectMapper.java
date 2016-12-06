package com.examples.dzone;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;

public class JsonWriterObjectMapper {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  ObjectMapper objectMapper = new ObjectMapper();

  public void writeEmployeeToJson(Employee emp) {
    try {
      String jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
      logger.info("Employee JSON is\n" + jsonInString);
      objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
      objectMapper.writeValue(new File(emp.getId()+"_employee.json"), emp);
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
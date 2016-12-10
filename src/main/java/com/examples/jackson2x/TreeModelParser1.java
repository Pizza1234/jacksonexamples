package com.examples.jackson2x;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

public class TreeModelParser1 {
  public static void main(String[] args) throws IOException {
    String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=5";
    System.setProperty("http.agent", "Chrome");
    String genreJson = IOUtils.toString(new URL(url), Charset.defaultCharset());

    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(genreJson);
    System.out.println(node.getNodeType()); // prints OBJECT
    System.out.println(node.isContainerNode()); // prints true
    Iterator<String> fieldNames = node.fieldNames();
    while (fieldNames.hasNext()) {
      String fieldName = fieldNames.next();
      System.out.println(fieldName);
    }

    System.out.println(node.get("title").asText());
    JsonNode dataset = node.get("dataset");
    System.out.println(dataset.getNodeType()); // Prints ARRAY
    Iterator<JsonNode> datasetElements = dataset.iterator();
    while (datasetElements.hasNext()) {
      JsonNode datasetElement = datasetElements.next();
      System.out.println(datasetElement.getNodeType());// Prints Object
      Iterator<String> datasetElementFields = datasetElement.fieldNames();
      while (datasetElementFields.hasNext()) {
        String datasetElementField = datasetElementFields.next();
        System.out.println(datasetElementField); // prints album_id, ...
      }
      break;
    }
  }
}
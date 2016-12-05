package com.examples.jackson2x;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SerializationExampleTreeModel {
  public static void main(String[] args) throws IOException {
    // Create the node factory that gives us nodes.
    JsonNodeFactory factory = new JsonNodeFactory(false);

    // create a json factory to write the treenode as json. for the example
    // we just write to console
    JsonFactory jsonFactory = new JsonFactory();
    JsonGenerator generator = jsonFactory.createGenerator(System.out);
    ObjectMapper mapper = new ObjectMapper();

    // the root node - album
    ObjectNode album = factory.objectNode();
    album.put("Album-Title", "Kind Of Blue");
    mapper.writeTree(generator, album);

  }

}
package com.examples.jackson1x;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class StreamingAPIExample2Arrays {
  public static void main(String[] args) throws IOException {
    String json = "[{\"foo\": \"bar\"},{\"foo\": \"biz\"}]";

    JsonFactory f = new JsonFactory();
    JsonParser jp = f.createJsonParser(json);
    // advance stream to START_ARRAY first:
    jp.nextToken();
    // and then each time, advance to opening START_OBJECT
    ObjectMapper mapper = new ObjectMapper();
    while (jp.nextToken() == JsonToken.START_OBJECT) {
      Foo foobar = mapper.readValue(jp, Foo.class);
      // process
      // after binding, stream points to closing END_OBJECT
    }
  }
}

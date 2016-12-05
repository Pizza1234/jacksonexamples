package com.examples.jackson1x;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

import java.io.File;
import java.io.IOException;

public class StreamingAPIExample {

  public static void main(String[] args) throws IOException {
    generatorExample();
    parserExample();

  }

  private static void parserExample() throws IOException {
    JsonFactory f = new JsonFactory();
    JsonParser jp = f.createJsonParser(new File("src/main/resources/jackson1x/user.json"));
    User user = new User();
    jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
    while (jp.nextToken() == JsonToken.FIELD_NAME) {
      String fieldname = jp.getCurrentName();
      jp.nextToken(); // move to value, or START_OBJECT/START_ARRAY
      if ("name".equals(fieldname)) { // contains an object
        User.Name name = new User.Name();
        while (jp.nextToken() != JsonToken.END_OBJECT) {
          String namefield = jp.getCurrentName();
          jp.nextToken(); // move to value
          if ("first".equals(namefield)) {
            name.setFirst(jp.getText());
          } else if ("last".equals(namefield)) {
            name.setLast(jp.getText());
          } else {
            throw new IllegalStateException("Unrecognized field '" + fieldname + "'!");
          }
        }
        user.setName(name);
      } else if ("gender".equals(fieldname)) {
        user.setGender(User.Gender.valueOf(jp.getText()));
      } else if ("verified".equals(fieldname)) {
        user.setVerified(jp.getCurrentToken() == JsonToken.VALUE_TRUE);
      } else if ("userImage".equals(fieldname)) {
        user.setUserImage(jp.getBinaryValue());
      } else {
        throw new IllegalStateException("Unrecognized field '" + fieldname + "'!");
      }
    }
    jp.close(); // ensure resources get cleaned up timely and properly
  }

  private static void generatorExample() throws IOException {
    JsonFactory f = new JsonFactory();
    JsonGenerator g = f.createJsonGenerator(new File("src/main/resources/jackson1x/user-modified-streaming-generator.json"),
        JsonEncoding.UTF8);

    g.writeStartObject();
    g.writeObjectFieldStart("name");
    g.writeStringField("first", "Jasdoe");
    g.writeStringField("last", "Sixpack");
    g.writeEndObject(); // for field 'name'
    g.writeStringField("gender", User.Gender.MALE.toString());
    g.writeBooleanField("verified", false);
    g.writeFieldName("userImage"); // no 'writeBinaryField' (yet?)
    byte[] binaryData = "Rm9vYmFyIQ==".getBytes();
    g.writeBinary(binaryData);
    g.writeEndObject();
    g.close(); // important: will force flushing of output, close underlying output stream
  }
}

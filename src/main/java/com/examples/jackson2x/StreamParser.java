package com.examples.jackson2x;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * The aim of this class is to get the list of albums from free music archive
 * (limit to 5)
 *
 */
public class StreamParser {
  public static void main(String[] args) throws IOException {
    // Get a list of albums from free music archive. limit the results to 5
    String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=5";
    System.setProperty("http.agent", "Chrome");
    // get an instance of the json parser from the json factory
    JsonFactory factory = new JsonFactory();
    JsonParser parser = factory.createParser(new URL(url));

    while (!parser.isClosed()) {
      JsonToken token = parser.nextToken();
      if (token == null) {
        break;
      }
      if (JsonToken.FIELD_NAME.equals(token) && "dataset".equals(parser.getCurrentName())) {
        token = parser.nextToken();
        if (!JsonToken.START_ARRAY.equals(token)) {
          break;
        }
        token = parser.nextToken();
        if (!JsonToken.START_OBJECT.equals(token)) {
          break;
        }
        while (true) {
          token = parser.nextToken();
          if (token == null)
            break;
          if (JsonToken.FIELD_NAME.equals(token) && "album_title".equals(parser.getCurrentName())) {
            token = parser.nextToken();
            System.out.println(parser.getText());
          }
        }
      }
    }
  }
}
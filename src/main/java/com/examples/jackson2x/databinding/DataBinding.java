package com.examples.jackson2x.databinding;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataBinding {
  public static void main(String[] args) throws IOException {
    String url = "http://freemusicarchive.org/api/get/albums.json" +
        "?api_key=60BLHNQCAOUFPIBZ&limit=2";
    System.setProperty("http.agent", "Chrome");
    ObjectMapper mapper = new ObjectMapper();
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    Albums albums = mapper.readValue(new URL(url), Albums.class);
    Dataset[] datasets = albums.getDataset();
    for (Dataset dataset : datasets) {
      System.out.println(dataset.getAlbum_title());
    }
  }
}

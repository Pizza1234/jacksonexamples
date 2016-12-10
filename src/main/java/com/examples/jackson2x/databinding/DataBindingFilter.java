package com.examples.jackson2x.databinding;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataBindingFilter {
  public static void main(String[] args) throws IOException {
    String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
    System.setProperty("http.agent", "Chrome");
    ObjectMapper mapper = new ObjectMapper();
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    AlbumsFilter albums = mapper.readValue(new URL(url), AlbumsFilter.class);
    System.out.println(albums.getTotal_pages());
    System.out.println(albums.getTitle());
    for (DatasetFilter dataset : albums.getDatasetFilter()) {
      System.out.println(dataset.getAlbum_comments());
      System.out.println(dataset.get("album_images"));
      System.out.println(dataset.get("tags"));
      System.out.println(dataset.get("album_listens"));
      break;
    }
  }
}

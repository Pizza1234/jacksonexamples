package com.examples.jackson1x;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FullDataBindingPOJOExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        try {
            User user = mapper.readValue(new File("src/main/resources/jackson1x/user.json"), User.class);
            mapper.writeValue(new File("src/main/resources/jackson1x/user-modified-full.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package com.examples.jackson1x;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;

public class DataBindingWithGenerics {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //Map<String,com.examples.jackson1x.User> result = mapper.readValue(src, new TypeReference<Map<String,com.examples.jackson1x.User>>() { });
        User result = mapper.readValue(new File("src/main/resources/jackson1x/user.json"), new TypeReference<User>() { });
        System.out.println(result);
    }
}

package com.examples.jackson1x;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RawDataBindingExample {
    public static void main(String[] args) throws IOException {
        Map<String,Object> userData = readFromJson("jackson1x/user.json");
        writeToJson();
    }

    private static void writeToJson() throws IOException {
        Map<String,Object> userData = new HashMap<String,Object>();
        Map<String,String> nameStruct = new HashMap<String,String>();
        nameStruct.put("first", "Joe");
        nameStruct.put("last", "Sixpack");
        userData.put("name", nameStruct);
        userData.put("gender", "MALE");
        userData.put("verified", Boolean.FALSE);
        userData.put("userImage", "Rm9vYmFyIQ==");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/jackson1x/user-modified-raw.json"), userData);
    }

    private static Map<String,Object> readFromJson(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> userData = mapper.readValue(new File("src/main/resources/jackson1x/user.json"), Map.class);
        return userData;
    }
}

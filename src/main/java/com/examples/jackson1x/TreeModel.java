package com.examples.jackson1x;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.TreeMapper;
import org.codehaus.jackson.node.ObjectNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TreeModel {

    public static void main(String[] args) throws IOException {
        readJsonFromFileAndSave();
        constructTree();
    }

    private static void constructTree() {
        TreeMapper treeMapper = new TreeMapper();
        ObjectNode userOb = treeMapper.objectNode();
        ObjectNode nameOb = userOb.putObject("name");
        nameOb.put("first", "Joe");
        nameOb.put("last", "Sixpack");
        userOb.put("gender", User.Gender.MALE.toString());
        userOb.put("verified", false);
        byte[] imageData =  "Rm9vYmFyIQ==".getBytes(); // getImageData() or wherever it comes from
        userOb.put("userImage", imageData);
    }

    private static void readJsonFromFileAndSave() throws IOException {
        ObjectMapper m = new ObjectMapper();
        // can either use mapper.readTree(source), or mapper.readValue(source, JsonNode.class);
        JsonNode rootNode = m.readTree(new FileInputStream(new File("src/main/resources/jackson1x/user.json")));
        // ensure that "last name" isn't "Xmler"; if is, change to "Jsoner"
        JsonNode nameNode = rootNode.path("name");
        String lastName = nameNode.path("last").getTextValue();
        if ("xmler".equalsIgnoreCase(lastName)) {
            ((ObjectNode)nameNode).put("last", "Jsoner");
        }
        // and write it out:
        m.writeValue(new File("src/main/resources/jackson1x/user-modified-tree.json"), rootNode);
    }
}

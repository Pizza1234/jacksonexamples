final ObjectMapper mapper = new ObjectMapper();
MyValue value = new MyValue();
// ... and configure
File newState = new File("my-stuff.json");
// writes JSON serialization of MyValue instance
mapper.writeValue(newState, value);
// or, read
MyValue older = mapper.readValue(new File("my-older-stuff.json"), MyValue.class);

// Or if you prefer JSON Tree representation:
JsonNode root = mapper.readTree(newState);

// and find values by, for example, using a JsonPointer expression:
int age = root.at("/personal/age").getValueAsInt();


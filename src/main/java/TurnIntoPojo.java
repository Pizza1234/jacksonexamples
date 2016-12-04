import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yuriy on 04.12.2016.
 */
public class TurnIntoPojo {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        try {
            User user = mapper.readValue(new File("src/main/resources/user.json"), User.class);
            mapper.writeValue(new File("src/main/resources/user-modified.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

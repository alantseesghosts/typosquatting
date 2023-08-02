import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.json.JSONException;

import org.json.simple.parser.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {
       /*  //System.out.println("Hello, World!");
        JSONParser jsonparse =  new JSONParser();

        JSONObject jsonObject = (JSONObject) jsonparse.parse(new FileReader("src/read.json"));
        
        JSONObject jsonObject2 = (JSONObject) jsonparse.parse(new FileReader("src/solo.json"));

        String id        = (String) jsonObject.get("EmployeeID");
        String firstname = (String) jsonObject.get("FirstName");
        String lastname  = (String) jsonObject.get("LastName");
        String country   = (String) jsonObject.get("Country");

        JSONObject docObject = (JSONObject) jsonObject2.get("doc");
            String name = (String) docObject.get("name");
            String rev = (String) docObject.get("_rev");

            System.out.println("Name: " + name);

            System.out.println("Rev: " + rev);
      /*   String description = jsonObject.getJSONObject("doc")
                .getJSONObject("versions")
                .getJSONObject("0.0.1")
                .getString("description");
       // System.out.println(description);

      /*  System.out.println(id);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(country);
        
*/               String filePath = "data.json";

        try {
            // Read the content of the file
            String jsonString = new String(Files.readAllBytes(Paths.get("src/test.json")));

            // Parse the JSON and extract the description
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject docObject = jsonObject.getJSONObject("value").getJSONObject("doc");
            String description = docObject.getString("description");
            System.out.println("Description: " + description);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    }


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class pract {
    

    public static void add_data(String number) throws Exception{
        try {
        
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test.json")));
        
        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    JSONObject docObject = jsonObject.getJSONObject("doc");
                    String description = docObject.optString("description", "N/A"); // Provide a default value if not found
                    //System.out.println("Description " + (i + 1) + ": " + description);
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "yourname";
        String password = "yourpassword";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

        Statement statement = connection.createStatement();
        String query = "DROP TABLE IF EXISTS example_1; " +
                       "CREATE TABLE example_1(id VARCHAR(400))";
        //statement.execute(query);
       
        // Prepare a statement with parameterized query
        String insertQuery = "INSERT INTO example_1 (id) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        // Insert a number into the "id" column
        String numberToInsert = number;
        preparedStatement.setString(1, numberToInsert);
        preparedStatement.executeUpdate();

        // Close the prepared statement and connection
        preparedStatement.close();

        String selectQuery = "SELECT * FROM example_1";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        // Process the result set and print the data to the terminal
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            //System.out.println("ID: " + id);
        }    
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void add_description(String id,String value) throws Exception{
        try {
        
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test.json")));
        
        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    JSONObject docObject = jsonObject.getJSONObject("doc");
                    String description = docObject.optString("description", "N/A"); // Provide a default value if not found
                    //System.out.println("Description " + (i + 1) + ": " + description);
                }
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "yourname";
        String password = "yourpassword";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

        Statement statement = connection.createStatement();
        
        // Prepare a statement with parameterized query for both "id" and "description"
        String insertQuery = "INSERT INTO example_1 (id, description) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        // Insert data into both "id" and "description" columns
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, value);
        preparedStatement.executeUpdate();

        // Close the prepared statement and connection
        preparedStatement.close();

        statement.close();
        connection.close();
    }


    public static void build_database() throws Exception{

        String jsonString = new String(Files.readAllBytes(Paths.get("src/first_block.json")));
        
        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
        // Get the JSONObject at the current index
        JSONObject jsonObject = jsonArray.getJSONObject(i);

        // Get the "doc" JSONObject from the current object
        JSONObject docObject = jsonObject.getJSONObject("doc");

        //JSONArray versions = docObject.getJSONArray("versions");
        
        // Get the "description" property from the "doc" JSONObject
       // String description = docObject.getString("description");

        // Get the "id" property from the current object
        String id = jsonObject.getString("id");

        add_data(id);

        // Do whatever you want with the description
      //  System.out.println("ID " + (i + 1) + ": " + id );//+ " Description " + (i + 1) + ": " + description);
        }
    }

    public static void build_data() throws Exception{
        String jsonString = new String(Files.readAllBytes(Paths.get("/home/alant/Desktop/npm_dir/json_3.json")));
        
        JSONArray jsonArray = new JSONArray(jsonString);

        for (int i = 0; i < jsonArray.length(); i++) {
        // Get the JSONObject at the current index
        JSONObject jsonObject = jsonArray.getJSONObject(i);

        // Get the "doc" JSONObject from the current object
        JSONObject docObject = jsonObject.getJSONObject("doc");

        //JSONArray versions = docObject.getJSONArray("versions");
        
        // Get the "description" property from the "doc" JSONObject
        String description = docObject.optString("description", "N/A");

        // Get the "id" property from the current object
        String id = jsonObject.getString("id");
        //add_data(id);
        add_description(id,description);
        // Do whatever you want with the description
        //System.out.println("ID " + (i + 1) + ": " + id + " Description " + (i + 1) + ": " + description);
        }
    }


    public static void clear_data() throws Exception{
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "yourname";
        String password = "yourpassword";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

        Statement statement = connection.createStatement();
        String query = "DELETE FROM EXAMPLE_1";
        statement.execute(query);
    }

    public static void show_data() throws Exception{
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "yourname";
        String password = "yourpassword";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

        Statement statement = connection.createStatement();
        String query = "SELECT * FROM EXAMPLE_1";
        statement.execute(query);

        String selectQuery = "SELECT * FROM example_1";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        // Process the result set and print the data to the terminal
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            System.out.println("ID: " + id);
        }    
        resultSet.close();
        statement.close();
        connection.close();
    }

    
    public static void main(String[] args) throws Exception {
         //clear_data();

         //add_data("12");
         //build_data();
         //show_data();
         System.out.println("done");
    }
}
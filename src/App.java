import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        String inputFilePath = "/home/alant/Desktop/packages (copy).json"; // Replace with the actual path to your file
        String outputFilePath = "/home/alant/Desktop/npm_dir/json_4.json"; // Replace with the path where you want to save the new file

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            String line;
            int linesToPrint = 40000; // Set the total number of lines to print (10,000 to 20,000)
            int linesCount = 0;
            int linesStart = 30001; // Set the line number to start printing from (10,000)

            while ((line = reader.readLine()) != null && linesCount < linesToPrint) {
               // System.out.println(line);
                linesCount++;
                if (linesCount >= linesStart) {
                    writer.println(line); // Write each line to the new file if it is within the range
                }
                
            }
            System.out.println("Lines written to the new file: " + (linesCount - linesStart + 1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

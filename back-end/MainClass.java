
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
        // Get the current working directory
        String directoryPath = "F:/My work/word-generation/";

        // Specify the relative path to the data file
        String relativePath = "shakespeare.txt";
        // String relativePath = "words.txt"//

        // Create a File object using the current directory and relative path
        File dataFile = new File(directoryPath, relativePath);

        // Check if the file exists
        if (dataFile.exists()) {
            // Create an instance of StatsObj
            StatsObj statsObj = new StatsObj(5);

            // Read the content of the data file and extract words
            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Split the line into words using space as a delimiter
                    String[] words = line.split("\\s+");

                    // Add each word to StatsObj
                    for (String word : words) {
                        statsObj.add(word);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Test the functionality of StatsObj
            System.out.println("Count of 'shakespeare.txt': " + statsObj.getCountOf(dataFile.getPath()));
            System.out.println("Most frequent item: " + statsObj.getMostFrequent());
            System.out.println("Top most frequent items: " + statsObj.getTopMostFreq());
            System.out.println("Random item: " + statsObj.getRandom());
            System.out.println("StatsObj data: " + statsObj);
        } else {
            System.out.println("Data file not found: " + dataFile.getPath());
        }
    }
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

    public static void main(String[] args) {
      
        String directoryPath = "F:/My work/word-generation/";

     
        String relativePath = "shakespeare.txt";
     
        File dataFile = new File(directoryPath, relativePath);

    
        if (dataFile.exists()) {
           
            StatsObj statsObj = new StatsObj(5);

            
            try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                   
                    String[] words = line.split("\\s+");
                    for (String word : words) {
                        statsObj.add(word);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

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

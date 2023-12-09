
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TextModel {
    private HashMap<String, StatsObj> map;

    public TextModel() {
        map = new HashMap<>();
    }

    private StatsObj getStatsObjForWord(String word) {
        StatsObj b = null;
        if (map.containsKey(word)) {
            b = map.get(word);
        } else {
            b = new StatsObj(3);
            map.put(word, b);
        }

        return b;
    }

   
    public void addWordPair(String word, String followingWord) {
        StatsObj obj;
        if (map.containsKey(word)) {
            obj = map.get(word);
        }

        else {
            obj = new StatsObj(0);
        }
        obj.add(followingWord);
        map.put(word, obj);
    }

    public void loadData(String filename) {
        String text = getFileAsString(filename);
        text = text.replaceAll("\\s+", " ").trim(); 

        String[] words = text.split(" "); // split by space

        for (int i = 0; i < words.length - 1; i++) {
            addWordPair(words[i], words[i + 1]);
        }


    }

    public void loadPairData(String filename) {
        String text = getFileAsString(filename);
        text = text.replaceAll("\\s+", " ").trim(); 

        String[] words = text.split(" "); 

        for (int i = 0; i < words.length - 2; i++) {
            String wordPair = words[i] + " " + words[i + 1];
            /* System.out.println(wordPair) */
            addWordPair(wordPair, words[i + 2]);
        }

    }

    public String simulateNextWord(String word) {
        StatsObj obj = map.get(word);
        return obj.getRandom();
    }

    public String simulate2NextWord(String word) {
        StatsObj obj = map.get(word);
        return word + " " + obj.getRandom();
    }

    public static String getFileAsString(String path) {
        StringBuilder b = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                b.append(line + "\n");
                line = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Something wrong: " + e.getMessage());
        }

        return b.toString();
    }

    public String predictNextWord(String word) {
        StatsObj obj = map.get(word);
        return obj.getMostFrequent();
    }

}

public class Tester {

    private static final int NUM_WORDS_TO_GENERATE = 100;

    public static void main(String[] args) {
        TextModel model = new TextModel(); 
        model.loadPairData("shakespeare.txt"); 

        String generatedOutput = "";

        String currentWord = "From fairest"; 
        generatedOutput += currentWord;

        for (int i = 0; i < NUM_WORDS_TO_GENERATE; i++) {
            String nextWord = (model).simulate2NextWord(currentWord);
            nextWord = nextWord.substring(nextWord.indexOf(" ") + 1, nextWord.length());

           
            
            generatedOutput += " " + nextWord.substring(nextWord.indexOf(" ") + 1, nextWord.length());

            if (i % 8 == 0)
                generatedOutput += "\n"; 
            currentWord = nextWord;
        }

        System.out.println(generatedOutput);
    }
}

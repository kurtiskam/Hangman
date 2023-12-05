import java.util.Random;

public class PickAWord {

    private Random rand = new Random();

    public String getRandomWord(String[] wordList) {
        int upperbound = wordList.length;
        int int_random = rand.nextInt(upperbound);
        return wordList[int_random].toUpperCase();
    }
}

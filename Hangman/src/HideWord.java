import java.util.Arrays;

public class HideWord {

    public char[] hideWord(int wordLength) {
        char[] hiddenWord = new char[wordLength];
        Arrays.fill(hiddenWord, '–');
        return hiddenWord;
    }
}

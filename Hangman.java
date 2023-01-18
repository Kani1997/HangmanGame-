
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String[] words = {"java", "programming", "computer", "science"};
        String word = words[(int)(Math.random() * words.length)];
        String asterisk = new String(new char[word.length()]).replace("\0", "*");
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        while (count < 7 && asterisk.contains("*")) {
            System.out.println("Guess any letter in the word");
            System.out.println(asterisk);
            String guess = scanner.next();
            char guessChar = guess.charAt(0);
            if(word.contains(guess)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guessChar) {
                        asterisk = asterisk.substring(0, i) + guessChar + asterisk.substring(i + 1);
                    }
                }
            } else {
                count++;
                System.out.println("Wrong guess. Number of tries remaining: " + (7 - count));
            }
        }
        if(count<7){
            System.out.println("Congratulations! You have won the game. The word was " + word);
        }else{
            System.out.println("You have lost the game. The word was " + word);
        }
    }
}

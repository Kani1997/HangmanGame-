import java.util.Scanner;

public class MultiplayerHangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, please enter the word to be guessed: ");
        String word = scanner.nextLine();
        String asterisk = new String(new char[word.length()]).replace("\0", "*");
        int count = 0;

        System.out.println("Player 2, start guessing the letters: ");
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
            System.out.println("Player 2, you have won the game. The word was " + word);
        }else{
            System.out.println("Player 2, you have lost the game. The word was " + word);
        }
    }
}



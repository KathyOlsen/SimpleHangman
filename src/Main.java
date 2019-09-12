import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner key = new Scanner(System.in);
        Random r = new Random();
        int random = 0;

        ArrayList<String> words = new ArrayList<>();
        words.add("tree");
        words.add("rain");
        words.add("bear");
        words.add("encourage");
        words.add("promise");
        words.add("soup");
        words.add("chess");
        words.add("insurance");
        words.add("pancakes");
        words.add("stream");

        String hangmanWord = "";
        String guess = "";
        String endGame = "";
        String endPlay = "";
        int sumIncorrect = 0;
        int counter1 = 0;
        int counter2 = 0;

        while(true){
            counter1 = 0;
            counter2 = 0;
            sumIncorrect = 0;
            random = r.nextInt(words.size());
            hangmanWord = words.get(random);
            String[] fullLetters = hangmanWord.split("",hangmanWord.length());
            String[] interimLetters = new String[fullLetters.length];
            for(int i = 0; i <interimLetters.length; i++){
                interimLetters[i] = "_";
            }
            System.out.println("Welcome! Let's play Hangman!\n");
            System.out.print("Here is the word I am thinking of: ");
            for(int i = 0; i < interimLetters.length; i++){
                System.out.print(interimLetters[i] + " ");
            }
            while (!endGame.equals(true)){
                System.out.println("\nEnter your guess (lowercase): ");
                guess = key.next();
                key.nextLine();
                if(guess.equalsIgnoreCase(hangmanWord)){
                    System.out.println("Your've won! The word was " + hangmanWord + ".");
                    break;
                }else{
                    System.out.print("Your guess so far: ");
                    for(int i = 0; i < fullLetters.length; i++){
                        if(guess.equalsIgnoreCase(fullLetters[i]) | interimLetters[i].equalsIgnoreCase(fullLetters[i])){
                            if(guess.equalsIgnoreCase(fullLetters[i])){
                                interimLetters[i] = fullLetters[i];
                                counter1 += 1;
                                counter2 += 1;
                            }else if (interimLetters[i].equalsIgnoreCase(fullLetters[i])) {
                                interimLetters[i] = fullLetters[i];
                            }
                        }
                        System.out.print(interimLetters[i] + " ");
                    }
                    System.out.print("\n");
                    if(counter1 == 0){
                        sumIncorrect += 1;
                        System.out.println("You have answered incorrectly " + sumIncorrect + "/6 times.");
                    }
                    counter1 = 0;
                    if(sumIncorrect == 6){
                        System.out.println("Sorry, you have no more guesses left.  " +
                                "The word was " + hangmanWord + ". \nThank you for playing!\n");
                        endGame = "true";
                        break;
                    }
                    if(counter2 == fullLetters.length) {
                        System.out.println("You've won! The word was " + hangmanWord + ".");
                        endGame = "true";
                        break;
                    }
                }
            }
            words.remove(hangmanWord);
            System.out.println("Do you want to play again? (y/n)");
            endPlay = key.next();
            key.nextLine();
            if (endPlay.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.print("\nEnter a word to guess: ");

        String wordToGuess = input.nextLine();
    }
}

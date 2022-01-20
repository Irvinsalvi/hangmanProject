import java.util.Scanner;

public class App {

    private static String wordToGuess;
    private static String hiddenWord;
    private static int count = 6;

    public static void main(String[] args) throws Exception 
    {
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to Hangman!");
        System.out.print("\nEnter a word to guess: ");

        wordToGuess = input.nextLine();
        wordToGuess = wordToGuess.toLowerCase();

        hiddenWord = new String(new char[wordToGuess.length()]).replace("\0", "_");

        while (count > 0 && hiddenWord.contains("_"))
        {
            System.out.print(hiddenWord.replaceAll("", " ").trim());
            System.out.print("\t(Lives Left: " + count + ")\n");
            System.out.print("\nGuess any letter: ");
            String guess = input.next();
            checkGuess(guess);
        }

        if (count == 0)
        {
            System.out.println("\nToo bad! You ran out of lives! The word was " + wordToGuess.toUpperCase() + ".\n");
        }

        input.close();
    }

    public static void checkGuess(String guess)
    {
        String newWord = "";
        for(int i = 0; i < wordToGuess.length(); i++)
        {
            if (wordToGuess.charAt(i) == guess.charAt(0))
            {
                newWord += guess.charAt(0);
            } 
            else if (hiddenWord.charAt(i) != '_')
            {
                newWord += wordToGuess.charAt(i);
            }
            else
            {
                newWord += "_";
            }
        }

        if (hiddenWord.equals(newWord))
        {
            count--;
        }
        else
        {
            hiddenWord = newWord;
        }

        if (hiddenWord.equals(wordToGuess))
        {
            System.out.println("\nCorrect! You Win! The word was " + wordToGuess.toUpperCase() + "!");
        }
    }
}

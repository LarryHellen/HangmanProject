import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private GameManager manager;
    private String end;
    
    
    public UserInterface(Scanner scanner, GameManager manager){
        this.scanner = scanner;
        this.manager = manager;
    }
    
    public void start(){
        System.out.println();
        intro();
        
        while(true){
        
            System.out.println();
            play();

            if(this.end.equals("win")){
                System.out.print("Congrats! You won. ");
            } else {
                System.out.print("Unfortunately, you lost. ");
            }
            System.out.println("The word was \'" + manager.getWord() + "\'");
            
            System.out.print("Do you want to play again? ");
            String input = scanner.nextLine();
            
            if(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("ye")){
                manager.resetGame();
                continue;
            }
            
            break;
        }
    }
    
    public void intro(){
        System.out.println("Welcome to Hangman. In this game you will have to guess a word one letter at a time.");
        System.out.println("Every time you guess a letter that exists in the chosen word, the place that letter occupies in the word will be revealed.");
        System.out.println("If the letter you guessed does not exist in the chosen word, you get a strike.");
        System.out.println("Once you have " + this.manager.getMaxStrikes() +  " strikes, you lose the game.");
        System.out.println("Conversly, if you are able to guess all the letters in the word before you gain " + this.manager.getMaxStrikes() + " strikes, you win the game.");
    }
    
    public void play(){
        this.end = "continue";
        while(this.end.equals("continue")){
            
            printStats();
            

            System.out.print("What letter do you want to guess? ");
            String letter = this.scanner.nextLine();

            
            if(this.manager.guessLetter(letter)){
                System.out.println("You guessed correctly.");
            } else{
                System.out.println("Your guess was wrong. The word does not contain the letter \'" + letter + "\'");
            }
            
            System.out.println();
            
            this.end = this.manager.endCheck();
        }
    }
    
    public void printStats(){
        System.out.print("The word: ");
        for(String letter : this.manager.getFoundLetters()){
            System.out.print(letter + " ");
        }
        
        if(this.manager.getWrongLetters().size() > 0){ 
            System.out.print("\nIncorrected guesses: ");
            for(String wrong : this.manager.getWrongLetters()){
                System.out.print(wrong + " ");
            }
        }
        
        System.out.println("\nStrikes: " + this.manager.getStrikes());
    }
}


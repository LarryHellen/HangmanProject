import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        FileReader fileReader = new FileReader();
        GameManager manager = new GameManager(fileReader);
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner, manager);
        
        ui.start();
    }
}
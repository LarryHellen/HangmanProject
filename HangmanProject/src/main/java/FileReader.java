import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private ArrayList<String> potentialWords;
    
    public FileReader(){
        this.potentialWords = new ArrayList<>();
    }
    
    public ArrayList<String> getPotentialWords(){
        return this.potentialWords;
    }
    
    
    //For some reason this method returns an indexOutOfBounds error when compiled, but not in IDE
    
    public void readFile(){
        try(Scanner reader = new Scanner(Paths.get("words.txt"))){
            
            while(reader.hasNextLine()){
                String row = reader.nextLine();
                
                this.potentialWords.add(row);
            }
        } catch(Exception e){
            System.out.println("Error test xyz4: " + e.getMessage());
        }
    }
}

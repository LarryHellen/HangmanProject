import java.util.ArrayList;

public class GameManager {
    private FileReader fileReader;
    private String word;
    private String[] foundLetters;
    private ArrayList<String> wrongLetters;
    private int maxStrikes;
    private int strikes;
    
    
    public GameManager(FileReader fileReader){
        this.fileReader = fileReader;
        //this.fileReader.readFile();
        
        this.word = this.generateRandomWord();
        
        this.foundLetters = new String[this.word.length()];
        
        for(int i = 0; i < word.length(); i++){
            this.foundLetters[i] = "_";
        }
        
        this.wrongLetters = new ArrayList<>();
        
        this.maxStrikes = 7;
        this.strikes = 0;
    }
    
    public String getWord(){
        return this.word;
    }
    
    public String[] getFoundLetters(){
        return this.foundLetters;
    }
    
    public ArrayList<String> getWrongLetters(){
        return this.wrongLetters;
    }
    
    public int getMaxStrikes(){
        return this.maxStrikes;
    }
    
    public int getStrikes(){
        return this.strikes;
    }
    
    public boolean guessLetter(String guess){
        if(this.word.contains(guess.toLowerCase())){
            for(int i = 0; i < this.word.length(); i++){
                if(this.word.substring(i, i +1).equals(guess)){
                    this.foundLetters[i] = guess;
                }
            }
            return true;
        }
        this.wrongLetters.add(guess);
        this.strikes++;
        return false;
    }
    
    public String endCheck(){
        String temp = "";
        
        for(String s : this.foundLetters){
            temp = temp + s;
        }
        
        if(temp.equals(this.word)){
            return "win";
        } else if(this.strikes >= this.maxStrikes){
            return "lose";
        }
        return "continue";
    }
    
    public String generateRandomWord(){
        ArrayList<String> temp = new ArrayList<>();
        temp.add("hello");
        temp.add("world");
        temp.add("wreck");
        temp.add("regard");
        temp.add("rule");
        temp.add("amuse");
        temp.add("scary");
        temp.add("emergency");
        temp.add("acquit");
        
        double r = Math.random();
        
        return temp.get((int)(r*temp.size()));
    }
    
    public String generateRandomWordFromFile(ArrayList<String> pool){
        double r = Math.random();
        
        return pool.get((int)(r*pool.size()));
    }
    
    
    public void resetGame(){
        this.word = this.generateRandomWord();
        
        this.foundLetters = new String[this.word.length()];
        
        for(int i = 0; i < word.length(); i++){
            this.foundLetters[i] = "_";
        }
        
        this.wrongLetters.clear();
        
        this.strikes = 0;
    }
}

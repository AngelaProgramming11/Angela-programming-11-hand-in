import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        //copy line from text into arraylist
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine())!= null){
            lines.add(line);
        }
        //search for word
        ArrayList<Integer> temp = searchWord(lines, "code");
        for(int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i));
        }
        br.close();
    }

    //search for word
    public static ArrayList searchWord(ArrayList<String> lines, String word){
        ArrayList<Integer> indexOfWord = new ArrayList<>();
        //loop through each element of arraylist/line of text to compare
        for(int i = 0; i < lines.size(); i++){
            int placeHolder = 0;
            int numOfLetters = 0;
            //loop through each character of a line
            for(int j = 0; j < lines.get(i).length(); j++) {
                if (numOfLetters == word.length()) {
                    //word is found so record index of line in arraylist
                    indexOfWord.add(i);
                    break;
                }
                if (lines.get(i).charAt(j) == word.charAt(placeHolder)) {
                    //characters match so record how many letters are correct
                    placeHolder++;
                    numOfLetters++;
                } else {
                    //characters don't match so go back to the first letter of the word to restart comparing
                    placeHolder = 0;
                    numOfLetters = 0;
                }
            }
        }
        return indexOfWord;
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) throws IOException {
        //copy line from text
        ArrayList<String> lines = new ArrayList<>();
        FileReader fr = new FileReader("ProgrammingHistory.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        //search for word
        ArrayList<Integer> temp = searchWord(lines, "0");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
    }

    //search for word
    public static ArrayList searchWord(ArrayList<String> lines, String word) {
        ArrayList<Integer> indexOfWord = new ArrayList<>();
        //loop through each element of arraylist to compare
        for (int i = 0; i < lines.size(); i++) {
            int placeHolder = 0;
            int numOfLetters = 0;
            Boolean skipToWord = false;
            //loop through each character of a line
            for (int j = 0; j < lines.get(i).length(); j++) {
                //make sure the computer is looking for the individual word and not the combination of letters
                //ex: if the word is "and", the computer has to avoid counting the "and" in "land"
                if (skipToWord == true) {
                    //if the current character is not a space, the computer is still looking for the word inside of a word
                    //so keep skipping characters until it reaches a space/new word
                    if (lines.get(i).charAt(j) == ' ') {
                        skipToWord = false;
                    }
                } else {
                    if (numOfLetters == word.length()) {
                        //word is found so record index of line in arraylist
                        indexOfWord.add(i);
                        break;
                    }
                    if (lines.get(i).charAt(j) == word.charAt(placeHolder)) {
                        //record how many letters are correct
                        placeHolder++;
                        numOfLetters++;
                    } else {
                        //go back to the first letter of the word to restart comparing
                        placeHolder = 0;
                        numOfLetters = 0;
                        skipToWord = true;
                    }
                }
            }
        }
        return indexOfWord;
    }
}
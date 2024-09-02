import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

class FileManager {

    ArrayList<String> readAllWordFromFile(String fileName){
        ArrayList<String> data = new ArrayList<String>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }        
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return data;
    }
    
    void writeCorrectWord(String fileName, String userInput){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName, true))) {
            writter.write(userInput+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }

    void writeWordWithIndexForResume(ArrayList<Word> boardWordList, String fileName){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(fileName))) {
            for(int i=0;i<boardWordList.size();i++){
                writter.write(boardWordList.get(i).word+"|"+boardWordList.get(i).X+"|"+boardWordList.get(i).Y+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
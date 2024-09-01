import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

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
}
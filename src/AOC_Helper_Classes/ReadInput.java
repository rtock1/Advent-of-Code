package AOC_Helper_Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadInput {
    public static String getString(String path){
        String data = new String();
        try {
            File file = new File("src/"+path.replace('.','/') + "/puzzleInput.txt");
            Scanner reader = new Scanner(file);
            while(reader.hasNextLine()){
                data += reader.nextLine() + "\n";
            }
            data = data.substring(0,data.length()-1);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return data;
    }
}

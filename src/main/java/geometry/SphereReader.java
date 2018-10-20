package geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SphereReader {

    public List<String> readLines(String filePath){
        List<String> lines = new ArrayList<String>();
        try( BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String tempLine = reader.readLine();
            while(tempLine!=null){
                lines.add(tempLine);
                tempLine=reader.readLine();
            }
        }catch (IOException e) {

        }
        return  lines;
    }
}
package geometry;

import exceptions.FileReadingException;
import exceptions.InputFileNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SphereReader {

    public List<String> readLines(String filePath) throws InputFileNotFoundException, FileReadingException {
        List<String> lines = new ArrayList<>();
        try( BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String tempLine = reader.readLine();
            while(tempLine!=null){
                lines.add(tempLine);
                tempLine=reader.readLine();
            }
        }catch (FileNotFoundException e) {
            throw new InputFileNotFoundException("File not found",filePath);
        }catch (IOException e){
            throw new FileReadingException(e.getMessage(),e);
        }
        return  lines;
    }
}
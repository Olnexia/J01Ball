package geometry;

import exceptions.FileReadingException;
import exceptions.InputFileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

public class SphereReader {
    private static Logger logger = Logger.getLogger(SphereReader.class.getName());

    public List<String> readLines(String filePath) throws InputFileNotFoundException, FileReadingException {
        List<String> lines = new ArrayList<>();
        try( BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String tempLine = reader.readLine();
            while(tempLine!=null){
                lines.add(tempLine);
                logger.info(tempLine +" was read from file");
                tempLine=reader.readLine();
            }
        }catch (FileNotFoundException e) {
            logger.error("An exception occurred while searching for the file",e);
            throw new InputFileNotFoundException("File not found",filePath);
        }catch (IOException e){
            logger.error("An exception occurred while reading the file",e);
            throw new FileReadingException(e.getMessage(),e);
        }
        return  lines;
    }
}
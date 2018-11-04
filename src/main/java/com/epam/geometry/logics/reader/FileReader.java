package com.epam.geometry.logics.reader;

import com.epam.geometry.exceptions.FileReadingException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    public List<String> readLines(String filePath) throws FileReadingException {
        List<String> lines = new ArrayList<>();
        try( BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))){
            String tempLine = reader.readLine();
            while(tempLine!=null){
                lines.add(tempLine);
                logger.info(tempLine +" was read from file");
                tempLine=reader.readLine();
            }
        }catch (IOException e){
            logger.error("An exception occurred while reading the file",e);
            throw new FileReadingException(e.getMessage(),filePath,e);
        }
        return  lines;
    }
}
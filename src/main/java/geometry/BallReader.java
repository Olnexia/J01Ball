package geometry;

import java.io.*;
import java.util.ArrayList;

public class BallReader {

    public ArrayList<String> readBalls(String filePath){
        File file = new File(filePath);
        FileInputStream fileStream = null;
        ArrayList<String> validLines=null;
        BufferedReader reader;
        try{
            fileStream = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fileStream));

            BallValidator validator=new BallValidator();
            String tempLine = reader.readLine();
            validLines=new ArrayList<String>();
            while(tempLine!=null){
                if(validator.validateBall(tempLine)) {
                    validLines.add(tempLine);
                }
                tempLine = reader.readLine();
            }
        }catch (IOException e){

        }finally {
            try{
                if(fileStream!=null){
                    fileStream.close();
                }
            } catch (IOException e){

            }
        }
        return (validLines.isEmpty()) ? null : validLines;
    }
}
package geometry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//TODO Change logics: validator as a param

public class  BallReader {

    public List<String> readBalls(String filePath){
        File file = new File(filePath);
        FileInputStream fileStream = null;
        List<String> lines = new ArrayList<String>();
        BufferedReader reader;
        try{
            fileStream = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fileStream));

            String tempLine = reader.readLine();
            while(tempLine!=null){
                lines.add(tempLine);
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
        return  lines;
    }
}
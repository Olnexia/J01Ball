package geometry;

import java.util.ArrayList;
import java.util.List;

public class BallParser {

    public List<Double[]> parseBalls(List<String> lines){
        List<Double> balls= new ArrayList<Double>();
        for(String line:lines){
            String[] lineArray = line.split("\\s+");
            double radius = Double.parseDouble(lineArray[0]);
            double xCoordinate = Double.parseDouble(lineArray[1]);
            double yCoordinate = Double.parseDouble(lineArray[2]);
            double zCoordinate = Double.parseDouble(lineArray[3]);
            //Improve
        }
        return balls;
    }

}

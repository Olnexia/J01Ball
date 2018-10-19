package geometry;

import java.util.ArrayList;

public class BallParser {

    public ArrayList<Ball> parseBalls(ArrayList<String> lines){
        ArrayList<Ball> balls= new ArrayList<Ball>();
        for(String line:lines){
            String[] lineArray = line.split("\\s+");
            double radius = Double.parseDouble(lineArray[0]);
            double xCoordinate = Double.parseDouble(lineArray[1]);
            double yCoordinate = Double.parseDouble(lineArray[2]);
            double zCoordinate = Double.parseDouble(lineArray[3]);
            balls.add(new Ball(radius,xCoordinate,yCoordinate,zCoordinate));
        }
        return balls;
    }

}

package geometry;

import java.util.ArrayList;
import java.util.List;

public class SphereParser {

    public List<Double> parseSpheres(List<String> lines){
        List<Double> spheres = new ArrayList<Double>();
        for(String line:lines){
            String[] lineArray = line.split("\\s+");
            spheres.add(Double.parseDouble(lineArray[0]));
            spheres.add(Double.parseDouble(lineArray[1]));
            spheres.add(Double.parseDouble(lineArray[2]));
            spheres.add(Double.parseDouble(lineArray[3]));
        }
        return spheres;
    }

}

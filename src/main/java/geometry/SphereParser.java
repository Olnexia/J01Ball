package geometry;

import java.util.ArrayList;
import java.util.List;

public class SphereParser {

    public List<double[]> parseSpheres(List<String> lines, Validator<String> validator){
        List<double[]> validSphereData = new ArrayList<>();
        for(String line:lines){
            double[] sphereData = parseSphere(line,validator);
            if(sphereData!=null){
                validSphereData.add(sphereData);
            }
        }
        return validSphereData;
    }

    private double[] parseSphere(String line,Validator validator){
        double[] validSphereData=null;
        if(validator.validate(line)){
            validSphereData = new double[3];
            String[] lineArray = line.split("\\s+");
            for( int i=0;i<3;i++){
                validSphereData[i]=Double.parseDouble(lineArray[i]);
            }
        } else{
            //logging
        }
        return validSphereData;
    }
}

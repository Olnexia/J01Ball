package geometry;

import exceptions.ParseSphereException;

import java.util.ArrayList;
import java.util.List;

public class SphereParser {

    public List<double[]> parseSpheres(List<String> lines, Validator<String> validator){
        List<double[]> validSphereData = new ArrayList<>();
        for(String line:lines){
            try {
                double[] sphereData = parseSphere(line, validator);
                validSphereData.add(sphereData);
            }
            catch (ParseSphereException e){

            }
        }
        return validSphereData;
    }

    public double[] parseSphere(String line,Validator<String> validator) throws ParseSphereException {
        if (!validator.validate(line)) {
            throw new ParseSphereException("Line can't be parsed to sphere data",line);
        }

        double[] validSphereData = new double[4];
        String[] lineArray = line.split("\\s+");
        for (int i = 0; i < 3; i++) {
            validSphereData[i] = Double.parseDouble(lineArray[i]);
        }
        return validSphereData;
    }
}

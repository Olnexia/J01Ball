package geometry;

import exceptions.SphereParsingException;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class SphereParser {
    private static Logger logger = Logger.getLogger(SphereParser.class.getName());
    public List<double[]> parseSpheres(List<String> lines, Validator<String> validator){
        List<double[]> validSphereData = new ArrayList<>();
        for(String line:lines){
            try {
                double[] sphereData = parseSphere(line, validator);
                validSphereData.add(sphereData);
            }
            catch (SphereParsingException e){
                logger.warn("An exception occurred while parsing the line",e);
            }
        }
        return validSphereData;
    }

    public double[] parseSphere(String line,Validator<String> validator) throws SphereParsingException {
        if (!validator.validate(line)) {
            throw new SphereParsingException("Line can't be parsed to sphere data",line);
        }

        double[] validSphereData = new double[4];
        String[] lineArray = line.split("\\s+");
        for (int i = 0; i < 4; i++) {
            validSphereData[i] = Double.parseDouble(lineArray[i]);
        }
        logger.info(line + " parsed to sphere data as doubles");
        return validSphereData;
    }
}

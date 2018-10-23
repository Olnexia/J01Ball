package geometry;

import exceptions.SphereParsingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SphereParser {
    private static Logger logger = LogManager.getLogger(SphereParser.class);

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

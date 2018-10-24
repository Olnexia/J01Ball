package com.epam.task1.geometry;

import com.epam.task1.exceptions.SphereParsingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SphereParser {
    private static String LINE_SPLITER = "\\s+";
    private static int PARAM_AMOUNT = 4;
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
        double[] validSphereData = new double[PARAM_AMOUNT];
        String[] lineArray = line.split(LINE_SPLITER);
        for (int i = 0; i < PARAM_AMOUNT; i++) {
            validSphereData[i] = Double.parseDouble(lineArray[i]);
        }
        logger.info(line + " parsed to sphere data as doubles");
        return validSphereData;
    }
}

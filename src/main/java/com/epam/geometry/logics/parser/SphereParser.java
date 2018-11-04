package com.epam.geometry.logics.parser;

import com.epam.geometry.exceptions.SphereParsingException;
import java.util.ArrayList;
import java.util.List;
import com.epam.geometry.logics.validator.Validator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SphereParser {
    private static final String LINE_SEPARATOR = "\\s+";
    private static final int PARAM_AMOUNT = 4;
    private static final Logger logger = LogManager.getLogger(SphereParser.class);
    private Validator<String> validator;

    public SphereParser(Validator<String> validator){
        this.validator = validator;
    }

    public List<double[]> parseSpheres(List<String> lines){
        List<double[]> validSphereData = new ArrayList<>();
        for(String line:lines){
            try {
                double[] sphereData = parseSphere(line);
                validSphereData.add(sphereData);
            } catch (SphereParsingException e){
                logger.warn("An exception occurred while parsing the line" + line);
            }
        }
        return validSphereData;
    }

    public double[] parseSphere(String line) throws SphereParsingException {
        if (!validator.validate(line)) {
            throw new SphereParsingException("Line can't be parsed to sphere data",line);
        }
        double[] validSphereData = new double[PARAM_AMOUNT];
        String[] lineArray = line.split(LINE_SEPARATOR);
        for (int i = 0; i < PARAM_AMOUNT; i++) {
            validSphereData[i] = Double.parseDouble(lineArray[i]);
        }
        logger.info(line + " parsed to sphere data as doubles");
        return validSphereData;
    }
}

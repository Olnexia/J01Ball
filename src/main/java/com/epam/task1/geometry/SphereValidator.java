package com.epam.task1.geometry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SphereValidator implements Validator<String>
{
    private static final String SPHERE_PATTERN="^[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]";
    private static Logger logger = LogManager.getLogger(SphereValidator.class);
    private Pattern pattern;
    private Matcher matcher;

    public boolean validate(final String sphereLine){
        pattern=Pattern.compile(SPHERE_PATTERN);
        matcher = pattern.matcher(sphereLine);
        boolean isValid = matcher.matches();
        if (isValid) {
            logger.info(sphereLine+ " is valid");
        } else{
            logger.warn(sphereLine+ " is not valid");
        }
        return isValid;
    }
}

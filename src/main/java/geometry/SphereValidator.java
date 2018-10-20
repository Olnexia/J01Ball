package geometry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SphereValidator implements Validator<Double>
{
    private Pattern pattern;
    private Matcher matcher;
    private static final String BALL_PATTERN="^[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]";

    @Override
    public boolean validate(final String ballLine){
        pattern=Pattern.compile(BALL_PATTERN);
        matcher = pattern.matcher(ballLine);
        return matcher.matches();
    }

}

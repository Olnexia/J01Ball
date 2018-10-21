package geometry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SphereValidator implements Validator<String>
{
    private static final String SPHERE_PATTERN="^[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]\\s+\\-?[0-9]\\.[0-9]";
    private Pattern pattern;
    private Matcher matcher;

    public boolean validate(final String sphereLine){
        pattern=Pattern.compile(SPHERE_PATTERN);
        matcher = pattern.matcher(sphereLine);
        return matcher.matches();
    }
}

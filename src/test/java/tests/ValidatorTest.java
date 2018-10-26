package tests;

import static org.junit.Assert.*;
import com.epam.task1.logics.validator.SphereValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class ValidatorTest {
    private static final SphereValidator validator = new SphereValidator();

    @DataProvider
    public static Object[][] dataValidatorAdd() {
        return new Object[][] {
                { "1.0 2.0 3.0 4.0",true },
                { "-2.0 4.5 5.0 2.0",false },
                { "2.0 1.5 -5.2 2.1",true },
                { "2.0 4.5z 2.0 2.0",false },
                { "2.0 3.5 7.0",false }
        };
    }

    @Test
    @UseDataProvider("dataValidatorAdd")
    public void testAdd(String line, boolean expected) {
        //given

        //when
        boolean result = validator.validate(line);
        //then
        assertEquals(expected, result);
    }
}

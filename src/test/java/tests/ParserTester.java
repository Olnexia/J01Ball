package tests;

import entity.Sphere;
import geometry.*;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class ParserTester {
    private final static SphereParser PARSER = new SphereParser();
    private final static SphereValidator VALIDATOR = new SphereValidator();

//    @Test
//    public void ShouldReturnTestSphereDataWhenInputIsTestStr(){
//        //given
//        String expectedStringData = "4.0 3.0 5.0 2.0";
//        Sphere expectedSphere = new Sphere(4,3,5,2);
//        try {
//            //when
//            Sphere actualSphere = PARSER.parseSphere(expectedStringData,);
//            //then
//            assertArrayEquals(TEST_STR_ARRAY, res.toArray());
//        } catch (Exception e) {
//            fail();
//        }
//    }
}

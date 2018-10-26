package tests;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import com.epam.task1.exceptions.SphereCreatingException;
import com.epam.task1.logics.creator.SphereCreator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CreatorTest {
    private static final SphereCreator creator = new SphereCreator();
    private static final Sphere EXPECTED_SPHERE = new Sphere(4.0,new Point(3.0,5.0,-2.0));
    private static final List <Sphere> EXPECTED_LIST = new ArrayList <>();
    static {
        EXPECTED_LIST.add(new Sphere(1.0,new Point( 2.0, 3.0, 4.0)));
        EXPECTED_LIST.add(new Sphere(5.2,new Point( 2.1, 2.0, 2.2)));
        EXPECTED_LIST.add(new Sphere(4.0,new Point( 6.1, 4.0, 4.0)));
        EXPECTED_LIST.add(new Sphere(5.0,new Point( 6.0, 2.0, 4.0)));
    }

    @Test
    public void shouldReturnExpectedSphereWhenInputIsExpectedSphereData() throws SphereCreatingException {
        //given
        double[] expectedSphereData = new double[]{4.0, 3.0, 5.0, -2.0};
        //when
        Sphere actualSphere = creator.createSphere(expectedSphereData);
        //then
        assertEquals(EXPECTED_SPHERE, actualSphere);
    }

    @Test(expected = SphereCreatingException.class)
    public void shouldThrowSphereCreatingExceptionWhenNegativeRadius() throws SphereCreatingException{
        //given
        double[] expectedSphereData = new double[]{-4.0, 3.0, 5.0, -2.0};
        //when
        creator.createSphere(expectedSphereData);
        //then
    }

    @Test
    public void ShouldReturnExpectedSphereListWhenInputIsExpectedSphereDataList() {
        //given
        List <double[]> expectedSphereDataList = new ArrayList <>();
        expectedSphereDataList.add(new double[]{1.0, 2.0, 3.0, 4.0});
        expectedSphereDataList.add(new double[]{5.2, 2.1, 2.0, 2.2});
        expectedSphereDataList.add(new double[]{4.0, 6.1, 4.0, 4.0});
        expectedSphereDataList.add(new double[]{5.0, 6.0, 2.0, 4.0});
        //when
        List<Sphere> actualSphereList = creator.createSpheres(expectedSphereDataList);
        //then
        assertEquals(EXPECTED_LIST,actualSphereList);
        }
}

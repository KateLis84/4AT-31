package itstep_aqa.unit;

import day_2.Calc;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest {
@Test
    void firstTest(){
    Assert.assertEquals(Calc.devide(8, 4), 2d, "Dividing failed");
}

}

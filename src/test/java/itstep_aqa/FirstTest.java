package itstep_aqa;

import org.testng.Assert;
import org.testng.annotations.Test;
import day_2.Calc;
public class FirstTest {
@Test
    void firstTest(){
    Assert.assertEquals(Calc.devide(8, 4), 2d, "Dividing failed");
}

}

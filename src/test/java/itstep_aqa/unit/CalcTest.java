package itstep_aqa.unit;

import day_2.Calc;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

public class CalcTest {
    @Test
    void divideTest(){
        Assert.assertEquals(Calc.devide(8,4),new Double(2d)," Dividing failed");
    }


    @Test(dataProvider = "addingDataProvider")
    void addTest(Double a,Double b,Double expectedResult){
        Assert.assertEquals(Calc.add(a,b),expectedResult, " Adding failed");
    }

    @DataProvider
    public static Object[][] addingDataProvider() {
        Object[][] res = new Object[4][3];
        res[0][0] = 4.0;
        res[0][1] = 5.0;
        res[0][2] = 9.0;

        res[1][0] = 2.0;
        res[1][1] = 0.0;
        res[1][2] = 2.0;

        res[2][0] = 60.0;
        res[2][1] = 7.0;
        res[2][2] = 67.0;

        res[3][0] = -34.0;
        res[3][1] = 8.0;
        res[3][2] = -26.0;
        return res;
    }
}

package org.calculation;

import org.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculationTest extends BaseTest {

    @DataProvider(name = "numData")
    public Object[][] getUserData () {
        String num_1 = "1";
        String num_2 = "2";
        String expectedNum_1 = "3";
        return new Object[][] {{num_1, num_2, expectedNum_1}};
    }

    @Test(groups = "calculation", dataProvider = "numData")
    void sumTwoNumbersTest (String num_1, String num_2, String expectedResult) {
        String actualResult;

        actualResult = homePage.sumTwoNumbers(num_1, num_2).numFind();

        Assert.assertEquals(actualResult, expectedResult);
    }
}

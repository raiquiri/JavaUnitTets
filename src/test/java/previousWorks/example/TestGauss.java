package previousWorks.example;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import previousWorks.example.Gauss;

import static previousWorks.example.Gauss.methodGauss;

public class TestGauss {


    @Test(groups = "slau")
    void testGauss() throws Exception {
        // Arange - создание окружения
        final double[][] array = new double[][] {{3,2,-5}, {2,-1,3}, {1,2,-1}};
        final double[] vector = new double[] {-1,13,9};
        double[] expectedResult = new double[] {3,5,4};
        double[] actualResult;
        final double DELTA = 1e-2;

        // Act - действие
        actualResult = methodGauss(array,vector);

        // Assert
        SoftAssert softAssert = new SoftAssert();
        for(int i = 0; i < expectedResult.length; i++) {
            softAssert.assertEquals(actualResult[i], expectedResult[i], DELTA);
        }
    }
    @Test(groups = "slau", expectedExceptions = {Gauss.MatrixException.class},
            expectedExceptionsMessageRegExp = "Система имеет множество решений")
    void testGaussException() throws Exception {
        // Arange - создание окружения
        final double[][] array = new double[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        final double[] vector = new double[] {1,2,3};
        double[] actualResult;
        final double DELTA = 1e-2;

        // Act - действие
        actualResult = methodGauss(array,vector);
    }
}

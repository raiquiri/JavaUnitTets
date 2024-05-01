package previousWorks.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static previousWorks.example.Sort.*;

public class TestSort {
    @Test (groups = "positive")
    void testSortShakerInt() {
        // Arange - создание окружения
        final int[] array = new int[] {4,5,1,2,3,9,7,10,8,6};
        int[] expectedResult = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] actualResult;

        // Act - действие
        actualResult = sortShaker(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @DataProvider(name = "arrays")
    public Object[][] getArrays() {
        double[] array1 = new double[] {4.51,5.32,1.86,2.12,3.43,9.55,7.14,10.22,8.1,6.15};
        double[] expectedResult1 = new double[] {1.86,2.12,3.43,4.51,5.32,6.15,7.14,8.1,9.55,10.22};
        double[] array2 = new double[] {4.51,5.32,1.86,4.51,3.43,4.51,6.15};
        double[] expectedResult2 = new double[] {1.86,3.43,4.51,4.51,4.51,5.32,6.15};
        return new Object[][] {{array1, expectedResult1}, {array2, expectedResult2}};
    }

    @Test (groups = "positive", dataProvider = "arrays")
    void testSortShakerDouble(double[] array, double[] expectedResult) {
        // Arange - создание окружения
        double[] actualResult;
        final double DELTA = 1e-2;
        // Act - действие
        actualResult = sortShaker(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult, DELTA);
    }
    @Test (groups = "negative")
    void testNegativeSortShakerInt() {
        // Arange - создание окружения
        final int[] array = new int[] {4,5,1,2,3,9,7,10,8,6};
        int[] expectedResult = new int[] {1,2,3,4,5,6,7,9,8,10};
        int[] actualResult;

        // Act - действие
        actualResult = sortShaker(array);

        // Assert
        Assert.assertNotEquals(actualResult, expectedResult);
    }
    @Test (groups = "negative")
    void testNegativeSortShakerDouble() {
        // Arange - создание окружения
        final double[] array = new double[] {4.51,5.32,1.86,2.12,3.43,9.55,7.14,10.22,8.1,6.15};
        double[] expectedResult = new double[] {1.86,2.12,3.43,4.51,6.15,5.32,7.14,8.1,9.55,10.22};
        double[] actualResult;

        // Act - действие
        actualResult = sortShaker(array);

        // Assert
        Assert.assertNotEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    void testSortInsertInt() {
        // Arange - создание окружения
        final int[] array = new int[] {4,5,1,2,3,9,7,10,8,6};
        int[] expectedResult = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] actualResult;

        // Act - действие
        actualResult = sortInsert(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    void testSortInsertDouble() {
        // Arange - создание окружения
        final double[] array = new double[] {4.51,5.32,1.86,2.12,3.43,9.55,7.14,10.22,8.1,6.15};
        double[] expectedResult = new double[] {1.86,2.12,3.43,4.51,5.32,6.15,7.14,8.1,9.55,10.22};
        double[] actualResult;

        // Act - действие
        actualResult = sortInsert(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "negative")
    void testNegativeSortInsertInt() {
        // Arange - создание окружения
        final int[] array = new int[] {4,5,1,2,3,9,7,10,8,6};
        int[] expectedResult = new int[] {1,2,3,4,5,6,8,7,9,10};
        int[] actualResult;

        // Act - действие
        actualResult = sortInsert(array);

        // Assert
        Assert.assertNotEquals(actualResult, expectedResult);
    }

    @Test (groups = "negative")
    void testNegativeSortInsertDouble() {
        // Arange - создание окружения
        final double[] array = new double[] {4.51,5.32,1.86,2.12,3.43,9.55,7.14,10.22,8.1,6.15};
        double[] expectedResult = new double[] {1.86,2.12,3.43,4.51,6.15,5.32,7.14,8.1,9.55,10.22};
        double[] actualResult;

        // Act - действие
        actualResult = sortInsert(array);

        // Assert
        Assert.assertNotEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    void testSortCombInt() {
        // Arange - создание окружения
        final int[] array = new int[] {4,5,1,2,3,9,7,10,8,6};
        int[] expectedResult = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] actualResult;

        // Act - действие
        actualResult = sortComb(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    void testSortCombDouble() {
        // Arange - создание окружения
        final double[] array = new double[] {4.51,5.32,1.86,2.12,3.43,9.55,7.14,10.22,8.1,6.15};
        double[] expectedResult = new double[] {1.86,2.12,3.43,4.51,5.32,6.15,7.14,8.1,9.55,10.22};
        double[] actualResult;

        // Act - действие
        actualResult = sortComb(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    void testSortChooseInt() {
        // Arange - создание окружения
        final int[] array = new int[] {4,5,1,2,3,9,7,10,8,6};
        int[] expectedResult = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] actualResult;

        // Act - действие
        actualResult = sortChoose(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test (groups = "positive")
    void testSortChooseDouble() {
        // Arange - создание окружения
        final double[] array = new double[] {4.51,5.32,1.86,2.12,3.43,9.55,7.14,10.22,8.1,6.15};
        double[] expectedResult = new double[] {1.86,2.12,3.43,4.51,5.32,6.15,7.14,8.1,9.55,10.22};
        double[] actualResult;

        // Act - действие
        actualResult = sortChoose(array);

        // Assert
        Assert.assertEquals(actualResult, expectedResult);
    }
}

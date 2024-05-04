package org.parseText;

import org.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParseTextTest extends BaseTest {

    @Test (groups = "parse")
     void menuParseTest() {
        String expectedResult = "Почта\nнет непрочитанных писем" +
                "\nНаписать письмо\nДиск\nПодключить Плюс" +
                "\nМузыка, фильмы, кешбэк баллами\nМои отзывы" +
                "\nИзбранное\nВнешний вид";
        String actualResult;

        actualResult = homePage.menuParse();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = "parse")
    void licenseParseTest() {
        String expectedResult = "Правовые документы";
        String actualResult;

        actualResult = homePage.licenseParse();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = "parse")
    void supportParseTest() {
        String expectedResult = "Обратная связь";
        String actualResult;

        actualResult = homePage.supportParse();

        Assert.assertEquals(actualResult, expectedResult);
    }
}

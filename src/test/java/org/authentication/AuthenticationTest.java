package org.authentication;

import org.baseTest.BaseTest;
import org.common.CommonAction;
import org.openqa.selenium.WebDriver;
import org.pages.basePage.BasePage;
import org.pages.homePage.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {


    @DataProvider(name = "userData")
    public Object[][] getUserData () {
        String userName_1 = "testUser010501";
        String password_1 = "QqbnomkingFf0!01";
        return new Object[][] {{userName_1, password_1}};
    }

    @Test (groups = "authentication", dataProvider = "userData")
    void singInPositive(String userName, String password) throws HomePage.AuthenticationException {
        String actualResult;
        String expectedResult = userName;

        actualResult = homePage.loginValidUser(userName, password).profileName();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = "authentication", dataProvider = "userData")
    void exitPositive(String username, String password) throws HomePage.AuthenticationException {
        String actualResult;
        String expectedResult = "Войти";

        actualResult = homePage
                .loginValidUser(username, password)
                .exit()
                .exitCheck();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (groups = "authentication", dataProvider = "userData",
            expectedExceptions = {HomePage.AuthenticationException.class})
    void singInLoginNegative (String userName, String password) throws HomePage.AuthenticationException {
        String invalidLogin = userName.replace("t", "y");
        homePage.loginValidUser(invalidLogin, password);
    }

    @Test (groups = "authentication", dataProvider = "userData",
            expectedExceptions = {HomePage.AuthenticationException.class})
    void singInPasswordNegative (String userName, String password) throws HomePage.AuthenticationException {
        String unvalidPassword = password.replace("Q", "W");
        homePage.loginValidUser(userName, unvalidPassword);
    }

    @Test (groups = "authentication",
            expectedExceptions = {HomePage.AuthenticationException.class})
    void exitNegative () throws HomePage.AuthenticationException {
        homePage.exit();
    }
}

package org.authentication;

import org.baseTest.BaseTest;
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
    void singInTest (String userName, String password) {
        String actualResult;
        String expectedResult = userName;

        actualResult = homePage.loginValidUser(userName, password).profileName();

        Assert.assertEquals(actualResult, expectedResult);
    }
}

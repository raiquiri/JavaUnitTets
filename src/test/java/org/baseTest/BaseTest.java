package org.baseTest;

import org.common.CommonAction;
import org.openqa.selenium.WebDriver;
import org.pages.basePage.BasePage;
import org.pages.homePage.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static org.common.Config.CLEAR_COOKIES;
import static org.common.Config.CLOSE_BROWSER;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);

    @BeforeTest
    public void openMainPage () {
        basePage.open("https://ya.ru");
    }

    @AfterTest (alwaysRun = true)
    public void clearCookies () {
        if (CLEAR_COOKIES){
            driver.manage().deleteAllCookies();
        }
    }

    @AfterSuite (alwaysRun = true)
    public void close() {
        if (CLOSE_BROWSER) {
            driver.quit();
        }
    }
}

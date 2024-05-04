package org.baseTest;

import org.common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.pages.basePage.BasePage;
import org.pages.homePage.HomePage;
import org.testng.annotations.*;

import static org.common.Config.*;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp () {
        driver = CommonAction.createDriver();
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);

        basePage.open(URL);
    }

    public void openMainPage () {
        basePage.open(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies () {
        if (CLEAR_COOKIES){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterMethod (alwaysRun = true)
    public void close() {
        if (CLOSE_BROWSER) {
            driver.quit();
        }
    }
}

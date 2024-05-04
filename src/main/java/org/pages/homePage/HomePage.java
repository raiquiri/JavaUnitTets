package org.pages.homePage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.basePage.BasePage;

import static org.constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));

    /*
    * Open Authentication class
    */
    private final By closeButtonBy = By.xpath("/html/body/div[19]/button");
    private final By loginButtonBy = By.xpath("//a[@class='home-link2 headline__personal-enter home-link2_color_black']");
    private final By userNameBy = By.xpath("//*[@id=\"passp-field-login\"]");
    private final By userButtonBy = By.xpath("//*[@id=\"passp:sign-in\"]");
    private final By passwordBy = By.xpath("//*[@id=\"passp-field-passwd\"]");
    private final By singInBy = By.xpath("//*[@id=\"passp:sign-in\"]");

    public HomePage loginValidUser(String userName, String password) throws AuthenticationException {
        closeDownloadWindow();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonBy)).click();
        driver.findElement(userNameBy).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userButtonBy)).click();
        loginError();
        driver.findElement(passwordBy).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(singInBy)).click();
        passwordError();


        return new HomePage(driver);
    }

    private final By profileButtonBy = By.xpath("//a[@class='home-link2 headline__personal-avatar avatar avatar_size_adaptive avatar_hover_yes']");
    private final By profileNameBy = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/span[2]");

    public String profileName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButtonBy)).click();
        changeFrame();
        return driver.findElement(profileNameBy).getAttribute("innerText");
    }

    private final By loginErrorBy = By.xpath("//*[@id=\"field:input-login:hint\"]");

    private HomePage loginError() throws AuthenticationException {
        try {
            if (wait.until(ExpectedConditions.presenceOfElementLocated(loginErrorBy)).isDisplayed()) {
                throw new AuthenticationException("Не правильный логин");
            }
        } catch (TimeoutException e) {

        }

        return new HomePage(driver);
    }

    private final By passwordErrorBy = By.xpath("//div[@id='field:input-passwd:hint']");

    private HomePage passwordError() throws AuthenticationException {
        try {
            if (wait.until(ExpectedConditions.presenceOfElementLocated(passwordErrorBy)).isDisplayed()) {
                throw new AuthenticationException("Неверный пароль");
            }
        } catch (TimeoutException e) {

        }

        return new HomePage(driver);
    }

    private final By exitButtonBy = By.xpath("//a[@data-testid='logout']");

    public HomePage exit() throws AuthenticationException {
        closeDownloadWindow();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(profileButtonBy)).click();
            changeFrame();
            wait.until(ExpectedConditions.visibilityOfElementLocated(exitButtonBy)).click();
        } catch (TimeoutException e){
            throw new AuthenticationException("Вы не можете выйти, вы не вошли в аккуант");
        }

        return new HomePage(driver);
    }

    public String exitCheck() {
        return driver.findElement(loginButtonBy).getAttribute("innerText");
    }

    private HomePage closeDownloadWindow () {
        try {
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(closeButtonBy)).isDisplayed()){
                driver.findElement(closeButtonBy).click();
            }
        } catch (TimeoutException e) {

        }

        return new HomePage(driver);
    }
    private final By iFrameBy = By.xpath("//iframe[@class='usermenu-portal__iframe']");

    private HomePage changeFrame() {
        driver.switchTo().frame(driver.findElement(iFrameBy));
        return new HomePage(driver);
    }
    /*
    * Close Authentication class
    */

    /*
     * Open ParseText class
     */
    private final By menuButtonBy = By.xpath("//*[@viewBox='0 0 40 40']");
    private final By listMenuBy = By.xpath("//div[@class='List Menu']");

    public String menuParse () {
        closeDownloadWindow();
        driver.findElement(menuButtonBy).click();
        changeFrame();

        List<WebElement> content = driver.findElements(listMenuBy);

        return content.get(0).getAttribute("innerText") + "\n"
                + content.get(1).getAttribute("innerText");
    }

    private final By licenseButtonBy = By.xpath("//a[@data-testid='legal-rules']");
    private final By documentsNameBy = By.xpath("//span[@class='b-header__title']");

    public String licenseParse () {
        closeDownloadWindow();
        driver.findElement(menuButtonBy).click();
        changeFrame();
        wait.until(ExpectedConditions.visibilityOfElementLocated(licenseButtonBy)).click();

        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles) {
            driver.switchTo().window(handle);
        }

        return driver.findElement(documentsNameBy).getAttribute("innerText");
    }

    private final By supportButtonBy = By.xpath("//a[@data-testid='report-violation']");

    public String supportParse () {
        closeDownloadWindow();
        driver.findElement(menuButtonBy).click();
        changeFrame();
        wait.until(ExpectedConditions.visibilityOfElementLocated(supportButtonBy)).click();

        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles) {
            driver.switchTo().window(handle);
        }

        return driver.findElement(documentsNameBy).getAttribute("innerText");
    }

    /*
     * Close ParseText class
     */

    public static class AuthenticationException extends Exception {
        public AuthenticationException(String message) {
            super(message);
        }
    }
}

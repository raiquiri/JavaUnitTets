package org.pages.homePage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.basePage.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /*
    * Open Authentication class
    */
    private By closeButtonBy = By.xpath("/html/body/div[19]/button");
    private By loginButtonBy = By.xpath("//a[@class='home-link2 headline__personal-enter home-link2_color_black']");
    private By userNameBy = By.xpath("//*[@id=\"passp-field-login\"]");
    private By userButtonBy = By.xpath("//*[@id=\"passp:sign-in\"]");
    private By passwordBy = By.xpath("//*[@id=\"passp-field-passwd\"]");
    private By singInBy = By.xpath("//*[@id=\"passp:sign-in\"]");
    private By defButtonBy = By.xpath("//button[@data-t='button:pseudo']");

    public HomePage loginValidUser(String userName, String password) {
        clickButton(closeButtonBy);
        clickButton(loginButtonBy);
        driver.findElement(userNameBy).sendKeys(userName);
        clickButton(userButtonBy);
        driver.findElement(passwordBy).sendKeys(password);
        clickButton(singInBy);


        return new HomePage(driver);
    }

    private By profileLinkBy = By.xpath("//a[@class='home-link2 headline__personal-avatar avatar avatar_size_adaptive avatar_hover_yes']");
    private By profileNameBy = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/span[2]");

    public String profileName(){
        clickButton(profileLinkBy);
        return driver.findElement(profileNameBy).getAttribute("innerText");
    }
    /*
    * Close Authentication class
    */

    /*
     * Open Calculation class
     */
    private By inputStringBy = By.xpath("//*[@id=\"input\"]");
    private By enterButtonBy = By.xpath("//*[@id=\"BtnCalc\"]");

    public HomePage sumTwoNumbers(String num_1, String num_2) {
        WebElement inputString = driver.findElement(inputStringBy);
        clickButton(inputString);
        inputString.clear();
        inputString.sendKeys(num_1);
        inputString.sendKeys("+");
        inputString.sendKeys(num_2);
        clickButton(enterButtonBy);

        return new HomePage(driver);
    }

    public HomePage subTwoNumbers(String num_1, String num_2) {
        WebElement inputString = driver.findElement(inputStringBy);
        clickButton(inputString);
        inputString.clear();
        inputString.sendKeys(num_1);
        inputString.sendKeys("-");
        inputString.sendKeys(num_2);
        clickButton(enterButtonBy);

        return new HomePage(driver);
    }

    public HomePage mulTwoNumbers(String num_1, String num_2) {
        WebElement inputString = driver.findElement(inputStringBy);
        clickButton(inputString);
        inputString.clear();
        inputString.sendKeys(num_1);
        inputString.sendKeys("*");
        inputString.sendKeys(num_2);
        clickButton(enterButtonBy);

        return new HomePage(driver);
    }

    public HomePage divTwoNumbers(String num_1, String num_2) {
        WebElement inputString = driver.findElement(inputStringBy);
        clickButton(inputString);
        inputString.clear();
        inputString.sendKeys(num_1);
        inputString.sendKeys("/");
        inputString.sendKeys(num_2);
        clickButton(enterButtonBy);

        return new HomePage(driver);
    }

    public String numFind () {
        return driver.findElement(inputStringBy).getText();
    }
    /*
     * Close Calculation class
     */

    /*
     * Open ParseText class
     */
    private By nameBy = By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/h1");
    private By contentBy = By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/p");
    private By helpListBy = By.xpath("//*[@id=\"menuhelp\"]/ul/*");

    public String parseName() {
        return driver.findElement(nameBy).getText();
    }

    public String parseContent() {
        return driver.findElement(contentBy).getText();
    }

    public String[] parseHelpList() {
        List<WebElement> helpList = driver.findElements(helpListBy);
        String[] strings = new String[helpList.size()];

        for(int i = 0; i < helpList.size(); i++) {
            strings[i] = helpList.get(i).getText();
        }
        return strings;
    }
    /*
     * Close ParseText class
     */

    public HomePage clickButton(By buttonBy) {
        WebElement button = driver.findElement(buttonBy);
        waitElementIsVisible(button).click();

        return this;
    }
    public HomePage clickButton(WebElement button) {
        waitElementIsVisible(button).click();

        return this;
    }
}

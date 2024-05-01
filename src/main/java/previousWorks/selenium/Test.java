package previousWorks.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pages.homePage.HomePage;

import java.time.Duration;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // иницилизация драйвера + неявное ожидание
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // открытие страницы
        driver.get("https://ya.ru/");

        By closeButtonBy = By.xpath("/html/body/div[19]/button");
        By loginButtonBy = By.xpath("//a[@class='home-link2 headline__personal-enter home-link2_color_black']");
        By userNameBy = By.xpath("//*[@id=\"passp-field-login\"]");
        By userButtonBy = By.xpath("//*[@id=\"passp:sign-in\"]");
        By passwordBy = By.xpath("//*[@id=\"passp-field-passwd\"]");
        By singInBy = By.xpath("//*[@id=\"passp:sign-in\"]");
        By defButtonBy = By.xpath("//button[@data-t='button:pseudo']");

        String user = "testUser010501";
        String password = "QqbnomkingFf0!01";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButtonBy)).click();
        driver.findElement(loginButtonBy).click();
        driver.findElement(userNameBy).sendKeys(user);
        driver.findElement(userButtonBy).click();
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(singInBy).click();

        By profileLinkBy = By.xpath("//a[@class='home-link2 headline__personal-avatar avatar avatar_size_adaptive avatar_hover_yes']");
        By profileNameBy = By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[2]/span[2]");

        driver.findElement(profileLinkBy).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//img[@class='UserPic-Image']")).click();
        //System.out.println(driver.findElement(profileNameBy).getAttribute("innerText"));
        /*System.out.println("start");
        driver.findElement(By.xpath("//div[@style='margin-bottom: -10px;']")).click();
        WebElement inputString = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameBy));
        inputString.click();
        inputString.sendKeys("");
        inputString.sendKeys(userName);
        driver.findElement(userButtonBy).click();
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(singInBy).click();*/

        // закрытие
        /*driver.quit();*/
    }
}

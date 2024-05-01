package previousWorks.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class YandexMenuExample {
    public static void main(String[] args) throws InterruptedException {
        // Указываем путь к драйверу Chrome (замените путь на свой)

        // Создаем экземпляр драйвера Chrome
        WebDriver driver = new EdgeDriver();

        // Открываем страницу ya.ru
        driver.get("https://ya.ru");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        By closeButtonBy = By.xpath("/html/body/div[19]/button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButtonBy)).click();

        // Находим кнопку меню по классу или другому селектору
        WebElement menuButton = driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/div"));

        // Кликаем по кнопке, чтобы открыть меню
        menuButton.click();

        Thread.sleep(2000);
        // Находим варианты в dropdown меню по классу или другому селектору
        List<WebElement> menuOptions = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div/div"));

        // Выводим информацию о каждом варианте меню
        for (WebElement option : menuOptions) {
            System.out.println(option.getAttribute("children"));
        }

        // Закрываем браузер
        //driver.quit();
    }
}
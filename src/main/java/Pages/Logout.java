package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {
    private final WebDriver driver;

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public static String getMessageModalText() {
        WebElement message = WebDriver.findElement(By.xpath("//*[@id=\"toast-container\"]/div"));
        WebDriverWait wait = new WebDriverWait(this.WebDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }

    public void clickBackButton() {
        driver.navigate().back();
    }
}
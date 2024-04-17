package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg'l*)
            private WebElement logoutButton;

    public Logout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public String getMessageModalText() {
        WebElement message = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div"));
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();

    public void clickBackButton() {
        this.driver.navigate().back();
    }
}
}
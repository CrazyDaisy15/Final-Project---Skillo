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

    @FindBy(xpath = "//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg']")
    private WebElement logoutButton;

    private final WebDriverWait wait;

    public Logout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickLogoutBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public String getMessageModalText() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div")));
        return message.getText();
    }
}
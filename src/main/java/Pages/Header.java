package Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    private final WebDriver webDriver;
    public Header(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }
    @FindBy(id = "nav-link-login")
    private WebElement loginLink;
    @FindBy(id = "nav-link-profile")
    private WebElement profilePageLink;

    public void clickLogin() {
        this.loginLink.click();
    }

    public void clickProfile() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(this.profilePageLink));
        this.profilePageLink.click();
    }
}
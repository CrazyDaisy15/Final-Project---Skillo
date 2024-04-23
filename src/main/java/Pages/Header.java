package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    private final WebDriver webDriver;
    public Header(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }
    @FindBy(id = "nav-link-login")
    private WebElement loginLink;

    public void clickLogin() {
        this.loginLink.click();
    }
}
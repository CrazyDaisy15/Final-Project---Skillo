package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FollowUser1 {
    public static String PAGE_URL = "http://training.skillo-bg.com:4200/posts/all";
    private WebDriver webDriver;

    @FindBy(class = "btn btn-primary ng-star-inserted")
    private WebElement followButton;

    public FollowUser1(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);

        public void clickFollow(){
            WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(followButton));
            followButton.click();

        }
    }
}
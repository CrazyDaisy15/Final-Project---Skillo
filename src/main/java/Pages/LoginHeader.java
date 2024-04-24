package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginHeader {
    private final WebDriver webDriver;
    public LoginHeader(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }
    private WebDriverWait wait;
    @FindBy(id = "profileLink")
    private WebElement profileLink;
    @FindBy(xpath = "logoutButton")
    private WebElement logoutButton;
    @FindBy(id = "homeButton")
    private WebElement homeButton;
    @FindBy(id = "NewPostButton")
    private WebElement newPostButton;

    public void clickHome() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
    }

    public void clickLogoutButton() {
        WebElement logoutButton = this.webDriver.findElement(By.xpath("//*[@id=\"navbarColor01\"]/ul[2]/li/a/i"));
        logoutButton.click();
    }

    public void clickNewPost() {
         WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
         WebElement postLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-new-post")));
         postLink.click();
    }
    public void clickCreatePost() {
         WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-create-post")));
         WebElement createPost = this.webDriver.findElement(By.id("nav-link-create-post"));
         createPost.click();
    }
}
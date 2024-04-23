package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfterLogin {
    private final WebDriver webDriver;
    public AfterLogin(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(className = "app-post-modal")
    private WebElement modalDialog;

    @FindBy(className = "like")
    private WebElement likeButton;

    @FindBy(className = "fa-thumbs-down")
    private WebElement dislikeButton;

    @FindBy(className = "ng-star-inserted")
    private WebElement followUserBtn;

    @FindBy(className = "btn-primary")
    private WebElement unfollowUserBtn;

    public void waitForDialogToAppear() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(modalDialog));
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clickLikeButton() {
        likeButton.click();
    }

    public void clickDislikeButton() {
        dislikeButton.click();
    }

    public void clickFollowUserBtn() {
        followUserBtn.click();

    }
    public void clickUnfollowUserBtn() {
        unfollowUserBtn.click();
    }

    public boolean isPostLiked() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(likeButton));
        return true;
    }
    public boolean isPostDisliked() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(dislikeButton));
        return true;
    }
    public boolean isUserFollowed() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(followUserBtn));
        return true;
    }
    public boolean isUserUnfollowed() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(unfollowUserBtn));
        return true;
    }
}
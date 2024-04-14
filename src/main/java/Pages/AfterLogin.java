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

    @FindBy(css = ".container-flud .post-profile-img .post-user")
    WebElement usernameLink;

    @FindBy(tagName = "app-post-modal")
    WebElement modalDialog;

    @FindBy(class = "far fa-heart fa-2x")
    WebElement likeButton;

    @FindBy(class = "ml-4 far fa-thumbs-down fa-2x")
    WebElement dislikeButton;


    public AfterLogin(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void waitForDialogToAppear() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(modalDialog));
    }

    public void clickLikeButton() {
        clickElement(likeButton);
    }

    public void clickDislikeButton() {
        clickElement(dislikeButton);
    }

    public void clickUsernameLink() {
        clickElement(usernameLink);
    }
}

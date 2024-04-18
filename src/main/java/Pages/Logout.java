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

   @FindBy(xpath = "//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg']")
           private WebElement logoutButton;

   private final WebDriverWait wait;

    public Logout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
       // WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        //WebElement logoutButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement
        //        (By.xpath("//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg']"))));
       // logoutButton.click();

    public String getMessageModalText() {
      //  WebElement message = this.driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div"));
      //  WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"toast-container\"]/div")));
        return message.getText();

     //   public void clickBackBrowserButton() {
     //   driver.navigate().back();
     //   }
}
}
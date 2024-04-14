package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Search {

    private final WebDriver webDriver;
    @FindBy(id = "search-bar")
    WebElement searchField;

    @FindBy(xpath = "//*[contains(text(), 'CrazyDaizy15')]")
    List<WebElement> searchResults;

    public Search(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }
    public void goToSearchField() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).click();
    }
    public void searchUser(String username) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(username);
    }
    public void waitForUserInDropdown() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
    }
    public void clickOnUser(int index) {
        WebElement user = searchResults.get(index);
        user.click();
    }
}
package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;
import java.time.Duration;

public class UserLogout {
    private WebDriver driver;
    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
    }

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Downloads/chrome-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4200/posts/all");
        PageFactory.initElements(driver, this);
    }

    @FindBy
    private WebElement logoutButton;

    @Test(dataProvider = "getUser")
    public void testUserLogout(String username, String password, String userId) {

        //Open homepage
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        //Login with existing user
        Header header = new Header(driver);
        header.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isUrlLoaded();
        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        loginPage.clickSignIn();
        WebElement logoutButton = driver.findElement(By.xpath( "//*[@class='nav-link']//*[@class='fas fa-sign-out-alt fa-lg']"));
                   logoutButton.click();

        //Check if the user is logged out
        boolean isUserLoggedOut = logoutButton.isSelected();
        Assert.assertTrue(isUserLoggedOut, "The user is logged out.");
    }
}
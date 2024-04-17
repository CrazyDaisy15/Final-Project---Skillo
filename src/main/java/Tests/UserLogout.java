package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        this.driver.get("http://training.skillo-bg.com:4200/posts/all");
    }

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
    }

    @Test(dataProvider = "getUser")
    public void testUserLogout(String username, String password, String userId) {
        //Initialize pages
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);
        Logout logout = new Logout(driver);

        //Open homepage
        homePage.navigateTo();

        // Login with existing user
        header.clickLogin();
        loginPage.isUrlLoaded();
        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        loginPage.clickSignIn();
        // boolean isUserLoggedIn = HomePage.isUrlLoaded();
        Assert.assertTrue(homePage.isUrlLoaded(), "The user is NOT logged in."); {
        }

        logout.clickLogoutButton();

        // Check if the user is logged out
        // boolean isUserLoggedOut = LoginPage.isUrlLoaded();
        Assert.assertTrue(loginPage.isUrlLoaded(), "The user is NOT logged out.");
        String logoutMessageText = logout.getMessageModalText();
        Assert.assertEquals(logoutMessageText, "Successful logout!");
    }
}
package Tests;

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

    @FindBy(className = "fas fa-sign-out-alt fa-lg")
    private WebElement logoutButton;

    @Test(dataProvider = "getUser")
    public void testUnfollowingSpecificUser(String username, String password, String userId) {

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

//        homePage.verifyUrl();
//
//        boolean isSignInTextPresent = loginPage.checkSignInTextIsDisplayed();
//        Assert.assertTrue(isSignInTextPresent, "The Sign In text is not visible");
//
//        boolean isProfileSectionPresent = Header.checkProfileSectionIsVisible();
//        Assert.assertTrue(isProfileSectionPresent, "Profile Section is not visible");
//
//        LoginHeader.clickTheLogoutButton();
//
//        public void clickLogout() {
//            logoutButton.click();
//            Assert.assertTrue(isUserLoggedOut(), "Successful logout!");
//        }
//
//        private boolean isUserLoggedOut() {
//            boolean isLoginButtonPresent = Header.verifyTheLogInButtonIsVisible();
//            Assert.assertTrue(isLoginButtonPresent, "Login button is not visible");
//        }
    }
}
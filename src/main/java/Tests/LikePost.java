package Tests;

import Pages.Header;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;

import java.time.Duration;

public class LikePost extends Main {
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

    @Test(dataProvider = "getUser")
    public void testLikePost(String username, String password, String userId) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        //login with existing user
        Header header = new Header(driver);
        header.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isUrlLoaded();
        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        loginPage.clickSignIn();

        //Click on random post
        homePage.clickRandomPost();
        AfterLogin afterLogin = new AfterLogin(driver);
        AfterLogin.waitForDialogToAppear();

        // Check if the button to like the post is visible
        boolean isButtonVisible = homePage.checkIfLikeButtonIsVisible();
        Assert.assertTrue(isButtonVisible, "The button is not displayed");

        //Like the post
        afterLogin.clickLikeButton();

        //Verify that button name changed
        afterLogin.verifyButtonNameChanged();

        //Check if the pop-up confirmation has appeared
        Assert.assertTrue(driver.findElement(By.id("toast-container")).isDisplayed(), "Confirmation does not appear.");
    }
}
package Tests;

import Pages.Header;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class UserLogin extends Main {

    private final WebDriver webDriver;

    public UserLogin(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
    }

    @Test(dataProvider = "getUser")
    public void testFollowUser(String username, String password, String userId) {

        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateTo();
        Assert.assertTrue(homePage.isUrlLoaded(), "Home page is not loaded");

        header.clickLogin();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page is not Login");

        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);

        loginPage.checkRememberMe();
        Assert.assertTrue(loginPage.isSelected(), "Remember me checkbox is not checked.");

        loginPage.checkRememberMe();
        Assert.assertTrue(homePage.isUrlLoaded(),"Home page is not loaded!");

        header.clickProfile();
        Assert.assertTrue(loginPage.isUrlLoaded(), "Current page in not profile page for " + userId + " user");

    }
}
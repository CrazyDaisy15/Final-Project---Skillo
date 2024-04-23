package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;

public class UserLogout extends Main {

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
    }

    @Test(dataProvider = "getUser")
    public void testUserLogout(String username, String password, String userId) {
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        Logout logout = new Logout(webDriver);

        homePage.navigateTo();

        header.clickLogin();
        loginPage.isUrlLoaded();
        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        loginPage.clickSignIn();

        Assert.assertTrue(homePage.isUrlLoaded(), "The user is NOT logged in."); {
        }
        logout.clickLogoutBtn();

        Assert.assertTrue(loginPage.isUrlLoaded(), "The user is NOT logged out.");
        String logoutMessageText = logout.getMessageModalText();
        Assert.assertEquals(logoutMessageText, "Successful logout!");
    }
}
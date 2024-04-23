package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;

public class UnfollowUser extends Main {
    private WebDriver driver;

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
    }

    @Test(dataProvider = "getUser")
    public void testUnfollowUser(String username, String password, String userId) {

        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);
        AfterLogin afterLogin = new AfterLogin(driver);

        homePage.navigateTo();

        header.clickLogin();
        loginPage.isUrlLoaded();
        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        loginPage.clickSignIn();

        Assert.assertTrue(afterLogin.isUserUnfollowed(), "The user is unfollowed.");
        afterLogin.clickUnfollowUserBtn();
    }

    public boolean unfollowUser(WebElement unFollowedUserBtn) {
        String buttonText = unFollowedUserBtn.getText();
        if (buttonText.equals("Follow")) {
            return false;
        } else if (buttonText.equals("Unfollow")) {
            unFollowedUserBtn.click();
            return true;
        } else {
            return false;
        }
    }
}
package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;

public class FollowUser extends Main {
    private WebDriver driver;

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
    }

    @Test(dataProvider = "getUser")
    public void testFollowUser(String username, String password, String userId) {

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

        Assert.assertTrue(afterLogin.isUserFollowed(), "The user is followed.");
        afterLogin.clickFollowUserBtn();
    }

    public boolean followUser(WebElement followUserBtn) {
        String buttonText = followUserBtn.getText();
        if (buttonText.equals("Follow")) {
            followUserBtn.click(); // Follow the user
            return true;
        } else if (buttonText.equals("Unfollow")) {
            System.out.println("The user is not followed!");
            return false;
        } else {
            return false;
        }
    }
}
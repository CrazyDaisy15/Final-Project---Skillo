package Tests;

import Pages.AfterLogin;
import Pages.Header;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LikePost extends Main {
    //private WebDriver driver;

    @DataProvider(name = "getUser")
    public Object[][] getUser() {
        return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
    }

    @Test(dataProvider = "getUser")
    public void testLikePost(String username, String password, String userId) {

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

        Assert.assertTrue(afterLogin.isPostLiked(), "The post is liked.");
        afterLogin.clickLikeButton();
    }

    public boolean likedPost(WebElement likeButton) {
        String initialClassName = likeButton.getAttribute("class");
        likeButton.click();
        String updatedClassName = likeButton.getAttribute("class");
        return updatedClassName.contains("liked");
    }
}
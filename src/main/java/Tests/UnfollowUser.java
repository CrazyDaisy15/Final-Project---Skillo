package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;
import java.time.Duration;

public class UnfollowUser extends Main {
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

    //    @FindBy(xpath = "/html/body/app-root/div[2]/app-all-posts/div/div/div[1]/app-post-detail/div/app-small-user-profile/div/div[2]/button")
    //    private WebElement followedUser;
    @Test(dataProvider = "getUser")
    public void testUnfollowingUser(String username, String password, String userId) {
        setUpTest();

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
        WebElement unFollowedUserBtn = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-all-posts/div/div/div[1]/app-post-detail/div/app-small-user-profile/div/div[2]/button"));

        // Check if the user is already followed
        boolean isUserUnfollowed = unFollowedUser(unFollowedUserBtn);
        Assert.assertTrue(isUserUnfollowed, "The user is unfollowed.");
    }
    public boolean unFollowedUser(WebElement unFollowedUserBtn) {
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
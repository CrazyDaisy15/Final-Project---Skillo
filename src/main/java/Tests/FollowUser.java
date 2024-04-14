package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;
import java.time.Duration;

public class FollowUser extends Main {
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
    public void testFollowingCount(String username, String password, String userId) {
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
        WebElement followedUserBtn = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-all-posts/div/div/div[1]/app-post-detail/div/app-small-user-profile/div/div[2]/button"));

        //Check if the user is already followed
        boolean isUserFollowed = followedUser(followedUserBtn);
        Assert.assertTrue(isUserFollowed, "The user is followed.");
    }
    public boolean followedUser(WebElement followedUserBtn) {
        String buttonText = followedUserBtn.getText();
        if (buttonText.equals("Follow")) {
            followedUserBtn.click(); // Follow the user
            return true;
        } else if (buttonText.equals("Unfollow")) {
            System.out.println("The user is not followed!");
            return false;
        } else {
            return false;
        }
    }
}
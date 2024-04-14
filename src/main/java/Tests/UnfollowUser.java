package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        //Go to profile page
        LoginHeader.goToProfile();


        //Get number of current followers
        ProfilePage profilePage = new ProfilePage(driver);
        int currentFollowingCount = profilePage.getFollowingCount();

        //Go to search field
        Search search = new Search(driver);
        search.goToSearchField();

        //ind specific person and unfollow him/her - the user will be "Rumi"
        ProfilePage userProfilePage = new ProfilePage(driver);
        search.searchUser("Rumi");
        search.waitForUserInDropdown();
        search.clickOnUser(0);
        userProfilePage.clickUnfollowButton();

        // Check if the button to Unfollow is visible
        boolean isButtonVisible = homePage.checkIfUnfollowButtonIsVisible();
        Assert.assertTrue(isButtonVisible, "The button is not displayed");

        //Go to profile and verify that following number is decreased
        LoginHeader.goToProfile();
        profilePage.waitForFollowingCountDecrease(currentFollowingCount);

        int newFollowersCount = profilePage.getFollowingCount();
        Assert.assertEquals(newFollowersCount, currentFollowingCount - 1, "Following number is not decreased.");
    }
}
package Tests;

import Pages.Header;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
            this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            this.driver.get("http://training.skillo-bg.com:4200/posts/all");
        }
        @DataProvider(name = "getUser")
        public Object[][] getUser() {
            return new Object[][]{{"CrazyDaisy15", "CrazyDaisy15", "5689"}};
        }

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
            WebElement likedPostBtn = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-all-posts/div/div/div[1]/app-post-detail/div/div[2]/div/div[1]/i[1]"));

            // Check if the post has been already liked
            boolean isPostLiked = likedPost(likedPostBtn);
            Assert.assertTrue(isPostLiked, "The post is liked.");
        }
        public boolean likedPost (WebElement likedPostBtn){
            String initialClassName = likedPostBtn.getAttribute("class");
            likedPostBtn.click();
            String updatedClassName = likedPostBtn.getAttribute("class");
            return updatedClassName.contains("liked");
        }
    }
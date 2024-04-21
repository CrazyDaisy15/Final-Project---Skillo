package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.*;
import java.time.Duration;

public class DislikePost extends Main {
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
    public void testDislikePost(String username, String password, String userId) {

        //Open homepage
        HomePage homePage = new HomePage(driver);
        Header header = new Header(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.navigateTo();

        //Login with existing user
        Header Header = new Header(driver);
        header.clickLogin();
        LoginPage LoginPage = new LoginPage(driver);
        loginPage.isUrlLoaded();
        loginPage.fillInUserName(username);
        loginPage.fillInPassword(password);
        loginPage.checkRememberMe();
        loginPage.clickSignIn();
        WebElement dislikedPostBtn = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-all-posts/div/div/div[1]/app-post-detail/div/div[2]/div/div[1]/i[2]"));

        // Check if the post has been already disliked
        boolean isPostDisliked = dislikedPost(dislikedPostBtn);
        Assert.assertTrue(isPostDisliked, "The post is disliked.");
    }
    public boolean dislikedPost(WebElement dislikedPostBtn) {
        String initialClassName = dislikedPostBtn.getAttribute("class");
        dislikedPostBtn.click();
        String updatedClassName = dislikedPostBtn.getAttribute("class");
        return updatedClassName.contains("liked");
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        this.driver.close();
    }
}
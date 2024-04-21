package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class UserLogin {

    private WebDriver driver;

    @BeforeMethod
    protected final void setUpTest() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        this.driver.get("http://training.skillo-bg.com:4200/posts/all");
    }

    @Test
    public void loginTest(){
        String homeURL = "http://training.skillo-bg.com:4200/posts/all";
        this.driver.get(homeURL);

        String currentURL = this.driver.getCurrentUrl();
        Assert.assertEquals(currentURL,homeURL);

        WebElement loginLink = this.driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        String loginURL = "http://training.skillo-bg.com:4200/users/login";
        String loginCurrentURL = this.driver.getCurrentUrl();
        Assert.assertEquals(loginCurrentURL,loginURL);

        WebElement usernameTextField = this.driver.findElement(By.id("defaultLoginFormUsername"));
        usernameTextField.sendKeys("CrazyDaisy15");

        WebElement passwordTestField = this.driver.findElement(By.xpath("//form/input[@id='defaultLoginFormPassword']"));
        passwordTestField.sendKeys("CrazyDaisy15");

        WebElement rememberMeCheckbox = this.driver.findElement(By.xpath("//*[@class='remember-me']/input[@type='checkbox']"));
        rememberMeCheckbox.click();
        Assert.assertTrue(rememberMeCheckbox.isSelected());

        WebElement signInButton = this.driver.findElement(By.id("sign-in-button"));
        Assert.assertTrue(signInButton.isEnabled(), "The Sign In Button is disabled");
        signInButton.click();

        WebElement profilePageLink = this.driver.findElement(By.id("nav-link-profile"));
        profilePageLink.click();

        Assert.assertEquals(this.driver.getCurrentUrl(),"http://training.skillo-bg.com:4200/users/5689");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        this.driver.close();
    }
}
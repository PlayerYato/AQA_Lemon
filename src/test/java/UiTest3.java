import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.time.Duration;

public class UiTest3 {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    ProfilePage profilePage;

    @BeforeTest
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://zoolandia.com.ua/ua/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
            public void myTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.loginButton();
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.rememberButton();
        loginPage.submitButton();
        profilePage.entryCabinet();
        Assert.assertEquals(driver.getCurrentUrl(), "https://zoolandia.com.ua/ua/account.php");
        }

        @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}


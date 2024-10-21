import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BuyPage;
import pages.MainPage;
import pages.ShopPage;

import java.time.Duration;

@Listeners({AllureTestNg.class})

public class UiTest1 {

    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    ShopPage shopPage;
    BuyPage buyPage;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://zoolandia.com.ua/ua/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
        shopPage = new ShopPage(driver);
        buyPage = new BuyPage(driver);

    }

    @Test
    public void UiTest1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage.selectLocation();
        shopPage.selectionCategory();
        shopPage.selectionProduct();
        buyPage.buyButton();
        buyPage.addToCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://zoolandia.com.ua/ua/checkout");

    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}

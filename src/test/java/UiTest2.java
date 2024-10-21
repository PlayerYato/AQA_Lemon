import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CheaperPage;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;


public class UiTest2 {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    ProductPage productPage;
    CheaperPage cheaperPage;

    @BeforeTest
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://zoolandia.com.ua/ua/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cheaperPage = new CheaperPage(driver);
    }

    @Test
    public void Test(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage.searchCategory();
        homePage.buttonSearch();
        productPage.productSelection();
        cheaperPage.chaeperClick();
        cheaperPage.nameInput();
        cheaperPage.phoneInput();
        cheaperPage.productLink();
        cheaperPage.commentInput();
        cheaperPage.cheaperProductSubmit();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fancybox-slide fancybox-slide--html fancybox-slide--current fancybox-slide--complete']")));
        WebElement text = driver.findElement(By.xpath("//div[@class='fancybox-slide fancybox-slide--html fancybox-slide--current fancybox-slide--complete']"));
        Assert.assertEquals(text.getText(), "Ваша заявка успішно відправлена!");
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}



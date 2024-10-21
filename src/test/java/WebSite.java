import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebSite {

    WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/validation/input-validation.html");
    }

    @Test
    public void myTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement input1 = driver.findElement(By.xpath("//input[@id='firstname']"));
        input1.sendKeys("fdsawrtyhgd");

        WebElement input2 = driver.findElement(By.xpath("//input[@id='surname']"));
        input2.sendKeys("asdfghjklzx");

        WebElement input3 = driver.findElement(By.xpath("//input[@id='age']"));
        input3.sendKeys("19");

        WebElement dropdownElement = driver.findElement(By.id("country"));

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Ukraine");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        wait.until(ExpectedConditions.urlToBe("https://testpages.eviltester.com/validate/input-validation"));

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://testpages.eviltester.com/validate/input-validation")) {
            System.out.println("Тест пройден: Переход на страницу результата успешен.");
        } else {
            System.out.println("Тест не пройден: Переход на страницу результата не удался.");
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}



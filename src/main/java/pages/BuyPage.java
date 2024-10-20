package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BuyPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
}
    @FindBy(xpath = "//button[@class='product__button']")
    WebElement submitButton1;

    @FindBy(xpath = "//a[@class='dropdown-menu__order-link']")
    WebElement link2;

    public void buyButton(){
        submitButton1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-menu__order-link']")));
    }

    public void addToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(link2));
        link2.click();

    }
}
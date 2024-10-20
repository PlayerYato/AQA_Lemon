package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='live-search']")
    WebElement inputSearch;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement buttonSubmit1;

    public void searchCategory(){
        inputSearch.sendKeys("Переноски");
    }

    public void buttonSearch(){
        buttonSubmit1.click();
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {
    private WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@src='/images/suhoy_korm_logo_2.webp']")
    WebElement productLink1;

    @FindBy(xpath = "//img[@alt='Royal Canin (Роял Канін) Sterilised 37 - Сухий корм для кастрованих котів та стерилізованих котів']")
    WebElement productLink2;

    public void selectionCategory(){
        productLink1.click();

        }

    public void selectionProduct(){
        productLink2.click();
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='navigation__link navigation__link--enter']")
    WebElement button1;

    @FindBy(xpath = "//input[@name='data[email]']")
    WebElement input1;

    @FindBy(xpath = "//input[@name='data[password]']")
    WebElement input2;

    @FindBy(xpath = "//input[@name='remember']")
    WebElement button2;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement button3;

    public void loginButton(){
        button1.click();
    }

    public  void enterEmail(){
        input1.sendKeys("KovalDenis1105@gmail.com");
    }

    public void enterPassword(){
        input2.sendKeys("1Q2w3e4r5t");
    }

    public void rememberButton(){
        button2.click();
    }

    public void submitButton(){
        button3.click();
    }
}

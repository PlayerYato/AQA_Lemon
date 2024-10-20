package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheaperPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheaperPage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='966']")
    WebElement buttonSubmit2;

    @FindBy(xpath = "//input[@name='name']")
    WebElement input1;

    @FindBy(xpath = "//input[@id='modal_phone']")
    WebElement input2;

    @FindBy(xpath = "//input[@name='link']")
    WebElement input3;

    @FindBy(xpath = "//input[@name='comment']")
    WebElement input4;

    @FindBy(xpath = "//button[@id='cheaperProductSubmit']")
    WebElement buttonSubmit3;

    public void chaeperClick(){
        buttonSubmit2.click();
    }

    public void nameInput(){
        input1.sendKeys("Денис");
    }

    public void phoneInput(){
        input2.sendKeys("+38 (000) 000 00 00");
    }

    public void productLink(){
        input3.sendKeys("https://prom.ua/p2250949612-kontejner-perenoska-stefanplast.html?utm_source=google_pmax&utm_medium=cpc&utm_content=pmax&utm_campaign=Pmax_cpa_50_zootovary&gad_source=1&gclid=CjwKCAjw1NK4BhAwEiwAVUHPUHBwUh4ktQWKaZhdfJSngcK5yUHJobQeSg3QXH0NWMiyxSiqJLJ16BoC_VoQAvD_BwE");
    }
    public void commentInput(){
        input4.sendKeys("знайшов дешевше");
    }

    public void cheaperProductSubmit(){
        buttonSubmit3.click();
    }

}

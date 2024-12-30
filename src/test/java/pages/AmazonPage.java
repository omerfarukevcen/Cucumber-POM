package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox") // Amazon arama kutusu
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"sp-cc-accept\"]") // Arama sonuçları
    public WebElement cookies;

    @FindBy(xpath = "//*[@id=\"search\"]/span/div[2]/h1/div/div[1]/div/h2/span[3]") // Arama sonuçları
    public WebElement searchResults;

    @FindBy(xpath = "//*[@id=\"a-autoid-4-announce\"]") // Arama sonuçları
    public WebElement sepeteEkle;


    @FindBy(xpath = "//*[@id=\"sc-active-items-header\"]") // Arama sonuçları
    public WebElement sepetiOnayla;



}

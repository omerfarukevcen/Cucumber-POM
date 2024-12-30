package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AmazonStep {
    AmazonPage amazonPage = new AmazonPage();

    @Given("Kullanıcı Amazon ana sayfasında")
    public void kullanıcıAmazonAnaSayfasında() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        amazonPage.cookies.click();
    }


    @When("Kullanıcı arama çubuğuna {string} yazar ve arama yapar")
    public void kullanıcıAramaCubugunaYazarVeAramaYapar(String arancakUrun) {
        amazonPage.searchBox.sendKeys(arancakUrun, Keys.ENTER);

    }

    @Then("Arama sonuçları {string} kelimesini içermelidir")
    public void aramaSonuclarıKelimesiniIcermelidir(String arananUrun) {
        Assert.assertTrue(amazonPage.searchResults.getText().contains(arananUrun));

    }

    @And("Kullanıcı ilk ürünü sepete ekler")
    public void kullanıcıIlkUrunuSepeteEkler() {
        amazonPage.sepeteEkle.click();
    }

    @Then("Kullanıcı ürünün sepete eklendiğini kontrol eder")
    public void kullanıcıUrununSepeteEklendiginiKontrolEder() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonSepet"));
        Assert.assertTrue(amazonPage.sepetiOnayla.getText().contains("Alışveriş Sepeti"));
    }

    @And("Kullanıcı sayfayı kapatır")
    public void kullanıcıSayfayıKapatır() {
        Driver.closeDriver();
    }

    @And("Kullanıcı {int} saniye bekler")
    public void kullanıcıSaniyeBekler(int sure) {
        ReusableMethods.waitFor(sure);
    }
}

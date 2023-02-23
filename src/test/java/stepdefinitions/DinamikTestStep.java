package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import pages.TestPage;
import utilities.ConfigReader;
import utilities.Driver;

public class DinamikTestStep {

    TestPage testPage = new TestPage();

    @Given("Kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Then("Kullanici arama yapmak istedigi {string} birimleri girer")
    public void kullanici_arama_yapmak_istedigi_birimleri_girer(String aranacakParaBirimi) {

        testPage.googleAramaKutusu.sendKeys(ConfigReader.getProperty(aranacakParaBirimi) + Keys.ENTER);
    }


}

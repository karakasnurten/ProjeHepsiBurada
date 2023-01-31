package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.TestPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.image.Kernel;

public class Test01 {

    TestPage testPage = new TestPage();
    String paraninDegeri = "";
    @Given("Kullanici google sayfasina gider")
    public void kullanici_google_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Then("Kullanici cookies i kabul eder")
    public void kullanici_cookies_i_kabul_eder() {
    // cookies varsa kabul edilir

       // testPage.cookies.click();
    }
    @Then("Arama Kutusuna karsilastirma yapmak istedigi para birimlerini girer")
    public void arama_kutusuna_karsilastirma_yapmak_istedigi_para_birimlerini_girer() {
     testPage.googleAramaKutusu.sendKeys("Euro to Dollar"+ Keys.ENTER);
    }
    @Then("Para birimlerinin karsilastirmasini alir")
    public void para_birimlerinin_karsilastirmasini_alir() {

   paraninDegeri = testPage.karsilastirilanDeger.getText();
        System.out.println(paraninDegeri);

    }
    @Then("Verilen degerlerin iki den kucuk oldugunu dogrular")
    public void verilenDegerlerinIkiDenKucukOldugunuDogrular() {

        Assert.assertTrue(Double.parseDouble(paraninDegeri)<1.5);
    }
}

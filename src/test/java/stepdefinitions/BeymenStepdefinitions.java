package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.BeymenPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;


public class BeymenStepdefinitions {

    String fiyat;

    BeymenPages beymen = new BeymenPages();

    @Given("kullanici Beymen sayfasina gider")
    public void kullanici_beymen_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("beymenUrl"));
    }
    @Then("Cerezleri kabul eder ve cinsiyet secimini yapar")
    public void cerezleriKabulEderVeCinsiyetSeciminiYapar() {

        ReusableMethods.bekle(3);
        beymen.cerezKabul.click();
        ReusableMethods.bekle(2);
        beymen.genderManButton.click();

    }
    @Given("Beymen anasayfasinin acildigini kontrol eder")
    public void beymen_anasayfasinin_acildigini_kontrol_eder() {
        String str= "Beymen";

        assertTrue(Driver.getDriver().getTitle().contains(str));
    }
    @Given("Arama kutucuguna {string} kelimesini girer ve aratir")
    public void arama_kutucuguna_kelimesini_girer_ve_aratir(String aranacakUrun) {
        aranacakUrun = ConfigReader.getProperty("aranacakBeymen");
        beymen.searchbox.sendKeys(aranacakUrun+ Keys.ENTER);
    }
    @Then("Sonuca gore sergilenen urunlerden rastgele bir urun secer")
    public void sonuca_gore_sergilenen_urunlerden_rastgele_bir_urun_secer() {
        ReusableMethods.bekle(2);
        beymen.firstProduct.click();
    }
    @Then("Secilen urunun urun bilgisi ve tutar bilgisini txt dosyasina yazdirir")
    public void secilen_urunun_urun_bilgisi_ve_tutar_bilgisini_txt_dosyasina_yazdirir() throws IOException {

        String str = beymen.productDetail.getText();
        fiyat = beymen.price.getText();

        //  FileWriter file = new FileWriter("C:\\Users\\Yvz\\Desktop\\proje.txt",true);

        FileWriter file = new FileWriter("C:\\Users\\Yvz\\Desktop\\proje.txt");

        file.write("urun detaylari : "+ str);
        file.write("--------------------------------");
        file.write("urun fiyati : "+fiyat);
        file.close();

    }
    @Then("Secilen urunu sepete ekler")
    public void secilen_urunu_sepete_ekler() {
        beymen.urunBedeni.click();
        ReusableMethods.bekle(2);
        beymen.sepeteEkle.click();
        ReusableMethods.bekle(3);
        beymen.sepetim.click();

    }
    @Then("Urun sayfasindaki fiyat ile sepette yer alan urunun fiyatinin dogrulugunu karsilastirir")
    public void urun_sayfasindaki_fiyat_ile_sepette_yer_alan_urunun_fiyatinin_dogrulugunu_karsilastirir() {
        assertEquals(fiyat,beymen.sepettekiUrunFiyati.getText());
    }
    @Then("Adet sayisini arttirarak urun adedinin {int} oldugunu dogrular")
    public void adet_sayisini_arttirarak_urun_adedinin_oldugunu_dogrular(Integer sayi) {

        String birimFiyatStr = beymen.sepettekiUrunFiyati.getText();
        String sepettekiUrunStr = birimFiyatStr.replaceAll("\\D","");
        int birimFiyat = Integer.parseInt(sepettekiUrunStr);
        //System.out.println(birimFiyat);
        ReusableMethods.bekle(3);

        String secim = sayi + " adet";
        Select select = new Select(beymen.sepettekiUrunuArtirButonu);
        select.selectByVisibleText(secim);

        ReusableMethods.bekle(3);
        Driver.getDriver().navigate().refresh();

        String toplamFiyatStr = beymen.sepettekiUrunFiyati.getText();
        String sepettekiUrunStrs = toplamFiyatStr.replaceAll("\\D","");
        int toplamFiyat = Integer.parseInt(sepettekiUrunStrs);
        //System.out.println(toplamFiyat);
        assertEquals((toplamFiyat / birimFiyat), (int) sayi);

    }
    @Then("Urunu sepetten silerek sepetin bos oldugunu kontrol eder")
    public void urunu_sepetten_silerek_sepetin_bos_oldugunu_kontrol_eder() {

        beymen.sepettekiUrunSilButonu.click();

        assertTrue(beymen.sepetinizdeUrunBulunmamaktadir.isDisplayed());


    }

}

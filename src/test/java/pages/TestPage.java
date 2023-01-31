package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestPage {

    public TestPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[text()='Accept all']")
    public WebElement cookies;

    @FindBy(xpath = "//input[@class='gLFyf']")
    public WebElement googleAramaKutusu;

    @FindBy (xpath = "//span[@class='DFlfde SwHCTb']")
    public WebElement karsilastirilanDeger;
}

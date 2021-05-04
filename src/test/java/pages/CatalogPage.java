package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
    WebDriver driver;


    @FindBy(xpath = "//span[contains(text(),'Электроника')]")
    WebElement electronicaSectionButton;

    public CatalogPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ElectronicaMenuPage clickElectronicaButton(){
        electronicaSectionButton.click();
        return new ElectronicaMenuPage (driver);

    }
}

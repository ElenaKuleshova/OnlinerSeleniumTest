package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlinerHomePage {
    WebDriver driver;

    @FindBy(linkText = "Каталог")
    WebElement catalogSectionButton;

    @FindBy(linkText = "Новости")
    WebElement newsSectionButton;


    public OnlinerHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CatalogPage clickCatalogSectionButton(){
        catalogSectionButton.click();
        return new CatalogPage(driver);
    }


}

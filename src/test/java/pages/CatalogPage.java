package pages;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

public class CatalogPage{
    WebDriver driver;

    private String  catalogNavigationItem = "//span[contains(text(),'%s')]";
    private String catalogPageTitle = "Каталог Onliner";

    public String getCatalogPageTitle(){
        return catalogPageTitle;
    }

    public CatalogPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void navigateCatalogItem(String catalogItem){
        BaseElement baseElement = new BaseElement(By.xpath(String.format(catalogNavigationItem,catalogItem)));
        baseElement.clickElement(By.xpath(String.format(catalogNavigationItem,catalogItem)));

    }

}

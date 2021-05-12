package pages;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

public class ElectronicaMenuPage {
 WebDriver driver;

 private String asideItemTitle = "//div[@class='catalog-navigation-list__aside-title'][contains(text(),'%s')]";
 private String dropdownTitle = "//span[@class='catalog-navigation-list__dropdown-title'][contains(text(),'%s')]";



    public ElectronicaMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMenuAsideItem(String menuAsideTitle){
        BaseElement baseElement = new BaseElement(By.xpath(String.format(asideItemTitle,menuAsideTitle)));
        baseElement.clickElement(By.xpath(String.format(asideItemTitle,menuAsideTitle)));
            }


    public void clickOnMenuDropdownItem(String menuDropdownTitle){
        BaseElement baseElement = new BaseElement(By.xpath(String.format(dropdownTitle,menuDropdownTitle)));
        baseElement.clickElement(By.xpath(String.format(dropdownTitle,menuDropdownTitle)));

    }



}

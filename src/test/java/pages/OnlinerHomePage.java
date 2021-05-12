package pages;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

public class OnlinerHomePage {
    WebDriver driver;

    private final String onlinerSection= "%s";
    private String onlinerPageTitle = "Onliner";

    public String getOnlinerPageTitle(){
        return onlinerPageTitle;
    }

    public OnlinerHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void navigateSection(String mainSectionName){
        BaseElement baseElement = new BaseElement(By.linkText(String.format(onlinerSection,mainSectionName)));
        baseElement.clickElement(By.linkText(String.format(onlinerSection,mainSectionName)));

    }


}

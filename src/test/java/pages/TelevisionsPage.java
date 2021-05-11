package pages;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelevisionsPage {
    WebDriver driver;

    public TelevisionsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private final String checkboxFilter = "//div[@class='schema-filter__label' and contains(.,'%s')]/following-sibling::div//span[contains(text(),'%s')]";
    private final String inputFilter = "//input[@placeholder='%s']";


    public WebElement getCheckboxByValue(String filterName, String filterValue)
    {
        return driver.findElement(new By.ByXPath(String.format(checkboxFilter,filterName,filterValue)));
    }


    public void selectCheckboxByValue(String filterTitle, String filterValue){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getCheckboxByValue(filterTitle, filterValue));
    }

  /*
public WebElement getFirstDiagonalSizeFromDropdown(String size){
        return driver.findElement(new By.ByXPath("//div[@class='schema-filter__group']/*[1]//option[contains(text(),'"+size+"')]"));
}

public void selectFirstDiagonalSizeFromDropdown (String size){
        getFirstDiagonalSizeFromDropdown(size).click();
}


    public WebElement getSecondDiagonalSizeFromDropdown(String size){
        return driver.findElement(new By.ByXPath("//div[@class='schema-filter__group']/*[2]//option[contains(text(),'"+size+"')]"));
    }

    public void selectSecondDiagonalSizeFromDropdown (String size){
        getSecondDiagonalSizeFromDropdown(size).click();
    }*/


public WebElement getPriceTextBox(String placeholder){
        return driver.findElement(new By.ByXPath(String.format(inputFilter, placeholder)));
}

public void setPrice(String placeholder, String price){
        getPriceTextBox(placeholder).sendKeys(price + Keys.ENTER);
}



    }



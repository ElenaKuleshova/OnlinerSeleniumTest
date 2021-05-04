package pages;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelevisionsPage {
    WebDriver driver;

   @FindBy(xpath = "//input[@value='samsung']")
   WebElement checkbox;



    @FindBy(xpath = "//input[@placeholder='до']")
    WebElement priceToTextBox;

    @FindBy(xpath = "//div[@class='schema-filter__group']/*[1]//option[@value='400']")
    WebElement selectDiagonalFrom;

    @FindBy(xpath = "//div[@class='schema-filter__group']/*[2]//option[@value='500']")
    WebElement selectDiagonalTo;

    @FindBy(xpath = "//input[@value='1920x1080']")
    WebElement resolutionCheckbox;

    public TelevisionsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//This method to get WebElement of checkbox with appropriate value attribute
    public WebElement getCheckboxByValue(String value)
    {
        return driver.findElement(new By.ByXPath("//input[@value='"+value+"']"));
    }

//This method to select checkbox with appropriate value attribute
    public void selectCheckboxByValue(String value){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", getCheckboxByValue(value));
    }

    //This method to get element in the first Diagonal dropdown
public WebElement getFirstDiagonalSizeFromDropdown(String size){
        return driver.findElement(new By.ByXPath("//div[@class='schema-filter__group']/*[1]//option[contains(text(),'"+size+"')]"));
}
//This method to select size in the first Diagonal dropdown
public void selectFirstDiagonalSizeFromDropdown (String size){
        getFirstDiagonalSizeFromDropdown(size).click();
}

    //This method to get element in the second Diagonal dropdown
    public WebElement getSecondDiagonalSizeFromDropdown(String size){
        return driver.findElement(new By.ByXPath("//div[@class='schema-filter__group']/*[2]//option[contains(text(),'"+size+"')]"));
    }
    //This method to select size in the second Diagonal dropdown
    public void selectSecondDiagonalSizeFromDropdown (String size){
        getSecondDiagonalSizeFromDropdown(size).click();
    }

   //This method to get price textbox element by placeholder
public WebElement getPriceTextBox(String placeholder){
        return driver.findElement(new By.ByXPath("//input[@placeholder='"+placeholder+"']"));
}

public void setPrice(String placeholder, String price){
        getPriceTextBox(placeholder).sendKeys(price + Keys.ENTER);
}



    }



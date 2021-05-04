package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElectronicaMenuPage {
 WebDriver driver;

 @FindBy(xpath = "//div[@class='catalog-navigation-list__aside-title'][contains(text(),'Телевидение')]")
 WebElement tvAndVideoListItem;

 @FindBy(xpath = "//span[@class='catalog-navigation-list__dropdown-title'][contains(text(),'Телевизоры')]")
 WebElement televisionsAsideItem;

 public ElectronicaMenuPage(WebDriver driver){
     this.driver = driver;
     PageFactory.initElements(driver, this);
 }

 public void clickOnTvAndVideoListItem(){
tvAndVideoListItem.click();
 }

 public TelevisionsPage clickOnTelevisionAsideItem(){
     televisionsAsideItem.click();
     return new TelevisionsPage(driver);
 }


}

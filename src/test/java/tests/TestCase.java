package tests;

import base.BaseTest;
import checks.Validation;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CatalogPage;
import pages.ElectronicaMenuPage;
import pages.TelevisionsPage;
import pages.OnlinerHomePage;

import java.util.List;



public class TestCase extends BaseTest {

    @Parameters({"tvModel", "price", "resolution", "diagonalSizeStart", "diagonalSizeTo"})
    @Test
    public void testTVSearchResults(String tvModel, String price, String resolution, String diagonalSizeStart, String diagonalSizeTo) throws Exception {

        Assert.assertEquals(driver.getTitle(), "Onliner");


        //Navigate to Catalog section
        OnlinerHomePage onlinerHomePage = new OnlinerHomePage(driver);
        CatalogPage catalogPage = onlinerHomePage.clickCatalogSectionButton();
        Assert.assertEquals(driver.getTitle(), "Каталог Onliner");

        //Navigate to Electronica Menu from Catalog Main Page and select TV and Video
        ElectronicaMenuPage electronicaMenuPage = catalogPage.clickElectronicaButton();
        Assert.assertTrue(driver.findElement(new By.ByXPath("//div[contains(text(),'Мобильные телефоны и')]")).isDisplayed());

        electronicaMenuPage.clickOnTvAndVideoListItem();

        //Navigate to Televisions page
        TelevisionsPage televisionsPage = electronicaMenuPage.clickOnTelevisionAsideItem();
        Assert.assertTrue(driver.findElement(new By.ByXPath("//h1[contains(text(), 'Телевизоры')]")).isDisplayed());

        //Select filters for TV Search
        televisionsPage.selectCheckboxByValue(tvModel);
        televisionsPage.setPrice("до", price);
        televisionsPage.selectCheckboxByValue(resolution);
        televisionsPage.selectFirstDiagonalSizeFromDropdown(diagonalSizeStart);
        televisionsPage.selectSecondDiagonalSizeFromDropdown(diagonalSizeTo);

        //Wait
       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//div[@class='schema-products']")));
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(new By.ByXPath("//div[@class='schema-product__group']")));


       Validation validation = new Validation(driver);

       List<WebElement> productElements = validation.getProductDescription();

       Assert.assertTrue(validation.checkTVModelFilter(productElements,tvModel));
       Assert.assertTrue(validation.checkResolutionFilter(productElements,resolution));
       Assert.assertTrue(validation.checkDiagonalSizeFilter(productElements,diagonalSizeStart,diagonalSizeTo));
       Assert.assertTrue(validation.checkPriceFilter(price));

           }
}









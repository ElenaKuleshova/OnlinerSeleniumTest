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

    @Parameters({"filterTitleProducer","filterValueProducer",
            "price",
            "filterTitleResolution","filterValueResolution",
            "filterTitleDiagonal", "filterValueDiagonalMin", "filterValueDiagonalMax"
           })
    @Test
    public void testTVSearchResults(String filterTitleProducer,String filterValueProducer,
                                    String price,
                                    String filterTitleResolution, String filterValueResolution,
                                    String filterTitleDiagonal, String filterValueDiagonalMin,String filterValueDiagonalMax){

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
        televisionsPage.selectCheckboxByValue(filterTitleProducer, filterValueProducer);
        televisionsPage.setPrice("до", price);
        televisionsPage.selectCheckboxByValue(filterTitleResolution, filterValueResolution);
        televisionsPage.selectCheckboxByValue(filterTitleDiagonal, filterValueDiagonalMin);
        televisionsPage.selectCheckboxByValue(filterTitleDiagonal, filterValueDiagonalMax);
        //televisionsPage.selectFirstDiagonalSizeFromDropdown(diagonalSizeStart);
        //televisionsPage.selectSecondDiagonalSizeFromDropdown(diagonalSizeTo);

        //Wait
       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//span[@class='schema-filter-button__sub schema-filter-button__sub_main'][contains(text(), 'Найдено')]")));
       //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(new By.ByXPath("//div[@class='schema-product__group']")));


       Validation validation = new Validation(driver);

       List<WebElement> productElements = validation.getProductDescription();

       //Assert.assertTrue(validation.checkTVModelFilter(productElements,tvModel));
       //Assert.assertTrue(validation.checkResolutionFilter(productElements,resolution));
       //Assert.assertTrue(validation.checkDiagonalSizeFilter(productElements,diagonalSizeStart,diagonalSizeTo));
       //Assert.assertTrue(validation.checkPriceFilter(price));

           }
}









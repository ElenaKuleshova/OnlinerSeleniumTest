package tests;

import base.BaseElement;
import base.BaseTest;
import base.BrowserService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CatalogPage;
import pages.ElectronicaMenuPage;
import pages.TelevisionsPage;
import pages.OnlinerHomePage;

import java.util.List;



public class TestCase extends BaseTest {

    @Parameters({"mainSectionName", "catalogItem",
            "menuAsideTitle", "menuDropdownTitle",
            "filterTitleProducer", "filterValueProducer",
            "filterTitlePrice", "pricePlaceholder", "priceValue",
            "filterTitleResolution", "filterValueResolution",
            "filterTitleDiagonal", "filterValueDiagonalMin", "filterValueDiagonalMax"
    })
    @Test
    public void testTVSearchResults(String mainSectionName, String catalogItem,
                                    String menuAsideTitle, String menuDropdownTitle,
                                    String filterTitleProducer, String filterValueProducer,
                                    String filterTitlePrice, String pricePlaceholder, String priceValue,
                                    String filterTitleResolution, String filterValueResolution,
                                    String filterTitleDiagonal, String filterValueDiagonalMin, String filterValueDiagonalMax) {



        OnlinerHomePage onlinerHomePage = new OnlinerHomePage(driver);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), onlinerHomePage.getOnlinerPageTitle());

        onlinerHomePage.navigateSection(mainSectionName);

        CatalogPage catalogPage = new CatalogPage(driver);
        softAssert.assertEquals(driver.getTitle(), catalogPage.getCatalogPageTitle());

        catalogPage.navigateCatalogItem(catalogItem);


        ElectronicaMenuPage electronicaMenuPage = new ElectronicaMenuPage(driver);
        electronicaMenuPage.clickOnMenuAsideItem(menuAsideTitle);
        electronicaMenuPage.clickOnMenuDropdownItem(menuDropdownTitle);


        TelevisionsPage televisionsPage = new TelevisionsPage(driver);
        softAssert.assertTrue(driver.findElement(televisionsPage.getTvPageTitleLocator()).isDisplayed());

        televisionsPage.selectCheckboxFilter(filterTitleProducer, filterValueProducer);
        televisionsPage.setInputFilter(filterTitlePrice, pricePlaceholder, priceValue);
        televisionsPage.selectCheckboxFilter(filterTitleResolution, filterValueResolution);
        televisionsPage.selectCheckboxFilter(filterTitleDiagonal, filterValueDiagonalMin);
        televisionsPage.selectCheckboxFilter(filterTitleDiagonal, filterValueDiagonalMax);

        softAssert.assertTrue(televisionsPage.isEachProductHasTitleWithFilterValue(filterValueProducer));
        softAssert.assertTrue(televisionsPage.isEachProductHasPriceByFilterValue(priceValue));
        softAssert.assertTrue(televisionsPage.isEachProductContainsFilterValue(filterValueResolution));
        softAssert.assertTrue(televisionsPage.isEachProductWithinMinAndMaxRange(filterValueDiagonalMin, filterValueDiagonalMax));
        softAssert.assertAll();

        }
    }










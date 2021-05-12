package pages;

import base.BaseElement;
import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TelevisionsPage {
    WebDriver driver;

    public TelevisionsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private final String checkboxFilter = "//div[@class='schema-filter__label' and contains(.,'%s')]/following-sibling::div//span[contains(text(),'%s')]";
    private final String inputFilter = "//div[@class='schema-filter__label' and contains(.,'%s')]/following-sibling::div//input[@placeholder='%s']";
    private final By tvPageTitleLocator = By.xpath("//h1[contains(text(), 'Телевизоры')]");

   private static final By FILTER_RESULT_BUTTON = By.className("schema-filter-button__inner-container");

    private final By PRODUCT_TITLE = By.className("schema-product__title");
    public static By PRODUCT_DESCRIPTION = By.className("schema-product__description");

    private final By PRODUCT_PRICE = By.xpath("//div[@class='schema-product__price']//span");



    public By getTvPageTitleLocator(){return tvPageTitleLocator;};



       public void selectCheckboxFilter(String filterTitle, String filterValue){
           BaseElement baseElement = new BaseElement(FILTER_RESULT_BUTTON);
           String buttonText = baseElement.getElement(FILTER_RESULT_BUTTON).getText();

           JavascriptExecutor executor = (JavascriptExecutor)driver;
           executor.executeScript("arguments[0].click();", baseElement.getElement(By.xpath(String.format(checkboxFilter,filterTitle,filterValue))));
           baseElement.waitInvisibilityText(FILTER_RESULT_BUTTON, buttonText);

           }

        public void setInputFilter(String filterTitle, String placeholder, String inputValue){
            BaseElement baseElement = new BaseElement(FILTER_RESULT_BUTTON);
            String buttonText = baseElement.getElement(FILTER_RESULT_BUTTON).getText();

            baseElement.getElement(By.xpath(String.format(inputFilter, filterTitle, placeholder))).sendKeys(inputValue + Keys.ENTER);
            baseElement.waitInvisibilityText(FILTER_RESULT_BUTTON, buttonText);


}

        public boolean isEachProductHasTitleWithFilterValue(String filterValue){
            BaseElement baseElement = new BaseElement(PRODUCT_TITLE);
            List<WebElement> elements = baseElement.getElements(PRODUCT_TITLE);
             for (WebElement element : elements) {
                if (!element.getText().contains(filterValue)) {
                return false;
        }
    }
             return true;
}


        public boolean isEachProductHasPriceByFilterValue(String priceValue){
        BaseElement baseElement = new BaseElement(PRODUCT_PRICE);

        List<WebElement> elements = baseElement.getElements(PRODUCT_PRICE);
        for (WebElement element : elements){
            String str = element.getText();

            str = str.substring(0,str.length()-3);
            str = str.replace(",", ".");
            double actualPrice = Double.parseDouble(str);

            if (actualPrice > Integer.parseInt(priceValue)){
                return false;
            }
        }
        return true; }



    public boolean isEachProductContainsFilterValue(String filterValue) {
        BaseElement baseElement = new BaseElement(PRODUCT_DESCRIPTION);
        List<WebElement> elements = baseElement.getElements(PRODUCT_DESCRIPTION);
        for (WebElement element : elements) {
                        if (!element.getText().contains(filterValue)) {
                return false;
            }
        }
        return true;
    }

public boolean isEachProductWithinMinAndMaxRange(String minRange, String maxRange){
    BaseElement baseElement = new BaseElement(PRODUCT_DESCRIPTION);

    List<WebElement> elements = baseElement.getElements(PRODUCT_DESCRIPTION);
    for (WebElement element : elements) {
    String str = element.getText();
    str = str.substring(0,4);
    ;
    str = str.replace("\"", "");
    double actualDiagonal = Double.parseDouble(str);

    if (!(actualDiagonal>=Integer.parseInt(minRange) && actualDiagonal<=Integer.parseInt(maxRange))) {return false;}
}
        return true; }
}






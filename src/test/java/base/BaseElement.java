package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement implements WebElement{
    protected WebElement webElement;
    private static final int WAIT = 10;


    public BaseElement(By by) {
        this.webElement = getElement(by);
    }

    public static WebElement getElement(By Locator) {
               return new WebDriverWait(BrowserService.getDriver(), WAIT)
                    .until(driver -> driver.findElement(Locator));
        }


    public static List<WebElement> getElements(By Locator) {
        return new WebDriverWait(BrowserService.getDriver(), WAIT)
                .until(driver -> driver.findElements(Locator));
    }

    public void waitInvisibilityText(By Locator, String text) {
        WebDriverWait wait = new WebDriverWait(BrowserService.getDriver(), WAIT);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Locator, text));
    }

    public void clickElement(By elementLocator) {
        getElement(elementLocator).click();
    }

     @Override
    public void click() {

    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}

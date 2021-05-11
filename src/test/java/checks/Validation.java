package checks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Double.parseDouble;

public class Validation {
    WebDriver driver;

    public Validation(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public boolean checkPriceFilter(String price) {
        List<WebElement> elements = driver.findElements(new By.ByXPath("//div[@class='schema-product__price']//span"));
        for (WebElement element : elements){
            String str = element.getText();
            System.out.println(str);
            str = str.substring(0,str.length()-3);
            str = str.replace(",", ".");
            double actualPrice = Double.parseDouble(str);

            if (actualPrice > Integer.parseInt(price)){
                return false;
            }
        }
   return true; }

   public List<WebElement> getProductDescription(){
       List<WebElement> elements = driver.findElements(new By.ByXPath("//div[@class='schema-product__description']/span"));
       return elements;
   }
public boolean checkTVModelFilter(List<WebElement> elements, String tvModel){
       for (WebElement element : elements){
        String str = element.getText();
        System.out.println(str);
        if (!str.contains(tvModel)){
            return false;
        }
    }
    return true; }


    public boolean checkResolutionFilter(List<WebElement> elements, String resolution){
        for (WebElement element : elements){
            String str = element.getText();
            System.out.println(str);
            if (!str.contains(resolution)){
                return false;
            }
        }
        return true; }


    public boolean checkDiagonalSizeFilter(List<WebElement> elements, String diagonalSizeStart, String diagonalSizeTo){
        for (WebElement element : elements){
            String str = element.getText();
            str = str.substring(0,4);
            System.out.println(str);
            str = str.replace("\"", "");
            double actualDiagonal = Double.parseDouble(str);

            if (!(actualDiagonal>=Integer.parseInt(diagonalSizeStart) && actualDiagonal<=Integer.parseInt(diagonalSizeTo))) {return false;}
        }
        return true; }
}



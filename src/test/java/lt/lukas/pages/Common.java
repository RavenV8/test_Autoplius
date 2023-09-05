package lt.lukas.pages;

import lt.lukas.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Common {
    public static void setUpChromeDriver() {
        Driver.setChrome();
    }
    public static void openUrl(String url) {
        Driver.getInstance().get(url);
    }
    public static void quitDriver() {
        Driver.quitWebDriver();
    }
    public static WebElement getElement(By locator){
        return Driver.getInstance().findElement(locator);
    }
    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }
}

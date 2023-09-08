package lt.lukas.pages;

import lt.lukas.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    public static boolean waitForElementToBeVisibleCustomised(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true; // when element did become visible
        } catch (TimeoutException e) {
            return false; // when element did not become visible
        } catch (NoSuchElementException e) {
            return false; // when element was not found
        }
    }
    public static void sendKeysToElement(By locator, String message) {
        getElement(locator).sendKeys(message);
    }
    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }
}

package lt.lukas.pages.autoplius.createSellPages;

import lt.lukas.pages.Common;
import lt.lukas.pages.Locators;
import lt.lukas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateSellPage {
    public static void open(){
        Common.setUpChromeDriver();
        Common.openUrl("https://m.autoplius.lt");
    }
    public static void acceptCookies() {
        boolean isVisible =
                Common.waitForElementToBeVisibleCustomised(Locators.Autoplius.Home.dialogCookies, 2);
        if (isVisible){
            Common.clickOnElement(Locators.Autoplius.Home.buttonAccept);
        }
    }

    public static void clickOnCreateSellButton() {
        Common.clickOnElement(Locators.Autoplius.Sell.buttonOpenSellWindow);
    }

    public static void clickOnToCreateCarSell() {
        Common.clickOnElement(Locators.Autoplius.Sell.buttonToSellCar);
    }

    public static void selectTwoOptions(String optionOne, String optionTwo, String optionType) {
        // To open List
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.Sell.chooseListOption(optionType)));
        elementByXPath.click(); // Click on the element located by XPath

        // To choose Wanted option
        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.Sell.chooseOption(optionOne)));
        elementByXPath.click();
        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.Sell.chooseOption(optionTwo)));
        elementByXPath.click();
    }

    public static void selectSingleOption(String option, String optionType) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.Sell.chooseFieldOption(optionType)));
        elementByXPath.click();

        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.Sell.chooseOption(option)));
        elementByXPath.click();
    }

    public static void selectOption(String option, String optionType) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.Sell.chooseButtonOption(option, optionType)));
        elementByXPath.click();
    }

    public static void insertMileage(String message) {
        Common.sendKeysToElement(
                Locators.Autoplius.Sell.insertMileage,
                message
        );
    }
    public static void insertPrice(String message) {
        Common.sendKeysToElement(
                Locators.Autoplius.Sell.insertPrice,
                message
        );
    }
    public static void insertNumber(String message) {
        Common.sendKeysToElement(
                Locators.Autoplius.Sell.insertNumber,
                message.substring(4)
        );
    }
    public static void insertEmail(String message) {
        Common.sendKeysToElement(
                Locators.Autoplius.Sell.insertEmail,
                message
        );
    }

    public static void submitDataToSearch() {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.Sell.chooseListOption("submit")));
        elementByXPath.click();
    }

    public static String searchDescription() {
        return Common.getTextFromElement(Locators.Autoplius.Sell.searchTitle);
    }

    public static String readError() {
        return Common.getTextFromElement(Locators.Autoplius.Sell.error);
    }
}

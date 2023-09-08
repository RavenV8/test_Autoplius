package lt.lukas.pages.autoplius.seachCarPage;

import lt.lukas.pages.Common;
import lt.lukas.pages.Locators;
import lt.lukas.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchCarPage {
    public static void open(){
        Common.setUpChromeDriver();
        Common.openUrl("https://m.autoplius.lt/");
    }
    public static void acceptCookies() {
        boolean isVisible =
                Common.waitForElementToBeVisibleCustomised(Locators.Autoplius.Home.dialogCookies, 2);
        if (isVisible){
            Common.clickOnElement(Locators.Autoplius.Home.buttonAccept);
        }
    }

    public static void selectBrandOptions(String brandName, String modelName) {
        // To open List
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseListOption("brand")));
        elementByXPath.click(); // Click on the element located by XPath

        // To choose Wanted option
        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseOption(brandName)));
        elementByXPath.click();
        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseOption(modelName)));
        elementByXPath.click();
    }

    public static void selectFromToOptions(String fromValue, String toValue, String type) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseListOption(type)));
        elementByXPath.click();

        if(fromValue != ""){
            elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseFromToOption("field_from",fromValue)));
            elementByXPath.click();
        }
        if(toValue != ""){
            elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseFromToOption("field_to", toValue)));
            elementByXPath.click();
        }
        if(fromValue == "" || toValue == ""){
            elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseOption("Pasirinkti")));
            elementByXPath.click();
        }
    }

    public static void selectSingleOptionCheckbox(String fuelType, String type) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseListOption(type)));
        elementByXPath.click();

        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseFuelOption(fuelType)));
        elementByXPath.click();

        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseListOption("Pasirinkti")));
        elementByXPath.click();

    }

    public static void selectSingleOption(String transmision, String type) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseListOption(type)));
        elementByXPath.click();

        elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseOption(transmision)));
        elementByXPath.click();
    }

    public static void submitDataToSearch(){
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(10));
        WebElement elementByXPath = wait.until(ExpectedConditions.elementToBeClickable(Locators.Autoplius.SearchEngine.chooseListOption("submit")));
        elementByXPath.click();
    }

    public static String searchDescription() {
        return Common.getTextFromElement(Locators.Autoplius.SearchEngine.searchTitle("search-title")) + " " + Common.getTextFromElement(Locators.Autoplius.SearchEngine.searchTitle("search-parameters"));
    }

    public static String generateExpectedResult(String brand, String model, String fromYear, String toYear, String fromPrice, String toPrice, String fuelType, String transmission, String bodyType) {
        String expectedResult = "";
        //To add brand or default 'Automobiliai'
        if(!brand.isEmpty()) expectedResult += brand + " ";
        else expectedResult += "Automobiliai ";
        //If there is brand there is model. If no model chosen then it is just brand
        if(!model.equals("Visi " + brand) && !model.isEmpty()) expectedResult = expectedResult + model + " ";

        // Chracters " | " are used to seperate certain objects
        if(!fuelType.isEmpty())expectedResult += fuelType + " | ";
        if(!transmission.isEmpty()) expectedResult += transmission + " | ";

        if(!fromYear.isEmpty()) expectedResult += "nuo " + fromYear;
        if(!fromYear.isEmpty() && !toYear.isEmpty()) expectedResult += " ";
        if(!toYear.isEmpty()) expectedResult += "iki " + toYear;

        if((!fromYear.isEmpty() || !toYear.isEmpty()) && (!fromPrice.isEmpty() || !toPrice.isEmpty())) expectedResult += " | ";

        if(!fromPrice.isEmpty()) expectedResult += "nuo " + fromPrice + " €";
        if(!fromPrice.isEmpty() && !toPrice.isEmpty()) expectedResult += " ";
        if(!toPrice.isEmpty()) expectedResult += "iki " + toPrice + " €";

        if(!bodyType.isEmpty()) expectedResult += " | " + bodyType;

        return expectedResult;
    }
}

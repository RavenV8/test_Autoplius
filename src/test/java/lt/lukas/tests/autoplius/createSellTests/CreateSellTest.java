package lt.lukas.tests.autoplius.createSellTests;

import lt.lukas.pages.autoplius.createSellPages.CreateSellPage;
import lt.lukas.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateSellTest extends BaseTest {
    @BeforeMethod
    @Override
    public void setUp() {
        CreateSellPage.open();
        CreateSellPage.acceptCookies();
    }
    @DataProvider(name = "dataAboutCar")
    public Object[][] provideDataForTestSelectListDemo() {
        return new Object[][]{
                {"Audi", "A4", "2008", "Liepa", "Benzinas", "Sedanas", "Automatinė", "4/5", "100000", "5000", "+37060000000", "cadxmwmyvbdfnoyepd@ckptr.com", "Lietuva", "Vilnius", "Audi A4, sedanas"},
                {"Renault", "Megane", "2011", "Kovas", "Dyzelinas", "Visureigis", "Mechaninė", "2/3", "250", "500", "+37060000000", "cadxmwmyvbdfnoyepd@ckptr.com", "Vokietija", "Kita", "Renault Megane, visureigis"},
                {"Tesla", "Model 3", "2020", "Gruodis", "Elektra", "Sedanas", "Automatinė", "4/5", "2000000", "250000", "+37060000000", "cadxmwmyvbdfnoyepd@ckptr.com", "Lietuva", "Vilnius", "Tesla Model 3, sedanas"},
                {"", "", "", "", "Benzinas / dujos", "", "", "", "10000", "", "", "cadxmwmyvbdfnoyepd@ckptr.com", "", "", "Užpildėte ne visus privalomus laukus"},
                {"", "", "", "", "", "", "", "", "", "", "", "cadxmwmyvbdfnoyepd@ckptr.com", "", "", "Užpildėte ne visus privalomus laukus"},
        };
    }
    @Test(dataProvider = "dataAboutCar")
    public void createSellTest(String brand, String model, String year, String month,
                             String fuelType, String bodyType, String transmission, String doorNumber,
                             String kilometrage, String price, String number, String email,
                             String country, String city, String expectedResult){

        CreateSellPage.clickOnCreateSellButton();
        CreateSellPage.clickOnToCreateCarSell();

        String actualResult;
        boolean missedMandatory = false;

        // Some methods have "type" string that is used in switch cases in Locators for cleaner code
        // missedMandatory boolean is used to identify if required information was not given
        if(!brand.isEmpty() && !model.isEmpty()) {CreateSellPage.selectTwoOptions(brand, model, "brand");} else {missedMandatory = true;}
        if(!year.isEmpty() && !month.isEmpty()) {CreateSellPage.selectTwoOptions(year, month, "year");} else {missedMandatory = true;}
        if(!fuelType.isEmpty()) {CreateSellPage.selectSingleOption(fuelType, "fuel_id");} else {missedMandatory = true;}
        if(!bodyType.isEmpty()) {CreateSellPage.selectSingleOption(bodyType, "body_type_id");} else {missedMandatory = true;}
        if(!transmission.isEmpty()) {CreateSellPage.selectOption(transmission, "transmission");} else {missedMandatory = true;}
        if(!doorNumber.isEmpty()) {CreateSellPage.selectOption(doorNumber, "door");} else {missedMandatory = true;}
        if(!kilometrage.isEmpty()) {CreateSellPage.insertMileage(kilometrage);} else {missedMandatory = true;}
        if(!price.isEmpty()) {CreateSellPage.insertPrice(price);} else {missedMandatory = true;}
        if(!number.isEmpty()) {CreateSellPage.insertNumber(number);} else {missedMandatory = true;}
        if(!email.isEmpty()) {CreateSellPage.insertEmail(email);} else {missedMandatory = true;}
        if(!country.isEmpty() && !city.isEmpty()) {CreateSellPage.selectTwoOptions(country, city, "place");} else {missedMandatory = true;}


        CreateSellPage.submitDataToSearch();

        if(missedMandatory) {
            actualResult = CreateSellPage.readError().substring(0, 36);
            Assert.assertEquals(actualResult, expectedResult);
        }
        else{
            actualResult = CreateSellPage.searchDescription();
            Assert.assertEquals(actualResult, expectedResult);
        }
    }
}
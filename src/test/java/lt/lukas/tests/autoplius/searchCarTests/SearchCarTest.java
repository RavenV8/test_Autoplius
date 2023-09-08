package lt.lukas.tests.autoplius.searchCarTests;


import lt.lukas.pages.autoplius.seachCarPages.SearchCarPage;
import lt.lukas.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchCarTest extends BaseTest {
    @BeforeMethod
    @Override
    public void setUp() {
        SearchCarPage.open();
        SearchCarPage.acceptCookies();
    }
    @DataProvider(name = "selectConfigurations")
    public Object[][] provideDataForTestSelectListDemo() {
        return new Object[][]{
                {"Audi", "A4", "2008", "2020", "1000", "10000", "Benzinas", "Automatinė", "Sedanas"},
                {"Renault", "Megane", "2011", "2011", "500", "4000", "Dyzelinas", "Mechaninė", "Hečbekas"},
                {"Mazda", "CX-5", "2016", "2023", "10000", "12000", "Benzinas", "Automatinė", "Visureigis"},
                {"Mazda", "Visi Mazda", "", "2023", "10000", "12000", "Benzinas", "Automatinė", "Sedanas"},
                {"BMW", "Visi BMW", "", "2023", "3000", "", "Benzinas", "Mechaninė", "Universalas"},
                {"BMW", "Visi BMW", "", "", "3000", "", "", "", "Universalas"},
                {"", "", "", "", "3000", "", "", "", "Universalas"},
                {"", "", "", "", "", "", "", "", ""},
        };
    }
    @Test(dataProvider = "selectConfigurations")
    public void searchEngine(
            String brand, String model, String fromYear, String toYear,
            String fromPrice, String toPrice, String fuelType, String transmission, String bodyType){

        //Some methods have "type" string that is used in switch cases in Locators for cleaner code
        if(!brand.isEmpty()) {SearchCarPage.selectBrandOptions(brand, model);}
        if(!fromYear.isEmpty() || !toYear.isEmpty()) {SearchCarPage.selectFromToOptions(fromYear, toYear, "year");}
        if(!fromPrice.isEmpty() || !toPrice.isEmpty()) {SearchCarPage.selectFromToOptions(fromPrice, toPrice, "price");}
        if(!fuelType.isEmpty()) {SearchCarPage.selectSingleOptionCheckbox(fuelType, "fuel");}
        if(!transmission.isEmpty()) {SearchCarPage.selectSingleOption(transmission, "transmission");}
        if(!bodyType.isEmpty()) {SearchCarPage.selectSingleOptionCheckbox(bodyType, "body");}
        SearchCarPage.submitDataToSearch();

        //Generating expectedResult from data
        String expectedResult = SearchCarPage.generateExpectedResult(brand, model, fromYear, toYear, fromPrice, toPrice, fuelType, transmission, bodyType);
        String actualResult = SearchCarPage.searchDescription();

        Assert.assertEquals(actualResult, expectedResult);
    }
}

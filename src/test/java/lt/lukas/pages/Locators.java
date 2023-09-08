package lt.lukas.pages;

import org.openqa.selenium.By;

public class Locators {

    public static class Autoplius {
        public static class Home{
            public static By dialogCookies = By.xpath("//div[@role='alertdialog']");
            public static By buttonAccept = By.xpath("//button[@id='onetrust-accept-btn-handler']");
        }
        public static class Login{
            public static By buttonOpenLoginWindow = By.xpath("//li[@class='js-global-user-menu']//span[@class='header-label']");
            public static By insertUserEmail = By.xpath("//input[@id='username-lookup']");
            public static By passwordBar = By.xpath("//input[@id='password']");
            public static By buttonContinue = By.xpath("//div[@class='login-button']");
            public static By emailError = By.xpath("//form[@action='https://autoplius.lt/login']//div//div//span[@class='username js-value']");
            public static By buttonSubmit = By.xpath("//form[@class='js-form-login']//div[@class='login-button']//button[@type='submit']");
            public static By checkIfEmailCorrect = By.xpath("//div[@class='drop-down']//span[@class='header-label']//strong");
        }
        public static class SearchEngine{
            public static By chooseListOption(String listName) {
                if (listName == "brand") {return By.xpath("//div[@id='field_make_id']");}
                else if(listName == "year"){return By.xpath("//div[@id='field_make_date_from']");}
                else if(listName == "price"){return By.xpath("//div[@id='field_sell_price_from']");}
                else if(listName == "fuel"){return By.xpath("//div[@id='field_fuel_id']");}
                else if(listName == "body"){return By.xpath("//div[@id='field_body_type_id']");}
                else if(listName == "transmission"){return By.xpath("//div[@id='field_gearbox_id']");}
                else if(listName == "Pasirinkti"){return By.xpath("//div[@title='Pasirinkti']");}
                else if(listName == "submit"){return By.xpath("//button[@type='submit']");}
                else return null;
            }
            public static By chooseOption(String option) {
                return By.xpath(String.format("//a[@title='%s']", option));
            }
            public static By chooseFromToOption(String fromOrTo, String option) {
                return By.xpath(String.format("//ul[@id='%s']//li/a[@title='%s']", fromOrTo, option));
            }
            public static By chooseFuelOption(String fuelType) {
                return By.xpath(String.format("//input[@title='%s']/following-sibling::label", fuelType));
            }
            public static By searchTitle (String type){
                return By.xpath(String.format("//div[@class='%s']", type));
            }
        }
    }
}

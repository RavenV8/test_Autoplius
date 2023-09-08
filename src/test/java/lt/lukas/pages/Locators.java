package lt.lukas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
                switch (listName) {
                    case "brand":
                        return By.xpath("//div[@id='field_make_id']");
                    case "year":
                        return By.xpath("//div[@id='field_make_date_from']");
                    case "price":
                        return By.xpath("//div[@id='field_sell_price_from']");
                    case "fuel":
                        return By.xpath("//div[@id='field_fuel_id']");
                    case "body":
                        return By.xpath("//div[@id='field_body_type_id']");
                    case "transmission":
                        return By.xpath("//div[@id='field_gearbox_id']");
                    case "Pasirinkti":
                        return By.xpath("//div[@title='Pasirinkti']");
                    case "submit":
                        return By.xpath("//button[@type='submit']");
                    default:
                        return null;
                }
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
        public static class Sell{
            public static By buttonOpenSellWindow = By.xpath("//span[@class='ico create-announcement']");
            public static By buttonToSellCar = By.xpath("//a[@class='categories-list-item ico-active-cat2']");
            public static By insertMileage = By.xpath("//input[@name='kilometrage']");
            public static By insertPrice = By.xpath("//input[@name='sell_price_eur']");
            public static By insertNumber= By.xpath("//input[@name='contacts_phone']");
            public static By insertEmail = By.xpath("//input[@name='contacts_email']");
            public static By error = By.xpath("//div[@class='error-msg']");

            public static By chooseListOption(String listName) {
                switch (listName) {
                    case "brand":
                        return By.xpath("//button[@data-placeholder='Markė, Modelis']");
                    case "year":
                        return By.xpath("//button[@data-placeholder='Pirmos registracijos data']");
                    case "place":
                        return By.xpath("//button[@data-placeholder='Šalis, Miestas']");
                    case "submit":
                        return By.xpath("//button[@title='Dėti skelbimą']");
                    default:
                        return null;
                }
            }

            public static By chooseOption(String option) {
                return By.xpath(String.format("//button[@class='search-dropdown' and text()='%s']", option));
            }
            public static By chooseFieldOption(String optionName) {
                return By.xpath(String.format("//button[@value='%s']", optionName));
            }
            public static By chooseButtonOption(String option, String optionName) {
                switch (optionName) {
                    case "transmission":
                        switch (option) {
                            case "Automatinė":
                                return By.xpath("//label[@for='gearbox_id_38']");
                            case "Mechaninė":
                                return By.xpath("//label[@for='gearbox_id_37']");
                            default:
                                return null;
                        }
                    case "door":
                        switch (option) {
                            case "2/3":
                                return By.xpath("//label[@for='number_of_doors_id_126']");
                            case "4/5":
                                return By.xpath("//label[@for='number_of_doors_id_127']");
                            case "Kita":
                                return By.xpath("//label[@for='number_of_doors_id_128']");
                            default:
                                return null;
                        }
                    default:
                        return null;
                }
            }

            public static By searchTitle = By.xpath("//div[@class='packet-ann-title']");
        }
    }
}

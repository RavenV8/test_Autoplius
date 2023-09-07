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

    }
}

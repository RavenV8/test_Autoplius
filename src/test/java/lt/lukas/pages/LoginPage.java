package lt.lukas.pages;

public class LoginPage {
    public static void open(){
        Common.setUpChromeDriver();
        Common.openUrl("https://autoplius.lt/");
    }

    public static void clickOnLoginButton() {
        Common.clickOnElement(Locators.SeleniumEasy.Login.buttonOpenLoginWindow);
    }
}

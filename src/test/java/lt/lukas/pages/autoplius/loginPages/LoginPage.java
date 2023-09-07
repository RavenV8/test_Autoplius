package lt.lukas.pages.autoplius.loginPages;

import lt.lukas.pages.Common;
import lt.lukas.pages.Locators;
import lt.lukas.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static void open(){
        Common.setUpChromeDriver();
        Common.openUrl("https://autoplius.lt/");
    }
    public static void acceptCookies() {
        boolean isVisible =
                Common.waitForElementToBeVisibleCustomised(Locators.Autoplius.Home.dialogCookies, 2);
        if (isVisible){
            Common.clickOnElement(Locators.Autoplius.Home.buttonAccept);
        }
    }
    public static void clickOnLoginButton() {
        Common.clickOnElement(Locators.Autoplius.Login.buttonOpenLoginWindow);
    }
    public static void insertEmail(String message) {
        Common.sendKeysToElement(
                Locators.Autoplius.Login.insertUserEmail,
                message
        );
    }
    public static boolean isThereErrorEmail(String email) {
        try {
            // How much time to wait for the element to become visible
            WebDriverWait wait = new WebDriverWait(Driver.getInstance(), Duration.ofSeconds(1));
            // emailError is xpath to certain object that displays email only when it is written correctly
            WebElement emailErrorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.Autoplius.Login.emailError));
            String emailErrorText = emailErrorElement.getText();

            return emailErrorText.contains(email);
        } catch (Exception e) {
            return false;
        }
    }
    public static void insertPassword(String message) {
        Common.sendKeysToElement(
                Locators.Autoplius.Login.passwordBar,
                message
        );
    }
    public static void clickOnContinue() {
        Common.clickOnElement(Locators.Autoplius.Login.buttonContinue);
    }
    public static void clickOnSubmit() {
        Common.clickOnElement(Locators.Autoplius.Login.buttonSubmit);
    }
    public static String checkEmail() {
        return Common.getTextFromElement(
                Locators.Autoplius.Login.checkIfEmailCorrect
        );
    }
    public static boolean loginWindowClosed() {
        // Checks if particular xpath is reachable that is only reachable when login window is closed (in other words on main menu)
        return !Driver.getInstance().findElements(Locators.Autoplius.Login.checkIfEmailCorrect).isEmpty();
    }
}

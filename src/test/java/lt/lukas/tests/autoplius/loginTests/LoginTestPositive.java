package lt.lukas.tests.autoplius.loginTests;

import lt.lukas.pages.autoplius.loginPages.LoginPage;
import lt.lukas.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestPositive extends BaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        LoginPage.open();
        LoginPage.acceptCookies();
    }
    @Test
    public void loginPage(){
        // Open login window
        LoginPage.clickOnLoginButton();
        // Type in Email
        String inputEmail = "cadxmwmyvbdfnoyepd@ckptr.com";
        String inputPassword = "Slaptazodi";
        LoginPage.insertEmail(inputEmail);
        LoginPage.clickOnContinue();

        String actualResult;
        // Check if email is accepted
        boolean isPasswordBarAppeared = LoginPage.isThereErrorEmail(inputEmail);
        if (isPasswordBarAppeared){
            // Type in Password
            LoginPage.insertPassword(inputPassword);
            LoginPage.clickOnSubmit();
            // Check if password is accepted
            boolean isLoginWindowClosed = LoginPage.loginWindowClosed();
            if(isLoginWindowClosed) {
                actualResult = LoginPage.checkEmail();
            }
            else{
                actualResult = "FAILED. Incorrect password.";
            }
        }
        else {actualResult = "FAILED. Incorrect email.";}

        // inputEmail used as expected result. On main menu it shows that we are connected and to correct account.
        Assert.assertEquals(actualResult, inputEmail,
                """
                \nExpected: %s
                Actual: %s
                """.formatted(inputEmail, actualResult));
    }
}

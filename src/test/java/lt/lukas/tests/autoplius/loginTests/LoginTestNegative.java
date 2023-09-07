package lt.lukas.tests.autoplius.loginTests;


import lt.lukas.pages.autoplius.loginPages.LoginPage;
import lt.lukas.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestNegative extends BaseTest {

    @BeforeMethod
    @Override
    public void setUp() {
        LoginPage.open();
        LoginPage.acceptCookies();
    }
    @DataProvider(name = "dataOfEmailAndPassword", parallel = true)
    public Object[][] provideDataForTestTwoInputFields() {
        return new Object[][]{
                {"asdafddsf@gmail.com", "Slaptazodi", "FAILED. Incorrect email."},
                {"", "Slaptazodi", "FAILED. Incorrect email."},
                {"cadxmwmyvbdfnoyepd@ckptr.com", "QWERT", "FAILED. Incorrect password."},
                {"cadxmwmyvbdfnoyepd", "", "FAILED. Incorrect email."},
                {"", "", "FAILED. Incorrect email."},
        };
    }
    @Test(dataProvider = "dataOfEmailAndPassword")
    public void loginPage(String email, String password, String expectedResult){
        // Open login window
        LoginPage.clickOnLoginButton();
        // Type in Email
        String inputEmail = email;
        String inputPassword = password;
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
        Assert.assertEquals(actualResult, expectedResult,
                """
                \nExpected: %s
                Actual: %s
                """.formatted(inputEmail, expectedResult));
    }
}

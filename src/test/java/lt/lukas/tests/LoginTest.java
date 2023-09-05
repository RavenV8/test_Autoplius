package lt.lukas.tests;

import lt.lukas.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @BeforeMethod
    @Override
    public void setUp() {
        LoginPage.open();
    }
    @Test
    public void loginPageOpen(){
        LoginPage.clickOnLoginButton();

    }
}

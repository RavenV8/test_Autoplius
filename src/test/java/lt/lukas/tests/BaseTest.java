package lt.lukas.tests;

import lt.lukas.pages.Common;
import lt.lukas.utilities.TestListener;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(TestListener.class)
public abstract class BaseTest {

    @BeforeMethod
    public abstract void setUp();

    @AfterMethod
    public void tearDown() {
        Common.quitDriver();
    }


}


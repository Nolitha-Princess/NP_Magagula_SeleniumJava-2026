package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//it extends the BaseTest class to inherit the WebDriver instance and any other
//shared resources needed for login tests.

public class LoginTest extends BaseTest {

    //Use @test to execute test
    @Test(dataProvider = "testData")

    //Method to test login functionality with valid credentials.
    //It throws InterruptedException to handle any interruptions during the execution of the test.

    public void loginWithValidCredentials(String emailAddress, String password) throws InterruptedException {
        loginPage.clickLoginButton();
        loginPage.enterEmailAddress(emailAddress);
        loginPage.enterPassword(password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginSuccess("My Learning");
    }

    //Data provider method that supplies test data for the login test.
    //It returns a two-dimensional array of objects,
    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {"123nolitha@gmail.com", "@test123"}
        };

    }
}


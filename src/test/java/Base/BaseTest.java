package Base;

import Pages.LoginPage;
import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    /*declaring a variable named browserFactory of type BrowserFactory and creating
    a new instance of the BrowserFactory class using the new keyword */

    BrowserFactory browserFactory = new BrowserFactory();

    //Define the URL of the application under test and the browser choice for running the tests
    //Final - Cannot be reassigned after initialization
    public final String url = "https://ndosisimplifiedautomation.vercel.app/";
    public final String browserChoice = "chrome";

    //Declare a WebDriver variable named driver, which will be used to control the browser during the tests
    public WebDriver driver;
    //Initialize the LoginPage object, which will be used to interact with the login page of the application
    public LoginPage loginPage;

    @BeforeMethod

    public void setUp() {
        //initialize the WebDriver instance by calling the startBrowser method of the BrowserFactory class,
        driver = browserFactory.startBrowser(browserChoice, url);
        //Initialize the LoginPage object using the PageFactory,
        //which allows for easy interaction with the elements on the login page
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @AfterMethod
    public void quitBrowser() {
        browserFactory.closeBrowser();
    }


}

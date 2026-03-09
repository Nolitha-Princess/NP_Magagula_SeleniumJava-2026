package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    //Specify the WebDriver instance as static to ensure it is shared across all instances of the class
    static WebDriver driver;

    //Method to start the browser based on the user's choice and navigate to the specified URL

    //Method takes two parameters: browserChoice (the type of browser to start) and url (the URL to navigate to)
    public static WebDriver startBrowser(String browserChoice, String url) {

        //Check the browser choice and initialize the corresponding WebDriver

        //equalsIgnoreCase is used to make the comparison case-insensitive, allowing for flexibility in user input
        if (browserChoice.equalsIgnoreCase("cHrOmE")) {
            driver = new ChromeDriver();
        } else if (browserChoice.equalsIgnoreCase("internetexplore")) {
            driver = new InternetExplorerDriver();
        } else if (browserChoice.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserChoice.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            driver = new EdgeDriver();
        }

        //Maximize the browser window and navigate to the specified URL
        driver.manage().window().maximize();
        driver.get(url);

        //Return the initialized WebDriver instance
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}

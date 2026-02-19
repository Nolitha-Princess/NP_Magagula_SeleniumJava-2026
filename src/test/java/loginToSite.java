import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginToSite {

    //WebDriver needed to open communication with the browser
    WebDriver driver;

    /*Use @test to execute test*/
    @Test
    public void loginWithValidCredentials() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button/span[2]")).click();
        driver.findElement(By.id("login-email")).sendKeys("NolithaMTest@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("test@123");
        driver.findElement(By.id("login-submit")).click();

        Thread.sleep(2000);

        //verification boolean to verify if  user is logged in
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[4]/button/span[2]")).isDisplayed();

        //string to verify that the user is logged in
        String myLearningText = driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[4]/button/span[2]")).getText();

        //show actual results
        System.out.println(myLearningText);
        //Assert that the txt is available
        Assert.assertEquals(myLearningText, "My Learning");

    }

}

package CRMProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open the browser
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void printURL() {
        String url = driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/img")).getAttribute("src");
        System.out.println("URL of the header image is: " + url);
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}

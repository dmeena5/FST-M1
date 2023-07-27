package CRMProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity6 {
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
    public void MenuCheck() {
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        String navigationMenu = driver.findElement(By.id("toolbar")).getAttribute("id");
        Assert.assertNotNull(navigationMenu);
        System.out.println("The user is on the home page with the Navigation Menu");
        String ActivitiesItem = driver.findElement(By.id("grouptab_3")).getAttribute("id");
        Assert.assertEquals("grouptab_3", ActivitiesItem);
        System.out.println("The item 'Activities' exists in the Menu");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

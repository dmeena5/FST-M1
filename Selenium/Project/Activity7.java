package CRMProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void BeforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://alchemy.hguy.co/crm/");
        System.out.println("The title of the page is: " + driver.getTitle());

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        String navigationMenu = driver.findElement(By.id("toolbar")).getAttribute("id");
        Assert.assertEquals("toolbar", navigationMenu);
        System.out.println("The user is on the home page");
    }
    @Test
    public void AdditionalInfo(){
        //sales selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"grouptab_0\"]")));
        driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]")).click();
        // Leads selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"moduleTab_9_Leads\"]")));
        driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]")).click();
        //Additional Information icon selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"adspan_1bf01e91-1f26-5249-ed14-63294367a7e5\"]/span")));
        driver.findElement(By.xpath("//*[@id=\"adspan_1bf01e91-1f26-5249-ed14-63294367a7e5\"]/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-id-6\"]/div")));
        String additional_details = driver.findElement(By.xpath("//*[@id=\"ui-id-6\"]/div")).getText();
        System.out.println("The header of the additional info popup is: " + additional_details);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-id-5\"]/span")));
        String PhoneNumber = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]/span")).getText();
        System.out.println("Mobile number of the lead is: " + PhoneNumber);

    }
    @AfterTest
    public void afterMethod(){
        driver.quit();
    }

}

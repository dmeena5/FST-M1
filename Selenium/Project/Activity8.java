package CRMProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void BeforeMethod(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        System.out.println("The title of the page is: " + driver.getTitle());

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        String navigationMenu = driver.findElement(By.id("toolbar")).getAttribute("id");
        Assert.assertEquals("toolbar", navigationMenu);
        System.out.println("The user is on the home page");
    }
    @Test
    public void AdditionalInfo() throws InterruptedException{
        //sales selection
        driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]")).click();
        // Accounts selection
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Accounts\"]")).click();
        String validSalesWindow = driver.findElement(By.className("recent_h3")).getText();
        //Assertions
        Assert.assertEquals(validSalesWindow, "Recently Viewed");
        System.out.println("New Window Opened, Confirmation text is :" + validSalesWindow);
        Thread.sleep(2000);
        //Find the table on the page and print the names of the first 5 odd-numbered rows
        //of the table to the console.
        String h2Text = driver.findElement(By.className("module-title-text")).getText();
        System.out.println("header 2 is : " + h2Text);
        for(int i=1;i<=13;i=i+2){
            WebElement rowdata = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]/b"));
            System.out.println(rowdata.getText());}
    }
        @AfterTest
        public void afterMethod(){
            driver.quit();
        }

}

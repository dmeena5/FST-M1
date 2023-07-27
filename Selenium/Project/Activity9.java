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
public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void BeforeMethod() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/crm/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Open the browser to the Alchemy CRM site and login.
        System.out.println("The title of the page is: " + driver.getTitle());

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        //HomePage
        String navigationMenu = driver.findElement(By.id("toolbar")).getAttribute("id");
        Assert.assertEquals("toolbar", navigationMenu);
        System.out.println("The user is on the home page");
    }

    @Test
    public void Traversing_tables() {
        //Navigate to the Sales -> Leads
        //sales selection
        driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]")).click();
        // Leads selection
        driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Leads\"]")).click();
        //Find the table on the page and print the first 10 values in the Name column and
        //the User column of the table to the console
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table")));
        WebElement table = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'list view table')]/tbody/tr"));
        System.out.println("Number of rows: " + rows.size());
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'list view table')]/tbody/tr[1]/td"));
        System.out.println("Number of columns: " + cols.size());
        for (WebElement row : rows) {

            System.out.println(row.getText());}

    }

    @AfterTest
    public void afterMethod() {
        driver.quit();
    }
}

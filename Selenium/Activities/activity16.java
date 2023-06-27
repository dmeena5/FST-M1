import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity16 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
        System.out.println("The title od the page is: " +driver.getTitle());
        //Find the input fields of the Sign Up form.
        WebElement Username = driver.findElement(By.xpath("//input[contains(@class,'-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class,'-password')]"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
        WebElement email = driver.findElement(By.xpath("//input[contains(@class,'email-')]"));

        //Fill in the details in the fields with your own data.
        Username.sendKeys("NewUser");
        password.sendKeys("Password");
        confirmPassword.sendKeys("Password");
        email.sendKeys("real_email@xyz.com");
        //driver.findElement(By.xpath("//button[contains(@class,'ui button')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
        //Wait for success message to appear and print it to the console
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        String login_msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message is: " + login_msg);
        driver.quit();
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity12 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("The title of the page is: " +driver.getTitle());
        //Find the text field , Check if the text field is enabled and print it.
        WebElement textField = driver.findElement(By.id("input-text"));
        System.out.println("The field is enabled: " + textField.isEnabled());
        //Click the "Enable Input" button to enable the input field.
        driver.findElement(By.id("toggleInput")).click();
        //Check if the text field is enabled again and print it.
        System.out.println("The field is enabled: " + textField.isEnabled());
        driver.quit();
    }
}

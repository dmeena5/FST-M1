import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity10 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("The title is: " + driver.getTitle());
        //Find the checkbox input element.
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        WebElement checkbox = driver.findElement(By.id("dynamicCheckbox"));
        //Check if it is visible on the page.
        //Click the "Remove Checkbox" button.
        toggleButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("The Dynamic check box is not available");
        toggleButton.click();
        //Check if it is visible again and print the result.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println("The Dynamic check box is available");
        driver.findElement(By.xpath("//input[@class='willDisappear']")).click();
        //checkbox.click();
        driver.quit();
    }
}

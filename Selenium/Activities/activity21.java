import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity21 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("The title of page is: " + driver.getTitle());
        System.out.println("Current tab: " + driver.getWindowHandle());
        //Find the button to open a new tab and click it.
        driver.findElement(By.id("launcher")).click();
        //Wait for the new tab to open.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //Print all the handles.
        System.out.println("Currently open windows: " + driver.getWindowHandles());
        //Switch to the newly opened tab, print it's title and heading.
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("Page title: " + driver.getTitle());
        String pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);
        // Find and click the button on page to open another tab
        driver.findElement(By.id("actionButton")).click();
        //Repeat the steps by clicking the button in the new tab page.
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        //Print all the handles.
        System.out.println("Currently open windows: " + driver.getWindowHandles());
        //Switch to the newly opened tab, print it's title and heading.
        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        // Print the handle of the current tab
        System.out.println("Current tab: " + driver.getWindowHandle());
        // Print the title and heading of the new page
        System.out.println("Page title: " + driver.getTitle());
        String pageHeading1 = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading1);
        driver.quit();

    }
}

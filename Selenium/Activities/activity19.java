import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity19 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("The title of the page is: " +driver.getTitle());
        //Find the button to open a CONFIRM alert and click it.
        driver.findElement(By.id("confirm")).click();
        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        Alert confirmAlert = driver.switchTo().alert();
        String alertText = confirmAlert.getText();
        System.out.println("The message in the confirmation alert box is: " + alertText);
        //Close the alert once with Ok and again with Cancel.
        confirmAlert.accept();
        System.out.println("The alert is accepted and closed");
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert1 = driver.switchTo().alert();
        String alertText1 = confirmAlert1.getText();
        System.out.println("The message in the confirmation alert box is: " + alertText1);
        confirmAlert1.dismiss();
        System.out.println("The alert is cancelled and closed");
        driver.quit();
    }
}

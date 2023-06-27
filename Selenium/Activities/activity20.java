import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class activity20 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("The title of the page is: " +driver.getTitle());
        //Find the button to open a PROMPT alert and click it.
        driver.findElement(By.id("prompt")).click();
        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        Alert prompt_alert = driver.switchTo().alert();
        System.out.println("The text in the prompt alert box is: " +prompt_alert.getText());
        //Type "Awesome!" into the prompt.
        prompt_alert.sendKeys("Awesome!");
        //Close the alert by clicking Ok
        prompt_alert.accept();
        driver.quit();
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity9 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/ajax");
        System.out.println("The title of the page is: " + driver.getTitle());
        //Find and click the "Change content" button on the page.
        driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/button")).click();
        //Wait for the text to say "HELLO!". Print the message that appears on the page.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajax-content\"]/h1")));
        WebElement messageHello = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h1"));
        System.out.println("The message on the page is: " + messageHello.getText());
        //Wait for the text to change to contain "I'm late!". Print the new message on the page.
        WebElement delayedText = driver.findElement(By.tagName("h3"));
        System.out.println(delayedText.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"ajax-content\"]/h3"),"I'm late!"));
        WebElement messageLate = driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h3"));
        System.out.println("The message on the page is: " + messageLate.getText());
        driver.quit();

    }
}

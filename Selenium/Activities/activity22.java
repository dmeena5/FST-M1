import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity22 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/popups");
        System.out.println("The title of the page is: " +driver.getTitle());
        //Find the Sign in button and hover over it. Print the tooltip message.
        WebElement signIn = driver.findElement(By.className("orange"));
        Actions builder = new Actions(driver);
        builder.moveToElement(signIn).build().perform();
        String tooltipMessage = signIn.getAttribute("data-tooltip");
        System.out.println(tooltipMessage);
        //Click the button to open the Sign in form.
        signIn.click();
        //Enter the credentials
        //username: admin
        //password: password
        //Click login and print the message on the page after logging in.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("admin");
        password.sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String login_msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("The login message is: " +login_msg);
        driver.quit();
    }
}

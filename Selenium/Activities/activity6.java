import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity6 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("The Title of the page is: " + driver.getTitle());
        //Press the key of first letter of your name in caps
        builder.sendKeys("M").build().perform();
        //Press CTRL+a and the CTRL+c to copy all the text on the page.
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("C").keyUp(Keys.CONTROL).build().perform();
        driver.quit();

    }
}

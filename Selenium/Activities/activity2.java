import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity2 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
        System.out.println("The title of the page is: " + driver.getTitle());
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();
        System.out.println("Login is successful");
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message is: " + message);
        driver.quit();
    }
}

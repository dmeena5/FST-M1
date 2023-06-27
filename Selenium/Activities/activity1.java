import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class activity1 {
    public static void main(String[] args){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/");
        System.out.println("The title of the page is: " + driver.getTitle());
        driver.findElement(By.id("about-link")).click();
        System.out.println("The title of the new page is: " + driver.getTitle());
        driver.quit();
    }
}

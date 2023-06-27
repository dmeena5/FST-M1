import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4 {
    public static void main(String[] args){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("The title of the page is: " + driver.getTitle());
        String thirdHeader = driver.findElement(By.xpath("//*[@id='third-header']")).getText();
        System.out.println(thirdHeader);
        String fifthHeader = driver.findElement(By.xpath("//h5[text()='Fifth header']")).getText();
        System.out.println(fifthHeader);
        String violetButton = driver.findElement(By.cssSelector("body > div > div.activity.content > div > div.spaced > div > div > div > div:nth-child(2) > div:nth-child(2) > button.ui.violet.button")).getAttribute("class");
        System.out.println("Classes related to violet button are: " +violetButton);
        String greyButton = driver.findElement(By.className("grey")).getText();
        System.out.println("Text in grey button is " +greyButton);
        driver.quit();
    }
}

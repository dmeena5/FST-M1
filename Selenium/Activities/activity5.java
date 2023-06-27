import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity5 {
    public static void main(String[] args){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("The title of the page is: " + driver.getTitle());
        //Left click and print the value of the side in the front.
        Actions builder = new Actions(driver);
        builder.click().pause(1000).build().perform();
        String frontValue = driver.findElement(By.className("active")).getText();
        System.out.println("The value of the side in the front: " + frontValue);
        //Double click to show a random side and print the number.
        builder.doubleClick().pause(1000).build().perform();
        String randomSide = driver.findElement(By.className("active")).getText();
        System.out.println("The random side displayed contains value: " +randomSide);
        //Right click and print the value shown on the front of the cube.
        builder.contextClick().pause(1000).build().perform();
        String rightClick = driver.findElement(By.className("active")).getText();
        System.out.println("The value shown on the front of the cube: " +rightClick);
        driver.quit();

    }
}

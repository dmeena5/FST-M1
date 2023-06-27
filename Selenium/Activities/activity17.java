import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class activity17 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/selects");
        System.out.println("The title od the page is: " +driver.getTitle());
        //On the Single Select:
        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select singleSelect = new Select(dropdown);
        //Select the second option using the visible text.
        singleSelect.selectByVisibleText("Option 2");
        System.out.println("Second option: " + singleSelect.getFirstSelectedOption().getText());

        //Select the third option using the index.
        singleSelect.selectByIndex(3);
        System.out.println("Third option: " + singleSelect.getFirstSelectedOption().getText());

        //Select the fourth option using the value.
        singleSelect.selectByValue("4");
        System.out.println("Fourth option: " + singleSelect.getFirstSelectedOption().getText());

        //Get all the options and print them to the console.
        List<WebElement> allOptions = singleSelect.getOptions();
        System.out.println("Options in the dropdown: ");
        for(WebElement option: allOptions){
            System.out.println(option.getText());
        }
        driver.quit();

    }
}

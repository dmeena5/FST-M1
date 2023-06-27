import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;

public class activity8 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println("The title is: " + driver.getTitle());
        //Find the checkbox toggle button and click it.
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        toggleButton.click();
        //Wait till the checkbox disappears.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(toggleButton.isDisplayed());
        System.out.println("The text on the togglecheckbox is: " +toggleButton.getText());
        //Click the button again. Wait till it appears and check the checkbox.
        toggleButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(toggleButton.isDisplayed());
        System.out.println("The text on the toggleCheckbox is: " +toggleButton.getText());
        WebElement checkbox = driver.findElement(By.id("dynamicCheckbox"));
        System.out.println("The title of dynamic checkbox is: " +checkbox.getText());
        WebElement select = driver.findElement(By.xpath("//input[@name='toggled']"));
        select.click();
        System.out.println(select.isSelected());
        driver.quit();
    }
}

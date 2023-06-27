import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class activity14 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/tables");
        System.out.println("The title of the page is: " + driver.getTitle());
        //Find the number of rows and columns in the table and print them.
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr"));
        System.out.println("number of rows: " + rows.size());
        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[1]/td"));
        System.out.println("number of rows: " + cols.size());

        //Find and print the cell value at the second row second column.
        WebElement second_row_second_col_value = driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]"));
        System.out.println("The cell value at the second row second column is: " + second_row_second_col_value.getText());
        //Click the header of the first column to sort by name.
        driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/thead/tr/th")).click();
        //Find and print the cell value at the second row second column again.
        WebElement second_row_second_col_value_new = driver.findElement(By.xpath("//table[contains(@class, 'sortable')]/tbody/tr[2]/td[2]"));
        System.out.println("The cell value at the second row second column: " + second_row_second_col_value_new.getText());

        //Print the cell values of the table footer.
        List<WebElement> footer_values = driver.findElements(By.xpath("//table[contains(@class,'sortable')]/tfoot/tr/th"));
        System.out.println("Values in footer are: ");
        for (WebElement cell : footer_values){
            System.out.println("Cell values: " + cell.getText());
        }

        driver.quit();
    }
}

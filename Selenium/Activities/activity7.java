import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity7 {
    public static void main(String[] args) {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("The title is: " +driver.getTitle());
        //Find the ball and simulate a click and drag to move it into "Dropzone 1".
        Actions builder = new Actions(driver);
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropZone1 = driver.findElement(By.id("droppable"));
        builder.click(ball).dragAndDrop(ball,dropZone1).build().perform();
        //Verify that the ball has entered Dropzone 1.
        driver.findElement(By.cssSelector("#draggable")).getCssValue("Color");
        System.out.println("The ball is in Dropzone1");
        //Once verified, move the ball into "Dropzone 2".
        WebElement dropZone2 = driver.findElement(By.id("dropzone2"));
        builder.dragAndDrop(dropZone1, dropZone2).build().perform();
        //Verify that the ball has entered Dropzone 2.
        String check2 = driver.findElement(By.cssSelector("#dropzone2")).getText();
        System.out.println("the text in dropzone2 is: " + check2);
        String text = "Dropzone 2\n" +
                "Dropped!";
        boolean value = check2.contains(text);
        if (value){
            System.out.println("The ball is moved to Dropzone2");}
        driver.quit();
    }
}

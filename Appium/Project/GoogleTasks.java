import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class GoogleTasks {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void TasksTest() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("tasks_fab")));
    driver.findElement(AppiumBy.id("tasks_fab")).click();
    //Complete Activity with Google Tasks
    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
    driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
    driver.findElement(AppiumBy.id("add_task_done")).click();
    // Complete Activity with Google Keep
    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("tasks_fab")));
    driver.findElement(AppiumBy.id("tasks_fab")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
    driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
    driver.findElement(AppiumBy.id("add_task_done")).click();

    //Complete the second Activity Google Keep
    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("tasks_fab")));
    driver.findElement(AppiumBy.id("tasks_fab")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
    driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
    driver.findElement(AppiumBy.id("add_task_done")).click();

    wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView")));
    String Task1 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView")).getText();
    System.out.println(Task1);
    Assert.assertEquals(Task1, "Complete Activity with Google Tasks");
    String Task2 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getAttribute("text");
        System.out.println(Task2);
    Assert.assertEquals(Task2, "Complete Activity with Google Keep");
    String Task3 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getAttribute("text");
        System.out.println(Task3);
    Assert.assertEquals(Task3, "Complete the second Activity Google Keep");

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

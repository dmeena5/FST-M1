package Bonus_Activities;
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
import java.util.List;

public class GoogleKeep {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void KeepTest() {
        //Click the Create New Note button to add a new Note.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("new_note_button")));
        driver.findElement(AppiumBy.id("new_note_button")).click();
        //Add a title for the note and add a small description.
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Reminder Testing");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("edit_note_text")));
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("adding notes to test the reminder");
        //Click the reminder icon on the toolbar to add a reminder for Afternoon of the same day.
        driver.findElement(AppiumBy.id("menu_reminder")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Pick a date & time')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/text")));
        List<WebElement> reminder_list = driver.findElements(AppiumBy.id("com.google.android.keep:id/text"));
        reminder_list.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.keep:id/text")));
        List<WebElement> timeslot = driver.findElements(AppiumBy.id("com.google.android.keep:id/text"));
        timeslot.get(2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Button")));
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Save')]")).click();
        //Press the back button and make an assertion to ensure that the note was added.
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("index_note_title")));
        String reminder = driver.findElement(AppiumBy.id("reminder_chip_text")).getText();
        System.out.println(reminder);
        Assert.assertEquals(reminder,"Today, 6:00 PM");
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}

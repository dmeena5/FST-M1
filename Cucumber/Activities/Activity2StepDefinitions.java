package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.SocketOption;
import java.time.Duration;

public class Activity2StepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void UserOnLoginPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(" https://www.training-support.net/selenium/login-form");
    }
    @When("^User enters username and password")
    public void UserEnterDetails() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    // used for activity4 & 5
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void Details(String username, String password) throws Throwable{
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("^Read the page title and confirmation message$")
    public void GetDetails(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String pageTitle = driver.getTitle();
        String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Title of the Page is: " + pageTitle);
        System.out.println("Confirmation Message is: " + confirmationMessage);
    }
    @And("^Close the Browser$")
    public void closeTheBrowser() throws Throwable {
        driver.quit();
    }
}

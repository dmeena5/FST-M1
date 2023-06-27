package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3StepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @Given("^User is on the page$")
    public void OpenPage(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        }

    @When("^User clicks the Simple Alert button$")
    public void OpenSimpleAlert(){
        driver.findElement(By.cssSelector("#simple")).click();
    }
    @When("^User clicks the Confirm Alert button$")
    public void openConfirmAlert() {
        driver.findElement(By.cssSelector("#confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void openPromptAlert() {
        driver.findElement(By.cssSelector("#prompt")).click();
    }
    @Then("^Alert opens$")
    public void AlertOpens(){
        alert = driver.switchTo().alert();
    }
    @And("^Read the text from it and print it$")
    public void ReadText(){
            System.out.println("The text from the alert is: " + alert.getText());
    }
    @And("^Close the alert$")
    public void CloseAlert(){
        alert.accept();
    }
    @And("^Write a custom message in it$")
    public void CustomMessage(){
        alert.sendKeys("Custom Message");
    }
    @And("^Close the alert with Cancel$")
    public void CancelAlert(){
        alert.dismiss();
    }
    @And("^Read the result text$")
    public void readResult(){
        //String result = driver.findElement(By.id("result")).getText();
        System.out.println("Read the result");
    }
    @And("^Close Browser$")
    public void closeBrowser() {
        driver.quit();
    }

}

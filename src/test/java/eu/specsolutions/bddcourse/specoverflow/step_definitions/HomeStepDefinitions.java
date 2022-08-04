package eu.specsolutions.bddcourse.specoverflow.step_definitions;

//import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class HomeStepDefinitions {

    @Autowired
    private BrowserContext browserContext;


    @Given("the user is logged in")
    public void theUserIsLoggedIn() {

        browserContext.getDriver().get("https://specflowmasterclassspecoverflowweb20220706204956.azurewebsites.net/" + "Login");

        browserContext.getDriver().findElement(By.id("Name")).sendKeys("Marvin");
        browserContext.getDriver().findElement(By.id("Password")).sendKeys("1234");
        browserContext.getDriver().findElement(By.cssSelector("input[type=submit]")).click();



    }

    @When("the user checks the home page")
    public void theUserChecksTheHomePage() {

        browserContext.getBaseUrl();
        browserContext.waitForPageToBeLoaded("Home - Spec Overflow");
        assertEquals("Home - Spec Overflow", browserContext.getDriver().getTitle());
    }

    @Then("the username is shown on home page")
    public void theUsernameIsShownOnHomePage() {

        assertEquals("Marvin",browserContext.getDriver().findElement(By.id("LoggedInUser")).getText());

    }


}

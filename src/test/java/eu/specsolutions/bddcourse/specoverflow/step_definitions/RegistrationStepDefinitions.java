package eu.specsolutions.bddcourse.specoverflow.step_definitions;

import eu.specsolutions.bddcourse.specoverflow.support.BrowserContext;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
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

public class RegistrationStepDefinitions {

    @Autowired
    private BrowserContext browserContext;


    @Given("the user clicks register button")
    public void theUserClicksRegisterButton() {
         browserContext.getDriver().get(browserContext.getBaseUrl()+"Register");
         browserContext.pauseForDebug();
         assertEquals("Register - Spec Overflow",browserContext.getDriver().getTitle());

    }

    @And("populate username {string} and password {string}")
    public void populateUsernameAndPassword(String Username, String Password) {

        browserContext.getDriver().findElement(By.id("UserName")).sendKeys(Username);
        browserContext.getDriver().findElement(By.id("Password")).sendKeys(Password);


    }

    @And("Re-enter password {string}")
    public void reEnterPassword(String ReEnterPassword) {

        browserContext.getDriver().findElement(By.id("PasswordReEnter")).sendKeys(ReEnterPassword);

    }

    @When("the user submits the registration")
    public void theUserSubmitsTheRegistration() {
        browserContext.getDriver().findElement(By.id("RegisterButton")).click();
        browserContext.pauseForDebug();
        browserContext.pauseForDebug();
    }

    @Then("the user is registered successfully")
    public void theUserIsRegisteredSuccessfully() {
        assertEquals("Login - Spec Overflow",browserContext.getDriver().getTitle());
    }



}

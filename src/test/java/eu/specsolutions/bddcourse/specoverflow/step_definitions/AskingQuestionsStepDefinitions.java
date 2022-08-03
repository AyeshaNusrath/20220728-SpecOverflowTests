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

public class AskingQuestionsStepDefinitions {

    @Autowired
    private BrowserContext browserContext;


    @When("the user start entering the question title {string}")
    public void theUserStartEnteringTheQuestionTitle(String PartialQuestion) {
        browserContext.getDriver().get(browserContext.getBaseUrl()+"Ask");
        browserContext.getDriver().findElement(By.id("TitleInput")).sendKeys("What is");
        browserContext.pauseForDebug();
        browserContext.pauseForDebug();


    }

    @Then("the suggestions are shown in Similar questions section")
    public void theSuggestionsAreShownInSimilarQuestionsSection() {
        String similarQuestion = browserContext.getDriver().findElement(By.id("SimilarQuestions")).getText();
        assertEquals(similarQuestion,browserContext.getDriver().findElement(By.id("SimilarQuestions")).getText());


    }




    @When("the user asks the question")
    public void theUserAsksTheQuestion() {

        browserContext.getDriver().get(browserContext.getBaseUrl()+"Ask");
        browserContext.getDriver().findElement(By.id("TitleInput")).sendKeys("What is JUnit?");
        browserContext.getDriver().findElement(By.id("BodyInput")).sendKeys("What is  JUnit? \n" +
                                                                                "I want to learn about JUnit. \n" +
                                                                                "As Junit is the base of Automation testing.");
        browserContext.pauseForDebug();
        browserContext.pauseForDebug();


    }

    @And("the user clicks on Post your question button")
    public void theUserClicksOnPostYourQuestionButton() {

        browserContext.getDriver().findElement(By.id("PostQuestionButton")).click();
        browserContext.pauseForDebug();
    }

    @Then("the question is submitted")
    public void theQuestionIsSubmitted() {

        assertEquals("What is JUnit? - Spec Overflow", browserContext.getDriver().getTitle());
        assertEquals("Marvin",browserContext.getDriver().findElement(By.id("LoggedInUser")).getText());
    }


}

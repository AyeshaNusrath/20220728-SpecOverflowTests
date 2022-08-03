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

public class VotingAnswersStepDefinitions {


    @Autowired
    private BrowserContext browserContext;

    private String voteCount;

    @When("the user gives vote for an answer")
    public void theUserGivesVoteForAnAnswer() {

        browserContext.getDriver().get(browserContext.getBaseUrl()+"Question?id=291edce5-e68b-449b-bbad-fe9eb6d4cd74");
        browserContext.pauseForDebug();
        browserContext.pauseForDebug();
        //browserContext.getDriver().findElement(By.xpath("//a[text()='How to write better BDD scenarios?']")).click();
        //String Question = browserContext.getDriver().findElement(By.partialLinkText("How to write better BDD ")).getText();
        //System.out.println("The question is: %s%n" +Question);
        voteCount = browserContext.getDriver().findElement(By.xpath("//button[@class='vote-up']")).getText();
        browserContext.getDriver().findElement(By.xpath("//button[@class='vote-up']")).click();


    }

    @Then("vote is successfully counted for that answer")
    public void voteIsSuccessfullyCountedForThatAnswer() {

        assertEquals(voteCount,browserContext.getDriver().findElement(By.xpath("//button[@class='vote-up']")).getText());
    }
}

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

        browserContext.getDriver().get(browserContext.getBaseUrl());

        browserContext.pauseForDebug();
        browserContext.pauseForDebug();
        browserContext.getDriver().findElement(By.xpath("//*[@id=\"Questions\"]/li[2]/div/div[4]/div[1]/a")).click();
        voteCount = browserContext.getDriver().findElement(By.xpath("//button[@class='vote-up']")).getText();
        browserContext.getDriver().findElement(By.xpath("//button[@class='vote-up']")).click();


    }

    @Then("vote is successfully counted for that answer")
    public void voteIsSuccessfullyCountedForThatAnswer() {

        assertEquals(voteCount,browserContext.getDriver().findElement(By.xpath("//button[@class='vote-up']")).getText());
        assertEquals("Marvin",browserContext.getDriver().findElement(By.id("LoggedInUser")).getText());
    }
}

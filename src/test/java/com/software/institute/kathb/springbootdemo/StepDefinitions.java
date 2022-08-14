package com.software.institute.kathb.springbootdemo;

import com.software.institute.kathb.springbootdemo.actor.Actor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    private String firstName;
    private String firstNameAnswer;

    private Actor actor;

    @Given("I have an actor with first name set to {string}")
    public void actor_is(String firstName)
    {
        actor = new Actor(firstName, "Smith");
        this.firstName = firstName;
    }

    @When("I get the actor first name")
    public void i_get_actor_first_name()
    {
        firstNameAnswer = actor.getFirstName();
    }

    @When("I set the actor first name to {string}")
    public void i_set_actor_first_name(String firstName)
    {
        actor.setFirstName(firstName);
        this.firstName = firstName;
    }

    @Then("the actor first name returned should be {string}")
    public void first_name_returned(String expectedAnswer)
    {
        assertEquals(expectedAnswer, firstNameAnswer);
    }
}

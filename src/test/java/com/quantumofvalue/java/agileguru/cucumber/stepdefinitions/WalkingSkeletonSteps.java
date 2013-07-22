package com.quantumofvalue.java.agileguru.cucumber.stepdefinitions;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;

import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.PendingException;

public class WalkingSkeletonSteps {
	
	@Resource(name="itemService")
	ItemService itemService;
	
	@Resource(name="databaseCleaner")
	DatabaseCleaner databaseCleaner;
	
	@Before
	public void beforeScenario() {	
		databaseCleaner.truncate();
	}

	@Given("^items \"([^\"]*)\" and \"([^\"]*)\" in the database$")
	public void items_and_in_the_database(String item1, String item2) throws Throwable {
		
		List<Item> items = Arrays.asList(new Item(item1), new Item(item2));
		
		itemService.save(items);
		
		Assert.assertArrayEquals(items.toArray(), itemService.findAll().toArray());
	}

	@When("^I open \"([^\"]*)\" page$")
	public void I_open_page(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I should see \"([^\"]*)\" and \"([^\"]*)\" listed on the page.$")
	public void I_should_see_and_listed_on_the_page(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
}

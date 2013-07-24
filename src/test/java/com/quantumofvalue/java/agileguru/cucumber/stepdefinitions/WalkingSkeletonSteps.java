package com.quantumofvalue.java.agileguru.cucumber.stepdefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import static com.google.common.collect.Lists.transform;
import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalkingSkeletonSteps {
	
	@Resource(name="itemService")
	private ItemService itemService;
	
	@Resource(name="databaseCleaner")
	private DatabaseCleaner databaseCleaner;
	
	private WebDriver driver;
	private static final String baseUrl = "http://localhost:8080";
	
	@Before
	public void beforeScenario() {	
		databaseCleaner.truncate();
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void afterScenario() {
		driver.quit();
	}	

	@Given("^items \"([^\"]*)\" and \"([^\"]*)\" in the database$")
	public void items_and_in_the_database(String item1, String item2) throws Throwable {
		
		List<Item> items = Arrays.asList(new Item(item1), new Item(item2));
		
		itemService.save(items);
		
		Assert.assertArrayEquals(items.toArray(), itemService.findAll().toArray());
	}

	@When("^I open \"([^\"]*)\" page$")
	public void I_open_page(String url) throws Throwable {
		driver.get(baseUrl+url);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("Agile Guru - Items"));
	}

	@Then("^I should see \"([^\"]*)\" and \"([^\"]*)\" listed on the page.$")
	public void I_should_see_and_listed_on_the_page(String item1, String item2) throws Throwable {
		List<WebElement> tdElements = driver.findElements(By.xpath("//td"));
		List<String> stringElements = transform(tdElements, new Function<WebElement,String>() {
			public String apply(WebElement webElement) {
				return webElement.getText();
			}
		});
		Assert.assertArrayEquals(new String[] {item1, item2}, stringElements.toArray());
	}
}

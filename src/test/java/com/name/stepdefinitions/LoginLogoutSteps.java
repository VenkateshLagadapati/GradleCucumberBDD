package com.name.stepdefinitions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;

import com.name.pages.LoginLogoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLogoutSteps  {
	
	Hooks hooks;
	LoginLogoutPage loginLogoutPage;
	WebDriver driver;
	
	@Given("I launch application")
	public void i_launch_application() {
	    hooks = new Hooks();
	    driver = hooks.getDriver();
	    loginLogoutPage = new LoginLogoutPage(driver);
	    loginLogoutPage.launchApplication();
	}

	@When("I login using {string} and {string}")
	public void i_login_using_and(String string1, String string2) {
		loginLogoutPage.loginToApplication(string1,string2);
	}

	@Then("I verify the login is success")
	public void i_verify_the_login_is_success() {
		assertEquals(true, loginLogoutPage.loginStatusCheck());
	}
	
	@Then("I verify the logout is success")
	public void i_verify_the_logout_is_success() {
		assertEquals(true, loginLogoutPage.logoutStatusCheck());
	}

}

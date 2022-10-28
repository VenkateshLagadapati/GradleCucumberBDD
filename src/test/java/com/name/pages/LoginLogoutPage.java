package com.name.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLogoutPage {
	
	WebDriver driver;
	
	public LoginLogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="username")
	WebElement usernameBox;
	
	@FindBy(name="password")
	WebElement passwordBox;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//*[@class='oxd-userdropdown-tab']")
	WebElement userProfileIcon;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutButton;
	
	public void launchApplication() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
	}

	public void loginToApplication(String username, String password) {
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
	}
	
	public boolean loginStatusCheck() {
		boolean isLoginSuccess = userProfileIcon.isDisplayed();
		return isLoginSuccess;
	}
	
	public boolean logoutStatusCheck() {
		userProfileIcon.click();
		logoutButton.click();
		boolean isLogoutSuccess = usernameBox.isDisplayed();
		return isLogoutSuccess;
	}
}

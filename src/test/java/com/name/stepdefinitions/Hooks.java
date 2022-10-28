package com.name.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;
import com.name.utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	ReadConfig readconfig = new ReadConfig();

	public String url = readconfig.getUrl();
	public String browser = readconfig.getBrowserName();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	public static WebDriver driver;

	@Before
	public void setup() {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed() == true) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File sourcePath = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
						System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);
			} catch (IOException e) {
			}
		}
		driver.close();
	}

	public WebDriver getDriver() {
		return driver;
	}
}

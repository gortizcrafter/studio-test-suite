package org.craftercms.studio.test.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {
	WebDriver driver;
	ConstantsPropertiesManager constantsPropertiesManager;

	public void openConnection() {
		constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);
		String webBrowserProperty = constantsPropertiesManager.getSharedExecutionConstants().getProperty("webBrowser");

		if (webBrowserProperty.equalsIgnoreCase("Chrome")) {

			System.setProperty("phantomjs.binary.path",
					constantsPropertiesManager.getSharedExecutionConstants().getProperty("phantomJSExec"));
			driver = new PhantomJSDriver();
		} else if (webBrowserProperty.equalsIgnoreCase("FireFox"))
			driver = new FirefoxDriver();
		else if (webBrowserProperty.equalsIgnoreCase("Safari"))
			driver = new SafariDriver();
		else {
			// if not recognized web browser, it run by default with Firefox                
			driver = new FirefoxDriver();
		}

		driver.get(constantsPropertiesManager.getSharedExecutionConstants().getProperty("baseUrl"));
	}

	public void closeConnection() {   
		this.driver.close();
		this.driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void driverWait() {
		long wait = Long.parseLong(constantsPropertiesManager.getSharedExecutionConstants().getProperty("defaultWaitTime"));
		this.driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		try {
			Thread.sleep(wait);
		} catch (InterruptedException ie1) {
			ie1.printStackTrace();
		}
	}
}

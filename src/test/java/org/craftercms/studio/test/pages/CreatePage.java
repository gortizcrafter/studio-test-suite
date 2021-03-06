package org.craftercms.studio.test.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class CreatePage {

	private WebDriverManager driverManager;
	private WebDriver driver;
	private String siteName;
	private String siteID;
	private String descriptionSite;
	private String blueprintCombo;
	private String plutonBlueprint;
	private String createSiteButton;
	private String cancelButton;
	private String emptyBlueprint;
	private String corporateBlueprint;
	private String AngMemGamBlueprint;
	private String usersOption;
	private String helpOption;
	private String aboutOption;
	private String documentationOption;
	private String adminDropdownOption;
	private String settingsOption;

	/**
	 * 
	 */
	public CreatePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driver = this.driverManager.getDriver();
		siteName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.site_name");
		siteID = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.id_name");
		descriptionSite = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.description_site");
		blueprintCombo = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.blueprint_combo");
		plutonBlueprint = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.pluton_blueprint");
		createSiteButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.create_button");
		cancelButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.cancel_button");
		emptyBlueprint = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.empty_blueprint");
		corporateBlueprint = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.corporate_blueprint");
		AngMemGamBlueprint = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create.ang_mem_gam_blueprint");
		usersOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create.users_option");
		helpOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create_help_option");
		aboutOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create_about_option");
		documentationOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create_documentation_option");
		adminDropdownOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("create_admin_dropdown_option");
		settingsOption = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("create_settings_option");
		
	}

	public CreatePage(WebDriver driver) {

		this.driver = driver;

	}

	// Set site name

	public void setSiteName() {

		WebElement nameNewSite = driver.findElement(By.cssSelector(siteName));
		nameNewSite.sendKeys(RandomStringUtils.randomAlphabetic(5));

	}

	public void fillSiteName() {

		// Set site name

		this.setSiteName();

	}

	// Set site ID

	public void setSiteId(String strSiteID) {

		WebElement idSite = driver.findElement(By.cssSelector(siteID));
		idSite.sendKeys(strSiteID);

	}

	public void fillIdSite(String strSiteID) {

		// Set site ID

		this.setSiteId(strSiteID);

	}

	// Set description

	public void setDescription(String strDescription) {

		WebElement description = driver.findElement(By.cssSelector(descriptionSite));
		description.sendKeys(strDescription);

	}

	public void fillDescription(String strDescription) {

		// Set description

		this.setDescription(strDescription);

	}

	// Open blueprint combo

	public void blueprintCombo() {

		WebElement comboBlueprint = driver.findElement(By.cssSelector(blueprintCombo));
		comboBlueprint.click();

	}

	public void openBlueprintCombo() {

		// Open blueprint combo

		this.blueprintCombo();

	}

	// select blue pluton print

	public void plutonBlueprint() {

		WebElement blueprintPluton = driver.findElement(By.xpath(plutonBlueprint));

		blueprintPluton.click();

	}

	public void selectPlutonBlueprint() {

		// select blue pluton print

		this.plutonBlueprint();

	}

	// select blue empty print

	public void emptyBlueprint() {

		WebElement blueprintEmpty = driver.findElement(By.cssSelector(emptyBlueprint));

		blueprintEmpty.click();

	}

	public void selectEmptyBlueprint() {

		// select blue empty print

		this.emptyBlueprint();

	}

	// select blue corporate print

	public void corporateBlueprint() {

		WebElement blueprintCorporate = driver.findElement(By.xpath(corporateBlueprint));

		blueprintCorporate.click();

	}

	public void selectComporateBlueprint() {

		// select blue corporate print

		this.corporateBlueprint();

	}

	// select blue angular memory game print

	public void angMemGamBlueprint() {

		WebElement blueprintCorporate = driver.findElement(By.xpath(AngMemGamBlueprint));

		blueprintCorporate.click();

	}

	public void selectAngMemGamBlueprint() {

		// select blue angular memory game print

		this.angMemGamBlueprint();

	}

	// Press on create site

	public void createButton() {

		WebElement createButton = driver.findElement(By.cssSelector(createSiteButton));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		createButton.click();

	}

	public void clickOnCreateSiteButton() {

		// Press on create site

		this.createButton();

	}

	// Press on users option

	public void usersOption() {

		WebElement users = driver.findElement(By.xpath(usersOption));
		users.click();

	}

	public void clickOnUsersOption() {

		// Press on users option

		this.usersOption();

	}

	// Press on Cancel button of the create site process.

	public void cancelButton() {

		WebElement createButton = driver.findElement(By.cssSelector(cancelButton));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		createButton.click();

	}

	public void clickOnCancelButtonOfTheCreateSiteProcess() {

		// Press on Cancel button of the create site.

		this.cancelButton();

	}

	// Press on help option

	public void clickHelp() {

		WebElement users = driver.findElement(By.cssSelector(helpOption));
		users.click();

	}

	public void clickOnHelpOption() {

		// Press on help option

		this.clickHelp();

	}

	// Press on about option

	public void clickAbout() {

		WebElement about = driver.findElement(By.cssSelector(aboutOption));
		about.click();

	}

	public void clickOnAboutOption() {

		// Press on about option

		this.clickAbout();

	}

	// Press on documentation option

	public void clickDocumentation() {

		WebElement documentation = driver.findElement(By.cssSelector(documentationOption));
		documentation.click();

	}

	public void clickOnDocumentationOption() {

		// Press on documentation option

		this.clickDocumentation();

	}
	
	// Press on admin option

	public void clickAdmin() {

		WebElement admin = driver.findElement(By.cssSelector(adminDropdownOption)); 
		admin.click();

	}

	public void clickOnAdminOption() {

		// Press on admin option

		this.clickAdmin();

	}
	

	// Press on settings option

	public void clickSettings() {

		WebElement settings = driver.findElement(By.cssSelector(settingsOption));
		settings.click();

	}

	public void clickOnSettingsOption() {

		// Press on settings option

		this.clickSettings();

	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	public void setDriverManager(WebDriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
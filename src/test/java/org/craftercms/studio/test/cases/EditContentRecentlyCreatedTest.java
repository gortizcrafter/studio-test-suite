package org.craftercms.studio.test.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.craftercms.studio.test.pages.AdminConsolePage;
import org.craftercms.studio.test.pages.DashboardPage;
import org.craftercms.studio.test.pages.HomePage;
import org.craftercms.studio.test.pages.LoginPage;
import org.craftercms.studio.test.utils.FilesLocations;
import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;

/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class EditContentRecentlyCreatedTest {

	private WebDriverManager driverManager;

	private LoginPage loginPage;

	private HomePage homePage;

	private DashboardPage dashboardPage;

	private AdminConsolePage adminConsolePage;

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		UIElementsPropertiesManager uIElementsPropertiesManager = new UIElementsPropertiesManager(
				FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.loginPage = new LoginPage(driverManager, uIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, uIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, uIElementsPropertiesManager);
		this.adminConsolePage = new AdminConsolePage(driverManager, uIElementsPropertiesManager);

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}

	public void bodyNotRequiered() {
		// go to admin console page

		driverManager.getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// select content types
		adminConsolePage.selectContentTypeOption();

		// open content types

		adminConsolePage.clickExistingTypeOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select the Entry content type

		adminConsolePage.selectEntryContentType();

		// Confirm the content type selected

		adminConsolePage.confirmContentTypeSelected();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// select main content

		driverManager.getDriver().findElement(By.cssSelector("#yui-gen8")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Body not required

		driverManager.getDriver()
				.findElement(By.cssSelector("div.property-wrapper:nth-child(21) > div:nth-child(2) > input")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save

		adminConsolePage.saveDragAndDropProcess();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

	}

	public void createNewContent() {

		// right click to see the the menu

		dashboardPage.rightClickToSeeMenu();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Select Entry Content Type

		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected

		dashboardPage.clickOKButton();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Set basics fields of the new content created

		dashboardPage.setBasicFieldsOfNewContent("Test1", "Testing1");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Expand all fields

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// Set Main Content

		// dashboardPage.setMetadataFields("title", "keywords");

		// Set the title of main content

		driverManager.getDriver().findElement(By.cssSelector("#title > div > input")).sendKeys("MainTitle");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save and close

		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();
	}

	public void editingContentRecentlyCreated() {

		// right click to see the menu and edit

		dashboardPage.rightClickToSelectEditOption();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo()
				.frame(driverManager.getDriver().findElement(By.cssSelector(".studio-ice-dialog > .bd iframe")));

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// edit internal title

		driverManager.getDriver().findElement(By.cssSelector("#internal-name > div > input")).sendKeys("EDITED");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Expand all fields

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-form-expand-all")).click();

		// Set Main Content

		// dashboardPage.setMetadataFields("EditedTitle", "EditedKeywords");

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// save and close

		driverManager.getDriver().findElement(By.id("cstudioSaveAndClose")).click();

		// Switch back to the dashboard page

		driverManager.getDriver().switchTo().defaultContent();

	}

	@Test(priority = 0)

	public void editContentRecentlyCreated() {

		// login to application

		loginPage.loginToCrafter("admin", "admin");

		// MaximizeWindow
		driverManager.maximizeWindow();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// go to preview page
		homePage.goToPreviewPage();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// Show site content panel
		driverManager.getDriver().findElement(By.xpath("/html/body/div[2]/div[1]/nav/div/div[2]/ul[1]/li/div/div[1]/a"))
				.click();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Body not requiered

		bodyNotRequiered();

		// go to dashboard

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

		// expand pages folder

		dashboardPage.expandPagesTree();

		// create new content

		createNewContent();

		// Expand Home Tree

		dashboardPage.expandHomeTree2();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// reload page

		driverManager.getDriver().navigate().refresh();

		// wait for element is clickeable

		homePage.getDriverManager().driverWait();

		// Edited content recently created

		editingContentRecentlyCreated();
		
		// reload page

		driverManager.getDriver().navigate().refresh();

		// Assert find the new content created edited

		String contentEdited = driverManager.getDriver().findElement(By.cssSelector("#ygtvlabelel3")).getText();
		Assert.assertEquals(contentEdited, "Testing1EDITED");

	}

}

package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * 
 * @author Gustavo Andrei Ortiz Alfaro 
 *
 */

public class AdminConsolePage {

	private WebDriverManager driverManager;
    private WebDriver driver;
    private String contentTypeOption;
    private String openExistingTypeOption;
    private String genericContentTypeOption;
    private String okButton;
    private String saveButton;
    private String genericTitle;
    private String displayTemplateField;
    private String editFTLOption;
    private String inputTitle;
    private String inputIceGroup;
    private String inputDescription;
    private String inputDefaultValue;
    private String clickOnInputSection;
    /**
     * 
     */
    public AdminConsolePage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
        this.driverManager = driverManager;
        this.driver = this.driverManager.getDriver();
        contentTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.content_type_option");
        openExistingTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.open_Existing_Type_Option");
        genericContentTypeOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.generic_Content_Type_Option");
        okButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.ok_Button");
        saveButton = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.save_Button");
        genericTitle = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.generic_title");
        displayTemplateField = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.display_Template_Field");
        editFTLOption = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.edit_FTL_Option");
        inputTitle = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Title");
        inputIceGroup = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Ice_Group");
        inputDescription = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Description");
        inputDefaultValue = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.input_Default_Value");
        clickOnInputSection = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("adminconsole.click_On_Input_Section");
    }
	public AdminConsolePage(WebDriver driver) {

		this.driver = driver;

	}

	// Click on Content Type option

	public void clickContentTypeOption() {

		 WebElement contentTypeOpt = driver.findElement(By.xpath(contentTypeOption));
		 contentTypeOpt.click();

	}

	public void selectContentTypeOption() {

		// Click on Content Type option

		this.clickContentTypeOption();

	}

	// Click on open existing Type option

	public void clickOpenExistingTypeOption() {

		WebElement openExistingTypeOpt = driver.findElement(By.id(openExistingTypeOption));
		openExistingTypeOpt.click();

	}

	public void clickExistingTypeOption() {

		// Click on open existing Type option

		this.clickOpenExistingTypeOption();

	}

	// Select the generic content type

	public void selectContentType() {

		WebElement selectGenericOption = driver.findElement(By.cssSelector(genericContentTypeOption));
		selectGenericOption.click();

	}

	public void selectEntryContentType() {

		// Select the generic content type

		this.selectContentType();

	}

	// Confirm the content type selected

	public void okContentTypeSelected() {

		WebElement okButtonOpt = driver.findElement(By.id(okButton));
		okButtonOpt.click();

	}

	public void confirmContentTypeSelected() {

		// Confirm the content type selected

		this.okContentTypeSelected();

	}

	// Save the section dropped.

	public void saveSectionDropped() {

		WebElement okButtonOpt = driver.findElement(By.xpath(saveButton));
		okButtonOpt.click();

	}

	public void saveDragAndDropProcess() {

		// Save the section dropped.

		this.saveSectionDropped();

	}

	// Click on generic title to edit the context type selected.

	public void clickOnGenericTitle() {

		WebElement ClickTitle = driver.findElement(By.cssSelector(genericTitle));
		ClickTitle.click();

	}

	public void doClickOnGenericTitle() {

		// Click on generic title to edit the context type selected.

		this.clickOnGenericTitle();

	}

	// Click on display template field.

	public void clickOnDisplayTemplateField() {

		WebElement showTemplate = driver.findElement(By.cssSelector(displayTemplateField));
		showTemplate.click();

	}

	public void doClickOnDisplayTemplateField() {

		// Click on display template field.

		this.clickOnDisplayTemplateField();

	}

	// Edit ftl option

	public void clickOnEditFTLOption() {

		WebElement editFLTopt = driver.findElement(By.cssSelector(editFTLOption));
		editFLTopt.click();

	}

	public void doClickOnEditFTLOption() {

		// Edit ftl option

		this.clickOnEditFTLOption();

	}

	// Set title

	public void setTitle(String strTitle) {

		WebElement typeTitle = driver.findElement(By.cssSelector(inputTitle));
		typeTitle.sendKeys(strTitle);

	}

	// Set ICE group

	public void setIceGroup(String strICEGroup) {

		WebElement typeIceGroup = driver.findElement(By.cssSelector(inputIceGroup));
		typeIceGroup.sendKeys(strICEGroup);

	}

	// Set description

	public void setDescription(String strDescription) {

		WebElement typeDescription = driver.findElement(By.cssSelector(inputDescription));
		typeDescription.sendKeys(strDescription);

	}

	// Set default value

	public void setDefaultValue(String strDefaultValue) {

		WebElement typeDefaultValue = driver.findElement(By.cssSelector(inputDefaultValue));
		typeDefaultValue.sendKeys(strDefaultValue);

	}
	
	// Complete input fields basics
	
	public void completeInputFieldsBasics(String strTitle, String strICEGroup, String strDescription, String strDefaultValue) {

		// Fill title

		this.setTitle(strTitle);

		// Fill Ice group

		this.setIceGroup(strICEGroup);

		// Fill description
		
		this.setDescription(strDescription);
		
		// Fill default value
		
		this.setDefaultValue(strDefaultValue);

	}
	
	// Click on input section to can view the properties 

	public void clickOnInputSectionToViewTheProperties() {

		WebElement showInputSection = driver.findElement(By.cssSelector(clickOnInputSection));
		showInputSection.click();

	}

	public void clickInputSection() {

		// Confirm the content type selected

		this.clickOnInputSectionToViewTheProperties();

	}
}
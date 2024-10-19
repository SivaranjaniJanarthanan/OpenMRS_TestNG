package com.pageobjectmodeltestng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclasstenstng.BaseClassTestNG;
import com.excelutilitytestng.ExcelUtilityTestNG;
import com.interfaceelementtestng.OpenMRSElementTestNG;
import com.propertytestng.FileReaderManagerMRSTestNG;

public class OpenMRSStartVisitTestNG extends BaseClassTestNG implements OpenMRSElementTestNG {

	@FindBy(xpath = startvist_xpath)
	private WebElement start_visit;

	@FindBy(id = confirmstartvisit_id)
	private WebElement confirm_visit;

	@FindBy(xpath = attachment_xpath)
	private WebElement attachment;

	@FindBy(xpath = attachment_caption_xpath)
	private WebElement attachment_caption;
	
	@FindBy(xpath = upload_button_xpath)
	private WebElement uploadbutton;
	
	@FindBy(xpath = patient_detial_xpath)
	private WebElement patient_detial;

	public OpenMRSStartVisitTestNG(WebDriver driver) { // Change to Constructor
		PageFactory.initElements(driver, this); // POM class methods initialized
	}

	public void validStartVisitPage() throws Throwable {

		FileReaderManagerMRSTestNG data = new FileReaderManagerMRSTestNG();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		start_visit.click();

		confirm_visit.click();

		attachment.click();

		String filePath = "D:\\IPT Premium\\Amazon_RTM.xlsx"; // Dynamic file path
		String uploadButtonXPath = "//div[text()='Click or drop a file here.']"; // Dynamic XPath for the upload button

		fileUpload(driver, filePath, uploadButtonXPath);

		String attachment_caption_xpath = ExcelUtilityTestNG.getCellValue("data", "user1", "Attachment Caption");
		passInput(attachment_caption, attachment_caption_xpath);
		
		uploadbutton.click();
		
		patient_detial.click();

	}

}

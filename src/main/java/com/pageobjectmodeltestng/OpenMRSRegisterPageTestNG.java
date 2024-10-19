package com.pageobjectmodeltestng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.baseclasstenstng.BaseClassTestNG;
import com.excelutilitytestng.ExcelUtilityTestNG;
import com.interfaceelementtestng.OpenMRSElementTestNG;
import com.propertytestng.FileReaderManagerMRSTestNG;

public class OpenMRSRegisterPageTestNG extends BaseClassTestNG implements OpenMRSElementTestNG {

	@FindBy(xpath = register_xpath)
	private WebElement register;

	@FindBy(name = patient_name)
	private WebElement p_name;

	@FindBy(name = middle_name)
	private WebElement m_name;

	@FindBy(name = family_name)
	private WebElement f_name;

	@FindBy(xpath = next_xpath)
	private WebElement next_button;

	@FindBy(id = gender_id)
	private WebElement gender;

	@FindBy(name = day_name)
	private WebElement date;

	@FindBy(name = month_name)
	private WebElement month;

	@FindBy(name = year_name)
	private WebElement year;

	@FindBy(id = address_id)
	private WebElement address;
	
	@FindBy(id = address2_id)
	private WebElement address2;
	
	@FindBy(id = city_id)
	private WebElement city;
	
	@FindBy(name = phoneno_name)
	private WebElement phoneno;
	
	@FindBy(name = relationship_name)
	private WebElement relationship;
	
	@FindBy(xpath = personname_xpath)
	private WebElement personname;
	
	@FindBy(id = submitbutton_id)
	private WebElement submit_button;
	

	public OpenMRSRegisterPageTestNG(WebDriver driver) { // Change to Constructor
		PageFactory.initElements(driver, this); // POM class methods initialized
	}

	public void validRegister() throws Throwable {
		// Scenario 2

		FileReaderManagerMRSTestNG data = new FileReaderManagerMRSTestNG();

		elementClick(register);

		String patient_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Patient_name");
		passInput(p_name, patient_name);

		String middle_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Patient_Middle_name");
		passInput(m_name, middle_name);

		String family_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Patient_Family_name");
		passInput(f_name, family_name);

		elementClick(next_button);

		//String gender_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Patient_gender");
		// passInput(date, day_name);
		selectByVisibleText(gender, "Male");

		elementClick(next_button);

		String day_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Patient_birthDay");
		passInput(date, day_name);

		//String month_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Patient_birthMonth");
		// passInput(month, month_name);
		selectByVisibleText(month, "March");

		String year_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Patient_birthYear");
		passInput(year, year_name);

		elementClick(next_button);

		String address_id = ExcelUtilityTestNG.getCellValue("data", "user1", "Address_1");
		passInput(address, address_id);

		String address2_id = ExcelUtilityTestNG.getCellValue("data", "user1", "Address_2");
		passInput(address2, address2_id);
		
		String city_id = ExcelUtilityTestNG.getCellValue("data", "user1", "City/Village");
		passInput(city, city_id);
		
		elementClick(next_button);
		
		String phoneno_name = ExcelUtilityTestNG.getCellValue("data", "user1", "Phone no");
		passInput(phoneno, phoneno_name);
		
		elementClick(next_button);
		
		selectByIndex(relationship, 2);
		
		String personname_xpath = ExcelUtilityTestNG.getCellValue("data", "user1", "Person Name");
		passInput(personname, personname_xpath);
		
		elementClick(next_button);
		
		elementClick(submit_button);
		
		
	}
}

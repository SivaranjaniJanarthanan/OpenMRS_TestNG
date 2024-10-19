package com.interfaceelementtestng;

public interface OpenMRSElementTestNG {
	
	//Scenario 1 --> Login
	
		String userName_id = "username";
		String password_id = "password";
		String location_id = "Inpatient Ward";
		String login_id = "loginButton";
		
		//Scenario 2 -->  Register
		
		String register_xpath = "//a[text()[normalize-space()='Register a patient']]";
		
		//Excel Data
		String patient_name = "givenName";
		String middle_name = "middleName";
		String family_name = "familyName";
		
		String next_xpath = "//button[@class='confirm right']";
		
		String gender_id = "gender-field";
		String day_name = "birthdateDay";
		String month_name = "birthdateMonth";
		String year_name = "birthdateYear";
		String address_id = "address1";
		String address2_id = "address2";
		String city_id = "cityVillage";
		String phoneno_name = "phoneNumber";
		String relationship_name = "relationship_type";
		String personname_xpath = "//input[@placeholder='Person Name']";
		String submitbutton_id = "submit";
		
		//Start Visit
		String startvist_xpath = "(//div[@class='col-11 col-lg-10'])[1]";
		
		String confirmstartvisit_id = "start-visit-with-visittype-confirm";
		
		String attachment_xpath = "(//a[@class='button task activelist'])[5]";
		
		String attachment_caption_xpath = "//textarea[@placeholder='Enter a caption']";
		
		String upload_button_xpath = "//button[@class='confirm ng-binding']";
		
		String patient_detial_xpath = "//li[normalize-space()='Simbhu M Dhanush']";
		
		//End Visit
		
		String endvisit_xpath = "(//div[@class='col-11 col-lg-10'])[1]";
		

}

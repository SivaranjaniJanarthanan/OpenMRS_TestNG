package com.pageobjectmanagertestng;

import com.baseclasstenstng.BaseClassTestNG;
import com.pageobjectmodeltestng.OpenMRSEndVisitTestNG;
import com.pageobjectmodeltestng.OpenMRSLoginPageTestNG;
import com.pageobjectmodeltestng.OpenMRSRegisterPageTestNG;
import com.pageobjectmodeltestng.OpenMRSStartVisitTestNG;
import com.propertytestng.FileReaderManagerMRSTestNG;

public class PageObjectManagerMRSTestNG extends BaseClassTestNG {
	
	private OpenMRSLoginPageTestNG loginPage;
	private OpenMRSRegisterPageTestNG registerPage;
	private OpenMRSStartVisitTestNG startPage;
	private OpenMRSEndVisitTestNG endPage;
	private FileReaderManagerMRSTestNG fileReader;
	
	
	public OpenMRSLoginPageTestNG getLoginPage() {
		if (loginPage == null) {
			loginPage = new OpenMRSLoginPageTestNG(driver);
		}
		return loginPage;
	}
	
	public OpenMRSRegisterPageTestNG getRegisterPage() {
		if (registerPage == null) {
			registerPage = new OpenMRSRegisterPageTestNG(driver);
		}
		return registerPage;
	}
	
	public OpenMRSStartVisitTestNG getStartVisitPage() { 
		if (startPage == null) {
			startPage = new OpenMRSStartVisitTestNG(driver);
		}
		return startPage;

	}
	
	public OpenMRSEndVisitTestNG getEndVisitPage() { 
		if (endPage == null) {
			endPage = new OpenMRSEndVisitTestNG(driver);
		}
		return endPage;

	}
	
	public FileReaderManagerMRSTestNG getFileReader() { // FileReaderManager
		if (fileReader == null) {
			fileReader = new FileReaderManagerMRSTestNG();
		}
		return fileReader;

	}

}

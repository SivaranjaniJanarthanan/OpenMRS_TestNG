package com.runnertestng;

import com.baseclasstenstng.BaseClassTestNG;
import com.pageobjectmanagertestng.PageObjectManagerMRSTestNG;

public class OpenMRSTestNGRunner extends BaseClassTestNG {

	public static void main(String[] args) throws Throwable {
		PageObjectManagerMRSTestNG pageObjectManager = new PageObjectManagerMRSTestNG();
		launchBrowser(pageObjectManager.getFileReader().getDataProperty("browser"));
		launchUrl(pageObjectManager.getFileReader().getDataProperty("url"));
		pageObjectManager.getLoginPage().validLogin();
		pageObjectManager.getRegisterPage().validRegister();
		pageObjectManager.getStartVisitPage().validStartVisitPage();

	}

}

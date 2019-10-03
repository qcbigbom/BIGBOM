package com.bigbom.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bigbom.ui.DashboardPageUI;
import com.bigbom.ui.LoginPageUI;

import CommonPage.commonFunction;

public class DashboardPage extends commonFunction {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public void clearByJs(String value) {
		executeScriptBrowser(value);
	}

	public void inputEmailLogin(String value) {
		waitVisible(LoginPageUI.LOGIN_EMAIL_TXT);
		clear(LoginPageUI.LOGIN_EMAIL_TXT);
		input(LoginPageUI.LOGIN_EMAIL_TXT, value);
	}

	public AnalysisPage clickLinkAnalytics() {
		waitVisible(DashboardPageUI.ANALYSTICS_LINK);
		click(DashboardPageUI.ANALYSTICS_LINK);
		return PageFactory.initElements(driver, AnalysisPage.class);

	}

	public void hoverCampaignNameTestAuto() {
		waitVisible(DashboardPageUI.CAMPAIGNNAME_LINK);
		hover(DashboardPageUI.CAMPAIGNNAME_LINK);
	}

}

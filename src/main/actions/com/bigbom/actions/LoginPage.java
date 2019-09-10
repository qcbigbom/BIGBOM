package com.bigbom.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bigbom.ui.HomePageUI;
import com.bigbom.ui.LoginPageUI;

import CommonPage.commonFunction;

public class LoginPage extends commonFunction {

    public LoginPage(WebDriver driver) {
		super(driver);
	}
    public void clearByJs(String value)
	{
		executeScriptBrowser(value);
	}
	public LoginPage clickdangnhap() {
		waitVisible(HomePageUI.DANGNHAP_TXT);
		click(HomePageUI.DANGNHAP_TXT);
		return PageFactory.initElements(driver, LoginPage.class);
	}

//	private  void ctrlAEmail() {
//		waitVisible(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT);
//		(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT).sendKey(Keys.CONTROL + "a");
//		
//	}


	public void clearEmailorSdt() {
		waitVisible(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT);
		clear(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT);

	}
	

	public void inputEmailorSdt(String value) {
		waitVisible(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT);
		input(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT, value);

	}

	public void clearMatkhau() {
		waitVisible(LoginPageUI.MATKHAU_DANGNHAP_TXT);
		clear(LoginPageUI.MATKHAU_DANGNHAP_TXT);
	}

	public void iputMatkhau(String value) {
		waitVisible(LoginPageUI.MATKHAU_DANGNHAP_TXT);
		input(LoginPageUI.MATKHAU_DANGNHAP_TXT, value);
	}

	public HomePage clickbuttonDangnhap() {
		waitVisible(LoginPageUI.DANGNHAP_LOGIN_BTN);
		click(LoginPageUI.DANGNHAP_LOGIN_BTN);
		return PageFactory.initElements(driver, HomePage.class);

	}

	public String getDynamicText(String value) {
		waitVisibleDynamicElement(LoginPageUI.DYNAMIC_MSG, value);
		return getTextDynamicElement(LoginPageUI.DYNAMIC_MSG, value);
	}
	public String getTextUserName(){
		waitVisible(LoginPageUI.USERNAME_LBL);
		return getText(LoginPageUI.USERNAME_LBL);
	}


}

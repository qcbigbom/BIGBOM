package com.bigbom.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bigbom.ui.LoginPageUI;
import com.bigbom.ui.LogoutPageUI;
import com.bigbom.ui.SignupPageUI;

import CommonPage.commonFunction;

public class LoginPage extends commonFunction {

	public LoginPage(WebDriver driver) {
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

	public void hoverToolTipEmail() {
		waitVisible(LoginPageUI.TOOLTIPEMAI_BTN);
		hover(LoginPageUI.TOOLTIPEMAI_BTN);
	}

	public void inputPasswordLogin(String value) {
		waitVisible(LoginPageUI.LOGIN_PASSWORD_TXT);
		clear(LoginPageUI.LOGIN_PASSWORD_TXT);
		input(LoginPageUI.LOGIN_PASSWORD_TXT, value);
	}

	public void hoverToolTipPassword() {
		waitVisible(LoginPageUI.TOOLTIPPASSWORD_BTN);
		hover(LoginPageUI.TOOLTIPPASSWORD_BTN);
	}

	public LoginPage clickButtonSignIn() {
		waitVisible(LoginPageUI.LOGIN_BTN);
		click(LoginPageUI.LOGIN_BTN);
		return PageFactory.initElements(driver, LoginPage.class);

	}

	public void clickButtonClose() {
		waitVisible(LoginPageUI.CLOSE_BTN);
		click(LoginPageUI.CLOSE_BTN);

	}

	public void clickForgotPassLink() {
		waitVisible(LoginPageUI.LOGIN_FORGOTPASSWORD_LINK);
		click(LoginPageUI.LOGIN_FORGOTPASSWORD_LINK);
//		return PageFactory.initElements(driver, LoginPage.class);

	}

	public void clickIconGG() {
		waitVisible(LoginPageUI.LOGIN_LOGO_GG);
		click(LoginPageUI.LOGIN_LOGO_GG);

	}

	public void clickFBIcon() {
		waitVisible(LoginPageUI.LOGIN_LOGO_FB);
		click(LoginPageUI.LOGIN_LOGO_FB);

	}

//	public String errorMessenger() {
//		// waitVisible(LoginPageUI.LOGIN_WARNING_MSG);
//		WebElement e = driver.findElement(By.xpath(LoginPageUI.LOGIN_WARNING_MSG));
//		String text = e.getText();
//		return text;
//
//	}

	public String getDynamicText(String value) {
		waitVisibleDynamicElement(SignupPageUI.DYNAMIC_MSG, value);
		return getTextDynamicElement(SignupPageUI.DYNAMIC_MSG, value);
	}

	public String getHTML5ValidationMessage(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}

	// Login by FB
//	public void clearEmailFB() {
//		waitVisible(LoginPageUI.LOGIN_EMAIL_FB_TXT);
//		clear(LoginPageUI.LOGIN_EMAIL_FB_TXT);
//
//	}

	public void inputEmailFB(String value) {
		waitVisible(LoginPageUI.LOGIN_EMAIL_FB_TXT);
		clear(LoginPageUI.LOGIN_EMAIL_FB_TXT);
		input(LoginPageUI.LOGIN_EMAIL_FB_TXT, value);

	}

//	public void clearPASSWORDFB() {
//		waitVisible(LoginPageUI.LOGIN_PASSWORD_FB_TXT);
//		clear(LoginPageUI.LOGIN_PASSWORD_FB_TXT);
//	}

	public void inputPasswordFB(String value) {
		waitVisible(LoginPageUI.LOGIN_PASSWORD_FB_TXT);
		clear(LoginPageUI.LOGIN_PASSWORD_FB_TXT);
		input(LoginPageUI.LOGIN_PASSWORD_FB_TXT, value);
	}

//input email password đăng nhập FB
	public LoginPage clickButtonLoginFB() {
		waitVisible(LoginPageUI.LOGIN_FB_BTN);
		click(LoginPageUI.LOGIN_FB_BTN);
		return PageFactory.initElements(driver, LoginPage.class);

	}

	public LoginPage clickAccept_FB() {
		waitVisible(LoginPageUI.LOGIN_FB_BTN_CONFIRM);
		click(LoginPageUI.LOGIN_FB_BTN_CONFIRM);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	// confirm page
	public String verifyEmailPageTitle() {
		waitVisible(LoginPageUI.VERIFYEMAIL_TITLE);
		WebElement e = driver.findElement(By.xpath(LoginPageUI.VERIFYEMAIL_TITLE));
		String text = e.getText();
		return text;

	}

	public LoginPage click_verifyEmailPage() {
		waitVisible(LoginPageUI.VERIFYEMAIL_BTN);
		click(LoginPageUI.VERIFYEMAIL_BTN);
		return PageFactory.initElements(driver, LoginPage.class);

	}

	public LoginPage Logout() {
		waitVisible(LogoutPageUI.LOGOUT_INFOMENU);
		click(LogoutPageUI.LOGOUT_INFOMENU);
		waitVisible(LogoutPageUI.LOGOUT_MENU_DDL);
		click(LogoutPageUI.LOGOUT_MENU_LOGOUT_ITEM);
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public LoginPage clickLogout() {
		waitVisible(SignupPageUI.USER_LBN);
		click(SignupPageUI.USER_LBN);
		waitVisible(SignupPageUI.LOGOUT_BTN);
		click(SignupPageUI.LOGOUT_BTN);
		return PageFactory.initElements(driver, LoginPage.class);
	}
}

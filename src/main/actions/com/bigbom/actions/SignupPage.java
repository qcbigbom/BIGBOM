package com.bigbom.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.bigbom.ui.SignupPageUI;

import CommonPage.commonFunction;

public class SignupPage extends commonFunction {

	public SignupPage(WebDriver driver) {
		super(driver);
	}

	public void clearByJs(String value) {
		executeScriptBrowser(value);
	}

//	public SignupPage clickdangnhap() {
//		waitVisible(HomePageUI.DANGNHAP_TXT);
//		click(HomePageUI.DANGNHAP_TXT);
//		return PageFactory.initElements(driver, SignupPage.class);
//	}

//	private  void ctrlAEmail() {
//		waitVisible(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT);
//		(LoginPageUI.MOBILEOREMAIL_DANGNHAP_TXT).sendKey(Keys.CONTROL + "a");
//		
//	}

	public void iputDisplayName(String value) {
		waitVisible(SignupPageUI.DISPLAYNAME_SIGNUP_TXT);
		clear(SignupPageUI.DISPLAYNAME_SIGNUP_TXT);
		input(SignupPageUI.DISPLAYNAME_SIGNUP_TXT, value);
	}

	public void inputEmail(String value) {
		waitVisible(SignupPageUI.EMAIL_SIGNUP_TXT);
		clear(SignupPageUI.EMAIL_SIGNUP_TXT);
		input(SignupPageUI.EMAIL_SIGNUP_TXT, value);

	}

	public void clickTooltipEmail() {
		waitVisible(SignupPageUI.TOOLTIPEMAIL_SIGNUP_BTN);
		click(SignupPageUI.TOOLTIPEMAIL_SIGNUP_BTN);

	}

	public void hoverTooltipEmail() {
		waitVisible(SignupPageUI.TOOLTIPEMAIL_SIGNUP_BTN);
		hover(SignupPageUI.TOOLTIPEMAIL_SIGNUP_BTN);
	}

	public String getTextEmailInvalidMsg() {
		waitVisible(SignupPageUI.EMAILINVALID_MSG);
		return getText(SignupPageUI.EMAILINVALID_MSG);
	}

	public void hoverTooltipPassword() {
		waitVisible(SignupPageUI.TOOLTIPPASSWORD_SIGNUP_BTN);
		hover(SignupPageUI.TOOLTIPPASSWORD_SIGNUP_BTN);
	}

	public void iputPassword(String value) {
		waitVisible(SignupPageUI.PASSWORD_TXT);
		clear(SignupPageUI.PASSWORD_TXT);
		input(SignupPageUI.PASSWORD_TXT, value);
	}

	public void hoverTooltipPhone() {
		waitVisible(SignupPageUI.TOOLTIPPASSWORD_SIGNUP_BTN);
		hover(SignupPageUI.TOOLTIPPASSWORD_SIGNUP_BTN);
	}

	public void iputPhone(String value) {
		waitVisible(SignupPageUI.NUMBERPHONE_TXT);
		clear(SignupPageUI.NUMBERPHONE_TXT);
		input(SignupPageUI.NUMBERPHONE_TXT, value);
	}

	public HomePage clickbuttonSignup() {
		waitVisible(SignupPageUI.SIGNUP_BTN);
		click(SignupPageUI.SIGNUP_BTN);
		return PageFactory.initElements(driver, HomePage.class);

	}

	public void iputOTP(String value) {
		waitVisible(SignupPageUI.OTP_TXT);
		clear(SignupPageUI.OTP_TXT);
		input(SignupPageUI.OTP_TXT, value);
	}

	public void hoverTooltipOTP() {
		waitVisible(SignupPageUI.TOOLTIPOTP_VERIFY_BTN);
		hover(SignupPageUI.TOOLTIPOTP_VERIFY_BTN);
	}

	public void clickButtonSubmit() {
		waitVisible(SignupPageUI.SUBMIT_BTN);
		click(SignupPageUI.SUBMIT_BTN);
	}

	public void inputEmailYopmail(String value) {
		waitVisible(SignupPageUI.EMAILYOPMAIL_TXT);
		clear(SignupPageUI.EMAILYOPMAIL_TXT);
		input(SignupPageUI.EMAILYOPMAIL_TXT, value);
	}

	public void clickButtonResend() {
		waitVisible(SignupPageUI.RESEND_BTN);
		click(SignupPageUI.RESEND_BTN);

	}

	public void clickButtonCheckEmailYopmail() {
		waitVisible(SignupPageUI.CHECKEMAILYOPMAIL_BTN);
		click(SignupPageUI.CHECKEMAILYOPMAIL_BTN);

	}

	public String getextOTP() {
		waitVisible(SignupPageUI.OTP_LBN);
		return getText(SignupPageUI.OTP_LBN);
	}

	public String getDynamicText(String value) {
		waitVisibleDynamicElement(SignupPageUI.DYNAMIC_MSG, value);
		return getTextDynamicElement(SignupPageUI.DYNAMIC_MSG, value);
	}

	public void clickButtonContinue() {
		waitVisible(SignupPageUI.CONTINUE_BTN);
		click(SignupPageUI.CONTINUE_BTN);

	}

	public void clickButtonStartFreeTrial() {
		waitVisible(SignupPageUI.STARTFREETRIAL_BTN);
		click(SignupPageUI.STARTFREETRIAL_BTN);

	}

	public void clickButtonOK() {
		waitVisible(SignupPageUI.OK_BTN);
		click(SignupPageUI.OK_BTN);

	}

	public void clickButtonSkip() {
		waitVisible(SignupPageUI.SKIP_BTN);
		click(SignupPageUI.SKIP_BTN);

	}

//	public void clickLaybelUser() {
//		waitVisible(SignupPageUI.USER_LBN);
//		click(SignupPageUI.USER_LBN);
//
//	}

	public LoginPage clickLogout() {
		waitVisible(SignupPageUI.USER_LBN);
		click(SignupPageUI.USER_LBN);
		waitVisible(SignupPageUI.LOGOUT_BTN);
		click(SignupPageUI.LOGOUT_BTN);
		return PageFactory.initElements(driver, LoginPage.class);
	}
}

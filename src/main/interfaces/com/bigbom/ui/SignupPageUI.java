package com.bigbom.ui;

public class SignupPageUI {
	public static final String DISPLAYNAME_SIGNUP_TXT = "//input[@id='inputName']";
	public static final String EMAIL_SIGNUP_TXT = "//input[@id='inputEmail']";
	public static final String TOOLTIPEMAIL_SIGNUP_BTN = "//*[@class='bb-icon bb-icon-exclamation-circle bb-feedback-input__icon']";
	public static final String TOOLTIPPASSWORD_SIGNUP_BTN = "//*[@class='bb-icon bb-icon-exclamation-circle bb-feedback-input__icon']";

	public static final String PASSWORD_TXT = "//input[@id='inputPassword']";
	public static final String NUMBERPHONE_TXT = "//input[@id='inputPhone']";
	public static final String SIGNUP_BTN = "//div[@class='wrp-action']//button";
	public static final String DYNAMIC_MSG = "//*[contains(text(),'%s')]";
	public static final String EMAILINVALID_MSG = "//span[contains(text(),'Email invalid')]";

	// OTP
	public static final String OTP_TXT = "//input[@id='inputOTP']";
	public static final String TOOLTIPOTP_VERIFY_BTN = "//*[@class='bb-icon bb-icon-exclamation-circle bb-feedback-input__icon']";
	public static final String SUBMIT_BTN = "//button[@class='bb-button bb-button--primary bb-button--large']";
	// Yopmail
	public static final String EMAILYOPMAIL_TXT = "//input[@id='login']";
	public static final String CHECKEMAILYOPMAIL_BTN = "//input[@class='sbut']";
	public static final String OTP_LBN = "//p[contains(text(),'ng Bigbom.')]/../following-sibling::div";
	public static final String IFRAME_LBN = "//td[@class='whc bordfin_gbd alt']//iframe[@class='whc']";
	// SignupSuccessfully
	public static final String CONTINUE_BTN = "//button[@class='bb-button bb-button--primary bb-button--large']";
	public static final String STARTFREETRIAL_BTN = "//button[contains(text(),'Start Free trial')]";
	public static final String OK_BTN = "//button[contains(text(),'OK')]";
	public static final String SKIP_BTN = "//span[@class='tour-skip-btn']";
	public static final String USER_LBN = "//div[@class='avatar-name small']";
	public static final String LOGOUT_BTN = "//span[contains(text(),'Logout')]";
	// Resend
	public static final String RESEND_BTN = "//button[contains(text(),'Resend')]";
}

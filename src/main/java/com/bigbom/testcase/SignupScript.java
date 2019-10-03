package com.bigbom.testcase;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bigbom.actions.HomePage;
import com.bigbom.actions.LoginPage;
import com.bigbom.actions.SignupPage;
import com.bigbom.ui.SignupPageUI;

import CommonPage.Commontestcase;
import ObjectPageJson.JsonData;

public class SignupScript extends Commontestcase {
	WebDriver driver;
	SignupPage signupPage;
	HomePage homePage;
	LoginPage loginPage;
	JsonData data;
	String emailRandom, displayNameRandom, emailIncorrectMsg, emailNotDocCom, emailVarchar, emailBeforeA, emailNotCom,
			emailAlready, emailBlankSpace, emailOnlyGmailDocCom, emailAlreadyMsg, emailCorrect, emailIncorrect,
			phoneNumberIncorrectMsg, phoneIncorrect, phoneCorrect, passwordIncorrectMsg, passwordNotEnoughtCharacter,
			urlYopmail, verifyAcountMsg, otpInvalid, otpVarchar, otpMustNumberMsg, otpInvalidMsg, bigbomConfirmMsg,
			tilePageOTP, registerSuccessfulMsg, welcomeAccountMsg, welcomeToBigbomMsg, getDayStartsFreeMsg,
			getFreeTrialStartedMsg, activeSuccessfulMsg, resendOTPMsg, titleYopmail;
	static String yopMail, numberOTP, passwordSignupCorrect;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		// phone
		phoneNumberIncorrectMsg = "Phone invalid";
		phoneIncorrect = "bigbom";
		phoneCorrect = "0868521357";
		// password
		passwordIncorrectMsg = "Password must contain at least 6 characters";
		passwordNotEnoughtCharacter = "1#B23";
		passwordSignupCorrect = "123456";
		// Email
		emailIncorrectMsg = "Email invalid";
		emailVarchar = "Bibom VN";
		emailBeforeA = "Bigbom2019@";
		emailNotDocCom = "Bigbom2019@gmail";
		emailOnlyGmailDocCom = "@gmail.com";
		emailNotCom = "bigbom2019@gmail.";
		emailBlankSpace = "bibom2019gmail. com";
		emailAlready = "bigbomtest01@yopmail.com";
		emailAlreadyMsg = "Email already exists!";
		// OTP
		verifyAcountMsg = "Verify Your Account";
		otpVarchar = "bigbomtest";
		otpMustNumberMsg = "OTP Code must contain 6 numbers";
		otpInvalid = "123456";
		otpInvalidMsg = "OTP code is invalid";
		bigbomConfirmMsg = "Chào mừng bạn đã đến với hệ thống Bigbom. Để bắt đầu tận hưởng những tính năng tuyệt vời mà chúng tôi cung cấp, hãy nhập vào mã kích hoạt sau đây:";
		tilePageOTP = "Bigbom - The Pioneer of Blockchain Advertising Technology";
		resendOTPMsg = "Verify email sent, please check your mailbox";
		// Messenger
		registerSuccessfulMsg = "Verification Successful!";
		welcomeAccountMsg = "Congratulations! You have successfully verified your account";
		welcomeToBigbomMsg = "Welcome to Bigbom!";
		getDayStartsFreeMsg = "Congratulation! Your 14-day free trial starts today. The trial version offers unlimited access to the full power of Bigbom. You can upgrade at any time during your trial.";
		activeSuccessfulMsg = "Active Successful!";
		getFreeTrialStartedMsg = "Congratulation! Your 14-day free trial started! Thank you.";
		// url
		urlYopmail = "http://www.yopmail.com/en/";
		data = getDataJson(".\\Data\\Bigbom.json");
		titleYopmail = "YOPmail - Inbox";
		inititalReport("Signup.html");
	}

	@BeforeMethod
	public void beforeMethod() {
		emailRandom = "bigbomqctest" + randomName() + "@yopmail.com";
		displayNameRandom = "qcbigbom" + randomName();
	}

	@Test
	public void TC_AT01_getCurrentUrl() {
		logTestCase("TC_AT01_getCurrentUrl");
		String currrentUrl = driver.getCurrentUrl();
		assertEquals(currrentUrl, "https://uat-ads.bigbom.net/");
	}

	@Test
	public void TC_AT02_InputAllEmptyFieldsVerifyNotDisplayButton() {
		logTestCase("TC_AT02_InputAllEmptyFieldsVerifyNotDisplayButton");
		signupPage = PageFactory.initElements(driver, SignupPage.class);
		signupPage.iputDisplayName("");
		signupPage.iputPassword("");
		signupPage.iputPhone("");
		WebElement buttonSignup = driver.findElement(By.xpath("//div[@class='wrp-action']//button"));
		Assert.assertFalse(buttonSignup.isEnabled());
	}

	@Test
	public void TC_AT03_CheckValidateEmailFields() throws InterruptedException {
		logTestCase("TC_AT03_CheckValidateEmailFields");
		signupPage.iputDisplayName(displayNameRandom);
		signupPage.inputEmail(emailVarchar);
		signupPage.hoverTooltipEmail();
		verifyEqual(signupPage.getTextEmailInvalidMsg(), "Email invalid");
		signupPage.inputEmail(emailBeforeA);
		signupPage.hoverTooltipEmail();
		verifyEqual(signupPage.getTextEmailInvalidMsg(), "Email invalid");
		signupPage.inputEmail(emailNotDocCom);
		signupPage.hoverTooltipEmail();
		verifyEqual(signupPage.getTextEmailInvalidMsg(), "Email invalid");
		signupPage.inputEmail(emailOnlyGmailDocCom);
		signupPage.hoverTooltipEmail();
		verifyEqual(signupPage.getTextEmailInvalidMsg(), "Email invalid");
		signupPage.inputEmail(emailNotCom);
		signupPage.hoverTooltipEmail();
		verifyEqual(signupPage.getTextEmailInvalidMsg(), "Email invalid");
		signupPage.inputEmail(emailBlankSpace);
		signupPage.hoverTooltipEmail();
		verifyEqual(signupPage.getTextEmailInvalidMsg(), "Email invalid");
		WebElement buttonSignup = driver.findElement(By.xpath("//div[@class='wrp-action']//button"));
		Assert.assertFalse(buttonSignup.isEnabled());
	}

	@Test
	public void TC_AT04_CheckValidatePasswordFields() throws InterruptedException {
		logTestCase("TC_AT04_CheckValidatePasswordFields");
		signupPage.inputEmail(emailRandom);
		signupPage.iputPassword(passwordNotEnoughtCharacter);
		signupPage.hoverTooltipPassword();
		verifyEqual(signupPage.getDynamicText(passwordIncorrectMsg), "Password must contain at least 6 characters");
		WebElement buttonSignup = driver.findElement(By.xpath("//div[@class='wrp-action']//button"));
		Assert.assertFalse(buttonSignup.isEnabled());
	}

	@Test
	public void TC_AT05_CheckValidateNumberPhoneFields() throws InterruptedException {
		logTestCase("TC_AT05_CheckValidateNumberPhoneFields");
		signupPage.iputPassword(passwordSignupCorrect);
		signupPage.iputPhone(phoneIncorrect);
		signupPage.hoverTooltipPhone();
		verifyEqual(signupPage.getDynamicText(phoneNumberIncorrectMsg), "Phone invalid");
		WebElement buttonSignup = driver.findElement(By.xpath("//div[@class='wrp-action']//button"));
		Assert.assertFalse(buttonSignup.isEnabled());
	}

	@Test
	public void TC_AT06_VerifyDisplayButtonSignup() throws InterruptedException {
		logTestCase("TC_AT06_VerifyDisplayButtonSignup");
		signupPage.iputPhone(phoneCorrect);
		WebElement buttonSignup = driver.findElement(By.xpath("//div[@class='wrp-action']//button"));
		Assert.assertTrue(buttonSignup.isDisplayed());
	}

	@Test
	public void TC_AT07_SignupWithEmailAlready() throws InterruptedException {
		logTestCase("TC_AT07_SignupWithEmailAlready");
		signupPage.inputEmail(emailAlready);
		signupPage.clickbuttonSignup();
		verifyEqual(signupPage.getDynamicText(emailAlreadyMsg), "Email already exists!");
	}

	@Test
	public void TC_AT08_SignupNewAcount() throws InterruptedException {
		logTestCase("TC_AT08_SignupNewAcount");
		signupPage.inputEmail(emailRandom);
		yopMail = signupPage.getAtribute(SignupPageUI.EMAIL_SIGNUP_TXT, "value");
		Thread.sleep(2000);
		signupPage.clickbuttonSignup();
	}

//	@Test
	public void TC_AT09_GoToPageVerifyAcount() throws InterruptedException {
		logTestCase("TC_AT09_GoToPageVerifyAcount");
		verifyEqual(signupPage.getDynamicText(verifyAcountMsg), "Verify Your Account");

	}

	@Test
	public void TC_AT10_VerifyOtpMustNumber() throws InterruptedException {
		logTestCase("TC_AT10_VerifyOtpMustNumber");
		signupPage.iputOTP(otpVarchar);
		signupPage.hoverTooltipOTP();
		verifyEqual(signupPage.getDynamicText(otpMustNumberMsg), "OTP Code must contain 6 numbers");
	}

	@Test
	public void TC_AT11_VerifyOtpInvalid() throws InterruptedException {
		logTestCase("TC_AT11_VerifyOtpInvalid");
		signupPage.iputOTP(otpInvalid);
		signupPage.clickButtonSubmit();
		signupPage.hoverTooltipOTP();
		verifyEqual(signupPage.getDynamicText(otpInvalidMsg), "OTP code is invalid");
	}

	@Test
	public void TC_AT12_OpenNewTab() throws InterruptedException, AWTException {
		logTestCase("TC_AT12_OpenNewTab");
		signupPage.openNewTabAndSwithchToNewTab(driver);
//		signupPage.switchToNewTab(driver);
		Thread.sleep(1000);
		signupPage.openUrl(urlYopmail);
	}

	@Test
	public void TC_AT13_InputEmailYopmailVerify() throws InterruptedException {
		logTestCase("TC_AT13_InputEmailYopmailVerify");
		signupPage.inputEmailYopmail(yopMail);
		Thread.sleep(2000);
		signupPage.clickButtonCheckEmailYopmail();
		Thread.sleep(2000);
		signupPage.switchToIframe(SignupPageUI.IFRAME_LBN);
		String getText = signupPage.getTextDynamicElement(SignupPageUI.OTPNOTIFY_MSG, bigbomConfirmMsg);
		numberOTP = signupPage.getextOTP();

		if (getText == "Chào mừng bạn đã đến với hệ thống Bigbom. Để bắt đầu tận hưởng những tính năng tuyệt vời mà chúng tôi cung cấp, hãy nhập vào mã kích hoạt sau đây:") {
			numberOTP = signupPage.getextOTP();
			signupPage.switchToDefaultContent(driver);
		} else {
			signupPage.switchToDefaultContent(driver);
			signupPage.switchWindowByTitle(tilePageOTP);
			Thread.sleep(1000);
			signupPage.clickButtonResend();
			Thread.sleep(1000);
			signupPage.switchWindowByTitle(titleYopmail);
			signupPage.clickButtonCheckEmailYopmail();
			signupPage.switchToIframe(SignupPageUI.IFRAME_LBN);
			numberOTP = signupPage.getextOTP();
			signupPage.switchToDefaultContent(driver);
		}
	}

//	@Test
	public void TC_AT14_InputEmailYopmailVerify() throws InterruptedException {
		verifyEqual(signupPage.getDynamicText(bigbomConfirmMsg),
				"Chào mừng bạn đã đến với hệ thống Bigbom. Để bắt đầu tận hưởng những tính năng tuyệt vời mà chúng tôi cung cấp, hãy nhập vào mã kích hoạt sau đây:");
		Thread.sleep(2000);

		signupPage.switchToDefaultContent(driver);
		signupPage.switchWindowByTitle(tilePageOTP);
		Thread.sleep(1000);
		signupPage.clickButtonResend();
		Thread.sleep(1000);
		signupPage.switchWindowByTitle(titleYopmail);
		signupPage.clickButtonCheckEmailYopmail();
		signupPage.switchToIframe(SignupPageUI.IFRAME_LBN);
		numberOTP = signupPage.getextOTP();
		signupPage.switchToDefaultContent(driver);
		signupPage.switchToDefaultContent(driver);

	}

	@Test
	public void TC_AT16_VerifyOTP() throws InterruptedException {
		logTestCase("TC_AT16_VerifyOTP");
		signupPage.switchWindowByTitle(tilePageOTP);
		signupPage.iputOTP(numberOTP);
		signupPage.clickButtonSubmit();
		verifyEqual(signupPage.getDynamicText(registerSuccessfulMsg), "Verification Successful!");
		verifyEqual(signupPage.getDynamicText(welcomeAccountMsg),
				"Congratulations! You have successfully verified your account");
	}

	@Test
	public void TC_AT17_VeriffySignUpSuccessful() throws InterruptedException {
		logTestCase("TC_AT17_VeriffySignUpSuccessful");
		signupPage.clickButtonContinue();
		verifyEqual(signupPage.getDynamicText(welcomeToBigbomMsg), "Welcome to Bigbom!");
		verifyEqual(signupPage.getDynamicText(getDayStartsFreeMsg),
				"Congratulation! Your 14-day free trial starts today. The trial version offers unlimited access to the full power of Bigbom. You can upgrade at any time during your trial.");
	}

	@Test
	public void TC_AT18_ClickButtonStartFreeTrial() throws InterruptedException {
		logTestCase("TC_AT18_ClickButtonStartFreeTrial");
		signupPage.clickButtonStartFreeTrial();
		verifyEqual(signupPage.getDynamicText(activeSuccessfulMsg), "Active Successful!");
		verifyEqual(signupPage.getDynamicText(getFreeTrialStartedMsg),
				"Congratulation! Your 14-day free trial started! Thank you.");
		signupPage.clickButtonOK();
		Thread.sleep(2000);
		signupPage.clickButtonSkip();
		Thread.sleep(2000);
		loginPage = signupPage.clickLogout();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	@AfterClass
	public void AfterClass() {
		closeBrowser();
		exportReport();
	}

}

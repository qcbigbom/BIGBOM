package com.bigbom.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bigbom.actions.LoginPage;
import com.bigbom.actions.SignupPage;

import CommonPage.Commontestcase;
import CommonPage.commonFunction;

public class LoginScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	SignupPage signupPage;
	commonFunction cmnFunction;
	String parentWID, titleGoogle, loginGoogleFailMsg, loginFacebookFailMsg, titleBigbom, emailVarchar, emailBeforeA,
			emailNotDocCom, emailOnlyGmailDocCom, emailNotCom, emailBlankSpace, emailMustRequiredMsg, emailIncorrect,
			emailInvalidMsg, emailNotVerify, emailFacebook, passwordFacebook, passwordMustRequiredMsg,
			passwordNotEnoughtCharracters, passwordInCorrect, passwordNotEnoughtCharractersMsg,
			passwordOfEmailNotVerify, errorMsg, notifyEmailNotVerifyMsg, notifyEmailMustVerifyMsg, titleFacebook,
			resetPasswordMsg, textRequestEnterEmailVerifyMsg, unverifiedEmailMsg, emailNotExistMsg,
			textNotifyHasBeenSentEmailMsg, textCheckYourEmailMsg;
	static String yopMail, passwordSignupCorrect, emailCorrect, passwordCorrect;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		parentWID = driver.getWindowHandle();
		inititalReport("Login.html");
		titleGoogle = "Đăng nhập - Tài khoản Google";
		titleBigbom = "Bigbom - The Pioneer of Blockchain Advertising Technology";
		titleFacebook = "Facebook";
		// MSG
		loginGoogleFailMsg = "Login Google Error:Popup closed by user";
		loginFacebookFailMsg = "Login Facebook Error: Unknown error";
		errorMsg = "Email or password is wrong.";
		// email
		emailFacebook = "techteam@bigbom.com";
		passwordFacebook = "Bigbom_tech";
		emailCorrect = "techteam@bigbom.com";
		emailIncorrect = "tech@bigbom.com";
		emailNotVerify = "tran002@yopmail.com";
		emailMustRequiredMsg = "Email is required";
		emailInvalidMsg = "Email invalid";
		emailVarchar = "Bibom VN";
		emailBeforeA = "Bigbom2019@";
		emailNotDocCom = "Bigbom2019@gmail";
		emailOnlyGmailDocCom = "@gmail.com";
		emailNotCom = "bigbom2019@gmail.";
		emailBlankSpace = "bibom2019gmail. com";
		notifyEmailNotVerifyMsg = "Email is not verified.";
		notifyEmailMustVerifyMsg = "Your email is not verify yet. Do you want to re-verify this email?";

		// password
		passwordCorrect = "Bigbom_tech";
		passwordInCorrect = "1234567";
		passwordMustRequiredMsg = "Password is required";
		passwordNotEnoughtCharracters = "123";
		passwordNotEnoughtCharractersMsg = "Password must contain at least 6 characters";
		passwordOfEmailNotVerify = "123456";
		resetPasswordMsg = "Reset Password";
		textRequestEnterEmailVerifyMsg = "Enter your username or email to reset your password. You will receive an email with instructions on how to reset your password.	If you are experiencing problems resetting your password ";
		// ForgotPass
		unverifiedEmailMsg = "Unverified email";
		emailNotExistMsg = "Email not exist";
		textCheckYourEmailMsg = "Check your email";
		textNotifyHasBeenSentEmailMsg = "An email with instructions to create a new password has been sent to you.";
	}

//	@Test
	public void TC_AT19_OpenAndClosePopupGG() throws InterruptedException {
		logTestCase("TC_AT19_OpenAndClosePopupGG");
		loginPage.clickIconGG();
		Thread.sleep(2000);
//		loginPage.switchWindowByTitle("Đăng nhập bằng Google");
		loginPage.switchWindowByTitle(titleGoogle);
		driver.close();
		Thread.sleep(3000);
//		loginPage.switchWindowByTitle(parentWID);
		loginPage.switchWindowByTitle(titleBigbom);
//		driver.switchTo().window(parentWID);
		Thread.sleep(2000);
		verifyEqual(loginPage.getDynamicText(loginGoogleFailMsg), "Login Google Error:Popup closed by user");

	}

//	@Test
	public void TC_AT20_OpenAndClosePopupFB() throws InterruptedException {
		logTestCase("TC_AT20_OpenAndClosePopupFB");
		loginPage.clickFBIcon();
		Thread.sleep(2000);
		// switch windows
		loginPage.switchWindowByTitle(titleFacebook);
		driver.close();
		Thread.sleep(2000);
//		loginPage.getWindow(driver);
		driver.switchTo().window(parentWID);
		verifyEqual(loginPage.getDynamicText(loginFacebookFailMsg), "Login Facebook Error: Unknown error");
	}

//	@Test
	public void TC_AT21_SignInSuccessfullyWithEmailAndPassFb() throws InterruptedException {
		logTestCase("TC_AT21_SignInSuccessfullyWithEmailAndPassFb");
		loginPage.clickFBIcon();
		Thread.sleep(2000);
		// switch windows to popup
		loginPage.switchWindowByTitle(titleFacebook);
		loginPage.inputEmailFB(emailFacebook);
		loginPage.inputPasswordFB(passwordFacebook);
		loginPage.clickButtonLoginFB();
		Thread.sleep(2000);
		driver.switchTo().window(parentWID);
		// check page redirect to verify page`
		verifyEqual(loginPage.verifyEmailPageTitle(), "Congratulation!");
		loginPage.click_verifyEmailPage();
		Thread.sleep(5000);
		loginPage.Logout();

	}

	@Test
	public void TC_AT22_SignInAccountHadSignUp() throws InterruptedException {
		logTestCase("TC_AT22_SignInAccountHadSignUp");
		loginPage.inputEmailLogin(emailCorrect);
		loginPage.inputPasswordLogin(passwordCorrect);
		loginPage.clickButtonSignIn();
		loginPage.Logout();
	}

	@Test
	public void TC_AT23_SignInDontInputEmailAndPassword() throws InterruptedException {
		logTestCase("TC_AT23_SignInDontInputEmailAndPassword");
		loginPage.inputEmailLogin("");
		loginPage.inputPasswordLogin("");
		loginPage.clickButtonSignIn();
		loginPage.hoverToolTipEmail();
		verifyEqual(loginPage.getDynamicText(emailMustRequiredMsg), "Email is required");
		Thread.sleep(2000);
		loginPage.hoverToolTipPassword();
		verifyEqual(loginPage.getDynamicText(passwordMustRequiredMsg), "Password is required");
		Thread.sleep(2000);
	}

	@Test
	public void TC_AT24_CheckValidInputEmail() throws InterruptedException {
		logTestCase("TC_AT24_CheckValidInputEmail");
		loginPage.inputEmailLogin(emailVarchar);
		loginPage.hoverToolTipEmail();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		Thread.sleep(2000);
		loginPage.inputEmailLogin(emailBeforeA);
		loginPage.hoverToolTipEmail();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		Thread.sleep(2000);
		loginPage.inputEmailLogin(emailNotDocCom);
		loginPage.hoverToolTipEmail();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		Thread.sleep(2000);
		loginPage.inputEmailLogin(emailOnlyGmailDocCom);
		loginPage.hoverToolTipEmail();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		Thread.sleep(2000);
		loginPage.inputEmailLogin(emailNotCom);
		loginPage.hoverToolTipEmail();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		Thread.sleep(2000);
		loginPage.inputEmailLogin(emailBlankSpace);
		loginPage.hoverToolTipEmail();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		Thread.sleep(2000);
		loginPage.inputEmailLogin("");
	}

	@Test
	public void TC_AT25_CheckValidInputPassword() throws InterruptedException {
		logTestCase("TC_AT25_CheckValidInputPassword");
		loginPage.inputPasswordLogin(passwordNotEnoughtCharracters);
		loginPage.hoverToolTipPassword();
		verifyEqual(loginPage.getDynamicText(passwordNotEnoughtCharractersMsg),
				"Password must contain at least 6 characters");
		Thread.sleep(2000);
		loginPage.inputPasswordLogin("");
	}

	@Test
	public void TC_AT26_SignInWithEmailIncorrectAndPasswordCorrect() throws InterruptedException {
		logTestCase("TC_AT26_SignInWithEmailIncorrectAndPasswordCorrect");
		loginPage.inputEmailLogin(emailIncorrect);
		loginPage.inputPasswordLogin(passwordCorrect);
		loginPage.clickButtonSignIn();
		Thread.sleep(2000);
		verifyEqual(loginPage.getDynamicText(errorMsg), "Email or password is wrong.");
//		verifyEqual(loginPage.errorMessenger(), "Email or password is wrong.");
		Thread.sleep(2000);
	}

	@Test
	public void TC_AT27_SignInWithEmailCorrectAndPasswordIncorrect() throws InterruptedException {
		logTestCase("TC_AT27_SignInWithEmailCorrectAndPasswordIncorrect");
		loginPage.inputEmailLogin(emailCorrect);
		loginPage.inputPasswordLogin(passwordInCorrect);
		loginPage.clickButtonSignIn();
		Thread.sleep(2000);
		verifyEqual(loginPage.getDynamicText(errorMsg), "Email or password is wrong.");
		Thread.sleep(2000);
	}

	@Test
	public void TC_AT28_SignInWithEmailInCorrectAndPasswordIncorrect() throws InterruptedException {
		logTestCase("TC_AT28_SignInWithEmailInCorrectAndPasswordIncorrect");
		loginPage.inputEmailLogin(emailIncorrect);
		loginPage.inputPasswordLogin(passwordInCorrect);
		loginPage.clickButtonSignIn();
		Thread.sleep(2000);
		verifyEqual(loginPage.getDynamicText(errorMsg), "Email or password is wrong.");
		Thread.sleep(2000);
	}

	@Test
	public void TC_AT29_SignInWithEmailNotVerify() throws InterruptedException {
		logTestCase("TC_AT29_SignInWithEmailNotVerify");
		loginPage.inputEmailLogin(emailNotVerify);
		loginPage.inputPasswordLogin(passwordOfEmailNotVerify);
		loginPage.clickButtonSignIn();
		Thread.sleep(2000);
		verifyEqual(loginPage.getDynamicText(notifyEmailNotVerifyMsg), "Email is not verified.");
		Thread.sleep(2000);
		verifyEqual(loginPage.getDynamicText(notifyEmailMustVerifyMsg),
				"Your email is not verify yet. Do you want to re-verify this email?");
		Thread.sleep(2000);
		loginPage.clickButtonClose();
	}

	@Test
	public void TC_AT30_SignInWithEmailPasswordVerifySignupPage() throws InterruptedException {
		logTestCase("TC_AT30_SignInWithEmailPasswordVerifySignupPage");
		loginPage.inputEmailLogin(SignupScript.yopMail);
		loginPage.inputPasswordLogin(SignupScript.passwordSignupCorrect);
		loginPage.clickButtonSignIn();
		Thread.sleep(2000);
	}

	@Test
	public void TC_AT31_ClickForgotPassword() throws InterruptedException {
		logTestCase("TC_AT31_ClickForgotPassword");
		loginPage.clickLogout();
		loginPage.clickLinkForgotPassword();
		verifyEqual(loginPage.getDynamicText(resetPasswordMsg), "Reset Password");
		verifyEqual(textRequestEnterEmailVerifyMsg,
				"Enter your username or email to reset your password. You will receive an email with instructions on how to reset your password.	If you are experiencing problems resetting your password ");
		loginPage.clickButtonCancel();
		verifyEqual(loginPage.getCurrentUrl(driver), "https://uat-ads.bigbom.net/");

	}

	@Test
	public void TC_AT32_VerifyValidInputWrongFormatEmail() throws InterruptedException {
		logTestCase("TC_AT32_VerifyInputWrongFormatEmail");
		loginPage.clickLinkForgotPassword();
		verifyEqual(loginPage.getDynamicText(resetPasswordMsg), "Reset Password");
		verifyEqual(textRequestEnterEmailVerifyMsg,
				"Enter your username or email to reset your password. You will receive an email with instructions on how to reset your password.	If you are experiencing problems resetting your password ");
		loginPage.inputEmailForgotPassword(emailVarchar);
		Thread.sleep(1000);
		loginPage.hoverToolTipEmailResetPassword();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		loginPage.inputEmailForgotPassword(emailBeforeA);
		Thread.sleep(1000);
		loginPage.hoverToolTipEmailResetPassword();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		loginPage.inputEmailForgotPassword(emailNotDocCom);
		Thread.sleep(1000);
		loginPage.hoverToolTipEmailResetPassword();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		loginPage.inputEmailForgotPassword(emailNotCom);
		Thread.sleep(1000);
		loginPage.hoverToolTipEmailResetPassword();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
		loginPage.inputEmailForgotPassword(emailBlankSpace);
		Thread.sleep(1000);
		loginPage.hoverToolTipEmailResetPassword();
		verifyEqual(loginPage.getDynamicText(emailInvalidMsg), "Email invalid");
	}

	@Test
	public void TC_AT33_ForgotPasswordWithEmailNotVerify() throws InterruptedException {
		logTestCase("TC_AT33_ForgotPasswordWithEmailNotVerify");
		loginPage.inputEmailForgotPassword(emailNotVerify);
		loginPage.clickButtonGetOTP();
		verifyEqual(loginPage.getDynamicText(unverifiedEmailMsg), "Unverified email");
		Thread.sleep(2000);
	}

	@Test
	public void TC_AT34_ForgotPasswordWithEmailNotExits() throws InterruptedException {
		logTestCase("TC_AT33_ForgotPasswordWithEmailNotVerify");
		loginPage.inputEmailForgotPassword(emailIncorrect);
		loginPage.clickButtonGetOTP();
		verifyEqual(loginPage.getDynamicText(emailNotExistMsg), "Email not exist");
		Thread.sleep(2000);
	}

	@Test
	public void TC_AT34_ForgotPasswordWithEmailHadSignup() throws InterruptedException {
		logTestCase("TC_AT33_ForgotPasswordWithEmailNotVerify");
		loginPage.inputEmailForgotPassword(yopMail);
		loginPage.clickButtonGetOTP();
		verifyEqual(loginPage.getDynamicText(textCheckYourEmailMsg), "Check your email");
		Thread.sleep(2000);
		verifyEqual(loginPage.getDynamicText(textNotifyHasBeenSentEmailMsg),
				"An email with instructions to create a new password has been sent to you.");
		Thread.sleep(2000);
		loginPage.clickButtonClose();
		verifyEqual(loginPage.getCurrentUrl(driver), "https://uat-ads.bigbom.net/handler/forgot-password");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	@AfterClass
	public void AfterClass() {
//		closeBrowser();
		exportReport();
	}

}

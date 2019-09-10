package com.bigbom.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bigbom.actions.HomePage;
import com.bigbom.actions.LoginPage;

import CommonPage.Commontestcase;
import ObjectPageJson.JsonData;

public class LoginScript extends Commontestcase {
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	JsonData data;
	String emailAndSdtorPasswordIncorrectMsg, emailSdtOrPasswordWrongMsg, PhoneNumberIncorrectMsg, phoneIncorrect,
			emailIncorrectMsg, emailCorrect, emailIncorrect, passwordNotEnoughtCharacterMsg,
			passwordNotEnoughtCharacter, passwordWrong, passwordCorrect;
	
	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		emailAndSdtorPasswordIncorrectMsg = "Hãy nhập email / số điện thoại và mật khẩu";
		PhoneNumberIncorrectMsg = "Số điện thoại không đúng";
		emailIncorrectMsg = "Email không đúng";
		emailSdtOrPasswordWrongMsg = "Sai email / số điện thoại hoặc mật khẩu";
		// password
		passwordNotEnoughtCharacterMsg = "Tối thiểu 6 ký tự";
		passwordNotEnoughtCharacter = "123";
		passwordWrong = "123456";
		passwordCorrect = "1234@abcd";
		// emailsdt
		emailCorrect = "genymotionios@gmail.com";
		phoneIncorrect = "1234";
		emailIncorrect = "1234abcd";
		data = getDataJson(".\\Data\\BeeCow.json");
	}

	@Test
	public void TC_01_LoginEmptyEmailAndPassWord() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		loginPage = homePage.clickdangnhap();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputEmailorSdt("");
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(emailAndSdtorPasswordIncorrectMsg),
				"Hãy nhập email / số điện thoại và mật khẩu");
	}

	@Test
	public void TC_02_LoginWrongSDT() {
		loginPage.inputEmailorSdt(phoneIncorrect);
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(PhoneNumberIncorrectMsg), "Số điện thoại không đúng");
		verifyEqual(loginPage.getDynamicText(emailAndSdtorPasswordIncorrectMsg),
				"Hãy nhập email / số điện thoại và mật khẩu");
		loginPage.clearByJs("$('input#usr').val('')");

	}

	@Test
	public void TC_03_LoginWrongEmail() {
//		loginPage.clearEmailorSdt();
		loginPage.inputEmailorSdt(emailIncorrect);
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(emailIncorrectMsg), "Email không đúng");
		verifyEqual(loginPage.getDynamicText(emailAndSdtorPasswordIncorrectMsg),
				"Hãy nhập email / số điện thoại và mật khẩu");
		loginPage.clearByJs("$('input#usr').val('')");

	}

	@Test
	public void TC_04_LogincorrectEmailBlankPassword() {
//		loginPage.clearEmailorSdt();
		loginPage.inputEmailorSdt(emailCorrect);
		loginPage.iputMatkhau("");
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(emailAndSdtorPasswordIncorrectMsg),
				"Hãy nhập email / số điện thoại và mật khẩu");
	}

	@Test
	public void TC_05_LogincorrectEmailPasswordNotEnoughtCharracter() {
		loginPage.iputMatkhau(passwordNotEnoughtCharacter);
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(passwordNotEnoughtCharacterMsg), "Tối thiểu 6 ký tự");
		verifyEqual(loginPage.getDynamicText(emailAndSdtorPasswordIncorrectMsg),
				"Hãy nhập email / số điện thoại và mật khẩu");
		loginPage.clearByJs("$('input#pwd').val('')");
	}

//
	@Test
	public void TC_06_LogincorrectEmailWrongPassword() {
		loginPage.iputMatkhau(passwordWrong);
		loginPage.clickbuttonDangnhap();
		verifyEqual(loginPage.getDynamicText(emailSdtOrPasswordWrongMsg), "Sai email / số điện thoại hoặc mật khẩu");
		loginPage.clearByJs("$('input#pwd').val('')");
	}

//	TC7. Navigate to url: https://www.beecow.com
//		2. Click button: Đăng nhập
//		3. Input username: "genymotionios@gmail.com"
//		4. Input password: "1234@abcd"
//		5. Click button: Đăng nhập.Verify label username "genymotionios" is displayed on the top right screen
	@Test
	public void TC_07_LoginCorrectEmailSdtAndPassword() throws InterruptedException {
		loginPage.iputMatkhau(passwordCorrect);
		loginPage.clickbuttonDangnhap();
		Thread.sleep(3000);
		verifyEqual(loginPage.getTextUserName(), "genymotionios");
		Thread.sleep(3000);
		}

	@AfterClass
	public void AfterClass() {
		 closeBrowser();
	}

}

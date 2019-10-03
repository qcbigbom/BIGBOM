package com.bigbom.testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bigbom.actions.AnalysisPage;
import com.bigbom.actions.DashboardPage;
import com.bigbom.actions.HomePage;
import com.bigbom.actions.LoginPage;
import com.bigbom.actions.SignupPage;

import CommonPage.Commontestcase;
import ObjectPageJson.JsonData;

public class AnalysisScript extends Commontestcase {
	WebDriver driver;
	SignupPage signupPage;
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AnalysisPage analysisPage;
	JsonData data;
	String emailRandom, activeSuccessfulMsg;
	static String emailCorrect, passwordCorrect;

	@Parameters({ "browser", "version", "url" })
	@BeforeClass
	public void BeforeClass(String browser, String version, String url) {
		driver = openMultiBrowser(browser, version, url);
		emailCorrect = "techteam@bigbom.com";
		passwordCorrect = "Bigbom_tech";
		data = getDataJson(".\\Data\\Bigbom.json");
		inititalReport("Signup.html");
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputEmailLogin(emailCorrect);
		loginPage.inputPasswordLogin(passwordCorrect);
		loginPage.clickButtonSignIn();
	}

	@BeforeMethod
	public void beforeMethod() {
		dashboardPage.hoverCampaignNameTestAuto();
		analysisPage = dashboardPage.clickLinkAnalytics();

	}

	@Test
	public void TC_AT01_getCurrentUrl() {
		logTestCase("TC_AT01_getCurrentUrl");
		String currrentUrl = driver.getCurrentUrl();
		assertEquals(currrentUrl,
				"https://uat-ads.bigbom.net/analytics?id=5d957743ff3f0c00113d128b&type=campaign&fbAdAccountId=act_2469378083315956");
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

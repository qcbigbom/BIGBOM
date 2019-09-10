package CommonPage;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.google.gson.Gson;

import ObjectPageJson.JsonData;

//import com.google.gson.Gson;

//import ObjectPageJson.JsonData;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class Commontestcase {
	WebDriver driver;

	public WebDriver openMultiBrowser(String browser, String version, String url) {
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			ChromeDriverManager.getInstance().version(version).setup();
			driver = new ChromeDriver(options);
			driver.get(url);
			driver.manage().window().maximize();
		} else if (browser.equals("firefox")) {
			FirefoxDriverManager.getInstance().version(version).setup();
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public JsonData getDataJson(String JsonFile) {
		String json = readFile(JsonFile);
		return new Gson().fromJson(json, JsonData.class);
	}

	public String readFile(String filename) {
		String result = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String randomName() {
		Random rand = new Random();
		int n = rand.nextInt(9999999);
		return String.valueOf(n);
	}

	public void verifyEqual(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public void closeBrowser() {
		driver.quit();
	}
}
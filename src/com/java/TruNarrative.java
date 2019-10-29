package com.java;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TruNarrative {
	public static WebDriver driver;
	public static String actualurl;
	public static String sURL = "https://www.google.com/";

	public static void openingBrowser() {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(sURL);
		System.out.println("Page title is " + driver.getTitle());
		System.out.println("Current URL is " + driver.getCurrentUrl());
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement oSearch;
		oSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oSearch.sendKeys("TruNarrative");
		oSearch.sendKeys(Keys.ENTER);
	}

	public static void getPageInfo() {
		System.out.println("Page Title is : " + driver.getTitle());
		System.out.println("Page Current URL is : " + driver.getCurrentUrl());
	}

	public static void VerifyResult() {
		WebElement oElement;
		String sTitleExpected = "https://trunarrative.com/";
		List<WebElement> oList = driver
				.findElements(By.linkText("TruNarrative | Who, What and When | Fraud and Compliance ..."));
		for (int i = 0; i < oList.size(); i++) {
			Assert.assertTrue(oList.get(i).getText().contains("TruNarrative"));
		}
	}

	public static void Navigate() {
		WebElement oLink;
		oLink = driver.findElement(By.xpath("//cite[@class='iUh30']"));
		oLink.click();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		getPageInfo();
	}

	public static void VerifyStrapLine() {
		String expectedText = "Easy Onboarding. Smooth Transactions. Insightful Compliance";

		if (driver.getPageSource().contains("Easy Onboarding. Smooth Transactions. Insightful Compliance")) {

			System.out.println("Easy Onboarding. Smooth Transactions. Insightful Compliance is found on the page");
		} else {
			System.out.println(expectedText + "not found in the  page");

		}

	}

	public static void TruNarrativeTeam() {

		Actions oMouse = new Actions(driver);
		WebElement oScr, oTrg;
		oScr = driver.findElement(By.linkText("More"));
		oMouse.moveToElement(oScr).release().build().perform();
		oTrg = driver.findElement(By.linkText("TruNarrative Team"));
		oMouse.moveToElement(oTrg).click().build().perform();
	}

	public static void VerifyTruNarrativeTeam() {
		int iList;
		List<WebElement> olist = driver.findElements(By.xpath("//section//div[@class='content']/h2"));
		iList = olist.size();

		if (iList == 9) {

			System.out.println("No. of TruNarrative leadership team listed in website = " + olist.size());
		} else {
			System.out.println("TruNarrative leadership team does not have 9 members ");
		}
	}

	public static void VerifyCEO() {
		String sNameExpected = "John Lord";
		String sRoleExpected = "Founder and CEO";
		WebElement oJName, oJRole;
		oJName = driver.findElement(By.xpath("(//section//div[@class='content']/h2)[1]"));
		oJRole = driver.findElement(By.xpath("(//p[@class='sub'])[1]"));
		String sNameActual = oJName.getText();
		String sRoleActual = oJRole.getText();

		if (sNameExpected.equals(sNameActual) && (sRoleExpected.equals(sRoleActual))) {

			System.out.println("CEO name and Role match passed");
		} else {
			System.out.println("CEO name and Role match failed");
		}

	}

	public static void VerifyCTO() {
		String sNameExpected = "David Eastaugh";
		String sRoleExpected = "CTO";
		WebElement oJName, oJRole;
		oJName = driver.findElement(By.xpath("(//section//div[@class='content']/h2)[5]"));
		oJRole = driver.findElement(By.xpath("(//p[@class='sub'])[5]"));
		String sNameActual = oJName.getText();
		String sRoleActual = oJRole.getText();

		if (sNameExpected.equals(sNameActual) && (sRoleExpected.equals(sRoleActual))) {

			System.out.println("CTO name and Role match passed");
		} else {
			System.out.println("CTO name and Role match failed");
		}

	}

	public static void VerifyHRM() {
		String sNameExpected = "Nicola Janney";
		String sRoleExpected = "Human Resources Manager";
		WebElement oJName, oJRole;
		oJName = driver.findElement(By.xpath("(//section//div[@class='content']/h2)[8]"));
		oJRole = driver.findElement(By.xpath("(//p[@class='sub'])[8]"));
		String sNameActual = oJName.getText();
		String sRoleActual = oJRole.getText();

		if (sNameExpected.equals(sNameActual) && (sRoleExpected.equals(sRoleActual))) {

			System.out.println("HRM name and Role match passed");
		} else {
			System.out.println("HRM name and Role match failed");
		}

	}

	public static void main(String[] args) {
		openingBrowser();
		VerifyResult();
		Navigate();
		VerifyStrapLine();
		TruNarrativeTeam();
		VerifyTruNarrativeTeam();
		VerifyCEO();
		VerifyCTO();
		VerifyHRM();
		closeBrowser();
	}

	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}

}

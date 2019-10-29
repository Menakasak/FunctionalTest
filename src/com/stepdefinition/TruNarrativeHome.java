package com.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TruNarrativeHome {

	public static WebDriver driver;
	public static String actualurl;
	public static String sURL = "https://www.google.com/";

	@Given("^Open Google.com$")
	public void launchBrowser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@When("^Search for TruNarrative$")
	public void navigateBrowser() throws Throwable {

		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebElement oSearch;
		oSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		oSearch.sendKeys("TruNarrative");
		oSearch.sendKeys(Keys.ENTER);
	}

	@Then("^Validate the Reasult$")
	public void validateTitle() throws Throwable {
		List<WebElement> oList = driver
				.findElements(By.linkText("TruNarrative | Who, What and When | Fraud and Compliance ..."));
		for (int i = 0; i < oList.size(); i++) {
			Assert.assertTrue(oList.get(i).getText().contains("TruNarrative"));
		}

		String expectedText = "Easy Onboarding. Smooth Transactions. Insightful Compliance";

		if (driver.getPageSource().contains("Easy Onboarding. Smooth Transactions. Insightful Compliance")) {

			System.out.println("Easy Onboarding. Smooth Transactions. Insightful Compliance is found on the page");
		} else {
			System.out.println(expectedText + "not found in the  page");

		}

	}

	@When("^Navigate via the UI ")
	public void TruNarrativeTeam() throws Throwable {

		Actions oMouse = new Actions(driver);
		WebElement oScr, oTrg;
		oScr = driver.findElement(By.linkText("More"));
		oMouse.moveToElement(oScr).release().build().perform();
		oTrg = driver.findElement(By.linkText("TruNarrative Team"));
		oMouse.moveToElement(oTrg).click().build().perform();
	}

	@Then("^ TruNarrative leadership team$")
	public static void VerifyTruNarrativeTeam() throws Throwable {
		int iList;
		List<WebElement> olist = driver.findElements(By.xpath("//section//div[@class='content']/h2"));
		iList = olist.size();

		if (iList == 9) {

			System.out.println("No. of TruNarrative leadership team listed in website = " + olist.size());
		} else {
			System.out.println("TruNarrative leadership team does not have 9 members ");
		}
	}

	String sNameExpected1 = "John Lord";
	String sRoleExpected1 = "Founder and CEO";
	WebElement oJName1, oJRole1;
	{
		oJName = driver.findElement(By.xpath("(//section//div[@class='content']/h2)[1]"));
		oJRole = driver.findElement(By.xpath("(//p[@class='sub'])[1]"));
		String sNameActual1 = oJName1.getText();
		String sRoleActual1 = oJRole1.getText();

		if (sNameExpected1.equals(sNameActual1) && (sRoleExpected1.equals(sRoleActual1))) {

			System.out.println("CEO name and Role match passed");
		} else {
			System.out.println("CEO name and Role match failed");
		}

	}

	String sNameExpected2 = "David Eastaugh";
	String sRoleExpected2 = "CTO";
	WebElement oJName2, oJRole2;
	{
		oJName = driver.findElement(By.xpath("(//section//div[@class='content']/h2)[5]"));
		oJRole = driver.findElement(By.xpath("(//p[@class='sub'])[5]"));
		String sNameActual = oJName1.getText();
		String sRoleActual = oJRole1.getText();

		if (sNameExpected2.equals(sNameActual) && (sRoleExpected2.equals(sRoleActual))) {

			System.out.println("CTO name and Role match passed");
		} else {
			System.out.println("CTO name and Role match failed");
		}

	}

	String sNameExpected = "Nicola Janney";
	String sRoleExpected = "Human Resources Manager";
	WebElement oJName, oJRole;
	{
		oJName = driver.findElement(By.xpath("(//section//div[@class='content']/h2)[8]"));
		oJRole = driver.findElement(By.xpath("(//p[@class='sub'])[8]"));
		String sNameActual = oJName.getText();
		String sRoleActual = oJRole.getText();

		if (sNameExpected.equals(sNameActual) && (sRoleExpected.equals(sRoleActual))) {

			System.out.println("HRM name and Role match passed");
		} else {
			System.out.println("HRM name and Role match failed");
		}

		driver.close();
		driver.quit();
	}
}

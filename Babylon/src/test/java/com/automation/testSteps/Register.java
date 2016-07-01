package com.automation.testSteps;

import java.util.List;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.lib.Screenshot;
import com.automation.reports.AdvancedReports;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Register {

	public static AndroidDriver driver = null;
	AdvancedReports report = new AdvancedReports(driver);

	@Given("^User opens Babylon Health App$")
	public void user_opens_Babylon_Health_App() throws MalformedURLException {

		report.ReportClass("Open Babylon App", "TC1");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "6.0");
	    capabilities.setCapability("deviceName", "Emulator");
		//capabilities.setCapability("deviceName", "BH907JV209");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.babylon");
		capabilities.setCapability("appActivity", "com.babylon.activity.RegistrationActivity");

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			report.PassTest("Appium Started");
			Screenshot.takePicture(driver, "Appium Started");
		}

		catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@When("^User clicks Sign Up Button$")
	public void user_clicks_Sign_Up_Button() throws Throwable {
		WebElement sign = driver.findElement(By.name("Sign up"));
		sign.click();
		report.InfoTest("Clicked SignUp Button");
		Screenshot.takePicture(driver,"Sign Up click");

	}

	@And("^User enters all the \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_all_the_and(String arg1, String arg2, String arg3, String arg4) throws Throwable {

		driver.findElement(By.name("Email")).sendKeys(arg1);

		driver.findElement(By.id("com.babylon:id/passwordEdt")).sendKeys(arg2);

		driver.findElement(By.name("First Name")).sendKeys(arg3);

		driver.findElement(By.name("Last Name")).sendKeys(arg4);

		driver.findElement(By.name("Date of Birth (dd/mm/yyyy)")).click();

		driver.findElement(By.id("android:id/datePicker"));
		
		Screenshot.takePicture(driver, "Date Picker");

	/*	WebElement month = driver
				.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText"));

		month.clear();

		month.sendKeys("08");

		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='1']")).sendKeys("Nov");

		driver.findElement(By.xpath("//android.widget.NumberPicker[@index='2']")).sendKeys("1982");*/
		
		
		WebElement ele = driver
				.findElement(By.xpath("//android.widget.NumberPicker[@index='0']//android.widget.EditText"));
	
		
		System.out.println(ele.getText());
		
	/*	TouchAction action = new TouchAction((MobileDriver) driver);
		
		action.press(ele).perform();
		
		//action.longPress(ele).perform();*/
	
		
   ele.sendKeys(Keys.BACK_SPACE);		
   ele.sendKeys("08");
   
   //ele.sendKeys(Keys.NUMPAD8);
		
		
   //ele.clear();
	
	//	driver.findElement(By.xpath("//android.widget.NumberPicker[@index='0']")).sendKeys("08");
	//	ele.sendKeys("08"); 
	
		
		
		
		
		
		
		Screenshot.takePicture(driver,"Date Picker2" );
		
		driver.findElement(By.id("android:id/button1")).click();

		driver.findElement(By.id("com.babylon:id/location_spinner")).click();
		driver.findElement(By.id("com.babylon:id/name_text_view")).click();

		driver.findElement(By.className("android.widget.CheckBox")).click();
		report.InfoTest("Filled up Babylon form");
		Screenshot.takePicture(driver, "Filled Up form");

	}

	

	@Then("^New Account is created for User$")
	public void new_Account_is_created_for_User() throws Throwable {

		driver.findElement(By.id("com.babylon:id/createAccountBtn")).click();
		report.PassTest("Bablon Account Created");
	}

	@And("^User Clicks on Avatar Icon$")
	public void user_Clicks_on_Avatar_Icon() throws Throwable {
		Screenshot.takePicture(driver, "Avatar Screen");
		driver.findElement(By.id("com.babylon:id/activity_home_page_settings")).click();
		report.InfoTest("Clicked Avatar Icon");
	}

	@Then("^User counts Number of Settings$")
	public void user_counts_Number_of_Settings() throws Throwable {
		
		Screenshot.takePicture(driver, "Settings Screen");
		List<WebElement> settings = driver.findElements(By.xpath("com.babylon:id/recyclerView[@index='0']"));
		System.out.println("Size of the list is" + settings.size());
		report.InfoTest("Settings Menu displayed");
	}

}

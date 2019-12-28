package com.capgemini.hotelmanagement.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionForUser {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver;
	
	@Given("^the user has loaded the application in the browser$")
	public void the_user_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enters the valid email in the textbox$")
	public void user_enters_the_valid_email_in_the_textbox() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("shitalpatil@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the user enters valid password in the textbox$")
	public void the_user_enters_valid_password_in_the_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Shital123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		

	@When("^user click on the LOGIN button$")
	public void user_click_on_the_LOGIN_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-loginadmin/div/form/div/div/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@When("^the user click on BOOK HOTEL link$")
	public void the_user_click_on_BOOK_HOTEL_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='BOOK HOTEL']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^click on VIEW ROOMS button$")
	public void click_on_VIEW_ROOMS_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-bookuser/div[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@When("^user click on BOOK NOW button$")
	public void user_click_on_BOOK_NOW_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-bookroom/div/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user select check in date$")
	public void user_select_check_in_date() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-userbooking/div/form/div/div[2]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user select check out date$")
	public void user_select_check_out_date() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-userbooking/div/form/div/div[2]/div[4]/input")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on select button$")
	public void click_on_select_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-userbooking/div/form/div/div[3]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@When("^user select mode of payment$")
	public void user_select_mode_of_payment() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"paymentMode\"]/option[4]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^click on submit button,hotel must be booked$")
	public void click_on_submit_button_hotel_must_be_booked() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-payment/div/form/div/div[3]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on BOOKING HISTORY link, list must be displayed$")
	public void click_on_BOOKING_HISTORY_link_list_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='BOOKING HISTORY']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on LOGOUT button, home page should be displayed$")
	public void click_on_LOGOUT_button_home_page_should_be_displayed() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/button")).click();
	}



}

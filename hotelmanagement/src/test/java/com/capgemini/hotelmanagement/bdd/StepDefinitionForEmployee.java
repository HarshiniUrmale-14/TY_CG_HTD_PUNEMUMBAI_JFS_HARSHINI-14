package com.capgemini.hotelmanagement.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionForEmployee {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver;
	
	@Given("^The employee has loaded the application in the browser$")
	public void the_employee_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^employee click on the login link$")
	public void employee_click_on_the_login_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the employee enters the  valid email id in the input box$")
	public void the_employee_enters_the_valid_email_id_in_the_input_box() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("priti@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the employee enters the valid  password in the input box$")
	public void the_employee_enters_the_valid_password_in_the_input_box() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Priti123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on the login button ,dashboard page must be displayed$")
	public void click_on_the_login_button_dashboard_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-loginadmin/div/form/div/div/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on BOOK ROOM link$")
	public void click_on_BOOK_ROOM_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='BOOK ROOM']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on BOOK NOW button$")
	public void click_on_BOOK_NOW_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-employeeroom/div/div/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid user id in textbox$")
	public void enter_valid_user_id_in_textbox() throws Throwable {
		driver.findElement(By.name("userId")).sendKeys("111");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid user name in textbox$")
	public void enter_valid_user_name_in_textbox() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Manoj Shinde");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^select check in date$")
	public void select_check_in_date() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-employeebooking/div/form/div/div[2]/div[5]/input")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^select check out date$")
	public void select_check_out_date() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-employeebooking/div/form/div/div[2]/div[6]/input")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-employeebooking/div/form/div/div[3]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^select mode of payment$")
	public void select_mode_of_payment() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"paymentMode\"]/option[4]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on submit button,room must be booked and payment should be done$")
	public void click_on_submit_button_room_must_be_booked_and_payment_should_be_done() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-payment/div/form/div/div[3]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on the LOGOUT button, home page must be displayed$")
	public void click_on_the_LOGOUT_button_home_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



}

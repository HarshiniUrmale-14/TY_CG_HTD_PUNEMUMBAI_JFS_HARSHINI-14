package com.capgemini.hotelmanagement.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionForManagement {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver;

	@Given("^The management has loaded the application in the browser$")
	public void the_management_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^management click on the login link$")
	public void management_click_on_the_login_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the management enters the  valid email id in the input box$")
	public void the_management_enters_the_valid_email_id_in_the_input_box() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("management@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the management enters the valid  password in the input box$")
	public void the_management_enters_the_valid_password_in_the_input_box() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Manage123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^clicks on the login button ,dashboard page must be displayed$")
	public void clicks_on_the_login_button_dashboard_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-loginadmin/div/form/div/div/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on ADD ADMIN link$")
	public void click_on_ADD_ADMIN_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ADD ADMIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid admin name in textbox$")
	public void enter_valid_admin_name_in_textbox() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("shamila");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid email id in textbox$")
	public void enter_valid_email_id_in_textbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("shamil@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid mobile number in textbox$")
	public void enter_valid_mobile_number_in_textbox() throws Throwable {
		driver.findElement(By.name("phoneNo")).sendKeys("9876543210");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid adhar number in textbox$")
	public void enter_valid_adhar_number_in_textbox() throws Throwable {
		driver.findElement(By.name("adharNo")).sendKeys("123456789012");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^select nationality$")
	public void select_nationality() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"2\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid password in textbox$")
	public void enter_valid_password_in_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Manage123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter same password to confirm$")
	public void enter_same_password_to_confirm() throws Throwable {
		driver.findElement(By.name("password2")).sendKeys("Manage123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on register button, admin must be added in the database$")
	public void click_on_register_button_admin_must_be_added_in_the_database() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-addadmin/div/form/div/div[4]/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on VIEWBILL link , the bill details must be displayed$")
	public void click_on_VIEWBILL_link_the_bill_details_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='VIEWBILL']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on USERDETAILS  link,the user details must be displayed$")
	public void click_on_USERDETAILS_link_the_user_details_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='USER DETAILS']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on LOGOUT button, home page must be displayed$")
	public void click_on_LOGOUT_button_home_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/button")).click();
	}

}

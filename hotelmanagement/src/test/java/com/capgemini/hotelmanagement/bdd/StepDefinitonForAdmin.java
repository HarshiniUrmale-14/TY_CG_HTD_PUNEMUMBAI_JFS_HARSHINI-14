package com.capgemini.hotelmanagement.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitonForAdmin {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver;

	@Given("^the admin has loaded the application in the browser$")
	public void the_admin_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^admin click on login link$")
	public void admin_click_on_login_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters valid email in the emailbox$")
	public void the_admin_enters_valid_email_in_the_emailbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("simmimulani1221@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters valid password in the password textbox$")
	public void the_admin_enters_valid_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Simmi1221");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin clicks on the login button$")
	public void the_admin_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-loginadmin/div/form/div/div/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the dashboard page must be displayed$")
	public void the_dashboard_page_must_be_displayed() throws Throwable {
		//driver.findElement(By.xpath("//a[text()='HOME']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/********************************
	 * Delete Hotel Operation
	 ***************************************************/

	@When("^click on HOTELLIST link$")
	public void click_on_HOTELLIST_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='HOTELLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on the DELETE button$")
	public void click_on_the_DELETE_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-hotellist/div[2]/table/tbody/tr[1]/td[8]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^selected hotel details must be deleted$")
	public void selected_hotel_details_must_be_deleted() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/a[3]")).click();
	}

	/********************************
	 * Add Hotel Operation
	 ***************************************************/

	@When("^click on the HOTELLIST link$")
	public void click_on_the_HOTELLIST_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='HOTELLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on the ADD HOTEL button$")
	public void click_on_the_ADD_HOTEL_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-hotellist/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter hotel name in textbox$")
	public void enter_hotel_name_in_textbox() throws Throwable {
		driver.findElement(By.name("hotelName")).sendKeys("Sansruti");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter location in textbox$")
	public void enter_location_in_textbox() throws Throwable {
		driver.findElement(By.name("location")).sendKeys("Nidah Nagar,MG-Road,Pune");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter image url in textbox$")
	public void enter_image_url_in_textbox() throws Throwable {
		driver.findElement(By.name("imageUrl")).sendKeys("sdfghjkljhgdfghj.jpg");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter mobile number in textbox$")
	public void enter_mobile_number_in_textbox() throws Throwable {
		driver.findElement(By.name("phoneNo")).sendKeys("8788151739");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[5]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@When("^close the ADD HOTEL pop up$")
	public void close_the_ADD_HOTEL_pop_up() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/div/button/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/********************************
	 * Delete Room Operation
	 ***************************************************/
	
	@When("^click on the ROOMLIST link$")
	public void click_on_the_ROOMLIST_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ROOMLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on DELETE button$")
	public void click_on_DELETE_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-roomlist/div/table/tbody/tr[2]/td[10]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^selected room must be deleted$")
	public void selected_room_must_be_deleted() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ROOMLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/*********************update hotel********************/

@When("^click on HotelList link$")
public void click_on_HotelList_link() throws Throwable {
	driver.findElement(By.xpath("//a[text()='HOTELLIST']")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^click on update button$")
public void click_on_update_button() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-hotellist/div[2]/table/tbody/tr[1]/td[7]/button")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^enter location$")
public void enter_location() throws Throwable {
	driver.findElement(By.name("location")).sendKeys("Arni road Yavatmal");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


@When("^click on update hotel button$")
public void click_on_update_hotel_button() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"exampleModal1\"]/div/div/div[2]/form/div[5]/button[2]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


@When("^click on cross pop up$")
public void click_on_cross_pop_up() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"exampleModal1\"]/div/div/div[1]/div/button")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

/***********************************Add room***************************/

@Given("^click on add room button$")
public void click_on_add_room_button() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-hotellist/div[2]/table/tbody/tr[1]/td[6]/button")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Given("^entr the room id$")
public void entr_the_room_id() throws Throwable {
	driver.findElement(By.name("roomId")).sendKeys("401");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Given("^select room type$")
public void select_room_type() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"roomType\"]/option[2]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Given("^select room capacity$")
public void select_room_capacity() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"roomCapacity\"]/option[3]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Given("^select room status$")
public void select_room_status() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"roomStatus\"]/option[2]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Given("^enter room rent$")
public void enter_room_rent() throws Throwable {
	driver.findElement(By.name("roomRent")).sendKeys("1200");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Given("^enter image url$")
public void enter_image_url() throws Throwable {
	driver.findElement(By.name("imageUrl")).sendKeys("sdfghj.jpg");
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
 
@Given("^click on the submit room button$")
public void click_on_the_submit_room_button() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-addroom/div/form/div/div/div[10]/button[2]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

/***********************************Customer Details***************************/

@Then("^click on GUESTLIST link,list must be displayed$")
public void click_on_GUESTLIST_link_list_must_be_displayed() throws Throwable {
	driver.findElement(By.xpath("//a[text()='GUESTLIST']")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

/***********************************Add Employee***************************/

@Given("^click on addEmployee link$")
public void click_on_addEmployee_link() throws Throwable {
	driver.findElement(By.xpath("//a[text()='ADD EMPLOYEE']")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@When("^enter valid employee name in textbox$")
public void enter_valid_employee_name_in_textbox() throws Throwable {
	driver.findElement(By.name("employeeName")).sendKeys("Roshan");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^enter valid email id in textbox$")
public void enter_valid_email_id_in_textbox() throws Throwable {
	driver.findElement(By.name("email")).sendKeys("roshan@gmail.com");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^enter valid mobile number in textbox$")
public void enter_valid_mobile_number_in_textbox() throws Throwable {
	driver.findElement(By.name("phoneNo")).sendKeys("8765432189");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^enter valid hotel id in textbox$")
public void enter_valid_hotel_id_in_textbox() throws Throwable {
	driver.findElement(By.name("hotelId")).sendKeys("1");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^enter valid hotel name in textbox$")
public void enter_valid_hotel_name_in_textbox() throws Throwable {
	driver.findElement(By.name("hotelName")).sendKeys("Sukhakarta");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


@Given("^enter valid adhar no in textbox$")
public void enter_valid_adhar_no_in_textbox() throws Throwable {
	driver.findElement(By.name("adharNo")).sendKeys("787878787878");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^enter valid password in textbox$")
public void enter_valid_password_in_textbox() throws Throwable {
	driver.findElement(By.name("password")).sendKeys("Roshan123");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^enter same password to confirm$")
public void enter_same_password_to_confirm() throws Throwable {
	driver.findElement(By.name("password2")).sendKeys("Roshan123");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^click on REGISTER button,employee must be added in database$")
public void click_on_REGISTER_button_employee_must_be_added_in_database() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-addemployee/div/form/div/div[4]/button[1]")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}



}

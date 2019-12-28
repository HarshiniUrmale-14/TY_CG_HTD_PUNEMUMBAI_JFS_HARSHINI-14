Feature: Testing of employee related operations

Background: 
Given The employee has loaded the application in the browser
When employee click on the login link
And the employee enters the  valid email id in the input box
And the employee enters the valid  password in the input box
And click on the login button ,dashboard page must be displayed


@Feature5
Scenario: Verifying book room feature 
And click on BOOK ROOM link
And click on BOOK NOW button
And enter valid user id in textbox
And enter valid user name in textbox
And select check in date 
And select check out date 
And click on submit button
And select mode of payment
Then click on submit button,room must be booked and payment should be done

@Feature6
Scenario: Verifying the functionality of logout button
Then click on the LOGOUT button, home page must be displayed




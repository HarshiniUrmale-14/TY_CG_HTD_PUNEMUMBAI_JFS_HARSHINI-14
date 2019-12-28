Feature: Testing of management related operations

Background: 
Given The management has loaded the application in the browser
When management click on the login link
And the management enters the  valid email id in the input box
And the management enters the valid  password in the input box
And clicks on the login button ,dashboard page must be displayed


@Feature1
Scenario: Verifying add admin feature 
And click on ADD ADMIN link
And enter valid admin name in textbox
And enter valid email id in textbox
And enter valid mobile number in textbox
And enter valid adhar number in textbox
And select nationality
And enter valid password in textbox
And enter same password to confirm
Then click on register button, admin must be added in the database


@Feature2
Scenario: Verifying view bill feature
Then click on VIEWBILL link , the bill details must be displayed

@Feature3
Scenario: Verifying user details feature
Then click on USERDETAILS  link,the user details must be displayed

@Feature4
Scenario: Verifying the logout button
Then click on LOGOUT button, home page must be displayed




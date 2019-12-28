Feature: Testing the user related operations

Background:
Given the user has loaded the application in the browser
When user enters the valid email in the textbox
And the user enters valid password in the textbox
And user click on the LOGIN button

@Feature7
Scenario: Verifying the functionality of book hotel feature
And the user click on BOOK HOTEL link
And click on VIEW ROOMS button
And user click on BOOK NOW button
And user select check in date
And user select check out date
And click on select button
And user select mode of payment
Then click on submit button,hotel must be booked

@Feature8
Scenario: Verify the list of booked rooms of user 
Then click on BOOKING HISTORY link, list must be displayed

@Feature9
Scenario: Verifying th efuctionality of  logout button
Then click on LOGOUT button, home page should be displayed
Feature: Testing the admin related features

Background:
Given the admin has loaded the application in the browser
When admin click on login link
And the admin enters valid email in the emailbox
And the admin enters valid password in the password textbox
And the admin clicks on the login button
And the dashboard page must be displayed

@Function1
Scenario: Verifying delete operation on hotel
And click on HOTELLIST link
And click on the DELETE button
Then selected hotel details must be deleted

@Function2
Scenario: Verifying add operation on hotel
And click on the HOTELLIST link
And click on the ADD HOTEL button
And enter hotel name in textbox
And enter location in textbox
And enter image url in textbox
And enter mobile number in textbox
And click on submit button
And close the ADD HOTEL pop up

@Function3
Scenario: Verifying delete operation on room
And click on the ROOMLIST link
And click on DELETE button
Then selected room must be deleted 

@Function4
Scenario: Verifying update hotel operation
And click on HotelList link
And click on update button
And enter location
And click on update hotel button
And click on cross pop up 

@Function5
Scenario: Verifying add romm operation
Given click on HotelList link
And click on add room button
And entr the room id 
And select room type
And select room capacity
And select room status
And enter room rent
And enter image url
And click on the submit room button

@Function7
Scenario: Verify the customer details 
Then click on GUESTLIST link,list must be displayed

@Function8
Scenario: Verifying the functionality of add employee feature
Given click on addEmployee link
And enter valid employee name in textbox
And enter valid email id in textbox
And enter valid mobile number in textbox
And enter valid hotel id in textbox
And enter valid hotel name in textbox
And enter valid adhar no in textbox
And enter valid password in textbox
And enter same password to confirm
And click on REGISTER button,employee must be added in database 

@Function9
Scenario: Verifying th efuctionality of  logout button
Then click on LOGOUT button, home page should be displayed



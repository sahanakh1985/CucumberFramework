Feature:Login into Salesforce Application

Scenario:Login into Salesforce with valid UN and invalid PWD

Given user is on "LoginPage"
When User enter  into textbox "Username" "Sahana@tek.com"
When User enter  into textbox "Password" "Siri@123"
When user clicks on radioButton
When user clicks on login button
Then user is on "HomePage"

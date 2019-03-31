@registration @uitest
Feature: User registration feature
	This feature will test all positive and negative scenarios


	Background: User navigates to registration page
	  	Given User navigates to new user registration page using browser from env json

	@smoke @positive
	Scenario Outline: Verify that user is able to register with unique name, unique email and password
		When User enters unique name as <name>
		And User enters unique email as <email>
		And User enters password as <password> for registration
  		Then User registration is successful and user navigates to all users page 'All User'
		Then Verify user details on all users page
		Examples:
			| name  	| email		| password  |
			| test		| test 		| Abcd1234  |
			| qaauto	| qaauto 	| Pass123   |


	@negative
	Scenario Outline: Test data:: This scenario is required before running all error scenarios
		When User enters name as <name>, email as <email> and password as <password>
		Then User registration is successful and user navigates to all users page 'All User'
		Then Verify user details on all users page
		Examples:
			| name  | email        | password|
			| #$%#@	| ^%$&@590.com | #^%$&^  |
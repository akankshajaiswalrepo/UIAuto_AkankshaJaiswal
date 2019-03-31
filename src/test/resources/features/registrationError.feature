@registration @uitest
Feature: User registration validating errors
	This feature will test all error scenarios of user registration page


	Background: User navigates to registration page
		Given User navigates to new user registration page using browser from env json


	@pre-requisite @test-data @smoke
	Scenario Outline: Test data:: This scenario is required before running all error scenarios
		When User enters name as <name>, email as <email> and password as <password>
		Examples:
			| name  	| email		   | password  |
			| sample	| sample@gmail.com | Pqrs1234  |


	@error @smoke
	Scenario Outline: Verify that user gets error when unique name is not provided for registration
		When User enters name as <name>, email as <email> and password as <password>
		Then User registration fails for name uniqueness with error 'Must be unique'
		Then User remains on new user page 'New User'
		Examples:
			| name  	| email		  	    | password  |
			| sample	| sample1@gmail.com | Qwer1234  |


	@error
	Scenario Outline: Verify that user gets error when unique email is not provided for registration
		When User enters name as <name>, email as <email> and password as <password>
		Then User registration fails for email uniqueness with error 'Must be unique'
		Then User remains on new user page 'New User'
		Examples:
			| name   | email			| password  |
			| sample1| sample@gmail.com | Pass1234  |


	@error @negative
	Scenario Outline: Verify that user gets error when invalid email is provided for registration
		When User enters name as <name>, email as <email> and password as <password>
		Then User registration fails for invalid email with error 'Invalid email address'
		Then User remains on new user page 'New User'
		Examples:
			| name    | email				| password  |
			| sample2 | sample@@gmail.com    | Inva1234  |
			| sample2 | samplegmail.com      | Inva1234  |
			| sample2 | ^%$&@123#.com        | Inva1234  |


	@error
	Scenario Outline: Verify that user gets error when password is less than 6 characters
		When User enters name as <name>, email as <email> and password as <password>
		Then User registration fails for password minimum characters with error 'Minimum size is 6'
		Then User remains on new user page 'New User'
		Examples:
			| name   | email				| password  |
			| sample3| sample3@gmail.com    | test  	|

	@error
	Scenario Outline: Verify that user gets error when confirm password are not same
		When User enters name as <name>, email as <email> and not same password as <password>
		Then User registration fails for password not same with error 'passwords are not the same'
		Then User remains on new user page 'New User'
		Examples:
			| name   | email			| password  |
			| sample4| sample4@gmail.com| test123 	|


	@error
	Scenario Outline: Verify that user gets error when no name, email and password are provided
		When User enters name as <name>, email as <email> and not same password as <password>
		Then User registration fails for name uniqueness with error 'Required'
		Then User registration fails for email uniqueness with error 'Required'
		Then User registration fails for invalid email with error 'Required'
		Then User remains on new user page 'New User'
		Examples:
			| name   | email | password  |
			| 		 |	     | 		 	 |
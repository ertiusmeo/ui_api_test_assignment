
#Selenium Webdriver Java Tests

## Description
This is automation test suite for http://qa-recruitment-newsletter.s3-website-eu-west-1.amazonaws.com/, using Selenium with Java, TestNG and Maven.


## Features
1. PageObjects 
2. TestNG test framework support [ http://testng.org/doc/index.html ]
3. Maven Support - Software project management
4. Multi-browser support

## Test Application
Application for signing in newsletter.

## Automated Tests
tc_001_successfulSubscriptionWithRequiredField: 
Checking successful subscription with required fields only.

tc_002_successfulSubscriptionWithAllFields:
Checking successful subscription with all fields.

tc_003_requiredFieldEmpty:
Checking unsuccessful subscription without required field

tc_004_requiredFieldRemoved
Checking unsuccessful subscription after removing required field

tc_005_endDateError
Checking validation rule for end date field

tc_006_endDateRemoved
Checking successful subscription without end date

## Prerequisites Software/Tools
1. Java Development Kit 8
2. Java Runtime Environment 8
3. IDE [IntelliJ IDEA or Eclipse]

## Getting Started
1. Clone the project on the target directory
2. Once the project is cloned successfully, build the projec in IDE. Use pom.xml file to resolve dependencies if needed.
3. Run test from NewsletterTests class.
 

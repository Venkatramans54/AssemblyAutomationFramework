# Automation Framework for Assembly

This Framework is developed to automate a few uses in Assembly Application.\
[Assembly](https://www.joinassembly.com/)

## Technology Stack

1. [Java](https://www.java.com/en/)
2. [Maven](https://maven.apache.org/)
3. [Selenium Webdriver](https://www.selenium.dev/maven/)
4. [TestNG](https://testng.org/doc/)
5. [Extent Spark Report](https://github.com/extent-framework/extentreports-java/wiki/A-Complete-Example) 
6. [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)

## Key Features

- Cross Browser Testing Support for Chrome and Firefox
- Automatic Driver Management with WebDriver Manager
- Graphical Reporting with Extent Reports
- Data Driven with JSON
- Designed with Page Object Model Architecture

## Execution in Eclipse

- Clone this repository to your local
- Import the project into Eclipse and wait till the dependencies are downloaded
- Right Click on the testsuite and Run As - TestNG Suite.

## Execution in Command Prompt

- Install Java and Maven in your Machine
- Clone this repository to your local
- Execute the following commands

```bash
cd AssemblyAutomation
mvn clean test -DsuiteName=WebTestSuite.xml
```

## Documents

You can Find Execution Recordings and Framework Document in the following Link.\
[Execution Videos and Framework Document](https://drive.google.com/drive/folders/1teBpxLf4FoPMcklOwSsnfQpEXM_d8_yL?)

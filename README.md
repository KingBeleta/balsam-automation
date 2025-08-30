# balsam-automation

Description

Automated testing framework for Balsam’s e-commerce platform using Selenium WebDriver and TestNG. Features dynamic step logging, screenshots, reusable Page Object Model structure, and detailed HTML reports via ExtentReports.

Features
Page Object Model (POM) structure
Dynamic step logging with screenshots
Assertions with pass/fail status in reports
ExtentReports HTML reports
Configurable browser setup (Chrome, Firefox, Incognito)
Randomized option selection for tests
Easy integration with CI/CD pipelines
Prerequisites
Java 17+ installed
Maven installed
Git installed (optional for cloning)
Browsers: Chrome, Firefox

Project Setup
Clone the repository:
git clone <repository-url>


Navigate to project:
cd balsam-automation


Install dependencies:
mvn clean install

Running Tests
Run a single test file:
mvn test -Dtest=BalsamCartTest


Run via testng.xml:
mvn test -DsuiteXmlFile=src/test/resources/testng.xml

Reports
After each run, HTML reports are generated in the reports/ folder.

Screenshots are saved in the screenshots/ folder.

Notes

Tests are designed to dynamically select available product options.

Framework supports adding new test cases easily using Page Objects.

**Monefy App**

Monefy is a personal finance application that makes money management easy. The app is designed to streamline expense tracking and help you save money.

**Test cases covered in the automation suite:**

Covered high priority test cases in automation because they interact with customer data directly. A disparity in client’s data would cause a defect in client’s financial logs and can harm business reputation.

Dashboard Tests

1. Verify user can click on new income. (Priority: High)
1. Verify user can click on new expense. (Priority: High)
1. Verify user can add new expense from the dashboard new expense shortcut icon like food, bills, clothes. (Priority: High)
1. Verify that balance is updated correctly when user updates add new expense from the dashboard new expense shortcut icon. (Priority: High)

` `New Income Tests

1. Verify user can record income on new income page. (Priority: High)
1. Verify that balance is correctly displayed when user records new income. (Priority: High)
1. Verify user can record multiple incomes like Deposits, Savings, Salary. (Priority: High)
1. Verify that balance is added correctly when user records multiple new incomes. (Priority: High)
1. Verify that user can update the existing income. (Priority: High)
1. Verify that balance is displayed correctly when updating the existing income. (Priority: High)
1. Verify that user can delete the existing balance. (Priority: High)
1. Verify that balance is displayed correctly when deleting the existing balance. (Priority: High)

New Expense Tests

1. Verify user can record expense on new expense page. (Priority: High)
1. Verify that balance is correctly displayed when user records new expense. (Priority: High)
1. Verify user can record multiple expenses like Bills, Cars, Clothes. (Priority: High)
1. Verify that balance is displayed correctly when user records multiple new expenses. (Priority: High)
1. Verify that user can update the existing expense. (Priority: High)
1. Verify that balance is displayed correctly when updating the existing expense. (Priority: High)
1. Verify that user can delete the existing expense. (Priority: High)
1. Verify that balance is displayed correctly when deleting the existing expense. (Priority: High)

Transfer Tests

1. Verify that user can click transfer on the dashboard. (Priority: High)
1. Verify that user navigates to new transfer page when click transfer icon. (Priority: High)
1. Verify that user can enter amount to transfer from Cash to Card. (Priority: High)
1. Verify that user can open accounts when clicking three dots. (Priority: High)
1. Verify that amount has been deducted from the Cash and credited into Card. (Priority: High)

Other Tests:

1. Verify enable/disable of Monthly budget by Budget Mode setting and it shall be displayed over Balance Pie Chart. (Priority: Medium)
1. Verify enable/disable of Carry Over setting and it shall be displayed over Balance Pie Chart. (Priority: Medium)
1. Verify Selection of All Accounts/Cash/Payment Card shall populate correct results on Dashboard Screen. (Priority: Medium)
1. Verify Selection of "Day" shall populate correct data on Dashboard Screen. (Priority: Medium)
1. Verify Selection of "Week" shall populate correct data on Dashboard Screen. (Priority: Medium)
1. Verify Selection of "Month" shall populate correct data on Dashboard Screen. (Priority: Medium)
1. Verify Selection of "Year" shall populate correct data on Dashboard Screen. (Priority: Medium)
1. Verify Selection of "Past Date" and "Future date" shall populate correct data on Dashboard Screen. (Priority: Medium)
1. Verify Create, Restore and Delete database operations, delete shall be performed on local and cloud data as well. (Priority: Medium)
1. Verify addition of income amount with New Category creation and note. (Priority: Low)
1. Verify addition of expense amount with New Category creation and note. (Priority: Low)


**Outline of automating proposed scenarios on different levels of testing pyramid.**

The testing pyramid is a concept that group software into three categories. This helps QA professionals to ensure quality, reduce the time it takes to find root cause of bug, and build more reliable suite.

From top to bottom, the main layer include:

1. UI/Exploratory tests
1. Integration tests
1. Unit tests

UI/ Exploratory tests generally lie at the top layer of the pyramid which are generally are more complex and have more dependencies than unit and integrations tests. Our automation suite has been implemented based on the top layer of the pyramid. Following are the pros and cons list:

Pros: 

1. Tests from user perspective.
1. Verifies end to end workflow of the application.
1. Reduces number of errors found in production.

Cons:

1. Slow execution time as it performs end to end test on workflows.
1. Test flakiness as it requires maintenance and trouble shooting if change in workflows.

**Technical Document:** 

Tech Stack, Libraries and Dependencies used:

- Java JDK 15.0.2
- NodeJS
- Android SDK
- Appium Inspector
- Appium Server GUI
- Appium Libraries
- Selenium Libraries
- TestNG
- Maven

**Project Specification:**

Appium has been used for automating the Monefy application which is an opensource test automation tool for native, hybrid and mobile web applications.

Page Object Model design pattern approach has been used for storing objects and maintaining test in separate folder. It is useful in reducing code duplication and improves test case maintenance.

**Folder structure:**

Config.properties: contains the app name, device name and platform version

Pages: contains all the class files for different pages that includes all the page objects and methods specific for that page.

Tests: contains all the class files for different pages test cases and scenarios

Monefy.apk is contained in the src folder.

Pom.xml: contains the maven dependencies.

**To run the tests**

1. Clone the project from the repository shared.
1. Download the maven dependencies.
1. Run the testng.xml file using TestNg.

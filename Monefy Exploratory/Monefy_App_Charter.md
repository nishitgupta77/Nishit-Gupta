|Charter 1: Testing of income/ expense functionality| |
|:----|:----|
|Coverage Area|Testing of areas involving transactions:
||-Adding income and expense using +/- icon
-Adding expense using the icons on the dashboard
-Changing added values from Balance and checking update|
|Test Environment|Production|
|Platform|Android 11, iOS 15.5|
|Tester|Nishit Gupta|
|Time Started|03-June-2022, 4:00 PM|
|Duration |30 minutes|
|Priority|High|
|Test Notes|1. Add income using the "+" icon, add notes and category.    i. Add negative income, unable to add.
   ii. Add maximum income, Can add upto 9 digits (INR).
  iii. Add category, click to add new category - should ask for premium account.
  iv. Add income, notes and existing category - able to save, check if balance is updated.|
| |2. Add expense using the "-" icon, add notes and category.    i. Add negative expense, unable to add.
   ii. Add maximum expense, Can add upto 9 digits (INR).
  iii. Add category, click to add new category - should ask for premium account.
  iv. Add expense, notes and existing category - able to save, check if balance is updated.|
| |3. Add expense using the dashboard icons.
   i. Check balance after updating the expense.
  ii. Check expense status - match it with the category selected.
  iii. Add multiple categories and check if the percentage is updated on the dashboard for selected category.|
| |4. Update added income and expense added.
   i. Choose an added income, update it - check if the balance is updated.
  ii. Choose an added expense, update it - check if the balance is updated.
  iii. Delete an added expense or income - check if balance is updated.|
|Bugs|Found on iOS 15.5 with INR currency set
Bug Details: Negative sign not appearing when adding expense higher than income in balance.
Reproduction steps:
1. Add income Eg. INR 3,000
2. Add Expense Eg. INR 5,000
Expected outcome:
Balance should be updated as -INR 2000 or INR -2000
Actual outcome:
Balance is updated as INR 2000
Notes: Unable to verify on android, currency change requires premium account. Current currency set as dollar.|
|Risk|1. Since this application deals with finanacial transaction logs so a thorough testing (Regression testing and volume testing) around these areas is required to mitigate any risks.
Areas: Income/Expense Addition, Updating , Deletion.|

------------------------------------------------------------------------------------------------------------------

|Charter 2: Testing of transfer functionality| |
|:----|:----|
|Coverage Area|Testing of areas involving transfer:
-Checking transfer functionality
-Checking account status after transfer|
|Test Environment|Production|
|Platform|Android 11, iOS 15.5|
|Tester|Nishit Gupta|
|Time Started|04-June-2022, 3:00 PM|
|Duration |20 minutes|
|Priority|High|
|Test Notes|1. Click on transfer icon on home page
  i. Choose cash to card option, add note and amount - check account status, it should be updated - cash to card must be transferred|
| |2. Click on transfer icon on home page
  i. Choose card to cash option, add note and amount - check account status, it should be updated - card to cash must be transferred|
| |3. Click on transfer icon on home page
  i. Choose cash to card option, add amount - check by adding transfer amount greater than the available cash balance - cash would be changed to negative amount and card would be added.|
| |4. Check by transferring from cash to cash account or card to card account - unable to add tranfer amount|
| |5. Open accounts, click on transfer and perform above tests 1 - 4.|
|Bugs|Found on iOS 15.5 with INR currency set
Bug Details: Negative sign not appearing when adding transfer amount higher than available in balance.
Reproduction steps:
1. Available cash is 1000
2. Perform cash to card transfer of 2000
Expected outcome:
Balance should be updated as -INR 1000 or INR -1000 in cash
Actual outcome:
Balance is updated as INR 1000 in cash
Notes: Unable to verify on android, currency change requires premium account. Current currency set as dollar.|
|Risk|1. Since this application deals with finanacial transaction logs so a thorough testing (Regression testing and volume testing) around these areas is required to mitigate any risks.
Areas: Transfer amount|

-----------------------------------------------------------------------------------------------------------------

|Charter 3: Testing of search functionality| |
|:----|:----|
|Coverage Area|Testing of areas involving transfer:
-Checking search functionality|
|Test Environment|Production|
|Platform|Android 11, iOS 15.5|
|Tester|Nishit Gupta|
|Time Started|05-June-2022, 3:00 PM|
|Duration |15 minutes|
|Priority|Low|
|Test Notes|1. Click on search icon on home page
 i. Check qwerty keyboard is triggered.
ii. Check recent searches is displayed.
iii. Check that placeholder Search records is displayed.
iv. Check user can click on recent search. |
| |2. Enter search records on search.
i. Check can search for different Income types.
ii. Check can search for different expense types.
iii. Check can search for notes of Income types.
iv. Check can search for notes of Expense types.
v. Check can search for Income amount.
vi. Check can search for Expense amount.|
| |3. Enter non existing search itemsi. Should give message "No records have been found."|
| |4. Search recent items
i. Check maximum 3 records displayed for recent search.
ii. Check most recent search is displayed on top.
iii. Check user lands on correct page when clicking on recent search.
iv. Check user gets search suggestion when searching for records. |
| | |
|Bugs|No bugs Observerd.|

----------------------------------------------------------------------------------------------------------------

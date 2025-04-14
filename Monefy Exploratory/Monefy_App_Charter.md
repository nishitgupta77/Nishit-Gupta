
# QA Test Report

---

## Charter 1: Income/Expense Functionality Testing

### 📌 Coverage Area
- Adding income and expense via **+ / - icons**
- Adding expense via **dashboard icons**
- Updating values from **Balance** and verifying updates

### 🧪 Test Environment
- **Environment:** Production  
- **Platform:** Android 15, iOS 18.4 
- **Tester:** Nishit Gupta  
- **Start Time:** 12-April-2025, 4:00 PM  
- **Duration:** 30 minutes  
- **Priority:** High  

### 📝 Test Notes
1. **Income Addition (+ icon)**  
   - ❌ Negative income not allowed  
   - ✅ Maximum: up to 9 digits (INR)  
   - 🔒 Adding new category prompts for premium upgrade  
   - ✅ Able to add income with notes and existing category; balance updates accordingly  

2. **Expense Addition (- icon)**  
   - ❌ Negative expense not allowed  
   - ✅ Maximum: up to 9 digits (INR)  
   - 🔒 Adding new category prompts for premium upgrade  
   - ✅ Able to add expense with notes and existing category; balance updates accordingly  

3. **Expense via Dashboard Icons**  
   - ✅ Check balance after each expense  
   - ✅ Match expense status with selected category  
   - ✅ Multiple categories update dashboard percentage correctly  

4. **Editing Entries**  
   - ✅ Update added income → balance updates  
   - ✅ Update added expense → balance updates  
   - ✅ Delete entries → balance updates  

### 🐞 Bugs
- **Platform:** iOS 18.4  
- **Issue:** Negative balance not displayed properly  
- **Steps to Reproduce:**  
   1. Add Income: INR 3,000  
   2. Add Expense: INR 5,000  
   3. Expected: Balance = -INR 2,000  
   4. Actual: Balance = INR 2,000  
- **Note:** Could not verify on Android due to currency change restriction (premium account required)

### ⚠️ Risk
- This module involves **financial transactions**, so **thorough regression and volume testing** is essential.  
- Focus areas: **Addition, Update, Deletion** of income/expenses.

---

## Charter 2: Transfer Functionality Testing

### 📌 Coverage Area
- Transfer feature testing  
- Account status post-transfer

### 🧪 Test Environment
- **Environment:** Production  
- **Platform:** Android 15, iOS 18.4  
- **Tester:** Nishit Gupta  
- **Start Time:** 12-April-2025, 4:00 PM 
- **Duration:** 20 minutes  
- **Priority:** High  

### 📝 Test Notes
1. **Transfer: Cash ➡️ Card**  
   - ✅ Add note & amount, balance updates correctly  

2. **Transfer: Card ➡️ Cash**  
   - ✅ Add note & amount, balance updates correctly  

3. **Exceeding Available Balance**  
   - ✅ Cash to Card with excess amount → cash shows negative balance, card updates  

4. **Invalid Transfers**  
   - ❌ Transfers from cash-to-cash or card-to-card not allowed  

5. **Same Scenarios from Accounts Page**  
   - ✅ All steps above tested from Accounts > Transfer  

### 🐞 Bugs
- **Platform:** iOS 18.4  
- **Issue:** Negative balance not displayed correctly  
- **Steps to Reproduce:**  
   1. Available cash: INR 1,000  
   2. Transfer: Cash to Card → INR 2,000  
   3. Expected: Cash = -INR 1,000  
   4. Actual: Cash = INR 1,000  
- **Note:** Android check not possible (currency locked to dollar)

### ⚠️ Risk
- Critical area involving **money movement between accounts**.  
- Requires **regression and volume testing** to ensure no transaction anomalies.

---

## Charter 3: Search Functionality Testing

### 📌 Coverage Area
- Testing the in-app **search functionality**

### 🧪 Test Environment
- **Environment:** Production  
- **Platform:** Android 15, iOS 18.4  
- **Tester:** Nishit Gupta  
- **Start Time:** 12-April-2025, 3:00 PM  
- **Duration:** 15 minutes  
- **Priority:** Low  

### 📝 Test Notes
1. **Initial UI Check**  
   - ✅ Keyboard appears  
   - ✅ Placeholder "Search records" visible  
   - ✅ Recent searches shown & clickable  

2. **Search Capabilities**  
   - ✅ Search by income/expense types  
   - ✅ Search by notes and amounts  

3. **No Results**  
   - ✅ Non-matching terms show: “No records have been found.”  

4. **Recent Searches**  
   - ✅ Max 3 records  
   - ✅ Most recent on top  
   - ✅ Clicking item navigates correctly  
   - ✅ Suggestions appear while typing  

### 🐞 Bugs
- None observed ✅

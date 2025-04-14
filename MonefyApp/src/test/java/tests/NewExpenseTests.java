package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import pages.DashboardPage;
import pages.NewExpensePage;
import pages.NewIncomePage;
import pages.NewIncomePage.IncomeType;
import pages.TransactionPage;
import util.ExtentTestNGListener;

public class NewExpenseTests extends BaseClass {
		
	public DashboardPage dashboardPage;
	public NewIncomePage newIncomePage;
	public NewExpensePage newExpensePage;
	public TransactionPage transactionPage;
	
	@BeforeMethod
	public void Initialize() {
		dashboardPage = new DashboardPage(driver);	
		newIncomePage = new NewIncomePage(driver); 
		transactionPage = new TransactionPage(driver);
		newExpensePage = new NewExpensePage(driver);

	}

	@Test
	public void AddNewExpenseTest() throws InterruptedException
	{
		
		int incomeAmount = 500;
		int expenseAmount = 20;

		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome(Integer.toString(incomeAmount),IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount));

		//2. Add New Expense amount as Bills
		dashboardPage.clickNewExpense();
		newExpensePage.addNewExpense(Integer.toString(expenseAmount), "Bills");

		//3. Verify the Balance amount
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount-expenseAmount));
	}
	
	@Test
	public void AddMultipleExpenseTest() throws InterruptedException
	{
		int incomeAmount = 500;
		int expenseAmount = 20;
		int balanceAmount = incomeAmount;

		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome(Integer.toString(incomeAmount),IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount));

		//2. Add New Expense amount as Bills
		dashboardPage.clickNewExpense();
		newExpensePage.addNewExpense(Integer.toString(expenseAmount), "Bills");
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(balanceAmount -= expenseAmount));

		//3. Add New Expense amount as Cars
		dashboardPage.clickNewExpense();
		newExpensePage.addNewExpense(Integer.toString(expenseAmount), "Car");
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(balanceAmount -= expenseAmount));

		//4. Add New Expense amount as Cars
		dashboardPage.clickNewExpense();
		newExpensePage.addNewExpense(Integer.toString(expenseAmount), "Clothes");
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(balanceAmount -= expenseAmount));
		
	}
	
	@Test
	public void UpdateExpenseTest() throws InterruptedException
	{
		int incomeAmount = 500;
		int expenseAmount = 20;
		int newExpenseAmount = 30;

		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome(Integer.toString(incomeAmount), IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount));

		//2. Add New Expense amount as Bills
		dashboardPage.clickNewExpense();
		newExpensePage.addNewExpense(Integer.toString(expenseAmount), "Bills");

		//3. Verify the Balance amount
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount-expenseAmount));

		//4. Update transaction amount to new transaction amount
		dashboardPage.clickBalanceAmount();
		transactionPage.openTransactionType("Bills");
		transactionPage.clearTransaction();
		newExpensePage.addNewExpense(Integer.toString(newExpenseAmount), "Bills");

		//5. Verify balance after new transaction amount
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount-newExpenseAmount));
		
	}
	
	@Test
	public void DeleteExpenseTest() throws InterruptedException
	{
		int incomeAmount = 500;
		int expenseAmount = 20;

		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome(Integer.toString(incomeAmount),IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount));

		//2. Add New Expense amount as Bills
		dashboardPage.clickNewExpense();
		newExpensePage.addNewExpense(Integer.toString(expenseAmount), "Bills");

		//3. Delete Expense transaction amount
		dashboardPage.clickBalanceAmount();
		transactionPage.openTransactionType("Bills");
		transactionPage.deleteTransaction();
		dashboardPage.clickBalanceAmount();

		//4. Verify expense transaction is deleted
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(incomeAmount));
		
	}

}

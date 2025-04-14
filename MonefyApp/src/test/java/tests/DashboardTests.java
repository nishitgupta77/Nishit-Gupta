package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import pages.DashboardPage;
import pages.NewExpensePage;
import pages.NewIncomePage;
import pages.TransactionPage;

public class DashboardTests extends BaseClass {
		
	public DashboardPage dashboardPage;
	public NewExpensePage newExpensePage;
	public TransactionPage transactionPage;
	
	@BeforeMethod
	public void Initialize() {
		dashboardPage = new DashboardPage(driver);	
		newExpensePage = new NewExpensePage(driver);
		transactionPage = new TransactionPage(driver);
	}

	
	@Test
	public void iconExpenseTest() throws InterruptedException
	{
		int expense = 200;
		int initialBalance = Integer.parseInt(dashboardPage.getBalanceAmount());
		dashboardPage.chooseExpenseIcon();
		newExpensePage.confirmExpense(Integer.toString(expense));
		int finalBalance = Integer.parseInt(dashboardPage.getBalanceAmount());
		Assert.assertEquals(finalBalance, (initialBalance-expense));
	}
	
}

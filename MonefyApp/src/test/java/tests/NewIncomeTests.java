package tests;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import pages.DashboardPage;
import pages.NewIncomePage;
import pages.TransactionPage;
import util.ExtentTestNGListener;
import pages.NewIncomePage.IncomeType;

public class NewIncomeTests extends BaseClass {
		
	public DashboardPage dashboardPage;
	public NewIncomePage newIncomePage;
	public TransactionPage transactionPage;
	
	@BeforeMethod
	public void Initialize() {
		dashboardPage = new DashboardPage(driver);	
		newIncomePage = new NewIncomePage(driver); 
		transactionPage = new TransactionPage(driver);
	}

	@Test
	public void AddNewIncomeTest() throws InterruptedException, IOException
	{
	
		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome("500",IncomeType.DEPOSIT);
		//2. Verify that amount Balance is correctly displayed on dashboard page
		Assert.assertEquals(dashboardPage.getBalanceAmount(), "500");
		
	}
	
	@Test
	public void AddMultipleIncomeTest() throws InterruptedException
	{
		//1. Initial Amount added as Deposit Income
		int amount = 500;
		int newAmount = amount;
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome(Integer.toString(amount), IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(amount));

		//2. Amount of 500 added as Salary Income
		dashboardPage.clickNewIncome();	
		newIncomePage.addNewIncome(Integer.toString(amount), IncomeType.SALARY);		 
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(newAmount += amount));

		//3. Amount of 500 added as Savings 
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome(Integer.toString(amount), IncomeType.SAVINGS);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), Integer.toString(	newAmount += amount));
		
	}

	@Test
	public void UpdateIncomeTest() throws InterruptedException
	{   
		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome("500",IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), "500");

		//2. Open transaction page
		dashboardPage.clickBalanceAmount();
		transactionPage.openTransaction();
		transactionPage.clearTransaction();

		//3. Update new Transaction amount
		newIncomePage.addNewIncome("700",IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), "700");
		
	}
	
	@Test
	public void DeleteIncomeTest() throws InterruptedException
	{   
		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome("500",IncomeType.DEPOSIT);
		Assert.assertEquals(dashboardPage.getBalanceAmount(), "500");
		dashboardPage.clickBalanceAmount();
		transactionPage.openTransaction();

		//2. Delete Amount from the transaction 
		transactionPage.deleteTransaction();
		dashboardPage.clickBalanceAmount();
		Assert.assertEquals(dashboardPage.getBalanceAmount(), "0");
		
	}

}

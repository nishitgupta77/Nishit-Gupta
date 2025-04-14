package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import pages.DashboardPage;
import pages.NewIncomePage;
import pages.TransactionPage;
import pages.TransferPage;
import pages.NewIncomePage.IncomeType;

public class TransferTests extends BaseClass {
		
	public DashboardPage dashboardPage;
	public NewIncomePage newIncomePage;
	public TransactionPage transactionPage;
	public TransferPage transferPage;
	
	@BeforeMethod
	public void Initialize() {
		dashboardPage = new DashboardPage(driver);	
		newIncomePage = new NewIncomePage(driver); 
		transactionPage = new TransactionPage(driver);
		transferPage = new TransferPage(driver);
	}

	@Test
	public void AddTransfer() throws InterruptedException
	{
		String income = "1000";
		String transferAmt = "500";
		
		//1. Initial Amount added as Deposit Income
		dashboardPage.clickNewIncome();
		newIncomePage.addNewIncome(income,IncomeType.DEPOSIT);
		//2. Add Transfer
		dashboardPage.clickTransfer();
		transferPage.openInputAmount();
		newIncomePage.clickKeyBoardCharacters(transferAmt);
		transferPage.addTransfer();
		//3. Check transfer status in accounts
		dashboardPage.openAccounts();
		int actualCash = Integer.parseInt(dashboardPage.getAmount("Cash"));
		int actualCard = Integer.parseInt(dashboardPage.getAmount("Card"));
		int expectedCash = Integer.parseInt(income)-Integer.parseInt(transferAmt);
		int expectedCard = Integer.parseInt(transferAmt);
		Assert.assertEquals(actualCash, expectedCash);
		Assert.assertEquals(actualCard, expectedCard);
	}
}

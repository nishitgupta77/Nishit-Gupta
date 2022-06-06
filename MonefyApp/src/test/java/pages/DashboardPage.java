package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DashboardPage extends BasePage {

	public DashboardPage(AppiumDriver<MobileElement> driver)
	{
		super(driver);
	}
	@AndroidFindBy(id="com.monefy.app.pro:id/income_button_title")
	private MobileElement btnIncome;

	@AndroidFindBy(id="com.monefy.app.pro:id/expense_button")
	private MobileElement btnExpense;

	@AndroidFindBy(id="com.monefy.app.pro:id/balance_amount")
	private MobileElement btnBalance;

	@AndroidFindBy(xpath="(//android.widget.ImageView[@index='0'])[1]")
	private MobileElement btnFood;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='11']")
	private MobileElement btnTaxi;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='1']")
	private MobileElement btnCar;	

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='2']")
	private MobileElement btnTransport;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='19']")
	private MobileElement btnSports;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='15']")
	private MobileElement btnClothes;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='21']")
	private MobileElement btnCommunications;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='20']")
	private MobileElement btnHealth;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='14']")
	private MobileElement btnEatingOut;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='8']")
	private MobileElement btnHouse;

	@AndroidFindBy(xpath="//android.widget.ImageView[@index='18']")
	private MobileElement btnToiletry;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/transfer_menu_item")
	private MobileElement btnTransfer;
	
	@AndroidFindBy(id="com.monefy.app.pro:id/overflow")
	private MobileElement btnSideTray;
	
	@AndroidFindBy(xpath="//*[@text='Accounts']")
	private MobileElement btnAccounts;
	
	@AndroidFindBy(xpath="(//android.widget.ListView[@content-desc=\"List of accounts\"]//android.widget.TextView[2])[1]")
	private MobileElement textCash;
	
	@AndroidFindBy(xpath="(//android.widget.ListView[@content-desc=\"List of accounts\"]//android.widget.TextView[2])[2]")
	private MobileElement textCard;
	
	public void clickNewIncome()
	{
		clickOnElementButton(btnIncome);
	}

	public void clickNewExpense()
	{
		clickOnElementButton(btnExpense);
		
	}
	
	public String getBalanceAmount()
	{
		waitForElement(btnBalance);
		String bal = btnBalance.getText();
		int dollarPos = bal.indexOf(" ");
		int dotPos = bal.indexOf(".");
		String newBal = bal.substring(dollarPos+1, dotPos);
		return newBal.replaceAll(",","").replace("$","");
	}
	
	public void clickBalanceAmount()
	{
		clickOnElementButton(btnBalance);
	}
	
	public void chooseExpenseIcon() {
		clickOnElementButton(btnTaxi);
	}
	
	public void clickTransfer() {
		clickOnElementButton(btnTransfer);
	}
	
	public void openAccounts() {
		clickOnElementButton(btnSideTray);
		clickOnElementButton(btnAccounts);
	}
	
	public String getAmount(String AccountType)
	{
		if(AccountType == "Cash") {
		waitForElement(textCash);
		String bal = textCash.getText();
		int dollarPos = bal.indexOf(" ");
		int dotPos = bal.indexOf(".");
		String newBal = bal.substring(dollarPos+1, dotPos);
		return newBal.replaceAll(",","").replace("$","");
		}
		else {
			waitForElement(textCard);
			String bal = textCard.getText();
			int dollarPos = bal.indexOf(" ");
			int dotPos = bal.indexOf(".");
			String newBal = bal.substring(dollarPos+1, dotPos);
			return newBal.replaceAll(",","").replace("$","");
		}
	}
}

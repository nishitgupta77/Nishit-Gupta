package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DashboardPage extends BasePage {

    public DashboardPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    // Main Action Buttons
    @AndroidFindBy(id = "com.monefy.app.pro:id/income_button_title")
    private MobileElement btnIncome;

    @AndroidFindBy(id = "com.monefy.app.pro:id/expense_button")
    private MobileElement btnExpense;

    @AndroidFindBy(id = "com.monefy.app.pro:id/balance_amount")
    private MobileElement btnBalance;

    // Expense Category Buttons
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@index='0'])[1]")
    private MobileElement btnFood;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='11']")
    private MobileElement btnTaxi;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    private MobileElement btnCar;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement btnTransport;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='19']")
    private MobileElement btnSports;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='15']")
    private MobileElement btnClothes;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='21']")
    private MobileElement btnCommunications;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='20']")
    private MobileElement btnHealth;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='14']")
    private MobileElement btnEatingOut;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='8']")
    private MobileElement btnHouse;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='18']")
    private MobileElement btnToiletry;

    // Navigation & Menu
    @AndroidFindBy(id = "com.monefy.app.pro:id/transfer_menu_item")
    private MobileElement btnTransfer;

    @AndroidFindBy(id = "com.monefy.app.pro:id/overflow")
    private MobileElement btnSideTray;

    @AndroidFindBy(xpath = "//*[@text='Accounts']")
    private MobileElement btnAccounts;

    // Account Balances
    @AndroidFindBy(xpath = "(//android.widget.ListView[@content-desc=\"List of accounts\"]//android.widget.TextView[2])[1]")
    private MobileElement textCash;

    @AndroidFindBy(xpath = "(//android.widget.ListView[@content-desc=\"List of accounts\"]//android.widget.TextView[2])[2]")
    private MobileElement textCard;

    public void clickNewIncome() {
        clickOnElementButton(btnIncome);
    }

    public void clickNewExpense() {
        clickOnElementButton(btnExpense);
    }

    public void clickBalanceAmount() {
        clickOnElementButton(btnBalance);
    }

    public void chooseExpenseIcon() {
        clickOnElementButton(btnTaxi); // can be parameterized if needed
    }

    public void clickTransfer() {
        clickOnElementButton(btnTransfer);
    }

    public void openAccounts() {
        clickOnElementButton(btnSideTray);
        clickOnElementButton(btnAccounts);
    }

    public String getBalanceAmount() {
        waitForElement(btnBalance);
        return extractAmount(btnBalance.getText());
    }

    public String getAmount(String accountType) {
        if ("Cash".equalsIgnoreCase(accountType)) {
            waitForElement(textCash);
            return extractAmount(textCash.getText());
        } else if ("Card".equalsIgnoreCase(accountType)) {
            waitForElement(textCard);
            return extractAmount(textCard.getText());
        } else {
            throw new IllegalArgumentException("Unsupported account type: " + accountType);
        }
    }

    private String extractAmount(String text) {
        int dollarPos = text.indexOf(" ");
        int dotPos = text.indexOf(".");
        String amount = text.substring(dollarPos + 1, dotPos);
        return amount.replaceAll(",", "").replace("$", "");
    }
}

package com.private24.pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class CarLoansPage extends BasePage {

    public CarLoansPage(Page page) {
        super(page);
    }

    private final String agreementsTab = "//div[contains(text(), 'Agreements') and .//parent::a[@href='/auto-credit/my']]";
    private final String authWidgetP24New = "iframe[src='https://login-widget.privat24.ua/']";
    private final String amountFieldCarCost = "//input[@data-qa-node='amount']";
    private final String amountFieldPrepaidExpense = "//input[@data-qa-node='prepaid']";
    private final String phoneCodeButton = "//button[@data-qa-node='phone-code']";
    private final String searchPhoneCodeField = "//input[@placeholder = 'Search' and .//ancestor::div[@data-qa-node]]";
    private final String phoneNumberField = "//input[@data-qa-node = 'phone-number' and @placeholder = '000000000']";
    private final String applyOrderButton = "//button[@type = 'button' and contains(text(), 'Submit an application')]";
    private final String selectedUsedAutoTab = "//div[@data-qa-node='type' and contains(text(), 'With mileage')]";
    private final String confirmForm = "//div[contains(text(), 'One-time password has been forwarded to your phone')]";
    private final String buttonCountryKiribati = "//div[@name='Kiribati']";


    public CarLoansPage selectAgreementsTab() {
        page.click(agreementsTab);
        return this;
    }

    public CarLoansPage checkIsDisplayedAuthWidget() {
        FrameLocator frame = page.frameLocator(authWidgetP24New);
        Locator h2El = frame.locator("h2").first();
        String h2Text = h2El.innerText();
        Assertions.assertEquals("Login/Registration", h2Text);
        return this;
    }

    public CarLoansPage checkIsDisplayedConfirm() {
        page.waitForSelector(confirmForm);
        return this;
    }

    public CarLoansPage enterAmountFieldCarCost(String amount) {
        page.fill(amountFieldCarCost, amount);
        return this;
    }

    public CarLoansPage enterAmountFieldPrepaidExpense(String amount) {
        page.fill(amountFieldPrepaidExpense, amount);
        return this;
    }

    public CarLoansPage enterPhoneNumber(String phoneNumber) {
        page.fill(phoneNumberField, phoneNumber);
        return this;
    }

    public CarLoansPage searchPhoneCountryCodeField(String phoneNumber) {
        page.fill(searchPhoneCodeField, phoneNumber);
        return this;
    }

    public CarLoansPage selectPhoneCodeButton() {
        page.click(phoneCodeButton);
        return this;
    }

    public CarLoansPage submitOrderButton() {
        page.click(applyOrderButton);
        return this;
    }

    public CarLoansPage checkSelectedTabWithMileageAuto() {
        page.waitForSelector(selectedUsedAutoTab);
        return this;
    }

    public CarLoansPage selectCountryCountryKiribatiFromList() {
        page.click(buttonCountryKiribati);
        return this;
    }
}

package com.private24.pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;

public class MobilePhoneReplenishmentPage extends BasePage {

    public MobilePhoneReplenishmentPage(Page page) {
        super(page);
    }

    private final String inputPhoneNumber = "//input[@data-qa-node='phone-number']";
    private final String inputAmount = "//input[@data-qa-node='amount']";
    private final String inputCardNumber = "//input[@data-qa-node='numberdebitSource']";
    private final String inputCardExpDate = "//input[@data-qa-node='expiredebitSource']";
    private final String inputCardCvv = "//input[@data-qa-node='cvvdebitSource']";
    private final String buttonSubmitPayment = "//button[@data-qa-node='submit']";
    private final String cardNumberInTheCart = "//td[@data-qa-node='card']";
    private final String recipientNameInTheCart = "//span[@data-qa-node='nameB']";
    private final String amountInTheCart = "//div[@data-qa-node='amount']";
    private final String commissionInTheCart = "//span[@data-qa-node='commission']";
    private final String commissionCurrencyInTheCard = "//span[@data-qa-node='commission-currency']";
    private final String walletButton = "//div[@data-qa-node='debitSourceSource']";

    /**
     * Enter a phone number excluding country code
     *
     * @param phone phone number
     */
    public MobilePhoneReplenishmentPage enterPhoneNumber(String phone) {
        page.fill(inputPhoneNumber, phone);
        return this;
    }

    /**
     * Enter the amount of replenishment of the mobile phone number
     *
     * @param sum amount of replenishment
     */
    public MobilePhoneReplenishmentPage enterAmount(String sum) {
        page.fill(inputAmount, sum);
        return this;
    }

    /**
     * Enter the card data for payment
     *
     * @param number card number, expDate expiry date, cvv the cvv code
     */
    public MobilePhoneReplenishmentPage enterCardData(String number, String expDate, String cvv) {
        page.fill(inputCardNumber, number);
        page.fill(inputCardExpDate, expDate);
        page.fill(inputCardCvv, cvv);
        return this;
    }

    /**
     * Acceptance of payment
     */
    public MobilePhoneReplenishmentPage submitMobileReplenishment() {
        page.click(buttonSubmitPayment);
        return this;
    }


    /**
     * Check the card number with which the payment and the recipient
     *
     * @param cardFrom  the card number for payment
     * @param recipient mobile operator
     */
    public MobilePhoneReplenishmentPage checkPaymentCardAndRecipient(String cardFrom, String recipient) {
        Assertions.assertEquals(page.textContent(cardNumberInTheCart).split(" ")[3], cardFrom);
        Assertions.assertEquals(page.textContent(recipientNameInTheCart), recipient);
        return this;
    }

    /**
     * Check the amount and Commission amount
     *
     * @param amount           the amount will be credited to the mobile account
     * @param commission       the commission in addition to mobile account
     * @param commissionAmount currency of fee
     */
    public MobilePhoneReplenishmentPage checkPaymentAmountAndCommission(String amount, String commission, String commissionAmount) {
        Assertions.assertEquals(amount, page.textContent(amountInTheCart));
        Assertions.assertEquals(commission, page.textContent(commissionInTheCart));
        Assertions.assertEquals(commissionAmount, page.textContent(commissionCurrencyInTheCard).split(" ")[1]);
        return this;
    }

}

package com.private24.tests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.private24.constants.Constant.CURRENCY.CURRENCY_UAH;
import static com.private24.constants.Constant.DOMAINS_URL.PRIVAT24_MOBILE_REPLENISHMENT_URL;
import static com.private24.constants.Constant.TestDataForMobileReplenishment.CVV_CODE_CARD_1;
import static com.private24.constants.Constant.TestDataForMobileReplenishment.EXP_DATE_CARD_1;
import static com.private24.constants.Constant.TestDataForMobileReplenishment.PHONE_NUMBER_UKRAINE;
import static com.private24.constants.Constant.TestDataForMobileReplenishment.TEST_CARD_1;
import static com.private24.constants.Constant.TestDataForMobileReplenishment.TEST_CARD_1_THE_LAST_FOUR_DIGITS;

public class MobilePhoneReplenishmentPositiveTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    void checkMinimumReplenishmentAmount(String browserType) {
        initiateBrowser(browserType);
        basePage.navigateTo(PRIVAT24_MOBILE_REPLENISHMENT_URL);
        mobilePhoneReplenishmentPage
                .enterPhoneNumber(PHONE_NUMBER_UKRAINE)
                .enterAmount("1")
                .enterCardData(TEST_CARD_1, EXP_DATE_CARD_1, CVV_CODE_CARD_1)
                .submitMobileReplenishment()
                .checkPaymentAmountAndCommission("1 " + CURRENCY_UAH, "2", CURRENCY_UAH)
                .checkPaymentCardAndRecipient(TEST_CARD_1_THE_LAST_FOUR_DIGITS, "Kyivstar Ukraine");
    }

}

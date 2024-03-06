package com.private24.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.private24.constants.Constant.DOMAINS_URL.PRIVAT24_CAR_LOANS_URL;

public class CarLoansTest extends BaseTest{
    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    void applyingForAnOldCarLoanPublicSession(String browserType) {
        initiateBrowser(browserType);
        basePage.navigateTo(PRIVAT24_CAR_LOANS_URL);
        carLoansPage
                .checkSelectedTabWithMileageAuto()
                .enterAmountFieldCarCost("1500000")
                .enterAmountFieldPrepaidExpense("900000")
                .selectPhoneCodeButton()
                .searchPhoneCountryCodeField("Kiri")
                .selectCountryCountryKiribatiFromList()
                .enterPhoneNumber("000000000")
                .submitOrderButton()
                .checkIsDisplayedConfirm();
    }

    @ParameterizedTest
    @ValueSource(strings = {"chromium", "firefox"})
    void checkRedirectOnAuthorization(String browserType) {
        initiateBrowser(browserType);
        basePage.navigateTo(PRIVAT24_CAR_LOANS_URL);
        carLoansPage
                .selectAgreementsTab()
                .checkIsDisplayedAuthWidget();
    }

}

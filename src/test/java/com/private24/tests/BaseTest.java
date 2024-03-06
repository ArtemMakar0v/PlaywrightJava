package com.private24.tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.private24.pages.BasePage;
import com.private24.pages.CarLoansPage;
import com.private24.pages.MobilePhoneReplenishmentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    protected BasePage basePage;
    protected MobilePhoneReplenishmentPage mobilePhoneReplenishmentPage;
    protected CarLoansPage carLoansPage;

    @BeforeEach
    public void setUp() {
        playwright = Playwright.create();
    }

    @AfterEach
    public void tearDown() {
        if (browser != null)
            browser.close();
        if (playwright != null)
            playwright.close();
    }

    public void initiateBrowser(String browserType) {
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);

        switch (browserType) {
            case "chromium":
                browser = playwright.chromium().launch(options);
                break;
            case "firefox":
                browser = playwright.firefox().launch(options);
                break;
            case "webkit":
                browser = playwright.webkit().launch(options);
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type");
        }
        page = browser.newPage();
        basePage = new BasePage(page);
        mobilePhoneReplenishmentPage = new MobilePhoneReplenishmentPage(page);
        carLoansPage = new CarLoansPage(page);
    }
}
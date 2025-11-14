package com.qa.nopcommerce.factory;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;


    public Page initBrowser (String browserName){
        System.out.println("Browser name is : " + browserName);
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false));
                break;
            case "edge":
                browser = playwright.chromium().launch(new LaunchOptions()
                        .setChannel("sedge")
                        .setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false));
                break;
            default:
                System.out.println("Please pass the right browser name...." + browserName);
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://demo.nopcommerce.com/");
        page.waitForLoadState();
        return page;


    }
}


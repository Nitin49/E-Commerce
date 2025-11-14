package com.qa.nopcommerce.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    Page page;
    private static final String registerLinkSelector = "//a[text()='Register']";
    private final static String loginLinkSelector = "//a[text()='Log in']";


    public HomePage(Page page) {
        this.page = page;
    }

    public String isHomePageUrlIsCorrect()
    {
        String actualHomePageUrl=page.url();
        System.out.println("Home Page URL is: " + actualHomePageUrl);
        return actualHomePageUrl;
    }
    public String isHomePageTitleIsCorrect()
    {
        page.waitForLoadState();
        String actualHomePageTitle =page.title();
    System.out.println("Home Page Title is: " + actualHomePageTitle);
    return actualHomePageTitle;
    }

    public boolean isLogoVisible1(){
        Locator logoSelector = page.locator("img[alt='nopCommerce demo store']");
        return logoSelector.isVisible();

    }
    public boolean isRegisterLinkVisible(){

        Locator registerLinkSelector = page.locator("//a[text()='Register']");
         return registerLinkSelector.isVisible();

    }
    public String isRegisterTextIsCorrect(){
        Locator registerLinkSelector = page.locator("//a[text()='Register']");
        String actualRegisterText= registerLinkSelector.textContent();
        System.out.println("Register link text is: " + actualRegisterText);
        return actualRegisterText;
    }
    public boolean isLoginLinkVisible()
    {
        Locator loginLinkSelector= page.locator("//a[text()='Log in']");
        return loginLinkSelector.isVisible();
    }
    public String isLoginTextIsCorrect(){
        Locator loginLinkSelector= page.locator("//a[text()='Log in']");
        String actualLoginText=loginLinkSelector.textContent();
        System.out.println("Login link text is: " + actualLoginText);
        return actualLoginText;


}







}

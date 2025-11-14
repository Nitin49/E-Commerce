package com.qa.nopcommerce.test;
import com.qa.nopcommerce.factory.PlaywrightFactory;;
import com.qa.nopcommerce.pages.HomePage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;;
import org.testng.annotations.BeforeMethod;;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
    PlaywrightFactory pf;
    Page page;
    HomePage homePage;

    @BeforeTest
    public void setUp() {
        pf = new PlaywrightFactory();
       page= pf.initBrowser("chromium");
       homePage = new HomePage(page);
    }

    @Test(priority = 1)
    // Verify the Home Page URL is correct or not
    public void verifyHomePageUrlTest()
    {
        String actualHomePageUrl=homePage.isHomePageUrlIsCorrect();
        Assert.assertEquals(actualHomePageUrl,"https://demo.nopcommerce.com/","Home Page Url is Incorrect");

    }
    @Test(priority = 2)
    // Verify the Home Page Title is correct or not
    public void verifyHomePageTitleTest()
    {
        String actualHomePageTitle= homePage.isHomePageTitleIsCorrect();
        Assert.assertEquals(actualHomePageTitle,"nopCommerce demo store. Home page title","Home Page Title is Incorrect");
    }
    @Test (priority = 3)
    // Verify the Logo is visible on Home Page
    public void verifyLogoTest()
    {
        boolean logoVisibleFlag= homePage.isLogoVisible1();
        Assert.assertTrue(logoVisibleFlag,"Logo is not Visible on the Home page");
    }

    @Test (priority = 4)
    // Verify the Register link is visible on Home Page
    public void registerLinkIsVisibleTest()
    {
        boolean registerLinkVisibleFlag= homePage.isRegisterLinkVisible();
        Assert.assertTrue(registerLinkVisibleFlag,"Register Link is not Visible on the Home page");
    }
    @Test (priority = 5)
    // Verify the Register link text is correct on Home Page
    public void registerLinkTextCorrectTest()
    {
        String actualRegisterText=homePage.isRegisterTextIsCorrect();
        Assert.assertEquals(actualRegisterText,"Register","Register link text is Incorrect");

    }
    @Test (priority = 6)
    // Verify the Login link is visible on Home Page
    public void loginLinkIsVisibleTest()
    {
        boolean loginLinkVisibleFlag= homePage.isLoginLinkVisible();
        Assert.assertTrue(loginLinkVisibleFlag,"Login Link is not Visible on the Home page");
    }
    @Test (priority = 7)
    // Verify the Login link text is correct on Home Page
    public void loginLinkTextCorrectTest()
    {
        String actualLoginText=homePage.isLoginTextIsCorrect();
        Assert.assertEquals(actualLoginText,"Log in","Login link text is Incorrect");
    }







}

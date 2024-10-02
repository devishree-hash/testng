package org.execution;

import java.io.IOException;
import java.time.Duration;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageManager;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestScript extends BaseClass{

	public static BaseClass baseClass=new BaseClass();
	public static PageManager pageManager=new PageManager();
	
	@Test(priority=2)
	private void homePageValidation () throws IOException, InterruptedException
	{
		WebElement searchItem =pageManager.getHomePage().getSearchItem();
    	searchItem.sendKeys(baseClass.readExcell(2, 1));
    	baseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	WebElement searchButton = pageManager.getHomePage().getSearchButton();
    	Thread.sleep(2000);
    	if(searchButton.isEnabled()) {
    		test.log(Status.PASS, "search button is appeared");
    		test.addScreenCaptureFromPath(baseClass.getScreenShot());
       }
    	else {
    		test.log(Status.FAIL, "search button is not appeared");
    	}
    	baseClass.clickButton(searchButton);
		
	}
	@Test(priority=3)
	private void kurtiSetPageValidation() throws IOException, InterruptedException
	{
		WebElement kurtiSet = pageManager.getKurtiSetPage().getKurtiSet();
    	String text = kurtiSet.getText();
    	System.out.println(text);
	    baseClass.getScreenShot();
    	baseClass.clickButton(kurtiSet);
	    baseClass.handlingWindow();
	    WebElement cart = pageManager.getKurtiSetPage().getCart();
        baseClass.clickButton(cart);
        WebElement checkCartItem = pageManager.getKurtiSetPage().getCheckCartItem();
        if(checkCartItem.getText().equals("1")) {
        	test.log(Status.PASS, "The cart has the items which i have added");
        	 }
        
        WebElement viewCart =pageManager.getKurtiSetPage().getViewCart();
        baseClass.clickButton(viewCart);
        Thread.sleep(2000);
        WebElement shoppingCart =pageManager.getKurtiSetPage().getShoppingCart();
        if(shoppingCart.isDisplayed()) {
        	test.log(Status.PASS, "shoppingCart is displayed");
        	  }
        WebElement deleteButton = pageManager.getKurtiSetPage().getDeleteButton();
        baseClass.clickButton(deleteButton);
        WebElement proceedToCheckOut =pageManager.getKurtiSetPage().getProceedToCheckOut();
        if(proceedToCheckOut.isDisplayed()) {
        	test.log(Status.PASS, "Proceed to chekcout is appeared");
        	 }
        baseClass.clickButton(proceedToCheckOut);
		
	}
	@Test(priority=4)
	private void logout() throws IOException
	{
		WebElement homeLogo = pageManager.getLogOutPage().getHomeLogo();
        baseClass.clickButton(homeLogo);
        WebElement searchPage =pageManager.getLogOutPage().getSearchPage();
        if(searchPage.isDisplayed()) {
        	test.log(Status.PASS, "searchPage is appeared");        }
        baseClass.getScreenShot();
    }
		
	
	
}

/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Home
* @module			:		Home
* @testmethod		:	   	testLocationEnabled()
* @testmethod		:	   	testSearchResult()
* @testmethod		:	   	testPopularCtgrs()
* @testmethod		:	   	testPopularCtgrs()
*/
package com.test.scripts;


import java.awt.Robot;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MDLDPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;

import io.appium.java_client.TouchAction;

public class Home extends BaseLib {
	String sTestData;
	String[] sData=null;
	WelcomePO welcomePo=null;
	LoginPO loginPo=null;
	HomePO homePo=null;
	PostNeedPO postneedPo=null;
	JavascriptExecutor js=null;
	HashMap<String, String> scrollObject=null;


	/* @TestCaseID: Home_01
	 * @Description: Check city is displayed
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="Check city is displayed")
	public void testLocationEnabled()
	{
		sTestData="Home_01";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	homePo.navigateToHomeWOLogin(welcomePo,homePo);
			Assert.assertEquals(homePo.getEleLocationTxtFld().getText(),sData[6]);
			NXGReports.addStep("Currenty city is displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		throw e;
		}
	}

	/* @TestCaseID: Home_02
	 * @Description: To check if device current city is displayed in Home page with location services disabled.--cannot automate
	 * @Author: Yashi Priya
	 * Covered in WelcomeTest -
	 * */


	/* @TestCaseID: Home_03
	 * @Description: Search for Need names/Keywords
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="Search for Need names/Keywords")
	public void testSearchResult()
	{
		sTestData="Home_03";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		homePo.getEleSearchTxtFld().sendKeys(sData[7]);
		homePo.getEleKeyboardReturnBtn().click();
		Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
		NXGReports.addStep("Search result is displayed", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Home_04
	 * @Description: Check if popular categories getting displayed in Home page
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="Check if popular categories getting displayed in Home page")
	public void testPopularCtgrs() throws Exception
	{
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("HomePage is displayed", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleHomeAppliancesIcn().isDisplayed(), "Home Appliances icon is not displayed under popular categories");
			NXGReports.addStep("Home Appliances icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleInteriorDecorationIcn().isDisplayed(), "Interior Decoration icon is not displayed under popular categories");
			NXGReports.addStep("Interior Decoration icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getElePestControlIcn().isDisplayed(), "Pest Control is not displayed under popular categories");
			NXGReports.addStep("Pest Control icon is successfully displayed under popular categories", LogAs.PASSED, null);
			/*Assert.assertTrue(homePo.getEleSecurityServicesIcn().isDisplayed(), "Security Services icon is not displayed under popular categories");
			NXGReports.addStep("Security Services icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleModularKitchenIcn().isDisplayed(), "Modular Kitchen icon is not displayed under popular categories");
			NXGReports.addStep("Modular Kitchen icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleEventOrganizersIcn().isDisplayed(), "Event Organizers icon is not displayed under popular categories");
			NXGReports.addStep("Event Organizers icon is successfully displayed under popular categories", LogAs.PASSED, null);
			//homePo.scrollToComputerTraining()//pageup and pagedown
			//driver.scrollTo("Security Services");
			//Thread.sleep(2000);
			//driver.swipe(16, 401, 16, 355, 3000);
			//TouchAction act=new TouchAction(driver);
			//act.moveTo(16, 643).perform();
			
			/*for(int i=0;i<=1;i++)
			{
				try
				{
					js = (JavascriptExecutor) driver;
					scrollObject = new HashMap<String, String>();
					scrollObject.put("direction", "down");
					js.executeScript("mobile: scroll", scrollObject);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			
			}*/
			//((JavascriptExecutor) driver) .executeScript("window.scrollTo(0, document.body.scrollHeight)"); 

		/*	Assert.assertTrue(homePo.getEleComputerTrainingIcn().isDisplayed(), "Computer Training icon is not displayed under popular categories");
			NXGReports.addStep("Computer Training icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getElePackersAndMoversIcn().isDisplayed(), "Packers and Movers icon is not displayed under popular categories");
			NXGReports.addStep("Packers & Movers icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleCateringServicesIcn().isDisplayed(), "Catering Services icon is not displayed under popular categories");
			NXGReports.addStep("Catering Services", LogAs.PASSED, null);
			//driver.scrollTo("Computer Training");
			Assert.assertTrue(homePo.getEleWebsiteServicesIcn().isDisplayed(), "Website Services icon is not displayed under popular categories");
			NXGReports.addStep("Website Services icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleCoachingAndTuitionsIcn().isDisplayed(), "Coaching & Tuitions icon is not displayed under popular categories");
			NXGReports.addStep("Coaching & Tuitions icon is successfully displayed under popular categories", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleElectricalRepairsIcn().isDisplayed(), "Electrical Repairs icon is not displayed under popular categories");
			NXGReports.addStep("Electrical Repairs icon is successfully displayed under popular categories", LogAs.PASSED, null);*/

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}

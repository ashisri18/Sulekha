/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of Welcome. 
 * @module			:		Welcome
 * @testmethod		:	   	testLocationPermissionAlert()
 * @testmethod		:	   	testAllowBtn()
 * @testmethod		:	   	testDontAllowBtn()
 * @testmethod		:	   	testNotificationPermissionAlert()
 * @testmethod		:	   	testNotificationOKBtn()
 * @testmethod		:	   	testDontAllowNotification()
 * @testmethod		:	   	testSkip()
 */

package com.test.scripts;
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
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;
public class WelcomePage extends BaseLib 
{
	String sTestData=null;
	String[] sData=null;
	WelcomePO welcomePo;
	HomePO homePo;
	LoginPO loginPo;
	PostNeedPO postneedPo;
	MyNeedsDashboardPO myNeedsDashboadrdpo;
	MDLDPO mdldpo;
	MorePO morePo;

	/* @TestCaseID: Welcome_01
	 * @Description: To check whether location permission alert is displayed on launching the app
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To check whether location permission alert is displayed on launching the app.")
	public void testLocationPermissionAlert() throws Exception
	{
		welcomePo=new WelcomePO(driver);
		try
		{
			Assert.assertTrue(welcomePo.getEleAllowSulekhaTxt().isDisplayed(), "Allow Sulekha to access your location text is not displayed");
			NXGReports.addStep("Allow Sulekha to access your location even when you are not using the app? text is displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleAlwaysTxt().isDisplayed(), "Always text is not displayed");
			NXGReports.addStep("Always text is displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleAllowBtn().isDisplayed(), "Location permission alert popup with Allow button is not displayed");
			NXGReports.addStep("Location popup with Allow button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleDontAllowBtn().isDisplayed(), "Location permission alert popup with Dont Allow button is not displayed");
			NXGReports.addStep("Location popup with Dont Allow button is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleAllowBtn().click();
			welcomePo.getEleOKBtn().click();
			}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Welcome_02
	 * @Description: Tap over "Allow" on location permission alert and verify
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="Tap over 'Allow' on location permission alert and verify")
	public void testAllowBtn()
	{
		sTestData="Welcome_02";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	Assert.assertTrue(welcomePo.getEleOKBtn().isDisplayed(), "Location permission alert popup is not displayed");
			NXGReports.addStep("Location permission alert popup is successfully displayed", LogAs.PASSED, null);
			//welcomePo.getEleAllowBtn().click();
			welcomePo.getEleOKBtn().click();
			Assert.assertTrue(welcomePo.getEleSkipBtn().isDisplayed(),"Notification popup is not handled");
			NXGReports.addStep("Notification popup is successfully handled", LogAs.PASSED, null);
			welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Loging is skipped and Home screen is successfully handled", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleLocationTxtFld().getText().equals("Bangalore"),"City location is not displayed");
			NXGReports.addStep("Current city is successfully handled", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Welcome_03
	 * @Description: Tap over "Don't Allow" on location permission alert and verify
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="Tap over 'Don't Allow' on location permission alert and verify")
	public void testDontAllowBtn()
	{
		sTestData="Welcome_03";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{
			Assert.assertTrue(welcomePo.getEleOKBtn().isDisplayed(), "Location permission alert popup is not displayed");
			NXGReports.addStep("Location permission alert popup is successfully displayed", LogAs.PASSED, null);
			//welcomePo.getEleDontAllowBtn().click();
			welcomePo.getEleOKBtn().click();
			Assert.assertTrue(welcomePo.getEleSkipBtn().isDisplayed(),"Notification popup is not handled");
			NXGReports.addStep("Notification popup is successfully handled", LogAs.PASSED, null);
			welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Login is skipped and Home screen is successfully displayed", LogAs.PASSED, null);
			//Assert.assertTrue(homePo.getEleLocationTxtFld().getText().equals("Enter your city"),"City location is displayed");
			//NXGReports.addStep("City is not displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Welcome_04
	 * @Description: Check whether Push notification permission alert is displayed on launching the app
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="Check whether Push notification permission alert is displayed on launching the app")
	public void testNotificationPermissionAlert()
	{
		welcomePo=new WelcomePO(driver);
		try
		{
			welcomePo.tohandleLocationPopup();
			Assert.assertTrue(welcomePo.getEleNotificationAlertTxt().isDisplayed(), "Sulekha would like to send you Notification text is not displayed");
			NXGReports.addStep("Sulekha would like to send you Notification text is displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleDontAllowBtn().isDisplayed(), "Location permission alert popup with Dont Allow button is not displayed");
			NXGReports.addStep("Notification popup with Dont Allow button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleOKBtn().isDisplayed(), "Push notification permission alert popup is not displayed");
			NXGReports.addStep("Push notification permission with ok option is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
			
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Welcome_05
	 * @Description: Tap over "OK" on Push notification permission alert and verify
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true,description="Tap over 'OK' on Push notification permission alert and verify")
	public void testNotificationOKBtn() throws Exception
	{
		sTestData="Welcome_05";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		postneedPo=new PostNeedPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(homePo.getEleHomeAppliancesIcn().isDisplayed(),"Popular categories list is not displayed");
			NXGReports.addStep("Popular categories list is successfully displayed", LogAs.PASSED, null);
			homePo.getEleHomeAppliancesIcn().click();
			Assert.assertTrue(postneedPo.getEleFillformBtn().isDisplayed(),"Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleFillformBtn().click();
			welcomePo.handleForm(sData[8], mdldpo);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit request button is not displayed");
			NXGReports.addStep("Submit request button is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleSubmitRequestBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNeedNotiSMSTxt().isDisplayed(),"Push notification is not received to user mobile after need is distributed to businesses");
			NXGReports.addStep("Push notification is received to user mobile after need is distributed to businesses", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Welcome_06
	 * @Description: Tap over "Don't Allow" on Push notification permission alert
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=true,description=" Tap over 'Don't Allow' on Push notification permission alert")  
	public void testDontAllowNotification() throws Exception
	{
		sTestData="Welcome_06";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo = new MorePO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.tohandleLocationPopup();
			Assert.assertTrue(welcomePo.getEleDontAllowBtn().isDisplayed(), "Push notification permission alert popup is not displayed");
			NXGReports.addStep("Push notification permission alert popup is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleDontAllowBtn().click();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			myNeedsDashboadrdpo.getEleSecondOption().click();
			Assert.assertTrue(postneedPo.getEleFillformBtn().isDisplayed(),"Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleFillformBtn().click();
			welcomePo.handleForm(sData[8], mdldpo);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit request button is not displayed");
			NXGReports.addStep("Submit request button is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleSubmitRequestBtn().click();
			try{
			Assert.assertTrue(welcomePo.getEleMatchedBusiTxt().isDisplayed(),"Posted need is still displayed under notifications");
			NXGReports.addStep("Posted need is no more displayed under notifications", LogAs.PASSED, null);
			}catch(Exception e){
				welcomePo.getEleAllowBtn().click();
				Assert.assertTrue(welcomePo.getEleMatchedBusiTxt().isDisplayed(),"Posted need is still displayed under notifications");
				NXGReports.addStep("Posted need is no more displayed under notifications", LogAs.PASSED, null);
			}
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: Welcome_07
	 * @Description: To tap over "skip" button and verify, should navigate to home page
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=true,description="To tap over 'skip' button and verify, should navigate to home page")
	public void testSkip()
	{
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleSkipBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
		}
	}

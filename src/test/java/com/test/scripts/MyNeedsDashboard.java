/***********************************************************************
 * @author 			:		RAGHU KIRAN MR
 * @description		: 		Test scripts of MyNeedDashboad
 * @module			:		MyNeedDashboad
 * @testmethod		:	   	testCheckStatus()
 * @testmethod		:	    testNotificationTriggered()
 * @testmethod		:	   	testAutomaticRefesh()
 * @testmethod		:	   	testDateOfPostedNeed()
 * @testmethod		:	   	testNeedDashboard()
 * @testmethod		:	   	testCheckResponsesPage()
 * @testmethod		:	   	testCallIcon()
 * @testmethod		:	   	testScore()
 * @testmethod		:	   	testSummaryTab()
 * @testmethod		:	   	testReview()
 * @testmethod		:	   	testReviewNoAlertPopup()
 * @testmethod		:	   	testReviewYesAlertPopup()
 * @testmethod		:	    testWriteReviewLink()
 * @testmethod		:	   	testReviewRate()
 * @testmethod		:	   	testNotFinalized()
 * @testmethod		:	   	testDintReceivedCall()
 * @testmethod		:	   	testDismissPopup()
 * @testmethod	    :       testSelectNotHappyQuote()
 * @testmethod	    :       testComments()
 * @testmethod       :       testCancelPopup()
 * @testmethod       :       testVerifyCancelled()
 * @testmethod       :       testShortList()
 */
package com.test.scripts;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.test.baselib.BaseLib;
import com.test.baselib.GenericLib;
import com.test.po.BusinessProfilePO;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MDLDPO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class MyNeedsDashboard extends BaseLib{
	String sTestData;
	String[] sData=null;
	WelcomePO welcomePo;
	LoginPO loginPo;
	HomePO homePo;
	PostNeedPO postneedPo;
	MDLDPO mdldpo;
	MyNeedsDashboardPO myNeedsDashboadrdpo;
	BusinessProfilePO businessprofilePo;

	/* @TestCaseID:myNeedsDashboadrd_01
	 * @Description:Check the Status "Its taking time to get matching business for you need" in dashboard
	 * @Author:RaghuKiran MR*/
	@Test(priority=1,enabled=true,description="Check the Status 'Its taking time to get matching business for you need' in dashboard")
	public void testCheckStatus()
	{
		sTestData="myNeedsDashboadrd_01";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_02
	 * @Description:Check the Notification is triggered
	 * @Author:RaghuKiran MR*/
	@Test(priority=2,enabled=true,description="Check the Notification is triggered")
	public void testNotificationTriggered()
	{
		sTestData="myNeedsDashboadrd_02";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo,sData[6],sData[7]);
			Assert.assertTrue(postneedPo.getEleNotificationLnk().isDisplayed(),"Notification icon is not displayed");
			NXGReports.addStep("Notification icon is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNotificationLnk().click();
			Assert.assertTrue(homePo.getEleNotificationLstItm().isDisplayed(),"Posted need is not displayed under notifications");
			NXGReports.addStep("Posted need is successfully displayed under notifications", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* @TestCaseID:myNeedsDashboadrd_03
	 * @Description:Check for automatic refresh
	 * @Author:RaghuKiran MR*/
	@Test(priority=3,enabled=true,description="Check for automatic refresh")
	public void testAutomaticRefesh()
	{
		sTestData="myNeedsDashboadrd_03";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDashboardBtn().isDisplayed(),"Dashboard button is not displayed");
			NXGReports.addStep("Dashboard button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDashboardBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCountNeedNumber().isDisplayed(),"Number of business match count is not displayed on the dashboard page");
			NXGReports.addStep("Number of business match count is successfully displayed on the dashboard page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_04
	 * @Description:Check for date of posted need
	 * @Author:RaghuKiran MR*/
	@Test(priority=4,enabled=true,description="Check for date of posted need")
	public void testDateOfPostedNeed()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.getEleDashboardBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDataPostedOption().isDisplayed(),"Data on which the need is posted should not displayed on the need page");
			NXGReports.addStep("Data on which the need is posted should be displayed on the need page", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_05
	 * @Description:Tap over any need displayed in dashboard
	 * @Author:RaghuKiran MR*/
	@Test(priority=5,enabled=true,description="Tap over any need displayed in dashboard")
	public void testNeedDashboard()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.getEleDashboardBtn().click();
			myNeedsDashboadrdpo.getEleNeedArrowBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_06
	 * @Description:Check the Responses page
	 * @Author:RaghuKiran MR*/
	@Test(priority=6,enabled=true,description="Check the Responses page")
	public void testCheckResponsesPage()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDashboardBtn().isDisplayed(),"Dashboard icon is not displayed");
			NXGReports.addStep("Dashboard icon is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDashboardBtn().click();
			myNeedsDashboadrdpo.getEleNeedArrowBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNameofBusinessTxt().isDisplayed(),"Name of the business is not displayed");
			NXGReports.addStep("Name of the business is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleLocationNameTxt().isDisplayed(),"Location Name is not displayed");
			NXGReports.addStep("Location Name is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewLink().isDisplayed(),"Review link is not displayed");
			NXGReports.addStep("Review link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCallIcon().isDisplayed(),"Call icon is not displayed");
			NXGReports.addStep("Call icon is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().isDisplayed(),"Not Finalised Businees button is not dispalyed");
			NXGReports.addStep("Not Finalised Businees button is successfully dispalyed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleScoreIcon().isDisplayed(),"Score icon is not displayed");
			NXGReports.addStep("Score icon is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_07
	 * @Description:Tap on the call icon displayed on the business 
	 * @Author:RaghuKiran MR*/
	@Test(priority=7,enabled=true,description="Tap on the call icon displayed on the business")
	public void testCallIcon() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.dashboard();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCallIcon().isDisplayed(),"Call icon is not displayed");
			NXGReports.addStep("Call icon is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleCallIcon().click();
			businessprofilePo.handlingCall();


		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_08
	 * @Description:Tap on the score displayed on the business
	 * @Author:RaghuKiran MR*/
	@Test(priority=8,enabled=true,description="Tap on the score displayed on the business")
	public void testScore()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.dashboard();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleScoreIcon().isDisplayed(),"Score icon is not displayed");
			NXGReports.addStep("Score icon is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_09
	 * @Description:Check the Summary tab
	 * @Author:RaghuKiran MR*/
	@Test(priority=9,enabled=true,description="Check the Summary tab")
	public void testSummaryTab()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.dashboard();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleSummaryTab().isDisplayed(),"Summary tab is not displayed");
			NXGReports.addStep("Summary tab is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleSummaryTab().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleSummaryNeedList().isDisplayed(),"Summary of the need should is not displayed");
			NXGReports.addStep("Summary of the need should is successfully displayed", LogAs.PASSED, null);


		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_10
	 * @Description:Tap on "Select & review" button displayed on the business
	 * @Author:RaghuKiran MR*/
	@Test(priority=10,enabled=true,description="Tap on 'Select & review' button displayed on the business")
	public void testReview()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewLink().isDisplayed(),"Review link is not displayed");
			NXGReports.addStep("Review link is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleReviewLink().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNoBtn().isDisplayed(),"Alert with the message'Got your job done from business name….?with No and Yes button' is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name….?with No and Yes button' is successfully displayed", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_11
	 * @Description:Tap No button displayed on "Got your job done from business name..?" alert
	 * @Author:RaghuKiran MR*/
	@Test(priority=11,enabled=true,description="Tap No button displayed on 'Got your job done from business name..?' alert")
	public void testReviewNoAlertPopup()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewLink().isDisplayed(),"Review link is not displayed");
			NXGReports.addStep("Review link is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleReviewLink().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNoBtn().isDisplayed(),"Alert with the message'Got your job done from business name….?with No and Yes button' is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name….?with No and Yes button' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleNoBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);


		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_12
	 * @Description:Tap Yes button displayed on "Got your job done from business name..?" alert
	 * @Author:RaghuKiran MR*/
	@Test(priority=12,enabled=true,description="Tap Yes button displayed on 'Got your job done from business name..?' alert")
	public void testReviewYesAlertPopup()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			myNeedsDashboadrdpo.getEleReviewLink().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleYesBtn().isDisplayed(),"Alert with the message'Got your job done from business name….?with No and Yes button' is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name….?with No and Yes button' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleYesBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(),"User should not navigated to Rate and review page");
			NXGReports.addStep("User should be navigated to Rate and review page", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_13
	 * @Description:Check whether Write review link is displayed when user discard to review the business
	 * @Author:RaghuKiran MR*/
	@Test(priority=13,enabled=true,description="Check whether Write review link is displayed when user discard to review the business")
	public void testWriteReviewLink() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			myNeedsDashboadrdpo.getEleReviewLink().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleYesBtn().isDisplayed(),"Alert with the message'Got your job done from business name….?with No and Yes button' is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name….?with No and Yes button' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleYesBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(),"User should not navigated to Rate and review page");
			NXGReports.addStep("User should not navigated to Rate and review page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			welcomePo.getEleBackArwIcn().click();
			Thread.sleep(2000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewBtn().isDisplayed(),"Write a review button is not displayed");
			NXGReports.addStep("Write a review button is successfully displayed", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_14
	 * @Description:Check posting the review in Rate and review page
	 * @Author:RaghuKiran MR*/
	@Test(priority=14,enabled=true,description="Check posting the review in Rate and review page")
	public void testReviewRate() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewLink().isDisplayed(), "Review link is not displayed");
			NXGReports.addStep("Review link is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleReviewLink().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleYesBtn().isDisplayed(),"Alert with the message'Got your job done from business name….?with No and Yes button' is not displayed");
			NXGReports.addStep("Alert with the message'Got your job done from business name….?with No and Yes button' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleYesBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(),"User should not navigated to Rate and review page");
			NXGReports.addStep("User should be navigated to Rate and review page", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			welcomePo.getEleBackArwIcn().click();
			Thread.sleep(2000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleReviewBtn().isDisplayed(),"Write a review button is not displayed");
			NXGReports.addStep("Write a review button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleReviewBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(),"User should not navigated to Rate and review page");
			NXGReports.addStep("User should not navigated to Rate and review page", LogAs.PASSED, null);
			Thread.sleep(2000);
			new TouchAction((MobileDriver)driver).longPress(100,200).release().perform();
			Thread.sleep(2000);
			/*Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "Write your review text field is not displayed");
			NXGReports.addStep("Write your review text field is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleWriteyourreviewTxtFld().sendKeys(sData[10]);
			homePo.getEleKeyboardReturnBtn().click();
			businessprofilePo.getElePOSTREVIEWBtn().click();
			Assert.assertTrue(businessprofilePo.getEleReviewPostedToast().isDisplayed(),"Review is not posted");
			NXGReports.addStep("Review is successfully posted", LogAs.PASSED, null);*/
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_15
	 * @Description:Tap over "NOT FINALIZED" button
	 * @Author:RaghuKiran MR*/
	@Test(priority=15,enabled=true,description="Tap over 'NOT FINALIZED' button")
	public void testNotFinalized() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().isDisplayed(), "Not finalished business button is not displayed");
			NXGReports.addStep("Not finalished business button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDidntReceiveCallOption().isDisplayed(),"Popup with message 'I didn't received calls from businesses' is not displayed");
			NXGReports.addStep("Popup with message 'I didn't received calls from businesses' is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().isDisplayed(),"Popup with message 'I'm not happy with the quote I received' is not displayed");	
			NXGReports.addStep("I'm not happy with the quote I received' is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleIdonthavethisneedanymorePopup().isDisplayed(),"Popup with message 'I don't have this need anymore' is not displayed");
			NXGReports.addStep("Popup with message 'I don't have this need anymore' is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_16
	 * @Description:Select "I didn't received calls from businesses" and verify.
	 * @Author:RaghuKiran MR*/
	@Test(priority=16,enabled=true,description="Select 'I didn't received calls from businesses' and verify.")
	public void testDintReceivedCall() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().isDisplayed(), "Not finalished business button is not displayed");
			NXGReports.addStep("Not finalished business button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDidntReceiveCallOption().isDisplayed(),"Popup with message 'I didn't received calls from businesses' is not displayed");
			NXGReports.addStep("Popup with message 'I didn't received calls from businesses' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDidntReceiveCallOption().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDismissBtn().isDisplayed(),"Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is not dispalyed");
			NXGReports.addStep("Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is successfully dispalyed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:myNeedsDashboadrd_17
	 * @Description:Tap on "Dismiss" button displayed on the pop up
	 * @Author:RaghuKiran MR*/
	@Test(priority=17,enabled=true,description="Tap on 'Dismiss' button displayed on the pop up")
	public void testDismissPopup() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDidntReceiveCallOption().isDisplayed(),"Popup with message 'I didn't received calls from businesses' is not displayed");
			NXGReports.addStep("Popup with message 'I didn't received calls from businesses' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDidntReceiveCallOption().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleDismissBtn().isDisplayed(),"Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is not dispalyed");
			NXGReports.addStep("Alert with the message 'We will get business to call you back with quotes message and Dismiss button' is successfully dispalyed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleDismissBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:myNeedsDashboadrd_18
	 * @Description:Select "I'm not happy with the quote I received" and verify- More quotes
	 * @Author:RaghuKiran MR*/
	@Test(priority=18,enabled=true,description="Select 'I'm not happy with the quote I received' and verify- More quotes")
	public void testSelectNotHappyQuote() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().isDisplayed(),"Popup with message 'I'm not happy with the quote I received' is not displayed");	
			NXGReports.addStep("Popup with message 'I'm not happy with the quote I received' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleTellusMorePopup().isDisplayed(),"A pop up window with message 'Type in additional details about your need. We'll have businesses call you.,textbox,Send and Cancel buttons' should not displayed");
			NXGReports.addStep("A pop up window with message 'Type in additional details about your need. We'll have businesses call you.,textbox,Send and Cancel buttons' should be displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:myNeedsDashboadrd_19
	 * @Description:Enter the comments in more quotes pop up and tap Send
	 * @Author:RaghuKiran MR*/
	@Test(priority=19,enabled=true,description="Enter the comments in more quotes pop up and tap Send")
	public void testComments() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().isDisplayed(),"Popup with message 'I'm not happy with the quote I received' is not displayed");	
			NXGReports.addStep("Popup with message 'I'm not happy with the quote I received' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleImnothappywiththeQuotesPopup().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleTellusMorePopup().isDisplayed(),"A pop up window with message 'Type in additional details about your need. We'll have businesses call you.,textbox,Send and Cancel buttons' should not displayed");
			NXGReports.addStep("A pop up window with message 'Type in additional details about your need. We'll have businesses call you.,textbox,Send and Cancel buttons' should be displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleTellusMoreNeedPopup().sendKeys(sData[9]);
			homePo.getEleKeyboardReturnBtn().click();
			myNeedsDashboadrdpo.getEleSendBtn().click();
			myNeedsDashboadrdpo.getEleDismissBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleRequestedQuotesTxt().isDisplayed(),"You have requested more quotes message should not displayed in response page");
			NXGReports.addStep("You have requested more quotes message should be displayed in response page", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleMoreQuotesTxt().isDisplayed(), "More quotes message is not displayed in dashboard page");
			NXGReports.addStep("More quotes message is successfully displayed in dashboard page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:myNeedsDashboadrd_20
	 * @Description:Tap on "Cancel" button displayed on the pop up
	 * @Author:RaghuKiran MR*/
	@Test(priority=20,enabled=true,description="Tap on 'Cancel' button displayed on the pop up")
	public void testCancelPopup() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCancelBtn().isDisplayed(),"Cancel button is not displayed");
			NXGReports.addStep("Cancel button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleCancelBtn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User should not redirected to Responses page");
			NXGReports.addStep("User should be redirected to Responses page", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:myNeedsDashboadrd_21
	 * @Description:Select "I don't have this need anymore" and verify-Cancelled
	 * @Author:RaghuKiran MR*/
	@Test(priority=21,enabled=true,description="Select 'I don't have this need anymore' and verify-Cancelled")
	public void testVerifyCancelled() throws Exception
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo, postneedPo, sData[6],sData[7]);
			myNeedsDashboadrdpo.getEleNotFinalisedBusinessBtn().click();
			Thread.sleep(10000);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleIdonthavethisneedanymorePopup().isDisplayed(),"Popup with message 'I don't have this need anymore' is not displayed");
			NXGReports.addStep("Popup with message 'I don't have this need anymore' is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleIdonthavethisneedanymorePopup().click();
			myNeedsDashboadrdpo.getEleDismissBtn().click();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCancelledNeedTxt().isDisplayed(),"You have cancelled this need meesage is not dispalyed");
			NXGReports.addStep("You have cancelled this need meesage is successfully dispalyed", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:myNeedsDashboadrd_22
	 * @Description:Perform 'Shortlist' operation from Mobile and verify in 'My Shortlist' section
	 * @Author:RaghuKiran MR*/
	@Test(priority=22,enabled=true,description="Perform 'Shortlist' operation from Mobile and verify in 'My Shortlist' section")
	public void testShortList()
	{
		sTestData="myNeedsDashboadrd_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.searchNeeds(homePo, mdldpo,postneedPo, sData[6],sData[7]);
			Assert.assertTrue(myNeedsDashboadrdpo.getEleResponsesPostBtn().isDisplayed(), "Responses post button is not displayed");
			NXGReports.addStep("Responses post button is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleResponsesPostBtn().click();
			Assert.assertTrue(businessprofilePo.getEleShortlistIcn().isDisplayed(), "Short list button is not displayed");
			NXGReports.addStep("Short list button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleShortlistIcn().click();
			welcomePo.getEleBackArwIcn().click();
			welcomePo.getEleBackArwIcn().click();
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "More page is not displayed");
			NXGReports.addStep("More page is successfully displayed", LogAs.PASSED, null);
			homePo.getEleShortListLnk().click();
			//Assert.assertTrue(condition, message);
			NXGReports.addStep("Shortlisted business is successfully seen under shortlist tab", LogAs.PASSED, null);
			Assert.assertTrue(mdldpo.getEleShortlistsIcon().isDisplayed(),"The shortlisted business should not displayed in My Shortlists page");
			NXGReports.addStep("The shortlisted business should be displayed in My Shortlists page", LogAs.PASSED, null);
		}

		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}

/***********************************************************************
 * @author 			:	  Shreyas MS
 * @description		: 	  Test scripts of More Test 
 * @module			:	  MoreTest
 * @testmethod		:	  testMoreScreen() 	
 * @testmethod		:	  testShortListPage()
 * @testmethod		:	  testListMyBuisnessPage()
 * @testmethod		:	  testNotificationPage()	
 * @testmethod		:	  testNotiResponsePage()
 * @testmethod		:	  testRemoveMyShortlist()
 * @testmethod		:	  testPostedReview()
 * @testmethod		:	  testAnyReview()
 */
package com.test.scripts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.UpdateAccountPO;
import com.test.po.WelcomePO;
public class More extends BaseLib
{
	String sTestData;
	String[] sData = null;
	WelcomePO welcomePo = null;
	LoginPO loginPo = null;
	HomePO homePo = null;
	MorePO morePo = null;
	MDLDPO mdldpo= null;
	BusinessProfilePO businessprofilePo=null;
	PostNeedPO postneedPo=null;
	MyNeedsDashboardPO myneeddashboardPo=null;
	JavascriptExecutor js=null;
	HashMap<String, String> scrollObject=null;

	/*
	 * @TestCaseID: More_01
	 * @Description: Tap on More in Home page
	 * @Author: Shreyas M S
	 */
	@Test(priority = 1, enabled =true,description="Tap on More in Home page")
	public void testMoreScreen() 
	{
		sTestData = "More_01";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		morePo = new MorePO(driver);
		welcomePo = new WelcomePO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "More icon in Home screen is not displayed");
			NXGReports.addStep("More icon in Home screen is successfully displayed", LogAs.PASSED, null);
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "Shortlist Link is not displayed");
			NXGReports.addStep("Shortlist Link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleListMyBusinessLnk().isDisplayed(), "List My Business Link is not displayed");
			NXGReports.addStep("List My Business Link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getElePropRentLnk().isDisplayed(), "Properties/Rentals Link is not displayed");
			NXGReports.addStep("Properties/Rentals Link is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleProfileAndSettingTxt().isDisplayed(), "Profile & Setting text is not displayed");
			NXGReports.addStep("Profile & Setting text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleUpdateMyAccLnk().isDisplayed(), "Update my account Link is not displayed under Profile & Setting");
			NXGReports.addStep("Update my account Link is successfully displayed under Profile & Setting", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleLogoutLnk().isDisplayed(), "Logout Link is not displayed under Profile & Setting");
			NXGReports.addStep("Logout Link is successfully displayed under Profile & Setting", LogAs.PASSED, null);

		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/*
	 * @TestCaseID: More_02
	 * @Description: Check tapping on "Shortlists"
	 * @Author: Shreyas M S
	 */
	@Test(priority = 2, enabled =true,description="Check tapping on 'Shortlists'")
	public void testShortListPage() 
	{
		sTestData = "More_01";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		morePo = new MorePO(driver);
		welcomePo = new WelcomePO(driver);
		try 
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "More icon in Home screen is not displayed");
			NXGReports.addStep("More icon in Home screen is successfully displayed", LogAs.PASSED, null);
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "Shortlist Link is not displayed");
			NXGReports.addStep("Shortlist Link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleShortListLnk().click();
			Assert.assertTrue(morePo.getEleShortlistPageTxt().isDisplayed(), "Shortlist page is not displayed");
			NXGReports.addStep("Shortlist page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(morePo.getEleShortlistedBusiLst().isDisplayed(), "Shortlist page is not displayed with all the user shortlisted businesses");
			NXGReports.addStep("Shortlist page is successfully displayed with all the user shortlisted businesses", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/*
	 * @TestCaseID: More_03
	 * @Description: Check tapping on "List my business"
	 * @Author: Shreyas M S
	 */
	@Test(priority = 3, enabled =true,description="Check tapping on 'List my business'")
	public void testListMyBuisnessPage() 
	{
		sTestData = "More_01";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		morePo = new MorePO(driver);
		welcomePo = new WelcomePO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "More icon in Home screen is not displayed");
			NXGReports.addStep("More icon in Home screen is successfully displayed", LogAs.PASSED, null);
			homePo.getEleMoreIcn().click();
			morePo.getEleListMyBusinessLnk().click();
			Assert.assertTrue(morePo.getEleAddBuisnessTxt().isDisplayed(), "List My Business page is not displayed");/*Verify the element in appium inspector on iOS*/
			NXGReports.addStep("List My Business page is successfully displayed", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/*
	 * @TestCaseID: Notification_01
	 * @Description: View notification and verify
	 * @Author: Shreyas M S
	 */
	@Test(priority = 4, enabled =true,description="View notification and verify")
	public void testNotificationPage() throws Exception 
	{
		sTestData = "Notification_02";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		morePo = new MorePO(driver);
		welcomePo = new WelcomePO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		postneedPo=new PostNeedPO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			morePo.getEleNotificationTab().click();
			Assert.assertTrue(morePo.getEleNotificationTxt().isDisplayed(), "Notifications page is not displayed");
			NXGReports.addStep("Notifications page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleNotificationListItm().isDisplayed(),"Notification is not displayed with need name");
			NXGReports.addStep("Notification is successfully displayed with need name", LogAs.PASSED, null);
			Thread.sleep(10000);
			Assert.assertTrue(morePo.getEleNumberofBusinessTxt().isDisplayed(), "Need name is not displayed with number of businesses matched");
			NXGReports.addStep("Need name is successfully displayed with number of businesses matched", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/*
	 * @TestCaseID: Notification_02
	 * @Description: Tap on the notification displayed
	 * @Author: Shreyas M S
	 */
	@Test(priority = 5, enabled =true,description="Tap on the notification displayed")
	public void testNotiResponsePage() 
	{
		sTestData = "Notification_01";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		morePo = new MorePO(driver);
		welcomePo = new WelcomePO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		postneedPo=new PostNeedPO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			morePo.getEleNotificationTab().click();
			Assert.assertTrue(morePo.getEleNotificationTxt().isDisplayed(), "Notifications page is not displayed");
			NXGReports.addStep("Notifications page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNotificationListItm().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "Responses page is not displayed");
			NXGReports.addStep("Responses page is successfully displayed", LogAs.PASSED, null);

		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/*
	 * @TestCaseID: RmvShortlist_01
	 * @Description: Remove shortlist and verify.
	 * @Author: Shreyas M S
	 */
	@Test(priority = 6, enabled =true,description="Remove shortlist and verify.")
	public void testRemoveMyShortlist() throws Exception 
	{
		sTestData = "More_01";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		morePo = new MorePO(driver);
		welcomePo = new WelcomePO(driver);
		mdldpo=new MDLDPO(driver);
		myneeddashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myneeddashboardPo.getEleDashboardBtn().click();
			Assert.assertTrue(morePo.getEleNeedTxt().isDisplayed(), "User is not navigated to Dashboard");
			NXGReports.addStep("User is successfully navigated to Dashboard", LogAs.PASSED, null);
			morePo.getEleNeedTxt().click();
			Assert.assertTrue(morePo.getEleNeedResponsTxt().isDisplayed(), "User is not navigated to Responses page");
			NXGReports.addStep("User is successfully navigated to Responses page", LogAs.PASSED, null);
			morePo.getEleNeedResponsTxt().click();
			Assert.assertTrue(businessprofilePo.getEleBusinessNameTxt().isDisplayed(), "User is not navigated to business profile page");/*Verify the element in appium inspector on iOS*/
			NXGReports.addStep("User is successfully navigated to business profile page", LogAs.PASSED, null);
			businessprofilePo.getEleShortlistIcn().click();
			//Assert.assertTrue(businessprofilePo.getEleShortlistTost().isDisplayed(), "The business is not shortlisted");
			//NXGReports.addStep("Toast message is displayed and business is successfully shortlisted", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User is not navigated to Response page");
			NXGReports.addStep("User is navigated to Response page", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			Assert.assertTrue(myneeddashboardPo.getEleNeedsTab().isDisplayed(), "User is not navigated to needs dashboard page");
			NXGReports.addStep("User is navigated to needs dashboard page", LogAs.PASSED, null);
			Thread.sleep(10000);
			driver.tap(1, 205, 39, 1);
			Assert.assertTrue(businessprofilePo.getEleShortlistNameTxt().isDisplayed(), "User is not navigated to Shortlist page");
			NXGReports.addStep("User is navigated to Shortlist page", LogAs.PASSED, null);
			businessprofilePo.getEleRemoveShortlistIcn().click();
			Assert.assertFalse(morePo.getEleShortList1stItm().getText().equals("Apex Services Inc."), "The need removed from shortlist still exists in the Shortlist page");
			NXGReports.addStep("The business is successfully removed from the shortlist page", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: My Reviews_01
	 * @Description: Check whether review posted by the user is displayed in Reviews page.
	 * @Author: Yashi Priya*///bug- after clicking on view dashboard navigates to responses page
	@Test(priority=7,enabled=true,description="Check whether review posted by the user is displayed in Reviews page.")
	public void testPostedReview() throws Exception
	{
		sTestData="My Reviews_01";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneeddashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		morePo= new MorePO(driver);
		postneedPo=new PostNeedPO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			myneeddashboardPo.getEleSecondOption().click();
			postneedPo.toSubmitNeed(myneeddashboardPo);
			try
			{
				Assert.assertTrue(myneeddashboardPo.getEleNeedsTab().isDisplayed(),"User is not navigated to need dashboard page");
				NXGReports.addStep("User is successfully navigated to need dashboard page",LogAs.PASSED, null);
				myneeddashboardPo.getEleNeedArrowBtn().click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User is not navigated to response page");
				NXGReports.addStep("User is successfully navigated to response page", LogAs.PASSED, null);
			}
			catch(Exception e)
			{
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User is not navigated to response page");
				NXGReports.addStep("User is successfully navigated to response page", LogAs.PASSED, null);
			}
			myneeddashboardPo.getEleReviewLink().click();
			myneeddashboardPo.getEleYesBtn().click();
			Assert.assertTrue(businessprofilePo.getEleRatingBusiTxt().isDisplayed(), "A popup to post a review is not displayed");
			NXGReports.addStep("A popup to post a review is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.toTapOnRatingBar();
			Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "Write your review text field is not displayed");
			NXGReports.addStep("Write your review text field is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleWriteyourreviewTxtFld().sendKeys(sData[10]);
			homePo.getEleKeyboardReturnBtn().click();
			businessprofilePo.getElePOSTREVIEWBtn().click();
			Assert.assertTrue(myneeddashboardPo.getEleThankyouTxt().isDisplayed()&&myneeddashboardPo.getEleVIEWDASHBOARDBtn().isDisplayed(), "Thankyou for your valuable feedback text message with View Dashboard button is not displayed");
			NXGReports.addStep("Thankyou for your valuable feedback text message with View Dashboard button is displayed", LogAs.PASSED, null);
			myneeddashboardPo.getEleVIEWDASHBOARDBtn().click();
			try{
				myneeddashboardPo.getEleNeedArrowBtn().click();
			}catch(Exception e){
				welcomePo.getEleBackArwIcn().click();
				myneeddashboardPo.getEleNeedArrow().click();
				
			}
				morePo.getEleNeedResponsTxt().click();
				businessprofilePo.scrollToReviews();
				myneeddashboardPo.getEleNameofBusinessTxt().click();
				Assert.assertTrue(businessprofilePo.getEleReviewTxt().equals(sData[10]), "The review is not displayed under reviews section in business profile page.");
				NXGReports.addStep("The review is successfully displayed under reviews section in business profile page.", LogAs.PASSED, null);
				welcomePo.getEleBackArwIcn().click();
				welcomePo.getEleBackArwIcn().click();
				morePo.getEleMyReviewIcn().click();
				Assert.assertTrue(morePo.getEleReviewsLstItm().getText().equals(sData[10]), "The review is not displayed under Reviews tab");
				NXGReports.addStep("The review is successfully displayed under Reviews tab", LogAs.PASSED, null);

		}

		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/*
	 * @TestCaseID: My Reviews_02
	 * @Description: Tap on any review displayed in My reviews page
	 * @Author: Yashi Priya
	 */
	@Test(priority = 8, enabled =true,description="Tap on any review displayed in My reviews page")
	public void testAnyReview() 
	{
		sTestData = "My Reviews_02";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		morePo = new MorePO(driver);
		welcomePo = new WelcomePO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			morePo.getEleMyReviewIcn().click();
			morePo.getEleReviewsLstItm().click();
			Assert.assertTrue(businessprofilePo.getEleReviewDetailView().isDisplayed(), "User is not navigated to detailed view of the review");
			NXGReports.addStep("User is successfully navigated to detailed view of the review", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}





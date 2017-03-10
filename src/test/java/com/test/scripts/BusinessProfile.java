/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of Business Profile page
 * @module			:		Business Profile
 * @testmethod		:	   	testBusinessProfilePage()
 * @testmethod		:	   	testCallIcon()
 * @testmethod		:	   	testSMSTap()
 * @testmethod		:	   	testShortlistTap()
 * @testmethod		:	   	testRemoveShortlistTap()
 * @testmethod		:	   	testNotificationIcon()
 * @testmethod		:	   	testWorkPhoneNumber()
 * @testmethod		:	   	testAddressTap()
 * @testmethod		:	   	testEmailIcon()
 * @testmethod		:	   	testWebIcon()
 * @testmethod		:	   	testServicesOffered()
 * @testmethod		:	   	testSubmitReview()
 * @testmethod		:		testRateReview()
 * @testmethod		:		testSubmitReview()
 */
package com.test.scripts;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
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
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.WelcomePO;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class BusinessProfile extends BaseLib {
	String sTestData=null;
	String[] sData=null;
	HomePO homePo=null;
	MyNeedsDashboardPO myneedsdashboardPo=null;
	BusinessProfilePO businessprofilePo=null;
	LoginPO loginPo=null;
	WelcomePO welcomePo=null;
	MorePO morePo=null;



	/* @TestCaseID: BusinessProfile_01
	 * @Description: To check the Business Profile page and verify all the elements present in the page.
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To check the Business Profile page and verify all the elements present in the page.")
	public void testBusinessProfilePage()
	{
		sTestData="BusinessProfile_01";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		welcomePo=new WelcomePO(driver);

		try
		{	
			homePo.navigateToHomeWOLogin(welcomePo, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			Assert.assertTrue(businessprofilePo.getEleBusinessNameTxt().isDisplayed(), "Name of the business is not displayed");
			NXGReports.addStep("Name of the business is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessLocation().isDisplayed(), "Business location is not displayed");
			NXGReports.addStep("Business location is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessReviwsTxt().isDisplayed(), "Business reviews is not displayed");
			NXGReports.addStep("Business reviews is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessScore().isDisplayed(), "Business score is not displayed");
			NXGReports.addStep("Business score is successfully displayed", LogAs.PASSED, null);
			//rating bar cannot be identified.
			Assert.assertTrue(businessprofilePo.getEleCallIcn().isDisplayed(), "Call icon in the business profile screen is not displayed");
			NXGReports.addStep("Call icon in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleSMSIcn().isDisplayed(), "SMS icon in the business profile screen is not displayed");
			NXGReports.addStep("SMS icon in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleShortlistIcn().isDisplayed(), "Shortlist icon in the business profile screen is not displayed");
			NXGReports.addStep("Shortlist icon in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleNotificationIcn().isDisplayed(), "Notification icon in the business profile screen is not displayed");
			NXGReports.addStep("Notification icon in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessWorkTxt().isDisplayed(), "Work of the business in the business profile screen is not displayed");
			NXGReports.addStep("Work of the business in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleWorkPhoneNumTxt().isDisplayed(), "Work phone number in the business profile screen is not displayed");
			NXGReports.addStep("Work phone number in the business profile screen is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleBusinessMobileNumTxt().isDisplayed(), "Mobile phone number of the business is not displayed");
			NXGReports.addStep("Mobile phone number of the business is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleAddressIcn().isDisplayed(), "Address of the business in the business profile screen is not displayed");
			NXGReports.addStep("Address of the business in the business profile screen is successfully displayed", LogAs.PASSED, null);
			try
			{
				driver.scrollTo("Landmark");
				Assert.assertTrue(businessprofilePo.getEleBusinessLandmarkTxt().isDisplayed(), "Landmark of the business in the business profile screen is not displayed");
				NXGReports.addStep("Landmark of the business in the business profile screen is successfully displayed", LogAs.PASSED, null);

			}
			catch(Exception e)
			{
				NXGReports.addStep("Landmark of the business in the business profile screen is not displayed", LogAs.PASSED, null);
			}
			driver.scrollTo("Email");
			Assert.assertTrue(businessprofilePo.getEleEmailIcn().isDisplayed(), "Business EmailID in the business profile screen is not displayed");
			NXGReports.addStep("Business EmailID in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("Contact person");
			Assert.assertTrue(businessprofilePo.getEleBusinessContactTxt().isDisplayed(), "Business Contact person in the business profile screen is not displayed");
			NXGReports.addStep("Business Contact person in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("Working hours");
			Assert.assertTrue(businessprofilePo.getEleBusinessWorkinghoursTxt().isDisplayed(), "Business Working hours in the business profile screen is not displayed");
			NXGReports.addStep("Business Working hours in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("Photos / videos");
			Assert.assertTrue(businessprofilePo.getEleBusinessImg().isDisplayed(), "Business Images in the business profile screen is not displayed");
			NXGReports.addStep("Business Images in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("About");
			Assert.assertTrue(businessprofilePo.getEleBusinessAboutTxt().isDisplayed(), "Business About section in the business profile screen is not displayed");
			NXGReports.addStep("Business About section in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("Services offered");
			Assert.assertTrue(businessprofilePo.getEleServicesOfrdTxt().isDisplayed(), "Business Services offered in the business profile screen is not displayed");
			NXGReports.addStep("Business Services offered in the business profile screen is successfully displayed", LogAs.PASSED, null);
			driver.scrollTo("Website");
			Assert.assertTrue(businessprofilePo.getEleWebsiteIcn().isDisplayed(), "Business website in the business profile screen is not displayed");
			NXGReports.addStep("Business website in the business profile screen is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.scrollToReviewsAfterWebsite();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Assert.assertTrue(businessprofilePo.getEleReviewLnk().isDisplayed(), "Business reviews section in the business profile screen is not displayed");
			NXGReports.addStep("Business reviews section in the business profile screen is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.toTestMoreReview();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_02
	 * @Description: To tap on call icon in the business profile page.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="To tap on call icon in the business profile page.")
	public void testCallIcon() throws Exception
	{
		sTestData="BusinessProfile_02";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.getEleCallIcn().click();
		businessprofilePo.handlingCall();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_03
	 * @Description: To tap on SMS icon and verify if message popup is displayed.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="To tap on SMS icon and verify if message popup is displayed.")
	public void testSMSTap()
	{
		sTestData="BusinessProfile_03";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			homePo.navigateToHomeWOLogin(welcomePo, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			businessprofilePo.getEleSMSIcn().click();
			Assert.assertTrue(businessprofilePo.getEleNewMsgTxt().isDisplayed(), "Message popup is not displayed");
			NXGReports.addStep("Message popup is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleSMSToTxtFld().isDisplayed(), "Message popup is not displayed with the To: field");
			NXGReports.addStep("Message popup is successfully displayed with the To: field", LogAs.PASSED, null);
			Assert.assertFalse(businessprofilePo.getEleBusinessPhnNumTxt().getText().isEmpty(), "Message popup is not displayed with the To: field containing business number");
			NXGReports.addStep("Message popup is successfully displayed with the To: field containing business number", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_04
	 * @Description: To tap on Shortlist icon and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="To tap on Shortlist icon and verify.")
	public void testShortlistTap()
	{
		sTestData="BusinessProfile_04";
		sData=GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		morePo=new MorePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			sBusinessName=businessprofilePo.getEleGetQuotesForBusinessLstItm().getText();
			businessprofilePo.getEleShortlistIcn().click();
			//Assert.assertTrue(businessprofilePo.getEleShortlistTost().isDisplayed(), "The business is not shortlisted");
			//NXGReports.addStep("Toast message is displayed and business is successfully shortlisted", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleRemoveShortlistIcn().isDisplayed(), "The shortlist icon has not changed to remove shortlist");
			NXGReports.addStep("The shortlist icon has successfully changed to remove shortlist", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(), "Get Quotes page for the business is not displayed");
			NXGReports.addStep("Get Quotes screen for the business is displayed", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "More page is not displayed");
			NXGReports.addStep("More page is successfully displayed", LogAs.PASSED, null);
			homePo.getEleShortListLnk().click();
			Assert.assertEquals(sBusinessName, businessprofilePo.getEleShortlistItm().getText(),"Shortlisted business is not seen under shortlist tab");
			NXGReports.addStep("Shortlisted business is successfully seen under shortlist tab", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_05
	 * @Description: To tap on Remove Shortlist icon and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true,description="To tap on Remove Shortlist icon and verify.")
	public void testRemoveShortlistTap()
	{
		sTestData="BusinessProfile_05";
		sData=GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		morePo=new MorePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo, sData[7]);
		sBusinessName=businessprofilePo.getEleBusinessNameTxt().getText();
		welcomePo.getEleBackArwIcn().click();
		Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(), "Get Quotes page for the business is not displayed");
		NXGReports.addStep("Get Quotes screen for the business is displayed", LogAs.PASSED, null);
		welcomePo.getEleBackArwIcn().click();
		Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
		NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
		homePo.getEleMoreIcn().click();
		Assert.assertTrue(homePo.getEleShortListLnk().isDisplayed(), "More page is not displayed");
		NXGReports.addStep("More page is successfully displayed", LogAs.PASSED, null);
		homePo.getEleShortListLnk().click();
		Assert.assertEquals(sBusinessName, businessprofilePo.getEleShortlistItm().getText(),"Shortlisted business is not seen under shortlist tab");
		NXGReports.addStep("Shortlisted business is successfully seen under shortlist tab", LogAs.PASSED, null);
		businessprofilePo.getEleRemoveShortlistIcn().click();
		//Assert.assertTrue(businessprofilePo.getEleRemoveShortlistTost().isDisplayed(), "Remove shortlist toast message is not displayed business is not removed from the shortlist");
		//NXGReports.addStep("Remove shortlist toast message is displayed and business is successfully removed from the shortlist", LogAs.PASSED, null);
		Assert.assertNotEquals(sBusinessName, businessprofilePo.getEleShortlistItm().getText(),"Shortlisted business is still seen under shortlist tab");
		NXGReports.addStep("Shortlisted business is no more seen under shortlist tab", LogAs.PASSED, null);
		welcomePo.getEleBackArwIcn().click();
		morePo.getEleHomeIcn().click();
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo, sData[7]);
		Assert.assertTrue(businessprofilePo.getEleShortlistIcn().isDisplayed(), "Remove shortlist icon is not changed to shortlist icon");
		NXGReports.addStep("Remove shortlist icon is successfully changed to shortlist icon", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_06
	 * @Description: To tap on Notification icon in the business profile page.
	 * @Author: Yashi Priya*/
	@Test(priority=06,enabled=true,description="To tap on Notification icon in the business profile page.")
	public void testNotificationIcon()
	{
		sTestData="BusinessProfile_06";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.getEleNotificationIcn().click();
		Assert.assertTrue(businessprofilePo.getEleNOTIFICATIONTxt().isDisplayed(), "User is not navigated to notification page");
		NXGReports.addStep("User is successfully navigated to notification page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_07
	 * @Description: Tap on the phone number displayed under Work section
	 * @Author: Yashi Priya*/
	@Test(priority=07,enabled=true,description="Tap on the phone number displayed under Work section")
	public void testWorkPhoneNumber() throws Exception
	{
		sTestData="BusinessProfile_07";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.getEleWorkPhoneNumTxt().click();
		businessprofilePo.handlingCall();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: BusinessProfile_08
	 * @Description: To tap on the address icon associated with Address
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=true,description="To tap on the address icon associated with Address")
	public void testAddressTap()
	{
		sTestData="BusinessProfile_08";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			homePo.navigateToHomeWOLogin(welcomePo, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			businessprofilePo.getEleAddressIcn().click();
			Assert.assertTrue(businessprofilePo.getEleUseGoogleMapPopup().isDisplayed(),"The Google Maps app isn’t on your phone, use the app popup is not displayed");
			NXGReports.addStep("The Google Maps app isn’t on your phone, use the app popup is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleGoogleMapNOTHANKSbtn().click();
			Assert.assertTrue(businessprofilePo.getEleBusiMapLocationTxt().isDisplayed(),"Business location is not displayed on the map");
			NXGReports.addStep("Business location is successfully displayed on the map", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_09
	 * @Description: Tap on the Email id displayed under Email section
	 * @Author: Yashi Priya*/
	@Test(priority=9,enabled=true,description="Tap on the Email id displayed under Email section")
	public void testEmailIcon()
	{
		sTestData="BusinessProfile_09";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		driver.scrollTo("Email");
		businessprofilePo.getEleEmailIcn().click();
		Assert.assertTrue(businessprofilePo.getEleNewMsgTxt().isDisplayed(), "Device specific Email Centre is not opened");
		NXGReports.addStep("Device specific Email Centre is opened", LogAs.PASSED, null);
		Assert.assertFalse(businessprofilePo.getEleBusinessEmailAddress().getText().isEmpty(), "Device specific Email Centre  with prepopulated business email id is not displayed");
		NXGReports.addStep("Device specific Email Centre  with prepopulated business email id is successfully displayed", LogAs.PASSED, null);
		Assert.assertFalse(businessprofilePo.getEleEmailMsgBody().getText().isEmpty(), "Device specific Email Centre  with Need name is not opened");
		NXGReports.addStep("Device specific Email Centre  with Need name is successfully opened", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_10
	 * @Description: To tap on the web icon of the business in the business profile page.
	 * @Author: Yashi Priya*/
	@Test(priority=10,enabled=true,description="To tap on the web icon of the business in the business profile page.")
	public void testWebIcon() throws Exception
	{
		sTestData="BusinessProfile_10";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		driver.scrollTo("Website");
		businessprofilePo.getEleWebsiteIcn().click();
		Assert.assertTrue(businessprofilePo.getEleBusinessWebImg().isDisplayed(), "Business website page is not displayed");
		NXGReports.addStep("Business website page is successfully displayed", LogAs.PASSED, null);
		//cleanupcode
		Thread.sleep(10000);
		driver.tap(1, 6, 0, 1);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}





	/* @TestCaseID: BusinessProfile_11
	 * @Description: To check the Services offered section
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=true,description="To check the Services offered section")
	public void testServicesOffered()
	{
		sTestData="BusinessProfile_11";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{
			homePo.navigateToHomeWOLogin(welcomePo, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			driver.scrollTo("Services offered");
			Assert.assertTrue(businessprofilePo.getEleServicesOfrdTxt().isDisplayed(),"Services offered section with the number of services is not displayed");
			NXGReports.addStep("Services offered section with the number of services is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleServicesOfrdLst().isDisplayed(),"List of services offered by the business is not displayed");
			NXGReports.addStep("List of services offered by the business is successfully displayed", LogAs.PASSED, null);
			try
			{
				Assert.assertTrue(businessprofilePo.getEleViewMoreBtn().isDisplayed(), "View more button is not displayed");
				NXGReports.addStep("View more button is displayed", LogAs.PASSED, null);
				businessprofilePo.getEleViewMoreBtn().click();
				driver.scrollTo("Services offered");
				Assert.assertTrue(businessprofilePo.getEleMoreServicesTxtView().isDisplayed(), "More services text view is not displayed");
				NXGReports.addStep("More services text view is successfully displayed", LogAs.PASSED, null);
				Assert.assertTrue(businessprofilePo.getEleViewLessBtn().isDisplayed(), "View less button is not displayed");
				NXGReports.addStep("View less button is successfully displayed", LogAs.PASSED, null);
				businessprofilePo.getEleViewLessBtn().click();
				driver.scrollTo("Services offered");
				Assert.assertTrue(businessprofilePo.getEleServicesOfrdLst().isDisplayed(),"Services offered section with the number of services is not displayed");
				NXGReports.addStep("Services offered section with the number of services is successfully displayed", LogAs.PASSED, null);
				Assert.assertTrue(businessprofilePo.getEleViewMoreBtn().isDisplayed(),"View more button is not displayed");
				NXGReports.addStep("View more button is successfully displayed", LogAs.PASSED, null);
			}
			catch(Exception e)
			{
				Assert.assertFalse(businessprofilePo.getEleViewMoreBtn().isDisplayed(), "View more button is displayed");
				NXGReports.addStep("View more button is not displayed", LogAs.PASSED, null);
			}

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_12
	 * @Description: Tap on Website of the business
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=true,description="Tap on Website of the business")
	public void testBusinessWebsiteLnk() throws Exception
	{
		sTestData="BusinessProfile_12";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		driver.scrollTo("Website");
		businessprofilePo.getEleWebsiteLnk().click();
		Assert.assertTrue(businessprofilePo.getEleBusinessWebImg().isDisplayed(), "Business website page is not displayed");
		NXGReports.addStep("Business website page is successfully displayed", LogAs.PASSED, null);
		Thread.sleep(10000);
		//cleanupcode
		driver.tap(1, 6, 0, 1);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: BusinessProfile_13
	 * @Description: To tap on any review-bug 
	 * @Author: Yashi Priya*/
	@Test(priority=13,enabled=true,description=" To tap on any review-bug ")
	public void testAnyReview()
	{
		sTestData="BusinessProfile_13";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			businessprofilePo.scrollToReviews();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			businessprofilePo.getEleReviewLnk().click();
			Assert.assertTrue(businessprofilePo.getEleReviewDetailView().isDisplayed(), "A detailed view of the review is not displayed");
			NXGReports.addStep("A detailed view of the review is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_14
	 * @Description: To tap on More reviews link
	 * @Author: Yashi Priya*/
	@Test(priority=14,enabled=true,description="To tap on More reviews link")
	public void testMoreReview()
	{
		sTestData="BusinessProfile_14";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			businessprofilePo.scrollToReviews();
			businessprofilePo.toTestMoreReview();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_15
	 * @Description: To tap on "write review" icon and verify the popup.
	 * @Author: Yashi Priya*/
	@Test(priority=15,enabled=true,description="To tap on 'write review' icon and verify the popup.")
	public void testWriteReview()
	{
		sTestData="BusinessProfile_15";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
			businessprofilePo.scrollToReviews();
			businessprofilePo.navigateToPostReviewPopup();
			Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "a popup with a write your review text field is not displayed");
			NXGReports.addStep("a popup with a write your review text field is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getElePOSTREVIEWBtn().isDisplayed(), "a popup with a post review button is not displayed");
			NXGReports.addStep("a popup with a post review button is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: BusinessProfile_16
	 * @Description: Tap on "Post Review" without rating/reviewing in Rate & review page
	 * @Author: Yashi Priya*/
	@Test(priority=16,enabled=true,description="Tap on 'Post Review' without rating/reviewing in Rate & review page")
	public void testSubmitWORateReview()
	{
		sTestData="BusinessProfile_16";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.scrollToReviews();
		businessprofilePo.navigateToPostReviewPopup();
		businessprofilePo.testRateBusiAlert(welcomePo);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}



	/* @TestCaseID: BusinessProfile_17
	 * @Description: Tap on "Post Review" only rating and without entering review in Rate & review page
	 * @Author: Yashi Priya*/
	@Test(priority=17,enabled=true,description="Tap on 'Post Review' only rating and without entering review in Rate & review page")
	public void testRateReview() throws Exception
	{
		sTestData="BusinessProfile_17";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.scrollToReviews();
		businessprofilePo.navigateToPostReviewPopup();
		businessprofilePo.toTapOnRatingBar();
		Assert.assertTrue(businessprofilePo.getElePOSTREVIEWBtn().isDisplayed(), "post review button is not displayed");
		NXGReports.addStep("post review button is displayed", LogAs.PASSED, null);
		businessprofilePo.getElePOSTREVIEWBtn().click();
		Assert.assertTrue(businessprofilePo.getEleReviewPostedToast().isDisplayed(),"Review is not posted");
		NXGReports.addStep("Review is successfully posted", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: BusinessProfile_18
	 * @Description:Submit the review
	 * @Author: Yashi Priya*/
	@Test(priority=18,enabled=true,description="Submit the review")
	public void testSubmitReview() throws Exception
	{
		sTestData="BusinessProfile_18";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		businessprofilePo.navigateToBusinessProfile(homePo, myneedsdashboardPo,sData[7]);
		businessprofilePo.scrollToReviews();
		businessprofilePo.navigateToPostReviewPopup();
		businessprofilePo.testRateBusiAlert(welcomePo);
		businessprofilePo.toTapOnRatingBar();
		Assert.assertTrue(businessprofilePo.getEleWriteyourreviewTxtFld().isDisplayed(), "Write your review text field is not displayed");
		NXGReports.addStep("Write your review text field is successfully displayed", LogAs.PASSED, null);
		businessprofilePo.getEleWriteyourreviewTxtFld().sendKeys(sData[8]);
		homePo.getEleKeyboardReturnBtn().click();
		businessprofilePo.getElePOSTREVIEWBtn().click();
		Assert.assertTrue(businessprofilePo.getEleReviewPostedToast().isDisplayed(),"Review is not posted");
		NXGReports.addStep("Review is successfully posted", LogAs.PASSED, null);



		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

}








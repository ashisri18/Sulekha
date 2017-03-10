/***********************************************************************
 * @author 			:		RaghuKiran MR 
 * @description		: 		Test scripts of BrowseBusinessListing 
 * @module			:		BrowserBusinessListing
 * @testmethod		:	   	testBusinessProfilePage()
 * @testmethod		:	   	testFillLink()
 * @testmethod		:	   	testCallIcon()
 * @testmethod		:	   	testSendMessageIcon()
 * @testmethod		:	   	testShortlistOptions()
 * @testmethod		:	   	testSortButtonDisplayed()
 * @testmethod		:	   	testSortByScore()
 * @testmethod		:	   	testSortByRating()
 * @testmethod		:	   	testSortByDefault()
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
import com.test.po.BusinessProfilePO;
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MDLDPO;
import com.test.po.MorePO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;

public class BrowseBusinessListing extends BaseLib {
	String sTestData=null;
	String[] sData=null;
	HomePO homePo=null;
	PostNeedPO postneedPo;
	MyNeedsDashboardPO myneedsdashboardPo=null;
	BusinessProfilePO businessprofilePo=null;
	LoginPO loginPo=null;
	WelcomePO welcomePo=null;
	MorePO morePo=null;
	MDLDPO mdldpo=null;

	/* @TestCaseID:BusinessProfilePage_01
	 * @Description:Select any item in Browse business listing and verify.
	 * @Author: RaghuKiran*/
	@Test(priority=1,enabled=true,description="Select any item in Browse business listing and verify.")
	public void testBusinessProfilePage()
	{
		sTestData="BrowseBusinessListing_01";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			homePo.getEleFirstOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleGetQuotesForBusinessLstItm().isDisplayed(), "Business listing page is not displayed");
			NXGReports.addStep("Business listing page is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleGetQuotesForBusinessLstItm().click();
			Assert.assertTrue(businessprofilePo.getEleBusinessNameTxt().isDisplayed(),"User is not navigated to business profile page");
			NXGReports.addStep("User is successfully navigated to business profile page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:BusinessProfilePage_02
	 * @Description:Tap over "Tap to fill.." link and verify whether user is redirected to need form.
	 * @Author: RaghuKiran*/
	@Test(priority=2,enabled=true,description="Tap over 'Tap to fill' link and verify whether user is redirected to need form.")
	public void testFillLink()
	{
		sTestData="BrowseBusinessListing_02";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			Assert.assertTrue(homePo.getEleFirstOption().isDisplayed(),"he required need is not displayed");
			NXGReports.addStep("The required need is successfully displayed", LogAs.PASSED, null);
			homePo.getEleFirstOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(),"Get Quotes button is not displayed");
			NXGReports.addStep("Get Quotes button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getGetQuotesBtn().click();
			Assert.assertTrue(businessprofilePo.getEleNeedNameTxt().isDisplayed(), "Need name text is not displayed");
			NXGReports.addStep("Need name text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"User should not navigated to LCF of the need");
			NXGReports.addStep("User should be navigated to LCF of the need", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}
	/* @TestCaseID:BusinessProfilePage_03
	 * @Description:Tap over CALL icon and verify.
	 * @Author: RaghuKiran*/
	@Test(priority=3,enabled=true,description="Tap over CALL icon and verify.")
	public void testCallIcon() throws Exception
	{
		sTestData="BrowseBusinessListing_03";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			homePo.getEleFirstOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleCallIcon().isDisplayed(),"Call icon is not displayed");
			NXGReports.addStep("Call icon is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleCallIcon().click();
			businessprofilePo.handlingCall();

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}
	/* @TestCaseID:BusinessProfilePage_04
	 * @Description:Tap on "Send message" icon displayed on business
	 * @Author: RaghuKiran*/
	@Test(priority=4,enabled=true,description="Tap on 'Send message' icon displayed on business")
	public void testSendMessageIcon()
	{
		sTestData="BrowseBusinessListing_04";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			myneedsdashboardPo.getEleSecondOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(postneedPo.getEleSmsIcon().isDisplayed(),"Sms icon is not displayed");
			NXGReports.addStep("Sms icon  is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleSmsIcon().click();
			Assert.assertTrue(businessprofilePo.getEleNewMsgTxt().isDisplayed(), "Message popup is not displayed");
			NXGReports.addStep("Message popup is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleSMSToTxtFld().isDisplayed(), "Message popup is not displayed with the to field containing business number");
			NXGReports.addStep("Message popup is successfully displayed with the to field containing business number", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}
	/* @TestCaseID:BusinessProfilePage_05
	 * @Description:Tap on "Shortlist" from options
	 * @Author: RaghuKiran*/
	@Test(priority=5,enabled=true,description="Tap on 'Shortlist' from options")
	public void testShortlistOptions()
	{
		sTestData="BrowseBusinessListing_05";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo = new MorePO(driver);
		mdldpo=new MDLDPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			myneedsdashboardPo.getEleSecondOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(postneedPo.getShortlistIcon().isDisplayed(),"ShortlistIcon is not displayed");
			NXGReports.addStep("Shortlist icon is successfully displayed", LogAs.PASSED, null);
			postneedPo.getShortlistIcon().click();
			welcomePo.getEleBackArwIcn().click();
			homePo.getEleMoreIcn().click();
			homePo.getEleShortListLnk().click();
			Assert.assertTrue(mdldpo.getEleShortlistsItem().isDisplayed(),"The business should not shortlisted and listed under Shortlists page");
			NXGReports.addStep("The business should be shortlisted and listed under Shortlists page", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleShortlistNameTxt().isDisplayed(),"Shortlisted name is not displayed");
			NXGReports.addStep("Shortlisted name is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}

	}
	/* @TestCaseID:BusinessProfilePage_06
	 * @Description:Tap on the Sort button displayed on right corner of business listing page
	 * @Author: RaghuKiran*/
	@Test(priority=6,enabled=true,description="Tap on the Sort button displayed on right corner of business listing page")
	public void testSortButtonDisplayed()
	{
		sTestData="BrowseBusinessListing_06";
		sData=GenericLib.toReadExcelData(sTestData);
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo = new MorePO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			myneedsdashboardPo.getEleSecondOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(businessprofilePo.getElefloatsortBtn().isDisplayed(),"Float sort button is not displayed");
			NXGReports.addStep("Float sort button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getElefloatsortBtn().click();
			Assert.assertTrue(businessprofilePo.getEleSortByScoreBtn().isDisplayed(),"Sort By Score button is not displayed");
			NXGReports.addStep("Sort By Score button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleSortByRatingBtn().isDisplayed(),"Sort By Rating button is not displayed");
			NXGReports.addStep("Sort By Rating button is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}
	/* @TestCaseID:BusinessProfilePage_07
	 * @Description:Tap on Sort by score from sort option
	 * @Author: RaghuKiran*/
	@Test(priority=7,enabled=true,description="Tap on Sort by score from sort option")
	public void testSortByScore()
	{
		sTestData="BrowseBusinessListing_07";
		sData=GenericLib.toReadExcelData(sTestData);
		String sScoreValue=null;
		String svalue=null;
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo = new MorePO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			myneedsdashboardPo.getEleSecondOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			sScoreValue = myneedsdashboardPo.getEleScoreTxt().getText();
			businessprofilePo.getElefloatsortBtn().click();
			Assert.assertTrue(businessprofilePo.getEleSortByScoreBtn().isDisplayed(),"Sort By Score button is not displayed");
			NXGReports.addStep("Sort By Score button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleSortByScoreBtn().click();
			svalue=myneedsdashboardPo.getEleScoreTxt().getText();
			Assert.assertFalse(sScoreValue.equals(svalue),"The businesses is not displayed in the descending order of score associated");
			NXGReports.addStep("The businesses is successfully displayed in the descending order of score associated", LogAs.PASSED, null);
			businessprofilePo.getElefloatsortBtn().click();
			Assert.assertTrue(businessprofilePo.getEleSortByDefaultBtn().isDisplayed(),"Sort By Default button is not displayed");
			NXGReports.addStep("Sort By Default button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleSortByDefaultBtn().click();

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}
	/* @TestCaseID:BusinessProfilePage_08
	 * @Description:Tap on Sort by rating from sort option
	 * @Author: RaghuKiran*/
	@Test(priority=8,enabled=true,description="Tap on Sort by rating from sort option")
	public void testSortByRating()
	{
		sTestData="BrowseBusinessListing_08";
		sData=GenericLib.toReadExcelData(sTestData);
		String sRatingvalue=null;
		String sRatingvalue1=null;
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo = new MorePO(driver);
		mdldpo=new MDLDPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			homePo.getEleFirstOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			sRatingvalue=businessprofilePo.getEleRatingList().getText();
			businessprofilePo.getElefloatsortBtn().click();
			Assert.assertTrue(businessprofilePo.getEleSortByRatingBtn().isDisplayed(),"Sort by rating button is not displayed");
			NXGReports.addStep("Sort by rating button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleSortByRatingBtn().click();
			sRatingvalue1=businessprofilePo.getEleRatingList().getText();
			Assert.assertFalse(sRatingvalue.equals(sRatingvalue1),"The businesses is not displayed in the descending order of rating associated");
			NXGReports.addStep("The businesses is successfully displayed in the descending order of rating associated ", LogAs.PASSED, null);
			businessprofilePo.getElefloatsortBtn().click();
			Assert.assertTrue(businessprofilePo.getEleSortByDefaultBtn().isDisplayed(),"Sort By Default button is not displayed");
			NXGReports.addStep("Sort By Default button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleSortByDefaultBtn().click();

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}


	}
	/* @TestCaseID:BusinessProfilePage_09
	 * @Description:Tap on Sort by default from sort option
	 * @Author: RaghuKiran*/
	@Test(priority=9,enabled=true,description="Tap on Sort by default from sort option")
	public void testSortByDefault ()
	{
		sTestData="BrowseBusinessListing_09";
		sData=GenericLib.toReadExcelData(sTestData);
		String sBusinessName=null;
		String sBusinessName1=null;
		homePo=new HomePO(driver);
		myneedsdashboardPo=new MyNeedsDashboardPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		postneedPo=new PostNeedPO(driver);
		morePo = new MorePO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sData[7]);
			myneedsdashboardPo.getEleSecondOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			businessprofilePo.getElefloatsortBtn().click();
			sBusinessName= businessprofilePo.getEleBusinessNameTxt().getText();
			Assert.assertTrue(businessprofilePo.getEleSortByScoreBtn().isDisplayed(),"Sort By Score button is not displayed");
			NXGReports.addStep("Sort By Score button is not displayed", LogAs.PASSED, null);
			businessprofilePo.getEleSortByScoreBtn().click();
			sBusinessName1= businessprofilePo.getEleBusinessNameTxt().getText();
			Assert.assertFalse(sBusinessName.equals(sBusinessName1),"The business name text is not same");
			NXGReports.addStep("The business name text is  same", LogAs.PASSED, null);
			businessprofilePo.getElefloatsortBtn().click();
			Assert.assertTrue(businessprofilePo.getEleSortByDefaultBtn().isDisplayed(),"Sort By Default button is not displayed");
			NXGReports.addStep("Sort By Default button is successfully displayed", LogAs.PASSED, null);
			businessprofilePo.getEleSortByDefaultBtn().click();
			Assert.assertEquals(sBusinessName,businessprofilePo.getEleBusinessNameTxt().getText(),"The businesses is not displayed in the default order");
			NXGReports.addStep("The businesses is successfully displayed in the default order", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}

	}
}

package com.test.scripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class NeedPosting extends BaseLib {
	String sTestData;
	String[] sData=null;
	WelcomePO welcomePo=null;
	LoginPO loginPo=null;
	HomePO homePo=null;
	PostNeedPO postneedPo=null;
	MDLDPO mdldpo=null;
	MyNeedsDashboardPO myNeedsDashboadrdpo=null;
	BusinessProfilePO businessprofilePo;

	/* @TestCaseID:Needposting_01
	 * @Description:Tap on the search box in the home page, enter a need name and tap on that search result need 
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=1,enabled=true,description="Tap on the search box in the home page, enter a need name and tap on that search result need")
	public void testSearchBox(){
		sTestData="Needposting_01";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			myNeedsDashboadrdpo.getEleCityTxtField().clear();
			Assert.assertTrue(myNeedsDashboadrdpo.getEleCityTxtField().isDisplayed(),"City text field is not displayed");
			NXGReports.addStep("City text field is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleCityTxtField().sendKeys(sData[6]);
			myNeedsDashboadrdpo.getEleCityOption().click();
			homePo.getEleKeyboardReturnBtn().click();
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "An imtermediate pop-up will not displayed to chose need name");
			NXGReports.addStep("An imtermediate pop-up will be displayed to chose need name", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_02
	 * @Description:Tap on any popular category and verify
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=2,enabled=true,description="Tap on any popular category and verify")
	public void testPopularCategory(){
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Popular categories is not displayed");
			NXGReports.addStep("Popular categories is successfully displayed", LogAs.PASSED, null);
			homePo.getEleHomeAppliancesIcn().click();
			Assert.assertTrue(homePo.getEleHomeAppliancesIcn().isDisplayed(),"An intermediate pop-up will not displayed to choose need name");
			NXGReports.addStep("An imtermediate pop-up will be displayed to chose need name", LogAs.PASSED, null);
			Assert.assertTrue(mdldpo.getEleFillformBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"BrowseBusinessListing link is not displayed");
			NXGReports.addStep("BrowseBusinessListing link is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_03
	 * @Description:Select a need from the list and tap on "Fill the form and get free quotes" button
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=3,enabled=true,description="Select a need from the list and tap on 'Fill the form and get free quotes' button")
	public void testNeedFormList(){
		sTestData="Needposting_02";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleSecondOption().click();
			Assert.assertTrue(mdldpo.getEleFillformBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(businessprofilePo.getEleNeedNameTxt().isDisplayed(), "Need name text is not displayed");
			NXGReports.addStep("Need name text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(), "User should not redirected to the specific need form page");
			NXGReports.addStep("User should be redirected to the specific need form page", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:Needposting_04
	 * @Description:Tap on "Fill the form and get free quotes" button without choosing any option from the list
	 * @Author: RAGHUKIRAN MR*///bug
	@Test(priority=4,enabled=true,description="Tap on 'Fill the form and get free quotes' button without choosing any option from the list")
	public void testNeedFormLstWOOption(){
		sTestData="Needposting_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleSecondOption().click();
			Assert.assertTrue(mdldpo.getEleFillformBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleFillformBtn().click();
			postneedPo.getEleFormRadioBtn().click();
			Assert.assertTrue(postneedPo.getEleAlertSelectOneOption().isDisplayed(), "Alert with message 'Please select one option' is not displayed");
			NXGReports.addStep("Alert with message 'Please select one option' is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:Needposting_05
	 * @Description:Select any need from the list and tap on "Browse bussinees listing" link
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=5,enabled=true,description="Select any need from the list and tap on 'Browse bussinees listing' link")
	public void testBrowseBussinesslink(){
		sTestData="Needposting_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successsfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleSecondOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"Browser business listing link is not displayed");
			NXGReports.addStep("Browser business listing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleGetQuotesForBusinessLstItm().isDisplayed(), "Business listing page is not displayed");
			NXGReports.addStep("Business listing page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(), "Get quotes button is not displayed");
			NXGReports.addStep("Get quotes button is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_06
	 * @Description:Tap on "Browse business listing" link without choosing any option from the list
	 * @Author: RAGHUKIRAN MR*/
	@Test(priority=6,enabled=true,description="Tap on 'Browse business listing' link without choosing any option from the list")
	public void testBusinessLstWOOption(){
		sTestData="Needposting_04";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			myNeedsDashboadrdpo.getEleSecondOption().click();
			Assert.assertTrue(homePo.getEleBrowseBusinessListingBtn().isDisplayed(),"Browser business listing link is not displayed");
			NXGReports.addStep("Browser business listing link is successfully displayed", LogAs.PASSED, null);
			homePo.getEleBrowseBusinessListingBtn().click();
			Assert.assertTrue(businessprofilePo.getEleGetQuotesForBusinessLstItm().isDisplayed(), "Business listing page is not displayed");
			NXGReports.addStep("Business listing page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getGetQuotesBtn().isDisplayed(), "Get quotes button is not displayed");
			NXGReports.addStep("Get quotes button is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_07
	 * @Description:In the need form Tap on the NEXT button without choosing any options
	 * @Author:RaghuKiran MR*/
	@Test(priority=7,enabled=true,description="In the need form Tap on the NEXT button without choosing any options")
	public void testNextWOChoosing()
	{
		sTestData="Needposting_06";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			mdldpo.search(sData, homePo, myNeedsDashboadrdpo);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleAlertQuestionPopup().isDisplayed(), "An alert with please select atleast one optionis not displayed");
			NXGReports.addStep("An alert with please select atleast one optionis is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID:Needposting_08
	 * @Description:Select "Others" as an Option in the question list
	 * @Author:RaghuKiran MR*/
	@Test(priority=8,enabled=true,description="Select 'Others' as an Option in the question list")
	public void testOthersOption()
	{
		sTestData="Needposting_06";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		mdldpo=new MDLDPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed",LogAs.PASSED, null);
			homePo.getEleFirstOption().click();
			Assert.assertTrue(mdldpo.getEleFillformBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.INFO, null);
			mdldpo.getEleFillformBtn().click();
			Assert.assertTrue(mdldpo.getEleOthersBtn().isDisplayed(),"Other option is not displayed");
			NXGReports.addStep("Other option is successfully displayed", LogAs.INFO, null);
			mdldpo.getEleOthersBtn().click();
			Assert.assertTrue(mdldpo.getEleTellUsTxtFld().isDisplayed(),"User should not show 'Tell us more' as the last question,before choosing locality");
			NXGReports.addStep("User should bes show 'Tell us more' as the last question,before choosing locality", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID:Needposting_09
	 * @Description:Tap on next buton withoout providing any value in "Tell us more" field
	 * @Author:RaghuKiran MR*///bug
	@Test(priority=9,enabled=true,description="Tap on next buton withoout providing any value in 'Tell us more' field")
	public void testNextWOValue()
	{
		sTestData="Needposting_06";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		mdldpo=new MDLDPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sData[7]);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed",LogAs.PASSED, null);
			homePo.getEleFirstOption().click();
			Assert.assertTrue(mdldpo.getEleFillformBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
			NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.INFO, null);
			mdldpo.getEleFillformBtn().click();
			Assert.assertTrue(mdldpo.getEleTellUsTxtFld().isDisplayed(),"User should not show 'Tell us more' as the last question,before choosing locality");
			NXGReports.addStep("User should bes show 'Tell us more' as the last question,before choosing locality", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleAlertValuepopup().isDisplayed(),"User should not displayed with the message 'Please enter value'");
			NXGReports.addStep("User should be displayed with the message 'Please enter value'", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();


		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}

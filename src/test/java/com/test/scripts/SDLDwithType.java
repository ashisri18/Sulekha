/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of SDLDwithType. 
 * @module			:		SDLDwithType
 * @testmethod		:	   	testSDLDneedWithType()
 * @testmethod		:	   	testSingleSelectQuestion()
 * @testmethod		:	   	testOptionAlert()
 * @testmethod		:	   	testConfirmAndSubmitPage()
 * @testmethod		:	   	testEditIcon()
 * @testmethod		:	   	testUpdatingAttribute()
 * @testmethod		:	   	testSubmitRequestBtn()
 */
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
import com.test.po.HomePO;
import com.test.po.LoginPO;
import com.test.po.MyNeedsDashboardPO;
import com.test.po.PostNeedPO;
import com.test.po.WelcomePO;

public class SDLDwithType extends BaseLib {
	String sTestData=null;
	String[] sData=null;
	String sNeed;
	PostNeedPO postneedPo;
	HomePO homePo;
	LoginPO loginPo;
	WelcomePO welcomePo;
	MyNeedsDashboardPO myNeedsDashboardPo;

	/* @TestCaseID: SDLDwithType_01
	 * @Description: Only one question form should be displayed followed by Contact Info page
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="Only one question form should be displayed followed by Contact Info page")
	public void testSDLDNeedWithType()
	{
		sTestData="SDLDwithType_01";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleKeyboardReturnBtn().click();
			driver.scrollTo(sNeed);
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleAmbulanceServicesLstItm().click();
			Assert.assertTrue(postneedPo.getEleFillformBtn().isDisplayed(),"he required need is not selected");
			NXGReports.addStep("The required need is successfully selected", LogAs.PASSED, null);
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "More than one question form is displayed");
			NXGReports.addStep("Only one question form is displayed", LogAs.PASSED, null);
			postneedPo.getEleFormRadioBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "User is not followed to contact information screen");
			NXGReports.addStep("User is successfully followed to contact information screen", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithType_02
	 * @Description: User should be shown a single select question with types to choose
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="User should be shown a single select question with types to choose")
	public void testSingleSelectQuestion()
	{
		sTestData="SDLDwithType_02";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleAmbulanceServicesLstItm().click();
			Assert.assertTrue(postneedPo.getEleFillformBtn().isDisplayed(),"Fill form popup is not displayed");
			NXGReports.addStep("Fill form popup is displayed", LogAs.PASSED, null);
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "Only one question form is not displayed");
			NXGReports.addStep("Only one question form is displayed", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleFormRadioBtn().isDisplayed(), "User is not shown with a single select question with types to choose");
			NXGReports.addStep("User is successfully shown with a single select question with types to choose", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithType_03
	 * @Description: Tap on next button without choosing any option.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="Tap on next button without choosing any option.")
	public void testOptionAlert()
	{
		sTestData="SDLDwithType_03";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleAmbulanceServicesLstItm().click();
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "Form page for the particular need is not displayed");
			NXGReports.addStep("Form page for the particular need is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSelectAtleastOneOptAlertPopup().isDisplayed(), "Please select atleast one option Alert popup is not displayed");
			NXGReports.addStep("Please select atleast one option Alert popup is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithType_04
	 * @Description: Tap on NEXT in Contact information page,user should be navigated to Confirm and submit page."
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="Tap on NEXT in Contact information page,user should be navigated to Confirm and submit page.")
	public void testConfirmAndSubmitScreen()
	{
		sTestData="SDLDwithType_04";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("TSearch result is displayed successfully", LogAs.PASSED, null);
			homePo.getEleAmbulanceServicesLstItm().click();
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(postneedPo.getEleFormRadioBtn().isDisplayed(), "Form radio button is not displayed");
			NXGReports.addStep("Form radio button is displayed", LogAs.PASSED, null);
			postneedPo.getEleFormRadioBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "Contact and Information page is not displayed");
			NXGReports.addStep("Contact and Information page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "Confirm and submit page is not displayed");
			NXGReports.addStep("Confirm and submit page is successfully displayed", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithType_05
	 * @Description: Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page,User should be navigated to that specific questionnaire."
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true,description="Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page,User should be navigated to that specific questionnaire.")
	public void testEditIcon()
	{
		sTestData="SDLDwithType_05";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleAmbulanceServicesLstItm().click();
			postneedPo.getEleFillformBtn().click();
			postneedPo.getEleFormRadioBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "Confirm and submit page is not displayed");
			NXGReports.addStep("Confirm and submit page is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleEditIcn().isDisplayed(), "Edit icon is not displayed in submit page");
			NXGReports.addStep("Edit icon is displayed in submit page", LogAs.PASSED, null);	
			postneedPo.getEleEditIcn().click();
			Assert.assertTrue(postneedPo.getEleFormRadioBtn().isDisplayed(), "User is not navigated to that specific questionnaire");
			NXGReports.addStep("User is successfully navigated to that specific questionnaire", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "Redirecting to Form page after clicking on edit icon is not successful");
			NXGReports.addStep("Redirecting to Form page after clicking on edit icon is successful", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithType_06
	 * @Description: Tap over NEXT button after updating.User should be navigated to Confirm and submit page after updating an attribute in the question page."
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=true,description="Tap over NEXT button after updating.User should be navigated to Confirm and submit page after updating an attribute in the question page.")
	public void testUpdatingAttribute()
	{
		sTestData="SDLDwithType_06";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		myNeedsDashboardPo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleAmbulanceServicesLstItm().click();
			postneedPo.getEleFillformBtn().click();
			postneedPo.getEleFormRadioBtn().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleEditIcn().click();
			Assert.assertTrue(postneedPo.getEleFormRadioBtn().isDisplayed(), "User is not navigated to that specific questionnaire");
			NXGReports.addStep("User is successfully navigated to that specific questionnaire", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleFormRadioBtn2().isDisplayed(), "User is not navigated to that specific questionnaire and thus the second radio button is not displayed");
			NXGReports.addStep("User is successfully navigated to that specific questionnaire with the second radio button displayed on the page", LogAs.PASSED, null);
			postneedPo.getEleFormRadioBtn2().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "Contact and Information page is not displayed");
			NXGReports.addStep("Contact and Information page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "Confirm and submit page is not displayed");
			NXGReports.addStep("Confirm and submit page is successfully displayed", LogAs.PASSED, null);


		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithType_07
	 * @Description: Tap over SUBMIT button in Confirm and submit page
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=true,description="Tap over SUBMIT button in Confirm and submit page")
	public void testSubmitRequestBtn()
	{
		sTestData="SDLDwithType_07";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.getEleSearchTxtFld().sendKeys(sNeed);
			homePo.getEleKeyboardReturnBtn().click();
			Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
			NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
			homePo.getEleAmbulanceServicesLstItm().click();
			Assert.assertTrue(postneedPo.getEleFillformBtn().isDisplayed(), "Fill form popup is not displayed");
			NXGReports.addStep("The required need is successfully selected", LogAs.PASSED, null);
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "Form page for the particular need is not displayed");
			NXGReports.addStep("Form page for the particular need is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleFormRadioBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "Contact and Information page is not displayed");
			NXGReports.addStep("Contact and Information page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "Confirm and submit page is not displayed");
			NXGReports.addStep("Confirm and submit page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleSubmitRequestBtn().click();
			//Assert.assertTrue(driver.findElement(By.xpath("//UIAStaticText[@name='Thank you']")).isDisplayed(), "Thank you screen is not displayed");
			//NXGReports.addStep("Thank you screen is displayed", LogAs.PASSED, null);
			try{
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed()&&myNeedsDashboardPo.getEleNotFinalisedBusinessBtn().isDisplayed(), "Not redirecting to response page");
				NXGReports.addStep("redirecting to response page", LogAs.PASSED, null);
			}catch(Exception e){
				myNeedsDashboardPo.getEleNeedArrowBtn().click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed()&&myNeedsDashboardPo.getEleNotFinalisedBusinessBtn().isDisplayed(), "Not redirecting to response page");
				NXGReports.addStep("redirecting to response page", LogAs.PASSED, null);
			}

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

}

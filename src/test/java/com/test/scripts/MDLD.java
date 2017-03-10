/***********************************************************************
 * @author 			:		RaghuKiran
 * @description		: 		Test scripts of MDLD 
 * @module			:		MDLD
 * @testmethod		:	  testMDLDNeed() 	
 * @testmethod		:	  testCheckShowQuestion()
 * @testmethod		:	  testNextWOChoosing()
 * @testmethod		:	  testChooseLocality()	
 * @testmethod		:	  testNextContactInfo()
 * @testmethod		:	  testEdiIcon()
 * @testmethod		:	  testNextAfterUpdating()
 * @testmethod		:	  testNextWOChangeValue() 
 * @testmethod		:	  testNeedResponsePage() 
 * @testmethod		:	  testOthersOption()
 * @testmethod		:	  testOthersChoosingQuestion()	
 * @testmethod		:	  testLCFNeedPost()
 */

package com.test.scripts;

import java.awt.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

public class MDLD extends BaseLib {
	String sTestData=null;
	String[] sData=null;
	PostNeedPO postneedPo;
	HomePO homePo;
	LoginPO loginPo;
	WelcomePO welcomePo;
	MDLDPO mdldpo;
	MyNeedsDashboardPO myNeedsDashboadrdpo;
	BusinessProfilePO businessprofilePo;

	/* @TestCaseID: MDLDTest_01
	 * @Description: Search for a MDLD need with type(Ex: Business intelligence & analytics training), and post a need.
	 * @Author:RaghuKiran MR*/
	@Test(priority=1,enabled=true,description="Search for a MDLD need with type(Ex: Business intelligence & analytics training), and post a need.")
	public void testMDLDNeed() throws Exception
	{
		sTestData="MDLDTest_01";
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
			mdldpo.search(sData, homePo, myNeedsDashboadrdpo);
			mdldpo.handleForm(sData[8], postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit Request page is not displayed");
			NXGReports.addStep("Submit Request page is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleSubmitRequestBtn().click();
			try{
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User is not navigated to Dashboard Responses page when lead is distributed");
				NXGReports.addStep("Responses page is successfully displayed", LogAs.PASSED, null);
			}catch(Exception e){
				myNeedsDashboadrdpo.getEleNeedArrowBtn().click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User is not navigated to Dashboard Responses page when lead is distributed");
				NXGReports.addStep("Need Dashboard page is successfully displayed", LogAs.PASSED, null);
			}
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_02
	 * @Description:Check if user is shown question with select options
	 * @Author:RaghuKiran MR*/
	@Test(priority=2,enabled=true,description="Check if user is shown question with select options")
	public void testCheckShowQuestion()

	{
		sTestData="MDLDTest_02";
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
			Assert.assertTrue(mdldpo.getEleQuestionLookingTxt().isDisplayed(),"Question text is not displayed");
			NXGReports.addStep("Question text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"Show question with  select options page is not displayed");
			NXGReports.addStep("Show question with  select options page is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_03
	 * @Description:Tap on the NEXT button without choosing any options
	 * @Author:RaghuKiran MR*/
	@Test(priority=3,enabled=true,description="Tap on the NEXT button without choosing any options")
	public void testNextWOChoosing()
	{
		sTestData="MDLDTest_03";
		sData=GenericLib.toReadExcelData(sTestData);
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		businessprofilePo=new BusinessProfilePO(driver);
		mdldpo=new MDLDPO(driver);
		myNeedsDashboadrdpo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			mdldpo.search(sData, homePo, myNeedsDashboadrdpo);
			Assert.assertTrue(mdldpo.getEleNextBtn().isDisplayed(),"Show question with  select options page is not displayed");
			NXGReports.addStep("Show question with  select options page is successfully displayed", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleAlertQuestionPopup().isDisplayed(), "An alert with please select atleast one optionis not displayed");
			NXGReports.addStep("An alert with please select atleast one option is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_04
	 * @Description:Check if Choose locality question is displayed for B2U and U2B categories.
	 * @Author:RaghuKiran MR*/
	@Test(priority=4,enabled=true,description="Check if Choose locality question is displayed for B2U and U2B categories.")
	public void testChooseLocality() throws Exception
	{
		sTestData="MDLDTest_04";
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
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"Show question with  select options page is not displayed");
			NXGReports.addStep("Show question with  select options page is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleFormCheckBox().click();
			Assert.assertTrue(mdldpo.getEleDestQuestTxt().isDisplayed(),"Destination question is not displayed");
			NXGReports.addStep("Destination question is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(mdldpo.getEleLocationTxt().getText().equals(sData[6]),"Location name is not displayed");
			NXGReports.addStep("Location name is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(mdldpo.getEleDestinationTxtBox().isDisplayed(),"Choose locality question should not displayed for both U2B and B2U categories");
			NXGReports.addStep("Choose locality question should is successfully displayed for both U2B and B2U categories", LogAs.PASSED, null);	
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_05
	 * @Description:Tap on NEXT in Contact information page.
	 * @Author:RaghuKiran MR*/
	@Test(priority=5,enabled=true,description="Tap on NEXT in Contact information page.")
	public void testNextContactInfo() throws Exception
	{
		sTestData="MDLDTest_05";
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
			mdldpo.handleForm(sData[8],postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully  displayed", LogAs.PASSED, null);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleNeedTxt().isDisplayed(), "Need text is not displayed in submit page");
			NXGReports.addStep("Need text is successfully displayed in submit page", LogAs.PASSED, null);	
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit Request page is not displayed");
			NXGReports.addStep("Submit Request page is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_06
	 * @Description:Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page.
	 * @Author:RaghuKiran MR*/
	@Test(priority=6,enabled=true,description="Tap over EDIT icon for the attribute group questionnaire in Confirm and submit page.")
	public void testEdiIcon() throws Exception
	{
		sTestData="MDLDTest_06";
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
			mdldpo.handleForm(sData[8],postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleEditicon().isDisplayed(),"Edit icon is not displayed");
			NXGReports.addStep("Edit icon is successfuly displayed", LogAs.PASSED, null);	
			mdldpo.getEleEditicon().click();
			Assert.assertTrue(mdldpo.getEleQuestionLookingTxt().isDisplayed(),"Question text is not displayed");
			NXGReports.addStep("Question text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"User should not navigated to that specific questionnaire");
			NXGReports.addStep("User should be navigated to that specific questionnaire", LogAs.PASSED, null);	

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_07
	 * @Description:Tap over NEXT button after updating.
	 * @Author:RaghuKiran MR*/
	@Test(priority=7,enabled=true,description="Tap over NEXT button after updating.")
	public void testNextAfterUpdating() throws Exception
	{
		sTestData="MDLDTest_07";
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
			mdldpo.handleForm(sData[8],postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			postneedPo.getEleNextBtn().click();
			mdldpo.getEleEditicon().click();
			Assert.assertTrue(businessprofilePo.getEleFormPagingTxt().isDisplayed(),"User should not navigated to the next question page");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			mdldpo.getEleFormCheckBox1().click();
			Assert.assertTrue(mdldpo.getEleDestQuestTxt().isDisplayed(),"Destination question is not displayed");
			NXGReports.addStep("Destination question is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_08
	 * @Description:Tap over NEXT button without changing any values.
	 * @Author:RaghuKiran MR*/
	@Test(priority=8,enabled=true,description="Tap over NEXT button without changing any values.")
	public void testNextWOChangeValue() throws Exception
	{
		sTestData="MDLDTest_08";
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
			mdldpo.handleForm(sData[8],postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			postneedPo.getEleNextBtn().click();
			mdldpo.getEleEditicon().click();
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleNeedTxt().isDisplayed(), "Need text is not displayed in submit page");
			NXGReports.addStep("Need text is successfully displayed in submit page", LogAs.PASSED, null);	
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(),"User should not navigated to the confirm and submit page");
			NXGReports.addStep("User should be navigated to the confirm and submit page", LogAs.PASSED, null);	
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_09
	 * @Description: Tap over SUBMIT button in Confirm and submit page.
	 * @Author:RaghuKiran MR*/
	@Test(priority=9,enabled=true,description="Tap over SUBMIT button in Confirm and submit page.")
	public void testNeedResponsePage() throws Exception
	{
		sTestData="MDLDTest_09";
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
			mdldpo.handleForm(sData[8],postneedPo);
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleNeedTxt().isDisplayed(), "Need text is not displayed in submit page");
			NXGReports.addStep("Need text is successfully displayed in submit page", LogAs.PASSED, null);	
			mdldpo.getEleSubmitRequestBtn().click();
			try{
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User is not navigated to Dashboard Responses page when lead is distributed");
				NXGReports.addStep("Responses page is successfully displayed", LogAs.PASSED, null);
			}catch(Exception e){
				myNeedsDashboadrdpo.getEleNeedArrowBtn().click();
				Assert.assertTrue(postneedPo.getEleResponsesTab().isDisplayed(), "User is not navigated to Dashboard Responses page when lead is distributed");
				NXGReports.addStep("Need Dashboard page is successfully displayed", LogAs.PASSED, null);
			}
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_10
	 * @Description:Select "Others" as an Option in the question list
	 * @Author:RaghuKiran MR*///bug
	@Test(priority=10,enabled=true,description="Select 'Others' as an Option in the question list")
	public void testOthersOption()
	{
		sTestData="MDLDTest_10";
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
			mdldpo.search(sData, homePo, myNeedsDashboadrdpo);	
			mdldpo.getEleOthersBtn().click();
			mdldpo.getEleFormRadioBtn().click();
			mdldpo.getEleFormCheckBox().click();
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleTellUsTxtFld().isDisplayed(),"User should not show 'Tell us more' as the last question,before choosing locality");
			NXGReports.addStep("User should be show 'Tell us more' as the last question,before choosing locality", LogAs.PASSED, null);	
			mdldpo.getEleTellUsTxtFld().sendKeys(sData[10]);
			homePo.getEleKeyboardReturnBtn().click();
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleLocationTxtFld().isDisplayed(),"Destination localitity text field is not displayed");
			NXGReports.addStep("Destination localitity text field is successfully displayed", LogAs.PASSED, null);	
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_11
	 * @Description:Submit a need with "Others" as an Option choosen for a question.
	 * @Author:RaghuKiran MR*///bug
	@Test(priority=11,enabled=true,description="Submit a need with 'Others' as an Option choosen for a question.")
	public void testOthersChoosingQuestion() throws Exception
	{
		sTestData="MDLDTest_11";
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
			mdldpo.search(sData, homePo, myNeedsDashboadrdpo);
			mdldpo.getEleOthersBtn().click();
			mdldpo.getEleFormRadioBtn().click();
			mdldpo.getEleFormCheckBox().click();
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleTellUsTxtFld().isDisplayed(),"User should not show 'Tell us more' as the last question,before choosing locality");
			NXGReports.addStep("User should be show 'Tell us more' as the last question,before choosing locality", LogAs.PASSED, null);	
			mdldpo.getEleTellUsTxtFld().sendKeys(sData[10]);
			homePo.getEleKeyboardReturnBtn().click();
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleLocationTxtFld().isDisplayed(), "Location text field is not displayed");
			NXGReports.addStep("Location text field is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleLocationTxtFld().sendKeys(sData[8]);
			Thread.sleep(20000);
			Assert.assertTrue(mdldpo.getEleLocalitiesList().isDisplayed(), "Location list is not displayed");
			NXGReports.addStep("Location list is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleLocalitiesList().click();
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(), "Submit button is not displayed");
			NXGReports.addStep("Submit button is successfully displayed", LogAs.PASSED, null);
			mdldpo.getEleSubmitRequestBtn().click();
			Assert.assertTrue(mdldpo.getEleAdditionalinfoTxt().isDisplayed(),"Fetching matching business for your requrement text message is not displayed");
			NXGReports.addStep("Fetching matching business for your requrement text message is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: MDLDTest_12
	 * @Description:Fill the LCF and POST a need for any SDLD need(Camera Dealears,User enters the text )
	 * @Author:RaghuKiran MR*/
	@Test(priority=12,enabled=true,description="Fill the LCF and POST a need for any SDLD need(Camera Dealears,User enters the text)")
	public void testTellusMoreWithValue()
	{
		sTestData="MDLDTest_12";
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
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(postneedPo.getEleTellusmoreTxt().isDisplayed(), "User is not  displayed only with Tell us more field.");
			NXGReports.addStep("User is successfully displayed only with Tell us more field.",LogAs.PASSED, null);
			postneedPo.getEleTellusMoreTxtFld().sendKeys(sData[9]);
			homePo.getEleKeyboardReturnBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleAdditionalInfoTxt().isDisplayed(),"Additional information text is not displayed");
			NXGReports.addStep("Additional information text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleNeedTxt().isDisplayed(),"Update need text is not displayed");
			NXGReports.addStep("Update need text is successfully displayed", LogAs.PASSED, null);
		
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	
	/* @TestCaseID: MDLDTest_13
	 * @Description:Fill the LCF and POST a need for any SDLD need(Camera Dealears,User without enters the text)
	 * @Author:RaghuKiran MR*/
	@Test(priority=13,enabled=true,description="Fill the LCF and POST a need for any SDLD need(Camera Dealears,User without enters the text)")
	public void testTellUsMoreWOValue()
	{
		sTestData="MDLDTest_12";
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
			postneedPo.getEleFillformBtn().click();
			Assert.assertTrue(postneedPo.getEleTellusmoreTxt().isDisplayed(), "User is not  displayed only with Tell us more field.");
			NXGReports.addStep("User is successfully displayed only with Tell us more field.",LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleContactInformation().isDisplayed(),"The contact information page is not displayed");
			NXGReports.addStep("The contact information page is successfully displayed", LogAs.PASSED, null);	
			mdldpo.getEleNextBtn().click();
			mdldpo.getEleNextBtn().click();
			Assert.assertTrue(mdldpo.getEleNeedTxt().isDisplayed(), "Need text is not displayed in submit page");
			NXGReports.addStep("Need text is successfully displayed in submit page", LogAs.PASSED, null);	
			Assert.assertTrue(mdldpo.getEleSubmitRequestBtn().isDisplayed(),"Submit Request page is not displayed");
			NXGReports.addStep("Submit Request page is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
}

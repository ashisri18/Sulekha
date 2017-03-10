package com.test.scripts;
import java.util.concurrent.TimeUnit;
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
public class SDLDWithoutType extends BaseLib {

	String sTestData=null;
	String[] sData=null;
	String sNeed;
	PostNeedPO postneedPo;
	HomePO homePo;
	LoginPO loginPo;
	WelcomePO welcomePo;
	MyNeedsDashboardPO myNeedsDashboardPo;

	/* @TestCaseID: SDLDwithoutType_01
	 * @Description: To check if user is shown question with "Tell us more" label for this case. 
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="To check if user is shown question with 'Tell us more' label for this case.")
	public void testTellUsMoreLabel()
	{
		sTestData="SDLDwithoutType_01";
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
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_02
	 * @Description: To Tap over NEXT button without entering any value in Tell us more field.
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="To Tap over NEXT button without entering any value in Tell us more field.")
	public void testNextWithEmptyTellusMoreFld()
	{
		sTestData="SDLDwithoutType_02";
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
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "User is not redirected to Contact information page.");
			NXGReports.addStep("User is successfully redirected to Contact information page.", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_03
	 * @Description:Tap on NEXT in Contact information page.
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="Tap on NEXT in Contact information page.")
	public void testConfirmAndSubmitScreen()
	{
		sTestData="SDLDwithoutType_03";
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
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "User is not redirected to Contact information page.");
			NXGReports.addStep("User is successfully redirected to Contact information page..", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_04
	 * @Description: To check in Confirm and submit page when value is not provided in "Tell us more" field.
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="To check in Confirm and submit page when value is not provided in 'Tell us more' field.")
	public void testNeedLabelNeedName()
	{
		sTestData="SDLDwithoutType_04";
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
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleNeedLabel().isDisplayed(), "User is not displayed with Need label");
			NXGReports.addStep("User is not displayed with Need label", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleNeedNameTxt().isDisplayed(), "User is not displayed with Need name");
			NXGReports.addStep("User is successfully displayed with Need name", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleCityLabel().isDisplayed(), "User is not displayed with City label");
			NXGReports.addStep("User is successfully displayed with City label", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleCityNameTxt().isDisplayed(), "User is not displayed with City name");
			NXGReports.addStep("User is successfully displayed with City name", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_05
	 * @Description: To check in Confirm and submit page when value is provided in "Tell us more" field.
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true,description="To check in Confirm and submit page when value is provided in 'Tell us more' field.")
	public void testTellusMoreFldWithValue()
	{
		sTestData="SDLDwithoutType_05";
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
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleTellusMoreTxtFld().sendKeys(sData[8]);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleAdditionalInfoLabel().isDisplayed(), "User is not displayed with Additional info label");
			NXGReports.addStep("User is successfully displayed with Additional info label", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.geteleUserCommentTxt().isDisplayed(), "User comment is not displayed in confirm and submit page");
			NXGReports.addStep("User comment is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleCityLabel().isDisplayed(), "User is not displayed with City label");
			NXGReports.addStep("User is successfully displayed with City label", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleCityNameTxt().isDisplayed(), "User is not displayed with City name");
			NXGReports.addStep("User is successfully displayed with City name", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_06
	 * @Description: To tap over EDIT icon for the Additional info/ Need  in Confirm and submit page.
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=true,description="To tap over EDIT icon for the Additional info/ Need  in Confirm and submit page.")
	public void testEditIcnforAdditionalInfo()
	{
		sTestData="SDLDwithoutType_06";
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
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleTellusMoreTxtFld().sendKeys(sData[8]);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleAdditionalInfoLabel().isDisplayed(), "User is not displayed with Additional info label");
			NXGReports.addStep("User is successfully displayed with Additional info label", LogAs.PASSED, null);
			postneedPo.getEleAdditionalInfoEditIcn().click();
			Assert.assertTrue(postneedPo.getEleTellusmoreTxt().isDisplayed(), "User is not navigated to the specific questionnaire.");
			NXGReports.addStep("User is navigated to the specific questionnaire.", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleFormPagingTxt().isDisplayed(), "User is not navigated to the specific questionnaire.");
			NXGReports.addStep("User is navigated to the specific questionnaire.", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_07
	 * @Description: To tap over NEXT button after updating the Additional Info.
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=true,description="To tap over NEXT button after updating the Additional Info.")
	public void testUpdateInfo()
	{
		sTestData="SDLDwithoutType_07";
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
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleTellusMoreTxtFld().sendKeys(sData[8]);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
			Assert.assertTrue(postneedPo.getEleAdditionalInfoLabel().isDisplayed(), "User is not displayed with Additional info label");
			NXGReports.addStep("User is successfully displayed with Additional info label", LogAs.PASSED, null);
			postneedPo.getEleAdditionalInfoEditIcn().click();
			Assert.assertTrue(postneedPo.getEleTellusmoreTxt().isDisplayed(), "User is not navigated to the specific questionnaire.");
			NXGReports.addStep("User is navigated to the specific questionnaire.", LogAs.PASSED, null);
			postneedPo.geteleUserCommentTxt().clear();
			homePo.getEleKeyboardReturnBtn().click();
			postneedPo.getEleTellusMoreTxtFld().sendKeys(sData[6]);
			homePo.getEleKeyboardReturnBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleContactInfoTxt().isDisplayed(), "User is not redirected to Contact information page.");
			NXGReports.addStep("User is successfully redirected to Contact information page.", LogAs.PASSED, null);
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: SDLDwithoutType_08
	 * @Description: To Tap over SUBMIT button in Confirm and submit page when need name is passed as attribute value.
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=true,description="To Tap over SUBMIT button in Confirm and submit page when need name is passed as attribute value.")
	public void testSubmitWithNeedNameAttribute()
	{
		sTestData="SDLDwithoutType_08";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		myNeedsDashboardPo=new MyNeedsDashboardPO(driver);
		try
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
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

	/* @TestCaseID: SDLDwithoutType_09
	 * @Description: Tap over SUBMIT button in Confirm and submit page when Additional info is passed as attribute value.
	 * @Author: Yashi Priya*/
	@Test(priority=9,enabled=true,description="Tap over SUBMIT button in Confirm and submit page when Additional info is passed as attribute value.")
	public void testSubmitWithAdditionalInfoAttribute()
	{
		sTestData="SDLDwithoutType_09";
		sData=GenericLib.toReadExcelData(sTestData);
		sNeed=sData[7];
		postneedPo=new PostNeedPO(driver);
		homePo=new HomePO(driver);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		myNeedsDashboardPo=new MyNeedsDashboardPO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			homePo.searchNeed(sNeed);
			postneedPo.toPostSdldWithoutType(homePo);
			postneedPo.getEleTellusMoreTxtFld().sendKeys(sData[8]);
			postneedPo.getEleNextBtn().click();
			postneedPo.getEleNextBtn().click();
			Assert.assertTrue(postneedPo.getEleSubmitRequestBtn().isDisplayed(), "User is not navigated to Confirm and submit page.");
			NXGReports.addStep("User is successfully navigated to Confirm and submit page.", LogAs.PASSED, null);
			postneedPo.getEleSubmitRequestBtn().click();
			//Assert.assertTrue(driver.findElement(By.xpath("//UIAStaticText[@name='Thank you']")).isDisplayed(), "Thank you screen is not displayed");
			//NXGReports.addStep("Thank you screen is displayed", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboardPo.getEleNeedsLstItm().getText().equals("Neurologists"), "User is not navigated to Needs List page with the newly posted need");
			NXGReports.addStep("User is successfully navigated to Needs List page with the newly posted need", LogAs.PASSED, null);
			Assert.assertTrue(myNeedsDashboardPo.getEleNeedNotiSMSTxt().isDisplayed(), "user is not redirected to Need list page with status Fetching matching experts for your requirement");
			NXGReports.addStep("user is successfully redirected to Need list page with status Fetching matching experts for your requirement", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}

/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Test scripts of Join Sulekha 
* @module			:		Join Sulekha
* @testmethod		:	   	testWithoutMobileNum()
* @testmethod		:	   	testInvalidMobileNum()
* @testmethod		:	   	testValidMobileNum()
* @testmethod		:	   	testReceivedOTP()
* @testmethod		:	   	testOTPTimeLimit()
* @testmethod		:	   	testResendCode()
* @testmethod		:	   	testOtpReceivedSms()
* @testmethod		:	   	testWOVerificationCode()
* @testmethod		:	   	testInvalidOtp()
* @testmethod		:	   	test6DigitVerificationCode()
* @testmethod		:	   	testTermsCondition()
* @testmethod		:	   	testEditIcon()
* @testmethod		:	   	testTnCBackBtn()
* @testmethod		:	   	testSkipLnk()
* @testmethod		:	   	testLoginLnk()
*/
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
import com.test.po.WelcomePO;

public class JoinSulekha extends BaseLib 
{
	String sTestData=null;
	String[] sData=null;
	WelcomePO welcomePo;
	HomePO homePo;
	LoginPO loginPo;

	/* @TestCaseID: Join Sulekha_01
	 * @Description: Tap over "join now" without entering mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="Tap over 'join now' without entering mobile number")
	public void testWithoutMobileNum()
	{
		sTestData="Join Sulekha_01";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleMobileAlertPopup().isDisplayed(), "An alert with message Enter your mobile number is not displayed");
			NXGReports.addStep("An alert with message Enter your mobile number is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_02
	 * @Description: Tap over "join now" by entering invalid mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="Tap over 'join now' by entering invalid mobile number")
	public void testInvalidMobileNum()
	{
		sTestData="Join Sulekha_02";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleInvalidMobileAlertPopup().isDisplayed(), "An alert with message Invalid mobile number, try again is not displayed");
			NXGReports.addStep("An alert with message Invalid mobile number, try again is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_03
	 * @Description: Tap over "join now" button by entering valid mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="Tap over 'join now' button by entering valid mobile number")
	public void testValidMobileNum()
	{
		sTestData="Join Sulekha_03";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPCodeTxtFld().isDisplayed(), "Verification OTP screen is not displayed");
			NXGReports.addStep("Verification OTP screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_04
	 * @Description: Check entering the received OTP
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="Check entering the received OTP")
	public void testReceivedOTP()
	{
		sTestData="Join Sulekha_04";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
			welcomePo.joinNow(sData[1],sData[2]);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home screen is not displayed");
			NXGReports.addStep("Home screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_05
	 * @Description: Checking OTP time limit
	 * @Author: Yashi Priya*/
	@Test(priority=5,enabled=true,description="Checking OTP time limit")
	public void testOTPTimeLimit() throws Exception
	{
		sTestData="Join Sulekha_05";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPTimeLimitTxt().isDisplayed(), "A time limit of 120 seconds is not displayed");
			NXGReports.addStep("A time limit of 120 seconds is successfully displayed", LogAs.PASSED, null);
			driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			Assert.assertTrue(welcomePo.getEleRESENDCODEBtn().isDisplayed(), "ResendCode button is not displayed after 120 seconds ");
			NXGReports.addStep("After 120 seconds, ResendCode button is successfully displayed.", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_06
	 * @Description: Tap on Resend code button displayed in OTP page after 120 seconds time up
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=true,description="Tap on Resend code button displayed in OTP page after 120 seconds time up")
	public void testResendCode() throws Exception
	{
		sTestData="Join Sulekha_06";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPTimeLimitTxt().isDisplayed(), "A time limit of 120 seconds is not displayed");
			NXGReports.addStep("A time limit of 120 seconds is successfully displayed", LogAs.PASSED, null);
			driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
			Assert.assertTrue(welcomePo.getEleRESENDCODEBtn().isDisplayed(), "ResendCode button is not displayed after 120 seconds ");
			NXGReports.addStep("ResendCode button is successfully displayed after 120 seconds ", LogAs.PASSED, null);
			welcomePo.getEleRESENDCODEBtn().click();
			Assert.assertTrue(welcomePo.getEleCodeViaSMSTxt().isDisplayed(), "New verification code is not received vis SMS.");
			NXGReports.addStep("New OTP is received successfully via sms", LogAs.PASSED, null);
			Assert.assertTrue(welcomePo.getEleOTPTimeLimitTxt().isDisplayed(), "A time limit of 120 seconds is not displayed");
			NXGReports.addStep("A time limit of 120 seconds is successfully displayed", LogAs.PASSED, null);		
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: Join Sulekha_07
	 * @Description:Check entering the OTP received through SMS
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=true,description="Check entering the OTP received through SMS")
	public void testOtpReceivedSms() throws Exception{
		sTestData="Join Sulekha_07";
		sData=GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			driver.manage().timeouts().implicitlyWait(125, TimeUnit.SECONDS);
			Assert.assertTrue(welcomePo.getEleRESENDCODEBtn().isDisplayed(), "ResendCode button is not displayed after 120 seconds ");
			NXGReports.addStep("ResendCode button is successfully displayed after 120 seconds", LogAs.PASSED, null);
			welcomePo.getEleRESENDCODEBtn().click();
			Assert.assertTrue(welcomePo.getEleCodeViaSMSTxt().isDisplayed(), "New verification code is not received vis SMS.");
			NXGReports.addStep("New OTP is received successfully via sms", LogAs.PASSED, null);
			welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home screen is not displayed");
			NXGReports.addStep("Home screen is successfully displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_08
	 * @Description: To tap on "Done" button without entering verification code
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=true,description=" To tap on 'Done' button without entering verification code")
	public void testWOVerificationCode()
	{
		sTestData="Join Sulekha_08";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPCodeTxtFld().isDisplayed(), "Mobile number verification page is not displayed");
			NXGReports.addStep("Mobile number verification page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOTPCodeTxtFld().click();
			welcomePo.getEleDoneBtn().click();
			Assert.assertTrue(welcomePo.getEleValidCodePopup().isDisplayed(), "An alert message to enter verification code is not displayed ");
			NXGReports.addStep("An alert message to enter valid verification code is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_09
	 * @Description: check entering invalid otp
	 * @Author: Yashi Priya*/
	@Test(priority=9,enabled=true,description="check entering invalid otp")
	public void testInvalidOtp(){
		sTestData="Join Sulekha_09";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try{	
			welcomePo.toHandleAlertPopup();
			welcomePo.joinNow(sData[1],sData[2]);
			Assert.assertTrue(welcomePo.getEleValidCodePopup().isDisplayed(),"An alert message enter valid verification code popup is not displayed");
			NXGReports.addStep("An alert message enter valid verification code popup is successfully displayed", LogAs.PASSED, null);	
			welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: Join Sulekha_10
	 * @Description:Check entering less than 6-digit verification code
	 * @Author: Yashi Priya*/
	@Test(priority=10,enabled=true,description="Check entering less than 6-digit verification code")
	public void test6DigitVerificationCode(){
		sTestData="Join Sulekha_10";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try{
			welcomePo.toHandleAlertPopup();
			welcomePo.joinNow(sData[1],sData[2]);
			welcomePo.getEleDoneBtn().click();
			Assert.assertTrue(welcomePo.getEle6DigitCodePopup().isDisplayed(),"An alert message enter 6-digit verification code  popup is not displayed");
			NXGReports.addStep("An alert message enter 6-digit verification code  popup is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOKBtn().click();

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: Join Sulekha_11
	 * @Description: To tap over "T & C" link in the join sulekha page
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=true,description="To tap over 'T & C' link in the join sulekha page")
	public void testTermsCondition()
	{
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleTermsCLnk().isDisplayed(),"T and C link is not displayed in join sulekha page");
			NXGReports.addStep("T and C link is successfully displayed in join sulekha page", LogAs.PASSED, null);
			welcomePo.getEleTermsCLnk().click();
			Assert.assertTrue(welcomePo.getEleTermsCTxt().isDisplayed(), "T & C screen is not displayed");
			NXGReports.addStep("T & C screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_12
	 * @Description: To tap over edit icon in the OTP page and verify if join sulekha page appears.
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=true,description="To tap over edit icon in the OTP page and verify if join sulekha page appears.")
	public void testEditIcon()
	{
		sTestData="Join Sulekha_12";
		sData= GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleMobileNoTxtFld().sendKeys(sData[1]);
			welcomePo.getEleJOINNOWBtn().click();
			Assert.assertTrue(welcomePo.getEleEditIcn().isDisplayed(), "Edit icon in otp page is not displayed");
			NXGReports.addStep("Edit icon in otp page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleEditIcn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_13
	 * @Description: Tap over Back button from Terms and conditions page.
	 * @Author: Yashi Priya*/
	@Test(priority=13,enabled=true,description="Tap over Back button from Terms and conditions page.")
	public void testTnCBackIcn()
	{
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleTermsCLnk().isDisplayed(),"T and C link is not displayed in join sulekha page");
			NXGReports.addStep("T and C link is successfully displayed in join sulekha page", LogAs.PASSED, null);
			welcomePo.getEleTermsCLnk().click();
			Assert.assertTrue(welcomePo.getEleTermsCTxt().isDisplayed(), "T & C screen is not displayed");
			NXGReports.addStep("T & C screen is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleBackArwIcn().click();
			Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Sulekha screen is not displayed");
			NXGReports.addStep("Join Sulekha screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_14
	 * @Description: To tap over "skip" link in join sulekha page and verify if home page is displayed
	 * @Author: Yashi Priya*/
	@Test(priority=14,enabled=true,description=" To tap over 'skip' link in join sulekha page and verify if home page is displayed")
	public void testSkipLnk() throws Exception
	{
		welcomePo=new WelcomePO(driver);
		homePo=new HomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleSkipLnk().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleSkipLnk().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home screen is not displayed");
			NXGReports.addStep("Home screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Join Sulekha_15 
	 * @Description: To tap over "login" link in the join sulekha page and verify if "login page is displayed
	 * @Author: Yashi Priya*/
	@Test(priority=15,enabled=true,description="To tap over 'login' link in the join sulekha page and verify if 'login page is displayed")
	public void testLoginLnk()
	{
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			welcomePo.getEleJOINSULEKHABtn().click();
			Assert.assertTrue(welcomePo.getEleLoginLnk().isDisplayed(),"Join sulekha page is not displayed");
			NXGReports.addStep("Join sulekha page is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleLoginLnk().click();
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login screen is not displayed");
			NXGReports.addStep("Login screen is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}

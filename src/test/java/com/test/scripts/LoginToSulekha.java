
/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Test scripts of Login
 * @module			:		Login
 * @testmethod		:	   	testLoginWOEmailIDMobileNum()
 * @testmethod		:	   	testLoginInvalideMobNum()
 * @testmethod		:	   	testLoginInvalideEmail()
 * @testmethod		:	   	testLoginUnRegEmail()
 * @testmethod		:	   	testLoginUnRegMob()
 * @testmethod		:	   	testUnRegMobJoinSulekha()
 * @testmethod		:	   	testUnRegEmailJoinSulekha()
 * @testmethod		:	   	testUnRegMobileCancel()
 * @testmethod		:	   	testUnregisteredEmailPopupCancelBtn()
 * @testmethod		:	   	testLoginWithMobileWithoutPwd()
 * @testmethod		:	   	testLoginWithEmailWithoutPwd()
 * @testmethod		:	   	testShowPwdLnk()
 * @testmethod		:	   	testHidePwdLnk()
 * @testmethod		:	   	testValidEmailInvalidPwd()
 * @testmethod		:	   	testValidMobileInvalidPwd()
 * @testmethod		:	   	testValidLoginViaEmailID()
 * @testmethod		:	   	testValidLoginViaValidMobileNum()
 * @testmethod		:	   	testForgtPwd()
 * @testmethod		:	   	testPwdViaSms()
 * @testmethod		:	   	testPwdViaEmail()
 * @testmethod		:	   	testGoogleLogin()
 * @testmethod		:	   	testUnRegGoogleLogin()
 * @testmethod		:	   	testValidMobAndName()
 * @testmethod		:	   	testWithoutEnteringMobileNumber()
 * @testmethod		:		testInvalidMobileNumber()
 * @testmethod		:		testWOEnteringEmail()
 * @testmethod		:		testInvalidEnteringEmail()
 * @testmethod		:		testWithoutName()
 * @testmethod		:		testInvalidOtp()
 * @testmethod		:		test6DigitVerificationCode()
 * @testmethod		:		testValidOtp()
 * @testmethod		:		testTandCApplyLnk()
 * @testmethod		:		testSkipLnk()
 */							
package com.test.scripts;

import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.touch.TouchActions;
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
import com.test.po.UpdateAccountPO;
import com.test.po.WelcomePO;

public class LoginToSulekha extends BaseLib {

	String sTestData=null;
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	LoginPO loginPo;
	WelcomePO welcomePo;
	HomePO homePo;
	UpdateAccountPO updateAccountPo;
	JavascriptExecutor js=null;
	HashMap<String, String> scrollObject=null;

	/* @TestCaseID: Login_01
	 * @Description: Tap over LOGIN button without entering any values in Email ID/Mobile number field and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=1,enabled=true,description="Tap over LOGIN button without entering any values in Email ID/Mobile number field and verify.")
	public void testLoginWOEmailIDMobileNum()
	{
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed");
		NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleEmailMobPopup().isDisplayed(), "Enter email / mobile number alert is not displayed");
		NXGReports.addStep("Enter email / mobile number alert is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_02
	 * @Description: To tap over "login" button by entering invalid mobileno
	 * @Author: Yashi Priya*/
	@Test(priority=2,enabled=true,description="To tap over 'login' button by entering invalid mobileno.")
	public void testLoginInvalideMobNum()
	{
		sTestData="Login_02";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed");
		NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleInValidMobNumPopup().isDisplayed(), "An alert popup saying Invalid mobile number, try again is not displayed");
		NXGReports.addStep("An alert 'Invalid mobile number, try again' is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_03
	 * @Description: To tap over "login" button by entering invalid emailid
	 * @Author: Yashi Priya*/
	@Test(priority=3,enabled=true,description="To tap over 'login' button by entering invalid emailid")
	public void testLoginInvalideEmail()
	{
		sTestData="Login_03";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed");
		NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[3]);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleValidEmailPopup().isDisplayed(), "An alert popup saying Enter valid email is not displayed");
		NXGReports.addStep("An alert saying 'Enter valid email' is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_04
	 * @Description: To tap over "login" button by entering unregistered email id
	 * @Author: Yashi Priya*/
	@Test(priority=4,enabled=true,description="To tap over 'login' button by entering unregistered email id")
	public void testLoginUnRegEmail()
	{
		sTestData="Login_04";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed");
		NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[3]);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleUnRegEmailPopup().isDisplayed(), "An alert popup saying The email id you have entered does not belong to any account is not displayed");
		NXGReports.addStep("An alert saying The email id you have entered does not belong to any account is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_05
	 * @Description: To tap over "login" button by entering unregistered mobile number
	 * @Author: Yashi Priya */
	@Test(priority=5,enabled=true,description="To tap over 'login' button by entering unregistered mobile number")
	public void testLoginUnRegMob()
	{	
		sTestData="Login_05";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
		loginPo.getElePwddTxtFld().click();
		Assert.assertTrue(loginPo.getEleUnRegMobPopup().isDisplayed(), "An alert popup saying Something went worng message is not displayed");
		NXGReports.addStep("An alert popup saying Something went worng message is successfully displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleUnRegMobnumPopup().isDisplayed(),"An alert popup saying The mobile number you just entered does not belong to Sulekha's account is not displayed");
		NXGReports.addStep("An alert popup saying The mobile number you just entered does not belong to Sulekha's account is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_06
	 * @Description: Tap over Join Sulekha button displayed on the alert for unregistered mobile number.
	 * @Author: Yashi Priya*/
	@Test(priority=6,enabled=true,description="Tap over Join Sulekha button displayed on the alert for unregistered mobile number.")
	public void testUnRegMobJoinSulekha()
	{	
		sTestData="Login_06";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
		loginPo.getElePwddTxtFld().click();
		Assert.assertTrue(loginPo.getEleUnRegMobPopup().isDisplayed(),"An alert popup saying The mobile number you just entered does not belong to Sulekha's account is not displayed");
		NXGReports.addStep("An alert popup saying The mobile number you just entered does not belong to Sulekha's account is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleJoinSulekhaBtn().click();
		Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Now Sulekha page is not displayed");
		NXGReports.addStep("Join Now Sulekha page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_07
	 * @Description: Tap over Join Sulekha button displayed on the alert for unregistered emailID.
	 * @Author: Yashi Priya*/
	@Test(priority=7,enabled=true,description="Tap over Join Sulekha button displayed on the alert for unregistered emailID.")
	public void testUnRegEmailJoinSulekha()
	{	
		sTestData="Login_07";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[3]);
		loginPo.getElePwddTxtFld().click();
		Assert.assertTrue(loginPo.getEleUnRegEmailPopup().isDisplayed(), "An alert popup saying The email id you have entered does not belong to any account is not displayed");
		NXGReports.addStep("An alert saying The email id you have entered does not belong to any account is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleJoinSulekhaBtn().click();
		Assert.assertTrue(welcomePo.getEleJOINNOWBtn().isDisplayed(), "Join Sulekha page is not displayed");
		NXGReports.addStep("Join Sulekha page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_08
	 * @Description: Tap over Cancel button displayed on the alert for unregistered mobile number.
	 * @Author: Yashi Priya*/
	@Test(priority=8,enabled=true,description="Tap over Cancel button displayed on the alert for unregistered mobile number.")
	public void testUnRegMobileCancel()
	{
		sTestData="Login_08";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
		loginPo.getElePwddTxtFld().click();
		Assert.assertTrue(loginPo.getEleUnRegMobPopup().isDisplayed(),"An alert popup saying The mobile number you just entered does not belong to Sulekha's account is not displayed");
		NXGReports.addStep("An alert popup saying The mobile number you just entered does not belong to Sulekha's account is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleCancelBtn().click();
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed when cancelled");
		NXGReports.addStep("Login page is successfully displayed when cancelled", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_09
	 * @Description: Tap over Cancel button displayed on the alert for unregistered EmailID.
	 * @Author: Yashi Priya*/
	@Test(priority=9,enabled=true,description="Tap over Cancel button displayed on the alert for unregistered EmailID.")
	public void testUnregisteredEmailPopupCancelBtn()
	{
		sTestData="Login_09";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[3]);
		loginPo.getElePwddTxtFld().click();
		Assert.assertTrue(loginPo.getEleUnRegEmailPopup().isDisplayed(), "An alert popup saying The email id you have entered does not belong to any account is not displayed");
		NXGReports.addStep("An alert saying The email id you have entered does not belong to any account is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleCancelBtn().click();
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(), "Login page is not displayed when cancelled");
		NXGReports.addStep("Login page is successfully displayed when cancelled", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_10
	 * @Description: To tap over "login" button by entering registered mobileno and no password
	 * @Author: Yashi Priya*/
	@Test(priority=10,enabled=true,description="To tap over 'login' button by entering registered mobileno and no password")
	public void testLoginWithMobileWithoutPwd()
	{
		sTestData="Login_10";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleEnterPwdPopup().isDisplayed(), "An alert popup saying Enter your Password is not displayed");
		NXGReports.addStep("An alert popup saying Enter your Password is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_11
	 * @Description: To tap over "login" button by entering registered emailid and no password
	 * @Author: Yashi Priya*/
	@Test(priority=11,enabled=true,description="To tap over 'login' button by entering registered emailid and no password")
	public void testLoginWithEmailWithoutPwd()
	{
		sTestData="Login_11";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[3]);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleEnterPwdPopup().isDisplayed(), "An alert popup saying Enter your Password is not displayed");
		NXGReports.addStep("An alert popup saying Enter your Password is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_12
	 * @Description: To tap over "Show" link of password field in login page
	 * @Author: Yashi Priya*/
	@Test(priority=12,enabled=true,description="To tap over 'Show' link of password field in login page")
	public void testShowPwdLnk()
	{
		sTestData="Login_12";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getElePwddTxtFld().sendKeys(sData[4]);
		Assert.assertTrue(loginPo.getEleSHOWLnk().isDisplayed(), "Show Link is not displayed");
		NXGReports.addStep("Show Link is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleSHOWLnk().click();
		Assert.assertTrue(loginPo.getEleHIDELnk().isDisplayed(), "Hide Link is not displayed");
		NXGReports.addStep("Hide Link is successfully displayed and the password entered is readable and not encrypted", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_13
	 * @Description: To tap over "Hide" link of password field in login page
	 * @Author: Yashi Priya*/
	@Test(priority=13,enabled=true,description="To tap over 'Hide' link of password field in login page")
	public void testHidePwdLnk()
	{
		sTestData="Login_13";
		sData=GenericLib.toReadExcelData(sTestData);
		welcomePo=new WelcomePO(driver);
		loginPo=new LoginPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getElePwddTxtFld().sendKeys(sData[4]);
		loginPo.getEleSHOWLnk().click();
		Assert.assertTrue(loginPo.getEleHIDELnk().isDisplayed(), "Hide Link is not displayed");
		NXGReports.addStep("Hide Link is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleHIDELnk().click();
		Assert.assertTrue(loginPo.getEleSHOWLnk().isDisplayed(), "Show Link is not displayed");
		NXGReports.addStep("Show Link is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_14
	 * @Description: To Tap over LOGIN and enter valid Email ID and invalid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=14,enabled=true,description="To Tap over LOGIN and enter valid Email ID and invalid Password and verify.")
	public void testValidEmailInvalidPwd()
	{
		sTestData="Login_14";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(),"Login page is not displayed");
		NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[3]);
		loginPo.getElePwddTxtFld().sendKeys(sData[4]);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleIncorrectPwdPopup().isDisplayed(), "An alert popup saying Incorrect password is not displayed");
		NXGReports.addStep("An alert popup saying Incorrect password is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_15
	 * @Description: To Tap over LOGIN and enter valid Mobile number and invalid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=15,enabled=true,description="To Tap over LOGIN and enter valid Mobile number and invalid Password and verify.")
	public void testValidMobileInvalidPwd()
	{
		sTestData="Login_15";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(),"Login page is not displayed");
		NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleEmailmobTxtFld().sendKeys(sData[1]);
		loginPo.getElePwddTxtFld().sendKeys(sData[4]);
		loginPo.getEleLoginBtn().click();
		Assert.assertTrue(loginPo.getEleIncorrectPwdPopup().isDisplayed(), "An alert popup saying Incorrect password is not displayed");
		NXGReports.addStep("An alert popup saying Incorrect password is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_16
	 * @Description: To Tap over LOGIN and enter valid Email ID and valid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=16,enabled=true,description="To Tap over LOGIN and enter valid Email ID and valid Password and verify.")
	public void testValidLoginViaEmailID()
	{
		sTestData="Login_16";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			Assert.assertTrue(loginPo.getEleLoginBtn().isDisplayed(),"Login page is not displayed");
			NXGReports.addStep("Login page is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleEmailmobTxtFld().sendKeys(sData[3]);
			loginPo.getElePwddTxtFld().sendKeys(sData[4]);
			loginPo.getEleLoginBtn().click();
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_17
	 * @Description: To Tap over LOGIN and enter valid Mobile number and valid Password and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=17,enabled=true,description="To Tap over LOGIN and enter valid Mobile number and valid Password and verify.")
	public void testValidLoginViaValidMobileNum()
	{
		sTestData="Login_17";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.login(sData, homePo);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_18
	 * @Description: To tap over "forgot password" link in Login page.
	 * @Author: Yashi Priya*/
	@Test(priority=18,enabled=true,description="To tap over 'forgot password' link in Login page.")
	public void testForgtPwd()
	{
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleForgotPwdLnk().isDisplayed(), "Forgot password link is not displayed in login page");
		NXGReports.addStep("Forgot password link is successfully displayed in login page", LogAs.PASSED, null);
		loginPo.getEleForgotPwdLnk().click();
		Assert.assertTrue(loginPo.getEleForgotPwdTxt().isDisplayed(), "Forgot password page is not displayed");
		NXGReports.addStep("Forgot password page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_19
	 * @Description: To enter a valid mobile number in Via SMS in Forgot password? Page and tap on Send button
	 * @Author: Yashi Priya*/
	@Test(priority=19,enabled=true,description="To enter a valid mobile number in Via SMS in Forgot password? Page and tap on Send button")
	public void testPwdViaSms()
	{
		sTestData="Login_19";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleForgotPwdLnk().click();
		Assert.assertTrue(loginPo.getEleForgotPwdTxt().isDisplayed(), "Forgot password page is not displayed");
		NXGReports.addStep("Forgot password page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleViaSMSOpt().click();
		Assert.assertTrue(loginPo.getEleEnterMobTxtFld().isDisplayed(), "Mobile number text Field in forgot Password page is not displayed");
		NXGReports.addStep("Mobile number text Field in forgot Password page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleEnterMobTxtFld().sendKeys(sData[1]);
		loginPo.getEleSendBtn().click();
		Assert.assertTrue(loginPo.getEleWeSentPwdPopup().isDisplayed(), "we've sent password to mobile number alert is not displayed");
		NXGReports.addStep("we've sent password to mobile number alert is displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: Login_20
	 * @Description: To enter a valid Email ID in Via email in Forgot password? Page and tap on Send button
	 * @Author: Yashi Priya*/
	@Test(priority=20,enabled=true,description="To enter a valid Email ID in Via email in Forgot password? Page and tap on Send button")
	public void testPwdViaEmail()
	{
		sTestData="Login_20";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		loginPo.getEleForgotPwdLnk().click();
		Assert.assertTrue(loginPo.getEleForgotPwdTxt().isDisplayed(), "Forgot password page is not displayed");
		NXGReports.addStep("Forgot password page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleViaEmailOpt().click();
		Assert.assertTrue(loginPo.getEleEnterEmailTxtFld().isDisplayed(), "Email Id text Feild in forgot Password page is not displayed");
		NXGReports.addStep("Email Id text Feild in forgot Password page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleEnterEmailTxtFld().sendKeys(sData[3]);
		loginPo.getEleSendBtn().click();
		Assert.assertTrue(loginPo.getEleWeSentPwdtoMailPopup().isDisplayed(), "we've mailed your password to email alert is not displayed");
		NXGReports.addStep("we've mailed your password to email alert is displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


	/* @TestCaseID: login_21
	 * @Descripyion: To login through google+
	 * @Author: Yashi Priya*/
	@Test(priority=21,enabled=true,description="To login through google+")
	public void testGoogleLogin() throws Exception
	{
		sTestData="Login_22";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login link is not displayed");
			NXGReports.addStep("Google+ login link is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleGoogleLoginLnk().click();
			Thread.sleep(5000);
			//Switching from app to webview
			Set<String> contextHandles=driver.getContextHandles();
			for(String contextHandle:contextHandles){
				if(contextHandle.contains("WEBVIEW")){
					driver.context(contextHandle);
				}
			}
			Assert.assertTrue(loginPo.getEleGoogleEmailTxtFld().isDisplayed(),"Google login screen is not displayed");
			NXGReports.addStep("Google login screen is successfully displayed", LogAs.PASSED, null);
			loginPo.getEleGoogleEmailTxtFld().sendKeys(sData[3]);
			loginPo.getEleGoogleNextBtn().click();
			loginPo.getEleGooglePwdTxtFld().sendKeys(sData[4]);
			loginPo.getEleGoogleSignInBtn().click();
			Thread.sleep(10000);
			driver.context("NATIVE_APP");
			driver.tap(1, 218,434,1);
			Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
			NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);

			//Clean up code
			homePo.getEleMoreIcn().click();
			updateAccountPo.getEleLogoutBtn().click();
			updateAccountPo.getEleLoginBtn().click();
			welcomePo.getEleLoginLnk().click();
			loginPo.getEleGoogleLoginLnk().click();
			Thread.sleep(10000);
			driver.tap(1,182,79,1);
			driver.tap(1,182,79,1);
			Thread.sleep(10000);
			driver.tap(1,207,278,1);
			Thread.sleep(5000);
			//Switching from webview to native app
			Set<String> contextHandles1=driver.getContextHandles();
			for(String contextHandle1:contextHandles1){
				if(contextHandle1.contains("WEBVIEW")){
					driver.context(contextHandle1);
				}
			}
			loginPo.getEleGmailSignLink().click();
			Thread.sleep(10000);
			loginPo.getEleGmailRemoveBtn().click();
			loginPo.getEleGmailAccountBtn().click();
			loginPo.getEleGmailRemoveBtn().click();
			Thread.sleep(1000);

		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: login_22
	 * @Descripyion: Check the Create Account page for unregistered user when logged in through Facebook or G+
	 * @Author: Yashi Priya*/
	@Test(priority=22,enabled=true,description="Check the Create Account page for unregistered user when logged in through Facebook or G+")
	public void testUnRegGoogleLogin() throws Exception
	{
		sTestData="Login_24";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login link is not displayed");
		NXGReports.addStep("Google+ login link is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();

		Thread.sleep(5000);
		Set<String> contextHandles=driver.getContextHandles();
		for(String contextHandle:contextHandles){
			if(contextHandle.contains("WEBVIEW")){
				driver.context(contextHandle);
			}
		}
		Assert.assertTrue(loginPo.getEleGoogleEmailTxtFld().isDisplayed(), "Google+ login page is not displayed");
		NXGReports.addStep("Google+ login page is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleEmailTxtFld().sendKeys(sData[3]);
		loginPo.getEleGoogleNextBtn().click();
		Assert.assertTrue(loginPo.getEleGooglePwdTxtFld().isDisplayed(), "Password text field is not displayed");
		NXGReports.addStep("Password text field is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGooglePwdTxtFld().sendKeys(sData[4]);
		Assert.assertTrue(loginPo.getEleGoogleSignInBtn().isDisplayed(),"Google signin button is successfully displayed");
		NXGReports.addStep("Google signin button is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleSignInBtn().click();
		Thread.sleep(10000);
		driver.context("NATIVE_APP");
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleEmailTxt().isDisplayed(), "Email text field is not displayed");
		NXGReports.addStep("Email text field is successfully displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
		NXGReports.addStep("mobile number text field is successfully dispalyed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: login_23
	 * @Descripyion:Enter a valid mobile number and email id in create account page and tap on Create button
	 * @Author: Yashi Priya*/
	@Test(priority=23,enabled=true,description="Enter a valid mobile number and email id in create account page and tap on Create button")
	public void testValidMobAndName() throws Exception
	{
		sTestData="Login_25";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login link is not displayed");
		NXGReports.addStep("Google+ login link is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(20000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page is not displayed");
		NXGReports.addStep("Create account page is successfully displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
		NXGReports.addStep("mobile number text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleMobileNumTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(welcomePo.getEleCodeViaSMSTxt().isDisplayed(), "New verification code is not received vis SMS.");
		NXGReports.addStep("New OTP is received successfully via sms", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
		NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}

	}


	/* @TestCaseID: login_24
	 * @Descripyion:Tap over Create button without entering Mobile number
	 * @Author: Yashi Priya*/
	@Test(priority=24,enabled=true,description="Tap over Create button without entering Mobile number")
	public void testWithoutEnteringMobileNumber() throws Exception
	{
		sTestData="Login_28";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEle10DigitNumberPopUp().isDisplayed(),"An alert with message 'Enter valid mobile number' should not displayed");
		NXGReports.addStep("An alert with message 'Enter valid mobile number' should be displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: login_25
	 * @Descripyion:Enter invalid Mobile number and tap over Create button.
	 * @Author: Yashi Priya*/
	@Test(priority=25,enabled=true,description="Enter invalid Mobile number and tap over Create button.")
	public void testInvalidMobileNumber() throws Exception
	{
		sTestData="Login_31";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleMobileNumTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEleInvalidMobilePopup().isDisplayed(),"An alert with message 'Invalid mobile number, try again' should not displayed");
		NXGReports.addStep("An alert with message 'Invalid mobile number, try again' should be displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: login_26
	 * @Descripyion:Tap over Create button without entering Email ID
	 * @Author: Yashi Priya*/
	@Test(priority=26,enabled=true,description="Tap over Create button without entering Email ID")
	public void testWOEnteringEmail() throws Exception
	{
		sTestData="Login_28";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleEmailTxt().clear();
		loginPo.getEleMobileNumTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEleEnterValidEmailPopup().isDisplayed(),"An alert with message 'Enter valid email' should not displayed");
		NXGReports.addStep("An alert with message 'Enter valid email' should be displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: login_27
	 * @Descripyion:Enter invalid Email ID and tap over Create button.
	 * @Author: Yashi Priya*/
	@Test(priority=27,enabled=true,description="Enter invalid Email ID and tap over Create button.")
	public void testInvalidEnteringEmail() throws Exception
	{
		sTestData="Login_33";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleEmailTxt().clear();
		loginPo.getEleEnterEmailTxtFld1().sendKeys(sData[3]);
		loginPo.getEleMobileNumTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEleEnterValidEmailPopup().isDisplayed(),"An alert with message 'Enter valid email' should not displayed");
		NXGReports.addStep("An alert with message 'Enter valid email' should be displayed", LogAs.PASSED, null);
		}catch(Exception e){
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;

		}
	}
	/* @TestCaseID: login_28
	 * @Descripyion:Tap over Create button without entering Name.
	 * @Author: Yashi Priya*/
	@Test(priority=28,enabled=true,description="Tap over Create button without entering Name.")
	public void testWithoutName() throws Exception
	{
		sTestData="Login_28";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should is successfully displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEleNamePopup().isDisplayed(),"An alert with message 'Enter your name' should not displayed");
		NXGReports.addStep("An alert with message 'Enter your name' should be displayed", LogAs.PASSED, null);
		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: login_29
	 * @Descripyion:Check entering invalid OTP 
	 * @Author: Yashi Priya*/
	@Test(priority=29,enabled=true,description="Check entering invalid OTP")
	public void testInvalidOtp() throws Exception
	{
		sTestData="Login_26";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
		NXGReports.addStep("mobile number text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleMobileNumTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
		NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
		welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
		Assert.assertTrue(loginPo.getEleCorrectOtpPopup().isDisplayed(),"An alert message enter valid verification code popup is not displayed");
		NXGReports.addStep("An alert message enter valid verification code popup is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleOKBtn().click();

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}



	}
	/* @TestCaseID: login_30
	 * @Descripyion:Check entering less than 6-digit verification code
	 * @Author: Yashi Priya*/
	@Test(priority=30,enabled=true,description="Check entering less than 6-digit verification code")
	public void test6DigitVerificationCode() throws Exception
	{
		sTestData="Login_27";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
		loginPo.getEleMobileNumTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
		NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
		welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
		welcomePo.getEleDoneBtn().click();
		Assert.assertTrue(welcomePo.getEle6DigitCodePopup().isDisplayed(),"An alert message enter 6-digit verification code  popup is not displayed");
		NXGReports.addStep("An alert message enter 6-digit verification code  popup is successfully displayed", LogAs.PASSED, null);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: login_31
	 * @Descripyion:Enter valid OTP 
	 * @Author: Yashi Priya*/
	@Test(priority=31,enabled=true,description="Enter valid OTP")
	public void testValidOtp() throws Exception
	{
		sTestData="Login_28";
		sData=GenericLib.toReadExcelData(sTestData);
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(loginPo.getEleGoogleLoginLnk().isDisplayed(),"Google+ login is not displayed");
		NXGReports.addStep("Google+ login is successfully displayed", LogAs.PASSED, null);
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1, 218,434,1);
		Thread.sleep(2000);
		Assert.assertTrue(loginPo.getEleCreateAccountTxt().isDisplayed(),"Create account page should not displayed");
		NXGReports.addStep("Create account page should be displayed", LogAs.PASSED, null);
		Assert.assertTrue(loginPo.getEleNameTxtFld().isDisplayed(),"Name text field is not dispalyed");
		NXGReports.addStep("Name text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleNameTxtFld().sendKeys(sData[5]);
		homePo.getEleKeyboardReturnBtn().click();
		Assert.assertTrue(loginPo.getEleMobileNumTxtFld().isDisplayed(),"mobile number text field is not dispalyed");
		NXGReports.addStep("mobile number text field is successfully dispalyed", LogAs.PASSED, null);
		loginPo.getEleMobileNumTxtFld().sendKeys(sData[1]);
		homePo.getEleKeyboardReturnBtn().click();
		loginPo.getEleCreateBtn().click();
		Assert.assertTrue(loginPo.getEleOtpTxt().isDisplayed(),"User should not navigated to OTP page and OTP should be received via SMS to the entered mobile number.");
		NXGReports.addStep("User should be navigated to OTP page and OTP should be received via SMS to the entered mobile number.", LogAs.PASSED, null);
		welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
		Thread.sleep(10000);
		Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
		NXGReports.addStep("Home page is successfully displayed", LogAs.PASSED, null);

		//clean up code
		homePo.getEleMoreIcn().click();
		updateAccountPo.getEleLogoutBtn().click();
		updateAccountPo.getEleLoginBtn().click();
		welcomePo.getEleLoginLnk().click();
		loginPo.getEleGoogleLoginLnk().click();
		Thread.sleep(10000);
		driver.tap(1,182,79,1);
		driver.tap(1,182,79,1);
		Thread.sleep(10000);
		driver.tap(1,207,278,1);
		Thread.sleep(50000);
		Set<String> contextHandles1=driver.getContextHandles();
		for(String contextHandle1:contextHandles1){
			if(contextHandle1.contains("WEBVIEW")){
				driver.context(contextHandle1);
			}
		}
		loginPo.getEleGmailSignLink().click();
		Thread.sleep(1000);
		loginPo.getEleGmailRemoveBtn().click();
		loginPo.getEleGmailAccountBtn().click();
		loginPo.getEleGmailRemoveBtn().click();
		Thread.sleep(2000);

		}catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}
	/* @TestCaseID: login_32
	 * @Descripyion: Tap over T&C apply link and verify.-- Bug T&C link is disabled.
	 * @Author: Yashi Priya*/
	@Test(priority=32,enabled=true,description="Tap over T&C apply link and verify.-- Bug T&C link is disabled.")
	public void testTandCApplyLnk()
	{
		loginPo=new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(welcomePo.getEleTermsCLnk().isDisplayed(), "Terms and Condition link is not displayed");
		NXGReports.addStep("Terms and condition link is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleTermsCLnk().click();
		Assert.assertTrue(welcomePo.getEleTermsCTxt().isDisplayed(), "Sulekha Terms and conditions page is not displayed");
		NXGReports.addStep("Sulekha Terms and conditions page is successfully displayed", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/* @TestCaseID: login_33
	 * @Descripyion: Tap over SKIP link and verify.
	 * @Author: Yashi Priya*/
	@Test(priority=33,enabled=true,description="Tap over SKIP link and verify.")
	public void testSkipLnk()
	{
		loginPo=new LoginPO(driver);
		homePo=new HomePO(driver);
		welcomePo=new WelcomePO(driver);
		try
		{	welcomePo.toHandleAlertPopup();
		loginPo.navigateToLogin(welcomePo);
		Assert.assertTrue(welcomePo.getEleSkipBtn().isDisplayed(), "Skip is not displayed");
		NXGReports.addStep("Skip button is successfully displayed", LogAs.PASSED, null);
		welcomePo.getEleSkipBtn().click();
		Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "User is not navigated to Home page");
		NXGReports.addStep("User be navigated to Home page", LogAs.PASSED, null);
		}
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}


}

package com.test.scripts;

import java.util.concurrent.TimeUnit;

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
import com.test.po.PostNeedPO;
import com.test.po.UpdateAccountPO;
import com.test.po.WelcomePO;

public class UpdateAccount extends BaseLib {
	String sTestData;
	String[] sData = null;
	WelcomePO welcomePo = null;
	LoginPO loginPo = null;
	HomePO homePo = null;
	UpdateAccountPO updateAccountPo = null;

	/*
	 * @TestCaseID: UpdateAccount_01
	 * @Description: Check the Update my account page.
	 * @Author: Shreyas M S
	 */
	@Test(priority=1, enabled=true,description="Check the Update my account page")
	public void testUpdateMyAccountPage() {
		sTestData = "UpdateAccount_02";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try {
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "Home screen with more tab is not displayed");
			NXGReports.addStep("Home screen More tab is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.navigateToUpdateAcc(homePo);
			Assert.assertTrue(updateAccountPo.getEleAccountSettingsTxt().isDisplayed(), "Account seetings text is not displayed");
			NXGReports.addStep("Account seetings text is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleUpdateAccEmailTxt().isDisplayed(),"Email id is not displayed");
			NXGReports.addStep("Email id is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleChangePwdBtn().isDisplayed(),"Change password button is not displayed");
			NXGReports.addStep("Change password button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo. getEleUserNameTxt().isDisplayed(),"Username text is not displayed");
			NXGReports.addStep("Change password button is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleMobileTxt().isDisplayed(),"Mobile text is not displayed");
			NXGReports.addStep("Mobile text is successfully displayed", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}

	}
	/*
	 * @TestCaseID: UpdateAccount_02
	 * @Description: Tap on Change Password button displayed in Update my account page
	 * @Author: Shreyas M S
	 */
	@Test(priority=2, enabled=true,description="Tap on Change Password button displayed in Update my account page")
	public void testChangePwdScreen() {
		sTestData = "UpdateAccount_02";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			updateAccountPo.navigateToUpdateAcc(homePo);
			Assert.assertTrue(updateAccountPo.getEleChangePwdBtn().isDisplayed(),"Change password button is not displayed");
			NXGReports.addStep("Change password button is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleChangePwdBtn().click();
			Assert.assertTrue(updateAccountPo.getEleChangePwdTxt().isDisplayed(), "Change password popup is not displayed");
			NXGReports.addStep("Change password popup is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleCurrentPwdFld().isDisplayed(), "Current password field is not displayed");
			NXGReports.addStep("Current password field is Successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getElenewPwdFld().isDisplayed(),"New password field is not displayed");
			NXGReports.addStep("New password field is successfully displayed", LogAs.PASSED, null);
			Assert.assertTrue(updateAccountPo.getEleRetypenewPwdFld().isDisplayed(),"Retype new password field is not displayed");
			NXGReports.addStep("Retype new password field  is successfully displayed", LogAs.PASSED, null);
			//Assert.assertTrue(, message);
			Assert.assertTrue(updateAccountPo.getEleCancelBtn().isDisplayed(), "Cancel button is not displayed");
			NXGReports.addStep("Cancel button is successfully displayed", LogAs.PASSED, null);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/*
	 * @TestCaseID: UpdateAccount_03
	 * @Description: Enter the valid values for Change password and tap on the button
	 * @Author: Shreyas M S
	 */
	@Test(priority=3, enabled=true,description="Enter the valid values for Change password and tap on the button")
	public void testChangingPwd() throws Exception {
		sTestData = "UpdateAccount_04";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try {
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			updateAccountPo.navigateToUpdateAcc(homePo);
			Assert.assertTrue(updateAccountPo.getEleChangePwdBtn().isDisplayed(),"Change password button is not displayed");
			NXGReports.addStep("Change password button is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleChangePwdBtn().click();
			updateAccountPo.getEleCurrentPwdFld().sendKeys(sData[4]);
			updateAccountPo.getElenewPwdFld().sendKeys(sData[11]);
			updateAccountPo.getEleRetypenewPwdFld().sendKeys(sData[11]);
			homePo.getEleKeyboardReturnBtn().click();
			Thread.sleep(1000);
			driver.tap(1, 20,371,2000);
			Assert.assertTrue(updateAccountPo.getEleChangePwdBtn().isDisplayed(), "Password is not changed");
			NXGReports.addStep("Password is  changed", LogAs.PASSED, null);
			//cLeanup code
			updateAccountPo.getEleChangePwdBtn().click();
			updateAccountPo.getEleCurrentPwdFld().sendKeys(sData[11]);
			updateAccountPo.getElenewPwdFld().sendKeys(sData[4]);
			updateAccountPo.getEleRetypenewPwdFld().sendKeys(sData[4]);
			homePo.getEleKeyboardReturnBtn().click();
			Thread.sleep(1000);
			driver.tap(1, 20,371,2000);
			Thread.sleep(2000);
		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/*
	 * @TestCaseID: UpdateAccount_04    
	 * @Description: Change the mobile number and tap on Save profile button
	 * @Author: Shreyas M S
	 */
	@Test(priority=4, enabled=true,description=" Change the mobile number and tap on Save profile button")
	public void testChangeMobNum() throws Exception {
		sTestData = "UpdateAccount_03";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		welcomePo=new WelcomePO(driver);
		try {
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			updateAccountPo.navigateToUpdateAcc(homePo);
			driver.findElement(By.id(sData[1])).clear();
			updateAccountPo.getEleMobileNmuberFld().sendKeys(sData[12]);
			Assert.assertTrue(updateAccountPo.getEleSaveProfileBtn().isDisplayed(), "Save profile button is not displayed");
			NXGReports.addStep("Save profile button is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleSaveProfileBtn().click();
			Assert.assertTrue(welcomePo.getEleOTPCodeTxtFld().isDisplayed(),"Verification code text field is not displayed");
			NXGReports.addStep("Verification code text field is successfully displayed", LogAs.PASSED, null);
			welcomePo.getEleOTPCodeTxtFld().sendKeys(sData[2]);
			Assert.assertTrue(updateAccountPo.getEleMobileTxt().getText().equals(sData[12]), "Mobile number is not update");
			NXGReports.addStep("Mobile number is successfully update", LogAs.PASSED, null);
			//cleanup code
			driver.findElement(By.id(sData[12])).clear();
			updateAccountPo.getEleMobileNmuberFld().sendKeys(sData[1]);
			updateAccountPo.getEleSaveProfileBtn().click();
			Thread.sleep(2000);
		} catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/*
	 * @TestCaseID: UpdateAccount_05
	 * @Description: Change the name and tap on Save profile button
	 * @Author: Shreyas M S
	 */
	@Test(priority=5, enabled=true,description="Change the name and tap on Save profile button")
	public void testChangeUsername() {
		sTestData = "UpdateAccount_03";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		welcomePo=new WelcomePO(driver);
		try {
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			updateAccountPo.navigateToUpdateAcc(homePo);
			driver.findElement(By.id(sData[5])).clear();
			updateAccountPo.getEleNameFld().sendKeys(sData[13]);
			Assert.assertTrue(updateAccountPo.getEleSaveProfileBtn().isDisplayed(),"Save profile button is not displayed");
			NXGReports.addStep("Save profile button is successfully displayed", LogAs.PASSED, null);
			updateAccountPo.getEleSaveProfileBtn().click();
			updateAccountPo.getEleUpdatemyaccBtn().click();
			Assert.assertTrue(updateAccountPo. getEleUserNameTxt().getText().equals(sData[13]), "Name of the user is not updated");
			NXGReports.addStep("Name of the user is successfully updated", LogAs.PASSED, null);
			//clean up code
			driver.findElement(By.id(sData[13])).clear();
			driver.findElement(By.id("Name")).sendKeys(sData[5]);	
			updateAccountPo.getEleSaveProfileBtn().click();
		} catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

	/*
	 * @TestCaseID: Logout_01
	 * @Description: In left menu, tap on Log out
	 * @Author: Shreyas M S
	 */
	@Test(priority=6, enabled=true,description="In left menu, tap on Log out")
	public void testLogout() {
		sTestData = "UpdateAccount_03";
		sData = GenericLib.toReadExcelData(sTestData);
		homePo = new HomePO(driver);
		loginPo = new LoginPO(driver);
		welcomePo=new WelcomePO(driver);
		updateAccountPo = new UpdateAccountPO(driver);
		try 
		{
			welcomePo.toHandleAlertPopup();
			loginPo.navigateToLogin(welcomePo);
			loginPo.login(sData, homePo);
			Assert.assertTrue(homePo.getEleMoreIcn().isDisplayed(), "More icon is not displayed");
			NXGReports.addStep("More icon  is successfully displayed", LogAs.PASSED, null);
			homePo.getEleMoreIcn().click();
			Assert.assertTrue(updateAccountPo.getEleLogoutBtn().isDisplayed(), "Logout button is not displayed in More screen");
			NXGReports.addStep("Logout button is successfully displayed in More screen", LogAs.PASSED, null);
			updateAccountPo.getEleLogoutBtn().click();
			Assert.assertTrue(updateAccountPo.getEleLoginBtn().isDisplayed(), "Login screen is not displayed.");
			NXGReports.addStep("Login screen is successfully displayed", LogAs.PASSED, null);

		} 
		catch(Exception e)
		{	
			NXGReports.addStep("Failed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			throw e;
		}
	}

}

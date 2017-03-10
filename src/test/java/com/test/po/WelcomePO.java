package com.test.po;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePO{
	public Logger log = Logger.getLogger(this.getClass());
	IOSDriver driver=null;
	public WelcomePO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//UIAButton[@name='JOIN SULEKHA']")
	private WebElement eleJOINSULEKHABtn;
	public WebElement getEleJOINSULEKHABtn()
	{
		return eleJOINSULEKHABtn;
	}
	@FindBy(xpath="//*[@name='abc btn radio to on mtrl 000']")
	private WebElement eleFormPopupRadioBtn;
	public WebElement getEleFormPopupRadioBtn()
	{
	return eleFormPopupRadioBtn;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleMatchedBusiTxt;
	public WebElement getEleMatchedBusiTxt()
	{
	return eleMatchedBusiTxt;
	}
	


	@FindBy(xpath="//UIAStaticText[@name='Enter 6-digit verification code']")
	private WebElement ele6DigitCodePopup;
	public WebElement getEle6DigitCodePopup(){
		return ele6DigitCodePopup;
	}
	
	
	@FindBy(xpath="//UIAStaticText[@name='Enter a valid verification code']")
	private WebElement eleValidCodePopup;
	public WebElement getEleValidCodePopup()
	{
		return eleValidCodePopup;
	}
	
	
	
	@FindBy(id="You'll receive the verification code via SMS")
	private WebElement eleCodeViaSMSTxt;
	public WebElement getEleCodeViaSMSTxt()
	{
		return eleCodeViaSMSTxt;
	}
	@FindBy(xpath="//UIAStaticText[@name='Enter your mobile number.']")
	private WebElement eleMobileAlertPopup;
	public WebElement getEleMobileAlertPopup()
	{
		return eleMobileAlertPopup;
	}
	@FindBy(xpath="//UIAButton[@name='Done']")
	private WebElement eleDoneBtn;
	public WebElement getEleDoneBtn()
	{
		return eleDoneBtn;
	}

	@FindBy(xpath="//UIAStaticText[@name='Invalid mobile number, try again']")
	private WebElement eleInvalidMobileAlertPopup;
	public WebElement getEleInvalidMobileAlertPopup()
	{
		return eleInvalidMobileAlertPopup;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATextField[1]") 
	private WebElement eleOTPCodeTxtFld;
	public WebElement getEleOTPCodeTxtFld()
	{
		return eleOTPCodeTxtFld;
	}

	@FindBy(xpath="//UIAButton[@name='SKIP']")
	private WebElement eleSkipBtn;
	public WebElement getEleSkipBtn()
	{
		return eleSkipBtn;
	}
	@FindBy(xpath="//UIAButton[@name='SKIP']")
	private WebElement eleSkiplnk;
	public WebElement getEleSkipLnk()
	{
		return eleSkiplnk;
	}

	@FindBy(xpath="//UIAButton[@name='LOGIN']")
	private WebElement eleLoginLnk;
	public WebElement getEleLoginLnk()
	{
		return eleLoginLnk;
	}

	@FindBy(xpath="//UIAButton[@name='JOIN NOW']")
	private WebElement eleJOINNOWBtn;
	public WebElement getEleJOINNOWBtn()
	{
		return eleJOINNOWBtn;
	}

	@FindBy(xpath="//UIAStaticText[@name='Welcome!']")
	private WebElement eleWelcomeTxt;
	public WebElement getEleWelcomeTxt()
	{
		return eleWelcomeTxt;
	}

	@FindBy(xpath="//UIAButton[@name='ic edit grey']")
	private WebElement eleEditIcn;
	public WebElement getEleEditIcn()
	{
		return eleEditIcn;
	}
	
	@FindBy(xpath="//UIAAlert[@name='Allow “Sulekha” to access your location even when you are not using the app?']")
	private WebElement eleAllowSulekhaTxt;
	public WebElement getEleAllowSulekhaTxt()
	{
		return eleAllowSulekhaTxt;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='“Sulekha” Would Like to Send You Notifications']")
	private WebElement eleNotificationAlertTxt;
	public WebElement getEleNotificationAlertTxt()
	{
		return eleNotificationAlertTxt;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='Always']")
	private WebElement eleAlwaysTxt;
	public WebElement getEleAlwaysTxt()
	{
		return eleAlwaysTxt;
	}
	@FindBy(xpath="//UIAButton[@name='RESEND CODE']")
	private WebElement eleRESENDCODEBtn;
	public WebElement getEleRESENDCODEBtn()
	{
		return eleRESENDCODEBtn;
	}

	@FindBy(xpath="//UIAButton[@name='*T & C apply']")
	private WebElement eleTermsCLnk;
	public WebElement getEleTermsCLnk()
	{
		return eleTermsCLnk;
	}

	@FindBy(xpath="//UIAStaticText[@name='Terms & Conditions']")
	private WebElement eleTermsCTxt;
	public WebElement getEleTermsCTxt()
	{
		return eleTermsCTxt;
	}

	@FindBy(xpath="//UIAButton[@name='Back Ipad']")
	private WebElement eleBackArwIcn;
	public WebElement getEleBackArwIcn()
	{
		return eleBackArwIcn;
	}
	@FindBy(id="Mobile number")
	private WebElement eleMobileNoTxtFld;
	public WebElement getEleMobileNoTxtFld()
	{
		return eleMobileNoTxtFld;
	}

	@FindBy(xpath="//UIAStaticText[@name='Allow Sulekha to access your location even when you are not using the app? Always']")
	private WebElement eleLocationPopup;
	public WebElement getEleLocationPopup()
	{
		return eleLocationPopup;
	}

	@FindBy(xpath="//UIAButton[@name='Allow']")
	private WebElement eleAllowBtn;
	public WebElement getEleAllowBtn()
	{
		return eleAllowBtn;
	}

	@FindBy(xpath="//UIAButton[@name='Don’t Allow']")
	private WebElement eleDontAllowBtn;
	public WebElement getEleDontAllowBtn()
	{
		return eleDontAllowBtn;
	}

	@FindBy(xpath="//UIAButton[@name='OK']")
	private WebElement eleOKBtn;
	public WebElement getEleOKBtn()
	{
		return eleOKBtn;
	}

	@FindBy(xpath="//UIAStaticText[@name='Sulekha would like to send you Notifications']")
	private WebElement eleNotificationPopup;
	public WebElement getEleNotificationPopup()
	{
		return eleNotificationPopup;
	}

	@FindBy(xpath="(//UIAButton)[3]")
	private WebElement eleOTPTimeLimitTxt;
	public WebElement getEleOTPTimeLimitTxt()
	{
		return eleOTPTimeLimitTxt;
	}
	

	@FindBy(id="Enter your location")
	private WebElement eleDestinationTxtBox;
	public WebElement getEleDestinationTxtBox()
	{
		return eleDestinationTxtBox;
	}




	/* @Description- To register into the app
	 * @Author- Yashi Priya*/
	public void joinNow(String sMobileNo,String sCode)
	{
			getEleJOINSULEKHABtn().click();
			Assert.assertTrue(getEleJOINNOWBtn().isDisplayed(), "Join Sulekha page is not displayed");
			NXGReports.addStep("Join Sulekha page is successfully displayed", LogAs.PASSED, null);
			getEleMobileNoTxtFld().sendKeys(sMobileNo);
			getEleJOINNOWBtn().click();
			Assert.assertTrue(getEleOTPCodeTxtFld().isDisplayed(),"Verification OTP screen is not displayed");
			NXGReports.addStep("Verification OTP screen is successfully displayed", LogAs.PASSED, null);
			getEleOTPCodeTxtFld().sendKeys(sCode);
	}
	/* @Description- To register into the app
	 * @Author- Yashi Priya*/
	public void toHandleAlertPopup(){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try
		{
			if(getEleOKBtn().isDisplayed())
			{	NXGReports.addStep("Notification popup is displayed", LogAs.PASSED, null);
				getEleOKBtn().click();
			}
			
		}catch(Exception e)
		{
			tohandleLocationPopup();
			if(getEleOKBtn().isDisplayed())
			{	NXGReports.addStep("Notification popup is displayed", LogAs.PASSED, null);
				getEleOKBtn().click();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		NXGReports.addStep("Popups are successfully handled", LogAs.PASSED, null);
		
	}
	/* @Description- To register into the app
	 * @Author- Lakshmi*/
	public void tohandleLocationPopup()
	{
		try
		{
			if(getEleAllowBtn().isDisplayed())			
			{	NXGReports.addStep("Location popup is displayed", LogAs.PASSED, null);
				getEleAllowBtn().click();	
			}	
		}
		catch(Exception e)
		{
			NXGReports.addStep("Location Alert popup is not displayed", LogAs.PASSED, null);
		}
	}

	public void handleForm(String sLocalitiesList,MDLDPO mdldpo) throws InterruptedException
	{
				mdldpo.getEleFormCheckBox().click();
				Assert.assertTrue(getEleDestinationTxtBox().isDisplayed(),"Destination text box is not dispalyed");
				NXGReports.addStep("Destination text box is successfully dispalyed", LogAs.PASSED, null);
				getEleDestinationTxtBox().sendKeys(sLocalitiesList);
				Thread.sleep(1000);
				Assert.assertTrue(mdldpo.getEleLocalitiesList().isDisplayed(),"Destination search result is not displayed");
				NXGReports.addStep("Destination search result is successfully displayed",LogAs.PASSED, null);
				mdldpo.getEleLocalitiesList().click();
				Assert.assertTrue(mdldpo.getEleNextBtn().isDisplayed(),"Next button is not displayed");
				NXGReports.addStep("Next button is successfully displayed", LogAs.PASSED, null);
				mdldpo.getEleNextBtn().click();
	}
	
}

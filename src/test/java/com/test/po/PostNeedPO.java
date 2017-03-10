package com.test.po;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

import io.appium.java_client.ios.IOSDriver;

public class PostNeedPO {
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	IOSDriver driver=null;
	HomePO homePo=null;
	LoginPO loginPo=null;
	
	public PostNeedPO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//UIAStaticText[@name='Tell us more']")
	private WebElement eleTellusmoreTxt;
	public WebElement getEleTellusmoreTxt()
	{
		return eleTellusmoreTxt;
	}
	
	@FindBy(xpath="//UIAButton[@name='Back Ipad']")
	private WebElement eleBackArwIcn;
	public WebElement getEleBackArwIcn()
	{
		return eleBackArwIcn;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='City']")
	private WebElement eleCityLabel;
	public WebElement getEleCityLabel()
	{
		return eleCityLabel;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[5]")
	private WebElement eleCityNameTxt;
	public WebElement getEleCityNameTxt()
	{
		return eleCityNameTxt;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='Need']")
	private WebElement eleNeedLabel;
	public WebElement getEleNeedLabel()
	{
		return eleNeedLabel;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[3]")
	private WebElement eleNeedNameTxt;
	public WebElement getEleNeedNameTxt()
	{
		return eleNeedNameTxt;
	}
	
	
	
	@FindBy(xpath="//*[@name='Please enter value']")
	private WebElement eleAlertValuepopup;
	public WebElement getEleAlertValuepopup()
	{
		return eleAlertValuepopup;
	}
	@FindBy(xpath="//UIAButton[@name='Fill the form and get free quotes']")
	private WebElement eleFillformBtn;
	public WebElement getEleFillformBtn()
	{
		return eleFillformBtn;
	}
	@FindBy(id="Please select one option")
	private WebElement eleAlertSelectOneOption;
	public WebElement getEleAlertSelectOneOption(){
		return eleAlertSelectOneOption;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleFormRadioBtn;
	public WebElement getEleFormRadioBtn()
	{
		return eleFormRadioBtn;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='Contact information']")
	private WebElement eleContactInfoTxt;
	public WebElement getEleContactInfoTxt()
	{
		return eleContactInfoTxt;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[2]")
	private WebElement eleFormRadioBtn2;
	public WebElement getEleFormRadioBtn2()
	{
		return eleFormRadioBtn2;
	}
	
	@FindBy(xpath="//UIAButton[@name='RESPONSES']")
	private WebElement eleResponsesTab;
	public WebElement getEleResponsesTab()
	{
		return eleResponsesTab;
	}
	
	
	
	@FindBy(id="1 of 2")
	private WebElement eleFormPagingTxt;
	public WebElement getEleFormPagingTxt()
	{
		return eleFormPagingTxt;
	}
	
	@FindBy(xpath="//UIAButton[@name='NEXT']")
	private WebElement eleNextBtn;
	public WebElement getEleNextBtn()
	{
		return eleNextBtn;
	}
	
	@FindBy(xpath="//UIAButton[@name='SUBMIT REQUEST']")
	private WebElement eleSubmitRequestBtn;
	public WebElement getEleSubmitRequestBtn()
	{
		return eleSubmitRequestBtn;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='Additional info']")
	private WebElement eleAdditionalInfoLabel;
	public WebElement getEleAdditionalInfoLabel()
	{
		return eleAdditionalInfoLabel;
	}
	
	@FindBy(id="Top 10 Neurologists in Bangalore.")

	private WebElement eleUserCommentTxt;

	public WebElement geteleUserCommentTxt()

	{

	return eleUserCommentTxt;

	}

	
	@FindBy(id="Provide any other specific details for your need")
	private WebElement eleTellusMoreTxtFld;
	public WebElement getEleTellusMoreTxtFld()
	{
		return eleTellusMoreTxtFld;
	}
	
	@FindBy(xpath="//UIAStaticText[@name='Notifications']")
	private WebElement eleNotificationLnk;
	public WebElement getEleNotificationLnk()
	{
		return eleNotificationLnk;
	}
	///UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[3]

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[3]")
	private WebElement eleNeedTxt;
	public WebElement getEleNeedTxt()
	{
		return eleNeedTxt;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleNotificationListItm;
	public WebElement getEleNotificationListItm()
	{
		return eleNotificationListItm;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleEditIcn;
	public WebElement getEleEditIcn()
	{
		return eleEditIcn;
	}
	
	@FindBy(xpath="//*[@name='Please select atleast one option']")
	private WebElement eleSelectAtleastOneOptAlertPopup;
	public WebElement getEleSelectAtleastOneOptAlertPopup()
	{
		return eleSelectAtleastOneOptAlertPopup;
	}
	
	
	@FindBy(xpath="//UIAButton[@name='smsIcon']")

	private WebElement eleSmsIcon;

	public WebElement getEleSmsIcon(){

	return eleSmsIcon;

	}
	
	
	
	@FindBy(xpath="//UIAButton[@name='shortlistIcon']")

	private WebElement eleShortlistIcon;

	public WebElement getShortlistIcon(){

	return eleShortlistIcon;

	}
	@FindBy(xpath="//UIAButton[@name='My Review Iphone']")
	private WebElement eleAdditionalInfoEditIcn;
	public WebElement getEleAdditionalInfoEditIcn()
	{
		return eleAdditionalInfoEditIcn;
	}
	
	@FindBy(id="Additional info")
	private WebElement eleAdditionalInfoTxt;
	public WebElement getEleAdditionalInfoTxt()
	{
		return eleAdditionalInfoTxt;
	}
	
	@FindBy(id="Ambulance Services")
	private WebElement eleAmbulanceServicesTxt;
	public WebElement getEleAmbulanceServicesTxt()
	{
		return eleAmbulanceServicesTxt;
	}
	
	public void toSubmitNeed(MyNeedsDashboardPO myneedsdashboardPo)
	{
		getEleFillformBtn().click();
		Assert.assertTrue(eleFormPagingTxt.isDisplayed(), "Form page for the business is not displayed");
		NXGReports.addStep("Form page for the business is successfully displayed",LogAs.PASSED, null);
		getEleFormRadioBtn().click();
		Assert.assertTrue(eleContactInfoTxt.isDisplayed(), "Contact information page is not displayed");
		NXGReports.addStep("Contact information page is successfully displayed",LogAs.PASSED, null);
		getEleNextBtn().click();
		Assert.assertTrue(getEleSubmitRequestBtn().isDisplayed(), "Confirm and submit page is not displayed");
		NXGReports.addStep("Confirm and submit page is successfully displayed",LogAs.PASSED, null);
		getEleSubmitRequestBtn().click();
		Assert.assertTrue(myneedsdashboardPo.getEleNeedsTab().isDisplayed(), "User is not navigated to NeedsDashboard screen");
		NXGReports.addStep("User is successfully navigated to NeedsDashboard screen", LogAs.INFO, null);
		
	}
	
	
	/* @Description- To navigate till Tell us More screen in SDLDwithoutType
	 * @Author- Yashi Priya*/
	public void toPostSdldWithoutType(HomePO homePo)
	{
		homePo.getEleSeachRsltLstItm().click();
		Assert.assertTrue(getEleFillformBtn().isDisplayed(), "Fill form popup is not displayed");
		NXGReports.addStep("Fill form popup is successfully displayed",LogAs.PASSED, null);
		getEleFillformBtn().click();
		Assert.assertTrue(getEleTellusmoreTxt().isDisplayed(), "User is not  displayed only with Tell us more field.");
		NXGReports.addStep("User is successfully displayed only with Tell us more field.",LogAs.PASSED, null);
	}
}

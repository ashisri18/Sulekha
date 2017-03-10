package com.test.po;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MDLDPO {
	String[] sData=null;
	public Logger log = Logger.getLogger(this.getClass());
	IOSDriver driver=null;
	HomePO homePo=null;
	LoginPO loginPo=null;
	
	public MDLDPO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@name='Fill the form and get free quotes']")
	private WebElement eleFillformBtn;
	public WebElement getEleFillformBtn()
	{
		return eleFillformBtn;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleShortlistsItem;
	public WebElement getEleShortlistsItem()
	{
		return eleShortlistsItem;
	}
	
	@FindBy(xpath="//*[@name='ic star border black 36dp 3x']")

	private WebElement eleShortlistsIcon;

	public WebElement getEleShortlistsIcon(){

	return eleShortlistsIcon;

	}


	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleFormRadioBtn;
	public WebElement getEleFormRadioBtn()
	{
		return eleFormRadioBtn;
	}
	@FindBy(xpath="//*[@name='What are you looking for?']")
	private WebElement elequestiontxt;
	public WebElement getElequestiobtxt(){
		return elequestiontxt;
	}
	
	@FindBy(xpath="//*[@name='What do you want to be trained in?']")
	private WebElement eletrainedquestion;
	public WebElement getEletrainedquestion(){
		return eletrainedquestion;
	}
	
	@FindBy(xpath="//*[@name='Responses']")
	private WebElement eleResponsesTab;
	public WebElement getEleResponsesTab()
	{
		return eleResponsesTab;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleLocationList;
	public WebElement getEleLocationList(){
		return eleLocationList;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleFormCheckBox;
	public WebElement getEleFormCheckBox()
	{
		return eleFormCheckBox;
	}
	
	@FindBy(id="Date")
	private WebElement eleDateTxtFld;
	public WebElement getEleDateTxtFld(){
		return eleDateTxtFld;
	}
	@FindBy(id="Max 5 localities can be added")
	private WebElement eleDestinationTxtBox;
	public WebElement getEleDestinationTxtBox()
	{
		return eleDestinationTxtBox;
	}
	@FindBy(xpath="//*[@name='Return']")
	private WebElement eleReturnBtn;
	public WebElement getEleReturnBtn(){
		return eleReturnBtn;
	}
	
	
	
	@FindBy(xpath="//*[@name='NEXT']")
	private WebElement eleNextBtn;
	public WebElement getEleNextBtn()
	{
		return eleNextBtn;
	}
	@FindBy(id="Enter your location")

	private WebElement eleLocationTxtFld;

	public WebElement getEleLocationTxtFld(){

	return eleLocationTxtFld;

	}
	@FindBy(xpath="//UIAStaticText[@name='Surveillance DVR Solutions']")
	private WebElement eleNeedSummarypageTxt;
	public WebElement getEleNeedSummarypageTxt(){
		return eleNeedSummarypageTxt;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleLocalitiesList;
	public WebElement getEleLocalitiesList(){
		return eleLocalitiesList;
	}
	@FindBy(xpath="//*[@name='SUBMIT REQUEST']")
	private WebElement eleSubmitRequestBtn;
	public WebElement getEleSubmitRequestBtn()
	{
		return eleSubmitRequestBtn;
	}
	@FindBy(xpath="//*[@name='Others']")
	private WebElement eleOthersBtn;
	public WebElement getEleOthersBtn(){
	return eleOthersBtn;

	}
	@FindBy(xpath="//*[@name='Notifications']")
	private WebElement eleNotificationLnk;
	public WebElement getEleNotificationLnk()
	{
		return eleNotificationLnk;
	}
	
	@FindBy(xpath="//*[@name='Business intelligence & analytics training']")
	private WebElement eleradioBtn;
	public 	WebElement getEleradioBtn(){
		return eleradioBtn;
		
		
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[2]")

	private WebElement eleFormCheckBox1;

	public WebElement getEleFormCheckBox1()

	{

	return eleFormCheckBox1;

	}
	@FindBy(xpath="//*[@name='Pest control products & equipment dealers']")
	private WebElement eleRadioBtn;
	public WebElement getEleRadioBtn(){
		return eleRadioBtn;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[1]")
	private WebElement eleEditicon;
	public WebElement getEleEditicon(){
		return eleEditicon;
	}
	@FindBy(xpath="//*[@name='Contact information']")
	private WebElement eleContactInformation;
	public WebElement getEleContactInformation(){
		return eleContactInformation;
	}		
	
	@FindBy(xpath="//*[@name='Please select atleast one option']")
	private WebElement eleAlertQuestionPopup;
	public WebElement getEleAlertQuestionPopup(){
		return eleAlertQuestionPopup;
	}
	@FindBy(xpath=" //UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAButton[2]")
	private WebElement eleCheckedformList;
	public WebElement getEleCheckedformList(){
		return eleCheckedformList;
	}
	@FindBy(id="Provide any other specific details for your need")
	private WebElement eleTellUsTxtFld;
	public WebElement getEleTellUsTxtFld(){
		return eleTellUsTxtFld;
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[3]")
	private WebElement eleAdditionalinfoTxt;
	public WebElement getEleAdditionalinfoTxt(){
		return eleAdditionalinfoTxt;
	}
	@FindBy(id="What are you looking for?")
	private WebElement eleQuestionLookingTxt;
	public WebElement getEleQuestionLookingTxt(){
		return eleQuestionLookingTxt;
	}
	
	@FindBy(id="Where do you need this service?")
	private WebElement eleDestQuestTxt;
	public WebElement getEleDestQuestTxt(){
		return eleDestQuestTxt;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[2]")
	private WebElement eleLocationTxt;
	public WebElement getEleLocationTxt(){
		return eleLocationTxt;
	}
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[3]")
	private WebElement eleNeedTxt;
	public WebElement getEleNeedTxt(){
		return eleNeedTxt;
	}
	
	
	//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAScrollView[1]/UIAStaticText[3]

	

	public void search(String[] sData,HomePO homePo,MyNeedsDashboardPO myNeedsDashboadrdpo)
	{
		myNeedsDashboadrdpo.getEleCityTxtField().clear();
		myNeedsDashboadrdpo.getEleCityTxtField().sendKeys(sData[6]);
		myNeedsDashboadrdpo.getEleCityOption().click();
		homePo.getEleKeyboardReturnBtn().click();
		homePo.getEleSearchTxtFld().sendKeys(sData[7]);
		homePo.getEleKeyboardReturnBtn().click();
		Assert.assertTrue(homePo.getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
		NXGReports.addStep("Search result is successfully displayed",LogAs.PASSED, null);
		myNeedsDashboadrdpo.getEleSecondOption().click();
		Assert.assertTrue(getEleFillformBtn().isDisplayed(), "Fill the form and get free quotes button is not displayed");
		NXGReports.addStep("Fill the form and get free quotes button is successfully displayed", LogAs.PASSED, null);
		getEleFillformBtn().click();
		}
	public void handleForm(String sLocalitiesList,PostNeedPO postneedPo) throws InterruptedException
	{
				getEleFormCheckBox().click();
				Assert.assertTrue(getEleDestinationTxtBox().isDisplayed(),"Destination text box is not dispalyed");
				NXGReports.addStep("Destination text box is successfully dispalyed", LogAs.PASSED, null);
				getEleDestinationTxtBox().sendKeys(sLocalitiesList);
				Thread.sleep(1000);
				Assert.assertTrue(getEleLocalitiesList().isDisplayed(),"Destination search result is not Selected");
				NXGReports.addStep("Destination search result is successfully Selected",LogAs.PASSED, null);
				getEleLocalitiesList().click();
				postneedPo.getEleNextBtn().click();
	}
	
}

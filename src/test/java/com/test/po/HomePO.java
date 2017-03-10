package com.test.po;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

import io.appium.java_client.ios.IOSDriver;


public class HomePO {
	public Logger log = Logger.getLogger(this.getClass());
	IOSDriver driver=null;

	public HomePO(IOSDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]")
	private WebElement eleSeachRsltLstItm2;
	public WebElement getEleSeachRsltLstItm2()
	{
	return eleSeachRsltLstItm2;
	}
	@FindBy(xpath="//UIAStaticText[@name='Popular Categories']")
	private WebElement elePopularCtgrsTxt;
	public WebElement getElePopularCtgrsTxt()
	{
		return elePopularCtgrsTxt;
	}

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")
	private WebElement eleFirstOption;
	public WebElement getEleFirstOption(){
		return eleFirstOption;
	}
	
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")
	private WebElement eleLocationTxtFld;
	public WebElement getEleLocationTxtFld()
	{
		return eleLocationTxtFld;
	}
	
	
	@FindBy(id="What service do you need?")
	private WebElement eleSearchTxtFld;
	public WebElement getEleSearchTxtFld()
	{
		return eleSearchTxtFld;
	}
	
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]")
	private WebElement eleSearchResultLst;
	public WebElement getEleSearchResultLst()
	{
		return eleSearchResultLst;
	}
	
	
	@FindBy(xpath="//UIATableCell[@name='Ambulance Services in Bangalore']")
	private WebElement eleAmbulanceServicesLstItm;
	public WebElement getEleAmbulanceServicesLstItm()
	{
		return eleAmbulanceServicesLstItm;
	}
	

	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]")
	private WebElement eleNotificationLstItm;
	public WebElement getEleNotificationLstItm()
	{
		return eleNotificationLstItm;
	}
	
	
	@FindBy(xpath="//UIAButton[@name='Browse business listings']")
	private WebElement eleBrowseBusinessListingBtn;
	public WebElement getEleBrowseBusinessListingBtn()
	{
		return eleBrowseBusinessListingBtn;
	}
	
	
	@FindBy(xpath="//UIAStaticText[@name='Shortlist']")
	private WebElement eleShortListLnk;
	public WebElement getEleShortListLnk()
	{
		return eleShortListLnk;
	}
	
	
	@FindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")
	private WebElement eleSeachRsltLstItm;
	public WebElement getEleSeachRsltLstItm()
	{
		return eleSeachRsltLstItm;
	}
	
	
	@FindBy(id="Home Appliances Repairs & Services")
	private WebElement eleHomeAppliancesIcn;
	public WebElement getEleHomeAppliancesIcn(){
		return eleHomeAppliancesIcn;
	}
	
	
	@FindBy(id="Interior Decoration")
	private WebElement eleInteriorDecorationIcn;
	public WebElement getEleInteriorDecorationIcn(){
		return eleInteriorDecorationIcn;
	}
	
	@FindBy(id="Pest Control")
	private WebElement elePestControlIcn;
	public WebElement getElePestControlIcn(){
		return elePestControlIcn;
	}
	
	@FindBy(id="Security Services")
	private WebElement eleSecurityServicesIcn;
	public WebElement getEleSecurityServicesIcn(){
		return eleSecurityServicesIcn;
	}
	
	@FindBy(id="Modular Kitchen")
	private WebElement eleModularKitchenIcn;
	public WebElement getEleModularKitchenIcn(){
		return eleModularKitchenIcn;
	}
	
	@FindBy(id="Event Organizers")
	private WebElement eleEventOrganizersIcn;
	public WebElement getEleEventOrganizersIcn(){
		return eleEventOrganizersIcn;
	}
	
	@FindBy(id="Computer Training")
	private WebElement eleComputerTrainingIcn;
	public WebElement getEleComputerTrainingIcn(){
		return eleComputerTrainingIcn;
	}
	
	@FindBy(id="Packers & Movers")
	private WebElement elePackersAndMoversIcn;
	public WebElement getElePackersAndMoversIcn(){
		return elePackersAndMoversIcn;
	}
	
	@FindBy(id="Catering Services")
	private WebElement eleCateringServicesIcn;
	public WebElement getEleCateringServicesIcn(){
		return eleCateringServicesIcn;
	}
	
	@FindBy(id="Website Services")
	private WebElement eleWebsiteServicesIcn;
	public WebElement getEleWebsiteServicesIcn(){
		return eleWebsiteServicesIcn;
	}
	
	@FindBy(id="Coaching & Tuitions")
	private WebElement eleCoachingAndTuitionsIcn;
	public WebElement getEleCoachingAndTuitionsIcn(){
		return eleCoachingAndTuitionsIcn;
	}
	
	@FindBy(id="Electrical Repairs")
	private WebElement eleElectricalRepairsIcn;
	public WebElement getEleElectricalRepairsIcn(){
		return eleElectricalRepairsIcn;
	}
	
	
	@FindBy(xpath="//UIAStaticText[@name='More']")
	private WebElement eleMoreIcn;
	public WebElement getEleMoreIcn()
	{
		return eleMoreIcn;
	}
	

	@FindBy(xpath="//UIAButton[@name='SHORTLIST']")
	private WebElement eleShortlistTab;
	public WebElement getEleShortlistTab()
	{
		return eleShortlistTab;
	}
	
	
	@FindBy(xpath="//UIAButton[@name='Return']")
	private WebElement eleKeyboardReturnBtn;
	public WebElement getEleKeyboardReturnBtn()
	{
		return eleKeyboardReturnBtn;
	}
	
	
	
	
	
	
	/* @Description- to navigate to application home page vis skip button.
	 * @Author- Yashi Priya
	 */
	public void navigateToHomeWOLogin(WelcomePO welcomePo, HomePO homePo)
	{		
		welcomePo.toHandleAlertPopup();
		welcomePo.getEleSkipBtn().click();
		Assert.assertTrue(homePo.getElePopularCtgrsTxt().isDisplayed(), "Home page is not displayed");
		NXGReports.addStep("Home page is displayed", LogAs.PASSED, null);
			
		
	}
	
	/* @Description- to search the requested need
	 * @Author- Lakshmi
	 */
	public void searchNeed(String sNeed)
	{
		getEleSearchTxtFld().sendKeys(sNeed);
		getEleKeyboardReturnBtn().click();
		Assert.assertTrue(getEleSearchResultLst().isDisplayed(), "Search result is not displayed");
		NXGReports.addStep("Search result is successfully displayed", LogAs.PASSED, null);
	}
}


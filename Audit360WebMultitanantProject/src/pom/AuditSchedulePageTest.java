package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;

public class AuditSchedulePageTest extends BaseTest {

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Schedule']
	//Clicking on the Schedule
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Schedule']")
	private WebElement Schedule;

	//Clicking on the Audit Schedule from side menu
	@FindBy(xpath="//li[@class='open active']//ul[@class='sub-menu']//li//span[@class='title'][contains(text(),'Create Schedule')]")
	private WebElement CreateAuditSchedule;

	//Clicking on the Audit Schedule Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement AuditScheduleHeader;

	//Clicking on the Create New Schedule Button
	@FindBy(xpath="//span[contains(text(),'Create New Schedule')]")
	private WebElement CreateNewSheduleBTN;

	//Passing the Values to Select Audit Type Search Filed
	@FindBy(xpath="//div[@id='s2id_search_audit_types']/ul/li/input")
	private WebElement SelectAuditTypeSearchField;

	//Passing the Values to Select Country Search Filed
	@FindBy(xpath="//div[@id='s2id_search_address']/ul/li/input")
	private WebElement SelectContrySearchField;

	//Passing the Values to Select Auditee Search Filed
	@FindBy(xpath="//div[@id='s2id_search_auditees']/ul/li/input")
	private WebElement SelectAuditeeSearchField;

	//Passing the Values to Schedule start From 
	@FindBy(xpath="//input[@id='sch_start_from']")
	private WebElement ScheduleStartFrom;

	//Passing the Values to Schedule Start To
	@FindBy(xpath="//input[@id='sch_start_to']")
	private WebElement ScheduleStartTo;

	//Passing the Values to Schedule End From 
	@FindBy(xpath="//input[@id='sch_end_from']")
	private WebElement ScheduleEndFrom;

	//Passing the Values to Schedule End To
	@FindBy(xpath="//input[@id='sch_end_to']")
	private WebElement ScheduleEndTo;



	//Passing the Values to Audit Review Period From Search Field
	@FindBy(xpath="//input[@id='start_audit_period']")
	private WebElement AuditReviewPeriodFromSearchField;

	//Passing the Values to Audit Review Period To Search Field
	@FindBy(xpath="//input[@id='end_audit_period']")
	private WebElement AuditReviewPeriodToSearchField;

	//Checking the No Match Found Error Message
	@FindBy(xpath="//div[@id='select2-drop']//li[@class='select2-no-results']")
	private WebElement NoMatchFoundErrorMSG;

	//Clicking on the Select Audit Type
	@FindBy(xpath="//div[@id='s2id_audit_audit_type_id']/a/span[2]")
	private WebElement SAT;

	//Passing the Values to Select Audit type
	@FindBy(xpath="//div[@id='select2-drop']/div/label/following-sibling::input")
	private WebElement SATText;

	//Selecting Vendor Option Under Select Auditee Type
	@FindBy(xpath="//select[@id='audit_auditee_type_id']/option[text()='Vendor']")
	private WebElement Vendor;

	//Clicking on the Select Country/state/Location
	@FindBy(xpath="//div[@id='s2id_audit_address']/a/span[2]")
	private WebElement Location;

	//Passing the values to Loaction
	@FindBy(xpath="//div[@id='select2-drop']/div/label/following-sibling::input")
	private WebElement LocationText;

	//Clicking on the Select Auditee
	@FindBy(xpath="//span[text()='Start typing to search.']")
	private WebElement SelectAuditee;

	//Passing the Values to Select Auditee
	@FindBy(xpath="//div[@id='select2-drop']/div/label/following-sibling::input")
	private WebElement SelectAuditeeText;

	//Clicking on the Start date
	@FindBy(xpath="//input[@id='audit_audit_schedules_attributes_0_start_date']")
	private WebElement StartDate;

	//Clicking on the End date
	@FindBy(xpath="//input[@id='audit_audit_schedules_attributes_0_end_date']")
	private WebElement EndDate;

	//Clicking on the From Time
	@FindBy(xpath="//input[@id='audit_audit_schedules_attributes_0_start_time']")
	private WebElement StartTime;

	//Selecting 1st option under From Time
	@FindBy(xpath="//div[contains(@class,'ui-timepicker-wrapper ui-timepicker-positioned-top')][1]/ul/li[1]")
	private WebElement FromTimeOptions;

	//Clicking on the end Time
	@FindBy(xpath="//input[@class='time end_date ui-timepicker-input']")
	private WebElement EndTime;

	//Selecting 1st option under To Time
	@FindBy(xpath="//div[contains(@class,'ui-timepicker-wrapper ui-timepicker-positioned-top')][2]/ul/li[3]")
	private WebElement ToTimeOptions;

	//Selecting the 1st Auditor
	@FindBy(xpath="//div[@id='select2-drop']/ul/li[1]")
	private WebElement SelectAuditorOption;

	//Clicking on the Save Button//input[@value='Save']
	@FindBy(xpath="//input[@value='Save']")
	private WebElement SaveBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement CancelBTN;

	//Clicking on the Ok Button
	@FindBy(xpath="//a[text()='OK']")
	private WebElement OKBTN;

	//Clicking on the today Start Date
	@FindBy(xpath="//table[@class=' table-condensed']/tbody/tr/td[@class='today day']")
	private WebElement TodayStartDate;

	//Clicking on the today end Date
	@FindBy(xpath="//table[@class=' table-condensed']/tbody/tr/td[@class='today day']")
	private WebElement TodayEndDate;

	//Clicking on the Audit Period From
	@FindBy(xpath="//label[contains(text(),'Audit Review Period From:')]/following-sibling::input")
	private WebElement AuditReviewPeriodFrom;

	//Clicking on the Audit Period to
	@FindBy(xpath="//label[contains(text(),'Audit Review Period To:')]/following-sibling::input")
	private WebElement AuditReviewPeriodTo;

	//Passing the Values to Select Auditor//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input[@type='text']
	//div[@id='s2id_mapped_auditors']//input[@class='select2-input']
	@FindBy(xpath="//div[@id='s2id_mapped_auditors']//input[@type='text']")
	private WebElement SetSelectAuditor;

	//Clicking on the Multiple Auditor Readio Button
	@FindBy(xpath="//label[text()='Multiple auditor']")
	private WebElement MultipleAuditorBTN;

	//Clicking on the Sub Audits Radio Buttons
	@FindBy(xpath="//label[text()='Sub Audits']")
	private WebElement SubAuditsBTN;

	//Passing the Values to Select Sub Audit 1
	@FindBy(xpath="//div[@id='s2id_mapped_auditors_0_sub_audit_type_ids_']/ul/li/input[@type='text']")
	private WebElement SubAuditOne;

	//Passing the Values to Select Sub Audit 2
	@FindBy(xpath="//div[@id='s2id_mapped_auditors_1_sub_audit_type_ids_']/ul/li/input[@type='text']")
	private WebElement SubAuditTwo;

	//Clicking on the Matched Text////ul[@class='select2-results']/li[1]/div/span[@class='select2-match']
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Select Auditor
	@FindBy(xpath="//div[@id='s2id_mapped_auditors']/ul[@class='select2-choices']")
	private WebElement SelecctAuditor;

	//Passing the Values to Search Text filed
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBTN;

	//Clicking on the First TR
	@FindBy(xpath="//table[@id='auditsTableData']/tbody/tr[1]")
	private WebElement FirstTR;

	//Clicking on the Select Execution Status
	@FindBy(xpath="//div[@id='s2id_execution_statuses']/ul/li/input")
	private WebElement SelectExecutionStatus;

	//Clicking on the Update Button
	@FindBy(xpath="//input[@id='audit_update']")
	private WebElement UpdateBTN;

	//Clicking on the Delete Button
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement DeleteBTN;

	//Click on the Go Button
	@FindBy(xpath="//button[text()='Go']")
	private WebElement GoBTN;

	//clicking on the Parallel Execution Check box
	@FindBy(xpath="//label[text()='Parallel Execution']")
	private WebElement ParallelExecutionCheckBox;

	//clicking on the Multiple Execution Check box
	@FindBy(xpath="//label[text()='Multiple auditor']")
	private WebElement MultipleExecutionCheckBox;

	//clicking on the Lead auditor
	@FindBy(xpath="//label[text()='Is lead auditor']")
	private WebElement IsLeadauditorCheckBox;

	//clicking on the Group
	@FindBy(xpath="//label[text()='Groups']")
	private WebElement GroupCheckBox;

	//clicking on the Sub Audit
	@FindBy(xpath="//label[text()='Sub Audits']")
	private WebElement SubauditCheckBox;

	//clicking on the Lead auditor
	@FindBy(xpath="//div[@id='s2id_lead_selected_auditor']//a//span[1]")
	private WebElement LeadAudior;

	//Passing the Values to Lead Audior
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetLeadAudior;

	public void ClickGroupCheckBox() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", GroupCheckBox);
		System.out.println("Group Check box is Clicked");
		chiledTest.log(Status.INFO, "Group Check box is Clicked");
	}

	public void ClickSubAuditsCheckBox() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubauditCheckBox);
		System.out.println("Sub audit box is Clicked");
		chiledTest.log(Status.INFO, "Sub Audit Check box is Clicked");
	}

	public void VerifySubAuditsInDisabledMode() throws InterruptedException
	{
		Thread.sleep(2000);
		//Checking Sub Audit Check box is Disabled
		List<WebElement> SubauditCheckBtn = driver.findElements(By.xpath("//input[@id='sub_audit_check' and @disabled]"));
		Assert.assertTrue(SubauditCheckBtn.size()==1, "Sub Audit Check Box is not in Disabled mode");
		System.out.println("Sub audit Check box is Disabled");
		chiledTest.log(Status.INFO, "Sub Audit Check box is Disabled");

		//Checking Sub Audit Drop down is Disabled
		 List<WebElement> SubauditDropDwon = driver.findElements(By.xpath("//select[@id='mapped_auditors_0_sub_audit_type_ids_' and @disabled]"));
		Assert.assertTrue(SubauditDropDwon.size()==1, "Sub Audit Check Box is not in Disabled mode");
		System.out.println("Sub audit drop down is Disabled");
		chiledTest.log(Status.INFO, "Sub Audit Check drop down is Disabled");

	}


	public AuditSchedulePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ScrollBar));
		
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickSchedule(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(Schedule));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Schedule);

	}

	public void ClickAuditSchedule(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(CreateAuditSchedule));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CreateAuditSchedule);
	}

	public void ClickUpdateBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UpdateBTN);
		System.out.println("Update Button is Clicked");
	}

	public void ClickGoBTN()
	{
		GoBTN.click();
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}
	public void ClickDeleteBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DeleteBTN);
		System.out.println("Delete Button is Clicked");
	}

	public void ClickCreateNewSheduleBTN()
	{
		CreateNewSheduleBTN.click();
	}

	public void SetSelectAuditTypeSearchFiled(String SAT)
	{
		SelectAuditTypeSearchField.clear();

		SelectAuditTypeSearchField.sendKeys(SAT);
		System.out.println("Entered Audit Type is : " + SAT);
	}

	public void SetCountrySearchFiled(String SC)
	{
		SelectContrySearchField.clear();

		SelectContrySearchField.sendKeys(SC);
		System.out.println("Entered Country is : " + SC);
	}

	public void SetSelectAuditeeSearchFiled(String SA)
	{
		SelectAuditeeSearchField.clear();

		SelectAuditeeSearchField.sendKeys(SA);
		System.out.println("Entered Audtee is : " + SA);
	}

	public void SetScheduleStartFrom(String SF)
	{
		ScheduleStartFrom.clear();

		ScheduleStartFrom.sendKeys(SF);
		System.out.println("Entered Schedule Start From is : " + SF);
		chiledTest.log(Status.INFO, "Scedule Start From Is Entered");

		ScheduleStartFrom.sendKeys(Keys.ESCAPE);
	}

	public void SetScheduleStartTO(String ST)
	{
		ScheduleStartTo.clear();

		ScheduleStartTo.sendKeys(ST);
		System.out.println("Entered Start TO is : " + ST);
		chiledTest.log(Status.INFO, "Schedule Start To");

		ScheduleStartTo.sendKeys(Keys.ESCAPE);
	}

	public void SetScheduleEndFrom(String EF)
	{
		ScheduleEndFrom.clear();

		ScheduleEndFrom.sendKeys(EF);
		System.out.println("Entered Schedule End From is : " + EF);
		chiledTest.log(Status.INFO, "Scedule End From Is Entered");

		ScheduleEndFrom.sendKeys(Keys.ESCAPE);
	}

	public void SetScheduleEndTO(String ET)
	{
		ScheduleEndTo.clear();

		ScheduleEndTo.sendKeys(ET);
		System.out.println("Entered Schedule End TO is : " + ET);
		chiledTest.log(Status.INFO, "Schedule End To");

		ScheduleEndTo.sendKeys(Keys.ESCAPE);
	}

	public void SetAuditReviewPeriodFromSearchFiled(String ARPF)
	{
		AuditReviewPeriodFromSearchField.clear();

		AuditReviewPeriodFromSearchField.sendKeys(ARPF);
		System.out.println("Entered Start Date is : " + ARPF);

		AuditReviewPeriodFromSearchField.sendKeys(Keys.ESCAPE);
	}

	public void SetAuditReviewPeriodToSearchFiled(String ARPT)
	{
		AuditReviewPeriodToSearchField.clear();

		AuditReviewPeriodToSearchField.sendKeys(ARPT);
		System.out.println("Entered End Date is : " + ARPT);

		AuditReviewPeriodToSearchField.sendKeys(Keys.ESCAPE);

	}

	public void SetSelectExecutionStatus(String ES)
	{
		SelectExecutionStatus.sendKeys(ES);
		System.out.println("Selected Execution status is : " + ES);
	}

	public void ClickFirstTR(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(FirstTR)).click();

	}

	public void ClickSelectAuditType(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SAT)).click();
	}

	public void SetSelectAuditType(String SAT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SATText)).sendKeys(SAT);
		System.out.println("Entered Select Audit Type is : " + SAT);

	}

	public void SetSetSelectAuditor(String SA) throws InterruptedException
	{

		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='s2id_mapped_auditors']//a")).click();
		driver.findElement(By.xpath("//div[@id='select2-drop']//div//input")).sendKeys(SA);
		System.out.println("Entered Auditor is : " + SA);
		chiledTest.log(Status.INFO, "Auditor is Selected");

	}

	public void SetMultipleAuditor(String MA) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='s2id_mapped_auditors']//input[@type='text']")).sendKeys(MA);
		System.out.println("Entered Auditor is : " + MA);
		chiledTest.log(Status.INFO, "Auditor is Selected");
	}

	public void ClickLeadAudior() throws InterruptedException
	{	
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", LeadAudior);

	}

	public void SetLeadAuditor(String LA)
	{
		SetLeadAudior.sendKeys("LA");
		System.out.println("Entered Lead audior is : " + LA);
		chiledTest.log(Status.INFO, "Lead Auditor is Selected");
	}

	public void ClickVendorOption(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Vendor)).click();
	}

	public void ClickSelectCountryStateLocation(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Location)).click();
	}

	public void SetCountryStateLocation(String CSL, WebDriver driver) throws InterruptedException
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(LocationText)).sendKeys(CSL);
			System.out.println("Entered Select Country/State/Location Is : " + CSL);
		}catch (StaleElementReferenceException e) {

		}


	}

	public void ClickSelectAuditee(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SelectAuditee)).click();
	}

	public void SetSelectAuditeeText(String SA, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SelectAuditeeText)).sendKeys(SA);
		System.out.println("Entered Select Auditee is : " + SA);
	}

	public void ClickStartDate()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(StartDate));
		StartDate.click();
	}

	public void ClickTodayStartDate(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(TodayStartDate)).click();	
	}

	public void ClickAuditScheduleHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditScheduleHeader);
	}

	public void ClickEndDate()
	{
		EndDate.click();
	}

	public void ClickTodayEndDate(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(TodayEndDate)).click();
	}

	public void ClickSelectAuditorOption()
	{
		String text = SelectAuditorOption.getText();
		System.out.println("Selected Auditor type is : " + text);
		SelectAuditorOption.click();
	}

	public void ClickParallelExecutionCheckBox()
	{
		ParallelExecutionCheckBox.click();
		System.out.println("Parallel Execution Check Box is Clicked");
		chiledTest.log(Status.INFO, "Parallel Execution Check Box is Clicked");
	}

	public void ClickMultipleExecutionCheckBox()
	{
		MultipleExecutionCheckBox.click();
		System.out.println("Multiple Execution Check Box is Clicked");
		chiledTest.log(Status.INFO, "Multiple Execution Check Box is Clicked");
	}

	public void ClickIsLeadauditorCheckBox()
	{
		IsLeadauditorCheckBox.click();
		System.out.println("Is Lead audior Check Box is Clicked");
		chiledTest.log(Status.INFO, "Is Lead Audior Check Box is Clicked");
	}


	public void ClickSaveBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SaveBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SaveBTN);
		System.out.println("Save Button is Clicked");
	}

	public void ClickCancelBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CancelBTN);
		System.out.println("Cancel Button is Clicked");
	}

	public void ClickOKBTN()
	{
		OKBTN.click();
		System.out.println("Ok Button is Clicked");
	}
	public void ClickMultipleAuditorBTN()
	{
		MultipleAuditorBTN.click();
	}

	public void ClickSubAuditsBTN() throws InterruptedException
	{
		Thread.sleep(1000);
		SubAuditsBTN.click();
	}

	public void SetSubAuditOne(String SO, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		SubAuditOne.sendKeys(SO);
		System.out.println("Entered Sub Audit is : " + SO);

	}

	public void SetSubAuditTwo(String ST, WebDriver driver)
	{
		SubAuditTwo.sendKeys(ST);
		System.out.println("Entered Sub Audit is : " + ST);

	}

	public void ClickMatched()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(Matched));
			Matched.click();
		}catch (StaleElementReferenceException e) {
		}

	}

	public void ClickSelecctAuditor()
	{
		SelecctAuditor.click();
	}

	public void SetAuditReviewPeriodFromDate(String FD)
	{
		AuditReviewPeriodFrom.clear();

		AuditReviewPeriodFrom.sendKeys(FD);
		System.out.println("Selected Audit Period From date is : " + FD);

		AuditReviewPeriodFrom.sendKeys(Keys.ESCAPE);
	}

	public void SetAuditReviewPeriodTo(String TD)
	{
		AuditReviewPeriodTo.clear();

		AuditReviewPeriodTo.sendKeys(TD);
		System.out.println("Selected Audit Period To date is : " + TD);

		AuditReviewPeriodTo.sendKeys(Keys.ESCAPE);
	}

	public void SetSearchBTN(String SB)
	{
		SearchBTN.clear();

		SearchBTN.sendKeys(SB);
		System.out.println("Searched Audit Type is : " + SB);
	}

	public void ClearSearchBTN()
	{
		SearchBTN.clear();
	}

	public void VerifyAuditSchedulPageIsDisplayed(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Audit schedule header
		if(wait.until(ExpectedConditions.visibilityOf(AuditScheduleHeader)).isDisplayed())
		{
			String Actual_text = AuditScheduleHeader.getText();
			String Expected_text = "AUDIT SCHEDULE";
			Assert.assertEquals(Actual_text, Expected_text, "Header Name is Wrong");
			System.out.println("Pass : Audit Schedule Header is displayed");
		}

		//Checking the Create new schedule button is Displayed
		if(CreateNewSheduleBTN.isDisplayed())
		{
			System.out.println("Pass : Create New Schedule button is Displayed");
		}

		//checking the Search Text Filed
		if(SearchBTN.isDisplayed())
		{
			System.out.println("Pass : Search Button is Displayed");
		}

		//checking the Rows text box
		WebElement RowText = driver.findElement(By.xpath("//select[@name='auditsTableData_length']"));
		if(RowText.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Rows Search Button is Displayed");
		}

		//checking the Schedule ID
		WebElement ScheduleID = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[1]"));
		if(ScheduleID.isDisplayed())
		{
			String Actual_text = ScheduleID.getText();
			String Expected_text = "SCHEDULE ID";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Schedule ID is Displayed");
		}

		//Checking Audit Type
		WebElement AudityType = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[2]"));
		if(AudityType.isDisplayed())
		{
			String Actual_text = AudityType.getText();
			String Expected_text = "AUDIT TYPE";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Audit Type is Displayed");
		}

		//Checking Auditee 
		WebElement Auditee = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[3]"));
		if(Auditee.isDisplayed())
		{
			String Actual_text = Auditee.getText();
			String Expected_text = "AUDITEE";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Auditee is Displayed");
		}

		//Checking Auditor 
		WebElement Auditor = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[4]"));
		if(Auditor.isDisplayed())
		{
			String Actual_text = Auditor.getText();
			String Expected_text = "AUDITOR";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Auditor is Displayed");
		}

		//Checking From and date Time 
		WebElement date = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[5]"));
		if(date.isDisplayed())
		{
			String Actual_text = date.getText();
			String Expected_text = "FROM DATE & TIME";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : From Date and time is Displayed");
		}

		//Checking To date and Time 
		WebElement ToDate = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[6]"));
		if(ToDate.isDisplayed())
		{

			String Actual_text = ToDate.getText();
			String Expected_text = "TO DATE & TIME";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : To Date and time is Displayed");
		}

		//Checking Audit Review Period From
		WebElement ARPF = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[7]"));
		if(ARPF.isDisplayed())
		{
			String Actual_text = ARPF.getText();
			String Expected_text = "AUDIT REVIEW PERIOD FROM";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Audit Review Period From is Displayed");
		}

		//Checking Audit Review Period To
		WebElement ARPT = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[8]"));
		if(ARPT.isDisplayed())
		{
			String Actual_text = ARPT.getText();
			String Expected_text = "AUDIT REVIEW PERIOD TO";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Audit Review Period TO is Displayed");
		}


		//Checking execution status
		WebElement ES = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[9]"));
		if(ES.isDisplayed())
		{
			String Actual_text = ES.getText();
			String Expected_text = "EXECUTION STATUS";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Execution Status is Displayed");
		}

		//Checking Schedule Status
		WebElement SS = driver.findElement(By.xpath("//table[@id='auditsTableData']/thead/tr/th[10]"));
		if(SS.isDisplayed())
		{
			String Actual_text = SS.getText();
			String Expected_text = "SCHEDULE STATUS";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Schedule Status is Displayed");
		}

	}

	public void VerifyCreateAuditSchedulePageIsDisplayed(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Created audit schedule Header
		WebElement CAS = driver.findElement(By.xpath("//h4[@class='text-left p-b-5']"));
		if(wait.until(ExpectedConditions.visibilityOf(CAS)).isDisplayed())
		{
			String Actual_Create = CAS.getText();
			String Expected_Create = "Create Audit Schedule";
			Assert.assertEquals(Actual_Create, Expected_Create);
			System.out.println("Pass : Create Audit Schedule Header is Displayed");

		}

		//Checking the Select Audit Type
		WebElement SAT = driver.findElement(By.xpath("//div[@id='s2id_audit_audit_type_id']//label[@class='select2-offscreen']"));
		if(SAT.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Audit type is Displayed");
		}

		//Checking the Select Auditee Type
		WebElement SAT1 = driver.findElement(By.xpath("//div[@id='s2id_audit_auditee_type_id']//a[@class='select2-choice select2-default']"));
		if(SAT1.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Auditee type is Displayed");
		}

		//Checking the Select Country/State/Location
		WebElement Country = driver.findElement(By.xpath("//div[@id='s2id_audit_address']//a[@class='select2-choice select2-default']"));
		if(Country.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Country/State/Location is Displayed");
		}

		//Checking the Select Auditee
		WebElement SA = driver.findElement(By.xpath("//div[@id='s2id_search_addresses_auditee']//a[@class='select2-choice select2-default']"));
		if(SA.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Auditee is Displayed");
		}

		//checking Start date
		WebElement StartDate = driver.findElement(By.xpath("//input[@id='audit_audit_schedules_attributes_0_start_date']"));
		if(StartDate.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Start Date is Displayed");
		}

		//checking End date
		WebElement EndDate = driver.findElement(By.xpath("//input[@id='audit_audit_schedules_attributes_0_end_date']"));
		if(EndDate.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : End Date is Displayed");
		}

		//checking From
		WebElement From = driver.findElement(By.xpath("//input[@id='audit_audit_schedules_attributes_0_start_time']"));
		if(From.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : From is Displayed");
		}

		//checking TO
		WebElement TO = driver.findElement(By.xpath("//input[@id='audit_audit_schedules_attributes_0_end_time']"));
		if(TO.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : TO is Displayed");
		}

		//Checking Multiple Auditor
		WebElement MA = driver.findElement(By.xpath("//label[@for='audit_audit_schedules_attributes_0_multiple_auditor']"));
		if(MA.isDisplayed())
		{
			String Actual_text = MA.getText();
			String Expected_text = "Multiple auditor";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Multiple Auditor is Displayed");
		}

		//checking the Multiple Checkbox
		WebElement MACheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(MACheckBox.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Multiple Check box is Displayed");
		}

		//checking Select Auditor
		WebElement SA1 = driver.findElement(By.xpath("//div[@class='select2-container full-width selected_auditor on_schedule_create']//a[@class='select2-choice select2-default']"));
		if(SA1.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Auditor is Displayed");
		}

		//Checking Save Button
		if(SaveBTN.isDisplayed() )
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Save Button is Displayed");
		}

		//Checking Cancel Button
		if(CancelBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Cancel Button is Displayed");
		}

	}

	public void VerifyEditAuditSchedulePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement EditAuditSchedulePage = driver.findElement(By.xpath("//h5[text()='Edit Audit Schedule']"));
		if(wait.until(ExpectedConditions.visibilityOf(EditAuditSchedulePage)).isDisplayed())
		{
			String Actual_Text = EditAuditSchedulePage.getText();
			String Expected_Text = "Edit Audit Schedule";
			Assert.assertEquals(Actual_Text, Expected_Text, "page Name is Wrong");
			System.out.println("Edit Audit Schedule Page is Displayed");
			chiledTest.log(Status.INFO, "Edit Audit Schedule Page is Displayed");
		}

		//Checking Select Audit Type is read only mode
		List<WebElement> SAT1 = driver.findElements(By.xpath("//select[@id='audit_schedule_audit' and @disabled]"));
		Assert.assertTrue(SAT1.size()>0, "Select Audit Type is not working as Read only");
		System.out.println("pass : Select Audit Type is Read only mode");
		chiledTest.log(Status.INFO, "pass : Select Audit Type is Read only mode");

		//Checking Select Auditee Is Read only
		List<WebElement> Auditee1 = driver.findElements(By.xpath("//select[@id='audit_auditee_type_id' and @disabled]"));
		Assert.assertTrue(Auditee1.size()>0, "Select Auditee Type is not working as Read only");
		System.out.println("pass : Select Auditee Type is Read only mode");
		chiledTest.log(Status.INFO, "pass : Select Auditee Type is Read only mode");

		//Checking Select Address Is Read only
		List<WebElement> Address = driver.findElements(By.xpath("//div[@class='form-group form-group-default required']/input[@disabled='disabled']"));
		Assert.assertTrue(Address.size()>0, "Address is not working as Read only");
		System.out.println("pass : Address is Read only mode");
		chiledTest.log(Status.INFO, "pass : Address is Read only mode");

		//Checking Select Auditee Is Read only
		List<WebElement> Auditee = driver.findElements(By.xpath("//select[@id='audit_auditee_id' and @disabled]"));
		Assert.assertTrue(Auditee.size()>0, "Address is not working as Read only");
		System.out.println("pass : Auditee is Read only mode");
		chiledTest.log(Status.INFO, "pass : Auditee is Read only mode");

		//Checking Select Auditor Is Read only
		List<WebElement> Auditor = driver.findElements(By.xpath("//select[@id='mapped_auditors' and @disabled]"));
		Assert.assertTrue(Auditor.size()>0, "Auditor is not working as Read only");
		System.out.println("pass : Select Auditor is Read only mode");
		chiledTest.log(Status.INFO, "pass : Select Auditor is Read only mode");

		//Checking Audit Review Period From
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> AuditReviewPeriodFrom1 = driver.findElements(By.xpath("//input[@id='audit_schedule_audit_period_from' and @disabled]"));
		Assert.assertFalse(AuditReviewPeriodFrom1.size()>0, "Audit Review Period From should Editable");
		System.out.println("pass : Audit Review Period From is Not Read only mode");
		chiledTest.log(Status.INFO, "pass : Audit Review Period From is Not Read only mode");

		//Checking Audit Review Period to
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> AuditReviewPeriodTo1 = driver.findElements(By.xpath("//input[@id='audit_schedule_audit_period_to' and @disabled]"));
		Assert.assertFalse(AuditReviewPeriodTo1.size()>0, "Audit Review Period To should Editable");
		System.out.println("pass : Audit Review Period To is Not Read only mode");
		chiledTest.log(Status.INFO, "pass : Audit Review Period To is Not Read only mode");

		//Checking Schedule Start Date from
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> StartDateFrom = driver.findElements(By.xpath("//input[@id='audit_schedule_start_date' and @disabled]"));
		Assert.assertFalse(StartDateFrom.size()>0, "Audit Review Period To should Editable");
		System.out.println("pass : Schedule start date from is Not Read only mode");
		chiledTest.log(Status.INFO, "pass : Schedule start date from is Not Read only mode");

		//Checking Schedule Start Date To
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> StartDateTo = driver.findElements(By.xpath("//input[@id='audit_schedule_end_date' and @disabled]"));
		Assert.assertFalse(StartDateTo.size()>0, "Audit Review Period To should Editable");
		System.out.println("pass : Schedule start date To is Not Read only mode");
		chiledTest.log(Status.INFO, "pass : Schedule start date To is Not Read only mode");

	}

	public void VerifyScheduleCreatedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement SuccessMSG = driver.findElement(By.xpath("//span[contains(text(),'Schedule created successfully')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Schedule created successfully Pop up is NOT Displayed");
		System.out.println("Pass : Schedule created successfully. Success Message is Displayed");
		chiledTest.log(Status.INFO, "Schedule created successfully. Success Message is Displayed");

		//clicking on the cancel Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@type='button']")).click();
	} 


	public void VerifyDataIsDisplayedUnderGrid(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement Data = driver.findElement(By.xpath("//tr[@class='edit_audit_schedule_row even' or @class='edit_audit_schedule_row odd']"));
			if(Data.isDisplayed()){
				System.out.println("Searched Audit Type is Displayed");
				chiledTest.log(Status.INFO, "Searched Audit Type is Displayed");}
		}catch (Exception e) {
			WebElement NoDataFound = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
			if(NoDataFound.isDisplayed()){
				System.out.println("No data available in table Error Message is Displayed");
				chiledTest.log(Status.INFO, "No data available in table Error Message is Displayed");}}

	}

	public void VerifyNoMatchFoundErrorMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(NoMatchFoundErrorMSG)).isDisplayed())
		{
			String  Actual_Text = NoMatchFoundErrorMSG.getText();
			String Expected_Text = "No matches found";
			Assert.assertEquals(Actual_Text, Expected_Text, "Message is Wrong");
			System.out.println("No matches found Error Message is Displayed");
			chiledTest.log(Status.INFO, "No matches found Error Message is Displayed");
		}
	}

	public void VerifyRequiredFiledsAreDisplayd(WebDriver driver)
	{
		//Checking Select Audit Type is Required Filed
		List<WebElement> SelectAuditType = driver.findElements(By.xpath("//select[@id='audit_audit_type_id' and @required='required']"));
		Assert.assertTrue(SelectAuditType.size()>0, "Select Audit Type is Not Working as Required Field");
		System.out.println("Select Audit Type is Required Field");
		chiledTest.log(Status.INFO, "Select Audit Type is Required Field");

		//Checking Select Auditee Type is Required Filed
		List<WebElement> SelectAuditeeType = driver.findElements(By.xpath("//select[@id='audit_auditee_type_id' and @required='required']"));
		Assert.assertTrue(SelectAuditeeType.size()>0, "Select Auditee Type is Not Working as Required Field");
		System.out.println("Select Auditee Type is Required Field");
		chiledTest.log(Status.INFO, "Select Auditee Type is Required Field");

		//Checking Select Start Date is Required Filed
		List<WebElement> SelectStartDate = driver.findElements(By.xpath("//input[@id='audit_audit_schedules_attributes_0_start_date' and @required='required']"));
		Assert.assertTrue(SelectStartDate.size()>0, "Select Auditee Type is Not Working as Required Field");
		System.out.println("Start date is Required Field");
		chiledTest.log(Status.INFO, "Start date Type is Required Field");

		//Checking Select End Date is Required Filed
		List<WebElement> SelectEndDate = driver.findElements(By.xpath("//input[@id='audit_audit_schedules_attributes_0_end_date' and @required='required']"));
		Assert.assertTrue(SelectEndDate.size()>0, "Select Auditee Type is Not Working as Required Field");
		System.out.println("End date is Required Field");
		chiledTest.log(Status.INFO, "End date Type is Required Field");

		//Checking Auditor is Required Filed
		List<WebElement> Auditor = driver.findElements(By.xpath("//select[@id='mapped_auditors' and @required='required']"));
		Assert.assertTrue(Auditor.size()>0, "Select Auditee Type is Not Working as Required Field");
		System.out.println("Select Auditor is Required Field");
		chiledTest.log(Status.INFO, "Select Auditor Type is Required Field");

	}

	public void VerifyAuditPeriodToShouldGreaterThanAuditReviewPeriodFrom(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_Text= ErrorMSG.getText();
			String Expected_Text  = "Audit Period To should be greater than Audit Period From.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Audit Period To should be greater than Audit Period From pop up is NOT Displayed");
			System.out.println("End date should be greater than start date pop up is Displayed");
			chiledTest.log(Status.INFO, "End date should be greater than start date pop up is Displayed");

			//Clicking close button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
		}

	}

	public void VerifyAnnexureDocumentIsNotValidForTheSelectedSubAuditTypeErrorMSG(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMsg)).isDisplayed())
		{
			String Actual_Text = ErrorMsg.getText();
			String Expected_Text = "Annexure document is not valid for the selected sub audit type in the specified date range.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Message is Wrong");
			System.out.println("Annexure document is not valid for the selected sub audit type in the specified date range. Error Message is Displayed");
			chiledTest.log(Status.INFO, "Annexure document is not valid for the selected sub audit type in the specified date range. Error Message is Displayed");
		}
	}

	public void VerifyAScheduleIsUpdatedSuccessfullySuccessMSG(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Schedule is updated successfully.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Message is Wrong");
			System.out.println("Schedule is updated successfully. Message is Displayed");
			chiledTest.log(Status.INFO, "Schedule is updated successfully. Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();}
	}

	public void VerifyAreYouSureYouWantToDeleteAuditSchedulePopUpIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement AreYouSureYouDeletePopUp = driver.findElement(By.xpath("//p[@class='p-b-10']"));
		if(wait.until(ExpectedConditions.visibilityOf(AreYouSureYouDeletePopUp)).isDisplayed()){
			String Actual_Text = AreYouSureYouDeletePopUp.getText();
			String Expected_Text = "Are you sure?, You want to delete audit schedule";
			Assert.assertEquals(Actual_Text, Expected_Text, "Message is Wrong");
			System.out.println("Are you sure?, You want to delete audit schedule Pop Up is Displayed");
			chiledTest.log(Status.INFO, "Are you sure?, You want to delete audit schedule Pop Up is Displayed");}
	}

	public void VerifyScheduleWasSuccessfullyDestroyedMSGDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Schedule was successfully destroyed.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Message is Wrong");
			System.out.println("Schedule was successfully destroyed. Message is Displayed");
			chiledTest.log(Status.INFO, "Schedule was successfully destroyed. Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();}
	}

	public void VerifyUpdateButtonIsDisplayed(WebDriver driver)
	{
		List<WebElement> UpdateBTN1 = driver.findElements(By.xpath("//input[@id='audit_update']"));
		Assert.assertTrue(UpdateBTN1.size()>0, "Update Button is not Displayed");
		System.out.println("Pass : Update Button is Displayed");
		chiledTest.log(Status.INFO, "Pass : Update Button is Displayed");
	}

	public void VerifyDeleteButtonIsDisplayed(WebDriver driver)
	{
		List<WebElement> deleteBTN1 = driver.findElements(By.xpath("//a[@class='btn btn-danger btn-block']"));
		Assert.assertTrue(deleteBTN1.size()>0, "Update Button is not Displayed");
		System.out.println("Pass : Delete Button is Displayed");
		chiledTest.log(Status.INFO, "Pass : Delete Button is Displayed");
	}

	public void VerifyCancelButtonIsDisplayed(WebDriver driver)
	{
		List<WebElement> CancelBTN1 = driver.findElements(By.xpath("//button[@class='btn btn-default btn-block']"));
		Assert.assertTrue(CancelBTN1.size()>0, "Update Button is not Displayed");
		System.out.println("Pass : Cancel Button is Displayed");
		chiledTest.log(Status.INFO, "Pass : Cancel Button is Displayed");
	}

	public void VerifyUpdateButtonIsNotDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> UpdateBTN1 = driver.findElements(By.xpath("//input[@id='audit_update']"));
		Assert.assertTrue(UpdateBTN1.size()<=0, "Update Button is Displayed");
		System.out.println("Pass : Update Button is Not Displayed");
		chiledTest.log(Status.INFO, "Pass : Update Button is Not Displayed");
	}

	public void VerifyDeleteButtonIsNotDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> deleteBTN1 = driver.findElements(By.xpath("//a[@class='btn btn-danger btn-block']"));
		Assert.assertTrue(deleteBTN1.size()<=0, "Update Button is Displayed");
		System.out.println("Pass : Delete Button is Not Displayed");
		chiledTest.log(Status.INFO, "Pass : Delete Button is Not Displayed");
	}

	public void VerifyCancelButtonIsNotDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> CancelBTN1 = driver.findElements(By.xpath("//button[@class='btn btn-default btn-block']"));
		Assert.assertTrue(CancelBTN1.size()<=0, "Update Button is Displayed");
		System.out.println("Pass : Cancel Button is Not Displayed");
		chiledTest.log(Status.INFO, "Pass : Cancel Button is Not Displayed");
	}

	public void SetLeadAudior()
	{
		List<WebElement> LeadAuditor = driver.findElements(By.xpath("//select[@id='lead_selected_auditor']//option"));
		WebElement Firsttleadaudior = LeadAuditor.get(1);
		String Actual_Firsttleadaudior = Firsttleadaudior.getText();
		String Expected_Firsttleadaudior = Lib.getCellValue(XLPATH, "Schedule", 33, 0);
		Assert.assertEquals(Actual_Firsttleadaudior, Expected_Firsttleadaudior, "Lead Audior is Not Matched");

		Firsttleadaudior.click();
		System.out.println("Lead Audior is Selected");
		chiledTest.log(Status.INFO, "Lead Audior is Selected");
	}

	public void VerifypleaseSelectScheduleStartToAlertPopUpIsDisplayed()
	{
		Alert Alert = driver.switchTo().alert();
		String Actual_AlertMSG = Alert.getText();
		String Expected_AlertMSG = "please select Schedule Start To";
		Assert.assertEquals(Actual_AlertMSG, Expected_AlertMSG, "Alert Message is Wrong");
		System.out.println("please select Schedule Start To Alert Message is Displayed");
		chiledTest.log(Status.INFO, "please select Schedule Start To Alert Message is Displayed");

		//accepting Alert
		Alert.accept();

	}

	public void VerifypleaseSelectScheduleStartFromAlertPopUpIsDisplayed()
	{
		Alert Alert = driver.switchTo().alert();
		String Actual_AlertMSG = Alert.getText();
		String Expected_AlertMSG = "please select Schedule Start From";
		Assert.assertEquals(Actual_AlertMSG, Expected_AlertMSG, "Alert Message is Wrong");
		System.out.println("please select Schedule Start From Alert Message is Displayed");
		chiledTest.log(Status.INFO, "please select Schedule Start From Alert Message is Displayed");

		//accepting Alert
		Alert.accept();

	}

	public void VerifypleaseSelectScheduleEndTolertPopUpIsDisplayed()
	{
		Alert Alert = driver.switchTo().alert();
		String Actual_AlertMSG = Alert.getText();
		String Expected_AlertMSG = "please select Schedule End To";
		Assert.assertEquals(Actual_AlertMSG, Expected_AlertMSG, "Alert Message is Wrong");
		System.out.println("please select Schedule End To Alert Message is Displayed");
		chiledTest.log(Status.INFO, "please select Schedule End To Alert Message is Displayed");

		//accepting Alert
		Alert.accept();

	}

	public void VerifypleaseSelectScheduleEndFromlertPopUpIsDisplayed()
	{
		Alert Alert = driver.switchTo().alert();
		String Actual_AlertMSG = Alert.getText();
		String Expected_AlertMSG = "please select Schedule End From";
		Assert.assertEquals(Actual_AlertMSG, Expected_AlertMSG, "Alert Message is Wrong");
		System.out.println("please select Schedule End From Alert Message is Displayed");
		chiledTest.log(Status.INFO, "please select Schedule End From Alert Message is Displayed");

		//accepting Alert
		Alert.accept();

	}

}

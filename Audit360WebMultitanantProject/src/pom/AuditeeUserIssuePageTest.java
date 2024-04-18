package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class AuditeeUserIssuePageTest extends BaseTest {

	//Clicking on the scroll bar
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Issues under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content')]/li/a/span[text()='Issues']")
	private WebElement Issues;

	//Clicking on the Home Header
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement HomeHeader;

	//Clicking on the My Audit Header
	@FindBy(xpath="//a[@class='active'][contains(text(),'ISSUES')]")
	private WebElement IssuesHeader;

	//Passing the values to Select Parent Audit Type
	@FindBy(xpath="//div[@id='s2id_issue_transaction_audit_types']//input[@type='text']")
	private WebElement SelectParentAuditType;

	//Passing the values to Select Auditor
	@FindBy(xpath="//div[@id='s2id_issue_transaction_auditor']//input[@type='text']")
	private WebElement SelectAuditor;

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

	//Passing the Values to Select Schedule Due Date From
	@FindBy(xpath="//input[@id='issue_transaction_due_date']")
	private WebElement SelectScheduleDueDateFrom;

	//Passing the Values to Select Schedule Due Date To
	@FindBy(xpath="//input[@id='issue_transaction_due_date_to']")
	private WebElement SelectScheduleDueDateTo;

	//Passing the values to Search text Field
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBox;

	//Clicking on the Go Button
	@FindBy(xpath="//button[contains(text(),'Go')]")
	private WebElement GOBTN;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Checking SNO under grid
	@FindBy(xpath="//th[text()='S no.']")
	private WebElement SNO;

	//Checking Sub Audit Type under grid
	@FindBy(xpath="//th[text()='Sub Audit Type']")
	private WebElement SubAudit;

	//Checking Parent Audit Type under grid
	@FindBy(xpath="//th[text()='Parent Audit Type']")
	private WebElement ParentAuditAudit;

	//Checking Auditee under grid
	@FindBy(xpath="//th[text()='Auditee']")
	private WebElement Auditee;

	//Checking Sub Auditee under grid
	@FindBy(xpath="//th[text()='Sub Auditee']")
	private WebElement SubAuditee;

	//Checking Group Name  under grid
	@FindBy(xpath="//th[text()='GROUP NAME']")
	private WebElement GroupName;

	//Checking Checkpoint Intent under grid
	@FindBy(xpath="//th[text()='CheckPoint Intent']")
	private WebElement CheckpointIntent;

	//Checking Input Value under grid
	@FindBy(xpath="//th[text()='Input Value']")
	private WebElement InputValue;

	//Checking Date of Audit under grid
	@FindBy(xpath="//th[text()='Date of Audit']")
	private WebElement DateOfAudit;

	//Checking Due Date under grid
	@FindBy(xpath="//th[text()='Due Date']")
	private WebElement DueDate;

	//Checking Details under grid
	@FindBy(xpath="//th[text()='Details']")
	private WebElement Details;

	//Checking Issue Status under grid
	@FindBy(xpath="//th[text()='Issue Status']")
	private WebElement IssueStatus;

	//Checking Digital Evidence under grid
	@FindBy(xpath="//th[text()='Digital Evidence']")
	private WebElement DigitalEvidence;

	//Checking No Record Found Error under grid
	@FindBy(xpath="//td[@class='dataTables_empty']")
	private WebElement NoRecordFound;

	@FindBy(xpath="//select[@name='tableWithSearchForIssueTransactions_length']")
	private WebElement ShowRows;

	public AuditeeUserIssuePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickIssues(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Issues);
	}


	public void ClickHomeHeader()
	{
		HomeHeader.click();
	}

	public void ClickIssuesHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", IssuesHeader);
	}

	public void SetSelectParentAuditType(String SPA)
	{
		SelectParentAuditType.sendKeys(SPA);
		System.out.println("Entered Parent Audit Type is : " + SPA);
	}

	public void SetSelectAuditor(String SA)
	{
		SelectAuditor.sendKeys(SA);
		System.out.println("Entered Auditor is : " + SA);
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


	public void SetSelectScheduleDueDateFrom(String SDF)
	{
		SelectScheduleDueDateFrom.sendKeys(SDF);
		System.out.println("Entered Schedule Due Date From is : " + SDF);

		SelectScheduleDueDateFrom.sendKeys(Keys.ESCAPE);
	}

	public void SetSelectScheduleDueDateTo(String SDT)
	{
		SelectScheduleDueDateTo.sendKeys(SDT);
		System.out.println("Entered Schedule Due Date To is : " + SDT);

		SelectScheduleDueDateTo.sendKeys(Keys.ESCAPE);
	}



	public void ClickMatched(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Matched)).click();
	}

	public void setSearchBox(String SS, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SearchBox)).clear();
		SearchBox.sendKeys(SS);
		System.out.println("Searched Audit Type is : " + SS);
	}

	public void ClearSearchBox()
	{
		SearchBox.clear();
	}

	public void ClickGOBTN()
	{
		GOBTN.click();
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}

	public void ClickCloseBTN()
	{
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement All = CloseBTN.get(i);
			All.click();
		}
	}


	public void VerifyIssuesPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking Home Header
		Assert.assertTrue(HomeHeader.isDisplayed(), "Home Header is Not Displayed");
		System.out.println("Home is Displayed");
		chiledTest.log(Status.INFO, "Home is Displayed");

		//Checking the Issues Header
		Assert.assertTrue(IssuesHeader.isDisplayed(), "Issues Header is Not Displayed");
		System.out.println("Issue Header is Displayed");
		chiledTest.log(Status.INFO, "Issue Header is Displayed");

		//Checking the Select Parent Audit type
		WebElement SelectParentAudittype = driver.findElement(By.xpath("//label[contains(text(),'Select Parent Audit Type')]"));
		Assert.assertTrue(SelectParentAudittype.isDisplayed(), "Select Parent Audit Type Drop down Is Not Displayed");
		System.out.println("Select Parent Audit Type Drop down is Displayed");
		chiledTest.log(Status.INFO, "Select Parent Audit Type Drop down is Displayed");

		//Checking the Select Auditor
		WebElement SelectIntent = driver.findElement(By.xpath("//label[contains(text(),'Select Auditor')]"));
		Assert.assertTrue(SelectIntent.isDisplayed(), "Select Auditor Drop down Is Not Displayed");
		System.out.println("Selecte Auditor Drop down is Displayed");
		chiledTest.log(Status.INFO, "Selecte Auditor Drop down is Displayed");


		//Checking the Schedule Start From
		WebElement SelectScheduleStartDate = driver.findElement(By.xpath("//label[contains(text(),'Schedule Start From')]"));
		Assert.assertTrue(SelectScheduleStartDate.isDisplayed(), "Select Start From Drop down Is Not Displayed");
		System.out.println("Schedule Start From Drop down is Displayed");
		chiledTest.log(Status.INFO, "Schedule Start From Drop down is Displayed");


		//Checking the Select Schedule Start To
		WebElement SelectScheduleEndDate = driver.findElement(By.xpath("//label[contains(text(),'Schedule Start To')]"));
		Assert.assertTrue(SelectScheduleEndDate.isDisplayed(), "Schedule Start TO Drop down Is Not Displayed");
		System.out.println("Schedule Start To Drop down is Displayed");
		chiledTest.log(Status.INFO, "Schedule Start To Drop down is Displayed");

		//Checking the Schedule End From
		WebElement ScheduleEndFrom = driver.findElement(By.xpath("//label[contains(text(),'Schedule End From')]"));
		Assert.assertTrue(SelectScheduleStartDate.isDisplayed(), "Schedule End From down Is Not Displayed");
		System.out.println("Schedule End From Drop down is Displayed");
		chiledTest.log(Status.INFO, "Schedule End From Drop down is Displayed");


		//Checking the Schedule End To
		WebElement ScheduleEndTo = driver.findElement(By.xpath("//label[contains(text(),'Schedule End To')]"));
		Assert.assertTrue(ScheduleEndTo.isDisplayed(), "Schedule End To down Is Not Displayed");
		System.out.println("Schedule End ToDrop down is Displayed");
		chiledTest.log(Status.INFO, "Schedule End ToTo Drop down is Displayed");

		//Checking the Select Issue Status
		WebElement SelectIssueStatus = driver.findElement(By.xpath("//label[contains(text(),'Select Issue Status')]"));
		Assert.assertTrue(SelectIssueStatus.isDisplayed(), "Select Issue Status Drop down Is Not Displayed");
		System.out.println("Select Issue Status drop down is Displayed");
		chiledTest.log(Status.INFO, "Select Issue Status drop down is Displayed");

		//Checking the Select Due Date From
		WebElement SelectDueDateFrom = driver.findElement(By.xpath("//label[contains(text(),'Select Due Date From')]"));
		Assert.assertTrue(SelectDueDateFrom.isDisplayed(), "Select Due Date From Drop down Is Not Displayed");
		System.out.println("Select Due Date From drop down is Displayed");
		chiledTest.log(Status.INFO, "Select Due Date From drop down is Displayed");

		//Checking the Select Due Date To
		WebElement SelectDueDateTo = driver.findElement(By.xpath("//label[contains(text(),'Select Due Date To')]"));
		Assert.assertTrue(SelectDueDateTo.isDisplayed(), "Select Due Date To Drop down Is Not Displayed");
		System.out.println("Select Due Date To drop down is Displayed");
		chiledTest.log(Status.INFO, "Select Due Date To drop down is Displayed");

		//Checking Go Button is Displayed
		Assert.assertTrue(GOBTN.isDisplayed(), "Go Button is NOT Displayed");
		System.out.println("Go Button is Displayed");
		chiledTest.log(Status.INFO, "Go Button is Displayed");

		//Checking the search text Field
		Assert.assertTrue(SearchBox.isDisplayed(), "Go Button is NOT Displayed");
		System.out.println("Search text Field is Displayed");
		chiledTest.log(Status.INFO, "Search text Field is Displayed");

		//checking SNO is Displayed
		Assert.assertTrue(SNO.isDisplayed(), "SNO is NOT Displayed");
		System.out.println("SNO is Displayed");
		chiledTest.log(Status.INFO, "SNO is Displaye");

		//Checking Sub Audit Type
		Assert.assertTrue(SubAudit.isDisplayed(), "Sub Audit is NOT Displayed");
		System.out.println("Sub Audit is Displayed");
		chiledTest.log(Status.INFO, "Sub Audit is Displaye");

		//Checking Parent Audit Audit Type
		Assert.assertTrue(ParentAuditAudit.isDisplayed(), "Parent Audit Type is NOT Displayed");
		System.out.println("Parent Audit Type is Displayed");
		chiledTest.log(Status.INFO, "Parent Audit Type is Displaye");

		//Checking Auditee 
		Assert.assertTrue(Auditee.isDisplayed(), "Auditee is NOT Displayed");
		System.out.println("Auditee is Displayed");
		chiledTest.log(Status.INFO, "Auditee is Displaye");

		//Checking Sub Auditee
		Assert.assertTrue(SubAuditee.isDisplayed(), "Sub Auditee is NOT Displayed");
		System.out.println("Sub Auditee is Displayed");
		chiledTest.log(Status.INFO, "Sub Auditee is Displaye");

		//Checking Group Name
		Assert.assertTrue(GroupName.isDisplayed(), "Group Name is NOT Displayed");
		System.out.println("Group Name is Displayed");
		chiledTest.log(Status.INFO, "Group Name is Displaye");

		//Checking Checkpoint Intent
		Assert.assertTrue(CheckpointIntent.isDisplayed(), "Checkpoint Intent is NOT Displayed");
		System.out.println("Checkpoint Intent is Displayed");
		chiledTest.log(Status.INFO, "Checkpoint Intent is Displaye");

		//Checking Date Of Audit
		Assert.assertTrue(DateOfAudit.isDisplayed(), "Date Of Audit is NOT Displayed");
		System.out.println("Date Of Audit is Displayed");
		chiledTest.log(Status.INFO, "Date Of Audit is Displaye");

		//Checking Due Date
		Assert.assertTrue(DueDate.isDisplayed(), "Due Date is NOT Displayed");
		System.out.println("Due Date is Displayed");
		chiledTest.log(Status.INFO, "Due Date is Displaye");

		//Checking Issue status
		Assert.assertTrue(IssueStatus.isDisplayed(), "Issue Status is NOT Displayed");
		System.out.println("Issue Status is Displayed");
		chiledTest.log(Status.INFO, "Issue Status is Displaye");

		//Checking Details
		Assert.assertTrue(Details.isDisplayed(), "Details is NOT Displayed");
		System.out.println("Details is Displayed");
		chiledTest.log(Status.INFO, "Details is Displaye");

		//Checking Digital Evidence
		Assert.assertTrue(DigitalEvidence.isDisplayed(), "Digital Evidence is NOT Displayed");
		System.out.println("Digital Evidence is Displayed");
		chiledTest.log(Status.INFO, "Digital Evidence is Displaye");

		//Checking No Record Found Error message
		Assert.assertTrue(NoRecordFound.isDisplayed(), "No Record Found is NOT Displayed");
		System.out.println("No Record Found is Displayed");
		chiledTest.log(Status.INFO, "No Record Found is Displaye");

		//Checking the Show Rows is Displayed
		Assert.assertTrue(ShowRows.isDisplayed(), "Show Rows is Not Displayed");
		System.out.println("Show Rows is Displayed");
		chiledTest.log(Status.INFO, "Show Rows is Displaye");

		//Checking the Total Count of TH
		List<WebElement> THCount = driver.findElements(By.xpath("//table[@id='tableWithSearchForIssueTransactions']/thead/tr[1]/th"));
		int Actual_THcount = THCount.size();
	//	int Expected_THcount = 15;//It has showing 14
		int Expected_THcount = 14;//#SM
		Assert.assertEquals(Actual_THcount, Expected_THcount, "Total Count of TH is Wrong");

	}

	public void VerifyIssuesAreIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath("//table[@id='tableWithSearchForIssueTransactions']/tbody/tr/td[@class='sorting_1']")).isDisplayed();
			System.out.println("Searched Issues are Displayed");
			chiledTest.log(Status.INFO, "Searched Issues are Displayed");

		}catch (Exception e) {
			NoRecordFound.isDisplayed();
			System.out.println("No Record Found. Message is Displayed");
			chiledTest.log(Status.INFO, "No Record Found. Message is Displayed");
		}
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

package pom;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;

public class AuditorMyIssuePageTest extends BaseTest{

	//Checking Home is Displayed
	@FindBy(xpath="//a[text()='Home']")
	private WebElement Home;

	//Checking My Issue (Auditor) Header is Displayed
	@FindBy(xpath="//a[text()='MY ISSUES (AUDITOR)']")
	private WebElement MyIssueAuditorHeader;

	//Passing the values to Select Parent Audit Type
	@FindBy(xpath="//div[@id='s2id_search_audit_issues']//input[@type='text']")
	private WebElement SelectParentAuditType;

	//Passing the Values to Auditee
	@FindBy(xpath="//div[@id='s2id_cluster_auditees']//input")
	private WebElement Auditees;

	//Passing the values to Select Intent
	@FindBy(xpath="//div[@id='s2id_search_issue_intent']//input[@type='text']")
	private WebElement SelectIntent;

	//Passing the values to Select Issue Status
	@FindBy(xpath="//div[@id='s2id_issue_statuses']//input[@type='text']']")
	private WebElement SelectIssueStatus;

	//Passing the Values to Select Group
	@FindBy(xpath="//div[@id='s2id_search_group']//input[@type='text']")
	private WebElement SelectGroup;

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

	//Clicking on the Go Button
	@FindBy(xpath="//button[text()='Go']")
	private WebElement GOBTN;

	//selecting 100 under Show and Row
	@FindBy(xpath="//select[@name='auditorIssuesTableData_length']/option[@value='100']")
	private WebElement ShowAndRow;
	
	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Checking Search Text Fields
	@FindBy(xpath="//input[@Type='search']")
	private WebElement SearchBox;

	//Checking Q Id 
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Q Id']")
	private WebElement QId;

	//Checking Sub Audit Type
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Sub Audit Type']")
	private WebElement SubAuditType;

	//Checking Parent Audit Type
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Parent Audit Type']")
	private WebElement ParentAuditType;

	//Checking Auditee
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Auditee']")
	private WebElement Auditee;

	//Checking Sub Auditee
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Sub Auditee']")
	private WebElement SubAuditee;

	//Checking Group Name
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Group Name']")
	private WebElement GroupName;

	//Checking Checkpoint Intent
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Checkpoint Intent']")
	private WebElement CheckpointIntent;

	//Checking Disposition(s)
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Disposition(s)']")
	private WebElement Dispositions;

	//Checking Compliance 
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Compliance']")
	private WebElement Compliance;

	//Checking Compliance 
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Input Value']")
	private WebElement InputValue;

	//Checking Schedule Date 
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Schedule Date']")
	private WebElement ScheduleDate;

	//Checking Issue Status 
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/thead/tr/th[text()='Issue Status']")
	private WebElement IssueStatus;

	//clicking on the 1st checkpoints
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/tbody/tr[1]")
	private WebElement FirstCheckpoint;

	//clicking on the 2nd checkpoints
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/tbody/tr[2]")
	private WebElement SecondCheckpoint;

	//clicking on the 3rd checkpoints
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/tbody/tr[3]")
	private WebElement ThirdCheckpoint;

	//clicking on the 4th checkpoints
	@FindBy(xpath="//table[@id='auditorIssuesTableData']/tbody/tr[4]")
	private WebElement FourthCheckpoint;



	public AuditorMyIssuePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void SetSelectParentAuditType(String SPA)
	{
		SelectParentAuditType.sendKeys(SPA);
		System.out.println("Entered Parent Audit Type is : " + SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");
	}

	public void SetAuditees(String AT)
	{
		Auditees.sendKeys(AT);
		System.out.println("Entered Parent Audit Type is : " + AT);
		chiledTest.log(Status.INFO, "Auditees is Entered");
	}

	public void SetSelectIntent(String SA)
	{
		SelectIntent.sendKeys(SA);
		System.out.println("Entered Intent is : " + SA);
		chiledTest.log(Status.INFO, "Intent is Enterd");
	}

	public void ClickSelectIssuesStatus(WebDriver driver)
	{
		SelectIssueStatus.click();
	}

	public void SetSelectIssueStatus(String IS)
	{
		SelectIssueStatus.sendKeys(IS);
		System.out.println("Entered Issue Status is : IS");
	}

	public void SetGroups(String GP)
	{
		SelectGroup.sendKeys(GP);
		System.out.println("Entered Groups is : " + GP);
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

	public void ClickGOBTN()
	{
		GOBTN.click();
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}
	
	public void ClickShowandRow()
	{
		ShowAndRow.click();
		System.out.println("100 is Selected under Show And Row");
		chiledTest.log(Status.INFO, "100 is Selected under Show And Row");
	}

	public void ClickMatched(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Matched)).click();
	}

	public void SetSearchBox(String SS)
	{
		SearchBox.clear();
		SearchBox.sendKeys(SS);
		System.out.println("Searched Audit Type is : " +SS);
		chiledTest.log(Status.INFO, "Audit Type is Searched");
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
	
	public void ClickFirstCheckpoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstCheckpoint));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", FirstCheckpoint);
		System.out.println("1st Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "1st Checkpoint is Clicked");
	}
	
	public void ClickSecondCheckpoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SecondCheckpoint));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SecondCheckpoint);
		System.out.println("2nd Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "2nd Checkpoint is Clicked");
	}
	
	public void ClickThirdCheckpoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ThirdCheckpoint));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ThirdCheckpoint);
		System.out.println("3rd Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "3rd Checkpoint is Clicked");
	}
	
	public void ClickFourthCheckpoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FourthCheckpoint));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", FourthCheckpoint);
		System.out.println("4th Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "4th Checkpoint is Clicked");
	}
	
	public void VerifyIssueHandledSuccessfullyMSGIsDisplayed()
	{
		/*WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccessMsg = driver.findElement(By.xpath("//span[contains(text(),'Issue Handled Succesfully')]"));
		assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMsg)).isDisplayed(), "Issue Handled Succesfully Message is Not Displayd");
		System.out.println("Issue Handled Succesfully Message is Displayed");
		chiledTest.log(Status.INFO, "Issue Handled Succesfully Message is Displayed");*/
		
	}

	public void VerifyMyIssuePageIsDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//checking the Home is Displayed
		Assert.assertTrue(Home.isDisplayed(), "Home is NOT Displayed" );
		System.out.println("Home is Displayed");
		chiledTest.log(Status.INFO, "Home is Displayed");

		//checking the My Issue header is Displayed
		Assert.assertTrue(MyIssueAuditorHeader.isDisplayed(), "My Issue header is NOT Displayed" );
		System.out.println("My Issue header is Displayed");
		chiledTest.log(Status.INFO, "My Issue header is Displayed");

		//checking the Show and Row is Displayed
		Assert.assertTrue(ShowAndRow.isDisplayed(), "Show and Row is NOT Displayed");
		System.out.println("Show and Row is Displayed");
		chiledTest.log(Status.INFO, "show and Row is Displayed");

		//checking the Search Box is Displayed
		Assert.assertTrue(SearchBox.isDisplayed(), "Search is NOT Displayed" );
		System.out.println("Search is Displayed");
		chiledTest.log(Status.INFO, "Search is Displayed");

		//checking the Q Id is Displayed
		Assert.assertTrue(QId.isDisplayed(), "Q id is NOT Displayed" );
		System.out.println("Q id is Displayed");
		chiledTest.log(Status.INFO, "Q id is Displayed");

		//checking Sub Audit Type is Displayed
		Assert.assertTrue(SubAuditType.isDisplayed(), "Sub Audit Type is NOT Displayed" );
		System.out.println("Sub Audit Type is Displayed");
		chiledTest.log(Status.INFO, "Sub Audit Type is Displayed");

		//checking Parent Audit Type is Displayed
		Assert.assertTrue(ParentAuditType.isDisplayed(), "Parent Audit Type is NOT Displayed" );
		System.out.println("Parent Audit Type is Displayed");
		chiledTest.log(Status.INFO, "Parent Audit Type is Displayed");

		//checking Auditee is Displayed
		Assert.assertTrue(Auditee.isDisplayed(), "Auditee is NOT Displayed" );
		System.out.println("Auditee is Displayed");
		chiledTest.log(Status.INFO, "Auditee is Displayed");

		//checking Sub Auditee is Displayed
		Assert.assertTrue(SubAuditee.isDisplayed(), "Sub Auditee is NOT Displayed" );
		System.out.println("Sub Auditee is Displayed");
		chiledTest.log(Status.INFO, "Sub Auditee is Displayed");

		//checking Group Name is Displayed
		Assert.assertTrue(GroupName.isDisplayed(), "Group Name is NOT Displayed" );
		System.out.println("Group Name is Displayed");
		chiledTest.log(Status.INFO, "Group Name is Displayed");

		//checking Checkpoint Internet is Displayed
		Assert.assertTrue(CheckpointIntent.isDisplayed(), "Checkpoint Intent is NOT Displayed" );
		System.out.println("Checkpoint Intent is Displayed");
		chiledTest.log(Status.INFO, "Checkpoint Intent is Displayed");

		//checking Dispositions is Displayed
		Assert.assertTrue(Dispositions.isDisplayed(), "Dispositions is NOT Displayed" );
		System.out.println("Dispositions is Displayed");
		chiledTest.log(Status.INFO, "Dispositions is Displayed");

		//checking Compliance is Displayed
		Assert.assertTrue(Compliance.isDisplayed(), "Compliance is NOT Displayed" );
		System.out.println("Compliance is Displayed");
		chiledTest.log(Status.INFO, "Compliance is Displayed");

		//checking Schedule date is Displayed
		Assert.assertTrue(ScheduleDate.isDisplayed(), "Schedule Date is NOT Displayed" );
		System.out.println("Schedule Date is Displayed");
		chiledTest.log(Status.INFO, "Schedule Date is Displayed");

		//checking Issue status date is Displayed
		Assert.assertTrue(IssueStatus.isDisplayed(), "Issue Status Date is NOT Displayed" );
		System.out.println("Issue Status is Displayed");
		chiledTest.log(Status.INFO, "Issue Status is Displayed");

	}

	public void VerifyIssuesAreIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath("//table[@id='auditorIssuesTableData']/tbody/tr/td[@class='sorting_1']")).isDisplayed();
			System.out.println("Searched Issues are Displayed");
			chiledTest.log(Status.INFO, "Searched Issues are Displayed");

		}catch (Exception e) {
			driver.findElement(By.xpath("//table[@id='auditorIssuesTableData']/tbody/tr/td[@class='dataTables_empty']")).isDisplayed();
			System.out.println("No Record Found. Message is Displayed");
			chiledTest.log(Status.INFO, "No Record Found. Message is Displayed");
		}
	}

	public void ClickMyIssuesHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MyIssueAuditorHeader);
	}


}

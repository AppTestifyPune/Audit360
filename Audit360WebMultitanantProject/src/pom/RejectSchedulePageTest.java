package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;
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

public class RejectSchedulePageTest extends BaseTest{

	//Clicking on the Audit Schedule from side menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Reject Requests']")
	private WebElement RejectSchedule;

	//Passing the Values to Select Audit Type
	@FindBy(xpath="//div[@id='s2id_search_audit_type']//input[@type='text']")
	private WebElement AuditType;

	//Passing the Values to Select Auditee
	@FindBy(xpath="//div[@id='s2id_search_auditee']//input[@type='text']")
	private WebElement Auditee;

	//Passing the Vaoues to Select Auditor
	@FindBy(xpath="//div[@id='s2id_search_auditor']//input[@type='text']")
	private WebElement Auditor;

	//Clicking on the Select Schedule Status
	@FindBy(xpath="//div[@id='s2id_execution_status']//a/span[@class='select2-chosen']")
	private WebElement ScheduleStatus;

	//Passing the values to Select Schedule Status
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetScheduleStatus;

	//Passing the Values to Schedule date From
	@FindBy(xpath="//input[@id='start_date']")
	private WebElement DateFrom;

	//Passing the Values to Schedule date TO
	@FindBy(xpath="//input[@id='end_date']")
	private WebElement DateTO;

	//Clicking on the Accept Button
	@FindBy(xpath="//table[@id='rejectScheduleTableData']/tbody/tr[1]/td/a[contains(text(),'Accept')]")
	private WebElement AcceptBTN;

	//Clicking the Reject Button
	@FindBy(xpath="//table[@id='rejectScheduleTableData']/tbody/tr[1]/td/a[contains(text(),'Reject')]")
	private WebElement RejectBTN;

	//Clicking on the ok button
	@FindBy(xpath="//a[text()='OK']")
	private WebElement OKBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement CancelBTN;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[contains(@class,'select2-match')]")
	private WebElement Matched;


	public RejectSchedulePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickRejectSchedule(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RejectSchedule);
	}

	public void SetAuditType(String AT)
	{
		AuditType.sendKeys(AT);
		System.out.println("Selected Audit Type Is : " + AT);
	}

	public void SetAuditee(String AE)
	{
		Auditee.sendKeys(AE);
		System.out.println("Selected Audit Type Is : " + AE);
	}

	public void SetAuditor(String SA)
	{
		Auditor.sendKeys(SA);
		System.out.println("Selected Auditor is : " + SA);
	}

	public void ClickScheduleStatus()
	{
		ScheduleStatus.click();
	}

	public void SetSetScheduleStatus(String SS)
	{
		SetScheduleStatus.sendKeys(SS);
		System.out.println("Selected Auditor is : " + SS);
	}

	public void SetDateFrom(String SD)
	{
		DateFrom.sendKeys(SD);
		System.out.println("Selected Start Date is : " + SD);
		DateFrom.sendKeys(Keys.ESCAPE);
		System.out.println("Start date is Entered");
	}

	public void SetDateTO(String DT)
	{
		DateTO.sendKeys(DT);
		System.out.println("Selected Start Date is : " + DT);
		DateTO.sendKeys(Keys.ESCAPE);
		System.out.println("End date is Entered");
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void ClickAcceptButton() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(AcceptBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AcceptBTN);
		System.out.println("Accept Button is Clicked");
	}

	public void ClickRejectBTN() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(RejectBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RejectBTN);
		System.out.println("Reject Button is Clicked");
	}


	public void ClickOKButton(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(OKBTN)).click();
		System.out.println("Ok Button is Clicked");
	}

	public void ClickCancelButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CancelBTN)).click();
		System.out.println("Cancel Button is Clicked");

	}


	public void VerifyRejectdRequestsPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Request = driver.findElement(By.xpath("//h4[text()=' Rejected Requests ']"));
		wait.until(ExpectedConditions.visibilityOf(Request));
		if(Request.isDisplayed())
		{
			String Actual_Text = Request.getText();
			String Expected_Text = "Rejected Requests";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass :  Rejected Requests  Page Is Displayed");
		}

		//Checking the Pagination
		WebElement Pagination = driver.findElement(By.xpath("//select[@class='form-control']"));
		if(Pagination.isDisplayed())
		{
			List<WebElement> Options = driver.findElements(By.xpath("//select[@class='form-control']/option"));
			int count = Options.size();
			int Actual_count = count;
			int Expected_count = 6;
			Assert.assertEquals(Actual_count, Expected_count);
		}

		//Checking the Show
		WebElement Show = driver.findElement(By.xpath("//label[text()='Show ']"));
		if(Show.isDisplayed())
		{
			Assert.assertTrue(true);
		}

		//Checking the Data in the table
		WebElement data = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/tbody/tr"));
		if(data.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Rejected Requests List are Displayed");
		}

		//Checking the Serial Number 
		WebElement SLNO = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[1]"));
		if(SLNO.isDisplayed())
		{
			String Actual_Text = SLNO.getText();
			String Expected_Text = "SCHEDULE ID";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : SCHEDULE ID is Displayed");
		}

		//Checking the Auditor Name
		WebElement AN = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[2]"));
		if(AN.isDisplayed())
		{
			String Actual_Text = AN.getText();
			String Expected_Text = "AUDITOR NAME";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Auditor Name is Displayed");
		}

		//Checking the Audit Type
		WebElement Audittype = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[3]"));
		if(Audittype.isDisplayed())
		{
			String Actual_Text = Audittype.getText();
			String Expected_Text = "AUDIT TYPE";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Audit Type is Displayed");
		}

		//Checking the Auditee
		WebElement Auditee = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[4]"));
		if(Auditee.isDisplayed())
		{
			String Actual_Text = Auditee.getText();
			String Expected_Text = "AUDITEE";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Auditee is Displayed");
		}

		//Checking the Date-Time
		WebElement DateTime = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[5]"));
		if(DateTime.isDisplayed())
		{
			String Actual_Text = DateTime.getText();
			String Expected_Text = "DATE-TIME";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Date-Time is Displayed");
		}

		//Checking the Execution status
		WebElement ExecutionStatus = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[6]"));
		if(ExecutionStatus.isDisplayed())
		{
			String Actual_Text = ExecutionStatus.getText();
			String Expected_Text = "EXECUTION STATUS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Execution Status is Displayed");
		}

		//Checking the Schedule Status
		WebElement ScheduleStatus = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[7]"));
		if(ScheduleStatus.isDisplayed())
		{
			String Actual_Text = ScheduleStatus.getText();
			String Expected_Text = "SCHEDULE STATUS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Schedule Status is Displayed");
		}


		//Checking the Reason
		WebElement Reason = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[8]"));
		if(Reason.isDisplayed())
		{
			String Actual_Text = Reason.getText();
			String Expected_Text = "REASON";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Reason is Displayed");
		}

		//checking the Actions
		WebElement Actions = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/thead/tr/th[9]"));
		if(Actions.isDisplayed())
		{
			String Actual_Text = Actions.getText();
			String Expected_Text = "ACTIONS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Actions is Displayed");
		}

		System.out.println("Pass : Reject Requests Page is Displayed");

	}

	public void VerifyDoYouWantToAcceptThisRequestPopUpIsDisplayed(WebDriver driver)
	{
		WebElement RejectPOPUp = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to ACCEPT this request ?')]"));
		Assert.assertTrue(RejectPOPUp.isDisplayed(), "Are you sure you want to reject this request Pop Up is Displayed");
		System.out.println("Are you sure you want to reject this request Pop Up is Not Displayed");
		chiledTest.log(Status.INFO, "Are you sure you want to reject this request Pop Up is Not Displayed");
	}

	public void VerifyDoYouWantToRejectThisRequestPopUpIsDisplayed(WebDriver driver)
	{
		WebElement RejectPOPUp = driver.findElement(By.xpath("//p[contains(text(),'Do you want to reject this request?')]"));
		Assert.assertTrue(RejectPOPUp.isDisplayed(), "Do you want to reject this request Pop Up is Displayed");
		System.out.println("Do you want to reject this request Pop Up is Not Displayed");
		chiledTest.log(Status.INFO, "Do you want to reject this request Pop Up is Not Displayed");
	}

	public void VerifyRequestIsProcessedsuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement RIPS = driver.findElement(By.xpath("//span[text()='Request is processed successfully.']"));
		if(wait.until(ExpectedConditions.visibilityOf(RIPS)).isDisplayed())
		{
			String Actual_text = RIPS.getText();
			String Expcted_text = "Request is processed successfully.";
			Assert.assertEquals(Actual_text, Expcted_text);
			System.out.println("Pass : Request is processed successfully. Message is Displayed");

			//Clicking on the Close button
			driver.findElement(By.xpath("//button[@class='close']")).click();
		}
	}
	
	public void VerifyingRejectedAuditsAreDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement Data = driver.findElement(By.xpath("//tr[@class='odd' or @class='even']"));
			Assert.assertTrue(Data.isDisplayed());
				System.out.println("Audit Type is Displayed");
				chiledTest.log(Status.INFO, "Searched Audit Type is Displayed");
		}catch (Exception e) {
			WebElement NoDataFound = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
			Assert.assertTrue(NoDataFound.isDisplayed());
				System.out.println("No data available in table Error Message is Displayed");
				chiledTest.log(Status.INFO, "No data available in table Error Message is Displayed");
			}
	}
	
	
	public void ClickCloseButton()
	{
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement All = CloseBTN.get(i);
			All.click();
		}
	}
	
}

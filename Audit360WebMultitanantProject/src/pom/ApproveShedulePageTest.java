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

public class ApproveShedulePageTest extends BaseTest{
	
	//Clicking on the Audit Schedule from side menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Edit Requests']")
	private WebElement EditRequests;

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
	@FindBy(xpath="//a[contains(text(),'Accept')]")
	private WebElement AcceptBTN;

	//Clicking the Reject Button
	@FindBy(xpath="//a[contains(text(),'Reject')]")
	private WebElement RejectBTN;

	//Clicking on the ok button
	@FindBy(xpath="//div[@class='modal disable-scroll stick-up in']//a[@class='btn btn-primary btn-block m-t-5 confirm'][contains(text(),'OK')]")
	private WebElement OKBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//div[@class='modal disable-scroll stick-up in']//a[@class='btn btn-default btn-block m-t-5 cancel'][contains(text(),'Cancel')]")
	private WebElement CancelBTN;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the First TR
	@FindBy(xpath="//table[@id='acceptedScheduleTableData']/tbody/tr[1]")
	private WebElement FirstTR;


	public ApproveShedulePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickApproveSchedule(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EditRequests);
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
	}

	public void SetDateTO(String DT)
	{
		DateTO.sendKeys(DT);
		System.out.println("Selected Start Date is : " + DT);
		DateTO.sendKeys(Keys.ESCAPE);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void ClickAcceptButton() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(AcceptBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AcceptBTN);
		System.out.println("Accept Button is Clicked");
	}

	public void ClickRejectBTN() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(RejectBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RejectBTN);
		System.out.println("Reject Button is Clicked");
	}

	public void ClickFirstTR() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(FirstTR)).click();
	}

	public void ClickOKButton(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(OKBTN)).click();
		System.out.println("Ok Button is Clicked");

	}

	public void ClickCancelButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CancelBTN)).click();
		System.out.println("Cancel Button is Clicked");

	}

	public void VerifyApproveRequestPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Home = driver.findElement(By.xpath("//a[@class='active']"));
		wait.until(ExpectedConditions.visibilityOf(Home));
		if(Home.isDisplayed())
		{
			String Actual_Text = Home.getText();
			String Expected_Text = "HOME";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Home is Displayed");
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
		WebElement data = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/tbody/tr"));
		if(data.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Rejected Requests List are Displayed");
		}

		//Checking the Serial Number 
		WebElement SLNO = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[1]"));
		if(SLNO.isDisplayed())
		{
			String Actual_Text = SLNO.getText();
			String Expected_Text = "SCHEDULE ID";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : SCHEDULE ID is Displayed");
		}

		//Checking the Audit Type
		WebElement Audittype = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[2]"));
		if(Audittype.isDisplayed())
		{
			String Actual_Text = Audittype.getText();
			String Expected_Text = "AUDIT TYPE";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Audit Type is Displayed");
		}

		//Checking the Auditee
		WebElement Auditee = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[3]"));
		if(Auditee.isDisplayed())
		{
			String Actual_Text = Auditee.getText();
			String Expected_Text = "AUDITEE";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Auditee is Displayed");
		}

		//Checking the Auditor Name
		WebElement AN = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[4]"));
		if(AN.isDisplayed())
		{
			String Actual_Text = AN.getText();
			String Expected_Text = "AUDITOR";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Auditor Name is Displayed");
		}

		//Checking the From Date-Time
		WebElement DateTime = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[5]"));
		if(DateTime.isDisplayed())
		{
			String Actual_Text = DateTime.getText();
			String Expected_Text = "FROM DATE & TIME";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Date-Time is Displayed");
		}

		//Checking the To Date-Time
		WebElement ToDateTime = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[6]"));
		if(ToDateTime.isDisplayed())
		{
			String Actual_Text = ToDateTime.getText();
			String Expected_Text = "TO DATE & TIME";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Date-Time is Displayed");
		}

		//Checking the Execution status
		WebElement ExecutionStatus = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[7]"));
		if(ExecutionStatus.isDisplayed())
		{
			String Actual_Text = ExecutionStatus.getText();
			String Expected_Text = "EXECUTION STATUS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Execution Status is Displayed");
		}

		//Checking the Schedule Status
		WebElement ScheduleStatus = driver.findElement(By.xpath("//table[@id='acceptedScheduleTableData']/thead/tr/th[8]"));
		if(ScheduleStatus.isDisplayed())
		{
			String Actual_Text = ScheduleStatus.getText();
			String Expected_Text = "SCHEDULE STATUS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Schedule Status is Displayed");
		}

		System.out.println("Pass : Re-Assign Requests Page is Displayed");

	}

	public void VerifyApproveRejectAuditScheduleChangesIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Approve/Reject Audit Schedule Changes is Displaying or not
		WebElement ARASC = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h5[1]"));
		if(wait.until(ExpectedConditions.visibilityOf(ARASC)).isDisplayed())
		{
			String Actual_ARASC = ARASC.getText();
			String Expected_ARASC = "Approve/Reject Audit Schedule Changes";
			Assert.assertEquals(Actual_ARASC, Expected_ARASC);
			System.out.println("Pass : Approve/Reject Audit Schedule Changes is Displayed");

		}

		//Checking the Audit Type
		WebElement AuditType = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[1]"));
		if(AuditType.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Audit Type is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[1]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the Actual Audit Schedule Details
		WebElement AASD = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h5[2]"));
		if(AASD.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Actual Audit Schedule Details is Displayed");
		}

		//Checking the Auditee Type
		WebElement AuditeeType = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[2]"));
		if(AuditeeType.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Auditee Type is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[2]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the Auditee 
		WebElement Auditee = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[3]"));
		if(Auditee.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Auditee is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[3]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the Start Date time 
		WebElement SDT = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[4]"));
		if(SDT.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Start Date time is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[4]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the end Date time 
		WebElement EDT = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[5]"));
		if(EDT.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : End Date Time is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[5]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the Updated Audit Schedule Details
		WebElement UASD = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h5[3]"));
		if(UASD.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Updated Audit Schedule Details is Displayed");
		}

		//Checking the Auditee type
		WebElement AET = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[6]"));
		if(AET.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Auditee Type is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[6]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the Auditee 
		WebElement Auditee1 = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[7]"));
		if(Auditee1.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Auditee is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[7]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the Start Date time 
		WebElement SDT1 = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[8]"));
		if(SDT1.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Start Date Time is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[8]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//Checking the end Date time 
		WebElement EDT1 = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[9]"));
		if(EDT1.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : End Date Time is Displayed");

			List<WebElement> list = driver.findElements(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/div[9]/input"));
			Assert.assertTrue(list.size() > 0);
		}

		//checking the cancel Button
		WebElement CancelButton = driver.findElement(By.xpath("//i[@class='pg-close fs-14']"));
		if(CancelButton.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Close Button is Displayed");
		}

	}

	public void VerifyScheduleUpdatedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//span[text()='Schedule Updated Successfully']"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Schedule Updated Successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Schedule Updated Successfully Success Message is Displayed");

			//clicking on the close button
			driver.findElement(By.xpath("//button[@class='close']")).click();
		}

	}
	public void VerifyScheduleUpdatedRejectedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement RejectedSuccessMSG = driver.findElement(By.xpath("//span[text()='Schedule update request rejected  Successfully']"));
		if(wait.until(ExpectedConditions.visibilityOf(RejectedSuccessMSG)).isDisplayed())
		{
			String Actual_Text = RejectedSuccessMSG.getText();
			String Expected_Text = "Schedule update request rejected Successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Schedule update request rejected Successfully Success Message is Displayed");

			//clicking on the close button
			driver.findElement(By.xpath("//button[@class='close']")).click();
		}
	}

	public void VerifyingAuditsAreDisplayed(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement Data = driver.findElement(By.xpath("//tr[@class='odd' or @class='even']"));
			Assert.assertTrue(Data.isDisplayed(), "Audit Type are Displayed");
				System.out.println("Audit Type is Displayed");
				chiledTest.log(Status.INFO, "Searched Audit Type is Displayed");
		}catch (Exception e) {
			WebElement NoDataFound = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
			Assert.assertTrue(NoDataFound.isDisplayed(), "No data available in table Error Message is Displayed");
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
	
	public void VerfiyDoYouWantToRejectThisRequestPopUpIsDisplayed()
	{
		WebElement RejectPOPUp = driver.findElement(By.xpath("//p[contains(text(),'Do you want to reject this request?')]"));
		Assert.assertTrue(RejectPOPUp.isDisplayed(), "Do you want to reject this request Pop Up is Displayed");
		System.out.println("Do you want to reject this request Pop Up is Not Displayed");
		chiledTest.log(Status.INFO, "Do you want to reject this request Pop Up is Not Displayed");
	}
	
	public void VerfiyDoYouWantToAcceptThisRequestPopUpIsDisplayed()
	{
		WebElement RejectPOPUp = driver.findElement(By.xpath("//p[contains(text(),'Do you want to accept this request?')]"));
		Assert.assertTrue(RejectPOPUp.isDisplayed(), "Do you want to reject this request Pop Up is Displayed");
		System.out.println("Do you want to reject this request Pop Up is Not Displayed");
		chiledTest.log(Status.INFO, "Do you want to reject this request Pop Up is Not Displayed");
	}
}

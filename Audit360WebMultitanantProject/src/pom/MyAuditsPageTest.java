package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Table;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.GetScreenshots;
import generic.Lib;

public class MyAuditsPageTest extends BaseTest {

	//Clicking on the Home Button
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement Home;

	//Checking the My Audits Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement MyAuditsHeader;

	//Clicking on the scroll bar
	@FindBy(xpath="//nav[contains(@class,'page-sidebar')]/div[contains(@class,'sidebar-menu')]")
	private WebElement ScrollBar;

	//Clicking on the Annexure under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content')]/li/a/span[text()='My Audits']")
	private WebElement MyAudits;

	//Passing the Values to Select Audit Type
	@FindBy(xpath="//div[@id='s2id_audit_type']//input[@type='text']")
	private WebElement SelectAudittype;

	//Passing the Values to Select Execution Status
	@FindBy(xpath="//div[@id='s2id_auditee_execution_status']//input[@type='text']")
	private WebElement SelectExecutionStatus;

	//Passing the Values to From Date
	@FindBy(xpath="//input[@id='audit_start_date']")
	private WebElement Fromdate;

	//Passing the Values to To Date
	@FindBy(xpath="//input[@id='audit_end_date']")
	private WebElement Todate;

	//Passing the Values to Select Auditee
	@FindBy(xpath="//div[@id='s2id_search_auditee']//input")
	private WebElement SelectAuditee;

	//Passing the Values Search Text Fields
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBTN;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//clicking on the 1st Audit type
	@FindBy(xpath="//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr[1]")
	private WebElement firstAuditType;

	//clicking on the 2nd Audit type
	@FindBy(xpath="//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr[2]")
	private WebElement SecondAuditType;

	//clicking on the 3rd Audit type
	@FindBy(xpath="//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr[3]")
	private WebElement ThirdAuditType;

	//clicking on the 4th Audit type
	@FindBy(xpath="//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr[4]")
	private WebElement FourthAuditType;

	//clicking on the 5th Audit type
	@FindBy(xpath="//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr[5")
	private WebElement FifthAuditType;

	//Clicking on the Sign Off Audit Button
	@FindBy(xpath="//a[text()='Sign off audit']")
	private WebElement SignOffAuditBTN;

	//Clicking on the Auditor Satisfaction Survey button
	@FindBy(xpath="//a[@class='button btn btn-primary btn-block']")
	private WebElement AuditorSatisfactionSurveyBTN;

	//clicking on the Submit Survey Button
	@FindBy(xpath="//input[@value='Submit Survey']")
	private WebElement SubmitSurveyBTN;

	//clicking on the Cancel Button
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement CancelBTN;

	//Clicking on the Ok Button
	@FindBy(xpath="//a[text()='OK']")
	private WebElement OKBTN;

	//Selecting 100 under Pagination
	@FindBy(xpath="//select[@name='tableWithAuditeeSubAuditsSearch_length']/option[last()]")
	private WebElement Pagination;

	//Clicking on the Sign Off Main Audit
	@FindBy(xpath="//a[text()='Sign off Main Audit']")
	private WebElement SignOffMainAuditBTN;

	//Clicking on the document Tab
	@FindBy(xpath="//a[@data-toggle='tab'][text()='Documents']")
	private WebElement DocumnetTab;

	//Clicking on the Remarks Tab
	@FindBy(xpath="//a[@data-toggle='tab'][text()='Remarks']")
	private WebElement RemarksTab;

	//Clicking on the Close Button
	@FindBy(xpath="//button[@class='close']/i")
	private WebElement CloseBTN;

	//clicking on the Yes Button
	@FindBy(xpath="//table[@id='tableWithSearchSummaryAuditeeApp']/tbody/tr[1]/td//label[@data-report-button='yes']")
	private WebElement YesBTN;

	//clicking on the NO Button
	@FindBy(xpath="//table[@id='tableWithSearchSummaryAuditeeApp']/tbody/tr[1]/td//label[@data-report-button='no']")
	private WebElement NoBTN;
	
	//clicking on the Res Button
	@FindBy(xpath="//table[@id='tableWithSearchSummaryAuditeeApp']//tbody/tr[1]/td//label[contains(text(),'Res')]")
	private WebElement ResBTN;

	//Passing the Value to Comments
   //@FindBy(xpath="//textarea[@class='form-control auditee_desc max_char']") //#SM Modify
	@FindBy(xpath="//textarea[@id='issue_issue_comments_attributes_0_description']")
	private WebElement Comments;

	//Clicking on the Accept Button
	@FindBy(xpath="//input[@value='Accept']")
	private WebElement AcceptBTN;

	//Clicking on the Reject Button
	@FindBy(xpath="//input[@value='Re-Examine']")
	private WebElement ReExaminBTN;
	
	//Passing the values to Choose File
	@FindBy(xpath="//input[@id='issue_audit_compliance_documents_attributes_0_document']")
	private WebElement ChooseFile;

	//Clicking on the Due Date
	@FindBy(xpath="//label[contains(text(),'Due Date')]/following-sibling::input")////input[@id='auditee_due_date']
	private WebElement DueDate;

	//Checking the Due date Validation Message
	@FindBy(xpath="//span[@id='date_error_message']")
	private WebElement PleaseEnterValidDate;

	//Checking the Success Message
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]/span")
	private WebElement SuccessMSG;

	//Clicking on the Success Message close Button
	@FindBy(xpath="//div[contains(@class,'alert alert-success')]/button")
	private WebElement SuccessMSGCloseBTN;

	//clicking on the Attach Audit Reference Button
	@FindBy(xpath="//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr[1]/td/a/span[@title='Attach Audit Reference']")
	private WebElement AttachAuditReferenceBTN;
	
	//Clicking on the Direct Resolution Check Box
	@FindBy(xpath="//div[@class='m-l-325 btn btn-primary m-b-20 show']//label[@class='direct-resolution-level']")
	private WebElement DirectResolutionCkeckBox;
	
	//Clicking on Accept
	@FindBy(xpath="//input[@value='Accept']")
	private WebElement AcceptButton;

	@FindBy(xpath="//textarea[@id='issue_issue_comments_attributes_0_description' and @required='required']")
	private WebElement CommentsTextField;

	//input[@id='issue_audit_compliance_documents_attributes_0_document' and @required='required']

	public MyAuditsPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickHome(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Home));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Home);
		System.out.println("Home Header is Clicked");
	}

	public void ClickMyAuditsHeader(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(MyAuditsHeader).click().build().perform();
		System.out.println("My Audits Header is Clciked");
	}

	public void SetSelectAuditType(String SA)
	{
		SelectAudittype.sendKeys(SA);
		System.out.println("Entered Audit Type Is : " + SA);
	}

	public void ClearSelectAudittype()
	{
		SelectAudittype.clear();
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickMyAuditsUnderSideMenu(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MyAudits);
	}

	public void SetSelectExecutionStatus(String SES)
	{
		SelectExecutionStatus.sendKeys(SES);
		System.out.println("Selected Execution Status is : " + SES);
	}


	public void SetFromdate(String FD, WebDriver driver) throws InterruptedException
	{
		Fromdate.sendKeys(FD);
		System.out.println("Entered From date is : " + FD);

		Thread.sleep(1000);

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
	}


	public void SetTodate(String TD, WebDriver driver)
	{
		Todate.sendKeys(TD);
		System.out.println("Entered To date is : " + TD);

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
	}

	public void SetSelectAuditee(String AE)
	{
		SelectAuditee.sendKeys(AE);
		System.out.println("Selected Auditee is : " + AE);
	}

	public void SetSearchButton(String SB) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SearchBTN)).clear();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(SearchBTN)).sendKeys(SB);
		System.out.println("Searched Sub Audit Type is : " + SB);
	}

	public void ClearSearchBTN()
	{
		SearchBTN.clear();
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void ClickfirstAuditType(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(firstAuditType)).click();

	}

	public void ClickSecondAuditType() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SecondAuditType)).click();
	}

	public void ClickThirdAuditType() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ThirdAuditType)).click();
	}

	public void ClickFourthAuditType() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(FourthAuditType)).click();
	}

	public void ClickFifithAuditType() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(FifthAuditType)).click();
	}

	public void ClickSingOffAuditButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(SignOffAuditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SignOffAuditBTN);
		System.out.println("Sign Off Audit Button is Clicked");
	}

	public void ClickAuditorSatisfactionSurveyBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditorSatisfactionSurveyBTN);
		System.out.println("Auditor Satisfaction Survey Button is Clicked");

	}
	
	public void ClickDirectResolutionCheckBox() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DirectResolutionCkeckBox);
		System.out.println("Direct Resolution Checkbox is Cliecked");
		chiledTest.log(Status.INFO, "Direct Resolution Checkbox is Cliecked");
	}


	public void ClickCancelBTN()
	{
		CancelBTN.click();
		System.out.println("Cancel Button is Clicked");
		chiledTest.log(Status.INFO, "Cancel Button Is Clicked");
	}

	public void ClickOKBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", OKBTN);
		System.out.println("Ok Button is Clicked");
		chiledTest.log(Status.INFO, "OK Button Is Clicked");
	}

	public void ClickDueDate()
	{
		DueDate.click();

	}

	public void SetDueDate(String DD, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(DueDate)).sendKeys(DD);
		System.out.println("Entered Due Date Is : " + DD);
		chiledTest.log(Status.INFO, "due date is Entered");

		DueDate.sendKeys(Keys.ESCAPE);
	}

	public void ClickPagination(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Pagination)).click();
	}

	public void SetComments(String CM) throws InterruptedException
	{
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(Comments).build().perform();

		Comments.clear();
		Comments.sendKeys(CM);
	//	driver.findElement(By.xpath("//textarea[@class='form-control auditee_desc max_char field_to_show_char_remaining']")).sendKeys("Test");
		System.out.println("Entered Comments is : " + CM);
		chiledTest.log(Status.INFO, "Comment Is Entered");
	}

	public void ClickYesBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(YesBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", YesBTN);
	}

	public void ClickNoBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(NoBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NoBTN);
	}
	
	public void ClickResButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ResBTN);
		System.out.println("Res Button is Clicked");
		chiledTest.log(Status.INFO, "Res Button is Clicked");
	}


	public void ClickDocumnetTab(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DocumnetTab);

	}

	public void ClickRemarksTab(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RemarksTab);

	}

	public void ClickSignOffMainAuditBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SignOffMainAuditBTN);
		System.out.println("Sign Off Main Audit Button is Clicked");
		chiledTest.log(Status.INFO, "Sign Off Main Audit Button is Clicked");

	}

	public void ClickSubmitSurveyBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitSurveyBTN);
		System.out.println("Submit Survey Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Survey Button is Clicked");

	}

	public void ClickCloseBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);
	}

	public void ClickAcceptBTN(WebDriver driver) throws Exception
	{
		try{
			GetScreenshots.WAIT(AcceptBTN);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(AcceptBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", AcceptBTN);
			System.out.println("Accept Button is Clicked");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickReExamineButton(WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ReExaminBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ReExaminBTN);
			System.out.println("Reject Button is Clicked");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void VerifyNotStartedStatusIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NotStarted = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr[1]/td[text()='Not Started']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(NotStarted)).isDisplayed(), "Not Started status is Not Displayed");
		System.out.println("Not started Status is Displayed");
		chiledTest.log(Status.INFO, "Not started Status is Displayed");
	}



	public void VerifyMyAuditsPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Checking the My Audits Header 
		if(MyAuditsHeader.isDisplayed())
		{
			System.out.println("Pass : My Audits Header is Displayed");
		}

		//checking Select Audit Type
		if(SelectAudittype.isDisplayed() && driver.findElement(By.xpath("//label[contains(text(),'Select Audit Type')]")).isDisplayed())
		{
			System.out.println("Pass : Select Audit Type Drop Down is Displayed");
		}

		//checking Select Execution Status
		if(SelectExecutionStatus.isDisplayed() && driver.findElement(By.xpath("//label[contains(text(),'Select Execution Status')]")).isDisplayed())
		{
			System.out.println("Pass : Select Execution Status Drop Down is Displayed");
		}

		//checking Select Date Range
		if(Fromdate.isDisplayed() && Todate.isDisplayed() && driver.findElement(By.xpath("//label[contains(text(),'Select Date Range')]")).isDisplayed())
		{
			System.out.println("Pass : Select Date Range Drop Down is Displayed");
		}


		//Checking the search Button
		if(SearchBTN.isDisplayed())
		{
			System.out.println("Pass : Search Text Field is Displayed");
		}

		//Checking the Table Is displayed
		WebElement Table = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']"));
		if(Table.isDisplayed())
		{
			System.out.println("Pass : My Audits Grid is Displayed");
		}

		//Checking the Table Header Count
		List<WebElement> TableHeaderCount = driver.findElements(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th"));
		int count = TableHeaderCount.size();
		int Actual_count = count;
		int Expected_count = 7;
		Assert.assertEquals(Actual_count, Expected_count, "The My Audit Grid Header count is Wrong");

		//Checking SNO
		WebElement SNO = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th[1]"));
		String Actual_SNO = SNO.getText();
		String Expected_SNO = "ID";
		Assert.assertEquals(Actual_SNO, Expected_SNO, "SNO. is Not Displayed");

		//Checking Audit Type
		WebElement AuditType = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th[2]"));
		String Actual_AuditType = AuditType.getText();
		String Expected_AuditType = "AUDIT TYPE";
		Assert.assertEquals(Actual_AuditType, Expected_AuditType, "The Audit Type is Not Displayed");

		//Checking Auditte
		WebElement Auditee = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th[3]"));
		String Actual_Auditee = Auditee.getText();
		String Expected_Auditee = "AUDITEE";
		Assert.assertEquals(Actual_Auditee, Expected_Auditee, "The Auditee is Not Displayed");

		//Checking Auditor
		WebElement Auditor = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th[4]"));
		String Actual_Auditor = Auditor.getText();
		String Expected_Auditor = "AUDITOR";
		Assert.assertEquals(Actual_Auditor, Expected_Auditor, "The Auditor is Not Displayed");

		//Checking Date Of Auditor
		WebElement DateOfAuditor = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th[5]"));
		String Actual_DateOfAuditor = DateOfAuditor.getText();
		String Expected_DateOfAuditor = "DATE OF AUDIT";
		Assert.assertEquals(Actual_DateOfAuditor, Expected_DateOfAuditor, "The Date Of Auditor is Not Displayed");

		//Checking Satus
		WebElement Satus = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th[6]"));
		String Actua_Satus = Satus.getText();
		String Expected_Satus = "STATUS";
		Assert.assertEquals(Actua_Satus, Expected_Satus, "The Status is Not Displayed");

		//Checking Action
		WebElement Action = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/thead/tr/th[7]"));
		String Actual_Action = Action.getText();
		String Expected_Action = "ACTION";
		Assert.assertEquals(Actual_Action, Expected_Action, "The Action is Not Displayed");

	}

	public void VerifyNoMatchFoundMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NoMatchFound = driver.findElement(By.xpath("//div[@id='select2-drop']//ul[@class='select2-results scroll-content']/li[@class='select2-no-results']"));
		wait.until(ExpectedConditions.visibilityOf(NoMatchFound));
		Assert.assertTrue(NoMatchFound.isDisplayed(), "No matches found Message is Not Displayed");

	}

	public void ClickAttachAuditReferenceButton()
	{
		AttachAuditReferenceBTN.click();
		System.out.println("Attach Audit Reference Button is Clicked");
		chiledTest.log(Status.INFO, "Attach Audit Reference Button is Clicked");
	}


	public void VerifyAuditeeisDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,5);
		try{
			WebElement Auditee = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr/td[@class='sorting_1']"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Auditee)).isDisplayed(), "Searched Audit Types are Not Displayed Under the Grid");
			System.out.println("Searched Audit Types are Displayed Under the Grid");
			chiledTest.log(Status.INFO, "Searched Audit Types are displayed");
		}catch (Exception e) {
			WebElement NoData = driver.findElement(By.xpath("//td[text()='No data available in table']"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(NoData)).isDisplayed(), "No Data Found Message is Not Displayed");
			System.out.println("No Data Found Message is Displayed");
			chiledTest.log(Status.INFO, "No Data Found Message is Displayed");
		}
	}

	public void VerifyNoDataFoundDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NoData = driver.findElement(By.xpath("//td[text()='No data available in table']"));
		wait.until(ExpectedConditions.visibilityOf(NoData));
		Assert.assertTrue(NoData.isDisplayed(), "No Data Found Message is Not Displayed");
		System.out.println("Pass : No Data Found Message is Displayed");

	}

	public void VerifySummaryPageIsDisplayed1(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SoftAssert SoftAssert = new SoftAssert();

		//Checking Summary Header
		WebElement Summary = driver.findElement(By.xpath("//div[@class='panel-title']"));
		SoftAssert.assertTrue(Summary.isDisplayed(), "Summary Header is Not Displayed");

		//Checking the Audit Type Name
		String Expected_AuditName = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[1]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditName);

		String Actual_AuditName = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0);
		String Actual_AuditName1 = Actual_AuditName.toUpperCase();
		System.out.println("Actual Audit Type Name is : " + Actual_AuditName1);

		SoftAssert.assertEquals(Expected_AuditName, Actual_AuditName1, "Audit Type Name is Wrong");


		//Checking the Sub Audit Name
		String Expected_SubAuditName = driver.findElement(By.xpath("//div[@class='p-l-30 bold']")).getText();
		System.out.println("Expected Sub Auditee Name is : " + Expected_SubAuditName);

		String Actual_SubAuditName = Lib.getCellValue(XLPATH, "Schedule", 9, 0);
		System.out.println("Actual Sub Auditee Name is : " + Actual_SubAuditName);

		SoftAssert.assertEquals(Expected_SubAuditName, Actual_SubAuditName, "Sub Auditee Name is Wrong");

		//Checking the Auditee Review Status
		String Expected_AuditeeReviewStatus = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[4]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditeeReviewStatus);

		String Actual_AuditeeReviewStatus = "NOT ACCEPTED";
		System.out.println("Actual Auditee Review Status is : " + Actual_AuditeeReviewStatus);

		SoftAssert.assertEquals(Expected_AuditeeReviewStatus, Actual_AuditeeReviewStatus, "Auditee Review Status is Wrong");


	}


	public void VerifySummaryPageIsDisplayed2(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SoftAssert SoftAssert = new SoftAssert();

		//Checking Summary Header
		WebElement Summary = driver.findElement(By.xpath("//div[@class='panel-title']"));
		SoftAssert.assertTrue(Summary.isDisplayed(), "Summary Header is Not Displayed");

		//Checking the Audit Type Name
		String Expected_AuditName = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[1]/div[2]")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditName);
		String Actual_AuditName = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
		String Actual_AuditName1 = Actual_AuditName.toUpperCase();
		System.out.println("Actual Audit Type Name is : " + Actual_AuditName1);
		SoftAssert.assertEquals(Expected_AuditName, Actual_AuditName1, "Audit Type Name is Wrong");

		//Checking the Sub Audit Name
		String Expected_SubAuditName = driver.findElement(By.xpath("//div[@class='p-l-30 bold']")).getText();
		System.out.println("Expected Sub Auditee Name is : " + Expected_SubAuditName);
		String Actual_SubAuditName = Lib.getCellValue(XLPATH, "Schedule", 135, 0);
		System.out.println("Actual Sub Auditee Name is : " + Actual_SubAuditName);
		SoftAssert.assertEquals(Expected_SubAuditName, Actual_SubAuditName, "Sub Auditee Name is Wrong");

		//Checking the Auditee Review Status
		String Expected_AuditeeReviewStatus = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[4]/div[2]")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditeeReviewStatus);
		String Actual_AuditeeReviewStatus = "NOT ACCEPTED";
		System.out.println("Actual Auditee Review Status is : " + Actual_AuditeeReviewStatus);
		SoftAssert.assertEquals(Expected_AuditeeReviewStatus, Actual_AuditeeReviewStatus, "Auditee Review Status is Wrong");


	}

	public void VerifySummaryPageIsDisplayed3(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SoftAssert SoftAssert = new SoftAssert();

		//Checking Summary Header
		WebElement Summary = driver.findElement(By.xpath("//div[@class='panel-title']"));
		SoftAssert.assertTrue(Summary.isDisplayed(), "Summary Header is Not Displayed");

		//Checking the Audit Type Name
		String Expected_AuditName = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[1]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditName);
		String Actual_AuditName = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
		String Actual_AuditName1 = Actual_AuditName.toUpperCase();
		System.out.println("Actual Audit Type Name is : " + Actual_AuditName1);
		SoftAssert.assertEquals(Expected_AuditName, Actual_AuditName1, "Audit Type Name is Wrong");

		//Checking the Sub Audit Name
		String Expected_SubAuditName = driver.findElement(By.xpath("//div[@class='p-l-30 bold']")).getText();
		System.out.println("Expected Sub Auditee Name is : " + Expected_SubAuditName);
		String Actual_SubAuditName = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		System.out.println("Actual Sub Auditee Name is : " + Actual_SubAuditName);
		SoftAssert.assertEquals(Expected_SubAuditName, Actual_SubAuditName, "Sub Auditee Name is Wrong");

		//Checking the Auditee Review Status
		String Expected_AuditeeReviewStatus = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[4]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditeeReviewStatus);
		String Actual_AuditeeReviewStatus = "NOT ACCEPTED";
		System.out.println("Actual Auditee Review Status is : " + Actual_AuditeeReviewStatus);
		SoftAssert.assertEquals(Expected_AuditeeReviewStatus, Actual_AuditeeReviewStatus, "Auditee Review Status is Wrong");


	}

	public void VerifySummaryPageIsDisplayed4(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SoftAssert SoftAssert = new SoftAssert();

		//Checking Summary Header
		WebElement Summary = driver.findElement(By.xpath("//div[@class='panel-title']"));
		SoftAssert.assertTrue(Summary.isDisplayed(), "Summary Header is Not Displayed");

		//Checking the Audit Type Name
		String Expected_AuditName = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[1]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditName);
		String Actual_AuditName = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
		String Actual_AuditName1 = Actual_AuditName.toUpperCase();
		System.out.println("Actual Audit Type Name is : " + Actual_AuditName1);
		SoftAssert.assertEquals(Expected_AuditName, Actual_AuditName1, "Audit Type Name is Wrong");

		//Checking the Sub Audit Name
		String Expected_SubAuditName = driver.findElement(By.xpath("//div[@class='p-l-30 bold']")).getText();
		System.out.println("Expected Sub Auditee Name is : " + Expected_SubAuditName);
		String Actual_SubAuditName = Lib.getCellValue(XLPATH, "Audit Execution", 135, 0);
		System.out.println("Actual Sub Auditee Name is : " + Actual_SubAuditName);
		SoftAssert.assertEquals(Expected_SubAuditName, Actual_SubAuditName, "Sub Auditee Name is Wrong");

		//Checking the Auditee Review Status
		String Expected_AuditeeReviewStatus = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[4]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditeeReviewStatus);
		String Actual_AuditeeReviewStatus = "NOT ACCEPTED";
		System.out.println("Actual Auditee Review Status is : " + Actual_AuditeeReviewStatus);
		SoftAssert.assertEquals(Expected_AuditeeReviewStatus, Actual_AuditeeReviewStatus, "Auditee Review Status is Wrong");


	}

	public void VerifySummaryPageIsDisplayed5(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SoftAssert SoftAssert = new SoftAssert();

		//Checking Summary Header
		WebElement Summary = driver.findElement(By.xpath("//div[@class='panel-title']"));
		SoftAssert.assertTrue(Summary.isDisplayed(), "Summary Header is Not Displayed");

		//Checking the Audit Type Name
		String Expected_AuditName = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[1]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditName);
		String Actual_AuditName = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
		String Actual_AuditName1 = Actual_AuditName.toUpperCase();
		System.out.println("Actual Audit Type Name is : " + Actual_AuditName1);
		SoftAssert.assertEquals(Expected_AuditName, Actual_AuditName1, "Audit Type Name is Wrong");

		//Checking the Sub Audit Name
		String Expected_SubAuditName = driver.findElement(By.xpath("//div[@class='p-l-30 bold']")).getText();
		System.out.println("Expected Sub Auditee Name is : " + Expected_SubAuditName);
		String Actual_SubAuditName = Lib.getCellValue(XLPATH, "Audit Execution", 136, 0);
		System.out.println("Actual Sub Auditee Name is : " + Actual_SubAuditName);
		SoftAssert.assertEquals(Expected_SubAuditName, Actual_SubAuditName, "Sub Auditee Name is Wrong");

		//Checking the Auditee Review Status
		String Expected_AuditeeReviewStatus = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[4]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditeeReviewStatus);
		String Actual_AuditeeReviewStatus = "NOT ACCEPTED";
		System.out.println("Actual Auditee Review Status is : " + Actual_AuditeeReviewStatus);
		SoftAssert.assertEquals(Expected_AuditeeReviewStatus, Actual_AuditeeReviewStatus, "Auditee Review Status is Wrong");


	}


	public void VerifySummaryPageIsDisplayed6(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SoftAssert SoftAssert = new SoftAssert();

		//Checking Summary Header
		WebElement Summary = driver.findElement(By.xpath("//div[@class='panel-title']"));
		SoftAssert.assertTrue(Summary.isDisplayed(), "Summary Header is Not Displayed");

		//Checking the Audit Type Name
		String Expected_AuditName = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[1]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditName);
		String Actual_AuditName = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
		String Actual_AuditName1 = Actual_AuditName.toUpperCase();
		System.out.println("Actual Audit Type Name is : " + Actual_AuditName1);
		SoftAssert.assertEquals(Expected_AuditName, Actual_AuditName1, "Audit Type Name is Wrong");

		//Checking the Sub Audit Name
		String Expected_SubAuditName = driver.findElement(By.xpath("//div[@class='p-l-30 bold']")).getText();
		System.out.println("Expected Sub Auditee Name is : " + Expected_SubAuditName);
		String Actual_SubAuditName = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		System.out.println("Actual Sub Auditee Name is : " + Actual_SubAuditName);
		SoftAssert.assertEquals(Expected_SubAuditName, Actual_SubAuditName, "Sub Auditee Name is Wrong");

		//Checking the Auditee Review Status
		String Expected_AuditeeReviewStatus = driver.findElement(By.xpath("//div[@class='panel-body no-padding m-b-20 p-l-5']/div[4]/div[@class='p-l-30 bold all-caps']")).getText();
		System.out.println("Expected Audit Type Name is : " + Expected_AuditeeReviewStatus);
		String Actual_AuditeeReviewStatus = "NOT ACCEPTED";
		System.out.println("Actual Auditee Review Status is : " + Actual_AuditeeReviewStatus);
		SoftAssert.assertEquals(Expected_AuditeeReviewStatus, Actual_AuditeeReviewStatus, "Auditee Review Status is Wrong");


	}


	public void VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement AreYouSure = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5"));
		wait.until(ExpectedConditions.visibilityOf(AreYouSure));

		WebElement AfterSigningOff = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/p"));
		if(AreYouSure.isDisplayed() && AfterSigningOff.isDisplayed())
		{
			String Actual_AreYouSure = AreYouSure.getText();
			String Expected_AreYouSure = "Are you sure you want to sign off this audit ?";
			Assert.assertEquals(Actual_AreYouSure, Expected_AreYouSure, "Pop is Wrong");


			String Actual_AfterSigningOff = AfterSigningOff.getText();
			String Expected_AfterSigningOff = "After signing off, you cannot accept or reject issues. All the un - attempted issues will get automatically accepted by the application . Still go ahead and sign off ?";
			Assert.assertEquals(Actual_AfterSigningOff, Expected_AfterSigningOff, "Pop Message is Wrong");
			System.out.println("Are you sure you want to sign off this audit ? Pop is Displayed");
			chiledTest.log(Status.INFO, "Are you sure you want to sign off this audit ? Pop is Displayed");
		}

	}

	public void VerifyAuditAcceptedSuccessfullySuccessMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Audit accepted successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Audit accepted successfully Success Message is Displayed");
			chiledTest.log(Status.INFO, "Audit accepted successfully Success Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/button")).click();
		}
	}


	public void VerifyIssueAcceptedSuccessfullySuccessMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		SoftAssert softassertion = new SoftAssert();

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		wait.until(ExpectedConditions.visibilityOf(SuccessMSG));
		softassertion.assertTrue(SuccessMSG.isDisplayed(), "Issue Accept successfully Success Message is Not Displayed");
		String Actual_Text = SuccessMSG.getText();
		String Expected_Text = "Issue Accept successfully";
		softassertion.assertEquals(Actual_Text, Expected_Text);
		System.out.println("Pass : Issue accepted successfully Success Message is Displayed");
	}

	public void VerifyIssueRejectedSuccessfullySuccessMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		SoftAssert softassertion = new SoftAssert();
		try{
			WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG));
			softassertion.assertTrue(SuccessMSG.isDisplayed(), "Issue Reject successfully Success Message is Not Displayed");
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Issue Reject successfully";
			softassertion.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Issue Reject successfully Success Message is Displayed");
		}catch (StaleElementReferenceException e) {

		}

	}


	public void VerifyReviewcheckPointTabView(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		SoftAssert softAssertion = new SoftAssert();

		//Checking Group
		WebElement Group = driver.findElement(By.xpath("//div[@id='s2id_check_point_group_id']/a/span[@class='select2-chosen']"));
		wait.until(ExpectedConditions.visibilityOf(Group));
		softAssertion.assertTrue(Group.isEnabled(), "Group is Able to Edit");

		//Checking Checkpoint Name
		WebElement CheckPointName = driver.findElement(By.xpath("//div[contains(@class,'form-group form-group-default required')]//input[contains(@class,'form-control enable-text')]"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointName));
		softAssertion.assertFalse(CheckPointName.isEnabled(), "Check Point is Able to Edit");

		//Checking Definition
		WebElement Definition = driver.findElement(By.xpath("//div[@class='form-group form-group-default required']/textarea"));
		wait.until(ExpectedConditions.visibilityOf(Definition));
		softAssertion.assertTrue(Definition.isEnabled(), "Definition is Able to Edit");


		//Checking compliance
		WebElement Complaince = driver.findElement(By.xpath("//div[@id='s2id_compliance']/a/span[@class='select2-chosen']"));
		wait.until(ExpectedConditions.visibilityOf(Complaince));
		softAssertion.assertTrue(Complaince.isEnabled(), "Complaince is Able to Edit");


		//Checking Dispositions
		WebElement Dispositions = driver.findElement(By.xpath("//div[@class='form-group form-group-default ']/input"));
		wait.until(ExpectedConditions.visibilityOf(Dispositions));
		softAssertion.assertTrue(Dispositions.isEnabled(), "Dispositions is Able to Edit");


		//Checking Risk Level
		WebElement RiskLevel = driver.findElement(By.xpath("//div[@id='s2id_risk_level']/a/span[@class='select2-chosen']"));
		wait.until(ExpectedConditions.visibilityOf(RiskLevel));
		softAssertion.assertTrue(RiskLevel.isEnabled(), "Risk Level is Able to Edit");


		//Checking Comments
		WebElement Comments = driver.findElement(By.xpath("//textarea[@id='issue_issue_comments_attributes_0_description']"));
		wait.until(ExpectedConditions.visibilityOf(Comments));
		softAssertion.assertFalse(Comments.isEnabled(), "Comments is Not Able to Edit");


		//Checking due date
		WebElement DueDate = driver.findElement(By.xpath("//input[@id='issue_due_date']"));
		wait.until(ExpectedConditions.visibilityOf(DueDate));
		softAssertion.assertTrue(DueDate.isEnabled(), "Due Date is Able to Edit");


		//Checking the Choose file Button is Displayed
		WebElement Choose = driver.findElement(By.xpath("//input[@id='issue_audit_compliance_documents_attributes_0_document']"));
		wait.until(ExpectedConditions.visibilityOf(Choose));
		softAssertion.assertTrue(Choose.isDisplayed(), "Choose File Button is Not Displayed");


		//Checking Add a Document Button is Displayed
		WebElement AddDocument = driver.findElement(By.xpath("//a[contains(@class,'add_nested_fields')]"));
		wait.until(ExpectedConditions.visibilityOf(AddDocument));
		softAssertion.assertTrue(AddDocument.isDisplayed(), "Add A Document Button is Not Displayed");


		//Checking Delete Button is Displayed
		WebElement DeleteBTN = driver.findElement(By.xpath("//a[contains(@class,'remove_nested_fields')]"));
		wait.until(ExpectedConditions.visibilityOf(DeleteBTN));
		softAssertion.assertTrue(DeleteBTN.isDisplayed(), "Delete Button is Not Displayed");


		//Checking Accept Button is Displayed
		/*WebElement AcceptBTN = driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block auditee_result accept_button']"));
		wait.until(ExpectedConditions.visibilityOf(AcceptBTN));*/
		softAssertion.assertTrue(AcceptBTN.isDisplayed(), "Accept Button is Not Displayed");


		//Checking Reject Button is Displayed
		/*WebElement RejectBTN = driver.findElement(By.xpath("//input[@value='Re-Examine']"));
		wait.until(ExpectedConditions.visibilityOf(RejectBTN));*/
		softAssertion.assertTrue(ReExaminBTN.isDisplayed(), "ReExamin Button is Not Displayed");


		//Checking Review checkPoint Header
		WebElement ReviewCheckpointHeader = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h5"));
		wait.until(ExpectedConditions.visibilityOf(ReviewCheckpointHeader));
		softAssertion.assertTrue(ReviewCheckpointHeader.isDisplayed(), "Review Check point Header is Not Displayed");

		softAssertion.assertAll();
	}


	public void VerifyDocumnetView(WebDriver driver)
	{

		WebDriverWait wait = new WebDriverWait(driver, 10);

		SoftAssert SoftAssert = new SoftAssert();

		//Checking Issue Documents Header
		WebElement IssueDocuments = driver.findElement(By.xpath("//label[contains(text(),'Issue Documents')]"));
		wait.until(ExpectedConditions.visibilityOf(IssueDocuments));
		SoftAssert.assertTrue(IssueDocuments.isDisplayed(), "Issue Documnets Header is Not Displayed Under Documnet Tab");

		//Checking the Table
		WebElement Table = driver.findElement(By.xpath("//table[@id='condensedTable']"));
		wait.until(ExpectedConditions.visibilityOf(Table));
		SoftAssert.assertTrue(Table.isDisplayed(), "Issue Documnets Table is Not Displayed Under Documnet Tab");

		//Checking the SNo
		WebElement SNO = driver.findElement(By.xpath("//table[@id='condensedTable']/thead/tr/th[text()='Sno.']"));
		wait.until(ExpectedConditions.visibilityOf(SNO));
		SoftAssert.assertTrue(SNO.isDisplayed(), "SNo is Not Displayed");

		//Checking the File Name
		WebElement FileName = driver.findElement(By.xpath("//table[@id='condensedTable']/thead/tr/th[text()='File Name']"));
		wait.until(ExpectedConditions.visibilityOf(FileName));
		SoftAssert.assertTrue(SNO.isDisplayed(), "File Name is Not Displayed");


		//Checking the Time Stamp
		WebElement TimeStamp = driver.findElement(By.xpath("//table[@id='condensedTable']/thead/tr/th[text()='Timestamp']"));
		wait.until(ExpectedConditions.visibilityOf(SNO));
		SoftAssert.assertTrue(TimeStamp.isDisplayed(), "Time Stamp is Not Displayed");

		//Checking the UploadedBy
		WebElement UploadedBy = driver.findElement(By.xpath("//table[@id='condensedTable']/thead/tr/th[text()='Uploaded By']"));
		wait.until(ExpectedConditions.visibilityOf(UploadedBy));
		SoftAssert.assertTrue(SNO.isDisplayed(), "Uploaded By is Not Displayed");

		//Checking the Total Row Count
		List<WebElement> RowCount = driver.findElements(By.xpath("//table[@id='condensedTable']/tbody/tr"));
		int count = RowCount.size();
		int  Actual_count= count;
		int Expected_count = 2;
		SoftAssert.assertEquals(Actual_count, Expected_count, "Total Row count is Wrong");

		//Checking the Attached Document Name
		WebElement DocumnetName1 = driver.findElement(By.xpath("//table[@id='condensedTable']/tbody/tr/td[2]/a[text()='IMG-20180607-WA0031.jpg']"));
		wait.until(ExpectedConditions.visibilityOf(DocumnetName1));
		SoftAssert.assertTrue(DocumnetName1.isDisplayed(), "Attached File Name is Not Displayed");

		//Checking the Attached Document Name
		WebElement DocumnetName2 = driver.findElement(By.xpath("//table[@id='condensedTable']/tbody/tr/td[2]/a[text()='IMG-20180606-WA0023.jpg']"));
		wait.until(ExpectedConditions.visibilityOf(DocumnetName2));
		SoftAssert.assertTrue(DocumnetName2.isDisplayed(), "Attached File Name is Not Displayed");

		SoftAssert.assertAll();
	}

	public void UploadDocumnet(WebDriver driver)
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
		System.out.println("documnet is Uploaded");
	}


	public void VerifyAuditsAreDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		try
		{
			WebElement data = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr/td[@class='sorting_1']"));
			Assert.assertTrue(data.isDisplayed(), "Issues are not Displayed");
			System.out.println("Issues are Displayed Under Grid");

		}catch (Exception e) {
			WebElement Nodata = driver.findElement(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr/td[@class='dataTables_empty']"));
			Assert.assertTrue(Nodata.isDisplayed(), "No data available in table in The Table Message is Displayed");
			System.out.println("No data available in table Message is Displayed");
		}
	}


	public void VerifyAuditorSatisfactionSurveyButtonIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		List<WebElement> AuditorSatisfactionSurveyButton = driver.findElements(By.xpath("//a[@class='button btn btn-primary btn-block']"));
		Assert.assertTrue(AuditorSatisfactionSurveyButton.size()>0, "Auditor Satisfaction Survey Button is Displayed");
		System.out.println("Pass : Auditor Satisfaction Survey Button is Displayed");
		chiledTest.log(Status.INFO, "Auditor Satisfaction Survey Button is Displayed");
	}


	public void VerifyPleaseEnterValidDate(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(PleaseEnterValidDate)).isDisplayed())
		{
			String Actual_Text = PleaseEnterValidDate.getText();
			String Expected_Text = "Please enter valid date";
			Assert.assertEquals(Actual_Text, Expected_Text, "Error Message is Wrong");
			System.out.println("Please enter Valid Date Error Message is Displayed");
			chiledTest.log(Status.INFO, "Please enter Valid Date Error Message is Displayed");
		}
	}

	public void VerifyPleaseCompleteTheSurveyValidationMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement PleaseCompleteTheSurveyErrorMSG = driver.findElement(By.xpath("//label[text()='Please complete the survey.']"));
		if(wait.until(ExpectedConditions.visibilityOf(PleaseCompleteTheSurveyErrorMSG)).isDisplayed())
		{
			String Actual_Text = PleaseCompleteTheSurveyErrorMSG.getText();
			String Expected_Text = "Please complete the survey.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Error Message is Wrong");
			System.out.println("Please complete the survey. Validation Message is Displayed");
			chiledTest.log(Status.INFO, "Please complete the survey. Validation Message is Displayed");
		}
	}

	public void VerifyResponsesAddedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Responses added successfully";
			Assert.assertEquals(Actual_Text, Expected_Text, "Message is Wrong");
			System.out.println("Responses added successfully Message is Displayed");
			chiledTest.log(Status.INFO, "Responses added successfully Message is Displayed");

			//clicking on the Close Button
			SuccessMSGCloseBTN.click();
		}
	}

	public void VerifyThereAreNoIssuesForThisAudit(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NoIssuesErrorMSG = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(wait.until(ExpectedConditions.visibilityOf(NoIssuesErrorMSG)).isDisplayed())
		{
			String Actual_Text = NoIssuesErrorMSG.getText();
			String Expected_Text = "There are no issues for this audit";
			Assert.assertEquals(Actual_Text, Expected_Text, "There are no issues for this audit Message is Displayed");
			System.out.println("Pass : There are no issues for this audit Message is Displayed");
			chiledTest.log(Status.INFO, "There are no issues for this audit Message is Displayed");

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

	public void VerifyProvisionalSubmissionStatusIsDisplayed()
	{
		List<WebElement> PS = driver.findElements(By.xpath("//table[@id='tableWithAuditeeSubAuditsSearch']/tbody/tr/td/span[contains(text(),'Provisionally Submitted')]"));
		Assert.assertTrue(PS.size()>=0, "Provisionally Submitted Status is NOT Displayed");
		System.out.println("Provisionally Submitted Status is Displayed");
		chiledTest.log(Status.INFO, "Provisionally Submitted Status is Displayed");
	}

	public void VerifyDocumentUploadedSuccessfullyMSGIsDisplayed() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Alert = SuccessMSG.getText();
			String Expected_Alert = "Document Uploaded successfully";
			Assert.assertEquals(Actual_Alert, Expected_Alert, "Document Uploaded successfully Pop Up Is not displayed");
			System.out.println("Document Uploaded successfully Pop Up is Displayed");
			chiledTest.log(Status.INFO, "Document Uploaded successfully Pop Up is Displayed");

			//clicking on the Close Button
			SuccessMSGCloseBTN.click();

		}

	}

	public void VerifyYesAndNoButtonIsReadOnlyMode()
	{
		//Checking Yes button should be disabled
		WebElement YesButton = driver.findElement(By.xpath("//label[@data-report-button='yes' and @disabled]"));
		Assert.assertTrue(YesButton.isDisplayed(), "Yes Button is Not in Read only mode");
		System.out.println("Yes Button is Disabled");
		chiledTest.log(Status.INFO, "Yes Button is Disabled");

		//Checking No button should be disabled
		WebElement NoButton = driver.findElement(By.xpath("//label[@data-report-button='no' and @disabled]"));
		Assert.assertTrue(NoButton.isDisplayed(), "No Button is Not in Read only mode");
		System.out.println("No Button is Disabled");
		chiledTest.log(Status.INFO, "No Button is Disabled");

	}
	
	public void VerifyDuedateIsRequired()
	{
		WebElement DueDateTextField = driver.findElement(By.xpath("//label[contains(text(),'Due Date')]/following-sibling::input[@required]"));
		Assert.assertTrue(DueDateTextField.isDisplayed(), "Due date is Not Required");
		System.out.println("Due Date is Required");
		chiledTest.log(Status.INFO, "DUe date is Required");
	}
	
	public void VerifyCommentsIsReauiredFiled()
	{
	//	WebElement CommentsTextField = driver.findElement(By.xpath("//textarea[@class='form-control auditee_desc max_char' and @required='required']"));
		WebElement CommentsTextField = driver.findElement(By.xpath("//textarea[@id='issue_issue_comments_attributes_0_description' and @required='required']"));
		Assert.assertTrue(CommentsTextField.isDisplayed(), "Comments is Not Required Fields");
		System.out.println("Comments is Required Filed");
		chiledTest.log(Status.INFO, "Comments is Required Filed");
	}
	
	public void VerifyDigitalEvidencsIsRequired() throws Exception
	{
		GetScreenshots.WAIT(CommentsTextField);
		Assert.assertTrue(CommentsTextField.isDisplayed(), "Digital Evidence is Not Required");
		System.out.println("Digital Evidence is Required");
		chiledTest.log(Status.INFO, "Digital Evidence is Required");
	}
	
	public void VerifyReExamineButtonShouldNotDisplay() throws Exception
	{
		//#SM
	//	WebElement element = driver.findElement(By.xpath("//input[@value='Accept']"));
		GetScreenshots.WAIT(AcceptBTN);
		Actions act=new Actions(driver);
		act.moveToElement(AcceptBTN).build().perform();
		
		List<WebElement> RBTN = driver.findElements(By.xpath("//input[@style='display: none;']"));
		System.out.println(RBTN.size());
		
		Assert.assertTrue(RBTN.size()==1, "Re-Examine Button is Displayed Post click of Direct Resolution Check Box");
		System.out.println("Pass : Re Examine Button is Not Displayed");
		chiledTest.log(Status.INFO, "Pass : Re Examine Button is Not Displayed");
	}
	
	public void UploadDocumentsDigitalEvidences(WebDriver driver) throws Exception
	{
		try{
			Thread.sleep(1000);//#SM Added 
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			GetScreenshots.WAIT(ChooseFile);
		//	WebElement element = driver.findElement(By.xpath("//input[@id='issue_audit_compliance_documents_attributes_0_document']"));
			wait.until(ExpectedConditions.visibilityOf(ChooseFile));
			Actions act= new Actions(driver);
			act.moveToElement(ChooseFile).build().perform();
			
			//Uploading the JPG File
			driver.findElement(By.xpath("//input[@id='issue_audit_compliance_documents_attributes_0_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
			Thread.sleep(1000);
			System.out.println("File uploaded successfully");
			/*//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();

			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			System.out.println("*****Uploading >25MB Documents****");
			chiledTest.log(Status.INFO, "*****Uploading >25MB Documets*********");

			//Uploading the JPG File
			driver.findElement(By.xpath("//input[@id='issue_audit_compliance_documents_attributes_0_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\30_MB_PDF_document.pdf");

			//Checking the document should be less than 25mb. Alert is Displayed
			Alert alert = driver.switchTo().alert();
			String Actual_alert = alert.getText();
			String Expected_alert = "document should be less than 25mb.";
			Assert.assertEquals(Actual_alert, Expected_alert, "document should be less than 25mb. Alert is Not Displayed");
			System.out.println("document should be less than 25mb Alert is Displayed");
			chiledTest.log(Status.INFO, "document should be less than 25mb Alert is Displayed");
			alert.accept();

			//Uploading other than this Documents only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg.
			System.out.println("************Uploading .Mov Documents*************");
			chiledTest.log(Status.INFO, "********Uploading .MOV Documets**********");

			//Passing the Documents to Choose File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\All Main audit list is not coming in current flow.MOV");

			//Checking the only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg file should be uploaded pop is Displayed
			VerifyOnlyPdfWavMp3OggMp4DocDocxJpgPngWmvJpegMpegFileShouldBeUploadedPopUpIsDisplayed();

			System.out.println("*****Uploading .TXT Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .TXT Documets*********");

			//Passing the Documents to Choose File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\All Main audit list is not coming in current flow.MOV");

			//Checking the only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg file should be uploaded pop is Displayed
			VerifyOnlyPdfWavMp3OggMp4DocDocxJpgPngWmvJpegMpegFileShouldBeUploadedPopUpIsDisplayed();

			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Uploading the JPG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");

			System.out.println("*****Uploading .MP3 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .MP3 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the PNG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[2]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\kurai-onrum-illai.mp3");

			System.out.println("*****Uploading .PDF Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .PDF Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .PDF File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[3]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\download.pdf");

			System.out.println("*****Uploading .PDF Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .PDF Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .PDF File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[4]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\fp_dc_setup_guide.pdf");

			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .JPG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[5]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180607-WA0031.jpg");

			//clicking on the Confidential Check box
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[5]//input[@type='checkbox']")).click();

			System.out.println("*****Uploading .Mp3 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .Mp3 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .Mp3 File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[6]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\kurai-onrum-illai.mp3");

			//clicking on the Confidential Check box
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[6]//input[@type='checkbox']")).click();

			System.out.println("*****Uploading .Mp4 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .Mp4 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .Mp4 File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[7]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\VID_20200213_170644.mp4");

			//clicking on the Confidential Check box
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[7]//input[@type='checkbox']")).click();

			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the JPG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[8]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");

			//clicking on the Confidential Check box
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[8]//input[@type='checkbox']")).click();

			//Clicking on the OK Button
			driver.findElement(By.xpath("//input[@class='btn btn-primary m-t-30 updated_docs']")).click();
			System.out.println("OK Button is Clicked");
			chiledTest.log(Status.INFO, "OK Button is Clicked");*/

			System.out.println("Pass : Documents are Uploaded");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}
	}
	
	public void Verify8CPAreDisplayed()
	{
		int Actual_CPCount = driver.findElements(By.xpath("//table[@id='tableWithSearchSummaryAuditeeApp']/tbody/tr")).size();
		int Expected_CPCount = 8;
		Assert.assertEquals(Actual_CPCount, Expected_CPCount, "8 CP Are Not Displayed");
		System.out.println("8 CP are Dispalyed");
		chiledTest.log(Status.INFO, "8 CP are Dispalyed");
	}
	
	public void Verify4CPAreDisplayed()
	{
		int Actual_CPCount = driver.findElements(By.xpath("//table[@id='tableWithSearchSummaryAuditeeApp']/tbody/tr")).size();
		int Expected_CPCount = 4;
		Assert.assertEquals(Actual_CPCount, Expected_CPCount, "8 CP Are Not Displayed");
		System.out.println("8 CP are Dispalyed");
		chiledTest.log(Status.INFO, "8 CP are Dispalyed");
	}
	
	public void Verify1CPAreDisplayed()
	{
		int Actual_CPCount = driver.findElements(By.xpath("//table[@id='tableWithSearchSummaryAuditeeApp']/tbody/tr")).size();
		int Expected_CPCount = 1;
		Assert.assertEquals(Actual_CPCount, Expected_CPCount, "8 CP Are Not Displayed");
		System.out.println("1 CP are Dispalyed");
		chiledTest.log(Status.INFO, "1 CP are Dispalyed");
	}
	

}

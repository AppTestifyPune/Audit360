package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;
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

public class IssuesPageTest extends BaseTest {

	//Clicking on the My Audit Header
	@FindBy(xpath="//a[@class='active'][text()='ISSUES ']")
	private WebElement IssuesHeader;

	//Clicking on the scroll bar
	@FindBy(xpath="//nav[contains(@class,'page-sidebar')]/div[contains(@class,'sidebar-menu')]")
	private WebElement ScrollBar;

	//Clicking on the Issues under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content')]/li/a/span[text()='Issues']")
	private WebElement Issues;

	//Passing the Values to Select Parent Audit Type
	@FindBy(xpath="//div[@id='s2id_issue_transaction_audit_types']//input[@type='text']")
	private WebElement SelectParentAuditType;

	//Passing the Values to Select Auditor
	@FindBy(xpath="//div[@id='s2id_issue_transaction_auditor']//input[@type='text']")
	private WebElement SelectAuditor;

	//Passing the Values to Select Due Date From
	@FindBy(xpath="//input[@id='issue_transaction_due_date']")
	private WebElement SelectDueDateFrom;

	//Passing the Values to Select due Date To
	@FindBy(xpath="//input[@id='issue_transaction_due_date_to']")
	private WebElement SelectDueDateTO;

	//Passing the Values to Select issue status
	@FindBy(xpath="//div[@id='s2id_issue_transaction_statuses']//a//span[@class='select2-chosen']")
	private WebElement SelectIssueStatus;

	//Passing the values to Select Issue status 
	@FindBy(xpath="//div[@class='select2-search']//input[@id='s2id_autogen4_search']")
	private WebElement IssueStatus;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Passing the values to Search text Field
	@FindBy(xpath="//label[contains(text(),'Search:')]//input[@class='form-control']")
	private WebElement SearchBox;

	//clicking on the 1st View Button
	@FindBy(xpath="//table[@id='tableWithSearchForIssueTransactions']//tbody/tr[1]/td//button[@type='button']")
	private WebElement FirstViewBTN;

	//clicking on the 2nd View Button
	@FindBy(xpath="//table[@id='tableWithSearchForIssueTransactions']//tbody/tr[2]/td//button[@type='button']")
	private WebElement SecondViewBTN;

	//clicking on the 3rd View Button
	@FindBy(xpath="//table[@id='tableWithSearchForIssueTransactions']//tbody/tr[3]/td//button[@type='button']")
	private WebElement ThirdViewBTN;

	//clicking on the 4th View Button
	@FindBy(xpath="//table[@id='tableWithSearchForIssueTransactions']//tbody/tr[4]/td//button[@type='button']")
	private WebElement FourthViewBTN;

	//clicking on the 5th View Button
	@FindBy(xpath="//table[@id='tableWithSearchForIssueTransactions']//tbody/tr[5]/td//button[@type='button']")
	private WebElement FifthViewBTN;

	//Clicking on the Select All Check Box
	@FindBy(xpath="//input[@name='selectall']")
	private WebElement SelectAll;

	//Passing the values to Choose File
	@FindBy(xpath="//input[@id='issue_audit_compliance_documents_attributes_0_document']")
	private WebElement ChooseFile;

	//Clicking on the 1st TR
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[1]")
	private WebElement FirstTR;

	//Passing the Values to Due Date
	@FindBy(xpath="//input[@id='due_date']")
	private WebElement dueDate;

	//Clicking on the Cancel Button
	@FindBy(xpath="//button[@class='btn btn-default btn-block'][text()='Cancel']")
	private WebElement CancelBTN;

	//checking the Issue Comments is Required Filed or not
	@FindBy(xpath="//textarea[@id='bulk_issue_comment'][@required='required']")
	private WebElement IssueComments;

	//Checking No matching records found
	@FindBy(xpath="//td[@class='dataTables_empty']")
	private WebElement Nodata;

	//Clicking on the Filter Button
	@FindBy(xpath="//button[@id='filter_issue_transactions']")
	private WebElement GoBTN;

	//Clicking on the Back to Audit Page
	@FindBy(xpath="//a[contains(text(),'Back To Review Audits')]")
	private WebElement BackToReviewAuditBTN;

	//selecting 100 under pagination
	@FindBy(xpath="//select[@name='tableWithSearchForIssueTransactions_length']//option[@value='100']")
	private WebElement Pagination;
	
	//clicking on the Resolve Issue Button
	@FindBy(xpath="//input[@class='btn btn-primary update_issue_status_btn']")
	private WebElement ResloveBTN;

	public IssuesPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickPagination() throws InterruptedException
	{
		Thread.sleep(200);
		Pagination.click();
		Thread.sleep(200);
	}


	public void ClickIssuesHeader()
	{
		IssuesHeader.click();
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickIssues(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Issues));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Issues);
	}

	public void ClickResloveIssueButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ResloveBTN);
		System.out.println("Reslove issue button is clicked");
		chiledTest.log(Status.INFO, "Reslove issue button is clicked");
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

	public void SetSelectDueDateFrom(String AD)
	{
		SelectDueDateFrom.sendKeys(AD);
		System.out.println("Entered Audit Date is : " + AD);
		SelectDueDateFrom.sendKeys(Keys.ESCAPE);

	}

	public void SetSelectDueDateTo(String DD)
	{
		SelectDueDateTO.sendKeys(DD);
		System.out.println("Entered Due Date is : " + DD);
		SelectDueDateTO.sendKeys(Keys.ESCAPE);
	}

	public void ClickSelectIssueStatus()
	{
		SelectIssueStatus.click();
	}

	public void SetIssuesStatus(String SS)
	{
		IssueStatus.sendKeys(SS);
		System.out.println("Entered Issue status is : " + SS);
		chiledTest.log(Status.INFO, "Issue Status is Entered");
	}

	public void ClickMatched(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Matched)).click();
	}

	public void setSearchBox(String SS, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SearchBox)).clear();

		SearchBox.sendKeys(SS);
		System.out.println("Searched Audit Type is : " + SS);
	}

	public void ClearSearchBox()
	{
		SearchBox.clear();
	}

	public void SetIssueComments(String IC)
	{
		IssueComments.sendKeys(IC);
		System.out.println("Entered Issues Comments is : " + IC);
	}

	public void ClickFirstViewBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(FirstViewBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", FirstViewBTN);
		System.out.println("View Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");

	}

	public void ClickSecondViewBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SecondViewBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SecondViewBTN);
		System.out.println("View Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");

	}

	public void ClickThirdViewBTNViewBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ThirdViewBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ThirdViewBTN);
		System.out.println("View Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}

	public void ClickCancelBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(CancelBTN)).click();
		System.out.println("Cancel Button is Clicked");
	}

	public void ClickSelectAll(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(SelectAll)).click();
		System.out.println("select All check box is Clicked");
	}

	public void UploadDocumnet(WebDriver driver)
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
		System.out.println("documnet is Uploaded");
	}

	public void ClickFirstTR(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(FirstTR)).click();

	}

	public void SetdueDate(String DD)
	{
		try{
			dueDate.sendKeys(DD);
			System.out.println("Entered Due Date is : " + DD);
		}catch (StaleElementReferenceException e) {
		}

	}

	public void ClickGoBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(GoBTN)).click();
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");

	}

	public void ClickBackToReviewAuditBTN()
	{
		BackToReviewAuditBTN.click();
		System.out.println("Back to Review Audit Button is Clicked");
		chiledTest.log(Status.INFO, "Back to Review Audit Button is Clicked");
	}

	public void VerifyNoDataAvailableInTableIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(Nodata)).isDisplayed()){
			System.out.println("Pass : No data available in table Error Message is Displayed");
			chiledTest.log(Status.INFO, "Pass : No data available in table Error Message is Displayed");}
		else{
			System.out.println("Fail : No data available in table Error Message is Displayed ");
			chiledTest.log(Status.INFO, "Fail : No data available in table Error Message is Not Displayed");}
	}

	public void VerifyIssuesPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking the Issues Header
		Assert.assertTrue(IssuesHeader.isDisplayed(), "Issues Header is Not Displayed");

		//Checking the Select Parent Audit type
		WebElement SelectParentAudittypeLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Parent Audit Type')]"));
		Assert.assertTrue(SelectParentAudittypeLabel.isDisplayed(), "Select Audit Type Drop down Is Not Displayed");

		//Checking the Select Auditor
		WebElement SelectAuditorLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Auditor')]"));
		Assert.assertTrue(SelectAuditorLabel.isDisplayed(), "Select Auditor Drop down Is Not Displayed");

		//Checking the Select Audit Date
		WebElement SelectAuditDateLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Audit Date')]"));
		Assert.assertTrue(SelectAuditDateLabel.isDisplayed(), "Select Audit Date Drop down Is Not Displayed");

		//Checking the Select Issue Status
		WebElement SelectIssueStatus = driver.findElement(By.xpath("//label[contains(text(),'Select Issue Status')]"));
		Assert.assertTrue(SelectIssueStatus.isDisplayed(), "Select Issue status Drop down Is Not Displayed");

		//Checking the Select Due Date
		WebElement SelectParentDuedate = driver.findElement(By.xpath("//label[contains(text(),'Select Due Date')]"));
		Assert.assertTrue(SelectParentDuedate.isDisplayed(), "Select due date Drop down Is Not Displayed");

		//Checking the Search Button
		Assert.assertTrue(SearchBox.isDisplayed(), "Search Button Is Not Displayed");

		//checking Table
		WebElement Table = driver.findElement(By.xpath("//table[@id='tableWithSearch']"));
		Assert.assertTrue(Table.isDisplayed(), "Issues Grid Is Not Displayed");

	}


	public void VerifyIssuesgridIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr/td[@class='sorting_1']")).isDisplayed();
			System.out.println("Issues are Displayed Under Grid");

		}catch (Exception e) {
			driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr/td[@class='dataTables_empty']")).isDisplayed();
			System.out.println("No data available in table Message is Displayed");
		}
	}

	public void VerifyNoMatchFoundMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NoMatchFound = driver.findElement(By.xpath("//div[@id='select2-drop']//li[@class='select2-no-results'][contains(text(),'No matches found')]"));
		wait.until(ExpectedConditions.visibilityOf(NoMatchFound));
		Assert.assertTrue(NoMatchFound.isDisplayed(), "No matches found Message is Not Displayed");
		System.out.println("No matches found Message is Displayed");

	}

	public void VerifyInProgressstatusIsDisplayed(WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 15);
			WebElement IssueStatus = driver.findElement(By.xpath("//textarea[@id='status']"));
			String Actiual_Text = wait.until(ExpectedConditions.visibilityOf(IssueStatus)).getText();
			String Expected_text = "In Progress";
			Assert.assertEquals(Actiual_Text, Expected_text, "In progress status is Not Displayd");
			System.out.println("In Progress status is Displayed");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Atcual_MSG = SuccessMSG.getText();
			String Expected_MSG = "Issue updated successfully";
			Assert.assertEquals(Atcual_MSG, Expected_MSG, "Issue updated successfully Message is Not Displayed");
			System.out.println("Issues Updated SuccessFully Message is Displayed");
			chiledTest.log(Status.INFO, "Issues Updated SuccessFully Message is Displayed");}

	}
	
	public void VerifyUpdatedSuccessFullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Atcual_MSG = SuccessMSG.getText();
			String Expected_MSG = "Updated Successfully";
			Assert.assertEquals(Atcual_MSG, Expected_MSG, "Updated successfully Message is Not Displayed");
			System.out.println("Updated SuccessFully Message is Displayed");
			chiledTest.log(Status.INFO, "Updated SuccessFully Message is Displayed");}

	}

	public void VerifyNoMatchingRecordsFoundIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(Nodata)).isDisplayed()){
			System.out.println("Pass : No data available in table Error Message is Displayed");
			chiledTest.log(Status.INFO, "Pass : No data available in table Error Message is Displayed");}
		else{
			System.out.println("Fail : No data available in table Error Message is not Displayed ");
			chiledTest.log(Status.INFO, "Fail : No data available in table Error Message is Not Displayed");}
	}

	public void VerifyIssueIsRetainedSuccessMSGISDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement IssueIsRetainedMSG = driver.findElement(By.xpath("//span[contains(text(),'Issue is retained')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(IssueIsRetainedMSG)).isDisplayed(), "Issue is retained Success Message is Not Displayed");
		System.out.println("Issue is retained Success Message is Displayed");
		chiledTest.log(Status.INFO, "Issue is retained Success Message is Displayed");
	}

	public void VerifyIssueIsDroppedSuccessMSGISDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement IssueIsDroppedMSG = driver.findElement(By.xpath("//span[contains(text(),'Issue is dropped')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(IssueIsDroppedMSG)).isDisplayed(), "Issue is dropped Success Message is Not Displayed");
		System.out.println("Issue is dropped Success Message is Displayed");
		chiledTest.log(Status.INFO, "Issue is dropped Success Message is Displayed");
	}

	public void Verify3IssuesAreDisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> IssueList = driver.findElements(By.xpath("//table[@id='tableWithSearchForIssueTransactions']//tbody/tr"));
		Assert.assertTrue(IssueList.size()==3, "Total 3 Checkpoints are not displayed");
		System.out.println("Toatl 3 CP are displayed");
		chiledTest.log(Status.INFO, "Toatl 3 CP are displayed");
	}
}

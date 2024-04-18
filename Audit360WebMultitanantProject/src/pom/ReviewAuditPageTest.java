package pom;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.SystemUtils;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class ReviewAuditPageTest extends BaseTest {

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Review Audit from side menu //ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Review Audit']
//	@FindBy(xpath="//span[text()='Review Audit']")
	@FindBy(xpath="(//span[text()='Review Audit'][@class='title'])[2]")//#SM
	private WebElement ReviewAudit;

	//Clicking on the Review Audit Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement ReviewAuditHeader;

	//Clicking on the Start Date
	@FindBy(xpath="//input[@id='start_date']")
	private WebElement Startdate;

	//Clicking on the To Date
	@FindBy(xpath="end_date")
	private WebElement EndDate;

	//passing the values to Search text field
	@FindBy(xpath="//input[@id='smart_search']")
	private WebElement SearchTextBox;

	//clicking on the Refresh button
	@FindBy(xpath="//button[@id='search_review_audits_list_filter']")
	private WebElement RefreshBTN;

	//Clicking on the 1st Main Audit TR
	@FindBy(xpath="//table[@id='newreviewauditsTableData']/tbody/tr[1]")
	private WebElement FirstTR;

	//Clicking on the 2nd Main Audit TR
	@FindBy(xpath="//table[@id='newreviewauditsTableData']/tbody/tr[2]")
	private WebElement SecondTR;

	//clicking on the Review button
	@FindBy(xpath="//button[@class='btn btn-finalize Reviewed_button']")
	private WebElement ReviewedBTN;

	//Clicking on the Select Sub audit drop down
	@FindBy(xpath="//div[@id='s2id_sub-audit-type']//a/span[@class='select2-chosen']")
	private WebElement SelectSubAuditType;

	//Passing the Values to Select sub audit Type
	@FindBy(xpath="//div[@id='select2-drop']/div//input")
	private WebElement SetSubAudits;

	//Passing the Values to Select Group
	@FindBy(xpath="//div[@id='s2id_review_group']//li[@class='select2-search-field']//input")
	private WebElement SetGroup;

	//Clicking on the Matched Option
	@FindBy(xpath="//div[@id='select2-drop']//ul/li[1]/div/span")
	private WebElement MatchOptions;

	//clicking on the Remove Button
	@FindBy(xpath="//a[@class='select2-search-choice-close']")
	private WebElement RemoveBTN;

	//clicking on the Group Finalize Button
	@FindBy(xpath="//a[contains(text(),'Finalize')]")
	private WebElement GroupFinalizeBTN;

	//clicking on the Sub Audit Finalize button//button[@class='btn btn-finalize Finalize_button']
	@FindBy(xpath="//button[contains(text(),'Finalize')]")
	private WebElement SubAuditFinalizeBTN;

	//clicking on the Main Audit Finalization button
	@FindBy(xpath="//a[text()='Main Audit Finalize']")
	private WebElement MainAuditFinalizeBTN;

	//clicking on the Select All Checkpoints
	@FindBy(xpath="//label[@for='all-check_points']")
	private WebElement SelectAllCheckpoints;

	//Clicking on the Select All Auditees
	@FindBy(xpath="//label[text()='Select All Sub Auditees']")
	private WebElement SelectAllAuditees;

	//Clicking on the Summary Button
	@FindBy(xpath="//a[@class='btn btn-primary btn-summary']")
	private WebElement SummaryBTN;

	//Clicking on the Submit Main Audit Button
	@FindBy(xpath="//a[text()='Submit Main Audit']")
	private WebElement SubmitMainAuditBTN;

	//clicking on the 1st Checkpoint//h5[text()='Select A Checkpoint']/following-sibling::ul/li[1]
	@FindBy(xpath="//label[contains(text(),'CP1')]")
	private WebElement FirstCP;

	//clicking on the 2nd Checkpoint
	@FindBy(xpath="//label[contains(text(),'CP2')]")
	private WebElement SecondCP;

	//clicking on the 3rd Checkpoint
	@FindBy(xpath="//label[contains(text(),'CP3')]")
	private WebElement ThirdCP;

	//clicking on the 4th Checkpoint
	@FindBy(xpath="//label[contains(text(),'CP4')]")
	private WebElement FourthCP;

	//clicking on the 5th Checkpoint
	@FindBy(xpath="//label[contains(text(),'CP5')]")
	private WebElement FifthCP;

	//clicking on the 6th Checkpoint
	@FindBy(xpath="//label[contains(text(),'CP6')]")
	private WebElement SixthCP;

	//clicking on the 7th Checkpoint
	@FindBy(xpath="//label[contains(text(),'CP7')]")
	private WebElement SeventhCP;

	//clicking on the 8th Checkpoint
	@FindBy(xpath="//label[contains(text(),'CP8')]")
	private WebElement EighthCP;

	//clicking on the Engine101 PI
	@FindBy(xpath="//label[contains(text(),'Engine101')]")
	private WebElement Engine101PI;

	//clicking on the Engine102 PI
	@FindBy(xpath="//label[contains(text(),'Engine102')]")
	private WebElement Engine102PI;

	//clicking on the Checkpoint Edit Button
	@FindBy(xpath="//table[@id='review_compliance_table']/tbody/tr[1]/td//button[@class='btn btn-edit']")
	private WebElement CheckpointEditBTN;

	//clicking on the Summary Pop up window close button
	@FindBy(xpath="//div[@id='modalSummary']//button[@class='close']")
	private WebElement SummaryCloseBTN;

	//Clicking on the Submit Audit Button
	@FindBy(xpath="//button[@class='btn btn-finalize provisionally_submitted_button']")
	private WebElement SubmitAuditBTN;

	//Clicking on the go Button
	@FindBy(xpath="//button[text()='Go']")
	private WebElement GoBTN;

	//Clicking on the Check Box
	@FindBy(xpath="//table[@id='reviewauditsTableData']/tbody/tr[1]/td[1]/input[@class='schedule_checkbox']")
	private WebElement CheckBox;

	//Passing the Values to select Audit type
	@FindBy(xpath="//div[@id='s2id_search_audit_type']//input[@type='text']")
	private WebElement SelectAuditType;

	//clicking on the Finalize Button
	@FindBy(xpath="//input[@value='Finalize']")
	private WebElement FinalizeBTN;

	//Passing the Values to Comments
	@FindBy(xpath="//textarea[@placeholder='Enter comments']")
	private WebElement Comments;

	//Upload Documents
	@FindBy(xpath="//input[@id='issue_audit_compliance_documents_attributes_0_document']")
	private WebElement ChooseFile;

	//Clicking on the Retain Issue Button
	@FindBy(xpath="//input[@value='Retain Issue']")
	private WebElement RetainIssueBTN;

	//Clicking on the Drop Issue Button
	@FindBy(xpath="//input[@value='Drop Issue']")
	private WebElement DropIssueBTN;

	//Clicking on the Back To Review Audits Button
	@FindBy(xpath="//a[text()='Back To Review Audits']")
	private WebElement BackToReviewAuditBTN;

	//Clicking on the My Audit Header
	@FindBy(xpath="//a[@class='active'][text()='ISSUE']")
	private WebElement IssuesHeader;

	//Clicking on the Bulk Finalize Audits Button
	@FindBy(xpath="//a[text()='Bulk Finalize Audits']")
	private WebElement BulkFinalizeAuditsBTN;

	//Clicking on the Select All Button
	@FindBy(xpath="//input[@id='audit_review_bulk_select_all']")
	private WebElement SelectALL;

	//Passing the Values to Bulk Finalize Tag Reason
	@FindBy(xpath="//div[@class='modal-body']//input[@name='selected_tags']")
	private WebElement BulkFinalizeTagReason;

	//Clicking on the Bulk Finalize Tag pop up Finalize Button
	@FindBy(xpath="//button[@class='btn btn-primary bulk_finalize_success']")
	private WebElement BulkFinalizeTagPopUpFinalizeBTN;

	//Clicking on the Bulk Finalize Tag pop up Cancel Button
	@FindBy(xpath="//button[@class='btn btn-default bulk_finalize_cancle']")
	private WebElement BulkFinalizeTagPopUpCancelBTN;

	//Checking the Triangle Button
	@FindBy(xpath="//i[@class='fa fa-exclamation-triangle']")
	private WebElement TriangleBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//a[text()='Submit']")
	private WebElement SubmitBTN;

	//Passing the Values to ReAudit Comments
	@FindBy(xpath="//textarea[@id='audit_schedule_reaudit_comment']")
	private WebElement SetReauditComment;

	//Passing the Values to Reaudit Start Date
	@FindBy(xpath="//input[@id='audit_schedule_reaudit_start_date']")
	private WebElement ReauditStartdate;

	//Passing the Values to Reaudit End Date
	@FindBy(xpath="//input[@id='audit_schedule_reaudit_end_date']")
	private WebElement ReauditEndDate;

	//clicking on the ReAudit Checkpoints button
	@FindBy(xpath="//input[@value='Reaudit Checkpoints']")
	private WebElement ReuditCheckpointsBTN;

	//clicking on the Main Audit Recommend Button
//	@FindBy(xpath="//a[text()='Main Audit Recommend']") //#SM..
	@FindBy(xpath="//a[@class='btn btn-finalize']")
	private WebElement MainAuditRecommendBTN;

	//clicking on the Recommend button
	@FindBy(xpath="//button[@class='btn btn-finalize Recommend_button']")
	private WebElement RecommendBTN;

	//clicking on the Accepted Status
	@FindBy(xpath="//td[text()='Accepted']")
	private WebElement Accepted;

	//clicking on the In progress Status
	@FindBy(xpath="//td[text()='In Progress']")
	private WebElement Inprogress;

	//clicking on the Simulate Score button
	@FindBy(xpath="//a[text()='Simulate Score']")
	private WebElement SimulateScoreBTN;

	//clicking on the audit closer button
	@FindBy(xpath="//button[contains(text(),'Audit Closure')]")
	private WebElement AuditCloserBTN;

	//passing the values to audit closer comment
	@FindBy(xpath="//textarea[@id='audit_schedule_closure_comment' and @required='true']")
	private WebElement AuditCloserComment;

	//clicking on the audit closer pop up OK Button
	@FindBy(xpath="//input[@value='Ok']")
	private WebElement AuditCloserPopUpOKBTN;

	//clicking on the audit closer pop up Cancel Button
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement AuditCloserPopUpCancelBTN;

	//clicking on the Add Checkpoint Pop up Yes Button
	@FindBy(xpath="//button[@class='btn btn-primary add_auditor_check_point']")
	private WebElement YesBTN;

	//********** Legends ***********
	//clicking on the In Review Legends
	@FindBy(xpath="//label[@id='in-review']//input")
	private WebElement InReviewLegends;

	//clicking on the New Checkpoint Legends
	@FindBy(xpath="//label[@id='new-checkpoint']//input")
	private WebElement NewCheckpointLegends;

	//clicking on the Review Successful Legends
	@FindBy(xpath="//label[@id='review-success']//input")
	private WebElement ReviewSuccessfulLegends;

	//clicking on the Spot Resolution Legends
	@FindBy(xpath="//label[@id='spot-resolution']//input")
	private WebElement SpotResolutionLegends;

	//clicking on the Direct Resolution Legends
	@FindBy(xpath="//label[@id='direct_resolution']//input")
	private WebElement DirectResolutionLegends;

	@FindBy(xpath="//select[@id='search_criteria']")
	private WebElement SelectAuditDropdown;
	
	public void ClickSpotResolutionLegends()
	{
		SpotResolutionLegends.click();
		System.out.println("Spot Resolution Legends is Clicked");
		chiledTest.log(Status.INFO, "Spot Resolution Legends is Clicked");
	}

	public void ClickDirectResolutionLegends()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(DirectResolutionLegends));
		DirectResolutionLegends.click();
		System.out.println("Direct Resolution Legends is Clicked");
		chiledTest.log(Status.INFO, "Direct Resolution Legends is Clicked");
	}

	public void ClickNewCheckpointLegends() throws InterruptedException 
	{
		NewCheckpointLegends.click();
		System.out.println("New Chekpoint Filter is Clicked");
		chiledTest.log(Status.INFO, "New Chekpoint Filter is Clicked");
	}

	public ReviewAuditPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ScrollBar));
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
		System.out.println("Clicked the Scroll Bar");
	}

	public void ClickReviewAudit(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ReviewAudit));

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReviewAudit);
		System.out.println("Review Audit Clicked");
	}


	public void ClickReviewAuditHeader(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReviewAuditHeader);
	}

	public void ClickCheckBox(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(CheckBox)).click();
	}

	public void ClickSubmitAuditBTN() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SubmitAuditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitAuditBTN);
		System.out.println("Submit Audit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Audit Button is Clicked");
	}

	public void ClickSummaryCloseBTN()
	{
		SummaryCloseBTN.click();
		System.out.println("Close Button is Clicked");
	}

	public void ClickSimulateScoreBTN()
	{
		SimulateScoreBTN.click();
		System.out.println("Simulate Score Button is Clicked");
		chiledTest.log(Status.INFO, "Simulate Score Button is Clicked");
	}

	public void ClickFirstCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(FirstCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", FirstCP);
		System.out.println("First Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "First Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);

	}


	public void ClickSecondCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SecondCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SecondCP);
		System.out.println("Second Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "Second Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);

	}


	public void ClickThirdCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ThirdCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ThirdCP);
		System.out.println("Third Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "Third Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);

	}

	public void ClickFourthCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(FourthCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", FourthCP);
		System.out.println("Fourth Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "Fourth Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);

	}

	public void ClickfifthCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(FifthCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", FifthCP);
		System.out.println("Fifth Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "Fifth Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);
	}

	public void ClickSixthCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SixthCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SixthCP);
		System.out.println("Sixth Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "Sixth Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);

	}

	public void ClickSeventhCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SeventhCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SeventhCP);
		System.out.println("Seventh Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "Seventh Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);

	}

	public void ClickEightCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(EighthCP));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EighthCP);
		System.out.println("Eighth Checkpoint Radio button is clicked");
		chiledTest.log(Status.INFO, "Eighth Checkpoint Radio button is clicked");
		
		Thread.sleep(2000);

	}

	public void ClickEingine101PI() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Engine101PI)).click();
		System.out.println("Engine101 PI is clicked");
		chiledTest.log(Status.INFO, "Engine101 PI is clicked");
	}

	public void ClickEingine102PI() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Engine102PI)).click();
		System.out.println("Engine102 PI is clicked");
		chiledTest.log(Status.INFO, "Engine102 PI is clicked");

	}

	public void Verify8CheckpointsAreDisplayed() throws InterruptedException
	{
		Thread.sleep(3000);
		//verifying 8 Checkpoints is Displayed or not
		List<WebElement> CPs = driver.findElements(By.xpath("//ul[@class='check_point-list check-point-list list-group']/li"));
		int Actaul_Count = CPs.size();
	//	int Expected_Count = 8; //##SM
		int Expected_Count = 9;
		Assert.assertEquals(Actaul_Count, Expected_Count, "9 Checkpoints are Not Displayed");
		System.out.println("Toatl 9 CP are Displayed");
		chiledTest.log(Status.INFO, "Toatl 9 CP are Displayed");
	}

	public void Verify10CheckpointsAreDisplayed() throws InterruptedException
	{
		Thread.sleep(3000);
		//verifying 8 Checkpoints is Displayed or not
		List<WebElement> CPs = driver.findElements(By.xpath("//ul[@class='check_point-list check-point-list list-group']/li"));
		int Actaul_Count = CPs.size();
		int Expected_Count = 10;
		Assert.assertEquals(Actaul_Count, Expected_Count, "10 Checkpoints are Not Displayed");
		System.out.println("Toatl 10CP are Displayed");
		chiledTest.log(Status.INFO, "Toatl 10 CP are Displayed");
	}

	public void Verify3CheckpointsAreDisplayed() throws InterruptedException
	{
		//verifying 8 Checkpoints is Displayed or not
		List<WebElement> CPs = driver.findElements(By.xpath("//div[@class='checkbox-list']//ul[@class='check_point-list check-point-list list-group']//li"));
		int Actaul_Count = CPs.size();
		int Expected_Count = 3;
		Assert.assertEquals(Actaul_Count, Expected_Count, "Only 3 Checkpoints should Displayed");
		System.out.println("3 checkpoint is Displayed");
		chiledTest.log(Status.INFO, "3 checkpoint is Displayed");
	}

	public void Verify1CheckpointsAreDisplayed() throws InterruptedException
	{
		//verifying 1 Checkpoints is Displayed or not
		List<WebElement> CPs = driver.findElements(By.xpath("//div[@class='checkbox-list']//ul[@class='check_point-list check-point-list list-group']//li"));
		int Actaul_Count = CPs.size();
		int Expected_Count = 1;
		Assert.assertEquals(Actaul_Count, Expected_Count, "only 1 Checkpoints should Displayed");
		System.out.println("1 checkpoint is Displayed");
		chiledTest.log(Status.INFO, "1 checkpoint is Displayed");
	}

	public void Verify2CheckpointsAreDisplayed()
	{
		List<WebElement> CPcount1 = driver.findElements(By.xpath("//div[@class='checkbox-list']//ul[@class='check_point-list check-point-list list-group']//li"));
		int Actual_CPcount1 = CPcount1.size();
		int Expected_CPcount1 = 2;
		Assert.assertEquals(Actual_CPcount1, Expected_CPcount1, "Only 2 checkpoint should display");
		System.out.println("2 checkpoint is Displayed");
		chiledTest.log(Status.INFO, "2 checkpoint is Displayed");
	}

	public void ClickRemoveBTN() throws InterruptedException
	{
		try
		{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(RemoveBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", RemoveBTN);
			System.out.println("Remove Button is Clicked");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}

	}

	public void ClickCheckpointEditBTN() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(CheckpointEditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CheckpointEditBTN);
		System.out.println("Checkpoint edit button is Clicked");
		chiledTest.log(Status.INFO, "Checkpoint edit button is Clicked");
		Thread.sleep(2000);
	}

	public void ClickSelectSubAuditType() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SelectSubAuditType)).click();
	}

	public void SetSubAudits(String SA)
	{
		SetSubAudits.sendKeys(SA);
		System.out.println("Selected Sub Audit Type is : " + SA);
		chiledTest.log(Status.INFO, "Sub Audit Type is Selected");
	}

	public void SetGroup(String SA) throws Exception
	{
		Thread.sleep(2000); //#SM
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SetGroup));
		SetGroup.sendKeys(SA);
		System.out.println("Selected Group is : " + SA);
		chiledTest.log(Status.INFO, "Group is Selected");
	}

	public void SetStartDate(String SD)
	{
		Startdate.sendKeys(SD);
		System.out.println("Entered Start date is :" + SD);
		chiledTest.log(Status.INFO, "Start date is Entered");
	}

	public void SetEndDate(String ED)
	{
		EndDate.sendKeys(ED);
		System.out.println("Entered End date is :" + ED);
		chiledTest.log(Status.INFO, "End date is Entered");
	}

	public void ClickRefreshButton()
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(RefreshBTN));

		RefreshBTN.click();
		System.out.println("Refresh button is clicked");
		chiledTest.log(Status.INFO, "Refresh button is clicked");
	}


	public void SetSearchTextBox(String SB)
	
	{ 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SelectAuditDropdown)).click();
		Select objSelect =new Select(SelectAuditDropdown);
		objSelect.selectByValue("audit_type");
		
		
		wait.until(ExpectedConditions.visibilityOf(SearchTextBox));

		SearchTextBox.sendKeys(SB);
		System.out.println("Audit Type is Enterd in Search text field");
		System.out.println("Searched Audit Type is : " + SB);
		chiledTest.log(Status.INFO, "Audit Type is Searched");
	}

	public void ClickFirstTR(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(FirstTR)).click();
	}

	public void ClickSecondTR(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SecondTR)).click();
	}

	public void ClickMatchedTextOption(WebDriver driver)
	{
		//#SM
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(MatchOptions));
		MatchOptions.click();
	}

	public void ClickReviewedBTN() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ReviewedBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReviewedBTN);
		System.out.println("Reviewed Button is Clicked");
		chiledTest.log(Status.INFO, "Reviewed Button is Clicked");
	}

	public void ClickGroupFinalizeButton() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(GroupFinalizeBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", GroupFinalizeBTN);
		System.out.println("Finalize Button is Clicked");
		chiledTest.log(Status.INFO, "Finalize Button is Clicked");
	}

	public void ClickSubAuditFinalizeButton() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SubAuditFinalizeBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubAuditFinalizeBTN);
		System.out.println("Finalize Button is Clicked");
		chiledTest.log(Status.INFO, "Finalize Button is Clicked");
	}

	public void ClickMainAuditFinalizeBTN() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(MainAuditFinalizeBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", MainAuditFinalizeBTN);
		System.out.println("Main Audit Finalize Button is Clicked");
		chiledTest.log(Status.INFO, "Main Audit Finalize Button is Clicked");

	}

	public void ClickSelectAllAuditees() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SelectAllAuditees)).click();
		System.out.println("select All auditee is Clicked");
		chiledTest.log(Status.INFO, "select All auditee is Clicked");
	}

	public void ClickSelectAllCheckpoints() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SelectAllCheckpoints)).click();
		System.out.println("select All Checkpoints is Clicked");
		chiledTest.log(Status.INFO, "select All Checkpoints is Clicked");
	}

	public void ClickSummaryBTN()
	{
		SummaryBTN.click();
		System.out.println("Summary button is clicked");
		chiledTest.log(Status.INFO, "Summary button is clicked");
	}

	public void ClickSubmitMainAuditBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SubmitMainAuditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitMainAuditBTN);
		System.out.println("Submit Main Audit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Main Audit Button is Clicked");
	}

	public void ClickGoBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", GoBTN);
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}

	public void ClickReuditCheckpointsButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReuditCheckpointsBTN);
		System.out.println("Reudit Checkpoints Button is Clicked");
		chiledTest.log(Status.INFO, "Reudit Checkpoints Button is Clicked");
	}

	public void SetReauditStartDate(String SD)
	{
		ReauditStartdate.clear();

		ReauditStartdate.sendKeys(SD);
		System.out.println("Entered Reaudit start Date is : " + SD);
		chiledTest.log(Status.INFO, "Reaudit start date is Entered");

	}

	public void SetReauditEndDate(String SD)
	{
		ReauditEndDate.clear();

		ReauditEndDate.sendKeys(SD);
		System.out.println("Entered Reaudit start Date is : " + SD);
		chiledTest.log(Status.INFO, "Reaudit end date is Entered");

		ReauditEndDate.sendKeys(Keys.ESCAPE);
	}


	public void SetReauditCommnet(String RC)
	{
		try{
			SetReauditComment.sendKeys(RC);
			System.out.println("Entered Reaudit Comment is : " + RC);
			chiledTest.log(Status.INFO, "Reaudit Comment is Entered");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}

	}

	public void ClickAuditCloserButton()
	{
		AuditCloserBTN.click();
		System.out.println("Audit Close button is clicked");
		chiledTest.log(Status.INFO, "Audit Close button is clicked");
	}

	public void VerfiyAuditCloserCommentsPopUpIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement AuditCloserPOpUp = driver.findElement(By.xpath("//h4[text()='Audit Closure Comments']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(AuditCloserPOpUp)).isDisplayed(), "Audit Closer Pop Up is Not Displayed");
		System.out.println("Audit Closer Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Audit Closer Pop Up is Displayed");
	}

	public void SetAuditCloserComment(String CM)
	{
		AuditCloserComment.sendKeys(CM);
		System.out.println("Enterd Audit Closer comment is" + CM);
		chiledTest.log(Status.INFO, "Audit Closer comment is Entered");
	}

	public void ClickAuditCloserPopUpOKButton()
	{
		AuditCloserPopUpOKBTN.click();
		System.out.println("OK Button is Clicked");
		chiledTest.log(Status.INFO, "OK Button is Clicked");
	}

	public void ClickAuditCloserPopUpCancelButton()
	{
		AuditCloserPopUpCancelBTN.click();
		System.out.println("cancel Button is Clicked");
		chiledTest.log(Status.INFO, "Cancel Button is Clicked");
	}

	public void VerifyAuditHasBeenClosedSuccessMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement SuccessMSG = driver.findElement(By.xpath("//span[text()='Audit has been closed successfully']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Audit has been closed successfully Message is Not Displayed");
		System.out.println("Audit has been closed successfully Message is Displayed");
		chiledTest.log(Status.INFO, "Audit has been closed successfully Message is Displayed");
	}



	public void ClickYesButton()
	{
		YesBTN.click();
		System.out.println("Yes Button is Clicked");
		chiledTest.log(Status.INFO, "Yes Button is Clicked");
	}

	public void VerifyAuditFinalizedSuccessfullySuccessMsgIsDisplayed(WebDriver driver)
	{
		/*WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_SuccessMSG = SuccessMSG.getText();
			String Actaul_SuccessMSG = "Audit Finalized Successfully";
			Assert.assertEquals(Expected_SuccessMSG, Actaul_SuccessMSG);
			System.out.println("Pass : Audit Finalized Successfully Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}*/
	}

	public void ClickSubmitBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitBTN);
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void VerifyTriangleButtonIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(TriangleBTN)).isDisplayed())
		{
			System.out.println("Pass : Triangle Button is Displayed");
			chiledTest.log(Status.INFO, "Pass : Triangle Button is Displayed");
		}else
		{
			System.out.println("Fail : Triangle Button is Displayed");
			chiledTest.log(Status.INFO, "Fail : Triangle Button is Displayed");
		}
	}

	public void SetComments(String SC)
	{
		Comments.sendKeys(SC);
		System.out.println("Entered Comments is : " + SC);
	}

	public void SetBulkFinalizeTagReason(String BFR)
	{
		BulkFinalizeTagReason.sendKeys(BFR);
		System.out.println("Entered Bulk Finalize Tag Reason is : " + BFR);
	}


	public void ClickFinalizeBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", FinalizeBTN);
		System.out.println("Finalize button is Clicked");
		chiledTest.log(Status.INFO, "Finalize button is Clicked");
	}

	public void SetSelectAuditType(String SAT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SelectAuditType)).sendKeys(SAT);
		System.out.println("serached Select Audit Type is : " + SAT);

	}

	public void ClickRetainIssueBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RetainIssueBTN);
	}

	public void ClickDropIssueBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DropIssueBTN);
	}

	public void ClickBackToReviewAuditBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", BackToReviewAuditBTN);
	}


	public void ClickBulkFinalizeTagPopUpFinalizeBTN()
	{
		BulkFinalizeTagPopUpFinalizeBTN.click();
		System.out.println("Finalize button is Clicked under Bulk Finalize Tag Pop Up");
	}

	public void ClickBulkFinalizeTagPopUpCancelBTN()
	{
		BulkFinalizeTagPopUpCancelBTN.click();
		System.out.println("Cancel button is Clicked under Bulk Finalize Tag Pop Up");
	}


	public void VerifyIssuesPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(IssuesHeader));
		Assert.assertTrue(IssuesHeader.isDisplayed(), "Issue Page Is Displayed");
		System.out.println("Issue Page is Displayed");
	}


	public void ClickBulkFinalizeAuditsBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(BulkFinalizeAuditsBTN)).click();
	}

	public void ClickMainAuditRecommendBTN()
	{
		//button[@class='btn btn-finalize Recommend_button']
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(MainAuditRecommendBTN));
		MainAuditRecommendBTN.click();
		System.out.println("Main Audit Recommend Button is Clicked");
		chiledTest.log(Status.INFO, "Main Audit Recommend Button is Clicked");
	}

	public void ClickRecommendButton()
	{
		RecommendBTN.click();
		System.out.println("Recommend Button is Clicked");
		chiledTest.log(Status.INFO, "Recommend Button is Clicked");
	}

	public void VerifyMainAuditRecommendButtonIsNotDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> MainAuditeRcommendBTN = driver.findElements(By.xpath("//a[text()='Main Audit Recommend']"));
		Assert.assertTrue(MainAuditeRcommendBTN.size()<=0, "Main Audit Recommend Button is Displayed");
		System.out.println("Main Audit Recommend Button is Not Displayed");
		chiledTest.log(Status.INFO, "Main Audit Recommend Button is Not Displayed");

	}

	public void VerifyRecommendBttonIsNotDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> RecommendBTN = driver.findElements(By.xpath("//button[@class='btn btn-finalize Recommend_button']"));
		Assert.assertTrue(RecommendBTN.size()<=0, "Recommedn button is Displayed");
		System.out.println("Recommend Button is Not Displayed");
		chiledTest.log(Status.INFO, "Recommend Button is Not Displayed");
	}

	public void VerifyReviewButtonShouldNotDisplay() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> ReviewButton = driver.findElements(By.xpath("//button[@class='btn btn-finalize Reviewed_button']"));
		Assert.assertTrue(ReviewButton.size()<=0, "Review button is Displayed before Handle Issue");
		System.out.println("Review Button is Not Displayed");
		chiledTest.log(Status.INFO, "Review Button is Not Displayed");
	}

	public void VerifyReviewBTNIsDisabled()
	{
		WebElement ReviewBTN = driver.findElement(By.xpath("//button[@class='btn btn-finalize Reviewed_button' and @disabled]"));
		Assert.assertTrue(ReviewBTN.isDisplayed(), "Review Button is not in Read only mode");
		System.out.println("Review Button is Read only mode");
		chiledTest.log(Status.INFO, "Review Button is read only mode");
	}

	public void ClickAcceptedStatus()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Accepted);
		System.out.println("Accepted status is Clicked");
		chiledTest.log(Status.INFO, "Accepted status is Clicked");
	}

	public void VerfiyInProgressStatusIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Inprogress)).isDisplayed(), "Inprogress status is Not Displayed");
		System.out.println("Inprogress status is Displayed");
		chiledTest.log(Status.INFO, "Inprogress status is Displayed");
	}



	public void VerifyReviewAuditPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking Review Audit Header
		WebElement ReviewAuditHeader = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(ReviewAuditHeader)).isDisplayed())
		{
			String Expected_Text = ReviewAuditHeader.getText();
			String Actual_Text = "REVIEW AUDIT";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : REVIEW AUDIT Page is Displayed");
		}

	}

	public void VerifySearchedReviewAuditisDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath("//td[@class='sorting_1']")).isDisplayed();
			System.out.println("Pass : Audits Are Displyed");
		}
		catch(Exception e){
			driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isDisplayed();
			System.out.println("Pass : No data available in table Message is Displayed");
		}

	}



	public void VerifyAuditSubmitedSuccessfullySuccessMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_SuccessMSG = SuccessMSG.getText();
			String Actaul_SuccessMSG = "Audit Submitted Successfully";
			Assert.assertEquals(Expected_SuccessMSG, Actaul_SuccessMSG);
			System.out.println("Pass : Audit Submited successfully Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}


	public void VerifyMainAuditFinalizedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_SuccessMSG = SuccessMSG.getText();
			String Actaul_SuccessMSG = "Main Audit Finalized Successfully";
			Assert.assertEquals(Expected_SuccessMSG, Actaul_SuccessMSG);
			System.out.println("Pass : Main Audit Finalized Successfully Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}

	public void VerifyBulkFinalizedHasBeenSuccessfullyDoneMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_SuccessMSG = SuccessMSG.getText();
			String Actaul_SuccessMSG = "Audit has been submitted for finalization, this operation might take few minutes";
			Assert.assertEquals(Expected_SuccessMSG, Actaul_SuccessMSG);
			System.out.println("Pass : Bulk finalized has been successfully done. Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}

	public void VerifyCalenderIsDisplayedOrNot(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Calender = driver.findElement(By.xpath("//div[contains(@class,'datepicker-days')]"));
		wait.until(ExpectedConditions.visibilityOf(Calender));
		Assert.assertTrue(Calender.isDisplayed(), "Calender is Displayed");
		System.out.println("Pass :  Calender is Displayed");
	}

	public void VerifyCheckPointCount(WebDriver driver)
	{
		//Checking the Check Point Count
		List<WebElement> CheckPointsCounts = driver.findElements(By.xpath("//table[@id='tableWithSearchSummary']/tbody/tr"));
		int Actual_Count = CheckPointsCounts.size();
		int Expected_Count = 4;
		Assert.assertEquals(Actual_Count, Expected_Count, "CheckPoint Count Are Wrong");
		System.out.println("Total 4 CP are Displayed");
		chiledTest.log(Status.INFO, "Toatl 4 CP are Displayed");
	}

	public void Verify5CheckPointAreDisplayed(WebDriver driver) throws InterruptedException
	{
		List<WebElement> CheckPointsCounts = driver.findElements(By.xpath("//ul[@class='check_point-list check-point-list list-group']//li"));
		int Actual_Count = CheckPointsCounts.size();
		int Expected_Count = 5;
		Assert.assertEquals(Actual_Count, Expected_Count, "5 CP Are Not Displayed");
		System.out.println("Total 5 CP are Displayed");
		chiledTest.log(Status.INFO, "Toatl 5 CP are Displayed");
	}

	public void VerifyBulkFinalizeTagPopUpIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement BulkFinalizeTag = driver.findElement(By.xpath("//h4[@class='modal-title']"));
		if(wait.until(ExpectedConditions.visibilityOf(BulkFinalizeTag)).isDisplayed())
		{
			String Actual_Text = BulkFinalizeTag.getText();
			String Expected_Text = "Bulk Finalize Tag";
			Assert.assertEquals(Actual_Text, Expected_Text, "Pop Up Header is Wrong");
			System.out.println("Bulk Finalize Tag Pop Up Is Displayed");
			chiledTest.log(Status.INFO, "Bulk Finalize Tag Pop Up Is Displayed");
		}
	}

	public void VerifyAtleasetOneScheduleShouldBeselectedPopUpIsDisplayed()
	{
		Alert alert = driver.switchTo().alert();
		String Actual_Text1 = alert.getText();
		String Expected_Text1 = "Alteast 1 schedule should be selected.";
		Assert.assertEquals(Actual_Text1, Expected_Text1, "Alteast 1 schedule should be selected. Pop Is Displayed");
		System.out.println("Pass : Alteast 1 schedule should be selected. Pop Is Displayed");
		chiledTest.log(Status.INFO, "Alteast 1 schedule should be selected. Pop Is Displayed");

		alert.accept();
	}

	public void VerifyScheduleIsUpdatedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actaul_Text = SuccessMSG.getText();
			String Expected_Text = "Schedule is updated successfully.";
			Assert.assertEquals(Actaul_Text, Expected_Text);
			System.out.println("Pass :  Schedule is updated successfully. Message is Displayed");
			chiledTest.log(Status.INFO, "Schedule Is Updated Successfully Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}

	}

	public void VerifyReauditAcceptedStatuISDisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ReAuditAccepted = driver.findElement(By.xpath("//table[@id='newreviewauditsTableData']/tbody//span[text()='Reaudit Accepted']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(ReAuditAccepted)).isDisplayed(), "ReAudit Accepted status is Not Displayed");
		System.out.println("ReAudit Accepted status is Displayed");
		chiledTest.log(Status.INFO, "ReAudit Accepted status is Displayed");
	}

	public void VerifyRecommendedSuccessfullyMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement RecommendedSuccessMSG = driver.findElement(By.xpath("//span[contains(text(),'Recommended successfully')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(RecommendedSuccessMSG)).isDisplayed(), "Recommended successfully Message is Not Diplayed");
		System.out.println("Recommended successfully Message is Diplayed");
		chiledTest.log(Status.INFO, "Recommended successfully Message is Diplayed");
	}

	public void VerifyProvisionallySubmittedStatusIsDisplayed()
	{
		WebElement PSS = driver.findElement(By.xpath("//span[contains(text(),'Provisionally Submitted')]"));
		Assert.assertTrue(PSS.isDisplayed(), "Provisionally Submitted Status is NOT Showing in Summary Page");
		System.out.println("Provisionally Submitted Status is Showing in Summary Page");
		chiledTest.log(Status.INFO, "Provisionally Submitted Status is Showing in Summary Page");
	}

	public void VerifyPleaseConfirmHavingSelectedAllRequiredCheckPointsForReauditPopIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement RecommendedSuccessMSG = driver.findElement(By.xpath("//p[contains(text(),'Please confirm having selected all required check points for re-audit')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(RecommendedSuccessMSG)).isDisplayed(), "Please confirm having selected all required check points for re-audit Pop is Not Diplayed");
		System.out.println("Please confirm having selected all required check points for re-audit Popup is Diplayed");
		chiledTest.log(Status.INFO, "Please confirm having selected all required check points for re-audit Popup is Diplayed");

		//clicking on the OK Button
		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block m-t-5 confirm']")).click();

	}

	public void VerifyDoYouWishToAddThisCheckpointPermenantlyPopUpIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement DoYouWish = driver.findElement(By.xpath("//div[contains(text(),'Do you wish to add this checkpoint permenantly')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(DoYouWish)).isDisplayed(), "Do you wish to add this checkpoint permenantly Pop Up Is Not Displayed");
		System.out.println("Do you wish to add this checkpoint permenantly Popup is Diplayed");
		chiledTest.log(Status.INFO, "Do you wish to add this checkpoint permenantly Popup is Diplayed");
	}

	public void verifyCheckpointAddedSuccessfullyMsgIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement CPsuccessMSG = driver.findElement(By.xpath("//span[text()='Checkpoint added successfully']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(CPsuccessMSG)).isDisplayed(), "Checkpoint added successfully Msaage is Not Displayed");
		System.out.println("Checkpoint added successfully Msaage is Diplayed");
		chiledTest.log(Status.INFO, "Checkpoint added successfully Msaage is Diplayed");

		//clicking on the Close button
		driver.findElement(By.xpath("//div[@class='alert alert-success']//button")).click();
	}

	public void VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actaul_Text = SuccessMSG.getText();
			String Expected_Text = "Compliance was successfully updated.";
			Assert.assertEquals(Actaul_Text, Expected_Text);
			System.out.println("Pass : Compliance was successfully updated Message is Displayed");
		}

	}

	public void VerifyResolutionIsDoneSucessMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement SuccessMSG = driver.findElement(By.xpath("//span[text()='Resolution is done.']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Resolution Is Done Message is Not Displayed");
		System.out.println("Resolution is Done success Msaage is Diplayed");
		chiledTest.log(Status.INFO, "Resolution is Done succsuccess Msaage is Diplayed");

	}





}




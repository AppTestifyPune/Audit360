package pom;

import static org.testng.Assert.expectThrows;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;

public class AuditExecutionPageTest extends BaseTest {

	//Clicking on the Issues Button
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeBTN;

	//Clicking on the Issues Button
	@FindBy(xpath="//a[@class='btn btn-primary']/b[text()='Issues']")
	private WebElement IssuesBTN;

	//Clicking on the Create Scedule Button
	@FindBy(xpath="//a[@class='btn btn-primary']/b[text()='Create Schedule']")
	private WebElement CreateSceduleBTN;

	//Passing the Values to Audit Type
	@FindBy(xpath="//div[@id='s2id_my_audits_audit_types']//input[@type='text']")
	private WebElement AuditType;

	//Passing the Values to Auditee 
	@FindBy(xpath="//div[@id='s2id_my_audits_auditee_ids']//input[@type='text']")
	private WebElement Auditee;

	//Passing the Values to Execution Status
	@FindBy(xpath="//div[@id='s2id_my_audits_execution_status']//input[@type='text']")
	private WebElement ExecutionStatus;

	//Passing the Values to From Date
	@FindBy(xpath="//input[@id='my_audits_start_date']")
	private WebElement FromDate;

	//Passing the Values to From Date
	@FindBy(xpath="//input[@id='my_audits_end_date']")
	private WebElement EndDate;

	//Clicking on the Matched
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Accept Button//div[@id='step2']/div[1]/div[4]/div/div[1]/a[contains(text(),'Accept')]
	@FindBy(xpath="//a[contains(text(),'Accept')]")   
	private WebElement AcceptBTN;

	//Clicking on the Modify Button
	@FindBy(xpath="//button[@id='dropdownMenuButton']")   
	private WebElement ModifyBTN;

	//Clicking on the Reject Button
	@FindBy(xpath="//a[contains(text(),'Reject')]")
	private WebElement RejectBTN;

	//Clicking on the Reassign Button
	@FindBy(xpath="//a[contains(text(),'Reassign')]")
	private WebElement ReassignBTN;

	//Clicking on the Edit Schedule Button
	@FindBy(xpath="//a[contains(text(),'Edit Schedule')]")
	private WebElement EditScheduleBTN;

	//Clicking on the Request For Extension
	@FindBy(xpath="//button[contains(text(),'Request For Extension')]")
	private WebElement ReqestForExtensionBTN;

	//Clicking on the Reschedule button
	@FindBy(xpath="//button[contains(text(),'Reschedule')]")
	private WebElement RescheduleBTN;

	//Clicking on the RLead Auditor not accepted button
	@FindBy(xpath="//a[contains(text(),'Lead Auditor not accepted')]")
	private WebElement LeadAuditorNotAcceptedBTN;

	//Clicking on the Start Button
	@FindBy(xpath="//table[@id='tableWithSearch']/tbody/tr[1]/td[3]/a[contains(text(),'start')]")
	private WebElement StartBTN;

	//Clicking on the start Button////table[@id='tableWithSearchSummary']/tbody/tr[1]/td[5]/a[@class='btn btn-primary prime-btn btn-block all-caps choose_execution_type']
//oldone	@FindBy(xpath="//table[@id='tableWithSearchSummary']/tbody/tr[1]/td[5]/a[@class='btn btn-primary prime-btn btn-block all-caps choose_execution_type ']")
//	private WebElement PIStartBTN;
	
	@FindBy(xpath="//table[@id='tableWithSearchSummary']/tbody/tr[1]/td[6]/a[@class='btn btn-primary prime-btn btn-block all-caps choose_execution_type ']")
	private WebElement PIStartBTN;

	//Clicking on the Not Started Button
	@FindBy(xpath="//div[@id='step2']/div[1]/div[4]/div/div/a[contains(text(),'Not Start')]")
	private WebElement NotStartedBTN;

	//Clicking on the Normal mode
	@FindBy(xpath="//a[text()='Normal']")
	private WebElement normal;

	//Clicking on the Express Mode
	@FindBy(xpath="//a[text()='Express']")
	private WebElement Express;

	//Passing the Values to Enter Remarks
	@FindBy(xpath="//textarea[@placeholder='Enter Remarks']")
	private WebElement EnterRemarks;

	//Passing the Value to Express mode Remarks
	@FindBy(xpath="//label[contains(text(),'Enter Remarks')]/following-sibling::textarea")
	private WebElement ExpressRemarks;

	//Passing the Values to Enter Confidental Remarks
	@FindBy(xpath="//textarea[@placeholder='Enter Confidential Remarks...']")
	private WebElement EnterConfidentalRemarks;

	//Passing the Value to Express mode Confidental Remarks
	@FindBy(xpath="//label[contains(text(),'Enter Confidential Remarks')]/following-sibling::textarea")
	private WebElement ExpressConfidentalRemarks;

	//Clicking on the Yes Button
	@FindBy(xpath="//input[@value='Yes']/ancestor::label")
	private WebElement YesButton;

	//Clicking on the No Button
	@FindBy(xpath="//input[@value='No']/ancestor::label")
	private WebElement NoButton;

	//Clicking on the Partial Button//input[@value='Partial']/ancestor::label
	@FindBy(xpath="//input[@value='Partial']/ancestor::label") 
	private WebElement PartialButton;

	//Clicking on the NA Button//input[@value='NA']/ancestor::label
	@FindBy(xpath="//input[@value='NA']/ancestor::label")
	private WebElement NAButton;

	//Clicking on the Dispositions
	@FindBy(xpath="//ul[@class='select2-choices']")
	private WebElement Dispositions;

	//Clicking on the Next Button
	@FindBy(xpath="//input[@id='valid_btn'][@value='Next']")
	private WebElement NextBTN;

	//Clicking on the Please Select
	@FindBy(xpath="//div[@id='s2id_audit_compliance_input_value']")
	private WebElement ValuesDropDownList;

	//Passing the Values to Enter Input Values text fields  //input[@id='audit_compliance_input_value']
	@FindBy(xpath="//input[@placeholder='Enter Input values']")    
	private WebElement EnterInputValues1;

	//Passing the Values to Enter Input Values text fields
	@FindBy(xpath="//textarea[@id='audit_compliance_input_value']")
	private WebElement EnterInputValues2;

	//Passing the Values to Search Button
	@FindBy(xpath="//label[contains(text(),'Search')]/input")
	private WebElement SearchBTN;

	//Passing the values to search 
	@FindBy(xpath="//div[@id='tableWithSearchSummary_filter']//input[@class='form-control']")
	private WebElement PiSearchBTN;

	//Clicking on the Ok Button
	@FindBy(xpath="//a[contains(text(),'Ok')]")
	private WebElement OKBTN1;

	//Clicking on the Complete Button
	@FindBy(xpath="//a[contains(text(),'completed')]")
	private WebElement CompleteBTN;

	//Clicking on the Submitted Button
	@FindBy(xpath="//button[@class='btn btn-primary prime-btn btn-block all-caps']")
	private WebElement SubmittedBTN;

	//Clicking on the Accept Button
	@FindBy(xpath="//a[contains(text(),'Accepted')]")
	private WebElement AcceptedButton;

	//Clicking on the Submit Audit Button
	@FindBy(xpath="//a[contains(text(),'Submit Audit')]")
	private WebElement SubmitAuditBTN;

	//Clicking on the Past Audits
	@FindBy(xpath="//a[@data-toggle='tab'][text()=' Past Audits']")
	private WebElement PastAudits;

	//Clicking on the View Audit Info Button
	@FindBy(xpath="//a[text()='VIEW AUDIT INFO']")
	private WebElement ViewAuditInfoBTN;

	//Clicking on the Not Found Button
	@FindBy(xpath="//label[@data-button='not_found']")
	private WebElement NotFoundBTN;

	//Clicking on the Please Select
	@FindBy(xpath="//div[@id='s2id_annexure_configure_reason']/a/span[text()='Please Select']")
	private WebElement PleaseSelect;

	//Passing the Values to Reason
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement Reason;

	//Clicking on the Submit button
	@FindBy(xpath="//div[contains(@class,'modal-footer')]//input[contains(@name,'commit')]")
	private WebElement SubmitBTN;

	//Clicking on the Add New Pi Button
	@FindBy(xpath="//a[@class='btn btn-primary btn-block all-caps add_new_pi'][text()='Add New PI']")
	private WebElement AddNewPIBTN;

	//Clicking on the save Button
	@FindBy(xpath="//div[contains(@class,'col-md-6 col-xs-12')]//input[@name='commit']")
	private WebElement SaveBTN;

	//Passing the Values to Primary Identifier Name
	@FindBy(xpath="//div[contains(@class,'form-group form-group-default required')]/input[@id='sub_auditee_name']")
	private WebElement PrimaryIdentifierName;

	//Clicking on the Completed Tab
	@FindBy(xpath="//a[@data-toggle='tab'][text()='Completed']")
	private WebElement CompletedTab;

	//Clicking on the Completed Tab
	@FindBy(xpath="//a[@data-toggle='tab'][text()='Not Executed']")
	private WebElement NotExecuatedTab;

	//Verifying In progress Button is displayed
	@FindBy(xpath="//a[contains(text(),'In Progress')]")
	private WebElement InProgressBTN;

	//Clicking on the Confidential Check Box
	@FindBy(xpath="//div[@class='row m-t-10']/div[1]/div/div/input[@type='checkbox']")
	private WebElement ConfidentialCheckBox;

	//Clicking on the Next Button
	@FindBy(xpath="//button[@class='btn btn-primary btn-cons m-b-10 ed btn-lg btn-larger next_express_li']")
	private WebElement ExpressModeVerifyTabNextButton; 

	//Clicking on the Next Button
	@FindBy(xpath="//button[@class='btn btn-primary btn-cons m-b-10 ed btn-lg btn-larger input_li activate_next_li partial_next_btn']")
	private WebElement ExpressModePartialTabNextButton;

	//Clicking on the Next Button 
	@FindBy(xpath="//button[@class='btn btn-primary btn-cons m-b-10 ed btn-lg btn-larger not_job_done_finish activate_next_li validate_field ']")
	private WebElement ExpressModeInputTabNextButton;

	//Clicking on the Next Button 
	@FindBy(xpath="//button[@class='btn btn-primary btn-cons m-b-10 ed btn-lg btn-larger not_job_done_finish activate_next_li validate_field spot_tab_enabled']")
	private WebElement ExpressModeInputTabNextButton1;

	//clicking on the Spot Resolution TAb Next button
	@FindBy(xpath="//button[@class='btn btn-primary btn-cons m-b-10 ed btn-lg btn-larger not_job_done_finish activate_next_li ']")
	private WebElement ExpressModeSpotResolutionTabNextButton;

	//Passing the Values to Text And Number
	@FindBy(xpath="//label[text()='Text And Numbers']/following-sibling::textarea[@placeholder='Enter Input values']")
	private WebElement TextAndNumber;

	//Passing the Values to 1st Text and Number
	@FindBy(xpath="//ul[@class='cps inputs']/div/li[1]/div[2]//label[text()='Text And Numbers']/following-sibling::textarea")
	private WebElement FirstTextAndNumberValue;

	//Passing the Values to 2nd Text and Number
	@FindBy(xpath="//ul[@class='cps inputs']/div/li[2]/div[2]//label[text()='Text And Numbers']/following-sibling::textarea")
	private WebElement SecondTextAndNumberValue;

	//Passing the Values to 3rd Text and Number
	@FindBy(xpath="//ul[@class='cps inputs']/div/li[3]/div[2]//label[text()='Text And Numbers']/following-sibling::textarea")
	private WebElement ThirdTextAndNumberValue;

	//Passing the Values to Number
	@FindBy(xpath="//ul[@class='cps inputs']/div/li[1]/div[2]//label[text()='Number']/following-sibling::input")
	private WebElement FirstNumber;

	//Passing the Values to Number
	@FindBy(xpath="//ul[@class='cps inputs']/div/li[2]/div[2]//label[text()='Number']/following-sibling::input")
	private WebElement SecondNumber;

	//Passing the Values to Number
	@FindBy(xpath="//ul[@class='cps inputs']/div/li[3]/div[2]//label[text()='Number']/following-sibling::input")
	private WebElement ThirdNumber;

	//Passing the Values to Percentage
	@FindBy(xpath="//label[text()='Percentage']/following-sibling::input")
	private WebElement Percentage;

	//Passing the Values to Text
	@FindBy(xpath="//ul[@class='cps inputs']//li//div[2]//label[text()='Text']/following-sibling::textarea")
	private WebElement FirstText;

	//Passing the Values to Text
	@FindBy(xpath="//ul[@class='cps inputs']//li[2]//div[2]//label[text()='Text']/following-sibling::textarea")
	private WebElement SecondText;

	//Passing the Values to Text
	@FindBy(xpath="//ul[@class='cps inputs']//li[3]//div[2]//label[text()='Text']/following-sibling::textarea")
	private WebElement ThirdText;

	//Passing the Values to date
	@FindBy(xpath="//label[text()='Date']/following-sibling::input")
	private WebElement Date;

	//Passing the Values to date and range
	@FindBy(xpath="//label[text()='Date And Range']/following-sibling::input")
	private WebElement DateAndRange;

	//Clicking on the Submit Button//input[@class='btn btn-primary m-t-30 submit_express_form']
	@FindBy(xpath="//input[@class='btn btn-primary m-t-30 submit_express_form ']")
	private WebElement ExpressSubmitBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@class='btn btn-primary m-t-30 button_express_form ']")
	private WebElement ExpressSubmitBTN1;

	//Clicking on the Document
	@FindBy(xpath="//a[text()=' Documents']")
	private WebElement ExpressDocumnet;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement HandleRequestPopUpSubmitBTN;

	//Passing the Values to Handle Request Reason
	@FindBy(xpath="//input[@placeholder='Enter Reason']")
	private WebElement HandleRequestReason;

	//Passing the Values to Observed Values
	@FindBy(xpath="//input[@id='observed_value']")
	private WebElement ObservedValues;

	//Passing the Values to Max values
	@FindBy(xpath="//input[@id='audit_compliance_max_value' and @class='form-control']")
	private WebElement MaxValues;

	//Passing the Values to Sample reviewed Express Mode
	@FindBy(xpath="//input[@name='max_value']")
	private WebElement ExpressModeSampleReviewed;

	//Passing the Values to Sample Passed Express Mode
	@FindBy(xpath="//input[@id='observed_value']")
	private WebElement ExpressModeSamplePassed;

	//Passing the Values to first Sample Passed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[1]//div[2]//input[1]")
	private WebElement FirstSamplePassedValue;

	//Passing the Values to Second Sample Passed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[2]//div[2]//input[1]")
	private WebElement SecondSamplePassedValue;

	//Passing the Values to Third Sample Passed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[3]//div[2]//input[1]")
	private WebElement ThirdSamplePassedValueervedValues;

	//Passing the Values to Fourth Sample Passed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[4]//div[2]//input[1]")
	private WebElement FourthSamplePassedValueervedValues;

	//Passing the Values to First Sample reviewed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[1]//div[3]//input[1]")
	private WebElement FisrtSampleReviewedValue;

	//Passing the Values to Second Sample reviewed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[2]//div[3]//input[1]")
	private WebElement SecondSampleReviewedValue;

	//Passing the Values to Third Sample reviewed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[3]//div[3]//input[1]")
	private WebElement ThirdSampleReviewedValue;

	//Passing the Values to Fourth Sample reviewed
	@FindBy(xpath="//div[contains(@class,'container-fluid full-height no-padding bg-white')]//div[4]//div[3]//input[1]")
	private WebElement FourthSampleReviewedValue;

	//Clicking on the Finish Button
	@FindBy(xpath="//input[@value='Finish Audit']")
	private WebElement FinishBTN;

	//Clicking on the Finish Button
	@FindBy(xpath="//button[text()='Finish Audit']")
	private WebElement FinishBTN1;

	//clicking on the Provisional Submission button
	@FindBy(xpath="//input[@value='Provisional submission']")
	private WebElement ProvisionalSubmissionBTN;

	//Clicking on the Provisional Submission Final Button
	@FindBy(xpath="//button[contains(text(),'Provisional Submit')]") 
	private WebElement ProvisionalSubmitButton;

	//Clicking on the Parent Audit Reaudit Button
	@FindBy(xpath="//div[@id='step2']//span[text()='Reaudit']")
	private WebElement ParentAuditReauditBTN;

	//Clicking on the Sub Audits Reaudit Button
	@FindBy(xpath="//a[contains(text(),'reaudit')]")
	private WebElement SubAuditReauditBTN;

	//Clicking on the Sub Audits Reaudit Button
	@FindBy(xpath="//a[contains(text(),'Reaudit')]")
	private WebElement SubAuditReauditBTN1;

	//passing the Values to Normal Mode Date
	@FindBy(xpath="//input[@name='audit_compliance[input_value]']")
	private WebElement NormalModeDate;

	//Clicking on the input Tab
	@FindBy(xpath="//a[@id='input_li_tab']")
	private WebElement InputTab;

	//Clicking on the Mark Pending PI as not executed button
	@FindBy(xpath="//a[contains(text(),'Mark Pending PI as not executed')]")
	private WebElement NotExecutedBTN;

	//Passing the Values to Reason
	@FindBy(xpath="//textarea[@id='not_found_reason']")
	private WebElement NOTFoundReason;

	//Moving the slider
	@FindBy(xpath="//div[@id='slider']/div/div")
	private WebElement Slider;

	//clicking on the Exceptional Group Tab
	@FindBy(xpath="//a[@id='is_exception_cks']")
	private WebElement ExceptionalGroupTab;

	//clicking on the Skip Button
	@FindBy(xpath="//button[text()='Skip']")
	private WebElement SkipBTN;

	//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up Cancel Button
	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[text()='Cancel']")
	private WebElement SkipCancelBTN;

	//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up OK Button
	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[text()='Ok']")
	private WebElement SkipOKBTN;

	//clicking on the Exceptional Group Next Button
	@FindBy(xpath="//button[@class='btn btn-primary btn-cons m-b-10 ed btn-lg btn-larger next_li']")
	private WebElement ExceptionalGrupNextBTN;

	//Passing the Values to Audit Level Recommendation
	@FindBy(xpath="//textarea[@id='main_audit_recommendations']")
	private WebElement AuditLevelRecommendation;

	//Passing the Values to Audit Level Recommendation
	@FindBy(xpath="//textarea[@id='audit_observations']")
	private WebElement AuditLevelObservations;

	//clicking on the Quote Audit Reference button
	@FindBy(xpath="//a[@class='btn btn-primary ref-button']")
	private WebElement QuoteAuditReferenceBTN;

	//clicking on the Submit Button under Quote Audit Reference 
	@FindBy(xpath="//input[@class='btn btn-primary upload_doc_ref']")
	private WebElement QuoteAuditReferenceSubmitBTN;

	//clicking on the Job done Button
	@FindBy(xpath="//input[@value='Job Done']")
	private WebElement JobDoneBTN;

	//clicking on the Task Completed Button
	@FindBy(xpath="//a[text()='Task Completed']")
	private WebElement TaskCompletedBTN;

	//clicking on the Audit Level Recommendation Link
	@FindBy(xpath="//h5[text()='Audit Level Recommendations']")
	private WebElement AuditLevelRecommendationsLink;

	//clicking on the Audit Level Observations Link
	@FindBy(xpath="//h5[text()='Audit Level Observations']")
	private WebElement AuditLevelObservationssLink;

	//clicking on the add checkpoint button
	@FindBy(xpath="//button[@id='add_check_point']")
	private WebElement AddCheckPointButton;

	//clicking on normal mode spot resolution Toggle button
	@FindBy(xpath="//span[@class='switchery switchery-default']")
	private WebElement NormalModeSpotResolutionToggleBTN;

	//passing the values to spot score in normal mode
	@FindBy(xpath="//input[@placeholder='Please Input scoring for spot fixing']")
	private WebElement NormalmodeSpotFixingScore;

	//Enabling 1st Spot Resolution Toggle Button in Express mode
	@FindBy(xpath="//div[@class='spot_issue_lists']//div[@class='row'][1]//div[2]//input//following-sibling::span")
	private WebElement ExpressModeSpotResolutionToggleBTN;

	//clicking on the 1st group Tag NA Toggle button
	@FindBy(xpath="//div[@class='list-group']//a[1]//label[@class='btn btn-default btn-sm active toggle-off']")
	private WebElement FirstGroupTagNAButton;

	//clicking on the 2nd group Tag NA Toggle button
	@FindBy(xpath="//div[@class='list-group']//a[2]//label[@class='btn btn-default btn-sm active toggle-off']")
	private WebElement SecondGroupTagNAButton;

	//Clicking on the 1st Group
	@FindBy(xpath="//div[@class='list-group']//a[1]")
	private WebElement FirstGroup;

	public void Click1stGroup() throws InterruptedException
	{
		Thread.sleep(2000);
		FirstGroup.click();
		System.out.println("1st Group is Clicked");
		chiledTest.log(Status.INFO, "1st Group is Clicked");
	}


	public void Click1stGroupTAGNAButton()
	{
		FirstGroupTagNAButton.click();
		System.out.println("1st Group Tag NA Button is Clicked");
		chiledTest.log(Status.INFO, "1st Group Tag NA Button is Clicked");
	}

	public void Click2ndGroupTAGNAButton()
	{
		SecondGroupTagNAButton.click();
		System.out.println("2nd Group Tag NA Button is Clicked");
		chiledTest.log(Status.INFO, "2nd Group Tag NA Button is Clicked");
	}

	public void VerifySorryMinimumOneGroupAuditHasToBeExecutedPOPIsDisplayed()
	{
		WebElement PopUpMSG = driver.findElement(By.xpath("//p[text()='Sorry, Minimum one group audit has to be executed.']"));
		Assert.assertTrue(PopUpMSG.isDisplayed(), "Sorry, Minimum one group audit has to be executed Pop up is Not Displayed");
		System.out.println("Sorry, Minimum one group audit has to be executed Pop up is Displayed");
		chiledTest.log(Status.INFO, "Sorry, Minimum one group audit has to be executed Pop up is Displayed");

		//clicking on the OK Button
		driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']")).click();
	}


	public AuditExecutionPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickHomeButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", HomeBTN);
	}

	public void ClickIssuesButton() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(IssuesBTN)).click();
		System.out.println("Issue Button is Clicked");
		chiledTest.log(Status.INFO, "Issue Button is Clicked");
	}

	public void ClickCreateScheduleButton()
	{
		CreateSceduleBTN.click();
		System.out.println("Create Schedule Button is Clicked");
		chiledTest.log(Status.INFO, "Create Schedule Button is Clicked");
	}

	public void ClickSelectAuditType()
	{
		AuditType.click();
	}

	public void SetAuditType(String AT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(AuditType)).sendKeys(AT);
		System.out.println("Entered Audit Type is : " + AT);
	}

	public void ClearAuditType()
	{
		AuditType.clear();
	}

	public void SetAuditee(String ATE)
	{
		Auditee.sendKeys(ATE);
		System.out.println("Entered Auditee Is : " + ATE);
	}

	public void SetExecutionStatus(String EX)
	{
		ExecutionStatus.sendKeys(EX);
		System.out.println("Entered Auditee Is : " +EX);
	}

	public void SetFromDate(String FD) throws InterruptedException
	{
		FromDate.sendKeys(FD);
		System.out.println("Eneterd From Date is : " + FD);
		Thread.sleep(1000);
		FromDate.sendKeys(Keys.ESCAPE);
	}

	public void SetEndDate(String ED) throws InterruptedException
	{
		EndDate.sendKeys(ED);
		System.out.println("Eneterd End Date is : " + ED);
		Thread.sleep(1000);
		EndDate.sendKeys(Keys.ESCAPE);
	}

	public void ClickMatched() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Matched)).click();
	}

	public void ClickAcceptBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(AcceptBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", AcceptBTN);
			System.out.println("Accept Button is Clicked");
		}catch (StaleElementReferenceException e) {
		}

	}

	public void ClickModifyBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ModifyBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ModifyBTN);
			System.out.println("Modify Button is Clicked");
		}catch (StaleElementReferenceException e) {
		}

	}

	public void ClickRejectBTN() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(RejectBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RejectBTN);
		System.out.println("Reject Button is Clicked");

	}

	public void ClickReassignBTN() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ReassignBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReassignBTN);
		System.out.println("Reassign Button is Clicked");
	}

	public void ClickEditScheduleBTN() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(EditScheduleBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EditScheduleBTN);
		System.out.println("Edit Schedule Button is Clicked");
		chiledTest.log(Status.INFO, "Edit Schedule Button is clicked");

	}

	public void ClickParentReauditBTN() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ParentAuditReauditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ParentAuditReauditBTN);
		System.out.println("ReauditBTN Button is Clicked");
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

	}

	public void ClickSubAuditsReauditBTN() throws InterruptedException
	{
		Thread.sleep(2000);
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if(SubAuditReauditBTN.isDisplayed()){
				SubAuditReauditBTN.click();
				System.out.println("Reaudit Button is Clicked");
				chiledTest.log(Status.INFO, "Reaudit Button is clicked");}
		}catch (Exception e) {
			if(SubAuditReauditBTN1.isDisplayed()){
				SubAuditReauditBTN1.click();
				System.out.println("Reaudit Button is Clicked");
				chiledTest.log(Status.INFO, "Reaudit Button is clicked");}}

	}

	public void ClickNotStartedBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(NotStartedBTN)).click();
		System.out.println("Not Started Button is Clicked");
		chiledTest.log(Status.INFO, "Not Started Button is clicked");
	}

	public void ClickMainAuditInProgressButton() throws InterruptedException
	{
		Thread.sleep(3000);
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement MainAuditInprogressBTN = driver.findElement(By.xpath("//a[contains(text(),'Inprogress')]"));
			MainAuditInprogressBTN.click();
			System.out.println("Inprogress Button is Clicked");
			chiledTest.log(Status.INFO, "Inprogress Button is Clicked");
		}catch (Exception e) {
			WebElement MainAuditInprogressBTN1 = driver.findElement(By.xpath("//a[contains(text(),'In Progress')]"));
			MainAuditInprogressBTN1.click();
			System.out.println("Inprogress Button is Clicked");
			chiledTest.log(Status.INFO, "Inprogress Button is Clicked");
		}

	}

	public void ClickSubAuditInProgressButton() throws InterruptedException
	{
		Thread.sleep(3000);
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement SubAuditInprogressBTN = driver.findElement(By.xpath("//a[contains(text(),'In Progress')]"));
			SubAuditInprogressBTN.click();
			System.out.println("Inprogress Button is Clicked");
			chiledTest.log(Status.INFO, "Inprogress Button is Clicked");
		}catch (Exception e) {
			WebElement SubAuditInprogressBTN = driver.findElement(By.xpath("//a[contains(text(),'in progress')]"));
			SubAuditInprogressBTN.click();
			System.out.println("Inprogress Button is Clicked");
			chiledTest.log(Status.INFO, "Inprogress Button is Clicked");
		}


	}

	public void ClickStartBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement S2 = driver.findElement(By.xpath("//a[contains(text(),'start')]"));
			S2.click();
			System.out.println("Start Button is Clicked");
			chiledTest.log(Status.INFO, "Start Button is Clicked");}
		catch (Exception e) {
			WebElement S1 = driver.findElement(By.xpath("//a[contains(text(),'Start')]"));
			S1.click();
			System.out.println("Start Button is Clicked");
			chiledTest.log(Status.INFO, "Start Button is Clicked");}
	}


	public void ClickFinishBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			JavascriptExecutor JS = (JavascriptExecutor)driver;
			JS.executeScript("arguments[0].click();", FinishBTN);
			System.out.println("Finish Button is Clicked");
			chiledTest.log(Status.INFO, "Finish Button is Clicked");}
		catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", FinishBTN1);
			System.out.println("Finish Button is Clicked");
			chiledTest.log(Status.INFO, "Finish Button is Clicked");}
	}

	public void ClickExpressModeSubmitButton(WebDriver driver)
	{
		try{
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ExpressSubmitBTN);
			System.out.println("Finish Button is Clicked");}
		catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ExpressSubmitBTN1);
			System.out.println("Finish Button is Clicked");}
	}

	public void ClickSubmitAuditBTN(WebDriver driver) throws InterruptedException
	{

		try{
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement SubmitAuditBTN1 = driver.findElement(By.xpath("//button[@type='submit']"));////a[contains(text(),'Submit Audit')]
			SubmitAuditBTN1.click();
			System.out.println("Submit Button is Clicked");
			chiledTest.log(Status.INFO, "Submit Audit Button is Clicked");}
		catch (Exception e) {
			WebElement SubmitAuditBTN2 = driver.findElement(By.xpath("//button[@data-target='#modal_final_image_upload']"));
			SubmitAuditBTN2.click();
			System.out.println("Submit Button is Clicked");
			chiledTest.log(Status.INFO, "Submit Audit Button is Clicked");}
	}

	public void ClickPIStartButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(PIStartBTN)).click();
		chiledTest.log(Status.INFO, "Start Button is Clicked");

	}

	public void ClickProvisionalSubmissionBTN()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", ProvisionalSubmissionBTN);
		System.out.println("Provisional Submission Button is Clicked");
		chiledTest.log(Status.INFO, "Provisional Submission Button is Clicked");
	}

	public void Clicknormal(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(normal)).click();
		System.out.println("Normal Mode Button is Clicked");
		chiledTest.log(Status.INFO, "Normal Button is Clicked");
	}

	public void ClickExpress(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(Express));
		wait.until(ExpectedConditions.elementToBeClickable(Express)).click();
		System.out.println("Express Button is Clicked");
		chiledTest.log(Status.INFO, "Express Button is Clicked");
	}


	public void SetEnterRemarks(String ER)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(EnterRemarks)).clear();
		wait.until(ExpectedConditions.visibilityOf(EnterRemarks)).sendKeys(ER);
		System.out.println("Entered Remarks is : " + ER);
		chiledTest.log(Status.INFO, "Remarks is Entered");

	}

	public void SetEnterConfidentalRemarks(String ECR)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(EnterConfidentalRemarks)).clear();
		EnterConfidentalRemarks.sendKeys(ECR);
		System.out.println("Entered Confidental Remarks is : " + ECR);
		chiledTest.log(Status.INFO, "Confidental Remarks is Entered");

	}

	public void ClickYesButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", YesButton);
		System.out.println("Yes Button is Clicked");
		chiledTest.log(Status.INFO, "Yes Button is Clicked");
	}

	public void ClickNoButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", NoButton);
		System.out.println("No Button is Clicked");
		chiledTest.log(Status.INFO, "NO Button is Clicked");
	}

	public void ClickPartialButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", PartialButton);
		System.out.println("Partial Button is Clicked");
		chiledTest.log(Status.INFO, "Partial Button is Clicked");
	}

	public void ClickNAButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", NAButton);
		System.out.println("NA Button is Clicked");
		chiledTest.log(Status.INFO, "NA Button is Clicked");
	}

	public void ClickDispositions(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(Dispositions));
			JavascriptExecutor JS = (JavascriptExecutor)driver;
			JS.executeScript("arguments[0].click();", Dispositions);
			System.out.println("Dispossion is Clicked");
		}catch (StaleElementReferenceException e) {

		}
	}	

	public void SetNOTFoundReason(String NFR)
	{
		NOTFoundReason.sendKeys(NFR);
		System.out.println("Entered Not Found  Reason is : " + NFR);
		chiledTest.log(Status.INFO, "Not Found Reason is Entered");
	}

	public void ClickNextButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBTN);
		System.out.println("Next Button is Clicked");
		chiledTest.log(Status.INFO, "Next Button is Clicked");
	}

	public void ClickExpressModeVerifyTabNextBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ExpressModeVerifyTabNextButton);
		System.out.println("Next Button is Clicked");
		chiledTest.log(Status.INFO, "Next Button is Clicked");
	}

	public void ClickExpressModePartialTabNextBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ExpressModePartialTabNextButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ExpressModePartialTabNextButton);
		}catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ExpressModePartialTabNextButton);
			System.out.println("Next Button is Clicked");
			chiledTest.log(Status.INFO, "Next Button is Clicked");
		}



	}

	public void ClickExpressModeInputTabNextBTN(WebDriver driver) throws InterruptedException
	{
		try	{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ExpressModeInputTabNextButton);
			System.out.println("Next Button is Clicked");
			chiledTest.log(Status.INFO, "Next Button is Clicked");
		}catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ExpressModeInputTabNextButton1);
			System.out.println("Next Button is Clicked");
			chiledTest.log(Status.INFO, "Next Button is Clicked");
		}

	}

	public void ClickExpressModeSpotResolutionTAbNextBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ExpressModeSpotResolutionTabNextButton);
		System.out.println("Next Button is Clicked");
		chiledTest.log(Status.INFO, "Next Button is Clicked");
	}


	public void ClickValuesDropDownList()
	{
		ValuesDropDownList.click();
	}

	public void SetSearchBTN(String SB) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(SearchBTN)).clear();
			wait.until(ExpectedConditions.visibilityOf(SearchBTN)).sendKeys(SB);
			System.out.println("Searched Audit Type is : " + SB);
			chiledTest.log(Status.INFO, "Audit Type is Searched");
		}catch (StaleElementReferenceException e) {
		}

	}

	public void SetPiSearchBTN(String SB) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(PiSearchBTN)).clear();
		wait.until(ExpectedConditions.visibilityOf(PiSearchBTN)).sendKeys(SB);
		System.out.println("Searched Sub Audit Type is : " + SB);
		chiledTest.log(Status.INFO, "PI is Searched");
	}

	public void ClearPiSearchBTN()
	{
		PiSearchBTN.clear();
	}

	public void ClickFinalProvisionalSubmitButton()
	{
		ProvisionalSubmitButton.click();
		System.out.println("Provisional Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Provisional Submit Button is Clicked");
	}

	public void ClickOKBTN1(WebDriver driver)
	{
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(OKBTN1)).click();
		System.out.println("Ok Button is Clicked");
		chiledTest.log(Status.INFO, "Ok Button is Clicked");
	}

	public void ClickCompletedButton()
	{
		CompleteBTN.click();
		System.out.println("Complete Button is Clicked");
		chiledTest.log(Status.INFO, "Complete Button is Clicked");
	}

	public void ClickNotFoundBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(NotFoundBTN)).click();
		System.out.println("Not Found Button is Clicked");
		chiledTest.log(Status.INFO, "Not Found Button is Clicked");
	}

	public void VerifyInstedOfCompleteBTNTickBTNisDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement TickeBTN = driver.findElement(By.xpath("//img[@title='Completed']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(TickeBTN)).isDisplayed(), "Tick Button NOT is Displayed");
		System.out.println("Pass : Tick Button is Displayed");
		chiledTest.log(Status.INFO, "Tick Button is Displayed");

	}

	public void VerifySubmittedBTNisDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(SubmittedBTN.isDisplayed(), "Submitted Button NOT is Displayed");
		System.out.println("Pass : Submitted Button is Displayed");
		chiledTest.log(Status.INFO, "Submitted Button is Displayed");

	}

	public void VerifyAcceptedBTNisDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(AcceptedButton.isDisplayed(), "Accepted Button NOT is Displayed");
		System.out.println("Pass : Accepted Button is Displayed");
		chiledTest.log(Status.INFO, "Accepted Button is Displayed");
	}

	public void ClickSubmittedButton()
	{
		SubmittedBTN.click();
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void ClickPastAudits(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(PastAudits)).click();
	}

	public void ClickViewAuditInfoBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ViewAuditInfoBTN)).click();
	}


	public void ClickPleaseSelect()
	{
		PleaseSelect.click();
	}

	public void SetReason(String SR)
	{
		Reason.sendKeys(SR);
		System.out.println("Entered Reason is : " + SR);
		chiledTest.log(Status.INFO, "Reason is Entered");
	}

	public void ClickSubmitButton()
	{
		SubmitBTN.click();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void ClickCompletedTab()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CompletedTab);
		System.out.println("Completed Tab is Clicked");
		chiledTest.log(Status.INFO, "Completed Tab is Clicked");
	}


	public void ClickNotExecutedTab()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NotExecuatedTab);
		System.out.println("Completed Tab is Clicked");
		chiledTest.log(Status.INFO, "Not Executed Tab is Clicked");
	}

	public void ClickAddNewPIBTN(WebDriver driver)
	{
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(AddNewPIBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddNewPIBTN);
		System.out.println("Add New Pi Button is Clicked");
		chiledTest.log(Status.INFO, "Add New Pi Button is Clicked");
	}

	public void ClickSaveBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SaveBTN);
		chiledTest.log(Status.INFO, "Save Button is Clicked");
	}

	public void ClickMarkPendingPIAsNotExecuted()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NotExecutedBTN);
		System.out.println("Mark Pending Pi As Not Executed Button is Clicked");
		chiledTest.log(Status.INFO, "Mark Pending Pi As Not Executed Button is Clicked");
	}

	public void SetPrimaryIdentifierName(String PIN, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(PrimaryIdentifierName));
		PrimaryIdentifierName.sendKeys(PIN);
		System.out.println("Entered Primary Identifier Name is : " + PIN);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Enterd");
	}

	public void ClickQuoteAuditReferenceBTN()
	{
		QuoteAuditReferenceBTN.click();
		System.out.println("Quote Audit Reference Button is Clicked");
		chiledTest.log(Status.INFO, "Quote Audit Reference Button is Clicked");
	}

	public void SetTextAndNumber(String TN)
	{
		try{
			TextAndNumber.clear();
			TextAndNumber.sendKeys(TN);
			System.out.println("Entered Text and Number is : " + TN);
			chiledTest.log(Status.INFO, "Text and Number is Enterd");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void SetFirstTextAndNumberValue(String FTN)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(FirstTextAndNumberValue)).sendKeys(FTN);
		System.out.println("Enterd Text and Number is : " + FTN);
		chiledTest.log(Status.INFO, "Text and Number is Enterd");
	}

	public void SetSecondTextAndNumberValue(String STN)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SecondTextAndNumberValue)).sendKeys(STN);
		System.out.println("Enterd Text and Number is : " + STN);
		chiledTest.log(Status.INFO, "Text and Number is Enterd");
	}

	public void SetThirdTextAndNumberValue(String TTN)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ThirdTextAndNumberValue)).sendKeys(TTN);
		System.out.println("Enterd Text and Number is : " + TTN);
		chiledTest.log(Status.INFO, "Text and Number is Enterd");
	}

	public void SetPercentage(String PN)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Percentage)).clear();
			wait.until(ExpectedConditions.visibilityOf(Percentage)).sendKeys(PN);
			System.out.println("Entered Percentage is : " + PN);
			chiledTest.log(Status.INFO, "Percentage is Enterd");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void SetFirstText(String FT)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(FirstText)).clear();
		wait.until(ExpectedConditions.visibilityOf(FirstText)).sendKeys(FT);
		System.out.println("Entered Text is : " + FT);
		chiledTest.log(Status.INFO, "Text is Enterd");
	}

	public void SetSecondText(String ST)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SecondText)).clear();
		wait.until(ExpectedConditions.visibilityOf(SecondText)).sendKeys(ST);
		System.out.println("Entered Text is : " + ST);
		chiledTest.log(Status.INFO, "Text is Enterd");
	}

	public void SetThirdText(String TT)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ThirdText)).clear();
		wait.until(ExpectedConditions.visibilityOf(ThirdText)).sendKeys(TT);
		System.out.println("Entered Text is : " + TT);
		chiledTest.log(Status.INFO, "Text is Enterd");
	}

	public void SetFirstNumber(String FN, WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(FirstNumber)).clear();
			wait.until(ExpectedConditions.visibilityOf(FirstNumber)).sendKeys(FN);
			System.out.println("Number is : " + FN);
			chiledTest.log(Status.INFO, "Number is Enterd");
		}catch (StaleElementReferenceException e) {

		}
	}

	public void SetSecondNumber(String SN, WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(SecondNumber)).clear();
			wait.until(ExpectedConditions.visibilityOf(SecondNumber)).sendKeys(SN);
			System.out.println("Number is : " + SN);
			chiledTest.log(Status.INFO, "Number is Enterd");
		}catch (StaleElementReferenceException e) {
		}
	}

	public void SetThirdNumber(String TN, WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ThirdNumber)).clear();
			wait.until(ExpectedConditions.visibilityOf(ThirdNumber)).sendKeys(TN);
			System.out.println("Number is : " + TN);
			chiledTest.log(Status.INFO, "Number is Enterd");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void SetDate(String SD, WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Date)).sendKeys(SD);
			System.out.println("Date is : " + SD);
			chiledTest.log(Status.INFO, "Date is Enterd");
			driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		}catch (StaleElementReferenceException e) {

		}

	}

	public void SetDateAndRange(String SD, WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(DateAndRange)).sendKeys(SD);
			System.out.println("Date and Range is : " + SD);
			chiledTest.log(Status.INFO, "Date and Range is Enterd");
			driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
		}catch (StaleElementReferenceException e) {

		}

	}

	public void SetExpressRemarks(String ER)
	{
		ExpressRemarks.sendKeys(ER);
		System.out.println("Entered Remarks is : " + ER);
		chiledTest.log(Status.INFO, "Remarks is Enterd");
	}

	public void SetExpressConfidentalRemarks(String CR)
	{
		ExpressConfidentalRemarks.sendKeys(CR);
		System.out.println("Entered Confidental Remarks is : " + CR);
		chiledTest.log(Status.INFO, "Confidental Remarks is Enterd");
	}


	public void ClickHandleRequestPopUpSubmitBTN()
	{
		HandleRequestPopUpSubmitBTN.click();
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

	}

	public void SetHandleRequestReason(String HRR)
	{
		HandleRequestReason.sendKeys(HRR);
		System.out.println("Entered Reason is : " + HRR);
		chiledTest.log(Status.INFO, "Reason is Entered");

	}

	public void SetObservedValues(String OV, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(ObservedValues)).clear();
		ObservedValues.sendKeys(OV);
		System.out.println("Entered Observed Value is : " + OV);
	}

	public void SetMaxValues(String MV, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MaxValues)).clear();
		MaxValues.sendKeys(MV);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		System.out.println("Entered Max Value is : " + MV);
		chiledTest.log(Status.INFO, "MAX values is Entered");
	}

	public void SetExpressModeSamplePassed(String ESP) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ExpressModeSamplePassed)).sendKeys(ESP);
		System.out.println("Entered Sample Passed is : " + ESP);

	}

	public void SetExpressModeSampleReviwed(String ESR) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ExpressModeSampleReviewed)).sendKeys(ESR);
		System.out.println("Entered Sample Reviewed is : " + ESR);
	}

	public void SetFirstSamplePassedValue(String FO) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstSamplePassedValue)).sendKeys(FO);
		System.out.println("Entered Observed Value is : " + FO);
	}

	public void SetSecondSamplePassedValue(String SO)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SecondSamplePassedValue)).sendKeys(SO);
		System.out.println("Entered Observed Value is : " + SO);
	}

	public void SetThirdSamplePassedValue(String TO)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ThirdSamplePassedValueervedValues)).sendKeys(TO);
		System.out.println("Entered Observed Value is : " + TO);
	}

	public void SetFourthSamplePassedValue(String FS)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FourthSamplePassedValueervedValues)).sendKeys(FS);
		System.out.println("Entered Observed Value is : " + FS);
	}

	public void SetFirstSampleReviewed(String FM)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FisrtSampleReviewedValue)).sendKeys(FM);
		System.out.println("Entered First Max Value is : " + FM);
	}

	public void SetSecondSampleReviewed(String SM)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SecondSampleReviewedValue)).sendKeys(SM);
		System.out.println("Entered First Max Value is : " + SM);
	}

	public void SetThirdSampleReviewed(String TM)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ThirdSampleReviewedValue)).sendKeys(TM);
		System.out.println("Entered First Max Value is : " + TM);
	}

	public void SetFourthSampleReviewed(String FM)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FourthSampleReviewedValue)).sendKeys(FM);
		System.out.println("Entered First Max Value is : " + FM);
	}

	public void SetNormalModeDate(String ND)
	{
		NormalModeDate.clear();
		NormalModeDate.sendKeys(ND);
		System.out.println("Entered Date is : " + ND);
		NormalModeDate.sendKeys(Keys.TAB);
	}

	public void ClickInputTab()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(InputTab)).click();
		System.out.println("Input Tab is clicked");
	}

	public void ClickQuoteAuditReferenceSubmitBTN()
	{
		QuoteAuditReferenceSubmitBTN.click();
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void SetAuditLevelRecommendation(String AR) throws InterruptedException
	{
		AuditLevelRecommendation.sendKeys(AR);
		System.out.println("Enterd Audit Level Recommendation is : " + AR);
		chiledTest.log(Status.INFO, "Audit Level Recommendation is Entered");
	}

	public void SetAuditLevelObservations(String AO) throws InterruptedException
	{
		AuditLevelObservations.sendKeys(AO);
		System.out.println("Enterd Audit Level Observations is : " + AO);
		chiledTest.log(Status.INFO, "Audit Level Observations is Entered");
	}

	public void VerifyCharacterLimitReachedErrorMSGISDisplayed()
	{
		WebElement LimitErrorMSG = driver.findElement(By.xpath("//div[text()='Character limit reached (5000).']"));
		Assert.assertTrue(LimitErrorMSG.isDisplayed(), "Character limit reached (5000). Error Message is Not Displayed");
		System.out.println("Character limit reached (5000). Error Message is Displayed");
		chiledTest.log(Status.INFO, "Character limit reached (5000). Error Message is Displayed");
	}

	public void ClickExceptionalGroupNextButton()
	{
		ExceptionalGrupNextBTN.click();
		System.out.println("Exceptional Group Next Button is Clicked");
		chiledTest.log(Status.INFO, "Exceptional Group Next Button is Clicked");
	}

	public void ClickSkipOKButton()
	{
		SkipOKBTN.click();
		System.out.println("Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up OK Button is Clicked");
		chiledTest.log(Status.INFO, "Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up OK Button is Clicked");
	}

	public void ClickSkipCancelButton()
	{
		SkipCancelBTN.click();
		System.out.println("Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up Cancel Button is Clicked");
		chiledTest.log(Status.INFO, "Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up Cancel Button is Clicked");
	}

	public void ClickSkipButton() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", SkipBTN);
		System.out.println("Skip Button is Clicked");
		chiledTest.log(Status.INFO, "Skip Button is Clicked");
	}

	public void ClickJobDoneButton()
	{
		JobDoneBTN.click();
		System.out.println("Job Done Button is Clicked");
		chiledTest.log(Status.INFO, "Job Done Button is Clicked");
	}

	public void ClickTaskCompletedButton()
	{
		TaskCompletedBTN.click();
		System.out.println("Task Completed button is Clicked");
		chiledTest.log(Status.INFO, "Task Completed button is Clicked");
	}

	public void ClickExceptionalGroupTab()
	{
		ExceptionalGroupTab.click();
		System.out.println("Exceptional Group Tab");
		chiledTest.log(Status.INFO, "Exceptional Group Tab");
	}

	public void ClickAuditLevelRecommendationsLink()
	{
		AuditLevelRecommendationsLink.click();
		System.out.println("Audit Level Recommendations Link is Clicked");
		chiledTest.log(Status.INFO, "Audit Level Recommendations Link is Clicked");
	}

	public void clickAuditLevelObservationssLink()
	{
		AuditLevelObservationssLink.click();
		System.out.println("Audit Level Observations Link is Clicked");
		chiledTest.log(Status.INFO, "Audit Level Observations Link is Clicked");
	}

	public void ClickNormalModeSpotResolutionToggleBTN()
	{
		NormalModeSpotResolutionToggleBTN.click();
		System.out.println("Spot Resolution Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Spot Resolution Toggle Button is Clicked");
	}

	public void ClickExpressModeSpotResolutionToggleBTN()
	{
		ExpressModeSpotResolutionToggleBTN.click();
		System.out.println("Spot Resolution Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Spot Resolution Toggle Button is Clicked");
	}

	public void SetNormalmodeSpotFixingScore(String SF) throws InterruptedException
	{
		Thread.sleep(2000);
		NormalmodeSpotFixingScore.sendKeys(SF);
		System.out.println("Enetered Spot Fixing score is : " + SF);
		chiledTest.log(Status.INFO, "Spot Fixing Score is Entered");

	}

	public void VerifyAuditLevelRecommendatiosText()
	{
		String Recommendations = driver.findElement(By.xpath("//div[@id='audit_recommendations-show']")).getText();
		String Recommendations1 = Lib.getCellValue(XLPATH, "Audit Execution", 115, 0);
		Assert.assertEquals(Recommendations, Recommendations1, "Entered Audit level Recommendations Text is showing wrong");
		System.out.println("Entered Audit level Recommendations Text is showing");
		chiledTest.log(Status.INFO, "Entered Audit level Recommendations Text is showing");
	}

	public void VerifyAuditLevelObservationsText()
	{
		String Observations = driver.findElement(By.xpath("//div[@id='audit_observations-show']")).getText();
		String Observations1 = Lib.getCellValue(XLPATH, "Audit Execution", 118, 0);
		Assert.assertEquals(Observations, Observations1, "Entered Audit level Observations Text is showing wrong");
		System.out.println("Entered Audit level Observations Text is showing");
		chiledTest.log(Status.INFO, "Entered Audit level Observations Text is showing");
	}

	public void VerifyRedColorisDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Redcolor = driver.findElement(By.xpath("//div[contains(@class,'field-error')]"));
		if(wait.until(ExpectedConditions.visibilityOf(Redcolor)).isDisplayed())
		{
			System.out.println("Pass : Red color is Displayed");
			chiledTest.log(Status.INFO, "Pass : Red color is Displayed");}else{
				System.out.println("Fail : Red color is Not Displayed");
				chiledTest.log(Status.INFO, "Fail : Red color is Not Displayed");}
	}

	public void VerifyCompletedTabIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Table is Displayed or Not
		WebElement Table = driver.findElement(By.xpath("//table[@id='tableWithSearch']"));
		if(wait.until(ExpectedConditions.visibilityOf(Table)).isDisplayed())
		{
			//checking the TH Count
			List<WebElement> THcount = driver.findElements(By.xpath("//table[@id='tableWithSearch']/thead/tr/th"));
			int Actual_count = THcount.size();
			int Expected_count = 4;
			Assert.assertEquals(Actual_count, Expected_count, "Total TH Count is Wrong");

			//Checking SNO
			String Actual_text =  driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[1]")).getText();
			String Expected_text = "SNO.";
			Assert.assertEquals(Actual_text, Expected_text, "SNO is Not Displayed");
			System.out.println("SNO is Displayed");

			//Checking Sub Auditees
			String Actual_SubAuditees =  driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[2]")).getText();
			String Expected_SubAuditees = "SUB AUDITEES";
			Assert.assertEquals(Actual_SubAuditees, Expected_SubAuditees, "Sub Auditees is Not Displayed");
			System.out.println("Sub Auditees is Displayed");

			//Checking Sub Auditees Found
			String Actual_SubAuditeesFound =  driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[3]")).getText();
			String Expected_SubAuditeesFound = "SUB AUDITEES FOUND";
			Assert.assertEquals(Actual_SubAuditeesFound, Expected_SubAuditeesFound, "Sub Auditees Found is Not Displayed");
			System.out.println("Sub Auditees Found is Displayed");

		}


	}

	public void VerifyNotExecutedTabIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Table is Displayed or Not
		WebElement Table = driver.findElement(By.xpath("//table[@id='IssuetableWithSearch']"));
		if(wait.until(ExpectedConditions.visibilityOf(Table)).isDisplayed())
		{
			//checking the TH Count
			List<WebElement> THcount = driver.findElements(By.xpath("//table[@id='IssuetableWithSearch']/thead/tr/th"));
			int Actual_count = THcount.size();
			int Expected_count = 4;
			Assert.assertEquals(Actual_count, Expected_count, "Total TH Count is Wrong");

			//Checking SNO
			String Actual_text =  driver.findElement(By.xpath("//table[@id='IssuetableWithSearch']/thead/tr/th[1]")).getText();
			String Expected_text = "SNO.";
			Assert.assertEquals(Actual_text, Expected_text, "SNO is Not Displayed");
			System.out.println("SNO is Displayed");

			//Checking Sub Auditees
			String Actual_SubAuditees =  driver.findElement(By.xpath("//table[@id='IssuetableWithSearch']/thead/tr/th[2]")).getText();
			String Expected_SubAuditees = "SUB AUDITEES";
			Assert.assertEquals(Actual_SubAuditees, Expected_SubAuditees, "Sub Auditees is Not Displayed");
			System.out.println("Sub Auditees is Displayed");

			//Checking Sub Auditees Found
			String Actual_SubAuditeesFound =  driver.findElement(By.xpath("//table[@id='IssuetableWithSearch']/thead/tr/th[3]")).getText();
			String Expected_SubAuditeesFound = "SUB AUDITEES FOUND";
			Assert.assertEquals(Actual_SubAuditeesFound, Expected_SubAuditeesFound, "Sub Auditees Found is Not Displayed");
			System.out.println("Sub Auditees Found is Displayed");

		}

	}

	public void CheckpointLevelUploadDocuments(WebDriver driver) throws InterruptedException
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 60);

			//Clicking on the Digital Evidence Button Button
			WebElement DigitalEvidenceBTN = driver.findElement(By.xpath("//button[@class='btn btn-Blue btn-primary btn-popUp btn-cons']"));
			wait.until(ExpectedConditions.visibilityOf(DigitalEvidenceBTN));
			JavascriptExecutor JS = (JavascriptExecutor)driver;
			JS.executeScript("arguments[0].click();", DigitalEvidenceBTN);
			System.out.println("Digital Evidence Button is Clicked");
			chiledTest.log(Status.INFO, "Digital Evidence Button is Clicked");

			//Checking the Note is Displayed or not
			WebElement Note = driver.findElement(By.xpath("//div[@class='col-md-12']/strong"));
			if(wait.until(ExpectedConditions.visibilityOf(Note)).isDisplayed())
			{
				String NotText = Note.getText();
				System.out.println("Note is Displayed" + NotText);
			}

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();

			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			System.out.println("*****Uploading >25MB Documents****");
			chiledTest.log(Status.INFO, "*****Uploading >25MB Documets*********");

			//Uploading the JPG File
			//#SM(All file paths are changed)
			//driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\30_MB_PDF_document.pdf");
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\30_MB_PDF_document.pdf");
			
			//Checking the document should be less than 25mb. Alert is Displayed
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String Actual_alert = alert.getText();
			String Expected_alert = "The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB";
			Assert.assertEquals(Actual_alert, Expected_alert, "Alert Message is Wrong");
			System.out.println("The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB Alert is Displayed");
			chiledTest.log(Status.INFO, "The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB Alert is Displayed");
			alert.accept();

			//Uploading other than this Documents only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg.
			System.out.println("************Uploading .Mov Documents*************");
			chiledTest.log(Status.INFO, "********Uploading .MOV Documets**********");

			//Passing the Documents to Choose File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\All Main audit list is not coming in current flow.MOV");

			//Checking the only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg file should be uploaded pop is Displayed
			VerifyOnlyPdfWavMp3OggMp4DocDocxJpgPngWmvJpegMpegFileShouldBeUploadedPopUpIsDisplayed();

			System.out.println("*****Uploading .TXT Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .TXT Documets*********");

			//Passing the Documents to Choose File
			//#SM Below is mistake it should upload TXT file but uploading .MOV file
			//#SM
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\sampleTXT.txt");

			//Checking the only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg file should be uploaded pop is Displayed
			VerifyOnlyPdfWavMp3OggMp4DocDocxJpgPngWmvJpegMpegFileShouldBeUploadedPopUpIsDisplayed();

			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Uploading the JPG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
			
			System.out.println("*****Uploading .MP3 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .MP3 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			Thread.sleep(1000);
			//Uploading the PNG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[2]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\MereGharRamAayeHainJubinNautiyalHindiSong.mp3");
			
			System.out.println("*****Uploading .PDF Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .PDF Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			Thread.sleep(1000);
			//Uploading the .PDF File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[3]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\download.pdf");
			
			System.out.println("*****Uploading .PDF Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .PDF Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			Thread.sleep(1000);
			//Uploading the .PDF File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[4]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\fp_dc_setup_guide.pdf");
			
			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			Thread.sleep(1000);
			//Uploading the .JPG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[5]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\IMG-20180607-WA0031.jpg");
			
			//clicking on the Confidential Check box
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[5]//input[@type='checkbox']")).click();

			System.out.println("*****Uploading .Mp3 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .Mp3 Documets*********");

			Thread.sleep(1000);
			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");
            
            
			//Uploading the .Mp3 File
			Thread.sleep(1000);
	//		driver.findElement(By.xpath("//div[@class='row m-t-10']/div[6]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\kurai-onrum-illai.mp3");
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[6]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\kurai.mp3");
			//clicking on the Confidential Check box
			
			WebElement OkButton = driver.findElement(By.xpath("//input[@class='btn btn-primary m-t-30 updated_docs']"));
			Actions act= new Actions(driver);
			act.moveToElement(OkButton).build().perform();
			
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[6]//input[@type='checkbox']")).click();

			System.out.println("*****Uploading .Mp4 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .Mp4 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			Thread.sleep(1000);
			//Uploading the .Mp4 File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[7]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\VID_20200213_170644.mp4");

			//clicking on the Confidential Check box
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[7]//input[@type='checkbox']")).click();

			//#SM
			act.moveToElement(OkButton).build().perform();
			Thread.sleep(1000);
			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			Thread.sleep(1000);
			//Uploading the JPG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[8]//input[@class='upload_new_document']")).sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\IMG-20180607-WA0031.jpg");
			act.moveToElement(OkButton).build().perform();//#SM
			//clicking on the Confidential Check box
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[8]//input[@type='checkbox']")).click();
           
			//Clicking on the OK Button
			driver.findElement(By.xpath("//input[@class='btn btn-primary m-t-30 updated_docs']")).click();
			System.out.println("OK Button is Clicked");
			chiledTest.log(Status.INFO, "OK Button is Clicked");

			System.out.println("Pass : Documents are Uploaded");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}
	}

	public void ExpressModeSpotResolutionUploadDocuments(WebDriver driver) throws InterruptedException
	{
		try{

			//passing the Values to Remarks
			driver.findElement(By.xpath("//input[@id='issue_remarks' and @required]")).sendKeys("Reamrks Test");
			System.out.println("Remarks is Enterd");
			chiledTest.log(Status.INFO, "Remarks is Entered");

			WebDriverWait wait = new WebDriverWait(driver, 60);
			//Checking the Note is Displayed or not
			WebElement Note = driver.findElement(By.xpath("//div[@class='col-md-12']/strong"));
			if(wait.until(ExpectedConditions.visibilityOf(Note)).isDisplayed())
			{
				String NotText = Note.getText();
				System.out.println("Note is Displayed" + NotText);
			}

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[text()='Add Digital Evidences']")).click();

			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			System.out.println("*****Uploading >25MB Documents****");
			chiledTest.log(Status.INFO, "*****Uploading >25MB Documets*********");

			//Uploading the JPG File
			driver.findElement(By.xpath("//div[@class='row m-t-10']/div[1]//input[@class='upload_new_document']")).sendKeys("D:\\Audit-360 Upload Document Test\\30_MB_PDF_document.pdf");

			//Checking the The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB Alert is Displayed
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String Actual_alert = alert.getText();
			String Expected_alert = "The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB";
			Assert.assertEquals(Actual_alert, Expected_alert, "Alert Message is Wrong");
			System.out.println("The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB Alert is Displayed");
			chiledTest.log(Status.INFO, "The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB Alert is Displayed");
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

			//Clicking on the Submit Button
			driver.findElement(By.xpath("//input[@class='btn btn-primary new_spot_resolution_submit']")).click();
			System.out.println("Submit Button is Clicked");
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			System.out.println("Pass : Documents are Uploaded");
		}catch (StaleElementReferenceException e) {
		}

	}



	public void ImageMandatoryUploadDocuments() throws InterruptedException // CTRL-5745 Changes
	{
		/*try
		{
			//Verifying Upload Digital Evidences Pop Up is Displayed
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement UploadDocumnet = driver.findElement(By.xpath("//h4[text()='Upload Digital Evidences']"));
			if(wait.until(ExpectedConditions.visibilityOf(UploadDocumnet)).isDisplayed())
			{
				String Actual_text = UploadDocumnet.getText();
				String Expected_text = "Upload Digital Evidences";
				Assert.assertEquals(Actual_text, Expected_text, "Upload Digital Evidences Pop Up is Not Displayed");
				System.out.println("UploadDocumnet Pop Up is Displayed");
				chiledTest.log(Status.INFO, "Upload Digital Evidences Pop Up is Displayed");
			}

			//clicking on the Submit Button
			driver.findElement(By.xpath("//input[@name='commit']")).click();
			System.out.println("Submit Button is Clicked");
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//checking At least one document should be uploaded alert should display
			Alert Alert = driver.switchTo().alert();
			String Actual_Text = Alert.getText();
			String Expected_Text = "Atleast one document should be uploaded.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
			System.out.println("Pass : Atleast one document should be uploaded Pop Up is Displayed");
			chiledTest.log(Status.INFO, "Atleast one document should be uploaded Pop Up is Displayed");

			//accepting the alert
			Alert.accept();

			System.out.println("*****Uploading >25 MB Documents****");
			chiledTest.log(Status.INFO, "*****Uploading >25 MB Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary m-b-20 m-t-10 add_nested_fields']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the >25MB File
			driver.findElement(By.xpath("//div[@class='fields'][1]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\30_MB_PDF_document.pdf");

			//Checking the document should be less than 25mb. Alert is Displayed
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String Actual_alert = alert.getText();
			String Expected_alert = "The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB";
			Assert.assertEquals(Actual_alert, Expected_alert, "Alert Message is Wrong");
			System.out.println("The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB Pop Up is displayed" );
			chiledTest.log(Status.INFO, "The total uploaded documents size should be less than 25MB. Your uploaded documents size is 32.10MB Pop Up is displayed");

			alert.accept();

			//Uploading other than this Documents only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg.
			System.out.println("************Uploading .Mov Documents*************");
			chiledTest.log(Status.INFO, "********Uploading .MOV Documets**********");

			//Passing the Documents to Choose File
			driver.findElement(By.xpath("//div[@class='fields'][1]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\All Main audit list is not coming in current flow.MOV");

			//Checking the only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg file should be uploaded pop is Displayed
			VerifyOnlyPdfWavMp3OggMp4DocDocxJpgPngWmvJpegMpegFileShouldBeUploadedPopUpIsDisplayed();

			System.out.println("*****Uploading .TXT Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .TXT Documets*********");

			//Passing the Documents to Choose File
			driver.findElement(By.xpath("//div[@class='fields'][1]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\All Main audit list is not coming in current flow.MOV");

			//Checking the only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, wmv, jpeg, mpeg file should be uploaded pop is Displayed
			VerifyOnlyPdfWavMp3OggMp4DocDocxJpgPngWmvJpegMpegFileShouldBeUploadedPopUpIsDisplayed();

			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Uploading the JPG File
			driver.findElement(By.xpath("//div[@class='fields'][1]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");

			System.out.println("*****Uploading .MP3 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .MP3 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary m-b-20 m-t-10 add_nested_fields']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the PNG File
			driver.findElement(By.xpath("//div[@class='fields'][2]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\kurai-onrum-illai.mp3");

			System.out.println("*****Uploading .PDF Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .PDF Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary m-b-20 m-t-10 add_nested_fields']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .PDF File
			driver.findElement(By.xpath("//div[@class='fields'][3]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\download.pdf");

			System.out.println("*****Uploading .PDF Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .PDF Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary m-b-20 m-t-10 add_nested_fields']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .PDF File
			driver.findElement(By.xpath("//div[@class='fields'][4]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\fp_dc_setup_guide.pdf");

			System.out.println("*****Uploading .JPG Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .JPG Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary m-b-20 m-t-10 add_nested_fields']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .JPG File
			driver.findElement(By.xpath("//div[@class='fields'][5]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180607-WA0031.jpg");

			System.out.println("*****Uploading .Mp3 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .Mp3 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary m-b-20 m-t-10 add_nested_fields']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .Mp3 File
			driver.findElement(By.xpath("//div[@class='fields'][6]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\kurai-onrum-illai.mp3");

			System.out.println("*****Uploading .Mp4 Documents****");
			chiledTest.log(Status.INFO, "*****Uploading .Mp4 Documets*********");

			//Clicking on the add Digital Evidences button
			driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary m-b-20 m-t-10 add_nested_fields']")).click();
			System.out.println("Add Digital Evidences Button is Clicked");
			chiledTest.log(Status.INFO, "Add Digital Evidences Button is Clicked");

			//Uploading the .Mp4 File
			driver.findElement(By.xpath("//div[@class='fields'][7]//input[@class='final_document' and @required='required']")).sendKeys("D:\\Audit-360 Upload Document Test\\VID_20200213_170644.mp4");

			//Clicking on the Submit Button
			driver.findElement(By.xpath("//input[@name='commit']")).click();
			System.out.println("Submit Button is Clicked");
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

		}catch (StaleElementReferenceException e) {

		}*/

	}

	public void SetEnterInputValues(String IV, WebDriver driver)
	{

		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			EnterInputValues1.clear();
			EnterInputValues1.sendKeys(IV);
			EnterInputValues1.sendKeys(Keys.ESCAPE);
			System.out.println("Entered Input Value is : " + IV);
			chiledTest.log(Status.INFO, "Input is Entered");
		}catch (Exception e) {
			EnterInputValues2.clear();
			EnterInputValues2.sendKeys(IV);
			EnterInputValues2.sendKeys(Keys.ESCAPE);
			System.out.println("Entered Input Value is : " + IV);
			chiledTest.log(Status.INFO, "Input is Entered");}
	}


	public void VerifyAuditExecutionPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Checking the Upcoming Audits Tab
		WebElement UAT = driver.findElement(By.xpath("//li[@class='bg-whi my_audits_listing active'][@data-type='upcoming']"));
    
		//Checking the Past Audits
		WebElement PA = driver.findElement(By.xpath("//a[contains(text(),'Past Audits')]"));

		//Checking the Policy and Documents
		WebElement PD = driver.findElement(By.xpath("//a[contains(text(),'Policy & Documents')]"));

		if(UAT.isDisplayed() && PA.isDisplayed() && PD.isDisplayed())
		{
			String Expected_UAT = UAT.getText();
			String Actual_UAT = "UPCOMING AUDITS";
			Assert.assertEquals(Expected_UAT, Actual_UAT);
			System.out.println("Upcoming Audits Tab Is Displayed");

			String Expected_PA = PA.getText();
			String Actual_PA = "PAST AUDITS";
			Assert.assertEquals(Expected_PA, Actual_PA);
			System.out.println("Past Audits Tab Is Displayed");

			String Expected_PD = PD.getText();
			String Actual_PD = "POLICY & DOCUMENTS";
			Assert.assertEquals(Expected_PD, Actual_PD);
			System.out.println("Policy and Documents Tab Is Displayed");

		}

		//Checking Filter 
		WebElement Filter = driver.findElement(By.xpath("//h5[@class='text-white bold all-caps']"));
		if(Filter.isDisplayed())
		{
			String Expected_Filter = Filter.getText();
			String Actual_Filter = "FILTER";
			Assert.assertEquals(Expected_Filter, Actual_Filter);
			System.out.println("Filter Text is Displayed");
		}

		//Checking From Date, End Date, Audit Type, Auditee, Execution Status Text fields, Issues Button, Create Audit Schedule Button
		if(IssuesBTN.isDisplayed() && CreateSceduleBTN.isDisplayed() && FromDate.isDisplayed() && EndDate.isDisplayed() && AuditType.isDisplayed() && Auditee.isDisplayed() && ExecutionStatus.isDisplayed())
		{
			System.out.println("Pass : Ieesues Button is Displayed");
			System.out.println("Pass : Create Secedule Button is Displayed");
			System.out.println("Pass : From date is Displayed");
			System.out.println("Pass : To date is Displayed");
			System.out.println("Pass : Audit Type is Displayed");
			System.out.println("Pass : Auditee is Displayed");
			System.out.println("Pass : Execution Status is Displayed");

		}

	}

	public void VerifyNoMatchFoundErrorMSGIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement NoMatch = driver.findElement(By.xpath("//div[@id='select2-drop']//li[@class='select2-no-results'][contains(text(),'No matches found')]"));

		if(NoMatch.isDisplayed())
		{
			String Expected_Text = NoMatch.getText();
			String Actual_Text = "No matches found";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : No matches found Message is Displayed");
		}
	}

	public void VerifyAcceptRejectAssignEditButtonsAreDisplayed(WebDriver driver)
	{
		//Checking the Accept, Reject, Reassign and edit Schedule Buttons

		WebElement AcceptBTN1 = driver.findElement(By.xpath("//div[@id='step2']/div[1]/div[4]/div/div[1]/a[text()='Accept']"));
		WebElement RejectBTN1 = driver.findElement(By.xpath("//div[@id='step2']/div[1]/div[4]/div/div[2]/button[@class='btn btn-danger prime-btn btn-block all-caps add_schedule_id']"));
		WebElement ReassignBTN1 = driver.findElement(By.xpath("//div[@id='step2']/div[1]/div[4]/div/div[3]/button[@class='btn btn-warning prime-btn btn-block all-caps add_schedule_id']"));
		WebElement EditSeheduleBTN1 = driver.findElement(By.xpath("//div[@id='step2']/div[1]/div[4]/div/div[4]/button[@class='btn btn-info prime-btn btn-block all-caps edit_auditor_schedule']"));
		if(AcceptBTN1.isDisplayed() && RejectBTN1.isDisplayed() && ReassignBTN1.isDisplayed() && EditSeheduleBTN1.isDisplayed())
		{
			try
			{
				System.out.println("Accept Button is Displayed");
				System.out.println("Reject Button is Displayed");
				System.out.println("Reassign Button is Displayed");
				System.out.println("Edit Sehedule Button is Displayed");
			}catch (StaleElementReferenceException e) {

			}

		}

	}

	public void VerifyAuditAcceptedSuccesfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_SuccessMSG = SuccessMSG.getText();
			String Actual_SuccessMSG = "Audit accepted succesfully";
			Assert.assertEquals(Expected_SuccessMSG, Actual_SuccessMSG);
			System.out.println("Pass : Audit accepted succesfully Success Message is Displayed");
		}

	}

	public void VerifyChooseExecutionTypePopUpIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement ChooseExecutionType = driver.findElement(By.xpath("//div[@class='modal-body text-center m-t-20']/h4"));
		if(ChooseExecutionType.isDisplayed())
		{
			String Expected_ChooseExecutionType = ChooseExecutionType.getText();
			String Actual_ChooseExecutionType = "Choose Execution Type";
			Assert.assertEquals(Expected_ChooseExecutionType, Actual_ChooseExecutionType);
			System.out.println("Pass : Choose Execution Type Pop up is Displayed");
		}
	}

	public void VerifyingCheckPointCountsUnderNarmolMode(WebDriver driver)
	{
		List<WebElement> CheckPointCount = driver.findElements(By.xpath("//div[@class='bhoechie-tab-content active']//div[@class='list-group']/a"));
		int Actual_count = CheckPointCount.size();
		int Expected_count = 4;
		Assert.assertEquals(Actual_count, Expected_count, "CheckPoints Counts Are Wrong");
		System.out.println("Number of Check Points displayed : " + Actual_count);
		System.out.println("4 Checkpoints are Displayed");

	}

	public void VerifyingCheckPointCountsUnderExpressMode(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		//Checking the Check Points Count
		List<WebElement> CPCount = driver.findElements(By.xpath("//ul[@id='sortable1']/li"));
		int Actual_Count = CPCount.size();
		int Expected_Count = 3;
		Assert.assertEquals(Actual_Count, Expected_Count, "CheckPoints Counts Are Wrong");
		System.out.println("Number of Check Points displayed : " + Actual_Count);
		System.out.println("3 Checkpoints are Displayed");
	}

	public void VerifyAuditHomePageIsDisplayed(WebDriver driver)
	{
		//Checking the Home 
		WebElement Home = driver.findElement(By.xpath("//a[text()='Home']"));

		//Checking Audit Home
		WebElement AuditHome = driver.findElement(By.xpath("//a[text()='Audit Home']"));

		//Checking Auditee name
		WebElement AuditeeName = driver.findElement(By.xpath("//span[@class='badge badge-success']"));
		if(Home.isDisplayed() && AuditHome.isDisplayed() && AuditeeName.isDisplayed())
		{
			System.out.println("Pass : Home is Displayed");
			System.out.println("Pass : Audit Home is displayed");
			System.out.println("Pass : Auditee Name is Displayed");
		}



	}

	public void CheckingTheComplianceScoreCount(WebDriver driver)
	{
		//checking Yes count
		WebElement YesCount = driver.findElement(By.xpath("//span[@class='badge badge-success pad10 yes_count']"));
		String Actual_YesCount = YesCount.getText();
		int count1 = Integer.parseInt(Actual_YesCount);
		int Expected_count = 0;
		int Actual_count = count1;
		Assert.assertEquals(Expected_count, Actual_count);


		//Checking Partial Count
		WebElement PartialCount = driver.findElement(By.xpath("//span[@class='badge badge-warning pad10 partial_count']"));
		String Actual_PartialCount = PartialCount.getText();
		int count2 = Integer.parseInt(Actual_PartialCount);
		int Expected_count2 = 0;
		int Actual_count2 = count2;
		Assert.assertEquals(Expected_count2, Actual_count2);


		//Checking No Count
		WebElement NoCount = driver.findElement(By.xpath("//span[@class='badge badge-danger pad10 no_count']"));
		String Actual_NoCount = NoCount.getText();
		int count3 = Integer.parseInt(Actual_NoCount);
		int Expected_count3 = 0;
		int Actual_count3 = count3;
		Assert.assertEquals(Expected_count3, Actual_count3);

		//Checking NA Count
		WebElement NACount = driver.findElement(By.xpath("//span[@class='badge badge-success pad10 na_count']"));
		String Actual_NACount = NACount.getText();
		int count4 = Integer.parseInt(Actual_NACount);
		int Expected_count4 = 0;
		int Actual_count4 = count4;
		Assert.assertEquals(Expected_count4, Actual_count4);

		//Checking Input Count
		WebElement InputCount = driver.findElement(By.xpath("//span[@class='badge badge-success pad10 input_count']"));
		String Actual_InputCount = InputCount.getText();
		int count5 = Integer.parseInt(Actual_InputCount);
		int Expected_count5 = 0;
		int Actual_count5 = count5;
		Assert.assertEquals(Expected_count5, Actual_count5);
	}

	public void CheckingTheYesDispositions(WebDriver driver)
	{
		System.out.println("*******************************************");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of yes Dispositions is ! " +count);

		//Clicking on the 1st Yes Dispositions
		WebElement All = alloptions.get(0);
		String AllText = All.getText();
		System.out.println("Displayed Yes Dispositions are : " + AllText);

		String FirstDisipositions = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		System.out.println("Entered Yes Dispositions is : " + FirstDisipositions);
		Assert.assertEquals(FirstDisipositions, AllText);

		//Clicking on the 2nd Yes Dispositions
		WebElement All1 = alloptions.get(1);
		String AllText1 = All1.getText();
		System.out.println("Displayed Yes Dispositions are : " + AllText1);

		String SecondDisipositions = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		System.out.println("Entered Yes Dispositions is : " + SecondDisipositions);
		Assert.assertEquals(SecondDisipositions, AllText1);

		//Clicking on the 3rd Yes Dispositions
		WebElement All2 = alloptions.get(2);
		String AllText2 = All2.getText();
		System.out.println("Displayed Yes Dispositions are : " + AllText1);

		String ThridDisipositions = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		System.out.println("Entered Yes Dispositions is : " + ThridDisipositions);
		Assert.assertEquals(ThridDisipositions, AllText2);


		//Clicking on the 4th Yes Dispositions
		WebElement All3 = alloptions.get(3);
		String AllText3 = All3.getText();
		System.out.println("Displayed Yes Dispositions are : " + AllText3);

		String FourthDisipositions = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		System.out.println("Entered Yes Dispositions is : " + FourthDisipositions);
		Assert.assertEquals(FourthDisipositions, AllText3);


	}


	public void CheckingThePartialDispositions(WebDriver driver)
	{
		System.out.println("*******************************************");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of Partial Dispositions is ! " +count);

		//Clicking on the 1st Partial Dispositions
		WebElement All = alloptions.get(0);
		String AllText = All.getText();
		System.out.println("Displayed Partial Dispositions are : " + AllText);

		String FirstDisipositions = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		System.out.println("Entered Partial Dispositions is : " + FirstDisipositions);
		Assert.assertEquals(FirstDisipositions, AllText);

		//Clicking on the 2nd Partial Dispositions
		WebElement All1 = alloptions.get(1);
		String AllText1 = All1.getText();
		System.out.println("Displayed Partial Dispositions are : " + AllText1);

		String SecondDisipositions = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		System.out.println("Entered Partial Dispositions is : " + SecondDisipositions);
		Assert.assertEquals(SecondDisipositions, AllText1);

		//Clicking on the 3rd Partial Dispositions
		WebElement All2 = alloptions.get(2);
		String AllText2 = All2.getText();
		System.out.println("Displayed Partail Dispositions are : " + AllText1);

		String ThridDisipositions = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		System.out.println("Entered Partial Dispositions is : " + ThridDisipositions);
		Assert.assertEquals(ThridDisipositions, AllText2);

		//Clicking on the 4th Partial Dispositions
		WebElement All3 = alloptions.get(3);
		String AllText3 = All3.getText();
		System.out.println("Displayed Partial Dispositions are : " + AllText3);

		String FourthDisipositions = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		System.out.println("Entered Partial Dispositions is : " + FourthDisipositions);
		Assert.assertEquals(FourthDisipositions, AllText3);


	}

	public void CheckingTheNODispositions(WebDriver driver)
	{
		System.out.println("*******************************************");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of NO Dispositions is ! " +count);

		//Clicking on the 1st Partial Dispositions
		WebElement All = alloptions.get(0);
		String AllText = All.getText();
		System.out.println("Displayed NO Dispositions are : " + AllText);

		String FirstDisipositions = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		System.out.println("Entered NO Dispositions is : " + FirstDisipositions);
		Assert.assertEquals(FirstDisipositions, AllText);

		//Clicking on the 2nd Partial Dispositions
		WebElement All1 = alloptions.get(1);
		String AllText1 = All1.getText();
		System.out.println("Displayed NO Dispositions are : " + AllText1);

		String SecondDisipositions = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		System.out.println("Entered NO Dispositions is : " + SecondDisipositions);
		Assert.assertEquals(SecondDisipositions, AllText1);

		//Clicking on the 3rd Partial Dispositions
		WebElement All2 = alloptions.get(2);
		String AllText2 = All2.getText();
		System.out.println("Displayed NO Dispositions are : " + AllText1);

		String ThridDisipositions = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		System.out.println("Entered NO Dispositions is : " + ThridDisipositions);
		Assert.assertEquals(ThridDisipositions, AllText2);

		//Clicking on the 4th Partial Dispositions
		WebElement All3 = alloptions.get(3);
		String AllText3 = All3.getText();
		System.out.println("Displayed NO Dispositions are : " + AllText3);

		String FourthDisipositions = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		System.out.println("Entered NO Dispositions is : " + FourthDisipositions);
		Assert.assertEquals(FourthDisipositions, AllText3);

	}

	public void CheckingTheNADispositions(WebDriver driver)
	{
		System.out.println("*******************************************");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of NA Dispositions is ! " +count);

		//Clicking on the 1st Partial Dispositions
		WebElement All = alloptions.get(0);
		String AllText = All.getText();
		System.out.println("Displayed NA Dispositions are : " + AllText);

		String FirstDisipositions = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		System.out.println("Entered NA Dispositions is : " + FirstDisipositions);
		Assert.assertEquals(FirstDisipositions, AllText);

		//Clicking on the 2nd Partial Dispositions
		WebElement All1 = alloptions.get(1);
		String AllText1 = All1.getText();
		System.out.println("Displayed NA Dispositions are : " + AllText1);

		String SecondDisipositions = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		System.out.println("Entered NA Dispositions is : " + SecondDisipositions);
		Assert.assertEquals(SecondDisipositions, AllText1);

		//Clicking on the 3rd Partial Dispositions
		WebElement All2 = alloptions.get(2);
		String AllText2 = All2.getText();
		System.out.println("Displayed NA Dispositions are : " + AllText1);

		String ThridDisipositions = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		System.out.println("Entered NA Dispositions is : " + ThridDisipositions);
		Assert.assertEquals(ThridDisipositions, AllText2);

		//Clicking on the 4th Partial Dispositions
		WebElement All3 = alloptions.get(3);
		String AllText3 = All3.getText();
		System.out.println("Displayed NA Dispositions are : " + AllText3);

		String FourthDisipositions = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		System.out.println("Entered NA Dispositions is : " + FourthDisipositions);
		Assert.assertEquals(FourthDisipositions, AllText3);


	}

	public void VerifyingYesDispositions(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		wait.until(ExpectedConditions.visibilityOf(ListBox));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actial_count = alloptions.size();
		int Expected_count = 4;
		Assert.assertEquals(Actial_count, Expected_count, "Yes Disposition count is showing Wrong");
		System.out.println("The Totle Number of yes Dispositions is ! " + Actial_count);

	}

	public void VerifyingNODispositions(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actial_count = alloptions.size();
		int Expected_count = 4;
		Assert.assertEquals(Actial_count, Expected_count, "NO Disposition count is showing Wrong");
		System.out.println("The Totle Number of NO Dispositions is ! " + Actial_count);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

	}

	public void VerifyingPartialDispositions(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actial_count = alloptions.size();
		int Expected_count = 4;
		Assert.assertEquals(Actial_count, Expected_count, "Partial Disposition count is showing Wrong");
		System.out.println("The Totle Number of Partial Dispositions is ! " + Actial_count);


	}


	public void VerifyingNADispositions(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@multiple='multiple']")));
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actial_count = alloptions.size();
		int Expected_count = 4;
		Assert.assertEquals(Actial_count, Expected_count, "NA Disposition count is showing Wrong");
		System.out.println("The Totle Number of NA Dispositions is ! " + Actial_count);
	}



	public void SelectingAllDispositions(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ListBox = driver.findElement(By.xpath("//select[@multiple='multiple']"));
		wait.until(ExpectedConditions.visibilityOf(ListBox));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		for(int i=0; i<alloptions.size(); i++)
		{
			try
			{
				WebElement All = alloptions.get(i);
				All.click();
				System.out.println("All Dispossitions are selected");
				chiledTest.log(Status.INFO, "All The Dispositions are Selected");
			}catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}


		}
	}

	public void CheckingTheValues(WebDriver driver)
	{
		System.out.println("*******************************************");


		WebElement ListBox = driver.findElement(By.id("audit_compliance_input_value"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of the Values Drop down is ! " +count);

		//Clicking on the 1st Partial Dispositions
		WebElement All = alloptions.get(1);
		String AllText = All.getText();
		System.out.println("Displayed Value is : " + AllText);

		String FirstDisipositions = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		System.out.println("Entered Values is : " + FirstDisipositions);
		Assert.assertEquals(FirstDisipositions, AllText);

		//Clicking on the 2nd Values
		WebElement All1 = alloptions.get(2);
		String AllText1 = All1.getText();
		System.out.println("Displayed Values is : " + AllText1);

		String SecondDisipositions = Lib.getCellValue(XLPATH, "Check Point", 140, 0);
		System.out.println("Entered Values is : " + SecondDisipositions);
		Assert.assertEquals(SecondDisipositions, AllText1);

		//Clicking on the 3rd Partial Dispositions
		WebElement All2 = alloptions.get(3);
		String AllText2 = All2.getText();
		System.out.println("Displayed Values Is : " + AllText1);

		String ThridDisipositions = Lib.getCellValue(XLPATH, "Check Point", 141, 0);
		System.out.println("Entered Values is : " + ThridDisipositions);
		Assert.assertEquals(ThridDisipositions, AllText2);


	}

	public void SelectingValues(WebDriver driver)
	{		
		try{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			WebElement ListBox = driver.findElement(By.id("audit_compliance_input_value"));
			Select select = new Select(ListBox);
			List<WebElement> alloptions = select.getOptions();
			int count = alloptions.size();
			System.out.println("The Totle Number of the Values Drop down is ! " +count);
			for(int i=0; i<count; i++){
				alloptions.get(1).click();
				System.out.println("1st Value is Selected Under Values Drop down List");
				chiledTest.log(Status.INFO, "1st Value is Selected Under Values Drop down List");}
		}catch (Exception e) {
			WebElement ListBox = driver.findElement(By.id("issue_input_value"));
			Select select = new Select(ListBox);
			List<WebElement> alloptions = select.getOptions();
			int count = alloptions.size();
			System.out.println("The Totle Number of the Values Drop down is ! " +count);
			for(int i=0; i<count; i++){
				alloptions.get(1).click();
				System.out.println("1st Value is Selected Under Values Drop down List");
				chiledTest.log(Status.INFO, "1st Value is Selected Under Values Drop down List");}
		}

	}
	public void SelectingValuesUnderExpressMode(WebDriver driver)
	{
		WebElement ListBox = driver.findElement(By.xpath("//select[@id='input_value']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of the Values Drop down is ! " +count);
		for(int i=0; i<count; i++)
		{
			alloptions.get(1).click();
			System.out.println("1st Value is Selected Under Values Drop down List");
			chiledTest.log(Status.INFO, "1st Value is Selected Under Values Drop down List");
		}

	}


	public void VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Audit submitted successfully Message is Not Displayed");
		System.out.println("Audit Submitted Successfully message is Displayed");
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");
	}

	public void VerifySubmittedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Submitted successfully Message is Not Displayed");
		System.out.println("Pass : Submitted successfully Success Message is Displayed");
		chiledTest.log(Status.INFO, "Submitted successfully Success Message is Displayed");
	}

	public void VerifyCalenderIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement calender = driver.findElement(By.xpath("//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']"));
		if(wait.until(ExpectedConditions.visibilityOf(calender)).isDisplayed())
		{
			System.out.println("Pass : Calender is Displayed");
		}

	}

	public void VerifyingReasonPopUpIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Reason = driver.findElement(By.xpath("//form[@id='not_found_reason_form']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(Reason)).isDisplayed(), "Reason pop is NOT Displayed");
		System.out.println("Reason pop is Displayed");
		chiledTest.log(Status.INFO, "Reason pop is Displayed");
	}

	public void VerifyNameCantBeBlankErrorMsgIsDisplayed(WebDriver driver)
	{

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement NameCantBlank = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(NameCantBlank)).isDisplayed())
		{
			String Actual_text = NameCantBlank.getText();
			String Expected_text = "Name can't be blank";
			Assert.assertEquals(Actual_text, Expected_text, "Name can't be blank Error Message is NOT Displayed");
			System.out.println("Pass : Name can't be blank Error Message is Displayed");
			chiledTest.log(Status.INFO, "Name can't be blank Error Message is Displayed");
		}

		//Clicking on the close Button
		driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
	}

	public void VerifySubAuditeeAddedAndScheduledSuccessfully(WebDriver driver)
	{
		System.out.println("Test");
		/*WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_text = SuccessMSG.getText();
			String Expected_text = "Sub auditee added and scheduled successfully";
			Assert.assertEquals(Actual_text, Expected_text, "Sub auditee added and scheduled successfully Message is Displayed");
			System.out.println("Pass : Sub auditee added and scheduled successfully Message is Displayed Message is Displayed");
			chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Message is Displayed Message is Displayed");

			//Clicking on the close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}*/

	}

	public void VerifyDuplicatePINotAllowedMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement DuplicatePI = driver.findElement(By.xpath("//div[@class='alert alert-success']//span[contains(text(),'Duplicate PI not allowed')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(DuplicatePI)).isDisplayed(), "Duplicate PI Not allowed Message Is Not Displayed");
		System.out.println("Duplicate PI not allowed Message is Diplayed");
		chiledTest.log(Status.INFO,"Duplicate PI not allowed Message is Diplayed");

		//clicking on the Close button
		driver.findElement(By.xpath("//div[@class='alert alert-success']//button")).click();

	}

	public void VerifyNoDataAvailableInTableMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement Nodata = driver.findElement(By.xpath("//table[@id='tableWithSearchSummary']//td[@class='dataTables_empty']"));
		wait.until(ExpectedConditions.visibilityOf(Nodata)).isDisplayed();
		{
			String Actual_text = Nodata.getText();
			String Expected_text = "No data available in table";
			Assert.assertEquals(Actual_text, Expected_text, "No data available in table message is Not Displayed");

			System.out.println("Pass : No data available in table message is Displayed");
		}
	}

	public void VerifyEnterRemarksIsMandatory(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath("//textarea[@placeholder='Enter Remarks'][@required='required']")).isDisplayed();
			System.out.println("Pass : Enter Remarks is Required Field");
		}catch (Exception e) {
			System.out.println("Fail : Enter Remarks is not Required Field");
		}
	}

	public void VerifyHandleRequestPopUpIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Checking the Handle Request Pop is Displayed
		WebElement HandleRequest = driver.findElement(By.xpath("//h4[contains(text(),'Handle Request')]"));
		if(wait.until(ExpectedConditions.visibilityOf(HandleRequest)).isDisplayed())
		{
			String Actual_Text = HandleRequest.getText();
			String Expected_text = "Handle Request";
			Assert.assertEquals(Actual_Text, Expected_text, "Handle Request Pop is Wrong");
			System.out.println("Handle Request Pop Up is Displayed");
		}
	}

	public void VerifyReasonIsRequiredFiled()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement HandleRequestReason = driver.findElement(By.xpath("//input[@placeholder='Enter Reason'][@required='required']"));
		if(wait.until(ExpectedConditions.visibilityOf(HandleRequestReason)).isDisplayed())
		{
			System.out.println("Pass : Reason is Required Field");	
		}
	}

	public void VerifyRejectRequestPlacedSuccessfullyPleasewaitForAdminApprovalMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_text = "Reject request placed successfully please wait for admin approval.";
			Assert.assertEquals(Actual_Text, Expected_text);
			System.out.println("Reject request placed successfully please wait for admin approval Success Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}

	public void VerifyReassignRequestPlacedSuccessfullyPleasewaitForAdminApprovalMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_text = "Reassign request placed successfully please wait for admin approval.";
			Assert.assertEquals(Actual_Text, Expected_text);
			System.out.println("Reassign request placed successfully please wait for admin approval Success Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}

	public void VerifyAuditEditedSuccessfullyPleasewaitForAdminApprovalMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_text = "Audit edited succesfully, please wait for admin approval";
			Assert.assertEquals(Actual_Text, Expected_text);
			System.out.println("Audit edited succesfully, please wait for admin approval Success Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}

	public void VerifyAcceptRejectReassignEditButtonsShouldNotBeDisplay() throws InterruptedException
	{
		Thread.sleep(4000);

		//Checking Accept Button 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> AcceptBTN = driver.findElements(By.xpath("//a[contains(text(),'Accept')]"));
		Assert.assertTrue(AcceptBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Accept Button is Not Displayed");

		//Checking Reject Button 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> RejectBTN = driver.findElements(By.xpath("//a[contains(text(),'Reject')]"));
		Assert.assertTrue(RejectBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Reject Button is Not Displayed");

		//Checking Reassign Button 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> ReassignBTN = driver.findElements(By.xpath("//a[contains(text(),'Reassign')]"));
		Assert.assertTrue(ReassignBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Reassign Button is Not Displayed");

		//Checking Edit Button 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> EditBTN = driver.findElements(By.xpath("//a[contains(text(),'Edit Schedule')]"));
		Assert.assertTrue(EditBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Edit Schedule Button is Not Displayed");

	}

	public void VerifyRejectReassignEditButtonsShouldNotBeDisplay() throws InterruptedException
	{
		Thread.sleep(2000);

		//Checking Reject Button 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> RejectBTN = driver.findElements(By.xpath("//a[contains(text(),'Reject')]"));
		Assert.assertTrue(RejectBTN.size()<=0, "Reject Button is Displayed");
		System.out.println("Reject Button is Not Displayed");

		//Checking Reassign Button 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> ReassignBTN = driver.findElements(By.xpath("//a[contains(text(),'Reassign')]"));
		Assert.assertTrue(ReassignBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Reassign Button is Not Displayed");

		//Checking Edit Button 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> EditBTN = driver.findElements(By.xpath("//a[contains(text(),'Edit Schedule')]"));
		Assert.assertTrue(EditBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Edit Schedule Button is Not Displayed");

	}


	public void VerifyPartialTabIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking the Partial Tab is Displayed or not
		WebElement PartialTab = driver.findElement(By.xpath("//li[@class='express_partial active']/a[@class='partial_li']"));
		if(wait.until(ExpectedConditions.visibilityOf(PartialTab)).isDisplayed())
		{
			System.out.println("Pass : Partial Tab is Displayed");
		}
	}

	public void VerifyExpressButtonIsDisabled()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement ExpressBTNDisabled = driver.findElement(By.xpath("//a[@class='btn btn-complete btn-cons btn-lg activate_express_mode disabled disabled_color']"));
		Assert.assertFalse(ExpressBTNDisabled.isDisplayed(), "Express button is NOT in Disabled");
		System.out.println("Pass : Express Button is Disabled");
		chiledTest.log(Status.INFO, "Pass : Express Button is Disabled");

	}

	public void VerifyAtLeastOneDocumentShouldbeUploadedPopUpIsDisplayed()
	{
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "Atleast one document should be uploaded.";
		Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
		System.out.println("Pass : Atleast one document should be uploaded Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Atleast one document should be uploaded Pop Up is Displayed");

		Alert.accept();
	}

	public void VerifyPleaseEnterRemarksPopUpIsDisplayed()
	{
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "Please enter remarks";
		Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
		System.out.println("Pass : Please enter remarks Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Please enter remarks Pop Up is Displayed");

		Alert.accept();
	}

	public void VerifyOnlyPdfWavMp3OggMp4DocDocxJpgPngWmvJpegMpegFileShouldBeUploadedPopUpIsDisplayed()
	{
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		System.out.println("Displayed Pop Up Message is" + Actual_Text);
		String Expected_Text = "only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, jpeg, xls, xlsx, csv file should be uploaded.";
		Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
		System.out.println("only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, jpeg, xls, xlsx, csv file should be uploaded. Pop Up is Displayed");
		chiledTest.log(Status.INFO, "only pdf, wav, mp3, ogg, mp4, doc, docx, jpg, png, jpeg, xls, xlsx, csv file should be uploaded.Pop Up is Displayed");

		Alert.accept();
	}

	public void VerifyMarkPendingPIAsNotExecutedButtonShouldNotDisplay()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> NotExecutedBTN = driver.findElements(By.xpath("//a[contains(text(),'Mark Pending PI as not executed')]"));
		Assert.assertTrue(NotExecutedBTN.size()<=0, "Mark Pending Pi As Not Executed Button is Showing Befer the PI Execution");
		System.out.println("Mark Pending Pi As Not Executed Button is not displayed");
		chiledTest.log(Status.INFO, "Mark Pending Pi As Not Executed Button is not displayed");

	}

	//Checking Please execute all the check points Pop up Is displayed
	public void VerifyPleaseExecuteAllTheCheckPointsPopUpIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "Please execute all the check points";
		Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
		System.out.println("Pass : Please execute all the check points Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Please execute all the check points Pop Up is Displayed");

		Alert.accept();
	}

	//checking Max value or min value should not be blank
	public void VerifyMaxValueOrMinValueShouldNotBeBlankPopUpIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "Max value or min value should not be blank";
		Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
		System.out.println("Pass : Max value or min value should not be blank Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Max value or min value should not be blank Pop Up is Displayed");

		Alert.accept();
	}

	//Checking Max value should be greater than observed value
	public void VerifyMaxValueShouldBeGretterThanObservedValuePopUpIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "Max value should be gretter than observed value";
		Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
		System.out.println("Pass : Max value should be greater than observed value Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Max value should be greater than observed value Pop Up is Displayed");

		Alert.accept();
	}

	//Checking Please provide inputs to all checkpoints before moving to next tab Pop Up
	public void VerifyPleaseProvideInputsToAllCheckpointsBeforeMovingToNextTabPopUpIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "Please provide inputs to all checkpoints before moving to next tab";
		Assert.assertEquals(Actual_Text, Expected_Text, "Pop up Message is Wrong");
		System.out.println("Pass : Please provide inputs to all checkpoints before moving to next tab Pop Up Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Please provide inputs to all checkpoints before moving to next tab Pop Up Pop Up is Displayed");

		Alert.accept();
	}

	public void MoveSlider(WebDriver driver) throws InterruptedException
	{
		
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Slider));
			Actions act = new Actions(driver);
			act.dragAndDropBy(Slider, 1000, 0).perform();

			//checking after slider is moved to 50 Observed Value is showing 50 or not
			String Actual_ObservedValues = driver.findElement(By.xpath("//span[@id='observed_val']")).getText();
			String Expected_ObservedValues = "50.00";
			Assert.assertEquals(Actual_ObservedValues, Expected_ObservedValues, "Observed Values is Showing Wrong");
			System.out.println("Actual Observed Values is : " + Actual_ObservedValues);
			System.out.println("Expected Observed Values is : " + Expected_ObservedValues);
			System.out.println("Slider is Moved to 50");
			chiledTest.log(Status.INFO, "Slider is moved to 50");
		}catch (MoveTargetOutOfBoundsException e) {

		}
	}

	public void VerifyReAuditSubmittedButtonisDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ReAuditSubmittedBTN = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td/a/span[text()='Reaudit Submitted']"));
		Assert.assertTrue(ReAuditSubmittedBTN.isDisplayed(), "ReAudit Submitted Button is NOT Displayed");
		System.out.println("ReAudit Submitted Button is Displayed");
		chiledTest.log(Status.INFO, "ReAudit Submitted Button is Displayed");

	}

	public void VerifyAllButtonsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//Checking the Yes Button is Displayed
		List<WebElement> YesBTN = driver.findElements(By.xpath("//input[@value='Yes']/ancestor::label"));
		Assert.assertTrue(YesBTN.size()>0, "Yes Button is not Displayed");
		System.out.println("Yes Button is Displayed");
		chiledTest.log(Status.INFO, "Yes Button is Displayed");

		//Checking the NO Button is Displayed
		List<WebElement> NOBTN = driver.findElements(By.xpath("//input[@value='No']/ancestor::label"));
		Assert.assertTrue(NOBTN.size()>0, "No Button is not Displayed");
		System.out.println("No Button is Displayed");
		chiledTest.log(Status.INFO, "No Button is Displayed");

		//Checking the Partial Button is Displayed
		List<WebElement> PartialBTN = driver.findElements(By.xpath("//input[@value='Partial']/ancestor::label"));
		Assert.assertTrue(PartialBTN.size()>0, "Partial Button is not Displayed");
		System.out.println("Partial Button is Displayed");
		chiledTest.log(Status.INFO, "Partial Button is Displayed");

		//Checking the NA Button is Displayed
		List<WebElement> NABTN = driver.findElements(By.xpath("//input[@value='NA']/ancestor::label"));
		Assert.assertTrue(NABTN.size()>0, "Na Button is not Displayed");
		System.out.println("NA Button is Displayed");
		chiledTest.log(Status.INFO, "NA Button is Displayed");

	}

	public void VerifyOnlyYesAndNoButtonsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//Checking the Yes Button is Displayed
		List<WebElement> YesBTN = driver.findElements(By.xpath("//input[@value='Yes']/ancestor::label"));
		Assert.assertTrue(YesBTN.size()>0, "Yes Button is not Displayed");
		System.out.println("Yes Button is Displayed");
		chiledTest.log(Status.INFO, "Yes Button is Displayed");

		//Checking the NO Button is Displayed
		List<WebElement> NOBTN = driver.findElements(By.xpath("//input[@value='No']/ancestor::label"));
		Assert.assertTrue(NOBTN.size()>0, "No Button is not Displayed");
		System.out.println("No Button is Displayed");
		chiledTest.log(Status.INFO, "No Button is Displayed");

		//Checking the Partial Button is not Displayed
		List<WebElement> PartialBTN = driver.findElements(By.xpath("//input[@value='Partial']/ancestor::label"));
		Assert.assertFalse(PartialBTN.size()<0, "Partial Button is not Displayed");
		System.out.println("Partial Button is Not Displayed");
		chiledTest.log(Status.INFO, "Partial Button is Not Displayed");

		//Checking the NA Button is not  Displayed
		List<WebElement> NABTN = driver.findElements(By.xpath("//input[@value='NA']/ancestor::label"));
		Assert.assertFalse(NABTN.size()<0, "Na Button is not Displayed");
		System.out.println("NA Button is Not Displayed");
		chiledTest.log(Status.INFO, "NA Button is Not Displayed");

	}

	public void VerifyOnlyYesNoAndPartialButtonsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//Checking the Yes Button is Displayed
		List<WebElement> YesBTN = driver.findElements(By.xpath("//input[@value='Yes']/ancestor::label"));
		Assert.assertTrue(YesBTN.size()>0, "Yes Button is not Displayed");
		System.out.println("Yes Button is Displayed");
		chiledTest.log(Status.INFO, "Yes Button is Displayed");

		//Checking the NO Button is Displayed
		List<WebElement> NOBTN = driver.findElements(By.xpath("//input[@value='No']/ancestor::label"));
		Assert.assertTrue(NOBTN.size()>0, "No Button is not Displayed");
		System.out.println("No Button is Displayed");
		chiledTest.log(Status.INFO, "No Button is Displayed");

		//Checking the Partial Button is Displayed
		List<WebElement> PartialBTN = driver.findElements(By.xpath("//input[@value='Partial']/ancestor::label"));
		Assert.assertTrue(PartialBTN.size()>0, "Partial Button is not Displayed");
		System.out.println("Partial Button is Displayed");
		chiledTest.log(Status.INFO, "Partial Button is Displayed");

		//Checking the NA Button is Displayed
		List<WebElement> NABTN = driver.findElements(By.xpath("//input[@value='NA']/ancestor::label"));
		Assert.assertFalse(NABTN.size()<0, "NA Button is not Displayed");
		System.out.println("NA Button is Not Displayed");
		chiledTest.log(Status.INFO, "NA Button is Not Displayed");

	}

	public void VerifyOnlyYesNoAndNAButtonsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//Checking the Yes Button is Displayed
		List<WebElement> YesBTN = driver.findElements(By.xpath("//input[@value='Yes']/ancestor::label"));
		Assert.assertTrue(YesBTN.size()>0, "Yes Button is not Displayed");
		System.out.println("Yes Button is Displayed");
		chiledTest.log(Status.INFO, "Yes Button is Displayed");

		//Checking the NO Button is Displayed
		List<WebElement> NOBTN = driver.findElements(By.xpath("//input[@value='No']/ancestor::label"));
		Assert.assertTrue(NOBTN.size()>0, "No Button is not Displayed");
		System.out.println("No Button is Displayed");
		chiledTest.log(Status.INFO, "No Button is Displayed");

		//Checking the Partial Button is Displayed
		List<WebElement> PartialBTN = driver.findElements(By.xpath("//input[@value='Partial']/ancestor::label"));
		Assert.assertFalse(PartialBTN.size()<0, "Partial Button is not Displayed");
		System.out.println("Partial Button is Not Displayed");
		chiledTest.log(Status.INFO, "Partial Button is Not Displayed");

		//Checking the NA Button is Displayed
		List<WebElement> NABTN = driver.findElements(By.xpath("//input[@value='NA']/ancestor::label"));
		Assert.assertTrue(NABTN.size()>0, "Na Button is not Displayed");
		System.out.println("NA Button is Displayed");
		chiledTest.log(Status.INFO, "NA Button is Displayed");

	}

	public void VerifyAllButtonsAreNotDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//Checking the Yes Button is Displayed
		List<WebElement> YesBTN = driver.findElements(By.xpath("//input[@value='Yes']/ancestor::label"));
		Assert.assertFalse(YesBTN.size()<0, "Yes Button is not Displayed");
		System.out.println("Yes Button is Not Displayed");
		chiledTest.log(Status.INFO, "Yes Button is Not Displayed");

		//Checking the NO Button is Displayed
		List<WebElement> NOBTN = driver.findElements(By.xpath("//input[@value='No']/ancestor::label"));
		Assert.assertFalse(NOBTN.size()<0, "No Button is not Displayed");
		System.out.println("No Button is Not Displayed");
		chiledTest.log(Status.INFO, "No Button is Not Displayed");

		//Checking the Partial Button is Displayed
		List<WebElement> PartialBTN = driver.findElements(By.xpath("//input[@value='Partial']/ancestor::label"));
		Assert.assertFalse(PartialBTN.size()<0, "Partial Button is not Displayed");
		System.out.println("Partial Button is Not Displayed");
		chiledTest.log(Status.INFO, "Partial Button is Not Displayed");

		//Checking the NA Button is Displayed
		List<WebElement> NABTN = driver.findElements(By.xpath("//input[@value='NA']/ancestor::label"));
		Assert.assertFalse(NABTN.size()<0, "Na Button is not Displayed");
		System.out.println("NA Button is Not Displayed");
		chiledTest.log(Status.INFO, "NA Button is Not Displayed");

	}

	public void VerifyingPartialComplianceIsDisabledByAdminForTheSelectedCheckpointAlertIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "Partial compliance is disabled by admin for the selected checkpoint.";
		Assert.assertEquals(Actual_Text, Expected_Text, "Alert Pop Up Message is Wrong");
		System.out.println("Partial compliance is disabled by admin for the selected checkpoint. pop is Displayed");
		chiledTest.log(Status.INFO, "Partial compliance is disabled by admin for the selected checkpoint. pop is Displayed");

		//Accepting the Alert
		Alert.accept();
	}

	public void VerifyingNAComplianceIsDisabledByAdminForTheSelectedCheckpointAlertIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Actual_Text = Alert.getText();
		String Expected_Text = "N/A compliance is disabled by admin, for the selected checkpoint.";
		Assert.assertEquals(Actual_Text, Expected_Text, "Alert Pop Up Message is Wrong");
		System.out.println("N/A compliance is disabled by admin, for the selected checkpoint. pop is Displayed");
		chiledTest.log(Status.INFO, "N/A compliance is disabled by admin, for the selected checkpoint. pop is Displayed");

		//Accepting the Alert
		Alert.accept();
	}

	public void VerifyScheduleCreatedSuccessfullySuccessMSGISDisplayed()
	{
		WebElement SuccessMSG = driver.findElement(By.xpath("//span[text()='Schedule created successfully']"));
		if(SuccessMSG.isDisplayed())
		{
			String Actual_text = SuccessMSG.getText();
			String Expected_text = "Schedule created successfully";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Schedule created successfully. Success Message is Displayed");

			//clicking on the cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@type='button']")).click();
		} 
	}

	public void VerifyAreYouSureYouWantToSkipAllTheUnattemptedExceptionalCheckpointsPopUpIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SkipPopUp = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to skip all the unattempted exceptional checkpoints?')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SkipPopUp)).isDisplayed(), "Are you sure you want to skip all the unattempted exceptional checkpoints? Pop Up is Not Displayed");
		System.out.println("Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed");
		chiledTest.log(Status.INFO, "Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed");
	}

	/*public void VerifyOnly6AParametersAreRequired()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> FirstParameters = driver.findElements(By.xpath("//input[@id='audit_compliance_auditor_additional_infos_attributes_0_auditor_info' and @required='required']"));
		Assert.assertTrue(FirstParameters.size()>0, "1st Parameter is Not Required Field");

		List<WebElement> ThirdParameters = driver.findElements(By.xpath("//textarea[@id='audit_compliance_auditor_additional_infos_attributes_2_auditor_info' and @required='required']"));
		Assert.assertTrue(ThirdParameters.size()>0, "3rd Parameter is Not Required Field");

		List<WebElement> FifthParameters = driver.findElements(By.xpath("//input[@id='audit_compliance_auditor_additional_infos_attributes_4_auditor_info' and @required='required']"));
		Assert.assertTrue(FifthParameters.size()>0, "5th Parameter is Not Required Field");

		List<WebElement> SixthParameters = driver.findElements(By.xpath("//input[@id='audit_compliance_auditor_additional_infos_attributes_6_auditor_info' and @required='required']"));
		Assert.assertTrue(SixthParameters.size()>0, "6th Parameter is Not Required Field");

		List<WebElement> EightthParameters = driver.findElements(By.xpath("//textarea[@id='audit_compliance_auditor_additional_infos_attributes_8_auditor_info' and @required='required']"));
		Assert.assertTrue(EightthParameters.size()>0, "8th Parameter is Not Required Field");

		List<WebElement> TenthParameters = driver.findElements(By.xpath("//input[@id='audit_compliance_auditor_additional_infos_attributes_10_auditor_info' and @required='required']"));
		Assert.assertTrue(TenthParameters.size()>0, "10th Parameter is Not Required Field");

	}*/

	/*public void Set12ParametersValues()
	{
		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[1]//input[@placeholder='Enter number']")).sendKeys("20");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[2]//textarea[@placeholder='Enter text']")).sendKeys("Test ABC");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[3]//textarea[@placeholder='Enter text and number']")).sendKeys("Test 123");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[4]//input[@placeholder='Select date']")).sendKeys("12 04 2021");

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

		driver.findElement(By.xpath("//select[@id='audit_compliance_auditor_additional_infos_attributes_5_auditor_info']//option[2]")).click();

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[7]//input[@placeholder='Enter percentage']")).sendKeys("100");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[8]//input[@placeholder='Enter number']")).sendKeys("60");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[9]//textarea[@placeholder='Enter text']")).sendKeys("Test XYZ");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[10]//textarea[@placeholder='Enter text and number']")).sendKeys("Test 456");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[11]//input[@placeholder='Enter percentage']")).sendKeys("70");

		driver.findElement(By.xpath("//table[@id='table_addtional_info']//tbody/tr[12]//input[@placeholder='Enter percentage']")).sendKeys("85");

	}*/

	public void VerifyDocumentUploadedSuccessfullyMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement DocMSG = driver.findElement(By.xpath("//span[text()='Document Uploaded successfully']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(DocMSG)).isDisplayed(), "Document Uploaded successfully Messag is NOT Displayed");
		System.out.println("Document Uploaded successfully message is displayed");
		chiledTest.log(Status.INFO, "Document Uploaded successfully message is displayed");

		//clicking on the close Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']//button")).click();
	}

	public void SelectingAllDocumentsUnderQuoteAuditReference() throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> dd = driver.findElements(By.xpath("//div[@class='fallback']//input[@type='checkbox']"));
		int Actaul_Size = dd.size();
		int Expected_Size = 5;
		Assert.assertEquals(Actaul_Size, Expected_Size, "5 documents are Not Displayed");
		for(int i=0; i<dd.size(); i++)
		{
			try{
				WebElement aa = dd.get(i);
				aa.click();
			}catch (StaleElementReferenceException e) {
			}

		}
	}

	public void VerifyJobDoneSuccessfullyMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement JobDoneMSG = driver.findElement(By.xpath("//span[text()='Job done successfully']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(JobDoneMSG)).isDisplayed(), "Job done successfully Message is Not Displayed");
		System.out.println("Job done successfully Message is Diplayed");
		chiledTest.log(Status.INFO, "Job done successfully Message is Diplayed");
	}

	public void VerifyAcceptButtonIsDisplayed() throws InterruptedException
	{
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(AcceptBTN.isDisplayed(), "Accept button is Not Displayed");
		System.out.println("Accept button iis Diplayed");
		chiledTest.log(Status.INFO, "Accept button iis Diplayed");
	}

	public void VerifyRejectButtonIsDisplayed() throws InterruptedException
	{
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(RejectBTN.isDisplayed(), "Reject button is Not Displayed");
		System.out.println("Rject button iis Diplayed");
		chiledTest.log(Status.INFO, "Reject button iis Diplayed");
	}

	public void VerifyReassignButtonIsDisplayed() throws InterruptedException
	{
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(ReassignBTN.isDisplayed(), "reassign button is Not Displayed");
		System.out.println("reassign button iis Diplayed");
		chiledTest.log(Status.INFO, "reassign button iis Diplayed");
	}

	public void VerifyRequestForExtensionButtonIsDisplayed() throws InterruptedException
	{
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(ReqestForExtensionBTN.isDisplayed(), "Request For Extension button is Not Displayed");
		System.out.println("Request For Extension button iis Diplayed");
		chiledTest.log(Status.INFO, "Request For Extension button iis Diplayed");
	}

	public void VerifyRescheduleButtonIsDisplayed() throws InterruptedException
	{
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(RescheduleBTN.isDisplayed(), "Reschedule button is Not Displayed");
		System.out.println("Reschedule button iis Diplayed");
		chiledTest.log(Status.INFO, "Reschedule button iis Diplayed");
	}

	public void VerifyLeadAuditorNotAcceptedButtonIsDisplayed() throws InterruptedException
	{
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(LeadAuditorNotAcceptedBTN.isDisplayed(), "Lead Auditor not accepted button is Not Displayed");
		System.out.println("Lead Auditor not accepted button iis Diplayed");
		chiledTest.log(Status.INFO, "Lead Auditor not accepted button iis Diplayed");
	}

	public void VerifyInprogressButtonIsDisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertTrue(InProgressBTN.isDisplayed(), "In progress button is Not Displayed");
		System.out.println("In progress button iis Diplayed");
		chiledTest.log(Status.INFO, "In progress button iis Diplayed");
	}

	public void VerifyTaskCompletedSuccessfullyMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement TaskCompletedMSG = driver.findElement(By.xpath("//span[contains(text(),'Task completed successfully')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(TaskCompletedMSG)).isDisplayed(), "Task completed successfully Message is Not Displayed");
		System.out.println("Task completed successfully is Diplayed");
		chiledTest.log(Status.INFO, "Task completed successfully is Diplayed");
	}

	public void Verify8CPIsDisplayedInExpressMode()
	{
		List<WebElement> TotalCP = driver.findElements(By.xpath("//ul[@id='sortable1']//li"));
		int Actual_TotalCP = TotalCP.size();
		int Expected_TotalCP = 8;
		Assert.assertEquals(Actual_TotalCP, Expected_TotalCP, "Total 8 CP are Not Displayed");
		System.out.println("Total 8 CP are Displayed");
		chiledTest.log(Status.INFO, "Total 8 CP are Displayed");
	}

	public void Verify10CPIsDisplayedInExpressMode()
	{
		List<WebElement> TotalCP = driver.findElements(By.xpath("//ul[@id='sortable1']//li"));
		int Actual_TotalCP = TotalCP.size();
		int Expected_TotalCP = 10;
		Assert.assertEquals(Actual_TotalCP, Expected_TotalCP, "Total 10 CP are Not Displayed");
		System.out.println("Total 10 CP are Displayed");
		chiledTest.log(Status.INFO, "Total 10 CP are Displayed");
	}

	public void VerifyIntentHasAlreadyBeenTakenErrorMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//span[text()='Intent has already been taken']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed(), "Intent has already been taken Message is Not Displayed");
		System.out.println("Intent has already been taken Message is Displayed");
		chiledTest.log(Status.INFO, "Intent has already been taken Message is Displayed");

		//clicking close button
		driver.findElement(By.xpath("//div[@class='alert alert-danger']//button[@class='close']")).click();

	}

	public void VerifyAreYouSureYouWantToSkipAllNonAttentedNegativeCheckpointsPopUpIsDisplayed()
	{
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement MSG1 = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to skip all the unattempted exceptional checkpoints?')]"));
			Assert.assertTrue(MSG1.isDisplayed(), "Are you sure you want to skip all the unattempted exceptional checkpoints? Message is NOT Displayed");
			System.out.println("Are you sure you want to skip all the unattempted exceptional checkpoints? Message is Displayed");
			chiledTest.log(Status.INFO, "Are you sure you want to skip all the unattempted exceptional checkpoints? Message is Displayed");
		}catch (Exception e) {

			WebElement MSG1 = driver.findElement(By.xpath("//p[contains(text(),'Are you sure you want to skip all non attented negative checkpoints.')]"));
			Assert.assertTrue(MSG1.isDisplayed(), "Are you sure you want to skip all non attented negative checkpoints. Message is NOT Displayed");
			System.out.println("Are you sure you want to skip all non attented negative checkpoints. Message is Displayed");
			chiledTest.log(Status.INFO, "Are you sure you want to skip all non attented negative checkpoints. Message is Displayed");

		}
	}

	public void ClickAddCheckpointButton()
	{
		AddCheckPointButton.click();
		System.out.println("Add Checkpoint Button is Clicked");
		chiledTest.log(Status.INFO, "Issue Button is Clicked");
	}

	public void Verify2GroupsAreDisplayed()
	{
		List<WebElement> TotalGroup = driver.findElements(By.xpath("//div[@class='col-lg-2 col-md-2 col-sm-2 col-xs-2 bhoechie-tab-menu']//div//a"));
		int Actual_TotalGP = TotalGroup.size();
		int Expected_TotalGP = 2;
		Assert.assertEquals(Actual_TotalGP, Expected_TotalGP, "Total 2 Groups are Not Displayed");
		System.out.println("Total 2 Groups are Displayed");
		chiledTest.log(Status.INFO, "Total 2 Groups are Displayed");
	}

	public void Verify3GroupsAreDisplayed()
	{
		List<WebElement> TotalGroup = driver.findElements(By.xpath("//div[@class='col-lg-2 col-md-2 col-sm-2 col-xs-2 bhoechie-tab-menu']//div//a"));
		int Actual_TotalGP = TotalGroup.size();
		int Expected_TotalGP = 3;
		Assert.assertEquals(Actual_TotalGP, Expected_TotalGP, "Total 3 Groups are Not Displayed");
		System.out.println("Total 3 Groups are Displayed");
		chiledTest.log(Status.INFO, "Total 3 Groups are Displayed");
	}

	public void Verify1GroupsAreDisplayed()
	{
		List<WebElement> TotalGroup = driver.findElements(By.xpath("//div[@class='col-lg-2 col-md-2 col-sm-2 col-xs-2 bhoechie-tab-menu']//div//a"));
		int Actual_TotalGP = TotalGroup.size();
		int Expected_TotalGP = 1;
		Assert.assertEquals(Actual_TotalGP, Expected_TotalGP, "Total 1 Groups are Not Displayed");
		System.out.println("Total 1 Groups are Displayed");
		chiledTest.log(Status.INFO, "Total 1 Groups are Displayed");
	}

	public void Verify4CPIsDisplayed()
	{
		List<WebElement> TotalCP = driver.findElements(By.xpath("//div[@class='col-lg-5 col-md-5 col-sm-5 col-xs-5 bhoechie-tab bhoechie-tab-menu-1']//div[@class='bhoechie-tab-content active']//a"));
		int Actual_TotalCP = TotalCP.size();
		int Expected_TotalGP = 4;
		Assert.assertEquals(Actual_TotalCP, Expected_TotalGP, "Total 4 CP are Not Displayed");
		System.out.println("Total 4 CP are Displayed");
		chiledTest.log(Status.INFO, "Total 4 CP are Displayed");
	}

	public void Verify5CPIsDisplayed()
	{
		List<WebElement> TotalCP = driver.findElements(By.xpath("//div[@class='col-lg-5 col-md-5 col-sm-5 col-xs-5 bhoechie-tab bhoechie-tab-menu-1']//div[@class='bhoechie-tab-content active']//a"));
		int Actual_TotalCP = TotalCP.size();
		int Expected_TotalGP = 5;
		Assert.assertEquals(Actual_TotalCP, Expected_TotalGP, "Total 5 CP are Not Displayed");
		System.out.println("Total 5 CP are Displayed");
		chiledTest.log(Status.INFO, "Total 5 CP are Displayed");
	}

	public void VerifyDigitalEvidencesAndRemarksAreMandatoryAlertIsDisplayed()
	{
		Alert alert = driver.switchTo().alert();
		String Actual_Text = alert.getText();
		String Expected_Text = "Digital Evidences and Remarks are mandatory.";
		Assert.assertEquals(Actual_Text, Expected_Text, "Message is Wrong");
		System.out.println("Digital Evidences and Remarks are mandatory Alert Pop is Displayed");
		chiledTest.log(Status.INFO, "Digital Evidences and Remarks are mandatory Alert Pop is Displayed");

		//accepting the alert pop up
		alert.accept();
	}
}



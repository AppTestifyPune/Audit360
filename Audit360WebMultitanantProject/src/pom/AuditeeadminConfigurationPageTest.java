package pom;

import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class AuditeeadminConfigurationPageTest extends BaseTest {

	//clicking on the Auditee admin Configure header
	@FindBy(xpath="//a[contains(text(),'AUDITEE ADMIN CONFIGURATION')]")
	private WebElement AuditeeAdminConfigureHeader;

	//clicking on the Select Audit Type
	@FindBy(xpath="//div[@id='s2id_list_auditee_admin_configurations']//span[@class='select2-chosen']")
	private WebElement SelectAuditType;

	//Passing the Values to Select Audit Type
	@FindBy(xpath="//div[@id='select2-drop']//input")
	private WebElement SetAuditType;

	//clicking on the auditee Respondent Work flow not required radio button
	@FindBy(xpath="//label[@for='audit_type_eliminate_respondent_false']/following-sibling::input[@class='eliminate_respondent_workflow']")
	private WebElement RespondentWorkFlowNotReuiredRBTN;

	//clicking on the auditee Reviewer Work flow not required radio button
	@FindBy(xpath="//label[@for='audit_type_eliminate_reviewer_false']/following-sibling::input[@class='eliminate_reviewer_workflow']")
	private WebElement ReviwerWorkFlowNotReuiredRBTN;

	//passing the values to Issue Assignment
	@FindBy(xpath="//div[@id='s2id_audit_type_allocation_assignments']//ul/li/input")
	private WebElement IssueAssignment;

	//passing the values to Respondent to Respond Issue
	@FindBy(xpath="//div[@id='s2id_audit_type_reopen_issue_resulations']//ul/li/input")
	private WebElement RespondIssue;

	//clicking on the Matched text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement MatchedText;

	//clicking on the Save Button
	@FindBy(xpath="//input[@value='Save']")
	private WebElement SaveBTN;

	//clicking on the AUDITEE RESPONDENT WORKFLOW Not Required Radio button
	@FindBy(xpath="//input[@id='audit_type_eliminate_respondent_true']")
	private WebElement AuditeeRespondentWorkFlowNotRequired;

	//clicking on the AUDITEE Reviewer WORKFLOW Not Required Radio button
	@FindBy(xpath="//input[@id='audit_type_eliminate_reviewer_true']")
	private WebElement AuditeeReviewerWorkFlowNotRequired;

	//clicking on the Auditee Level Radio Button
	@FindBy(xpath="//input[@id='audit_type_is_auditee_code_required_true']")
	private WebElement AuditeeLevel;

	@FindBy(xpath="//input[@id='audit_type_issue_allocation_single_time']")
	private WebElement IssueallocationSingletime;
	//input[@id='audit_type_issue_allocation_single_time']

	public AuditeeadminConfigurationPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickAuditeeAdminConfigureHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditeeAdminConfigureHeader);
	}

	public void ClickSelectAuditType()
	{
		SelectAuditType.click();
	}

	public void SetSetAuditType(String SA)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SetAuditType));
		
		SetAuditType.sendKeys(SA);
		System.out.println("Entered Audit Type is : " + SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");
	}

	public void SetIssueAssignment(String IA)
	{
		//selecting the Issue allocation as single time //#SM Added
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		wait.until(ExpectedConditions.visibilityOf(IssueallocationSingletime));
		
		IssueallocationSingletime.click();
       //This is same

		IssueAssignment.sendKeys(IA);
		System.out.println("Entered Issue Assigmnet is : " + IA);
		chiledTest.log(Status.INFO, "Issue assignmnet is Selected");
	}

	public void ClickMatchedText() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(MatchedText));
		
		MatchedText.click();
	}

	public void SetRespondIssue(String RI)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(RespondIssue));
		
		RespondIssue.sendKeys(RI);
		System.out.println("Entered Rspond Issue is : " + RI);
		chiledTest.log(Status.INFO, "Rspond Issue is Selected");
	}

	public void ClickRespondentWorkFlowNotReuiredRadioButton()
	{
		RespondentWorkFlowNotReuiredRBTN.click();
		System.out.println("Respondent Work flow Not Required Radio button is clicked");
		chiledTest.log(Status.INFO, "Respondent Work flow Not Required Radio button is clicked");
	}

	public void ClickReviwerWorkFlowNotReuiredRadioButton()
	{
		ReviwerWorkFlowNotReuiredRBTN.click();
		System.out.println("Reviwer Work flow Not Required Radio button is clicked");
		chiledTest.log(Status.INFO, "Reviwer Work flow Not Required Radio button is clicked");
	}

	public void ClickSaveBTN()
	{
		SaveBTN.click();
		System.out.println("Save Button is Clciked");
		chiledTest.log(Status.INFO, "Save Button is Clciked");
	}

	public void ClickAuditeeRespondentWorkFlowNotRequiredRadioBTN()
	{
		if(AuditeeRespondentWorkFlowNotRequired.isDisplayed()){
			AuditeeRespondentWorkFlowNotRequired.click();
			System.out.println("Auditee Respondent Work Flow Not Required Radio Button is Clicked");
			chiledTest.log(Status.INFO, "Auditee Respondent Work Flow Not Required Radio Button is Clicked");}
	}

	public void ClickAuditeeReviewerWorkFlowNotRequiredRadioBTN()
	{
		if(AuditeeReviewerWorkFlowNotRequired.isDisplayed()){
			AuditeeReviewerWorkFlowNotRequired.click();
			System.out.println("Auditee Reviewer Work Flow Not Required Radio Button is Clicked");
			chiledTest.log(Status.INFO, "Auditee Reviewer Work Flow Not Required Radio Button is Clicked");}
	}

	public void ClickAuditeeLevelRadioBTN()
	{
		if(AuditeeLevel.isDisplayed()){
			AuditeeLevel.click();
			System.out.println("Auditee Level Radio Button is Clicked");
			chiledTest.log(Status.INFO, "Auditee Lavel Radio Button is Clicked");}
	}

	public void VerifyAuditeeConfigurationSuccessfullyDoneMsGIsDisplayed()
	{
		WebElement SuccssMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(SuccssMSG.isDisplayed())
		{
			String Actaul_text = SuccssMSG.getText();
			String Expected_text = "Auditee configuration successfully done";
			Assert.assertEquals(Actaul_text, Expected_text, "Auditee configuration successfully done Message is Not Displayed");
			System.out.println("Auditee configuration successfully done message is Displayed");
			chiledTest.log(Status.INFO, "Auditee configuration successfully done message is Dsiplayed");
		}
	}


	public void VerifyRespondantAndReviewerShouldNotShowUnderIssueAssignment()
	{
		WebElement Respondent = driver.findElement(By.xpath("//select[@id='audit_type_allocation_assignments']/option[@value='4' and @class='hide']"));
		Assert.assertTrue(Respondent.isDisplayed(), "Respondent Is showing under Issue Assignmnet");
		System.out.println("Respondent is Not Showing under Issue Assignment");
		chiledTest.log(Status.INFO, "Respondent is Not Showing under Issue Assignment");

		WebElement Reviewer = driver.findElement(By.xpath("//select[@id='audit_type_allocation_assignments']/option[@value='5' and @class='hide']"));
		Assert.assertTrue(Reviewer.isDisplayed(), "Reviewer Is showing under Issue Assignmnet");
		System.out.println("Reviewer is Not Showing under Issue Assignment");
		chiledTest.log(Status.INFO, "Reviewer is Not Showing under Issue Assignment");

	}

	public void VerifyAuditeeReviewerShouldNotShaowUnderIssueAssignment()
	{
		WebElement Reviewer = driver.findElement(By.xpath("//select[@id='audit_type_allocation_assignments']/option[@value='5' and @class='hide']"));
		Assert.assertTrue(Reviewer.isDisplayed(), "Reviewer Is showing under Issue Assignmnet");
		System.out.println("Reviewer is Not Showing under Issue Assignment");
		chiledTest.log(Status.INFO, "Reviewer is Not Showing under Issue Assignment");
	}

	public void VerifyRespondentShouldNotShaowUnderIssueAssignment()
	{
		WebElement Respondent = driver.findElement(By.xpath("//select[@id='audit_type_allocation_assignments']/option[@value='4' and @class='hide']"));
		Assert.assertTrue(Respondent.isDisplayed(), "Respondent Is showing under Issue Assignmnet");
		System.out.println("Respondent is Not Showing under Issue Assignment");
		chiledTest.log(Status.INFO, "Respondent is Not Showing under Issue Assignment");
	}

	public void VerifySignleTimeRadioButtonIsDisabled()
	{
		//checking the single time radio button is disabled mode
		WebElement SingleTimeRBTN = driver.findElement(By.xpath("//input[@id='audit_type_issue_allocation_single_time' and @disabled='disabled']"));
		Assert.assertTrue(SingleTimeRBTN.isDisplayed(), "Single Time Radio Button is Not disabled");
		System.out.println("Single Time Radio Button is disabled");
		chiledTest.log(Status.INFO, "Single Time Radio Button is disabled");
	}

	public void VerifyEveryTimeRadioButtonIsDisabled()
	{
		WebElement EveryTimeRBTN = driver.findElement(By.xpath("//input[@id='audit_type_issue_allocation_every_time' and @disabled='disabled']"));
		Assert.assertTrue(EveryTimeRBTN.isDisplayed(), "Every Time Radio Button is Not disabled");
		System.out.println("Every Time Radio Button is disabled");
		chiledTest.log(Status.INFO, "Every Time Radio Button is disabled");
	}
	
	public void VerifySubAuditsRadioButtonIsDisabled()
	{
		WebElement SubauditsRBTN = driver.findElement(By.xpath("//input[@value='sub_audit' and @disabled='disabled']"));
		Assert.assertTrue(SubauditsRBTN.isDisplayed(), "Subaudits Radio Button is Not disabled");
		System.out.println("Subaudits Radio Button is disabled");
		chiledTest.log(Status.INFO, "Subaudits Radio Button is disabled");
	}
	
	public void VerifyGroupRadioButtonIsDisabled()
	{
		WebElement GroupRBTN = driver.findElement(By.xpath("//input[@value='group' and @disabled='disabled']"));
		Assert.assertTrue(GroupRBTN.isDisplayed(), "Group Radio Button is Not disabled");
		System.out.println("Group Radio Button is disabled");
		chiledTest.log(Status.INFO, "Group Radio Button is disabled");
	}
	
	public void VerifyCheckPointsRadioButtonIsDisabled()
	{
		WebElement CheckpointRBTN = driver.findElement(By.xpath("//input[@value='check_point' and @disabled='disabled']"));
		Assert.assertTrue(CheckpointRBTN.isDisplayed(), "Checkpoints Radio Button is Not disabled");
		System.out.println("Checkpoints Radio Button is disabled");
		chiledTest.log(Status.INFO, "Checkpoints Radio Button is disabled");
	}
	
	public void VerifyCluesterLevelRadioButtonIsDisabled()
	{
		WebElement ClusterLevelRBTN = driver.findElement(By.xpath("//input[@value='check_point' and @disabled='disabled']"));
		Assert.assertTrue(ClusterLevelRBTN.isDisplayed(), "Cluster Radio Button is Not disabled");
		System.out.println("Cluster Radio Button is disabled");
		chiledTest.log(Status.INFO, "Cluster Radio Button is disabled");
	}
	
	public void VerifyAuditeeLevelradioButtonIsDisabled()
	{
		WebElement AuditeeLevelRBTN = driver.findElement(By.xpath("//input[@value='check_point' and @disabled='disabled']"));
		Assert.assertTrue(AuditeeLevelRBTN.isDisplayed(), "Auditee Level Radio Button is Not disabled");
		System.out.println("Auditee Level Radio Button is disabled");
		chiledTest.log(Status.INFO, "Auditee Level Radio Button is disabled");
	}
	
	public void VerifyIssueallocationIsDisabled()
	{
		WebElement IssuesAllocation = driver.findElement(By.xpath("//select[@id='audit_type_allocation_assignments' and @disabled]"));
		Assert.assertTrue(IssuesAllocation.isDisplayed(), "Issues allocation is Not disabled");
		System.out.println("Issues allocation is disabled");
		chiledTest.log(Status.INFO, "Issues allocation is disabled");
	}
	
	public void VerifyResponseToReopenIssuesIsDisabled()
	{
		WebElement ResponseToReassign = driver.findElement(By.xpath("//select[@id='audit_type_reopen_issue_resulations' and @disabled]"));
		Assert.assertTrue(ResponseToReassign.isDisplayed(), "Response to Reopen issue is Not disabled");
		System.out.println("Response to Reopen issue is disabled");
		chiledTest.log(Status.INFO, "Response to Reopen issue is disabled");
	}
}



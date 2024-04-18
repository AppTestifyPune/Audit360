package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sqlite.Function;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class ConfigureAuditPageTest extends BaseTest {

	//Clicking on the scroll bar
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Configure Audit from side menu //ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Configure Audit']
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Configure Audit']")
	private WebElement ConfigureAudit;

	//Clicking on the Configure audit Sub Menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[contains(text(),'Configure Audit')]")
	private WebElement CA;

	//clicking on the Audit Type Header page
	@FindBy(xpath="//a[text()='AUDIT TYPE']")
	private WebElement AuditType;

	//Passing the values to Search Button
	@FindBy(xpath="//div[@id='tableAuditTypes_filter']//input[@type='search']")
	private WebElement SearchBTN;

	//Passing the Values to Define Tab Seach Text file
	@FindBy(xpath="//div[@id='tableWithSearchInner_filter']//input")
	private WebElement DefineTabSearchBTN;

	//Passing the Values to Search Text Filed under User Manage management Screen
	@FindBy(xpath="//div[@id='RolestableWithSearch_filter']//input[@class='form-control']")
	private WebElement SearchBTN1;

	//Clicking on the CreateAuditType Button
	@FindBy(xpath="//button[@id='createAuditType']")
	private WebElement CreateAuditTypeBTN;

	//Passing the Values to Audit Type Name
	@FindBy(xpath="//input[@id='audit_type_name']")
	private WebElement AuditTypeName;

	//Passing the Values to Select Audit Type
	@FindBy(xpath="//div[@id='s2id_auditee_types_']/ul/li/input")
	private WebElement SelectAuditType;

	//Passing the Values to Select Sub Audit Types
	@FindBy(xpath="//div[@id='s2id_main_audit_type_ids_']/ul/li/input")
	private WebElement SelectSubAuditType; 

	//Clicking on the Matching
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Match;

	//clicking on the Next Button///
	@FindBy(xpath="//div[@class='tab-pane active']//button[@type='button'][contains(text(),'Next')]")
	private WebElement NextBTN;

	//clicking on the Begin Tab Next Button
	@FindBy(xpath="//div[@id='step1']//button[@class='btn btn-complete step'][contains(text(),'Next')]")
	private WebElement BeginTabNextBTN;

	//Clicking on the Define Tab Next Button//button[@class='btn btn-complete step main-audit-continue']
	@FindBy(xpath="//button[@class='btn btn-complete step main-audit-continue seqs_submit']")
	private WebElement DefineTabNextBTN;

	//Clicking on the Evaluate Tab Next Button
	@FindBy(xpath="//div[@id='step3']//button[@class='btn btn-complete step'][contains(text(),'Next')]")
	private WebElement EvaluateTabNextBTN;

	//Clicking on the Manage Role Tab Next Button
	@FindBy(xpath="//div[@class='panel-body no-padding']//button[@class='btn btn-complete step calculate_total_score'][contains(text(),'Next')]")
	private WebElement MangeRoleTabNextBTN;

	//clicking on the Configure Next Button//div[@id='step5']//button[@class='btn btn-complete step calculate_total_score'][contains(text(),'Next')]
	@FindBy(xpath="//button[@href='#step6']")
	private WebElement ConfigureTabNextBTN;

	//Clicking on the Back Button
	@FindBy(xpath="//div[@class='tab-pane active']//button[@type='button'][contains(text(),'Back')]")
	private WebElement BackBTN;

	//clicking on the Submit Button
	@FindBy(xpath="//div[@class='tab-pane active']//button[@name='button'][contains(text(),'Submit')]")
	private WebElement SubmitBTN;

	//clicking on the Select Group type
	@FindBy(xpath="//div[@id='s2id_group_type']/a/span[text()='Please Select']")
	private WebElement SelectGrouptype;

	//Passing the Values to Select Group Type
	@FindBy(xpath="//div[@id='select2-drop']/div/input[@type='text']")
	private WebElement SetSelectGroupType;

	//Passing the Values to Select CheckPoint Group
	@FindBy(xpath="//div[@id='s2id_groups_']//input")
	private WebElement SelectCheckPointGroup;

	//Passing the Values to Select Sub Audit Type
	@FindBy(xpath="//div[@id='s2id_main_audit_type_ids_']/ul/li/input[@type='text']")
	private WebElement SelectSubAudittype;

	//Clicking on the Parent Audit Type radio Button
	@FindBy(xpath="//label[@for='audit_type_parent_audit_type']")
	private WebElement ParentTypeAuditRadioBTN;

	//Clicking on the Sub Audit Type radio Button
	@FindBy(xpath="//label[@for='type_sub_audit_type']")
	private WebElement SubAuditTypeRadioBTN;

	//Clicking on the Group radio Button
	@FindBy(xpath="//label[@for='type_group']")
	private WebElement GroupRadioBTN;

	//Passing the Values to Low Risk Scoring
	@FindBy(xpath="//input[@id='audit_type_risk_scoring_attributes_low']")
	private WebElement LowRiskScoring;

	//Passing the Values to Meadium Risk Scroing
	@FindBy(xpath="//input[@id='audit_type_risk_scoring_attributes_medium']")
	private WebElement MeadiumRiskScroring;

	//Passing the Values to High Risk Scoring
	@FindBy(xpath="//input[@id='audit_type_risk_scoring_attributes_high']")
	private WebElement HighRiskScoring;

	//Passing the Values to Zero talerance Risk Scoring
	@FindBy(xpath="//input[@id='audit_type_risk_scoring_attributes_zero_tolerance']")
	private WebElement ZeroTaleranceRiskScoring;

	//Clicking on the Step 4 Back Button
	@FindBy(xpath="//button[@class='btn btn-danger step_back'][@href='#step4']")
	private WebElement Step4BackBTN;

	//Passing the Values to Manage Role search Text Box
	@FindBy(xpath="//div[@id='RolestableWithSearch_filter']//input[@type='search']")
	private WebElement ManageRoleSerachBTN;

	//Clicking on the Select Role
	@FindBy(xpath="//div[@id='s2id_role']/a/span[text()='Select Role']")
	private WebElement SelectRole;

	//Passing the Values to Select Role
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//input[@type='text']")
	private WebElement SetSelectRole;

	//Clicking on the Select All
	@FindBy(xpath="//label[@for='checkall']")
	private WebElement SelectAll;

	//Clicking on the Eliminate auditee signoff Check Box
	@FindBy(xpath="//input[@id='audit_type_eleminate_auditee_signoff']/following-sibling::span")
	private WebElement EliminateAuditeeSignOffToggleBTN;

	//Clicking on the Provisional submission toggle button
	@FindBy(xpath="//input[@id='audit_type_is_provisional_submission']/following-sibling::span")
	private WebElement ProvisionalSubmissionToggleBTN;

	//Clicking on the Annexure score Check Box
	@FindBy(xpath="//input[@id='audit_type_annexure_score']/following-sibling::span")
	private WebElement AnnexureScoreToggleBTN;

	//Clicking on the Annexure sampling
	@FindBy(xpath="//input[@id='audit_type_annexure_sampling']/following-sibling::span")
	private WebElement AnnexureSamplingToggleBTN;

	//Clicking on the Do you need to finalize audits in bulk ?
	@FindBy(xpath="//input[@id='audit_type_multi_select_bulk_finalize']/following-sibling::span")
	private WebElement BulkFinalizeToggleBTN;

	//Clicking on the Should digital evidence be mandatory for main audit ?
	@FindBy(xpath="//input[@id='audit_type_capture_image']/following-sibling::span")
	private WebElement DigitalEvidenceMandatoryToggleBTN;

	//Clicking on the Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed 
	@FindBy(xpath="//input[@id='audit_type_is_auditor_remarks_require']/following-sibling::span")
	private WebElement AuditorRemarksToogleBTN;

	//Clicking on the Additional Informations Toggle Button 
	@FindBy(xpath="//input[@id='audit_type_is_additional_info']/following-sibling::span")
	private WebElement AdditionalInfoToggleBTN;

	//clicking on the Do you want to allow auditee side user(auditee, respondent, reviewer) to change the issue due date? Toggle Button
	@FindBy(xpath="//input[@id='audit_type_is_change_due_date']/following-sibling::span")
	private WebElement IssueDuedateToggleBTN;

	//clicking on the Do you wish to add selfie? Toogle Button
	@FindBy(xpath="//input[@id='audit_type_is_selfie']/following-sibling::span")
	private WebElement AddSelfieToggleBTN;

	//clicking on the Do you wish to add digital signatures? Toogle Button
	@FindBy(xpath="//input[@id='audit_type_is_digital_signature']/following-sibling::span")
	private WebElement DigitalSignaturesToggleBTN;

	//clicking on the Do you wish to enable deemed sign off for this audit? Toogle Button
	@FindBy(xpath="//input[@id='audit_type_auto_auditee_signoff']/following-sibling::span")
	private WebElement DeemedAuditeeSifnOffToggleBTN;

	//clicking on the Allow multiple level review Toogle Button
	@FindBy(xpath="//input[@id='audit_type_is_multiple_review_required']/following-sibling::span")
	private WebElement AllowMultiplelevelReviewToggleBTN;

	//clicking on the Do you want to enable issue significance configuration for this audit type? Toggle button
	@FindBy(xpath="//input[@id='audit_type_issue_mapping_toggle']/following-sibling::span")
	private WebElement IssueSignificanceToggleBTN;

	//clicking on the Issue Signification Mapping
	@FindBy(xpath="//input[@id='audit_type_is_issue_significance_required']")
	private WebElement IssueSignificationMapping;

	//clicking on the Do you need spot resolution to be updated by auditor? Toggle button
	@FindBy(xpath="//input[@id='audit_type_spot_resolution_opted']/following-sibling::span")
	private WebElement SpotResolutionToggleBTN;

	//clicking on the Do you want to allow auditee for direct resolution? Toggle button
	@FindBy(xpath="//input[@id='audit_type_direct_resolution']/following-sibling::span")
	private WebElement DirectResolutionToggleBTN;

	//clicking on the Do you want to show all checkpoints to auditee during signoff? Toggle button
	@FindBy(xpath="//input[@id='show_all_cp_for_auditee_signoff']/following-sibling::span")
	private WebElement ShowAllCPToAuditeeDuringSignoffToggleBTN;

	//clicking on the Do you want to allow checkpoint group to be skipped during audit execution for this audit? Toggle button
	@FindBy(xpath="//input[@id='audit_type_is_group_level_skip']/following-sibling::span")
	private WebElement TagNAToggleBTN;

	//Clicking on the Select Verifier
	@FindBy(xpath="//div[@id='s2id_audit_type_issue_configuration_attributes_verifier']/a//span[@class='select2-arrow']")
	private WebElement SelectVerifier;

	//Passing the Values to Select Verifier
	@FindBy(xpath="//div[@id='select2-drop']/div[contains(@class,'select2-search')]/input[@type='text']")
	private WebElement SetSelectVerifier;

	//Clicking on the Select TAT Type
	@FindBy(xpath="//div[@id='s2id_audit_type_issue_configuration_attributes_tat_type']/a")
	private WebElement SelectTATType;

	//Passing the Values to Select TAT Type
	@FindBy(xpath="//div[@id='select2-drop']/div[contains(@class,'select2-search')]/input[@type='text']")
	private WebElement SetSelectTATType;

	//Passing the Values to Low Due Days
	@FindBy(xpath="//input[@id='audit_type_issue_configuration_attributes_low_risk_date']")
	private WebElement LowDueDays;

	//Passing the Values to Medium Due Days
	@FindBy(xpath="//input[@id='audit_type_issue_configuration_attributes_medium_risk_date']")
	private WebElement MediumDueDays;

	//Passing the Values to high Due Days
	@FindBy(xpath="//input[@id='audit_type_issue_configuration_attributes_high_risk_date']")
	private WebElement HighDueDays;

	//Passing the Values to Zero Tolerance Due Days
	@FindBy(xpath="//input[@id='audit_type_issue_configuration_attributes_zero_tolerance_risk_date']")
	private WebElement ZTDueDays;

	//Passing the Values to Remainders
	@FindBy(xpath="//div[@id='s2id_reminders_']//li/input[@type='text']")
	private WebElement Remainders;

	//clicking on the Email Preferences
	@FindBy(xpath="//div[@id='s2id_audit_type_email_preference_id']/a/span[@class='select2-chosen']")////div[@id='s2id_audit_type_email_preference_id']/a/span[text()='Please Select']
	private WebElement EmailPreference;

	//Clicking on the Frequency
	@FindBy(xpath="//div[@id='s2id_audit_type_frequency']/a/span[text()='Please Select']")
	private WebElement Frequency;

	//Passing the Values to Frequency
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetFrequency;

	//Passing the Values to Email Preference
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetEmailPreference;

	//Clicking on the Check Box
	@FindBy(xpath="//table[@id='RolestableWithSearch']/tbody/tr[1]/td[4]/div//label")
	private WebElement CheckBox;

	//Clicking on the 1st Audit type
	@FindBy(xpath="//table[@id='tableAuditTypes']/tbody/tr[1]")
	private WebElement FirstAuditType;

	//Clicking on the save Button
	@FindBy(xpath="//input[@id='edit_audit_type']")
	private WebElement SaveBTN;

	//Clicking on the Add Row//a[@class='btn btn-rounded btn-primary pull-right m-b-20 add_nested_fields']/i
	@FindBy(xpath="//a[contains(text(),'Add Row')]")
	private WebElement AddRowBTN;

	//Passing the Values to First TO
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[1]/td[2]/input")
	private WebElement FirstTo;

	//Passing the Values to First From
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[2]/td[2]/input")
	private WebElement SecondTo;

	//Passing the Values to First From
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[3]/td[2]/input")
	private WebElement ThridTo;

	//Passing the Values to First From
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[4]/td[2]/input")
	private WebElement FourthTo;

	//Passing the Values to First Out Come
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[1]/td[3]/textarea")
	private WebElement FirstOutCome;

	//Passing the Values to Second Out Come
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[2]/td[3]/textarea")
	private WebElement secondOutCome;

	//Passing the Values to Third Out Come
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[3]/td[3]/textarea")
	private WebElement ThirdOutCome;

	//Passing the Values to Fourth Out Come
	@FindBy(xpath="//table[@id='condensedTable']/tbody/tr[4]/td[3]/textarea")
	private WebElement FourthOutCome;

	//Selecting Last Option Under show 
	@FindBy(xpath="//select[@name='tableWithSearchInner_length']/option[last()]")
	private WebElement LastOption;

	//Clicking on the Go Button
	@FindBy(xpath="//button[contains(text(),'Go')]")
	private WebElement GoBTN;

	//Clicking on the Actual score slab Radio Buttons
	@FindBy(xpath="//div[@class='col-md-12 radio']/label[@class='rating_slab_radio actual_label']")
	private WebElement ActualScoreslabRadioBTN;

	//Clicking on the Percentage based slab Radio Buttons
	@FindBy(xpath="//label[@class='rating_slab_radio actual_label']//span[@class='radiomark']")
	private WebElement PercentageBasedScoreslabRadioBTN;

	//Clicking on the Ok Button
	@FindBy(xpath="//a[contains(text(),'OK')]")
	private WebElement OKBTN;

	//Passing the Values to Exceptional Max Deduction
	@FindBy(xpath="//input[@id='audit_type_negative_max_score']")
	private WebElement MaxDeduction;

	//clicking on the Surprise Audit radio button
	@FindBy(xpath="//label[text()='Surprise Audit']")
	private WebElement SurpriseAuditRadioBTN;

	//clicking on the Informed Audit radio button
	@FindBy(xpath="//label[text()='Informed Audit']")
	private WebElement InformedAuditRadioBTN;

	//clicking on the Multiple level Review Add button
	@FindBy(xpath="//a[@id='audit_type_review_level_add_more']")
	private WebElement MultipleLevelAddBTN;

	//Passing the Values to 1st CP Sequence 
	@FindBy(xpath="//table[@id='tableWithSearchInner']//tbody/tr[1]/td//input[@type='number']")
	private WebElement FirstCPSeq;

	//clicking on the Objective Radio Button
	@FindBy(xpath="//label[contains(text(),'Objective')]")
	private WebElement ObjectiveRadioBTN;

	//clicking on the Subjective Radio Button
	@FindBy(xpath="//label[contains(text(),'Subjective')]")
	private WebElement SubjectiveRadioBTN;

	//clicking on the Subjective Pop up OK button
	@FindBy(xpath="//button[text()='Ok']")
	private WebElement SubjectivePopUpOKBTN;

	//clicking on the Subjective Pop up Cancel button
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement SubjectivePopUpCancelBTN;

	//passing the values to issue significance
	@FindBy(xpath="//div[@class='issue_significance_area']//div[@class='bootstrap-tagsinput']//input")
	private WebElement DefineDataLeveles;

	//Clicking on the Spot Resolution By head of audit Radio Button
	@FindBy(xpath="//input[@id='audit_type_spot_resolution_scorer_super_admin']")
	private WebElement SpotHeadOfAuditRBTN;

	//Clicking on the Spot Resolution By Auditor During Execution Radio Button
	@FindBy(xpath="//input[@id='audit_type_spot_resolution_scorer_auditor']")
	private WebElement SpotAuditorDuringExecutionRBTN;

	//Clicking on the Spot Resolution By Reviewer/Verifier Radio Button
	@FindBy(xpath="//input[@id='audit_type_spot_resolution_scorer_reviewer']")
	private WebElement SpotByReviewerRBTN;

	//passing the values to enter score for Spot Resolution
	@FindBy(xpath="//input[@id='audit_type_spot_resolution_score']")
	private WebElement ScoreForSpotResolution;

	//Clicking on the Direct Resolution By head of audit Radio Button
	@FindBy(xpath="//input[@id='audit_type_direct_resolution_scorer_super_admin']")
	private WebElement DirectHeadOfAuditRBTN;

	//passing the values to enter score for Direct Resolution
	@FindBy(xpath="//input[@id='audit_type_direct_resolution_score']")
	private WebElement ScoreForDirectResolution;

	//Clicking on the Direct Resolution By Reviewer/Verifier Radio Button
	@FindBy(xpath="//input[@id='audit_type_direct_resolution_scorer_auditee_reviewer']")
	private WebElement DirectByReviewerRBTN;

	public WebElement clickonauditeetypefield(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("(//li[@class='select2-search-field'])[1]"));
		return element;
	}
	
	public WebElement set_issuesignificance_mappdata(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("(//input[@onkeypress='return blockSpecialChar(event)'])[1]"));
		return element;
	}

	public ConfigureAuditPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void ClickScrollBar(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ScrollBar));
		
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickConfigureAudit(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ConfigureAudit));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ConfigureAudit);
	}

	public void ClickConfigureAuditSubMenu() 
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(CA));
		
		CA.click();
		System.out.println("Configure audit Sub Menu is clicked");
	}


	public void SetSearchBTN(String SB)
	{
		SearchBTN.clear();
		SearchBTN.sendKeys(SB);
		System.out.println("Searched Audit Type is : " + SB);
	}

	public void SetDefineTabSearchBTN(String SB) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			DefineTabSearchBTN.clear();
			DefineTabSearchBTN.sendKeys(SB);
			System.out.println("Searched Checkpoint is : " + SB);
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}

	}

	public void ClickObjectiveRadioBTN()
	{
		ObjectiveRadioBTN.click();
		System.out.println("Objective Radio button is clicked");
		chiledTest.log(Status.INFO, "Objective Radio button is clicked");
	}

	public void ClickSubjectiveRadioBTN()
	{
		SubjectiveRadioBTN.click();
		System.out.println("Subjective Radio button is clicked");
		chiledTest.log(Status.INFO, "Subjective Radio button is clicked");
	}

	public void ClickSubjectivePopUpOKBTN()
	{
		SubjectivePopUpOKBTN.click();
		System.out.println("OK button is clicked");
		chiledTest.log(Status.INFO, "Ok button is clicked");
	}

	public void ClickSubjectivePopUpCancelBTN()
	{
		SubjectivePopUpCancelBTN.click();
		System.out.println("CAncel button is clicked");
		chiledTest.log(Status.INFO, "Cancel button is clicked");
	}

	public void ClickIssueSignificanceMapping()
	{
		IssueSignificationMapping.click();
		System.out.println("Issue Signification Mapping is clicked");
		chiledTest.log(Status.INFO, "Issue Signification Mapping is clicked");
	}

	public void SetIssueSignificanceMappingData(String SS)
	{
		//###SM modified
		try
		{
		DefineDataLeveles.sendKeys(SS); //old
		}catch(Exception e)
		{}
		try
		{
		set_issuesignificance_mappdata(driver).sendKeys(SS); //new
		}catch(Exception e)
		{}
		System.out.println("Entered Issues Significance is : " + SS);
		chiledTest.log(Status.INFO, "Issues Significance is Entered");
	}

	public void VerifySubjectivePopUpIsDisplayed()
	{
		WebElement SubJectivePopUpMSG = driver.findElement(By.xpath("//div[@id='subjective_msg']//p"));
		String Actaul_SubJectivePopUpMSG = SubJectivePopUpMSG.getText();
		String Expected_SubJectivePopUpMSG = "Scoring and Rating can be simulated by the reviewer, before finalization. Not recommended, as this can lead to subjectivity. To be used with sufficient caution.";
		Assert.assertEquals(Actaul_SubJectivePopUpMSG, Expected_SubJectivePopUpMSG, "Scoring and Rating can be simulated by the reviewer, before finalization. Not recommended, as this can lead to subjectivity. To be used with sufficient caution. Message is Not Displayed");
		System.out.println("Scoring and Rating can be simulated by the reviewer, before finalization. Not recommended, as this can lead to subjectivity. To be used with sufficient caution. Message is Displayed");
		chiledTest.log(Status.INFO, "Scoring and Rating can be simulated by the reviewer, before finalization. Not recommended, as this can lead to subjectivity. To be used with sufficient caution. Message is Displayed");

	}

	public void SetSearchBTN1(String SB, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SearchBTN1)).clear();

		SearchBTN1.sendKeys(SB);
		System.out.println("Searched User is : " + SB);
	}

	public void ClickCreateAuditTypeBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(CreateAuditTypeBTN)).click();
	}

	public void SetSelectAuditType(String SAT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SelectAuditType)).sendKeys(SAT);
		System.out.println("Selected Audit Type is : " + SAT);
	}


	public void SetAuditTypeName(String ATN, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(AuditTypeName)).sendKeys(ATN);
		System.out.println("Entered Audit Type Name is : " + ATN);
	}

	public void ClickMatch() throws InterruptedException
	{	// Modify sm
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		try
		{   wait.until(ExpectedConditions.visibilityOf(clickonauditeetypefield(driver)));
			clickonauditeetypefield(driver).click();
		}catch(Exception e)
		{}
		// Modify sm
		
		wait.until(ExpectedConditions.visibilityOf(Match));
		Match.click();	
	}

	public void SetSelectRole(String SSR)
	{
		try{
			SetSelectRole.sendKeys(SSR);
			System.out.println("Selected Role is : " + SSR);
		}catch (StaleElementReferenceException e) {
		}

	}

	public void ClickBeginTabNextButton() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(BeginTabNextBTN)).click();
		System.out.println("Next Button is Clicked");
	}

	public void ClickDefineTabNextButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DefineTabNextBTN);
		System.out.println("Next Button is Clicked");
	}

	public void ClickEvaluteTabNextButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EvaluateTabNextBTN);
		System.out.println("Next Button is Clicked");
	}

	public void ClickMangeRoleTabNextButton()
	{
		MangeRoleTabNextBTN.click();
	}

	public void ClickConfigureTabNextButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ConfigureTabNextBTN);
		System.out.println("Next Button is Clicked");
	}

	public void ClickBackBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tab-pane active']//button[@type='button'][contains(text(),'Back')]")));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", BackBTN);
	}

	public void ClickAuditTypeHeader(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditType);
		System.out.println("Audit Type Header is Clicked");
		chiledTest.log(Status.INFO, "Audit Type Header is Clicked");
	}


	public void ClickSubmitBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(SubmitBTN)).click();
		System.out.println("Submit Button is Clicked");
	}

	public void ClickSelectGrouptype(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(SelectGrouptype)).click();
	}

	public void SetSelectGrouptype(String SGT)
	{
		SetSelectGroupType.sendKeys(SGT);
		System.out.println("Selected Group Type is : " + SGT);
	}

	public void SetSelectCheckPointGroup(String SCG, WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(SelectCheckPointGroup)).sendKeys(SCG);
			System.out.println("Entered Select CheckPoint Group is : " + SCG);	
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClearSelectCheckpointGroup()
	{
		List<WebElement> ClearBTN = driver.findElements(By.xpath("//div[@id='s2id_groups_']//a[@class='select2-search-choice-close']"));
		for(int i=0; i<ClearBTN.size(); i++)
		{
			WebElement BTN = ClearBTN.get(i);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", BTN);
		}
	}

	public void SetSelectSubAudittype(String SA, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SelectSubAudittype)).sendKeys(SA);
		System.out.println("Selected Audit Type is : " + SA);
	}

	public void ClickParentTypeAuditRadioBTN(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(ParentTypeAuditRadioBTN)).isDisplayed())
		{
			ParentTypeAuditRadioBTN.click();
			System.out.println("Parent Audit Type Radio Button is Clicked");
		}

	}

	public void ClickSubAuditTypeRadioBTN()
	{
		SubAuditTypeRadioBTN.click();
		System.out.println("Sub Audit Type Radio Button is Selected");
	}

	public void ClickGroupRadioBTN()
	{
		GroupRadioBTN.click();
		System.out.println("Group Radio Button is Selected");
	}


	public void SetLowRiskScoring(String LR)
	{
		LowRiskScoring.clear();
		LowRiskScoring.sendKeys(LR);
		System.out.println("Entered Low Risk Scroing is : " + LR);
	}

	public void SetMeadiumRiskScroring(String MR)
	{
		MeadiumRiskScroring.clear();
		MeadiumRiskScroring.sendKeys(MR);
		System.out.println("Entered Meadium Risk Scroing is : " + MR);
	}

	public void SetHighRiskScoring(String MR)
	{
		HighRiskScoring.clear();
		HighRiskScoring.sendKeys(MR);
		System.out.println("Entered High Risk Scroing is : " + MR);
	}

	public void SetZeroTaleranceRiskScoring(String ZR)
	{
		ZeroTaleranceRiskScoring.clear();
		ZeroTaleranceRiskScoring.sendKeys(ZR);
		System.out.println("Entered Zero Talerance Risk Scroing is : " + ZR);
	}


	public void ClickStep4BackBTN(WebDriver driver)
	{
		Step4BackBTN.click();
	}

	public void SetManageRoleSerachBTN(String MS)
	{
		ManageRoleSerachBTN.sendKeys(MS);
		System.out.println("Entered Role is : " + MS);
	}

	public void ClickSelectRole(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(SelectRole)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickSelectAll(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SelectAll));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SelectAll);
	}

	public void ClickEliminateAuditeeSignoffTaggleBTN()
	{
		EliminateAuditeeSignOffToggleBTN.click();
		System.out.println("Do you need to eliminate auditee sign off ? Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Do you need to eliminate auditee sign off ? Toggle Button is enabled");
	}

	public void ClickProvisionalSubmissionToggleBTN() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ProvisionalSubmissionToggleBTN);
		//ProvisionalSubmissionToggleBTN.click();
		System.out.println("Do you want to allocate provissional submission (this allows the reviewer to parallelly review and submit the audit) Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Do you want to allocate provissional submission (this allows the reviewer to parallelly review and submit the audit) Toggle Button is enabled");
	}

	public void ClickAnnexureScoreTaggleBTN()
	{
		AnnexureScoreToggleBTN.click();
		System.out.println("Do you need annexure score ? Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Do you need annexure score ? Toggle Button is enabled");
	}

	public void ClickAnnexureSamplingTaggleBTN()
	{
		AnnexureSamplingToggleBTN.click();
		System.out.println("Do you need annexure sampling ? Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Do you need annexure sampling ? Toggle Button is enabled");
	}

	public void ClickBulkFinalizeTaggleBTN()
	{
		BulkFinalizeToggleBTN.click();
		System.out.println("Do you need to finalize audits in bulk ? Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Do you need to finalize audits in bulk ? Toggle Button is enabled");
	}

	public void ClickImageMandatoryTaggleBTN() // CTRL-5745 Changes
	{
		/*DigitalEvidenceMandatoryToggleBTN.click();
		System.out.println("Should capturing image be mandatory for main audit ? Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Should capturing image be mandatory for main audit ? Toggle Button is enabled");*/
	}

	public void ClickAuditorRemarksTaggleBTN()
	{
		AuditorRemarksToogleBTN.click();
		System.out.println("Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed Toggle Button is enabled");	
	}

	public void ClickAddSelfieTaggleBTN()
	{
		AddSelfieToggleBTN.click();
		System.out.println("Do you wish to add selfie? Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Do you wish to add selfie? Toggle Button is enabled Toggle Button is Clicked");
	}

	public void ClickAddDigitalSignatureTaggleBTN()
	{
		DigitalSignaturesToggleBTN.click();
		System.out.println("Do you wish to add digital signatures? Toggle Button is enabled");
		chiledTest.log(Status.INFO, "Do you wish to add digital signatures? Toggle Button is Clicked");
	}

	/*public void ClickAdditionalInfoToggleBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(AdditionalInfoToggleBTN)).click();
		System.out.println("Do you wish to add additional information at checkpoint level? Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Do you wish to add additional information at checkpoint level? Toggle Button is Clicked");
	}*/


	public void ClickAllowMultiLevelReviewToggleBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(AllowMultiplelevelReviewToggleBTN)).click();
		System.out.println("Allow multiple level review Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Allow multiple level review Toggle Button is Clicked");
	}

	public void ClickDoYouWantToEnableIssueMappingConfigurationForThisAudittypeToggleBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(IssueSignificanceToggleBTN)).click();
		System.out.println("Do you want to enable issue mapping configuration for this audit type? Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Do you want to enable issue mapping configuration for this audit type? Toggle Button is Clicked");
	}

	public void ClickSpotResultionToggleBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SpotResolutionToggleBTN)).click();
		System.out.println("Spot Resultions Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Spot Resultions Toggle Button is Clicked");
	}

	public void ClickDirectResultionToggleBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(DirectResolutionToggleBTN)).click();
		System.out.println("Direct Resultions Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Direct Resultions Toggle Button is Clicked");
	}


	public void ClickDoYouWantToShowAllCPToAuditeeDuringSignoffToggleBTNToggleBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(ShowAllCPToAuditeeDuringSignoffToggleBTN)).click();
		System.out.println("Do you want to show all checkpoints to auditee during signoff? Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Do you want to show all checkpoints to auditee during signoff? Toggle Button is Clicked");
	}
	
	public void ClickTagNAToggleBTNToggleBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(TagNAToggleBTN)).click();
		System.out.println("Do you want to allow checkpoint group to be skipped during audit execution for this audit? Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Do you want to allow checkpoint group to be skipped during audit execution for this audit? Toggle Button is Clicked");
	}

	public void ClickMultipleLevelAddBTN()
	{
		MultipleLevelAddBTN.click();
		System.out.println("Add button is Clicked");
		chiledTest.log(Status.INFO, "Add button is Clicked");
	}

	public void clickSelectVerifier()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", SelectVerifier);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SelectVerifier)).click();

	}

	public void SetSelectVerifier(String SV)
	{
		SetSelectVerifier.sendKeys(SV);
		System.out.println("Selected Verifier is : " + SV);
	}

	public void ClickSelectTATType()
	{
		SelectTATType.click();
	}

	public void SetSelectTATType(String ST)
	{
		SetSelectTATType.sendKeys(ST);
		System.out.println("Selected TAT Type is : " + ST);
	}

	public void SetLowDueDays(String SL)
	{
		LowDueDays.clear();
		LowDueDays.sendKeys(SL);
		System.out.println("Entered Low Due Date is : " + SL);
	}

	public void SetMediumDueDays(String SM)
	{
		MediumDueDays.clear();
		MediumDueDays.sendKeys(SM);
		System.out.println("Entered Medium Due Days is : " + SM);
	}

	public void SetHighDueDays(String SH)
	{
		HighDueDays.clear();
		HighDueDays.sendKeys(SH);
		System.out.println("Entered High Due Days is : " + SH);
	}

	public void SetZTDueDays(String SZ)
	{
		ZTDueDays.clear();
		ZTDueDays.sendKeys(SZ);
		System.out.println("Entered ZT Due Days is : " + SZ);
	}

	public void SetRemainders(String SR)
	{
		Remainders.sendKeys(SR);
		System.out.println("Selected Remainders is : " + SR);
	}

	public void ClickEmailPreference()
	{
		EmailPreference.click();
	}

	public void ClickFrequency(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Frequency));
		Actions action = new Actions(driver);	
		action.moveToElement(Frequency).click().build().perform();
		System.out.println("Frequency is Clikced");
	}

	public void SetFrequency(String SF)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SetFrequency)).sendKeys(SF);
		System.out.println("Selected Frequency is : " + SF);
	}


	public void SetEmailPreference(String EP)
	{
		SetEmailPreference.sendKeys(EP);
		System.out.println("Entered Email Preference is : " + EP);
	}

	public void ClickCheckBox(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CheckBox);

	}

	public void ClickFirstAuditType(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(FirstAuditType)).click();

	}

	public void ClickSaveBTN()
	{
		SaveBTN.click();
	}

	public void ClickAddRow(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddRowBTN);
		System.out.println("Add Row Button is Clicked");
	}

	public void SetShowAndRow(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(LastOption)).click();
	}

	public void ClickGoBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(GoBTN)).click();
		System.out.println("Go Button is Clicked");
	}

	public void ClickOKBTN()
	{
		OKBTN.click();
		System.out.println("Ok Button is Clicked");
		chiledTest.log(Status.INFO, "OK Button is Clicked");
	}

	public void ClickActualScoreSlabRadioBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ActualScoreslabRadioBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ActualScoreslabRadioBTN);
		System.out.println("Actual Score Slab Radio Button is Clicked");
	}

	public void ClickPercentageBasedScoreSlabRadioBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(PercentageBasedScoreslabRadioBTN)).click();
		System.out.println("Percentage Based Score Slab Radio Button is Clicked");
	}

	public void VerifyActualScoreSlabRadioButtonIsDisabled()
	{
		WebElement ActualScoreSlabRadioBTN = driver.findElement(By.xpath("//input[@id='audit_type_rating_slab_fixed_slab']"));
		Assert.assertFalse(ActualScoreSlabRadioBTN.isEnabled(), "Actual Score Slab Radio Button is not in Read only Mode");
		System.out.println("Pass : Actual Score Slab Radio Button is Disabled");
		chiledTest.log(Status.INFO, "Pass : Actual Score Slab Radio Button is Disabled");
	}

	public void VerifyPercentageBasedSlabRadioButtonIsEnabled()
	{
		WebElement ActualScoreSlabRadioBTN = driver.findElement(By.xpath("//input[@id='audit_type_rating_slab_percentage_slab']"));
		Assert.assertTrue(ActualScoreSlabRadioBTN.isEnabled(), "Percentage Based Slab Radio Button is not in Read only Mode");
		System.out.println("Pass : Percentage Based Score Slab Radio Button is Enabled");
		chiledTest.log(Status.INFO, "Pass : Percentage Based Score Slab Radio Button is Enabled");

	}

	public void ClearTO()
	{
		FirstTo.clear();
	}


	public void SetFirstTo(String FT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstTo)).clear();
		wait.until(ExpectedConditions.visibilityOf(FirstTo)).sendKeys(FT);
		System.out.println("Entered From is : " + FT);

	}

	public void SetSecondTo(String ST, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SecondTo)).clear();
		wait.until(ExpectedConditions.visibilityOf(SecondTo)).sendKeys(ST);
		System.out.println("Entered From is : " + ST);

	}

	public void SetThirdTo(String TT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ThridTo)).clear();
		wait.until(ExpectedConditions.visibilityOf(ThridTo)).sendKeys(TT);
		System.out.println("Entered From is : " + TT);

	}

	public void SetFourthTo(String FT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FourthTo)).clear();
		wait.until(ExpectedConditions.visibilityOf(FourthTo)).sendKeys(FT);
		System.out.println("Entered From is : " + FT);
	}


	public void SetFirstOutCome(String FO, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstOutCome)).sendKeys(FO);
		System.out.println("Entered Out Come is : " + FO);

	}

	public void SetSecondOutCome(String SO, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(secondOutCome)).sendKeys(SO);
		System.out.println("Entered Out Come is : " + SO);

	}

	public void SetThirdOutCome(String TO, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ThirdOutCome)).sendKeys(TO);
		System.out.println("Entered Out Come is : " + TO);
	}

	public void SetFourthOutCome(String FO, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FourthOutCome)).sendKeys(FO);
		System.out.println("Entered Out Come is : " + FO);
	}

	public void SetMaxDeduction(String MD)
	{
		MaxDeduction.clear();

		MaxDeduction.sendKeys(MD);
		System.out.println("Enterd Exceptional Max Deduction is : " + MD);
		chiledTest.log(Status.INFO, "Exceptional Max Deduction is Enterd");
	}

	public void ClickInformedAuditRadioButton()
	{
		InformedAuditRadioBTN.click();
		System.out.println("Informed Audit Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Informed Audit Radio Button is Clicked");
	}

	public void ClickSurpriseAuditRadioButton()
	{
		SurpriseAuditRadioBTN.click();
		System.out.println("Surprise Audit Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Surprise Audit Radio Button is Clicked");
	}

	public void SetFirstCPSeq(String CS1)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(FirstCPSeq)).clear();
		wait.until(ExpectedConditions.visibilityOf(FirstCPSeq)).sendKeys(CS1);
		System.out.println("Entered 1st checkpoint Sequence order is : " + CS1);
		chiledTest.log(Status.INFO, "1st checkpoint Sequence order is Entered");
	}

	public void ClickSpotResolutionHeadOfAuditRadioBTN()
	{
		SpotHeadOfAuditRBTN.click();
		System.out.println("Spot Resolution By Head of Audit Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Spot Resolution By Head of Audit Radio Button is Clicked");
	}

	public void ClickSpotResolutionByAuditorDusringExecutionRadioBTN()
	{
		SpotAuditorDuringExecutionRBTN.click();
		System.out.println("Spot Resolution By Auditor During Exection Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Spot Resolution By Auditor During Exection Radio Button is Clicked");
	}

	public void ClickSpotResolutionByReviewerRadioBTN()
	{
		SpotByReviewerRBTN.click();
		System.out.println("Spot Resolution By Reviewer/Verifier Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Spot Resolution By Reviewer/Verifier Radio Button is Clicked");
	}

	public void SetScoreForSpotResolution(String SS)
	{
		ScoreForSpotResolution.sendKeys(SS);
		System.out.println("Entered Score for Spot Resuliton is : " + SS);
		chiledTest.log(Status.INFO, "Score for Spot Resolution is Entered");
	}

	public void ClickDirectResolutionByHeadOfAuditRadioBTN()
	{
		DirectHeadOfAuditRBTN.click();
		System.out.println("Direct Resolution By Head of audit Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Direct Resolution By Head of audit Radio Button is Clicked");
	}

	public void SetEnterScoreForDirectResolution(String SD)
	{
		ScoreForDirectResolution.sendKeys(SD);
		System.out.println("Entered Score for Direct Resolution is : " + SD);
		chiledTest.log(Status.INFO, "Score for Direct Resolution is Entered");
	}

	public void ClickDirectResolutionByReviewerRadioBTN()
	{
		DirectByReviewerRBTN.click();
		System.out.println("Direct Resolution By Reviewer Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Direct Resolution By Reviewer Radio Button is Clicked");
	}



	public void VerifyAuditTypePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking the Audit Type Header
		WebElement Header = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(Header)).isDisplayed())
		{
			String Expected_Header = Header.getText();
			String Actual_Header = "AUDIT TYPE";
			Assert.assertEquals(Expected_Header, Actual_Header);
			System.out.println("Pass : Audit Type Header is Displayed");
		}

		//Checking Show and Rows
		WebElement show = driver.findElement(By.xpath("//div[@id='tableAuditTypes_length']/label"));
		if(show.isDisplayed())
		{
			System.out.println("pass : Show and Rows are displayed");
		}

		//Checking Search Text Box
		if(SearchBTN.isDisplayed())
		{
			System.out.println("Pass : Search Text Box is Displayed");
		}

		//Checking the Tabel
		WebElement Table = driver.findElement(By.xpath("//table[@id='tableAuditTypes']"));
		if(Table.isDisplayed())
		{
			System.out.println("Pass : Table is Displayed");
		}

		//Checking the Data
		try
		{
			boolean data = driver.findElement(By.xpath("//tr[@class='audit_type_records even' or 'audit_type_records odd']")).isDisplayed();
			System.out.println("Audit Typs are Displayed : " + data);
		}catch (Exception e) {

			boolean Empty = driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isDisplayed();
			System.out.println("No data available in table Message is Displayed : " + Empty);
		}

		//Checking SNo
		WebElement SN = driver.findElement(By.xpath("//th[contains(text(),'Sno.')]"));
		if(SN.isDisplayed())
		{
			String Expected_SN = SN.getText();
			String Actual_SN = "SNO.";
			Assert.assertEquals(Expected_SN, Actual_SN);
		}
		//Checking Audit Type
		WebElement AuditType = driver.findElement(By.xpath("//th[text()='Audit Type']"));
		if(AuditType.isDisplayed())
		{
			String Expected_Audit = AuditType.getText();
			String Actual_Audit = "AUDIT TYPE";
			Assert.assertEquals(Expected_Audit, Actual_Audit);

		}

		//Checking Parent Audit Type
		WebElement ParentAuditType = driver.findElement(By.xpath("//th[text()='Parent Audit Type']"));
		if(ParentAuditType.isDisplayed())
		{
			String Expected_ParentAuditType = ParentAuditType.getText();
			String Actual_ParentAuditType = "PARENT AUDIT TYPE";
			Assert.assertEquals(Expected_ParentAuditType, Actual_ParentAuditType);

		}

		//checking Timestamp
		WebElement Timestamp = driver.findElement(By.xpath("//th[text()='Timestamp']"));
		if(Timestamp.isDisplayed())
		{
			String Expected_Timestamp = Timestamp.getText();
			String Actual_Timestamp = "TIMESTAMP";
			Assert.assertEquals(Expected_Timestamp, Actual_Timestamp);
		}

		//Checking Create Audit Type Button
		if(CreateAuditTypeBTN.isDisplayed())
		{
			System.out.println("Pass : Create Audit Type Button is Displayed");
		}

	}

	public void VerifyBeginTabMandatoryFields(WebDriver driver)
	{

		//Checking Audit Type Name text field should accept 255 characters
		List<WebElement> ATN = driver.findElements(By.xpath("//input[@placeholder='Enter audit type name' and @maxlength='255' and @required='required']"));
		Assert.assertTrue(ATN.size()>0, "Audit Type Name is Accepting More than 255 charecters");
		System.out.println("Pass : Audit Type Name is Accepting <=255 charecters");
		chiledTest.log(Status.INFO, "Audit Type Name is Accepting <=255 charecters");

		//Checking Audit Type Name text field is Required or NOT
		List<WebElement> ATN1 = driver.findElements(By.xpath("//label[@id='audit_type_name-error']"));
		Assert.assertTrue(ATN1.size()>0, "Audit Type Name is Not Working as Required Field");
		System.out.println("Pass : Audit Type Name is Required Filed");
		chiledTest.log(Status.INFO, "Audit Type Name is Required Filed");

		//Checking Select Auditee Type is Required and Multi select
		List<WebElement> SAT = driver.findElements(By.xpath("//label[@id='auditee_types_-error']"));
		Assert.assertTrue(SAT.size()>0, "Auditee Type is Not Working as Required Field");
		System.out.println("Auditee Type is Required Filed");
		chiledTest.log(Status.INFO, "Audit Type is Required Filed");

		//Checking select auditee Type is Multiple select or not
		List<WebElement> SelectAuditeeType = driver.findElements(By.xpath("//Select[@name='auditee_types[]' and @required='required' and @multiple='multiple']"));
		Assert.assertTrue(SelectAuditeeType.size()>0, "Select Auditee Type is Not Working as Mutiple select");
		System.out.println("Select Auditee Type is Working as Mutiple select");
		chiledTest.log(Status.INFO, "Select Auditee Type is Working as Mutiple select");

	}



	public void VerifyDefineTabMandatoryFileds(WebDriver driver)
	{
		//Checking Group Type is Required field or Not
		List<WebElement> Group = driver.findElements(By.xpath("//label[@id='group_type-error']"));
		Assert.assertTrue(Group.size()>0, "Select Group Type is Not Working as Required Field");
		System.out.println("Pass : Select Group Type is Required Filed");
		chiledTest.log(Status.INFO, "Select Group Type is Required Filed");

		//checking Sub Audit Type
		List<WebElement> SubAuditType = driver.findElements(By.xpath("//label[@id='group_type-error']"));
		Assert.assertTrue(SubAuditType.size()>0, "Sub Audit Type is Not Working as Required Field");
		System.out.println("Pass : Sub Audit Type is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Sub Audit Type is Required Filed");


	}

	public void VerifyEvaluateTabMandatoryFileds(WebDriver driver)
	{
		//Checking Low 
		List<WebElement> Low = driver.findElements(By.xpath("//label[@id='audit_type_risk_scoring_attributes_low-error']"));
		Assert.assertTrue(Low.size()>0, "Low is Not Working as Required Field");
		System.out.println("Pass : Low is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Low is Required Filed");

		//checking the Low Risk Scoring max length =3
		List<WebElement> Low1 = driver.findElements(By.xpath("//input[@id='audit_type_risk_scoring_attributes_low' and @required='required' and @maxlength='7']"));
		Assert.assertTrue(Low1.size()>0, "Risk Score Low is Accepting more than 3 digits");
		System.out.println("Pass : Risk Score Low is Not Accepting more than 3 digits");
		chiledTest.log(Status.INFO, "Pass : Risk Score Low is Not Accepting more than 3 digits");

		//checking Medium
		List<WebElement> Medium = driver.findElements(By.xpath("//label[@id='audit_type_risk_scoring_attributes_medium-error']"));
		Assert.assertTrue(Medium.size()>0, "Medium is Not Working as Required Field");
		System.out.println("Pass : Medium is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Medium is Required Filed");

		//checking the Medium Risk Scoring max length =3
		List<WebElement> Medium1 = driver.findElements(By.xpath("//input[@id='audit_type_risk_scoring_attributes_medium' and @required='required' and @maxlength='7']"));
		Assert.assertTrue(Medium1.size()>0, "Risk Score Medium is Accepting more than 3 digits");
		System.out.println("Pass : Risk Score Medium is Not Accepting more than 3 digits");
		chiledTest.log(Status.INFO, "Pass : Risk Score Medium is Not Accepting more than 3 digits");

		//checking High
		List<WebElement> High = driver.findElements(By.xpath("//label[@id='audit_type_risk_scoring_attributes_high-error']"));
		Assert.assertTrue(High.size()>0, "High is Not Working as Required Field");
		System.out.println("Pass : High is Required Filed");
		chiledTest.log(Status.INFO, "Pass : High is Required Filed");

		//checking the High Risk Scoring max length =3
		List<WebElement> High1 = driver.findElements(By.xpath("//input[@id='audit_type_risk_scoring_attributes_high' and @required='required' and @maxlength='7']"));
		Assert.assertTrue(High1.size()>0, "Risk Score High is Accepting more than 3 digits");
		System.out.println("Pass : Risk Score High is Not Accepting more than 3 digits");
		chiledTest.log(Status.INFO, "Pass : Risk Score High is Not Accepting more than 3 digits");

		//checking Zero Tolerance
		List<WebElement> ZeroTolerance = driver.findElements(By.xpath("//label[@id='audit_type_risk_scoring_attributes_zero_tolerance-error']"));
		Assert.assertTrue(ZeroTolerance.size()>0, "High is Not Working as Required Field");
		System.out.println("Pass : Zero Tolerance is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Zero Tolerance is Required Filed");

		//checking the High Risk Scoring max length =3
		List<WebElement> ZeroTolerance1 = driver.findElements(By.xpath("//input[@id='audit_type_risk_scoring_attributes_zero_tolerance' and @required='required' and @maxlength='7']"));
		Assert.assertTrue(ZeroTolerance1.size()>0, "Risk Score ZeroTolerance is Accepting more than 3 digits");
		System.out.println("Pass : Risk Score ZeroTolerance is Not Accepting more than 3 digits");
		chiledTest.log(Status.INFO, "Pass : Risk Score ZeroTolerance is Not Accepting more than 3 digits");

	}

	public void VerifyConfigureTabMandatoryFields(WebDriver driver)
	{
		//Checking Select Verifier 
		List<WebElement> SelectVerifier1 = driver.findElements(By.xpath("//select[@id='audit_type_issue_configuration_attributes_verifier' and @required='required']"));
		Assert.assertTrue(SelectVerifier1.size()>0, "High is Not Working as Required Field");
		System.out.println("Pass : Select Verifier is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Select Verifier is Required Filed");

		//Checking Select TAT 
		List<WebElement> TAT = driver.findElements(By.xpath("//select[@id='audit_type_issue_configuration_attributes_tat_type' and @required='required']"));
		Assert.assertTrue(TAT.size()>0, "High is Not Working as Required Field");
		System.out.println("Pass : Select TAT is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Select TAT is Required Filed");

		/*//Checking frequency
			List<WebElement> Frequency1 = driver.findElements(By.xpath("//select[@id='audit_type_frequency' and @required='required']"));
			Assert.assertTrue(Frequency1.size()>0, "High is Not Working as Required Field");
			System.out.println("Pass : Frequency is Required Filed");
			chiledTest.log(Status.INFO, "Pass : Frequency is Required Filed");*/
	}



	public void VerifyFinalizeTabMandatoryFields(WebDriver driver)
	{
		//checking Total score is Required
		List<WebElement> TOtalScore = driver.findElements(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type' and @required='required']"));
		Assert.assertTrue(TOtalScore.size()>0, "Total Score is Not Working as Required Field");
		System.out.println("Pass : Total Score is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Total Score is Required Filed");

		//checking From is Required
		List<WebElement> From = driver.findElements(By.xpath("//input[@class='from_field main-type' and @required='required']"));
		Assert.assertTrue(From.size()>0, "From is Not Working as Required Field");
		System.out.println("Pass : From is Required Filed");
		chiledTest.log(Status.INFO, "Pass : From is Required Filed");

		//Checking the TO is Required field
		List<WebElement> TO = driver.findElements(By.xpath("//input[@class='to_field main-type' and @required='required']"));
		Assert.assertTrue(TO.size()>0, "To is Not Working as Required Field");
		System.out.println("Pass : To is Required Filed");
		chiledTest.log(Status.INFO, "Pass : To is Required Filed");

		//Checking the Out Come is Required field
		List<WebElement> OutCome = driver.findElements(By.xpath("//textarea[@class='text-uppercase audit_rating_result main-type outcome_text' and @required='required']"));
		Assert.assertTrue(OutCome.size()>0, "Out Come is Not Working as Required Field");
		System.out.println("Pass : Out Come is Required Filed");
		chiledTest.log(Status.INFO, "Pass : Out Come is Required Filed");


	}

	public void VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "Audit type created successfully.";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Audit type created successfully.Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}


	public void VerifyAuditCheckPointsShouldContainCheckPointsErrorMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "Audit check points Should contain check_points";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Audit check points Should contain check_points Error Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
		}
	}

	public void VerifyConfigureTabIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean CT = driver.findElement(By.xpath("//li[@class='step5 active']")).isDisplayed();
		System.out.println("Configure Tab is Displayed : " + CT);
	}

	public void VerifyEvaluateTabIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean ET = driver.findElement(By.xpath("//a[@class='step3 active']")).isDisplayed();
		System.out.println("Evaluation Tab is Displayed : " + ET);
	}

	public void VerifyManageRoleTabIsDisplayed(WebDriver driver)
	{
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ET = driver.findElement(By.xpath("//a[contains(@class,'step5 active')]"));
		wait.until(ExpectedConditions.visibilityOf(ET));
		System.out.println("Manage Role Tab is Displayed : " + ET);
	}

	public void VerifyNameHasAlreadyBeenTakenErrorMSGIsDisplayed(WebDriver driver)
	{

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "Name has already been taken";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Name has already been taken Error Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
		}
	}

	public void VerifyRadioButtonsAreWorkingFine(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		//Checking Parent Audit Type Radio Button is Displayed
		boolean PR = driver.findElement(By.xpath("//label[@for='audit_type_parent_audit_type']")).isDisplayed();
		System.out.println("Parent Audit Type is Displayed : " + PR);

		//Checking Sub Audit Type Radio Button is Displayed
		boolean SR = driver.findElement(By.xpath("//label[@for='type_sub_audit_type']")).isDisplayed();
		System.out.println("Sub Audit Type Radio Button is Displayed : " + SR);

		//Checking Group Radio Button
		boolean GR = driver.findElement(By.xpath("//label[@for='type_group']")).isDisplayed();
		System.out.println("Group Radio Button is Displayed : " + GR);

		//Clicking on the Parent Audit Type
		ParentTypeAuditRadioBTN.click();
		System.out.println("******************Parent Audit Type Radio Button is Clicked***************");

		//Checking Group Radio Button is Selected
		boolean GR1 = driver.findElement(By.xpath("//input[@id='type_group'][@checked='checked']")).isSelected();
		System.out.println("Initially Group Radio Button is Selected : " + GR1);

		//Checking Sub Audit Type Radio Button is Selected
		boolean SR1 = driver.findElement(By.xpath("//input[@id='type_sub_audit_type']")).isSelected();
		System.out.println("Sub Audit Type Radio Button is Selected : " + SR1);

		//Clicking on the Sub Audit Type Radio Button
		SubAuditTypeRadioBTN.click();
		System.out.println("*****************Sub Audit Type Radio Button is Clicked******************");

		//Checking Sub Audit Type Radio Button is Selected
		boolean SR2 = driver.findElement(By.xpath("//input[@id='type_sub_audit_type']")).isSelected();
		System.out.println("Sub Audit Type Radio Button is Selected : " + SR2);

		//Checking Group Radio Button is Selected
		boolean GR2 = driver.findElement(By.xpath("//input[@id='type_group'][@checked='checked']")).isSelected();
		System.out.println("Group Radio Button is Selected : " + GR2);


	}

	public void VerifySelectedUserCount(WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement SelectedUser = driver.findElement(By.xpath("//div[@id='s2id_selected_users']/ul/li/div"));
			wait.until(ExpectedConditions.visibilityOf(SelectedUser));
			//Checking Selected User Cantains one User or More User
			List<WebElement> UserCount = driver.findElements(By.xpath("//div[@id='s2id_selected_users']/ul/li/div"));
			int count = UserCount.size();
			int Expected_count = count;
			int Actual_count = 1;
			Assert.assertEquals(Expected_count, Actual_count);
			System.out.println("Selected User Count is : " + count);
		}catch (StaleElementReferenceException e) {

		}

	}



	public void VerifyAuditTypeUpdatedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "Audit type updated successfully.";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Audit type updated successfully. Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}

	public void VerifyNoDataAvailableInTableMsgIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement NoDataFound = driver.findElement(By.xpath("//td[contains(text(),'No data available in table')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(NoDataFound)).isDisplayed(), "No data available in table Is Not Displayed");
		System.out.println("Pass : No data available in table Message is Displayed");
		chiledTest.log(Status.INFO, "Pass : No data available in table Message is Displayed");
	}

	public void VerifyAuditRatingDeletePopUpIsDisplayed(WebDriver driver) 
	{
		//Checking the Audit Rating pop up is Displayed
		List<WebElement> AuditRatingDealtePopUp = driver.findElements(By.xpath("//h5[contains(text(),'Audit Rating Delete')]"));
		Assert.assertTrue(AuditRatingDealtePopUp.size()>0, "Audit Rating Delete Pop Up is Not Displayed");
		System.out.println("Pass : Audit rating Pop up is Displayed");
		chiledTest.log(Status.INFO, "Audit rating Pop up is Displayed");

		//Checking the Are you sure you want to cancel? Any changes will be lost. Message is Displayed
		List<WebElement> PopUpMSG = driver.findElements(By.xpath("//p[text()=' Are you sure you want to cancel?  Any changes will be lost. ']"));
		Assert.assertTrue(PopUpMSG.size()>0, "Are you sure you want to cancel? Any changes will be lost. Message is Not Displayed");
		System.out.println("Pass : Are you sure you want to cancel? Any changes will be lost. Message is Displayed");
		chiledTest.log(Status.INFO, "Are you sure you want to cancel? Any changes will be lost. Message is Displayed");
	}

	public void VerifyingAllIssueToggleButtonsAreDisplayed()
	{
		//Checking the Eliminate Auditee Sign off Toggle button is displayed
		Assert.assertTrue(EliminateAuditeeSignOffToggleBTN.isDisplayed(), "Eliminate Auditee Signoff Toggle Button is NOT displayed");
		System.out.println("Eliminate Auditee Signoff Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Eliminate Auditee Signoff Toggle Button is displayed");

		//Clicking on the Annexure score Toggle Button
		Assert.assertTrue(AnnexureScoreToggleBTN.isDisplayed(), "Annexure score Toggle Button is NOT displayed");
		System.out.println("Annexure score Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Annexure score Toggle Button is displayed");

		//Clicking on the Annexure sampling
		Assert.assertTrue(AnnexureSamplingToggleBTN.isDisplayed(), "Annexure Sampling Toggle Button is NOT displayed");
		System.out.println("Annexure Sampling Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Annexure Sampling Toggle Button is displayed");

		//Clicking on the Should digital evidence be mandatory for main audit ?
		Assert.assertTrue(DigitalEvidenceMandatoryToggleBTN.isDisplayed(), "digital evidence be mandatory for main audit Toggle Button is NOT displayed");
		System.out.println("digital evidence be mandatory for main audit Toggle Button is displayed");
		chiledTest.log(Status.INFO, "digital evidence be mandatory for main audit Toggle Button is displayed");

		//Clicking on the Do you need to finalize audits in bulk ?
		Assert.assertTrue(BulkFinalizeToggleBTN.isDisplayed(), "Eliminate Auditee workflow Toggle Button is NOT displayed");
		System.out.println("Finalize Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Finalize Toggle Button is displayed");

		//Clicking on the Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed 
		Assert.assertTrue(AuditorRemarksToogleBTN.isDisplayed(), "Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed Toggle Button is NOT displayed");
		System.out.println("Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowedt Toggle Button is displayed");

		//Clicking on the Do you want to allocate provissional submission (this allows the reviewer to parallelly review and submit the audit)
		Assert.assertTrue(ProvisionalSubmissionToggleBTN.isDisplayed(), "allocate provissional submission Toggle Button is NOT displayed");
		System.out.println("allocate provissional submission Toggle Button is displayed");
		chiledTest.log(Status.INFO, "allocate provissional submission Toggle Button is displayed");

		//Clicking on the Do you wish to add additional information at checkpoint level?
		Assert.assertTrue(AdditionalInfoToggleBTN.isDisplayed(), "Do you wish to add additional information at checkpoint level? Toggle Button is NOT displayed");
		System.out.println("Do you wish to add additional information at checkpoint level? Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Do you wish to add additional information at checkpoint level? Toggle Button is displayed");

		//Clicking on the Do you want to allow auditee side user(auditee, respondent, reviewer) to change the issue due date?
		Assert.assertTrue(IssueDuedateToggleBTN.isDisplayed(), "Do you want to allow auditee side user(auditee, respondent, reviewer) to change the issue due date? Toggle Button is NOT displayed");
		System.out.println("Do you want to allow auditee side user(auditee, respondent, reviewer) to change the issue due date? Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Do you want to allow auditee side user(auditee, respondent, reviewer) to change the issue due date? Toggle Button is displayed");

		//Clicking on the Do you wish to add selfie?
		Assert.assertTrue(AddSelfieToggleBTN.isDisplayed(), "Do you wish to add selfie? Toggle Button is NOT displayed");
		System.out.println("Do you wish to add selfie? Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Do you wish to add selfie? Toggle Button is displayed");

		//Clicking on the Do you wish to add digital signatures?
		Assert.assertTrue(DigitalSignaturesToggleBTN.isDisplayed(), "Do you wish to add digital signatures? Toggle Button is NOT displayed");
		System.out.println("Do you wish to add digital signatures? Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Do you wish to add digital signatures? Toggle Button is displayed");

		//Clicking on the Do you wish to enable deemed sign off for this audit?
		Assert.assertTrue(DeemedAuditeeSifnOffToggleBTN.isDisplayed(), "Do you wish to enable deemed sign off for this audit? Toggle Button is NOT displayed");
		System.out.println("Do you wish to enable deemed sign off for this audit? Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Do you wish to enable deemed sign off for this audit? Toggle Button is displayed");

		//Clicking on the Allow multiple level review Toggle Button is Displayed
		Assert.assertTrue(AllowMultiplelevelReviewToggleBTN.isDisplayed(), "Allow multiple level review Toggle Button is NOT displayed");
		System.out.println("Allow multiple level review Toggle Button is displayed");
		chiledTest.log(Status.INFO, "Allow multiple level review Toggle Button is displayed");


	}

	public void VerifyAnnexureScoringAndAnnexureSamplingToggleButtonsShouldNotShow()
	{

		//Clicking on the Annexure score Toggle Button
		Assert.assertFalse(AnnexureScoreToggleBTN.isDisplayed(), "Annexure score Toggle Button is displayed");
		System.out.println("Annexure score Toggle Button is NOT displayed");
		chiledTest.log(Status.INFO, "Annexure score Toggle Button is NOT displayed");

		//Clicking on the Annexure sampling
		Assert.assertFalse(AnnexureSamplingToggleBTN.isDisplayed(), "Annexure Sampling Toggle Button is displayed");
		System.out.println("Annexure Sampling Toggle Button is NOT displayed");
		chiledTest.log(Status.INFO, "Annexure Sampling Toggle Button is NOT displayed");

	}

	public void VerifyExceptionalMaxDeductionIsRequired()
	{
		WebElement Error = driver.findElement(By.xpath("//label[@id='audit_type_negative_max_score-error']"));
		if(Error.isDisplayed())
		{
			String Actual_Error = Error.getText();
			String Excepted_Error = "This field is required.";
			Assert.assertEquals(Actual_Error, Excepted_Error, "Exceptional Mex Deduction Error Message is Wrong");
			System.out.println("This field is require Error Message is Displayed");
			chiledTest.log(Status.INFO, "This field is require Error Message is Displayed");
		}
	}

	public void VerifyPleaseEnterValidMaxScoreErrorMSGISDisplayed()
	{
		WebElement ErrorMSG = driver.findElement(By.xpath("//span[text()='Please enter valid max score']"));
		Assert.assertTrue(ErrorMSG.isDisplayed(), "Please enter valid max score Error Message is Not Displayed");
		System.out.println("Please enter valid max score Error Message is Displayed");
		chiledTest.log(Status.INFO, "Please enter valid max score Error Message is Displayed");
	}

	/*public void AddingAdditionalParameters()
	{
		//Selecting All the Check Box 
		List<WebElement> ALLCKBTN = driver.findElements(By.xpath("//input[@class='info_flag']"));
		Assert.assertTrue(ALLCKBTN.size()==12, "Toatl 12 Check box are not diplayed");
		System.out.println("Toatl 12 Check box are displayed");
		chiledTest.log(Status.INFO, "Toatl 12 Check box are displayed");
		for(WebElement AB :  ALLCKBTN )
		{
			AB.click();
		}

		//Selecting All the Check Box 
		List<WebElement> IsMandetory = driver.findElements(By.xpath("//input[@class='is_mandetory']"));
		Assert.assertTrue(IsMandetory.size()==12, "Toatl 12 Is Mandatory Check box are not diplayed");
		chiledTest.log(Status.INFO, "Toatl 12 Is Mandatory Check box are displayed");
		IsMandetory.get(0).click();
		IsMandetory.get(2).click();
		IsMandetory.get(4).click();
		IsMandetory.get(6).click();
		IsMandetory.get(8).click();
		IsMandetory.get(10).click();

		//selecting the Number under 1st Parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[1]//select[@class='form-control additional_info datatype']/option[@value='number']")).click();
		System.out.println("Number is Selected for the 1st parameter");
		chiledTest.log(Status.INFO, "Number is Selected for the 1st parameter");

		//selecting text under 2nd Parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[2]//select[@class='form-control additional_info datatype']/option[@value='text']")).click();
		System.out.println("Text is Selected for the 2nd parameter");
		chiledTest.log(Status.INFO, "Text is Selected for the 2nd parameter");

		//selecting Text and Number under 3rd parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[3]//select[@class='form-control additional_info datatype']/option[@value='text_and_numbers']")).click();
		System.out.println("Text and Number is Selected for the 3rd parameter");
		chiledTest.log(Status.INFO, "Text and Number is Selected for the 3rd parameter");

		//selecting date under 4th parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[4]//select[@class='form-control additional_info datatype']/option[@value='date']")).click();
		System.out.println("date is Selected for the 4th parameter");
		chiledTest.log(Status.INFO, "date is Selected for the 4th parameter");

		//selecting date under 5th parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[5]//select[@class='form-control additional_info datatype']/option[@value='date_and_range']")).click();
		System.out.println("date and range is Selected for the 5th parameter");
		chiledTest.log(Status.INFO, "date and range is Selected for the 5th parameter");

		//selecting date under 6th parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[6]//select[@class='form-control additional_info datatype']/option[@value='values']")).click();
		System.out.println("Values is Selected for the 6th parameter");
		chiledTest.log(Status.INFO, "Values is Selected for the 6th parameter");

		//selecting date under 7th parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[7]//select[@class='form-control additional_info datatype']/option[@value='percentage']")).click();
		System.out.println("percentage is Selected for the 7th parameter");
		chiledTest.log(Status.INFO, "percentage is Selected for the 7th parameter");

		//selecting the Number under 8th Parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[8]//select[@class='form-control additional_info datatype']/option[@value='number']")).click();
		System.out.println("Number is Selected for the 8th parameter");
		chiledTest.log(Status.INFO, "Number is Selected for the 8th parameter");

		//selecting text under 9th Parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[9]//select[@class='form-control additional_info datatype']/option[@value='text']")).click();
		System.out.println("Text  is Selected for the 9th parameter");
		chiledTest.log(Status.INFO, "Text is Selected for the 9th parameter");

		//selecting Text and Number under 10th parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[10]//select[@class='form-control additional_info datatype']/option[@value='text_and_numbers']")).click();
		System.out.println("Text and number  is Selected for the 10th parameter");
		chiledTest.log(Status.INFO, "Text and number is Selected for the 10th parameter");

		//selecting date under 11th parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[11]//select[@class='form-control additional_info datatype']/option[@value='percentage']")).click();
		System.out.println("percentage  is Selected for the 11th parameter");
		chiledTest.log(Status.INFO, "percentage is Selected for the 11th parameter");

		//selecting date under 12th parameters
		driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[12]//select[@class='form-control additional_info datatype']/option[@value='percentage']")).click();
		System.out.println("percentage  is Selected for the 12th parameter");
		chiledTest.log(Status.INFO, "percentage is Selected for the 12th parameter");

		//clicking on the Values
		WebElement Values = driver.findElement(By.xpath("//table[@id='table_addtional_info']/tbody/tr[6]//div[@class='bootstrap-tagsinput']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Values);

		driver.switchTo().activeElement().sendKeys("Values Test 1");

		driver.switchTo().activeElement().sendKeys(Keys.ENTER);

		driver.switchTo().activeElement().sendKeys("Values Test 2");

		driver.switchTo().activeElement().sendKeys(Keys.ENTER);


	}*/

	public void VerifySupriseAuditRadioButtonIsEnabldByDefult()
	{
		WebElement SupriseRadioBTN = driver.findElement(By.xpath("//input[@id='audit_type_is_informed_audit_false' and @checked='checked']/following-sibling::label[text()='Surprise Audit']"));
		Assert.assertTrue(SupriseRadioBTN.isEnabled(), "Suprise Radio Button is Not Enabled by Defult");
		System.out.println("Suprise Radio Button is Enabled by Defult");
		chiledTest.log(Status.INFO, "Suprise Radio Button is Enabled by Defult");

	}

	public void VerifyAuditTypeMultipleReviewRoleShouldNotBeDuplicateErrorMessageIsDisplayed()
	{

		WebElement ErrorMSG = driver.findElement(By.xpath("//span[contains(text(),'Audit Type Multiple Review role should not be duplicate, Name has already been taken')]"));
		Assert.assertTrue(ErrorMSG.isDisplayed(), "Audit Type Multiple Review role should not be duplicate, Name has already been taken Error Message is Not Displayed");
		System.out.println("Audit Type Multiple Review role should not be duplicate, Name has already been taken Error message is Displayed");
		chiledTest.log(Status.INFO, "Audit Type Multiple Review role should not be duplicate, Name has already been taken Error message is Displayed");
	}

	public void VerifyAddButtonIsDisabled()
	{
		Assert.assertFalse(MultipleLevelAddBTN.isDisplayed(), "Add Button is Displayed after 5 Times");
		System.out.println("Add Button is Not Displayed");
		chiledTest.log(Status.INFO, "Add Button is Not Displayed");
	}

	public void VerifyAuditTypeNameAlreadyExistErrorMSGIsDisplayed()
	{
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[text()='Audit type name already exist!']"));
		Assert.assertTrue(ErrorMSG.isDisplayed(), "Audit type name already exist! Error Message is Not Displayed");
		System.out.println("Audit type name already exist! Error message is Displayed");
		chiledTest.log(Status.INFO, "Audit type name already exist! Error message is Displayed");
	}

}

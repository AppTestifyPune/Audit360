package scripts;

import java.util.List;
import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AdminIssuePageTest;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.ConfigureAuditPageTest;
import pom.GroupPageTest;
import pom.IssuesPageTest;
import pom.LoginPageTest;
import pom.ReviewAuditPageTest;
import pom.ReviewIssuePageTest;
import pom.SideMenuPageTest;

public class IssueSignificanceGroupsFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=4)
	public void Creating_Parent_Audit_Type_Test() throws InterruptedException
	{
		parentTest = extent.createTest("Issue Significance Functionality Test With Group Level Allocation", "Testing the Functionality of the Issue Significance withch is mapped with Groups level Allocations");

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Parent Audit Type Test");

		System.out.println("Creating Parent Audit Type Test");

		LoginPageTest l=new LoginPageTest(driver);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Singin Button is Clicked");

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

		CA.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		CA.ClickConfigureAudit(driver);
		chiledTest.log(Status.INFO, "Configure Audit is Clicked");

		//Clicking on the configure Audit Sub menu
		CA.ClickConfigureAuditSubMenu();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		CA.SetAuditTypeName(ATN, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");


		//Passing the values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******* DEFINE TAB *****************************

		//Clicking on the Parent Type Audit Radio Button
		CA.ClickParentTypeAuditRadioBTN(driver);
		chiledTest.log(Status.INFO, "Parent audit type Radio Button is Clicked");

		//Clicking on the select Group 
		CA.ClickSelectGrouptype(driver);

		//Passing the values to  select Group type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG1 = Lib.getCellValue(XLPATH, "Group", 9, 0);
		CA.SetSelectCheckPointGroup(SCG1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG2 = Lib.getCellValue(XLPATH, "Group", 10, 0);
		CA.SetSelectCheckPointGroup(SCG2, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* EVALUATE  TAB ***************************

		//Passing the Values to Low Risk Scroing
		String LR = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 76, 0);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scroing
		String MR = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 67, 0);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scroing
		String HR = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 72, 0);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Talerance Risk Scroing
		String ZR = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 80, 0);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Talerence Risk Scoring is Entered");


		//Clicking on the Next Button
		CA.ClickEvaluteTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = driver.switchTo().alert();
		Alert.dismiss();

		//******** CONFIGURE  TAB **************

		//Clicking on the Eliminate Auditee Sign off Toggle button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();

		//Clicking on the Do you want to enable issue significance configuration for this audit type? toggle button
		CA.ClickDoYouWantToEnableIssueMappingConfigurationForThisAudittypeToggleBTN();

		//clicking on the Issue Signification Mapping is clicked
		CA.ClickIssueSignificanceMapping();

		//passing the values to issue significance
		String SS1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 192, 0);
		CA.SetIssueSignificanceMappingData(SS1);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//passing the values to issue significance
		String SS2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 193, 0);
		CA.SetIssueSignificanceMappingData(SS2);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//passing the values to issue significance
		String SS3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 194, 0);
		CA.SetIssueSignificanceMappingData(SS3);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//passing the values to issue significance
		String SS4 = Lib.getCellValue(XLPATH, "Configure Audit Type", 195, 0);
		CA.SetIssueSignificanceMappingData(SS4);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//passing the values to issue significance
		String SS5 = Lib.getCellValue(XLPATH, "Configure Audit Type", 196, 0);
		CA.SetIssueSignificanceMappingData(SS5);

		//Clicking on the Select verifier
		CA.clickSelectVerifier();

		//Passing the Values to Select Verifier
		String SV = Lib.getCellValue(XLPATH, "Configure Audit Type", 58, 0);
		CA.SetSelectVerifier(SV);
		chiledTest.log(Status.INFO, "Verifier is Selected");

		//Clicking on the Match
		CA.ClickMatch();

		//Passing the Values to Low Due Days
		String SL = Lib.getCellValue(XLPATH, "Configure Audit Type", 73, 0);
		CA.SetLowDueDays(SL);
		chiledTest.log(Status.INFO, "Low Due Days is Entered");

		//Passing the Values to Medium Due Days
		String SM = Lib.getCellValue(XLPATH, "Configure Audit Type", 79, 0);
		CA.SetMediumDueDays(SM);
		chiledTest.log(Status.INFO, "Medium Due Days is Entered");

		//Passing the Values to High Due Days
		String SH = Lib.getCellValue(XLPATH, "Configure Audit Type", 85, 0);
		CA.SetHighDueDays(SH);
		chiledTest.log(Status.INFO, "High Due Days is Entered");

		//Passing the Values to ZT Due Days
		String SZ = Lib.getCellValue(XLPATH, "Configure Audit Type", 91, 0);
		CA.SetZTDueDays(SZ);
		chiledTest.log(Status.INFO, "ZT Due Days is Entered");

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Finalize Tab ************************

		Thread.sleep(5000);

		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		double d = 180;
		String Str = Double.toString(d);
		Assert.assertEquals(TotalScoreCount, Str, "Total Score count is showing Wrong");
		System.out.println("Diplayed Total Score is : " + Str);

		//Checking the To Count
		String Actual_TO = driver.findElement(By.xpath("//input[@id='audit_type_audit_ratings_attributes_0_to']")).getAttribute("value");
		System.out.println("TO Count is : " + Actual_TO);
		int d1 = 100;
		String Str1 = Integer.toString(d1);
		Assert.assertEquals(Actual_TO, Str1, "Total Score count is showing Wrong");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to First TO
		String FT = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 85, 0);
		CA.SetFirstTo(FT, driver);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 94, 0);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Second TO
		String ST1 = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 86, 0);
		CA.SetSecondTo(ST1, driver);

		//Passing the Values to Second Out Come
		String SO = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 93, 0);
		CA.SetSecondOutCome(SO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Passing the Values to Third Out Come
		String TO1 = Lib.getCellValue(XLPATH, "RSL Scenarios 3", 92, 0);
		CA.SetThirdOutCome(TO1, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully. Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully. Success Message is Displayed");

		System.out.println("**************************************************************");

	}

	//Configuring the Auditee admin configuration
	@Test(priority=5, dependsOnMethods= {"Creating_Parent_Audit_Type_Test"})
	public void Auditee_Admin_Configuration_Test() throws InterruptedException
	{
		SideMenuPageTest SM = new SideMenuPageTest(driver);

		AuditeeadminConfigurationPageTest AA = new AuditeeadminConfigurationPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Auditee Admin Configuration Test");

		System.out.println("Auditee Admin Configuration Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//clicking on the Scroll bar
		SM.ClickScrollBar();

		//clicking on the Configure audit
		SM.ClickConfigureAudit();

		//clicking on the Auditee admin Configure under side menu
		SM.clickAuditeeAdminConfigure();

		AA.ClickSelectAuditType();

		//passing the values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		AA.SetSetAuditType(SA);

		AA.ClickMatchedText();

		//clicking on the Respondent work flow not required radio button is clicked
		AA.ClickRespondentWorkFlowNotReuiredRadioButton();

		//clicking on the Reviewer work flow not required radio button is clicked
		AA.ClickReviwerWorkFlowNotReuiredRadioButton();

		//checking the single time radio button is disabled mode
		AA.VerifySignleTimeRadioButtonIsDisabled();

		//checking the Every time radio button is disabled mode
		AA.VerifyEveryTimeRadioButtonIsDisabled();

		//checking the sub audits radio button is disabled mode
		AA.VerifySubAuditsRadioButtonIsDisabled();

		//checking the Group radio button is disabled
		AA.VerifyGroupRadioButtonIsDisabled();

		//checking the Checkpoint radio button is disabled
		AA.VerifyCheckPointsRadioButtonIsDisabled();

		//checking the Cluster Level radio button is disabled
		AA.VerifyCluesterLevelRadioButtonIsDisabled();

		//checking the Auditee level radio button is disabled
		AA.VerifyAuditeeLevelradioButtonIsDisabled();

		//checking the Issue allocation is disabled
		AA.VerifyIssueallocationIsDisabled();

		//checking the Response to Reassign issue is disabled
		AA.VerifyResponseToReopenIssuesIsDisabled();

		//clicking on the Save button
		AA.ClickSaveBTN();

		//Verifying Auditee configuration successfully done message is Displayed
		AA.VerifyAuditeeConfigurationSuccessfullyDoneMsGIsDisplayed();

		System.out.println("******************************");

	}


	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=6, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Audit_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Audit Schedule Test");

		System.out.println("Creating Audit Schedule Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		SP.ClickScrollBar(driver);

		//Clicking on the Schedule 
		SP.ClickSchedule(driver);

		//Clicking on the Audit Schedule
		SP.ClickAuditSchedule(driver);
		chiledTest.log(Status.INFO, "Audit Schedule is Clicked");

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT1 = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		SP.SetSelectAuditType(SAT1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Vendor Option Under Select Auditee Type Drop Down List
		SP.ClickVendorOption(driver);

		//Clicking on the Select country/State/Location
		SP.ClickSelectCountryStateLocation(driver);

		//Passing the Values to Select country/State/Location
		String CSL1 = Lib.getCellValue(XLPATH, "Schedule", 6, 0);
		SP.SetCountryStateLocation(CSL1, driver);
		chiledTest.log(Status.INFO, "Country/State/Location is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Select Auditee
		SP.ClickSelectAuditee(driver);

		//Passing the Values to Select Auditee
		String SA2 = Lib.getCellValue(XLPATH, "Schedule", 9, 0);
		SP.SetSelectAuditeeText(SA2, driver);
		chiledTest.log(Status.INFO, "Select Auditee is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Start Date
		SP.ClickStartDate();

		//Selecting the today Date under Start Date
		SP.ClickTodayStartDate(driver);

		//Clicking on the End date
		SP.ClickEndDate();

		//Selecting the Today date under End Date
		SP.ClickTodayEndDate(driver);

		//Selecting Auditor
		String SA3 = Lib.getCellValue(XLPATH, "Schedule", 33, 0);
		SP.SetSetSelectAuditor(SA3);
		chiledTest.log(Status.INFO, "Auditor is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Save Button
		SP.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Schedule created successfully Success Message is Displayed
		SP.VerifyScheduleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Schedule created successfully. Success Message is displayed");

		System.out.println("****************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=7, dependsOnMethods= {"Creating_Audit_Schedule_Test"})
	public void Executing_The_AuditType_Through_Noramal_Mode_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Executing The AuditType Through Noramal Mode Test");

		System.out.println("Executing The AuditType Through Noramal Mode Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",42,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",42,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the General Parent Audit type to Audit Type
		String AT1 = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		AE.SetAuditType(AT1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Accept Button
		AE.ClickAcceptBTN(driver);
		chiledTest.log(Status.INFO, "Accept Button is Clicked");

		//Verifying Audit accepted successfully Success Message is Displayed
		AE.VerifyAuditAcceptedSuccesfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit accepted successfully Success Message is Displayed");

		driver.navigate().refresh();

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Not started Button
		AE.ClickNotStartedBTN(driver);
		chiledTest.log(Status.INFO, "Not started Button is clicked");

		//clicking on Normal Mode
		AE.Clicknormal(driver);

		System.out.println("*****************1st Check Point*************");

		chiledTest.log(Status.INFO, "****************1st Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER1 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER1);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR1 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the Yes button
		AE.ClickYesButton();

		//selecting all dispositions
		AE.SelectingAllDispositions(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************2nd Check Point*************");

		chiledTest.log(Status.INFO, "****************2nd Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER2);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR2 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR2);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Passing the Text And Number
		String IV = Lib.getCellValue(XLPATH, "Audit Execution", 42, 0);
		AE.SetEnterInputValues(IV, driver);
		chiledTest.log(Status.INFO, "Text and Number is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************3rd Check Point*************");

		chiledTest.log(Status.INFO, "****************3rd Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER3 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER3);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR3 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR3);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the No button
		AE.ClickNoButton();

		//selecting all dispositions
		AE.SelectingAllDispositions(driver);

		//selecting the values
		AE.SelectingValues(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************4th Check Point*************");

		chiledTest.log(Status.INFO, "****************4th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER4 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER4);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR4 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR4);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the Yes button
		AE.ClickYesButton();

		//selecting all dispositions
		AE.SelectingAllDispositions(driver);

		//Passing the Values to Percentage
		String IV2 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV2, driver);
		chiledTest.log(Status.INFO, "Text is Entered");

		AE.ClickNextButton(driver);

		System.out.println("*****************5th Check Point*************");

		chiledTest.log(Status.INFO, "****************5th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER5 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER5);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR5 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR5);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the NO button
		AE.ClickNoButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************6th Check Point*************");

		chiledTest.log(Status.INFO, "****************6th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER6 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER6);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR6 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR6);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Passing the Values to Date
		String ND = Lib.getCellValue(XLPATH, "Audit Execution", 43, 0);
		AE.SetNormalModeDate(ND);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************7th Check Point*************");

		chiledTest.log(Status.INFO, "****************7th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER7 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER7);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR7 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR7);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the No button
		AE.ClickNoButton();

		//selecting the values
		AE.SelectingValues(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************8th Check Point*************");

		chiledTest.log(Status.INFO, "****************8th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER8 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER8);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR8 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR8);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the NA button
		AE.ClickNAButton();

		//Passing the Values to text
		String IV3 = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		AE.SetEnterInputValues(IV3, driver);
		chiledTest.log(Status.INFO, "Text is Entered");

		AE.ClickNextButton(driver);

		System.out.println("*****************9th Check Point*************");

		chiledTest.log(Status.INFO, "****************9st Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER9 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER9);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR9 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR9);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the NA button
		AE.ClickNAButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************10th Check Point*************");

		chiledTest.log(Status.INFO, "****************10th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER10 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER10);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR10 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR10);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Date and Range is auto selected

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************11th Check Point*************");

		chiledTest.log(Status.INFO, "****************1th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER11);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR11 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR11);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the NA button
		AE.ClickNAButton();

		//selecting the values
		AE.SelectingValues(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*****************12th Check Point*************");

		chiledTest.log(Status.INFO, "****************12th Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER12 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER12);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR12 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR12);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the Partial button
		AE.ClickPartialButton();

		//Passing the Values to Text and number
		String IV4 = Lib.getCellValue(XLPATH, "Audit Execution", 42, 0);
		AE.SetEnterInputValues(IV4, driver);
		chiledTest.log(Status.INFO, "Percentage is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//checking audit submitted successfully message is displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("*******************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=8, dependsOnMethods= {"Executing_The_AuditType_Through_Noramal_Mode_Test"})
	public void Finalizing_The_AuditType_Test() throws Exception
	{

		chiledTest = parentTest.createNode("Finalize Audit Test");

		System.out.println("Finalize Audit Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Clicking on the Scroll Bar
		RA.ClickScrollBar(driver);

		//Clicking on the Review Audit side menu
		RA.ClickReviewAudit(driver);
		chiledTest.log(Status.INFO, "Review Audit is Clicked");

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing The Group**********************");

		chiledTest.log(Status.INFO, "**************Reviewing The Group******************");

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Group", 8, 0);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "Group", 9, 0);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA2 = Lib.getCellValue(XLPATH, "Group", 10, 0);
		RA.SetGroup(SA2);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize Button
		RA.ClickGroupFinalizeButton();

		//verifying Audit Finalized Successfully message is displayed
		RA.VerifyAuditFinalizedSuccessfullySuccessMsgIsDisplayed(driver);

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=9, dependsOnMethods= {"Finalizing_The_AuditType_Test"})
	public void Resloving_The_Issues_By_Auditee_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		IssuesPageTest IS = new IssuesPageTest(driver);

		ReviewIssuePageTest RI = new ReviewIssuePageTest(driver);

		System.out.println("Resloving The Issues By Auditee Test");

		chiledTest = parentTest.createNode("Resloving The Issues By Auditee Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 52, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 52, 1);
		l.setpassword(pw);

		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Singin Button is Clicked");

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

		IS.ClickScrollBar(driver);

		//clicking on the Issues under side menu
		IS.ClickIssues(driver);

		//passing the values to parent audit type
		String SPA = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		IS.SetSelectParentAuditType(SPA);

		IS.ClickMatched(driver);

		//clicking on the Select Issue status
		IS.ClickSelectIssueStatus();

		//Passing the Accepted under issue status
		String SS = Lib.getCellValue(XLPATH, "Issues", 47, 0);
		IS.SetIssuesStatus(SS);

		IS.ClickMatched(driver);

		//clicking on the Go button
		IS.ClickGoBTN(driver);

		//checking the Total 3 Issue CP are Displayed or not
		IS.Verify3IssuesAreDisplayed();

		// ************** Resolving CP1 Checkpoints ****************

		//Passing the CP1 to Search text fields
		String SS1 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		IS.setSearchBox(SS1, driver);

		//clicking on the View Button
		IS.ClickFirstViewBTN(driver);

		//checking Comments is Required or not
		RI.VerifyCommentIsRequiredFields();

		//Passing the Values to Comments
		String SC = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		RI.SetComments(SC);

		//clicking on the add digital evidence button
		RI.ClickAddADigitalEvidenceButton();

		//passing .pdf file
		RI.PassingPDFFile();

		//clicking on the Resolve button
		RI.clickResoveIssueButton();

		//checking Issue Updated Successfully message is displayed
		IS.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);

		// ************** Resolving CP3 Checkpoints ****************

		//Passing the CP3 to Search text fields
		String SS2 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		IS.setSearchBox(SS2, driver);

		//clicking on the View Button
		IS.ClickFirstViewBTN(driver);

		//checking Comments is Required or not
		RI.VerifyCommentIsRequiredFields();

		//Passing the Values to Comments
		String SC2 = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		RI.SetComments(SC2);

		//clicking on the add digital evidence button
		RI.ClickAddADigitalEvidenceButton();

		//passing .pdf file
		RI.PassingPDFFile();

		//clicking on the Resolve button
		RI.clickResoveIssueButton();

		//checking Issue Updated Successfully message is displayed
		IS.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);

		// ************** Resolving CP4 Checkpoints ****************

		//Passing the CP4 to Search text fields
		String SS3 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		IS.setSearchBox(SS3, driver);

		//clicking on the View Button
		IS.ClickFirstViewBTN(driver);

		//checking Comments is Required or not
		RI.VerifyCommentIsRequiredFields();

		//Passing the Values to Comments
		String SC3 = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		RI.SetComments(SC3);

		//clicking on the add digital evidence button
		RI.ClickAddADigitalEvidenceButton();

		//passing .pdf file
		RI.PassingPDFFile();

		//clicking on the Resolve button
		RI.clickResoveIssueButton();

		//checking Issue Updated Successfully message is displayed
		IS.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);

		System.out.println("**********************");
	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=10, dependsOnMethods= {"Resloving_The_Issues_By_Auditee_Test"})
	public void Issue_Significance_And_Closing_The_Issues_By_Admin_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AdminIssuePageTest AS = new AdminIssuePageTest(driver);

		System.out.println("Issue Significance And Closing The Issues By Admin Test");

		chiledTest = parentTest.createNode("Issue Significance And Closing The Issues By Admin Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Singin Button is Clicked");

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

		AS.ClickScrollBar(driver);

		//Clicking on the Issues under side menu
		AS.ClickIssues(driver);

		//passing the Values to Cluster
		String SC = Lib.getCellValue(XLPATH, "Issues", 10, 0);
		AS.SetCluster(SC);

		AS.ClickMatched(driver);

		//passing the values to parent audit type
		String SP = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		AS.SetParentauditType(SP);

		AS.ClickMatched(driver);

		//Passing Resolved status under Execution status
		String IS = Lib.getCellValue(XLPATH, "Issues", 50, 0);
		AS.SetIssueStatus(IS);

		AS.ClickMatched(driver);

		//clicking on the Go button
		AS.ClickGoButton();

		System.out.println("**Closing and adding Significance for CP4 Checkpoints***");

		chiledTest.log(Status.INFO, "**Closing and adding Significance for CP4 Checkpoints***");

		//passing CP4 to Search 
		String SS = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		AS.SetSearch(SS);
		chiledTest.log(Status.INFO, "CP4 Is Searched");

		AS.clickFirstTR();

		//Checking the Issues significance are displayed
		AS.VerifyIssueSignificanceAreDisplayed();

		//Selecting All Issue Significances
		AS.SelectAllIssueSignificances();

		//clicking on the Close issue button
		AS.ClickCloseIssueButton(driver);

		//Checking Do you want to choose the final auditee remarks for this issue ? Pop Up is Displayed
		AS.VerifyDoYouWantToChooseTheFinalAuditeeRemarksForThisIssue();

		//clicking on the No Button
		AS.ClickNoButton();

		//checking Issue is Closed success Message is Displayed
		AS.VerifyIssueIsClosedSucessMSGIsDisplayed();

		System.out.println("*****Closing and adding Significance for CP3 Checkpoints***");

		chiledTest.log(Status.INFO, "**Closing and adding Significance for CP3 Checkpoints***");

		driver.navigate().refresh();

		//passing the Values to Cluster
		String SC1 = Lib.getCellValue(XLPATH, "Issues", 10, 0);
		AS.SetCluster(SC1);

		AS.ClickMatched(driver);

		//passing the values to parent audit type
		String SP1 = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		AS.SetParentauditType(SP1);

		AS.ClickMatched(driver);

		//Passing Resolved status under Execution status
		String IS1 = Lib.getCellValue(XLPATH, "Issues", 50, 0);
		AS.SetIssueStatus(IS1);

		AS.ClickMatched(driver);

		//clicking on the Go button
		AS.ClickGoButton();

		//passing CP3 to Search 
		String SS1 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		AS.SetSearch(SS1);
		chiledTest.log(Status.INFO, "CP3 Is Searched");

		AS.clickFirstTR();

		//Checking the Issues significance are displayed
		AS.VerifyIssueSignificanceAreDisplayed();

		//Selecting All Issue Significances
		AS.SelectAllIssueSignificances();

		//clicking on the Close issue button
		AS.ClickCloseIssueButton(driver);

		//Checking Do you want to choose the final auditee remarks for this issue ? Pop Up is Displayed
		AS.VerifyDoYouWantToChooseTheFinalAuditeeRemarksForThisIssue();

		//clicking on the No Button
		AS.ClickNoButton();

		//checking Issue is Closed success Message is Displayed
		AS.VerifyIssueIsClosedSucessMSGIsDisplayed();

		System.out.println("**Closing and adding Significance for CP1 Checkpoints***");

		chiledTest.log(Status.INFO, "**Closing and adding Significance for CP1 Checkpoints***");

		driver.navigate().refresh();

		//passing the Values to Cluster
		String SC11 = Lib.getCellValue(XLPATH, "Issues", 10, 0);
		AS.SetCluster(SC11);

		AS.ClickMatched(driver);

		//passing the values to parent audit type
		String SP11 = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		AS.SetParentauditType(SP11);

		AS.ClickMatched(driver);

		//Passing Resolved status under Execution status
		String IS11 = Lib.getCellValue(XLPATH, "Issues", 50, 0);
		AS.SetIssueStatus(IS11);

		AS.ClickMatched(driver);

		//clicking on the Go button
		AS.ClickGoButton();

		//passing CP1 to Search 
		String SS2 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		AS.SetSearch(SS2);
		chiledTest.log(Status.INFO, "CP1 Is Searched");

		AS.clickFirstTR();

		//Checking the Issues significance are displayed
		AS.VerifyIssueSignificanceAreDisplayed();

		//Selecting All Issue Significances
		AS.SelectAllIssueSignificances();

		//clicking on the Close issue button
		AS.ClickCloseIssueButton(driver);

		//Checking Do you want to choose the final auditee remarks for this issue ? Pop Up is Displayed
		AS.VerifyDoYouWantToChooseTheFinalAuditeeRemarksForThisIssue();

		//clicking on the No Button
		AS.ClickNoButton();

		//checking Issue is Closed success Message is Displayed
		AS.VerifyIssueIsClosedSucessMSGIsDisplayed();

		//************Validating once the issues is closed than Significance should in read only mode for that CP***

		System.out.println("****Validating once the issues is closed than Significance should in read only mode for that CP***");

		chiledTest.log(Status.INFO, "***Validating once the issues is closed than Significance should in read only mode for that CP***");

		driver.navigate().refresh();

		//passing the Values to Cluster
		String SC12 = Lib.getCellValue(XLPATH, "Issues", 10, 0);
		AS.SetCluster(SC12);

		AS.ClickMatched(driver);

		//passing the values to parent audit type
		String SP12 = Lib.getCellValue(XLPATH, "Issue Significance", 7, 0);
		AS.SetParentauditType(SP12);

		AS.ClickMatched(driver);

		//Passing Resolved status under Execution status
		String IS12 = Lib.getCellValue(XLPATH, "Issues", 53, 0);
		AS.SetIssueStatus(IS12);

		AS.ClickMatched(driver);

		//clicking on the Go button
		AS.ClickGoButton();

		//passing CP4 to Search 
		String SS3 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		AS.SetSearch(SS3);
		chiledTest.log(Status.INFO, "CP4 Is Searched");

		AS.clickFirstTR();

		//checking the Post Closing the Issue Issue Significance are in Read only mode or not
		AS.VerifySignificanceIsDisabledOrNot();

		//checking Reopen and Close button should not show post close of issue.
		AS.VerifyReopenAndCloseButtonIsDisabled();

		System.out.println("****************************");

	}

}

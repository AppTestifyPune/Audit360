package scripts;

import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.ConfigureAuditPageTest;
import pom.LeadAuditorAllocationPageTest;
import pom.LoginPageTest;
import pom.SideMenuPageTest;

public class LeadAuditorWithGroupLevelFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=1)
	public void Creating_Parent_Audit_Type_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		parentTest = extent.createTest("Lead Auditor With Group Level Test", "Testing the Functionality of the Lead Audior with Group allocation");

		chiledTest = parentTest.createNode("Creating Parent Audit Type Test");

		System.out.println("Creating Parent Audit Type Test");

		WebDriverWait wait = new WebDriverWait(driver, 20);

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
		
        //clicking on the Scroll Bar
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
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
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
		String SCG1 = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CA.SetSelectCheckPointGroup(SCG1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG2 = Lib.getCellValue(XLPATH, "Group", 9, 0);
		CA.SetSelectCheckPointGroup(SCG2, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG3 = Lib.getCellValue(XLPATH, "Group", 10, 0);
		CA.SetSelectCheckPointGroup(SCG3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//selecting last option under Entries Fields
		CA.SetShowAndRow(driver);

		Thread.sleep(3000);
		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int Actual_CPCount = CPSixze.size();
		int Expected_CPCount = 12;
		Assert.assertEquals(Actual_CPCount, Expected_CPCount, "Check Points Count are Wrong");
		System.out.println("Displayed Total Checkpoints counts is : " + Expected_CPCount);

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* Evaluate TAB ***************************

		//Passing the Values to Low Risk Scoring
		String LR = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 76, 0);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 67, 0);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 72, 0);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 80, 0);
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
		chiledTest.log(Status.INFO, "Eliminate Auditee Sign off Toggle button is clicked");

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
		String FT = Lib.getCellValue(XLPATH, "All 3 Scoring Logic", 20, 0);
		CA.SetFirstTo(FT, driver);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "All 3 Scoring Logic", 29, 0);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Second TO
		String ST1 = Lib.getCellValue(XLPATH, "All 3 Scoring Logic", 21, 0);
		CA.SetSecondTo(ST1, driver);

		//Passing the Values to Second Out Come
		String SO = Lib.getCellValue(XLPATH, "All 3 Scoring Logic", 28, 0);
		CA.SetSecondOutCome(SO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Passing the Values to Third Out Come
		String TO1 = Lib.getCellValue(XLPATH, "All 3 Scoring Logic", 27, 0);
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
	@Test(priority=2, dependsOnMethods= {"Creating_Parent_Audit_Type_Test"})
	public void Auditee_Admin_Configuration_Test() throws InterruptedException
	{
		SideMenuPageTest SM = new SideMenuPageTest(driver);

		AuditeeadminConfigurationPageTest AA = new AuditeeadminConfigurationPageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

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

		//clicking on the Audoitee admin Configure under side menu
		SM.clickAuditeeAdminConfigure();

		AA.ClickSelectAuditType();

		//passing the values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AA.SetSetAuditType(SA);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 3, 0);
		AA.SetIssueAssignment(IA);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA1 = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 4, 0);
		AA.SetIssueAssignment(IA1);

		AA.ClickMatchedText();

		//Passing the Values to Respond issue
		String RI = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 3, 1);
		AA.SetRespondIssue(RI);

		AA.ClickMatchedText();

		//clicking on the Save button
		AA.ClickSaveBTN();

		//Verifying Auditee configuration successfully done message is Displayed
		AA.VerifyAuditeeConfigurationSuccessfullyDoneMsGIsDisplayed();

		System.out.println("******************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=3, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
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
		String SAT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
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

		//clicking on the Mutiple auditor
		SP.ClickMultipleAuditorBTN();

		///clicking on the Lead Audior
		SP.ClickIsLeadauditorCheckBox();

		//Selecting Auditor
		String MA = Lib.getCellValue(XLPATH, "Schedule", 34, 0);
		SP.SetMultipleAuditor(MA);
		chiledTest.log(Status.INFO, "HitheshAuditor is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Auditor
		String MA1 = Lib.getCellValue(XLPATH, "Schedule", 33, 0);
		SP.SetMultipleAuditor(MA1);
		chiledTest.log(Status.INFO, "AuditorTest1 is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Auditor
		String MA3 = Lib.getCellValue(XLPATH, "Schedule", 35, 0);
		SP.SetMultipleAuditor(MA3);
		chiledTest.log(Status.INFO, "AuditorTest2 is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//clicking on the Lead auditor
		SP.ClickLeadAudior();

		//Selecting the Lead Auditor
		SP.SetLeadAudior();

		//Clicking on the Save Button
		SP.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Schedule created successfully Success Message is Displayed
		SP.VerifyScheduleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Schedule created successfully. Success Message is displayed");

		System.out.println("****************************************************");

	}

	//Before lead auditor accept the schedule than Lead Auditor not accepted button should be display for remaining auditors
	@Test(priority=4, dependsOnMethods= {"Creating_Audit_Schedule_Test"})
	public void Lead_Auditor_Not_Accepted_Button_Should_Display_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Lead Auditor Not Accepted Button Should Display Test");

		System.out.println("Lead Auditor Not Accepted Button Should Display Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",43,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",43,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Verifying Lead Auditor not accepted button is Displayed
		AE.VerifyLeadAuditorNotAcceptedButtonIsDisplayed();

		System.out.println("Checking for 2nd auditor");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un1=Lib.getCellValue(XLPATH, "Login Credentials",44,0);
		l.setusername(un1);

		String pw1=Lib.getCellValue(XLPATH,"Login Credentials",44,1);
		l.setpassword(pw1);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the General Parent Audit type to Audit Type
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Verifying Lead Auditor not accepted button is Displayed
		AE.VerifyLeadAuditorNotAcceptedButtonIsDisplayed();

		System.out.println("***********************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=5, dependsOnMethods= {"Lead_Auditor_Not_Accepted_Button_Should_Display_Test"})
	public void Lead_Auditor_Allocation_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Lead Auditor Allocation Test");

		System.out.println("Lead Auditor Allocation Test");

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
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Verifying Accept button is Displayed
		AE.VerifyAcceptButtonIsDisplayed();

		//Verifying Reject button is Displayed
		AE.VerifyRejectButtonIsDisplayed();

		//Verifying Reassign button is Displayed
		AE.VerifyReassignButtonIsDisplayed();

		//Verifying Request for Extension button is Displayed
		AE.VerifyRequestForExtensionButtonIsDisplayed();

		//Verifying reschedule button is Displayed
		AE.VerifyRescheduleButtonIsDisplayed();

		//Clicking on the Accept Button
		AE.ClickAcceptBTN(driver);
		chiledTest.log(Status.INFO, "Accept Button is Clicked");

		LeadAuditorAllocationPageTest LA = new LeadAuditorAllocationPageTest(driver);

		//clicking on the Select Audit Configuration level
		LA.ClickSelectAuditConfigurationLevel();

		//Passing the Values to Audit Configuration level
		String AL = Lib.getCellValue(XLPATH, "Audit Execution", 128, 0);
		LA.SetAuditConfigurationLevel(AL);
		chiledTest.log(Status.INFO, "Group is Selected under Select Audit Configuration level");

		AE.ClickMatched();

		//****Selecting all 1st groups for 1st auditor****
		String FG1 = Lib.getCellValue(XLPATH, "Group", 8, 0);
		LA.SetFirstGroup(FG1);
		System.out.println("1st Grpup is Selected for the 1st auditor");
		chiledTest.log(Status.INFO, "1st Grpup is Selected for the 1st auditor");

		AE.ClickMatched();

		//****Selecting 2nd groups for 2nd auditor****

		String SG1 = Lib.getCellValue(XLPATH, "Group", 9, 0);
		LA.SetSecondGroup(SG1);
		System.out.println("2nd Grpup is Selected for the 2nd auditor");
		chiledTest.log(Status.INFO, "2nd Grpup is Selected for the 2nd auditor");

		AE.ClickMatched();

		//****Selecting all 3rd groups for 3rd auditor****

		String TG1 = Lib.getCellValue(XLPATH, "Group", 10, 0);
		LA.SetThirdGroup(TG1);
		System.out.println("3rd Grpup is Selected for the 3rd auditor");
		chiledTest.log(Status.INFO, "3rd Grpup is Selected for the 3rd auditor");

		AE.ClickMatched();

		//clicking on the submit button
		LA.ClickSubmitButton();

		//verifying Allocation execution successfully Message is Displayed
		LA.VerifyAllocationExecutionSuccessfullyDoneMSGIsDisplayed();

		System.out.println("*****************************");
	}


	//Executing Audit Type With Normal Mode Which Has Only Annexure Groups Test
	@Test(priority=6, dependsOnMethods= {"Lead_Auditor_Allocation_Test"})
	public void Executing_Schedule_By_1st_Auditor_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l = new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Executing Schedule By 1st Auditor Test");

		System.out.println("Executing Schedule By 1st Auditor Test");	

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		String un=Lib.getCellValue(XLPATH, "Login Credentials", 44, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 44, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		//Verifying Signed in successfully. Success Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

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

		//clicking on the No button
		AE.ClickNoButton();

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

		//Passing the Values to date
		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 43, 0);
		AE.SetEnterInputValues(IV1, driver);
		chiledTest.log(Status.INFO, "date is Entered");

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

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

		//clicking on the NA button
		AE.ClickNAButton();

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

		//clicking on the NA button
		AE.ClickNAButton();

		//selecting all dispositions
		AE.SelectingAllDispositions(driver);

		//Passing the Values to text
		String IV2 = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		AE.SetEnterInputValues(IV2, driver);
		chiledTest.log(Status.INFO, "Text is Entered");

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//post schedule is submitted also it should show In progress until unless lead auditor submit the schedule

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT3, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Verifying In progress Button is Displayed
		AE.VerifyInprogressButtonIsDisplayed();

		System.out.println("**********************");

	}

	//Executing Audit Type With Normal Mode Which Has Only Annexure Groups Test
	@Test(priority=7, dependsOnMethods= {"Executing_Schedule_By_1st_Auditor_Test"})
	public void Executing_Schedule_By_2nd_Auditor_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l = new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Executing Schedule By 2nd Auditor Test");

		System.out.println("Executing Schedule By 2nd Auditor Test");	

		WebDriverWait wait = new WebDriverWait(driver, 40);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		String un=Lib.getCellValue(XLPATH, "Login Credentials", 43, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 43, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		//Verifying Signed in successfully. Success Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickMainAuditInProgressButton();
		
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

		//clicking on the No button
		AE.ClickNoButton();

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

		//date and Range is auto selected

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

		//clicking on the NA button
		AE.ClickNAButton();

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

		//clicking on the NA button
		AE.ClickNAButton();

		//selecting all dispositions
		AE.SelectingAllDispositions(driver);

		//Passing the Values to text
		String IV2 = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		AE.SetEnterInputValues(IV2, driver);
		chiledTest.log(Status.INFO, "Text is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		
		//verifying audit submitted successfully message is displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		//post schedule is submitted also it should show In progress until unless lead auditor submit the schedule

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT3, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Verifying In progress Button is Displayed
		AE.VerifyInprogressButtonIsDisplayed();

		System.out.println("*******************************************");

	}

	//Executing Audit Type With Normal Mode Which Has Only Annexure Groups Test
	@Test(priority=8, dependsOnMethods= {"Executing_Schedule_By_2nd_Auditor_Test"})
	public void Executing_Schedule_By_Lead_Auditor_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l = new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Executing Schedule By Lead Auditor Test");

		System.out.println("Executing Schedule By Lead Auditor Test");	

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		String un=Lib.getCellValue(XLPATH, "Login Credentials", 42, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 42, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		//Verifying Signed in successfully. Success Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickMainAuditInProgressButton();

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

		//clicking on the No button
		AE.ClickNoButton();

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

		//passing the values to text and number
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

		//clicking on the NA button
		AE.ClickNAButton();

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
		chiledTest.log(Status.INFO, "Percentage is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		
		//checking audit submitted successfully message is displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("**********************************");

	}


}

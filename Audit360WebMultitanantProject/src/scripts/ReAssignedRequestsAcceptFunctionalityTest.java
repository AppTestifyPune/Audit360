package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.ConfigureAuditPageTest;
import pom.LoginPageTest;
import pom.ReassignSchedulePageTest;
import pom.SideMenuPageTest;

public class ReAssignedRequestsAcceptFunctionalityTest extends BaseTest {

	//Testing the Functionality of Creating Audit Type for Reassigning the Request Accept Test
	@Test(priority=1)
	public void Creating_Audit_Type_Test() throws InterruptedException
	{
		parentTest = extent.createTest("Re-Assign Schedule Accept Functionality Test", "Testing the Functionality of the Re-Assign Schedule List Test, Accept and Reject Request Test");

		chiledTest = parentTest.createNode("Creating Audit Type Test");

		System.out.println("Creating Audit Type Test");
		
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Audit Type Test");

		System.out.println("Creating Audit Type Test");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		LoginPageTest l=new LoginPageTest(driver);

		//Taking the User name from 'TestValidLoginPage' sheet in excel
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
		
	    //clicking on Scroll Bar Under side menu
		CA.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		CA.ClickConfigureAudit(driver);
		chiledTest.log(Status.INFO, "Configure Audit is Clicked");

		//Clicking on the configure Audit Sub menu
		CA.ClickConfigureAuditSubMenu();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Reassigned Schedule", 4, 0);
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


		//*************** Define Tab ***********************

		//Clicking on the Parent audit type Radio Button
		CA.ClickParentTypeAuditRadioBTN(driver);
		chiledTest.log(Status.INFO, "Parent audit type Radio Button is Clicked");

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* EVALUATE  TAB ***************************

		//Passing the Values to Low Risk Scroing
		String LR = Lib.getCellValue(XLPATH, "Configure Audit Type", 37, 0);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scroing
		String MR = Lib.getCellValue(XLPATH, "Configure Audit Type", 41, 0);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scroing
		String HR = Lib.getCellValue(XLPATH, "Configure Audit Type", 45, 0);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Talerance Risk Scroing
		String ZR = Lib.getCellValue(XLPATH, "Configure Audit Type", 49, 0);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Talerence Risk Scoring is Entered");

		//Clicking on the Next Button
		CA.ClickEvaluteTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = driver.switchTo().alert();
		Alert.accept();

		//******** Manage Role TAB **************

		//Clicking on the Select Roles
		CA.ClickSelectRole(driver);

		//Passing the Values to Select Roles
		String SSR = Lib.getCellValue(XLPATH, "Configure Audit Type", 54, 0);
		CA.SetSelectRole(SSR);
		chiledTest.log(Status.INFO, "Auditor Role is Selected Under Select Roles");

		CA.ClickMatch();

		//Clicking on the Go Button
		CA.ClickGoBTN(driver);
		chiledTest.log(Status.INFO, "Go Button is clicked");

		//Passing the Values to Search 
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 121, 0);
		CA.SetSearchBTN1(SB, driver);
		chiledTest.log(Status.INFO, "Auditor is Searched");

		//Clicking on the Check box
		CA.ClickCheckBox(driver);

		//Passing the Values to Search 
		String SB1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 122, 0);
		CA.SetSearchBTN1(SB1, driver);
		chiledTest.log(Status.INFO, "Auditor is Searched");

		//Clicking on the Check box
		CA.ClickCheckBox(driver);

		Thread.sleep(3000);
		//Checking the Selected User Count
		List<WebElement> SelectedUserCount = driver.findElements(By.xpath("//div[@id='s2id_selected_users']/ul/li/div"));
		int Actual_SelectedUserCount = SelectedUserCount.size();
		int Expected_SelectedUserCount = 2;
		Assert.assertEquals(Actual_SelectedUserCount, Expected_SelectedUserCount, "Selected User Count is showing Wrong");

		//clicking on the Next Button
		CA.ClickMangeRoleTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******** CONFIGURE  TAB **************


		//Clicking on the Select verifier
		CA.clickSelectVerifier();

		//Passing the Values to Select Verifier
		String SV = Lib.getCellValue(XLPATH, "Configure Audit Type", 58, 0);
		CA.SetSelectVerifier(SV);
		chiledTest.log(Status.INFO, "Verifier is Selected");

		//Clicking on the Match
		CA.ClickMatch();

		//Clicking on the Select TAT
		CA.ClickSelectTATType();

		//Passing the Values to Select TAT
		String ST1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 66, 0);
		CA.SetSelectTATType(ST1);
		chiledTest.log(Status.INFO, "Proposed By Auditee is Selected under Select TAT Type");

		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Finalize Tab ********************

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to First TO
		String FT = Lib.getCellValue(XLPATH, "Configure Audit Type", 147, 0);
		CA.SetFirstTo(FT, driver);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "Configure Audit Type", 99, 0);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Second TO
		String ST11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 148, 0);
		CA.SetSecondTo(ST11, driver);

		//Passing the Values to Second Out Come
		String SO = Lib.getCellValue(XLPATH, "Configure Audit Type", 98, 0);
		CA.SetSecondOutCome(SO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Third TO
		String TT = Lib.getCellValue(XLPATH, "Configure Audit Type", 149, 0);
		CA.SetThirdTo(TT, driver);

		//Passing the Values to Third Out Come
		String TO1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 97, 0);
		CA.SetThirdOutCome(TO1, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Passing the Values to Fourth Out Come
		String FO1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 96, 0);
		CA.SetFourthOutCome(FO1, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully. Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully. Success Message is Displayed");


		System.out.println("*********************************************************");

	}

	//Configuring the Auditee admin configuration
	@Test(priority=2, dependsOnMethods= {"Creating_Audit_Type_Test"})
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

		//clicking on the Audoitee admin Cnfigure under side menu
		SM.clickAuditeeAdminConfigure();

		AA.ClickAuditeeAdminConfigureHeader();

		AA.ClickSelectAuditType();

		//passing the values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Reassigned Schedule", 4, 0);
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

	//Testing the Functionality of the Creating Schedule For One More Reassign Audit Test
	@Test(priority=3, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Creating Schedule Audit Test");

		System.out.println("Creating Schedule Audit Test");
		
		LoginPageTest l = new LoginPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		//Verifying Signed in successfully. Success Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");
		
		SP.ClickScrollBar(driver);

		//Clicking on the Sehdule 
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
		String SAT1 = Lib.getCellValue(XLPATH, "Reassigned Schedule", 4, 0);
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

	//Testing the Functionality of the Reassign One More Audit Schedule Test
	@Test(priority=5, dependsOnMethods= {"Creating_Schedule_Test"})
	public void Reassign_Audit_Schedule_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Rassign Audit Schedule Test");

		System.out.println("Reassign Audit Schedule Test");	
		
		LoginPageTest l=new LoginPageTest(driver);

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
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
		String AT2 = Lib.getCellValue(XLPATH, "Reassigned Schedule", 4, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//clicking on the Modify Button
		AE.ClickModifyBTN(driver);
		chiledTest.log(Status.INFO, "Modify Button is Clicked");

		//Clicking on the Reassign Button
		AE.ClickReassignBTN();
		chiledTest.log(Status.INFO, "Reassign Button is Clicked");

		//Handle Request Pop Is Displayed
		AE.VerifyHandleRequestPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Handle Request Pop is Displayed");

		//Clicking on the Submit Button
		AE.ClickHandleRequestPopUpSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Checking Reason is Required Field or Not
		AE.VerifyReasonIsRequiredFiled();
		chiledTest.log(Status.INFO, "Reason is Required Field");

		//Passing the values to Reason
		String HRR = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetHandleRequestReason(HRR);
		chiledTest.log(Status.INFO, "Reason is Entered");

		//Clicking on the Submit Button
		AE.ClickHandleRequestPopUpSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Checking Reassign request placed successfully please wait for admin approval Success Message is Displayed or Not
		AE.VerifyReassignRequestPlacedSuccessfullyPleasewaitForAdminApprovalMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reassign request placed successfully please wait for admin approval Success Message is Displayed");

		System.out.println("*****************************************************");

	}

	//Testing the Functionality of the Re Assigned Requests Accept Test
	@Test(priority=5, dependsOnMethods= {"Reassign_Audit_Schedule_Test"})
	public void ReAssigned_Request_Accept_Test() throws InterruptedException
	{
		ReassignSchedulePageTest RS = new ReassignSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Reassigned Request Accept Test");

		System.out.println("Reassigned Request Accept Test");
		
		LoginPageTest l=new LoginPageTest(driver);
		
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 3, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH, "Login Credentials", 3, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");
		
		SP.ClickScrollBar(driver);

		//Clicking on the Schedule from side menu
		SP.ClickSchedule(driver);
		chiledTest.log(Status.INFO, "Schedule is Clicked");

		//Clicking on the Reassigned Schedule 
		RS.ClickReassignSchedule(driver);
		chiledTest.log(Status.INFO, "Re-assigned Schedule is Clicked");

		//Passing the Values to Select Audit Type
		String AT1 = Lib.getCellValue(XLPATH, "Reassigned Schedule", 4, 0);
		RS.SetAuditType(AT1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		RS.ClickMatched();

		//Clicking on the Accept Button
		RS.ClickAcceptButton();
		chiledTest.log(Status.INFO, "Accept Button is Clicked");

		//Verifying Are you Sure pop up Message is Displayed
		RS.VerifyAreYouSurePopUpMSGIsDisplayed1(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop up Message is Displayed");

		//Clicking on the OK Button
		RS.ClickOKButton(driver);
		chiledTest.log(Status.INFO, "OK Button is Clicked");

		System.out.println("*****************************************************************");


	}


}

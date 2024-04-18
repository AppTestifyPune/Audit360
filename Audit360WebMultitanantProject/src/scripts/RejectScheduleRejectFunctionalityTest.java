package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pom.EditSchedulePageTest;
import pom.LoginPageTest;
import pom.RejectSchedulePageTest;
import pom.SideMenuPageTest;

public class RejectScheduleRejectFunctionalityTest extends BaseTest {

	//Creating the General Group Sub Audit Type
	@Test(priority=1)
	public void Creating_Audit_Type_Test() throws InterruptedException
	{
		parentTest = extent.createTest("Reject Schedule Reject Functionality Test", "Testing the Functionality of the Reject Schedule List Test, Accept Reject Request Test and Reject Rejected Request Test");

		chiledTest = parentTest.createNode("Creating Audit Type for Rejecting the Request Test");

		System.out.println("Creating Audit Type for Rejecting the Request Test");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

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
		String ATN = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 0);
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
		Alert.dismiss();

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
		String ST = Lib.getCellValue(XLPATH, "Configure Audit Type", 66, 0);
		CA.SetSelectTATType(ST);
		chiledTest.log(Status.INFO, "Proposed By Auditee is Selected under Select TAT Type");

		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//************* Finalize Tab *******************

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
		String ST1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 148, 0);
		CA.SetSecondTo(ST1, driver);

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

		AA.ClickSelectAuditType();

		//passing the values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 0);
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

	//Testing the Functionality of the Creating Audit Schedule for General Group  AuditType Test
	@Test(priority=3, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Audit_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l = new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Audit Schedule For AuditType Test");

		System.out.println("Creating Audit Schedule For AuditType Test");

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
		String SAT1 = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 0);
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

		//SP.ClickSelectAuditorOption();
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

	//Testing the Functionality of the Reject Audit Schedule Test
	@Test(priority=4, dependsOnMethods= {"Creating_Audit_Schedule_Test"})
	public void Rejecting_Audit_Schedule_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Rejecting Audit Schedule Test");

		System.out.println("Rejecting Audit Schedule Test");	

		LoginPageTest l=new LoginPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName And Password");
		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 42, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 42, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the Genearl Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//clicking on the Modify button
		AE.ClickModifyBTN(driver);
		chiledTest.log(Status.INFO, "Modify Button is Clicked");

		//Clicking on the Reject Button
		AE.ClickRejectBTN();
		chiledTest.log(Status.INFO, "Reject Button is Clicked");

		//Handle Request Pop Is Displayed
		AE.VerifyHandleRequestPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Handle Request Pop is Displayed");

		//Clicking on the Submit Button
		AE.ClickHandleRequestPopUpSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Checking Reson is Required Field or Not
		AE.VerifyReasonIsRequiredFiled();
		chiledTest.log(Status.INFO, "Reason is Required Field");

		//Passing the values to Reason
		String HRR = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetHandleRequestReason(HRR);
		chiledTest.log(Status.INFO, "Reason is Entered");

		//Clicking on the Submit Button
		AE.ClickHandleRequestPopUpSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Checking Reject request placed successfully please wait for admin approval Success Message is Displayed or Not
		AE.VerifyRejectRequestPlacedSuccessfullyPleasewaitForAdminApprovalMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reject request placed successfully please wait for admin approval Success Message is Displayed");


		System.out.println("*****************************************************");

	}


	//Testing the Functionality of the Rejected Requests Accept Test
	@Test(priority=5, dependsOnMethods= {"Creating_Audit_Schedule_Test"})
	public void Rejecting_The_Request_By_Admin_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Request Reject Test");

		System.out.println("Request Reject Test");

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

		//Clicking on the Schedule from side menu
		SP.ClickSchedule(driver);
		chiledTest.log(Status.INFO, "Schedule is Clicked");

		//Clicking on the Reject Schedule
		RS.ClickRejectSchedule(driver);
		chiledTest.log(Status.INFO, "Reject Schedules is Clicked");

		//Passing the Values to Select Audit Type
		String AT1 = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 0);
		RS.SetAuditType(AT1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on The Matched text
		RS.ClickMatched();

		Thread.sleep(3000);

		//Checking the Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 0);
		WebElement AuditTypeName = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/tbody/tr[1]/td[3]"));
		String AuditTypeName1 = AuditTypeName.getText();
		Assert.assertEquals(ATN, AuditTypeName1, "Audit Type Name is Wrong");

		//checking Auditee Name
		String AN = Lib.getCellValue(XLPATH, "Schedule", 9, 0);
		String AuditeeName = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/tbody/tr[1]/td[4]")).getText();
		Assert.assertEquals(AN, AuditeeName, "Auditee Name is Wrong");

		//checking Execution Status
		String ES = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 3);
		String ExecuationStatus = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/tbody/tr[1]/td[6]")).getText();
		Assert.assertEquals(ES, ExecuationStatus, "ExecuationStatus is Wrong");

		//checking Schedule Status
		String SS = "Request For Reject";
		String ScheduleStatus = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/tbody/tr[1]/td[7]")).getText();
		Assert.assertEquals(SS, ScheduleStatus, "Schedule Status is Wrong");

		//Checking the Reason
		String Reason = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		String Reason1 = driver.findElement(By.xpath("//table[@id='rejectScheduleTableData']/tbody/tr[1]/td[8]")).getText();
		Assert.assertEquals(Reason, Reason1, "Reason is Wrong");

		//Clicking on the Reject Button
		RS.ClickRejectBTN();
		chiledTest.log(Status.INFO, "Reject Button is Clicked");

		//Verifying Are you Sure pop up Message is Displayed
		RS.VerifyDoYouWantToRejectThisRequestPopUpIsDisplayed(driver);

		//Clicking on the OK Button
		RS.ClickOKButton(driver);
		chiledTest.log(Status.INFO, "OK Button is Clicked");

		//Verifying Request is processed successfully. Message is Displayed or not
		RS.VerifyRequestIsProcessedsuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Request is processed successfully. Message is Displayed");

		System.out.println("*****************************************************************");

	}

	//Testing the Functionality of the Accepted Request Should not be show for the Auditor
	@Test(priority=6, dependsOnMethods= {"Rejecting_The_Request_By_Admin_Test"})
	public void Rejected_Request_Should_Show_For_The_Auditor_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);
		
		LoginPageTest l=new LoginPageTest(driver);

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
		String AT2 = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		Thread.sleep(10000);

		//Checking Accept Button 
		List<WebElement> AcceptBTN = driver.findElements(By.xpath("//a[contains(text(),'Accept')]"));
		Assert.assertTrue(AcceptBTN.size()>0, "Accept Button is Displayed");
		System.out.println("Accept Button is Displayed");

		//clicking on the modify button
		AE.ClickModifyBTN(driver);

		//Checking Reject Button 
		List<WebElement> RejectBTN = driver.findElements(By.xpath("//a[contains(text(),'Reject')]"));
		Assert.assertTrue(RejectBTN.size()>0, "Reject Button is Displayed");
		System.out.println("Reject Button is Displayed");

		//Checking Reassign Button 
		List<WebElement> ReassignBTN = driver.findElements(By.xpath("//a[contains(text(),'Reassign')]"));
		Assert.assertTrue(ReassignBTN.size()>0, "Reassign Button is Displayed");
		System.out.println("Reassign Button is Displayed");

		//Checking Edit Button 
		List<WebElement> EditBTN = driver.findElements(By.xpath("//a[contains(text(),'Edit Schedule')]"));
		Assert.assertTrue(EditBTN.size()>0, "Edit Schedule Button is Displayed");
		System.out.println("Edit Schedule Button is Displayed");

		System.out.println("****************************************************");

	}
}
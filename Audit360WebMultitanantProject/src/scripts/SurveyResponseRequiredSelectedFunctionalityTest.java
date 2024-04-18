package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import pom.MyAuditsPageTest;
import pom.SideMenuPageTest;
import pom.SurveyQuestionsPageTest;
import pom.SurveyResponsePageTest;

public class SurveyResponseRequiredSelectedFunctionalityTest extends BaseTest {
  
	//Creating the Configure Audit Type
	@Test(priority=1)
	public void Creating_Configure_Audit_Type_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		parentTest = extent.createTest("Survey Response Required Selected Test", "Testing the Functionality of Adding Questions, Auditor Satsfaction Survey, Signoff test Etc..");

		chiledTest = parentTest.createNode("Creating Configure Audit Type Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

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
		String ATN = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
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

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* EVALUATE  TAB ***************************

		//Passing the Values to Low Risk Scoring
		String LR = Lib.getCellValue(XLPATH, "Configure Audit Type", 37, 0);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "Configure Audit Type", 41, 0);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "Configure Audit Type", 45, 0);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "Configure Audit Type", 49, 0);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Tolerance Risk Scoring is Entered");

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

		//******************** Finalize Tab ************************

		Thread.sleep(4000);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "Configure Audit Type", 99, 0);
		CA.SetFirstOutCome(FO, driver);
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
	@Test(priority=2, dependsOnMethods= {"Creating_Configure_Audit_Type_Test"})
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
		String SA = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
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
	//Testing the Functionality of the Adding 10 Survey Questions Test
		@Test(priority=3, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
		public void Adding_Survey_Questions_Test() throws InterruptedException
		{
			SurveyQuestionsPageTest SQ = new SurveyQuestionsPageTest(driver);

			chiledTest = parentTest.createNode("Adding Survey Questions Test");

			System.out.println("Adding Survey Questions Test");

			//Clicking on the Auditor Survey from side menu
			SQ.ClickAuditorSurvey(driver);
			chiledTest.log(Status.INFO, "Auditor Survey is Clicked");

			//Clicking on the Survey Questions
			SQ.ClickSurveryQuestions(driver);
			chiledTest.log(Status.INFO, "Survey Questions is Clicked");

			//Clicking on the Select Audit Type
			SQ.ClickSelectAuditType();

			//Passing the Values to Select Audit Type 
			String SA = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
			SQ.SetSelectAuditType(SA);
			chiledTest.log(Status.INFO, "Audit Type is Selected");

			//Clicking on the Matched text
			SQ.ClickMatch();

			//Clicking on the Check Box's
			List<WebElement> checkBox = driver.findElements(By.xpath("//table[@id='question_table']/tbody/tr/td[1]/input[@type='checkbox']"));
			int count = checkBox.size();
			System.out.println("Total Number of CheckBox are : " + count);
			for(int i=0; i<checkBox.size(); i++)
			{
				WebElement AllCB = checkBox.get(i);
				AllCB.click();
			}

			System.out.println("All Check Box are Clicked");
			chiledTest.log(Status.INFO, "All Check Box are Clicked");

			//Clicking on the Response Required Check box
			Thread.sleep(3000);// Temprory
			SQ.ClickResponseRequiredCheckBoxBTN();
			chiledTest.log(Status.INFO, "Response Required Check box is Clicked");

			//Clicking on the Submit Button
			Thread.sleep(3000);
			SQ.ClickSubmitBTN(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//Verifying Questions added to audit type successfully Success Message is Displayed
			SQ.VeriftyQuestionsAddedToAuditTypeSuccessfullyMsgIsDisplayed(driver);
			chiledTest.log(Status.INFO, "Questions added to audit type successfully Success Message is Displayed");

			System.out.println("******************************************");

		}



	//Testing the Functionality of the Audit Schedule List page
	@Test(priority=4, dependsOnMethods= {"Adding_Survey_Questions_Test"})
	public void Audit_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Audit Schedule Test");

		System.out.println("Audit Schedule Test");

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
		String SAT = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
		SP.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Vendor Option Under Select Auditee Type Drop Down List
		SP.ClickVendorOption(driver);

		//Clicking on the Select country/State/Location
		SP.ClickSelectCountryStateLocation(driver);

		//Passing the Values to Select country/State/Location
		String CSL = Lib.getCellValue(XLPATH, "Schedule", 6, 0);
		SP.SetCountryStateLocation(CSL, driver);
		chiledTest.log(Status.INFO, "Country/State/Location is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Select Auditee
		SP.ClickSelectAuditee(driver);

		//Passing the Values to Select Auditee
		String SA = Lib.getCellValue(XLPATH, "Schedule", 9, 0);
		SP.SetSelectAuditeeText(SA, driver);
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
		String SA1 = Lib.getCellValue(XLPATH, "Schedule", 33, 0);
		SP.SetSetSelectAuditor(SA1);
		chiledTest.log(Status.INFO, "Auditor is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Save Button
		SP.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Schedule created successfully Success Message is Displayed
		SP.VerifyScheduleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Schedule created successfully. Success Message is displayed");

		System.out.println("***********************************");

	}

	//Testing the Functionality of the Audit Execution
	@Test(priority=5, dependsOnMethods= {"Audit_Schedule_Test"})
	public void Executing_The_Audit_Type_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Executing the Audit Type Test");

		System.out.println("Executing the Audit Type Test");

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
		String AT2 = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Accept Button
		AE.ClickAcceptBTN(driver);
		chiledTest.log(Status.INFO, "Accept Button is Clicked");

		//Verifying Audit accepted successfully Success Message is Displayed
		AE.VerifyAuditAcceptedSuccesfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit accepted succesfully Success Message is Displayed");

		driver.navigate().refresh();

		System.out.println("************** Executing the Audit Type*****************");

		chiledTest.log(Status.INFO, "************** Executing the Audit Type*****************");

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the Not Started Button
		AE.ClickNotStartedBTN(driver);
		chiledTest.log(Status.INFO, "Not Started Button is Clicked");

		//Clicking on the Normal Button
		AE.Clicknormal(driver);

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);
		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER11);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidently Remarks
		String ECR11 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR11);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Partial *********************************************

		//Clicking on the Partial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partial Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying Partial Dispositions are Displayed or Not
		AE.VerifyingPartialDispositions(driver);
		chiledTest.log(Status.INFO, "Partial Dispostions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER12 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER12);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidently Remarks
		String ECR12 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR12);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data);
		String Data1 = Data.toLowerCase();

		String Data2 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		System.out.println("Entered Input Data is : "+ Data2);

		Assert.assertEquals(Data2, Data1);

		//Passing the Values to input Values Text Filed
		String IV = Lib.getCellValue(XLPATH, "Audit Execution", 42, 0);
		AE.SetEnterInputValues(IV, driver);
		chiledTest.log(Status.INFO, "input Values is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER23 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER23);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidently Remarks
		String ECR23 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR23);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Yes Button *********************************************

		//Clicking on the Yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying Yes Dispositions are Displayed 
		AE.VerifyingYesDispositions(driver);
		chiledTest.log(Status.INFO, "Yes Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input11 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input11);
		String Input12 = Input11.toLowerCase(); 

		String Input13 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		Assert.assertEquals(Input12, Input13);

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER34 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER34);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidently Remarks
		String ECR34 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR34);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying No Dispositions are Displayed
		AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "No Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Checking the Input Values 
		String Input22 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input22);
		String Input23 = Input22.toLowerCase();

		String Input24 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input23, Input24);

		//Passing the Values to Input Text fields
		String IV4 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV4, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("*****************************************");

	}

	//Testing the Functionality of the Without Auditor Satisfaction Survey Signoff Test
	@Test(priority=6, dependsOnMethods= {"Executing_The_Audit_Type_Test"})
	public void Signoff_Audit_Without_Auditor_Satisfaction_Survey_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("Signoffing The Audit Without Auditor Satisfaction Survey Test");

		System.out.println("Signoffing The Audit Without Auditor Satisfaction Survey Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",52,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",52,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		String SA = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
		MA.SetSelectAuditType(SA);
		chiledTest.log(Status.INFO, "Valid Audit type is Entered");

		MA.ClickMatched();

		MA.ClickfirstAuditType(driver);

		//Checking the sign off Button is disabled
	//	List<WebElement> SignoffBTN = driver.findElements(By.xpath("//a[@class='btn btn-primary btn-block signing_off finalize_report'][@disabled='disabled']"));
	//#SM Modified	
		List<WebElement> SignoffBTN = driver.findElements(By.xpath("//a[@class='btn btn-primary btn-block signing_off finalize_report'][@data-subject='Are you sure you want to sign off this audit ?']"));
	
		Assert.assertTrue(SignoffBTN.size()>0, "Sign off Button is not disabled");
		System.out.println("Sign off Button is disabled");
		chiledTest.log(Status.INFO, "Sign off Button is disabled");

		//Clicking on the Auditor Satisfaction Survey Button
		//#SM# Select Check box first 
		
		
		
		MA.ClickAuditorSatisfactionSurveyBTN();
		chiledTest.log(Status.INFO, "Auditor Satisfaction Survey Button is Clicked");

		//clicking on the Submit Survey Button
		MA.ClickSubmitSurveyBTN(driver);
		chiledTest.log(Status.INFO, "Submit Survey Button is Clicked");

		//Verifying Please complete the survey Validation Message is Displayed
		MA.VerifyPleaseCompleteTheSurveyValidationMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Please complete the survey Validation Message is Displayed");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[1]/span[2]/span[1]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[2]/span[2]/span[2]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[3]/span[2]/span[3]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[4]/span[2]/span[4]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[5]/span[2]/span[5]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[6]/span[2]/span[1]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[7]/span[2]/span[2]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[8]/span[2]/span[3]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[9]/span[2]/span[4]/input")).click();

		driver.findElement(By.xpath("//form[@id='new_audit_type_survey_response']/div[10]/span[2]/span[5]/input")).click();

		//clicking on the Submit Survey Button
		MA.ClickSubmitSurveyBTN(driver);
		chiledTest.log(Status.INFO, "Submit Survey Button is Clicked");

		//Verifying Responses added successfully Message is Displayed
		MA.VerifyResponsesAddedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Responses added successfully Message is Displayed");

		System.out.println("************************************************");
	}

//	
	//Testing the Functionality of the View Response Test
	@Test(priority=7,dependsOnMethods= {"Signoff_Audit_Without_Auditor_Satisfaction_Survey_Test"} )
	public void View_Survey_Responses_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		SurveyResponsePageTest SR = new SurveyResponsePageTest(driver);

		chiledTest = parentTest.createNode("View Survey Responses Test");

		System.out.println("View Survey Responses Test");

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

		//Clicking on the Auditor Survey from side menu
		SR.ClickAuditorSurvey(driver);
		chiledTest.log(Status.INFO, "Auditor Suvery is Clicked Under Side menu");

		//Clicking on the Survey Responses
		SR.ClickSurveryResponses(driver);
		chiledTest.log(Status.INFO, "Suvery Responses is Clicked");

		//Passing the Values to Select Audit Type
		String AT = Lib.getCellValue(XLPATH, "Survey Questions", 5, 0);
		SR.SetSelectAuditType(AT);
		chiledTest.log(Status.INFO, "Select Audit Type is Searched");

		SR.ClickMatched();
		
		Thread.sleep(3000);//#SM
		driver.findElement(By.xpath("//button[@class='btn btn-primary pull-left audit_question_search']")).click();
		Thread.sleep(3000);//#SM
		
		SR.ClickViewBTN(driver);
		chiledTest.log(Status.INFO, "View Button is Clicked");

		//Checking Survey Response Page is Displayed
		SR.VerifyViewSurveyResponsePageIsDisplayed(driver);

		System.out.println("********************************************");
	}

}

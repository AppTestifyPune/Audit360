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
import pom.AnnexurePageTest;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.ConfigureAuditPageTest;
import pom.LoginPageTest;
import pom.MyAuditsPageTest;
import pom.ReAuditPageTest;
import pom.ReviewAuditPageTest;
import pom.SideMenuPageTest;
import pom.UploadAnnexureDocumentPageTest;

public class ReAuditWithSubAuditsFunctionalityTest extends BaseTest {

	//Creating the General Group Sub Audit Type
	@Test(priority=1)
	public void Creating_General_Sub_Audit_Type_Test() throws InterruptedException
	{
		parentTest = extent.createTest("Reaudit Functionality Test", "Testing the Functionality of Reaudit button");

		System.out.println("Creating General Sub Audit Type Test");

		chiledTest = parentTest.createNode("Creating General Sub Audit Type Test");

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
		String ATN2 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0);
		CA.SetAuditTypeName(ATN2, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT2, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();


		//*************** Define Tab ***********************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT1);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG1 = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CA.SetSelectCheckPointGroup(SCG1, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("****************************************************************");

	}

	//Creating the Annexure Group Sub Audit Type
	@Test(priority=2, dependsOnMethods= {"Creating_General_Sub_Audit_Type_Test"})
	public void  Creating_Static_Annexure_Sub_Audit_Type() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Static Annexure Sub Audit Type Test");

		System.out.println("Creating Static Annexure Sub Audit Type Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		CA.SetAuditTypeName(ATN2, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT2, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();


		//*************** Define Tab ***********************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 28, 0);
		CA.SetSelectGrouptype(SGT1);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG1 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		CA.SetSelectCheckPointGroup(SCG1, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("****************************************************************");

	}

	//Creating the Dynamic Annexure Sub Audit Type
	@Test(priority=3, dependsOnMethods= {"Creating_Static_Annexure_Sub_Audit_Type"})
	public void  Creating_Dynamic_Annexure_Sub_Audit_Type() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Dynamic Annexure Sub Audit Type Test");

		System.out.println("Creating Dynamic Annexure Sub Audit Type Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		CA.SetAuditTypeName(ATN2, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT2, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();


		//*************** Define Tab ***********************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 28, 0);
		CA.SetSelectGrouptype(SGT1);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		CA.SetSelectCheckPointGroup(SCG1, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("****************************************************************");

	}

	//Testing the Functionality Creating Parent Audit Type Test
	@Test(priority=4, dependsOnMethods= {"Creating_Dynamic_Annexure_Sub_Audit_Type"})
	public void Creating_Parent_Audit_Type_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Parent Audit Type Test");

		System.out.println("Creating Parent Audit Type Test");

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		SoftAssert SoftAssertion = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
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


		//******* DEFINE TAB *****************************

		//Clicking on the Parent Type Audit Radio Button
		CA.ClickParentTypeAuditRadioBTN(driver);
		chiledTest.log(Status.INFO, "Parent audit type Radio Button is Clicked");

		//Clicking on the Sub Audit Type Radio Button
		CA.ClickSubAuditTypeRadioBTN();
		chiledTest.log(Status.INFO, "Sub Audit Type Radio Button is Clicked");

		//Clicking on the select Group type
		String SA1 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0);
		CA.SetSelectSubAudittype(SA1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA2 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		CA.SetSelectSubAudittype(SA2, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA3 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		CA.SetSelectSubAudittype(SA3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();


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

		//Passing the Values to Zero Talerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "Configure Audit Type", 49, 0);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Talerence Risk Scoring is Entered");

		//Clicking on the Next Button
		CA.ClickEvaluteTabNextButton();


		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = wait.until(ExpectedConditions.alertIsPresent());
		String Actual_AlertText = Alert.getText();
		String Expected_AlertText = "Would you like to configure Roles for this Audit Type?";
		SoftAssertion.assertEquals(Actual_AlertText, Expected_AlertText, "Alert Text is Wrong");
		Alert.dismiss();

		//******** CONFIGURE  TAB **************

		//Clicking on the Do you need to eliminate auditee sign off ? Toggle Button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need to eliminate auditee sign off ? Toggle Button is Enabled");

		//enabling annexure scoring toggle button
		CA.ClickAnnexureScoreTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need annexure scoring toggle button is Enabled");

		//enabling Annexure sampling toggle button
		CA.ClickAnnexureSamplingTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need annexure Ampling toggle button is Enabled");

		//enabling the Additional Info Toggle button
		//CA.ClickAdditionalInfoToggleBTN();

		//adding the 12 types of Parameters
		//CA.AddingAdditionalParameters();

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

		//Clicking on the Frequency
		CA.ClickFrequency(driver);

		//Passing the Values to Frequency
		String SF = Lib.getCellValue(XLPATH, "Configure Audit Type", 103, 0);
		CA.SetFrequency(SF);
		chiledTest.log(Status.INFO, "Frequency is Selected");

		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();


		// ************** Finalize Tab *********************

		Thread.sleep(5000);

		//Checking Total Count
		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		double d = 450.0;
		String Str = Double.toString(d);
		Assert.assertEquals(TotalScoreCount, Str, "Total Score count is showing Wrong");

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

		System.out.println("**************************************************************");

	}

	//Testing the Functionality Uploading the Annexure Document
	@Test(priority=5, dependsOnMethods= {"Creating_Parent_Audit_Type_Test"})
	public void Uploading_The_Annexure_Documents_Test() throws InterruptedException
	{

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Uploading The Annexure Documents Test");

		System.out.println("Uploading The Annexure Documents Test");

		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		AnnexurePageTest AT = new AnnexurePageTest(driver);

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

		UA.ClickScrollBar(driver);

		//Clicking on the Annexure
		AT.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annexure is Clicked from Side Menu");

		UA.ClickAnnexureDocuments(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents is Clicked");

		System.out.println("*********Uploading the Annexure Document for Static Annexure*******************");

		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Static Annexure*******************");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Hithesh Static Annexure Sub Audit Type')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Uploading Documnets
		UA.UploadDocument();
		chiledTest.log(Status.INFO, "Document is Uploaded");

		//Clicking on the submit Button
		UA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Document Uploaded Successfully Message is Displayed 
		UA.VerifyDocumentUploadedSuccessfully(driver);
		chiledTest.log(Status.INFO, "Document Uploaded Successfully Message is Displayed");

		System.out.println("*********Uploading the Annexure Document for Dyanamic Annexure*******************");


		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Dyanamic Annexure*******************");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA1 = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		UA.SetAuditType(SA1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Hithesh Dynamic Annexure Sub Audit Type')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Passing the values to From Date
		String FD = Lib.getCellValue(XLPATH, "Annexure Documents", 3, 0);
		UA.SetFromDate(FD, driver);
		chiledTest.log(Status.INFO, "From Date is Entered");

		//Passing the values to From Date
		String TD = Lib.getCellValue(XLPATH, "Annexure Documents", 4, 0);
		UA.SetToDate(TD, driver);
		chiledTest.log(Status.INFO, "TO Date is Entered");

		//Uploading Documents
		UA.UploadDocument();
		chiledTest.log(Status.INFO, "Document is Uploaded");

		//Clicking on the submit Button
		UA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Document Uploaded Successfully Message is Displayed 
		UA.VerifyDocumentUploadedSuccessfully(driver);
		chiledTest.log(Status.INFO, "Document Uploaded Successfully Message is Displayed");

		System.out.println("*************************************************************************");

	}

	//Testing the Functionality of the Validating The Uploaded Documents Test
	@Test(priority=6, dependsOnMethods= {"Uploading_The_Annexure_Documents_Test"})
	public void Validating_The_Uploaded_Documents_Test() throws InterruptedException
	{
		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Validating The Uploaded Documnets Test");

		System.out.println("Validating The Uploaded Documnets Test");

		//Passing the Values to Sub Audit Type
		String SA = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		UA.SetSubAuditType(SA, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the No Of Files Uploaded 
		UA.ClickNOofFiles(driver);
		chiledTest.log(Status.INFO, "No Of Files Uploaded Link");

		//Verify File Uploaded Page is Displayed or Not
		UA.VerifyFilesUploadedPageIssDisplayed(driver);
		chiledTest.log(Status.INFO, "No Error Files and Proccess Status is Displayed");

		driver.navigate().refresh();

		//Passing the Values to Sub Audit Type
		String SA1 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		UA.SetSubAuditType(SA1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the No Of Files Uploaded 
		UA.ClickNOofFiles(driver);
		chiledTest.log(Status.INFO, "No Of Files Uploaded Link");

		//Verify File Uploaded Page is Displayed or Not
		UA.VerifyFilesUploadedPageIssDisplayed(driver);
		chiledTest.log(Status.INFO, "No Error Files and Proccess Status is Displayed");

		driver.navigate().refresh();

		System.out.println("**************************************");

	}


	//Configuring the Auditee admin configuration
	@Test(priority=7, dependsOnMethods= {"Validating_The_Uploaded_Documents_Test"})
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
		String SA = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
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
	@Test(priority=8, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Schedule_For_AuditType() throws InterruptedException
	{
		chiledTest = parentTest.createNode("Creating Schedule For Audit Type Test");

		System.out.println("Creating Schedule For Audit Type Test");

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

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
		String SAT = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
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

		System.out.println("******************************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=9, dependsOnMethods= {"Creating_Schedule_For_AuditType"})
	public void Executing_The_AuditType_Test() throws InterruptedException
	{

		chiledTest = parentTest.createNode("Executing Audit Type Test");

		System.out.println("Executing Audit Type Test");

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

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

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
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

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		System.out.println("************** Executing the Genral Audit Type*****************");

		chiledTest.log(Status.INFO, "************** Executing the Genral Audit Type*****************");

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0); 
		AE.SetSearchBTN(SB1);

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		AE.Clicknormal(driver);

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER11);

		//Passing the Values to Enter confidential Remarks
		String ECR11 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR11);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Partial *********************************************

		//Clicking on the Partial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partial Button is Clicked");

		//checking only 6 Parameters are Required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying Partial Dispositions are Displayed or Not
		AE.VerifyingPartialDispositions(driver);
		chiledTest.log(Status.INFO, "Partial Dispostions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER12 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER12);

		//Passing the Values to Enter confidential Remarks
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

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER23 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER23);


		//Passing the Values to Enter confidential Remarks
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

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER34 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER34);

		//Passing the Values to Enter confidential Remarks
		String ECR34 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR34);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//Checking only 6 Parameters are reuired
		//AE.VerifyOnly6AParametersAreRequired();

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

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");


		System.out.println("*********************Executing 1st Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 1st Sub Audit Group Under Static Annexure*********************");

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		AE.SetSearchBTN(SB11);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Passing the Values to Search Button
		String SB4 = Lib.getCellValue(XLPATH, "Configure Audit Type", 135, 0);
		AE.SetSearchBTN(SB4);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER113 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER113);

		//Passing the Values to Enter confidential Remarks
		String ECR113 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR113);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NO *********************************************

		//Clicking on the No Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//checking only 6 Parameters are required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify No Dispositions
		//AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER123 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123);

		//Passing the Values to Enter confidential Remarks
		String ECR123 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data3 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data3);
		String Data4 = Data3.toLowerCase();

		String Data5 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data5);

		Assert.assertEquals(Data4, Data5);

		//Selecting the 1st values under values drop down list
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is Selected");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER234 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234);

		//Passing the Values to Enter confidential Remarks
		String ECR234 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR234);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Partial Button *********************************************

		//Clicking on the Patial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partail Button is Clicked");

		//checking the only 6 parameters are requitred
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying Partial Dispositions are Displayed
		AE.VerifyingPartialDispositions(driver);
		chiledTest.log(Status.INFO, "Partial Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input4 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input4);
		String Input5 = Input4.toLowerCase(); 

		//Passing the Values to Percentage
		String Input6 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);

		Assert.assertEquals(Input5, Input6);

		//Passing the Values to Input
		String IV5 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV5, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER345 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345);

		//Passing the Values to Enter confidential Remarks
		String ECR345 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//checking only 6 parameters are required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NO Dispositions are Displayed
		//AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input7 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input7);
		String Input8 = Input7.toLowerCase();

		String Input9 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input9, Input8);

		//Passing the Values to Input Text fields
		String IV6 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV6, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");


		System.out.println("*********************Executing 2nd Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 2nd Sub Audit Group Under Static Annexure*********************");

		//Passing the Values to Search Button
		String SB5 = Lib.getCellValue(XLPATH, "Configure Audit Type", 136, 0);
		AE.SetSearchBTN(SB5);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER1131 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER1131);


		//Passing the Values to Enter confidential Remarks
		String ECR1131 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1131);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting NA *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify NA Dispositions
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER1231 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER1231);


		//Passing the Values to Enter confidential Remarks
		String ECR1231 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR1231);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//Checking the Data Type 
		String Data31 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data31);
		String Data41 = Data31.toLowerCase();

		String Data51 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data51);

		Assert.assertEquals(Data41, Data51);

		//Selecting the 1st values under values drop down list
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2341 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER2341);


		//Passing the Values to Enter confidential Remarks
		String ECR2341 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR2341);
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
		String Input41 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input41);
		String Input51 = Input41.toLowerCase(); 

		String Input61 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);

		Assert.assertEquals(Input51, Input61);

		//Passing the Values to Input
		String IV51 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV51, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER3451 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER3451);


		//Passing the Values to Enter confidential Remarks
		String ECR3451 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR3451);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//checking only 6 parameters are required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NO Dispositions are Displayed
		//AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input71 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input71);
		String Input81 = Input71.toLowerCase();

		String Input91 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input91, Input81);

		//Passing the Values to Input Text fields
		String IV61 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV61, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("***********Executing 3rd Sub Audit Type under Static Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 3rd Sub Audit Type under Static Annexure Group ***************");

		//Passing the Values to Search Button
		String SB51 = Lib.getCellValue(XLPATH, "Configure Audit Type", 137, 0);
		AE.SetSearchBTN(SB51);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);


		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);


		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR);

		AE.ClickMatched();

		//Passing the Values to Reason
		String NFR1 = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetNOTFoundReason(NFR1);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***********Executing 4th Sub Audit Type under Static Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 4th Sub Audit Type under Static Annexure Group ***************");

		driver.navigate().refresh();

		//Passing the Values to Search Button
		String SB6 = Lib.getCellValue(XLPATH, "Configure Audit Type", 138, 0);
		AE.SetSearchBTN(SB6);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);


		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR2 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR2);

		AE.ClickMatched();

		//Passing the Values to Reason
		String NFR2 = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetNOTFoundReason(NFR2);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("*******************Adding new PI ********************");


		chiledTest.log(Status.INFO, "*****************Adding new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");

		System.out.println("*******************Adding one more new PI ********************");

		chiledTest.log(Status.INFO, "*****************Adding one More new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN1 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPrimaryIdentifierName(PIN1, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");

		System.out.println("********* Executing Added new PI's *************");

		//Passing the Values to Search Text Filed
		String SB7 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0); 
		AE.SetPiSearchBTN(SB7);

		//Clicking on the Started Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Verifying Choose Execution Type Pop Up Is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose Execution Type Pop Up Is Displayed");

		//Clicking on the Normal Mode
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Mode is Clicked");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11311 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER11311);

		//Passing the Values to Enter confidential Remarks
		String ECR11311 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR11311);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting yes *********************************************

		//Clicking on the yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify Yes Dispositons
		AE.VerifyingYesDispositions(driver);
		chiledTest.log(Status.INFO, "Yes Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER12311 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER12311);


		//Passing the Values to Enter confidential Remarks
		String ECR12311 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR12311);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//Checking the Data Type 
		String Data311 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data311);
		String Data411 = Data311.toLowerCase();

		String Data511 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data511);

		Assert.assertEquals(Data411, Data511);

		//Selecting the 1st values under values drop down list
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER23411 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER23411);


		//Passing the Values to Enter confidential Remarks
		String ECR23411 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR23411);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Partail Button *********************************************

		//Clicking on the Partial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partail Button is Clicked");

		//checking only 6 parameters are required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying Partial Dispositions are Displayed
		AE.VerifyingPartialDispositions(driver);
		chiledTest.log(Status.INFO, "Partial Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input411 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input411);
		String Input511 = Input411.toLowerCase(); 

		String Input611 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);

		Assert.assertEquals(Input511, Input611);

		//Passing the Values to Input
		String IV511 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV511, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER34511 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER34511);


		//Passing the Values to Enter confidential Remarks
		String ECR34511 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR34511);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NA Button *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NA Dispositions are Displayed
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Data Type values
		List<WebElement> DataType = driver.findElements(By.xpath("//div[@class='form-group form-group-default']/span[@class='data_type_name']"));
		int DataTypesize = DataType.size();
		Assert.assertTrue(DataTypesize>0, "date_and_range is Displayed");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("******* Executing another newly Added PI ********");

		chiledTest.log(Status.INFO, "******* Executing another newly Added PI ********");

		//Passing the Values to Search Button
		String SB71 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPiSearchBTN(SB71);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);


		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);


		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR4 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR4);

		AE.ClickMatched();

		//Entering the Reason
		//Passing the Values to Reason
		String NFR3 = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetNOTFoundReason(NFR3);


		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		driver.navigate().refresh();

		//Clicking on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		System.out.println("**************Executing Dynamic Annexure Group*******************");

		chiledTest.log(Status.INFO, "**************Executing Dynamic Annexure Group*******************");

		//Passing the Values to Search Text Filed
		String SB41 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		AE.SetSearchBTN(SB41);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		System.out.println("*********************Executing 1st Sub Audit Group Under dynamic Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 1st Sub Audit Group Under Dynamic Annexure*********************");

		//Passing the Values to Search Button
		String SB141 = Lib.getCellValue(XLPATH, "Configure Audit Type", 135, 0);
		AE.SetSearchBTN(SB141);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER143 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER143);


		//Passing the Values to Enter confidential Remarks
		String ECR1431 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1431);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting NO *********************************************

		//Clicking on the No Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//Checking only 6 Parameters are Requird
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify No Dispositons
		//AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER123111 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123111);

		//Passing the Values to Enter confidential Remarks
		String ECR123111 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data3111 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data3111);
		String Data4111 = Data3111.toLowerCase();

		String Data5111 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data5111);

		Assert.assertEquals(Data4111, Data5111);

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER234111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234111);

		//Passing the Values to Enter confidential Remarks
		String ECR234111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR234111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Partial Button *********************************************

		//Clicking on the Partial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partail Button is Clicked");

		//checking only 6 Parameters are Required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying Partial Dispositions are Displayed
		AE.VerifyingPartialDispositions(driver);
		chiledTest.log(Status.INFO, "Partial Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input4111 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input4111);
		String Input5111 = Input4111.toLowerCase(); 

		//Passing the Values to Percentage
		String Input6111 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		Assert.assertEquals(Input5111, Input6111);

		//Passing the Values to Input
		String IV5111 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV5111, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER345111 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345111);

		//Passing the Values to Enter confidential Remarks
		String ECR345111 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//checking only 6 parameters are required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NO Dispositions are Displayed
		//AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input711 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input711);
		String Input811 = Input711.toLowerCase();

		String Input911 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input911, Input811);

		//Passing the Values to Input Text fields
		String IV611 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV611, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("*********************Executing 2nd Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 2nd Sub Audit Group Under Static Annexure*********************");

		//Passing the Values to Search Button
		String SB511 = Lib.getCellValue(XLPATH, "Configure Audit Type", 136, 0);
		AE.SetSearchBTN(SB511);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER113111 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER113111);

		//Passing the Values to Enter confidential Remarks
		String ECR113111 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR113111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NA *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify NA Dispositons
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER1231111 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER1231111);


		//Passing the Values to Enter confidential Remarks
		String ECR1231111 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR1231111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data31111 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data31111);
		String Data41111 = Data31111.toLowerCase();

		String Data51111 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data51111);

		Assert.assertEquals(Data41111, Data51111);

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2341111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER2341111);


		//Passing the Values to Enter confidential Remarks
		String ECR2341111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR2341111);
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
		String Input41111 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input41111);
		String Input51111 = Input41111.toLowerCase(); 

		String Input61111 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		Assert.assertEquals(Input51111, Input61111);

		//Passing the Values to Input
		String IV51111 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV51111, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER3451111 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER3451111);


		//Passing the Values to Enter confidential Remarks
		String ECR3451111 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR3451111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//checking only 6 parameters are required
		//AE.VerifyOnly6AParametersAreRequired();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NO Dispositions are Displayed
		//AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input7111 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input7111);
		String Input8111 = Input7111.toLowerCase();

		String Input9111 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input9111, Input8111);

		//Passing the Values to Input Text fields
		String IV6111 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV6111, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("***********Executing 3rd Sub Audit Type under Static Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 3rd Sub Audit Type under Static Annexure Group ***************");

		//Passing the Values to Search Button
		String SB711 = Lib.getCellValue(XLPATH, "Configure Audit Type", 137, 0);
		AE.SetSearchBTN(SB711);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);


		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);


		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR6 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR6);

		AE.ClickMatched();

		//Passing the Values to Reason
		String NFR4 = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetNOTFoundReason(NFR4);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***********Executing 4th Sub Audit Type under Static Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 4th Sub Audit Type under Static Annexure Group ***************");

		driver.navigate().refresh();

		//Passing the Values to Search Button
		String SB61 = Lib.getCellValue(XLPATH, "Configure Audit Type", 138, 0);
		AE.SetSearchBTN(SB61);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);


		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);


		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR8 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR8);

		AE.ClickMatched();

		//Entering the Reason
		String NFR5 = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetNOTFoundReason(NFR5);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("*******************Adding new PI ********************");
		chiledTest.log(Status.INFO, "*****************Adding new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN11 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN11, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");

		System.out.println("*******************Adding one more new PI ********************");

		chiledTest.log(Status.INFO, "*****************Adding one More new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN12 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPrimaryIdentifierName(PIN12, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");

		System.out.println("********* Executing Added new PI's *************");

		//Passing the Values to Search Text Filed
		String SB171 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0); 
		AE.SetPiSearchBTN(SB171);

		//Clicking on the Started Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Verifying Choose Execution Type Pop Up Is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose Execution Type Pop Up Is Displayed");

		//Clicking on the Normal Mode
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Mode is Clicked");

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER113121 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER113121);


		//Passing the Values to Enter confidential Remarks
		String ECR113121 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR113121);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting yes *********************************************

		//Clicking on the yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify Yes Dispositons
		AE.VerifyingYesDispositions(driver);
		chiledTest.log(Status.INFO, "Yes Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER123121 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123121);


		//Passing the Values to Enter confidential Remarks
		String ECR123121 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123121);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data3121 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data3121);
		String Data4121 = Data3121.toLowerCase();

		String Data5121 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data5121);

		Assert.assertEquals(Data4121, Data5121);

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER23411111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER23411111);


		//Passing the Values to Enter confidential Remarks
		String ECR23411111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR23411111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting Partail Button *********************************************

		//Clicking on the Partial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partail Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//checking only 6 parameters are required
		//AE.VerifyOnly6AParametersAreRequired();

		//Verifying Partial Dispositions are Displayed
		AE.VerifyingPartialDispositions(driver);
		chiledTest.log(Status.INFO, "Partial Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input4121 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input4121);
		String Input5121 = Input4121.toLowerCase(); 

		//Passing the Values to Percentage
		String Input6121 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		Assert.assertEquals(Input5121, Input6121);

		//Passing the Values to Input
		String IV5121 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV5121, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER345121 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345121);


		//Passing the Values to Enter confidential Remarks
		String ECR345121 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345121);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting NA Button *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NA Dispositions are Displayed
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Data Type values
		List<WebElement> DataType2 = driver.findElements(By.xpath("//div[@class='form-group form-group-default']/span[@class='data_type_name']"));
		int DataTypesize2 = DataType2.size();
		Assert.assertTrue(DataTypesize2>0, "date_and_range is Displayed");

		//Passing the 12 Parameters values 
		//AE.Set12ParametersValues();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("******* Executing another newly Added PI ********");

		chiledTest.log(Status.INFO, "******* Executing another newly Added PI ********");

		//Passing the Values to Search Button
		String SB721 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPiSearchBTN(SB721);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR10 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR10);

		AE.ClickMatched();

		//Passing the Values to Reason
		String NFR6 = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetNOTFoundReason(NFR6);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		//Clicking on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Passing the Values to Audit Level Recommendation
		String AR = Lib.getCellValue(XLPATH, "Audit Execution", 115, 0);
		AE.SetAuditLevelRecommendation(AR);

		//Passing the Values to Audit Level Observation
		String AO = Lib.getCellValue(XLPATH, "Audit Execution", 118, 0);
		AE.SetAuditLevelObservations(AO);

		//Clicking on the Submit Audit Button
		AE.ClickSubmitAuditBTN(driver);
		chiledTest.log(Status.INFO, "Submit Audit Button is Clicked");

		//Verifying Submitted successfully success Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Submitted successfully success Message is Displayed");

		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=10, dependsOnMethods= {"Executing_The_AuditType_Test"}, enabled=false)
	public void SignOff_Audit_Test() throws InterruptedException
	{
		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("SignOff Audits Test");

		System.out.println("SignOff Audits Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 52, 0);	
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 52, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the Value to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		MA.SetSelectAuditType(SA);
		chiledTest.log(Status.INFO, "Parent Audit is Searched");

		MA.ClickMatched();

		//Clicking on the First Audit Type
		MA.ClickfirstAuditType(driver);

		System.out.println("************Singoffing the General Sub Audit Type************");

		chiledTest.log(Status.INFO, "***********Singoffing the General Sub Audit Type************");

		//Passing the Values to search Text Box
		String SB = Lib.getCellValue(XLPATH, "ReAudit", 3, 0);
		MA.SetSearchButton(SB);
		chiledTest.log(Status.INFO, "General Sub Audit Is Searched");

		//Clicking on the First Audit Type
		MA.ClickfirstAuditType(driver);

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Passing the values to due Date
		String DD = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		System.out.println("************Singoffing the Static Sub Audit Type************");

		chiledTest.log(Status.INFO, "***********Singoffing the Static Sub Audit Type************");

		//Passing the Values to search Text Box
		String SB1 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		MA.SetSearchButton(SB1);
		chiledTest.log(Status.INFO, "General Sub Audit Is Searched");

		Thread.sleep(2000);
		//Clicking on the Engine101 Sub Auditee
		driver.findElement(By.xpath("//td[text()='Engine101']")).click();

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Passing the values to due Date
		String DD1 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD1, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		Thread.sleep(2000);
		//Clicking on the Engine102 Sub Auditee
		driver.findElement(By.xpath("//td[text()='Engine102']")).click();

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Passing the values to due Date
		String DD2 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD2, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		Thread.sleep(2000);
		//Clicking on the Engine105 Sub Auditee
		driver.findElement(By.xpath("//td[text()='Engine105']")).click();

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Passing the values to due Date
		String DD3 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD3, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		System.out.println("************Singoffing the Dynamic Sub Audit Type************");

		chiledTest.log(Status.INFO, "***********Singoffing the Dynamic Sub Audit Type************");

		//Passing the Values to search Text Box
		String SB2 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		MA.SetSearchButton(SB2);
		chiledTest.log(Status.INFO, "General Sub Audit Is Searched");

		Thread.sleep(2000);
		//Clicking on the Engine101 Sub Auditee
		driver.findElement(By.xpath("//td[text()='Engine101']")).click();

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Passing the values to due Date
		String DD4 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD4, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		Thread.sleep(2000);
		//Clicking on the Engine102 Sub Auditee
		driver.findElement(By.xpath("//td[text()='Engine102']")).click();

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Passing the values to due Date
		String DD5 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD5, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		Thread.sleep(2000);
		//Clicking on the Engine105 Sub Auditee
		driver.findElement(By.xpath("//td[text()='Engine105']")).click();

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Passing the values to due Date
		String DD6 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD6, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		//Liking on the Sign Off Main Audit
		MA.ClickSignOffMainAuditBTN(driver);
		chiledTest.log(Status.INFO, "Sign Off Main Audit Button is Clicked");

		//verifying Audit accepted successfully Success Message is Displayed
		MA.VerifyAuditAcceptedSuccessfullySuccessMSGIsDisplayed();
		chiledTest.log(Status.INFO, "Audit accepted successfully Success Message is Displayed");

		System.out.println("*******************************************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=11, dependsOnMethods= {"Executing_The_AuditType_Test"})
	public void ReOpping_CheckPoints_Test() throws Exception
	{

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		ReAuditPageTest RAP = new ReAuditPageTest(driver);

		chiledTest = parentTest.createNode("ReOpping Checkpoints Test");

		System.out.println("ReOpping Checkpoints Test");

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

		//Verifying review Audit Page is Displayed
		RA.VerifyReviewAuditPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Review Audit Page is Displayed");

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("**************Reopping the Checkpoints Of General Sub Audit Type***********");

		chiledTest.log(Status.INFO, "**************Reopping the Checkpoints Of General Sub Audit Type**********");

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA = Lib.getCellValue(XLPATH, "ReAudit", 3, 0);
		RA.SetSubAudits(SA);

		RA.ClickMatchedTextOption(driver);

		//clicking on the 1st Checkpoint
		RA.ClickFirstCheckPoint();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Compliance Was Successfully Updated Message is Displayed
		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA1 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0);
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the First Checkpoint radio button
		RA.ClickFourthCheckPoint();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR1 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR1, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//verifying Compliance Was Successfully Updated Mesage is Displayed
		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);

		System.out.println("**************Reopping the Checkpoints Of 1st Static Sub Audit Type***********");

		chiledTest.log(Status.INFO, "**************Reopping the Checkpoints Of 1st Static Sub Audit Type**********");

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA2 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		RA.SetSubAudits(SA2);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Second Checkpoint
		RA.ClickSecondCheckPoint();

		Thread.sleep(2000);
		//clicking on the Engine101
		driver.findElement(By.xpath("//label[contains(text(),'Engine101')]")).click();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR2 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR2, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Compliance Was Successfuly Updated
		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA3 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		RA.SetSubAudits(SA3);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Third Checkpoint
		RA.ClickThirdCheckPoint();

		Thread.sleep(2000);
		//clicking on the Engine101
		driver.findElement(By.xpath("//label[contains(text(),'Engine101')]")).click();


		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR3 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR3, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");


		System.out.println("**************Reopping the Checkpoints Of 2nd Static Sub Audit Type***********");

		chiledTest.log(Status.INFO, "**************Reopping the Checkpoints Of 2nd Static Sub Audit Type**********");

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA4 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		RA.SetSubAudits(SA4);

		RA.ClickMatchedTextOption(driver);

		//clicking on the 4th Checkpoint
		RA.ClickFourthCheckPoint();

		Thread.sleep(2000);
		//clicking on the Engine102
		driver.findElement(By.xpath("//label[contains(text(),'Engine102')]")).click();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR32 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR32, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");

		System.out.println("**************Reopping the Checkpoints Of Dynamic Sub Audit Type***********");

		chiledTest.log(Status.INFO, "**************Reopping the Checkpoints Of Dynamic Sub Audit Type**********");

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA5 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		RA.SetSubAudits(SA5);

		RA.ClickMatchedTextOption(driver);

		//******************* 1st Checkpoint Reopping **********************

		//clicking on the 1st Checkpoint
		RA.ClickFirstCheckPoint();

		Thread.sleep(2000);
		//clicking on the Engine105
		driver.findElement(By.xpath("//label[contains(text(),'Engine105')]")).click();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR5 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR5, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");

		//******************* 2nd Checkpoint Reopping **********************

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA6 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		RA.SetSubAudits(SA6);

		RA.ClickMatchedTextOption(driver);

		RA.ClickSecondCheckPoint();

		Thread.sleep(2000);
		//clicking on the Engine105
		driver.findElement(By.xpath("//label[contains(text(),'Engine105')]")).click();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR6 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR6, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");


		//******************* 3rd Checkpoint Reopping **********************

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA7 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		RA.SetSubAudits(SA7);

		RA.ClickMatchedTextOption(driver);

		//clicking on the 3rd checkpoint
		RA.ClickThirdCheckPoint();

		Thread.sleep(2000);
		//clicking on the Engine105
		driver.findElement(By.xpath("//label[contains(text(),'Engine105')]")).click();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR7 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR7, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");

		//******************* 4th Checkpoint Reopping **********************

		driver.navigate().refresh();

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA8 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		RA.SetSubAudits(SA8);

		RA.ClickMatchedTextOption(driver);

		//clicking on the 4th checkpoint
		RA.ClickFourthCheckPoint();

		Thread.sleep(2000);
		//clicking on the Engine105
		driver.findElement(By.xpath("//label[contains(text(),'Engine105')]")).click();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//Verifying Reaudit Remarks is Required Filed or not
		RAP.VerifyReAuditRemarksIsRequiredFiled(driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Required Filed");

		//Passing the Values to Reaudit Remarks 
		String RR8 = Lib.getCellValue(XLPATH, "ReAudit", 12, 0);
		RAP.SetReauditRemarks(RR8, driver);
		chiledTest.log(Status.INFO, "Reaudit Remarks is Entered");

		//Clicking on the Reaudit Button
		RAP.ClickReAuditButton(driver);
		chiledTest.log(Status.INFO, "Reaudit Button is clicked");

		//RAP.VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(driver);
		//chiledTest.log(Status.INFO, "Compliance was successfully updated Message is Displayed");

		//**************** Reaudit Checkpoints *********************

		RA.ClickReviewAuditHeader(driver);

		//Passing the Values to Search Text field
		String SB4 = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		RA.SetSearchTextBox(SB4);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		RA.ClickSelectSubAuditType();

		//Passing the Values to Select sub audits
		String SA31 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0);
		RA.SetSubAudits(SA31);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all checkpoints
		RA.ClickSelectAllCheckpoints();

		//Passing the Values to Reaudit Comments
		String RC = Lib.getCellValue(XLPATH, "ReAudit", 20, 0);
		RA.SetReauditCommnet(RC);

		//Passing the Values to Reaudit Start date
		String SD = Lib.getCellValue(XLPATH, "ReAudit", 26, 0);
		RA.SetReauditStartDate(SD);

		//Passing the Values to Reaudit End Date
		String ED = Lib.getCellValue(XLPATH, "ReAudit", 32, 0);
		RA.SetReauditEndDate(ED);

		//Clicking on the Reaudit Checkpoints Button
		RA.ClickReuditCheckpointsButton();
		
		//verifying Please confirm having selected all required check points for re-audit Popup is Displayed 
		RA.VerifyPleaseConfirmHavingSelectedAllRequiredCheckPointsForReauditPopIsDisplayed();

		//Verifying Schedule Is Updated Successfully Message is Displayed
		RA.VerifyScheduleIsUpdatedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("*********************************************");

	}

	//Testing the Functionality of the Reopen Checkpoints Execution
	@Test(priority=12, dependsOnMethods= {"ReOpping_CheckPoints_Test"})
	public void ReOppend_CheckPoints_Execution_Test() throws InterruptedException
	{
		System.out.println("ReOppend CheckPoints Execution Test");

		chiledTest = parentTest.createNode("ReOppend CheckPoints Execution Test");

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Passing the Auditor User Name
		String un=Lib.getCellValue(XLPATH, "Login Credentials",42,0);
		l.setusername(un);

		//Passing the Auditor Password
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",42,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the Parent Audit type to Audit Type Search text Field
		String AT = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		AE.SetAuditType(AT, driver);
		chiledTest.log(Status.INFO, "ReOppend Audit Type is Searched");

		AE.ClickMatched();

		//clicking on the Accept button
		AE.ClickAcceptBTN(driver);

		//Passing the Parent Audit type to Audit Type Search text Field
		String AT1 = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		AE.SetAuditType(AT1, driver);
		chiledTest.log(Status.INFO, "ReOppend Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Reaudit Button
		AE.ClickParentReauditBTN();

		System.out.println("************** Executing the General Sub Audit Type*****************");

		chiledTest.log(Status.INFO, "************** Executing the General Sub Audit Type*****************");

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0); 
		AE.SetSearchBTN(SB1);

		//Clicking on the Reaudit Button
		AE.ClickSubAuditsReauditBTN();

		AE.Clicknormal(driver);

		System.out.println("****Executing 1st Checkpoint****");

		chiledTest.log(Status.INFO, "****Executing 1st Checkpoint****");

		Thread.sleep(4000);

		//Passing the Values to Remarks
		String ER = Lib.getCellValue(XLPATH, "ReAudit", 41, 0);
		AE.SetEnterRemarks(ER);

		//Passing the Values to Confidential Remarks
		String ECR = Lib.getCellValue(XLPATH, "ReAudit", 48, 0);
		AE.SetEnterConfidentalRemarks(ECR);

		//Clicking on the NO Button
		AE.ClickNoButton();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting All No Dispositions
		AE.SelectingAllDispositions(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("****Executing 2nd Checkpoint****");

		chiledTest.log(Status.INFO, "****Executing 2nd Checkpoint****");

		Thread.sleep(4000);

		//Passing the Values to Remarks
		String ER2 = Lib.getCellValue(XLPATH, "ReAudit", 42, 0);
		AE.SetEnterRemarks(ER2);

		//Passing the Values to Confidential Remarks
		String ECR2 = Lib.getCellValue(XLPATH, "ReAudit", 49, 0);
		AE.SetEnterConfidentalRemarks(ECR2);

		//Clicking on the Partial Button
		AE.ClickPartialButton();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting All No Dispositions
		AE.SelectingAllDispositions(driver);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Checking Audit Submitted Successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0); 
		AE.SetSearchBTN(SB11);

		//Validating Tick Button is Displayed or Not
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("************** Executing the Static Annexure Sub Audit Type*****************");

		chiledTest.log(Status.INFO, "************** Executing the Static Annexure Sub Audit Type*****************");

		//Passing the Values to Search Text Filed
		String SB3 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0); 
		AE.SetSearchBTN(SB3);

		//Clicking on the Reaudit Button
		AE.ClickSubAuditsReauditBTN();

		//Passing the Engin101 to Search Text Filed
		String SB4 = Lib.getCellValue(XLPATH, "Audit Execution", 58, 0); 
		AE.SetSearchBTN(SB4);

		AE.ClickPIStartButton(driver);

		System.out.println("****Executing The 1st PI****");

		chiledTest.log(Status.INFO, "****Executing The 1st PI****");

		//Clicking Normal Mode
		AE.Clicknormal(driver);

		//Passing the Values to Remarks
		String ER3 = Lib.getCellValue(XLPATH, "ReAudit", 41, 0);
		AE.SetEnterRemarks(ER3);

		//Passing the Values to Confidential Remarks
		String ECR3 = Lib.getCellValue(XLPATH, "ReAudit", 48, 0);
		AE.SetEnterConfidentalRemarks(ECR3);

		AE.SelectingValues(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("****Executing The 2nd Checkpoint****");

		chiledTest.log(Status.INFO, "****Executing The 2nd Checkpoint****");

		Thread.sleep(4000);

		//Passing the Values to Remarks
		String ER4 = Lib.getCellValue(XLPATH, "ReAudit", 42, 0);
		AE.SetEnterRemarks(ER4);

		//Passing the Values to Confidental Remarks
		String ECR4 = Lib.getCellValue(XLPATH, "ReAudit", 49, 0);
		AE.SetEnterConfidentalRemarks(ECR4);

		//Clicking on the NA Button
		AE.ClickNAButton();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting All Dispositions
		AE.SelectingAllDispositions(driver);

		//Passing the Values to Percentage
		String IV = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV, driver);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Audit Submitted Successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("****Executing The 2nd PI****");

		chiledTest.log(Status.INFO, "****Executing The 2nd PI****");

		//Passing the Engin101 to Search Text Filed
		String SB5 = Lib.getCellValue(XLPATH, "Audit Execution", 59, 0); 
		AE.SetSearchBTN(SB5);

		AE.ClickPIStartButton(driver);

		AE.Clicknormal(driver);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Audit Submitted Successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		AE.ClickOKBTN1(driver);

		//Passing the Values to Search Text Filed
		String SB31 = Lib.getCellValue(XLPATH, "ReAudit", 4, 0); 
		AE.SetSearchBTN(SB31);

		//Validating Tick Button is Displayed or Not
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("************** Executing the Dynamic Annexure Sub Audit Type*****************");

		chiledTest.log(Status.INFO, "************** Executing the Dynamic Annexure Sub Audit Type*****************");

		//Passing the Values to Search Text Filed
		String SB7 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0); 
		AE.SetSearchBTN(SB7);

		//Clicking on the Reaudit Button
		AE.ClickSubAuditsReauditBTN();

		System.out.println("****Executing The 1st PI****");

		chiledTest.log(Status.INFO, "****Executing The 1st PI****");

		//Passing the Engin101 to Search Text Filed
		String SB8 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0); 
		AE.SetSearchBTN(SB8);

		AE.ClickPIStartButton(driver);

		//Clicking Normal Mode
		AE.Clicknormal(driver);

		System.out.println("********* Executing 1st Chckpoint*****");

		chiledTest.log(Status.INFO, "****Executing The 1st Checkpoint****");

		Thread.sleep(4000);

		//Passing the Values to Remarks
		String ER5 = Lib.getCellValue(XLPATH, "ReAudit", 41, 0);
		AE.SetEnterRemarks(ER5);

		//Passing the Values to Confidtial Remarks
		String ECR5 = Lib.getCellValue(XLPATH, "ReAudit", 48, 0);
		AE.SetEnterConfidentalRemarks(ECR5);

		//Clicking on the NO Button
		AE.ClickNoButton();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting All the Dispositions
		AE.SelectingAllDispositions(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("********* Executing 2nd Chckpoint*****");

		chiledTest.log(Status.INFO, "****Executing The 2nd Checkpoint****");

		Thread.sleep(4000);

		//Passing the Values to Remarks
		String ER6 = Lib.getCellValue(XLPATH, "ReAudit", 42, 0);
		AE.SetEnterRemarks(ER6);

		//Passing the Values to Confidental Remarks
		String ECR6 = Lib.getCellValue(XLPATH, "ReAudit", 49, 0);
		AE.SetEnterConfidentalRemarks(ECR6);

		//Selecting the Values 
		AE.SelectingValues(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("********* Executing 3rd Chckpoint*****");

		chiledTest.log(Status.INFO, "****Executing The 3rd Checkpoint****");

		Thread.sleep(4000);

		//Passing the Values to Remarks
		String ER7 = Lib.getCellValue(XLPATH, "ReAudit", 43, 0);
		AE.SetEnterRemarks(ER7);

		//Passing the Values to Confidential Remarks
		String ECR7 = Lib.getCellValue(XLPATH, "ReAudit", 50, 0);
		AE.SetEnterConfidentalRemarks(ECR7);

		//Clicking on the NA Button
		AE.ClickNAButton();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting All Dispositions
		AE.SelectingAllDispositions(driver);

		//Passing the Values to Percentage
		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV1, driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("********* Executing 4th Chckpoint*****");

		chiledTest.log(Status.INFO, "****Executing The 4th Checkpoint****");

		Thread.sleep(4000);

		//Passing the Values to Remarks
		String ER8 = Lib.getCellValue(XLPATH, "ReAudit", 44, 0);
		AE.SetEnterRemarks(ER8);

		//Passing the Values to Confidential Remarks
		String ECR8 = Lib.getCellValue(XLPATH, "ReAudit", 51, 0);
		AE.SetEnterConfidentalRemarks(ECR8);

		//Clicking on the Yes Button
		AE.ClickYesButton();

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting All Dispositions
		AE.SelectingAllDispositions(driver);

		//Passing the Values to Percentage
		String IV2 = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		AE.SetEnterInputValues(IV2, driver);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Audit Submitted Successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		AE.ClickOKBTN1(driver);

		//Validating Tick Button is Displayed or Not
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//clicking on the audit level Recommendations link
		AE.ClickAuditLevelRecommendationsLink();

		//checking the entered audit level Recommendations is displayed or not
		AE.VerifyAuditLevelRecommendatiosText();

		//clicking on the audit level Observations link
		AE.clickAuditLevelObservationssLink();

		//checking the entered audit level Observations is displayed or not
		AE.VerifyAuditLevelObservationsText();

		//Clicking on the Submit Audit Button
		AE.ClickSubmitAuditBTN(driver);

		//Verifying Submitted Successfully Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("**********************");

	}

	//Testing the Functionality of the Finalize Audit
	@Test(priority=13, dependsOnMethods= {"ReOppend_CheckPoints_Execution_Test"})
	public void Finalize_Audit_Test() throws InterruptedException
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
		String SB = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//checking Reaudit accepted status is Displayed
		RA.VerifyReauditAcceptedStatuISDisplayed();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing and Finalizing Static Annxure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Static Annxure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA = Lib.getCellValue(XLPATH, "ReAudit", 4, 0);
		RA.SetSubAudits(SA);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing Dynamic Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Dyanmic Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA1 = Lib.getCellValue(XLPATH, "ReAudit", 5, 0);
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing General Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing General Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA2 = Lib.getCellValue(XLPATH, "ReAudit", 3, 0);
		RA.SetSubAudits(SA2);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		//Clicking on the Main Audit Finalize button
		RA.ClickMainAuditFinalizeBTN();

		//verifying Audit Finalized Successfully message is displayed
		RA.VerifyAuditFinalizedSuccessfullySuccessMsgIsDisplayed(driver);

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=14, dependsOnMethods= {"Finalize_Audit_Test"})
	public void Validating_The_Scores_Test() throws InterruptedException
	{

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		System.out.println("Validating the Score Test");

		chiledTest = parentTest.createNode("Validating the Score Test");

		RA.ClickReviewAuditHeader(driver);

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "ReAudit", 6, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//clicking on the summary button
		RA.ClickSummaryBTN();

		Thread.sleep(2000);

		//Checking the Total Score
		String Actual_TotalScore = driver.findElement(By.xpath("//div[@class='recalc_total_score']")).getText();
		System.out.println("Actual Total Score is : " + Actual_TotalScore);
		String Expected_TotalScore = "175.83 / 450.0"; 
		System.out.println("Expected Total Score is : " + Expected_TotalScore);
		Assert.assertEquals(Actual_TotalScore, Expected_TotalScore, "Total Score is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Total score are Matched");

		//Checking the Audit rating
		String Actual_AuditRating = driver.findElement(By.xpath("//div[@class='recalc_rating']")).getText();
		System.out.println("Actual Rating is : " + Actual_AuditRating);
		String Expected_AuditRating = Lib.getCellValue(XLPATH, "Configure Audit Type", 98, 0);
		System.out.println("Expected Rating is : " + Expected_AuditRating);
		Assert.assertEquals(Actual_AuditRating, Expected_AuditRating, "Audit Rating is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual ratings are Matched");

		//Checking the Compliances %
		String Actual_Compliances = driver.findElement(By.xpath("//div[@class='recalc_compliance_percentage']")).getText();
		System.out.println("Actual Rating is : " + Actual_Compliances);
		String Expected_Compliances = "39.07";
		System.out.println("Expected Compliance is : " + Expected_Compliances);
		Assert.assertEquals(Actual_Compliances, Expected_Compliances, "Compliances % is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Compliances % are Matched");


		System.out.println("********************************");

	}

}


package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import pom.ReviewAuditPageTest;
import pom.SideMenuPageTest;
import pom.UploadAnnexureDocumentPageTest;

public class ProvisionalSubmissionAndBulkFinalizationFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Creating Group Audit Type test
	@Test(priority=1)
	public void Creating_General_Sub_Audit_Type_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		parentTest = extent.createTest("Provisional Submission and Bulk Finalization Functionality Test", "Testing the Functionality of the Provisional submission, Bulk Finalization, and Do you need annexure sampling Functionality");

		chiledTest = parentTest.createNode("Creating Genearl Sub Audit Type Test");

		System.out.println("Creating General Sub Audit Type Test");

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
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0);
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

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("***************************************");
	}

	//Testing the Functionality of the Creating Annexure Sub Audit Type For Dynamic Test
	@Test(priority=2, dependsOnMethods= {"Creating_General_Sub_Audit_Type_Test"})
	public void Creating_Annexure_Sub_Audit_Type_For_Dynmaic_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Sub Audit Type For Dynamic Test");

		System.out.println("Creating Annexure Sub Audit Type For Dynamic Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
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


		//************************** Define Tab **************************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 28, 0);
		CA.SetSelectGrouptype(SGT);
		chiledTest.log(Status.INFO, "Annexure Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG = Lib.getCellValue(XLPATH, "Group", 15, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("****************************");
	}

	//Testing the Functionality of the Creating Annexure Sub Audit Type For Static Group Test
	@Test(priority=3, dependsOnMethods= {"Creating_Annexure_Sub_Audit_Type_For_Dynmaic_Group_Test"})
	public void Creating_Annexure_Sub_Audit_Type_For_Static_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Sub Audit Type For Static Group Test");

		System.out.println("Creating Annexure Sub Audit Type For Static Group Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
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

		//************************** Define Tab **************************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 28, 0);
		CA.SetSelectGrouptype(SGT);
		chiledTest.log(Status.INFO, "Annexure Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG = Lib.getCellValue(XLPATH, "Group", 18, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("********************************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=4, dependsOnMethods= {"Creating_Annexure_Sub_Audit_Type_For_Static_Group_Test"})
	public void Creating_Parent_Audit_Type_With_One_General_Group_And_Two_Annexue_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Parent Audit Type With One General Group And Two Annexure Group Test");

		System.out.println("Creating Parent Audit Type With One General Group And Two Annexure Group Test");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		CA.SetAuditTypeName(ATN, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Begin Tab
		CA.ClickBeginTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******* DEFINE TAB *****************************

		//Clicking on the Parent Type Audit Radio Button
		CA.ClickParentTypeAuditRadioBTN(driver);
		chiledTest.log(Status.INFO, "Parent audit type Radio Button is Clicked");

		//Clicking on the Sub Audit Type Radio Button
		CA.ClickSubAuditTypeRadioBTN();
		chiledTest.log(Status.INFO, "Sub Audit Type Radio Button is Clicked");

		//Clicking on the select Group type
		String SA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0);
		CA.SetSelectSubAudittype(SA1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
		CA.SetSelectSubAudittype(SA3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA4 = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
		CA.SetSelectSubAudittype(SA4, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//selecting last option under Entries Fields
		CA.SetShowAndRow(driver);

		//Checking the Select Check Point group is Selected or not
		List<WebElement> SCG = driver.findElements(By.xpath("//div[@id='s2id_groups_']/ul[@class='select2-choices']"));
		int SCGCount = SCG.size();
		Assert.assertTrue(SCGCount>0, "Checkpoint Group is Not Selected");

		//Checking the Check Point table is displayed
		boolean Table = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']")).isDisplayed();
		System.out.println("Check Point grid is Displayed : " + Table);

		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 12;
		Assert.assertEquals(CPCount, CPCount1, "12 Check Points are Not Displayed");

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

		// If we enabled the Eliminate Auditee Sign off Toggle button than provisional submission Toggle button should be in Read only mode

		//Clicking on the Eliminate Auditee Sign off Toggle button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Eliminate Auditee Sign off Toggle button is enabled");

		List<WebElement> ProvisionalToggleBTN = driver.findElements(By.xpath("//input[@id='audit_type_is_provisional_submission' and @disabled]"));
		Assert.assertTrue(ProvisionalToggleBTN.size()>0, "provisional submission Toggle button is not in read only mode");
		System.out.println("provisional submission Toggle button is in read only mode");
		chiledTest.log(Status.INFO, "provisional submission Toggle button is in read only mode");

		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Eliminate Auditee Sign off Toggle button is disabled");

		List<WebElement> ProvisionalToggleBTN1 = driver.findElements(By.xpath("//input[@id='audit_type_is_provisional_submission']"));
		Assert.assertTrue(ProvisionalToggleBTN1.size()>0, "provisional submission Toggle button is enabled");
		System.out.println("provisional submission Toggle button is enabled");
		chiledTest.log(Status.INFO, "provisional submission Toggle button is enabled");

		//Clicking on the Do you need to finalize audits in bulk ?
		CA.ClickBulkFinalizeTaggleBTN();

		//clicking on the Annexure Sampling Toggle Button
		CA.ClickAnnexureSamplingTaggleBTN();

		//Clicking on the provisional submission Toggle button
		CA.ClickProvisionalSubmissionToggleBTN();

		//clicking on the Should capturing image be mandatory for main audit ? toggle button
		CA.ClickImageMandatoryTaggleBTN();

		//Clicking on the Do you wish to add selfie? toggle button
		CA.ClickAddSelfieTaggleBTN();

		//clicking on the Do you wish to add digital signatures? Toggle button
		CA.ClickAddDigitalSignatureTaggleBTN();

		//Clicking on the Select verifier
		CA.clickSelectVerifier();

		//Passing the Values to Select Verifier
		String SV = Lib.getCellValue(XLPATH, "Configure Audit Type", 58, 0);
		CA.SetSelectVerifier(SV);
		chiledTest.log(Status.INFO, "Verifier is Selected");

		//Clicking on the Match
		CA.ClickMatch();

		//clicking on the Select TAT Type
		CA.ClickSelectTATType();

		//Passing the Values to Select TAT Type
		String ST = Lib.getCellValue(XLPATH, "Configure Audit Type", 66, 0);
		CA.SetSelectTATType(ST);

		//Clicking on the Match
		CA.ClickMatch();

		//Clicking on the Frequency
		CA.ClickFrequency(driver);

		//Passing the Values to Frequency
		String SF = Lib.getCellValue(XLPATH, "Configure Audit Type", 103, 0);
		CA.SetFrequency(SF);
		chiledTest.log(Status.INFO, "Frequency is Selected");

		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		//*************** Finalize Tab *************************

		Thread.sleep(5000);   //input[@id='audit_type_total_score']

		//Checking the Total Count
		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		System.out.println("Total Scroe is : " + TotalScoreCount);
		double d = 150.0;
		String Str = Double.toString(d);
		Assert.assertEquals(TotalScoreCount, Str, "Total Score count is showing Wrong");

		//Checking the To Count
		String Actual_TO = driver.findElement(By.xpath("//input[@id='audit_type_audit_ratings_attributes_0_to']")).getAttribute("value");
		System.out.println("TO Count is : " + Actual_TO);
		int d1 = 100;
		String Str1 = Integer.toString(d1);
		Assert.assertEquals(Actual_TO, Str1, "Total Score count is showing Wrong");

		//Checking the Actual Score Slab is disabled for Redistribution Logic Group
		CA.VerifyActualScoreSlabRadioButtonIsDisabled();

		//Checking the Percentage Based Score slab Radio button is Enabled for Redistribution Logic Group
		CA.VerifyPercentageBasedSlabRadioButtonIsEnabled();

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

	//Testing the Functionality of the Uploading Annexure Document for Audit Type
	@Test(priority=5, dependsOnMethods= {"Creating_Parent_Audit_Type_With_One_General_Group_And_Two_Annexue_Group_Test"})
	public void Uploading_Annexure_Documenet_Test() throws InterruptedException
	{

		LoginPageTest l=new LoginPageTest(driver);

		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Uploading Annexure Document Test");

		System.out.println("Uploading Annexure Documenet Test");

		System.out.println("*********Uploading the Annexure Document for Static Annexure*******************");

		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Static Annexure*******************");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un);

		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		UA.ClickScrollBar(driver);

		UA.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annecxure is Clicked");

		UA.ClickAnnexureDocuments(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents is Clicked");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Static Annexure SAT')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		UA.VerifyStaticAnnexureTypeIsDisplayed();

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
		String SA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		UA.SetAuditType(SA1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Dynamic Annexure SAT')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		UA.VerifyDynamicAnnexureTypeIsDisplayed();

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

	//Configuring the Auditee admin configuration
	@Test(priority=6, dependsOnMethods= {"Uploading_Annexure_Documenet_Test"})
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
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
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
	@Test(priority=7, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Schedule Test");

		System.out.println("Creating Schedule Test");

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
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
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

		System.out.println("***********************************************");

	}

	//Testing the Functionality of the Executing General Audit type Test
	@Test(priority=8, dependsOnMethods= {"Creating_Schedule_Test"})
	public void Executing_Schedule_Through_Express_Noraml_Mode_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Executing Schedule Through Express And Noraml Mode Test");

		System.out.println("Executing Schedule Through Express And Noraml Mode Test");	

		WebDriverWait wait = new WebDriverWait(driver, 40);

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
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Accept Button
		AE.ClickAcceptBTN(driver);
		chiledTest.log(Status.INFO, "Accept Button is Clicked");

		//Verifying Audit accepted successfully Success Message is Displayed
		AE.VerifyAuditAcceptedSuccesfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit accepted successfully Success Message is Displayed");

		driver.navigate().refresh();

		System.out.println("************** Executing the General Sub Audit Type*****************");

		chiledTest.log(Status.INFO, "************** Executing the General Sub Audit Type*****************");

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0); 
		AE.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "General Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		AE.Clicknormal(driver);

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER11);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
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

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER34 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER34);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
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

		//Clicking on the Provisional Submission Button
		AE.ClickProvisionalSubmissionBTN();


		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("*********************Executing 1st Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 1st Sub Audit Group Under Static Annexure*********************");

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
		AE.SetSearchBTN(SB11);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Mark PI has not Executed Button should not be show until any one of the PI not Executed
		AE.VerifyMarkPendingPIAsNotExecutedButtonShouldNotDisplay();

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

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER113 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER113);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR113 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR113);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NO *********************************************

		//Clicking on the No Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify No Dispositions
		AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER123 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123);
		chiledTest.log(Status.INFO, "Remarks is Entered");

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

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER234 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR234 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR234);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Partial Button *********************************************

		//Clicking on the Partial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partail Button is Clicked");

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

		String Input6 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);

		Assert.assertEquals(Input5, Input6);

		//Passing the Values to Input
		String IV5 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV5, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER345 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR345 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NO Dispositions are Displayed
		AE.VerifyingNODispositions(driver);
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

		//Clicking on the Provisional Submission Button
		AE.ClickProvisionalSubmissionBTN();


		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		AE.ClearPiSearchBTN();

		//Clicking on the Mark Pending Pi as Not Executed
		AE.ClickMarkPendingPIAsNotExecuted();

		//***********Checking Completed Tab Functionality***************

		//Clicking on the Completed Tab
		AE.ClickCompletedTab();

		//Checking the Completed Tab is Displayed
		AE.VerifyCompletedTabIsDisplayed(driver);

		//Checking the Sub Audits are Displayed or Not
		List<WebElement> TotalTRCount = driver.findElements(By.xpath("//table[@id='tableWithSearch']/tbody/tr"));
		int Actual_TRcount = TotalTRCount.size();
		int Expected_TRcount = 1;
		Assert.assertEquals(Actual_TRcount, Expected_TRcount, "Displayed Sub Audit Count is Wrong");
		System.out.println("Sub Audit is Displayed");

		//************Checking the Not Executed Tab ***************

		AE.ClickNotExecutedTab();

		AE.VerifyNotExecutedTabIsDisplayed(driver);

		//Checking the Sub Audits are Displayed or Not
		List<WebElement> TotalTRCount1 = driver.findElements(By.xpath("//table[@id='IssuetableWithSearch']/tbody/tr"));
		int Actual_TRcount1 = TotalTRCount1.size();
		int Expected_TRcount1 = 3;
		Assert.assertEquals(Actual_TRcount1, Expected_TRcount1, "Displayed Sub Audit Count is Wrong");
		System.out.println("Sub Audit is Displayed");

		//Clicking on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("**************Executing Dynamic Annexure Group*******************");

		chiledTest.log(Status.INFO, "**************Executing Dynamic Annexure Group*******************");

		//Passing the Values to Search Text Filed
		String SB41 = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
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

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER143 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER143);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR1431 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1431);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting NO *********************************************

		//Clicking on the No Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify No Dispositions
		AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER123111 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR123111 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123111);
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER234111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR234111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR234111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//******************Selecting Partial Button *********************************************

		//Clicking on the Patial Button
		AE.ClickPartialButton();
		chiledTest.log(Status.INFO, "Partail Button is Clicked");

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
		String Input6111 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		Assert.assertEquals(Input5111, Input6111);

		//Passing the Values to Input
		String IV5111 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV5111, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER345111 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR345111 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//******************Selecting NO Button *********************************************

		//Clicking on the NO Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "NO Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NO Dispositions are Displayed
		AE.VerifyingNODispositions(driver);
		chiledTest.log(Status.INFO, "NO Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Input Values 
		String Input7171 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input7171);
		String Input8141 = Input7171.toLowerCase();

		String Input911 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input911, Input8141);

		//Passing the Values to Input Text fields
		String IV611 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV611, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Provisional Submission Button
		AE.ClickProvisionalSubmissionBTN();

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");


		System.out.println("*********************Executing 2nd Sub Audit Group Under dynamic Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 2nd Sub Audit Group Under dynamic Annexure*********************");

		//Passing the Values to Search Button
		String SB511 = Lib.getCellValue(XLPATH, "Configure Audit Type", 136, 0);
		AE.SetSearchBTN(SB511);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Express Mode
		AE.ClickExpress(driver);
		chiledTest.log(Status.INFO, "Express execution Mode is Clicked");

		Thread.sleep(4000);
		List<WebElement> sourceLocator2 = driver.findElements(By.xpath("//ul[@id='sortable1']/li/div[1]/div"));
		for(int i=0; i<sourceLocator2.size(); i++)
		{
			WebElement All = sourceLocator2.get(i);
			wait.until(ExpectedConditions.visibilityOf(All));
			//Dragging all the checkpoints to NA
			Thread.sleep(2000);
			WebElement targetLocator = driver.findElement(By.xpath("//ul[@id='sortable5']"));
			wait.until(ExpectedConditions.visibilityOf(targetLocator));
			Actions action = new Actions(driver);
			action.dragAndDrop(All, targetLocator).build(). perform();
			System.out.println("Dragging CP to NA compliance");
			chiledTest.log(Status.INFO, "Dragging CP to NA compliance");
		}

		//Clicking on the Next Button
		AE.ClickExpressModeVerifyTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Input Tab ***************************

		Thread.sleep(5000);

		//Selecting the Option Under Values drop down
		driver.findElement(By.xpath("//select[@id='input_value']/option[2]")).click();

		//Passing the values to Percentage
		String PN1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetPercentage(PN1);
		chiledTest.log(Status.INFO, "Percentage is Entered");

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//************** Summary Tab **********************

		//Passing the Values to Remarks
		String ER3 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetExpressRemarks(ER3);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Confidential Remarks
		String CR3 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetExpressConfidentalRemarks(CR3);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Provisional submission button
		AE.ClickProvisionalSubmissionBTN();

		//Verifying Audit submitted successfully success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully success Message is Displayed");

		System.out.println("***********Executing 3rd Sub Audit Type under dynamic Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 3rd Sub Audit Type under dynamic Annexure Group ***************");

		//Passing the Values to Search Button
		String SB711 = Lib.getCellValue(XLPATH, "Configure Audit Type", 137, 0);
		AE.SetSearchBTN(SB711);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR111 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR111);

		AE.ClickMatched();

		//Entering the Reason
		String NFR = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***********Executing 4th Sub Audit Type under dynamic Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 4th Sub Audit Type under dynamic Annexure Group ***************");

		driver.navigate().refresh();

		//Passing the Values to Search Button
		String SB61 = Lib.getCellValue(XLPATH, "Configure Audit Type", 138, 0);
		AE.SetSearchBTN(SB61);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR4 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR4);

		AE.ClickMatched();

		//Entering the Reason
		String NFR1 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR1);

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

		System.out.println("*******************Adding same PI ********************");

		chiledTest.log(Status.INFO, "*****************Adding same PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN121 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN121, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//checking duplicate Pi is Not Allowed Message is Displayed
		AE.VerifyDuplicatePINotAllowedMSGIsDisplayed();


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

		//Clicking on the Express Mode
		AE.ClickExpress(driver);
		chiledTest.log(Status.INFO, "Express execution Mode is Clicked");

		Thread.sleep(4000);
		List<WebElement> sourceLocator3 = driver.findElements(By.xpath("//ul[@id='sortable1']/li/div[1]/div"));
		for(int i=0; i<sourceLocator3.size(); i++)
		{
			WebElement All = sourceLocator3.get(i);
			wait.until(ExpectedConditions.visibilityOf(All));
			//Dragging all the checkpoints to Yes
			Thread.sleep(2000);
			WebElement targetLocator = driver.findElement(By.xpath("//ul[@id='sortable2']"));
			wait.until(ExpectedConditions.visibilityOf(targetLocator));
			Actions action = new Actions(driver);
			action.dragAndDrop(All, targetLocator).build(). perform();
			System.out.println("Dragging CP to Yes compliance");
			chiledTest.log(Status.INFO, "Dragging CP to Yes compliance");
		}

		//Clicking on the Next Button
		AE.ClickExpressModeVerifyTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Input Tab ***************************

		Thread.sleep(5000);

		//Selecting the Option Under Values drop down
		driver.findElement(By.xpath("//select[@id='input_value']/option[2]")).click();

		//Passing the values to Percentage
		String PN2 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetPercentage(PN2);
		chiledTest.log(Status.INFO, "Percentage is Entered");

		//Passing the values to Text
		String TT6 = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		AE.SetFirstText(TT6);
		chiledTest.log(Status.INFO, "Text is Entered");

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//************** Summary Tab **********************

		//Passing the Values to Remarks
		String ER4 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetExpressRemarks(ER4);

		//Passing the Values to Confidential Remarks
		String CR4 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetExpressConfidentalRemarks(CR4);

		//Clicking on the Provisional Submission Button
		AE.ClickProvisionalSubmissionBTN();

		//Verifying Audit submitted successfully success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully success Message is Displayed");

		System.out.println("******* Executing another newly Added PI ********");

		chiledTest.log(Status.INFO, "******* Executing another newly Added PI ********");

		//Passing the Values to Search Button
		String SB721 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPiSearchBTN(SB721);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Selecting Other Option Under Reason
		String SR121 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR121);
		chiledTest.log(Status.INFO, "Others Option is Selected Under Reason Drop down");

		AE.ClickMatched();

		//Passing the Values to Reason
		String NFR2 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR2);
		chiledTest.log(Status.INFO, "Reason is Entered");

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		//Clicking on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//Passing the Values to Audit Level Recommendation //CTRL-5745 Changes Impacted
		String AR = Lib.getCellValue(XLPATH, "Audit Execution", 115, 0);
		AE.SetAuditLevelRecommendation(AR);

		//Passing the Values to Audit level Observation
		String AO = Lib.getCellValue(XLPATH, "Audit Execution", 118, 0);
		AE.SetAuditLevelObservations(AO);

		//Clicking on the Submit Audit Button
		AE.ClickFinalProvisionalSubmitButton();

		//Uploading the Documents //CTRL-5745 Changes
		//AE.ImageMandatoryUploadDocuments();

		//Verifying Submitted successfully success Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Submitted successfully success Message is Displayed");

		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=9, dependsOnMethods= {"Executing_Schedule_Through_Express_Noraml_Mode_Test"})
	public void Provisionaly_Submitted_Status_Should_Show_For_AuditeeUser_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("Provisionaly Submitted Status Should Show For Auditee User Test");

		System.out.println("Provisionaly Submitted Status Should Show For Auditee User Test");

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

		//Passing the Values to Select Audit type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		MA.SetSelectAuditType(SA);

		MA.ClickMatched();

		//Checking Provisionally Submitted Status is Displayed or Not for audit type
		MA.VerifyProvisionalSubmissionStatusIsDisplayed();

		System.out.println("****************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=10, dependsOnMethods= {"Provisionaly_Submitted_Status_Should_Show_For_AuditeeUser_Test"})
	public void Submitting_The_AuditType_Which_Is_Provisionally_Submitted_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		System.out.println("Submitting The AuditType Which Is Provisionally Submitted Test");

		chiledTest = parentTest.createNode("Submitting The AuditType Which Is Provisionally Submitted Test");

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
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Under Summary page checking Audit Execution Status is Showing Provisionally Submitted Status or Not
		WebElement PSS = driver.findElement(By.xpath("//span[contains(text(),'Provisionally Submitted')]"));
		Assert.assertTrue(PSS.isDisplayed(), "Provisionally Submitted Status is NOT Showing in Summary Page");
		System.out.println("Provisionally Submitted Status is Showing in Summary Page");
		chiledTest.log(Status.INFO, "Provisionally Submitted Status is Showing in Summary Page");

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Submitting The 1st General Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Submitting The 1st General Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0);
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//Clicking on the Submit Audit button
		RA.ClickSubmitAuditBTN();

		System.out.println("*****************Submitting The Dynamic Annexure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Submitting The Dynamic Annexure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
		RA.SetSubAudits(SA2);

		RA.ClickMatchedTextOption(driver);

		//clicking on Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditeess
		RA.ClickSelectAllAuditees();

		//clicking on the Submit Audit button
		RA.ClickSubmitAuditBTN();

		System.out.println("*****************Submitting The Static Annexure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Submitting The Static Annexure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
		RA.SetSubAudits(SA3);

		RA.ClickMatchedTextOption(driver);

		//clicking on Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditeess
		RA.ClickSelectAllAuditees();


		//clicking on the Submit Audit button
		RA.ClickSubmitAuditBTN();

		//clicking on the Submit Main Audit Button
		RA.ClickSubmitMainAuditBTN();

		//verifying Audit Submitted successfully message is Displayed
		RA.VerifyAuditSubmitedSuccessfullySuccessMsgIsDisplayed(driver);

		System.out.println("***************************************");
	}

	//Sign offing the Audit Type
	@Test(priority=11, dependsOnMethods= {"Submitting_The_AuditType_Which_Is_Provisionally_Submitted_Test"})
	public void SignOff_Audit_Test() throws InterruptedException
	{

		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("SignOff Audits Test");

		System.out.println("SignOff Audits Test");

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

		//Passing the Value to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		MA.SetSelectAuditType(SA);
		chiledTest.log(Status.INFO, "Parent Audit is Searched");

		MA.ClickMatched();

		//Clicking on the First Audit Type
		MA.ClickfirstAuditType(driver);

		System.out.println("************Singoffing the 1st Sub Audit Type************");

		chiledTest.log(Status.INFO, "***********Singoffing the 1st Sub Audit Type************");

		//Passing the Values to search Text Box
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0);
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

		//Clicking on the Due date 
		MA.ClickDueDate();

		//Passing the values to due Date
		String DD = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		System.out.println("************Singoffing the Dynamic Sub Audit Type************");

		chiledTest.log(Status.INFO, "***********Singoffing the Dynamic Sub Audit Type************");

		//Passing the Values to search Text Box
		String SB1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
		MA.SetSearchButton(SB1);
		chiledTest.log(Status.INFO, "Dynamic Sub Audit Is Searched");

		Thread.sleep(2000);
		//Clicking on the Engine101 Sub Auditee
		driver.findElement(By.xpath("//td[text()='Engine101']")).click();

		//Clicking on the Sing Off Audit Button
		MA.ClickSingOffAuditButton(driver);
		chiledTest.log(Status.INFO, "Sing Off Audit Button is Clicked");

		//Verifying Are You Sure Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure Pop Up is Displayed");

		//Clicking on the Due date 
		MA.ClickDueDate();

		//Passing the values to due Date
		String DD1 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD1, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		System.out.println("************Singoffing the Static Sub Audit Type************");

		chiledTest.log(Status.INFO, "***********Singoffing the Static Sub Audit Type************");

		//Passing the Values to search Text Box
		String SB2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
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

		//Clicking on the Due date 
		MA.ClickDueDate();

		//Passing the values to due Date
		String DD3 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD3, driver);

		//Clicking on the OK Button
		MA.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button Is Clicked");

		//Clicking on the Sign Off Main Audit
		MA.ClickSignOffMainAuditBTN(driver);
		chiledTest.log(Status.INFO, "Sign Off Main Audit Button is Clicked");

		//verifying Audit accepted successfully Success Message is Displayed
		MA.VerifyAuditAcceptedSuccessfullySuccessMSGIsDisplayed();
		chiledTest.log(Status.INFO, "Audit accepted successfully Success Message is Displayed");

		System.out.println("*******************************************************");

	}

	//Testing the Functionality of the Finalizing Eliminate SignOff Audit Test
	@Test(priority=12, dependsOnMethods= {"SignOff_Audit_Test"})
	public void Bulk_Finalize_Test() throws InterruptedException
	{
		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Bulk Finalize Test");

		System.out.println("Bulk Finalize Test");

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

		//Clicking on the Bulk Finalize Audits Button
		RA.ClickBulkFinalizeAuditsBTN(driver);
		chiledTest.log(Status.INFO, "Bulk Finalize Audits Button is Clicked");

		//Checking the Select Country/State/Location is Read only Mode
		List<WebElement> Country = driver.findElements(By.xpath("//input[@id='s2id_autogen7' and @disabled]"));
		Assert.assertTrue(Country.size()>0, "Select Country/State/Location is Not Read only Mode");
		System.out.println("Select Country/State/Location is Read only Mode");
		chiledTest.log(Status.INFO, "Select Country/State/Location is Read only Mode");

		//Checking the Select Auditee
		List<WebElement> Auditee = driver.findElements(By.xpath("//input[@id='s2id_autogen6' and @disabled]"));
		Assert.assertTrue(Auditee.size()>0, "Select Country/State/Location is Not Read only Mode");
		System.out.println("Select Auditee is Read only Mode");
		chiledTest.log(Status.INFO, "Select Auditee is Read only Mode");

		//Checking the Select Auditor
		List<WebElement> Auditor = driver.findElements(By.xpath("//input[@id='s2id_autogen1' and @disabled]"));
		Assert.assertTrue(Auditor.size()>0, "Select Auditor is Not Read only Mode");
		System.out.println("Auditor is Read only Mode");
		chiledTest.log(Status.INFO, "Auditor is Read only Mode");

		//Checking the Select Execution Status
		List<WebElement> ExecutionStatus = driver.findElements(By.xpath("//select[@id='review_audit_execution_status' and @disabled]"));
		Assert.assertTrue(ExecutionStatus.size()>0, "Select Execution Status is Not Read only Mode");
		System.out.println("Select Execution Status is Read only Mode");
		chiledTest.log(Status.INFO, "Select Execution Status is Read only Mode");

		//Checking the Select Execution Status Accepted is Selected or Not
		List<WebElement> Accepted = driver.findElements(By.xpath("//select[@id='review_audit_execution_status']//option[@selected='selected'][text()='Accepted']"));
		Assert.assertTrue(Accepted.size()>0, "Accepted status is not Selected Under Execution Status");
		System.out.println("Accepted status is Selected Under Execution Status");
		chiledTest.log(Status.INFO, "Accepted status is Selected Under Execution Status");

		//Checking the Select Start date
		List<WebElement> StartDate = driver.findElements(By.xpath("//input[@id='start_date' and @disabled]"));
		Assert.assertTrue(StartDate.size()>0, "Start Date is Not Read only Mode");
		System.out.println("Start date is Read only Mode");
		chiledTest.log(Status.INFO, "Start date is Read only Mode");

		//Checking the Select end date
		List<WebElement> EndDate = driver.findElements(By.xpath("//input[@id='end_date' and @disabled]"));
		Assert.assertTrue(EndDate.size()>0, "End date is Not Read only Mode");
		System.out.println("End date is Read only Mode");
		chiledTest.log(Status.INFO, "End date is Read only Mode");

		//Passing the Values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		RA.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		RA.ClickMatchedTextOption(driver);

		//Clicking Go Button
		RA.ClickGoBTN(driver);

		//Clicking on the Check Box
		RA.ClickCheckBox(driver);
		chiledTest.log(Status.INFO, "Check Box is Selected");

		//Clicking on the Finalize Button
		RA.ClickFinalizeBTN();
		chiledTest.log(Status.INFO, "Finalize Button is Clicked");

		Alert alert = driver.switchTo().alert();
		String Actual_Text = alert.getText();
		String Expected_Text = "Are you sure you want to finalize all the schedules? You will no longer be able to make any updates in the responses of these audit schedules";
		Assert.assertEquals(Actual_Text, Expected_Text, "Are you sure you want to finalize all the schedules? You will no longer be able to make any updates in the responses of these audit schedules Pop is Not Displayed");

		alert.dismiss();

		//Clicking on the Finalize Button
		RA.ClickFinalizeBTN();
		chiledTest.log(Status.INFO, "Finalize Button is Clicked");

		Alert alert1 = driver.switchTo().alert();
		String Actual_Text1 = alert.getText();
		String Expected_Text1 = "Are you sure you want to finalize all the schedules? You will no longer be able to make any updates in the responses of these audit schedules";
		Assert.assertEquals(Actual_Text1, Expected_Text1, "Are you sure you want to finalize all the schedules? You will no longer be able to make any updates in the responses of these audit schedules Pop is Not Displayed");

		alert1.accept();

		//Checking the Bulk Finalize Tag pop up is displayed
		RA.VerifyBulkFinalizeTagPopUpIsDisplayed(driver);

		//Passing the Values to Bulk Finalize Tag Reason 
		String BFR = Lib.getCellValue(XLPATH, "Review Audit", 62, 0);
		RA.SetBulkFinalizeTagReason(BFR);
		chiledTest.log(Status.INFO, "Bulk Finalize Tag Reason is Entered");

		//Clicking on the Finalize Button Under Bulk Finalize tag Pop up
		RA.ClickBulkFinalizeTagPopUpFinalizeBTN();
		chiledTest.log(Status.INFO, "Finalize button is Clicked under Bulk Finalize Tag Pop Up");

		//Verifying Bulk finalized has been successfully done. Message is Displayed
		RA.VerifyBulkFinalizedHasBeenSuccessfullyDoneMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Bulk finalized has been successfully done. Message is Displayed");

		System.out.println("******************************************");

	}

	//Testing the Functionality of the Finalizing Eliminate SignOff Audit Test
	@Test(priority=13, dependsOnMethods= {"Bulk_Finalize_Test"})
	public void Validating_The_Score_Test() throws InterruptedException
	{
		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		System.out.println("Validating the Score Test");

		chiledTest = parentTest.createNode("Validating the Score Test");

		RA.ClickReviewAuditHeader(driver);

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
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
		String Expected_TotalScore = "60.0 / 150.0"; 
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
		String Expected_Compliances = "40.0";
		System.out.println("Expected Compliance is : " + Expected_Compliances);
		Assert.assertEquals(Actual_Compliances, Expected_Compliances, "Compliances % is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Compliances % are Matched");

		System.out.println("********************************");

	}

}

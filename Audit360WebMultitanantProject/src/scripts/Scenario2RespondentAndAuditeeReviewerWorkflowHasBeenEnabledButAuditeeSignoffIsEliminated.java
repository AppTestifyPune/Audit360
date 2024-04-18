package scripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AllocateIssuesPageTes;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.ConfigureAuditPageTest;
import pom.IssuesPageTest;
import pom.LoginPageTest;
import pom.MyAuditsPageTest;
import pom.RespondentWorkFlowTest;
import pom.ReviewAuditPageTest;
import pom.ReviewerWorkFlowTest;
import pom.SideMenuPageTest;
import pom.UploadAnnexureDocumentPageTest;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditSchedulePageTest;
import pom.ConfigureAuditPageTest;
import pom.LoginPageTest;

public class Scenario2RespondentAndAuditeeReviewerWorkflowHasBeenEnabledButAuditeeSignoffIsEliminated extends BaseTest{

	//Scenario2: Under configure, audit screen Respondent workflow and Auditee reviewer workflow has been enabled and Auditee signoff is eliminated.
	@Test(priority=1) 
	public void Create_Audit_Type_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		parentTest = extent.createTest("Scenario2: Under configure, audit screen Respondent workflow and Auditee reviewer workflow has been enabled and Auditee signoff is eliminated.", "Testing the Functionality Respondent and Reviewer WorkFlow..");

		chiledTest = parentTest.createNode("Create Audit Type Page Test");

		System.out.println("Create Audit Type Page Test");

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

		System.out.println("*******************************************");

	}

	//Creating the General Sub Audit type
	@Test(priority=2, dependsOnMethods= {"Create_Audit_Type_Page_Test"}) 
	public void Creating_General_Group_Sub_Audit_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating General Group Sub Audit Test");

		System.out.println("Creating General Group Sub Audit Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//*********** Begin Tab ***************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 3, 0);
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

		System.out.println("********************************************");

	}

	//Testing the Functionality of the Creating Annexure Sub Audit Type For Dynamic Test
	@Test(priority=3, dependsOnMethods= {"Creating_General_Group_Sub_Audit_Test"})
	public void Creating_Annexure_Sub_Audit_Type_For_Dynamic_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Sub Audit Type For Dynamic Test");

		System.out.println("Creating Annexure Sub Audit Type For Dynamic Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//*********** Begin Tab ***************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 4, 0);
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
	@Test(priority=4, dependsOnMethods= {"Creating_Annexure_Sub_Audit_Type_For_Dynamic_Group_Test"})
	public void Creating_Annexure_Sub_Audit_Type_For_Static_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Sub Audit Type For Static Group Test");

		System.out.println("Creating Annexure Sub Audit Type For Static Group Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//***************** Begin Tab ***************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 5, 0);
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
	@Test(priority=5, dependsOnMethods= {"Creating_Annexure_Sub_Audit_Type_For_Static_Group_Test"})
	public void Creating_Parent_Audit_Type_With_One_General_Group_And_Two_Annexue_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		System.out.println("Creating Parent Audit Type With One General Group And Two Annexure Group Test");

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		SoftAssert SoftAssertion = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
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

		//Clicking on the Sub Audit Type Radio Button
		CA.ClickSubAuditTypeRadioBTN();
		chiledTest.log(Status.INFO, "Sub Audit Type Radio Button is Clicked");

		//Clicking on the select Group type
		String SA1 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 3, 0);
		CA.SetSelectSubAudittype(SA1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA3 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 4, 0);
		CA.SetSelectSubAudittype(SA3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA4 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 5, 0);
		CA.SetSelectSubAudittype(SA4, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//selecting last option under Entries Fileds
		CA.SetShowAndRow(driver);
		
		//Checking the Select Check Point group is Selected or not
		List<WebElement> SCG = driver.findElements(By.xpath("//div[@id='s2id_groups_']/ul[@class='select2-choices']"));
		int SCGCount = SCG.size();
		SoftAssertion.assertTrue(SCGCount>0, "Checkpoint Group is Not Selected");

		//Checking the Check Point table is displayed
		boolean Table = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']")).isDisplayed();
		System.out.println("Check Point grid is Displayed : " + Table);

		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 12;
		SoftAssertion.assertEquals(CPCount, CPCount1, "12 Check Points are Not Displayed");

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

		//Clicking on the Do you need to eliminate auditee Sign Off ? Taggle Button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need to eliminate auditee Sign Off ? Taggle Button is enabled");

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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Finalize Tab *************************

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

		//Passing the Values to Scond TO
		String ST1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 148, 0);
		CA.SetSecondTo(ST1, driver);

		//Passing the Values to Scond Out Come
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

		SoftAssertion.assertAll();

	}

	//Testing the Functionality of the Upload Document page
	@Test(priority=6, dependsOnMethods= {"Creating_Parent_Audit_Type_With_One_General_Group_And_Two_Annexue_Group_Test"})
	public void Uploading_Annexure_Documnet_Page_Test() throws InterruptedException
	{

		LoginPageTest l=new LoginPageTest(driver);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Uploading Annexure Documenet Page Test");

		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Static Annexure*******************");

		System.out.println("*********Uploading the Annexure Document for Static Annexure*******************");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

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

		UA.ClickScrollBar(driver);

		UA.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annecxure is Clicked Under Side Menu");

		UA.ClickAnnexureDocuments(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents is Clicked");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clikcing on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'S2SSAT')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		Thread.sleep(1000);
		String AnnexureType = driver.findElement(By.xpath("//div[@class='form-group form-group-default annexure_type block']/span[@id='annexure_type']")).getText();
		System.out.println("Displayed Annexure Type is : " + AnnexureType);

		String Static = "Static";

		Assert.assertEquals(AnnexureType, Static);

		//Uploading Documents
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
		String SA1 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		UA.SetAuditType(SA1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'S2DSAT')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		Thread.sleep(1000);
		String AnnexureType1 = driver.findElement(By.xpath("//div[@class='form-group form-group-default annexure_type block']/span[@id='annexure_type']")).getText();
		System.out.println("Displayed Annexure Type is : " + AnnexureType1);

		String Dynamic = "Dynamic";

		Assert.assertEquals(AnnexureType1, Dynamic);

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

	//Testing the Functionality of the Validating The Uploaded Documnets Test
	@Test(priority=7, dependsOnMethods= {"Uploading_Annexure_Documnet_Page_Test"})
	public void Validating_The_Uploaded_Documents_Test() throws InterruptedException
	{
		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Validating The Uploaded Documnets Test");

		System.out.println("Validating The Uploaded Documnets Test");

		//Passing the Values to Sub Audit Type
		String SA = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 4, 0);
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
		String SA1 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 5, 0);
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

		System.out.println("*****************************************");

	}

	//Configuring the Auditee admin configuration
	@Test(priority=8, dependsOnMethods= {"Validating_The_Uploaded_Documents_Test"})
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

		//clicking on the Auditee admin Configure under side menu
		SM.clickAuditeeAdminConfigure();

		AA.ClickSelectAuditType();

		//passing the values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		AA.SetSetAuditType(SA);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA1 = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 4, 0);
		AA.SetIssueAssignment(IA1);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA2 = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 5, 0);
		AA.SetIssueAssignment(IA2);

		AA.ClickMatchedText();

		//Passing the Values to Respond issue
		String RI2 = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 4, 1);
		AA.SetRespondIssue(RI2);

		AA.ClickMatchedText();

		//clicking on the Save button
		AA.ClickSaveBTN();

		//Verifying Auditee configuration successfully done message is Displayed
		AA.VerifyAuditeeConfigurationSuccessfullyDoneMsGIsDisplayed();

		System.out.println("******************************");

	}

	//Testing the Functionality of the Audit Schedule List page
	@Test(priority=9, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Schedule_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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

		//Clicking on the schedule 
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
		String SAT = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
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

		System.out.println("***********************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=10, dependsOnMethods= {"Creating_Schedule_Test"})
	public void Executing_Audit_Type_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Executing The Auidt Type Test");

		System.out.println("Executing The Auidt Type Test");

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

		WebDriverWait wait = new WebDriverWait(driver, 40);

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
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
		String AT3 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		System.out.println("************** Executing the Genral Sub Audit Type*****************");

		chiledTest.log(Status.INFO, "************** Executing the Sub Genral Audit Type*****************");

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 3, 0); 
		AE.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "General Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER11);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER12 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER12);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER23 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER23);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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

		//Passing the Values to Enter Confidential Remarks
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

		//Clikcing on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");


		System.out.println("*********************Executing Dynamic Sub Audit Type***********************");

		chiledTest.log(Status.INFO, "*********************Executing Dynamic Sub Audit Type*********************");

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 5, 0);
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
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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
		chiledTest.log(Status.INFO, "NO Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER123 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER234 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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

		//Passing the Values to Enter Confidential Remarks
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

		//Clikcing on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("*********************Executing 2nd Sub Audit Under Dynamic Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 2nd Sub Audit Under Dynamic Annexure*********************");

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
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER1231 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER1231);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2341 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER2341);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER3451 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER3451);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
		String ECR3451 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR3451);
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
		String Input71 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input71);
		String Input81 = Input71.toLowerCase();

		String Input91 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input91, Input81);

		//Passing the Values to Input Text fields
		String IV61 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV61, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("***********Executing 3rd Sub Audit Under Dynamic Annexure***************");

		chiledTest.log(Status.INFO, "**********Executing 3rd Sub Audit Under Dynamic Annexure**************");

		//Passing the Values to Search Button
		String SB51 = Lib.getCellValue(XLPATH, "Configure Audit Type", 137, 0);
		AE.SetSearchBTN(SB51);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR);

		AE.ClickMatched();

		//Entering the Reason
		driver.findElement(By.xpath("//textarea[@id='not_found_reason']")).sendKeys("Reason Test");

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***********Executing 4th Sub Audit Type under Dynmaic Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 4th Sub Audit Type under Dynamic Annexure Group ***************");

		driver.navigate().refresh();

		//Passing the Values to Search Button
		String SB6 = Lib.getCellValue(XLPATH, "Configure Audit Type", 138, 0);
		AE.SetSearchBTN(SB6);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR1 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR1);

		AE.ClickMatched();

		//Entering the Reason
		driver.findElement(By.xpath("//textarea[@id='not_found_reason']")).sendKeys("Reason Test");

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		//Clikcing on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		System.out.println("**************Executing Static Annexure Sub Audit Type*******************");

		chiledTest.log(Status.INFO, "**************Executing Static Annexure Sub Audit Type*******************");


		//Passing the Values to Search Text Filed
		String SB41 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 4, 0);
		AE.SetSearchBTN(SB41);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		System.out.println("*********************Executing 1st Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 1st Sub Audit Group Under Static Annexure*********************");

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
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter Confidential Remarks
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
		chiledTest.log(Status.INFO, "NO Dispositons are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER123111 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidental Remarks
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

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER234111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidental Remarks
		String ECR234111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR234111);
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

		//Passing the Values to Enter confidental Remarks
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
		String Input711 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input711);
		String Input811 = Input711.toLowerCase();

		String Input911 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input911, Input811);

		//Passing the Values to Input Text fields
		String IV611 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV611, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clikcing on the Finish Button
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
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidental Remarks
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER1231111 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER1231111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidental Remarks
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2341111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER2341111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidental Remarks
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER3451111 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER3451111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidental Remarks
		String ECR3451111 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR3451111);
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
		String Input7111 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input type is : " + Input7111);
		String Input8111 = Input7111.toLowerCase();

		String Input9111 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		Assert.assertEquals(Input9111, Input8111);

		//Passing the Values to Input Text fields
		String IV6111 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV6111, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clikcing on the Finish Button
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
		driver.findElement(By.xpath("//textarea[@id='not_found_reason']")).sendKeys("Reason Test");

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
		driver.findElement(By.xpath("//textarea[@id='not_found_reason']")).sendKeys("Reason Test");

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		//Clikcing on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Clicking on the Submit Audit Button
		AE.ClickSubmitAuditBTN(driver);
		chiledTest.log(Status.INFO, "Submit Audit Button is Clicked");

		//Verifying Submitted successfully success Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Submitted successfully success Message is Displayed");

		System.out.println("***************************************************");

	}

	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(priority=11, dependsOnMethods= {"Executing_Audit_Type_Test"}) 
	public void Allocating_Issues_Test() throws InterruptedException{

		chiledTest = parentTest.createNode("Allocate Issue Pages Test");

		System.out.println("Allocating The Issues Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		LoginPageTest l= new LoginPageTest(driver);

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

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Clicking on the Go Button
		AI.ClickGOBTN(driver);

		//Checking Auditee User Drop down should not be Display
		AI.VerifyAuditeesDropdownShouldNotBeDisplay(driver);
		
		//checking Auditee Drop down should not be display
		AI.VerifyAuditeesDropdownShouldNotBeDisplay(driver);
		
		//Passing the Values to Search Box
		String SB = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AI.SetSearchBox(SB);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");
		
		//Clicking on the Select Respondent
		AI.ClickSelectRespondent();

		//Passing the Values to Select Respondent
		String SR = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		AI.SetSelectRespondent(SR);
		chiledTest.log(Status.INFO, "Repondent is Selected");

		AI.ClickMatched(driver);

		//Clicking on the check Box
		AI.ClickCheckBox(driver);
		chiledTest.log(Status.INFO, "Clicked on the Check Box");

		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		//Verifying Allocated Successfully Success Message is Displayed
		AI.VerifyAllocatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Allocated Successfully Success Message is Displayed");

		//Passing the Values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AI.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Annexure Sub Audit is Searched");

		//clicking on the Select Auditee Reviewer
		AI.ClickSelectAuditeeReviewer();

		//Passing the Values to Select Reviewer
		String SR1 = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		AI.SetSelectReviewer(SR1);
		chiledTest.log(Status.INFO, "Reviewer is Selected");

		AI.ClickMatched(driver);

		//Clicking on the check Box
		AI.ClickCheckBox(driver);
		chiledTest.log(Status.INFO, "Clicked on the Check Box");

		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		//Verifying Allocated Successfully Success Message is Displayed
		AI.VerifyAllocatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Allocated Successfully Success Message is Displayed");

		//Passing the Values to Search Box
		String SB2 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		AI.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "Annexure Sub Audit is Searched");

		//clicking on the Select Auditee Reviewer
		AI.ClickSelectAuditeeReviewer();

		//Passing the Values to Select Reviewer
		String SR2 = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		AI.SetSelectReviewer(SR2);
		chiledTest.log(Status.INFO, "Reviewer is Selected");

		AI.ClickMatched(driver);

		//Clicking on the check Box
		AI.ClickCheckBox(driver);
		chiledTest.log(Status.INFO, "Clicked on the Check Box");

		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		//Verifying Allocated Successfully Success Message is Displayed
		AI.VerifyAllocatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Allocated Successfully Success Message is Displayed");

		System.out.println("********************************************************");

	}

	//Testing the Functionality of the Finalize Audit
	@Test(priority=12, dependsOnMethods= {"Allocating_Issues_Test"})
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
		String SB = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing and Finalizing Static Annxure Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Static Annxure Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 5, 0);
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

		System.out.println("*****************Reviewing and Finalizing dynamic Annxure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing dynamic Annxure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA1 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 4, 0);
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);
		
		//clicking on the Select All Checkpoints
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
		String SA2 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 3, 0);
		RA.SetSubAudits(SA2);

		RA.ClickMatchedTextOption(driver);
		
		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		//Clicking on the Main Audit Finalize button
		RA.ClickMainAuditFinalizeBTN();

		//verifying Audit Finalized Successfully message is displayed
		RA.VerifyAuditFinalizedSuccessfullySuccessMsgIsDisplayed(driver);

		System.out.println("************************************************");

	}

	//Testing Functionality of the Issues Should Not Be Display For Reviewer Test
	/*@Test(priority=13, dependsOnMethods= {"Finalize_Audit_Test"}) 
	public void Responding_The_Issues_By_Respondednt_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		IssuesPageTest IP = new IssuesPageTest(driver);

		chiledTest = parentTest.createNode("Responding the Issues By Respondent Test");

		System.out.println("Responding the Issues By Respondent Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 60, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the Values to Select Parent Audit Type
		String SPA = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		IP.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Selected");

		IP.ClickMatched(driver);

		IP.ClickGoBTN(driver);
		

		//Passing the Not Mapped Group Name
		String SS1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		IP.setSearchBox(SS1, driver);
		chiledTest.log(Status.INFO, "Not Mapped Group Name is Searched");

		//checking No matching records found Message is Displayed
		IP.VerifyNoMatchingRecordsFoundIsDisplayed(driver);
		chiledTest.log(Status.INFO, "No matching records found Messag is Displayed");

		//Passing the Not Mapped Group Name
		String SS2 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		IP.setSearchBox(SS2, driver);
		chiledTest.log(Status.INFO, "Not Mapped Group Name is Searched ");

		//checking No matching records found Message is Displayed
		IP.VerifyNoMatchingRecordsFoundIsDisplayed(driver);
		chiledTest.log(Status.INFO, "No matching records found Message is Displayed");

		IP.ClickSelectIssuesStatus(driver);

		//Passing the Values to Issue Status
		String SS = Lib.getCellValue(XLPATH, "Issues", 47, 0);
		IP.SetSelectIssuesStatus(SS);
		chiledTest.log(Status.INFO, "Accepted Status is Selected under issue Status");

		IP.ClickMatched(driver);

		IP.ClickGoBTN(driver);
		

		//Passing the  Mapped Group Name
		String SS3 = Lib.getCellValue(XLPATH, "Group", 8, 0);
		IP.setSearchBox(SS3, driver);
		chiledTest.log(Status.INFO, "Mapped Group Name is Searched");

		IP.ClickSelectAll(driver);

		//Passing the Values to Comments
		String IC = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		IP.SetIssueComments(IC);
		chiledTest.log(Status.INFO, "Comment is Entered");

		//Clicking on the Respond Issue Button
		IP.ClickRespondIssueBTN(driver);
		chiledTest.log(Status.INFO, "Respond Issue Button is Clicked");

		//Verifying Issue Updated Successfully Message is Displayed
		IP.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issue Updated Successfully Mesage is Displayed");

		System.out.println("***********************************************");

	}

	//Testing Functionality of the Issues Should Not Be Display For Reviewer Test
	@Test(priority=14, dependsOnMethods= {"Responding_The_Issues_By_Respondednt_Test"}) 
	public void Responding_The_Issues_By_Reviewer_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		IssuesPageTest IP = new IssuesPageTest(driver);

		chiledTest = parentTest.createNode("Responding the Issues By Reviewer Test");

		System.out.println("Responding the Issues By Reviewer Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 68, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		IP.ClickScrollBar(driver);

		IP.ClickIssues(driver);

		//Passing the Values to Select Parent Audit Type
		String SPA1 = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		IP.SetSelectParentAuditType(SPA1);
		chiledTest.log(Status.INFO, "Parent Audit Type is Selected");

		IP.ClickMatched(driver);

		IP.ClickSelectIssuesStatus(driver);

		//Passing the Values to Issue Status
		String SS = Lib.getCellValue(XLPATH, "Issues", 47, 0);
		IP.SetSelectIssuesStatus(SS);
		chiledTest.log(Status.INFO, "Accepted Status is Selected under issue Status");

		IP.ClickMatched(driver);

		IP.ClearSearchBox();

		IP.ClickGoBTN(driver);
		

		//Clicking on the Select All Check box
		IP.ClickSelectAll(driver);

		//Passing the Values to Comments
		String IC1 = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		IP.SetIssueComments(IC1);
		chiledTest.log(Status.INFO, "Comment is Entered");

		//Clicking on the Respond Issue Button
		IP.ClickRespondIssueBTN(driver);
		chiledTest.log(Status.INFO, "Respond Issue Button is Clicked");

		//Verifying Issue Updated Successfully Message is Displayed
		IP.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issue Updated Successfully Mesage is Displayed");

		System.out.println("***********************************************");


	}

	//Testing Functionality of the Issues Should Not Be Display For Reviewer Test
	@Test(priority=15, dependsOnMethods= {"Responding_The_Issues_By_Reviewer_Test"}) 
	public void Complying_The_Issues_By_Auditee_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		IssuesPageTest IP = new IssuesPageTest(driver);

		chiledTest = parentTest.createNode("Complying the Issues By Reviewer Test");

		System.out.println("Complying the Issues By Reviewer Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
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

		IP.ClickScrollBar(driver);

		IP.ClickIssues(driver);

		//Passing the Values to Select Parent Audit Type
		String SPA = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		IP.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Selected");

		IP.ClickMatched(driver);

		IP.ClearSearchBox();

		IP.ClickGoBTN(driver);
		

		IP.ClickSelectIssuesStatus(driver);

		//Passing the Values to Issue Status
		String SS = Lib.getCellValue(XLPATH, "Issues", 55, 0);
		IP.SetSelectIssuesStatus(SS);
		chiledTest.log(Status.INFO, "Responded Status is Selected under issue Status");

		IP.ClickMatched(driver);

		IP.ClickGoBTN(driver);
		

		IP.ClickSelectAll(driver);

		//Checking Comply Issue Button is Displayed
		IP.VerifyComplyIssueButtonIsDisplayed(driver);

		//Checking Rework Button is Displayed
		IP.VerifyReWorkButtonIsDisplayed(driver);

		//Passing the Values to Comments
		String IC1 = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		IP.SetIssueComments(IC1);
		chiledTest.log(Status.INFO, "Comment is Entered");

		//Clicking on the Comply Issue Button
		IP.ClickComplyIssueBTN(driver);
		chiledTest.log(Status.INFO, "Comply Issue Button is Clicked");

		//Verifying Issue Updated Successfully Message is Displayed
		IP.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issue Updated Successfully Mesage is Displayed");


		System.out.println("***********************************************");

	}

	//Testing Functionality of the Resolving the Issues Reviewer Test
	@Test(priority=16, dependsOnMethods= {"Complying_The_Issues_By_Auditee_Test"}) 
	public void Resloving_The_Issues_By_Reviewer_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		IssuesPageTest IP = new IssuesPageTest(driver);

		chiledTest = parentTest.createNode("Resloving the Issues By Reviewer Test");

		System.out.println("Resloving the Issues By Reviewer Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 68, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		IP.ClickScrollBar(driver);

		IP.ClickIssues(driver);

		//Passing the Values to Select Parent Audit Type
		String SPA = Lib.getCellValue(XLPATH, "Respondent Reviewer Scenario2", 6, 0);
		IP.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Selected");

		IP.ClickMatched(driver);

		IP.ClearSearchBox();

		IP.ClickGoBTN(driver);
		

		IP.ClickSelectIssuesStatus(driver);

		//Passing the Comply to Issue Status
		String SS = Lib.getCellValue(XLPATH, "Issues", 57, 0);
		IP.SetSelectIssuesStatus(SS);
		chiledTest.log(Status.INFO, "Comply Status is Selected under issue Status");

		IP.ClickMatched(driver);

		IP.ClickGoBTN(driver);
		
		IP.ClickSelectAll(driver);

		//Checking the ReWork Button is Displayed
		IP.VerifyReWorkButtonIsDisplayed(driver);

		//Checking the Resolve Button is Displayed
		IP.VerifyResloveIssueButtonIsDisplayed(driver);

		//Passing the Values to Comments
		String IC1 = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		IP.SetIssueComments(IC1);
		chiledTest.log(Status.INFO, "Comment is Entered");

		//Clicking on the Comply Issue Button
		IP.ClickResloveIssueBTN(driver);
		chiledTest.log(Status.INFO, "Reslove Issue Button is Clicked");

		//Verifying Issue Updated Successfully Message is Displayed
		IP.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issue Updated Successfully Mesage is Displayed");

		System.out.println("***********************************************");

	}*/

}

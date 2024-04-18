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
import pom.CheckPointPageTest;
import pom.ConfigureAuditPageTest;
import pom.GroupPageTest;
import pom.LoginPageTest;
import pom.ReviewAuditPageTest;
import pom.SideMenuPageTest;
import pom.UploadAnnexureDocumentPageTest;

public class ExceptionalGroupsFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Creating Group Audit Type test
	@Test(priority=5)
	public void Creating_Exceptional_Sub_Audit_Type_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		parentTest = extent.createTest("Exceptional Group Functionality Test", "Testing the Functionality of the List Group, Add Group, Edit Group and Single Delete Group Test");

		chiledTest = parentTest.createNode("Creating Exceptional Sub Audit Type Test");

		System.out.println("Creating Exceptional Sub Audit Type Test");

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
		String ATN2 = Lib.getCellValue(XLPATH, "Exceptional Group", 5, 1);
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Define Tab ***********************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 29, 0);
		CA.SetSelectGrouptype(SGT1);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG1 = Lib.getCellValue(XLPATH, "Group", 12, 0);
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

		System.out.println("*****Creating one more Exceptional sub audit******");

		chiledTest.log(Status.INFO, "*****Creating one more Exceptional sub audit******");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN21 = Lib.getCellValue(XLPATH, "Exceptional Group", 6, 1);
		CA.SetAuditTypeName(ATN21, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT21 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT21, driver);
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
		String SGT11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 29, 0);
		CA.SetSelectGrouptype(SGT11);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG2 = Lib.getCellValue(XLPATH, "Group", 13, 0);
		CA.SetSelectCheckPointGroup(SCG2, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		//Passing the Values to Search Text box
		String SB = Lib.getCellValue(XLPATH, "Exceptional Group", 5, 1);
		CA.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Created the Audit Type is Serached");

		Thread.sleep(4000);

		//Checking SN0
		boolean SN0 = driver.findElements(By.xpath("//table[@id='tableAuditTypes']/tbody/tr[1]/td[1]")).size()>0;
		System.out.println("SNO is Displayed : " + SN0);

		String GroupName = driver.findElement(By.xpath("//table[@id='tableAuditTypes']/tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(SB, GroupName);

		WebElement ParentAudityType = driver.findElement(By.xpath("//table[@id='tableAuditTypes']/tbody/tr[1]/td[3]"));
		String No = ParentAudityType.getText();
		System.out.println("Parent Audity Type is : " + No);
		Assert.assertEquals("No", No);

		//Checking Time stamp
		boolean TimeStamp = driver.findElements(By.xpath("//table[@id='tableAuditTypes']/tbody/tr[1]/td[4]")).size()>0;
		System.out.println("Time Stamp is Displayed : " + TimeStamp);

		System.out.println("****************************************************************");

	}

	//Testing the Functionality of the Creating Group Audit Type test
	@Test(priority=6, dependsOnMethods= {"Creating_Exceptional_Sub_Audit_Type_Test"})
	public void Creating_General_Sub_Audit_Type_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Genearl Sub Audit Type Test");

		System.out.println("Creating General Sub Audit Type Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 1);
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

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


	//Testing the Functionality of the Creating Annexure Sub Audit Type For Static Group Test
	@Test(priority=7, dependsOnMethods= {"Creating_General_Sub_Audit_Type_Test"})
	public void Creating_Annexure_Sub_Audit_Type_For_Static_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Sub Audit Type For Static Group Test");

		System.out.println("Creating Annexure Sub Audit Type For Static Group Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating One More Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "Exceptional Group", 4, 1);
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//************************** Define Tab **************************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 28, 0);
		CA.SetSelectGrouptype(SGT1);
		chiledTest.log(Status.INFO, "Annexure Group Type is Selected");

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

		System.out.println("******************************************************");

	}

	//Testing the Functionality of the Eliminate Auditee Sign Off Test, Should capturing image be mandatory for main audit ?, Do you need to eliminate auditee respondent workflow ?, Do you need to eliminate auditee reviewer workflow ? and Do you need to finalize audits in bulk ?
	@Test(priority=8, dependsOnMethods= {"Creating_Annexure_Sub_Audit_Type_For_Static_Group_Test"})
	public void Creating_Audit_Type_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Audit Type Test");

		System.out.println("Creating Audit Type Test");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 2);
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
		String SA3 = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 1);
		CA.SetSelectSubAudittype(SA3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA4 = Lib.getCellValue(XLPATH, "Exceptional Group", 4, 1);
		CA.SetSelectSubAudittype(SA4, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA5 = Lib.getCellValue(XLPATH, "Exceptional Group", 5, 1);
		CA.SetSelectSubAudittype(SA5, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA6 = Lib.getCellValue(XLPATH, "Exceptional Group", 6, 1);
		CA.SetSelectSubAudittype(SA6, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//selecting last option under Entries Fields
		CA.SetShowAndRow(driver);

		//Checking the Select Check Point group is Selected or not
		List<WebElement> SCG = driver.findElements(By.xpath("//div[@id='s2id_groups_']/ul[@class='select2-choices']"));
		int SCGCount = SCG.size();
		Assert.assertTrue(SCGCount>0, "Check Point group is not Selected");

		//Checking the Check Point table is displayed
		boolean Table = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']")).isDisplayed();
		System.out.println("Check Point grid is Displayed : " + Table);

		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 16;
		Assert.assertEquals(CPCount, CPCount1, "Check Points Counts are Wrong");

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

		//Clicking on the Do you need to eliminate auditee sign off ? Toggle Button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need to eliminate auditee sign off ? Toggle Button is Enabled");

		//Do you need annexure score ? Toggle Button
		CA.ClickAnnexureScoreTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need annexure score ? Toggle Button is enabled");

		//Do you need annexure Sampling ? Toggle Button
		CA.ClickAnnexureSamplingTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need annexure Sampling ? Toggle Button is enabled");

		//Clicking on the Do you need to finalize audits in bulk ?
		CA.ClickBulkFinalizeTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need to finalize audits in bulk ? Toggle Button is Enabled");

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

		//******************** Finalize Tab ************************

		Thread.sleep(5000);

		//Checking Total Count
		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		double d = 300.0;
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

		//Verifying Please enter valid max score Error Message is Displayed
		CA.VerifyPleaseEnterValidMaxScoreErrorMSGISDisplayed();

		//Passing the Invalid Exceptional Max Deduction
		String MD = Lib.getCellValue(XLPATH, "Configure Audit Type", 163, 0);
		CA.SetMaxDeduction(MD);
		chiledTest.log(Status.INFO, "Invalid Exceptional Max Deduction is Entered");

		//Verifying Please enter valid max score Error Message is Displayed
		CA.VerifyPleaseEnterValidMaxScoreErrorMSGISDisplayed();

		//Passing the Valid Exceptional Max Deduction
		String MD1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 164, 0);
		CA.SetMaxDeduction(MD1);
		chiledTest.log(Status.INFO, "Valid Exceptional Max Deduction is Entered");

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully. Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully. Success Message is Displayed");

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Uploading Annexure Document for Audit Type
	@Test(priority=9, dependsOnMethods= {"Creating_Audit_Type_Test"})
	public void Uploading_Annexure_Documenet_Test() throws InterruptedException
	{

		LoginPageTest l=new LoginPageTest(driver);

		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Uploading Annexure Document Test");

		System.out.println("Uploading Annexure Documenet Test");

		System.out.println("*********Uploading the Annexure Document for Static Annexure*******************");

		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Static Annexure*******************");

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
		String SA = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 2);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Static')]")).click();

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

		System.out.println("*************************************************************************");

	}

	//Configuring the Auditee admin configuration
	@Test(priority=10, dependsOnMethods= {"Uploading_Annexure_Documenet_Test"})
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
		String SA = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 2);
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
	@Test(priority=11, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
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
		String SAT = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 2);
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
	@Test(priority=12, dependsOnMethods= {"Creating_Schedule_Test"})
	public void Executing_Audit_Type_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Executing Audit Type Test");

		System.out.println("Executing Audit Type Test");	

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
		String AT2 = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 2);
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
		String AT3 = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 2);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 1); 
		AE.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "General Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		AE.Clicknormal(driver);

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
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

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

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);


		System.out.println("*********************Executing 1st Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 1st Sub Audit Group Under Static Annexure*********************");

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "Exceptional Group", 4, 1);
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

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);


		AE.ClearPiSearchBTN();

		//Clicking on the Mark Pending Pi as Not Executed
		AE.ClickMarkPendingPIAsNotExecuted();

		//Clicking on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("*************Exceuting 1st Exceptional Sub Audits Through Normal Mode**********");

		chiledTest.log(Status.INFO, "*********Exceuting 1st Exceptional Sub Audits Through Normal Mode*******");

		//Passing the Values to Search Text Filed
		String SB3 = Lib.getCellValue(XLPATH, "Exceptional Group", 5, 1); 
		AE.SetSearchBTN(SB3);
		chiledTest.log(Status.INFO, "General Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		AE.Clicknormal(driver);

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//checking only Yes and NO button should display
		AE.VerifyOnlyYesAndNoButtonsDisplayed(driver);

		//Passing the Values to Enter Remarks
		String ER16 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER16);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR16 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR16);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//clicking on the Skip Button
		AE.ClickSkipButton();

		//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		AE.VerifyAreYouSureYouWantToSkipAllNonAttentedNegativeCheckpointsPopUpIsDisplayed();

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up Cancel Button
		AE.ClickSkipCancelButton();

		//clicking on the Skip Button
		AE.ClickSkipButton();

		//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		AE.VerifyAreYouSureYouWantToSkipAllNonAttentedNegativeCheckpointsPopUpIsDisplayed();

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up OK Butto
		AE.ClickSkipOKButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("*************Exceuting 1st Exceptional Sub Audits Through Express Mode**********");

		chiledTest.log(Status.INFO, "*********Exceuting 1st Exceptional Sub Audits Through Express Mode*******");

		//Passing the Values to Search Text Filed
		String SB41 = Lib.getCellValue(XLPATH, "Exceptional Group", 6, 1); 
		AE.SetSearchBTN(SB41);
		chiledTest.log(Status.INFO, "General Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		//clicking on the Express Mode
		AE.ClickExpress(driver);
		chiledTest.log(Status.INFO, "Express Button Is Clicked");

		//clicking on the Exceptional Group Tab
		AE.ClickExceptionalGroupTab();

		Thread.sleep(5000);

		//Validating Total 3 Checkpoints are Displayed or Not
		List<WebElement> NoOfCheckpoints = driver.findElements(By.xpath("//ul[@id='sortable8']/li"));
		int Actual_NoOfCheckpoints = NoOfCheckpoints.size();
		int Expected_NoOfCheckpoints = 3;
		Assert.assertEquals(Actual_NoOfCheckpoints, Expected_NoOfCheckpoints, "Total 3 Checkpoints are NOT Displayed");
		System.out.println("Toatl 3 Checkpoints are displayed");
		chiledTest.log(Status.INFO, "Toatl 3 Checkpoints are displayed");

		System.out.println("*****Dragging 1st checkpoint to Yes Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 1st checkpoint to Yes Compliance********");
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement CP1 = driver.findElement(By.xpath("//ul[@id='sortable8']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP1));
		WebElement Yes = driver.findElement(By.xpath("//ul[@class='cps moved negativeSortable placeholder yes_labels ui-sortable']"));
		wait.until(ExpectedConditions.visibilityOf(Yes));
		action.dragAndDrop(CP1, Yes).build(). perform();
		System.out.println("First Checkpoint is Dragged to Yes");
		chiledTest.log(Status.INFO, "First Checkpoint is Dragged to Yes");

		Thread.sleep(2000);

		System.out.println("*****Dragging 2nd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 2nd checkpoint to NO Compliance********");

		WebElement CP2 = driver.findElement(By.xpath("//ul[@id='sortable8']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP2));
		WebElement NO = driver.findElement(By.xpath("//ul[@class='cps moved negativeSortable placeholder no_labels ui-sortable']"));
		wait.until(ExpectedConditions.visibilityOf(NO));
		action.dragAndDrop(CP2, NO).build(). perform();
		chiledTest.log(Status.INFO, "2nd Checkpoint is Dragged to No");
		System.out.println("2nd Checkpoint is Dragged to NO");

		//clicking on the Skip Button
		AE.ClickSkipButton();

		/*//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		AE.VerifyAreYouSureYouWantToSkipAllTheUnattemptedExceptionalCheckpointsPopUpIsDisplayed();

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up Cancel Button
		AE.ClickSkipCancelButton();

		//clicking on the Skip Button
		AE.ClickSkipButton();

		//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		AE.VerifyAreYouSureYouWantToSkipAllTheUnattemptedExceptionalCheckpointsPopUpIsDisplayed();*/

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up OK Butto
		AE.ClickSkipOKButton();

		//Clicking on the Exceptional Group Next button
		AE.ClickExceptionalGroupNextButton();

		//********* Input Tab ********

		//Passing the Values to Date
		String SD = Lib.getCellValue(XLPATH, "Audit Execution", 43, 0);
		AE.SetDate(SD, driver);

		//Passing the Values to Percentage
		String PN = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetPercentage(PN);

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Butto is Clicked");

		//******** Summary Tab *******

		//Passing the Values to Remarks
		String ER = Lib.getCellValue(XLPATH, "Audit Execution", 107, 0);
		AE.SetExpressRemarks(ER);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Clicking on the Submit Button
		AE.ClickExpressModeSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		//clicking on the Submit Audit Button
		AE.ClickSubmitAuditBTN(driver);

		//Verifying Submitted successfully Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);


		System.out.println("**********************************");

	}

	//Testing the Functionality of the Finalize Audit
	@Test(priority=13, dependsOnMethods= {"Executing_Audit_Type_Test"})
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
		String SB = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 2);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing and Finalizing Static Annxure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Static Annxure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA = Lib.getCellValue(XLPATH, "Exceptional Group", 4, 1);
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

		System.out.println("*****************Reviewing and Finalizing 1st general Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing 1st general Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA1 = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 1);
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing 1st Exceptional Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing 1st Exceptional Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA2 = Lib.getCellValue(XLPATH, "Exceptional Group", 5, 1);
		RA.SetSubAudits(SA2);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing 2nd Exceptional Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing 2nd Exceptional Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA3 = Lib.getCellValue(XLPATH, "Exceptional Group", 6, 1);
		RA.SetSubAudits(SA3);

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

		System.out.println("**************************************************************");

	}
}

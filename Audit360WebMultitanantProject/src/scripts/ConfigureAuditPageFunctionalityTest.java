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
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.ConfigureAuditPageTest;
import pom.EditAuditTypePageTest;
import pom.LoginPageTest;

public class ConfigureAuditPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Configure Audit page
	@Test(priority=1)
	public void Configure_Audit_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		parentTest = extent.createTest("Configure Audit Functionality Test", "Testing the Configure Audit Page, Creating Audit Type, Search, Edit, etc..");

		chiledTest = parentTest.createNode("Configure Audit Page Test");

		System.out.println("Configure Audit Page Test");

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

		//Verifying Audit type Page is Displayed
		CA.VerifyAuditTypePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type Page is Displayed");

		System.out.println("******************************************************");


	}

	//Testing the Functionality of the Creating Group Audit Type test
	@Test(priority=2)
	public void Creating_General_Sub_Audit_Type_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Genearl Sub Audit Type Test");

		System.out.println("Creating General Sub Audit Type Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 4, 0);
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

		//Passing the Values to Search Text box
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 4, 0);
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


	//Testing the Functionality of the Creating Annexure Sub Audit Type For Dynamic Test
	@Test(priority=3, enabled=false)
	public void Creating_Annexure_Sub_Audit_Type_For_Dynmaic_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Sub Audit Type For Dynamic Test");

		System.out.println("Creating Annexure Sub Audit Type For Dynamic Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 7, 0);
		CA.SetAuditTypeName(ATN1, driver);
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

		System.out.println("**************************************************************");

	}


	//Testing the Functionality of the Creating Annexure Sub Audit Type For Static Group Test
	@Test(priority=4, enabled=false)
	public void Creating_Annexure_Sub_Audit_Type_For_Static_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Sub Audit Type For Static Group Test");

		System.out.println("Creating Annexure Sub Audit Type For Static Group Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating One More Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 9, 0);
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

	//Testing the Functionality of the Creating Group Audit Type test
	@Test(priority=5, enabled=false)
	public void Creating_Exceptional_Sub_Audit_Type_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Exceptional Sub Audit Type Test");

		System.out.println("Creating Exceptional Sub Audit Type Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 13, 0);
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
		String SCG1 = Lib.getCellValue(XLPATH, "Group", 11, 0);
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

		System.out.println("******* Creating one more Exceptional Sub Audit Type************");

		chiledTest.log(Status.INFO, "****** Creating one more Exceptional Sub Audit Type**********");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN21 = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
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
		String SCG11 = Lib.getCellValue(XLPATH, "Group", 12, 0);
		CA.SetSelectCheckPointGroup(SCG11, driver);
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
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 14, 0);
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
	@Test(priority=6)
	public void Creating_Same_Group_Audit_Type_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Same Genearl Group Audit Type Test");

		System.out.println("Creating Same General Group Audit Type Test");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 4, 0);
		CA.SetAuditTypeName(ATN, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Verifying Audit type name already exist! Error Message is Displayed
		CA.VerifyAuditTypeNameAlreadyExistErrorMSGIsDisplayed();
	
		System.out.println("*************************************************");

	}


	//Testing the Functionality of the Eliminate Auditee Sign Off Test, Should capturing image be mandatory for main audit ?, Do you need to eliminate auditee respondent workflow ?, Do you need to eliminate auditee reviewer workflow ? and Do you need to finalize audits in bulk ?
	@Test(priority=7, enabled=false)
	public void Creating_Audit_Type_with_Issue_Tracking_Test() throws InterruptedException
	{
		driver.navigate().refresh();

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Audit Type with Issue Tracking Test");

		System.out.println("Creating Audit Type with Issue Tracking Test");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
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
		String SA3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 9, 0);
		CA.SetSelectSubAudittype(SA3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the select Group type
		String SA4 = Lib.getCellValue(XLPATH, "Configure Audit Type", 7, 0);
		CA.SetSelectSubAudittype(SA4, driver);

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
		int CPCount1 = 8;
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

		//Checking all the Issues Toggle Buttons are Displaying or Not
		CA.VerifyingAllIssueToggleButtonsAreDisplayed();

		//Clicking on the Do you need to eliminate auditee sign off ? Toggle Button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need to eliminate auditee sign off ? Toggle Button is Enabled");

		//Do you need annexure score ? Toggle Button
		CA.ClickAnnexureScoreTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need annexure score ? Toggle Button is enabled");

		//Do you need annexure Sampling ? Toggle Button
		CA.ClickAnnexureSamplingTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need annexure Sampling ? Toggle Button is enabled");

		CA.ClickImageMandatoryTaggleBTN();
		chiledTest.log(Status.INFO, "Should capturing image be mandatory for main audit ? Toggle Button is Enabled");

		//Clicking on the Do you need to finalize audits in bulk ?
		CA.ClickBulkFinalizeTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need to finalize audits in bulk ? Toggle Button is Enabled");

		//Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed
		CA.ClickAuditorRemarksTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need checkpoint remarks as mandatory at checkpoint level? by opting this option, express mode audit execution will not be allowed ? Toggle Button is Enabled");

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

		//Verifying Audit type created successfully. Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully. Success Message is Displayed");

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of edit Audit Type
	@Test(priority=8, enabled=false)
	public void Edit_Audit_Type_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Edit Auidt Type Test");

		System.out.println("Edit Auidt Type Test");

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		//Passing the values to Search Box
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		CA.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Audit type is Searched");

		CA.ClickFirstAuditType(driver);

		//Clicking on the Email Preferences
		CA.ClickEmailPreference();

		//Passing the Values to Email Preferences
		String EP = Lib.getCellValue(XLPATH, "Email and Preference", 3, 0);
		CA.SetEmailPreference(EP);
		chiledTest.log(Status.INFO, "Email Preferences is Entered");

		//Clicking on the Match
		CA.ClickMatch();

		//Passing the Values to Remainders
		String SR = Lib.getCellValue(XLPATH, "Reminder", 3, 0);
		CA.SetRemainders(SR);
		chiledTest.log(Status.INFO, "Remainders is Entered");

		//Clicking on the Match
		CA.ClickMatch();

		//Clicking on the Save Button
		CA.ClickSaveBTN();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Audit type updated successfully Message is Displayed
		CA.VerifyAuditTypeUpdatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type updated successfully Message is Displayed");

		System.out.println("*************************************************");

	}

	//Testing the Functionality of the Creating Group Audit Type test
	@Test(priority=9)
	public void Audit_CheckPoints_Should_Contains_CheckPoints_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Audit CheckPoints Should Contains CheckPoints Test");

		System.out.println("Audit CheckPoints Should Contains CheckPoints Test");

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
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

		//************** Define Tab*******************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG = Lib.getCellValue(XLPATH, "Configure Audit Type", 31, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit CheckPoints Should Contain CheckPoints Error Message
		CA.VerifyAuditCheckPointsShouldContainCheckPointsErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit CheckPoints Should Contain CheckPoints Error Message");

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Entering More Than 50 Characters Test
	@Test(priority=10, enabled = false)
	public void Entering_More_Than_50_Charecters_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Entering More Than 50 Characters Test");

		System.out.println("Entering More Than 50 Characters Test");

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
		CA.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 5, 0);
		CA.SetAuditTypeName(ATN, driver);
		chiledTest.log(Status.INFO, "More Than 50 Characters Audit Name is Entered");

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// *************** Define Tab ****************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 15, 0);
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

		Assert.fail("Audit Type Name Is Accepting More than 50 Chareters");

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the General Group Should Not Accept Annexure Score And Annexure Sampling Test
	@Test(priority=11)
	public void Annexure_Score_And_Annexure_Sampling_Toggle_Buttons_should_not_show_For_Audit_Type_which_Is_Mapped_To_Only_General_Group_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Annexure Score And Annexure Sampling Toggle Buttons should not show for Audit Type which is Mapped to only General Group Test");

		System.out.println("Annexure Score And Annexure Sampling Toggle Buttons should not show for Audit Type which is Mapped to only General Group Test");

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
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

		//Verifying Annexure scoring and Annexure Sampling Toggle Buttons should not Displayed
		CA.VerifyAnnexureScoringAndAnnexureSamplingToggleButtonsShouldNotShow();

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Group and Sub Audit Type Radio Buttons 
	@Test(priority=12)
	public void Group_And_Sub_Audit_Type_Radio_Buttons_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Group And Sub Audit Type Radio Buttons Test");

		System.out.println("Group And Sub Audit Type Radio Buttons Test");

		driver.navigate().refresh();

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
		CA.ClickParentTypeAuditRadioBTN(driver);
		System.out.println("Parent Audit Type Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Parent Audit Type Radio Button is Clicked");

		//Checking Group Radio Button is Selected
		boolean GR1 = driver.findElement(By.xpath("//input[@id='type_group'][@checked='checked']")).isSelected();
		System.out.println("Group Radio Button is Selected : " + GR1);
		chiledTest.log(Status.INFO, "Group Radio Button is Selected");

		CA.ClickSubAuditTypeRadioBTN();
		chiledTest.log(Status.INFO, "Sub Audit Type Radio Button is Clicked");

		//Checking Sub Audit Type Radio Button is Selected
		boolean SR1 = driver.findElement(By.xpath("//input[@id='type_sub_audit_type']")).isSelected();
		System.out.println("Sub Audit Type Radio Button is Selected : " + SR1);
		chiledTest.log(Status.INFO, "Sub Audit Type Radio Button is Selected");

		//Checking Group Radio Button is Selected
		boolean GR2 = driver.findElement(By.xpath("//input[@id='type_group'][@checked='checked']")).isSelected();
		System.out.println("Group Radio Button is Selected : " + GR2);
		chiledTest.log(Status.INFO, "Group Radio Button is Selected");

		driver.navigate().refresh();

		System.out.println("***********************************************");

	}

	//Testing the Functionality of the Creating Group Audit Type test
	@Test(priority=13)
	public void AuditType_Mandatory_Field_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("AuditType Mandatory Field Test");

		System.out.println("AuditType Mandatory Field Test");

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//clicking on the Begin Tab Next Button
		CA.ClickBeginTabNextButton();

		//Verifying Begin Tab Mandatory fields
		CA.VerifyBeginTabMandatoryFields(driver);

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

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CA.VerifyDefineTabMandatoryFileds(driver);

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Checking select auditee Type is Multiple select or not
		List<WebElement> SelectAuditeeType = driver.findElements(By.xpath("//Select[@name='groups[]' and @required='required' and @multiple='multiple']"));
		Assert.assertTrue(SelectAuditeeType.size()>0, "Select Auditee Type is Not Working as Mutiple select");
		System.out.println("Select Auditee Type is Working as Mutiple select");
		chiledTest.log(Status.INFO, "Select Auditee Type is Working as Mutiple select");

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************
		
		CA.ClickBeginTabNextButton();

		CA.VerifyBeginTabMandatoryFields(driver);

		//Passing the Values to Audit Type Name
		String ATN1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		CA.SetAuditTypeName(ATN1, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT1, driver);
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

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT1);
		chiledTest.log(Status.INFO, "General Group Type is Selected");

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

		CA.ClickEvaluteTabNextButton();

		CA.VerifyEvaluateTabMandatoryFileds(driver);

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

		CA.VerifyConfigureTabMandatoryFields(driver);

		//Clicking on the Select verifier
		CA.clickSelectVerifier();

		//Passing the Values to Select Verifier
		String SV = Lib.getCellValue(XLPATH, "Configure Audit Type", 58, 0);
		CA.SetSelectVerifier(SV);
		chiledTest.log(Status.INFO, "Verifier is Selected");

		//Clicking on the Match
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		//*************** Finalize Tab *************************

		CA.VerifyFinalizeTabMandatoryFields(driver);

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		System.out.println("********************************************");
	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=14, enabled=false)
	public void Delete_Parent_AuditType_Test() throws InterruptedException
	{
		driver.navigate().refresh();

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Delete Parent AuditType Test");

		System.out.println("Delete Parent AuditType Test");	

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
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

		//Checking the Select Check Point group is Selected or not
		List<WebElement> SCG1 = driver.findElements(By.xpath("//div[@id='s2id_groups_']/ul[@class='select2-choices']"));
		int SCGCount = SCG1.size();
		Assert.assertTrue(SCGCount>0, "Check Point group is Not Selected");

		//Checking the Check Point table is displayed
		boolean Table = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']")).isDisplayed();
		System.out.println("Check Point grid is Displayed : " + Table);

		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 4;
		Assert.assertEquals(CPCount, CPCount1, "Check Points Count are Wrong");

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

		// Checking Annexure Scoring and Annexure Sampling toggle buttons should not show
		CA.VerifyAnnexureScoringAndAnnexureSamplingToggleButtonsShouldNotShow();

		//Should capturing image be mandatory for main audit ? Toggle Button
		CA.ClickImageMandatoryTaggleBTN();
		chiledTest.log(Status.INFO, "Should capturing image be mandatory for main audit ? Toggle Button is enabled");

		//Enabling on the Do you need to finalize audits in bulk ?
		CA.ClickBulkFinalizeTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need to finalize audits in bulk ? Toggle Button is enabled");

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

		Thread.sleep(5000);

		//Checking the Total Count
		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
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

		//Deleting the Audit Ratings
		List<WebElement> DeleteBTN = driver.findElements(By.xpath("//a[@class='btn btn-rounded btn-danger remove_field remove_nested_fields']"));
		int Actual_DeleteBTN = DeleteBTN.size();
		int Expected_DeleteBTN = 3;
		Assert.assertEquals(Actual_DeleteBTN, Expected_DeleteBTN, "Delete Button count is showing wrong");
		for(int i=0; i<DeleteBTN.size(); i++)
		{
			DeleteBTN.get(i).click();

			//checking the Audit Rating Pop Up is Displayed or Not
			CA.VerifyAuditRatingDeletePopUpIsDisplayed(driver);

			//Clicking on the Ok Button
			CA.ClickOKBTN();
		}

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully. Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully. Success Message is Displayed");

		//Passing the Values to Search Text box
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
		CA.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Created the Audit Type is Serached");

		//clicking on the audit Type
		CA.ClickFirstAuditType(driver);

		EditAuditTypePageTest EA = new EditAuditTypePageTest(driver);

		//clicking on the Delete Button
		EA.ClickDeleteButton();

		//verifying Are you sure?, You want to delete audit type
		EA.VerifyAreYouSureYouWantToDeleteAuditTypePopUpIsDisplayed();

		//clicking on the OK Button
		EA.ClickOKButton();

		//verifying Audit type was successfully destroyed Success Message is Displayed
		EA.VerifyAuditTypeWasSuccessfullyDestroyedSuccessMSGIsDisplayed();

		//Passing the Values to Search Text box
		String SB1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
		CA.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "Created the Audit Type is Serached");

		//verifying no data found error message is displayed
		CA.VerifyNoDataAvailableInTableMsgIsDisplayed(driver);

		System.out.println("**************************************************************");


	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=15, enabled=false)
	public void Multiple_Reviewer_Toggle_Button_Test() throws InterruptedException
	{
		driver.navigate().refresh();

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Multiple Reviewer Toggle Button Test");

		System.out.println("Multiple Reviewer Toggle Button Test");	

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.navigate().refresh();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
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

		//Checking the Select Check Point group is Selected or not
		List<WebElement> SCG1 = driver.findElements(By.xpath("//div[@id='s2id_groups_']/ul[@class='select2-choices']"));
		int SCGCount = SCG1.size();
		Assert.assertTrue(SCGCount>0, "Check Point group is Not Selected");

		//Checking the Check Point table is displayed
		boolean Table = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']")).isDisplayed();
		System.out.println("Check Point grid is Displayed : " + Table);

		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 4;
		Assert.assertEquals(CPCount, CPCount1, "Check Points Count are Wrong");

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

		//clicking on the Allow multiple level review
		CA.ClickAllowMultiLevelReviewToggleBTN();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//selecting Level 1 under 1st row
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[1]//td/select[@class='full-width multi_review_priority_level select2-offscreen']/option[@value='1']")).click();

		//Selecting Reviewer Under level 1 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[1]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='Reviewer']")).click();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//selecting Level 1 under 2nd row
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[2]//td/select[@class='full-width multi_review_priority_level select2-offscreen']/option[@value='1']")).click();

		//Selecting super admin Under level 2 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[2]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='SuperAdmin']")).click();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//selecting Level 3 under 3rd row
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[3]//td/select[@class='full-width multi_review_priority_level select2-offscreen']/option[@value='3']")).click();

		//Selecting Reviewer 1 Under level 3 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[3]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='Reviewer']")).click();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//selecting Level 5 under 4th row
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[4]//td/select[@class='full-width multi_review_priority_level select2-offscreen']/option[@value='5']")).click();

		//Selecting Reviewer Under level 4 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[4]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='Reviewer']")).click();
		
		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//selecting Level 2 under 5th row
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[5]//td/select[@class='full-width multi_review_priority_level select2-offscreen']/option[@value='3']")).click();

		//Selecting Super admin Under level 4 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[5]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='SuperAdmin']")).click();

		//checking add button should be disabled after 5 times click
		CA.VerifyAddButtonIsDisabled();
		
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

		Thread.sleep(5000);

		//Checking the Total Count
		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
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
		CA.VerifyAuditTypeMultipleReviewRoleShouldNotBeDuplicateErrorMessageIsDisplayed();

		System.out.println("*******************************");

	}

}

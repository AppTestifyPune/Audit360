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
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.CheckPointPageTest;
import pom.ConfigureAuditPageTest;
import pom.GroupPageTest;
import pom.LoginPageTest;
import pom.ReviewAuditPageTest;
import pom.ReviewCheckpointsPageTest;
import pom.SideMenuPageTest;

public class RemovingNAAndPartailComplianceNormalModeFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Group List 
	@Test(priority=1)
	public void Creating_The_Group_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

		parentTest = extent.createTest("Removing NA and Partial Compliance in Normal Mode Test", "Testing the Functionality Removing NA and Partial Compliance in Normal Mode  Test");

		chiledTest = parentTest.createNode("Creating Group Test");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		System.out.println("Creating Group Test");

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
		
	}
		
        /*//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 3, 0);
		AG.SetGroupType(SG);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 17, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 9, 0);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("**********************************************");

	}

	//Testing the Functionality of the Add Checkpoints
	@Test(priority=2, dependsOnMethods= {"Creating_The_Group_Test"})
	public void Adding_The_Checkpoints_Test() throws InterruptedException
	{
		chiledTest = parentTest.createNode("Adding the Checpoints Test");

		System.out.println("Adding the Checkpoints Test");

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("************Creating the Checkpoint which has both NA and Partial is enabled*****************");

		chiledTest.log(Status.INFO, "***********Creating the Checkpoint which has both NA and Partial is enabled****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 9, 0);
		CC.SetSearchBTN(SS);

		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB5 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB5);

		//Passing Values to NO Text Box
		String NB5 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB5);

		//Passing the Values to Yes Disposition
		String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD5);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to NA Disposition
		String ND115 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND115);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL5 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL5);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA5 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA5);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}else {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Checkpoint both are Disabled*****************");

		chiledTest.log(Status.INFO, "************Creating Checkpoint both are Disabled ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI51 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CC.SetEnterCheckpointintent(ECI51, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS51 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		CC.SetDescription(DS51);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA51 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA51);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB51 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB51);

		//Passing Values to NO Text Box
		String NB51 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB51);

		//Clicking on the Partial Check box
		CC.ClickPartialCheckBox();

		//Clicking on the NA Check Box
		CC.ClickNaCheckBox();

		//Passing the Values to Yes Disposition
		String YD51 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD51);

		//Passing the Values to No Disposition
		String ND51 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND51);

		//Passing the Values to Partial Disposition
		String PD51 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD51);

		//Passing the Values to NA Disposition
		String ND1151 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);

		CC.SetNADisposition(ND1151);
		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL51 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL51);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA51 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA51);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG1 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG1)).isDisplayed()){
			String Atcual_Text = SuccessMSG1.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}else {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating the Checkpoint which has enabled only Partial Compliance*****************");

		chiledTest.log(Status.INFO, "***********Creating the Checkpoint which has enabled only Partial Compliance****************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA7 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA7);
		chiledTest.log(Status.INFO, "Both Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB7);

		//Passing Values to NO Text Box
		String NB7 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB7);

		//Clicking on the NA Compliance
		CC.ClickNaCheckBox();

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//Passing the Values to Data type Values
		String SV17 = Lib.getCellValue(XLPATH, "Check Point", 140, 0);
		CC.SetDataTypeValues(SV17, driver);

		//Passing the Values to Data type Values
		String SV27 = Lib.getCellValue(XLPATH, "Check Point", 141, 0);
		CC.SetDataTypeValues(SV27, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG2 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG2)).isDisplayed()){
			String Atcual_Text = SuccessMSG2.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}else {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("*************Creating the Checkpoint which has enabled only NA Compliance*****************");

		chiledTest.log(Status.INFO, "*************Creating the Checkpoint which has enabled only NA Compliance***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		CC.SetDescription(DS8);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA8 = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		CC.SetExpectedActionFromAuditor(EA8);
		chiledTest.log(Status.INFO, "Both with Condtions Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB8);

		//Passing Values to NO Text Box
		String NB8 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB8);

		//Clicking on the Partial Compliance 
		CC.ClickPartialCheckBox();

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD8);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);//119
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
		CC.SetDataType(SD41);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL8 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL8);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected Under Risk Level");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG3 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG3)).isDisplayed()){
			String Atcual_Text = SuccessMSG3.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}else {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}


		System.out.println("***********Creating Input Type Checkpoint *************");

		chiledTest.log(Status.INFO, "******Creating Input Type Checkpoint **********");

		//Passing the Values to the Enter Checkpoint intent
		String ECI6 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI6, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS6 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS6);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA6 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
		CC.SetExpectedActionFromAuditor(EA6);
		chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD6 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD6);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL6 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
		CC.SetRiskLevel(RL6);
		chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA6 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA6);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

		System.out.println("***************************************************");

	}*/

	//Creating the Audit Type
	@Test(priority=3/*, dependsOnMethods= {"Adding_The_Checkpoints_Test"}*/)
	public void Creating_AuditType_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		LoginPageTest l = new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Parent Audit Type Test");

		System.out.println("Creating Parent Audit Type Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

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

		//clicking on Scroll Bar Under side menu
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
		String ATN = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 13, 0);
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

		//Clicking on the select Group 
		CA.ClickSelectGrouptype(driver);

		//Passing the values to  select Group type
		String SGT = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 3, 0);
		CA.SetSelectGrouptype(SGT);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 9, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();


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


		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = driver.switchTo().alert();
		Alert.dismiss();

		//******** CONFIGURE  TAB **************

		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Eliminate Auditee signoff Taggle is Enabled");

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


		//******************** Finalize Tab ************************

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

	}


	//Configuring the Auditee admin configuration
	@Test(priority=4, dependsOnMethods= {"Creating_AuditType_Test"})
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
		String SA = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 13, 0);
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


	//Testing the Functionality of the Add Checkpoints
	@Test(priority=5, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l = new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Schedule Test");

		System.out.println("Creating Schedule Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

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
		String SAT = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 13, 0);
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
	@Test(priority=6, dependsOnMethods= {"Creating_Schedule_Test"})
	public void Audit_Execution_With_Normal_Mode_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Audit Execution With Normal Mode Test");

		System.out.println("Audit Execution With Normal Mode Test");

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
		String AT2 = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 13, 0);
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
		String AT3 = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 13, 0);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickNotStartedBTN(driver);
		chiledTest.log(Status.INFO, "Not Start Button Is Clicked");

		//Clicking on the Normal mode
		AE.Clicknormal(driver);

		System.out.println("************Checking all the(yes, No, Partial and NA) buttons are Displayed************");

		chiledTest.log(Status.INFO, "Checking all the(yes, No, Partial and NA) buttons are Displayed");

		Thread.sleep(3000);

		//Adding Digital Evd to CP1 
		AE.CheckpointLevelUploadDocuments(driver);

		//Passing the Values to Enter Remarks
		String ER1 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER1);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR1 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		AE.VerifyAllButtonsDisplayed(driver);

		//Clicking on the Yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("************Checking only Yes and NO buttons are Displayed************");

		chiledTest.log(Status.INFO, "Checking only Yes and NO buttons are Displayed");

		Thread.sleep(25000);

		//Adding Digital Evd to CP2
		AE.CheckpointLevelUploadDocuments(driver);

		//Passing the Values to Enter Remarks
		String ER2 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER2);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR2 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR2);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		AE.VerifyOnlyYesAndNoButtonsDisplayed(driver);

		//Clicking on the Yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("************Checking Yes NO and Partial buttons are Displayed************");

		chiledTest.log(Status.INFO, "Checking Yes NO and Partial buttons are Displayed");

		Thread.sleep(25000);

		//Adding Digital Evd to CP3 
		AE.CheckpointLevelUploadDocuments(driver);

		//Passing the Values to Enter Remarks
		String ER3 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER3);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR3 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR3);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		AE.VerifyOnlyYesNoAndPartialButtonsDisplayed(driver);

		//Clicking on the Yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("************Checking Yes NO and NA buttons are Displayed************");

		chiledTest.log(Status.INFO, "Checking Yes NO and NA buttons are Displayed");

		Thread.sleep(25000);

		//Adding Digital Evd to CP4 
		AE.CheckpointLevelUploadDocuments(driver);

		//Passing the Values to Enter Remarks
		String ER4 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER4);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR4 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR4);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		AE.VerifyOnlyYesNoAndNAButtonsDisplayed(driver);

		//Clicking on the Yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		String IV = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("************Checking Yes NO NA and Partial buttons are Not Displayed************");

		chiledTest.log(Status.INFO, "Checking Yes NO NA and Partial buttons are Not Displayed");

		Thread.sleep(25000);

		//Adding Digital Evd to CP5
		AE.CheckpointLevelUploadDocuments(driver);

		//Passing the Values to Enter Remarks
		String ER5 = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER5);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR5 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR5);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		AE.VerifyAllButtonsAreNotDisplayed(driver);

		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV1, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("****************************************************");

	}

	//Testing the Functionality of the Review Audit Page Test
	@Test(priority=7, dependsOnMethods= {"Audit_Execution_With_Normal_Mode_Test"})
	public void Compliance_Should_Display_Under_Review_Audit_Page() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		ReviewCheckpointsPageTest RC = new ReviewCheckpointsPageTest(driver);

		chiledTest = parentTest.createNode("Compliance Should Display Under Review Audit Page");

		System.out.println("Compliance Should Display Under Review Audit Page");

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
		String SB = Lib.getCellValue(XLPATH, "NA and Partial Normal Mode", 13, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		RA.ClickFirstCheckPoint();

		//clicking on the Checkpoint Edit button
		RA.ClickCheckpointEditBTN();

		System.out.println("****Validating the 1st CP Details****");

		chiledTest.log(Status.INFO, "****Validating the 1st CP Details***");

		//**********Checking the CP name***********
		String Actual_CPName = driver.findElement(By.xpath("//input[@id='check_point_name']")).getAttribute("value");
		String Expected_CPName = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		Assert.assertEquals(Actual_CPName, Expected_CPName, "Checkpoint Intant name is showing Wrong");
		System.out.println("Checkpoint name is Matched");
		chiledTest.log(Status.INFO, "Checkpoint name is Matched");

		//Checking the CP name is Read only mode
		WebElement CP = driver.findElement(By.xpath("//input[@id='check_point_name' and @readonly='readonly']"));
		Assert.assertTrue(CP.isDisplayed(), "Checkpoint Intent Name is not Read only mode");
		System.out.println("Checkpoint Intent is Readonly mode");
		chiledTest.log(Status.INFO, "Checkpoint Intent is Readonly mode");

		//********Checking the Definition**********
		String Actual_Definition = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea")).getAttribute("value");
		String Expected_Definition = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		Assert.assertEquals(Actual_Definition, Expected_Definition, "Definition is showing Wrong");
		System.out.println("Definition is Matched");
		chiledTest.log(Status.INFO, "Definition is Matched");

		//Checking the Definition is Read only mode
		WebElement Definition = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea[@disabled]"));
		Assert.assertTrue(Definition.isDisplayed(), "Definition is not Read only mode");
		System.out.println("Definition is Readonly mode");
		chiledTest.log(Status.INFO, "Definition is Readonly mode");

		//********Checking the High is selected under Risk Level**********
		String Actual_RiskLevel = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select//option[@selected='selected']")).getText();
		String Expected_RiskLevel = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		Assert.assertEquals(Actual_RiskLevel, Expected_RiskLevel, "Risk Level is showing Wrong");
		System.out.println("Risk Level is Matched");
		chiledTest.log(Status.INFO, "Risk Level is Matched");

		//Checking the RiskLevel is Read only mode
		WebElement RiskLevel = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select[@disabled]"));
		Assert.assertTrue(RiskLevel.isDisplayed(), "Risk Level is not Read only mode");
		System.out.println("Risk Level is Readonly mode");
		chiledTest.log(Status.INFO, "Risk Level is Readonly mode");

		//*******Checking Auditee Comments is Read only mode**********
		WebElement AuditeeComments = driver.findElement(By.xpath("//textarea[@id='auditee_remarks' and @disabled='disabled']"));
		Assert.assertTrue(AuditeeComments.isDisplayed(), "Auditee Comments is not Read only mode");
		System.out.println("Auditee Comments is Readonly mode");
		chiledTest.log(Status.INFO, "Auditee Comments is Readonly mode");

		//********Checking the Notes to Auditor**********
		String Actual_NTA = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor']")).getText();
		String Expected_NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		Assert.assertEquals(Actual_NTA, Expected_NTA, "//textarea[@id='notes_to_auditor'] is showing Wrong");
		System.out.println("notes to auditor is Matched");
		chiledTest.log(Status.INFO, "notes to auditor is Matched");

		//Checking the Notes to Auditor is Read only mode
		WebElement NTA = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor' and @disabled='disabled']"));
		Assert.assertTrue(NTA.isDisplayed(), "Notes to Auditor is not Read only mode");
		System.out.println("Notes to Auditor is Readonly mode");
		chiledTest.log(Status.INFO, "Notes to Auditor is Readonly mod");

		//Checking the auditor Digital Evidence documents
		RC.VerifyingAuditorDigitalEvidencesFilesAreDisplayed();

		//Checking the Auditor Confidential Digital Evidences documents
		RC.VerifyingAuditorConfidentialDigitalEvidencesFilesAreDisplayed();

		RC.VerifyYesComplianceIsDisplayed();

		RC.VerifyNoComplianceIsDisplayed();

		RC.VerifyPartialComplianceIsDisplayed();

		RC.VerifyNAComplianceIsDisplayed();

		//clicking on the cancel button
		RC.ClicKCancelBTN();

		System.out.println("********Validating the 2nd CP Details ************");

		chiledTest.log(Status.INFO, "*****Validating the 2nd CP Details*****t");

		RA.ClickFirstCheckPoint();

		RA.ClickSecondCheckPoint();

		RA.ClickCheckpointEditBTN();

		//**********Checking the CP name***********
		String Actual_CPName1 = driver.findElement(By.xpath("//input[@id='check_point_name']")).getAttribute("value");
		String Expected_CPName1 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		Assert.assertEquals(Actual_CPName1, Expected_CPName1, "Checkpoint Intant name is showing Wrong");
		System.out.println("Checkpoint name is Matched");
		chiledTest.log(Status.INFO, "Checkpoint name is Matched");

		//Checking the CP name is Read only mode
		WebElement CP1 = driver.findElement(By.xpath("//input[@id='check_point_name' and @readonly='readonly']"));
		Assert.assertTrue(CP1.isDisplayed(), "Checkpoint Intent Name is not Read only mode");
		System.out.println("Checkpoint Intent is Readonly mode");
		chiledTest.log(Status.INFO, "Checkpoint Intent is Readonly mode");

		//********Checking the Definition**********
		String Actual_Definition1 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea")).getAttribute("value");
		String Expected_Definition1 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		Assert.assertEquals(Actual_Definition1, Expected_Definition1, "Definition is showing Wrong");
		System.out.println("Definition is Matched");
		chiledTest.log(Status.INFO, "Definition is Matched");

		//Checking the Definition is Read only mode
		WebElement Definition1 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea[@disabled]"));
		Assert.assertTrue(Definition1.isDisplayed(), "Definition is not Read only mode");
		System.out.println("Definition is Readonly mode");
		chiledTest.log(Status.INFO, "Definition is Readonly mode");

		//********Checking the High is selected under Risk Level**********
		String Actual_RiskLevel1 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select//option[@selected='selected']")).getText();
		String Expected_RiskLevel1 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		Assert.assertEquals(Actual_RiskLevel1, Expected_RiskLevel1, "Risk Level is showing Wrong");
		System.out.println("Risk Level is Matched");
		chiledTest.log(Status.INFO, "Risk Level is Matched");

		//Checking the RiskLevel is Read only mode
		WebElement RiskLevel1 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select[@disabled]"));
		Assert.assertTrue(RiskLevel1.isDisplayed(), "Risk Level is not Read only mode");
		System.out.println("Risk Level is Readonly mode");
		chiledTest.log(Status.INFO, "Risk Level is Readonly mode");

		//*******Checking Auditee Comments is Read only mode**********
		WebElement AuditeeComments1 = driver.findElement(By.xpath("//textarea[@id='auditee_remarks' and @disabled='disabled']"));
		Assert.assertTrue(AuditeeComments1.isDisplayed(), "Auditee Comments is not Read only mode");
		System.out.println("Auditee Comments is Readonly mode");
		chiledTest.log(Status.INFO, "Auditee Comments is Readonly mode");

		//********Checking the Notes to Auditor**********
		String Actual_NTA1 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor']")).getText();
		String Expected_NTA1 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		Assert.assertEquals(Actual_NTA1, Expected_NTA1, "//textarea[@id='notes_to_auditor'] is showing Wrong");
		System.out.println("notes to auditor is Matched");
		chiledTest.log(Status.INFO, "notes to auditor is Matched");

		//Checking the Notes to Auditor is Read only mode
		WebElement NTA1 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor' and @disabled='disabled']"));
		Assert.assertTrue(NTA1.isDisplayed(), "Notes to Auditor is not Read only mode");
		System.out.println("Notes to Auditor is Readonly mode");
		chiledTest.log(Status.INFO, "Notes to Auditor is Readonly mod");

		//Checking the auditor Digital Evidence documents
		RC.VerifyingAuditorDigitalEvidencesFilesAreDisplayed();

		//Checking the Auditor Confidential Digital Evidences documents
		RC.VerifyingAuditorConfidentialDigitalEvidencesFilesAreDisplayed();

		RC.VerifyYesComplianceIsDisplayed();

		RC.VerifyNoComplianceIsDisplayed();

		RC.VerifyPartialComplianceIsNotDisplayed();

		RC.VerifyNAComplianceIsNotDisplayed();

		//Clicking on the Cancel Button
		RC.ClicKCancelBTN();

		System.out.println("********Validating the 3rd CP Details ************");

		chiledTest.log(Status.INFO, "*****Validating The 3rd CP Deatils******");

		RA.ClickSecondCheckPoint();

		RA.ClickThirdCheckPoint();

		RA.ClickCheckpointEditBTN();

		//**********Checking the CP name***********
		String Actual_CPName2 = driver.findElement(By.xpath("//input[@id='check_point_name']")).getAttribute("value");
		String Expected_CPName2 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		Assert.assertEquals(Actual_CPName2, Expected_CPName2, "Checkpoint Intant name is showing Wrong");
		System.out.println("Checkpoint name is Matched");
		chiledTest.log(Status.INFO, "Checkpoint name is Matched");

		//Checking the CP name is Read only mode
		WebElement CP2 = driver.findElement(By.xpath("//input[@id='check_point_name' and @readonly='readonly']"));
		Assert.assertTrue(CP2.isDisplayed(), "Checkpoint Intent Name is not Read only mode");
		System.out.println("Checkpoint Intent is Readonly mode");
		chiledTest.log(Status.INFO, "Checkpoint Intent is Readonly mode");

		//********Checking the Definition**********
		String Actual_Definition2 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea")).getAttribute("value");
		String Expected_Definition2 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		Assert.assertEquals(Actual_Definition2, Expected_Definition2, "Definition is showing Wrong");
		System.out.println("Definition is Matched");
		chiledTest.log(Status.INFO, "Definition is Matched");

		//Checking the Definition is Read only mode
		WebElement Definition2 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea[@disabled]"));
		Assert.assertTrue(Definition2.isDisplayed(), "Definition is not Read only mode");
		System.out.println("Definition is Readonly mode");
		chiledTest.log(Status.INFO, "Definition is Readonly mode");

		//********Checking the High is selected under Risk Level**********
		String Actual_RiskLevel2 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select//option[@selected='selected']")).getText();
		String Expected_RiskLevel2 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		Assert.assertEquals(Actual_RiskLevel2, Expected_RiskLevel2, "Risk Level is showing Wrong");
		System.out.println("Risk Level is Matched");
		chiledTest.log(Status.INFO, "Risk Level is Matched");

		//Checking the RiskLevel is Read only mode
		WebElement RiskLevel2 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select[@disabled]"));
		Assert.assertTrue(RiskLevel2.isDisplayed(), "Risk Level is not Read only mode");
		System.out.println("Risk Level is Readonly mode");
		chiledTest.log(Status.INFO, "Risk Level is Readonly mode");

		//*******Checking Auditee Comments is Read only mode**********
		WebElement AuditeeComments2 = driver.findElement(By.xpath("//textarea[@id='auditee_remarks' and @disabled='disabled']"));
		Assert.assertTrue(AuditeeComments2.isDisplayed(), "Auditee Comments is not Read only mode");
		System.out.println("Auditee Comments is Readonly mode");
		chiledTest.log(Status.INFO, "Auditee Comments is Readonly mode");

		//********Checking the Notes to Auditor**********
		String Actual_NTA2 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor']")).getText();
		String Expected_NTA2 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		Assert.assertEquals(Actual_NTA2, Expected_NTA2, "//textarea[@id='notes_to_auditor'] is showing Wrong");
		System.out.println("notes to auditor is Matched");
		chiledTest.log(Status.INFO, "notes to auditor is Matched");

		//Checking the Notes to Auditor is Read only mode
		WebElement NTA2 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor' and @disabled='disabled']"));
		Assert.assertTrue(NTA2.isDisplayed(), "Notes to Auditor is not Read only mode");
		System.out.println("Notes to Auditor is Readonly mode");
		chiledTest.log(Status.INFO, "Notes to Auditor is Readonly mod");

		//Checking the auditor Digital Evidence documents
		RC.VerifyingAuditorDigitalEvidencesFilesAreDisplayed();

		//Checking the Auditor Confidential Digital Evidences documents
		RC.VerifyingAuditorConfidentialDigitalEvidencesFilesAreDisplayed();

		RC.VerifyYesComplianceIsDisplayed();

		RC.VerifyNoComplianceIsDisplayed();

		RC.VerifyPartialComplianceIsDisplayed();

		RC.VerifyNAComplianceIsNotDisplayed();

		//Clicking on the Cancel Button
		RC.ClicKCancelBTN();

		System.out.println("********Validating the 4th CP Details ************");

		chiledTest.log(Status.INFO, "*****Validating the 4th CP Details*****");

		RA.ClickThirdCheckPoint();

		RA.ClickFourthCheckPoint();

		RA.ClickCheckpointEditBTN();

		//**********Checking the CP name***********
		String Actual_CPName3 = driver.findElement(By.xpath("//input[@id='check_point_name']")).getAttribute("value");
		String Expected_CPName3 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		Assert.assertEquals(Actual_CPName3, Expected_CPName3, "Checkpoint Intant name is showing Wrong");
		System.out.println("Checkpoint name is Matched");
		chiledTest.log(Status.INFO, "Checkpoint name is Matched");

		//Checking the CP name is Read only mode
		WebElement CP3 = driver.findElement(By.xpath("//input[@id='check_point_name' and @readonly='readonly']"));
		Assert.assertTrue(CP3.isDisplayed(), "Checkpoint Intent Name is not Read only mode");
		System.out.println("Checkpoint Intent is Readonly mode");
		chiledTest.log(Status.INFO, "Checkpoint Intent is Readonly mode");

		//********Checking the Definition**********
		String Actual_Definition3 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea")).getAttribute("value");
		String Expected_Definition3 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		Assert.assertEquals(Actual_Definition3, Expected_Definition3, "Definition is showing Wrong");
		System.out.println("Definition is Matched");
		chiledTest.log(Status.INFO, "Definition is Matched");

		//Checking the Definition is Read only mode
		WebElement Definition3 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea[@disabled]"));
		Assert.assertTrue(Definition3.isDisplayed(), "Definition is not Read only mode");
		System.out.println("Definition is Readonly mode");
		chiledTest.log(Status.INFO, "Definition is Readonly mode");

		//********Checking the High is selected under Risk Level**********
		String Actual_RiskLevel3 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select//option[@selected='selected']")).getText();
		String Expected_RiskLevel3 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		Assert.assertEquals(Actual_RiskLevel3, Expected_RiskLevel3, "Risk Level is showing Wrong");
		System.out.println("Risk Level is Matched");
		chiledTest.log(Status.INFO, "Risk Level is Matched");

		//Checking the RiskLevel is Read only mode
		WebElement RiskLevel3 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select[@disabled]"));
		Assert.assertTrue(RiskLevel3.isDisplayed(), "Risk Level is not Read only mode");
		System.out.println("Risk Level is Readonly mode");
		chiledTest.log(Status.INFO, "Risk Level is Readonly mode");

		//*******Checking Auditee Comments is Read only mode**********
		WebElement AuditeeComments3 = driver.findElement(By.xpath("//textarea[@id='auditee_remarks' and @disabled='disabled']"));
		Assert.assertTrue(AuditeeComments3.isDisplayed(), "Auditee Comments is not Read only mode");
		System.out.println("Auditee Comments is Readonly mode");
		chiledTest.log(Status.INFO, "Auditee Comments is Readonly mode");

		//********Checking the Notes to Auditor**********
		String Actual_NTA3 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor']")).getText();
		String Expected_NTA3 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		Assert.assertEquals(Actual_NTA3, Expected_NTA3, "//textarea[@id='notes_to_auditor'] is showing Wrong");
		System.out.println("notes to auditor is Matched");
		chiledTest.log(Status.INFO, "notes to auditor is Matched");

		//Checking the Notes to Auditor is Read only mode
		WebElement NTA3 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor' and @disabled='disabled']"));
		Assert.assertTrue(NTA3.isDisplayed(), "Notes to Auditor is not Read only mode");
		System.out.println("Notes to Auditor is Readonly mode");
		chiledTest.log(Status.INFO, "Notes to Auditor is Readonly mod");

		//Checking the auditor Digital Evidence documents
		RC.VerifyingAuditorDigitalEvidencesFilesAreDisplayed();

		//Checking the Auditor Confidential Digital Evidences documents
		RC.VerifyingAuditorConfidentialDigitalEvidencesFilesAreDisplayed();

		RC.VerifyYesComplianceIsDisplayed();

		RC.VerifyNoComplianceIsDisplayed();

		RC.VerifyNAComplianceIsDisplayed();

		RC.VerifyPartialComplianceIsNotDisplayed();

		//Clicking on the Cancel Button
		RC.ClicKCancelBTN();

		System.out.println("********Validating 5th CP Details************");

		chiledTest.log(Status.INFO, "********Validating 5th CP Details************");

		RA.ClickFourthCheckPoint();

		RA.ClickfifthCheckPoint();

		RA.ClickCheckpointEditBTN();

		//**********Checking the CP name***********
		String Actual_CPName4 = driver.findElement(By.xpath("//input[@id='check_point_name']")).getAttribute("value");
		String Expected_CPName4 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		Assert.assertEquals(Actual_CPName4, Expected_CPName4, "Checkpoint Intant name is showing Wrong");
		System.out.println("Checkpoint name is Matched");
		chiledTest.log(Status.INFO, "Checkpoint name is Matched");

		//Checking the CP name is Read only mode
		WebElement CP4 = driver.findElement(By.xpath("//input[@id='check_point_name' and @readonly='readonly']"));
		Assert.assertTrue(CP4.isDisplayed(), "Checkpoint Intent Name is not Read only mode");
		System.out.println("Checkpoint Intent is Readonly mode");
		chiledTest.log(Status.INFO, "Checkpoint Intent is Readonly mode");

		//********Checking the Definition**********
		String Actual_Definition4 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea")).getAttribute("value");
		String Expected_Definition4 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		Assert.assertEquals(Actual_Definition4, Expected_Definition4, "Definition is showing Wrong");
		System.out.println("Definition is Matched");
		chiledTest.log(Status.INFO, "Definition is Matched");

		//Checking the Definition is Read only mode
		WebElement Definition4 = driver.findElement(By.xpath("//label[text()='Definition']//following-sibling::textarea[@disabled]"));
		Assert.assertTrue(Definition4.isDisplayed(), "Definition is not Read only mode");
		System.out.println("Definition is Readonly mode");
		chiledTest.log(Status.INFO, "Definition is Readonly mode");

		//********Checking the High is selected under Risk Level**********
		String Actual_RiskLevel4 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select//option[@selected='selected']")).getText();
		String Expected_RiskLevel4 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
		Assert.assertEquals(Actual_RiskLevel4, Expected_RiskLevel4, "Risk Level is showing Wrong");
		System.out.println("Risk Level is Matched");
		chiledTest.log(Status.INFO, "Risk Level is Matched");

		//Checking the RiskLevel is Read only mode
		WebElement RiskLevel4 = driver.findElement(By.xpath("//label[text()='Risk Level']//following-sibling::select[@disabled]"));
		Assert.assertTrue(RiskLevel4.isDisplayed(), "Risk Level is not Read only mode");
		System.out.println("Risk Level is Readonly mode");
		chiledTest.log(Status.INFO, "Risk Level is Readonly mode");

		//*******Checking Auditee Comments is Read only mode**********
		WebElement AuditeeComments4 = driver.findElement(By.xpath("//textarea[@id='auditee_remarks' and @disabled='disabled']"));
		Assert.assertTrue(AuditeeComments4.isDisplayed(), "Auditee Comments is not Read only mode");
		System.out.println("Auditee Comments is Readonly mode");
		chiledTest.log(Status.INFO, "Auditee Comments is Readonly mode");

		//********Checking the Notes to Auditor**********
		String Actual_NTA4 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor']")).getText();
		String Expected_NTA4 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		Assert.assertEquals(Actual_NTA4, Expected_NTA4, "//textarea[@id='notes_to_auditor'] is showing Wrong");
		System.out.println("notes to auditor is Matched");
		chiledTest.log(Status.INFO, "notes to auditor is Matched");

		//Checking the Notes to Auditor is Read only mode
		WebElement NTA4 = driver.findElement(By.xpath("//textarea[@id='notes_to_auditor' and @disabled='disabled']"));
		Assert.assertTrue(NTA4.isDisplayed(), "Notes to Auditor is not Read only mode");
		System.out.println("Notes to Auditor is Readonly mode");
		chiledTest.log(Status.INFO, "Notes to Auditor is Readonly mod");

		//Checking the auditor Digital Evidence documents
		RC.VerifyingAuditorDigitalEvidencesFilesAreDisplayed();

		//Checking the Auditor Confidential Digital Evidences documents
		RC.VerifyingAuditorConfidentialDigitalEvidencesFilesAreDisplayed();

		RC.VerifyYesComplianceIsNotDisplayed();

		RC.VerifyNoComplianceIsNotDisplayed();

		RC.VerifyPartialComplianceIsNotDisplayed();

		RC.VerifyNAComplianceIsNotDisplayed();

		RC.ClicKCancelBTN();

		System.out.println("**************************************************************");

	}

}

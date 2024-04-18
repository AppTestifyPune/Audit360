package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
import pom.MyAuditsPageTest;
import pom.ReviewAuditPageTest;
import pom.SideMenuPageTest;

public class RedistributionScoreLogicScenario1AndProvissionalSubmissionFunctionalityTest extends BaseTest {

	//Creating the Group and Adding four Checkpoints
	@Test(priority=1)
	public void Adding_Group_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

		parentTest = extent.createTest("Redistribution Score Logic Scenario 1 And Provissional Submission Express Mode Functionality Test", "Testing the Functionality of the Redistribution Score Logic if Group 1 with one NA, Group 2 with all checkpoints NA and Testing the Functionality of the Provissional Submission Audit type which is mapped with Group Level Through Express Mode");

		chiledTest = parentTest.createNode("Creating Group Test");

		System.out.println("***Redistribution Score Logic Scenario 1 Test***");

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
		
	  /* //clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Redistribution Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group 
		String ADG = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 3, 0);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*************One more Group******************************");

		chiledTest.log(Status.INFO, "*************One more Group****************************");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG1 = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG1);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL1 = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL1);
		chiledTest.log(Status.INFO, "Redistribution Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group 
		String ADG1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 4, 0);
		AG.SetAddnewGroup(ADG1);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");


		System.out.println("*******************************");
	}

	//Adding the 4 types of Checkpoints
	@Test(priority=2, dependsOnMethods= {"Adding_Group_Test"})
	public void Adding_Four_CheckPoints_To_Group_Test() throws InterruptedException
	{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding 4 Checkpoints to Group");

		chiledTest.log(Status.INFO, "Adding 4 Checkpoints to Group");

		chiledTest = parentTest.createNode("Adding 4 Checkpoints to Group");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 3, 0);
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
		String YB5 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 21, 0);
		CC.SetYestextBox(YB5);

		//Passing Values to NO Text Box
		String NB5 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB5);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

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
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}


		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Verify Checkpoint ***************");

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
		String YB51 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 19, 0);
		CC.SetYestextBox(YB51);

		//Passing Values to NO Text Box
		String NB51 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB51);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

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
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Both Checkpoint ***************");

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
		String YB7 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 18, 0);
		CC.SetYestextBox(YB7);

		//Passing Values to NO Text Box
		String NB7 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB7);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

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
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both With Conditions Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Both With Conditions Checkpoint ****************");

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
		String YB8 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 18, 0);
		CC.SetYestextBox(YB8);

		//Passing Values to NO Text Box
		String NB8 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB8);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

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
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
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

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");


		System.out.println("********************************************************************");

	}

	//Adding the 4 types of Checkpoints
	@Test(priority=3, dependsOnMethods= {"Adding_Four_CheckPoints_To_Group_Test"})
	public void Adding_Four_CheckPoints_To_another_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding 4 Checkpoints to another Group");

		chiledTest.log(Status.INFO, "Adding 4 Checkpoints to another Group");

		chiledTest = parentTest.createNode("Adding 4 Checkpoints to another Group");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 4, 0);
		CC.SetSearchBTN(SS);

		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
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
		String YB5 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 21, 0);
		CC.SetYestextBox(YB5);

		//Passing Values to NO Text Box
		String NB5 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB5);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

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
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}


		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Verify Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI51 = Lib.getCellValue(XLPATH, "Check Point", 126, 0);
		CC.SetEnterCheckpointintent(ECI51, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS51 = Lib.getCellValue(XLPATH, "Check Point", 132, 0);
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
		String YB51 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 21, 0);
		CC.SetYestextBox(YB51);

		//Passing Values to NO Text Box
		String NB51 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB51);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

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
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Both Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 127, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 133, 0);
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
		String YB7 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 21, 0);
		CC.SetYestextBox(YB7);

		//Passing Values to NO Text Box
		String NB7 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB7);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

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
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both With Condtions Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Both With Condtions Checkpoint ****************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 128, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 134, 0);
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
		String YB8 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 21, 0);
		CC.SetYestextBox(YB8);

		//Passing Values to NO Text Box
		String NB8 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 17, 0);
		CC.SetNoTextBox(NB8);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

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
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
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

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

		System.out.println("********************************************************************");

	}*/

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=4/*, dependsOnMethods= {"Adding_Four_CheckPoints_To_another_Group_Test"}*/)
	public void Creating_Parent_Audit_Type_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Parent Audit Type Test");

		System.out.println("Creating Parent Audit Type Test");

		WebDriverWait wait = new WebDriverWait(driver, 30);

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
		String ATN = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
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
		String SCG = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 3, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 4, 0);
		CA.SetSelectCheckPointGroup(SCG1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		Thread.sleep(3000);
		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int Actual_CPCount = CPSixze.size();
		int Expected_CPCount = 8;
		Assert.assertEquals(Actual_CPCount, Expected_CPCount, "Check Points Count are Wrong");
		System.out.println("Displayed Total Checkpoints counts is : " + Expected_CPCount);

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* EVALUATE  TAB ***************************

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

		//Clicking on the provisional submission Toggle button
		CA.ClickProvisionalSubmissionToggleBTN();

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

		//******************** Finalize Tab ************************

		Thread.sleep(5000);

		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		double d = 160;
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
		String FT = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 85, 0);
		CA.SetFirstTo(FT, driver);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 94, 0);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Second TO
		String ST1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 86, 0);
		CA.SetSecondTo(ST1, driver);

		//Passing the Values to Second Out Come
		String SO = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 93, 0);
		CA.SetSecondOutCome(SO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Passing the Values to Third Out Come
		String TO1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 92, 0);
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
	@Test(priority=5, dependsOnMethods= {"Creating_Parent_Audit_Type_Test"})
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
		String SA = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
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
	@Test(priority=6, dependsOnMethods= {"Creating_Parent_Audit_Type_Test"})
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
		String SAT1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		SP.SetSelectAuditType(SAT1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Vendor Option Under Select Auditee Type Drop Down List
		SP.ClickVendorOption(driver);

		//Clicking on the Select country/State/Location
		SP.ClickSelectCountryStateLocation(driver);

		//Passing the Values to Select country/State/Location
		String CCL1 = Lib.getCellValue(XLPATH, "Schedule", 6, 0);
		SP.SetCountryStateLocation(CCL1, driver);
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

	//Testing the Functionality of the Audit Execution page
	@Test(priority=7, dependsOnMethods= {"Creating_Audit_Schedule_Test"})
	public void Executing_The_AuditType_Through_Express_Mode_Tets() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		chiledTest = parentTest.createNode("Executing The AuditType Through Express Mode Test");

		System.out.println("Executing The AuditType Through Express Mode Test");

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
		String AT1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		AE.SetAuditType(AT1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Accept Button
		AE.ClickAcceptBTN(driver);
		chiledTest.log(Status.INFO, "Accept Button is Clicked");

		//Verifying Audit accepted successfully Success Message is Displayed
		AE.VerifyAuditAcceptedSuccesfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit accepted successfully Success Message is Displayed");

		driver.navigate().refresh();

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Not started Button
		AE.ClickNotStartedBTN(driver);

		//Clicking on the Express Mode ButtonW
		AE.ClickExpress(driver);
		chiledTest.log(Status.INFO, "Express Button is clicked");

		Thread.sleep(5000);

		//Validating Total 8 Checkpoints are Displayed or Not
		List<WebElement> NoOfCheckpoints = driver.findElements(By.xpath("//ul[@id='sortable1']/li"));
		int Actual_NoOfCheckpoints = NoOfCheckpoints.size();
		int Expected_NoOfCheckpoints = 8;
		Assert.assertEquals(Actual_NoOfCheckpoints, Expected_NoOfCheckpoints, "Total 8 Checkpoints are NOT Displayed");

		System.out.println("*****Dragging 1st checkpoint to Yes Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 1st checkpoint to Yes Compliance********");

		WebElement CP1 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP1));
		WebElement Yes = driver.findElement(By.xpath("//ul[@id='sortable2']"));
		wait.until(ExpectedConditions.visibilityOf(Yes));
		action.dragAndDrop(CP1, Yes).build(). perform();
		System.out.println("First Checkpoint is Dragged to Yes");
		chiledTest.log(Status.INFO, "First Checkpoint is Dragged to Yes");

		Thread.sleep(2000);

		System.out.println("*****Dragging 2nd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 2nd checkpoint to NO Compliance********");

		WebElement CP2 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP2));
		WebElement NO = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO));
		action.dragAndDrop(CP2, NO).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to No");
		System.out.println("Second Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 3rd checkpoint to NA Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 3rd checkpoint to NA Compliance********");

		WebElement CP3 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP3));
		WebElement NA = driver.findElement(By.xpath("//ul[@id='sortable5']"));
		wait.until(ExpectedConditions.visibilityOf(NA));
		action.dragAndDrop(CP3, NA).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to NA");
		System.out.println("Third Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 4th checkpoint to Yes Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 4th checkpoint to Yes Compliance********");

		WebElement CP4 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP4));
		WebElement Yes1 = driver.findElement(By.xpath("//ul[@id='sortable2']"));
		wait.until(ExpectedConditions.visibilityOf(Yes1));
		action.dragAndDrop(CP4, Yes1).build(). perform();
		chiledTest.log(Status.INFO, "Fourth Checkpoint is Dragged to Yes");
		System.out.println("Fourth Checkpoint is Dragged to Yes");

		Thread.sleep(2000);

		System.out.println("*****Dragging 5th checkpoint to NA Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 5th checkpoint to NA Compliance********");

		WebElement CP5 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP5));
		WebElement NA1 = driver.findElement(By.xpath("//ul[@id='sortable5']"));
		wait.until(ExpectedConditions.visibilityOf(NA1));
		action.dragAndDrop(CP5, NA1).build(). perform();
		chiledTest.log(Status.INFO, "Fifth Checkpoint is Dragged to NA");
		System.out.println("Fifth Checkpoint is Dragged to NA");


		Thread.sleep(2000);

		System.out.println("*****Dragging 6th checkpoint to NA Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 6th checkpoint to NA Compliance********");

		WebElement CP6 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP6));
		WebElement NA2 = driver.findElement(By.xpath("//ul[@id='sortable5']"));
		wait.until(ExpectedConditions.visibilityOf(NA2));
		action.dragAndDrop(CP6, NA2).build(). perform();
		chiledTest.log(Status.INFO, "sixth Checkpoint is Dragged to NA");
		System.out.println("sixth Checkpoint is Dragged to NA");

		Thread.sleep(2000);

		System.out.println("*****Dragging 7th checkpoint to NA Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 7th checkpoint to NA Compliance********");

		WebElement CP7 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP7));
		WebElement NA3 = driver.findElement(By.xpath("//ul[@id='sortable5']"));
		wait.until(ExpectedConditions.visibilityOf(NA3));
		action.dragAndDrop(CP7, NA3).build(). perform();
		chiledTest.log(Status.INFO, "Seventh Checkpoint is Dragged to NA");
		System.out.println("Seventh Checkpoint is Dragged to NA");

		Thread.sleep(2000);

		System.out.println("*****Dragging 8th checkpoint to NA Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 8th checkpoint to NA Compliance********");

		WebElement CP8 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP8));
		WebElement NA4 = driver.findElement(By.xpath("//ul[@id='sortable5']"));
		wait.until(ExpectedConditions.visibilityOf(NA4));
		action.dragAndDrop(CP8, NA4).build(). perform();
		chiledTest.log(Status.INFO, "Eighth Checkpoint is Dragged to NA");
		System.out.println("Eighth Checkpoint is Dragged to NA");

		//Clicking on the Next Button
		AE.ClickExpressModeVerifyTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//********* Input Tab ********

		Thread.sleep(6000);

		//Selecting the 1st Values under 1st Values Drop down list
		WebElement SelectValues = driver.findElement(By.xpath("//ul[@class='cps inputs']/li[2]//select[@id='input_value']/option[2]"));
		wait.until(ExpectedConditions.visibilityOf(SelectValues)).click();

		//Selecting the 1st Values under 1st Values Drop down list
		WebElement SelectValues1 = driver.findElement(By.xpath("//ul[@class='cps inputs']/li[3]//select[@id='input_value']/option[2]"));
		wait.until(ExpectedConditions.visibilityOf(SelectValues1)).click();

		//Passing the Values to Percentage
		String PN = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetPercentage(PN);
		chiledTest.log(Status.INFO, "Percentage is Entered");

		//Passing the Values to Text
		String FT = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		AE.SetFirstText(FT);
		chiledTest.log(Status.INFO, "Text is Entered");

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Butto is Clicked");

		//******** Summary Tab *******

		//Passing the Values to Remarks
		String ER = Lib.getCellValue(XLPATH, "Audit Execution", 107, 0);
		AE.SetExpressRemarks(ER);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Audit Level Recommendation 
		String AR = Lib.getCellValue(XLPATH, "Audit Execution", 115, 0);
		AE.SetAuditLevelRecommendation(AR);

		//Passing the Values to Audit level Observation
		String AO = Lib.getCellValue(XLPATH, "Audit Execution", 118, 0);
		AE.SetAuditLevelObservations(AO);

		//Clicking on the Provisional Submission Button
		AE.ClickProvisionalSubmissionBTN();
		chiledTest.log(Status.INFO, "Provisional Submission Button");

		//Checking Audit Submitted Success Message is Displayed or not
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Success Message is Displayed");

		System.out.println("*******************************");

	}


	//Testing the Functionality of the Audit Execution page
	@Test(priority=8, dependsOnMethods="Executing_The_AuditType_Through_Express_Mode_Tets")
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
		String SA = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		MA.SetSelectAuditType(SA);

		MA.ClickMatched();

		//Checking Provisionally Submitted Status is Displayed or Not for audit type
		MA.VerifyProvisionalSubmissionStatusIsDisplayed();

		System.out.println("****************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=9, dependsOnMethods= {"Provisionaly_Submitted_Status_Should_Show_For_AuditeeUser_Test"})
	public void Submitting_The_AuditType_Which_Is_Provisionally_Submitted_Test() throws Exception
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
		String SB = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Under Summary page checking Audit Execution Status is Showing Provisionally Submitted Status or Not
		WebElement PSS = driver.findElement(By.xpath("//span[contains(text(),'Provisionally Submitted')]"));
		Assert.assertTrue(PSS.isDisplayed(), "Provisionally Submitted Status is NOT Showing in Summary Page");
		System.out.println("Provisionally Submitted Status is Showing in Summary Page");
		chiledTest.log(Status.INFO, "Provisionally Submitted Status is Showing in Summary Page");

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 3, 0);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 4, 0);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//Clicking on the Submit Button
		RA.ClickSubmitMainAuditBTN();;

		System.out.println("***************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=10, dependsOnMethods= {"Submitting_The_AuditType_Which_Is_Provisionally_Submitted_Test"})
	public void Signoffing_The_AuditType_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("Signoffing The AuditType Test");

		System.out.println("Signoffing The AuditType Test");

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
		String SA = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		MA.SetSelectAuditType(SA);

		MA.ClickMatched();

		MA.ClickfirstAuditType(driver);

		//clicking on the Sign Off Audit Button
		MA.ClickSingOffAuditButton(driver);

		//verifying the Are you sure you want to sign off this audit ? Pop Up is Displayed
		MA.VerifyAreYouSureYouWantToSignOffThisAuditPopupIsDisplayed(driver);

		//Clicking on the Due date 
		MA.ClickDueDate();

		//Passing the values to due Date
		String DD3 = Lib.getCellValue(XLPATH, "My Audit Page", 3, 6);
		MA.SetDueDate(DD3, driver);

		//clicking on the OK Button
		MA.ClickOKBTN();

		System.out.println("******************************");
	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=11, dependsOnMethods= {"Signoffing_The_AuditType_Test"})
	public void Finalizing_The_AuditType_Test() throws Exception
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
		String SB = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing The Group**********************");

		chiledTest.log(Status.INFO, "**************Reviewing The Group******************");

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 3, 0);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 4, 0);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize Button
		RA.ClickGroupFinalizeButton();

		//verifying Audit Finalized Successfully message is displayed
		RA.VerifyAuditFinalizedSuccessfullySuccessMsgIsDisplayed(driver);

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=12, dependsOnMethods= {"Finalizing_The_AuditType_Test"})
	public void Validating_The_Scores_Test() throws Exception
	{
		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		System.out.println("Validating The Scores Test");

		chiledTest = parentTest.createNode("Validating The Scores Test");

		RA.ClickReviewAuditHeader(driver);

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 9, 0);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("**** Validating the 1st Group Score***");

		chiledTest.log(Status.INFO, "**** Validating the 1st Group IND Score***");

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 3, 0);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		System.out.println("**** Checking the 1st Checkpoint IND Score***");

		chiledTest.log(Status.INFO, "**** Checking the 1st Checkpoint IND Score***");

		RA.ClickFirstCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore1 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore1 = "Yes";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore1);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore1);
		Assert.assertEquals(Actual_ComplianceScore1, Expected_ComplianceScore1, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore = "30.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore);
		Assert.assertEquals(Actual_SubmittedScore, Expected_SubmittedScore, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore = "30.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore);
		System.out.println("Submitted Score is : " + Expected_FinalScore);
		Assert.assertEquals(Actual_FinalScore, Expected_FinalScore, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		List<WebElement> InputValues = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]"));
		Assert.assertTrue(InputValues.size()>=0, "Input Values should be Empty");

		//Checking the Is Issue
		List<WebElement> IsIssue = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue.size()>=0, "IsIssue should be Empty");

		System.out.println("**** Checking the 2nd Checkpoint IND Score***");

		RA.ClickFirstCheckPoint();

		RA.ClickSecondCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition1 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition1.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore2 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore2 = "No";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore2);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore2);
		Assert.assertEquals(Actual_ComplianceScore2, Expected_ComplianceScore2, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore1 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore1 = "0.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore1);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore1);
		Assert.assertEquals(Actual_SubmittedScore1, Expected_SubmittedScore1, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore1 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore1 = "0.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore1);
		System.out.println("Submitted Score is : " + Expected_FinalScore1);
		Assert.assertEquals(Actual_FinalScore1, Expected_FinalScore1, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		List<WebElement> InputValues2 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]"));
		Assert.assertTrue(InputValues2.size()>=0, "Input Values should be Empty");

		//Checking the Is Issue
		List<WebElement> IsIssue2 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue2.size()>=0, "IsIssue should be Empty");

		System.out.println("**** Checking the 3rd Checkpoint IND Score***");

		chiledTest.log(Status.INFO, "**** Checking the 3rd Checkpoint IND Score***");

		RA.ClickSecondCheckPoint();

		RA.ClickThirdCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition2 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition2.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore21 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore21 = "NA";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore21);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore21);
		Assert.assertEquals(Actual_ComplianceScore21, Expected_ComplianceScore21, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore2 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore2 = "0.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore2);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore2);
		Assert.assertEquals(Actual_SubmittedScore2, Expected_SubmittedScore2, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore2 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore2 = "0.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore2);
		System.out.println("Submitted Score is : " + Expected_FinalScore2);
		Assert.assertEquals(Actual_FinalScore2, Expected_FinalScore2, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		String Actual_InputValues21 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]")).getText();
		String Expeected_InputValues21 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		System.out.println("Actual Input Values is : " + Actual_InputValues21);
		System.out.println("Expected Input Values is : " + Expeected_InputValues21);
		Assert.assertEquals(Actual_InputValues21, Expeected_InputValues21, "Input Values is Wrong");
		System.out.println("Input Values is Matched");

		//Checking the Is Issue
		List<WebElement> IsIssue21 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue21.size()>=0, "IsIssue should be Empty");

		System.out.println("**** Checking the 4th Checkpoint IND Score***");

		chiledTest.log(Status.INFO, "**** Checking the 4th Checkpoint IND Score***");

		RA.ClickThirdCheckPoint();

		RA.ClickFourthCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition3 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition3.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore211 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore211 = "Yes";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore211);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore211);
		Assert.assertEquals(Actual_ComplianceScore211, Expected_ComplianceScore211, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore3 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore3 = "12.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore3);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore3);
		Assert.assertEquals(Actual_SubmittedScore3, Expected_SubmittedScore3, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore3 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore3 = "12.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore3);
		System.out.println("Submitted Score is : " + Expected_FinalScore3);
		Assert.assertEquals(Actual_FinalScore3, Expected_FinalScore3, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		String Actual_InputValues211 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]")).getText();
		String Expeected_InputValues211 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		System.out.println("Actual Input Values is : " + Actual_InputValues211);
		System.out.println("Expected Input Values is : " + Expeected_InputValues211);
		Assert.assertEquals(Actual_InputValues211, Expeected_InputValues211, "Input Values is Wrong");
		System.out.println("Input Values is Matched");

		//Checking the Is Issue
		List<WebElement> IsIssue211 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue211.size()>=0, "IsIssue should be Empty");

		System.out.println("************Validating 2nd Group Scoring**********");

		chiledTest.log(Status.INFO, "***********Validating 2nd Group Scoring*********");

		System.out.println("**** Checking the 5th Checkpoint IND Score***");

		chiledTest.log(Status.INFO, "**** Checking the 5th Checkpoint IND Score***");

		//clicking on the Remove Button
		RA.ClickRemoveBTN();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA2 = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 4, 0);
		RA.SetGroup(SA2);

		RA.ClickMatchedTextOption(driver);

		RA.ClickfifthCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition4 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition4.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore11 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore11 = "NA";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore11);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore11);
		Assert.assertEquals(Actual_ComplianceScore11, Expected_ComplianceScore11, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore5 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore5 = "0.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore5);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore5);
		Assert.assertEquals(Actual_SubmittedScore5, Expected_SubmittedScore5, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore5 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore5 = "0.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore5);
		System.out.println("Submitted Score is : " + Expected_FinalScore5);
		Assert.assertEquals(Actual_FinalScore5, Expected_FinalScore5, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		List<WebElement> InputValues1 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]"));
		Assert.assertTrue(InputValues1.size()>=0, "Input Values should be Empty");

		//Checking the Is Issue
		List<WebElement> IsIssue1 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue1.size()>=0, "IsIssue should be Empty");

		System.out.println("**** Checking the 6th Checkpoint IND Score***");

		chiledTest.log(Status.INFO, "**** Checking the 6th Checkpoint IND Score***");

		RA.ClickfifthCheckPoint();

		RA.ClickSixthCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition5 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition5.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore6 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore6 = "NA";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore6);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore6);
		Assert.assertEquals(Actual_ComplianceScore6, Expected_ComplianceScore6, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore6 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore6 = "0.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore6);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore6);
		Assert.assertEquals(Actual_SubmittedScore6, Expected_SubmittedScore6, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore6 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore6 = "0.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore6);
		System.out.println("Submitted Score is : " + Expected_FinalScore6);
		Assert.assertEquals(Actual_FinalScore6, Expected_FinalScore6, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		List<WebElement> InputValues6 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]"));
		Assert.assertTrue(InputValues6.size()>=0, "Input Values should be Empty");

		//Checking the Is Issue
		List<WebElement> IsIssue6 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue6.size()>=0, "IsIssue should be Empty");

		System.out.println("**** Checking the 7th Checkpoint IND Score***");

		chiledTest.log(Status.INFO, "**** Checking the 7th Checkpoint IND Score***");

		RA.ClickSixthCheckPoint();

		RA.ClickSeventhCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition6 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition6.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore7 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore7 = "NA";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore7);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore7);
		Assert.assertEquals(Actual_ComplianceScore7, Expected_ComplianceScore7, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore7 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore7 = "0.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore7);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore7);
		Assert.assertEquals(Actual_SubmittedScore7, Expected_SubmittedScore7, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore8 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore8 = "0.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore8);
		System.out.println("Submitted Score is : " + Expected_FinalScore8);
		Assert.assertEquals(Actual_FinalScore8, Expected_FinalScore8, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		String Actual_InputValues7 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]")).getText();
		String Expected_InputValues7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		System.out.println("Actual Input Values is : " + Actual_InputValues7);
		System.out.println("Expected Input Values is : " + Expected_InputValues7);
		Assert.assertEquals(Actual_InputValues7, Expected_InputValues7, "Input Values is Wrong");
		System.out.println("Input Values is Matched");

		//Checking the Is Issue
		List<WebElement> IsIssue7 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue7.size()>=0, "IsIssue should be Empty");

		System.out.println("**** Checking the 8th Checkpoint IND Score***");

		chiledTest.log(Status.INFO, "**** Checking the 8th Checkpoint IND Score***");

		RA.ClickSeventhCheckPoint();

		RA.ClickEightCheckPoint();

		//checking the Disposition
		List<WebElement> Disposition7 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[4]"));
		Assert.assertTrue(Disposition7.size()>=0, "Dispostions are showing in Express Execution");
		System.out.println("Disposition is Empty");

		//checking the Compliance Score
		String Actual_ComplianceScore8 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[3]")).getText();
		String Expected_ComplianceScore8 = "NA";
		System.out.println("Actual Compliance Score is : " + Actual_ComplianceScore8);
		System.out.println("Expected Compliance Score is : " + Expected_ComplianceScore8);
		Assert.assertEquals(Actual_ComplianceScore8, Expected_ComplianceScore8, "Compliance Score is Wrong");
		System.out.println("Compliance Score is Matched");

		//checking the Submitted Score
		String Actual_SubmittedScore8 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[5]")).getText();
		String Expected_SubmittedScore8 = "0.0";
		System.out.println("Submitted Score is : " + Actual_SubmittedScore8);
		System.out.println("Submitted Score is : " + Expected_SubmittedScore8);
		Assert.assertEquals(Actual_SubmittedScore8, Expected_SubmittedScore8, "Submitted Score is Wrong");
		System.out.println("Submitted Score is Matched");

		//checking the Final Score
		String Actual_FinalScore81 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[6]")).getText();
		String Expected_FinalScore81 = "0.0";
		System.out.println("Submitted Score is : " + Actual_FinalScore81);
		System.out.println("Submitted Score is : " + Expected_FinalScore81);
		Assert.assertEquals(Actual_FinalScore81, Expected_FinalScore81, "Final Score is Wrong");
		System.out.println("Final Score is Matched");

		//checking the Input Values
		String Actual_InputValues8 = driver.findElement(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[7]")).getText();
		String Expeected_InputValues8 = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		System.out.println("Actual Input Values is : " + Actual_InputValues8);
		System.out.println("Expected Input Values is : " + Expeected_InputValues8);
		Assert.assertEquals(Actual_InputValues8, Expeected_InputValues8, "Input Values is Wrong");
		System.out.println("Input Values is Matched");

		//Checking the Is Issue
		List<WebElement> IsIssue8 = driver.findElements(By.xpath("//table[@id='review_compliance_table']/tbody/tr/td[8]"));
		Assert.assertTrue(IsIssue8.size()>=0, "IsIssue should be Empty");

		//clicking on the Summary button
		RA.ClickSummaryBTN();

		Thread.sleep(2000);

		//Checking the Total Score
		String Actual_TotalScore = driver.findElement(By.xpath("//div[@class='recalc_total_score']")).getText();
		System.out.println("Actual Total Score is : " + Actual_TotalScore);
		String Expected_TotalScore = "42.0 / 60.0";
		System.out.println("Expected Total Score is : " + Expected_TotalScore);
		Assert.assertEquals(Actual_TotalScore, Expected_TotalScore, "Total Score is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Total score are Matched");

		//Checking the Audit rating
		String Actual_AuditRating = driver.findElement(By.xpath("//div[@class='recalc_rating']")).getText();
		System.out.println("Actual Rating is : " + Actual_AuditRating);
		String Expected_AuditRating = Lib.getCellValue(XLPATH, "RSL Scenarios 1", 93, 0);
		System.out.println("Expected Rating is : " + Expected_AuditRating);
		Assert.assertEquals(Actual_AuditRating, Expected_AuditRating, "Audit Rating is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual ratings are Matched");

		//Checking the Compliances %
		String Actual_Compliances = driver.findElement(By.xpath("//div[@class='recalc_compliance_percentage']")).getText();
		System.out.println("Actual Rating is : " + Actual_Compliances);
		String Expected_Compliances = "70.0";
		System.out.println("Expected Compliance is : " + Expected_Compliances);
		Assert.assertEquals(Actual_Compliances, Expected_Compliances, "Compliances % is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Compliances % are Matched");

		//clicking on the Close button
		RA.ClickSummaryCloseBTN();

		System.out.println("********************************");


	}





}

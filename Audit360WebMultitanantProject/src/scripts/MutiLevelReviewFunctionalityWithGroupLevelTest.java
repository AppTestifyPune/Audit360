package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
import pom.SideMenuPageTest;

public class MutiLevelReviewFunctionalityWithGroupLevelTest extends BaseTest {

	//Creating the Group and Adding four Checkpoints
	@Test(priority=1)
	public void Adding_Group_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

		parentTest = extent.createTest("Multiple Reviewer Functionality Test With Groups Level", "Testing the Functionality of the Multiple Reviewer Functionality With Group Level");

		System.out.println("***Creating Group Test***");

		System.out.println("Creating Group Test");

		chiledTest = parentTest.createNode("Creating Group Test");

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
		String SG = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "Group", 40, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Fixed Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group 
		String ADG = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
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
		String SL1 = Lib.getCellValue(XLPATH, "Group", 40, 0);
		AG.SetScoringLogic(SL1);
		chiledTest.log(Status.INFO, "Fixed Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group 
		String ADG1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
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
		String SS = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
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
		String YB5 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 41, 0);
		CC.SetNATextBox(NAB);

		//Checking the Partial Text is not Editable 
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
		String YB51 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 41, 0);
		CC.SetNATextBox(NAB1);

		//Checking the Partial Text is not Editable 
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
		String YB7 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 41, 0);
		CC.SetNATextBox(NAB2);

		//Checking the Partial Text is not Editable 
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
		String YB8 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 44, 0);
		CC.SetNATextBox(NAB3);

		//Checking the Partial Text is not Editable 
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
		String SS = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
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
		String YB5 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 41, 0);
		CC.SetNATextBox(NAB1);

		//Checking the Partial Text is not Editable 
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
		String YB51 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 41, 0);
		CC.SetNATextBox(NAB2);

		//Checking the Partial Text is not Editable 
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
		String YB7 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 41, 0);
		CC.SetNATextBox(NAB3);

		//Checking the Partial Text is not Editable 
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
		String YB8 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 22, 0);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 29, 0);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB4 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 41, 0);
		CC.SetNATextBox(NAB4);

		//Checking the Partial Text is not Editable 
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
		String ATN = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
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
		String SCG = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		CA.SetSelectCheckPointGroup(SCG, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		CA.SetSelectCheckPointGroup(SCG1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		Thread.sleep(3000);
		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int Actual_CPCount = CPSixze.size();
	//	int Expected_CPCount = 8;
		int Expected_CPCount = 9; //SM#
		Assert.assertEquals(Actual_CPCount, Expected_CPCount, "Check Points Count are Wrong");
		System.out.println("Displayed Total Checkpoints counts is : " + Expected_CPCount);

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* EVALUATE  TAB ***************************

		//Passing the Values to Low Risk Scoring
		String LR = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 76, 0);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 67, 0);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 72, 0);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 80, 0);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Talerence Risk Scoring is Entered");

		//Clicking on the Next Button
		CA.ClickEvaluteTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = driver.switchTo().alert();
		Alert.dismiss();

		//******** CONFIGURE  TAB **************

		//Clicking on the Eliminate Auditee Sign off Toggle button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();

		//clicking on the Allow multiple level review
		CA.ClickAllowMultiLevelReviewToggleBTN();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//Selecting Reviewer 3 Under level 1 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[1]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='Reviewer3']")).click();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//Selecting Reviewer 2 Under level 2 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[2]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='Reviewer2']")).click();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//Selecting Reviewer 1 Under level 3 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[3]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='Reviewer1']")).click();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();
		
		//Selecting Reviewer Under level 4 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[4]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='Reviewer']")).click();

		//clicking on the Add button
		CA.ClickMultipleLevelAddBTN();

		//Selecting Super admin Under level 5 Role
		driver.findElement(By.xpath("//table[@id='annexure_table']//tbody/tr[5]//td/select[@class='full-width multi_review_role_id select2-offscreen']//option[text()='SuperAdmin']")).click();

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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Finalize Tab ************************

		Thread.sleep(5000);

		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		double d = 200;//195
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
		String FT = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 85, 0);
		CA.SetFirstTo(FT, driver);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 94, 0);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Second TO
		String ST1 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 86, 0);
		CA.SetSecondTo(ST1, driver);

		//Passing the Values to Second Out Come
		String SO = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 93, 0);
		CA.SetSecondOutCome(SO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Passing the Values to Third Out Come
		String TO1 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 92, 0);
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
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
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
	@Test(priority=6, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
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
		String SAT1 = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
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
	public void Audit_Execution_Tets() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Audit Execution Test");

		System.out.println("Audit Execution Test");

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
		String AT2 = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
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

		System.out.println("************** Executing the 1st Group *****************");

		chiledTest.log(Status.INFO, "************** Executing the 1st Group *****************");

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the Not started Button
		AE.ClickNotStartedBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is clicked");

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

		//Clicking on the Yes Button
		AE.ClickYesButton();

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

		//Clicking on the Yes Button
		AE.ClickYesButton();

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

		//Clicking on the No Button
		AE.ClickNoButton();


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

		//Clicking on the NA Button
		AE.ClickNAButton();

		//Passing the Values to Enter Input Values
		String IV = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		AE.ClickNextButton(driver);

		System.out.println("************** Executing the 2nd Group *****************");

		chiledTest.log(Status.INFO, "************** Executing the 2nd Group *****************");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER111 = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR111 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the No Button
		AE.ClickNoButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************6th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER121 = Lib.getCellValue(XLPATH, "Audit Execution", 16, 0);
		AE.SetEnterRemarks(ER121);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR121 = Lib.getCellValue(XLPATH, "Audit Execution", 31, 0);
		AE.SetEnterConfidentalRemarks(ECR121);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************7th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER231 = Lib.getCellValue(XLPATH, "Audit Execution", 17, 0);
		AE.SetEnterRemarks(ER231);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR231 = Lib.getCellValue(XLPATH, "Audit Execution", 32, 0);
		AE.SetEnterConfidentalRemarks(ECR231);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Selecting the 1st Values from the Input Values drop down
	
	//	AE.SelectingValues(driver);   //#SM
	//	chiledTest.log(Status.INFO, "Values is selected");  //#SM

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

	//####SM  SM
		System.out.println("***********************8th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2311 = Lib.getCellValue(XLPATH, "Audit Execution", 17, 0);
		AE.SetEnterRemarks(ER2311);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR2311 = Lib.getCellValue(XLPATH, "Audit Execution", 32, 0);
		AE.SetEnterConfidentalRemarks(ECR2311);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Selecting the 1st Values from the Input Values drop down
	
		AE.SelectingValues(driver);   //#SM
		chiledTest.log(Status.INFO, "Values is selected");  //#SM

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

	
		
		System.out.println("***********************9th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER341 = Lib.getCellValue(XLPATH, "Audit Execution", 18, 0);
		AE.SetEnterRemarks(ER341);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR341 = Lib.getCellValue(XLPATH, "Audit Execution", 33, 0);
		AE.SetEnterConfidentalRemarks(ECR341);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Partial Button
		AE.ClickPartialButton();

		//Passing the Values to Max values
		String MV1 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 102, 0);
		AE.SetMaxValues(MV1, driver);
		chiledTest.log(Status.INFO, "100 is enterd under MAX values");

		//Moving slider to 50%
		AE.MoveSlider(driver);

		//Passing the Values to Enter Input Values
		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV1, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("*******************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=8, dependsOnMethods= {"Audit_Execution_Tets"})
	public void Level_1_Reviewer_Recommendation_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 1 Reviewer Recommendation Test");

		System.out.println("Level 1 Reviewer Recommendation Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",36,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",36,1);
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
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing The Group**********************");

		chiledTest.log(Status.INFO, "**************Reviewing The Group******************");

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();
		Thread.sleep(3000);//#SM R
		
		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);
		Thread.sleep(3000);//#SM R
		System.out.println("1 st Group select");//#SM R
		
		RA.ClickMatchedTextOption(driver);
        
		//Passing the 2nd group
		
		
		driver.findElement(By.xpath("//div[@id='s2id_review_group']//li[@class='select2-search-field']//input")).click();
		Thread.sleep(2000);
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		driver.findElement(By.xpath("//div[@id='s2id_review_group']//li[@class='select2-search-field']//input")).sendKeys(SA1);
		
	//	RA.SetGroup(SA1); //#SM //This is original but removed not working properly		
		Thread.sleep(3000);//#SM
		
		RA.ClickMatchedTextOption(driver);
		
		Thread.sleep(3000);//#SM R
		
		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();
		System.out.println(" selected all check points");//#SM R
		Thread.sleep(3000);//#SM R
		
		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		Thread.sleep(3000);
		//clicking on the Reviewed button
		RA.ClickMainAuditRecommendBTN();

		//verifying Recommended successfully message is displayed
		RA.VerifyRecommendedSuccessfullyMSGIsDisplayed();

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=9, dependsOnMethods= {"Level_1_Reviewer_Recommendation_Test"})
	public void Level_3_Reviewer_Should_Not_Get_Main_Audit_Recommend_Button_Till_Level_2_User_Recommend_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 3 Reviewer Should Not Get Main Audit Recommend Button Till Level 2 Reviewer Recommend Test");

		System.out.println("Level 3 Reviewer Should Not Get Main Audit Recommend Button Till Level 2 Reviewer Recommend Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",34, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",34, 1);
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
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		Thread.sleep(3000);
		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		Thread.sleep(2000); //#SM
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//checking
		RA.VerifyMainAuditRecommendButtonIsNotDisplayed();

		System.out.println("*****************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=10, dependsOnMethods= {"Level_3_Reviewer_Should_Not_Get_Main_Audit_Recommend_Button_Till_Level_2_User_Recommend_Test"})
	public void Level_2_Reviewer_Recommendation_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 2 Reviewer Recommendation Test");

		System.out.println("Level 2 Reviewer Recommendation Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",35,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",35,1);
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

		Thread.sleep(2000); //#SM
		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing The Group**********************");

		chiledTest.log(Status.INFO, "**************Reviewing The Group******************");

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		Thread.sleep(2000); //#SM
		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		Thread.sleep(2000); //#SM
		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//clicking on the Reviewed button
		RA.ClickMainAuditRecommendBTN();

		//verifying Recommended successfully message is displayed
		RA.VerifyRecommendedSuccessfullyMSGIsDisplayed();

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=11, dependsOnMethods= {"Level_2_Reviewer_Recommendation_Test"})
	public void Level_4_Reviewer_Should_Not_Get_Main_Audit_Recommend_Button_Till_Level_3_Reviewer_Recommend_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 4 Reviewer Should Not Get Main Audit Recommend Button Till Level 3 Reviewer Recommend Test");

		System.out.println("Level 4 Reviewer Should Not Get Main Audit Recommend Button Till Level 3 Reviewer Recommend Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",33, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",33, 1);
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
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//checking
		RA.VerifyMainAuditRecommendButtonIsNotDisplayed();

		System.out.println("*****************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=12, dependsOnMethods= {"Level_4_Reviewer_Should_Not_Get_Main_Audit_Recommend_Button_Till_Level_3_Reviewer_Recommend_Test"})
	public void Level_3_Reviewer_Recommendation_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 3 Reviewer Recommendation Test");

		System.out.println("Level 3 Reviewer Recommendation Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",34,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",34,1);
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
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing The Group**********************");

		chiledTest.log(Status.INFO, "**************Reviewing The Group******************");

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//clicking on the Reviewed button
		RA.ClickMainAuditRecommendBTN();

		//verifying Recommended successfully message is displayed
		RA.VerifyRecommendedSuccessfullyMSGIsDisplayed();

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=13, dependsOnMethods= {"Level_3_Reviewer_Recommendation_Test"})
	public void Level_5_Reviewer_Should_Not_Get_Main_Audit_Recommend_Till_Level_4_User_Recommend_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 5 Reviewer Should Not Get Main Audit Recommend Till Level4 User Recommend Test");

		System.out.println("Level 5 Reviewer Should Not Get Main Audit Recommend Till Level4 User Recommend Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3, 1);
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
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//checking
		RA.VerifyMainAuditRecommendButtonIsNotDisplayed();

		System.out.println("*****************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=14, dependsOnMethods= {"Level_5_Reviewer_Should_Not_Get_Main_Audit_Recommend_Till_Level_4_User_Recommend_Test"})
	public void Level_4_Reviewer_Recommend_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 4 Reviewer Recommend Test");

		System.out.println("Level 4 Reviewer Recommend Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",33, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",33, 1);
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
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
		RA.SetGroup(SA1);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//verifying 8 Checkpoints is Displayed or not
		RA.Verify8CheckpointsAreDisplayed();

		//checking on the Main Audit Recommend Button
		RA.ClickMainAuditRecommendBTN();

		//verifying Recommended successfully message is displayed
		RA.VerifyRecommendedSuccessfullyMSGIsDisplayed();

		System.out.println("*********************************");


	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=15, dependsOnMethods= {"Level_4_Reviewer_Recommend_Test"})
	public void Level_5_Reviewer_Recommend_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Level 5 Reviewer Recommend Test");

		System.out.println("Level 5 Reviewer Recommend Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3, 1);
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
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA = Lib.getCellValue(XLPATH, "Multi Level Review", 7, 1);
		RA.SetGroup(SA);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA1 = Lib.getCellValue(XLPATH, "Multi Level Review", 8, 1);
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

		System.out.println("*********************************");


	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=16, dependsOnMethods= {"Level_5_Reviewer_Recommend_Test"})
	public void Validating_The_Scores_Test() throws InterruptedException
	{
		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		System.out.println("Validating the Score Test");

		chiledTest = parentTest.createNode("Validating the Score Test");

		driver.navigate().refresh();
		Thread.sleep(10000);// its required due to time required for score update
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();
		
		driver.navigate().refresh();
		Thread.sleep(10000);// its required due to time required for score update

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

		
		
//		RA.ClickReviewAuditHeader(driver);// This hide for some issues //#SM

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "Multi Level Review", 4, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		RA.ClickSummaryBTN();

		
		Thread.sleep(2000);

		//Checking the Total Score
		String Actual_TotalScore = driver.findElement(By.xpath("//div[@class='recalc_total_score']")).getText();
		System.out.println("Actual Total Score is : " + Actual_TotalScore);
	//	String Expected_TotalScore = "132.5 / 200.0";//##SM
		String Expected_TotalScore = "157.5 / 200.0";//##SM
		System.out.println("Expected Total Score is : " + Expected_TotalScore);
		Assert.assertEquals(Actual_TotalScore, Expected_TotalScore, "Total Score is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Total score are Matched");

		//Checking the Audit rating
		String Actual_AuditRating = driver.findElement(By.xpath("//div[@class='recalc_rating']")).getText();
		System.out.println("Actual Rating is : " + Actual_AuditRating);
		String Expected_AuditRating = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 93, 0);
		System.out.println("Expected Rating is : " + Expected_AuditRating);
		Assert.assertEquals(Actual_AuditRating, Expected_AuditRating, "Audit Rating is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual ratings are Matched");

		//Checking the Compliances %
		String Actual_Compliances = driver.findElement(By.xpath("//div[@class='recalc_compliance_percentage']")).getText();
		System.out.println("Actual Rating is : " + Actual_Compliances);
	//	String Expected_Compliances = "66.25";//##SM
		String Expected_Compliances = "78.75"; //##SM
		System.out.println("Expected Compliance is : " + Expected_Compliances);
		Assert.assertEquals(Actual_Compliances, Expected_Compliances, "Compliances % is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Compliances % are Matched");

		RA.ClickSummaryCloseBTN();

		System.out.println("********************************");

	}

}

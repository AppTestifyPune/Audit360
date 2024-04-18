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
import pom.ReviewAuditPageTest;
import pom.SideMenuPageTest;
import pom.UploadAnnexureDocumentPageTest;

public class ExceptionalGroupsAndReorderCPFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Group List 
	@Test(priority=1)
	public void Group_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		parentTest = extent.createTest("Exceptional Group Functionality Test", "Testing the Functionality of the List Group, Add Group, Edit Group and Single Delete Group Test");

		chiledTest = parentTest.createNode("Group Page Test");

		System.out.println("Group Page Test");

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		l.ClickSigninBTN();

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

		System.out.println("*****************************************************");
	}

	//Testing the Functionality of the Adding the General Group Test
	/*@Test(priority=2, dependsOnMethods= {"Group_Page_Test"})
		public void Creating_Exceptional_Group_Test()
		{
			GroupPageTest AG = new GroupPageTest(driver);

			chiledTest = parentTest.createNode("Creating Exceptional Group Test");

			System.out.println("Creating Exceptional Group Test");

			//clicking on the Group Type
			AG.ClickGroupType(driver);

			//selecting the General Group under Group Type1
			String SG = Lib.getCellValue(XLPATH, "Group", 5, 0);
			AG.SetGroupType(SG);
			chiledTest.log(Status.INFO, "Exceptional Group is Selected");

			//Clicking on the Matched
			AG.ClickMatched(driver);

			//Checking the Annexure Group drop down is read only mode for Exceptional groups
			AG.VerifyAnnexureGroupDropDwonInReadOnlyMode(driver);

			//Checking the Scoring Logic Group drop down is read only mode for Exceptional groups
			AG.VerifyScoingDropDwonInReadOnlyMode(driver);

			//Passing the Values to Add group from excel
			String ADG = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 0);
			AG.SetAddnewGroup(ADG);
			chiledTest.log(Status.INFO, "Group Name is Entered");

			//clicking on the Add button
			AG.ClickAddBTN();
			chiledTest.log(Status.INFO, "Add Button is Clicked");

			//Verifying Group is Created Success Message is Displayed or not
			AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
			chiledTest.log(Status.INFO, "Group Created Successfully");

			//*********************Creating one more GP*********************************************

			//clicking on the Group Type
			AG.ClickGroupType(driver);

			//selecting the General Group under Group Type
			String SG1 = Lib.getCellValue(XLPATH, "Group", 5, 0);
			AG.SetGroupType(SG1);
			chiledTest.log(Status.INFO, "Exceptional Group is Selected");

			//Clicking on the Matched
			AG.ClickMatched(driver);

			//Checking the Annexure Group drop down is read only mode for Exceptional groups
			AG.VerifyAnnexureGroupDropDwonInReadOnlyMode(driver);

			//Checking the Scoring Logic Group drop down is read only mode for Exceptional groups
			AG.VerifyScoingDropDwonInReadOnlyMode(driver);

			//Passing the Values to Add group from excel
			String ADG1 = Lib.getCellValue(XLPATH, "Exceptional Group", 4, 0);
			AG.SetAddnewGroup(ADG1);
			chiledTest.log(Status.INFO, "Group Name is Entered");

			//clicking on the Add button
			AG.ClickAddBTN();
			chiledTest.log(Status.INFO, "Add Button is Clicked");

			//Verifying Group is Created Success Message is Displayed or not
			AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
			chiledTest.log(Status.INFO, "Group Created Successfully");

			System.out.println("**************************");

		}

		//Testing Functionality of the Create Check Point for Verify 
		@Test(priority=3, dependsOnMethods= {"Creating_Exceptional_Group_Test"}) 
		public void Adding_The_4_Types_Of_Checkpoints_To_Exceptional_Group_Test() throws InterruptedException
		{
			CheckPointPageTest CC = new CheckPointPageTest(driver);

			chiledTest = parentTest.createNode("Adding The 4 Types Of Checkpoints To Exceptional Group Test");

			System.out.println("Adding The 4 Types Of Checkpoints To Exceptional Group Test");

			//Passing the Values to Search Button
			String SS = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 0);
			CC.SetSearchBTN(SS);

			//Clicking on the Add Checkpoint Button
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

			//Passing the Values to Yes Disposition
			String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
			CC.SetYesDisposition(YD5);

			//Passing the Values to Yes Disposition
			String YD15 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
			CC.SetYesDisposition(YD15);

			//Passing the Values to Yes Disposition
			String YD25 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
			CC.SetYesDisposition(YD25);

			//Passing the Values to Yes Disposition
			String YD35 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
			CC.SetYesDisposition(YD35);

			//Passing the Values to No Disposition
			String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
			CC.SetNoDisposition(ND5);

			//Passing the Values to No Disposition
			String ND15 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
			CC.SetNoDisposition(ND15);

			//Passing the Values to No Disposition
			String ND25 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
			CC.SetNoDisposition(ND25);

			//Passing the Values to No Disposition
			String ND35 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
			CC.SetNoDisposition(ND35);

			//Checking the NO Compliance is Read Only Mode or Not?
			CC.VerifyNOComplianceIsReadonly(driver);

			//Checking the Partial Compliance is Read Only Mode or Not?
			CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

			//Checking the NA Compliance is Read Only Mode or Not?
			CC.VerifyNAComplianceIsReadonly(driver);

			//Checking the Partial Disposition is Read Only Mode or Not?
			CC.VerifyPartialDispositionIsReadOnly();

			//Checking the NA Disposition is Read Only Mode or Not?
			CC.VerifyNADispositionIsReadOnly();

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
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");


			System.out.println("*********Creating Input Type Checkpoint**************************");

			//Passing the Values to the Enter Checkpoint intent
			String ECI6 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
			CC.SetEnterCheckpointintent(ECI6, driver);
			chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

			//Passing the Values to the Description
			String DS6 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
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

			//Clicking on the Submit and Create new Button
			CC.ClickSubmitCreateBTN(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			WebElement SuccessMSG1 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG1)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");

			System.out.println("*********Creating Both Type Checkpoint**************************");

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

			//Passing the Values to Yes Disposition
			String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
			CC.SetYesDisposition(YD7);

			//Passing the Values to Yes Disposition
			String YD17 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
			CC.SetYesDisposition(YD17);

			//Passing the Values to Yes Disposition
			String YD27 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
			CC.SetYesDisposition(YD27);

			//Passing the Values to Yes Disposition
			String YD37 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
			CC.SetYesDisposition(YD37);

			//Passing the Values to No Disposition
			String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
			CC.SetNoDisposition(ND7);

			//Passing the Values to No Disposition
			String ND17 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
			CC.SetNoDisposition(ND17);

			//Passing the Values to No Disposition
			String ND27 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
			CC.SetNoDisposition(ND27);

			//Passing the Values to No Disposition
			String ND37 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
			CC.SetNoDisposition(ND37);

			//Checking the NO Compliance is Read Only Mode or Not?
			CC.VerifyNOComplianceIsReadonly(driver);

			//Checking the Partial Compliance is Read Only Mode or Not?
			CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

			//Checking the NA Compliance is Read Only Mode or Not?
			CC.VerifyNAComplianceIsReadonly(driver);

			//Checking the Partial Disposition is Read Only Mode or Not?
			CC.VerifyPartialDispositionIsReadOnly();

			//Checking the NA Disposition is Read Only Mode or Not?
			CC.VerifyNADispositionIsReadOnly();

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
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG2)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");


			System.out.println("************Creating Check Point for Both with Condtions Type Test************");

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

			//Passing the Values to Yes Disposition
			String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
			CC.SetYesDisposition(YD8);

			//Passing the Values to Yes Disposition
			String YD18 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
			CC.SetYesDisposition(YD18);

			//Passing the Values to Yes Disposition
			String YD28 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
			CC.SetYesDisposition(YD28);

			//Passing the Values to Yes Disposition
			String YD38 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
			CC.SetYesDisposition(YD38);

			//Passing the Values to No Disposition
			String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
			CC.SetNoDisposition(ND8);

			//Passing the Values to No Disposition
			String ND18 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
			CC.SetNoDisposition(ND18);

			//Passing the Values to No Disposition
			String ND28 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
			CC.SetNoDisposition(ND28);

			//Passing the Values to No Disposition
			String ND38 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
			CC.SetNoDisposition(ND38);

			//Checking the NO Compliance is Read Only Mode or Not?
			CC.VerifyNOComplianceIsReadonly(driver);

			//Checking the Partial Compliance is Read Only Mode or Not?
			CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

			//Checking the NA Compliance is Read Only Mode or Not?
			CC.VerifyNAComplianceIsReadonly(driver);

			//Checking the Partial Disposition is Read Only Mode or Not?
			CC.VerifyPartialDispositionIsReadOnly();

			//Checking the NA Disposition is Read Only Mode or Not?
			CC.VerifyNADispositionIsReadOnly();

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

			//clicking on the 3rd data type
			CC.ClickThirdDataType(driver);

			//Passing the Values to Data Type 
			String SD31 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
			CC.SetDataType(SD31);
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

			//Clicking on the Submit Button
			CC.ClickSubmitButton(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

			System.out.println("********************************************************************");

		}

		//Testing Functionality of the Create Check Point for Verify 
		@Test(priority=4, dependsOnMethods= {"Adding_The_4_Types_Of_Checkpoints_To_Exceptional_Group_Test"}) 
		public void Adding_The_4_Types_Of_Checkpoints_To_Another_Exceptional_Group_Test() throws InterruptedException
		{
			CheckPointPageTest CC = new CheckPointPageTest(driver);

			chiledTest = parentTest.createNode("Adding The 4 Types Of Checkpoints To Another Exceptional Group Test");

			System.out.println("Adding The 4 Types Of Checkpoints To Another Exceptional Group Test");

			CC.ClickManageCheckPointHeader(driver);

			//Passing the Values to Search Button
			String SS = Lib.getCellValue(XLPATH, "Exceptional Group", 4, 0);
			CC.SetSearchBTN(SS);

			//Clicking on the Add Checkpoint Button
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

			//Passing the Values to Yes Disposition
			String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
			CC.SetYesDisposition(YD5);

			//Passing the Values to Yes Disposition
			String YD15 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
			CC.SetYesDisposition(YD15);

			//Passing the Values to Yes Disposition
			String YD25 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
			CC.SetYesDisposition(YD25);

			//Passing the Values to Yes Disposition
			String YD35 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
			CC.SetYesDisposition(YD35);

			//Passing the Values to No Disposition
			String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
			CC.SetNoDisposition(ND5);

			//Passing the Values to No Disposition
			String ND15 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
			CC.SetNoDisposition(ND15);

			//Passing the Values to No Disposition
			String ND25 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
			CC.SetNoDisposition(ND25);

			//Passing the Values to No Disposition
			String ND35 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
			CC.SetNoDisposition(ND35);

			//Checking the NO Compliance is Read Only Mode or Not?
			CC.VerifyNOComplianceIsReadonly(driver);

			//Checking the Partial Compliance is Read Only Mode or Not?
			CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

			//Checking the NA Compliance is Read Only Mode or Not?
			CC.VerifyNAComplianceIsReadonly(driver);

			//Checking the Partial Disposition is Read Only Mode or Not?
			CC.VerifyPartialDispositionIsReadOnly();

			//Checking the NA Disposition is Read Only Mode or Not?
			CC.VerifyNADispositionIsReadOnly();

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
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");


			System.out.println("*********Creating Input Type Checkpoint**************************");

			//Passing the Values to the Enter Checkpoint intent
			String ECI6 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
			CC.SetEnterCheckpointintent(ECI6, driver);
			chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

			//Passing the Values to the Description
			String DS6 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
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

			//Clicking on the Submit and Create new Button
			CC.ClickSubmitCreateBTN(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			WebElement SuccessMSG1 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG1)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");

			System.out.println("*********Creating Both Type Checkpoint**************************");

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

			//Passing the Values to Yes Disposition
			String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
			CC.SetYesDisposition(YD7);

			//Passing the Values to Yes Disposition
			String YD17 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
			CC.SetYesDisposition(YD17);

			//Passing the Values to Yes Disposition
			String YD27 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
			CC.SetYesDisposition(YD27);

			//Passing the Values to Yes Disposition
			String YD37 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
			CC.SetYesDisposition(YD37);

			//Passing the Values to No Disposition
			String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
			CC.SetNoDisposition(ND7);

			//Passing the Values to No Disposition
			String ND17 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
			CC.SetNoDisposition(ND17);

			//Passing the Values to No Disposition
			String ND27 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
			CC.SetNoDisposition(ND27);

			//Passing the Values to No Disposition
			String ND37 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
			CC.SetNoDisposition(ND37);

			//Checking the NO Compliance is Read Only Mode or Not?
			CC.VerifyNOComplianceIsReadonly(driver);

			//Checking the Partial Compliance is Read Only Mode or Not?
			CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

			//Checking the NA Compliance is Read Only Mode or Not?
			CC.VerifyNAComplianceIsReadonly(driver);

			//Checking the Partial Disposition is Read Only Mode or Not?
			CC.VerifyPartialDispositionIsReadOnly();

			//Checking the NA Disposition is Read Only Mode or Not?
			CC.VerifyNADispositionIsReadOnly();

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
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG2)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");


			System.out.println("************Creating Check Point for Both with Condtions Type Test************");

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

			//Passing the Values to Yes Disposition
			String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
			CC.SetYesDisposition(YD8);

			//Passing the Values to Yes Disposition
			String YD18 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
			CC.SetYesDisposition(YD18);

			//Passing the Values to Yes Disposition
			String YD28 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
			CC.SetYesDisposition(YD28);

			//Passing the Values to Yes Disposition
			String YD38 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
			CC.SetYesDisposition(YD38);

			//Passing the Values to No Disposition
			String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
			CC.SetNoDisposition(ND8);

			//Passing the Values to No Disposition
			String ND18 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
			CC.SetNoDisposition(ND18);

			//Passing the Values to No Disposition
			String ND28 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
			CC.SetNoDisposition(ND28);

			//Passing the Values to No Disposition
			String ND38 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
			CC.SetNoDisposition(ND38);

			//Checking the NO Compliance is Read Only Mode or Not?
			CC.VerifyNOComplianceIsReadonly(driver);

			//Checking the Partial Compliance is Read Only Mode or Not?
			CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

			//Checking the NA Compliance is Read Only Mode or Not?
			CC.VerifyNAComplianceIsReadonly(driver);

			//Checking the Partial Disposition is Read Only Mode or Not?
			CC.VerifyPartialDispositionIsReadOnly();

			//Checking the NA Disposition is Read Only Mode or Not?
			CC.VerifyNADispositionIsReadOnly();

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

			//clicking on the 3rd data type
			CC.ClickThirdDataType(driver);

			//Passing the Values to Data Type 
			String SD31 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
			CC.SetDataType(SD31);
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

			//Clicking on the Submit Button
			CC.ClickSubmitButton(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

			System.out.println("***********************");

		}*/

	//Testing the Functionality of the Creating Group Audit Type test
	/*@Test(priority=5, dependsOnMethods= {"Adding_The_4_Types_Of_Checkpoints_To_Another_Exceptional_Group_Test"})
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
		String SCG1 = Lib.getCellValue(XLPATH, "Exceptional Group", 3, 0);
		CA.SetSelectCheckPointGroup(SCG1, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//****************

		//Passing the CP1 to Search text field
		String SB1 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CA.SetDefineTabSearchBTN(SB1);
		chiledTest.log(Status.INFO, "1st CP is Searched");

		//passing the seq to 1st CP
		String CS1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 179, 0);
		CA.SetFirstCPSeq(CS1);
		chiledTest.log(Status.INFO, "4th seq is Setted for 1st CP");

		//****************

		//Passing the CP2 to Search text field
		String SB2 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CA.SetDefineTabSearchBTN(SB2);
		chiledTest.log(Status.INFO, "2nd CP is Searched");

		//passing the seq to 2nd CP
		String CS2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 178, 0);
		CA.SetFirstCPSeq(CS2);
		chiledTest.log(Status.INFO, "3rd seq is Setted for 2nd CP");

		//****************

		//Passing the CP3 to Search text field
		String SB3 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CA.SetDefineTabSearchBTN(SB3);
		chiledTest.log(Status.INFO, "3rd CP is Searched");

		//passing the seq to 3rd CP
		String CS3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 177, 0);
		CA.SetFirstCPSeq(CS3);
		chiledTest.log(Status.INFO, "2nd seq is Setted for 3rd CP");

		//****************

		//Passing the CP4 to Search text field
		String SB4 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CA.SetDefineTabSearchBTN(SB4);
		chiledTest.log(Status.INFO, "4th CP is Searched");

		//passing the seq to 4th CP
		String CS4 = Lib.getCellValue(XLPATH, "Configure Audit Type", 176, 0);
		CA.SetFirstCPSeq(CS4);
		chiledTest.log(Status.INFO, "1st seq is Setted for 4th CP");

		//****************

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
		String SCG2 = Lib.getCellValue(XLPATH, "Exceptional Group", 4, 0);
		CA.SetSelectCheckPointGroup(SCG2, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//****************

		//Passing the CP1 to Search text field
		String SB11 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CA.SetDefineTabSearchBTN(SB11);
		chiledTest.log(Status.INFO, "1st CP is Searched");

		//passing the seq to 1st CP
		String CS11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 177, 0);
		CA.SetFirstCPSeq(CS11);
		chiledTest.log(Status.INFO, "2nd seq is Setted for 1st CP");

		//****************

		//Passing the CP2 to Search text field
		String SB21 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CA.SetDefineTabSearchBTN(SB21);
		chiledTest.log(Status.INFO, "2nd CP is Searched");

		//passing the seq to 2nd CP
		String CS21 = Lib.getCellValue(XLPATH, "Configure Audit Type", 179, 0);
		CA.SetFirstCPSeq(CS21);
		chiledTest.log(Status.INFO, "4th seq is Setted for 2nd CP");

		//****************

		//Passing the CP3 to Search text field
		String SB31 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CA.SetDefineTabSearchBTN(SB31);
		chiledTest.log(Status.INFO, "3rd CP is Searched");

		//passing the seq to 3rd CP
		String CS31 = Lib.getCellValue(XLPATH, "Configure Audit Type", 176, 0);
		CA.SetFirstCPSeq(CS31);
		chiledTest.log(Status.INFO, "1st seq is Setted for 3rd CP");

		//****************

		//Passing the CP4 to Search text field
		String SB41 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CA.SetDefineTabSearchBTN(SB41);
		chiledTest.log(Status.INFO, "4th CP is Searched");

		//passing the seq to 4th CP
		String CS41 = Lib.getCellValue(XLPATH, "Configure Audit Type", 178, 0);
		CA.SetFirstCPSeq(CS41);
		chiledTest.log(Status.INFO, "3rd seq is Setted for 4th CP");

		//****************

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

		//****************

		//Passing the CP1 to Search text field
		String SB11 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CA.SetDefineTabSearchBTN(SB11);
		chiledTest.log(Status.INFO, "1st CP is Searched");

		//passing the seq to 1st CP
		String CS11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 177, 0);
		CA.SetFirstCPSeq(CS11);
		chiledTest.log(Status.INFO, "2nd seq is Setted for 1st CP");

		//****************

		//Passing the CP2 to Search text field
		String SB21 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CA.SetDefineTabSearchBTN(SB21);
		chiledTest.log(Status.INFO, "2nd CP is Searched");

		//passing the seq to 2nd CP
		String CS21 = Lib.getCellValue(XLPATH, "Configure Audit Type", 179, 0);
		CA.SetFirstCPSeq(CS21);
		chiledTest.log(Status.INFO, "4th seq is Setted for 2nd CP");

		//****************

		//Passing the CP3 to Search text field
		String SB31 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CA.SetDefineTabSearchBTN(SB31);
		chiledTest.log(Status.INFO, "3rd CP is Searched");

		//passing the seq to 3rd CP
		String CS31 = Lib.getCellValue(XLPATH, "Configure Audit Type", 176, 0);
		CA.SetFirstCPSeq(CS31);
		chiledTest.log(Status.INFO, "1st seq is Setted for 3rd CP");

		//****************

		//Passing the CP4 to Search text field
		String SB41 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CA.SetDefineTabSearchBTN(SB41);
		chiledTest.log(Status.INFO, "4th CP is Searched");

		//passing the seq to 4th CP
		String CS41 = Lib.getCellValue(XLPATH, "Configure Audit Type", 178, 0);
		CA.SetFirstCPSeq(CS41);
		chiledTest.log(Status.INFO, "3rd seq is Setted for 4th CP");

		//****************

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

		//****************

		//Passing the CP1 to Search text field
		String SB11 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CA.SetDefineTabSearchBTN(SB11);
		chiledTest.log(Status.INFO, "1st CP is Searched");

		//passing the seq to 1st CP
		String CS11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 177, 0);
		CA.SetFirstCPSeq(CS11);
		chiledTest.log(Status.INFO, "2nd seq is Setted for 1st CP");

		//****************

		//Passing the CP2 to Search text field
		String SB21 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CA.SetDefineTabSearchBTN(SB21);
		chiledTest.log(Status.INFO, "2nd CP is Searched");

		//passing the seq to 2nd CP
		String CS21 = Lib.getCellValue(XLPATH, "Configure Audit Type", 179, 0);
		CA.SetFirstCPSeq(CS21);
		chiledTest.log(Status.INFO, "4th seq is Setted for 2nd CP");

		//****************

		//Passing the CP3 to Search text field
		String SB31 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CA.SetDefineTabSearchBTN(SB31);
		chiledTest.log(Status.INFO, "3rd CP is Searched");

		//passing the seq to 3rd CP
		String CS31 = Lib.getCellValue(XLPATH, "Configure Audit Type", 176, 0);
		CA.SetFirstCPSeq(CS31);
		chiledTest.log(Status.INFO, "1st seq is Setted for 3rd CP");

		//****************

		//Passing the CP4 to Search text field
		String SB41 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CA.SetDefineTabSearchBTN(SB41);
		chiledTest.log(Status.INFO, "4th CP is Searched");

		//passing the seq to 4th CP
		String CS41 = Lib.getCellValue(XLPATH, "Configure Audit Type", 178, 0);
		CA.SetFirstCPSeq(CS41);
		chiledTest.log(Status.INFO, "3rd seq is Setted for 4th CP");

		//****************

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
		Thread.sleep(1000);

		String AnnexureType = driver.findElement(By.xpath("//div[@class='form-group form-group-default annexure_type block']/span[@id='annexure_type']")).getText();
		System.out.println("Displayed Annexure Type is : " + AnnexureType);
		String Static = "Static";
		Assert.assertEquals(AnnexureType, Static);

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

	}*/

	//Testing the Functionality of the Executing General Audit type Test
	@Test(priority=12/*, dependsOnMethods= {"Creating_Schedule_Test"}*/)
	public void Executing_Audit_Type_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);

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

		/*//Clicking on the Accept Button
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

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//**********Checking instead of CP1 it should show CP3************
		String CPText1 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText1);

		String CPT1 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT1);
		Assert.assertEquals(CPT1, CPText1);


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

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//**********Cp1 should show************
		String CPText2 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText2);

		String CPT2 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT1);
		Assert.assertEquals(CPT2, CPText2);

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

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//**********Checking CP4 should show************
		String CPText3 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText3);

		String CPT3 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT3);
		Assert.assertEquals(CPT3, CPText3);

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

		//Clicking on the next button
		AE.ClickNextButton(driver);

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//**********Checking CP2 should show************
		String CPText4 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText4);

		String CPT4 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT4);
		Assert.assertEquals(CPT3, CPText3);

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
		String SB4 = Lib.getCellValue(XLPATH, "Audit Execution", 58, 0);
		AE.SetPiSearchBTN(SB4);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//**********Checking CP3 should show************
		String CPText5 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText5);

		String CPT5 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT5);
		Assert.assertEquals(CPT5, CPText5);


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

		//Passing the Values to Input
		String IV5 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV5, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//**********Checking CP1 should show************
		String CPText6 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText6);

		String CPT6 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT6);
		Assert.assertEquals(CPT6, CPText6);

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

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//**********Checking CP3 should show************
		String CPText7 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText7);

		String CPT7 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT7);
		Assert.assertEquals(CPT7, CPText7);

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

		//Passing the Number to Input Text fields
		String IV6 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV6, driver);
		chiledTest.log(Status.INFO, "number is Entered");
		
		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//**********Checking CP2 should show************
		String CPText8 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText8);

		String CPT8 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT8);
		Assert.assertEquals(CPT8, CPText8);

		//Passing the Values to Enter Remarks
		String ER123 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR123 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Selecting the 1st values under values drop down list
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is Selected");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		AE.ClearPiSearchBTN();

		//Clicking on the Mark Pending Pi as Not Executed
		AE.ClickMarkPendingPIAsNotExecuted();

		//clicking on the Add PI
		AE.ClickAddNewPIBTN(driver);

		//Passing the Values to Primary identifier name
		String PIN = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN, driver);
		chiledTest.log(Status.INFO, "New PI name is Enterd");

		//clicking on the Save Button
		AE.ClickSaveBTN(driver);

		//verifying Sub auditee added and scheduled successfully message is displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
       
       //Passing the Values to Search Button
		String SB5 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPiSearchBTN(SB5);

		//clicking on the Start Button
		//AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//clicking on the Express mode execution
		AE.ClickExpress(driver);

		Thread.sleep(5000);

		//Validating Total 3 Checkpoints are Displayed or Not
		List<WebElement> NoOfCheckpoints = driver.findElements(By.xpath("//ul[@id='sortable1']/li"));
		int Actual_NoOfCheckpoints = NoOfCheckpoints.size();
		int Expected_NoOfCheckpoints = 3;
		Assert.assertEquals(Actual_NoOfCheckpoints, Expected_NoOfCheckpoints, "Total 3 Checkpoints are NOT Displayed");

		System.out.println("*****Dragging 1st checkpoint to Yes Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 1st checkpoint to Yes Compliance********");

		//**********CP3 should show************
		String CPText9 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText9);

		String CPT9 = driver.findElement(By.xpath("//ul[@id='sortable1']//li[1]//label")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT9);
		Assert.assertEquals(CPT9, CPText9);

		WebElement CP1 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP1));
		WebElement Yes = driver.findElement(By.xpath("//ul[@id='sortable2']"));
		wait.until(ExpectedConditions.visibilityOf(Yes));
		action.dragAndDrop(CP1, Yes).build(). perform();
		System.out.println("First Checkpoint is Dragged to Yes");
		chiledTest.log(Status.INFO, "First Checkpoint is Dragged to Yes");

		Thread.sleep(2000);

		System.out.println("*****Dragging 2nd checkpoint to Yes Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 2nd checkpoint to Yes Compliance********");

		//**********CP1 should show************
		String CPText10 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText10);

		String CPT10 = driver.findElement(By.xpath("//ul[@id='sortable1']//li[1]//label")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT10);
		Assert.assertEquals(CPT10, CPText10);

		WebElement CP2 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP2));
		WebElement Yes1 = driver.findElement(By.xpath("//ul[@id='sortable2']"));
		wait.until(ExpectedConditions.visibilityOf(Yes1));
		action.dragAndDrop(CP2, Yes1).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to Yes");
		System.out.println("Second Checkpoint is Dragged to Yes");

		Thread.sleep(2000);

		System.out.println("*****Dragging 3rd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 3rd checkpoint to NO Compliance********");

		//**********CP4 should show************
		String CPText11 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText11);

		String CPT11 = driver.findElement(By.xpath("//ul[@id='sortable1']//li[1]//label")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT11);
		Assert.assertEquals(CPT11, CPText11);

		WebElement CP3 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP3));
		WebElement NO = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO));
		action.dragAndDrop(CP3, NO).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to NO");
		System.out.println("Third Checkpoint is Dragged to NO");*/

		/*//Clicking on the Next Button
		AE.ClickExpressModeVerifyTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************* Input Tab ************

		Thread.sleep(3000);

		//passing the Values to Percentage
		String PN = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetPercentage(PN);
		chiledTest.log(Status.INFO, "Percentage is Entered");

		//Selecting the 1st Values under 1st Values Drop down list
		AE.SelectingValuesUnderExpressMode(driver);

		//Passing the Values to Number
		String NU = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetNumber(NU, driver);

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Butto is Clicked");

		//************** Summary Tab ************

		//Passing the Values to Remarks
		String ER = Lib.getCellValue(XLPATH, "Audit Execution", 107, 0);
		AE.SetExpressRemarks(ER);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Clicking on the Submit Button
		AE.ClickExpressModeSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Butto is Clicked");

		//Checking Audit Submitted Success Message is Displayed or not
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Success Message is Displayed");


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
		chiledTest.log(Status.INFO, "1st Exceptional sub Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		AE.Clicknormal(driver);

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//checking only Yes and NO button should display
		AE.VerifyOnlyYesAndNoButtonsDisplayed(driver);

		//**********CP4 should show************
		String CPText12 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText12);

		String CPT12 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT12);
		Assert.assertEquals(CPT12, CPText12);

		//Passing the Values to Enter Remarks
		String ER16 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER16);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR16 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
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

		//Passing the Value to Percentage
		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV1, driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//checking only Yes and NO button should display
		AE.VerifyOnlyYesAndNoButtonsDisplayed(driver);

		//**********CP3 should show************
		String CPText13 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText13);

		String CPT13 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT13);
		Assert.assertEquals(CPT13, CPText13);

		//Passing the Values to Enter Remarks
		String ER17 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER17);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR17 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR17);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the No Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "No Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Selecting Values 
		AE.SelectingValues(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//**********CP2 should show************
		String CPText14 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText14);

		String CPT14 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CPT14);
		Assert.assertEquals(CPT14, CPText14);


		//Passing the Values to Enter Remarks
		String ER18 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER18);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR18 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR18);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//clicking on the Skip Button
		AE.ClickSkipButton();

		//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		AE.VerifyAreYouSureYouWantToSkipAllTheUnattemptedExceptionalCheckpointsPopUpIsDisplayed();

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up Cancel Button
		AE.ClickSkipCancelButton();

		//clicking on the Skip Button
		AE.ClickSkipButton();

		//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		AE.VerifyAreYouSureYouWantToSkipAllTheUnattemptedExceptionalCheckpointsPopUpIsDisplayed();

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up OK Butto
		AE.ClickSkipOKButton();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);*/

		System.out.println("*************Exceuting 2nd Exceptional Sub Audits Through Express Mode**********");

		chiledTest.log(Status.INFO, "*********Exceuting 2nd Exceptional Sub Audits Through Express Mode*******");

		//Passing the Values to Search Text Filed
		String SB41 = Lib.getCellValue(XLPATH, "Exceptional Group", 6, 1); 
		AE.SetSearchBTN(SB41);
		chiledTest.log(Status.INFO, "2nd Exceptional Sub Audit type Is Entered");

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
		List<WebElement> NoOfCheckpoints1 = driver.findElements(By.xpath("//ul[@id='sortable8']/li"));
		int Actual_NoOfCheckpoints1 = NoOfCheckpoints1.size();
		int Expected_NoOfCheckpoints1 = 3;
		Assert.assertEquals(Actual_NoOfCheckpoints1, Expected_NoOfCheckpoints1, "Total 3 Checkpoints are NOT Displayed");
		System.out.println("Toatl 3 Checkpoints are displayed");
		chiledTest.log(Status.INFO, "Toatl 3 Checkpoints are displayed");

		System.out.println("*****Dragging 1st checkpoint to Yes Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 1st checkpoint to Yes Compliance********");
		WebElement CP11 = driver.findElement(By.xpath("//ul[@id='sortable8']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP11));
		WebElement Yes11 = driver.findElement(By.xpath("//ul[@class='cps moved negativeSortable placeholder yes_labels ui-sortable']"));
		wait.until(ExpectedConditions.visibilityOf(Yes11));
		action.dragAndDrop(CP11, Yes11).build(). perform();
		System.out.println("First Checkpoint is Dragged to Yes");
		chiledTest.log(Status.INFO, "First Checkpoint is Dragged to Yes");

		Thread.sleep(2000);

		System.out.println("*****Dragging 2nd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 2nd checkpoint to NO Compliance********");

		WebElement CP21 = driver.findElement(By.xpath("//ul[@id='sortable8']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP21));
		WebElement NO1 = driver.findElement(By.xpath("//ul[@class='cps moved negativeSortable placeholder no_labels ui-sortable']"));
		wait.until(ExpectedConditions.visibilityOf(NO1));
		action.dragAndDrop(CP21, NO1).build(). perform();
		chiledTest.log(Status.INFO, "2nd Checkpoint is Dragged to No");
		System.out.println("2nd Checkpoint is Dragged to NO");

		//clicking on the Skip Button
		AE.ClickSkipButton();

		//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		//AE.VerifyAreYouSureYouWantToSkipAllTheUnattemptedExceptionalCheckpointsPopUpIsDisplayed();

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up Cancel Button
		AE.ClickSkipCancelButton();

		//clicking on the Skip Button
		AE.ClickSkipButton();

		//verifying Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up is Displayed
		//AE.VerifyAreYouSureYouWantToSkipAllTheUnattemptedExceptionalCheckpointsPopUpIsDisplayed();

		//clicking on the Are you sure you want to skip all the unattempted exceptional checkpoints? Pop up OK Butto
		AE.ClickSkipOKButton();

		//Clicking on the Exceptional Group Next button
		AE.ClickExceptionalGroupNextButton();

		//********* Input Tab ********

		//Passing the Values to Text and Number
		String TN1 = Lib.getCellValue(XLPATH, "Audit Execution", 42, 0);
		AE.SetTextAndNumber(TN1);
		chiledTest.log(Status.INFO, "Text and Number is Entered");

		//Selecting the 1st Values under 1st Values Drop down list
		WebElement SelectValues = driver.findElement(By.xpath("//ul[@class='cps inputs']/li//select[@id='input_value']/option[2]"));
		wait.until(ExpectedConditions.visibilityOf(SelectValues)).click();

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Butto is Clicked");

		//******** Summary Tab *******

		//Passing the Values to Remarks
		String ER1 = Lib.getCellValue(XLPATH, "Audit Execution", 107, 0);
		AE.SetExpressRemarks(ER1);
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
	/*@Test(priority=13, dependsOnMethods= {"Executing_Audit_Type_Test"})
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

	}*/

}

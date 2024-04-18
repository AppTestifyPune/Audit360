package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import pom.CheckPointPageTest;
import pom.ConfigureAuditPageTest;
import pom.GroupPageTest;
import pom.LoginPageTest;

public class InputDataTypesRequiredFieldsFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Group List 
	@Test(priority = 860)
	public void Creating_Group_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

		parentTest = extent.createTest("Input Data Type Validation Functionality through Normal Mode Test", "Testing the Functionality of the All 7 Data Type Validation Through Normal Mode Test");

		chiledTest = parentTest.createNode("Creating the Group Test");

		System.out.println("Creating the Group Test");

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		l.ClickSigninBTN();

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

		//clicking on the Group Type
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
			chiledTest.log(Status.INFO, "Redistribution Logic is Selected");

			//Clicking on the Matched
			AG.ClickMatched(driver);

			//Passing the Values to Add group from excel
			String ADG = Lib.getCellValue(XLPATH, "Input Data typs", 1, 0);
			AG.SetAddnewGroup(ADG);
			chiledTest.log(Status.INFO, "Group Name is Entered");

			//clicking on the Add button
			AG.ClickAddBTN();
			chiledTest.log(Status.INFO, "Add Button is Clicked");

			//Verifying Group is Created Success Message is Displayed or not
			AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
			chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*****************************");

	}

	//Adding all the 7 Data type to Created Group
	@Test(priority = 861, dependsOnMethods= {"Creating_Group_Test"})
		public void Adding_All_7_Data_Types_To_Group_Test() throws InterruptedException
		{
			CheckPointPageTest CC = new CheckPointPageTest(driver);

			chiledTest = parentTest.createNode("Adding All 7 Data Types To Group Test");

			System.out.println("Adding All 7 Data Types To Group Test");

			//Passing the Values to Search Button
			String SS = Lib.getCellValue(XLPATH, "Input Data typs", 1, 0);
			CC.SetSearchBTN(SS);

			//Clicking on the Add Checkpoint Button
			CC.ClickAddCheckPointBTN(driver);
			chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

			//Passing the Values to the Enter Checkpoint intent
			String ECI1 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
			CC.SetEnterCheckpointintent(ECI1, driver);
			chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

			//Passing the Values to the Description
			String DS1 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
			CC.SetDescription(DS1);
			chiledTest.log(Status.INFO, "Description is Entered");

			//clicking on the Expected action from auditor
			CC.ClickExpectedactionfromauditor(driver);

			//Passing the Values to Expected action from auditor
			String EA1 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
			CC.SetExpectedActionFromAuditor(EA1);
			chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

			//Clicking on the Matched
			CC.ClickMatched();

			//Clicking on the Data Type
			CC.ClickDataType(driver);

			//Passing the Values to Data Type 
			String SD1 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
			CC.SetDataType(SD1);
			chiledTest.log(Status.INFO, "Text is Selected Under Data Type Drop down");

			//Clicking on the Matching
			CC.ClickMatched();

			//clicking on the Risk level 
			CC.ClickRiskLevel(driver);

			//Passing the Values to Risk Level
			String RL1 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
			CC.SetRiskLevel(RL1);
			chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

			CC.ClickMatched();

			//Passing the Values to Notes to auditors description
			String NTA1 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
			CC.SetNoticetoAuditors(NTA1);
			chiledTest.log(Status.INFO, "Notes to auditors is Entered");

			//Clicking on the Submit and Create new Button
			CC.ClickSubmitCreateBTN(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			WebDriverWait wait = new WebDriverWait(driver, 10);
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

			System.out.println("*********************************");

			//Passing the Values to the Enter Checkpoint intent
			String ECI2 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
			CC.SetEnterCheckpointintent(ECI2, driver);
			chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

			//Passing the Values to the Description
			String DS2 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
			CC.SetDescription(DS2);
			chiledTest.log(Status.INFO, "Description is Entered");

			//clicking on the Expected action from auditor
			CC.ClickExpectedactionfromauditor(driver);

			//Passing the Values to Expected action from auditor
			String EA2 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
			CC.SetExpectedActionFromAuditor(EA2);
			chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

			//Clicking on the Matched
			CC.ClickMatched();

			//Clicking on the Data Type
			CC.ClickDataType(driver);

			//Passing the Values to Data Type 
			String SD2 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
			CC.SetDataType(SD2);
			chiledTest.log(Status.INFO, "Number is Selected Under Data Type Drop down");

			//Clicking on the Matching
			CC.ClickMatched();

			//clicking on the Risk level 
			CC.ClickRiskLevel(driver);

			//Passing the Values to Risk Level
			String RL2 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
			CC.SetRiskLevel(RL2);
			chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

			CC.ClickMatched();

			//Passing the Values to Notes to auditors description
			String NTA2 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
			CC.SetNoticetoAuditors(NTA2);
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

			System.out.println("*********************************");

			//Passing the Values to the Enter Checkpoint intent
			String ECI3 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
			CC.SetEnterCheckpointintent(ECI3, driver);
			chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

			//Passing the Values to the Description
			String DS3 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
			CC.SetDescription(DS3);
			chiledTest.log(Status.INFO, "Description is Entered");

			//clicking on the Expected action from auditor
			CC.ClickExpectedactionfromauditor(driver);

			//Passing the Values to Expected action from auditor
			String EA3 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
			CC.SetExpectedActionFromAuditor(EA3);
			chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

			//Clicking on the Matched
			CC.ClickMatched();

			//Clicking on the Data Type
			CC.ClickDataType(driver);

			//Passing the Values to Data Type 
			String SD3 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
			CC.SetDataType(SD3);
			chiledTest.log(Status.INFO, "Text and Number is Selected Under Data Type Drop down");

			//Clicking on the Matching
			CC.ClickMatched();

			//clicking on the Risk level 
			CC.ClickRiskLevel(driver);

			//Passing the Values to Risk Level
			String RL3 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
			CC.SetRiskLevel(RL3);
			chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

			CC.ClickMatched();

			//Passing the Values to Notes to auditors description
			String NTA3 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
			CC.SetNoticetoAuditors(NTA3);
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

			System.out.println("*********************************");


			//Passing the Values to the Enter Checkpoint intent
			String ECI4 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
			CC.SetEnterCheckpointintent(ECI4, driver);
			chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

			//Passing the Values to the Description
			String DS4 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
			CC.SetDescription(DS4);
			chiledTest.log(Status.INFO, "Description is Entered");

			//clicking on the Expected action from auditor
			CC.ClickExpectedactionfromauditor(driver);

			//Passing the Values to Expected action from auditor
			String EA4 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
			CC.SetExpectedActionFromAuditor(EA4);
			chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

			//Clicking on the Matched
			CC.ClickMatched();

			//Clicking on the Data Type
			CC.ClickDataType(driver);

			//Passing the Values to Data Type 
			String SD4 = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
			CC.SetDataType(SD4);
			chiledTest.log(Status.INFO, "Date is Selected Under Data Type Drop down");

			//Clicking on the Matching
			CC.ClickMatched();

			//clicking on the Risk level 
			CC.ClickRiskLevel(driver);

			//Passing the Values to Risk Level
			String RL4 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
			CC.SetRiskLevel(RL4);
			chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

			CC.ClickMatched();

			//Passing the Values to Notes to auditors description
			String NTA4 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
			CC.SetNoticetoAuditors(NTA4);
			chiledTest.log(Status.INFO, "Notes to auditors is Entered");

			//Clicking on the Submit and Create new Button
			CC.ClickSubmitCreateBTN(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			WebElement SuccessMSG4 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
			if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG4)).isDisplayed()){
				String Atcual_Text = SuccessMSG4.getText();
				String Expected_Text = "Checkpoint created successfully.";
				Assert.assertEquals(Atcual_Text, Expected_Text);
				System.out.println("Checkpoint Created Successfully Message is Displayed");
				chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
			}else {
				System.out.println("Checkpoint Created Successfully Message is Not Displayed");
				chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
			}

			System.out.println("*********************************");

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

			//Passing the Values to Expected action from auditor
			String EA5 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
			CC.SetExpectedActionFromAuditor(EA5);
			chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

			//Clicking on the Matched
			CC.ClickMatched();

			//Clicking on the Data Type
			CC.ClickDataType(driver);

			//Passing the Values to Data Type 
			String SD5 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
			CC.SetDataType(SD5);
			chiledTest.log(Status.INFO, "Date and Range is Selected Under Data Type Drop down");

			//Clicking on the Matching
			CC.ClickMatched();

			//clicking on the Risk level 
			CC.ClickRiskLevel(driver);

			//Passing the Values to Risk Level
			String RL5 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
			CC.SetRiskLevel(RL5);
			chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

			CC.ClickMatched();

			//Passing the Values to Notes to auditors description
			String NTA5 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
			CC.SetNoticetoAuditors(NTA5);
			chiledTest.log(Status.INFO, "Notes to auditors is Entered");

			//Clicking on the Submit and Create new Button
			CC.ClickSubmitCreateBTN(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			WebElement SuccessMSG5 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
			if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG5)).isDisplayed()){
				String Atcual_Text = SuccessMSG5.getText();
				String Expected_Text = "Checkpoint created successfully.";
				Assert.assertEquals(Atcual_Text, Expected_Text);
				System.out.println("Checkpoint Created Successfully Message is Displayed");
				chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
			}else {
				System.out.println("Checkpoint Created Successfully Message is Not Displayed");
				chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
			}

			System.out.println("*********************************");

			//Passing the Values to the Enter Checkpoint intent
			String ECI6 = Lib.getCellValue(XLPATH, "Check Point", 126, 0);
			CC.SetEnterCheckpointintent(ECI6, driver);
			chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

			//Passing the Values to the Description
			String DS6 = Lib.getCellValue(XLPATH, "Check Point", 132, 0);
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
			String SD6 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
			CC.SetDataType(SD6);
			chiledTest.log(Status.INFO, "Value is Selected Under Data Type Drop down");

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
			WebElement SuccessMSG6 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
			if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG6)).isDisplayed()){
				String Atcual_Text = SuccessMSG6.getText();
				String Expected_Text = "Checkpoint created successfully.";
				Assert.assertEquals(Atcual_Text, Expected_Text);
				System.out.println("Checkpoint Created Successfully Message is Displayed");
				chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
			}else {
				System.out.println("Checkpoint Created Successfully Message is Not Displayed");
				chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
			}

			System.out.println("*********************************");

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
			String EA7 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
			CC.SetExpectedActionFromAuditor(EA7);
			chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

			//Clicking on the Matched
			CC.ClickMatched();

			//Clicking on the Data Type
			CC.ClickDataType(driver);

			//Passing the Values to Data Type 
			String SD7 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
			CC.SetDataType(SD7);
			chiledTest.log(Status.INFO, "Percentage is Selected Under Data Type Drop down");

			//Clicking on the Matching
			CC.ClickMatched();

			//clicking on the Risk level 
			CC.ClickRiskLevel(driver);

			//Passing the Values to Risk Level
			String RL7 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
			CC.SetRiskLevel(RL7);
			chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

			CC.ClickMatched();

			//Passing the Values to Notes to auditors description
			String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
			CC.SetNoticetoAuditors(NTA7);
			chiledTest.log(Status.INFO, "Notes to auditors is Entered");

			//Clicking on the Submit and Create new Button
			CC.ClickSubmitButton(driver);
			chiledTest.log(Status.INFO, "Submit Button is Clicked");

			//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
			CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
			chiledTest.log(Status.INFO, "Checkpoint created successfully. massage is displayed");

			System.out.println("*********************************");

		}

		//Validating all the 7 Data type while Executing the Audit
		@Test(priority = 862, dependsOnMethods= {"Adding_All_7_Data_Types_To_Group_Test"})
		public void Creating_Audit_Type_Test() throws InterruptedException
		{
			chiledTest = parentTest.createNode("Creating Audit Type Test");

			System.out.println("Creating Audit Type Test");

			ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

			CA.ClickScrollBar(driver);

			//Clicking on the Configure Audit Under side menu
			CA.ClickConfigureAudit(driver);

			//Clicking on the Create Audit Type Button
			CA.ClickCreateAuditTypeBTN(driver);
			chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

			//******* Begin Tab *****************************

			//Passing the Values to Audit Type Name
			String ATN = Lib.getCellValue(XLPATH, "Input Data typs", 7, 0);
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
			String SCG = Lib.getCellValue(XLPATH, "Input Data typs", 1, 0);
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
			chiledTest.log(Status.INFO, "Zero Talerence Risk Scoring is Entered");

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

			Thread.sleep(3000);

			//Clicking on the Actual Score Slab Radio Button
			CA.ClickActualScoreSlabRadioBTN(driver);
			chiledTest.log(Status.INFO, "Actual Score Slab Radio Button is Clicked");

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


		//Creating the Schedule
		@Test(priority = 863, dependsOnMethods= {"Creating_Audit_Type_Test"})
		public void Creating_Schedule_To_Validate_Through_Normal_Mode_Test() throws InterruptedException
		{
			chiledTest = parentTest.createNode("Creating Schedule To Validate Through Normal Mode Test");

			System.out.println("Creating Schedule Creating Schedule To Validate Through Normal Mode Test");

			LoginPageTest l=new LoginPageTest(driver);

			AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

			l.ClickProfileBTN(driver);

			l.ClickLogoutBTN();

			chiledTest.log(Status.INFO, "Entered User Name and Password");
			String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
			l.setusername(un);

			String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
			l.setpassword(pw);

			l.ClickSigninBTN();

			//Verifying sign in successful message is displayed
			l.verifySignedInSuccessMsgIsDisplayed(driver);
			chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

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
			String SAT = Lib.getCellValue(XLPATH, "Input Data typs", 7, 0);
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

			System.out.println("************************************");

		}
	 

	//Validating all the 7 Data type while Executing the Audit
	@Test(priority = 864, dependsOnMethods= {"Creating_Schedule_To_Validate_Through_Normal_Mode_Test"})
	public void Validating_All_7_Data_Types_Through_Normal_Mode_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Validating All 7 Data Types Through Normal mode Test");

		System.out.println("Validating All 7 Data Types Through Normal mode Test");

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

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Input Data typs", 7, 0);
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
		String AT3 = Lib.getCellValue(XLPATH, "Input Data typs", 7, 0);
		AE.SetAuditType(AT3, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Not Started Button
		AE.ClickNotStartedBTN(driver);
		chiledTest.log(Status.INFO, "Not Started Button is Clicked");

		//Clicking on the Normal Mode
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		System.out.println("****Executing 1st Chckpoint******");

		chiledTest.log(Status.INFO, "***Executing 1st Chckpoint******");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER11);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR11 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR11);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data);
		String Data1 = Data.toLowerCase();

		String Data2 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		System.out.println("Entered Input Data is : "+ Data2);

		Assert.assertEquals(Data2, Data1);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//verifying red color is displayed
		AE.VerifyRedColorisDisplayed(driver);

		//Passing the Values to input Values Text Filed
		String IV = Lib.getCellValue(XLPATH, "Audit Execution", 41, 0);
		AE.SetEnterInputValues(IV, driver);
		chiledTest.log(Status.INFO, "input Values is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("****Executing 2nd Chckpoint******");

		chiledTest.log(Status.INFO, "***Executing 2nd Chckpoint******");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER2);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR2 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR2);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data3 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data3);
		String Data4 = Data3.toLowerCase();

		String Data5 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		System.out.println("Entered Input Data is : "+ Data5);

		Assert.assertEquals(Data4, Data5);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//verifying red color is displayed
		AE.VerifyRedColorisDisplayed(driver);

		//Passing the Values to input Values Text Filed
		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV1, driver);
		chiledTest.log(Status.INFO, "input Values is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("****Executing 3rd Chckpoint******");

		chiledTest.log(Status.INFO, "***Executing 3rd Chckpoint******");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER3 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER3);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR3 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR3);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data6 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data6);
		String Data7= Data6.toLowerCase();

		String Data8 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		System.out.println("Entered Input Data is : "+ Data8);

		Assert.assertEquals(Data7, Data8);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//verifying red color is displayed
		AE.VerifyRedColorisDisplayed(driver);

		//Passing the Values to input Values Text Filed
		String IV3 = Lib.getCellValue(XLPATH, "Audit Execution", 42, 0);
		AE.SetEnterInputValues(IV3, driver);
		chiledTest.log(Status.INFO, "input Values is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("****Executing 4th Chckpoint******");

		chiledTest.log(Status.INFO, "***Executing 4th Chckpoint******");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER4 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER4);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR4 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR4);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data9 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data9);
		String Data10 = Data9.toLowerCase();

		String Data11 = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
		System.out.println("Entered Input Data is : "+ Data11);

		Assert.assertEquals(Data10, Data11);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//verifying red color is displayed
		AE.VerifyRedColorisDisplayed(driver);

		//Passing the Values to Date
		String ND1 = Lib.getCellValue(XLPATH, "Input Data typs", 13, 0);
		AE.SetNormalModeDate(ND1);
		chiledTest.log(Status.INFO, "Date is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("****Executing 5th Chckpoint******");

		chiledTest.log(Status.INFO, "***Executing 5th Chckpoint******");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER5 = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER5);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR5 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR5);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data12 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data12);
		String Data13 = Data12.toLowerCase();
		String Data14 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		System.out.println("Entered Input Data is : "+ Data14);
		Assert.assertEquals(Data13, Data14);

		//Passing the Values to Date and Range
		String ND2 = Lib.getCellValue(XLPATH, "Input Data typs", 19, 0);
		AE.SetNormalModeDate(ND2);
		chiledTest.log(Status.INFO, "Date is Entered");

		//Clicking on the Apply button in calendar
		WebElement ApplyBTN = driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-success']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ApplyBTN);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("****Executing 6th Chckpoint******");

		chiledTest.log(Status.INFO, "***Executing 6th Chckpoint******");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER6 = Lib.getCellValue(XLPATH, "Audit Execution", 16, 0);
		AE.SetEnterRemarks(ER6);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR6 = Lib.getCellValue(XLPATH, "Audit Execution", 31, 0);
		AE.SetEnterConfidentalRemarks(ECR6);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data15 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data15);
		String Data16 = Data15.toLowerCase();

		String Data17 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data17);

		Assert.assertEquals(Data16, Data17);

		//Checking the Values drop down is Required filed or not
		WebElement Values = driver.findElement(By.xpath("//select[@id='audit_compliance_input_value' and @required='required']"));
		Assert.assertTrue(Values.isEnabled(), "Select Values drop down is not working ad required fields");
		System.out.println("Please Select Values is Required Field");
		chiledTest.log(Status.INFO, "Please Select Values is Required Field");

		AE.SelectingValues(driver);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("****Executing 7th Chckpoint******");

		chiledTest.log(Status.INFO, "***Executing 7th Chckpoint******");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER7 = Lib.getCellValue(XLPATH, "Audit Execution", 17, 0);
		AE.SetEnterRemarks(ER7);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR7 = Lib.getCellValue(XLPATH, "Audit Execution", 32, 0);
		AE.SetEnterConfidentalRemarks(ECR7);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Checking the Data Type 
		String Data18 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data18);
		String Data19 = Data18.toLowerCase();
		String Data20 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		System.out.println("Entered Input Data is : "+ Data20);
		Assert.assertEquals(Data19, Data20);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying red color is displayed
		AE.VerifyRedColorisDisplayed(driver);

		//Passing the Values to input Values Text Filed
		String IV7 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV7, driver);
		chiledTest.log(Status.INFO, "input Values is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("**************************");

	}

	//Creating the Schedule
	@Test(priority = 865, dependsOnMethods= {"Validating_All_7_Data_Types_Through_Normal_Mode_Test"})
	public void Creating_Schedule_To_Validate_Through_Express_Mode_Test() throws InterruptedException
	{	
		chiledTest = parentTest.createNode("Creating Schedule To Validate Through Express Mode Test");

		System.out.println("Creating Schedule To Validate Through Express Mode Test");

		LoginPageTest l=new LoginPageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);
		
		l.ClickProfileBTN(driver);
		
		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		l.ClickSigninBTN();

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

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
		String SAT = Lib.getCellValue(XLPATH, "Input Data typs", 7, 0);
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

		System.out.println("************************************");

	}


	//Validating all the 7 Data type while Executing the Audit
	@Test(priority = 866, dependsOnMethods= {"Creating_Schedule_To_Validate_Through_Express_Mode_Test"})
	public void Validating_All_7_Data_Types_Through_Express_Mode_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Validating All 7 Data Types Through Express mode Test");

		System.out.println("Validating All 7 Data Types Through Express mode Test");

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

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Input Data typs", 7, 0);
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
		String AT3 = Lib.getCellValue(XLPATH, "Input Data typs", 7, 0);
		AE.SetAuditType(AT3, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Not Started Button
		AE.ClickNotStartedBTN(driver);
		chiledTest.log(Status.INFO, "Not Started Button is Clicked");

		//Clicking on the Express Mode
		AE.ClickExpress(driver);
		chiledTest.log(Status.INFO, "Express Button is Clicked");

		//Clicking on the Input Tab
		AE.ClickInputTab();

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//checking Please provide inputs to all checkpoints before moving to next tab alert Pop up is Displayed
		AE.VerifyPleaseProvideInputsToAllCheckpointsBeforeMovingToNextTabPopUpIsDisplayed();

		//Passing the values to Text
		String TT = Lib.getCellValue(XLPATH, "Input Data typs", 25, 0);
		AE.SetFirstText(TT);
		chiledTest.log(Status.INFO, "Text is Entered");

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//checking Please provide inputs to all checkpoints before moving to next tab alert Pop up is Displayed
		AE.VerifyPleaseProvideInputsToAllCheckpointsBeforeMovingToNextTabPopUpIsDisplayed();

		//Passing the values to Number
		String FN = Lib.getCellValue(XLPATH, "Input Data typs", 36, 0);
		AE.SetFirstNumber(FN, driver);
		chiledTest.log(Status.INFO, "Number is Entered");

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//checking Please provide inputs to all checkpoints before moving to next tab alert Pop up is Displayed
		AE.VerifyPleaseProvideInputsToAllCheckpointsBeforeMovingToNextTabPopUpIsDisplayed();

		//Passing the values to text and Number
		String TN = Lib.getCellValue(XLPATH, "Input Data typs", 31, 0);
		AE.SetTextAndNumber(TN);
		chiledTest.log(Status.INFO, "Number is Entered");

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//checking Please provide inputs to all checkpoints before moving to next tab alert Pop up is Displayed
		AE.VerifyPleaseProvideInputsToAllCheckpointsBeforeMovingToNextTabPopUpIsDisplayed();

		//Passing the Values to Date
		String SD = Lib.getCellValue(XLPATH, "Input Data typs", 13, 0);
		AE.SetDate(SD, driver);
		chiledTest.log(Status.INFO, "date is Entered");

		//Clicking on the Apply button in calendar
		WebElement ApplyBTN = driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-success']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ApplyBTN);

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//checking Please provide inputs to all checkpoints before moving to next tab alert Pop up is Displayed
		AE.VerifyPleaseProvideInputsToAllCheckpointsBeforeMovingToNextTabPopUpIsDisplayed();

		//Selecting the 1st Values under Values
		AE.SelectingValuesUnderExpressMode(driver);

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//checking Please provide inputs to all checkpoints before moving to next tab alert Pop up is Displayed
		AE.VerifyPleaseProvideInputsToAllCheckpointsBeforeMovingToNextTabPopUpIsDisplayed();

		//Passing the Values to percentage
		String PN = Lib.getCellValue(XLPATH, "Input Data typs", 36, 0);
		AE.SetPercentage(PN);
		chiledTest.log(Status.INFO, "Percentage is Entered");

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Passing the Values to Remarks
		String ER = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetExpressRemarks(ER);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Clicking on the Submit Button
		AE.ClickExpressModeSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit submitted successfully success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully success Message is Displayed");

		System.out.println("****************************");

	}

}

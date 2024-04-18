package scripts;

import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.CheckPointPageTest;
import pom.LoginPageTest;

public class CheckPointPageFunctionalityTest extends BaseTest {

	//Testing Functionality of the Create Check Point for Verify
	@Test(priority=0) 
	public void Manage_checkPoint_Page_Test() throws InterruptedException {

		LoginPageTest l=new LoginPageTest(driver);

		parentTest = extent.createTest("CheckPoint Functionality Test", "Testing the Functionality of the Create Check Point for 4 types");

		chiledTest = parentTest.createNode("Manage CheckPoint Page Test");

		System.out.println("Manage CheckPoint Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excels
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

		System.out.println("****************************************");

	}

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority=1, dependsOnMethods= {"Manage_checkPoint_Page_Test"}) 
	public void Adding_Four_Types_Of_CheckPoints_To_General_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding Four Types Of CheckPoints To General Group Test");

		chiledTest = parentTest.createNode("Adding Four Types Of CheckPoints To General Group Test");

		System.out.println("Creating Verify Type Checkpoint Test");

		chiledTest.log(Status.INFO, "Creating Verify Type Checkpoint Test");

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 8, 0);
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

		//Passing Values to NO Text Box
		String NB5 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB5);

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

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to Partial Disposition
		String PD25 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD25);

		//Passing the Values to Partial Disposition
		String PD35 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD35);

		//Passing the Values to NA Disposition
		String ND115 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND115);

		//Passing the Values to NA Disposition
		String ND125 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND125);

		//Passing the Values to NA Disposition
		String ND135 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND135);

		//Passing the Values to NA Disposition
		String ND145 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND145);

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

		System.out.println("****Creating Input Type Checkpoint Test***");

		chiledTest.log(Status.INFO, "****Creating Input Type Checkpoint Test****");

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

		System.out.println("****Creating Both Type Checkpoint Test***");

		chiledTest.log(Status.INFO, "****Creating Both Type Checkpoint Test****");


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


		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to Partial Disposition
		String PD17 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD17);

		//Passing the Values to Partial Disposition
		String PD27 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD27);

		//Passing the Values to Partial Disposition
		String PD37 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD37);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Passing the Values to NA Disposition
		String ND127 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND127);

		//Passing the Values to NA Disposition
		String ND137 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND137);

		//Passing the Values to NA Disposition
		String ND147 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND147);

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

		System.out.println("****Creating Both With Condition Type Checkpoint Test***");

		chiledTest.log(Status.INFO, "****Creating Both With Condition Type Checkpoint Test****");

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

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to Partial Disposition
		String PD18 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD18);

		//Passing the Values to Partial Disposition
		String PD28 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD28);

		//Passing the Values to Partial Disposition
		String PD38 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD38);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//Passing the Values to NA Disposition
		String ND128 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND128);

		//Passing the Values to NA Disposition
		String ND138 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND138);

		//Passing the Values to NA Disposition
		String ND148 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND148);

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

	//Testing Functionality of the Create Check Point for Both With Conditions Type
	@Test(priority=2, dependsOnMethods= {"Adding_Four_Types_Of_CheckPoints_To_General_Group_Test"}) 
	public void Checkpoint_View_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Checkpoint View Test");

		System.out.println("Checkpoint View Test");

		System.out.println("****1st Checkpoint View Test****");

		chiledTest.log(Status.INFO, "*****1st Checkpoint View Test*****");

		//Clicking on the First Created Checkpoint
		CC.ClickFirstCheckpoint(driver);
		chiledTest.log(Status.INFO, "Clicked on the First Checkpoint");

		//Verify Edit Checkpoint page is Displayed
		CC.VerifyEditCheckpointPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Edit Checkpoint page is Displayed");

		CC.VerifyCheckPointsView(driver);

		//Clicking on the Close Button
		CC.ClickEditPageCloseBTN(driver);

		System.out.println("****2nd Checkpoint View Test****");

		chiledTest.log(Status.INFO, "*****2nd Checkpoint View Test*****");

		CC.ClickSecondCheckpoint(driver);

		//Verify Edit Checkpoint page is Displayed
		CC.VerifyEditCheckpointPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Edit Checkpoint page is Displayed");

		CC.InputCheckPointView(driver);

		//Clicking on the Close Button
		CC.ClickEditPageCloseBTN(driver);

		System.out.println("****3rd Checkpoint View Test****");

		chiledTest.log(Status.INFO, "*****3rd Checkpoint View Test*****");

		CC.ClickThirdCheckpoint(driver);

		//Verify Edit Checkpoint page is Displayed
		CC.VerifyEditCheckpointPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Edit Checkpoint page is Displayed");

		CC.BothCheckpointView(driver);

		//Clicking on the Close Button
		CC.ClickEditPageCloseBTN(driver);

		System.out.println("****4th Checkpoint View Test****");

		chiledTest.log(Status.INFO, "*****4th Checkpoint View Test*****");

		CC.ClickFourtcheckpoint(driver);

		//Verify Edit Checkpoint page is Displayed
		CC.VerifyEditCheckpointPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Edit Checkpoint page is Displayed");

		CC.BothWithCondtionsCheckPointView(driver);

		//Clicking on the Close Button
		CC.ClickEditPageCloseBTN(driver);

		System.out.println("********************************************************************");

	}

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority=3, enabled=false) 
	public void Adding_Four_Types_Of_CheckPoints_To_Another_General_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding Four Types Of CheckPoints To Another General Group Test");

		chiledTest = parentTest.createNode("Adding Four Types Of CheckPoints To Another General Group Test");

		System.out.println("Creating Verify Type Checkpoint Test");

		chiledTest.log(Status.INFO, "Creating Verify Type Checkpoint Test");

		//Clicking on the Manage Check Point Header
		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 11, 0);
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

		//Passing Values to NO Text Box
		String NB5 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB5);

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

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to Partial Disposition
		String PD25 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD25);

		//Passing the Values to Partial Disposition
		String PD35 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD35);

		//Passing the Values to NA Disposition
		String ND115 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND115);

		//Passing the Values to NA Disposition
		String ND125 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND125);

		//Passing the Values to NA Disposition
		String ND135 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND135);

		//Passing the Values to NA Disposition
		String ND145 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND145);

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

		System.out.println("****Creating Input Type Checkpoint Test***");

		chiledTest.log(Status.INFO, "****Creating Input Type Checkpoint Test****");

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

		System.out.println("****Creating Both Type Checkpoint Test***");

		chiledTest.log(Status.INFO, "****Creating Both Type Checkpoint Test****");


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


		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to Partial Disposition
		String PD17 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD17);

		//Passing the Values to Partial Disposition
		String PD27 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD27);

		//Passing the Values to Partial Disposition
		String PD37 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD37);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Passing the Values to NA Disposition
		String ND127 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND127);

		//Passing the Values to NA Disposition
		String ND137 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND137);

		//Passing the Values to NA Disposition
		String ND147 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND147);

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

		System.out.println("****Creating Both With Condition Type Checkpoint Test***");

		chiledTest.log(Status.INFO, "****Creating Both With Condition Type Checkpoint Test****");

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

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to Partial Disposition
		String PD18 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD18);

		//Passing the Values to Partial Disposition
		String PD28 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD28);

		//Passing the Values to Partial Disposition
		String PD38 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD38);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//Passing the Values to NA Disposition
		String ND128 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND128);

		//Passing the Values to NA Disposition
		String ND138 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND138);

		//Passing the Values to NA Disposition
		String ND148 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND148);

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

	//Adding the 4 types of Checkpoints to Fixed score Logic
	@Test(priority=4, dependsOnMethods= {"Checkpoint_View_Test"})
	public void Adding_Four_CheckPoints_To_Fixed_Score_Logic_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Adding 4 Checkpoints to Fixed Score Logic Group");

		System.out.println("Adding 4 Checkpoints to Fixed Score Logic Group");

		chiledTest.log(Status.INFO, "Adding 4 Checkpoints to Fixed Score Logic Group");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 9, 0);
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
		String YB5 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 22, 0);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 29, 0);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 41, 0);
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


		System.out.println("************Creating Input Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Input Checkpoint ***************");

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
		String EA51 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
		CC.SetExpectedActionFromAuditor(EA51);
		chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
		CC.SetDataType(SD);
		chiledTest.log(Status.INFO, "Data is Selected under data Type");

		//Clicking on the Matching
		CC.ClickMatched();

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

		CC.ClickPositiveConformity();

		//passing the Values to Positive Conformity
		String PC1 = Lib.getCellValue(XLPATH, "Check Point", 227, 0);
		CC.SetPositiveConformity(PC1);
		chiledTest.log(Status.INFO, "NO Is Selectd Under Positive Conformity");

		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 29, 0);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 33, 0);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 41, 0);
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

		CC.ClickPositiveConformity();

		//passing the Values to Positive Conformity
		String PC2 = Lib.getCellValue(XLPATH, "Check Point", 227, 0);
		CC.SetPositiveConformity(PC2);
		chiledTest.log(Status.INFO, "NO Is Selectd Under Positive Conformity");

		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 29, 0);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 33, 0);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "FXSL Scenarios 2", 44, 0);
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

	//Adding the 4 types of Checkpoints To Percentage Score Logic Group Test
	@Test(priority=5, dependsOnMethods= {"Adding_Four_CheckPoints_To_Fixed_Score_Logic_Group_Test"})
	public void Adding_Four_CheckPoints_To_Percentage_Score_Logic_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding Four CheckPoints To Percentage Score Logic Group Test");

		chiledTest = parentTest.createNode("Adding Four CheckPoints To Percentage Score Logic Group Test");

		chiledTest.log(Status.INFO, "Adding Four CheckPoints To Percentage Score Logic Group Test");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 10, 0);
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
		String YB5 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 21, 0);
		CC.SetYestextBox(YB5);

		//Passing Values to NO Text Box
		String NB5 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 17, 0);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 17, 0);
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


		System.out.println("************Creating Input Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Input Checkpoint ***************");

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
		String EA51 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
		CC.SetExpectedActionFromAuditor(EA51);
		chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		CC.SetDataType(SD);
		chiledTest.log(Status.INFO, "Data and Range is Selected under data Type");

		//Clicking on the Matching
		CC.ClickMatched();

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
		String YB7 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 21, 0);
		CC.SetYestextBox(YB7);

		//Passing Values to NO Text Box
		String NB7 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 17, 0);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 17, 0);
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

		CC.ClickPositiveConformity();

		//passing the Values to Positive Conformity
		String PC1 = Lib.getCellValue(XLPATH, "Check Point", 227, 0);
		CC.SetPositiveConformity(PC1);
		chiledTest.log(Status.INFO, "NO Is Selectd Under Positive Conformity");

		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 17, 0);
		CC.SetYestextBox(YB8);

		//Passing Values to NO Text Box
		String NB8 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 33, 0);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "POPSL Scenario 3", 50, 0);
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


	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority=6, dependsOnMethods= {"Adding_Four_CheckPoints_To_Percentage_Score_Logic_Group_Test"}) 
	public void Adding_Four_Types_Of_Checkpoints_To_Dynamic_Annexure_Group_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Adding Four Types Of Checkpoints To Dynamic Annexure Group Test");

		System.out.println("Adding Four Types Of Checkpoints To Dynamic Annexure Group Test");

		System.out.println("****Adding Verify Type Checkpoint****");

		chiledTest.log(Status.INFO, "****Adding Verify Type Checkpoint****");

		//Clicking on the Manage Check Point Header
		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 15, 0);
		CC.SetSearchBTN(SS);

		//Clicking on the add check Point Button
		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Check Point Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(ECI, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values Expected Action from Auditor
		String EA = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action from Auditor");

		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB);

		//Passing Values to NO Text Box
		String NB = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB);

		//Passing the Values to Yes Disposition
		String YD = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD);

		//Passing the Values to Yes Disposition
		String YD1 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD1);

		//Passing the Values to Yes Disposition
		String YD2 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD2);

		//Passing the Values to Yes Disposition
		String YD3 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD3);

		//Passing the Values to No Disposition
		String ND = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND);

		//Passing the Values to No Disposition
		String ND1 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND1);

		//Passing the Values to No Disposition
		String ND2 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND2);

		//Passing the Values to No Disposition
		String ND3 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND3);


		//Passing the Values to Partial Disposition
		String PD = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD);

		//Passing the Values to Partial Disposition
		String PD1 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD1);

		//Passing the Values to Partial Disposition
		String PD2 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD2);

		//Passing the Values to Partial Disposition
		String PD3 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD3);

		//Passing the Values to NA Disposition
		String ND11 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND11);

		//Passing the Values to NA Disposition
		String ND12 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND12);

		//Passing the Values to NA Disposition
		String ND13 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND13);

		//Passing the Values to NA Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND14);


		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL);
		chiledTest.log(Status.INFO, "Zero Tolerence Option is Selected");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit and Create New  Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebDriverWait wait = new WebDriverWait(driver, 10);
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

		System.out.println("****Creating Input Type CheckPoint****");

		chiledTest.log(Status.INFO, "****Creating Input Type CheckPoint****");

		//Passing the Values to the Enter Checkpoint intent
		String ECI1 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CC.SetEnterCheckpointintent(ECI1, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC1 = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC1);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS1 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		CC.SetDescription(DS1);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD1 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD1);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing the Values to Values 
		String SV1 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV1, driver);
		chiledTest.log(Status.INFO, "Values is Entered");

		//Passing the Values to Values 
		String SV2 = Lib.getCellValue(XLPATH, "Check Point", 140, 0);
		CC.SetDataTypeValues(SV2, driver);
		chiledTest.log(Status.INFO, "Values is Entered");

		//Passing the Values to Values 
		String SV3 = Lib.getCellValue(XLPATH, "Check Point", 141, 0);
		CC.SetDataTypeValues(SV3, driver);
		chiledTest.log(Status.INFO, "Values is Entered");

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL1 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
		CC.SetRiskLevel(RL1);
		chiledTest.log(Status.INFO, "Medium Option is Selected");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA1 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA1);
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

		System.out.println("*****Creating Both Type of CheckPoint*****");

		chiledTest.log(Status.INFO, "****Creating Both Type of CheckPoint*****");

		//Passing the Values to the Enter Checkpoint intent
		String ECI2 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CC.SetEnterCheckpointintent(ECI2, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC2 = Lib.getCellValue(XLPATH, "Annexure", 10, 0);
		CC.SetSelectAnnexureColumns(SAC2);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS2 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		CC.SetDescription(DS2);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Passing Values to Yes Text Box
		String YB2 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB2);

		//Passing Values to NO Text Box
		String NB2 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB2);

		//Passing the Values to Yes Disposition
		String YD31 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD31);

		//Passing the Values to Yes Disposition
		String YD11 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD11);

		//Passing the Values to Yes Disposition
		String YD21 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD21);

		//Passing the Values to Yes Disposition
		String YD311 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD311);

		//Passing the Values to No Disposition
		String ND31 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND31);

		//Passing the Values to No Disposition
		String ND4 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND4);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to No Disposition
		String ND6 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND6);

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to Partial Disposition
		String PD6 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD6);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to NA Disposition
		String ND15 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND16);

		//Passing the Values to NA Disposition
		String ND17 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND17);

		//Passing the Values to NA Disposition
		String ND18 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND18);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD3 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD3);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL3 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL3);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected");

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

		System.out.println("****Creating Both With Condition Type Checkpoint*****");

		chiledTest.log(Status.INFO, "****Checkpoint intent is Entered****");

		//Passing the Values to the Enter Checkpoint intent
		String ECI4 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CC.SetEnterCheckpointintent(ECI4, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC4 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		CC.SetSelectAnnexureColumns(SAC4);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS4 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		CC.SetDescription(DS4);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Passing Values to Yes Text Box
		String YB4 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB4);

		//Passing Values to NO Text Box
		String NB4 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB4);

		//Passing the Values to Yes Disposition
		String YD20 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD20);

		//Passing the Values to Yes Disposition
		String YD211 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD211);

		//Passing the Values to Yes Disposition
		String YD22 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD22);

		//Passing the Values to Yes Disposition
		String YD23 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD23);

		//Passing the Values to No Disposition
		String ND20 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND20);

		//Passing the Values to No Disposition
		String ND22 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND22);

		//Passing the Values to No Disposition
		String ND23 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND23);

		//Passing the Values to No Disposition
		String ND24 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND24);

		//Passing the Values to Partial Disposition
		String PD20 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD20);

		//Passing the Values to Partial Disposition
		String PD21 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD21);

		//Passing the Values to Partial Disposition
		String PD22 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD22);

		//Passing the Values to Partial Disposition
		String PD23 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD23);

		//Passing the Values to NA Disposition
		String ND30 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND30);

		//Passing the Values to NA Disposition
		String ND311 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(ND311);

		//Passing the Values to NA Disposition
		String ND32 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(ND32);

		//Passing the Values to NA Disposition
		String ND34 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(ND34);

		//clicking on the 1st data type
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD4 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD4);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD2 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD2);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD5 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD5);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD6 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		CC.SetDataType(SD6);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL4 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL4);
		chiledTest.log(Status.INFO, "High Option is Selected");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA4 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA4);
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
	@Test(priority=7, dependsOnMethods= {"Adding_Four_Types_Of_Checkpoints_To_Dynamic_Annexure_Group_Test"}) 
	public void Adding_Four_Types_Of_Checkpoints_To_Static_Annexure_Group_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Adding Four Types Of Checkpoints To Static Annexure Group Test");

		System.out.println("Adding Four Types Of Checkpoints To Static Annexure Group Test");

		System.out.println("****Creating Verify Type Checkpoints*****");

		chiledTest.log(Status.INFO, "****Creating Verify Type Checkpoints****");

		//Clicking on the Manage Check Point Header
		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 18, 0);
		CC.SetSearchBTN(SS);

		//Clicking on the add check Point Button
		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Check Point Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(ECI, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values Expected Action from Auditor
		String EA = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action from Auditor");

		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB);

		//Passing Values to NO Text Box
		String NB = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB);

		//Passing the Values to Yes Disposition
		String YD = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD);

		//Passing the Values to Yes Disposition
		String YD1 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD1);

		//Passing the Values to Yes Disposition
		String YD2 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD2);

		//Passing the Values to Yes Disposition
		String YD3 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD3);

		//Passing the Values to No Disposition
		String ND = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND);

		//Passing the Values to No Disposition
		String ND1 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND1);

		//Passing the Values to No Disposition
		String ND2 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND2);

		//Passing the Values to No Disposition
		String ND3 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND3);

		//Passing the Values to Partial Disposition
		String PD = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD);

		//Passing the Values to Partial Disposition
		String PD1 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD1);

		//Passing the Values to Partial Disposition
		String PD2 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD2);

		//Passing the Values to Partial Disposition
		String PD3 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD3);

		//Passing the Values to NA Disposition
		String NA = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(NA);

		//Passing the Values to NA Disposition
		String NA1 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(NA1);

		//Passing the Values to NA Disposition
		String NA2= Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(NA2);

		//Passing the Values to NA Disposition
		String NA3 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(NA3);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL);
		chiledTest.log(Status.INFO, "Zero Tolerence Option is Selected");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit and Create New  Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebDriverWait wait = new WebDriverWait(driver, 10);
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

		System.out.println("****Creating Input Type CheckPoint*****");

		chiledTest.log(Status.INFO, "****Creating Input Type CheckPoint*****");

		//Passing the Values to the Enter Checkpoint intent
		String ECI2 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CC.SetEnterCheckpointintent(ECI2, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC2 = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC2);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS2 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		CC.SetDescription(DS2);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD1 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD1);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing the Values to Values 
		String SV1 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV1, driver);
		chiledTest.log(Status.INFO, "Values is Entered");

		//Passing the Values to Values 
		String SV2 = Lib.getCellValue(XLPATH, "Check Point", 140, 0);
		CC.SetDataTypeValues(SV2, driver);
		chiledTest.log(Status.INFO, "Values is Entered");

		//Passing the Values to Values 
		String SV3 = Lib.getCellValue(XLPATH, "Check Point", 141, 0);
		CC.SetDataTypeValues(SV3, driver);
		chiledTest.log(Status.INFO, "Values is Entered");

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL2 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
		CC.SetRiskLevel(RL2);
		chiledTest.log(Status.INFO, "Medium Option is Selected");

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

		System.out.println("****Creating Both Type CheckPoint****");

		chiledTest.log(Status.INFO, "****Creating Both Type CheckPoint****");

		//Passing the Values to the Enter Checkpoint intent
		String ECI3 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CC.SetEnterCheckpointintent(ECI3, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC3 = Lib.getCellValue(XLPATH, "Annexure", 10, 0);
		CC.SetSelectAnnexureColumns(SAC3);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS3 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		CC.SetDescription(DS3);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Passing Values to Yes Text Box
		String YB3 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB3);

		//Passing Values to NO Text Box
		String NB3 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB3);

		//Passing the Values to Yes Disposition
		String YD4 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD4);

		//Passing the Values to Yes Disposition
		String YD5 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD5);

		//Passing the Values to Yes Disposition
		String YD6 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD6);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to No Disposition
		String ND4 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND4);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to No Disposition
		String ND6 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND6);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND7);


		//Passing the Values to Partial Disposition
		String PD4 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD4);

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to Partial Disposition
		String PD6 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD6);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to NA Disposition
		String NA4 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(NA4);

		//Passing the Values to NA Disposition
		String NA5 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(NA5);

		//Passing the Values to NA Disposition
		String NA6 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(NA6);

		//Passing the Values to NA Disposition
		String NA7 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(NA7);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD3 = Lib.getCellValue(XLPATH, "Check Point", 119, 0); //115
		CC.SetDataType(SD3);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL3 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL3);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected");

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

		System.out.println("****Creating Both With Condtion Type Checkpoint****");

		chiledTest.log(Status.INFO, "****Creating Both With Condtion Type Checkpoint****");

		//Passing the Values to the Enter Checkpoint intent
		String ECI4 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CC.SetEnterCheckpointintent(ECI4, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC4 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		CC.SetSelectAnnexureColumns(SAC4);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing the Values to the Description
		String DS4 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		CC.SetDescription(DS4);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Passing Values to Yes Text Box
		String YB4 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB4);

		//Passing Values to NO Text Box
		String NB4 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB4);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to Yes Disposition
		String YD9 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD9);

		//Passing the Values to Yes Disposition
		String YD10 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD10);

		//Passing the Values to Yes Disposition
		String YD11 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD11);

		//Passing the Values to No Disposition
		String ND71 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND71);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to No Disposition
		String ND9 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND9);

		//Passing the Values to No Disposition
		String ND10 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND10);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to Partial Disposition
		String PD9 = Lib.getCellValue(XLPATH, "Check Point", 163, 0);
		CC.SetPartialDisposition(PD9);

		//Passing the Values to Partial Disposition
		String PD10 = Lib.getCellValue(XLPATH, "Check Point", 164, 0);
		CC.SetPartialDisposition(PD10);

		//Passing the Values to Partial Disposition
		String PD11 = Lib.getCellValue(XLPATH, "Check Point", 165, 0);
		CC.SetPartialDisposition(PD11);

		//Passing the Values to NA Disposition
		String NA8 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(NA8);

		//Passing the Values to NA Disposition
		String NA9 = Lib.getCellValue(XLPATH, "Check Point", 170, 0);
		CC.SetNADisposition(NA9);

		//Passing the Values to NA Disposition
		String NA10 = Lib.getCellValue(XLPATH, "Check Point", 171, 0);
		CC.SetNADisposition(NA10);

		//Passing the Values to NA Disposition
		String NA11 = Lib.getCellValue(XLPATH, "Check Point", 172, 0);
		CC.SetNADisposition(NA11);

		//clicking on the 1st data type
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD4 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD4);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD2 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD2);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD5 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD5);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//clicking on the Matched
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD6 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		CC.SetDataType(SD6);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//clicking on the Matched
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL4 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL4);
		chiledTest.log(Status.INFO, "High Option is Selected");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA4 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA4);
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
	@Test(priority=8, dependsOnMethods= {"Adding_Four_Types_Of_Checkpoints_To_Static_Annexure_Group_Test"}) 
	public void Adding_The_Four_Types_Of_Checkpoints_to_Exceptional_Groups_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Adding Four Types Of Checkpoints To Exceptional Group Test");

		System.out.println("Adding Four Types Of Checkpoints To Exceptional Group Test");

		System.out.println("****Creating Verify Type Checkpoints*****");

		chiledTest.log(Status.INFO, "****Creating Verify Type Checkpoints****");

		//Clicking on the Manage Check Point Header
		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 12, 0);
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

		//Checking NO Compliance is Read only or Not
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking NA Compliance is Read only or Not
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking Partial Compliance is Read only or Not
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//checking the Partial Disposition is Read only or Not
		CC.VerifyPartialDispositionIsReadOnly();

		//checking the NA Disposition is Read only or Not
		CC.VerifyNADispositionIsReadOnly();

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


		chiledTest.log(Status.INFO, "****Creating Input Type Checkpoint****");

		System.out.println("****Creating Input Type Checkpoint****");

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

		System.out.println("**************************************************************************************");

		chiledTest.log(Status.INFO, "****Creating Both Type Checkpoint****");

		System.out.println("****Creating Both Type Checkpoint*****");

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

		//Checking NO Compliance is Read only or Not
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking NA Compliance is Read only or Not
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking Partial Compliance is Read only or Not
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//checking the Partial Disposition is Read only or Not
		CC.VerifyPartialDispositionIsReadOnly();

		//checking the NA Disposition is Read only or Not
		CC.VerifyNADispositionIsReadOnly();

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

		System.out.println("*******************************************************************************");		

		chiledTest.log(Status.INFO, "****Creating Both With Condition Type Checkpoint****");

		System.out.println("****Creating Both with Condtions Type Checkpoint*****");

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

		//Checking NO Compliance is Read only or Not
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking NA Compliance is Read only or Not
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking Partial Compliance is Read only or Not
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//checking the Partial Disposition is Read only or Not
		CC.VerifyPartialDispositionIsReadOnly();

		//checking the NA Disposition is Read only or Not
		CC.VerifyNADispositionIsReadOnly();

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
	@Test(priority=9, dependsOnMethods= {"Adding_The_Four_Types_Of_Checkpoints_to_Exceptional_Groups_Test"}) 
	public void Adding_The_Four_Types_Of_Checkpoints_To_One_More_Exceptional_Groups_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Adding Four Types Of Checkpoints To One More Exceptional Group Test");

		System.out.println("Adding Four Types Of Checkpoints To One More Exceptional Group Test");

		System.out.println("****Creating Verify Type Checkpoints*****");

		chiledTest.log(Status.INFO, "****Creating Verify Type Checkpoints****");

		//Clicking on the Manage Check Point Header
		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 13, 0);
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

		//Checking NO Compliance is Read only or Not
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking NA Compliance is Read only or Not
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking Partial Compliance is Read only or Not
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//checking the Partial Disposition is Read only or Not
		CC.VerifyPartialDispositionIsReadOnly();

		//checking the NA Disposition is Read only or Not
		CC.VerifyNADispositionIsReadOnly();

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


		chiledTest.log(Status.INFO, "****Creating Input Type Checkpoint****");

		System.out.println("*****Creating Input Type Checkpoint****");

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
		String SD6 = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
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

		chiledTest.log(Status.INFO, "****Creating Both Type Checkpoint****");

		System.out.println("*****Creating Both Type Checkpoint****");

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

		//Checking NO Compliance is Read only or Not
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking NA Compliance is Read only or Not
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking Partial Compliance is Read only or Not
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//checking the Partial Disposition is Read only or Not
		CC.VerifyPartialDispositionIsReadOnly();

		//checking the NA Disposition is Read only or Not
		CC.VerifyNADispositionIsReadOnly();

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

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

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

		System.out.println("*******************************************************************************");		

		chiledTest.log(Status.INFO, "****Creating Both With Condition Type Checkpoint****");

		System.out.println("*****Creating Both with Condition Type Checkpoint****");

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

		//Checking NO Compliance is Read only or Not
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking NA Compliance is Read only or Not
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking Partial Compliance is Read only or Not
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//checking the Partial Disposition is Read only or Not
		CC.VerifyPartialDispositionIsReadOnly();

		//checking the NA Disposition is Read only or Not
		CC.VerifyNADispositionIsReadOnly();

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

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
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

	//Testing Functionality of the Checkpoint Mandatory Filed Test
	@Test(priority=10, dependsOnMethods= {"Adding_The_Four_Types_Of_Checkpoints_To_One_More_Exceptional_Groups_Test"}) 
	public void general_Group_CheckPoint_Mandatory_Fields_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("General Group Checkpoint Mandatory Fields Test");

		System.out.println("General Group Checkpoint Mandatory Fields Test");

		//Clicking on the Manage checkpoint Header
		CC.ClickManageCheckPointHeader(driver);

		//Clicking on the Master/Add Checkpoint
		CC.ClickMasterOrAddCheckPoint(driver);

		CC.ClickSelectGroup(driver);

		//Passing the Values to Select Group under Master/Add Checkpoint
		String SG = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CC.SetSelectGroup(SG);
		chiledTest.log(Status.INFO, "Group Name is searched");

		CC.ClickMatched();

		//Clicking on the Go Button
		CC.ClickGoBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		//Clicking on the Add New Checkpoint Button
		CC.ClickAddNewcheckpointBTN(driver);
		chiledTest.log(Status.INFO, "Add new checkpoint Button is Clicked");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CC.VerifyGeneralGroupCheckPointMandataryFieldsErrorMSGIsDisplayed(driver);

		System.out.println("*******************************");

	}

	//Testing Functionality of the Checkpoint Mandatory Filed Test
	@Test(priority=11, dependsOnMethods= {"general_Group_CheckPoint_Mandatory_Fields_Test"}) 
	public void Verify_CheckPoint_Mandatory_Fields_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Verify Checkpoint Mandatory Fields Test");

		System.out.println("Verify Checkpoint Mandatory Fields Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		Thread.sleep(4000);

		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA);
		chiledTest.log(Status.INFO, "Verify is Selected Under Expected Actions from Auditor");

		CC.ClickMatched();

		//Checking the Minimum 1 disposition is required for NO, PARTIAL and N/A
		CC.VerifyMinimumOneDispositionsIsRequired();

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

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CC.VerifyVerifyCheckPointMandataryFieldsErrorMSGIsDisplayed(driver);

		System.out.println("***************************************");


	}

	//Testing Functionality of the Input Type Checkpoint Mandatory Filed Test
	@Test(priority=12, dependsOnMethods= {"Verify_CheckPoint_Mandatory_Fields_Test"}) 
	public void Input_CheckPoint_Mandatory_Fields_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Input Checkpoint Mandatory Fields Test");

		System.out.println("Input Checkpoint Mandatory Fields Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		Thread.sleep(4000);

		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA1 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
		CC.SetExpectedActionFromAuditor(EA1);
		chiledTest.log(Status.INFO, "Input is Selected Under Expected Actions from Auditor");

		CC.ClickMatched();

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CC.VerifyInputCheckPointMandataryFieldsErrorMSGIsDisplayed(driver);

		System.out.println("***************************************");


	}

	//Testing Functionality of the Both Type Checkpoint Mandatory Filed Test
	@Test(priority=13, dependsOnMethods= {"Input_CheckPoint_Mandatory_Fields_Test"}) 
	public void Both_CheckPoint_Mandatory_Fields_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Both Checkpoint Mandatory Fields Test");

		System.out.println("Both Checkpoint Mandatory Fields Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		Thread.sleep(4000);

		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA2 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA2);
		chiledTest.log(Status.INFO, "Both is Selected Under Expected Actions from Auditor");

		CC.ClickMatched();

		//Checking the Minimum 1 disposition is required for NO, PARTIAL and N/A
		CC.VerifyMinimumOneDispositionsIsRequired();

		//Passing Values to Yes Text Box
		String YB6 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB6);

		//Passing Values to NO Text Box
		String NB7 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB7);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND9 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND9);

		//Passing the Values to Partial Disposition
		String PD10 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD10);

		//Passing the Values to NA Disposition
		String ND111 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND111);

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CC.VerifyBothCheckPointMandataryFieldsErrorMSGIsDisplayed(driver);

		System.out.println("******************************");


	}


	//Testing Functionality of the Both Type Checkpoint Mandatory Filed Test
	@Test(priority=14, dependsOnMethods= {"Both_CheckPoint_Mandatory_Fields_Test"}) 
	public void Both_With_Conditions_CheckPoint_Mandatory_Fields_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Both With Conditions Checkpoint Mandatory Fields Test");

		System.out.println("Both With ConditionsCheckpoint Mandatory Fields Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		Thread.sleep(4000);

		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA3 = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		CC.SetExpectedActionFromAuditor(EA3);
		chiledTest.log(Status.INFO, "Both With Condtion  is Selected Under Expected Actions from Auditor");

		CC.ClickMatched();

		//Checking the Minimum 1 disposition is required for NO, PARTIAL and N/A
		CC.VerifyMinimumOneDispositionsIsRequired();

		//Checking At least one data type has to be selected Error Message
		CC.VerifyAtLeatOneDataTypeHasToBeSelected();

		//Passing Values to Yes Text Box
		String YB12 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB12);

		//Passing Values to NO Text Box
		String NB12 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB12);

		//Passing the Values to Yes Disposition
		String YD13 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD13);

		//Passing the Values to No Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND14);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND16);

		//clicking on the 1st data type
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD1 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD1);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD2 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD2);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matched
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD3 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD3);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//clicking on the Matched
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD4 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		CC.SetDataType(SD4);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//clicking on the Matched
		CC.ClickMatched();

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CC.VerifyBothWithConditionsCheckPointMandataryFieldsErrorMSGIsDisplayed(driver);

		System.out.println("*********************************");

	}

	//Testing Functionality of Verify Checkpoint Positive Conformity NO Test
	@Test(priority=15, dependsOnMethods= {"Both_With_Conditions_CheckPoint_Mandatory_Fields_Test"}) 
	public void Verify_Checkpoint_Positive_Conformity_NO_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Verify Checkpoint Positive Conformity NO Test");

		System.out.println("Verify Checkpoint Positive Conformity NO Test");

		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.navigate().refresh();

		//Clicking on the Manage checkpoint Header
		CC.ClickManageCheckPointHeader(driver);

		//Clicking on the Master/Add Checkpoint
		CC.ClickMasterOrAddCheckPoint(driver);

		CC.ClickSelectGroup(driver);

		//Passing the Values to Select Group under Master/Add Checkpoint
		String SG = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CC.SetSelectGroup(SG);
		chiledTest.log(Status.INFO, "Group Name is searched");

		CC.ClickMatched();

		//Clicking on the Go Button
		CC.ClickGoBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		//Clicking on the Add new Checkpoint Button
		CC.ClickAddNewcheckpointBTN(driver);

		Thread.sleep(4000);

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		CC.ClickPositiveConformity();

		//Passing the No values to Positive Conformity
		String PC = Lib.getCellValue(XLPATH, "Check Point", 227, 0);
		CC.SetPositiveConformity(PC);
		chiledTest.log(Status.INFO, "No is Selected Under Positive Conformity");

		CC.ClickMatched();

		System.out.println("**Passing the Values No<Yes**");

		chiledTest.log(Status.INFO, "**Passing the Values No<Yes**");

		//Passing Values to Yes Text Box
		String YB12 = Lib.getCellValue(XLPATH, "Check Point", 18, 0); 
		CC.SetYestextBox(YB12);

		//Passing Values to NO Text Box
		String NB12 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB12);

		//Passing the Values to Yes Disposition
		String YD13 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD13);

		//Passing the Values to No Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND14);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND16);

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("***Passing the Values No=Yes***");

		chiledTest.log(Status.INFO, "**Passing the Values No=Yes**");

		CC.ClearYestextBox();

		CC.ClearNoTextBox();

		//Passing Values to Yes Text Box
		String YB121 = Lib.getCellValue(XLPATH, "Check Point", 21, 0); 
		CC.SetYestextBox(YB121);

		//Passing Values to NO Text Box
		String NB121 = Lib.getCellValue(XLPATH, "Check Point", 27, 0);
		CC.SetNoTextBox(NB121);

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 59, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

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

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		WebElement ErrorMSG = driver.findElement(By.xpath("//li[@class='alert-error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_text = ErrorMSG.getText();
			String Expected_text = "No should have higher scores than Yes, Partial and N/A";
			Assert.assertEquals(Actual_text, Expected_text, "No should have higher scores than Yes, Partial and N/A");
			System.out.println("YNo should have higher scores than Yes, Partial and N/A Error Message is Displayed");
			chiledTest.log(Status.INFO, "No should have higher scores than Yes, Partial and N/A Error Message is Displayed");
		}

		System.out.println("*****************************");

	}

	//Testing Functionality of the Both Checkpoint Positive Conformity NO Test
	@Test(priority=16, enabled=false) 
	public void Both_Checkpoint_Positive_Conformity_NO_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Both Checkpoint Positive Conformity NO Test");

		System.out.println("Both Checkpoint Positive Conformity NO Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 128, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		CC.ClickPositiveConformity();

		//Passing the No values to Positive Conformity
		String PC = Lib.getCellValue(XLPATH, "Check Point", 227, 0);
		CC.SetPositiveConformity(PC);
		chiledTest.log(Status.INFO, "No is Selected Under Positive Conformity");

		CC.ClickMatched();

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

		System.out.println("**Passing the Values No<Yes**");

		chiledTest.log(Status.INFO, "**Passing the Values No<Yes**");

		//Passing Values to Yes Text Box
		String YB12 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB12);

		//Passing Values to NO Text Box
		String NB12 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB12);

		//Passing the Values to Yes Disposition
		String YD13 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD13);

		//Passing the Values to No Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND14);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND16);

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

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("**Passing the Values No=Yes**");

		chiledTest.log(Status.INFO, "**Passing the Values No=Yes**");

		CC.ClearYestextBox();

		CC.ClearNoTextBox();

		//Passing Values to Yes Text Box
		String YB121 = Lib.getCellValue(XLPATH, "Check Point", 21, 0); 
		CC.SetYestextBox(YB121);

		//Passing Values to NO Text Box
		String NB121 = Lib.getCellValue(XLPATH, "Check Point", 27, 0);
		CC.SetNoTextBox(NB121);

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("*****************************");

	}

	//Testing Functionality of the Both With Condition Checkpoint Positive Conformity NO Test
	@Test(priority=17, enabled=false) 
	public void Both_With_Condition_Checkpoint_Positive_Conformity_NO_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Both With Condition Checkpoint Positive Conformity NO Test");

		System.out.println("Both With Condition Checkpoint Positive Conformity NO Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 128, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		CC.ClickPositiveConformity();

		//Passing the No values to Positive Conformity
		String PC = Lib.getCellValue(XLPATH, "Check Point", 227, 0);
		CC.SetPositiveConformity(PC);
		chiledTest.log(Status.INFO, "No is Selected Under Positive Conformity");

		CC.ClickMatched();

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

		System.out.println("**Passing the Values No<Yes**");

		chiledTest.log(Status.INFO, "**Passing the Values No<Yes**");

		//Passing Values to Yes Text Box
		String YB12 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB12);

		//Passing Values to NO Text Box
		String NB12 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetNoTextBox(NB12);

		//Passing the Values to Yes Disposition
		String YD13 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD13);

		//Passing the Values to No Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND14);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND16);

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("***Passing the Values No=Yes***");

		chiledTest.log(Status.INFO, "**Passing the Values No=Yes**");

		CC.ClearYestextBox();

		CC.ClearNoTextBox();

		//Passing Values to Yes Text Box
		String YB121 = Lib.getCellValue(XLPATH, "Check Point", 21, 0); 
		CC.SetYestextBox(YB121);

		//Passing Values to NO Text Box
		String NB121 = Lib.getCellValue(XLPATH, "Check Point", 27, 0);
		CC.SetNoTextBox(NB121);

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("*****************************");

	}

	//Testing Functionality of Verify Checkpoint Positive Conformity YES Test
	@Test(priority=18, enabled=false) 
	public void Verify_Checkpoint_Positive_Conformity_Yes_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Verify Checkpoint Positive Conformity YES Test");

		System.out.println("Verify Checkpoint Positive Conformity YES Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		System.out.println("**Passing the Values Yes<No**");

		chiledTest.log(Status.INFO, "**Passing the Values Yes<No**");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 128, 0);
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

		CC.ClickPositiveConformity();

		//Passing the No values to Positive Conformity
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		CC.SetPositiveConformity(PC);
		chiledTest.log(Status.INFO, "Yes is Selected Under Positive Conformity");

		CC.ClickMatched();

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

		//Passing Values to Yes Text Box
		String YB12 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetYestextBox(YB12);

		//Passing Values to NO Text Box
		String NB12 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetNoTextBox(NB12);

		//Passing the Values to Yes Disposition
		String YD13 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD13);

		//Passing the Values to No Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND14);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND16);

		CC.ClickSubmitButton(driver);

		//checking the Yes should have higher or equal scores than No, Partial and N/A Error Message is Displayed
		CC.VerifyYesShouldhaveHigherscoresThanNoPartialAndNA(driver);

		System.out.println("**Passing the Values Yes=No**");

		chiledTest.log(Status.INFO, "**Passing the Values Yes=No**");

		CC.ClearYestextBox();

		CC.ClearNoTextBox();

		//Passing Values to Yes Text Box
		String YB121 = Lib.getCellValue(XLPATH, "Check Point", 21, 0); 
		CC.SetYestextBox(YB121);

		//Passing Values to NO Text Box
		String NB121 = Lib.getCellValue(XLPATH, "Check Point", 27, 0);
		CC.SetNoTextBox(NB121);

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("*****************************");

	}

	//Testing Functionality of the Both Checkpoint Positive Conformity YES Test
	@Test(priority=19, enabled=false) 
	public void Both_Checkpoint_Positive_Conformity_YES_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Both Checkpoint Positive Conformity YES Test");

		System.out.println("Both Checkpoint Positive Conformity YES Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		System.out.println("**Passing the Values Yes<No**");

		chiledTest.log(Status.INFO, "**Passing the Values Yes<No**");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 128, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		CC.ClickPositiveConformity();

		//Passing the No values to Positive Conformity
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		CC.SetPositiveConformity(PC);
		chiledTest.log(Status.INFO, "Yes is Selected Under Positive Conformity");

		CC.ClickMatched();

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

		//Passing Values to Yes Text Box
		String YB12 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetYestextBox(YB12);

		//Passing Values to NO Text Box
		String NB12 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetNoTextBox(NB12);

		//Passing the Values to Yes Disposition
		String YD13 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD13);

		//Passing the Values to No Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND14);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND16);

		CC.ClickSubmitButton(driver);

		//checking the Yes should have higher or equal scores than No, Partial and N/A Error Message is Displayed
		CC.VerifyYesShouldhaveHigherscoresThanNoPartialAndNA(driver);

		System.out.println("**Passing the Values Yes=No**");

		chiledTest.log(Status.INFO, "**Passing the Values Yes=No**");

		CC.ClearYestextBox();

		CC.ClearNoTextBox();

		//Passing Values to Yes Text Box
		String YB121 = Lib.getCellValue(XLPATH, "Check Point", 21, 0); 
		CC.SetYestextBox(YB121);

		//Passing Values to NO Text Box
		String NB121 = Lib.getCellValue(XLPATH, "Check Point", 27, 0);
		CC.SetNoTextBox(NB121);

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("*****************************");

	}

	//Testing Functionality of the Both With Condition Checkpoint Positive Conformity YES Test
	@Test(priority=20, enabled=false) 
	public void Both_With_Condition_Checkpoint_Positive_Conformity_YES_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Both With Condition Checkpoint Positive Conformity YES Test");

		System.out.println("Both With Condition Checkpoint Positive Conformity YES Test");

		CC.ClickCancelBTN();

		CC.ClickAddNewcheckpointBTN(driver);

		System.out.println("**Passing the Values Yes<No**");

		chiledTest.log(Status.INFO, "**Passing the Values Yes<No**");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 128, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		CC.ClickPositiveConformity();

		//Passing the No values to Positive Conformity
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		CC.SetPositiveConformity(PC);
		chiledTest.log(Status.INFO, "Yes is Selected Under Positive Conformity");

		CC.ClickMatched();

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

		//Passing Values to Yes Text Box
		String YB12 = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		CC.SetYestextBox(YB12);

		//Passing Values to NO Text Box
		String NB12 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetNoTextBox(NB12);

		//Passing the Values to Yes Disposition
		String YD13 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD13);

		//Passing the Values to No Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND14);

		//Passing the Values to Partial Disposition
		String PD15 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD15);

		//Passing the Values to NA Disposition
		String ND16 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND16);

		CC.ClickSubmitButton(driver);

		//checking the Yes should have higher or equal scores than No, Partial and N/A Error Message is Displayed
		CC.VerifyYesShouldhaveHigherscoresThanNoPartialAndNA(driver);

		System.out.println("**Passing the Values Yes=No**");

		chiledTest.log(Status.INFO, "**Passing the Values Yes=No**");

		CC.ClearYestextBox();

		CC.ClearNoTextBox();

		//Passing Values to Yes Text Box
		String YB121 = Lib.getCellValue(XLPATH, "Check Point", 21, 0); 
		CC.SetYestextBox(YB121);

		//Passing Values to NO Text Box
		String NB121 = Lib.getCellValue(XLPATH, "Check Point", 27, 0);
		CC.SetNoTextBox(NB121);

		CC.ClickSubmitButton(driver);

		//checking the No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed
		CC.VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(driver);

		System.out.println("*****************************");

	}

	//Testing Functionality of the Annexure Checkpoint Mandatory Filed Test
	@Test(priority=21, dependsOnMethods= {"Verify_Checkpoint_Positive_Conformity_NO_Test"}) 
	public void Annexure_CheckPoint_Mandatory_Fields_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Annexure Checkpoint Mandatory Fields Test");

		System.out.println("Annexure Checkpoint Mandatory Fields Test");

		CC.ClickCancelBTN();

		//Clicking on the Manage checkpoint Header
		CC.ClickManageCheckPointHeader(driver);

		//Clicking on the Master/Add Checkpoint
		CC.ClickMasterOrAddCheckPoint(driver);

		CC.ClickSelectGroup(driver);

		//Passing the Values to Select Group under Master/Add Checkpoint
		String SG = Lib.getCellValue(XLPATH, "Group", 15, 0);
		CC.SetSelectGroup(SG);
		chiledTest.log(Status.INFO, "Group Name is searched");

		CC.ClickMatched();

		//Clicking on the Go Button
		CC.ClickGoBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		//Clicking on the Add New Checkpoint Button
		CC.ClickAddNewcheckpointBTN(driver);
		chiledTest.log(Status.INFO, "Add new checkpoint Button is Clicked");

		Thread.sleep(4000);

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CC.VerifyAnnexureCheckPointMandatoryFiledsAreDisplayed(driver);

		System.out.println("***************************************");

	}

	//Testing Functionality of the Adding Same Checkpoint Intent Name Test
	@Test(priority=22, dependsOnMethods= {"Annexure_CheckPoint_Mandatory_Fields_Test"}) 
	public void Adding_Same_Checkpoint_Intent_Name_Test() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Adding the Same Checkpoint Intent Name Test");

		System.out.println("Adding the Same Checkpoint Intent Name Test");

		CC.ClickCancelBTN();

		//Clicking on the Manage checkpoint Header
		CC.ClickManageCheckPointHeader(driver);

		//Clicking on the Master/Add Checkpoint
		CC.ClickMasterOrAddCheckPoint(driver);

		CC.ClickSelectGroup(driver);

		//Passing the Values to Select Group under Master/Add Checkpoint
		String SG = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CC.SetSelectGroup(SG);
		chiledTest.log(Status.INFO, "Group Name is searched");

		CC.ClickMatched();

		//Clicking on the Go Button
		CC.ClickGoBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		//Clicking on the Add New Checkpoint Button
		CC.ClickAddNewcheckpointBTN(driver);
		chiledTest.log(Status.INFO, "Add new checkpoint Button is Clicked");

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

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		CC.VerifyIntentHasAlreadyBeenTakenErrorMSGIsDisplayed(driver);

		System.out.println("********************************");


	}

	//Testing Functionality of the Invalid Data Test
	@Test(priority=23, dependsOnMethods= {"Unique_Intent_Test"}, enabled = false) 
	public void Passing_Invalid_Data_To_Compliance_ScoreTest() throws InterruptedException{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Passing Invalid Data To Compliance Score Test");

		System.out.println("Passing Invalid Data To Compliance Score Test");

		CC.ClickManageCheckpoint(driver);

		CC.ClickMasterOrAddCheckPoint(driver);

		//Clicking on the Add new CheckPoint Button
		CC.ClickAddNewcheckpointBTN(driver);
		chiledTest.log(Status.INFO, "Add New Checkpoint Button is Clicked");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values Expected Action from Auditor
		String EA = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action from Auditor");

		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB = Lib.getCellValue(XLPATH, "Check Point", 19, 0);
		CC.SetYestextBox(YB);
		chiledTest.log(Status.INFO, "Entered the Charecter under Yes Disposition");

		//Passing Values to NO Text Box
		String NB = Lib.getCellValue(XLPATH, "Check Point", 25, 0);
		CC.SetNoTextBox(NB);
		chiledTest.log(Status.INFO, "Entered the Charecter under NO Disposition");

		//Passing the Values to Yes Disposition
		String YD = Lib.getCellValue(XLPATH, "Check Point", 45, 0);
		CC.SetYesDisposition(YD);

		//Passing the Values to No Disposition
		String ND = Lib.getCellValue(XLPATH, "Check Point", 48, 0);
		CC.SetNoDisposition(ND);

		//Passing the Values to Partial Disposition
		String PD = Lib.getCellValue(XLPATH, "Check Point", 51, 0);
		CC.SetPartialDisposition(PD);

		//Passing the Values to NA Disposition
		String ND1 = Lib.getCellValue(XLPATH, "Check Point", 54, 0);
		CC.SetNADisposition(ND1);

		//Verifying Please Enter the Vaid Number Error Message
		CC.VerifyPleaseEnterValidNumberErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Please enter a valid number. Error Message is Displayed");

		CC.ClearYestextBox();
		CC.ClearNoTextBox();
		CC.ClearPartialTextBox();
		CC.ClearNATextBox();

		//Passing Values to Yes Text Box
		String YB1 = Lib.getCellValue(XLPATH, "Check Point", 20, 0);
		CC.SetYestextBox(YB1);
		chiledTest.log(Status.INFO, "Entered The Other Than Numeric Data under Yes Disposition");

		//Passing Values to NO Text Box
		String NB1 = Lib.getCellValue(XLPATH, "Check Point", 26, 0);
		CC.SetNoTextBox(NB1);
		chiledTest.log(Status.INFO, "Entered The Other Than Numeric Data under NO Disposition");

		//Verifying Please enter a valid number Error Message is Displayed
		CC.VerifyPleaseEnterValidNumberErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Please enter a valid number Error Message is Displayed");

		//Clicking on the CloseBTN
		CC.ClickCloseBTN(driver);

		System.out.println("***************************************************");

	}

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority=24, dependsOnMethods= {"Adding_Same_Checkpoint_Intent_Name_Test"}) 
	public void Edit_Checkpoint_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Edit Checkpoint Test");

		System.out.println("Edit Checkpoint Test");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "Group", 11, 0);
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

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);

		//Clicking on the First Created Checkpoint
		CC.ClickFirstCheckpoint(driver);
		chiledTest.log(Status.INFO, "Clicked on the First Checkpoint");

		//Verify Edit Checkpoint page is Displayed
		CC.VerifyEditCheckpointPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Edit Checkpoint page is Displayed");

		CC.ClearEnterCheckpointintent(driver);

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 59, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		CC.ClearDescription();

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 65, 0);
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

		CC.ClearYestextBox();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "Check Point", 80, 0);
		CC.SetYestextBox(YB8);

		CC.ClearNoTextBox();

		//Passing Values to NO Text Box
		String NB8 = Lib.getCellValue(XLPATH, "Check Point", 77, 0);
		CC.SetNoTextBox(NB8);

		//Clearing all Dispositions
		CC.ClearAllDispositions(driver);

		//Passing the Values to Yes Disposition
		String YD = Lib.getCellValue(XLPATH, "Check Point", 177, 0);
		CC.SetYesDisposition1(YD, driver);

		//Passing the Values to No Disposition
		String ND1 = Lib.getCellValue(XLPATH, "Check Point", 185, 0);
		CC.SetNoDisposition1(ND1, driver);

		//Passing the Values to Partial Disposition
		String PD = Lib.getCellValue(XLPATH, "Check Point", 191, 0);
		CC.SetPartialDisposition1(PD, driver);

		//Passing the Values to NA Disposition
		String ND11 = Lib.getCellValue(XLPATH, "Check Point", 198, 0);
		CC.SetNADisposition1(ND11, driver);

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

		CC.ClearNoticetoAuditors();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 83, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the submit button
		CC.ClickEditPageSubmitButton();

		//Verifying Checkpoint Updated Successfully Success Message is Displayed
		CC.VerifyCheckpointUpdatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Checkpoint Updated Successfully Message is Displayed");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS1 = Lib.getCellValue(XLPATH, "Group", 11, 0);
		CC.SetSearchBTN(SS1);

		CC.ClickNumberOfCheckBoxButton(driver);

		//Clicking on the First Created Checkpoint
		CC.ClickFirstCheckpoint(driver);
		chiledTest.log(Status.INFO, "Clicked on the First Checkpoint");

		CC.UpdatedBothWithCondtionsCheckPointView(driver);

		System.out.println("**************************");


	}

}
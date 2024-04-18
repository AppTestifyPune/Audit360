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
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.LoginPageTest;

public class AuditExecutionPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Audit Execution page
	@Test(priority=1)
	public void Audit_Execution_page() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		parentTest = extent.createTest("Audit Execution page Functionality Test", "Testing the General Audit Execution, Testing the Annexure Audit Execution, Testing the Dynamic Audit Execution etc..");

		chiledTest = parentTest.createNode("Audit Execution page Test");

		System.out.println("Audit Execution page Test");

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

		//Verify Audit Execution Page is Displayed or not
		AE.VerifyAuditExecutionPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Execution Page is Displayed");

		System.out.println("****************************************************");

	}
	
	
	//Executing Audit Type With Normal Mode Which Has Only Annexure Groups Test
	@Test(priority=2)
	public void Executing_Audit_Type_With_Normal_Mode_Which_Has_Only_Annexure_Groups_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		LoginPageTest l = new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Executing Audit Type With Normal Mode Which Has Only Annexure Groups Test");

		System.out.println("Executing Audit Type With Normal Mode Which Has Only Annexure Groups Test");	

		WebDriverWait wait = new WebDriverWait(driver, 40);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		String un=Lib.getCellValue(XLPATH, "Login Credentials", 42, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 42, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		//Verifying Signed in successfully. Success Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		SoftAssert SoftAssertion = new SoftAssert();

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
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

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");
		
		System.out.println("*********************Executing 1st Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 1st Sub Audit Group Under Static Annexure*********************");

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 9, 0);
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

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);
		Thread.sleep(5000);

		/*//Checking 1st Checkpoint Intent name 
		String CP1Text13 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1Text13);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP113 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP113);
		Assert.assertEquals(CP113, CP1Text13);

		//Checking 1st Checkpoint Description
		String CP1descriptionText13 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1descriptionText13);

		String CP1description13 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP1description13);
		Assert.assertEquals(CP1descriptionText13, CP1description13);*/

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

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER113 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER113);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR113 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR113);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP2Text23 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2Text23);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP223 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP223);
		Assert.assertEquals(CP223, CP2Text23);

		//Checking 1st Checkpoint Description
		String CP2descriptionText23 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2descriptionText23);

		String CP2description23 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2description23);
		Assert.assertEquals(CP2descriptionText23, CP2description23);*/

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

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER123 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR123 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");


		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP3Text34 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3Text34);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP334 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP334);
		Assert.assertEquals(CP334, CP3Text34);

		//Checking 1st Checkpoint Description
		String CP3descriptionText34 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3descriptionText34);

		String CP3description34 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3description34);
		Assert.assertEquals(CP3descriptionText34, CP3description34);*/


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

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER234 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR234 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR234);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP4Text45 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4Text45);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP445 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP445);
		Assert.assertEquals(CP445, CP4Text45);

		//Checking 1st Checkpoint Description
		String CP4descriptionText45 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4descriptionText45);

		String CP4description45 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4description45);
		Assert.assertEquals(CP4descriptionText45, CP4description45);*/

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

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER345 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR345 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");


		System.out.println("*********************Executing 2nd Sub Audit Group Under Static Annexure***********************");

		chiledTest.log(Status.INFO, "*********************Executing 2nd Sub Audit Group Under Static Annexure*********************");

		//Passing the Values to Search Button
		String SB5 = Lib.getCellValue(XLPATH, "Configure Audit Type", 136, 0);
		AE.SetSearchBTN(SB5);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Start Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 1st Checkpoint Intent name 
		String CP1Text131 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1Text131);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP1131 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP1131);
		Assert.assertEquals(CP1131, CP1Text131);

		//Checking 1st Checkpoint Description
		String CP1descriptionText131 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1descriptionText131);

		String CP1description131 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP1description131);
		Assert.assertEquals(CP1descriptionText131, CP1description131);*/

		//******************Selecting NA *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify NA Dispositions
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for All the CheckPonts
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER1131 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER1131);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR1131 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1131);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP2Text231 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2Text231);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP2231 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2231);
		Assert.assertEquals(CP2231, CP2Text231);

		//Checking 1st Checkpoint Description
		String CP2descriptionText231 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2descriptionText231);

		String CP2description231 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2description231);
		Assert.assertEquals(CP2descriptionText231, CP2description231);*/

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

		//Verifying Enter Remarks is Required Filed for All the CheckPonts
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER1231 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER1231);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR1231 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR1231);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP3Text341 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3Text341);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP3341 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3341);
		Assert.assertEquals(CP3341, CP3Text341);

		//Checking 1st Checkpoint Description
		String CP3descriptionText341 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3descriptionText341);

		String CP3description341 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3description341);
		Assert.assertEquals(CP3descriptionText341, CP3description341);*/

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

		//Verifying Enter Remarks is Required Filed for All the CheckPonts
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER2341 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER2341);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR2341 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR2341);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP4Text451 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4Text451);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP4451 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4451);
		Assert.assertEquals(CP4451, CP4Text451);

		//Checking 1st Checkpoint Description
		String CP4descriptionText451 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4descriptionText451);

		String CP4description451 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4description451);
		Assert.assertEquals(CP4descriptionText451, CP4description451);*/

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

		//Verifying Enter Remarks is Required Filed for All the CheckPonts
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER3451 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER3451);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR3451 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR3451);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		System.out.println("***********Executing 3rd Sub Audit Type under Static Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 3rd Sub Audit Type under Static Annexure Group ***************");

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
		String NFR = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***********Executing 4th Sub Audit Type under Static Annexure Group ****************");

		chiledTest.log(Status.INFO, "**********Executing 4th Sub Audit Type under Static Annexure Group ***************");

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
		String NFR3 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR3);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("*******************Adding new PI ********************");

		chiledTest.log(Status.INFO, "*****************Adding new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Already Exist PI Name That is ENGINE101
		String PIN11 = Lib.getCellValue(XLPATH, "Audit Execution", 62, 0);
		AE.SetPrimaryIdentifierName(PIN11, driver);
		chiledTest.log(Status.INFO, "Entered Already Exist PI Name With All Caps Latter");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Duplicate PI Not Allowed Message is Displayed
		AE.VerifyDuplicatePINotAllowedMSGIsDisplayed();

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Valid Primary Identifier Name
		String PIN = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN, driver);
		chiledTest.log(Status.INFO, "Valid Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Already Exist PI Name That is ENGINE105
		String PIN12 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN12, driver);
		chiledTest.log(Status.INFO, "Entered Already Exist PI Name With All Caps Latter");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Duplicate PI Not Allowed Message is Displayed
		AE.VerifyDuplicatePINotAllowedMSGIsDisplayed();

		System.out.println("*******************Adding one more new PI ********************");

		chiledTest.log(Status.INFO, "*****************Adding one More new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN1 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPrimaryIdentifierName(PIN1, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Already Exist PI Name With All Small Latter
		String PIN122 = Lib.getCellValue(XLPATH, "Audit Execution", 63, 0);
		AE.SetPrimaryIdentifierName(PIN122, driver);
		chiledTest.log(Status.INFO, "Entered Already Exist PI Name With All Small Latter");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Duplicate PI Not Allowed Message is Displayed
		AE.VerifyDuplicatePINotAllowedMSGIsDisplayed();

		/*AE.ClearPiSearchBTN();

		Thread.sleep(2000);
		//Selecting the 100 under Show
		driver.findElement(By.xpath("//select[@name='tableWithSearchSummary_length']/option[@value='100']")).click();

		Thread.sleep(1000);
		//checking the Count of PI's
		List<WebElement> PI_Count = driver.findElements(By.xpath("//table[@id='tableWithSearchSummary']/tbody/tr"));
		int Actual_PI_Count = PI_Count.size();
		int Expected_PI_Count = 4;
		Assert.assertEquals(Actual_PI_Count, Expected_PI_Count, "Toatl Six Pi's are Displayed");
		System.out.println("Toatl 6 Pi's are Displayed");
		chiledTest.log(Status.INFO, "Toatl 6 Pi's are Displayed");*/

		System.out.println("********* Executing Added new PI's *************");

		//Passing the Values to Search Text Filed
		String SB7 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0); 
		AE.SetPiSearchBTN(SB7);

		//Clicking on the Started Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Verifying Choose Execution Type Pop Up Is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose Execution Type Pop Up Is Displayed");

		//Clicking on the Normal Mode
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Mode is Clicked");

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 1st Checkpoint Intent name 
		String CP1Text1311 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1Text1311);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP11311 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP11311);
		Assert.assertEquals(CP11311, CP1Text1311);

		//Checking 1st Checkpoint Description
		String CP1descriptionText1311 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1descriptionText1311);

		String CP1description1311 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP1description1311);
		Assert.assertEquals(CP1descriptionText1311, CP1description1311);*/

		//******************Selecting yes *********************************************

		//Clicking on the yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify Yes Dispositions
		AE.VerifyingYesDispositions(driver);
		chiledTest.log(Status.INFO, "Yes Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER11311 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER11311);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR11311 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR11311);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP2Text2311 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2Text2311);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP22311 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP22311);
		Assert.assertEquals(CP22311, CP2Text2311);

		//Checking 1st Checkpoint Description
		String CP2descriptionText2311 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2descriptionText2311);

		String CP2description2311 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2description2311);
		Assert.assertEquals(CP2descriptionText2311, CP2description2311);*/

		//Checking the Data Type 
		String Data311 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data311);
		String Data411 = Data311.toLowerCase();

		String Data511 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data511);

		Assert.assertEquals(Data411, Data511);

		//Selecting the 1st values under values drop down list
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER12311 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER12311);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR12311 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR12311);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP3Text3411 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3Text3411);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP33411 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP33411);
		Assert.assertEquals(CP33411, CP3Text3411);

		//Checking 1st Checkpoint Description
		String CP3descriptionText3411 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3descriptionText3411);

		String CP3description3411 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3description3411);
		Assert.assertEquals(CP3descriptionText3411, CP3description3411);*/

		//******************Selecting Partail Button *********************************************

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
		String Input411 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input411);
		String Input511 = Input411.toLowerCase(); 

		String Input611 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);

		Assert.assertEquals(Input511, Input611);

		//Passing the Values to Input
		String IV511 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV511, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER23411 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER23411);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR23411 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR23411);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP4Text4511 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4Text4511);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP44511 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP44511);
		Assert.assertEquals(CP44511, CP4Text4511);

		//Checking 1st Checkpoint Description
		String CP4descriptionText4511 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4descriptionText4511);

		String CP4description4511 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4description4511);
		Assert.assertEquals(CP4descriptionText4511, CP4description4511);*/

		//******************Selecting NA Button *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NA Dispositions are Displayed
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Data Type values
		List<WebElement> DataType = driver.findElements(By.xpath("//div[@class='form-group form-group-default']/span[@class='data_type_name']"));
		int DataTypesize = DataType.size();
		Assert.assertTrue(DataTypesize>0, "date_and_range is Displayed");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER34511 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER34511);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR34511 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR34511);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");


		System.out.println("******* Executing another newly Added PI ********");

		chiledTest.log(Status.INFO, "******* Executing another newly Added PI ********");

		//Passing the Values to Search Button
		String SB71 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPiSearchBTN(SB71);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR11 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR11);

		AE.ClickMatched();

		//Entering the Reason
		String NFR4 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR4);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		//Clicking on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Checking Tick button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("**************Executing Dynamic Annexure Group*******************");

		chiledTest.log(Status.INFO, "**************Executing Dynamic Annexure Group*******************");

		//Passing the Values to Search Text Filed
		String SB41 = Lib.getCellValue(XLPATH, "Configure Audit Type", 7, 0);
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

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 1st Checkpoint Intent name 
		String CP1Text14 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1Text14);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP14 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP14);
		Assert.assertEquals(CP14, CP1Text14);

		//Checking 1st Checkpoint Description
		String CP1descriptionText13114 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1descriptionText13114);

		String CP1description1321 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP1description1321);
		Assert.assertEquals(CP1descriptionText13114, CP1description1321);*/

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

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER143 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER143);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR1431 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1431);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP2Text2341 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2Text2341);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP223111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP223111);
		Assert.assertEquals(CP223111, CP2Text2341);

		//Checking 1st Checkpoint Description
		String CP2descriptionText23111 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2descriptionText23111);

		String CP2description23111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2description23111);
		Assert.assertEquals(CP2descriptionText23111, CP2description23111);*/

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

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER123111 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR123111 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP3Text34111 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3Text34111);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP334111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP334111);
		Assert.assertEquals(CP334111, CP3Text34111);

		//Checking 1st Checkpoint Description
		String CP3descriptionText34111 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3descriptionText34111);

		String CP3description34111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3description34111);
		Assert.assertEquals(CP3descriptionText34111, CP3description34111);*/

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

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER234111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER234111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR234111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR234111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP4Text45111 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4Text45111);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP445111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP445111);
		Assert.assertEquals(CP445111, CP4Text45111);

		//Checking 1st Checkpoint Description
		String CP4descriptionText45111 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4descriptionText45111);

		String CP4description45111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4description45111);
		Assert.assertEquals(CP4descriptionText45111, CP4description45111);*/

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

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER345111 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR345111 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Finish Button
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

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 1st Checkpoint Intent name 
		String CP1Text13111 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1Text13111);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP113111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP113111);
		Assert.assertEquals(CP113111, CP1Text13111);

		//Checking 1st Checkpoint Description
		String CP1descriptionText13111 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1descriptionText13111);

		String CP1description13111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP1description13111);
		Assert.assertEquals(CP1descriptionText13111, CP1description13111);*/

		//******************Selecting NA *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify NA Dispositions
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER113111 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER113111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR113111 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR113111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP2Text23111 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2Text23111);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP2231111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2231111);
		Assert.assertEquals(CP2231111, CP2Text23111);

		//Checking 1st Checkpoint Description
		String CP2descriptionText231111 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2descriptionText231111);

		String CP2description231111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2description231111);
		Assert.assertEquals(CP2descriptionText231111, CP2description231111);*/

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

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER1231111 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER1231111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR1231111 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR1231111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP3Text341111 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3Text341111);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP3341111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3341111);
		Assert.assertEquals(CP3341111, CP3Text341111);

		//Checking 1st Checkpoint Description
		String CP3descriptionText341111 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3descriptionText341111);

		String CP3description341111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3description341111);
		Assert.assertEquals(CP3descriptionText341111, CP3description341111);*/

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

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER2341111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER2341111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR2341111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR2341111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP4Text451111 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4Text451111);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP4451111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4451111);
		Assert.assertEquals(CP4451111, CP4Text451111);

		//Checking 1st Checkpoint Description
		String CP4descriptionText451111 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4descriptionText451111);

		String CP4description451111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4description451111);
		Assert.assertEquals(CP4descriptionText451111, CP4description451111);*/

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

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER3451111 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER3451111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR3451111 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR3451111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Finish Button
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
		String NFR6 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR6);

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
		String NFR5 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR5);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("*******************Adding new PI ********************");


		chiledTest.log(Status.INFO, "*****************Adding new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN16 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN16, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");

		System.out.println("*******************Adding one more new PI ********************");

		chiledTest.log(Status.INFO, "*****************Adding one More new PI *******************");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN15 = Lib.getCellValue(XLPATH, "Audit Execution", 57, 0);
		AE.SetPrimaryIdentifierName(PIN15, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);
		chiledTest.log(Status.INFO, "Sub auditee added and scheduled successfully Success Message is Displayed");


		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name with Caps Latter
		String PIN17 = Lib.getCellValue(XLPATH, "Audit Execution", 62, 0);
		AE.SetPrimaryIdentifierName(PIN17, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Duplicate PI Not Allowed message is Displayed
		AE.VerifyDuplicatePINotAllowedMSGIsDisplayed();

		/*AE.ClearPiSearchBTN();

		Thread.sleep(2000);
		//Selecting the 100 under Show
		driver.findElement(By.xpath("//select[@name='tableWithSearchSummary_length']/option[@value='100']")).click();

		Thread.sleep(1000);
		//checking the Count of PI's
		List<WebElement> PI_Count1 = driver.findElements(By.xpath("//table[@id='tableWithSearchSummary']/tbody/tr"));
		int Actual_PI_Count1 = PI_Count1.size();
		int Expected_PI_Count1 = 4;
		Assert.assertEquals(Actual_PI_Count1, Expected_PI_Count1, "Toatl Four Pi's are Displayed");
		System.out.println("Toatl 4 Pi's are Displayed");
		chiledTest.log(Status.INFO, "Toatl 4 Pi's are Displayed");*/

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

		//Clicking on the Normal Mode
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Mode is Clicked");

		//************************ Check point 1 ***********************

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 1st Checkpoint Intent name 
		String CP1Text13121 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1Text13121);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP113121 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP113121);
		Assert.assertEquals(CP113121, CP1Text13121);

		//Checking 1st Checkpoint Description
		String CP1descriptionText13121 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP1descriptionText13121);

		String CP1description13121 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP1description13121);
		Assert.assertEquals(CP1descriptionText13121, CP1description13121);*/

		//******************Selecting yes *********************************************

		//Clicking on the yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verify Yes Dispositions
		AE.VerifyingYesDispositions(driver);
		chiledTest.log(Status.INFO, "Yes Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All The Dispositions are Selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER113121 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER113121);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR113121 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR113121);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 2 ******************

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP2Text23121 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2Text23121);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP223121 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP223121);
		Assert.assertEquals(CP223121, CP2Text23121);

		//Checking 1st Checkpoint Description
		String CP2descriptionText23121 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP2descriptionText23121);

		String CP2description23121 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2description23121);
		Assert.assertEquals(CP2descriptionText23121, CP2description23121);*/

		//Checking the Data Type 
		String Data3121 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input Data type is : " + Data3121);
		String Data4121 = Data3121.toLowerCase();

		String Data5121 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		System.out.println("Entered Input Data is : "+ Data5121);
		Assert.assertEquals(Data4121, Data5121);

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER123121 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER123121);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR123121 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR123121);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Check point 3 ******************

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP3Text3411111 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3Text3411111);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP33411111 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP33411111);
		Assert.assertEquals(CP33411111, CP3Text3411111);

		//Checking 1st Checkpoint Description
		String CP3descriptionText3411111 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP3descriptionText3411111);

		String CP3description3411111 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP3description3411111);
		Assert.assertEquals(CP3descriptionText3411111, CP3description3411111);*/

		//******************Selecting Partail Button *********************************************

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
		String Input4121 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']")).getText();
		System.out.println("Displayed Input data is : " + Input4121);
		String Input5121 = Input4121.toLowerCase(); 

		String Input6121 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		Assert.assertEquals(Input5121, Input6121);

		//Passing the Values to Input
		String IV5121 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV5121, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER23411111 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER23411111);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR23411111 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR23411111);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		/*//Checking 2nd Checkpoint Intent name 
		String CP4Text45121 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4Text45121);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")));
		String CP445121 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP445121);
		Assert.assertEquals(CP445121, CP4Text45121);

		//Checking 1st Checkpoint Description
		String CP4descriptionText45121 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CP4descriptionText45121);

		String CP4description45121 = driver.findElement(By.xpath("//p[@class='p-l-15 p-r-15']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP4description45121);
		Assert.assertEquals(CP4descriptionText45121, CP4description45121);*/


		//******************Selecting NA Button *********************************************

		//Clicking on the NA Button
		AE.ClickNAButton();
		chiledTest.log(Status.INFO, "NA Button is Clicked");

		//clicking on the Dispositions
		AE.ClickDispositions(driver);

		//Verifying NA Dispositions are Displayed
		AE.VerifyingNADispositions(driver);
		chiledTest.log(Status.INFO, "NA Dispositions are Displayed");

		//Selecting all the Dispositions
		AE.SelectingAllDispositions(driver);
		chiledTest.log(Status.INFO, "All the Dispositions are Selected");

		//Checking the Data Type values
		List<WebElement> DataType2 = driver.findElements(By.xpath("//div[@class='form-group form-group-default']/span[@class='data_type_name']"));
		int DataTypesize2 = DataType2.size();
		Assert.assertTrue(DataTypesize2>0, "date_and_range is Displayed");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//Verifying Enter Remarks is Required Filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER345121 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER345121);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR345121 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR345121);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");


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

		//Passing the Values to Reason
		String SR121 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR121);

		AE.ClickMatched();

		//Entering the Reason
		String NFR7 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR7);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		//Clicking on the Ok Button
		AE.ClickOKBTN1(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//Clicking on the Submit Audit Button
		AE.ClickSubmitAuditBTN(driver);
		
		//Uploading the Documents
		AE.ImageMandatoryUploadDocuments();

		//Verifying Submitted successfully success Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Submitted successfully success Message is Displayed");

		SoftAssertion.assertAll();

		System.out.println("*********************************");

	}

	//Testing the Functionality of the Past Audits search Test
	@Test(priority= 474, dependsOnMethods= {"Executing_Audit_Type_With_Express_Mode_Which_Has_Only_General_Group_Test"}, enabled=false)
	public void Past_Audits_search_Test() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Past Audits Search Test");

		System.out.println("Past Audits Search Test");	

		WebDriverWait wait = new WebDriverWait(driver, 40);

		//Clicking on the Past Audit Tab
		AE.ClickPastAudits(driver);
		chiledTest.log(Status.INFO, "Past Audits Tab is Clicked");

		//Passing the Values to Audit Type Search Text Filed
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		AE.SetAuditType(AT, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		Thread.sleep(4000);

		SoftAssert Assert = new SoftAssert();
		//checking the Audit type Name 
		String AuditTypeName1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		System.out.println("Entered Audit Type Name is : " + AuditTypeName1);

		String AuditTypeName = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='step3']//div[2]/div/h2"))).getText();
		System.out.println("Displayed Audit Type Name : " + AuditTypeName);

		Assert.assertEquals(AuditTypeName, AuditTypeName1, "Entered Audit Type Name and Displayed Audit Type Name are Not Same");


		//Checking the Auditee Name
		String AuditeeName = Lib.getCellValue(XLPATH, "Schedule", 9, 0);
		System.out.println("Entered Auditee name is : " + AuditeeName);

		String Auditee1 = driver.findElement(By.xpath("//div[@id='step3']//div[3]//div[1]/h3")).getText();
		System.out.println("Displayed Auditee Name is : " + Auditee1);

		Assert.assertEquals(Auditee1, AuditeeName, "Entered Auditee Type Name and Displayed Auditee Type Name are Not Same");

		//Checking the status
		String Status1 = driver.findElement(By.xpath("//div[@id='step3']//div[4]/div/h2")).getText();
		System.out.println("Displayed Status is : " + Status1);
		String accepted = "accepted";
		Assert.assertEquals(accepted, Status1, "Status is Not Displayed As Accepted");

		//Clicking on the View Audit Info Button
		AE.ClickViewAuditInfoBTN(driver);
		chiledTest.log(Status.INFO, "View Audit Info Button");

		//Passing the Values to Search Text Filed
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 7, 0);
		AE.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Dynamic Annexure is Serached");

		//Checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//Passing the Values to Search Text Filed
		String SB2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 9, 0);
		AE.SetSearchBTN(SB2);
		chiledTest.log(Status.INFO, "Static Annexure is Serached");

		//Checking Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//Passing the Values to Search Text Filed
		String SB41 = Lib.getCellValue(XLPATH, "Configure Audit Type", 4, 0);
		AE.SetSearchBTN(SB41);
		chiledTest.log(Status.INFO, "Genaral Audit Type is Serached");

		//Checking Accepted Button is Displayed
		AE.VerifyAcceptedBTNisDisplayed(driver);
		chiledTest.log(Status.INFO, "Completed Button is Displayed");

		Assert.assertAll();

		System.out.println("*******************************************");

	}

}



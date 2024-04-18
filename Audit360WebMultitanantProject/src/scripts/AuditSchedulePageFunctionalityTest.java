package scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.LoginPageTest;

public class AuditSchedulePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Audit Schedule List page
	@Test(priority=1)
	public void Audit_Schedule_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		parentTest = extent.createTest("Audit Schedule Functionality Test", "Testing the Functionality of the Create Audit Schedule for Single Auditor, Multiple Auditor and Shedule List");

		chiledTest = parentTest.createNode("Audit Schedule Page Test");

		System.out.println("Audit Schedule Page Test");

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

		//Checking the Audit Schedule Page
		SP.VerifyAuditSchedulPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Schedule Page is Displayed");

		System.out.println("*****************************************************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=2)
	public void Creating_Audit_Schedule_Mandatory_Fields_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Creating Audit Schedule Mandatory Fields Test");

		System.out.println("Creating Audit Schedule Mandatory Fields Test");

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Checking the Required Fields are Displayed or Not
		SP.VerifyRequiredFiledsAreDisplayd(driver);

		System.out.println("*********************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=3)
	public void Audit_Review_Period_To_Should_greater_Than_Audit_Review_period_From_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Audit Review Period To Should greater Than Audit Review period From Test");

		System.out.println("Audit Review Period To Should greater Than Audit Review period From Test");

		driver.navigate().refresh();

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT = Lib.getCellValue(XLPATH, "Schedule Page", 3, 0);
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

		//Passing the values to Audit Review Period From
		String FD = Lib.getCellValue(XLPATH, "Schedule Page", 3, 9);
		SP.SetAuditReviewPeriodFromDate(FD);
		chiledTest.log(Status.INFO, "Audit Review Period From is Entered");

		//Passing the values to Audit Review Period To
		String TD = Lib.getCellValue(XLPATH, "Schedule Page", 3, 8);
		SP.SetAuditReviewPeriodTo(TD);
		chiledTest.log(Status.INFO, "Audit Review Period To is Entered");

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

		//Checking Audit Period To should be greater than Audit Period From. Error Message is Displayed
		SP.VerifyAuditPeriodToShouldGreaterThanAuditReviewPeriodFrom(driver);

		System.out.println("*********************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=4)
	public void Annexure_Validity_Period_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Annexure Validity Test");

		System.out.println("Annexure Validity Test");

		driver.navigate().refresh();

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT = Lib.getCellValue(XLPATH, "Schedule Page", 4, 0);
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

		//Checking Annexure document is not valid for the selected sub audit type in the specified date range. Error Message is Displayed
		SP.VerifyAnnexureDocumentIsNotValidForTheSelectedSubAuditTypeErrorMSG(driver);

		System.out.println("*********************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=5)
	public void Audit_Schedule_Cancel_Button_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Audit Schedule Cancel Button Test");

		System.out.println("Audit Schedule Cancel Button Test");

		driver.navigate().refresh();

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Cancel Button
		SP.ClickCancelBTN();
		chiledTest.log(Status.INFO, "Cancel Button is clicked");

		//Checking the Audit Schedule Page
		SP.VerifyAuditSchedulPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Schedule Page is Displayed");

		System.out.println("************************");

	}

	//Testing the Functionality of the Delete Audit Schedule Cancel button
	@Test(priority=6)
	public void Update_Delete_Cancel_Buttons_Should_Show_only_For_Execution_Status_Not_Started_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Update Delete Cancel Buttons Should Show only For Execution Status Not Started Test");

		System.out.println("Update Delete Cancel Buttons Should Show only For Execution Status Not Started Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES = Lib.getCellValue(XLPATH, "Schedule Page", 3, 10);
		SP.SetSelectExecutionStatus(ES);
		chiledTest.log(Status.INFO, "Not Started is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		//Checking Update Button is Displayed
		SP.VerifyUpdateButtonIsDisplayed(driver);

		//checking Cancel Button is Displayed
		SP.VerifyCancelButtonIsDisplayed(driver);

		//Checking Delete Button is Displayed
		SP.VerifyDeleteButtonIsDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES1 = Lib.getCellValue(XLPATH, "Schedule Page", 4, 10);
		SP.SetSelectExecutionStatus(ES1);
		chiledTest.log(Status.INFO, "In progress is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		//Checking Update Button is Displayed
		SP.VerifyUpdateButtonIsDisplayed(driver);

		//checking Cancel Button is Displayed
		SP.VerifyCancelButtonIsDisplayed(driver);

		//Checking Delete Button is not Displayed
		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES3 = Lib.getCellValue(XLPATH, "Schedule Page", 6, 10);
		SP.SetSelectExecutionStatus(ES3);
		chiledTest.log(Status.INFO, "Submitted is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES4 = Lib.getCellValue(XLPATH, "Schedule Page", 7, 10);
		SP.SetSelectExecutionStatus(ES4);
		chiledTest.log(Status.INFO, "Accepted is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES5 = Lib.getCellValue(XLPATH, "Schedule Page", 8, 10);
		SP.SetSelectExecutionStatus(ES5);
		chiledTest.log(Status.INFO, "In review is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);


		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES6 = Lib.getCellValue(XLPATH, "Schedule Page", 9, 10);
		SP.SetSelectExecutionStatus(ES6);
		chiledTest.log(Status.INFO, "Finalized is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES7 = Lib.getCellValue(XLPATH, "Schedule Page", 10, 10);
		SP.SetSelectExecutionStatus(ES7);
		chiledTest.log(Status.INFO, "Reaudit is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES8 = Lib.getCellValue(XLPATH, "Schedule Page", 11, 10);
		SP.SetSelectExecutionStatus(ES8);
		chiledTest.log(Status.INFO, "Reaudit submitted is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES9 = Lib.getCellValue(XLPATH, "Schedule Page", 12, 10);
		SP.SetSelectExecutionStatus(ES9);
		chiledTest.log(Status.INFO, "Reaudit accepted is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES10 = Lib.getCellValue(XLPATH, "Schedule Page", 13, 10);
		SP.SetSelectExecutionStatus(ES10);
		chiledTest.log(Status.INFO, "Lapsed not started is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("**************************");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Select Execution Status
		String ES11 = Lib.getCellValue(XLPATH, "Schedule Page", 14, 10);
		SP.SetSelectExecutionStatus(ES11);
		chiledTest.log(Status.INFO, "Lapsed in progress is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		//Clicking on the Go Button
		SP.ClickGoBTN();

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		SP.VerifyUpdateButtonIsNotDisplayed(driver);

		SP.VerifyCancelButtonIsNotDisplayed(driver);

		SP.VerifyDeleteButtonIsNotDisplayed(driver);

		System.out.println("*********************************");


	}

	//Testing the Functionality of the Create Audit Schedule Test
	@Test(priority=7)
	public void Create_Audit_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Create Audit Schedule Test");

		System.out.println("Create Audit Schedule Test");

		SP.ClickAuditScheduleHeader();

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT = Lib.getCellValue(XLPATH, "Schedule Page", 3, 0);
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

		System.out.println("*************************************");


	}

	//Testing the Functionality of the Edit Audit Schedule Test
	@Test(priority=8, dependsOnMethods= {"Create_Audit_Schedule_Test"})
	public void Edit_Audit_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Edit Audit Schedule Test");

		System.out.println("Edit Audit Schedule Test");

		//Passing the Values to Select Execution Status
		String ES = Lib.getCellValue(XLPATH, "Schedule Page", 3, 10);
		SP.SetSelectExecutionStatus(ES);
		chiledTest.log(Status.INFO, "Not Started is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		SP.ClickGoBTN();

		//Passing the Values to Search Text Field
		String SB = Lib.getCellValue(XLPATH, "Schedule Page", 3, 0);
		SP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		//Clicking on the Update Button
		SP.ClickUpdateBTN();
		chiledTest.log(Status.INFO, "Update Button is clicked");

		SP.VerifyAScheduleIsUpdatedSuccessfullySuccessMSG(driver);

		System.out.println("***************************");


	}

	//Testing the Functionality of the Edit Audit Schedule Cancel button
	@Test(priority=9)
	public void Edit_Audit_Schedule_Cancel_Button_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Edit Audit Schedule Cancel Button Test");

		System.out.println("Edit Audit Schedule Cancel Button Test");

		driver.navigate().refresh();

		//Passing the Values to Select Execution Status
		String ES = Lib.getCellValue(XLPATH, "Schedule Page", 3, 10);
		SP.SetSelectExecutionStatus(ES);
		chiledTest.log(Status.INFO, "Not Started is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		SP.ClickGoBTN();

		//Passing the Values to Search Text Field
		String SB = Lib.getCellValue(XLPATH, "Schedule Page", 3, 0);
		SP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		//Clicking on the cancel Button
		SP.ClickCancelBTN();
		chiledTest.log(Status.INFO, "cancel Button is Clicked");

		SP.VerifyAuditSchedulPageIsDisplayed(driver);

		System.out.println("*********************************");

	}

	//Testing the Functionality of the Delete Audit Schedule Cancel button
	@Test(priority=10)
	public void Delete_Audit_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Delete Audit Schedule Test");

		System.out.println("Delete Audit Schedule Test");

		driver.navigate().refresh();

		//Passing the Values to Select Execution Status
		String ES = Lib.getCellValue(XLPATH, "Schedule Page", 3, 10);
		SP.SetSelectExecutionStatus(ES);
		chiledTest.log(Status.INFO, "Not Started is Selected under Select Execution Status Drop down");

		SP.ClickMatched();

		SP.ClickGoBTN();

		//Passing the Values to Search Text Field
		String SB = Lib.getCellValue(XLPATH, "Schedule Page", 3, 0);
		SP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		SP.ClickFirstTR(driver);

		SP.VerifyEditAuditSchedulePageIsDisplayed(driver);

		//Clicking on the Delete Button
		SP.ClickDeleteBTN();
		chiledTest.log(Status.INFO, "Delete Button is Clicked");

		//Checking Are you sure?, You want to delete audit schedule pop up is Displayed
		SP.VerifyAreYouSureYouWantToDeleteAuditSchedulePopUpIsDisplayed(driver);

		//Clicking ok Button
		SP.ClickOKBTN();
		chiledTest.log(Status.INFO, "ok Button is Clicked");

		//checking Schedule was successfully destroyed success Message is Displayed
		SP.VerifyScheduleWasSuccessfullyDestroyedMSGDisplayed(driver);

		System.out.println("*****************************");

	}

	//Testing the Functionality of the Delete Audit Schedule Cancel button
	@Test(priority=11)
	public void Deleted_Audit_Schedule_Should_Not_Show_For_The_Auditor_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Deleted Audit Schedule Should not show for the Auditor Test");

		System.out.println("Deleted Audit Schedule Should not show for the Auditor Test");

		driver.navigate().refresh();

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

		//Searching the Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Schedule Page", 3, 0);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		Thread.sleep(10000);

		//Checking Accept Button 
		List<WebElement> AcceptBTN = driver.findElements(By.xpath("//a[contains(text(),'Accept')]"));
		Assert.assertTrue(AcceptBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Accept Button is Not Displayed");

		//Checking Reject Button 
		List<WebElement> RejectBTN = driver.findElements(By.xpath("//button[contains(text(),'Reject')]"));
		Assert.assertTrue(RejectBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Reject Button is Not Displayed");

		//Checking Reassign Button 
		List<WebElement> ReassignBTN = driver.findElements(By.xpath("//button[contains(text(),'Reassign')]"));
		Assert.assertTrue(ReassignBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Reassign Button is Not Displayed");

		//Checking Edit Button 
		List<WebElement> EditBTN = driver.findElements(By.xpath("//button[contains(text(),'Edit Schedule')]"));
		Assert.assertTrue(EditBTN.size()<=0, "Accept Button is Displayed");
		System.out.println("Edit Schedule Button is Not Displayed");

		System.out.println("****************************************************");

	}

	//Testing the Functionality of the Creating Schedule For One More Audit Type Test
	@Test(priority=12, enabled=false)
	public void Deleted_AuditType_Should_Not_Be_Show_In_Select_AuditType_Drop_Down_While_Creating_The_Schedule_test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Deleted AuditType Should Not Be Show In Select AuditType Drop Down While Creating The Schedule Test");

		System.out.println("Deleted AuditType Should Not Be Show In Select AuditType Drop Down While Creating The Schedule Test");

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		//clicking on the Create schedule button
		AE.ClickCreateScheduleButton();

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
		SP.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Verifying No Match Found Error Message is Displayed
		SP.VerifyNoMatchFoundErrorMSGIsDisplayed();

		driver.navigate().refresh();

		System.out.println("*****************************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=13, enabled=false)
	public void Creating_Schedule_For_AuditType_Which_Has_General_Group_And_Annexure_Group_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Schedule For AuditType Which Has General Group And Annexure Group Test");

		System.out.println("Creating Schedule For AuditType Which Has General Group And Annexure Group Test");

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
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
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




	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=22, enabled=false)
	public void Create_Audit_Schedule_for_Multiple_General_Group_AuditType_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Create Audit Schedule For Multiple General Group  AuditType Test");

		System.out.println("Create Audit Schedule For Multiple General Group  AuditType Test");

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 9, 0);
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

		System.out.println("*****************************************************************");

	}

	//Testing the Functionality of the Create Audit Schedule for Multiple Auditor
	@Test(priority=23, enabled = false)
	public void Create_Audit_Schedule_For_Multiple_Auditor_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Create Audit Schedule For Multiple Auditor Test");

		System.out.println("Create Audit Schedule For Multiple Auditor Test");

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type
		String SAT = Lib.getCellValue(XLPATH, "Schedule", 13, 0);
		SP.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Select Audit Type is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Vendor Option Under Select Auditee Type Drop Down List
		SP.ClickVendorOption(driver);

		//Clicking on the Select country/State/Location
		SP.ClickSelectCountryStateLocation(driver);

		//Passing the Values to Select country/State/Location
		String CSL = Lib.getCellValue(XLPATH, "Schedule", 16, 0);
		SP.SetCountryStateLocation(CSL, driver);
		chiledTest.log(Status.INFO, "Select Country/State/Location is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Select Auditee
		SP.ClickSelectAuditee(driver);

		//Passing the Values to Select Auditee
		String SA = Lib.getCellValue(XLPATH, "Schedule", 19, 0);
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

		//Clicking on the multiple Auditor
		SP.ClickMultipleAuditorBTN();

		//Clicking on the Select Auditor
		//driver.findElement(By.xpath("//div[@id='s2id_mapped_auditors']/ul[@class='select2-choices']")).click();
		SP.ClickSelecctAuditor();

		//Selecting 1st Auditor option Under select Auditor
		SP.ClickSelectAuditorOption();
		chiledTest.log(Status.INFO, "Auditor is Selected");

		//Clicking on the Select Auditor
		driver.findElement(By.xpath("//div[@id='s2id_mapped_auditors']/ul[@class='select2-choices']")).click();

		//Selecting 2nd Auditor option Under select Auditor
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[2]")).click();

		//Clicking on the sub Audits Radio Button
		SP.ClickSubAuditsBTN();

		//Passing the Values to Sub Audit one
		String SO = Lib.getCellValue(XLPATH, "Schedule", 22, 0);
		SP.SetSubAuditOne(SO, driver);

		//Clicking on the Matched 
		SP.ClickMatched();


		String SO1 = Lib.getCellValue(XLPATH, "Schedule", 23, 0);
		SP.SetSubAuditOne(SO1, driver);

		//Clicking on the Matched 
		SP.ClickMatched();

		//Passing the Values to Sub Audit Two
		String ST = Lib.getCellValue(XLPATH, "Schedule", 26, 0);
		SP.SetSubAuditTwo(ST, driver);

		//Clicking on the Matched 
		SP.ClickMatched();

		String ST1 = Lib.getCellValue(XLPATH, "Schedule", 27, 0);
		SP.SetSubAuditTwo(ST1, driver);

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Save Button
		SP.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Schedule created successfully Success Message is Displayed
		SP.VerifyScheduleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Schedule created successfully. Success Message is displayed");

		System.out.println("*****************************************************************");

	}


}

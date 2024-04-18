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
import pom.AuditeeUserIssuePageTest;
import pom.LoginPageTest;

public class AuditeeReviewerIssuePageSearchFunctionalityTest extends BaseTest {

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority=1) 
	public void Issues_Page_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		parentTest = extent.createTest("Auditee Reviewer Issues Page Search Functionality Test", "Testing the Functionality reviewer Issue Page, Search Criteria..");

		chiledTest = parentTest.createNode("Auditee Reviewer Issue Page Search Functionality Test");

		System.out.println("Auditee Reviewer Issue Page Search Functionality Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 68, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Clicking on the Scroll bar
		AUIP.ClickScrollBar(driver);

		//Clicking on the Issue under Side menu
		AUIP.ClickIssues(driver);

		//Verifying Issue page is Displayed or Not
		AUIP.VerifyIssuesPageIsDisplayed(driver);

		System.out.println("*************************************************");

	}

	//Testing Search Functionality of the Select Parent Audit Type
	@Test(priority=2) 
	public void Select_Parent_AuditType_Search_Test() throws InterruptedException{

		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("Select Parent Audit Type Search Test");

		System.out.println("Select Parent Audit Type Search Test");

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 0);
		AUIP.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA1 = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 4, 0);
		AUIP.SetSelectParentAuditType(SPA1);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA2 = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 5, 0);
		AUIP.SetSelectParentAuditType(SPA2);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Clicking on the Go Button
		AUIP.ClickGOBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		AUIP.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AUIP.ClickCloseBTN();

		System.out.println("************************");

	}

	//Testing Search Functionality of the Select Auditor
	@Test(priority=3) 
	public void Select_Auditor_Search_Test() throws InterruptedException{

		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("Select Auditor Search Test");

		System.out.println("Select Auditor Search Test");

		AUIP.ClickIssuesHeader();

		//Passing the Values to Select Parent Audit Type Search Field
		String SA1 = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 1);
		AUIP.SetSelectAuditor(SA1);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SA2 = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 4, 1);
		AUIP.SetSelectAuditor(SA2);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SA3 = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 5, 1);
		AUIP.SetSelectAuditor(SA3);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Clicking on the Go Button
		AUIP.ClickGOBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		AUIP.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AUIP.ClickCloseBTN();

		System.out.println("************************");

	}

	//Testing the Functionality of the Select Issue Status Search Test 
	@Test(priority=5)
	public void Select_Issue_Status_Search_Test() throws InterruptedException
	{
		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("Select Issue Status Search Test");

		System.out.println("Select Issue Status Search Test");

		AUIP.ClickIssuesHeader();

		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.id("issue_transaction_statuses"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actual_Count = alloptions.size();
		int Expected_Count = 12;
		System.out.println("The Totle Number of Issue Status is ! " + Actual_Count);
		Assert.assertEquals(Actual_Count, Expected_Count, "Issue Status Drop down list Count is Wrong");
		for (int i=1; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			String AllText = All.getText();
			System.out.println(AllText);
			All.click();

			//Clicking on the Go Button
			AUIP.ClickGOBTN();

			//Checking the Issue details are Displayed or not
			AUIP.VerifyIssuesAreIsDisplayed(driver);
		}

		System.out.println("*******************************************************");

	}

	//Testing the Search Functionality of the Schedule Start From and Schedule Start TO
	@Test(priority=6)
	public void Schedule_Start_From_And_Schedule_Start_TO_Search_Functionality_Test() throws InterruptedException
	{
		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("Schedule Start From And schedule Start TO Search Test");

		System.out.println("Schedule Start From And schedule start TO Search Test");

		AUIP.ClickIssuesHeader();

		//Passing the Values to Schedule Start From
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			//Passing the Values to Start From
			String SF = Lib.getCellValue(XLPATH, "Auditee User Issue Page", i, 2);
			AUIP.SetScheduleStartFrom(SF);

			//Passing the Values to Start TO
			String ST = Lib.getCellValue(XLPATH, "Schedule Page", i, 3);
			AUIP.SetScheduleStartTO(ST);

			//Clicking on the Go Button
			AUIP.ClickGOBTN();

			AUIP.VerifyIssuesAreIsDisplayed(driver);

		}

		System.out.println("********************************");

	}

	//Testing the Search Functionality of the Schedule End From and Schedule End TO
	@Test(priority=7)
	public void Schedule_End_From_And_Schedule_End_TO_Search_Functionality_Test() throws InterruptedException
	{
		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("Schedule End From And schedule End TO Search Functionality Test");

		System.out.println("Schedule End From And schedule End TO Search Functionality Test");

		AUIP.ClickIssuesHeader();

		//Passing the Values to Schedule Start Date
		int RC = Lib.getRowcount(XLPATH, "Auditee User Issue Page");
		for(int i=3; i<=RC-9; i++)
		{
			//Passing the Values to Start Date
			String EF = Lib.getCellValue(XLPATH, "Auditee User Issue Page", i, 2);
			AUIP.SetScheduleEndFrom(EF);

			//Passing the Values to End Date
			String ET = Lib.getCellValue(XLPATH, "Auditee User Issue Page", i, 3);
			AUIP.SetScheduleEndTO(ET);

			//Clicking on the Go Button
			AUIP.ClickGOBTN();;

			AUIP.VerifyIssuesAreIsDisplayed(driver);

		}

		System.out.println("********************************");

	}

	//Testing the Search Functionality of the Schedule Start From and Schedule End TO
	@Test(priority=8)
	public void Schedule_Start_From_And_Schedule_Start_TO_Mandatory_Test() throws InterruptedException
	{
		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("Schedule Start From And schedule Start TO Mandatory Test");

		System.out.println("Schedule Start From And schedule Start TO Mandatory Test");

		AUIP.ClickIssuesHeader();

		//Passing the Values to Schedule Start From
		String SF =  Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 2);
		AUIP.SetScheduleStartFrom(SF);

		//clicking on the Go Button
		AUIP.ClickGOBTN();

		//checking please select Schedule Start To Alert Message is Displayed
		AUIP.VerifypleaseSelectScheduleStartToAlertPopUpIsDisplayed();

		AUIP.ClickIssuesHeader();

		//passing the values to Schedule Start To
		String ST = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 3);
		AUIP.SetScheduleStartTO(ST);

		//clicking on the Go Button
		AUIP.ClickGOBTN();

		//checking please select Schedule Start From Alert Message is Displayed
		AUIP.VerifypleaseSelectScheduleStartFromAlertPopUpIsDisplayed();

		System.out.println("***********************");

	}


	//Testing Search Functionality of the Select Schedule Start Date
	@Test(priority=9) 
	public void Schedule_Due_Date_From_And_Schedule_Due_Date_To_Search_Test() throws InterruptedException{

		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("Schedule Due Date From And Schedule Due Date To Search Test");

		System.out.println("Schedule Due Date From And Schedule Due Date To Search Test");

		AUIP.ClickIssuesHeader();

		//Passing the Values to Schedule start Date
		String SDF = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 4);
		AUIP.SetSelectScheduleDueDateFrom(SDF);
		chiledTest.log(Status.INFO, "Schedule Due date From is Enterd");

		//Passing the Values to Schedule End Date
		String SDT = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 5);
		AUIP.SetSelectScheduleDueDateTo(SDT);
		chiledTest.log(Status.INFO, "Schedule Due date To is Enterd");

		//Clicking on the Go Button
		AUIP.ClickGOBTN();

		//Verifying Issue are Displayed or Not
		AUIP.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AUIP.ClickCloseBTN();

		System.out.println("************************");

	}

	//Testing Search Functionality of the searching all Search Criteria
	@Test(priority=10) 
	public void All_Search_Criteria_Test() throws InterruptedException{

		AuditeeUserIssuePageTest AUIP = new AuditeeUserIssuePageTest(driver);

		chiledTest = parentTest.createNode("All Search Criteria Test");

		System.out.println("All Search Criteria Test");

		AUIP.ClickIssuesHeader();

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 0);
		AUIP.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SA1 = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 1);
		AUIP.SetSelectAuditor(SA1);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AUIP.ClickMatched(driver);

		//Passing the Values to Schedule start From
		String SF = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 2);
		AUIP.SetScheduleStartFrom(SF);

		//Passing the Values to Schedule start To
		String ST = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 3);
		AUIP.SetScheduleStartTO(ST);

		//Passing the Values to Schedule end From
		String EF = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 2);
		AUIP.SetScheduleEndFrom(EF);

		//Passing the Values to Schedule End To
		String ET = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 3);
		AUIP.SetScheduleEndTO(ET);

		//Passing the Values to Schedule start Date
		String SDF = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 4);
		AUIP.SetSelectScheduleDueDateFrom(SDF);
		chiledTest.log(Status.INFO, "Schedule Due date From is Enterd");

		//Passing the Values to Schedule End Date
		String SDT = Lib.getCellValue(XLPATH, "Auditee User Issue Page", 3, 5);
		AUIP.SetSelectScheduleDueDateTo(SDT);
		chiledTest.log(Status.INFO, "Schedule Due date To is Enterd");

		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.id("issue_transaction_statuses"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		String IssueStatus = alloptions.get(1).getText();
		System.out.println("selected Issue status is : " + IssueStatus);

		alloptions.get(1).click();

		//Clicking on the Go Button
		AUIP.ClickGOBTN();

		//Checking the Issue details are Displayed or not
		AUIP.VerifyIssuesAreIsDisplayed(driver);

		System.out.println("***************");

	}
}

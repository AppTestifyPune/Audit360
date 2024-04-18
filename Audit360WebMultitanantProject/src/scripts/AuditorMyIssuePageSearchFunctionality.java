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
import pom.AuditorMyIssuePageTest;
import pom.LoginPageTest;
import pom.SuperAdminIssuePageTest;

public class AuditorMyIssuePageSearchFunctionality extends BaseTest{

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority=1) 
	public void Issues_Page_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);
		
		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		parentTest = extent.createTest("Auditor My Issues Functionality Test", "Testing the Functionality Auditor Issue Page, Search Criteria..");

		chiledTest = parentTest.createNode("My Issue Page Test");

		System.out.println("My Issue Page Test");

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

		//Clicking on Issue button
		AE.ClickIssuesButton();
		
		//checking MY Issue Page
		AI.VerifyMyIssuePageIsDisplayed();

		System.out.println("*************************************************");

	}


	//Testing Search Functionality of the Select Parent Audit Type
	@Test(priority=2) 
	public void Select_Parent_AuditType_Search_Test() throws InterruptedException
	{

		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("Select Parent Audit Type Search Test");

		System.out.println("Select Parent Audit Type Search Test");

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA = Lib.getCellValue(XLPATH, "Admin Issue Page", 3, 0);
		AI.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA1 = Lib.getCellValue(XLPATH, "Admin Issue Page", 4, 0);
		AI.SetSelectParentAuditType(SPA1);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA2 = Lib.getCellValue(XLPATH, "Admin Issue Page", 5, 0);
		AI.SetSelectParentAuditType(SPA2);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Clicking on the Go Button
		AI.ClickGOBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		AI.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AI.ClickCloseBTN();

		System.out.println("************************");

	}


	//Testing Search Functionality of the Select Parent Audit Type
	@Test(priority=3) 
	public void Select_Intent_Search_Test() throws InterruptedException{



		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("Select Intent Search Test");

		System.out.println("Select Intent Search Test");

		//Passing the Values to Select Parent Audit Type Search Field
		String SA1 = Lib.getCellValue(XLPATH, "Admin Issue Page", 3, 1);
		AI.SetSelectIntent(SA1);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SA2 = Lib.getCellValue(XLPATH, "Admin Issue Page", 4, 1);
		AI.SetSelectIntent(SA2);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SA3 = Lib.getCellValue(XLPATH, "Admin Issue Page", 5, 1);
		AI.SetSelectIntent(SA3);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Clicking on the Go Button
		AI.ClickGOBTN();
		chiledTest.log(Status.INFO, "Go Button is Clicked");

		AI.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AI.ClickCloseBTN();

		System.out.println("************************");

	}

	//Testing Search Functionality of the Select Parent Audit Type
	@Test(priority=4) 
	public void Select_Group_Search_Test() throws InterruptedException{



		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);


		chiledTest = parentTest.createNode("Select Group Search Test");

		System.out.println("Select Group Search Test");

		//Passing the Values to Select Parent Audit Type Search Field
		String GP1 = Lib.getCellValue(XLPATH, "Admin Issue Page", 3, 2);
		AI.SetGroups(GP1);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String GP2 = Lib.getCellValue(XLPATH, "Admin Issue Page", 4, 2);
		AI.SetGroups(GP2);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String GP3 = Lib.getCellValue(XLPATH, "Admin Issue Page", 5, 2);
		AI.SetGroups(GP3);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Clicking on the Go Button
		AI.ClickGOBTN();

		//Verifying Issue are Displayed or Not
		AI.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AI.ClickCloseBTN();

		System.out.println("************************");

	}

	//Testing the Functionality of the Select Execution Status Search Test 
	@Test(priority=5)
	public void Select_Issue_Status_Search_Test() throws InterruptedException
	{
		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("Select Issue Status Search Test");

		System.out.println("Select Issue Status Search Test");

		AI.ClickMyIssuesHeader();

		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.id("issue_statuses"));
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
		}

		//Clicking on the Go Button
		AI.ClickGOBTN();

		//Checking the Issue details are Displayed or not
		AI.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AI.ClickCloseBTN();

		System.out.println("*******************************************************");

	}

	//testing the Search Functionality of Audtees
	@Test(priority=7)
	public void Auditee_search_Functionality_Test() throws InterruptedException
	{
		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("All Search Criteria Test");

		System.out.println("All Search Criteria Test");

		AI.ClickMyIssuesHeader();

		//passing the values to Auditees
		String AT = Lib.getCellValue(XLPATH, "Admin Issue Page", 3, 5);
		AI.SetAuditees(AT);;

		AI.ClickMatched(driver);

		//Checking the Issue details are Displayed or not
		AI.VerifyIssuesAreIsDisplayed(driver);

		//Clicking on the Cancel Buttons
		AI.ClickCloseBTN();

		System.out.println("*****************");

	}

	//Testing the Search Functionality of the Schedule Start From and Schedule Start TO
	@Test(priority=8)
	public void Schedule_Start_From_And_Schedule_Start_TO_Search_Functionality_Test() throws InterruptedException
	{
		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("Schedule Start From And schedule Start TO Search Test");

		System.out.println("Schedule Start From And schedule start TO Search Test");

		AI.ClickMyIssuesHeader();

		//Passing the Values to Schedule Start Date
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			//Passing the Values to Start Date
			String SF = Lib.getCellValue(XLPATH, "Schedule Page", i, 6);
			AI.SetScheduleStartFrom(SF);

			//Passing the Values to End Date
			String ST = Lib.getCellValue(XLPATH, "Schedule Page", i, 7);
			AI.SetScheduleStartTO(ST);

			//Clicking on the Go Button
			AI.ClickGOBTN();

			AI.VerifyIssuesAreIsDisplayed(driver);

		}

		System.out.println("********************************");

	}

	//Testing the Search Functionality of the Schedule End From and Schedule End TO
	@Test(priority=9)
	public void Schedule_End_From_And_Schedule_End_TO_Search_Functionality_Test() throws InterruptedException
	{
		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("Schedule End From And schedule End TO Search Functionality Test");

		System.out.println("Schedule End From And schedule End TO Search Functionality Test");

		AI.ClickMyIssuesHeader();

		//Passing the Values to Schedule Start Date
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			//Passing the Values to Start Date
			String EF = Lib.getCellValue(XLPATH, "Schedule Page", i, 6);
			AI.SetScheduleEndFrom(EF);

			//Passing the Values to End Date
			String ET = Lib.getCellValue(XLPATH, "Schedule Page", i, 7);
			AI.SetScheduleEndTO(ET);

			//Clicking on the Go Button
			AI.ClickGOBTN();;

			AI.VerifyIssuesAreIsDisplayed(driver);

		}

		System.out.println("********************************");

	}

	//Testing the Search Functionality of the Schedule Start From and Schedule End TO
	@Test(priority=10)
	public void Schedule_Start_From_And_Schedule_Start_TO_Mandatory_Test() throws InterruptedException
	{
		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("Schedule Start From And schedule Start TO Mandatory Test");

		System.out.println("Schedule Start From And schedule Start TO Mandatory Test");

		AI.ClickMyIssuesHeader();

		//Passing the Values to Schedule Start From
		String SF =  Lib.getCellValue(XLPATH, "Schedule Page", 3, 6);
		AI.SetScheduleStartFrom(SF);

		//clicking on the Go Button
		AI.ClickGOBTN();

		//checking please select Schedule Start To Alert Message is Displayed
		AI.VerifypleaseSelectScheduleStartToAlertPopUpIsDisplayed();

		AI.ClickMyIssuesHeader();

		//passing the values to Schedule Start To
		String ST = Lib.getCellValue(XLPATH, "Schedule Page", 3, 7);
		AI.SetScheduleStartTO(ST);

		//clicking on the Go Button
		AI.ClickGOBTN();

		//checking please select Schedule Start From Alert Message is Displayed
		AI.VerifypleaseSelectScheduleStartFromAlertPopUpIsDisplayed();

		System.out.println("***********************");

	}

	//Testing Search Functionality of the Select Parent Audit Type
	@Test(priority=11) 
	public void All_Search_Criteria_Test() throws InterruptedException
	{

		AuditorMyIssuePageTest AI= new AuditorMyIssuePageTest(driver);

		chiledTest = parentTest.createNode("All Search Criteria Test");

		System.out.println("All Search Criteria Test");

		AI.ClickMyIssuesHeader();

		//Passing the Values to Select Parent Audit Type Search Field
		String SPA = Lib.getCellValue(XLPATH, "Admin Issue Page", 3, 0);
		AI.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String SA1 = Lib.getCellValue(XLPATH, "Admin Issue Page", 3, 1);
		AI.SetSelectIntent(SA1);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Passing the Values to Select Parent Audit Type Search Field
		String GP1 = Lib.getCellValue(XLPATH, "Admin Issue Page", 3, 2);
		AI.SetGroups(GP1);
		chiledTest.log(Status.INFO, "Intent is Enterd");

		//Clicking on the Matched 
		AI.ClickMatched(driver);

		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.id("issue_statuses"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actual_Count = alloptions.size();
		System.out.println("The Totle Number of Issue Status is ! " + Actual_Count);
		for (int i=1; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			String AllText = All.getText();
			System.out.println(AllText);
			All.click();
		}

		//Clicking on the Go Button
		AI.ClickGOBTN();

		//Checking the Issue details are Displayed or not
		AI.VerifyIssuesAreIsDisplayed(driver);

	}

}



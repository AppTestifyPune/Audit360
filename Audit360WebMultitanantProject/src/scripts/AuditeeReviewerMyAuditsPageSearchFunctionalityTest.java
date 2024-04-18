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
import pom.LoginPageTest;
import pom.MyAuditsPageTest;

public class AuditeeReviewerMyAuditsPageSearchFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Audit Execution page
	@Test(priority=1)
	public void MY_Audits_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		parentTest = extent.createTest("Auditee Reviewer My Audit Page Search Functionality Test", "Testing the Functionality of the Auditee Reviewer Search Functionality of the Page..");

		chiledTest = parentTest.createNode("My Audits page Search Functionality Test");

		System.out.println("My Audits page Search Functionality Test");

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

		//Verify My Audits Page is Displayed
		MA.VerifyMyAuditsPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "My Audits Page is Displayed");

		System.out.println("*******************************************************");

	}

	//Testing the Functionality of the Select Audit Type Search Test 
	@Test(priority=2)
	public void Select_Audit_Type_Search_Test() throws InterruptedException
	{

		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("Select Audit type Search Test");

		System.out.println("Select Audit type Search Test");
		int RC = Lib.getRowcount(XLPATH, "My Audit Page");
		for(int i=3; i<=RC-6; i++)
		{
			String SA = Lib.getCellValue(XLPATH, "My Audit Page", i, 0);
			MA.SetSelectAuditType(SA);
			chiledTest.log(Status.INFO, "Audit Type Is Serached under Select Audit Type");

			MA.ClickMatched();
		}

		//Checking the Audits details are Displayed or not
		MA.VerifyAuditeeisDisplayed(driver);

		//Clicking on the Cancel Buttons
		MA.ClickCloseButton();

		System.out.println("*******************************************************");

	}

	//Testing the Functionality of the Select Execution Status Search Test 
	@Test(priority=3)
	public void Select_Execution_Status_Search_Test() throws InterruptedException
	{
		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("Select Execution Status Search Test");

		System.out.println("Select Execution Status Search Test");

		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.id("auditee_execution_status"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of Execution Status is ! " + count);
		int Actual_Connt = count;
		int Expected_Count = 14;
		Assert.assertEquals(Actual_Connt, Expected_Count, "Select Execution Status Options count are Wrong");
		for (int i=1; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			String AllText = All.getText();
			System.out.println(AllText);
			All.click();
		}

		//Checking the Audits details are Displayed or not
		MA.VerifyAuditeeisDisplayed(driver);

		//Clicking on the Cancel Buttons
		MA.ClickCloseButton();

		System.out.println("*******************************************************");

	}

	//Testing the Functionality of the Select Date Range Search Test
	@Test(priority=4)
	public void Select_Date_Range_Search_Test() throws InterruptedException
	{
		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("Select Date Range Search Test");

		System.out.println("Select Date Range Search Test");

		//Passing the Invalid Values to From Date
		String FD = Lib.getCellValue(XLPATH, "My Audit Page", 3, 2);
		MA.SetFromdate(FD, driver);
		chiledTest.log(Status.INFO, "Invalid From Date is Entered");

		//Passing the Invalid Values to To Date
		String TD = Lib.getCellValue(XLPATH, "My Audit Page", 3, 3);
		MA.SetTodate(TD, driver);
		chiledTest.log(Status.INFO, "Invalid To Date is Entered");

		//Checking the Audits details are Displayed or not
		MA.VerifyAuditeeisDisplayed(driver);

		System.out.println("******************************************************");

	}


	//Testing the Functionality of the Select Date Range Search Test
	@Test(priority=5)
	public void Select_Auditee_Search_Test() throws InterruptedException
	{
		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("Select Auditee Search Test");

		System.out.println("Select Auditee Search Test");
		int RC = Lib.getRowcount(XLPATH, "My Audit Page");
		for(int i=3; i<=RC-6; i++)
		{
			String AE = Lib.getCellValue(XLPATH, "My Audit Page", i, 4);
			MA.SetSelectAuditee(AE);
			chiledTest.log(Status.INFO, "Audit Type Is Serached under Select Audit Type");

			MA.ClickMatched();
		}

		//Checking the Audits details are Displayed or not
		MA.VerifyAuditeeisDisplayed(driver);

		MA.ClickCloseButton();

		System.out.println("*********************");

	}

	//Testing the Functionality of the Select Date Range Search Test
	@Test(priority=6)
	public void All_Search_Test() throws InterruptedException
	{
		MyAuditsPageTest MA = new MyAuditsPageTest(driver);

		chiledTest = parentTest.createNode("All Search Test");

		System.out.println("All Search Test");

		MA.ClickMyAuditsHeader(driver);

		//Passing the Values to select Audit Type
		int RC = Lib.getRowcount(XLPATH, "My Audit Page");
		for(int i=3; i<=RC-6; i++)
		{
			String SA = Lib.getCellValue(XLPATH, "My Audit Page", i, 0);
			MA.SetSelectAuditType(SA);
			chiledTest.log(Status.INFO, "Audit Type Is Serached under Select Audit Type");

			MA.ClickMatched();
		}

		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.id("auditee_execution_status"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of Execution Status is ! " + count);
		int Actual_Connt = count;
		int Expected_Count = 14;
		Assert.assertEquals(Actual_Connt, Expected_Count, "Select Execution Status Options count are Wrong");
		for (int i=1; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			String AllText = All.getText();
			System.out.println(AllText);
			All.click();
		}

		//Passing the Values to From Date
		String FD = Lib.getCellValue(XLPATH, "My Audit Page", 3, 2);
		MA.SetFromdate(FD, driver);
		chiledTest.log(Status.INFO, "From Date is Entered");

		//Passing the Invalid Values to To Date
		String TD = Lib.getCellValue(XLPATH, "My Audit Page", 3, 3);
		MA.SetTodate(TD, driver);
		chiledTest.log(Status.INFO, "To Date is Entered");


		//Passing the Values to Select Auditee
		for(int i=3; i<=RC-6; i++)
		{
			String AE = Lib.getCellValue(XLPATH, "My Audit Page", i, 4);
			MA.SetSelectAuditee(AE);
			chiledTest.log(Status.INFO, "Audit Type Is Serached under Select Audit Type");

			MA.ClickMatched();
		}

		//Checking the Audits details are Displayed or not
		MA.VerifyAuditeeisDisplayed(driver);

		System.out.println("*********************");

	}

}

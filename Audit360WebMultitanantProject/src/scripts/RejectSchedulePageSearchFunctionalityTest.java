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
import pom.AuditSchedulePageTest;
import pom.LoginPageTest;
import pom.RejectSchedulePageTest;

public class RejectSchedulePageSearchFunctionalityTest extends BaseTest{

	//Testing the Functionality of the Re Assigned Requests
	@Test(priority=1)
	public void Rejected_Requests_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		parentTest = extent.createTest("Reject Schedule Functionality Test", "Testing the Functionality of the All Search Critria Under Reject Schedule Page Test");

		chiledTest = parentTest.createNode("Reject Request Page Test");

		System.out.println("Rejected Requests List Test");

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

		//Clicking on the Schedule from side menu
		SP.ClickSchedule(driver);
		chiledTest.log(Status.INFO, "Schedule is Clicked");

		//Clicking on the Reject Schedule
		RS.ClickRejectSchedule(driver);
		chiledTest.log(Status.INFO, "Reject Schedules is Clicked");

		//Verifying Rejected Requests Page is Displayed
		RS.VerifyRejectdRequestsPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Rejected Requests Page is Displayed");

		System.out.println("*****************************************************************");

	}

	//Testing the Functionality of the Select Audit Type
	@Test(priority=2)
	public void Select_Audit_Type_Search_Test() throws InterruptedException
	{
		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Audit Type Search Test");

		System.out.println("Select Audit Type Search Test");

		int RC = Lib.getRowcount(XLPATH, "Reject Schedule");
		for(int i=5; i<=RC-8; i++)
		{
			String AT = Lib.getCellValue(XLPATH, "Reject Schedule", i, 0);
			RS.SetAuditType(AT);
			System.out.println("Entered Audit Type is : " + AT);
			chiledTest.log(Status.INFO, "Audit Type Is Serached under Select Audit Type");

			RS.ClickMatched();
		}

		//Checking the Audits Are Displayed or Not
		RS.VerifyingRejectedAuditsAreDisplayed(driver);

		RS.ClickCloseButton();

		System.out.println("*******************************************");

	}

	//Testing the Functionality of the Select Auditee Search Test
	@Test(priority=3)
	public void Select_Auditee_Search_Test() throws InterruptedException
	{

		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Auditee Search Test");

		System.out.println("Select Auditee  Search Test");

		int RC = Lib.getRowcount(XLPATH, "Reject Schedule");
		for(int i=3; i<=RC-10; i++)
		{
			String AE = Lib.getCellValue(XLPATH, "Reject Schedule", i, 1);
			RS.SetAuditee(AE);
			System.out.println("Entered Auditee is : " + AE);
			chiledTest.log(Status.INFO, "Auditee is Selected");

			RS.ClickMatched();
		}

		//Checking the Audits Are Displayed or Not
		RS.VerifyingRejectedAuditsAreDisplayed(driver);

		RS.ClickCloseButton();

		System.out.println("*******************************************");
	}

	//Testing the Functionality of the Select Auditor Search Test
	@Test(priority=4)
	public void Select_Auditor_Search_Test() throws InterruptedException
	{
		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Auditor Search Test");

		System.out.println("Select Auditor Search Test");

		int RC = Lib.getRowcount(XLPATH, "Reject Schedule");
		for(int i=3; i<=RC-10; i++)
		{
			String SA = Lib.getCellValue(XLPATH, "Reject Schedule", i, 2);
			RS.SetAuditor(SA);
			System.out.println("Entered Auditor is : " + SA);
			chiledTest.log(Status.INFO, "Auditor is Selected");

			RS.ClickMatched();
		}

		//Checking the Audits Are Displayed or Not
		RS.VerifyingRejectedAuditsAreDisplayed(driver);

		RS.ClickCloseButton();

		System.out.println("*******************************************");
	}

	//Testing the Functionality of the Select Schedule Status Search Test
	@Test(priority=5)
	public void Select_Schedule_Status_Search_Test() throws InterruptedException
	{

		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Schedule Status Test");

		System.out.println("Select Schedule Status Test");

		System.out.println("Select Schedule Status Test");
		WebElement ListBox = driver.findElement(By.name("execution_status"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Total Number of the Execution Status is ! " + count);
		int Actual_Count = count;
	//	int Expected_Count = 17;
		int Expected_Count = 18;	//##SM
		Assert.assertEquals(Actual_Count, Expected_Count, "The Count Of Execution status is Wrong");
		for(int i=1; i<alloptions.size(); i++)
		{
			WebElement ClickAllOptions = alloptions.get(i);
			String AllText = ClickAllOptions.getText();
			System.out.println("Selected Execution Status is : " + AllText);

			ClickAllOptions.click();

			//Checking the Audits Are Displayed or Not
			RS.VerifyingRejectedAuditsAreDisplayed(driver);
		}

		System.out.println("***************************************");

	}

	//Testing the Functionality of the Select Schedule Status Search Test
	@Test(priority=6)
	public void Schedule_Date_From_And_To_Search_Test() throws InterruptedException
	{
		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Sechedule Date From and To Test");

		System.out.println("Sechedule Date From and To Test");

		//Passing the Values to Schedule Date From
		String SD = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 4);
		RS.SetDateFrom(SD);
		chiledTest.log(Status.INFO, "From date is Selected");

		//Passing the Values to Schedule Date From
		String DT = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 5);
		RS.SetDateTO(DT);
		chiledTest.log(Status.INFO, "From date is Selected");

		//Checking the Audits Are Displayed or Not
		RS.VerifyingRejectedAuditsAreDisplayed(driver);

		System.out.println("********************************************");
	}


	//Testing the Functionality of the Select Schedule Status Search Test
	@Test(priority=7)
	public void All_Search_Test() throws InterruptedException
	{
		RejectSchedulePageTest RS = new RejectSchedulePageTest(driver);

		chiledTest = parentTest.createNode("All Search Test");

		System.out.println("All Search Test");

		driver.navigate().refresh();

		//Passing the values to Audit type
		int RC = Lib.getRowcount(XLPATH, "Reject Schedule");
		for(int i=5; i<=RC-8; i++)
		{
			String AT = Lib.getCellValue(XLPATH, "Reject Schedule", i, 0);
			RS.SetAuditType(AT);
			System.out.println("Entered Audit Type is : " + AT);
			chiledTest.log(Status.INFO, "Audit Type Is Serached under Select Audit Type");

			RS.ClickMatched();
		}

		//Passing the Values to Auditee
		for(int i=3; i<=RC-10; i++)
		{
			String AE = Lib.getCellValue(XLPATH, "Reject Schedule", i, 1);
			RS.SetAuditee(AE);
			chiledTest.log(Status.INFO, "Auditee is Selected");

			RS.ClickMatched();
		}

		//Passing the values to Auditee
		for(int i=3; i<=RC-10; i++)
		{
			String SA = Lib.getCellValue(XLPATH, "Reject Schedule", i, 2);
			RS.SetAuditor(SA);
			chiledTest.log(Status.INFO, "Auditor is Selected");

			RS.ClickMatched();
		}

		System.out.println("Select Schedule Status Test");
		WebElement ListBox = driver.findElement(By.name("execution_status"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		alloptions.get(2).click();

		//Passing the Values to Schedule Date From
		String SD = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 4);
		RS.SetDateFrom(SD);
		chiledTest.log(Status.INFO, "From date is Selected");

		//Passing the Values to Schedule Date From
		String DT = Lib.getCellValue(XLPATH, "Reject Schedule", 3, 5);
		RS.SetDateTO(DT);
		chiledTest.log(Status.INFO, "From date is Selected");

		//Checking the Audits Are Displayed or Not
		RS.VerifyingRejectedAuditsAreDisplayed(driver);
		
		System.out.println("***************************");
	}

}

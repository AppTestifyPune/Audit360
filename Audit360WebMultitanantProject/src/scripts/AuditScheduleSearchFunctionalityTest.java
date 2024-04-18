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

public class AuditScheduleSearchFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Audit Schedule List page
	@Test(priority=1)
	public void Audit_Schedule_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		parentTest = extent.createTest("Audit Schedule Search Functionality Test", "Testing the Functionality of the Audit Schedule Search Criteria");

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


	//Testing the Search Functionality of the Select Audit Type
	@Test(priority=2)
	public void Select_Audit_Type_Search_Functionality_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Audit Type Search Test");

		System.out.println("Select Audit Type Search Test");

		//Passing the Valid Data to Select Audit Type 
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			String SAT = Lib.getCellValue(XLPATH, "Schedule Page", i, 0);
			SP.SetSelectAuditTypeSearchFiled(SAT);
			chiledTest.log(Status.INFO, "Valid Audit Type is Searched Under Select Audit Type Search Text Filed");

			SP.ClickMatched();

			//Clicking on the Go Button
			SP.ClickGoBTN();

			//Checking the Audit Type is Displayed or not
			SP.VerifyDataIsDisplayedUnderGrid(driver);
		}

		//Clicking on the Close Buttons
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement AllCloseBTN = CloseBTN.get(i);
			AllCloseBTN.click();
		}

		//Passing the Invalid Data to Select Audit Type 
		int RC1 = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC1-9; i++)
		{
			String SAT3 = Lib.getCellValue(XLPATH, "Schedule Page", i, 1);
			SP.SetSelectAuditTypeSearchFiled(SAT3);
			chiledTest.log(Status.INFO, "Valid Audit Type is Searched Under Select Audit Type Search Text Filed");

			//Checking No Match Found Error Message is Displayed
			SP.VerifyNoMatchFoundErrorMSGIsDisplayed();
		}


		System.out.println("***********************************");


	}

	//Testing the Search Functionality of the Select Country/State/Location 
	@Test(priority=3)
	public void Select_Country_Search_Functionality_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Country Search Test");

		System.out.println("Select Country Search Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Valid Data to Select Country/State/Location 
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			String SC = Lib.getCellValue(XLPATH, "Schedule Page", i, 2);
			SP.SetCountrySearchFiled(SC);
			chiledTest.log(Status.INFO, "Valid Data is Searched Under Select Country/State/Location Search Text Filed");

			SP.ClickMatched();

			//Clicking on the Go Button
			SP.ClickGoBTN();

			//Checking the Audit Type is Displayed or not
			SP.VerifyDataIsDisplayedUnderGrid(driver);
		}

		//Clicking on the Close Buttons
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement AllCloseBTN = CloseBTN.get(i);
			AllCloseBTN.click();
		}

		//Passing the Invalid Data to Select Country/State/Location 
		int RC1 = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC1-9; i++)
		{
			String SC = Lib.getCellValue(XLPATH, "Schedule Page", i, 3);
			SP.SetCountrySearchFiled(SC);
			chiledTest.log(Status.INFO, "Invalid Data is Searched Under Select Country/State/Location Search Text Filed");

			//Checking No Match Found Error Message is Displayed
			SP.VerifyNoMatchFoundErrorMSGIsDisplayed();
		}


		System.out.println("*****************************************");
	}

	//Testing the Search Functionality of the Select Auditee
	@Test(priority=4)
	public void Select_Auditee_Search_Functionality_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Auditee Search Test");

		System.out.println("Select Auditee Search Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Valid Data to Select Country/State/Location 
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			String SA = Lib.getCellValue(XLPATH, "Schedule Page", i, 4);
			SP.SetSelectAuditeeSearchFiled(SA);
			chiledTest.log(Status.INFO, "Valid Data is Searched Under Select Auditee Search Text Filed");

			SP.ClickMatched();

			//Clicking on the Go Button
			SP.ClickGoBTN();

			//Checking the Audit Type is Displayed or not
			SP.VerifyDataIsDisplayedUnderGrid(driver);
		}

		//Clicking on the Close Buttons
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement AllCloseBTN = CloseBTN.get(i);
			AllCloseBTN.click();
		}

		//Passing the Invalid Data to Select Country/State/Location 
		int RC1 = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC1-9; i++)
		{
			String SA = Lib.getCellValue(XLPATH, "Schedule Page", i, 5);
			SP.SetSelectAuditeeSearchFiled(SA);
			chiledTest.log(Status.INFO, "Invalid Data is Searched Under Select Auditee Search Text Filed");

			//Checking No Match Found Error Message is Displayed
			SP.VerifyNoMatchFoundErrorMSGIsDisplayed();
		}


		System.out.println("*****************************************");
	}

	//Testing the Search Functionality of the Select Execution Status
	@Test(priority=5)
	public void Select_Execution_Status_Search_Functionality_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Select Execution Status Search Test");

		System.out.println("Select Execution Status Search Test");

		SP.ClickAuditScheduleHeader();

		WebElement ListBox = driver.findElement(By.id("execution_statuses"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Total Number of the Execution Status is ! " + count);
		int Actual_Count = count;
	//	int Expected_Count = 17; //#SM
		int Expected_Count = 18;  //#SM
		Assert.assertEquals(Actual_Count, Expected_Count, "The Count Of Execution status is Wrong");
		for(int i=1; i<alloptions.size(); i++)
		{
			WebElement ClickAllOptions = alloptions.get(i);
			String AllText = ClickAllOptions.getText();
			System.out.println("Selected Execution Status is : " + AllText);

			ClickAllOptions.click();

			//Clicking on the Go Button
			SP.ClickGoBTN();

			SP.VerifyDataIsDisplayedUnderGrid(driver);
		}

		System.out.println("***********************************");

	}

	//Testing the Search Functionality of the Schedule Start From and Schedule Start TO
	@Test(priority=6)
	public void Schedule_Start_From_And_Schedule_Start_TO_Search_Functionality_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Schedule Start From And schedule Start TO Search Test");

		System.out.println("Schedule Start From And schedule start TO Search Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Schedule Start Date
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			//Passing the Values to Start Date
			String SF = Lib.getCellValue(XLPATH, "Schedule Page", i, 6);
			SP.SetScheduleStartFrom(SF);

			//Passing the Values to End Date
			String ST = Lib.getCellValue(XLPATH, "Schedule Page", i, 7);
			SP.SetScheduleStartTO(ST);

			//Clicking on the Go Button
			SP.ClickGoBTN();

			SP.VerifyDataIsDisplayedUnderGrid(driver);

		}

		System.out.println("********************************");

	}

	//Testing the Search Functionality of the Schedule End From and Schedule End TO
	@Test(priority=7)
	public void Schedule_End_From_And_Schedule_End_TO_Search_Functionality_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Schedule End From And schedule End TO Search Functionality Test");

		System.out.println("Schedule End From And schedule End TO Search Functionality Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Schedule Start Date
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			//Passing the Values to Start Date
			String EF = Lib.getCellValue(XLPATH, "Schedule Page", i, 6);
			SP.SetScheduleEndFrom(EF);

			//Passing the Values to End Date
			String ET = Lib.getCellValue(XLPATH, "Schedule Page", i, 7);
			SP.SetScheduleEndTO(ET);

			//Clicking on the Go Button
			SP.ClickGoBTN();

			SP.VerifyDataIsDisplayedUnderGrid(driver);

		}

		System.out.println("********************************");

	}

	//Testing the Search Functionality of the Schedule Start From and Schedule End TO
	@Test(priority=8)
	public void Schedule_Start_From_And_Schedule_Start_TO_Mandatory_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Schedule Start From And schedule Start TO Mandatory Test");

		System.out.println("Schedule Start From And schedule Start TO Mandatory Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Schedule Start From
		String SF =  Lib.getCellValue(XLPATH, "Schedule Page", 3, 6);
		SP.SetScheduleStartFrom(SF);

		//clicking on the Go Button
		SP.ClickGoBTN();

		//checking please select Schedule Start To Alert Message is Displayed
		SP.VerifypleaseSelectScheduleStartToAlertPopUpIsDisplayed();

		SP.ClickAuditScheduleHeader();

		//passing the values to Schedule Start To
		String ST = Lib.getCellValue(XLPATH, "Schedule Page", 3, 7);
		SP.SetScheduleStartTO(ST);

		//clicking on the Go Button
		SP.ClickGoBTN();

		//checking please select Schedule Start From Alert Message is Displayed
		SP.VerifypleaseSelectScheduleStartFromAlertPopUpIsDisplayed();

	}

	//Testing the Search Functionality of the Schedule End From and Schedule End TO
	@Test(priority=9)
	public void Schedule_End_From_And_Schedule_End_TO_Mandatory_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Schedule End From And schedule End TO Mandatory Test");

		System.out.println("Schedule Start End And schedule End TO Mandatory Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Schedule End From
		String EF =  Lib.getCellValue(XLPATH, "Schedule Page", 3, 6);
		SP.SetScheduleEndFrom(EF);

		//clicking on the Go Button
		SP.ClickGoBTN();

		//checking please select Schedule End To Alert Message is Displayed
		SP.VerifypleaseSelectScheduleEndTolertPopUpIsDisplayed();

		SP.ClickAuditScheduleHeader();

		//passing the values to Schedule End To
		String ET = Lib.getCellValue(XLPATH, "Schedule Page", 3, 7);
		SP.SetScheduleEndTO(ET);

		//clicking on the Go Button
		SP.ClickGoBTN();

		//checking please select Schedule End To Alert Message is Displayed
		SP.VerifypleaseSelectScheduleEndFromlertPopUpIsDisplayed();

	}


	//Testing the Search Functionality of the Schedule Start Date and End Date
	@Test(priority=10)
	public void Audit_Review_Period_From_And_Audit_Review_Period_To_Search_Functionality_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		chiledTest = parentTest.createNode("Audit Review Period From And Audit Review Period To Search Test");

		System.out.println("Audit Review Period From And Audit Review Period To Search Test");

		SP.ClickAuditScheduleHeader();

		//Passing the Values to Schedule Start Date
		int RC = Lib.getRowcount(XLPATH, "Schedule Page");
		for(int i=3; i<=RC-9; i++)
		{
			//Passing the Values to Start Date
			String ARPF = Lib.getCellValue(XLPATH, "Schedule Page", i, 8);
			SP.SetAuditReviewPeriodFromSearchFiled(ARPF);

			//Passing the Values to End Date
			String ARPT = Lib.getCellValue(XLPATH, "Schedule Page", i, 9);
			SP.SetAuditReviewPeriodToSearchFiled(ARPT);

			SP.ClickGoBTN();

			SP.VerifyDataIsDisplayedUnderGrid(driver);

		}

		System.out.println("********************************");

	}

}

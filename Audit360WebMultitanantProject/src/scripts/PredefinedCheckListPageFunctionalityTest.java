package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.PredefinedCheckListPageTest;

public class PredefinedCheckListPageFunctionalityTest extends BaseTest {

	//Testing Functionality of the Predefined CheckList Test
	@Test(priority=1) 
	public void Predefined_CheckList_Page_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		PredefinedCheckListPageTest PC = new PredefinedCheckListPageTest(driver);

		parentTest = extent.createTest("Predefined Checklist Functionality Test", "Testing the Predefined Checklist Page View Predefined Checklist and Add My Acount");

		chiledTest = parentTest.createNode("Predefined Checklist Page Test");

		System.out.println("Predefined Checklist Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		PC.ClickScrollBar(driver);
		
		PC.ClickCheckPoints(driver);
		
		//Clicking on the Predefined Checklist from side menu 
		PC.ClickPredefinedChecklist(driver);
		chiledTest.log(Status.INFO, "Predefined Checklist is Clicked");

		//Verifying Predefined Checklist page is displayed
		PC.VerifyPredefinedChecklistPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User is Navigated to Predefined Checklist Page");

		System.out.println("**********************************************************************");

	}

	//Testing Functionality of the view Predefined CheckList Test
	@Test(priority=2) 
	public void View_Predefined_CheckList_Test() throws InterruptedException{

		PredefinedCheckListPageTest PC = new PredefinedCheckListPageTest(driver);

		chiledTest = parentTest.createNode("View Predefined Checklist Test");

		System.out.println("View Predefined Checklist Test");

		//Passing the Values to Search box
		String SP = Lib.getCellValue(XLPATH, "Predefined Checklist", 3, 0);
		PC.SetSearchButton(SP);
		chiledTest.log(Status.INFO, "Predefined Checklist is Searched");

		//Clicking on the First View Button
		PC.ClickFirstViewBTN();
		chiledTest.log(Status.INFO, "View Button is Clicked");

		//Checking the Predefined Group Page
		PC.VerifyPredefinedGroupPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Predefined Group Page is Displayed");

		//clicking on the close Button
		PC.ClickCloseBTN();

		driver.navigate().refresh();

		//Verifying Predefined Checklist page is displayed
		PC.VerifyPredefinedChecklistPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User is Navigated to Predefined Checklist Page");

		System.out.println("**********************************************************************");

	}

	//Testing the Functionality of the Add checklist to my account Mandatory fields Test
	@Test(priority=3) 
	public void Add_CheckList_To_MY_Account_Mandatoryfields_Test() throws InterruptedException{

		PredefinedCheckListPageTest PC = new PredefinedCheckListPageTest(driver);

		chiledTest = parentTest.createNode("Add Checklist To My Account Mandatory fields Test");

		System.out.println("Add Checklist To My Account Mandatory fields Test");

		//Passing the Values to Search box
		String SP = Lib.getCellValue(XLPATH, "Predefined Checklist", 3, 0);
		PC.SetSearchButton(SP);
		chiledTest.log(Status.INFO, "Predefined Checklist is Searched");

		//Clicking on the Add Account Button
		PC.ClickFirstAddMyAccountBTN();
		chiledTest.log(Status.INFO, "Add To My Account Button is Clicked");

		//Checking the Add the checklist to my account as pop up is Displayed
		PC.VerifyAddtheChecklistToMyAccountAsisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add the checklist to my account as pop up is Displayed");

		//Clicking on the Cancel Button
		PC.ClickCancelBTN();
		chiledTest.log(Status.INFO, "Cancel Button is Clicked");

		//Clicking on the Add Account Button
		PC.ClickFirstAddMyAccountBTN();
		chiledTest.log(Status.INFO, "Add To My Account Button is Clicked");

		//Checking the Add the checklist to my account as pop up is Displayed
		PC.VerifyAddtheChecklistToMyAccountAsisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add the checklist to my account as pop up is Displayed");

		//Clicking on the Ok Button
		PC.ClickOKBTN();
		chiledTest.log(Status.INFO, "OK Button is Clicked");

		//Checking the Mandatory Error Message is Displayed or not
		PC.VerifyMandatoryErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "This field is required. Error Message is displayed");

		//clicking on the cancel Button
		PC.ClickCancelBTN();

		System.out.println("**********************************************************************");
	}

	//Testing Functionality of the view Predefined CheckList Test
	@Test(priority=4) 
	public void Add_CheckList_To_MY_Account_Test() throws InterruptedException{

		PredefinedCheckListPageTest PC = new PredefinedCheckListPageTest(driver);

		chiledTest = parentTest.createNode("Add Checklist To My Account Test");

		System.out.println("Add Checklist To My Account Test");

		//Passing the Values to Search box
		String SP = Lib.getCellValue(XLPATH, "Predefined Checklist", 3, 0);
		PC.SetSearchButton(SP);
		chiledTest.log(Status.INFO, "Predefined Checklist is Searched");

		//Clicking on the Add Account Button
		PC.ClickFirstAddMyAccountBTN();
		chiledTest.log(Status.INFO, "Add To My Account Button is Clicked");

		//Checking the Add the checklist to my account as pop up is Displayed
		PC.VerifyAddtheChecklistToMyAccountAsisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add the checklist to my account as pop up is Displayed");

		//Clicking on the Cancel Button
		PC.ClickCancelBTN();
		chiledTest.log(Status.INFO, "Cancel Button is Clicked");

		//Clicking on the Add Account Button
		PC.ClickFirstAddMyAccountBTN();
		chiledTest.log(Status.INFO, "Add To My Account Button is Clicked");

		//Passing the new group name to Add the checklist to my account as 
		String AT = Lib.getCellValue(XLPATH, "Predefined Checklist", 11, 0);
		PC.SetTextBox(AT);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//Clicking on the Ok Button
		PC.ClickOKBTN();
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Checking Group is Created Success Message 
		PC.VerifyGroupCreatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Group created successfully. Success Message is Displayed");


		System.out.println("**********************************************************************");

	}

	//Testing Functionality of the view Predefined CheckList Test
	@Test(priority=5) 
	public void Adding_Already_Exists_GroupName_To_MY_Account_Test() throws InterruptedException{

		PredefinedCheckListPageTest PC = new PredefinedCheckListPageTest(driver);

		chiledTest = parentTest.createNode("Adding Already Exists GroupName To MY Account Test");

		System.out.println("Adding Already Exists GroupName To MY Account Test");

		//Passing the Values to Search box
		String SP = Lib.getCellValue(XLPATH, "Predefined Checklist", 3, 0);
		PC.SetSearchButton(SP);
		chiledTest.log(Status.INFO, "Predefined Checklist is Searched");

		//Clicking on the Add Account Button
		PC.ClickFirstAddMyAccountBTN();
		chiledTest.log(Status.INFO, "Add To My Account Button is Clicked");

		//Checking the Add the checklist to my account as pop up is Displayed
		PC.VerifyAddtheChecklistToMyAccountAsisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add the checklist to my account as pop up is Displayed");

		//Passing the already Existing group name to Add the checklist to my account as 
		String AT = Lib.getCellValue(XLPATH, "Predefined Checklist", 8, 0);
		PC.SetTextBox(AT);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//Clicking on the Ok Button
		PC.ClickOKBTN();
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Checking Group is not Created Message is displayed
		PC.VerifyGroupNotCreatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Group created successfully. Success Message is Displayed");
	}
}

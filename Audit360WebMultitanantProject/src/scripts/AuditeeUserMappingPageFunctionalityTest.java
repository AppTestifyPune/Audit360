package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditeeUserMappingPageTest;
import pom.LoginPageTest;


public class AuditeeUserMappingPageFunctionalityTest extends BaseTest  {

	//Testing the Functionality of the Auditee User Mapping Page Test
	@Test(priority= 134)
	public void Auditee_User_Mapping_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditeeUserMappingPageTest UM = new AuditeeUserMappingPageTest(driver);

		parentTest = extent.createTest("Auditee User Mapping Functionality Test", "Testing the Auditee User Mapping Page, Add New Auditte User Test, View Auditee User Test, Edit Auditee User Test..");

		chiledTest = parentTest.createNode("Auditee User Mapping Page Test");

		System.out.println("Auditee User Mapping Page Test");

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

		//Clicking on the Scrol Bar
		UM.ClickScrollBar(driver);

		//Clicking on the Reminder under side menu
		UM.ClickAuditeeUserMappings(driver);
		chiledTest.log(Status.INFO, "Auditee User Mappings is Clicked");

		//Verifying Auditee Map User Page is Displayed
		UM.VerifyAuditeeMapUserPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Auditee Map User Page is Displayed");

		System.out.println("*******************************************************************");

	}

	//Testing the Functionality of the User Mapping Test
	@Test(priority= 135)
	public void User_Mapping_Test() throws InterruptedException
	{
		AuditeeUserMappingPageTest UM = new AuditeeUserMappingPageTest(driver);

		chiledTest = parentTest.createNode("User Mapping Test");

		System.out.println("User Mapping Test");

		//clicking on the Add New Auditee - User Mapping Button
		UM.ClickAddNewAuditeeBTN();
		chiledTest.log(Status.INFO, "Add New Auditee - User Mapping Button is Clicked");

		// Verifying Add Auditee to user page is Displayed
		UM.VerifyAddAuditeeToUserpageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Add Auditee to user page is Displayed");

		//Clikcing on the Please Select
		UM.ClickPleaseSelect();

		//Passing the Values to Auditee
		String SA = Lib.getCellValue(XLPATH, "Auditee User Mappping", 4, 0);
		UM.SetAuditee(SA, driver);
		chiledTest.log(Status.INFO, "Auditee is Selected");

		UM.ClickMatched();

		//Passing the Values to Auditee User 
		String AUT = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetAuditeeUser(AUT, driver);
		chiledTest.log(Status.INFO, "Auditee User is Selected");

		UM.ClickMatched();

		//Clicking on the Submit Button
		UM.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying User added to auditee successfully Success Message is Displayed
		UM.VerifyUserAddedToAuditeeSuccessfullySucessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User added to auditee successfully Success Message is Displayed");

		System.out.println("*******************************************************************");
	}


	//Testing the Functionality of the Auditee User Search Test
	@Test(priority= 136)
	public void Search_Auditee_User_Test() throws InterruptedException
	{
		AuditeeUserMappingPageTest UM = new AuditeeUserMappingPageTest(driver);

		chiledTest = parentTest.createNode("Search Auditee User Test");

		System.out.println("Search Auditee User Test");

		//Passing the Values to Search Text Filed
		String SB = Lib.getCellValue(XLPATH, "Auditee User Mappping", 3, 0);
		UM.SetSerachBTN(SB);
		chiledTest.log(Status.INFO, "Auditee User which is not Exist in DB Searched");

		//Verifying No Data Avialbel in the Table is Dispalyed
		UM.VerifyNoDataAvailableInTable(driver);
		chiledTest.log(Status.INFO, "No data available in table Message is Displayed");

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "Auditee User Mappping", 4, 0);
		UM.SetSerachBTN(SB1);
		chiledTest.log(Status.INFO, "Auditee User is Searched");

		Thread.sleep(2000);
		WebElement Option = driver.findElement(By.xpath("//table[@id='listAuditeeUsersTable']/tbody/tr[1]/td[1]"));
		String Text = Option.getText();

		String Expected_text = SB1;
		String Actual_text = Text;

		System.out.println("Displayed Auditee User is : " + Text);
		Assert.assertEquals(Expected_text, Actual_text);
		chiledTest.log(Status.INFO, "Searched Auditee User is Displayed");


		System.out.println("*******************************************************************");
	}

	//Testing the Functionality of the View Auditee User Search Test
	@Test(priority= 137)
	public void View_Auditee_User_Test() throws InterruptedException
	{
		AuditeeUserMappingPageTest UM = new AuditeeUserMappingPageTest(driver);

		chiledTest = parentTest.createNode("View Auditee User Test");

		System.out.println("View Auditee User Test");

		//Clicking on the View Auditee User Button
		UM.ClickViewBTN(driver);
		chiledTest.log(Status.INFO, "View Button is Clicked");

		//Verify Show Auditee Page is Displayed
		UM.VerifyShowAuditeePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Show Auditee Page is Displayed");

		//click on Close Button
		UM.ClickCloseBTN();

		System.out.println("*******************************************************************");

	}

	//Testing the Functionality of the Edit Auditee User Search Test
	@Test(priority= 138)
	public void Edit_Auditee_User_Test() throws InterruptedException
	{
		AuditeeUserMappingPageTest UM = new AuditeeUserMappingPageTest(driver);

		chiledTest = parentTest.createNode("Edit Auditee User Test");

		System.out.println("Edit Auditee User Test");

		//Clicking on the Auditee User Mappings Header
		UM.ClickAuditeeUserMappingsHeader(driver);

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "Auditee User Mappping", 4, 0);
		UM.SetSerachBTN(SB1);
		chiledTest.log(Status.INFO, "Auditee User is Searched");

		//Clicking on the Edit Auditee Button
		UM.ClickEditBTN(driver);
		chiledTest.log(Status.INFO, "Edit Button is Clicked");

		//Verifying Update Auditee Page is Displayed
		UM.VerifyUpdateAuditeePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Update Auditee Page is Displayed");

		//Clicking on the Submit Button
		UM.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Updated auditee users successfully Success Message is Displayed
		UM.VerifyUpdatedAuditeeUsersSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Updated auditee users successfully Success Message is Displayed");

		System.out.println("*******************************************************************");


	}


	//Testing the Functionality of the Add Auditee To User Mandatory Filed Test
	@Test(priority= 139)
	public void MandatoryFields_Test() throws InterruptedException
	{
		AuditeeUserMappingPageTest UM = new AuditeeUserMappingPageTest(driver);

		chiledTest = parentTest.createNode("Mandatory Fields Test");

		System.out.println("Mandatory Fields Test");

		//clicking on the Add New Auditee - User Mapping Button
		UM.ClickAddNewAuditeeBTN();
		chiledTest.log(Status.INFO, "Add New Auditee - User Mapping Button is Clicked");

		// Verifying Add Auditee to user page is Displayed
		UM.VerifyAddAuditeeToUserpageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Add Auditee to user page is Displayed");

		//Clicking on the Submit Button
		UM.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		UM.ClickPleaseSelect();

		//Passing the Values to Auditee
		String SA = Lib.getCellValue(XLPATH, "Auditee User Mappping", 4, 0);
		UM.SetAuditee(SA, driver);
		chiledTest.log(Status.INFO, "Auditee is Selected");

		UM.ClickMatched();

		//Clicking on the Submit Button
		UM.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Mandatory filed
		UM.VerifyMandatoryMessageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Mandatory fields are Displayed");


		System.out.println("*******************************************************************");
	}
}

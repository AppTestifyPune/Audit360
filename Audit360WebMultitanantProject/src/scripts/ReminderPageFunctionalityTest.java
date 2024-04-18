package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.ReminderPageTest;

public class ReminderPageFunctionalityTest extends BaseTest  {

	//Testing the Functionality of the Reminder Page
	@Test(priority=1)
	public void Reminder_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ReminderPageTest RP = new ReminderPageTest(driver);

		parentTest = extent.createTest("Reminder Functionality Test", "Testing the Reminder Page, Add Reminder Test");

		chiledTest = parentTest.createNode("Reminder Page Functionality Test");

		System.out.println("Reminder Page Functionality Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
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

		//Clicking on the Scroll Bar
		RP.ClickScrollBar(driver);

		//Clicking on the Reminder under side menu
		RP.ClickReminder(driver);
		chiledTest.log(Status.INFO, "Reminder is Clicked");

		//Verify Reminder page is Displayed
		RP.VerifyReminderPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Reminder page is Displayed");


		System.out.println("**********************************************************");
	}

	//Testing the Functionality of the Add Reminder Page
	@Test(priority=2)
	public void Reminder_Cancel_Button_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Reminder Cancel Button Test");

		System.out.println("Reminder Cancel Button Test");

		//Clicking on the Add Reminder Button
		RP.ClickAddReminderButton();
		chiledTest.log(Status.INFO, "Add Reminder Button is Clicked");

		//clicking on the add a remainder configuration Button
		RP.ClickAddaRemainderConfigurationButton();

		//Clicking on Cancel Button
		RP.ClickCancelButton();
		chiledTest.log(Status.INFO, "Cancel Button is Clicked");

		//Verify Reminder page is Displayed
		RP.VerifyReminderPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Reminder page is Displayed");

		System.out.println("**********************************************************");

	}


	//Testing the Functionality of the Add Reminder Page
	@Test(priority=3, dependsOnMethods= {"Reminder_Cancel_Button_Test"})
	public void Add_Reminder_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Add Reminder Test");

		System.out.println("Add Reminder Test");

		//Clicking on the Add Reminder Button
		RP.ClickAddReminderButton();
		chiledTest.log(Status.INFO, "Add Reminder Button is Clicked");

		//Passing the Values to Name
		String SN = Lib.getCellValue(XLPATH, "Reminder Page", 1, 0);
		RP.SetName(SN);
		chiledTest.log(Status.INFO, "Name Is Entered");

		//clicking on the Reminder configuration button
		RP.ClickAddaRemainderConfigurationButton();

		//Clicking on the Please Select Level
		RP.ClickPleaseselectLevel();

		//Passing the Values to Please Select Level
		String PL = Lib.getCellValue(XLPATH, "Reminder Page", 1, 1);
		RP.SetPleaseselectLevel(PL, driver);
		chiledTest.log(Status.INFO, "Upto Level is Selected");

		RP.ClickMatched();

		//Selecting the Roles under Roles drop down list
		String SR = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		RP.SetRoles(SR, driver);

		RP.ClickMatched();

		//Clicking on the Please Select Frequency
		RP.ClickPleaseSelectFrequency();

		//Passing the Values to Please Select Frequency
		String PF = Lib.getCellValue(XLPATH, "Reminder Page", 1, 4);
		RP.SetPleaseSelectFrequency(PF, driver);

		//clicking on the Matched
		RP.ClickMatched();

		//Passing the values to Days from TAT 
		String DFT = Lib.getCellValue(XLPATH, "Reminder Page", 1, 3);
		RP.SetDaysFromTAT(DFT);

		//selecting Monday from the When to send drop down 
		driver.findElement(By.xpath("//option[@value='Monday']")).click();
		System.out.println("Monday Option is Selected under When to Send");

		//selecting the High Option under Issue Type
		driver.findElement(By.xpath("//option[@value='high']")).click();
		System.out.println("High Option is Selected under When to Send");

		//Clicking on the submit Button
		RP.ClickSubmitBUtton();

		//Verifying Reminder Added Successfully Message 
		RP.VerifyReminderAddedSuccessfullyMSGIsDisplayed(driver);


		System.out.println("************Creating One more Remainder **********************************************");

		//Clicking on the Add Reminder Button
		RP.ClickAddReminderButton();
		chiledTest.log(Status.INFO, "Add Reminder Button is Clicked");

		//Passing the Values to Name
		String SN1 = Lib.getCellValue(XLPATH, "Reminder Page", 2, 0);
		RP.SetName(SN1);
		chiledTest.log(Status.INFO, "Name Is Entered");

		RP.ClickAddaRemainderConfigurationButton();

		//Clicking on the Please Select Level
		RP.ClickPleaseselectLevel();

		//Passing the Values to Please Select Level
		String PL1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 1);
		RP.SetPleaseselectLevel(PL1, driver);
		chiledTest.log(Status.INFO, "Upto Level is Selected");

		RP.ClickMatched();

		//Selecting the Roles under Roles drop down list
		String SR1 = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		RP.SetRoles(SR1, driver);

		RP.ClickMatched();

		//Clicking on the Please Select Frequency
		RP.ClickPleaseSelectFrequency();

		//Passing the Values to Please Select Frequency
		String PF1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 4);
		RP.SetPleaseSelectFrequency(PF1, driver);

		//clicking on the Matched
		RP.ClickMatched();

		//Passing the values to Days from TAT 
		String DFT1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 3);
		RP.SetDaysFromTAT(DFT1);

		//selecting Monday from the When to send drop down 
		driver.findElement(By.xpath("//option[@value='Monday']")).click();
		System.out.println("Monday Option is Selected under When to Send");

		//selecting the High Option under Issue Type
		driver.findElement(By.xpath("//option[@value='high']")).click();
		System.out.println("High Option is Selected under When to Send");

		//Clicking on the submit Button
		RP.ClickSubmitBUtton();

		//Verifying Reminder Added Successfully Message 
		RP.VerifyReminderAddedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Adding same Reminder 
	@Test(priority=4, dependsOnMethods= {"Add_Reminder_Test"})
	public void Adding_Same_Reminder_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Adding Same Reminder Test");

		System.out.println("Adding Same Reminder Test");

		//Clicking on the Add Reminder Button
		RP.ClickAddReminderButton();
		chiledTest.log(Status.INFO, "Add Reminder Button is Clicked");

		//Passing the Values to Name
		String SN1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 0);
		RP.SetName(SN1);
		chiledTest.log(Status.INFO, "Name Is Entered");

		RP.ClickAddaRemainderConfigurationButton();

		//Clicking on the Please Select Level
		RP.ClickPleaseselectLevel();

		//Passing the Values to Please Select Level
		String PL1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 1);
		RP.SetPleaseselectLevel(PL1, driver);
		chiledTest.log(Status.INFO, "Upto Level is Selected");

		RP.ClickMatched();

		//Selecting the Roles under Roles drop down list
		String SR = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		RP.SetRoles(SR, driver);

		RP.ClickMatched();

		//Clicking on the Please Select Frequency
		RP.ClickPleaseSelectFrequency();

		//Passing the Values to Please Select Frequency
		String PF1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 4);
		RP.SetPleaseSelectFrequency(PF1, driver);

		//clicking on the Matched
		RP.ClickMatched();

		//Passing the values to Days from TAT 
		String DFT1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 3);
		RP.SetDaysFromTAT(DFT1);

		//selecting Monday from the When to send drop down 
		driver.findElement(By.xpath("//option[@value='Monday']")).click();
		System.out.println("Monday Option is Selected under When to Send");

		//selecting the High Option under Issue Type
		driver.findElement(By.xpath("//option[@value='high']")).click();
		System.out.println("High Option is Selected under When to Send");

		//Clicking on the submit Button
		RP.ClickSubmitBUtton();

		//Verifying Reminder Added Successfully Message 
		RP.VerifyNameHasAlreadyBeenTakenErrorMSGIsDisplayed(driver);

		System.out.println("**********************************************************");

	}

	//Testing the Functionality of the Search Reminder Page
	@Test(priority=5, dependsOnMethods= {"Adding_Same_Reminder_Test"})
	public void Search_Reminder_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Search Reminder Test");

		System.out.println("Search Reminder Test");

		RP.ClickReminderHeader();

		//Passing the Values to Search text Filed
		String SR = Lib.getCellValue(XLPATH, "Reminder Page", 3, 0);
		RP.SetSearchButton(SR);
		chiledTest.log(Status.INFO, "Reminder Name is Searched");

		//Verifying the Reminder List is not Displayed
		RP.VerifyNoDataAvailableInTableIsDisplayed(driver);
		chiledTest.log(Status.INFO, "No data available in table Message is Displayed");

		//Passing the Values to Search text Filed
		String SR1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 0);
		RP.SetSearchButton(SR1);
		chiledTest.log(Status.INFO, "Reminder Name is Searched");

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement RemainderName = driver.findElement(By.xpath("//table[@id='remindersTableData']/tbody/tr[1]/td[2]"));
		String Text = wait.until(ExpectedConditions.visibilityOf(RemainderName)).getText();
		Assert.assertEquals(SR1, Text);
		System.out.println("Pass : Searched Remainder is Displayed");
		chiledTest.log(Status.INFO, "Searched Remainder is Displayed");

		System.out.println("**********************************************************");

	}

	//Testing the Functionality of the View Reminder Page
	@Test(priority=6, dependsOnMethods= {"Search_Reminder_Test"})
	public void View_Reminder_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("View Reminder Test");

		System.out.println("View Reminder Test");

		//clicking on the Remainder Header
		RP.ClickReminderHeader();

		//Passing the Values to Search text Filed
		String SR1 = Lib.getCellValue(XLPATH, "Reminder page", 1, 0);
		RP.SetSearchButton(SR1);
		chiledTest.log(Status.INFO, "Reminder Name is Searched");

		//Clicking on the View Button
		RP.ClickViewButton();

		//Verifying Reminder Page is Displayed
		RP.VerifyReminderDetailsPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reminder Page is Displayed");

		//Checking the Name
		String Actual_ReminderName = driver.findElement(By.xpath("//input[@id='reminder_name']")).getAttribute("value");
		String Expected_ReminderName = Lib.getCellValue(XLPATH, "Reminder Page", 1, 0);
		Assert.assertEquals(Actual_ReminderName, Expected_ReminderName, "Reminder Name is showing wrong");
		System.out.println("Reminder name is Matched");
		chiledTest.log(Status.INFO, "Reminder name is Matched");

		//checking the Level
		String Actaul_Level = driver.findElement(By.xpath("//div[@id='s2id_selected_level']//span[@class='select2-chosen']")).getText();
		String Expected_Level = Lib.getCellValue(XLPATH, "Reminder Page", 1, 1);
		Assert.assertEquals(Actaul_Level, Expected_Level, "Level is showing wrong");
		System.out.println("Level is Matched");
		chiledTest.log(Status.INFO, "Level is Matched");

		//Checking the Roles
		String Actual_Rols = driver.findElement(By.xpath("//div[@id='s2id_reminder_reminder_configurations_attributes_0_configurable_roles']//li[@class='select2-search-choice']/div")).getText();
		String Expected_Roles = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		Assert.assertEquals(Actual_Rols, Expected_Roles, "Roles is showing wrong");
		System.out.println("role is Matched");
		chiledTest.log(Status.INFO, "Role is Matched");

		//Checking the days form TAT
		String Actual_TAT = driver.findElement(By.xpath("//input[@placeholder='Days from TAT']")).getAttribute("value");
		String Expected_TAT = Lib.getCellValue(XLPATH, "Reminder Page", 1, 3);
		Assert.assertEquals(Actual_TAT, Expected_TAT, "TAT is showing wrong");
		System.out.println("TAT is Matched");
		chiledTest.log(Status.INFO, "TAT is Matched");

		//Checking the Frequency
		String Actual_Frequency = driver.findElement(By.xpath("//div[@id='s2id_autogen7']//span[@class='select2-chosen']")).getText();
		String Expected_Frequency = Lib.getCellValue(XLPATH, "Reminder Page", 1, 4);
		Assert.assertEquals(Actual_Frequency, Expected_Frequency, "Frequency is showing wrong");
		System.out.println("Frequency is Matched");
		chiledTest.log(Status.INFO, "Frequency is Matched");

		//Checking the When to send
		String Actual_WhenToSend = driver.findElement(By.xpath("//div[@id='s2id_autogen9']//span[@class='select2-chosen']")).getText();
		String Expected_WhenToSend = Lib.getCellValue(XLPATH, "Reminder Page", 1, 5);
		Assert.assertEquals(Actual_WhenToSend, Expected_WhenToSend, "When To Send is showing wrong");
		System.out.println("When To Send is Matched");
		chiledTest.log(Status.INFO, "When To Send is Matched");

		//Checking the Issue Type
		String Actual_IssueType = driver.findElement(By.xpath("//div[@id='s2id_reminder_reminder_configurations_attributes_0_configurable_issue_types']//li[@class='select2-search-choice']/div")).getText();
		String Expected_IssueType = Lib.getCellValue(XLPATH, "Reminder Page", 1, 6);
		Assert.assertEquals(Actual_IssueType, Expected_IssueType, "Issue Type is showing wrong");
		System.out.println("Issue Type is Matched");
		chiledTest.log(Status.INFO, "Issue Type is Matched");

		//Clicking on the Close Button
		RP.ClickCloseBTN();
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		System.out.println("**********************************************************");

	}

	//Testing the Functionality of the Edit Reminder Page
	@Test(priority=7, dependsOnMethods= {"View_Reminder_Test"})
	public void Edit_Reminder_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Edit Reminder Test");

		System.out.println("Edit Reminder Test");

		driver.navigate().refresh();

		//clicking on the Remainder Header
		RP.ClickReminderHeader();

		//Passing the Values to Search text Filed
		String SR1 = Lib.getCellValue(XLPATH, "Reminder Page", 1, 0);
		RP.SetSearchButton(SR1);
		chiledTest.log(Status.INFO, "Reminder Name is Searched");

		//Clicking on the Edit Button
		RP.ClickEditButton();

		//Clicking on the Cancel Button
		RP.ClickCancelButton();
		chiledTest.log(Status.INFO, "Cancel Button is Clicked");

		//Verify Reminder Page is Displayed
		RP.VerifyReminderPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Reminder Page is Displayed");

		//Clicking on the Edit Button
		RP.ClickEditButton();

		//Clicking on the Submit Button
		RP.ClickSubmitBUtton();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Remainder Updated Successfully Message is Displayed 
		RP.VerifyReminderUpdatedSuccessfullyIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Remainder Updated Successfully Message is Displayed");

		System.out.println("**********************************************************");
	}

	//Testing the Functionality of the Delete Reminder which is not mapped to any audit type
	@Test(priority=8, dependsOnMethods= {"Edit_Reminder_Test"})
	public void Delete_Reminder_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Delete Reminder Test");

		System.out.println("Delete Reminder Test");

		RP.ClickReminderHeader();

		//Passing the Values to Search Text Fields
		String SR = Lib.getCellValue(XLPATH, "Reminder Page", 2, 0);
		RP.SetSearchButton(SR);
		chiledTest.log(Status.INFO, "Reminder Name is Searched");

		//Clicking on the Delete Button
		RP.ClickDeleteButton(driver);

		//Verifying  Are you sure you want to delete this reminder ? pop is Displayed
		RP.VerifyAreYouSureYouWantToDeleteReminderPopIsDisplayed(driver);
		chiledTest.log(Status.INFO, " Are you sure you want to delete this reminder ? Pop up is Displayed");

		//Clicking on the Cancel Button
		RP.ClickCancelButton();
		chiledTest.log(Status.INFO, "Cancel Button is Clicked");

		//Verify Reminder Page is Displayed
		RP.VerifyReminderPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Reminder Page is Displayed");

		//Clicking on the Delete Button
		RP.ClickDeleteButton(driver);
		chiledTest.log(Status.INFO, "Delete Button is Clicked");

		//Clicking on the OK Button
		RP.ClickOKButton(driver);
		chiledTest.log(Status.INFO, "OK Button is Clicked");

		//Verifying Reminder Deleted Successfully Success Message is Displayed
		RP.VerifyReminderDeletedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reminder Deleted Successfully Success Message is Displayed");


		System.out.println("**********************************************************");

	}


	//Testing Reminder Mandatory Fields 
	@Test(priority=9, dependsOnMethods= {"Delete_Reminder_Test"})
	public void Reminder_Mandatory_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Reminder Mandatory Test");

		System.out.println("Reminder Mandatory Test");

		//clicking on the Add Reminder Button
		RP.ClickAddReminderButton();

		//clicking on the add Reminder Configuration Button
		RP.ClickAddaRemainderConfigurationButton();

		//Checking Name
		WebElement NAME = driver.findElement(By.xpath("//input[@placeholder='Name' and @required='required']"));
		Assert.assertTrue(NAME.isDisplayed(), "Name is Not Working as Required Filed");
		System.out.println("Pass : Name is Required Field");
		chiledTest.log(Status.INFO, "Name is Required Filed");

		//Checking Level
		WebElement Level = driver.findElement(By.xpath("//select[@class='selected_level full-width select2-offscreen' and @required='required']"));
		Assert.assertTrue(Level.isDisplayed(), "Level is Not Working as Required Filed");
		System.out.println("Pass : UpTo Level is Required Field");
		chiledTest.log(Status.INFO, "UPTO Level is Required Filed");

		//Checking Roles
		WebElement Roles = driver.findElement(By.xpath("//select[@class='selected_level_roles full-width select2-drop-multi select2-offscreen' and @required='required']"));
		Assert.assertTrue(Roles.isDisplayed(), "Roles is Not Working as required filed");
		System.out.println("Pass : Roles is Required Field");
		chiledTest.log(Status.INFO, "Roles is Required Filed");

		//Checking Frequency
		WebElement Frequency = driver.findElement(By.xpath("//select[@title='Frequency' and @required='required']"));
		Assert.assertTrue(Frequency.isDisplayed(), "Frequency is Not Working as Rquired Fields");
		System.out.println("Pass : Frequency is Required Field");
		chiledTest.log(Status.INFO, "Frequency is Required Filed");

		//Checking the Days From TAT
		WebElement Days = driver.findElement(By.xpath("//input[@placeholder='Days from TAT' and @required='required']"));
		Assert.assertTrue(Days.isDisplayed(), "Dayes From TAT is Not Working as Required Fileds");
		System.out.println("Pass : DAYs From TAT is Required Field");
		chiledTest.log(Status.INFO, "Days From TAT is Required Filed");

		System.out.println("**********************************************************");

	}


	//Testing the Functionality of the Delete Reminder which is mapped to audit type
	@Test(priority=10, dependsOnMethods= {"Reminder_Mandatory_Test"})
	public void Delete_Reminder_Which_Mapped_To_AuditType_Test() throws InterruptedException
	{
		ReminderPageTest RP = new ReminderPageTest(driver);

		chiledTest = parentTest.createNode("Delete Reminder which is Mapped to Audit Type Test");

		System.out.println("Delete Reminder which is Mapped to Audit Type Test");

		RP.ClickReminderHeader();

		//Passing the Mapped Reminder Name to Search Text Fields
		String SR = Lib.getCellValue(XLPATH, "Reminder Page", 4, 0);
		RP.SetSearchButton(SR);
		chiledTest.log(Status.INFO, "Reminder Name is Searched");

		//Clicking on the Delete Button
		RP.ClickDeleteButton(driver);
		chiledTest.log(Status.INFO, "Delete Button is Clicked");

		//Verifying Please note that the reminder cannot be deleted as Message is Displayed
		RP.VerifyPleaseNoteThatTheReminderCannotBeDeletedAsMSGIsDisplayed(driver);

		System.out.println("**********************************************************");

	}

}

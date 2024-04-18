package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.EmailPreferencePageTest;
import pom.LoginPageTest;

public class EmailPreferencePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Email Preference Page
	@Test(priority=1)
	public void Email_Preference_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		parentTest = extent.createTest("Email Preference Page Functionality Test", "Testing the Email Preference Page, Add Email Preference Test, List Email Prefernces, Search Email Preference..");

		chiledTest = parentTest.createNode("Email Preference Page Functionality Test");

		System.out.println("Email Preference Page Functionality Test");

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

		//Clicking on the Scroll Bar
		EP.ClickScrollBar(driver);

		//Clicking on the Reminder under side menu
		EP.ClickEmailPreferences(driver);
		chiledTest.log(Status.INFO, "Email Preference is Clicked");

		//Verifying Email Preference Page is Displayed
		EP.VerifyEmailPreferencePageisDispalyed(driver);
		chiledTest.log(Status.INFO, "Email Preference Page is Displayed");

		System.out.println("*******************************************************************");

	}

	//Testing the Functionality of the Add Email Preference
    @Test(priority=3, dependsOnMethods= {"Email_Preference_Page_Test"})
	public void Creating_Email_Preference_Test() throws InterruptedException
	{

		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		chiledTest = parentTest.createNode("Creating Email Preference Test");

		System.out.println("Creating Email Preference Test");

		//Clicking on the Add Email preference Button
		EP.ClickEmailPreferenceBTN();
		chiledTest.log(Status.INFO, "Add Email Preference Button is Displayed");

		//Checking Post action Trigger tab is Selected
		List<WebElement> PostActionTriggerTab = driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li[@class='active']/a[text()='Post Action Trigger']"));
		Assert.assertTrue(PostActionTriggerTab.size()>0, "Post Action Trigger Tap is Selected");

		//Passing the values to Creation of schedule by auditor	
		String R1 = Lib.getCellValue(XLPATH, "Email Preference", 8, 0);
		EP.PostActionTriggerSetRol1(R1, driver);

		//Passing the Values to Creation of schedule by admin	
		String R2 = Lib.getCellValue(XLPATH, "Email Preference", 9, 0);
		EP.PostActionTriggerSetRol2(R2, driver);

		//Clicking on the non Action Trigger Tab
		EP.ClickNonActionTriggerTab(driver);
		chiledTest.log(Status.INFO, "non Action Trigger Tab is Clicked");

		//Checking Non action Trigger tab is Selected
		List<WebElement> NonActionTriggerTab = driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li[@class='active']/a[text()='Non Action Trigger']"));
		Assert.assertTrue(NonActionTriggerTab.size()>0, "Non Action Trigger Tap is Selected");

		//Checking Non Action Trigger Page is Displayed
		EP.VerifyNonActionTriggerPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "non Action Trigger Page is Clicked");

		//Passing the Values to Roles
		int RC = Lib.getRowcount(XLPATH, "Email Preference");
		for(int i=8; i<=RC-11; i++)
		{
			String R13 = Lib.getCellValue(XLPATH, "Email Preference", i, 0);
			EP.NonActionTriggerSetRol1(R13, driver);

			EP.ClickMatched();
		}

		WebElement ListBox = driver.findElement(By.xpath("//table[@id='initEmailNotificationPreSearch']/tbody/tr[1]/td[3]/select"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Total Number of the Frequency is ! " + count);
		for(int i=0; i<alloptions.size(); i++)
		{
			alloptions.get(1).click();
		}

		//Passing the Values to Name
		String SN = Lib.getCellValue(XLPATH, "Email Preference", 3, 0);
		EP.SetName(SN);
		chiledTest.log(Status.INFO, "Email Preference Name is Entered");

		//Clicking on the submit Button
		EP.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying the Email preference was successfully created. Message is displayed
		EP.VerifyEmailPreferenceWasSuccessfullyCreatedMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Email preference was successfully created. Message is displayed");

		//***************** Creating one more Email Preferences **************************

		//Clicking on the Add Email preference Button
		EP.ClickEmailPreferenceBTN();
		chiledTest.log(Status.INFO, "Email Preference Button is Displayed");

		//Passing the values to Creation of schedule by auditor	
		String R5 = Lib.getCellValue(XLPATH, "Email Preference", 8, 0);
		EP.PostActionTriggerSetRol1(R5, driver);

		//Passing the Values to Creation of schedule by admin	
		String R3 = Lib.getCellValue(XLPATH, "Email Preference", 9, 0);
		EP.PostActionTriggerSetRol2(R3, driver);

		//Clicking on the non Action Trigger Tab
		EP.ClickNonActionTriggerTab(driver);
		chiledTest.log(Status.INFO, "non Action Trigger Tab is Clicked");

		//Checking Non action Trigger tab is Selected
		List<WebElement> NonActionTriggerTab1 = driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li[@class='active']/a[text()='Non Action Trigger']"));
		Assert.assertTrue(NonActionTriggerTab1.size()>0, "Non Action Trigger Tap is Selected");

		//Checking Non Action Trigger Page is Displayed
		EP.VerifyNonActionTriggerPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "non Action Trigger Page is Clicked");

		//Passing the Values to Roles
		int RC1 = Lib.getRowcount(XLPATH, "Email Preference");
		for(int i=8; i<=RC1-11; i++)
		{
			String R13 = Lib.getCellValue(XLPATH, "Email Preference", i, 0);
			EP.NonActionTriggerSetRol1(R13, driver);

			EP.ClickMatched();
		}

		WebElement ListBox1 = driver.findElement(By.xpath("//table[@id='initEmailNotificationPreSearch']/tbody/tr[1]/td[3]/select"));
		Select select1 = new Select(ListBox1);
		List<WebElement> alloptions1 = select1.getOptions();
		int count1 = alloptions1.size();
		System.out.println("The Total Number of the Frequency is ! " + count1);
		for(int i=0; i<alloptions1.size(); i++)
		{
			alloptions1.get(1).click();
		}

		//Passing the Values to Name
		String SN1 = Lib.getCellValue(XLPATH, "Email Preference", 4, 0);
		EP.SetName(SN1);
		chiledTest.log(Status.INFO, "Email Preference Name is Entered");

		//Clicking on the submit Button
		EP.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying the Email preference was successfully created. Message is displayed
		EP.VerifyEmailPreferenceWasSuccessfullyCreatedMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Email preference was successfully created. Message is displayed");


		System.out.println("*******************************************************************");

	}

	//Testing the Functionality of the Adding same Email Preference
	@Test(priority=4, dependsOnMethods= {"Creating_Email_Preference_Test"})
	public void Adding_Same_Email_Preference_Test() throws InterruptedException
	{

		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		chiledTest = parentTest.createNode("Adding Same Email Preference Test");

		System.out.println("Adding Same Email Preference Test");

		//Clicking on the Email Preference Header
		EP.ClickEmailPreferenceHeader(driver);
		chiledTest.log(Status.INFO, "Email Preference is Clicked");

		//Clicking on the Add Email preference Button
		EP.ClickEmailPreferenceBTN();
		chiledTest.log(Status.INFO, "Email Preference Button is Displayed");

		//Checking Post action Trigger tab is Selected
		List<WebElement> PostActionTriggerTab = driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li[@class='active']/a[text()='Post Action Trigger']"));
		Assert.assertTrue(PostActionTriggerTab.size()>0, "Post Action Trigger Tap is Selected");

		//Passing the values to Creation of schedule by auditor	
		String R1 = Lib.getCellValue(XLPATH, "Email Preference", 8, 0);
		EP.PostActionTriggerSetRol1(R1, driver);

		//Passing the Values to Creation of schedule by admin	
		String R2 = Lib.getCellValue(XLPATH, "Email Preference", 9, 0);
		EP.PostActionTriggerSetRol2(R2, driver);

		//Clicking on the non Action Trigger Tab
		EP.ClickNonActionTriggerTab(driver);
		chiledTest.log(Status.INFO, "non Action Trigger Tab is Clicked");

		//Checking Non action Trigger tab is Selected
		List<WebElement> NonActionTriggerTab = driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li[@class='active']/a[text()='Non Action Trigger']"));
		Assert.assertTrue(NonActionTriggerTab.size()>0, "Non Action Trigger Tap is Selected");

		//Checking Non Action Trigger Page is Displayed
		EP.VerifyNonActionTriggerPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "non Action Trigger Page is Clicked");

		//Passing the Values to Roles
		int RC = Lib.getRowcount(XLPATH, "Email Preference");
		for(int i=8; i<=RC-11; i++)
		{
			String R13 = Lib.getCellValue(XLPATH, "Email Preference", i, 0);
			EP.NonActionTriggerSetRol1(R13, driver);

			EP.ClickMatched();
		}

		WebElement ListBox = driver.findElement(By.xpath("//table[@id='initEmailNotificationPreSearch']/tbody/tr[1]/td[3]/select"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Total Number of the Frequency is ! " + count);
		for(int i=0; i<alloptions.size(); i++)
		{
			alloptions.get(1).click();
		}

		//Passing the Values to Name
		String SN = Lib.getCellValue(XLPATH, "Email Preference", 3, 0);
		EP.SetName(SN);
		chiledTest.log(Status.INFO, "Email Preference Name is Entered");

		//Clicking on the submit Button
		EP.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying the name has already been taken Message is displayed
		EP.VerifyNameHasAlreadyBeenTakenMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Name Has already been Taken Message is displayed");

		System.out.println("*******************************************************************");

	}


	//Testing the Functionality of the View Email Preference
	@Test(priority=5, dependsOnMethods= {"Adding_Same_Email_Preference_Test"})
	public void View_Email_Preference_Test() throws InterruptedException
	{

		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		chiledTest = parentTest.createNode("View Email Preference Test");

		System.out.println("View Email Preference Test");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Clicking on the Email Preference Header
		EP.ClickEmailPreferenceHeader(driver);
		chiledTest.log(Status.INFO, "Email Preference is Clicked");

		//Passing the Values to Search Text filed
		String SB = Lib.getCellValue(XLPATH, "Email Preference", 4, 0);
		EP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Entered the valid Email Preference Name");

		//Clicking on the View Button
		EP.ClickViewBTN(driver);
		chiledTest.log(Status.INFO, "View Button is Clicked");

		//Checking Email Preference Details page is Displayed
		EP.VerifyEmailPreferenceDetailsPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Email Preference Details Page is Displayed");

		//Clicking on the Close Button
		EP.ClickCloseBTN();

		System.out.println("*******************************************************************");

	}

	//Testing the Functionality of the Edit Email Preference
	@Test(priority=6, dependsOnMethods= {"View_Email_Preference_Test"})
	public void Edit_Email_Preference_Test() throws InterruptedException
	{
		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		chiledTest = parentTest.createNode("Edit Email Preference Test");

		System.out.println("Edit Email Preference Test");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Clicking on the Email Preference Header
		EP.ClickEmailPreferenceHeader(driver);
		chiledTest.log(Status.INFO, "Email Preference is Clicked");

		//Passing the Values to Search Text filed
		String SB1 = Lib.getCellValue(XLPATH, "Email Preference", 3, 0);
		EP.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "Email Prefernce is Searched");

		//Clicking on the Edit Button
		EP.ClickEditBTN(driver);
		chiledTest.log(Status.INFO, "Edit Button is Clicked");

		//clicking on the Submit Button
		EP.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Email preference was successfully updated Success Message is Displayed
		EP.VerifyEmailPreferenceWasSuccessfullyUpdated(driver);
		chiledTest.log(Status.INFO, "Email preference was successfully updated Success Message is Displayed");

		System.out.println("****************************************************************");

	}

	//Testing the Functionality of the Delete Email Preference
	@Test(priority=7, dependsOnMethods= {"Edit_Email_Preference_Test"})
	public void Delete_Email_Preference_Test() throws InterruptedException
	{
		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		chiledTest = parentTest.createNode("Delete Email Preference Test");

		System.out.println("Delete Email Preference Test");

		//Clicking on the email preference header
		EP.ClickEmailPreferenceHeader(driver);

		//Passing the Values to Search Text filed
		String SB1 = Lib.getCellValue(XLPATH, "Email Preference", 4, 0);
		EP.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "Email Prefernce is Searched");

		//Clicking on the Delete Button
		EP.ClickDeleteBTN(driver);
		chiledTest.log(Status.INFO, "Delete Button is Clicked");

		//Verifying the Email Preference delete Pop up is Displayed
		EP.VerifyEmailPreferenceDeletePupIsDisplayed1(driver);
		chiledTest.log(Status.INFO, "Email Preference delete Pop up is Displayed");

		//Clicking on the OK Button
		EP.ClickOKBTN(driver);
		chiledTest.log(Status.INFO, "OK Button is Clicked");

		//Verifying Email preference was successfully destroyed Success Message is Displayed
		EP.VerifyEmailPreferenceWasSuccessfullyDestroyedSuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Email preference was successfully destroyed Success Message is Displayed");

		driver.navigate().refresh();

		//Passing the Deleted name to Search Text filed
		String SB = Lib.getCellValue(XLPATH, "Email Preference", 4, 0);
		EP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Deleted Email Preference Name is Searched");

		//Checking No Data Available Message is Displayed
		EP.VerifyNoDataAvailableInTableisDisplayed(driver);


		System.out.println("****************************************************************");

	}

	//Testing the Functionality of the Search Email Preference
	@Test(priority=8, dependsOnMethods= {"Delete_Email_Preference_Test"})
	public void Search_Email_Preference_Test() throws InterruptedException
	{

		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		chiledTest = parentTest.createNode("Search Email Preference Test");

		System.out.println("Search Email Preference Test");

		//Clicking on the Email Preference Header
		EP.ClickEmailPreferenceHeader(driver);
		chiledTest.log(Status.INFO, "Email Preference is Clicked");

		//Passing the Deleted name to Search Text filed
		String SB = Lib.getCellValue(XLPATH, "Email Preference", 4, 0);
		EP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Deleted Email Preference Name is Searched");

		//Checking No Data Available Message is Displayed
		EP.VerifyNoDataAvailableInTableisDisplayed(driver);
		chiledTest.log(Status.INFO, "No Data Available Message is Displayed");

		//Passing the Valid Values to Search Text filed
		String SB2 = Lib.getCellValue(XLPATH, "Email Preference", 3, 0);
		EP.SetSearchBTN(SB2);
		chiledTest.log(Status.INFO, "Entered the valid Email Preference Name");

		Thread.sleep(2000);
		WebElement Name = driver.findElement(By.xpath("//table[@id='listPreferencesTable']/tbody/tr[1]/td[1]"));
		String text1 = Name.getText();

		String Expected_Text = text1;
		String Actual_Text = SB2;
		Assert.assertEquals(Expected_Text, Actual_Text);
		System.out.println("Displayed Name is : " + SB2 );
		chiledTest.log(Status.INFO, "Searched Email Preference is Displayed");

		System.out.println("*******************************************************************");

	}

	//Testing the Functionality of the Delete Email Preference which is Mapped to Audit Type
	@Test(priority=9, dependsOnMethods= {"Search_Email_Preference_Test"})
	public void Delete_Email_Preference_Which_Is_Mapped_TO_AuditType_Test() throws InterruptedException
	{
		EmailPreferencePageTest EP = new EmailPreferencePageTest(driver);

		chiledTest = parentTest.createNode("Delete Email Preference Which is Mapped to Audit Type Test");

		System.out.println("Delete Email Preference Which is Mapped to Audit Type Test");

		//Clicking on the Email Preference Header
		EP.ClickEmailPreferenceHeader(driver);
		chiledTest.log(Status.INFO, "Email Preference is Clicked");

		//Passing the Values to Search Text filed
		String SB = Lib.getCellValue(XLPATH, "Email Preference", 18, 0);
		EP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Email Prefernce is Searched");

		//Clicking on the Delete Button
		EP.ClickDeleteBTN(driver);
		chiledTest.log(Status.INFO, "Delete Button is Clicked");

		//Verifying Email Preference delete Pop Up Is Displayed
		EP.VerifyEmailPreferenceDeletePupIsDisplayed2(driver);
		chiledTest.log(Status.INFO, "Email Preference delete Pop Up Is Displayed");

		//Clicking on the Close Button
		driver.findElement(By.xpath("//a[@class='close']")).click();
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		EP.VerifyEmailPreferencePageisDispalyed(driver);
		

		System.out.println("****************************************************************");

	}

}

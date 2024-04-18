package scripts;


import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.ConfigureExecutionCountPageTest;
import pom.LoginPageTest;

public class ConfigureExecutionCountPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Configure Execution Page
	@Test(priority=40)
	public void Configure_Execution_Count_List_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureExecutionCountPageTest CE = new ConfigureExecutionCountPageTest(driver);

		parentTest = extent.createTest("Configure Execution Count Functionality Test", "Testing the Configure Execution Count  List, Edit Configure Execution Count Test");

		chiledTest = parentTest.createNode("Configure Execution Count Functionality Test");

		System.out.println("Configure Execution Count Functionality Test");

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

		//Clicking on the Scroll Bar
		CE.ClickScrollBar(driver);
		
		//Clicking on the System Settings
		CE.ClickSystemSettings(driver);
		chiledTest.log(Status.INFO, "System Settings is Clicked");	
		
		//Clicking on the Configure Execution Count
		CE.ClickConfigureExecutionCount(driver);
		chiledTest.log(Status.INFO, "Configure Execution is Clicked");

		//Verifying the Configure Execution count
		CE.VerifyConfigureExecutionCountPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Configure Execution count page is Displayed");

		System.out.println("****************************************************************************");
	}

	//Testing the Functionality of the Configure Execution Page
	@Test(priority=41)
	public void Configure_Execution_Count_Edit_Test() throws InterruptedException
	{

		ConfigureExecutionCountPageTest CE = new ConfigureExecutionCountPageTest(driver);

		chiledTest = parentTest.createNode("Configure Execution Count Edit Test");

		System.out.println("Configure Execution Count Edit Test");

		//Passing the Values to Search Text Field
		String SB = Lib.getCellValue(XLPATH, "System Settings", 3, 0);
		CE.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Max. Execution Counts is Searched");

		//Clicking on the Edit Icon
		CE.ClickEditBTN(driver);
		chiledTest.log(Status.INFO, "Edit Button is Clicked");

		//Clicking on the Cancel Button
		CE.ClickCancelBTN(driver);
		
		driver.navigate().refresh();

		//Verifying the Configure Execution count
		CE.VerifyConfigureExecutionCountPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Configure Execution count page is Displayed");

		//Clicking on the Edit Icon
		CE.ClickEditBTN(driver);
		chiledTest.log(Status.INFO, "Edit Button is Clicked");

		//Verifying Edit System Setting Page is Displayed
		CE.VerifyEditSystemSettingPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Edit System Setting Page is Displayed");

		//Passing the Values to Search Text Field
		String US = Lib.getCellValue(XLPATH, "System Settings", 7, 0);
		CE.SetUpdateSearchBTN(US);
		chiledTest.log(Status.INFO, "Max. Execution Counts is Entered");

		//Click Save Button
		CE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verify Settings updated successfully Success Message is Displayed
		CE.VerifySettingUpdatedSuccessfully(driver);
		chiledTest.log(Status.INFO, "Settings updated successfuly. Success Message is Displayed" );

	}
}

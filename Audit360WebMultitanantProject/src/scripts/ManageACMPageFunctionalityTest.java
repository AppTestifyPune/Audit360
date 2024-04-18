package scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.ManageACMPageTest;

public class ManageACMPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Manage ACM Page
	@Test(priority=66, enabled=false)
	public void Manage_ACM_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ManageACMPageTest MA = new ManageACMPageTest(driver);

		parentTest = extent.createTest("Manage ACM Page Test", "Testing the Functionality Management ACM Page, Adding ACM Etc..");

		chiledTest = parentTest.createNode("Manage ACM Page Test");

		System.out.println("Manage ACM Page Test");

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

		MA.ClickScrollBar(driver);

		//Clicking on the Role Managemenet
		MA.ClickRoleManagement(driver);
		chiledTest.log(Status.INFO, "Role Management is Clicked");

		//Clicking on the Manage ACM 
		MA.ClickManageACM(driver);
		chiledTest.log(Status.INFO, "Manage ACM is Clicked");

		//Verifying Manage Role Page is Displayed
		MA.VerifyManageACMPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Manage ACM Page is Displayed");

		System.out.println("********************************************************");


	}

	//Testing the Functionality of the Auditor Role
	@Test(priority=67, enabled=false)
	public void Auditor_Role_Test() throws InterruptedException
	{
		ManageACMPageTest MA = new ManageACMPageTest(driver);

		chiledTest = parentTest.createNode("Auditor Role Test");

		System.out.println("Auditor Role Test");

		//Clicking on the Select Role
		MA.ClickSelectRole();

		//Passing the Auditor to Select Role
		String SR = Lib.getCellValue(XLPATH, "Manage ACM", 3, 0);
		MA.SetSelectRole(SR);
		chiledTest.log(Status.INFO, "Auditor Role is Selected");

		//Clicking on the Matched text
		MA.ClickMatched();

		//Checking Auditor role and Check Box are Enabled or not
		MA.VerifyAuditorRoleIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Roles and Check Box are Enabled");

		System.out.println("********************************************************");

	}

	//Testing the Functionality of the Auditee Role
	@Test(priority=68, enabled=false)
	public void Auditee_Role_Test() throws InterruptedException
	{
		ManageACMPageTest MA = new ManageACMPageTest(driver);

		chiledTest = parentTest.createNode("Auditee Role Test");

		System.out.println("Auditee Role Test");

		driver.navigate().refresh();

		//Clicking on the Select Role
		MA.ClickSelectRole();

		//Passing the Auditor to Select Role
		String SR = Lib.getCellValue(XLPATH, "Manage ACM", 4, 0);
		MA.SetSelectRole(SR);
		chiledTest.log(Status.INFO, "Auditee Role is Selected");

		//Clicking on the Matched text
		MA.ClickMatched();

		//Checking Auditor role and Check Box are Enabled or not
		MA.VerifyAuditeeRoleIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Roles and Check Box are Enabled");

		System.out.println("********************************************************");

	}

	//Testing the Functionality of the Reviewer Role
	@Test(priority=69, enabled=false)
	public void Reviewer_Role_Test() throws InterruptedException
	{
		ManageACMPageTest MA = new ManageACMPageTest(driver);

		chiledTest = parentTest.createNode("Reviewer Role Test");

		System.out.println("Reviewer Role Test");

		driver.navigate().refresh();

		//Clicking on the Select Role
		MA.ClickSelectRole();

		//Passing the Auditor to Select Role
		String SR = Lib.getCellValue(XLPATH, "Manage ACM", 5, 0);
		MA.SetSelectRole(SR);
		chiledTest.log(Status.INFO, "Auditee Role is Selected");

		//Clicking on the Matched text
		MA.ClickMatched();

		//Checking Auditor role and Check Box are Enabled or not
		MA.VerifyReviewerRoleIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Roles and Check Box are Enabled");

		System.out.println("********************************************************");

	}

	//Testing the Functionality of the Respondent Role
	@Test(priority=70, enabled=false)
	public void Respondent_Role_Test() throws InterruptedException
	{
		ManageACMPageTest MA = new ManageACMPageTest(driver);

		chiledTest = parentTest.createNode("Respondent Role Test");

		System.out.println("Respondent Role Test");

		driver.navigate().refresh();

		//Clicking on the Select Role
		MA.ClickSelectRole();

		//Passing the Auditor to Select Role
		String SR = Lib.getCellValue(XLPATH, "Manage ACM", 6, 0);
		MA.SetSelectRole(SR);
		chiledTest.log(Status.INFO, "Auditee Role is Selected");

		//Clicking on the Matched text
		MA.ClickMatched();

		//Checking Auditor role and Check Box are Enabled or not
		MA.VerifyRespondentRoleIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Roles and Check Box are Enabled");

		System.out.println("********************************************************");

	}


	//Testing the Functionality of the SuperAdmin Role
	@Test(priority=71, enabled=false)
	public void SuperAdmin_Role_Test() throws InterruptedException
	{
		ManageACMPageTest MA = new ManageACMPageTest(driver);

		chiledTest = parentTest.createNode("SuperAdmin Role Test");

		System.out.println("SuperAdmin Role Test");

		driver.navigate().refresh();

		//Clicking on the Select Role
		MA.ClickSelectRole();

		//Passing the Auditor to Select Role
		String SR = Lib.getCellValue(XLPATH, "Manage ACM", 7, 0);
		MA.SetSelectRole(SR);
		chiledTest.log(Status.INFO, "Auditee Role is Selected");

		//Clicking on the Matched text
		MA.ClickMatched();

		//Checking Auditor role and Check Box are Enabled or not
		MA.VerifySuperAdminRoleIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Roles and Check Box are Enabled");

		System.out.println("********************************************************");

	}

	//Testing the Functionality of the New Role
	@Test(priority=72, enabled=false)
	public void New_Role_Test() throws InterruptedException
	{
		ManageACMPageTest MA = new ManageACMPageTest(driver);

		chiledTest = parentTest.createNode("New Role Test");

		System.out.println("New Role Test");

		driver.navigate().refresh();

		//Clicking on the Select Role
		MA.ClickSelectRole();

		//Passing the Auditor to Select Role
		String SR = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		MA.SetSelectRole(SR);
		chiledTest.log(Status.INFO, "Newly Created Role is Selected");

		//Clicking on the Matched text
		MA.ClickMatched();

		//Checking Auditor role and Check Box are Enabled or not
		MA.VerifyNewlyCreatedRoleIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Roles and Check Box are Enabled");

		//Clicking on the Check Box
		List<WebElement> CheckBox = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@type='checkbox']"));
		int count = CheckBox.size();
		System.out.println("Total Number of Check Box are : " + count);
		for(int i=0; i<count; i++)
		{
			WebElement All = CheckBox.get(i);
			All.click();
		}

		//Clicking on the Submit Button
		MA.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Updated role permissions successfully Success Message is Displayed
		MA.VerifyUpdatedRolePermissionsSuccessfully(driver);
		chiledTest.log(Status.INFO, "Updated role permissions successfully Success Message is Displayed");

		//Clikcing on the Select Role
		MA.ClickSelectRole();

		//Passing the Auditor to Select Role
		String SR1 = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		MA.SetSelectRole(SR1);
		chiledTest.log(Status.INFO, "Newly Created Role is Selected");

		//Clicking on the Matched text
		MA.ClickMatched();

		List<WebElement> CheckBoxCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@checked='checked']"));
		int CheckBoxTotalcount = CheckBoxCount.size();
		System.out.println("Total Check Box Count is : " + CheckBoxTotalcount);
		Assert.assertTrue(CheckBoxTotalcount>1);


		System.out.println("********************************************************");

	}


}

package scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditExecutionPageTest;
import pom.LoginPageTest;
import pom.SideMenuPageTest;
import pom.SwitchRolePageTest;

public class SwitchRolePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Switch Role
	@Test(priority=1)
	public void Switch_Role_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		SwitchRolePageTest SR = new SwitchRolePageTest(driver);

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		parentTest = extent.createTest("Switch Role Test", "Testing the Functionality of the Switch Role");

		chiledTest = parentTest.createNode("Switch Role Test");

		System.out.println("Switch Role Test");

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

		/*System.out.println("*****Auditee Switch Role Test****");

		chiledTest.log(Status.INFO, "*****Auditee Switch Role Test****");

		//Clicking on the Switch Role
		SR.ClickSwitchRole();

		//Passing the Values to Switch Roles
		String PR = Lib.getCellValue(XLPATH, "Switch Role", 3, 0);
		SR.SetSwitchRole(PR);
		chiledTest.log(Status.INFO, "Auditee is Selected under Switch Role");

		SR.ClickMatched();

		//Clicking on the Scroll Bar
		SM.ClickScrollBar();

		//Validating All Side Menu items are Displayed post Switching the Role to Auditee
		SM.VerifyAuditeeRoleSideMenuItemsAreDisplayed();*/

		System.out.println("******Auditee Reviewer Switch Role Test******");

		System.out.println("*****Auditee Reviewer Switch Role Test****");

		chiledTest.log(Status.INFO, "*****Auditee Reviewer Switch Role Test****");

		//Clicking on the Switch Role
		SR.ClickSwitchRole();

		//Passing the Values to Switch Roles
		String PR1 = Lib.getCellValue(XLPATH, "Switch Role", 5, 0);
		SR.SetSwitchRole(PR1);
		chiledTest.log(Status.INFO, "Auditee Reviewer is Selected under Switch Role");

		SR.ClickMatched();

		//Clicking on the Scroll Bar
		SM.ClickScrollBar();

		//Validating All Side Menu items are Displayed post Switching the Role to Auditee Reviewer
		SM.VerifyAuditeeReviewerRoleSideMenuItemsAreDisplayed();

		System.out.println("****************************");

		System.out.println("*****Auditee Respondent Switch Role Test****");

		chiledTest.log(Status.INFO, "*****Auditee Respondent Switch Role Test****");

		//Clicking on the Switch Role
		SR.ClickSwitchRole();

		//Passing the Values to Switch Roles
		String PR2 = Lib.getCellValue(XLPATH, "Switch Role", 4, 0);
		SR.SetSwitchRole(PR2);
		chiledTest.log(Status.INFO, "Auditee Respondent is Selected under Switch Role");

		SR.ClickMatched();

		//Clicking on the Scroll Bar
		SM.ClickScrollBar();

		//Validating All Side Menu items are Displayed post Switching the Role to Auditee Respondent
		SM.VerifyAuditeeRespondentRoleSideMenuItemsAreDisplayed();


		System.out.println("*********************************");

		System.out.println("*****Auditor Switch Role Test****");

		chiledTest.log(Status.INFO, "*****Auditor Switch Role Test****");

		//Clicking on the Switch Role
		SR.ClickSwitchRole();

		//Passing the Values to Switch Roles
		String PR3 = Lib.getCellValue(XLPATH, "Switch Role", 2, 0);
		SR.SetSwitchRole(PR3);
		chiledTest.log(Status.INFO, "Auditor is Selected under Switch Role");

		SR.ClickMatched();

		//Validating All Side Menu items are Displayed post Switching the Role to Auditor
		AE.VerifyAuditExecutionPageIsDisplayed(driver);

		System.out.println("*********************************");

		System.out.println("*****Super admin Switch Role Test****");

		chiledTest.log(Status.INFO, "*****Super admin Switch Role Test****");

		//Clicking on the Switch Role
		SR.ClickSwitchRole();

		//Passing the Values to Switch Roles
		String PR4 = Lib.getCellValue(XLPATH, "Switch Role", 1, 0);
		SR.SetSwitchRole(PR4);
		chiledTest.log(Status.INFO, "Super admin is Selected under Switch Role");

		SR.ClickMatched();

		//Clicking on the Scroll Bar
		SM.ClickScrollBar();

		Thread.sleep(3000);
		SM.VerifySuperadminSideMenuItemsAreDisplayed();

		
		System.out.println("*********************************");

	}

}

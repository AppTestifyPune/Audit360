package scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;
import pom.AnnexurePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.LoginPageTest;
import pom.SideMenuPageTest;

public class AuditeeadminConfigurationFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Annexure Page Test
	@Test(priority=1)
	public void Auditee_Admin_Configuration_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		parentTest = extent.createTest("Auditee Admin Configuration Functionality Test", "Testing the Functionality of the Auditee Admin Configuration Etc..");

		chiledTest = parentTest.createNode("Auditee Admin Configuration Page Test");

		System.out.println("Auditee Admin Configuration Page Test");

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

		//clicking on the Scroll bar
		SM.ClickScrollBar();

		//clicking on the Configure audit
		SM.ClickConfigureAudit();

		//clicking on the Audoitee admin Cnfigure under side menu
		SM.clickAuditeeAdminConfigure();

		System.out.println("*******************************************");

	}

	//Testing the Functionality of the Annexure Page Test
	@Test(priority=2, enabled=false)
	public void Auditee_Admin_Configuration_Test() throws InterruptedException
	{
		AuditeeadminConfigurationPageTest AA = new AuditeeadminConfigurationPageTest(driver);

		chiledTest = parentTest.createNode("Auditee Admin Configuration Test");

		System.out.println("Auditee Admin Configuration Test");

		AA.ClickSelectAuditType();

		//passing the values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		AA.SetSetAuditType(SA);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 3, 0);
		AA.SetIssueAssignment(IA);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA1 = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 4, 0);
		AA.SetIssueAssignment(IA1);

		AA.ClickMatchedText();

		//Passing the Values to Respond issue
		String RI = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 3, 1);
		AA.SetRespondIssue(RI);

		AA.ClickMatchedText();
		
		//clicking on the Save button
		AA.ClickSaveBTN();
		
		//Verifying Auditee configuration successfully done message is Displayed
		AA.VerifyAuditeeConfigurationSuccessfullyDoneMsGIsDisplayed();

		System.out.println("******************************");

	}



}

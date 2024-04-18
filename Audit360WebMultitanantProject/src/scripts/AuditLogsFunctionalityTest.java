package scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditLogsPageTest;
import pom.LoginPageTest;
import pom.SideMenuPageTest;

public class AuditLogsFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Configure Audit page
	@Test(priority=1)
	public void Audit_Logs_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		AuditLogsPageTest AL = new AuditLogsPageTest(driver);

		parentTest = extent.createTest("Audit Logs Functionality Test", "Testing the Functionality of the Audit Logs");

		chiledTest = parentTest.createNode("Audit Logs Page Test");

		System.out.println("Audit Logs Page Test");

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

		//clicking on the audit logs
		SM.ClickAuditLogs();

		//verifying Audit Log page details are showing in grid
		AL.VerifyAuditLogsPageDetailsAreDisplayed();

		System.out.println("***************************");

	}

	//Testing the Functionality of the Configure Audit page
	@Test(priority=2)
	public void Audit_Logs_Mandatory_Field_Test() throws InterruptedException
	{	
		AuditLogsPageTest AL = new AuditLogsPageTest(driver);

		chiledTest = parentTest.createNode("Audit Logs Mandatory Field Test");

		System.out.println("Audit Logs Mandatory Field Test");

		//clicking on the Go Button
		AL.ClickGoButton();

		//verifying please select all filed pop up is displayed
		AL.VerifyPleaseSelectAllFieldsPopUpIsDisplayed();

		System.out.println("***************************");
	}

	//Testing the Functionality of the Configure Audit page
	@Test(priority=3)
	public void Audit_Logs_Search_Test() throws InterruptedException
	{	
		AuditLogsPageTest AL = new AuditLogsPageTest(driver);

		chiledTest = parentTest.createNode("Audit Logs Search Test");

		System.out.println("Audit Logs Search Test");

		AL.ClickAuditLogsHeader();

		//Passing the values to Start date
		String SD = Lib.getCellValue(XLPATH, "Audit Logs", 1, 0);
		AL.SetStartDate(SD);

		//Passing the values to To date
		String ST = Lib.getCellValue(XLPATH, "Audit Logs", 1, 1);
		AL.SetEndDate(ST);

		//clicking on the Role Name
		AL.ClickRoleName();

		//passing the values to role name
		String SR = Lib.getCellValue(XLPATH, "Audit Logs", 1, 2);
		AL.SetRoleName(SR);

		AL.ClickMatchedText();

		AL.ClickUserName();

		//Passing the Values to Name
		String UN = Lib.getCellValue(XLPATH, "Audit Logs", 1, 3);
		AL.SetUserName(UN);

		AL.ClickMatchedText();

		//clicking on the Go Button
		AL.ClickGoButton();

		//verifying Logs is displayed
		AL.VerifyLogsAreDisplayed();

		//clicking on the Download Log button
		AL.ClickDownloadButton();

		System.out.println("***************************");
	}

}

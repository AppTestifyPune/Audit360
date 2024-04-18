package scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.TemplatesPageTest;

public class TemplatesPageFunctionalityTest extends BaseTest {


	//Testing the Functionality of the Templates Page
	@Test(priority=46)
	public void Template_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		TemplatesPageTest TP = new TemplatesPageTest(driver);

		parentTest = extent.createTest("Templates Functionality Test", "Testing the Template Page, Uplaod Document Test");

		chiledTest = parentTest.createNode("Template Page Functionality Test");

		System.out.println("Template Page Functionality Test");

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

		//Clikcing on the Scroll Bar
		TP.ClickScrollBar(driver);
		
		//Clicking on the system Settings
		TP.ClickSystemAndSettings(driver);
		chiledTest.log(Status.INFO, "System Settings is Clicked");

		//Clicking on the Templates under System Settings
		TP.ClickTemplates(driver);
		chiledTest.log(Status.INFO, "Templates is Clicked");

		//Verifying Templates Page is Displayed
		TP.VerifyTemplatePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Templates Page is Displayed");

		System.out.println("*********************************************************");
	}

	//Testing the Functionality of the Download Templates
	@Test(priority=47)   
	public void Download_Templates_Test() throws InterruptedException
	{
		TemplatesPageTest TP = new TemplatesPageTest(driver);

		chiledTest = parentTest.createNode("Download Template Functionality Test");

		System.out.println("Download Template Functionality Test");

		//Clicking on Cluster Template
		TP.ClickClusterTemplate();
		chiledTest.log(Status.INFO, "Cluster Template is Clicked");
		chiledTest.log(Status.INFO, "Cluster Template is Downloaded");

		//Clicking on the Auditor Template
		TP.ClickAuditorTemplate();
		chiledTest.log(Status.INFO, "Auditor Template is Clicked");

		chiledTest.log(Status.INFO, "Auditor Template is Downloaded");

		//Clicking on the Auditee Template
		TP.ClickAuditeeTemplate();
		chiledTest.log(Status.INFO, "Auditee Template is Clicked");

		chiledTest.log(Status.INFO, "Auditee Template is Downloaded");

		//Clicking on the Schedule Template
		TP.ClickscheduleTemplate();
		chiledTest.log(Status.INFO, "Schedule Template is Clicked");

		chiledTest.log(Status.INFO, "Schedule Template is Downloaded");

		//Clicking on the Auditee User Template
		TP.ClickAuditeeUserTemplate();
		chiledTest.log(Status.INFO, "Auditee User Template is Clicked");

		chiledTest.log(Status.INFO, "Auditee User Template is Downloaded");

		//Clicking on the Checkpoint Template
		TP.ClickCheckpointTemplate();
		chiledTest.log(Status.INFO, "Checkpoint Template is Clicked");

		chiledTest.log(Status.INFO, "Checkpoint User Template is Downloaded");

		System.out.println("*********************************************************");

	}

	//Testing the Functionality of the Uploading Different Document
	@Test(priority=48, enabled = false)
	public void Uploading_Different_Format_Document_Test() throws InterruptedException
	{
		TemplatesPageTest TP = new TemplatesPageTest(driver);

		chiledTest = parentTest.createNode("Uploading Diffrenet Format Document Functionality Test");

		System.out.println("Uploading Diffrenet Format Document Functionality Test");

		//Clicking on the Select Document type
		TP.ClickSelectDocType();

		//Clicking on the Auditte Document under Select Document Type
		TP.ClickAuditeeDocument();
		chiledTest.log(Status.INFO, "Auditee Document Option is Selected");

		
		
		//Clicking on the Upload Document Button
		TP.ClickUploadDocumentButton();

		//Verifying the Not a valid file format Error Message is Displayed
		TP.VerifyNotValidFileFormatErrorMessage(driver);
		chiledTest.log(Status.INFO, "Not a valid file format Error Message is Displayed");
		
		System.out.println("*********************************************************");


	}

}

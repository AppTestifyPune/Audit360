package scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.TemplatesPageTest;

public class AuditeeReviewerTemplateFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Configure Audit page
	@Test(priority=1)
	public void Auditee_Reviewer_Upload_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		parentTest = extent.createTest("Auditee Reviewer Upload Functionality Test", "Testing the Functionality of the Auditee Reviewer Upload");

		chiledTest = parentTest.createNode("Auditee Reviewer Upload Functionality Test");

		System.out.println("Auditee Reviewer Functionality Test");

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

		TemplatesPageTest TP = new TemplatesPageTest(driver);

		//clicking on the Scroll bar
		TP.ClickScrollBar(driver);

		//clicking on the System and Setting menu item
		TP.ClickSystemAndSettings(driver);

		//clicking on the Templates
		TP.ClickTemplates(driver);

		//clicking on the Select Document Type
		TP.ClickSelectDocType();

		//passing the Values to Document Type
		String DT = Lib.getCellValue(XLPATH, "Template", 7, 0);
		TP.SetSelectDocumnetType(DT);

		TP.ClickMatched();

		//Uploading the Auditee Reviewer Documents
		TP.UploadAuditeeReviewerDocument();

		//Upload documents button is clicked
		TP.ClickUploadDocumentButton();

		//Verifying Document saved successfully message is displayed
		TP.VerifyDocumentSavedSuccessfullyMSGIsDisplayed(driver);


		System.out.println("**************************");

	}

}

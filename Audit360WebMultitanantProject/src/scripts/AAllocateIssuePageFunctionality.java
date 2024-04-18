package scripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;
import pom.AllocateIssuesPageTes;
import pom.LoginPageTest;


public class AAllocateIssuePageFunctionality extends BaseTest
{
	@Test(priority =01)
	public void Allocate_Issues_Page_Test() throws InterruptedException{

		parentTest = extent.createTest("Allocate Issues Functionality Test", "Testing the Functionality Search, Allocating Issues to Reviewer and Respondent Etc..");
 
		chiledTest = parentTest.createNode("Allocate Issue Pages Test");

		System.out.println("Allocate Issues Page Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		LoginPageTest l= new LoginPageTest(driver);

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",52,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",52,1);

		l.setusername(un);
		//Taking the Password from 'TestValidLoginPage' sheet in excel

		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		System.out.println("*************************************************");
		
	}

  

}

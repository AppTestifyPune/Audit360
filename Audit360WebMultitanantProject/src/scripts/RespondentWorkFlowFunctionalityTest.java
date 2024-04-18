package scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.RespondentWorkFlowTest;

public class RespondentWorkFlowFunctionalityTest extends BaseTest {

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority = 585) 
	public void Issues_Page_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		RespondentWorkFlowTest RW = new RespondentWorkFlowTest(driver);

		parentTest = extent.createTest("Respondent User Work Flow Functionality Test", "Testing the Functionality Search, Respond Issues Etc..");

		chiledTest = parentTest.createNode("Issue Page Test");

		System.out.println("Issue Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",60,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",60,1);

		l.setusername(un);
		//Taking the Password from 'TestValidLoginPage' sheet in excel

		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		RW.VerifyIssuesPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issue Page is Displayed");

		System.out.println("*************************************************");

	}

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority = 586) 
	public void Respond_Issue_Test() throws InterruptedException{

		RespondentWorkFlowTest RW = new RespondentWorkFlowTest(driver);

		chiledTest = parentTest.createNode("Respond Issue Test");

		System.out.println("Respond Issue Test");

		SoftAssert softassertion = new SoftAssert();

		//Passing the Values to Select Parent Audit Type
		String SPA = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		RW.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Selected");

		RW.ClickMatched();

		//Selecting the 100 under Pagination 
		RW.ClickPagination(driver);

		//Checking the Total Issues Count
		List<WebElement> ToatlCount = driver.findElements(By.xpath("//table[@id='tableWithSearch']/tbody/tr"));
		int Actual_Count = ToatlCount.size();
		int Expected_Count = 2;
		softassertion.assertEquals(Actual_Count, Expected_Count, "Not Allocated Issues are also Displaying");

		//************ Resloving the Issues of General Group Audit type *********

		//Passing the Genral Audit type to Search text Box
		String SS = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0);
		RW.setSearchBox(SS, driver);
		chiledTest.log(Status.INFO, "General Group Audit type is searched");

		//Clicking on the First View Button
		RW.ClickFirstViewBTN(driver);

		//Checking the Issue Status
		RW.VerifyInProgressstatusIsDisplayed(driver);
		chiledTest.log(Status.INFO, "In Progress status is Displayed");

		//Verifying the Comments is Required field or not
		List<WebElement> Comments = driver.findElements(By.xpath("//textarea[@id='issue_issue_comments_attributes_0_description'][@required='required']"));
		softassertion.assertFalse(Comments.size()<0, "Comments is Not Working as Required Field");

		//Passing the values to Comments
		String SC = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		RW.SetComments(SC);
		chiledTest.log(Status.INFO, "Comments is Entered");

		//Upload Document 
		RW.UploadDocumnet(driver);
		chiledTest.log(Status.INFO, "Document is Uploaded");

		//Clicking on the Reslove Issues Button
		RW.ClickRespondIssueBTN(driver);
		chiledTest.log(Status.INFO, "Respond Issues Button is Clicked");

		//Checking Issues Updated SuccessFully Message is Displayed
		RW.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issues Updated SuccessFully Message is Displayed");

		//Clicking on the 2nd View Button
		RW.ClickSecondViewBTN(driver);

		//Checking the Issue Status
		RW.VerifyInProgressstatusIsDisplayed(driver);
		chiledTest.log(Status.INFO, "In Progress status is Displayed");

		//Verifying the Comments is Required field or not
		List<WebElement> Comments1 = driver.findElements(By.xpath("//textarea[@id='issue_issue_comments_attributes_0_description'][@required='required']"));
		softassertion.assertFalse(Comments1.size()<0, "Comments is Not Working as Required Field");

		//Passing the values to Comments
		String SC1 = Lib.getCellValue(XLPATH, "Issues", 39, 0);
		RW.SetComments(SC1);
		chiledTest.log(Status.INFO, "Comments is Entered");

		//Upload Document 
		RW.UploadDocumnet(driver);
		chiledTest.log(Status.INFO, "Document is Uploaded");

		//Clicking on the Reslove Issues Button
		RW.ClickRespondIssueBTN(driver);
		chiledTest.log(Status.INFO, "Respond Issues Button is Clicked");

		//Checking Issues Updated SuccessFully Message is Displayed
		RW.VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issues Updated SuccessFully Message is Displayed");
		
		System.out.println("****************************************");

		softassertion.assertAll();

	}


}

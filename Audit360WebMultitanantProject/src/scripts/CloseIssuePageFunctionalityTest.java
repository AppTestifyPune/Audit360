package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;
import pom.CloseIssuePageTest;
import pom.IssuesPageTest;
import pom.LoginPageTest;

public class CloseIssuePageFunctionalityTest extends BaseTest {

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority = 670) 
	public void Issues_Page_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		CloseIssuePageTest CS = new CloseIssuePageTest(driver);

		parentTest = extent.createTest("Close Functionality Test", "Testing the Functionality Search, Close/Reopen Issues Etc..");

		chiledTest = parentTest.createNode("Issue Page Test");

		System.out.println("Issue Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un);
		//Taking the Password from 'TestValidLoginPage' sheet in excel

		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		CS.ClickScrollBar(driver);

		CS.ClickIssues(driver);

		CS.VerifyIssuesPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Issue Page Is Displayed");


		System.out.println("*************************************************");

	}

	//Testing Functionality of the Close Issue Test
	@Test(priority = 671) 
	public void Close_Issues_Test() throws InterruptedException
	{

		chiledTest = parentTest.createNode("Close Issues Test");

		System.out.println("Close Issues Test");
		
		chiledTest.log(Status.INFO, "Close Issues Test");
		
		CloseIssuePageTest CS = new CloseIssuePageTest(driver);

		SoftAssert softassertion = new SoftAssert();

		//Passing the valid Data to Select Parent Audit Type
		String SPA = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		CS.SetSelectParentAuditType(SPA);
		chiledTest.log(Status.INFO, "Parent Audit Type is Searched");

		CS.ClickMatched();

		//Passing the Resloved Status to  Select Issue Status
		String SIS = Lib.getCellValue(XLPATH, "Issues", 50, 0);
		CS.SetSelectIssueStatus(SIS);
		chiledTest.log(Status.INFO, "Resolved status is Selected");

		CS.ClickMatched();

		//Selecting the 100 under Pagination 
		CS.ClickPagination(driver);

		Thread.sleep(2000);
		//Checking the Total Issues Count
		List<WebElement> ToatlCount = driver.findElements(By.xpath("//table[@id='issuesTableData']/tbody/tr"));
		int Actual_Count = ToatlCount.size();
		int Expected_Count = 12;
		softassertion.assertEquals(Actual_Count, Expected_Count, "Total Number of Issues count are Wrong");

		//Checking the 12 Resolved Status is Displayed or Not
		List<WebElement> Resolved = driver.findElements(By.xpath("//table[@id='issuesTableData']/tbody/tr/td[12]/span[text()='Resolved']"));
		int Actual_ResolvedCount = Resolved.size();
		int Expected_ResolvedCount = 10;
		softassertion.assertEquals(Actual_ResolvedCount, Expected_ResolvedCount, "Total 12 Resolved status Is Not Displayed");

		//************ Closing the Issues of Dynamic Audit Type*********

		//Passing the valid Data to Select Parent Audit Type
		String SPA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		CS.SetSelectParentAuditType(SPA1);
		chiledTest.log(Status.INFO, "Parent Audit Type is Searched");

		CS.ClickMatched();

		//Passing the Resloved Status to  Select Issue Status
		String SIS1 = Lib.getCellValue(XLPATH, "Issues", 50, 0);
		CS.SetSelectIssueStatus(SIS1);
		chiledTest.log(Status.INFO, "Resolved status is Selected");

		CS.ClickMatched();

		//Passing the Values to Search 
		String SS1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 7, 0);
		CS.setSearchBox(SS1, driver);

		//Clicking on the First TR
		CS.ClickFirstTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		//Clicking on the Second  TR
		CS.ClickSecondTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		//Clicking on the Thired TR
		CS.ClickThirdTRBTNViewBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		//Clicking on the Fourth TR
		CS.ClickFourthTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		/*//Clicking on the Fifth TR
		CS.ClickFifthTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");*/

		driver.navigate().refresh();

		//************ Closing the Issues of Static Audit Type*********

		//Passing the valid Data to Select Parent Audit Type
		String SPA2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		CS.SetSelectParentAuditType(SPA2);
		chiledTest.log(Status.INFO, "Parent Audit Type is Searched");

		CS.ClickMatched();

		//Passing the Resloved Status to  Select Issue Status
		String SIS2 = Lib.getCellValue(XLPATH, "Issues", 50, 0);
		CS.SetSelectIssueStatus(SIS2);
		chiledTest.log(Status.INFO, "Resolved status is Selected");

		CS.ClickMatched();

		//Passing the Values to Search 
		String SS2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 9, 0);
		CS.setSearchBox(SS2, driver);

		//Clicking on the First TR
		CS.ClickFirstTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		//Clicking on the Second  TR
		CS.ClickSecondTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		//Clicking on the Thired TR
		CS.ClickThirdTRBTNViewBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		//Clicking on the Fourth TR
		CS.ClickFourthTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		/*//Clicking on the Fifth TR
		CS.ClickFifthTRBTN(driver);

		//Clicking on the Close Button
		CS.ClickCloseIssueBTN(driver);
		chiledTest.log(Status.INFO, "Close Button is Clicked");*/

		System.out.println("*********************************************************");

		Assert.fail("Getting Audit compliance documents document data can't be blank, Audit compliance documents document can't be blank, Audit compliance documents base Not a valid file format Error Message");
		
		softassertion.assertAll();

	}


}

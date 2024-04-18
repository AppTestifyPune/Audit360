package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.SurveyResponsePageTest;

public class SurveyResponsePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Survey Response Page Test
	@Test(priority= 492)
	public void Survey_Response_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		SurveyResponsePageTest SR = new SurveyResponsePageTest(driver);

		parentTest = extent.createTest("Survey Response Page Test", "Testing the Functionality of Survey Response Page, Search Survery Response Etc..");

		chiledTest = parentTest.createNode("Survey Response Page Test");

		System.out.println("Survey Questions Page Test");

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

		SR.ClickScrollBar(driver);

		//Clicking on the Auditor Survey from side menu
		SR.ClickAuditorSurvey(driver);
		chiledTest.log(Status.INFO, "Auditor Survey is Clicked");

		//Clicking on the Survey Responses
		SR.ClickSurveryResponses(driver);
		chiledTest.log(Status.INFO, "Survey Responses is Clicked");

		//Verifying the Survey Responses page is displayed
		SR.VerifySuveryResponsesPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Survey Responses page is displayed");

		System.out.println("******************************************************************");


	}

	//Testing the Functionality of the Select Audit Type Serach 
	@Test(priority = 493)
	public void Select_Audit_Type_Search_Test() throws InterruptedException
	{

		SurveyResponsePageTest SR = new SurveyResponsePageTest(driver);

		chiledTest = parentTest.createNode("Select Audit Type Search Test");

		System.out.println("Select Audit Type Search Test");

		//Passing the Values to Select Audit Type
		String AT = Lib.getCellValue(XLPATH, "Survey Response", 3, 0);
		SR.SetSelectAuditType(AT);
		chiledTest.log(Status.INFO, "Valid Audit Type is Entered");

		SR.ClickMatched();

		//Passing the Values to Select Audit Type
		String AT1 = Lib.getCellValue(XLPATH, "Survey Response", 4, 0);
		SR.SetSelectAuditType(AT1);
		chiledTest.log(Status.INFO, "Valid Audit Type is Entered");

		SR.ClickMatched();

		//Passing the Values to Select Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "Survey Response", 5, 0);
		SR.SetSelectAuditType(AT2);
		chiledTest.log(Status.INFO, "Valid Audit Type is Entered");

		SR.ClickMatched();

		//Checking the Searched Audit Type is Displayed or Not
		SR.VerifyDataIsShownInGrid(driver);

		//Clicking on the Close Buttons
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement CloseBTNs = CloseBTN.get(i);
			CloseBTNs.click();
		}

		//Passing the Invalid Values to Select Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "Survey Response", 8, 0);
		SR.SetSelectAuditType(AT3);
		chiledTest.log(Status.INFO, "Invalid Audit Type is Entered");

		//Checking No Match Found Error Message is Displayed
		SR.VerifyNoMatchFoundIsDisplayed(driver);

		System.out.println("******************************************************************");

	}


	//Testing the Functionality of the Select Auditee Type Search 
	@Test(priority = 494)
	public void Select_Auditee_Search_Test() throws InterruptedException
	{

		SurveyResponsePageTest SR = new SurveyResponsePageTest(driver);

		chiledTest = parentTest.createNode("Select Auditee Search Test");

		System.out.println("Select Auditee Search Test");

		//Clicking on the Survey Response Header
		SR.ClickSuveryResponseHeader();

		//Passing the Values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "Survey Response", 12, 0);
		SR.SetSelectAuditee(SA);
		chiledTest.log(Status.INFO, "Valid Auditee is Entered");

		//Clicking on the Matched
		SR.ClickMatched();

		//Passing the Values to Select Audit Type
		String SA1 = Lib.getCellValue(XLPATH, "Survey Response", 13, 0);
		SR.SetSelectAuditee(SA1);
		chiledTest.log(Status.INFO, "Valid Auditee is Entered");

		//Clicking on the Matched
		SR.ClickMatched();

		//Checking the Searched Audit Type is Displayed or Not
		SR.VerifyDataIsShownInGrid(driver);

		//Clicking on the Close Buttons
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement CloseBTNs = CloseBTN.get(i);
			CloseBTNs.click();
		}

		//Passing the Values to Select Audit Type
		String SA2 = Lib.getCellValue(XLPATH, "Survey Response", 17, 0);
		SR.SetSelectAuditee(SA2);
		chiledTest.log(Status.INFO, "Valid Auditee is Entered");

		//Checking No Match Found Error Message is Displayed
		SR.VerifyNoMatchFoundIsDisplayed(driver);

		System.out.println("******************************************************************");

	}

	//Testing the Functionality of the Select Auditor Type Search 
	@Test(priority = 495)
	public void Select_Auditor_Search_Test() throws InterruptedException
	{

		SurveyResponsePageTest SR = new SurveyResponsePageTest(driver);

		chiledTest = parentTest.createNode("Select Auditor Search Test");

		System.out.println("Select Auditor Search Test");

		//Clicking on the Survey Response Header
		SR.ClickSuveryResponseHeader();

		//Passing the Values to Select Audit Type
		String SAA = Lib.getCellValue(XLPATH, "Survey Response", 22, 0);
		SR.SetSelectAuditor(SAA);
		chiledTest.log(Status.INFO, "Valid Auditor is Entered");

		//Clicking on the Matched
		SR.ClickMatched();

		//Passing the Values to Select Audit Type
		String SAA1 = Lib.getCellValue(XLPATH, "Survey Response", 23, 0);
		SR.SetSelectAuditor(SAA1);
		chiledTest.log(Status.INFO, "Valid Auditor is Entered");

		//Clicking on the Matched
		SR.ClickMatched();

		//Checking the Searched Audit Type is Displayed or Not
		SR.VerifyDataIsShownInGrid(driver);

		//Clicking on the Close Buttons
		List<WebElement> CloseBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		for(int i=0; i<CloseBTN.size(); i++)
		{
			WebElement CloseBTNs = CloseBTN.get(i);
			CloseBTNs.click();
		}


		//Passing the Invalid Values to Select Audit Type
		String SAA2 = Lib.getCellValue(XLPATH, "Survey Response", 28, 0);
		SR.SetSelectAuditor(SAA2);
		chiledTest.log(Status.INFO, "Invalid Auditor is Entered");

		//Checking No Match Found Error Message is Displayed
		SR.VerifyNoMatchFoundIsDisplayed(driver);

		System.out.println("******************************************************************");

	}


	//Testing the Functionality of the Select Auditee Type Search 
	@Test(priority = 496)
	public void Search_Functionality_Test() throws InterruptedException
	{

		SurveyResponsePageTest SR = new SurveyResponsePageTest(driver);

		chiledTest = parentTest.createNode("Search Functionality Test");

		System.out.println("Search Functionality Test");

		//Clicking on the SURVEY RESPONSE Header
		SR.ClickSuveryResponseHeader();

		//Passing the Valid Data to Search Text Box
		String SB = Lib.getCellValue(XLPATH, "Survey Response", 3, 0);
		SR.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Valid data is Enterd under Search Text Field");

		//Checking the Searched Audit Type is Displayed or Not
		SR.VerifyDataIsShownInGrid(driver);

		//Passing the invalid Data to Search Text Box
		String SB1 = Lib.getCellValue(XLPATH, "Survey Response", 8, 0);
		SR.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "Valid data is Enterd under Search Text Field");

		//Checking the Searched Audit Type is Displayed or Not
		SR.VerifyDataIsShownInGrid(driver);


		System.out.println("*********************************************************************");

	}
}

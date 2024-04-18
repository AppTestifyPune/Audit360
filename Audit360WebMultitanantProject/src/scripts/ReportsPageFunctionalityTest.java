package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.ReportsPageTest;
import pom.SideMenuPageTest;

public class ReportsPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Configure Audit page
	@Test(priority=1)
	public void Reports_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		parentTest = extent.createTest("Reports Functionality Test", "Testing the Reports Page..");

		chiledTest = parentTest.createNode("Reports Page Functionality Test");

		System.out.println("Reports Page Functionality Test");

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

		//Clicking on the scroll bar
		SM.ClickScrollBar();

		//clicking on the Reports under side menu
		SM.ClickReports();

		//clicking on the Basic reports under side menu
		SM.ClickBasicReports();

		//validating all reports links are displayed
		//RP.VerifyAllReportsLinkIsDisplayed();
	}

	//Testing the Functionality of the Configure Audit page
	@Test(priority=2, enabled=false)
	public void Monthly_Top_Five_Reports_Test() throws Exception
	{
		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Monthly Top 5 Reports Test");

		System.out.println("Monthly Top 5 Reports Test");

		//Clicking on the Monthly Top 5 Reports Test
		RP.ClickMonthlyTop5Issues();

		/*//Clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying the Please Select Proper date Range pop up is Displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//clicking on the Select Audit Type Drop down
		RP.ClickSelectAuditType();

		//Passing the Values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.SetSelectAuditType(SAT);

		RP.ClickMatchedText();

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//Clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Monthly Bottom 5 Reports Test
	@Test(priority=3, enabled=false)
	public void Monthly_Bottom_Five_Reports_Test() throws InterruptedException
	{
		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Monthly Bottom 5 Reports Test");

		System.out.println("Monthly Bottom 5 Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Monthly Bottom 5 Reports Test
		RP.ClickMonthlyBotton5Issues();

		/*//Clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying the Please Select Proper date Range pop up is Displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//clicking on the Select Audit Type Drop down
		RP.ClickSelectAuditType();

		//Passing the Values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.SetSelectAuditType(SAT);

		RP.ClickMatchedText();

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Monthly Top 5 Adherence Reports Test
	@Test(priority=4, enabled=false)
	public void Monthly_Top_Five_Adherence_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Monthly Top 5 Adherence Reports Test");

		System.out.println("Monthly Top 5 Adherence Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Monthly Bottom 5 Reports Test
		RP.ClickMonthlyTop5Adherence();

		/*//Clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying the Please Select Proper date Range pop up is Displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//clicking on the Select Audit Type Drop down
		RP.ClickSelectAuditType();

		//Passing the Values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.SetSelectAuditType(SAT);

		RP.ClickMatchedText();

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Monthly Bottom 5 Adherence Reports Test
	@Test(priority=5, enabled=false)
	public void Monthly_Bottom_Five_Adherence_Reports_Test() throws InterruptedException
	{
		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Monthly Bottom 5 Adherence Reports Test");

		System.out.println("Monthly Bottom 5 Adherence Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Monthly Bottom 5 Reports Test
		RP.ClickMonthlyBottom5Adherence();

		/*//Clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying the Please Select Proper date Range pop up is Displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//clicking on the Select Audit Type Drop down
		RP.ClickSelectAuditType();

		//Passing the Values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.SetSelectAuditType(SAT);

		RP.ClickMatchedText();

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Pie Chart Based On Issue Reports Test
	@Test(priority=6, enabled=false)
	public void Pie_Chart_Based_On_Issue_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Pie Chart Based On Issue Reports Test");

		System.out.println("Pie Chart Based On Issue Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Monthly Bottom 5 Reports Test
		RP.ClickPieChartBasedOnIssueStatus();

		//clicking on the Select Audit Type Drop down
		RP.ClickSelectAuditType();

		//Passing the Values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.SetSelectAuditType(SAT);

		RP.ClickMatchedText();

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Detailed Report With Audit Summary Reports Test
	@Test(priority=8)
	public void Detailed_Report_With_Audit_Summary_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Detailed Report With Audit Summary Reports Test");

		System.out.println("Detailed Report With Audit Summary Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Monthly Bottom 5 Reports Test
		RP.ClickDetailedReportWithAuditSummary();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Download Excel button
		RP.ClickDownloadExcelBTN();

		//Verifying Please select start data and end date Pop Up is displayed
		RP.VerifyPleaseSelectStartAndEndDatePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//Verifying Download Excel button is Displayed or not
		RP.verifyDownloadExcelButtonIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Detailed Report With Audit Issue Summary Reports Test
	@Test(priority=9)
	public void Detailed_Report_With_Audit_Issue_Summary_Reports_Test() throws InterruptedException
	{

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Detailed Report With Audit Issue Summary Reports Test");

		System.out.println("Detailed Report With Audit Issue Summary Reports Test");

		//clicking on the Home Button
		RP.ClickHome();

		//Clicking on the scroll bar
		SM.ClickScrollBar();

		//clicking on the Reports under side menu
		SM.ClickReports();

		//clicking on the Basic reports under side menu
		SM.ClickBasicReports();

		//Clicking on the Detailed Report With Audit Issue Summary Reports
		RP.ClickDetailedReportWithAuditIssueSummary();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Download Excel button
		RP.ClickDownloadExcelBTN();

		//Verifying Please select start data and end date Pop Up is displayed
		RP.VerifyPleaseSelectStartAndEndDatePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//Verifying Download Excel button is Displayed or not
		RP.verifyDownloadExcelButtonIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the List of Issues with Status Reports Test
	@Test(priority=10)
	public void List_Of_Issues_With_Status_Reports_Test() throws InterruptedException
	{

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("List of Issues with Status Reports Test");

		System.out.println("List of Issues with Status Reports Test");

		//clicking on the Home Button
		RP.ClickHome();

		//Clicking on the scroll bar
		SM.ClickScrollBar();

		//clicking on the Reports under side menu
		SM.ClickReports();

		//clicking on the Basic reports under side menu
		SM.ClickBasicReports();

		//Clicking on the List of Issues with Status Reports Test
		RP.ClickListOfIssuesWithStatus();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Download Excel button
		RP.ClickDownloadExcelBTN();

		//Verifying Please select start data and end date Pop Up is displayed
		RP.VerifyPleaseSelectStartAndEndDatePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//Verifying Download Excel button is Displayed or not
		RP.verifyDownloadExcelButtonIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Aging of Issues Reports Test
	@Test(priority=11)
	public void Aging_Of_Issues_Reports_Test() throws InterruptedException
	{

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Aging of Issues Reports Test");

		System.out.println("Aging of Issues Reports Test");

		//clicking on the Home Button
		RP.ClickHome();

		//Clicking on the scroll bar
		SM.ClickScrollBar();

		//clicking on the Reports under side menu
		SM.ClickReports();

		//clicking on the Basic reports under side menu
		SM.ClickBasicReports();

		//Clicking on the Aging of Issues link
		RP.ClickAgingOfIssues();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Download Excel button
		RP.ClickDownloadExcelBTN();

		//Verifying Please select start data and end date Pop Up is displayed
		RP.VerifyPleaseSelectStartAndEndDatePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//Verifying Download Excel button is Displayed or not
		RP.verifyDownloadExcelButtonIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Issue Status and Issue Types Reports Test
	@Test(priority=12, enabled=false)
	public void Issue_Status_And_Issue_Types_Reports_Test() throws InterruptedException
	{

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Issue Status and Issue Types Reports Test");

		System.out.println("Issue Status and Issue Types Reports Test");

		//clicking on the Home Button
		RP.ClickHome();

		//Clicking on the scroll bar
		SM.ClickScrollBar();

		//clicking on the Reports under side menu
		SM.ClickReports();

		//clicking on the Basic reports under side menu
		SM.ClickBasicReports();

		//Clicking on the Issue Status and Issue Types link
		RP.ClickIssueStatusAndIssueTypes();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the submit button
		RP.ClickSubmitBTN();

		//checking Please select the proper date range error message
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifySearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Audit Rating Counts Reports Test
	@Test(priority=13, enabled=false)
	public void Audit_Rating_Counts_Reports_Test() throws InterruptedException
	{

		SideMenuPageTest SM = new SideMenuPageTest(driver);

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Audit Rating Counts Reports Test");

		System.out.println("Audit Rating Counts Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Audit Rating Counts link
		RP.ClickAuditRatingCounts();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		WebElement OngoingAudits = driver.findElement(By.xpath("//div[text()='No. of Ongoing Audits - today']"));
		Assert.assertTrue(OngoingAudits.isDisplayed(), "No. of Ongoing Audits - today is Displayed");
		System.out.println("No. of Ongoing Audits - today is Displayed");

		WebElement RepeatIssue = driver.findElement(By.xpath("//div[text()='Repeat Issue - Current Month']"));
		Assert.assertTrue(RepeatIssue.isDisplayed(), "Repeat Issue - Current Month is Displayed");
		System.out.println("Repeat Issue - Current Month is Displayed");


		System.out.println("*************************");

	}

	//Testing the Functionality of the Pie Chart based on audit status Reports Test Reports Test
	@Test(priority=14, enabled=false)
	public void Pie_Chart_Based_On_Audit_Status_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Pie Chart based on audit status Reports Test");

		System.out.println("Pie Chart based on audit status Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Pie Chart based on audit status Link
		RP.ClickPieChartBasedOnAuditStatus();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Auditee Average Audit Rating Score Report Test
	@Test(priority=15, enabled=false)
	public void Auditee_Average_Audit_Rating_Score_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Auditee Average Audit Rating Score Reports Test");

		System.out.println("Auditee Average Audit Rating Score Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Auditee Average Audit Rating Score Link
		RP.ClickAuditeeAverageAuditRatingScore();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Submit button
		RP.ClickSubmitBTN();

		//checking the please select proper date range error pop up is displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Top 5 Auditees Report Test
	@Test(priority=16, enabled=false)
	public void Top_5_Auditees_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Top 5 Auditees Reports Test");

		System.out.println("Top 5 Auditees Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Top 5 Auditees Link
		RP.ClickTop5Auditees();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Submit button
		RP.ClickSubmitBTN();

		//checking the please select proper date range error pop up is displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Bottom 5 Auditees Report Test
	@Test(priority=17, enabled=false)
	public void Bottom_5_Auditees_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Bottom 5 Auditees Reports Test");

		System.out.println("Bottom 5 Auditees Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Bottom 5 Auditees Link
		RP.ClickBottom5Auditees();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Submit button
		RP.ClickSubmitBTN();

		//checking the please select proper date range error pop up is displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

	//Testing the Functionality of the Regionwise Groupwise Compliance Report Test
	@Test(priority=18, enabled=false)
	public void Regionwise_Groupwise_Compliance_Reports_Test() throws InterruptedException
	{

		ReportsPageTest RP = new ReportsPageTest(driver);

		chiledTest = parentTest.createNode("Regionwise Groupwise Compliance Reports Test");

		System.out.println("Regionwise Groupwise Compliance Reports Test");

		//clicking on the Reports Header
		RP.ClickReportsHeader();

		//Clicking on the Regionwise Groupwise Compliance Link
		RP.ClickRegionwiseGroupwiseCompliance();

		//Passing the Values to Select Audit Type
		String PS = Lib.getCellValue(XLPATH, "Reports", 3, 0);
		RP.PassingTheVlauesToSelectAuditType(PS);

		RP.ClickMatchedText();

		/*//clicking on the Submit button
		RP.ClickSubmitBTN();

		//checking the please select proper date range error pop up is displayed
		RP.VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed();*/

		//Passing the Values to From date
		String FD = Lib.getCellValue(XLPATH, "Reports", 3, 1);
		RP.SetFromDate(FD);

		//Passing the Values to To date
		String TD = Lib.getCellValue(XLPATH, "Reports", 3, 2);
		RP.SetToDate(TD);

		//clicking on the Submit Button
		RP.ClickSubmitBTN();

		//Verifying Searched Data is displayed or not
		RP.VerifyGraphicalReportsSearchedDataIsDisplayed();

		System.out.println("*************************");

	}

}
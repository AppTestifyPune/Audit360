package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class ReportsPageTest extends BaseTest {
	
	//clicking on the Home Button
	@FindBy(xpath="//a[text()='Home']")
	private WebElement Home;

	//clicking on the Reports
	@FindBy(xpath="//a[text()='REPORT']")
	private WebElement ReportsHeader;

	//clicking on the Monthly top 5 Reports
	@FindBy(xpath="//a[contains(text(),'Monthly Top 5 issues')]")
	private WebElement MonthlyTop5Issues;

	//clicking on the Monthly Bottom 5 Reports
	@FindBy(xpath="//a[contains(text(),'Monthly Bottom 5 issues')]")
	private WebElement MonthlyBottom5Issues;

	//clicking on the Monthly top 5 adherence
	@FindBy(xpath="//a[contains(text(),'Monthly Top 5 adherence')]")
	private WebElement MonthlyTop5adherence;

	//clicking on the Monthly Bottom 5 adherence
	@FindBy(xpath="//a[contains(text(),'Monthly Bottom 5 adherence')]")
	private WebElement MonthlyBottom5adherence;

	//clicking on the Pie Chart based on issue status
	@FindBy(xpath="//a[contains(text(),'Pie Chart based on issue status')]")
	private WebElement PieChartBasedOnIssueStatus;

	//clicking on the Detailed Report With Audit Summary
	@FindBy(xpath="//a[contains(text(),'Detailed Report With Audit Summary')]")
	private WebElement DetailedReportWithAuditSummary;

	//clicking on the Detailed Report With Audit Issue Summary
	@FindBy(xpath="//a[contains(text(),'Detailed Report With Audit Issue Summary')]")
	private WebElement DetailedReportWithAuditIssueSummary;

	//clicking on the List of Issues with Status
	@FindBy(xpath="//a[contains(text(),'List of Issues with Status')]")
	private WebElement ListOfIssuesWithStatus;

	//clicking on the Aging of Issues
	@FindBy(xpath="//a[contains(text(),'Aging of Issues')]")
	private WebElement AgingOfIssues;

	//clicking on the Issue Status and Issue Types
	@FindBy(xpath="//a[contains(text(),'Issue Status and Issue Types')]")
	private WebElement IssueStatusAndIssueTypes;

	//clicking on the Audit Rating Counts
	@FindBy(xpath="//a[contains(text(),'Audit Rating Counts')]")
	private WebElement AuditRatingCounts;

	//clicking on the Pie Chart based on audit status
	@FindBy(xpath="//a[contains(text(),'Pie Chart based on audit status')]")
	private WebElement PieChartBasedOnAuditStatus;

	//clicking on the Auditee Average Audit Rating Score
	@FindBy(xpath="//a[contains(text(),'Auditee Average Audit Rating Score')]")
	private WebElement AuditeeAverageAuditRatingScore;

	//clicking on the Top 5 Auditees
	@FindBy(xpath="//a[contains(text(),'Top 5 Auditees')]")
	private WebElement Top5Auditees;

	//clicking on the Bottom 5 Auditees
	@FindBy(xpath="//a[contains(text(),'Bottom 5 Auditees')]")
	private WebElement Bottom5Auditees;

	//clicking on the Regionwise Groupwise Compliance
	@FindBy(xpath="//a[contains(text(),'Regionwise Groupwise Compliance')]")
	private WebElement RegionwiseGroupwiseCompliance;

	//checking download Excel button is displayed
	@FindBy(xpath="//button[text()='Download']")
	private WebElement DownloadBTN;
	
	//clicking on the Submit Button
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement SubmitBTN;

	//clicking on the matched text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Select Audit Type
	@FindBy(xpath="//div[@id='s2id_audit_type_id']//span[text()='Select Audit Type']")
	private WebElement SAT;

	//Passing the Values to Select Audit Type
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//div[@class='select2-search']//input[@type='text']")
	private WebElement SetSelectAuditType;

	//passing the Values to From date//label[text()='Select From: ']/following-sibling::input[1]
	@FindBy(xpath="//input[@name='start_date']")
	private WebElement FromDate;

	//passing the Values to To date//label[text()=' To: ']/following-sibling::input[1]
	@FindBy(xpath="//input[@name='end_date']")
	private WebElement ToDate;

	
	

	public ReportsPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickHome()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Home);
	}

	public void ClickReportsHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReportsHeader);
		System.out.println("Reports Header is Clicked");
	}

	public void ClickMonthlyTop5Issues()
	{
		MonthlyTop5Issues.click();
		System.out.println("Monthly Top 5 Issue Report link is Clicked");
		chiledTest.log(Status.INFO, "Monthly Top 5 Issue Report link is Clicked");
	}

	public void ClickMonthlyBotton5Issues()
	{
		MonthlyBottom5Issues.click();
		System.out.println("Monthly Bottom 5 Issue Report link is Clicked");
		chiledTest.log(Status.INFO, "Monthly Bottom 5 Issue Report link is Clicked");
	}
	
	public void ClickMonthlyTop5Adherence()
	{
		MonthlyTop5adherence.click();
		System.out.println("Monthly Top 5 Adherence Report link is Clicked");
		chiledTest.log(Status.INFO, "Monthly Top 5 Adherence Report link is Clicked");
	}
	
	public void ClickMonthlyBottom5Adherence()
	{
		MonthlyBottom5adherence.click();
		System.out.println("Monthly Bottom 5 Adherence Report link is Clicked");
		chiledTest.log(Status.INFO, "Monthly Bottom 5 Adherence Report link is Clicked");
	}
	
	public void ClickPieChartBasedOnIssueStatus()
	{
		PieChartBasedOnIssueStatus.click();
		System.out.println("Pie Chart Based on Issue Status Report link is Clicked");
		chiledTest.log(Status.INFO, "Pie Chart Based on Issue Status Report link is Clicked");
	}
	
	public void ClickDetailedReportWithAuditSummary()
	{
		DetailedReportWithAuditSummary.click();
		System.out.println("Detailed Report With Audit Summary link is Clicked");
		chiledTest.log(Status.INFO, "Detailed Report With Audit Summary link is Clicked");
	}
	
	public void ClickDetailedReportWithAuditIssueSummary()
	{
		DetailedReportWithAuditIssueSummary.click();
		System.out.println("Detailed Report With Audit Issue Summary link is Clicked");
		chiledTest.log(Status.INFO, "Detailed Report With Audit Issue Summary link is Clicked");
	}
	
	public void ClickListOfIssuesWithStatus()
	{
		ListOfIssuesWithStatus.click();
		System.out.println("List of Issues with Status link is Clicked");
		chiledTest.log(Status.INFO, "List of Issues with Status link is Clicked");
	}
	
	public void ClickAgingOfIssues()
	{
		AgingOfIssues.click();
		System.out.println("Aging Of Issues link is Clicked");
		chiledTest.log(Status.INFO, "Aging Of Issues link is Clicked");
	}
	
	public void ClickIssueStatusAndIssueTypes()
	{
		IssueStatusAndIssueTypes.click();
		System.out.println("Issue Status and Issue Types link is Clicked");
		chiledTest.log(Status.INFO, "Issue Status and Issue Types link is Clicked");
	}
	
	public void ClickAuditRatingCounts()
	{
		AuditRatingCounts.click();
		System.out.println("Audit Rating Counts link is Clicked");
		chiledTest.log(Status.INFO, "Audit Rating Counts link is Clicked");
	}
	
	public void ClickPieChartBasedOnAuditStatus()
	{
		PieChartBasedOnAuditStatus.click();
		System.out.println("Pie Chart based on audit status link is Clicked");
		chiledTest.log(Status.INFO, "Pie Chart based on audit status is Clicked");
	}
	
	public void ClickAuditeeAverageAuditRatingScore()
	{
		AuditeeAverageAuditRatingScore.click();
		System.out.println("Auditee Average Audit Rating Score link is Clicked");
		chiledTest.log(Status.INFO, "Auditee Average Audit Rating Score is Clicked");
	}
	
	public void ClickTop5Auditees()
	{
		Top5Auditees.click();
		System.out.println("Top 5 Auditees link is Clicked");
		chiledTest.log(Status.INFO, "Top 5 Auditeese is Clicked");
	}
	
	public void ClickBottom5Auditees()
	{
		Bottom5Auditees.click();
		System.out.println("Bottom 5 Auditees link is Clicked");
		chiledTest.log(Status.INFO, "Bottom 5 Auditeese is Clicked");
	}
	
	
	public void ClickRegionwiseGroupwiseCompliance()
	{
		RegionwiseGroupwiseCompliance.click();
		System.out.println("Regionwise Groupwise Compliance link is Clicked");
		chiledTest.log(Status.INFO, "Regionwise Groupwise Compliance is Clicked");
	}
	
	public void PassingTheVlauesToSelectAuditType(String PS)
	{
		driver.findElement(By.xpath("//div[@id='s2id_audit_type_id']//input")).sendKeys(PS);
		System.out.println("Entered Audit Type Name is : " +PS);
		chiledTest.log(Status.INFO, "Audit Type Name is Searched");
	}

	public void ClickDownloadExcelBTN()
	{
		DownloadBTN.click();
		System.out.println("Download Excel Button is Clicked");
		chiledTest.log(Status.INFO, "Download Excel Button is Clicked");
	}
	
	public void verifyDownloadExcelButtonIsDisplayed()
	{
		Assert.assertTrue(DownloadBTN.isDisplayed(), "Download Excel Button is Not Displayed");
		System.out.println("Download Excel Button is Displayed");
		chiledTest.log(Status.INFO, "Download Excel Button is Displayed");
	}
	
	public void ClickMatchedText()
	{
		Matched.click();
	}

	public void ClickSelectAuditType()
	{
		SAT.click();
	}
	
	public void SetSelectAuditType(String SAT)
	{
		SetSelectAuditType.sendKeys(SAT);
		System.out.println("Entered Audit Type is : " + SAT);
		chiledTest.log(Status.INFO, "Audit Type is Selected");
	}
	
	public void SetFromDate(String FD)
	{
		FromDate.sendKeys(FD);
		System.out.println("Entered From Date is : " + FD);
		chiledTest.log(Status.INFO, "From Date is Enterd");
		
		FromDate.sendKeys(Keys.ESCAPE);
	}
	
	public void SetToDate(String TD)
	{
		ToDate.sendKeys(TD);
		System.out.println("Entered To Date is : " + TD);
		chiledTest.log(Status.INFO, "To Date is Enterd");
		
		ToDate.sendKeys(Keys.ESCAPE);
	}
	
	public void VerifyPleaseSelectTheProperDateRangePopUpIsDisplayed() throws InterruptedException
	{
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Expected_Alert = "Please select the proper date range";
		String Actaul_Alert = Alert.getText(); 
		Assert.assertEquals(Expected_Alert, Actaul_Alert, "Please select the proper date range Pop Up is NOT Displayed");
		System.out.println("Please select the proper date range Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Please select the proper date range Pop Up is Displayed");

		Alert.accept();

	}
	
	public void VerifyPleaseSelectStartAndEndDatePopUpIsDisplayed() throws InterruptedException
	{
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Expected_Alert = "Please select start data and end date.";
		String Actaul_Alert = Alert.getText(); 
		Assert.assertEquals(Expected_Alert, Actaul_Alert, "Please select start data and end date. Pop Up is NOT Displayed");
		System.out.println("Please select start data and end date. Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Please select start data and end date. Pop Up is Displayed");

		Alert.accept();

	}
	
	

	public void VerifyAllReportsLinkIsDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(MonthlyTop5Issues.isDisplayed() && MonthlyBottom5Issues.isDisplayed() && MonthlyTop5adherence.isDisplayed() && MonthlyBottom5adherence.isDisplayed() && PieChartBasedOnIssueStatus.isDisplayed() && DetailedReportWithAuditSummary.isDisplayed() && DetailedReportWithAuditIssueSummary.isDisplayed() && ListOfIssuesWithStatus.isDisplayed() && AgingOfIssues.isDisplayed() && IssueStatusAndIssueTypes.isDisplayed() && AuditRatingCounts.isDisplayed() && PieChartBasedOnAuditStatus.isDisplayed() && AuditeeAverageAuditRatingScore.isDisplayed() && Top5Auditees.isDisplayed() && Bottom5Auditees.isDisplayed() && RegionwiseGroupwiseCompliance.isDisplayed())
		{
			System.out.println("sknws");
		}else{
			System.out.println("fail");
		}
	}

	public void ClickSubmitBTN()
	{
		SubmitBTN.click();
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}
	
	public void VerifySearchedDataIsDisplayed()
	{
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement Data = driver.findElement(By.xpath("//table[@class='table table-striped table-hover table-search table-responsive dataTable no-footer']/tbody/tr/td[@class='sorting_1']"));
			Assert.assertTrue(Data.isDisplayed(), "Searched results are showed");
			System.out.println("Searched results are showed");
			chiledTest.log(Status.INFO, "Searched results are showed");

		}catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement NoData = driver.findElement(By.xpath("//td[text()='No data available in table']"));
			Assert.assertTrue(NoData.isDisplayed(), "No data available in table is Displayed");
			System.out.println("No data available in table is Displayed");
			chiledTest.log(Status.INFO, "No data available in table is Displayed");
		}
	}
	
	public void VerifyGraphicalReportsSearchedDataIsDisplayed()
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			//Checking download PDF Button is Displayed
			WebElement DownloadPDFBTN = driver.findElement(By.xpath("//button[contains(text(),'Download PDF')]"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(DownloadPDFBTN)).isDisplayed(), "Download PDF Button is Displayed");
			System.out.println("Download PDF Button is Displayed");
			chiledTest.log(Status.INFO, "Download PDF Button is Displayed");
			
			//Checking the PI Chart is Button is Displayed
			WebElement PIChart = driver.findElement(By.xpath("//div[@id='chart-area']"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(PIChart)).isDisplayed(), "Pi Chart is Displayed");
			System.out.println("Pi Chart is Displayed");
			chiledTest.log(Status.INFO, "Pi Chart is Displayed");
			
		}catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement NoData = driver.findElement(By.xpath("//b[text()='Sorry, no data exists']"));
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(NoData)).isDisplayed(), "Sorry, no data exists Message is Displayed");
			System.out.println("Sorry, no data exists Message is Displayed");
			chiledTest.log(Status.INFO, "Sorry, no data exists Message is Displayed");
		}
	}
	
}


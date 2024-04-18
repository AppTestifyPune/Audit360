package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;

public class AdminIssuePageTest extends BaseTest {

	//Clicking on the My Audit Header
	@FindBy(xpath="//a[@class='active'][text()='ISSUES ']")
	private WebElement IssuesHeader;

	//Clicking on the scroll bar
	@FindBy(xpath="//nav[contains(@class,'page-sidebar')]/div[contains(@class,'sidebar-menu')]")
	private WebElement ScrollBar;

	//Clicking on the Issues under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content')]/li/a/span[text()='Issues']")
	private WebElement Issues;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//passing the values to Cluster
	@FindBy(xpath="//div[@id='s2id_user_cluster_ids']//input")
	private WebElement Cluster;

	//Passing the values to Select Audit Type
	@FindBy(xpath="//div[@id='s2id_search_audit_issues']//input[@type='text']")
	private WebElement SelectAuditType;

	//passing the Values to Select Issue status
	@FindBy(xpath="//div[@id='s2id_issue_statuses']//input")
	private WebElement SetIssueStatus;

	//clicking on the Go Button
	@FindBy(xpath="//button[@id='search_issues_list_filter']")
	private WebElement GoBTN;

	//passing the values to Search fields
	@FindBy(xpath="//input[@type='search']")
	private WebElement Search;

	//clicking on the 1st TR
	@FindBy(xpath="//table[@id='issuesTableData']//tbody/tr[1]")
	private WebElement FirstTR;

	//clicking on the Close Issue button
	@FindBy(xpath="//div[text()='Close Issue']")
	private WebElement CloseIssueBTN;

	//clicking on the Reopen Issue button
	@FindBy(xpath="//input[@class='btn btn-primary btn-block auditee_result reset_issue']")
	private WebElement ReopenIssueBTN;

	//clicking on the Do you want to choose the final auditee remarks for this issue ? Yes Button
	@FindBy(xpath="//div[text()='Yes']")
	private WebElement YesBTN;

	//clicking on the Do you want to choose the final auditee remarks for this issue ? No Button
	@FindBy(xpath="//input[@value='No']")
	private WebElement NOBTN;


	public AdminIssuePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickIssuesHeader()
	{
		IssuesHeader.click();
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickIssues(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Issues);
	}

	public void ClickMatched(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Matched)).click();
	}


	public void SetCluster(String SC)
	{
		Cluster.sendKeys(SC);
		System.out.println("Entered Cluster is : " + SC);
		chiledTest.log(Status.INFO, "Cluster is Entered");
	}

	public void SetParentauditType(String SP)
	{
		SelectAuditType.sendKeys(SP);
		System.out.println("Entered Audit Type is : " + SP);
		chiledTest.log(Status.INFO, "Audit Type is Entered");
	}

	public void SetIssueStatus(String IS)
	{
		SetIssueStatus.sendKeys(IS);
		System.out.println("Entered Issue status is : " + IS );
		chiledTest.log(Status.INFO, "Issues Staus is Entered");
	}

	public void ClickGoButton()
	{
		GoBTN.click();
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");	
	}

	public void clickFirstTR() throws InterruptedException
	{
		Thread.sleep(2000);
		FirstTR.click();
	}


	public void SetSearch(String SS)
	{
		Search.clear();
		Search.sendKeys(SS);
		System.out.println("Searched audit type is " + SS);
	}

	public void ClickCloseIssueButton(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseIssueBTN);
		System.out.println("Close Issue Button is Clicked");
		chiledTest.log(Status.INFO, "Close Issue Button is Clicked");
	}

	public void ClickReopenIssueButton(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReopenIssueBTN);
		System.out.println("Reopen Issue Button is Clicked");
		chiledTest.log(Status.INFO, "Reopen Issue Button is Clicked");
	}

	public void VerifyIssueSignificanceAreDisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		//Checking Issue Significance are showing
		List<WebElement> AllSignificance = driver.findElements(By.xpath("//select[@name='issue_significance_list[]']//option"));
		Assert.assertTrue(AllSignificance.size()==5, "5 Issues signficance are not displayed");
		System.out.println("Toatla 5 Singinficance are displayed");
		chiledTest.log(Status.INFO, "Toatla 5 Singinficance are displayed");

		//Checking 1st Significance are matched
		Assert.assertEquals(AllSignificance.get(0).getText(), Lib.getCellValue(XLPATH, "Configure Audit Type", 192, 0), "1st Significance is Not matched");
		System.out.println(" 1st Significance are matched");
		chiledTest.log(Status.INFO, " 1st Significance are matched");

		//Checking 2nd Significance are matched
		Assert.assertEquals(AllSignificance.get(1).getText(), Lib.getCellValue(XLPATH, "Configure Audit Type", 193, 0), "2nd Significance is Not matched");
		System.out.println("2nd Significance are matched");
		chiledTest.log(Status.INFO, "2nd Significance are matched");

		//Checking 3rd Significance are matched
		Assert.assertEquals(AllSignificance.get(2).getText(), Lib.getCellValue(XLPATH, "Configure Audit Type", 194, 0), "3rd Significance is Not matched");
		System.out.println("3rd Significance are matched");
		chiledTest.log(Status.INFO, "3rd Significance are matched");

		//Checking 4th Significance are matched
		Assert.assertEquals(AllSignificance.get(3).getText(), Lib.getCellValue(XLPATH, "Configure Audit Type", 195, 0), "4th Significance is Not matched");
		System.out.println("4th Significance are matched");
		chiledTest.log(Status.INFO, "4th Significance are matched");

		//Checking 1st Significance are matched
		Assert.assertEquals(AllSignificance.get(4).getText(), Lib.getCellValue(XLPATH, "Configure Audit Type", 196, 0), "5th Significance is Not matched");
		System.out.println("5th Significance are matched");
		chiledTest.log(Status.INFO, "5th Significance are matched");
	}

	public void SelectAllIssueSignificances()
	{
		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.xpath("//select[@name='issue_significance_list[]']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actual_Count = alloptions.size();
		int Expected_Count = 5;
		System.out.println("The Totle Number of Issue Siginificance is ! " + Actual_Count);
		Assert.assertEquals(Actual_Count, Expected_Count, "Issue Status Drop down list Count is Wrong");
		for (int i=1; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			String AllText = All.getText();
			System.out.println(AllText);
			All.click();

		}
	}

	public void VerifyIssueIsClosedSucessMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccesMSG = driver.findElement(By.xpath("//span[text()='Issue is closed.']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccesMSG)).isDisplayed(), "Issue Is Closed success message is not Displayed");
		System.out.println("Issue is closed. is Displayed");
		chiledTest.log(Status.INFO, "Issue is closed. is Displayed");
	}

	public void VerifySignificanceIsDisabledOrNot() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement SignificanceDisabled = driver.findElement(By.xpath("//select[@name='issue_significance_list[]' and @disabled]"));
		Assert.assertTrue(SignificanceDisabled.isDisplayed(), "Signifiance is editable");
		System.out.println("Significance is Read only mode");
		chiledTest.log(Status.INFO, "Significance is Read only mode");

	}

	public void VerifyReopenAndCloseButtonIsDisabled()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Checking Post Closing the Issue Reopen and Close buttons should not show
		List<WebElement> ReopenBTN = driver.findElements(By.xpath("//input[@value='Reopen Issue']"));
		Assert.assertTrue(ReopenBTN.size()>=0, "Reopen Button is Displayed");
		System.out.println("Reopen Button is Not Displayed post closing the Issue");
		chiledTest.log(Status.INFO, "Reopen Button is Not Displayed post closing the Issue");

		List<WebElement> CloseBTN = driver.findElements(By.xpath("//input[@value='Close Issue']"));
		Assert.assertTrue(CloseBTN.size()>=0, "Close Button is Displayed");
		System.out.println("Close Button is Not Displayed post closing the Issue");
		chiledTest.log(Status.INFO, "Close Button is Not Displayed post closing the Issue");
	}

	public void ClickYesButton()
	{
		YesBTN.click();
		System.out.println("Yes Button Is Clicked");
		chiledTest.log(Status.INFO, "Yes Button is Clicked");
	}
	
	public void ClickNoButton()
	{
		NOBTN.click();
		System.out.println("No Button Is Clicked");
		chiledTest.log(Status.INFO, "No Button is Clicked");
	}

	
	public void VerifyDoYouWantToChooseTheFinalAuditeeRemarksForThisIssue()
	{
		WebElement PopUp = driver.findElement(By.xpath("//div[text()='Do you want to choose the final auditee remarks for this issue ?']"));
		Assert.assertTrue(PopUp.isDisplayed(), "Do you want to choose the final auditee remarks for this issue ? is NOT Displayed");
		System.out.println("Do you want to choose the final auditee remarks for this issue ? Pop Up Is Displayed");
		chiledTest.log(Status.INFO, "Do you want to choose the final auditee remarks for this issue ? Pop Up Is Displayed");
	}
}


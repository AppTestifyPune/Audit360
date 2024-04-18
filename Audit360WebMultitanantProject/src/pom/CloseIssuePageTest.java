package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CloseIssuePageTest {

	//Clicking on the Home Header
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement HomeHeader;

	//Clicking on the Issues Header
	@FindBy(xpath="//a[@class='active'][text()='ISSUE']")
	private WebElement IssuesHeader;

	//Clicking on the scroll bar
	@FindBy(xpath="//nav[contains(@class,'page-sidebar')]/div[contains(@class,'sidebar-menu')]")
	private WebElement ScrollBar;

	//Clikcing on the Issues under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content')]/li/a/span[text()='Issues']")
	private WebElement Issues;

	//Passing the values to Search text Field
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBox;

	//Passing the Values to Select Parent Audit Type
	@FindBy(xpath="//div[@id='s2id_search_audit_issues']//input[@type='text']")
	private WebElement SelectParentAuditType;
	
	//Passing the Values to Select Issue Status
	@FindBy(xpath="//div[@id='s2id_issue_statuses']//input[@type='text']")
	private WebElement SelectIssueStatus;
	
	

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Selecting 100 option under Pagination
	@FindBy(xpath="//select[@name='issuesTableData_length']/option[last()]")
	private WebElement Pagination;

	//Clicking on the Close Issue Button
	@FindBy(xpath="//input[@value='Close Issue']")
	private WebElement CloseIssueBTN;

	//Clicking on the Reopn Issue Button
	@FindBy(xpath="//input[@value='Reopen Issue']")
	private WebElement ReopenIssueBTN;

	//clicking on the 1st View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[1]")
	private WebElement FirstTR;

	//clicking on the 2nd View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[2]")
	private WebElement SecondTR;

	//clicking on the 3rd View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[3]")
	private WebElement ThiredTR;

	//clicking on the 4th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[4]")
	private WebElement FourthTR;

	//clicking on the 5th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[5]")
	private WebElement FifthTR;

	//clicking on the 6th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[6]")
	private WebElement SixthTR;

	//clicking on the 7th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[7]")
	private WebElement SeveenthTR;

	//clicking on the 8th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[8]")
	private WebElement EighthTR;

	//clicking on the 9th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[9]")
	private WebElement NinthTR;

	//clicking on the 10th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[10]")
	private WebElement TenthTR;

	//clicking on the 11 th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[11]")
	private WebElement EleventhTR;

	//clicking on the 12th View Button
	@FindBy(xpath="//table[@id='issuesTableData']/tbody/tr[12]")
	private WebElement TwoThTR;


	public CloseIssuePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickHomeHeader()
	{
		HomeHeader.click();
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

	public void ClickReopenIssueBTN(WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ReopenIssueBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ReopenIssueBTN);
		}catch (StaleElementReferenceException e) {
			
		}
		
	}

	public void ClickCloseIssueBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(CloseIssueBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", CloseIssueBTN);
		}catch (StaleElementReferenceException e) {
			
		}
		
	}


	public void SetSelectParentAuditType(String SPA)
	{
		SelectParentAuditType.sendKeys(SPA);
		System.out.println("Entered Parent Audit Type is : " + SPA);
	}
	
	public void SetSelectIssueStatus(String SIS)
	{
		SelectIssueStatus.sendKeys(SIS);
		System.out.println("Selected Issues Status is : " + SIS);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void setSearchBox(String SS, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SearchBox)).clear();
		SearchBox.sendKeys(SS);
		System.out.println("Searched Audit Type is : " + SS);
	}


	public void ClickPagination(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Pagination)).click();
	}

	public void ClickFirstTRBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(FirstTR)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickSecondTRBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(SecondTR)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickThirdTRBTNViewBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(ThiredTR)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickFourthTRBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(FourthTR)).click();
		}catch (StaleElementReferenceException e) {

		}
	}

	public void ClickFifthTRBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(FifthTR)).click();
		}catch (StaleElementReferenceException e) {

		}

	}
	

	public void VerifyIssuesPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking Home Header
		Assert.assertTrue(HomeHeader.isDisplayed(), "Home Header is Not Displayed");

		//Checking the Issues Header
		Assert.assertTrue(IssuesHeader.isDisplayed(), "Issues Header is Not Displayed");

		//Checking the Select Parent Audit type
		WebElement SelectParentAudittypeLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Parent Audit Type')]"));
		Assert.assertTrue(SelectParentAudittypeLabel.isDisplayed(), "Select Audit Type Drop down Is Not Displayed");

		//Checking the Select Intent
		WebElement SelectIntentLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Intent')]"));
		Assert.assertTrue(SelectIntentLabel.isDisplayed(), "Select Intent Drop down Is Not Displayed");

		//Checking the Select Issue status
		WebElement SelectIssueStatus = driver.findElement(By.xpath("//label[contains(text(),'Select Issue Status')]"));
		Assert.assertTrue(SelectIssueStatus.isDisplayed(), "Select Issue Status Drop down Is Not Displayed");

		//Checking the Select Group 
		WebElement SelectGroup = driver.findElement(By.xpath("//label[contains(text(),'Select Group')]"));
		Assert.assertTrue(SelectGroup.isDisplayed(), "Select Group  Drop down Is Not Displayed");

		//Checking the Search Button
		Assert.assertTrue(SearchBox.isDisplayed(), "Search Button Is Not Displayed");

		//checking Table
		WebElement Table = driver.findElement(By.xpath("//table[@id='issuesTableData']"));
		Assert.assertTrue(Table.isDisplayed(), "Issues Grid Is Not Displayed");

	}
}

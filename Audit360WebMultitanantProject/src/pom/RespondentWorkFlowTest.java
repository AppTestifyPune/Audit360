package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class RespondentWorkFlowTest extends BaseTest {

	//Clicking on the Home Header
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement HomeHeader;

	//Clicking on the My Audit Header
	@FindBy(xpath="//a[@class='active'][text()='ISSUES ']")
	private WebElement IssuesHeader;

	//Clicking on the scroll bar
	@FindBy(xpath="//nav[contains(@class,'page-sidebar')]/div[contains(@class,'sidebar-menu')]")
	private WebElement ScrollBar;

	//Clikcing on the Issues under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content')]/li/a/span[text()='Issues']")
	private WebElement Issues;

	//Passing the Values to Select Parent Audit Type
	@FindBy(xpath="//div[@id='s2id_issue_audit_types']//input[@type='text']")
	private WebElement SelectParentAuditType;

	//Passing the Values to Select Auditor
	@FindBy(xpath="//div[@id='s2id_issue_auditor']//input[@type='text']")
	private WebElement SelectAuditor;

	//Passing the Values to Select Audit Date
	@FindBy(xpath="//input[@id='issue_created_date']")
	private WebElement SelectAuditDate;

	//Pasing the Values to Select due date
	@FindBy(xpath="//input[@id='issue_due_date']")
	private WebElement SelectdueDate;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Passing the values to Search text Field
	@FindBy(xpath="//label[contains(text(),'Search:')]//input[@class='form-control']")
	private WebElement SearchBox;

	//Selecting 100 option under Pagination
	@FindBy(xpath="//select[@name='tableWithSearch_length']/option[last()]")
	private WebElement Pagination;

	//clicking on the 1st View Button
	@FindBy(xpath="//table[@id='tableWithSearch']/tbody/tr[1]/td[11]/button[@class='btn btn-clear edit_transaction_details']")
	private WebElement FirstViewBTN;

	//clicking on the 2nd View Button
	@FindBy(xpath="//table[@id='tableWithSearch']/tbody/tr[2]/td[11]/button[@class='btn btn-clear edit_transaction_details']")
	private WebElement SecondViewBTN;

	//Passing the Values to Comments
	@FindBy(xpath="//textarea[@placeholder='Enter comments']")
	private WebElement Comments;

	//Passing the values to Choose File
	@FindBy(xpath="//input[@id='issue_audit_compliance_documents_attributes_0_document']")
	private WebElement ChooseFile;
	
	//Clicking on the Reslove Issue Button
		@FindBy(xpath="//input[@value='RESPOND ISSUE']")
		private WebElement RespondIssueBTN;
		
		//Checking No data Available in the Tabele
		@FindBy(xpath="//td[text()='No data available in table']")
		private WebElement Nodata;



	public RespondentWorkFlowTest(WebDriver driver)
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

	public void SetSelectParentAuditType(String SPA)
	{
		SelectParentAuditType.sendKeys(SPA);
		System.out.println("Entered Parent Audit Type is : " + SPA);
	}

	public void SetSelectAuditor(String SA)
	{
		SelectAuditor.sendKeys(SA);
		System.out.println("Entered Auditor is : " + SA);
	}

	public void SetSelectAuditDate(String AD)
	{
		SelectAuditDate.sendKeys(AD);
		System.out.println("Entered Audit Date is : " + AD);
		SelectAuditDate.sendKeys(Keys.ESCAPE);
	}

	public void SetSelectdueDate(String DD)
	{
		SelectdueDate.sendKeys(DD);
		System.out.println("Entered Due Date is : " + DD);
		SelectdueDate.sendKeys(Keys.ESCAPE);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void setSearchBox(String SS, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SearchBox)).clear();

		SearchBox.sendKeys(SS);
		System.out.println("Searched Audit Type is : " + SS);
	}

	public void ClickPagination(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Pagination)).click();
	}

	public void ClickFirstViewBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(FirstViewBTN)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickSecondViewBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(SecondViewBTN)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void SetComments(String SC) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			Comments.sendKeys(SC);
			System.out.println("Entered comments is : " + SC);
		}catch (StaleElementReferenceException e) {

		}

	}

	public void UploadDocumnet(WebDriver driver)
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
		System.out.println("documnet is Uploaded");
	}
	
	public void ClickRespondIssueBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(RespondIssueBTN)).click();
		System.out.println("Respond Issues Button is Clicked");
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

		//Checking the Select Auditor
		WebElement SelectAuditorLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Auditor')]"));
		Assert.assertTrue(SelectAuditorLabel.isDisplayed(), "Select Auditor Drop down Is Not Displayed");

		//Checking the Select Audit Date
		WebElement SelectAuditDateLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Audit Date')]"));
		Assert.assertTrue(SelectAuditDateLabel.isDisplayed(), "Select Audit Date Drop down Is Not Displayed");

		//Checking the Select Issue Status
		WebElement SelectIssueStatus = driver.findElement(By.xpath("//label[contains(text(),'Select Issue Status')]"));
		Assert.assertTrue(SelectIssueStatus.isDisplayed(), "Select Issue status Drop down Is Not Displayed");

		//Checking the Select Due Date
		WebElement SelectParentDuedate = driver.findElement(By.xpath("//label[contains(text(),'Select Due Date')]"));
		Assert.assertTrue(SelectParentDuedate.isDisplayed(), "Select due date Drop down Is Not Displayed");

		//Checking the Search Button
		Assert.assertTrue(SearchBox.isDisplayed(), "Search Button Is Not Displayed");

		//checking Table
		WebElement Table = driver.findElement(By.xpath("//table[@id='tableWithSearch']"));
		Assert.assertTrue(Table.isDisplayed(), "Issues Grid Is Not Displayed");

	}

	public void VerifyInProgressstatusIsDisplayed(WebDriver driver)
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement IssueStatus = driver.findElement(By.xpath("//textarea[@id='status']"));
			String Actiual_Text = wait.until(ExpectedConditions.visibilityOf(IssueStatus)).getText();
			String Expected_text = "In Progress";
			Assert.assertEquals(Actiual_Text, Expected_text, "In progress status is Not Displayd");
			System.out.println("In Progress status is Displayed");
		}catch (StaleElementReferenceException e) {

		}
	}
	
	public void VerifyIssuesUpdatedSuccessFullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		try{
			if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
				String Atcual_MSG = SuccessMSG.getText();
				String Expected_MSG = "Issue updated successfully";
				Assert.assertEquals(Atcual_MSG, Expected_MSG, "Issues Updated SuccessFully Message is Not Displayed");}	
		}catch (StaleElementReferenceException e) {
			
		}
		
	}
	
	public void VerifyNoDataAvailableInTableIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(Nodata)).isDisplayed()){
			System.out.println("Pass : No data available in table Error Message is Displayed");
			chiledTest.log(Status.INFO, "Pass : No data available in table Error Message is Displayed");}
		else{
			System.out.println("Fail : No data available in table Error Message is Displayed ");
			chiledTest.log(Status.INFO, "Fail : No data available in table Error Message is Not Displayed");}
	}


}

package pom;

import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SideMenuPageTest extends BaseTest {

	//Clicking on the Scroll Bar
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Checking Checkpoint
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Check Points']")
	private WebElement Checkpoints;

	//Checking Manage Checkpoints 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//ul[@class='sub-menu']//span[text()='Manage Checkpoints']")
	private WebElement ManageCheckpoints;

	//Checking Predefined Checkpoints 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//ul[@class='sub-menu']//span[text()='Predefined Checkpoints']")
	private WebElement PredefinedCheckpoints;

	//Checking Dynamic Checklist 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//ul[@class='sub-menu']//span[text()='Dynamic Checkpoints']")
	private WebElement DynamicChecklist;

	//Checking Configure Audit
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']/div/ul/li/a//span[text()='Annexures']")
	private WebElement Annexure;

	//Checking Configure Audit
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Configure Audit']")
	private WebElement ConfigureAudit;

	//Clicking on the Configure audit Sub Menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[contains(text(),'Configure Audit')]")
	private WebElement CA;
	
	//Clicking on the Auditee Admin Configure Sub Menu
		@FindBy(xpath="//ul[@style='display: block;']/li/a/span[contains(text(),'Auditee Admin Configure')]")
		private WebElement AuditeeAdminConfigure;

	//Checking Auditor Survey
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Auditor Survey']")
	private WebElement AuditorSurvey;

	//Checking Schedule
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Schedule']")
	private WebElement Schedule;

	//Checking Review Audit
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Review Audit']")
	private WebElement ReviewAudit;

	//Checking Dash board
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Dashboard']")
	private WebElement Dashboard;

	//Checking System Settings
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='System Settings']")
	private WebElement SystemSettings;

	//checking User Management
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='User Management']")
	private WebElement UserManagemnet;

	//checking Role Management
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Role Management']")
	private WebElement RoleManagement;

	//checking Email Preferences
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Email Preferences']")
	private WebElement EmailPreferences;

	//checking Reminders
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Reminders']")
	private WebElement Reminders;

	//checking Logs
	@FindBy(xpath="//span[@class='title' and text()=' Audit Logs']")
	private WebElement AuditLogs;

	//Checking My Audits 
	@FindBy(xpath="//span[text()='My Audits']")
	private WebElement MyAudits;

	//Checking Issues 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Issues']")
	private WebElement Issues;

	//Checking Policy & Documents 
	@FindBy(xpath="//span[text()='Policy & Documents']")
	private WebElement PolicyAndDocuments;

	//Checking Process & Policy 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Processes & Policies']")
	private WebElement ProcessAndPolicy;

	//Checking Allocate Issues 
	@FindBy(xpath="//span[text()='Allocate Issues']")
	private WebElement AllocateIssues;

	//Checking Internal Messages 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Internal Messages']")
	private WebElement InternalMessages;

	//Checking Reports 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[@class='sidebar-menu']//span[text()='Reports']")
	private WebElement Reports;

	//clicking on the Basic Reports
	@FindBy(xpath="//span[@class='title' and contains(text(),'Basic Reports')]")
	private WebElement BasicReports;



	public SideMenuPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar()
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ScrollBar));
		
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickReports()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Reports);
		System.out.println("Reports is Clicked Under Side menu");
		chiledTest.log(Status.INFO, "Reports is Clicked Under Side menu");
	}

	public void ClickBasicReports()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", BasicReports);
		System.out.println("Basic Reports is Clicked Under Side menu");
		chiledTest.log(Status.INFO, "Basic Reports is Clicked Under Side menu");
	}

	public void ClickAuditLogs()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditLogs);
		System.out.println("Audit Logs is Clicked Under Side menu");
		chiledTest.log(Status.INFO, "Audit Logs is Clicked Under Side menu");
	}
	
	public void ClickConfigureAudit() 
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ConfigureAudit));
		
		ConfigureAudit.click();
		System.out.println("Configure Audit is Clicked Under Side menu");
		chiledTest.log(Status.INFO, "Configure Audit is Clicked Under Side menu");
	}
	
	public void ClickConfigureAuditSubMenu() 
	{
		CA.click();
		System.out.println("Configure Audit is Clicked Under Side menu");
		chiledTest.log(Status.INFO, "Configure Audit is Clicked Under Side menu");
	}
	
	public void clickAuditeeAdminConfigure()
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(AuditeeAdminConfigure));
		
		AuditeeAdminConfigure.click();
		System.out.println("Auditee Admin configure is Clicked Under Side menu");
		chiledTest.log(Status.INFO, "Auditee Admin configure is Clicked Under Side menu");
	}

	public void VerifySuperadminSideMenuItemsAreDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking Checkpoints is Displayed
		Assert.assertTrue(Checkpoints.isDisplayed(), "Checkpoints Side Menu is NOT Displayed");
		System.out.println("Checkpoints Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Checkpoints Side Menu is Displayd");

		//Checking Annexure is Displayed
		Assert.assertTrue(Annexure.isDisplayed(), "Annexure Side Menu is NOT Displayed");
		System.out.println("Annexure Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Annexure Side Menu is Displayd");

		//Checking Configure Audit is Displayed
		Assert.assertTrue(ConfigureAudit.isDisplayed(), "Configure Audit Side Menu is NOT Displayed");
		System.out.println("Configure Audit Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Configure Audit Side Menu is Displayd");

		//Checking Auditor Survey is Displayed
		Assert.assertTrue(AuditorSurvey.isDisplayed(), "Auditor Survey Side Menu is NOT Displayed");
		System.out.println("Auditor Survey Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Auditor Survey Side Menu is Displayd");

		//Checking Schedule is Displayed
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule Side Menu is NOT Displayed");
		System.out.println("Schedule Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Schedule Side Menu is Displayd");

		//Checking Process & Policy is Displayed
		Assert.assertTrue(ProcessAndPolicy.isDisplayed(), "Process & Policy Side Menu is NOT Displayed");
		System.out.println("Process & Policy Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Process & Policy Side Menu is Displayd");

		//Checking Review Audit is Displayed
		Assert.assertTrue(ReviewAudit.isDisplayed(), "Review Audit Side Menu is NOT Displayed");
		System.out.println("Review Audit Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Review Audit Side Menu is Displayd");

		//Checking Issue is Displayed
		Assert.assertTrue(Issues.isDisplayed(), "Issues Side Menu is NOT Displayed");
		System.out.println("Issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Issues Side Menu is Displayd");

		//Checking Reports is Displayed
		Assert.assertTrue(Reports.isDisplayed(), "Reports Side Menu is NOT Displayed");
		System.out.println("Reports Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Reports Side Menu is Displayd");

		//Checking Dash board is Displayed
		Assert.assertTrue(ReviewAudit.isDisplayed(), "Dash board Side Menu is NOT Displayed");
		System.out.println("Dash board Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Dash board Side Menu is Displayd");

		//Checking System Settings is Displayed
		Assert.assertTrue(SystemSettings.isDisplayed(), "System Settings Side Menu is NOT Displayed");
		System.out.println("System Settings Side Menu is Displayd");
		chiledTest.log(Status.INFO, "System Settings Side Menu is Displayd");

		
		//Checking User Management is Displayed
		Assert.assertTrue(UserManagemnet.isDisplayed(), "User Managemnet Side Menu is NOT Displayed");
		System.out.println("User Managemnet Side Menu is Displayd");
		chiledTest.log(Status.INFO, "User Managemnet Side Menu is Displayd");

		//Checking Internal Messages is Displayed
		Assert.assertTrue(InternalMessages.isDisplayed(), "Internal Messages issue Side Menu is NOT Displayed");
		System.out.println("Internal Messages issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Internal Messages issue Side Menu is Displayd");

		//Checking Role Management is Displayed
		Assert.assertTrue(RoleManagement.isDisplayed(), "Role Management Side Menu is NOT Displayed");
		System.out.println("Role Management Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Role Management Side Menu is Displayd");

		//Checking Email Preferences is Displayed
		Assert.assertTrue(EmailPreferences.isDisplayed(), "Email Preferences Side Menu is NOT Displayed");
		System.out.println("Email Preferences Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Email Preferences Side Menu is Displayd");

		//Checking Reminder is Displayed
		Assert.assertTrue(Reminders.isDisplayed(), "Reminder Side Menu is NOT Displayed");
		System.out.println("Reminder Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Reminder Side Menu is Displayd");

		//Checking Logs is Displayed
		Assert.assertTrue(AuditLogs.isDisplayed(), "Logs Side Menu is NOT Displayed");
		System.out.println("Logs Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Logs Side Menu is Displayd");


		/*Checkpoints.click();

		//Checking Manage Checkpoints is Displayed
		Assert.assertTrue(ManageCheckpoints.isDisplayed(), "Manage Checkpoints Side Menu is NOT Displayed");
		System.out.println("Manage Checkpoints Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Manage Checkpoints Side Menu is Displayd");

		//Checking Predefined Checkpoints is Displayed
		Assert.assertTrue(PredefinedCheckpoints.isDisplayed(), "Predefined Checkpoints Side Menu is NOT Displayed");
		System.out.println("Predefined Checkpoints Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Predefined Checkpoints Side Menu is Displayd");

		//Checking Dynamic Checkpoints is Displayed
		Assert.assertTrue(DynamicChecklist.isDisplayed(), "Dynamic Checkpoints Side Menu is NOT Displayed");
		System.out.println("Dynamic Checkpoints Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Dynamic Checkpoints Side Menu is Displayd");*/
	}

	public void VerifyAuditeeRoleSideMenuItemsAreDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking My Audits is Displayed
		Assert.assertTrue(MyAudits.isDisplayed(), "My Audits Side Menu is NOT Displayed");
		System.out.println("My Audits Side Menu is Displayd");
		chiledTest.log(Status.INFO, "My Audits Side Menu is Displayd");

		//Checking Issue is Displayed
		WebElement Issue = driver.findElement(By.xpath("//span[text()='Issues']"));
		Assert.assertTrue(Issue.isDisplayed(), "Issues Side Menu is NOT Displayed");
		System.out.println("Issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Issues Side Menu is Displayd");

		//Checking Policy And Documents is Displayed
		Assert.assertTrue(PolicyAndDocuments.isDisplayed(), "Policy And Documents Side Menu is NOT Displayed");
		System.out.println("Policy And Documents Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Policy And Documents Side Menu is Displayd");

		//Checking Allocate issue is Displayed
		Assert.assertTrue(AllocateIssues.isDisplayed(), "Allocate issue Side Menu is NOT Displayed");
		System.out.println("Allocate issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Allocate issue Side Menu is Displayd");

		//Checking Internal Messages is Displayed
		WebElement InternalMessage = driver.findElement(By.xpath("//span[text()='Internal Messages']"));
		Assert.assertTrue(InternalMessage.isDisplayed(), "Internal Messages issue Side Menu is NOT Displayed");
		System.out.println("Internal Messages issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Internal Messages issue Side Menu is Displayd");
	}

	public void VerifyAuditeeReviewerRoleSideMenuItemsAreDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking My Audits is Displayed
		Assert.assertTrue(MyAudits.isDisplayed(), "My Audits Side Menu is NOT Displayed");
		System.out.println("My Audits Side Menu is Displayd");
		chiledTest.log(Status.INFO, "My Audits Side Menu is Displayd");

		//Checking Issue is Displayed
		WebElement Issue = driver.findElement(By.xpath("//body[contains(@class,'windows desktop pace-done')]/nav/div[@class='sidebar-menu']//span[text()='Issues']"));
		Assert.assertTrue(Issue.isDisplayed(), "Issues Side Menu is NOT Displayed");
		System.out.println("Issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Issues Side Menu is Displayd");

		//Checking Policy And Documents is Displayed
		Assert.assertTrue(PolicyAndDocuments.isDisplayed(), "Policy And Documents Side Menu is NOT Displayed");
		System.out.println("Policy And Documents Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Policy And Documents Side Menu is Displayd");

		//Checking Allocate issue is Displayed
		Assert.assertTrue(AllocateIssues.isDisplayed(), "Allocate issue Side Menu is NOT Displayed");
		System.out.println("Allocate issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Allocate issue Side Menu is Displayd");

		//Checking Internal Messages is Displayed
		WebElement InternalMessage = driver.findElement(By.xpath("//span[text()='Internal Messages']"));
		Assert.assertTrue(InternalMessage.isDisplayed(), "Internal Messages issue Side Menu is NOT Displayed");
		System.out.println("Internal Messages issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Internal Messages issue Side Menu is Displayd");


	}

	public void VerifyAuditeeRespondentRoleSideMenuItemsAreDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking Issue is Displayed
		WebElement Issue = driver.findElement(By.xpath("//span[text()='Issues']"));
		Assert.assertTrue(Issue.isDisplayed(), "Issues Side Menu is NOT Displayed");
		System.out.println("Issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Issues Side Menu is Displayd");

		//Checking Policy And Documents is Displayed
		Assert.assertTrue(PolicyAndDocuments.isDisplayed(), "Policy And Documents Side Menu is NOT Displayed");
		System.out.println("Policy And Documents Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Policy And Documents Side Menu is Displayd");

		//Checking Internal Messages is Displayed
		WebElement InternalMessage = driver.findElement(By.xpath("//span[text()='Internal Messages']"));
		Assert.assertTrue(InternalMessage.isDisplayed(), "Internal Messages issue Side Menu is NOT Displayed");
		System.out.println("Internal Messages issue Side Menu is Displayd");
		chiledTest.log(Status.INFO, "Internal Messages issue Side Menu is Displayd");

	}




}

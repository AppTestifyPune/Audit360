package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;

public class LeadAuditorAllocationPageTest extends BaseTest {

	//Clicking on the Allocation Execution button
	@FindBy(xpath="//a[text()='Allocation Execution']")
	private WebElement AllocationExecutionBTN;

	//Clicking on the Parallel Execution button
	@FindBy(xpath="//a[text()='Parallel Execution']")
	private WebElement ParallelExecutionBTN;

	//Clicking on the Select Audit configuration level
	@FindBy(xpath="//div[@id='s2id_audit_schedule_configuration_level']//a//span[@class='select2-arrow']")
	private WebElement AuditConfigurationLevel;

	//Passing the values to Audit Configuration level
	@FindBy(xpath="//div[@id='select2-drop']//div//input")
	private WebElement SetAuditConfigurationlevel;

	//clicking on the Submit button
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement SubmitButton;

	//clicking on the cancel button
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement CancelButton;

	//Passing the Values to 1st Group
	@FindBy(xpath="//div[@id='s2id_audit_schedule_audit_groups_attributes_0_groups']//ul/li//input")
	private WebElement FirstGroup;

	//Passing the Values to 2nd Group
	@FindBy(xpath="//div[@id='s2id_audit_schedule_audit_groups_attributes_1_groups']//ul/li//input")
	private WebElement SecondGroup;

	//Passing the Values to 3rd Group
	@FindBy(xpath="//div[@id='s2id_audit_schedule_audit_groups_attributes_2_groups']//ul/li//input")
	private WebElement ThirdGroup;

	//Passing the Values to 1st Sub audit
	@FindBy(xpath="//div[@id='s2id_audit_schedule_audit_groups_attributes_0_audit_types']//ul/li//input")
	private WebElement FirstSubAudits;

	//Passing the Values to 2nd Sub audit
	@FindBy(xpath="//div[@id='s2id_audit_schedule_audit_groups_attributes_1_audit_types']//ul/li//input")
	private WebElement SecondSubAudits;

	//Passing the Values to 3rd Sub audit
	@FindBy(xpath="//div[@id='s2id_audit_schedule_audit_groups_attributes_2_audit_types']//ul/li//input")
	private WebElement ThirdSubAudits;

	public LeadAuditorAllocationPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickAllocationExecutionButton()
	{
		AllocationExecutionBTN.click();
		System.out.println("Allocation Execution button is Clicked");
		chiledTest.log(Status.INFO, "Allocation Execution button is Clicked");
	}

	public void ClickParallelExecutionBTN()
	{
		ParallelExecutionBTN.click();
		System.out.println("Parallel Execution button is Clicked");
		chiledTest.log(Status.INFO, "Parallel Execution button is Clicked");
	}

	public void ClickSelectAuditConfigurationLevel() throws InterruptedException
	{
		Thread.sleep(2000);
		AuditConfigurationLevel.click();
	}

	public void SetAuditConfigurationLevel(String AL)
	{
		SetAuditConfigurationlevel.sendKeys(AL);
		System.out.println("Selected Configure level is : " + AL);
	}

	public void ClickSubmitButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitButton);
		System.out.println("Submit button is Clicked");
		chiledTest.log(Status.INFO, "Submit button is Clicked");
	}

	public void ClickCancelButton()
	{
		CancelButton.click();
		System.out.println("Cancel button is Clicked");
		chiledTest.log(Status.INFO, "Cancel button is Clicked");
	}

	public void VerifySubAuditAndPIOptionIsDisabled()
	{
		WebElement SubAudit = driver.findElement(By.xpath("//select[@id='audit_schedule_configuration_level']//option[text()='SUB AUDIT' and @disabled='disabled']"));
		WebElement PI = driver.findElement(By.xpath("//select[@id='audit_schedule_configuration_level']//option[text()='PI' and @disabled='disabled']"));
		Assert.assertTrue(SubAudit.isDisplayed(), "SubAudit Option is in disabled");
		Assert.assertTrue(PI.isDisplayed(), "PI Option is in disabled");
	}

	public void SetFirstGroup(String FG) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(FirstGroup)).sendKeys(FG);
		System.out.println("Selected Group is : " + FG);
	}

	public void SetSecondGroup(String SG) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SecondGroup)).sendKeys(SG);
		System.out.println("Selected Group is : " + SG);
	}

	public void SetThirdGroup(String TG) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ThirdGroup)).sendKeys(TG);
		System.out.println("Selected Group is : " + TG);
	}
	
	public void SetFirstSubAudit(String FS) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(FirstSubAudits)).sendKeys(FS);
		System.out.println("Selected Group is : " + FS);
	}
	
	public void SetSecondSubAudit(String SS) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SecondSubAudits)).sendKeys(SS);
		System.out.println("Selected Group is : " + SS);
	}

	public void SetThirdSubAudit(String TS) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ThirdSubAudits)).sendKeys(TS);
		System.out.println("Selected Group is : " + TS);
	}

	public void VerifyAllocationExecutionSuccessfullyDoneMSGIsDisplayed()
	{
		WebElement SuccesMSG = driver.findElement(By.xpath("//span[contains(text(),'Allocation execution successfully done')]"));
		Assert.assertTrue(SuccesMSG.isDisplayed(), "Allocation execution successfully done Message is Not Displayed");
		System.out.println("Allocation execution successfully Message is Displayed");
		chiledTest.log(Status.INFO, "Allocation execution successfully Message is Displayed");
	}


}

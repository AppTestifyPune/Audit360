package pom;

import java.sql.Driver;
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

public class AuditLogsPageTest extends BaseTest {

	//Clicking on the Home Header
	@FindBy(xpath="//a[text()='AUDIT LOG']")
	private WebElement AuditLogsHeader;

	//passing the values to Start Date
	@FindBy(xpath="//input[@id='activity_start_date']")
	private WebElement StartDate;

	//passing the values to To Date
	@FindBy(xpath="//input[@id='activity_end_date']")
	private WebElement ToDate;

	//clicking on the Select Role Name
	@FindBy(xpath="//label[text()='Select Role Name']/following-sibling::div")
	private WebElement RoleName;

	//clicking on the Select User Name
	@FindBy(xpath="//label[text()='Select User Name']/following-sibling::div/a/span[@class='select2-arrow']")
	private WebElement UserName;

	//Passing the Values to Select Role Name
	@FindBy(xpath="//div[@id='select2-drop']//input")
	private WebElement SetRoleName;

	//Passing the Values to Select User Name
	@FindBy(xpath="//div[@id='select2-drop']//input")
	private WebElement SetUserName;

	//clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement MatchedText;

	//clicking on the Go Button
	@FindBy(xpath="//input[@name='GO']")
	private WebElement GoBTN;

	//clicking on the Go Button
	@FindBy(xpath="//input[@value='Download Logs']")
	private WebElement DownloadLogsBTN;

	public AuditLogsPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void ClickAuditLogsHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditLogsHeader);
	}

	public void SetStartDate(String SD) throws InterruptedException
	{
		StartDate.sendKeys(SD);
		System.out.println("Entered Start date is : " + SD);
		chiledTest.log(Status.INFO, "Start date is Entered");

		StartDate.sendKeys(Keys.TAB);

	}

	public void SetEndDate(String ST)
	{
		ToDate.sendKeys(ST);
		System.out.println("Entered To date is : " + ST);
		chiledTest.log(Status.INFO, "To date is Entered");

		ToDate.sendKeys(Keys.TAB);

	}

	public void ClickRoleName()
	{
		RoleName.click();
	}

	public void SetRoleName(String SR)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(SetRoleName));
		
		SetRoleName.sendKeys(SR);
		System.out.println("Entered Role Name is : " + SR);
		chiledTest.log(Status.INFO, "Role Name is Entered");
	}

	public void ClickUserName()
	{
		UserName.click();
	}

	public void SetUserName(String UN) throws InterruptedException
	{
		Thread.sleep(2000);
		SetUserName.sendKeys(UN);
		Thread.sleep(2000);
		System.out.println("Entered User Name is : " + UN);
		chiledTest.log(Status.INFO, "User Name is Entered");
	}

	public void ClickGoButton()
	{
		GoBTN.click();
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}

	public void ClickMatchedText()
	{
		MatchedText.click();
	}

	public void ClickDownloadButton()
	{
		DownloadLogsBTN.click();
		System.out.println("Download Button is Clicked");
		chiledTest.log(Status.INFO, "Download Button is Clicked");
	}

	public void VerifyPleaseSelectAllFieldsPopUpIsDisplayed()
	{
		Alert alert = driver.switchTo().alert();
		String Actula_Text = alert.getText();
		String Expected_Text = "Please select all required fields.";
		Assert.assertEquals(Actula_Text, Expected_Text, "Alert message is Wrong");
		System.out.println("Please select all required fields. Pop up is displayed");
		chiledTest.log(Status.INFO, "Please select all required fields. Pop up is displayed");

		alert.accept();
	}

	public void VerifyLogsAreDisplayed()
	{
		try{
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement Data = driver.findElement(By.xpath("//table[@id='activityTableWithSearchInner']//tbody/tr[@class='odd' or @class='even']"));
			Assert.assertTrue(Data.isDisplayed(), "Logs are displayed");
			System.out.println("Logs are displayed");
			chiledTest.log(Status.INFO, "Logs are displayed");
		}catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement NoData = driver.findElement(By.xpath("//td[text()='No data available in table']"));
			Assert.assertTrue(NoData.isDisplayed(), "No data available in table message is displayed");
			System.out.println("No data available in table message is displayed");
			chiledTest.log(Status.INFO, "No data available in table message is displayed");
		}
	}

	public void VerifyAuditLogsPageDetailsAreDisplayed()
	{
		//checking the Date and Time
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Date-Time']")).isDisplayed(), "Date and Time is Not Displayd");
		System.out.println("Date and Time is Not Diplayed");
		chiledTest.log(Status.INFO, "Date and Time is Not Diplayed");

		//checking the Module
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Module']")).isDisplayed(), "Module is Not Displayd");
		System.out.println("Module is Not Diplayed");
		chiledTest.log(Status.INFO, "Module is Not Diplayed");

		//checking the Action
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Action']")).isDisplayed(), "Action is Not Displayd");
		System.out.println("Action is Not Diplayed");
		chiledTest.log(Status.INFO, "Action is Not Diplayed");

		//checking the IP Address
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='IP Address']")).isDisplayed(), "IP Address is Not Displayd");
		System.out.println("IP Address is Not Diplayed");
		chiledTest.log(Status.INFO, "IP Address is Not Diplayed");

		//checking the User
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='User']")).isDisplayed(), "User is Not Displayd");
		System.out.println("User is Not Diplayed");
		chiledTest.log(Status.INFO, "User is Not Diplayed");

		//checking the Role
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Role']")).isDisplayed(), "Role is Not Displayd");
		System.out.println("Role is Not Diplayed");
		chiledTest.log(Status.INFO, "Role is Not Diplayed");

		//checking the Log Detail
		Assert.assertTrue(driver.findElement(By.xpath("//th[text()='Log Detail']")).isDisplayed(), "Log Detail is Not Displayd");
		System.out.println("Log Detail is Not Diplayed");
		chiledTest.log(Status.INFO, "Log Detail is Not Diplayed");

	}

}

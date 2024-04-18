package pom;

import java.util.List;
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

import com.aventstack.extentreports.Status;
import generic.BaseTest;


public class ReminderPageTest extends BaseTest{

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Reminder from side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Reminders']")
	private WebElement Reminders;

	//clicking on the Reminder Header
	@FindBy(xpath="//a[contains(text(),'REMINDER')]")
	private WebElement ReminderHeader;

	//Clicking on the Add Reminder Button
	@FindBy(xpath="//span[contains(text(),'Add Reminder')]")
	private WebElement AddReminderBTN;

	//Clicking on the Add a Remainder Configuration Button
	@FindBy(xpath="//a[contains(text(),'Add a reminder configuration')]")
	private WebElement AddARemainderConfigurationBTN;

	//Passing the Values to Search Box
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement SubmitBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement CancelBTN;

	//Passing the Values to Name
	@FindBy(xpath="//input[@id='reminder_name']")
	private WebElement Name;

	//Clicking on the please Select Frequency
	@FindBy(xpath="//span[contains(text(),'Please Select Frequency')]")
	private WebElement PleaseSelectFrequency;

	//Passing the Values to Please Select Frequency
	@FindBy(xpath="//input[@id='s2id_autogen7_search']")
	private WebElement SetFrequency;

	//Clicking on the Please Select level
	@FindBy(xpath="//span[@id='select2-chosen-5']")
	private WebElement PleaseselectLevel;

	//Passing the values to Please Select Level
	@FindBy(xpath="//input[@id='s2id_autogen5_search']")
	private WebElement PSL;

	//Clicking on the Days from TAT
	@FindBy(xpath="//input[@placeholder='Days from TAT']")
	private WebElement DaysFromTAT;

	//Passing the values to Recipient
	@FindBy(xpath="//label[contains(text(),'Role(s)')]/following-sibling::div/ul/li//input")
	private WebElement Roles;

	//Clicking on the 1st View Button
	@FindBy(xpath="//table[@id='remindersTableData']/tbody/tr[1]//button[@class='btn btn-clear view_remainder_details']")
	private WebElement ViewBTN;

	//clicking on the 1st Eidt Button
	@FindBy(xpath="//table[@id='remindersTableData']/tbody/tr[1]/td//a[1]")
	private WebElement EditBTN;

	//clicking on the 1st Delete Button
	@FindBy(xpath="//table[@id='remindersTableData']/tbody/tr[1]/td//a[2]")
	private WebElement DeleteBTN;

	//Clicking on the OK Button
	@FindBy(xpath="//div[@class='modal disable-scroll stick-up in']//a[@class='btn btn-primary btn-block m-t-5 confirm'][text()='OK']")
	private WebElement OKBTN;

	//Clicking on the Close Button
	@FindBy(xpath="//button[@class='btn btn-primary pull-right cancel_edit']")
	private WebElement CloseBTN;

	//clicking on the Matched text
	@FindBy(xpath="//div[@class='select2-result-label']/span[1]")
	private WebElement MatchedTex;

	public ReminderPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}


	public void ClickReminder(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Reminders);
	}

	public void ClickAddReminderButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(AddReminderBTN)).click();
		System.out.println("Add Remanider Button is Clicked");
		chiledTest.log(Status.INFO, "Add Reminder Button is Clicked");
	}

	public void ClickAddaRemainderConfigurationButton()
	{
		AddARemainderConfigurationBTN.click();
		System.out.println("Add a Remainder Configurtaion Button is Clicked");
		chiledTest.log(Status.INFO, "Add a Remainder Configurtaion Button is Clicked");
	}

	public void SetSearchButton(String SR)
	{
		SearchBTN.clear();
		SearchBTN.sendKeys(SR);
		System.out.println("Searched Reminder Name is : " + SR);
	}

	public void ClickSubmitBUtton()
	{
		SubmitBTN.click();
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "submit Button is Clicked");
	}

	public void ClickCancelButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CancelBTN);
	}

	public void SetName(String SN)
	{
		Name.sendKeys(SN);
		System.out.println("Entered Name is : " + SN);
	}

	public void ClearName()
	{
		Name.clear();
	}

	public void ClickPleaseSelectFrequency()
	{
		PleaseSelectFrequency.click();
	}

	public void ClickPleaseselectLevel()
	{
		PleaseselectLevel.click();
	}

	public void ClickCloseBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);
	}

	public void ClickMatched()
	{
		MatchedTex.click();
	}

	public void SetPleaseSelectFrequency(String PF, WebDriver driver) throws InterruptedException
	{
		SetFrequency.sendKeys(PF);
		System.out.println("Selected Frequency is : " + PF);
		chiledTest.log(Status.INFO, "Freequency is Enterd");
	}

	public void SetPleaseselectLevel(String PL, WebDriver driver) throws InterruptedException
	{
		PSL.sendKeys(PL);
		System.out.println("Selected Please select Level is : " + PL);
	}

	public void ClearPleaseSelectLevel()
	{
		PSL.clear();
	}

	public void SetDaysFromTAT(String DFT)
	{
		DaysFromTAT.sendKeys(DFT);
		System.out.println("Entered Days From TAT is : " + DFT);	
		chiledTest.log(Status.INFO, "Days From TAT is Selected");
	}

	public void ClearDaysFromTAT()
	{
		DaysFromTAT.clear();
	}


	public void SetRoles(String SR, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Roles.click();
		
		Roles.sendKeys(SR);
		System.out.println("Entered Role is : " + SR);
		chiledTest.log(Status.INFO, "Role is Selected");

	}

	public void ClickViewButton() throws InterruptedException
	{
		Thread.sleep(2000);
		ViewBTN.click();
		System.out.println("View Button is Clicked");
		chiledTest.log(Status.INFO, "View Button is Clicked");
	}

	public void ClickEditButton() throws InterruptedException
	{
		Thread.sleep(2000);
		EditBTN.click();
		System.out.println("Edit Button is Clicked");
		chiledTest.log(Status.INFO, "Edit Button is Clicked");
	}

	public void ClickDeleteButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(DeleteBTN)).click();
		System.out.println("Delete Button is Clicked");
		chiledTest.log(Status.INFO, "Delete Button is Clicked");
	}

	public void ClickOKButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(OKBTN)).click();
	}
	
	public void ClickReminderHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReminderHeader);
	}

	public void VerifyReminderPageisDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking Reminder Header
		Assert.assertTrue(ReminderHeader.isDisplayed(), "Reminder Header is Displayed");
		System.out.println("Pass : REMINDER Header is Displayed");
		chiledTest.log(Status.INFO, "REMINDER Header is Displayed");

		//Checking Add Reminder
		Assert.assertTrue(AddReminderBTN.isDisplayed(), "Add Reminder Button is Displayed");
		System.out.println("Pass : Add Reminder Button is Displayed");
		chiledTest.log(Status.INFO, "Add Reminder Button is Displayed");

		//Checking Rows and shows
		WebElement Shows = driver.findElement(By.xpath("//div[@id='remindersTableData_length']//label[1]"));
		Assert.assertTrue(Shows.isDisplayed(), "Shows and Rows is Displayed");
		System.out.println("Pass : Shows and Rows are Displayed");
		chiledTest.log(Status.INFO, "Shows and Rows are Displayed");

		//Checking Search Box
		Assert.assertTrue(SearchBTN.isDisplayed(), "Search Button is Displayed");
		System.out.println("Pass : Search Text Box is Displayed");
		chiledTest.log(Status.INFO, "Search Text Box is Displayed");

	}


	public void VerifyAddEditReminderPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking Reminder Header
		WebElement Reminder = driver.findElement(By.xpath("//a[@class='active']"));

		if(wait.until(ExpectedConditions.visibilityOf(Reminder)).isDisplayed())
		{
			String Expecte_Text = Reminder.getText();
			String Actual_Text = "REMINDER";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : REMINDER Header is Displayed");
		}

		//Checking Add/edit Reminder Header
		WebElement AddEditReminder = driver.findElement(By.xpath("//div[@class='panel-title']"));

		if(wait.until(ExpectedConditions.visibilityOf(AddEditReminder)).isDisplayed())
		{
			String Expecte_Text = AddEditReminder.getText();
			String Actual_Text = "ADD / EDIT REMINDER";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Add / Edit Reminder Header is Displayed");
		}

		//Checking Name Label
		WebElement NameLabel = driver.findElement(By.xpath("//label[@for='reminder_name']"));
		if(NameLabel.isDisplayed() && Name.isDisplayed())
		{
			String Expected_Text = NameLabel.getText();
			String Actual_Text = "NAME";
			Assert.assertEquals(Expected_Text, Actual_Text);

			System.out.println("Pass : Name Field is Displayed");
		}

		//Checking Recipient
		WebElement Recipient = driver.findElement(By.xpath("//div[@id='s2id_reminder_roles']"));
		//Checking Recipient Text 
		WebElement RecipientText = driver.findElement(By.xpath("//label[@for='reminder_recipient']"));

		if(wait.until(ExpectedConditions.visibilityOf(Recipient)).isDisplayed() && wait.until(ExpectedConditions.visibilityOf(RecipientText)).isDisplayed())
		{
			String Expected_Text = RecipientText.getText();
			String Actual_Text = "RECIPIENT";
			Assert.assertEquals(Expected_Text, Actual_Text);

			System.out.println("Pass : Recipient Field is Displayed");
		}

		//Checking the Frequency
		WebElement Frequency = driver.findElement(By.xpath("//label[@for='reminder_frequency']"));
		if(Frequency.isDisplayed() & PleaseSelectFrequency.isDisplayed())
		{
			String Expected_Text = Frequency.getText();
			String Actual_Text = "FREQUENCY";
			Assert.assertEquals(Expected_Text, Actual_Text);

			String Expected_text = PleaseSelectFrequency.getText();
			String Actual_text = "Please Select Frequency";
			Assert.assertEquals(Expected_text, Actual_text);

			System.out.println("Pass : Frequency Field is Displayed");
		}

		//Checking the Upto Level
		WebElement UPTO = driver.findElement(By.xpath("//label[@for='reminder_upto_level']"));

		if(UPTO.isDisplayed() & PleaseselectLevel.isDisplayed())
		{
			String Expected_Text = UPTO.getText();
			String Actual_Text = "UPTO LEVEL";
			Assert.assertEquals(Expected_Text, Actual_Text);

			String Expected_text = PleaseselectLevel.getText();
			String Actual_text = "Please Select Level";
			Assert.assertEquals(Expected_text, Actual_text);

			System.out.println("Pass : UPTO Level Field is Displayed");
		}


		//Checking the Days From TAT
		WebElement DaysFromTAT1 = driver.findElement(By.xpath("//label[@for='reminder_days_from_tat']"));
		if(DaysFromTAT1.isDisplayed() & DaysFromTAT.isDisplayed())
		{
			String Expected_Text = DaysFromTAT1.getText();
			String Actual_Text = "DAYS FROM TAT";
			Assert.assertEquals(Expected_Text, Actual_Text);

			System.out.println("Pass : Days From TAT Field is Displayed");
		}

		//Checking the Issues Type
		WebElement IssueType = driver.findElement(By.xpath("//div[@id='s2id_reminder_issue_type']"));
		//Checking IssueType Text
		WebElement IssuesTypeText = driver.findElement(By.xpath("//label[@for='reminder_issue_type']"));
		if(IssueType.isDisplayed() & IssuesTypeText.isDisplayed())
		{

			String Expected_text = IssuesTypeText.getText();
			String Actual_text = "ISSUE TYPE";
			Assert.assertEquals(Expected_text, Actual_text);

			System.out.println("Pass : Issue Type Field is Displayed");
		}

		//Checking Submit Button
		if(SubmitBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Submit Button is Displayed");

		}

		//Checking Cancel Button
		if(CancelBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Cancel Button is Displayed");

		}

	}


	public void VerifyReminderAddedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_Text = SuccessMSG.getText();
			String Actual_Text = "Reminder Added Successfully";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Reminder Added Successfully Success Message is Displayed");
			chiledTest.log(Status.INFO, "Reminder Added Successfully Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}
	}

	public void VerifyNameHasAlreadyBeenTakenErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed(), "Name has already been taken Error Message is Not Displayed");
		System.out.println("Pass : Name has already been taken Error Message is Displayed");
		chiledTest.log(Status.INFO, "Name has already been taken Error Message is Displayed");
	}

	public void VerifyReminderListIsDisplayedIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement data = driver.findElement(By.xpath("//table[@id='remindersTableData']/tbody/tr[1]"));
		if(wait.until(ExpectedConditions.visibilityOf(data)).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : reminder List is Displayed");
		}
	}

	public void VerifyNoDataAvailableInTableIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement Nodata = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(wait.until(ExpectedConditions.visibilityOf(Nodata)).isDisplayed())
		{
			String Expected_text = Nodata.getText();
			String Actual_text = "No data available in table";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : No data available in table Message is Displayed");
		}
	}

	public void VerifyReminderDetailsPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Reminder Details Header 
		WebElement Reminderdetails = driver.findElement(By.xpath("//h5[@class='text-primary ']"));
		if(wait.until(ExpectedConditions.visibilityOf(Reminderdetails)).isDisplayed())
		{
			String Expected_text = Reminderdetails.getText();
			String Actual_text = "Reminder Details";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Reminder Details Page is Displayed");
		}

		//Checking Close Button
		if(CloseBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass: Close Button is Displayed");
		}

	}

	public void VerifyReminderUpdatedSuccessfullyIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement RUS = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(RUS)).isDisplayed())
		{
			String Expected_text = RUS.getText();
			String Actual_text = "Reminder Updated Successfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Reminder Updated Successfully Message is Displayed");
		}

		//Clicking on the Close Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
	}

	public void VerifyAreYouSureYouWantToDeleteReminderPopIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement ReminderDelete = driver.findElement(By.xpath("//h5[contains(text(),'Reminder delete')]"));
		if(wait.until(ExpectedConditions.visibilityOf(ReminderDelete)).isDisplayed())
		{
			String Expected_text = ReminderDelete.getText();
			String Actual_text = "Reminder delete";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass :  Reminder delete Pop is Displayed");
		}
	}

	public void VerifyReminderDeletedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_Text = SuccessMSG.getText();
			String Actual_Text = "Reminder Deleted Successfully";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Reminder Deleted Successfully Success Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}
	}


	public void VerifyPleaseNoteThatTheReminderCannotBeDeletedAsMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//p[contains(text(),'Please note that the reminder cannot be deleted as')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(),"Please note that the reminder cannot be deleted as Message is NOT Displayed");
		System.out.println("Pass :  Please note that the reminder cannot be deleted as Message is Displayed");
		chiledTest.log(Status.INFO, "Please note that the reminder cannot be deleted as Message is Displayed");
	}
}


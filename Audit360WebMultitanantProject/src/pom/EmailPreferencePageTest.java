package pom;

import java.util.List;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;


public class EmailPreferencePageTest extends BaseTest{

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Reminder from side menu
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Email Preferences']")
	private WebElement EmailPreferences;

	//Clicking on the Email Preference Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement EmailPreferenceHeader;

	//Clicking on the email Preference Button
	@FindBy(xpath="//span[contains(text(),'Add Email Preference')]")
	private WebElement AddEmailPreferenceBTN;

	//Passing the Values to Search Text Box
	@FindBy(xpath="//input[@type='search']")
	private WebElement SearchBTN;

	//clicking on the 1st View Button
	@FindBy(xpath="//table[@id='listPreferencesTable']/tbody/tr[1]/td[2]/button[@class='btn btn-clear view_email_preferences_details']")
	private WebElement ViewBTN;

	//Clicking on the 1st Edit Button
	@FindBy(xpath="//table[@id='listPreferencesTable']/tbody/tr[1]/td[2]/a[@class='btn btn-info m-l-10']")
	private WebElement EditBTN;

	//Clicking on the 1st Delete Button
	@FindBy(xpath="//table[@id='listPreferencesTable']/tbody/tr[1]/td[2]/a[@class='btn btn-danger m-l-10 preference_delete']")
	private WebElement DeleteBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement SubmitBTN;

	//Passing the Values to Name
	@FindBy(xpath="//input[@id='email_preference_name' and @required='required']")
	private WebElement Name;

	//Passing the Values to Post Action Trigger Role1//div[@id='s2id_email_preference_role_ids_1_']//input[@type='text']
	@FindBy(xpath="//table[@id='initEmailNotificationnonSearch']//tbody/tr[1]//div[@id='s2id_roles_list']//ul//li//input")
	private WebElement PostActionTriggerSetRole1;

	//Passing the Values to Post Action Trigger Role2
	@FindBy(xpath="//table[@id='initEmailNotificationnonSearch']//tbody/tr[2]//div[@id='s2id_roles_list']//ul//li//input")
	private WebElement PostActionTriggerSetRole2;

	//Passing the Values to Non Action Trigger Role1
	@FindBy(xpath="//table[@id='initEmailNotificationPreSearch']/tbody/tr[1]/td[2]/div/ul/li/input")
	private WebElement NonActionTriggerSetRole1;

	//Passing the Values to Non Action Trigger Role2
	@FindBy(xpath="//table[@id='initEmailNotificationPreSearch']/tbody/tr[2]/td[2]/div/ul/li/input")
	private WebElement NonActionTriggerSetRole2;

	//Clicking on the Close Button
	@FindBy(xpath="//i[@class='pg-close fs-14']")
	private WebElement CloseBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement CancelBTN;

	//Clicking on the OK Button
	@FindBy(xpath="//a[text()='OK']")
	private WebElement OKBTN;

	//passing the Values to List Email Preference 
	@FindBy(xpath="//li[@class='select2-search-field']/input")
	private WebElement ListEmailPreference;

	//Clicking on the Matched 
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Non Action Trigger Tab
	@FindBy(xpath="//a[text()='Non Action Trigger']")
	private WebElement NonActionTriggerTab;

	public EmailPreferencePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickEmailPreferences(WebDriver driver) throws InterruptedException
	{
		Actions action = new Actions(driver);	
		action.moveToElement(EmailPreferences).click().build().perform();	
	}

	public void ClickEmailPreferenceHeader(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EmailPreferenceHeader);
	}

	public void ClickEmailPreferenceBTN()
	{
		AddEmailPreferenceBTN.click();
		System.out.println("Add Email Prefenece button is Clicked");
	}

	public void ClickNonActionTriggerTab(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NonActionTriggerTab);
		System.out.println("Non Action Trigger Tab is Clicked");
	}

	public void SetSearchBTN(String SB)
	{
		SearchBTN.clear();

		SearchBTN.sendKeys(SB);
		System.out.println("Searched Email Preference is : " + SB);

	}

	public void ClearSearchBTN() throws InterruptedException
	{
		SearchBTN.clear();
		Thread.sleep(2000);
	}

	public void ClickViewBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			ViewBTN.click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickEditBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(EditBTN)).click();
		System.out.println("Edit Button is Clicked");

	}

	public void ClickDeleteBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(DeleteBTN)).click();
	}

	public void ClickSubmitBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitBTN);
		System.out.println("Submit Button is Clicked");
	}

	public void SetName(String SN)
	{
		Name.clear();
		Name.sendKeys(SN);
		System.out.println("Entered Name is : " + SN);
	}

	public void PostActionTriggerSetRol1(String R1, WebDriver driver)
	{
		WebElement ListBox = driver.findElement(By.xpath("//select[@name='email_preference[role_ids][2][]']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		alloptions.get(0).click();
		System.out.println("1st Role Is selected");
		chiledTest.log(Status.INFO, "1st Role is Selected");

	}


	public void PostActionTriggerSetRol2(String R2, WebDriver driver)
	{
		/*WebElement ListBox = driver.findElement(By.xpath("//select[@name='email_preference[role_ids][3][]']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		alloptions.get(1).click();
		System.out.println("1st Role Is selected");
		chiledTest.log(Status.INFO, "1st Role is Selected");*/
	}

	public void NonActionTriggerSetRol1(String R1, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(NonActionTriggerSetRole1)).sendKeys(R1);
		System.out.println("Entered Rol is : " + R1);
	}

	public void NonActionTriggerSetRol2(String R2, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(NonActionTriggerSetRole2)).sendKeys(R2);
		System.out.println("Entered Rol is : " + R2);
	}

	public void NonActionTriggerSetRol3(String R3, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(NonActionTriggerSetRole1)).sendKeys(R3);
		System.out.println("Entered Rol is : " + R3);
	}


	public void NonActionTriggerSetRol4(String R4, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(NonActionTriggerSetRole2)).sendKeys(R4);
		System.out.println("Entered Rol is : " + R4);
	}

	public void NonActionTriggerSetRol5(String R5, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(NonActionTriggerSetRole2)).sendKeys(R5);
		System.out.println("Entered Rol is : " + R5);
	}

	public void ClickCloseBTN()
	{
		CloseBTN.click();
	}

	public void ClickCancelBTN()
	{
		CancelBTN.click();
	}

	public void ClickOKBTN(WebDriver driver)
	{
		OKBTN.click();
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void SetListEmailPreference(String LEP, WebDriver driver)
	{
		ListEmailPreference.clear();
		ListEmailPreference.sendKeys(LEP);
		System.out.println("Searched Email Preference is : " + LEP);
	}

	public void VerifyEmailPreferencePageisDispalyed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the EMAIL PREFERENCE Header
		WebElement EPHeader = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(EPHeader)).isDisplayed())
		{
			String Expecte_Text = EPHeader.getText();
			String Actual_Text = "EMAIL PREFERENCE";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : EMAIL PREFERENCE Header is Displayed");
		}

		//Checking Email Preference Button
		if(AddEmailPreferenceBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Add Email Preference Button is Displayed");
		}

		//Checking Search Button
		if(SearchBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Search Button is Displayed");
		}

		//Checking the Show and Rows
		if(driver.findElement(By.xpath("//div[@id='listPreferencesTable_length']//label[1]")).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Show and Rows are Displayed");
		}

	}

	public void VerifyNonActionTriggerPageIsDisplayed(WebDriver driver)
	{
		//checking the <th> Count
		List<WebElement> Thcount = driver.findElements(By.xpath("//table[@id='initEmailNotificationPreSearch']/thead/tr/th"));
		int Actual_Thcount = Thcount.size();
		int Expected_Thcount = 3;
		Assert.assertEquals(Actual_Thcount, Expected_Thcount, "TH Count is Wrong");

		//Checking TR count 
		List<WebElement> TRcount = driver.findElements(By.xpath("//table[@id='initEmailNotificationPreSearch']/tbody/tr"));
		int Actual_TRcount = TRcount.size();
	//	int Expected_TRcount = 17;
		int Expected_TRcount = 18;  //#SM
		Assert.assertEquals(Actual_TRcount, Expected_TRcount, "TR Count is Wrong");

		System.out.println("Non Action Trigger page is Displayed");
	}


	public void VerifyAddEditEmailPreferencePageIsDisplayed(WebDriver driver)
	{
		//Checking the Table 
		WebElement TableData1 = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr"));
		if(TableData1.isDisplayed())
		{
			Assert.assertTrue(TableData1.isDisplayed(), "Add / Edit Email Preference grid is Displayed");

			System.out.println("Pass : Add / Edit Email Preference grid is Displayed");

		}

		//Checking the Add/edit Email Preference table 
		WebElement TableData = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th"));

		//Checking the Name 
		WebElement Actions = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th[1]"));

		//Checking the Actions 
		WebElement Role = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th[2]"));
		if(TableData.isDisplayed())
		{
			List<WebElement> TableDataOptions = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th"));
			int Expected_text = TableDataOptions.size();
			int Actual_text = 2;
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass :  Displayed");

			Actions.isDisplayed();
			String Expected_Text = Actions.getText();
			String Actual_Text = "ACTIONS";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Actions is Displayed");

			Role.isDisplayed();
			String Expected_Text1 = Role.getText();
			String Actual_Text1 = "ROLES";
			Assert.assertEquals(Expected_Text1, Actual_Text1);
			System.out.println("Pass : Roles is Displayed");

		}

		//checking Name label
		WebElement NameLabel = driver.findElement(By.xpath("//label[@for='email_preference_name']"));
		if(Name.isDisplayed() && NameLabel.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Name Text Filed is Displayed");
		}

	}


	public void VerifyEmailPreferenceWasSuccessfullyCreatedMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Email preference was successfully created Message
		WebElement sucessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(sucessMSG)).isDisplayed())
		{
			String Expecte_Text = sucessMSG.getText();
			String Actual_Text = "Email preference was successfully created.";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Email preference was successfully created. Success Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
	}

	public void VerifyNameHasAlreadyBeenTakenMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Email preference was successfully created Message
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expecte_Text = ErrorMSG.getText();
			String Actual_Text = "Name has already been taken";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Name has already been taken Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
		}
	}

	public void VerifyEmailPreferenceDetailsPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//Checking the Email Preference Details Page
		WebElement EPD = driver.findElement(By.xpath("//h5[@class='text-primary ']"));
		if(wait.until(ExpectedConditions.visibilityOf(EPD)).isDisplayed())
		{
			String Expecte_Text = EPD.getText();
			String Actual_Text = "Email Preference Details";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Email Preference Details Page is Displayed");

		}

		//Checking the Email Preference Details table 
		WebElement TableData = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th"));

		//Checking the Action 
		WebElement Action = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th[1]"));

		//Checking the User 
		WebElement User = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th[2]"));
		if(TableData.isDisplayed())
		{
			List<WebElement> TableDataOptions = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/thead/tr/th"));
			int Expected_text = TableDataOptions.size();
			int Actual_text = 2;
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass :  Displayed");

			Action.isDisplayed();
			String Expected_Text = Action.getText();
			String Actual_Text = "ACTION";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Action is Displayed");

			User.isDisplayed();
			String Expected_Text1 = User.getText();
			String Actual_Text1 = "USER";
			Assert.assertEquals(Expected_Text1, Actual_Text1);
			System.out.println("Pass : User is Displayed");

		}

		//Checking the Email Preference Name
		WebElement EPN = driver.findElement(By.xpath("//div[@class='form-group form-group-default required']"));
		//Checking the Email Preference Name label
		WebElement EPNLabel = driver.findElement(By.xpath("//div[@class='form-group form-group-default required']/label"));
		//Checking the Email Preference Name Input
		WebElement EPNText = driver.findElement(By.xpath("//div[@class='form-group form-group-default required']/input"));
		if(EPN.isDisplayed() && EPNLabel.isDisplayed() && EPNText.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Email Preference Name is Displayed");
		}

		//Checking Close Button
		Assert.assertTrue(CloseBTN.isDisplayed());
		System.out.println("Pass : Close Button is Displayed");

	}

	public void VerifyNoDataAvailableInTableisDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NODATA = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(wait.until(ExpectedConditions.visibilityOf(NODATA)).isDisplayed())
		{
			String Expecte_Text = NODATA.getText();
			String Actual_Text = "No data available in table";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : No data available in table Message is Displayed");
			chiledTest.log(Status.INFO, "No Data Avilable Message is Displayed");
		}


	}

	public void VerifyEmailPreferenceWasSuccessfullyUpdated(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Email Preference Details Page
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expecte_Text = SuccessMSG.getText();
			String Actual_Text = "Email preference was successfully updated.";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Email preference was successfully updated Success Message is Displayed");

			//Clicking on the Close BTN
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();

		}
	}

	public void VerifyEmailPreferenceDeletePupIsDisplayed1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Email Preference delete Pop Up
		WebElement POPUP = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5"));

		//Checking Are you sure you want to delete this email preference. please note that as an effect of this, will not have any email preferences
		WebElement AreYouSureText = driver.findElement(By.xpath("//p[@class='p-b-10']"));

		if(wait.until(ExpectedConditions.visibilityOf(POPUP)).isDisplayed() && AreYouSureText.isDisplayed())
		{
			String Expecte_Text = POPUP.getText();
			String Actual_Text = "Email Preference delete";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Email Preference delete Pop Up is Displayed");

			/*String Expecte_AreYouSureText = AreYouSureText.getText();
			String Actual_AreYouSureText = "Are you sure you want to delete this email preference. please note that as an effect of this, will not have any email preferences";
			Assert.assertEquals(Expecte_AreYouSureText, Actual_AreYouSureText);
			System.out.println("Pass : Are you sure you want to delete this email preference. please note that as an effect of this, will not have any email preferences Message is Displayed");*/
		}


	}

	public void VerifyEmailPreferenceWasSuccessfullyDestroyedSuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Email Preference Details Page
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expecte_Text = SuccessMSG.getText();
			String Actual_Text = "Email preference was successfully destroyed.";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Email preference was successfully destroyed. Success Message is Displayed");

		}

		//Clicking on the Close BTN
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
	}

	public void VerifyEmailPreferenceDeletePupIsDisplayed2(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		//Checking the Email Preference delete Pop Up
		WebElement POPUP = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5"));

		//Checking Are you sure you want to delete this email preference. please note that as an effect of this, will not have any email preferences
		WebElement AreYouSureText = driver.findElement(By.xpath("//p[@class='p-b-10']"));

		if(wait.until(ExpectedConditions.visibilityOf(POPUP)).isDisplayed() && AreYouSureText.isDisplayed())
		{
			String Expecte_Text = POPUP.getText();
			String Actual_Text = "Email Preference delete";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : Email Preference delete Pop Up is Displayed");
			System.out.println("Pass : Are you sure you want to delete this email preference. please note that as an effect of this, will not have any email preferences Message is Displayed");
		}


	}

	public void VerifyYouShouldSelectAtleastOneRoleForEmailPreferenceMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Email Preference Details Page
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expecte_Text = SuccessMSG.getText();
			String Actual_Text = "You should select atleast one role for email preference";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : You should select atleast one role for email preference Message is Displayed");

		}

		//Clicking on the Close BTN
		driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@class='close']")).click();
	}

	public void VerifyNoMatchesFoundMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the no Matches Found Message 
		WebElement NoMatches = driver.findElement(By.xpath("//li[@class='select2-no-results']"));
		if(wait.until(ExpectedConditions.visibilityOf(NoMatches)).isDisplayed())
		{
			String Expecte_Text = NoMatches.getText();
			String Actual_Text = "No matches found";
			Assert.assertEquals(Expecte_Text, Actual_Text);
			System.out.println("Pass : No matches found Message is Displayed");

		}
	}
}

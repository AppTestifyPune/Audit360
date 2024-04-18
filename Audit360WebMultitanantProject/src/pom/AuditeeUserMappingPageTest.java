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
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class AuditeeUserMappingPageTest {

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clicking on the Auditee User Mappings from side menu
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Auditee user mappings']")
	private WebElement AuditeeUserMappings;
	
	//Clicking on the Auditee User Mappings Header
	@FindBy(xpath="//a[contains(@class,'active')]")
	private WebElement AuditeeUserMappingsHeader;

	//Passing the Values to Serach Text Box
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SerachBTN;

	//Checking the add new Auditee-User Mapping
	@FindBy(xpath="//a[@class='btn btn-primary m-l-10 m-t-10 add_auditee_to_users']")
	private WebElement AddNewAuditeeBTN;

	//Clicking Submit Button
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement SubmitBTN;

	//clicking close Button
	@FindBy(xpath="//i[@class='pg-close fs-14']")
	private WebElement CloseBTN;

	//Clicking on the Please Select
	@FindBy(xpath="//span[text()='Please Select']")
	private WebElement PleaseSelect;

	//Passing the Value to Auditee 
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement Auditee;
	
	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;
	

	//Clicking on the View Button
	@FindBy(xpath="//table[@id='listAuditeeUsersTable']/tbody/tr/td[3]/a[@class='btn btn-clear']")
	private WebElement ViewBTN;

	//Clicking on the Edit Button
	@FindBy(xpath="//table[@id='listAuditeeUsersTable']/tbody/tr/td[3]/a[@class='btn btn-info m-l-10']")
	private WebElement EditBTN;

	//Passing the Values to Auditee User
	@FindBy(xpath="//div[@id='s2id_auditee_user_ids']//input[@type='text']")
	private WebElement AuditeeUserText;

	public AuditeeUserMappingPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickAuditeeUserMappings(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditeeUserMappings);
	}
	
	public void ClickAuditeeUserMappingsHeader(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditeeUserMappingsHeader);
	}

	public void ClickAddNewAuditeeBTN()
	{
		AddNewAuditeeBTN.click();
	}

	public void ClickSubmitBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SubmitBTN)).click();
		//SubmitBTN.click();
	}

	public void ClickCloseBTN()
	{
		CloseBTN.click();
	}

	public void ClickPleaseSelect()
	{
		PleaseSelect.click();
	}

	public void SetAuditee(String SA, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(Auditee)).sendKeys(SA);
		System.out.println("Enterd Auditee is : " + SA);
	}

	
	public void ClickMatched()
	{
		Matched.click();
	}

	public void SetAuditeeUser(String AUT, WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(AuditeeUserText)).sendKeys(AUT);
		
	}

	public void SetSerachBTN(String SB)
	{
		SerachBTN.clear();

		SerachBTN.sendKeys(SB);
		System.out.println("searched Auditee User is : " + SB);
	}

	public void ClickViewBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(ViewBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ViewBTN);
		}catch (StaleElementReferenceException e) {

		}
	}
	
	public void SetAuditeeUserText(String AU)
	{
		AuditeeUserText.sendKeys(AU);
		System.out.println("Entered Auditee User is : " + AU);
	}

	public void ClickEditBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(EditBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", EditBTN);
		}catch (StaleElementReferenceException e) {

		}

	}

	public void VerifyAuditeeMapUserPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Auditee map User Header
		WebElement AUM = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(AUM)).isDisplayed())
		{
			String Expected_text = AUM.getText();
			String Actual_text = "AUDITEE MAP USER";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Auditee Map User Page is Displayed");
		}

		//Checking the Auditee User Table 
		WebElement Table = driver.findElement(By.xpath("//table[@id='listAuditeeUsersTable']"));
		if(Table.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass: Auditee User Table is Displayed");

			//Checking the Table head count
			List<WebElement> Count = driver.findElements(By.xpath("//table[@id='listAuditeeUsersTable']/thead/tr/th"));
			int Expected_count = Count.size();
			int Actual_count = 3;
			Assert.assertEquals(Expected_count, Actual_count);
		}

		//Checking the Search Text Box
		if(SerachBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Serach Button is Displayed");

		}

		//Checking the show and Rows
		WebElement show = driver.findElement(By.xpath("//div[@class='col-md-6 col-xs-12 p-l-0']//label[1]"));
		if(show.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Show and rows are Displayed");
		}

		//Checking Add new Auditee - User Mapping Button
		if(AddNewAuditeeBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Add new Auditee - User Mapping Button is Displayed");
		}

	}

	public void VerifyAddAuditeeToUserpageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Add Auditee To User header
		WebElement AATU = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h4"));
		if(wait.until(ExpectedConditions.visibilityOf(AATU)).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Add Auditee To User header is Displayed");
		}

		//Checking Auditee Label
		WebElement AuditeeLabel = driver.findElement(By.xpath("//label[@for='Auditee']"));
		if(AuditeeLabel.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Auditee Label is Displayed");
		}

		//Checking Auditee User Label
		WebElement AU = driver.findElement(By.xpath("//label[@for='Auditee_Users']"));
		if(AU.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Auditee User Label is Displayed");
		}

		//Checking Submit Button and Close Button
		if(SubmitBTN.isDisplayed() && CloseBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Submit Button and Close Button is Displayed");
		}
	}

	public void VerifyUserAddedToAuditeeSuccessfullySucessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "User added to auditee successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : User added to auditee successfully Success Message is Displayed");

			//clicking on the close button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}
	}

	public void VerifyNoDataAvailableInTable(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NOData = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(wait.until(ExpectedConditions.visibilityOf(NOData)).isDisplayed())
		{
			String Actual_Text = NOData.getText();
			String Expected_Text = "No data available in table";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : No data available in table Message is Displayed");
		}
	}


	public void VerifyShowAuditeePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking Show Auditee Page is Displayed
		WebElement ShowAuditee = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h4"));
		if(wait.until(ExpectedConditions.visibilityOf(ShowAuditee)).isDisplayed())
		{
			String Expected_text = ShowAuditee.getText();
			String Actual_text = "Show Auditee";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Show Auditee Page is Displayed");
		}

		//Checking Audit Name
		WebElement AuditName = driver.findElement(By.xpath("//select[@id='auditee_id']"));

		//Checking Auditee Users Options
		WebElement AuditeeUserOption = driver.findElement(By.xpath("//select[@id='auditee_user_ids']"));

		//Checking Auditee User Label
		WebElement Label = driver.findElement(By.xpath("//label[@for='Auditee_Users']"));
		if(AuditName.isDisplayed() && AuditeeUserOption.isDisplayed() && Label.isDisplayed() && CloseBTN.isDisplayed())
		{
			System.out.println("Pass : Audit Name is Displayed");
			System.out.println("Pass : Auditee Users Options is Displayed");
			System.out.println("Pass : Auditee User is Displayed");
			System.out.println("Pass : close Button is Displayed");
		}
	}


	public void VerifyUpdateAuditeePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);

		//Checking Show Auditee Page is Displayed
		WebElement ShowAuditee = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h4"));
		if(wait.until(ExpectedConditions.visibilityOf(ShowAuditee)).isDisplayed())
		{
			String Expected_text = ShowAuditee.getText();
			String Actual_text = "Update Auditee";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Show Auditee Page is Displayed");
		}

		//Checking Audit Name
		WebElement AuditName = driver.findElement(By.xpath("//div[@id='s2id_auditee_id']//a[@class='select2-choice']"));

		//Checking Auditee Users Options
		WebElement AuditeeUserOption = driver.findElement(By.xpath("//div[@id='s2id_auditee_user_ids']/ul[@class='select2-choices']"));

		//Checking Auditee User Label
		WebElement Label = driver.findElement(By.xpath("//label[@for='Auditee_Users']"));

		//Checking Auditee Label
		WebElement AuditeeLabel = driver.findElement(By.xpath("//label[@for='Auditee']"));

		if(AuditName.isDisplayed() && AuditeeUserOption.isDisplayed() && Label.isDisplayed() && CloseBTN.isDisplayed() && AuditeeLabel.isDisplayed() && SubmitBTN.isDisplayed())
		{
			System.out.println("Pass : Audit Name is Displayed");
			System.out.println("Pass : Auditee Users Options is Displayed");
			System.out.println("Pass : Auditee User is Displayed");
			System.out.println("Pass : close Button is Displayed");
			System.out.println("Pass : Submit Button is Displayed");
		}
	}


	public void VerifyUpdatedAuditeeUsersSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Updated auditee users successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Updated auditee users successfully Success Message is Displayed");

			//clicking on the close button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}
	}
	
	public void VerifyMandatoryMessageisDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		SoftAssert softAssert = new SoftAssert();
		//checking Auditee 
		WebElement Auditee = driver.findElement(By.xpath("//div[@class='form-group form-group-default form-group-default-select2 required']//select[@id='auditee_id'][@required='required']"));
		softAssert.assertTrue(Auditee.isDisplayed(), "Auditee should be Required field");
		
		//checking the Auditee Users 
		WebElement AuditeeUsers = driver.findElement(By.xpath("//div[@class='form-group form-group-default form-group-default-select2 required']//select[@id='auditee_user_ids'][@required='required']"));
		softAssert.assertTrue(AuditeeUsers.isDisplayed(), "Auditee Users should be Required field");
		
		softAssert.assertAll();
		
	}
}

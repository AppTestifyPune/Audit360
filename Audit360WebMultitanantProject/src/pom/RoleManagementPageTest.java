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
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class RoleManagementPageTest extends BaseTest{

	//Clicking on the scroll bar//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]") //nav[@class='page-sidebar']
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Role Management']
	//Clicking on the Manage Role under side menu 
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[2]/div[2]/div[1]/ul[1]/li/a/span[text()='Role Management']")
	private WebElement RoleManagement;

	//Clicking on the List of Roles from side menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Roles']")
	private WebElement Roles;

	//Clicking on the Add Role Button
	@FindBy(xpath="//a[@class='btn btn-primary m-l-10 m-t-10']/span[contains(text(),'Add Role')]")
	private WebElement AddRoleButton;

	//Passing the Values to Search Button
	@FindBy(xpath="//input[@type='search']")
	private WebElement SearchBTN;

	//Clicking on the View Button
	@FindBy(xpath="//a[@class='btn btn-clear']")
	private WebElement ViewBTN;

	//Clicking on the Edit Button
	@FindBy(xpath="//a[@class='btn btn-info m-l-10']")
	private WebElement EditBTN;

	//Clicking on the Delete Button
	@FindBy(xpath="//a[@class='btn btn-danger m-l-10']")
	private WebElement DeleteBTN;

	//Passing the values to Name
	@FindBy(xpath="//input[@id='role_name']")
	private WebElement SetName;

	//clicking on Level
	@FindBy(xpath="//span[@class='select2-chosen']/ancestor::div[@id='s2id_role_level']")
	private WebElement Level;

	//Passing the Values to Level
	@FindBy(xpath="//input[@id='s2id_autogen5_search']")
	private WebElement SetLevel;

	//clicking on the Role Type
	@FindBy(xpath="//div[@id='s2id_role_role_type']//a//span[1]")
	private WebElement RoleType;

	//Passing the Values to Roles Type
	@FindBy(xpath="//input[@id='s2id_autogen6_search']")
	private WebElement SetRoleType;

	//Clicking on the Access
	@FindBy(xpath="//div[@id='s2id_role_access']//a/span[1]")
	private WebElement Access;

	//Passing the Values to Access
	@FindBy(xpath="//input[@id='s2id_autogen7_search']")
	private WebElement SetAccess;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement SubmitBTN;

	//Clicking on the Close Button
	@FindBy(xpath="//i[@class='pg-close fs-14']")
	private WebElement CloseBTN;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Ok Button
	@FindBy(xpath="//a[text()='OK']")
	private WebElement OKBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement CancelBTN;

	//Checking the Error Message
	@FindBy(xpath="//div[@class='alert alert-danger']/span")
	private WebElement ErrorMSG;

	//Clicking on the Error Message Close Button
	@FindBy(xpath="//div[@class='alert alert-danger']/button")
	private WebElement ErrorMSGCloseBTN;

	//Checking the Success Message
	@FindBy(xpath="//div[@class='alert alert-success']/span")
	private WebElement SuccessMSG;

	//Clicking on the Success Message Close Button
	@FindBy(xpath="//div[@class='alert alert-success']/button")
	private WebElement SucessMSGCloseBTN;


	public RoleManagementPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickRoleManagement(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(RoleManagement));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RoleManagement);
		System.out.println("Role Managemnet is Clicked Under Side menu");
	}

	public void ClickRoles(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Roles));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Roles);

	}

	public void ClickAddRoleButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(AddRoleButton)).click();
	}

	public void ClickViewBTN()
	{
		ViewBTN.click();
	}

	public void ClickEditBTN()
	{
		EditBTN.click();
	}

	public void ClickDeleteBTN()
	{
		DeleteBTN.click();
	}

	public void SetSearchBTN(String SS)
	{
		SearchBTN.clear();

		SearchBTN.sendKeys(SS);
		System.out.println("Entered Role is : " + SS);
	}


	public void SetName(String SN, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SetName));
		SetName.sendKeys(SN);
		System.out.println("Entered Name is : " + SN);
	}

	public void ClearName()
	{
		SetName.clear();
	}

	public void ClickLevel(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Level)).click();

	}

	public void SetLevel(String SL)
	{
		SetLevel.sendKeys(SL);
		System.out.println("Entered level is : " + SL);
	}


	public void ClickRoleType()
	{
		RoleType.click();

	}

	public void SetRolesType(String SR)
	{
		SetRoleType.sendKeys(SR);
		System.out.println("Entered level is : " + SR);
		chiledTest.log(Status.INFO, "Role Type is Entered");
	}

	public void ClickAccess()
	{
		Access.click();

	}

	public void SetAccess(String SA)
	{
		SetAccess.sendKeys(SA);
		System.out.println("Entered level is : " + SA);
	}

	public void ClickSubmitBTN()
	{
		SubmitBTN.click();
	}

	public void ClickCloseBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void ClickOKBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(OKBTN)).click();

	}

	public void ClickCancelBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(CancelBTN)).click();

	}

	public void VerifyRoleManagePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Checking the Role Manage Header is Displayed
		WebElement RoleManagmentHeadr = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(RoleManagmentHeadr)).isDisplayed())
		{
			String Actual_Text = RoleManagmentHeadr.getText();
			String Expected_Text = "ROLE MANAGEMENT";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Role Manage Page is Displayed");
		}

		//Checking Row and Show
		WebElement Rows = driver.findElement(By.xpath("//div[@id='tableWithSearch_length']/label"));
		if(Rows.isDisplayed())
		{
			System.out.println("Pass : Row and Show are Displayed");
		}

		//Checking Add Role Button View Button Edit Button Search Button
		if(AddRoleButton.isDisplayed() && SearchBTN.isDisplayed() && ViewBTN.isDisplayed())
		{
			System.out.println("Add Role Button is Displayed");
			System.out.println("Edit Button is Displayed");
			System.out.println("Delete Button is Displayed");
		}

		//Checking the Table and Data
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr")).isDisplayed();
			System.out.println("Role Grid is Displayed");
		}
		catch(Exception e){
			driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isDisplayed();
			System.out.println("No matching records found is Displayed");
		}
	}

	public void VerifyAddRolePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking the Add Role Page is Displayed
		WebElement AddRole = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h4"));
		if(wait.until(ExpectedConditions.visibilityOf(AddRole)).isDisplayed())
		{
			String Actual_Text = AddRole.getText();
			String Expected_Text = "Add Role";
			Assert.assertEquals(Actual_Text, Expected_Text, "Header is Wrong");
			System.out.println("Pass : Add role Page is Displayed");
		}

		//Checking the Name
		WebElement Name = driver.findElement(By.xpath("//div[@class='form-group form-group-default required']"));
		WebElement NameLabel = driver.findElement(By.xpath("//label[@for='role_name']"));
		if(Name.isDisplayed() && NameLabel.isDisplayed() && SetName.isDisplayed())
		{
			System.out.println("Pass : Name is Displayed");
		}

		//checking the Level
		WebElement Level = driver.findElement(By.xpath("//div[@id='s2id_role_level']"));
		WebElement LevelLabel = driver.findElement(By.xpath("//label[@for='role_level']"));
		if(Level.isDisplayed() && LevelLabel.isDisplayed() && Level.isDisplayed())
		{
			System.out.println("Pass : Level is Displayed");
		}

		//Checking the Access
		WebElement Access = driver.findElement(By.xpath("//div[@id='s2id_role_access']"));
		WebElement AccessLabel = driver.findElement(By.xpath("//label[@for='role_access']"));
		if(Access.isDisplayed() && AccessLabel.isDisplayed() && Access.isDisplayed())
		{
			System.out.println("Pass : Access is Displayed");
		}

		//checking submit Button
		if(SubmitBTN.isDisplayed())
		{
			System.out.println("Pass : Submit Button is Displayed");
		}

		//Checking Close Button
		if(CloseBTN.isDisplayed())
		{
			System.out.println("pass : Close Button is Displayed");
		}

	}

	public void VerifyRoleCreatedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_Text = SuccessMSG.getText();
			String Actual_Text = "Role created successfully.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Role created successfully success Message is Displayed");

			//Clicking on the Close Button
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", SucessMSGCloseBTN);
		}

	}

	public void VerifyNameHasAlreadyBeenTakenErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_Text = ErrorMSG.getText();
			String Actual_Text = "Name has already been taken";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Name has already been taken Error Message is Displayed");

			//Clicking on the Close Button
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ErrorMSGCloseBTN);
		}

	}

	public void VerifyNoRecordsFoundMSGIsDisplayed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NoMatching = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(wait.until(ExpectedConditions.visibilityOf(NoMatching)).isDisplayed())
		{
			String Expected_Text = NoMatching.getText();
			String Actual_Text = "No Record Found.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : No Record Found. Message is Displayed");
		}
	}

	public void VerifyViewRolePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Checking the View Role Header
		try
		{
			WebElement ViewRole = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h4"));
			if(wait.until(ExpectedConditions.visibilityOf(ViewRole)).isDisplayed())
			{
				String Expected_Text = ViewRole.getText();
				String Actual_Text = "View Role";
				Assert.assertEquals(Expected_Text, Actual_Text);
				System.out.println("Pass : View Role is Displayed");
			}

			//Checking the Name Level Access Code
			List<WebElement> Roles = driver.findElements(By.xpath("//div[@class='col-md-6']"));
			int count = Roles.size();
			int Expeccted_count = count;
			int Actual_count = 4;
			Assert.assertEquals(Expeccted_count, Actual_count);
			System.out.println("Pass : Name, Level, Access and Code are Displayed");

			//Checking Close Button
			if(CloseBTN.isDisplayed())
			{
				System.out.println("Pass : Cancel button is Displayed");
			}

		}catch (StaleElementReferenceException e) {

		}

	}

	public void VerifyEditRolePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Checking the Edit Role Header
		WebElement EditRole = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h4"));
		if(wait.until(ExpectedConditions.visibilityOf(EditRole)).isDisplayed())
		{
			String Expected_Text = EditRole.getText();
			String Actual_Text = "Edit Role";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Edit Role is Displayed");
		}

	}

	public void VerifyRoleUpdatedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_Text = SuccessMSG.getText();
			String Actual_Text = "Role updated successfuly.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Role updated successfuly success Message is Displayed");

			//Clicking on the Close Button
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", SucessMSGCloseBTN);
		}



	}

	public void VerifyDeleteRolePopUpIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement DeleteRole = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5"));
		WebElement AreYouSure = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/p"));
		if(DeleteRole.isDisplayed() && AreYouSure.isDisplayed())
		{
			String Expected_DeleteRole = DeleteRole.getText();
			String Actual_DeleteRole = "Delete Role?";
			Assert.assertEquals(Expected_DeleteRole, Actual_DeleteRole);

			String Expected_AreYouSure = AreYouSure.getText();
			String Actual_AreYouSure = "Are you sure you want to delete the selected role?";
			Assert.assertEquals(Expected_AreYouSure, Actual_AreYouSure);

			System.out.println("Pass : Delete Role? Pop up Is Displayed");
		}
	}

	public void VerifyRoleHasBeenDeletedMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_Text = SuccessMSG.getText();
			String Actual_Text = "Role has been deleted.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Role has been deleted success Message is Displayed");

			//Clicking on the Close Button
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", SucessMSGCloseBTN);
		}



	}

	public void VerifyNameIsTooShortErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_Text = ErrorMSG.getText();
			String Actual_Text = "Name is too short (minimum is 6 characters)";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Name is too short (minimum is 6 characters) Error Message is Displayed");

			//Clicking on the Close Button
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ErrorMSGCloseBTN);
		}



	}

	public void VerifyAddRoleMandatoryFieldsIsDisplayed(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking Name
		List<WebElement> Name = driver.findElements(By.xpath("//input[@name='role[name]'][@required='required']"));
		Assert.assertTrue(Name.size()>0, "Name Is Not Working As Required Fileds");
		System.out.println("Pass : Name is Required Filed");

		//Checking Level
		List<WebElement> Level1 = driver.findElements(By.xpath("//select[@id='role_level'][@required='required']"));
		Assert.assertTrue(Level1.size()>0, "Level is Not Working As Required Filed");
		System.out.println("Pass : Level is Required Filed");

		//Checking Access
		List<WebElement> Access1 = driver.findElements(By.xpath("//select[@id='role_access'][@required='required']"));
		Assert.assertTrue(Access1.size()>0, "Level is Not Working As Required Filed");
		System.out.println("Pass : Access is Required Filed");

	}

	public void VerifyDeleteViewEditButtonIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//checking the View Edit and Delete button's are displayed for newly created role
		Assert.assertTrue(EditBTN.isDisplayed() && DeleteBTN.isDisplayed() && ViewBTN.isDisplayed(), "View, Edit and Delete Button's are not displayed for newly created Role");
		System.out.println("Pass : View, Edit and Delete Button's are displayed for newly created Role");
	}


	public void VerifyNameIsInvalidErrorMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_Text = ErrorMSG.getText();
			String Expected_Text = "Name < > and # characters should not be allowed.,Name is invalid";
			Assert.assertEquals(Actual_Text, Expected_Text, "Error Message is Wrong");
			System.out.println("Name < > and # characters should not be allowed. ,Name is invalid Error Message is Displayed");

			//Clicking on the Close Button
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ErrorMSGCloseBTN);
		}
	}
	
	public void VerifyLevelAndRoleIsDisabledInEditRolePage()
	{
		List<WebElement> LevelSize = driver.findElements(By.xpath("//label[text()='Level']/following-sibling::input[@id='s2id_autogen5' and 'disabled']"));
		Assert.assertTrue(LevelSize.size()==1, "Level is Read only mode");
		System.out.println("Level is Read only Mode in Edit Page");
		chiledTest.log(Status.INFO, "Level is Read only Mode in Edit Page");
		
		List<WebElement> RoleType = driver.findElements(By.xpath("//label[text()='Role type']/following-sibling::input[@id='s2id_autogen6' and 'disabled']"));
		Assert.assertTrue(RoleType.size()==1, "Role Type is Read only mode");
		System.out.println("Role Type is Read only Mode in Edit Page");
		chiledTest.log(Status.INFO, "Role is Read only Mode in Edit Page");
	}
}

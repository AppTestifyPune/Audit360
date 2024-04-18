package pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ManageRolePageTest {


	//Clicking on the scroll bar
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clikcing on the Manage Role under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Manage Roles']")
	private WebElement ManageRole;

	//Clicking on the Assign Roles Button
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement AssignRolesBTN;
	
	//Passing the Values to Search Button
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBTN;
	
	//Clicking on the Select All
	@FindBy(xpath="//label[@for='checkall']")
	private WebElement SelectAllCheckBox;
	
	//clikcing on the Check Box
	@FindBy(xpath="//table[@id='RolestableWithSearch']/tbody/tr[1]/td[4]/div/label")
	private WebElement CheckBoxBTN;
	
	//Passing the Values to Roles
	@FindBy(xpath="//input[@id='s2id_autogen16']")
	private WebElement SetRoles;
	
	//Clicking on the Ok Button
	@FindBy(xpath="//button[text()='Ok']")
	private WebElement OkBTN;
	
	//Clicking on the Delete Button
	@FindBy(xpath="//a[@class='select2-search-choice-close']")
	private WebElement DeleteBTN;
	


	public ManageRolePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickManageRole(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageRole);
	}

	public void SetSearchBTN(String SS)
	{
		SearchBTN.sendKeys(SS);
		System.out.println("Searched Role is : " + SS);
	}
	
	public void ClearSearchBTN()
	{
		SearchBTN.clear();
	}

	public void ClickOkBTN()
	{
		OkBTN.click();
	}
	
	public void ClickSelectAllCheckBox()
	{
		SelectAllCheckBox.click();
	}
	
	public void ClickCheckBoxBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CheckBoxBTN);
		
	}
	
	public void SetRoles(String SR)
	{
		SetRoles.sendKeys(SR);
		System.out.println("Selected role is : " + SR);
	}
	
	public void ClickAssignRolesBTN()
	{
		AssignRolesBTN.click();
	}
	
	public void ClickDeleteBTN()
	{
		DeleteBTN.click();
	}
	
	
	public void VerifyTextisUpdatedinUsersOrNot(WebDriver driver)
	{
		String bodyText = driver.findElement(By.xpath("//div[@id='s2id_selected_users']//ul[@class='select2-choices']")).getText();
		Assert.assertTrue(bodyText.contains(bodyText));
	}
	
	
	public void VerifyManageRolePageIsDisplayed(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		//Checking the Manage Role Page
		WebElement ManageRolepage = driver.findElement(By.xpath("//a[@class='active']"));

		//Checking Manage Roles Header
		WebElement ManageRoles = driver.findElement(By.xpath("//h4[contains(text(),'Manage Roles')]"));

		//Checking Filter users by location Text
		WebElement FilterUserByLocation = driver.findElement(By.xpath("//h5[contains(text(),'Filter users by location')]"));

		//Checking Select Country 
		WebElement SelectCountry = driver.findElement(By.xpath("//div[@id='s2id_country']"));

		//Checking Select Country Label
		WebElement SelectCountryLabel = driver.findElement(By.xpath("//label[text()='Select Country']"));

		//Checking Select State 
		WebElement SelectState = driver.findElement(By.xpath("//div[@id='s2id_state']"));

		//Checking Select State Label
		WebElement SelectStateLabel = driver.findElement(By.xpath("//label[text()='Select State']"));

		//Checking Select City 
		WebElement SelectCity = driver.findElement(By.xpath("//div[@id='s2id_city']"));

		//Checking Select City Label
		WebElement SelectCityLabel = driver.findElement(By.xpath("//label[text()='Select City']"));

		//Checking Select Zone 
		WebElement SelectZone = driver.findElement(By.xpath("//div[@id='s2id_zone']"));

		//Checking Select Zone Label
		WebElement SelectZoneLabel = driver.findElement(By.xpath("//label[text()='Select Zone']"));

		//Checking Select Area 
		WebElement SelectArea = driver.findElement(By.xpath("//div[@id='s2id_area']"));

		//Checking Select Area Label
		WebElement SelectAreaLabel = driver.findElement(By.xpath("//label[text()='Select Area']"));

		//Checking Shows and Rows
		WebElement Shows = driver.findElement(By.xpath("//div[@id='RolestableWithSearch_length']/label"));

		//Checking Tabel 
		WebElement Tabel = driver.findElement(By.xpath("//table[@id='RolestableWithSearch']"));

		//Checking User Name
		WebElement UserName = driver.findElement(By.xpath("//th[@class='sorting_asc']"));
		
		//Checking Email Id
		WebElement EmailId = driver.findElement(By.xpath("//th[@aria-label='Email Id: activate to sort column ascending']"));
		
		//Checking Role
		WebElement Role = driver.findElement(By.xpath("//th[@aria-label='Role: activate to sort column ascending']"));
		
		//Checking Select All
		WebElement SelectAll = driver.findElement(By.xpath("//th[@class='sorting_asc_disabled sorting_desc_disabled hider sorting']"));
		if(ManageRolepage.isDisplayed() && ManageRoles.isDisplayed() &&  SelectCountryLabel.isDisplayed() && FilterUserByLocation.isDisplayed() && SelectCountry.isDisplayed() && SelectCountry.isDisplayed() && SelectState.isDisplayed() && SelectStateLabel.isDisplayed() && SelectCity.isDisplayed() && SelectCityLabel.isDisplayed() && SelectZone.isDisplayed() && SelectZoneLabel.isDisplayed() && SelectArea.isDisplayed() && SelectAreaLabel.isDisplayed() && Shows.isDisplayed() && Tabel.isDisplayed() && UserName.isDisplayed() && EmailId.isDisplayed() && Role.isDisplayed() && SelectAll.isDisplayed() && SearchBTN.isDisplayed() && AssignRolesBTN.isDisplayed())
		{
			String Expected_text = ManageRolepage.getText();
			String Actual_text = "MANAGE ROLE";
			Assert.assertEquals(Expected_text, Actual_text);
			
			String Expected_Filter = FilterUserByLocation.getText();
			String Actual_Filter = "Filter users by location";
			Assert.assertEquals(Expected_Filter, Actual_Filter);
			
			String Expected_UserName = UserName.getText();
			String Actual_UserName = "USER NAME";
			Assert.assertEquals(Expected_UserName, Actual_UserName);
			
			String Expected_EmailId = EmailId.getText();
			String Actual_EmailId = "EMAIL ID";
			Assert.assertEquals(Expected_EmailId, Actual_EmailId);
			
			String Expected_Role = Role.getText();
			String Actual_Role = "ROLE";
			Assert.assertEquals(Expected_Role, Actual_Role);
			
			String Expected_SelectAll = SelectAll.getText();
			String Actual_SelectAll = "SELECT ALL";
			Assert.assertEquals(Expected_SelectAll, Actual_SelectAll);
			
			//Checking the TR
			try
			{
				boolean TR = driver.findElement(By.xpath("//table[@id='RolestableWithSearch']/tbody/tr[@class='odd' or @class='even']")).isDisplayed();
				System.out.println("Pass : Role Grid is displayed : " + TR);
			}catch (Exception e) {
				
				boolean NoData = driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isDisplayed();
				System.out.println("Pass : No data available in table Message is Displayed : " + NoData);
				
				
			}
			
			
			System.out.println("Pass : Manage Role page Is Displayed");
			
		}
		
	}
	
	public void VerifyUserRolesUpdatedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement SuccessMsg = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMsg)).isDisplayed())
		{
			String Expected_Text = SuccessMsg.getText();
			String Actual_Text = "User(s) roles updated Successfully";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : User(s) roles updated Successfully Message is Displayed");
		}
		
		//Clikcing on the close button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
	}
	
	public void VerifyMandatoryfieldsIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Roles = driver.findElement(By.xpath("//select[@id='role_ids_'][@required='required']"));
		if(Roles.isDisplayed())
		{
			System.out.println("Pass : Roles is Required Field");
		}
	}
	
	public void VerifyMinimumOneRoleShouldBeAssignedToUserMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement SuccessMsg = driver.findElement(By.xpath("//font[@size='3']"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMsg)).isDisplayed())
		{
			String Expected_Text = SuccessMsg.getText();
			String Actual_Text = "Minimum one role should be assigned to a user.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass :  Minimum one role should be assigned to a user. Success Message is Displayed");
		}
	}
	
	public void VerifySearchedRoleIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement TR = driver.findElement(By.xpath("//table[@id='RolestableWithSearch']/tbody/tr[@role='row']"));
		if(TR.isDisplayed())
		{
			System.out.println("Pass : Searched Role is Displayed");
		}
		
	}
	
	
	public void VerifyNoMatchingRecordsFoundErrorIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement NoData = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(NoData.isDisplayed())
		{
			
			System.out.println("Pass : No matching records found Error Message is Displayed");
		}
		
	}
}

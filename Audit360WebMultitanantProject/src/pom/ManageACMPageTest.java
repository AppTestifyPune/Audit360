package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ManageACMPageTest {

	//Clicking on the scroll bar
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clikcing on the Manage Role under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Role Management']")
	private WebElement RoleManagement;

	//Clicking on the List of Roles from side menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Manage ACM']")
	private WebElement ManageACM;

	//Clicking on the Select Role
	@FindBy(xpath="//span[@id='select2-chosen-3']")
	private WebElement SelectRole;

	//Passing the Values to Select Role
	@FindBy(xpath="//input[@id='s2id_autogen3_search']")
	private WebElement SetSelectRole;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement SubmitBTN;



	public ManageACMPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickRoleManagement(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RoleManagement);
	}

	public void ClickManageACM(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageACM);
	}

	public void ClickSelectRole()
	{
		SelectRole.click();
	}

	public void SetSelectRole(String SR)
	{
		SetSelectRole.sendKeys(SR);
		System.out.println("Selectd Role is : " + SR);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void ClickSubmitBTN()
	{
		SubmitBTN.click();
	}


	public void VerifyManageACMPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking Manage Role Header
		WebElement Header = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(Header)).isDisplayed())
		{
			String Expected_text = Header.getText();
			String Actual_text = "MANAGE ROLE";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Manage ACM Page is Displayed");
		}

		//Checking Role Label
		WebElement RoleLabel = driver.findElement(By.xpath("//label[contains(@for,'Role')]"));
		//Checking Select Role 
		if(RoleLabel.isDisplayed() && SelectRole.isDisplayed())
		{
			SelectRole.click();

			List<WebElement> SelectRoleOptions = driver.findElements(By.xpath("//ul[@id='select2-results-3']/li"));
			Assert.assertTrue(SelectRoleOptions.size()>1);
			System.out.println("Select Role Options are Displayed");
		}

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

	}


	public void VerifyAuditorRoleIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Checking the Role Count
		List<WebElement> RoleCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[1]"));
		int RoleTotalCount = RoleCount.size();
		System.out.println("Total Role Count is : " + RoleTotalCount);
		Assert.assertEquals(RoleTotalCount, 191);
		System.out.println(RoleTotalCount + " : Role's Are Displayed ");

		//Checking the CheckBox
		List<WebElement> CheckBoxCount1 = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input"));
		int CheckBoxTotalcount1 = CheckBoxCount1.size();
		System.out.println("Total Check Box Count is : " + CheckBoxTotalcount1);
		Assert.assertTrue(RoleTotalCount!=CheckBoxTotalcount1);

		//Enabled Check Box count
		List<WebElement> CheckBoxCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@checked='checked']"));
		int CheckBoxTotalcount = CheckBoxCount.size();
		//System.out.println("Total Check Box Count is : " + CheckBoxTotalcount);
		Assert.assertEquals(CheckBoxTotalcount, 30);
		System.out.println(CheckBoxTotalcount + " : Check Box's are Enabled ");

		/*for(int i=0; i<RoleTotalCount; i++)
		{
			WebElement AllRole = RoleCount.get(i);
			String Roletext = AllRole.getText();

			for(int j=0; j<CheckBoxTotalcount; j++)
			{

				WebElement AllCheckBox = CheckBoxCount.get(j);
				AllCheckBox.isEnabled();
			}	
			System.out.println(Roletext);
			System.out.println("Pass : Check Box are Enabled");

		}*/
	}


	public void VerifyAuditeeRoleIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Checking the Role Count
		List<WebElement> RoleCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[1]"));
		int RoleTotalCount = RoleCount.size();
		System.out.println("Total Role Count is : " + RoleTotalCount);
		Assert.assertEquals(RoleTotalCount, 191);
		System.out.println(RoleTotalCount + " : Role's are Displayed ");

		//Checking the CheckBox
		List<WebElement> CheckBoxCount1 = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input"));
		int CheckBoxTotalcount1 = CheckBoxCount1.size();
		System.out.println("Total Check Box Count is : " + CheckBoxTotalcount1);
		Assert.assertTrue(RoleTotalCount!=CheckBoxTotalcount1);

		//Enabled Check Box count
		List<WebElement> CheckBoxCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@checked='checked']"));
		int CheckBoxTotalcount = CheckBoxCount.size();
		//System.out.println("Total Check Box Count is : " + CheckBoxTotalcount);
		Assert.assertEquals(CheckBoxTotalcount, 19); 
		System.out.println(CheckBoxTotalcount + " : Check Box's are Enabled ");

		/*for(int i=0; i<RoleTotalCount; i++)
		{
			WebElement AllRole = RoleCount.get(i);
			String Roletext = AllRole.getText();

			for(int j=0; j<CheckBoxTotalcount; j++)
			{

				WebElement AllCheckBox = CheckBoxCount.get(j);
				AllCheckBox.isEnabled();
			}	
			System.out.println(Roletext);
			System.out.println("Pass : Check Box are Enabled");

		}*/
	}

	public void VerifyReviewerRoleIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Checking the Role Count
		List<WebElement> RoleCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[1]"));
		int RoleTotalCount = RoleCount.size();
		System.out.println("Total Role Count is : " + RoleTotalCount);
		Assert.assertEquals(RoleTotalCount, 191);
		System.out.println(RoleTotalCount + " : role's are displyed ");

		//Checking the CheckBox
		List<WebElement> CheckBoxCount1 = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input"));
		int CheckBoxTotalcount1 = CheckBoxCount1.size();
		System.out.println("Total Check Box Count is : " + CheckBoxTotalcount1);
		Assert.assertTrue(RoleTotalCount!=CheckBoxTotalcount1);

		//Enabled Check Box count
		List<WebElement> CheckBoxCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@checked='checked']"));
		int CheckBoxTotalcount = CheckBoxCount.size();
		//System.out.println("Total Check Box Count is : " + CheckBoxTotalcount);
		Assert.assertEquals(CheckBoxTotalcount, 16);
		System.out.println(CheckBoxTotalcount + " : Check Box's are Enabled ");

		/*for(int i=0; i<RoleTotalCount; i++)
		{
			WebElement AllRole = RoleCount.get(i);
			String Roletext = AllRole.getText();

			for(int j=0; j<CheckBoxTotalcount; j++)
			{

				WebElement AllCheckBox = CheckBoxCount.get(j);
				AllCheckBox.isEnabled();
			}	
			System.out.println(Roletext);
			System.out.println("Pass : Check Box are Enabled");

		}*/
	}


	public void VerifyRespondentRoleIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Checking the Role Count
		List<WebElement> RoleCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[1]"));
		int RoleTotalCount = RoleCount.size();
		System.out.println("Total Role Count is : " + RoleTotalCount);
		Assert.assertEquals(RoleTotalCount, 191);
		System.out.println(RoleTotalCount + " : Roles's Are Displayed ");

		//Checking the CheckBox
		List<WebElement> CheckBoxCount1 = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input"));
		int CheckBoxTotalcount1 = CheckBoxCount1.size();
		System.out.println("Total Check Box Count is : " + CheckBoxTotalcount1);
		Assert.assertTrue(RoleTotalCount!=CheckBoxTotalcount1);

		//Enabled Check Box count
		List<WebElement> CheckBoxCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@checked='checked']"));
		int CheckBoxTotalcount = CheckBoxCount.size();
		//System.out.println("Total Check Box Count is : " + CheckBoxTotalcount);
		Assert.assertEquals(CheckBoxTotalcount, 8);
		System.out.println(CheckBoxTotalcount + " : Check Box's are Enabled ");


		/*for(int i=0; i<RoleTotalCount; i++)
		{
			WebElement AllRole = RoleCount.get(i);
			String Roletext = AllRole.getText();

			for(int j=0; j<CheckBoxTotalcount; j++)
			{

				WebElement AllCheckBox = CheckBoxCount.get(j);
				AllCheckBox.isEnabled();
			}	
			System.out.println(Roletext);
			System.out.println("Pass : Check Box are Enabled");

		}*/
	}

	public void VerifySuperAdminRoleIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		//Checking the Role Count
		List<WebElement> RoleCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[1]"));
		int RoleTotalCount = RoleCount.size();
		System.out.println("Total Role Count is : " + RoleTotalCount);
		Assert.assertEquals(RoleTotalCount, 191);
		System.out.println(RoleTotalCount + " : Role's are Displayed ");


		//Checking the CheckBox
		List<WebElement> CheckBoxCount1 = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input"));
		int CheckBoxTotalcount1 = CheckBoxCount1.size();
		System.out.println("Total Check Box Count is : " + CheckBoxTotalcount1);
		Assert.assertTrue(RoleTotalCount!=CheckBoxTotalcount1);

		//Enabled Check Box count
		List<WebElement> CheckBoxCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@checked='checked']"));
		int CheckBoxTotalcount = CheckBoxCount.size();
		//System.out.println("Total Check Box Count is : " + CheckBoxTotalcount);
		Assert.assertEquals(CheckBoxTotalcount, 134);
		System.out.println(CheckBoxTotalcount + " : Check Box's are Enabled ");

		/*for(int i=0; i<RoleTotalCount; i++)
		{
			WebElement AllRole = RoleCount.get(i);
			String Roletext = AllRole.getText();

			for(int j=0; j<CheckBoxTotalcount; j++)
			{

				WebElement AllCheckBox = CheckBoxCount.get(j);
				AllCheckBox.isEnabled();
			}	
			System.out.println(Roletext);
			System.out.println("Pass : Check Box are Enabled");

		}*/
	}

	public void VerifyNewlyCreatedRoleIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		//Checking the Role Count
		List<WebElement> RoleCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[1]"));
		int RoleTotalCount = RoleCount.size();
		System.out.println("Total Role Count is : " + RoleTotalCount);
		Assert.assertEquals(RoleTotalCount, 191);
		System.out.println(RoleTotalCount + " : Role's are displayed ");

		//Checking the CheckBox
		List<WebElement> CheckBoxCount1 = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input"));
		int CheckBoxTotalcount1 = CheckBoxCount1.size();
		System.out.println("Total Check Box Count is : " + CheckBoxTotalcount1);
		Assert.assertTrue(RoleTotalCount!=CheckBoxTotalcount1);

		//Enabled Check Box count
		List<WebElement> CheckBoxCount = driver.findElements(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr/td[2]/input[@checked='checked']"));
		int CheckBoxTotalcount = CheckBoxCount.size();
		//System.out.println("Total Check Box Count is : " + CheckBoxTotalcount);
		Assert.assertEquals(CheckBoxTotalcount, 3);
		System.out.println(CheckBoxTotalcount + " : Check Box's are Enabled ");

		/*for(int i=0; i<RoleTotalCount; i++)
		{
			WebElement AllRole = RoleCount.get(i);
			String Roletext = AllRole.getText();

			for(int j=0; j<CheckBoxTotalcount; j++)
			{

				WebElement AllCheckBox = CheckBoxCount.get(j);
				AllCheckBox.isEnabled();
			}	
			System.out.println(Roletext);
			System.out.println("Pass : Check Box are Enabled");

		}*/
	}


	public void VerifyUpdatedRolePermissionsSuccessfully(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_text = SuccessMSG.getText();
			String Expected_text = "Updated role permissions successfully";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Updated role permissions successfully Success Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}
	}
}






/*//Checking AUDITOR ISSUES
		WebElement AuditorIssues = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[1]/td/strong[text()='AUDITOR ISSUES']"));

		//Checking auditor Issue list
		WebElement auditorIssuelist = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[2]/td[text()='auditor Issue list']"));

		//Checking AUDITOR ADDITIONAL ACTIONS
		WebElement AuditorAdditionalActions = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[3]/td/strong[text()='AUDITOR ADDITIONAL ACTIONS']"));

		//Checking auditor audits list
		WebElement AuditorAuditsList = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[4]/td[text()='auditor audits list']"));

		//Checking start audit
		WebElement StartAudit = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[5]/td[text()='start audit']"));

		//Checking Add Sub Auditee
		WebElement AddSubAudit = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[6]/td[text()='add sub auditee']"));

		//Checking Accpet audit
		WebElement AccpectAudit = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[7]/td[text()='Accpet audit']"));


		//Checking Update Audit by auditor
		WebElement UpdateAuditByAudior = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[8]/td[text()='Update audit by auditor']"));

		//checking Reassign audit
		WebElement ReassignAudit = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[9]/td[text()='Reassign audit']"));


		//Checking Reject Audit
		WebElement RejectAudit = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[10]/td[text()='Reject audit']"));

		//Checking My Audits
		WebElement MyAudits = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[11]/td[text()='My audits']"));

		//Checking Edit audit
		WebElement EditAudit = driver.findElement(By.xpath("//table[@id='RolepermissionSearch']/tbody/tr[12]/td[text()='Edit audit']"));*/



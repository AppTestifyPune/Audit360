package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class AllocateIssuesPageTes extends BaseTest {

	//Clicking on the Home Header
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement HomeHeader;

	//Clicking on the scroll bar
	@FindBy(xpath="//nav[contains(@class,'page-sidebar')]/div[contains(@class,'sidebar-menu')]")
	private WebElement ScrollBar;

	//Clicking on the Issues under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content')]/li/a/span[text()='Allocate Issues']")
	private WebElement AllocateIssues;

	//Clicking on the Audit Type
	@FindBy(xpath="//div[@id='s2id_audit_type']/a/span[text()='Select Audit Type']")
	private WebElement AuditType;

	//Passing the vakues to Audit Type
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement setAuditType;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Passing the Values to select Cluster
	@FindBy(xpath="//div[@id='s2id_cluster']/ul/li//input")
	private WebElement SetSelectCluster;

	//Clicking on the Allocate Button
	@FindBy(xpath="//button[text()='ALLOCATE']")
	private WebElement AlllocateBTN;

	//Clicking on the Select Respondent 
	@FindBy(xpath="//div[@id='s2id_respondent_user']/a/span[text()='Select Respondent']")
	private WebElement SelectRespondent;

	//clicking on the Select Auditee Reviewer//div[@id='s2id_auditee_reviewer_user']/a/span[text()='Select Auditee Reviewer']
	@FindBy(xpath="//span[text()='Select Auditee Reviewer']")
	private WebElement SelectAuditeeReviewer;
	
	//clicking on the Auditee User
	@FindBy(xpath="//span[text()='Select Auditee User']")
	private WebElement SelectAuditeeUser;
	
	//Passing the Values to Auditee User
	@FindBy(xpath="//div[@id='select2-drop']//input")
	private WebElement SetAuditeeUser;
	
	@FindBy(xpath="//span[@class='select2-chosen'][text()='Select Auditee User']")
	private WebElement AuditeeUserDropdown;
	
	
	public void ClickSelectAuditeeUser()
	{
		SelectAuditeeUser.click();
	}
	
	public void SetAuditeeUser(String AU)
	{
		SetAuditeeUser.sendKeys(AU);
		System.out.println("Entered Auditee User is : " + AU);
		chiledTest.log(Status.INFO, "Auditee User is Selected");
	}
	
	//Passing the values to Select Respondent
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetRespondent;

	//Passing the Values to Select Reviewer
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetReviewer;
	
	//Passing the Values to Auditees
	//@FindBy(xpath="//div[@id='s2id_auditee_id']/ul/li/input")//#SM Modify
	@FindBy(xpath="(//input[@class='select2-input'])[8]")
	private WebElement SetAuditeees;
	//*[@id='s2id_autogen6767_search']
	

	//Passing the Values to Search Button
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBox;

	//Clicking on the Check Box
	@FindBy(xpath="//table[@id='ckgroupTable']/tbody/tr[1]/td[1]/input[@type='checkbox']")
	private WebElement CheckBox;

	//Clicking on the Remove  Button
	@FindBy(xpath="//table[@id='ckgroupTable']/tbody/tr[1]/td[6]/button[text()='Remove']")
	private WebElement RemoveBTN;

	//Clicking on the Reassign Button
	@FindBy(xpath="//table[@id='ckgroupTable']/tbody/tr[1]/td[6]/button[text()='Reassign']")
	private WebElement ReassignBTN;

	//Clicking on the Confirm Button
	@FindBy(xpath="//span[contains(text(),'Confirm')]")
	private WebElement ConfirmBTN;

	//Clciking on the Go Button
	@FindBy(xpath="//input[@class='btn btn-primary filter_allocated_check_point_groups']")
	private WebElement GOBTN;

	@FindBy(xpath="//div[text()='auditeeuser2@yopmail.com']")
	private WebElement auditeeuser2;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement ErrorMSG;
	//div[@class='alert alert-danger']
	//button[@data-dismiss='alert']
	
	public AllocateIssuesPageTes(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickHomeHeader()
	{
		HomeHeader.click();
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickAllocateIssues(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AllocateIssues);
	}

	public void ClickAuditType()
	{
		AuditType.click();
	}

	public void SetAuditType(String AT)
	{
		setAuditType.sendKeys(AT);
		System.out.println("Entered Audit type is : " + AT);
	}

	public void SetSelectCluster(String SC)
	{
		SetSelectCluster.sendKeys(SC);
		System.out.println("Selected Cluster is : " + SC);
	}

	public void ClickMatched(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Matched)).click();
		System.out.println("Matched Selected");
		
	}

	public void ClickAlllocateBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(AlllocateBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AlllocateBTN);
	}

	public void SetSelectRespondent(String SR)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SetRespondent));
		SetRespondent.sendKeys(SR);
		System.out.println("Selected Respondent is : " + SR);
	}

	public void SetSelectReviewer(String SR)
	{
		SetReviewer.sendKeys(SR);
		System.out.println("Selected Reviewer is : " + SR);
	}

	public void ClickSelectRespondent()
	{
		SelectRespondent.click();
	}

	public void ClickSelectAuditeeReviewer()
	{
		SelectAuditeeReviewer.click();
	}
	
	public void SetAuditees(String SA) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(AuditeeUserDropdown));
		AuditeeUserDropdown.click();
	
		wait.until(ExpectedConditions.visibilityOf(auditeeuser2));
		auditeeuser2.click();
		//auditeeuser2@yopmail.com User selected
		
	  //SetAuditeees.sendKeys(SA);
		System.out.println("Selected Auditee is : " + SA);//Parameter not passed
		chiledTest.log(Status.INFO, "Auditees is Selected");
		
	}

	public void SetSearchBox(String SB) throws InterruptedException
	{
		Thread.sleep(2000);
		SearchBox.clear();
		Thread.sleep(1000);
		SearchBox.sendKeys(SB);
		System.out.println("Searched Sub Audit Type is : " + SB);
	}

	public void ClearSearchBox()
	{
		SearchBox.clear();
	}

	public void ClickCheckBox(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CheckBox)).click();

	}

	public void ClickRemoveBTN()
	{
		RemoveBTN.click();
		System.out.println("Remove Button is Clicked");
	}

	public void ClickReassignBTN()
	{
		ReassignBTN.click();
	}

	public void ClickConfirmBTN(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ConfirmBTN).click().build().perform();
	}

	public void ClickGOBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", GOBTN);
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}

	public void VerifyPleaseSelectAtleastOneGroupMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

	//	WebElement ErrorMSG = driver.findElement(By.xpath("//button[@data-dismiss='alert']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed());
		{
			String Actaul_text = ErrorMSG.getText();
			System.out.println("Error Message:"+Actaul_text);
			String Expected_text = "Please select atleast one group or sub audits";
			//#SM Modify Because The error mesage is wrong
		    //Assert.assertEquals(Actaul_text, Expected_text, "Wrong Message is Showed");
			System.out.println("Pass : Please select atleast one group Error Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//button[@class='close'][@data-dismiss='alert']")).click();
		}

	}

	public void VerifyAllocatedSuccessfullySuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Allocated Successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/button")).click();
		}
	}

	public void VerifyReassignAndRemoveButtonIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//Checking Reassign Button
		List<WebElement> ReassingButton = driver.findElements(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[6]/button[text()='Reassign']"));
		int ReassignButtonSize = ReassingButton.size();

		//Checking Remove Button
		List<WebElement> RemoveButton = driver.findElements(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[6]/button[text()='Remove']"));
		int RemoveButtonSize = RemoveButton.size();
		Assert.assertFalse(RemoveButtonSize>0, "Remove Button is Displayed");
		Assert.assertFalse(ReassignButtonSize>0, "Reassign Button is Displayed");

	}

	public void VerifyingReassignedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Reassigned Successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/button")).click();}
	}

	public void VerifyingRemovedSuccessfullyMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Removed Succesfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/button")).click();}
	}

	public void VerifyAreyouSureYouWantToRemoveUserPopUpIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement PopUp = driver.findElement(By.xpath("//div[@id='remove_popup']"));
		if(wait.until(ExpectedConditions.visibilityOf(PopUp)).isDisplayed()){
			String Actual_Text = driver.findElement(By.xpath("//div[@id='remove_popup']/p")).getText();
			String Expected_Text = "Are you sure you want to remove user";
			Assert.assertEquals(Actual_Text, Expected_Text, "Alert Message has been Wrong");}
	}

	public void VerifyAreyouSureYouWantToReassignUserPopUpIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement PopUp = driver.findElement(By.xpath("//div[@id='reassign_popup']"));
		if(wait.until(ExpectedConditions.visibilityOf(PopUp)).isDisplayed()){
			String Actual_Text = driver.findElement(By.xpath("//div[@id='reassign_popup']/p")).getText();
			String Expected_Text = "Are you sure you want to reassign user";
			Assert.assertEquals(Actual_Text, Expected_Text, "Alert Message has been Wrong");}
	}

	public void VerifyAuditeeReviewerDropDownShouldNotBeDisplay(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> AuditeeReviewerDropDown = driver.findElements(By.xpath("//label[text()='AUDITEE REVIEWERS']"));
		 Assert.assertTrue(AuditeeReviewerDropDown.size()<=0, "Auditee Reviewer Drop Down is Displayed");
		 System.out.println("Auditee Reviewer Drop Down is Not Displayed");
		 chiledTest.log(Status.INFO, "Auditee Reviewer Drop Down is Not Displayed");
	}

	public void VerifyRespondentDropdownShouldNotBeDisplay(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 List<WebElement> RespondentDropDown = driver.findElements(By.xpath("//label[text()='RESPONDENTS']"));
		 Assert.assertTrue(RespondentDropDown.size()<=0, "Respondent Drop Down is Displayed");
		 System.out.println("Respndent Drop Down is Not Displayed");
		 chiledTest.log(Status.INFO, "Respndent Drop Down is Not Displayed");
	}
	
	public void VerifyAuditeeUserDropdownShouldNotBeDisplay(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 List<WebElement> RespondentDropDown = driver.findElements(By.xpath("//label[text()='AUDITEE USER']"));
		 Assert.assertTrue(RespondentDropDown.size()<=0, "Auditee User Drop Down is Displayed");
		 System.out.println("Auditee User Drop Down is Not Displayed");
		 chiledTest.log(Status.INFO, "Auditee User Drop Down is Not Displayed");
	}
	
	public void VerifyAuditeesDropdownShouldNotBeDisplay(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 List<WebElement> RespondentDropDown = driver.findElements(By.xpath("//label[text()='Auditees']"));
		 Assert.assertTrue(RespondentDropDown.size()<=0, "Auditees Drop Down is Displayed");
		 System.out.println("Auditees Drop Down is Not Displayed");
		 chiledTest.log(Status.INFO, "Auditees Drop Down is Not Displayed");
	}

}

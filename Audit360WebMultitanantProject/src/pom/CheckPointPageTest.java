package pom;

import static org.testng.Assert.assertTrue;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;

public class CheckPointPageTest extends BaseTest{

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clicking on the Check Point Under Side Menu//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Check Points']
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Check Points']")
	private WebElement CheckPoints;

	//Clicking on the Manage Check point 
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Manage CheckPoints']")
	private WebElement ManageCheckpoint;

	//Clicking on the Master/ Add Checkpoint 
	@FindBy(xpath="//a[contains(text(),'Masters / Add Checkpoint')]")
	private WebElement AddCheckPoint;

	//Clicking on the Select Group Under Master/ Add Checkpoint
	@FindBy(xpath="//div[@id='s2id_check_point_group_id']/a/span[@class='select2-chosen']")
	private WebElement SelectGroup;

	//Clicking on the go Button
	@FindBy(xpath="//button[@id='get_check_points_list_with_search_params']")
	private WebElement GoBTN;

	//Clicking on the add check point
	@FindBy(xpath="//a[text()='Add Checkpoint']")
	private WebElement AddCheckPointBTN;

	//Passing the values to Search Box for Group
	@FindBy(xpath="//div[@id='ckgroupTable_filter']//input[@type='search']")
	private WebElement SearchBTN;

	//Passing the Values to Search Box for CheckPoints
	@FindBy(xpath="//div[@class='panel-collapse collapse in']//div[@class='panel-body p-t-0']//div//input[@type='search']")
	private WebElement SearchBox;

	//Checking the Group Name
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_group_id']/a/span[1]")
	private WebElement GroupName;
	
	//Passing the Values to Enter new Group
	@FindBy(xpath="//input[@name='add_group']")
	private WebElement EnterNewGroup;
	
	//clicking on the add new group toggle button
	@FindBy(xpath="//label[@for='checkboxID']")
	private WebElement AddNewGroupToggleBTN;

	//Passing the Values to Check point intent
	@FindBy(xpath="//textarea[@id='check_point_complaince_intent']")
	private WebElement EnterCheckpointintent;

	//Passing the values to the Description
	@FindBy(xpath="//textarea[@id='check_point_complaince_definition']")
	private WebElement Description;

	//clicking on the Expected action from auditor//
	@FindBy(xpath="//*[@id='s2id_check_point_complaince_action_type']/a/span[1]") ////*[@id='s2id_check_point_complaince_action_type']/a/span[2]/b
	private WebElement Expectedactionfromauditor;

	//Passing the Values to Expected Action from Auditor
	@FindBy(xpath="//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input[@type='text']")
	private WebElement SetExpectedActionFromAuditor;

	//Passing the Values to Yes Test Box.//*[@id='Yes']
	@FindBy(xpath="//label[contains(text(),'Yes')]/following-sibling::div/input")
	private WebElement YestextBox;

	//Passing the Values to No Text Box.//*[@id='No']
	@FindBy(xpath="//label[contains(text(),'No')]/following-sibling::div/input")
	private WebElement NoTextBox;

	//Passing the Values to Partial Text Box.//*[@id='Partial']
	@FindBy(xpath="//label[contains(text(),'Partial')]/following-sibling::div/input")
	private WebElement PartialTextBox;

	//Passing the Values to NA Text Box//input[@class='form-control non_redistribute_logic_na NA_score']  //input[@id='NA_score']
	@FindBy(xpath="//label[contains(text(),'NA')]/following-sibling::div/input")
	private WebElement NATextBox;

	//Passing the Values to Yes DISPOSITION
	@FindBy(xpath="//div[@class='form-group form-group-default label_size verify_actions chk_Yes  required']/following-sibling::div[@class='form-group form-group-default verify_actions']/div/input")
	private WebElement YesDisposition;

	//Passing the Values to Yes Disposition in Edit Mode
	@FindBy(xpath="//input[@id='dispose_Yes']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")
	private WebElement YesDisposition1;

	//Passing the Values to NO DISPOSITION
	@FindBy(xpath="//div[@class='form-group form-group-default label_size verify_actions chk_No  required']/following-sibling::div[@class='form-group form-group-default verify_actions']/div/input")
	private WebElement NoDisposition;

	//Passing the Values to No Dispostion in Edit Mode
	@FindBy(xpath="//input[@id='dispose_No']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")
	private WebElement NoDisposition1;

	//Passing the Values to Partial DISPOSITION
	@FindBy(xpath="//form[@id='new_check_point_complaince']/div[@class='row']/div[@class='row']/div[@class='row']/div[@class='col-md-3 col-xs-12']/div[3]/div/input")
	private WebElement PartialDisposition;

	//Passing the Values to Partial Dispostion in Edit Mode
	@FindBy(xpath="//input[@id='dispose_Partial']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")
	private WebElement PartialDisposition1;

	//Passing the Values to NA DISPOSITION
	@FindBy(xpath="//form[@id='new_check_point_complaince']/div[@class='row']/div[@class='row']/div[@class='row']//div[@class='row']/div[@class='col-md-3 col-xs-12']/div[3]/div/input")
	private WebElement NADisposition; 

	//Passing the Values to NA Dispostion in Edit Mode
	@FindBy(xpath="//input[@id='dispose_NA']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")
	private WebElement NADisposition1;

	//Clicking on the Data type
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_data_type_name']/a/span[1]") 
	private WebElement DataType;

	//clicking on the Add new Check point Button
	@FindBy(xpath="//a[text()='Add New Checkpoint']")
	private WebElement AddNewcheckpointBTN;

	//Clicking on the Risk Level
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_risk_level']/a/span[1]")
	private WebElement RiskLevel;

	//Passing the values to Risk level
	@FindBy(xpath="//div[@id='select2-drop']/div/input[@type='text']")
	private WebElement SetRiskLevel;

	//Passing the Values to Notice to Auditor Description
	@FindBy(xpath="//textarea[@id='check_point_complaince_notes_to_auditor']")
	private WebElement NoticetoAuditors;

	//Clicking on the Submit and Create New Check Point
	@FindBy(xpath="//button[@class='btn btn-block btn-primary submit_create_new']")
	private WebElement SubmitCreateBTN;

	//Clicking on the 1st TR Number of Check Box Button(4) //table[@id='ckgroupTable']/tbody/tr[1]/td[3]/a
	@FindBy(xpath="//a[@class='btn btn-sm  btn-rounded btn-primary collapseTwo']")
	private WebElement NumberOfCheckBoxBTN;

	//Clicking on the 1st Created Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[1]/td[1]")
	private WebElement FirstCheckpoint;

	//Clicking on the 2nd Created Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[2]/td[1]")
	private WebElement SecondCheckpoint;

	//Clicking on the 3rd Created Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[3]/td[1]")
	private WebElement ThirdCheckpoint;

	//Clicking on the 4th Created Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[4]/td[1]")
	private WebElement FourCheckpoint;

	//Clicking on the 4th Created Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[5]/td[1]")
	private WebElement FifthCheckpoint;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@class='btn btn-info btn-block submit_new']")////input[@type='submit' or @value='submit']
	private WebElement SubmitBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//div[@class='row']//div[@class='row']//button[@type='button'][contains(text(),'Cancel')]")
	private WebElement CancelBTN;

	//Clicking on the Edit Checkpoint Close Button
	@FindBy(xpath="//div[@class='modal-dialog modal-md']//i[@class='pg-close fs-14']")
	private WebElement EditPageCloseBTN;

	//clicking on the Close Button
	@FindBy(xpath="//i[@class='pg-close']")
	private WebElement CloseBTN;

	//Clicking on the Group
	@FindBy(xpath="//div[@class='select2-container full-width pick_anx_fields_group_select']//span[@class='select2-chosen'][contains(text(),'Select Group')]")
	private WebElement Group;

	//Passing the Values to Select Group
	@FindBy(xpath="//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input")
	private WebElement SetSelectGroup;

	//Clicking on the Matched.//*[@id='select2-drop']/ul/li[1]/div/span[@class='select2-match']
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Manage Check Point Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement ManageCheckPointHeader;

	//Clicking on the Select Annexure Columns
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_annexure_configuration_id']/a/span[2]")
	private WebElement SelectAnnexureColumns;

	//Passing the Values to Select Annexure Columns
	@FindBy(xpath="//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input") 
	private WebElement SetSelectAnnexureColumns;

	//Passing the Values to Data Type
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetDataType;

	//Passing the Values to Data Type Text Box
	@FindBy(xpath="//div[@class='form-group form-group-default input_actions']/div/input")
	private WebElement SetDataTypeValues;

	//Clicking on the First Data Type
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_check_point_options_attributes_0_data_type_attributes_name']/a/span[1]")
	private WebElement FirstDataType;

	//Clicking on the Second Data Type
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_check_point_options_attributes_1_data_type_attributes_name']/a/span[1]")
	private WebElement SecondDataType;

	//Clicking on the Third Data Type
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_check_point_options_attributes_2_data_type_attributes_name']/a/span[1]")
	private WebElement ThirdDataType;

	//Clicking on the Fourth Data Type
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_check_point_options_attributes_3_data_type_attributes_name']/a/span[1]")
	private WebElement FourthDataType;

	//clicking on the Positive Conformity
	@FindBy(xpath="//div[@id='s2id_check_point_complaince_positive_conformity']/a/span[1]")
	private WebElement PositiveConformity;

	//Passing the Values to Positive Conformity
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input")
	private WebElement SetPositiveConformity;

	//Clicking on the Partial Check box
	@FindBy(xpath="//input[@id='check_point_complaince_opt_partial']")
	private WebElement PartialCheckBox;

	//Clicking on the NA Check box
	@FindBy(xpath="//input[@id='check_point_complaince_opt_na']")
	private WebElement NACheckBox;

	//Checking Success Messages
	@FindBy(xpath="//div[@class='alert alert-success']/span")
	private WebElement SuccessMSG;

	//Clicking on the Success Message Close Button
	@FindBy(xpath="//div[@class='alert alert-success']/button")
	private WebElement SuccessMSGCloseBTN;

	//Checking the Checkpoint Intent Name is Required Filed or Not
	@FindBy(xpath="//label[@id='check_point_complaince_intent-error']")
	private WebElement CheckpointIntentNameisRequiredFiled;

	//Checking the Description is Required Filed or Not
	@FindBy(xpath="//label[@id='check_point_complaince_definition-error']")
	private WebElement DescriptionisRequiredFiled;

	//Checking the Expected Action from Auditor is Required Filed or Not
	@FindBy(xpath="//label[@id='check_point_complaince_action_type-error']")
	private WebElement ExpectedActionfromAuditorisRequiredFiled;

	//Checking the Risk Level is Required Filed or Not
	@FindBy(xpath="//label[@id='check_point_complaince_risk_level-error']")
	private WebElement RiskLevelisRequiredFiled;

	//Checking the Notes to Auditor is Required Filed or Not
	@FindBy(xpath="//label[@id='check_point_complaince_notes_to_auditor-error']")
	private WebElement NotesToAuditorRequiredFiled;

	//Checking the Minimum 1 disposition is required for NO, PARTIAL and N/A Error Message
	@FindBy(xpath="//div[@id='disposition_error']")
	private WebElement ComplianceErrorMSG;

	//Checking the Data Type Error Message
	@FindBy(xpath="//div[@id='data_type_error']")
	private WebElement DataTypeErrorMSG;

	//Checking At least One Data Type Has be Selected
	@FindBy(xpath="//div[text()='Atleast one data type has to be selected']")
	private WebElement OneDataType;

	//Checking Annexure Column is Required Filed or Not
	@FindBy(xpath="//label[@id='check_point_complaince_annexure_configuration_id-error']")
	private WebElement AnnexureColumn;

	//Clicking on the Activate Button
	@FindBy(xpath="//form[@class='new_check_point_complaince']//input[@id='check_point_complaince_active']")
	private WebElement ActivateBTN;

	//Clicking on the Activate button Under Edit Checkpoint Page//input[@id='check_point_complaince_active']
	@FindBy(xpath="//form[@class='edit_check_point_complaince']//input[@id='check_point_complaince_active']")
	private WebElement EditPageActivateButton;

	//Checking Partial Tab is Readonly or Not
	@FindBy(xpath = "//input[@id='Partial'][@readonly='readonly']")
	private WebElement Partila;

	//Checking the NA Tab is Read only or not
	@FindBy(xpath = "//input[@id='NA_score'][@readonly='readonly']")  
	private WebElement NA;

	//clicking on the Edit Checkpoint Submit Button
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement EditPageSubmitBTN;


	public CheckPointPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickCheckPoints(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CheckPoints)).click();
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CheckPoints);*/
	}

	public void ClickManageCheckpoint(WebDriver driver) throws InterruptedException
	{
		/*Actions action = new Actions(driver);	
		action.moveToElement(ManageCheckpoint).click().build().perform();*/
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageCheckpoint);
	}

	public void ClickManageCheckPointHeader(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(ManageCheckPointHeader));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageCheckPointHeader);
	}

	public void ClickMasterOrAddCheckPoint(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(AddCheckPoint));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddCheckPoint);
		System.out.println("Masters / Add Checkpoint is Clicked");
	}

	public void ClickGroup(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Group)).click();
	}

	public void ClickAddPageActivateBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(ActivateBTN)).isDisplayed())
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ActivateBTN);
			System.out.println("Activate Button is Clicked");
		}

	}

	public void ClickEditPageActivateBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EditPageActivateButton);
		System.out.println("Activate Button is Clicked");
		chiledTest.log(Status.INFO, "Activate Button is Clicked");
	}

	public void SetSelectGroup(String SG)
	{
		SetSelectGroup.sendKeys(SG);
		System.out.println("Selected Group is : " + SG);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void ClickPartialCheckBox()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PartialCheckBox);
		System.out.println("Partail Check box is clicked");
		chiledTest.log(Status.INFO, "Partail Check box is clicked");
	}

	public void ClickNaCheckBox()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NACheckBox);
		System.out.println("NA Check box is clicked");
		chiledTest.log(Status.INFO, "NA Check box is clicked");
	}

	public void ClickAddCheckPointBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(AddCheckPointBTN)).click();
		System.out.println("Add checkpoint Button is Clicked");
	}

	public void SetSearchBTN(String SS) throws InterruptedException
	{
		SearchBTN.clear();
		SearchBTN.sendKeys(SS);
		System.out.println("Searched Group Name is : " + SS);
	}

	public void SetSearchBox(String SB) throws InterruptedException
	{
		SearchBox.clear();
		SearchBox.sendKeys(SB);
		System.out.println("Searched Checkpoint Name is : " + SB);
	}

	public void ClickSelectGroup(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(SelectGroup)).click();
	}

	public void ClickGoBTN()
	{
		GoBTN.click();
		System.out.println("Go Button is Clicked");
	}



	public void SetEnterCheckpointintent(String ECI, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(EnterCheckpointintent));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='check_point_complaince_intent']"))).sendKeys(ECI);
		System.out.println("Entered Check point intent is : " + ECI);
	}

	public void ClearEnterCheckpointintent(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='check_point_complaince_intent']"))).clear();
	}

	public void SetDescription(String DS)
	{
		Description.sendKeys(DS);
		System.out.println("Entered Description is : " + DS);
	}

	public void ClearDescription()
	{
		Description.clear();
	}

	public void ClickExpectedactionfromauditor(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Expectedactionfromauditor)).click();
		}catch (StaleElementReferenceException e) {}
	}

	public void SetExpectedActionFromAuditor(String EA) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SetExpectedActionFromAuditor)).sendKeys(EA);
		System.out.println("Selected Expected Action From Auditor Option is : " + EA);
	}

	public void SetYestextBox(String YB)
	{
		YestextBox.clear();

		YestextBox.sendKeys(YB);
		System.out.println("Entered Compliance Score of Yes is : " + YB);
		chiledTest.log(Status.INFO, "Yes Score is Entered");
	}


	public void SetNoTextBox(String NB)
	{
		NoTextBox.clear();

		NoTextBox.sendKeys(NB);
		System.out.println("Entered Compliance Score of NO is : " + NB);
		chiledTest.log(Status.INFO, "No Score is Entered");
	}

	public void SetPartialTextBox(String PB)
	{
		PartialTextBox.clear();

		PartialTextBox.sendKeys(PB);
		System.out.println("Entered Compliance Score of Partial is : " + PB);
		chiledTest.log(Status.INFO, "Partial Score is Entered");
	}

	public void SetNATextBox(String NAB)
	{
		NATextBox.clear();

		NATextBox.sendKeys(NAB);
		System.out.println("Entered Compliance Score of NA is : " + NAB);
		chiledTest.log(Status.INFO, "NA Score is Entered");
	}

	public void ClearYestextBox()
	{
		YestextBox.clear();
	}


	public void ClearNoTextBox()
	{
		NoTextBox.clear();
	}

	public void ClearPartialTextBox()
	{
		PartialTextBox.clear();
	}

	public void ClearNATextBox()
	{
		NATextBox.clear();
	}

	public void SetYesDisposition(String YD)
	{
		YesDisposition.sendKeys(YD);
		YesDisposition.sendKeys(Keys.ENTER);
		System.out.println("Entered Yes Disposition is : " + YD);
	}

	public void SetYesDisposition1(String YD, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dispose_Yes']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")));
		wait.until(ExpectedConditions.visibilityOf(YesDisposition1));
		YesDisposition1.sendKeys(YD);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		System.out.println("Entered Yes Disposition is : " + YD);	
	}


	public void SetNoDisposition(String ND)
	{
		NoDisposition.sendKeys(ND);
		NoDisposition.sendKeys(Keys.ENTER);
		System.out.println("Entered No Disposition is : " + ND);
	}

	public void SetNoDisposition1(String ND, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dispose_No']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")));
		wait.until(ExpectedConditions.visibilityOf(NoDisposition1));
		NoDisposition1.sendKeys(ND);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		System.out.println("Entered No Disposition is : " + ND);	
	}


	public void SetPartialDisposition(String PD)
	{

		PartialDisposition.sendKeys(PD);
		PartialDisposition.sendKeys(Keys.ENTER);
		System.out.println("Entered Partial Disposition is : " + PD);
	}

	public void SetPartialDisposition1(String PD, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dispose_Partial']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")));
		wait.until(ExpectedConditions.visibilityOf(PartialDisposition1));
		PartialDisposition1.sendKeys(PD);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		System.out.println("Entered Partial Disposition is : " + PD);	
	}


	public void SetNADisposition(String ND)
	{
		NADisposition.sendKeys(ND);
		NADisposition.sendKeys(Keys.ENTER);
		System.out.println("Entered NA Disposition is : " + ND);
	}

	public void SetNADisposition1(String ND, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dispose_NA']/ancestor::div[@class='form-group form-group-default verify_actions']/div[@class='bootstrap-tagsinput']/input[@type='text']")));
		wait.until(ExpectedConditions.visibilityOf(NADisposition1));
		NADisposition1.sendKeys(ND);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		System.out.println("Entered NA Disposition is : " + ND);

	}


	public void ClickDataType(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(DataType)).click();
	}

	public void ClickFirstDataType(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(FirstDataType).click().build().perform();
	}

	public void ClickSecondDataType(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(SecondDataType).click().build().perform();
	}

	public void ClickThirdDataType(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Actions action = new Actions(driver);	
		action.moveToElement(ThirdDataType).click().build().perform();
	}

	public void ClickFourthDataType(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(FourthDataType).click().build().perform();
	}

	public void ClickAddNewcheckpointBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddNewcheckpointBTN);
		System.out.println("Add New Checkpoint Button is Clicked");
		chiledTest.log(Status.INFO, "Add New Checkpoint Button is Clicked");

	}

	public void ClickRiskLevel(WebDriver driver)
	{
		RiskLevel.click();
	}

	public void SetRiskLevel(String RL)
	{
		SetRiskLevel.sendKeys(RL);
		System.out.println("Selected Risk Level is : " + RL);
	}


	public void SetNoticetoAuditors(String NTA)
	{
		NoticetoAuditors.sendKeys(NTA);
		System.out.println("Entered Notes to auditors is : " + NTA);
	}

	public void ClearNoticetoAuditors()
	{
		NoticetoAuditors.clear();
	}

	public void ClickSubmitCreateBTN(WebDriver driver)
	{
		SubmitCreateBTN.click();
		System.out.println("Submit Create Checkpoint Button is Clicked");
	}

	public void ClickNumberOfCheckBoxButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(NumberOfCheckBoxBTN)).click();
	}

	public void ClickSelectAnnexureColumns(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(SelectAnnexureColumns)).click();
	}

	public void SetSelectAnnexureColumns(String SAC)
	{
		SetSelectAnnexureColumns.sendKeys(SAC);
		System.out.println("Selected Select Annexure Columns is : " + SAC);
	}

	public void SetDataType(String SD)
	{
		SetDataType.sendKeys(SD);
		System.out.println("Selected Data Type is : " + SD);
	}

	public void SetDataTypeValues(String SV, WebDriver driver)
	{
		SetDataTypeValues.sendKeys(SV);
		System.out.println("Entered Data Type Values are : " + SV);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);
	}

	public void ClickFirstCheckpoint(WebDriver driver) throws InterruptedException
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(FirstCheckpoint)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickSecondCheckpoint(WebDriver driver) throws InterruptedException
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(SecondCheckpoint)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickThirdCheckpoint(WebDriver driver) throws InterruptedException
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(ThirdCheckpoint)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickFourtcheckpoint(WebDriver driver) throws InterruptedException
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(FourCheckpoint)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickFifthcheckpoint(WebDriver driver) throws InterruptedException
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(FifthCheckpoint)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickSubmitButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(SubmitBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitBTN);
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void ClickCancelBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CancelBTN);
		System.out.println("Cancel Button is Clicked");
	}

	public void ClickPositiveConformity()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PositiveConformity)).click();
	}

	public void SetPositiveConformity(String PC)
	{
		SetPositiveConformity.clear();
		SetPositiveConformity.sendKeys(PC);
		System.out.println("Enterd Positive Conformity is : " + PC);
	}

	public void ClickEditPageCloseBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(EditPageCloseBTN)).click();
	}

	public void ClickAddNewGroupToggleButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddNewGroupToggleBTN);
		System.out.println("Add new Group Toggle Button is Clicked");
		chiledTest.log(Status.INFO, "Add new Group Toggle Button is Clicked");
	}
	
	
	public void SetEnterNewGroup(String EN) throws InterruptedException
	{
		Thread.sleep(2000);
		EnterNewGroup.sendKeys(EN);
		System.out.println("Entered new Group Name is : " + EN);
		chiledTest.log(Status.INFO, "Group Name is Entered");
	}
	
	public void ClickEditPageSubmitButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EditPageSubmitBTN);
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void ClickCloseBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CloseBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);
		//CloseBTN.click();
	}

	public void VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Checking the Edit Checkpoint Page is Displayed or not
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Actual_text = SuccessMSG.getText();
			String Expected_text = "Checkpoint created successfully.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Checkpoint created successfully. Success Message is Displayed");

			//Click Close Button
			SuccessMSGCloseBTN.click();}

	}

	public void VerifyAddCheckPointPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Checking the Close Button
		WebElement CloseBTN = driver.findElement(By.xpath("//div[@id='modalFillIn']//i[contains(@class,'pg-close')]"));
		if(CloseBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Close Button is Displayed");
		}

		//Checking the Activate Button
		WebElement ActivateBTN = driver.findElement(By.xpath("//input[@id='check_point_complaince_active']"));
		if(ActivateBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Activate Button is Displayed");
		}

		//Checking the Add Check point Header
		WebElement AddCheckpoint = driver.findElement(By.xpath("//h5[@class='text-left p-b-5']/span"));
		if(AddCheckpoint.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Add Check Point Header is Displayed");
		}

		//Checking group drop down list
		try
		{
			WebElement Group = driver.findElement(By.xpath("//div[@id='s2id_check_point_complaince_group_id']"));
			if(wait.until(ExpectedConditions.visibilityOf(Group)).isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Pass : Group drop down List is Displayed");
			}
		}catch (StaleElementReferenceException  e) {

		}



		//Checking the Check point intent Header
		WebElement CheckPoint1 = driver.findElement(By.xpath("//label[text()='Check point intent']"));
		//Checking the Enter Check Point intent Text field
		WebElement CheckPoint2 = driver.findElement(By.xpath("//input[@id='check_point_complaince_intent']"));
		if(CheckPoint1.isDisplayed() && CheckPoint2.isDisplayed())
		{
			String Actual_CheckPoint1 = CheckPoint1.getText();
			String Expected_CheckPoint1 = "CHECK POINT INTENT";
			Assert.assertEquals(Actual_CheckPoint1, Expected_CheckPoint1);
			System.out.println("Pass : Check point intent is Displayed");
		}

		//Checking Select Annexure Columns
		try
		{
			WebElement SAC = driver.findElement(By.xpath("//div[@id='s2id_check_point_complaince_annexure_configuration_id']"));
			if(SAC.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Pass : Select Annexure Columns is Displayed");
			}
		}catch (StaleElementReferenceException e) {

		}


		//Checking Description
		WebElement DescriptionText = driver.findElement(By.xpath("//label[@for='check_point_complaince_description']/ancestor::div[@class='form-group form-group-default required']"));
		if(DescriptionText.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Description is Displayed");
		}

		//Checking Expected Action From Auditor
		try
		{
			WebElement EAFA = driver.findElement(By.xpath("//div[@id='s2id_check_point_complaince_action_type']"));
			if(EAFA.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Pass : Expected Action From Auditor is Displayed");
			}
		}catch (StaleElementReferenceException e) {

		}

		//Checking Risk Level
		WebElement RL = driver.findElement(By.xpath("//div[@id='s2id_check_point_complaince_risk_level']"));
		if(RL.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Risk level is Displayed");
		}

		//Checking Notes to Auditor
		WebElement NTA = driver.findElement(By.xpath("//label[contains(@for,'check_point_complaince_notes_to_auditors')]"));
		if(NTA.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Notes to auditors is Displayed");
		}

		//Checking Submit Button
		WebElement SubmitButton = driver.findElement(By.xpath("//input[@class='btn btn-info btn-block submit_new']"));
		if(SubmitButton.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Submit Button is Displayed");
		}

		//Checking Cancel Button
		WebElement CancelButton = driver.findElement(By.xpath("//div[contains(@class,'row')]//div[contains(@class,'row')]//button[contains(@type,'button')][contains(text(),'Cancel')]"));
		if(CancelButton.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Cancel Button is Displayed");
		}

		//Checking Submit and Create Button
		WebElement SCBTN = driver.findElement(By.xpath("//div[contains(@class,'row')]//div[contains(@class,'row')]//button[contains(@type,'button')][contains(text(),'Cancel')]"));
		if(SCBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Submit and Create button is Displayed");
		}
	}

	public void VerifyEditCheckpointPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);

		//Checking the Edit Checkpoint Page is Displayed or not
		WebElement EditCheckpoint = driver.findElement(By.xpath("//h5[@class='text-primary ']"));
		try
		{
			if(wait.until(ExpectedConditions.visibilityOf(EditCheckpoint)).isDisplayed())
			{
				String Actual_text = EditCheckpoint.getText();
				String Expected_text = "Edit Checkpoint";
				Assert.assertEquals(Actual_text, Expected_text);
				System.out.println("Pass : Edit Checkpoint Page is Displayed");
			}
		}catch (StaleElementReferenceException e) {

		}

	}

	public void VerifyFourCheckpointsAreAddedOrNotInTheList(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking 4 Checkpoints are added in the List or not
		WebElement Checkpoint = driver.findElement(By.xpath("//table[@id='cktableWithSearch']/tbody/tr/td[1]"));
		if(wait.until(ExpectedConditions.visibilityOf(Checkpoint)).isDisplayed())
		{
			List<WebElement> AllCheckpoints = driver.findElements(By.xpath("//table[@id='cktableWithSearch']/tbody/tr/td[1]"));
			int Checkpointsize = AllCheckpoints.size();
			int Actual_Checkpointsize = Checkpointsize;
			int Expected_Checkpointsize = 4;
			Assert.assertEquals(Actual_Checkpointsize, Expected_Checkpointsize);
			System.out.println("PAss : 4 Checkpoints are added in the List");
		}
	}

	public void VerifyCheckpointUpdatedSuccessfullySuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking the Checkpoint Updated Successfully Success Message is Displayed or not
		WebElement UpdateMSG = driver.findElement(By.xpath("//span[text()='Checkpoint updated successfully.']"));
		if(wait.until(ExpectedConditions.visibilityOf(UpdateMSG)).isDisplayed())
		{
			String Actual_text = UpdateMSG.getText();
			String Expected_text = "Checkpoint updated successfully.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Checkpoint updated successfully. Success Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}
	}

	public void VerifyGeneralGroupCheckPointMandataryFieldsErrorMSGIsDisplayed(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking the CheckPoint intent
		if(CheckpointIntentNameisRequiredFiled.isDisplayed())
		{
			String Actual_Text = CheckpointIntentNameisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Checkpoint intent Name is Not Working As Required Filed");
			System.out.println("Checkpoint Intenet Name is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Checkpoint intent Name is Required filed Error Message is Displayed");
		}

		//Checking the Descriptions
		if(DescriptionisRequiredFiled.isDisplayed())
		{
			String Actual_Text = DescriptionisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Descriptions is Not Working As Required Filed");
			System.out.println("Description is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Description is Required filed Error Message is Displayed");
		}

		//Checking the Expected Actions from Auditor
		if(ExpectedActionfromAuditorisRequiredFiled.isDisplayed())
		{
			String Actual_Text = ExpectedActionfromAuditorisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Expeceted Actions from Auditors is Not Working As Required Filed");
			System.out.println("Expeceted Actions from Auditors is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Expeceted Actions from Auditors is Required filed Error Message is Displayed");
		}

		//Checking Risk Level is mandatory
		if(RiskLevelisRequiredFiled.isDisplayed())
		{
			String Actual_Text = RiskLevelisRequiredFiled.getText();
			String Expected_Text = "Risk Level is Mandatory";
			Assert.assertEquals(Actual_Text, Expected_Text, "Risk Level is Mandatory is Not Working As Required Filed");
			System.out.println("Risk Level is Mandatory is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Mandatory is Required filed Error Message is Displayed");
		}

		//Checking Notes to Auditor
		if(NotesToAuditorRequiredFiled.isDisplayed())
		{
			String Actual_Text = NotesToAuditorRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Notes to Auditor is Not Working As Required Filed");
			System.out.println("Notes to Auditor is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Required filed Error Message is Displayed");
		}

	}

	public void VerifyVerifyCheckPointMandataryFieldsErrorMSGIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking the CheckPoint intent
		if(CheckpointIntentNameisRequiredFiled.isDisplayed())
		{
			String Actual_Text = CheckpointIntentNameisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Checkpoint intent Name is Not Working As Required Filed");
			System.out.println("Checkpoint Intenet Name is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Checkpoint intent Name is Required filed Error Message is Displayed");
		}

		//Checking the Descriptions
		if(DescriptionisRequiredFiled.isDisplayed())
		{
			String Actual_Text = DescriptionisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Descriptions is Not Working As Required Filed");
			System.out.println("Description is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Description is Required filed Error Message is Displayed");
		}


		//Checking Risk Level is mandatory
		if(RiskLevelisRequiredFiled.isDisplayed())
		{
			String Actual_Text = RiskLevelisRequiredFiled.getText();
			String Expected_Text = "Risk Level is Mandatory";
			Assert.assertEquals(Actual_Text, Expected_Text, "Risk Level is Mandatory is Not Working As Required Filed");
			System.out.println("Risk Level is Mandatory is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Mandatory is Required filed Error Message is Displayed");
		}

		//Checking Notes to Auditor
		if(NotesToAuditorRequiredFiled.isDisplayed())
		{
			String Actual_Text = NotesToAuditorRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Notes to Auditor is Not Working As Required Filed");
			System.out.println("Notes to Auditor is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Required filed Error Message is Displayed");
		}

	}

	public void VerifyInputCheckPointMandataryFieldsErrorMSGIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking the CheckPoint intent
		if(CheckpointIntentNameisRequiredFiled.isDisplayed())
		{
			String Actual_Text = CheckpointIntentNameisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Checkpoint intent Name is Not Working As Required Filed");
			System.out.println("Checkpoint Intenet Name is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Checkpoint intent Name is Required filed Error Message is Displayed");
		}

		//Checking the Descriptions
		if(DescriptionisRequiredFiled.isDisplayed())
		{
			String Actual_Text = DescriptionisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Descriptions is Not Working As Required Filed");
			System.out.println("Description is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Description is Required filed Error Message is Displayed");
		}


		//Checking Risk Level is mandatory
		if(RiskLevelisRequiredFiled.isDisplayed())
		{
			String Actual_Text = RiskLevelisRequiredFiled.getText();
			String Expected_Text = "Risk Level is Mandatory";
			Assert.assertEquals(Actual_Text, Expected_Text, "Risk Level is Mandatory is Not Working As Required Filed");
			System.out.println("Risk Level is Mandatory is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Mandatory is Required filed Error Message is Displayed");
		}

		//Checking Notes to Auditor
		if(NotesToAuditorRequiredFiled.isDisplayed())
		{
			String Actual_Text = NotesToAuditorRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Notes to Auditor is Not Working As Required Filed");
			System.out.println("Notes to Auditor is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Required filed Error Message is Displayed");
		}

		//Checking the data type 
		if(DataTypeErrorMSG.isDisplayed())
		{
			String Actual_Text = DataTypeErrorMSG.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Data Type is not Working As Required Filed");
			System.out.println("Data Type is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Data Type is Required Filed Error Message is Displayed");
		}

	}

	public void VerifyBothCheckPointMandataryFieldsErrorMSGIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking the CheckPoint intent
		if(CheckpointIntentNameisRequiredFiled.isDisplayed())
		{
			String Actual_Text = CheckpointIntentNameisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Checkpoint intent Name is Not Working As Required Filed");
			System.out.println("Checkpoint Intenet Name is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Checkpoint intent Name is Required filed Error Message is Displayed");
		}

		//Checking the Descriptions
		if(DescriptionisRequiredFiled.isDisplayed())
		{
			String Actual_Text = DescriptionisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Descriptions is Not Working As Required Filed");
			System.out.println("Description is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Description is Required filed Error Message is Displayed");
		}


		//Checking Risk Level is mandatory
		if(RiskLevelisRequiredFiled.isDisplayed())
		{
			String Actual_Text = RiskLevelisRequiredFiled.getText();
			String Expected_Text = "Risk Level is Mandatory";
			Assert.assertEquals(Actual_Text, Expected_Text, "Risk Level is Mandatory is Not Working As Required Filed");
			System.out.println("Risk Level is Mandatory is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Mandatory is Required filed Error Message is Displayed");
		}

		//Checking Notes to Auditor
		if(NotesToAuditorRequiredFiled.isDisplayed())
		{
			String Actual_Text = NotesToAuditorRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Notes to Auditor is Not Working As Required Filed");
			System.out.println("Notes to Auditor is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Required filed Error Message is Displayed");
		}

		//Checking the data type 
		if(DataTypeErrorMSG.isDisplayed())
		{
			String Actual_Text = DataTypeErrorMSG.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Data Type is not Working As Required Filed");
			System.out.println("Data Type is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Data Type is Required Filed Error Message is Displayed");
		}

	}

	public void VerifyBothWithConditionsCheckPointMandataryFieldsErrorMSGIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		//Checking the CheckPoint intent
		if(CheckpointIntentNameisRequiredFiled.isDisplayed())
		{
			String Actual_Text = CheckpointIntentNameisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Checkpoint intent Name is Not Working As Required Filed");
			System.out.println("Checkpoint Intenet Name is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Checkpoint intent Name is Required filed Error Message is Displayed");
		}

		//Checking the Descriptions
		if(DescriptionisRequiredFiled.isDisplayed())
		{
			String Actual_Text = DescriptionisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Descriptions is Not Working As Required Filed");
			System.out.println("Description is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Description is Required filed Error Message is Displayed");
		}

		//Checking Risk Level is mandatory
		if(RiskLevelisRequiredFiled.isDisplayed())
		{
			String Actual_Text = RiskLevelisRequiredFiled.getText();
			String Expected_Text = "Risk Level is Mandatory";
			Assert.assertEquals(Actual_Text, Expected_Text, "Risk Level is Mandatory is Not Working As Required Filed");
			System.out.println("Risk Level is Mandatory is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Mandatory is Required filed Error Message is Displayed");
		}

		//Checking Notes to Auditor
		if(NotesToAuditorRequiredFiled.isDisplayed())
		{
			String Actual_Text = NotesToAuditorRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Notes to Auditor is Not Working As Required Filed");
			System.out.println("Notes to Auditor is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Required filed Error Message is Displayed");
		}


	}

	public void VerifyMinimumOneDispositionsIsRequired()
	{
		//Checking the Miniumum 1 disposition is required for NO, PARTIAL and N/A
		if(ComplianceErrorMSG.isDisplayed())
		{
			String Actual_Text = ComplianceErrorMSG.getText();
			String Expected_Text = "Minimum 1 disposition is required for NO, PARTIAL and N/A";
			Assert.assertEquals(Actual_Text, Expected_Text, "minimum 1 disposition is required for NO, PARTIAL and N/A is Not displayed");
			System.out.println("minimum 1 disposition is required for NO, PARTIAL and N/A Error Message is Displayed");
			chiledTest.log(Status.INFO, "minimum 1 disposition is required for NO, PARTIAL and N/A Error Message is Displayed");
		}
	}

	public void VerifyAtLeatOneDataTypeHasToBeSelected()
	{
		if(OneDataType.isDisplayed())
		{
			Assert.assertTrue(OneDataType.isDisplayed(), "Atleast one data type has to be selected Error Message is not Displayed");
			System.out.println("Atleast one data type has to be selected Error Message is Displayed");
			chiledTest.log(Status.INFO, "Atleast one data type has to be selected Error Message is Displayed");
		}
	}


	public void VerifyAnnexureCheckPointMandatoryFiledsAreDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking the CheckPoint intent
		if(CheckpointIntentNameisRequiredFiled.isDisplayed())
		{
			String Actual_Text = CheckpointIntentNameisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Checkpoint intent Name is Not Working As Required Filed");
			System.out.println("Checkpoint Intenet Name is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Checkpoint intent Name is Required filed Error Message is Displayed");
		}

		//Checking the Descriptions
		if(DescriptionisRequiredFiled.isDisplayed())
		{
			String Actual_Text = DescriptionisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Descriptions is Not Working As Required Filed");
			System.out.println("Description is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Description is Required filed Error Message is Displayed");
		}

		//Checking the Expected Actions from Auditor
		if(ExpectedActionfromAuditorisRequiredFiled.isDisplayed())
		{
			String Actual_Text = ExpectedActionfromAuditorisRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Expeceted Actions from Auditors is Not Working As Required Filed");
			System.out.println("Expeceted Actions from Auditors is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Expeceted Actions from Auditors is Required filed Error Message is Displayed");
		}

		//Checking Risk Level is mandatory
		if(RiskLevelisRequiredFiled.isDisplayed())
		{
			String Actual_Text = RiskLevelisRequiredFiled.getText();
			String Expected_Text = "Risk Level is Mandatory";
			Assert.assertEquals(Actual_Text, Expected_Text, "Risk Level is Mandatory is Not Working As Required Filed");
			System.out.println("Risk Level is Mandatory is Required filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Mandatory is Required filed Error Message is Displayed");
		}

		//Checking Notes to Auditor
		if(NotesToAuditorRequiredFiled.isDisplayed())
		{
			String Actual_Text = NotesToAuditorRequiredFiled.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Notes to Auditor is Not Working As Required Filed");
			System.out.println("Notes to Auditor is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Risk Level is Required filed Error Message is Displayed");
		}

		//Checking Select Annexure Coulmns is Required Filed
		if(AnnexureColumn.isDisplayed())
		{
			String Actual_Text = AnnexureColumn.getText();
			String Expected_Text = "This field is required.";
			Assert.assertEquals(Actual_Text, Expected_Text, "Select Annexure Columns is Not Working As Required Filed");
			System.out.println("Select Annexure Columns is Required Filed Error Message is Displayed");
			chiledTest.log(Status.INFO, "Select Annexure Columns is Required filed Error Message is Displayed");
		}


	}

	/*public void VerifySubmitAndCancelButtonisDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		boolean isPresent1 = driver.findElements(By.xpath("//input[@type='submit']")).size() > 0;
		boolean isPresent2 = driver.findElements(By.xpath("//div[@class='row']//div[@class='row']//button[@type='button'][contains(text(),'Cancel')]")).size() > 0;
		System.out.println("Submit Button is displayed " + isPresent1);
		System.out.println("Cancel Button is displayed " + isPresent2);
	}*/



	public void VerifyIntentHasAlreadyBeenTakenErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement Error = driver.findElement(By.xpath("//li[@class='alert-error']"));
		if(wait.until(ExpectedConditions.visibilityOf(Error)).isDisplayed())
		{
			String Expected_text = Error.getText();
			String Actual_text = "Intent has already been taken";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Intent has already been taken Error Message is Displayed");
			chiledTest.log(Status.INFO, "Intent has already been taken Error Message is Displayed");
		}
	}

	public void VerifyPleaseEnterValidNumberErrorMSGIsDisplayed(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement YesError = driver.findElement(By.xpath("//label[@id='Yes-error']"));
		WebElement NoError = driver.findElement(By.xpath("//label[@id='No-error']"));
		WebElement PartialError = driver.findElement(By.xpath("//label[@id='Partial-error']"));
		WebElement NAError = driver.findElement(By.xpath("//label[@id='NA-error']"));
		if(YesError.isDisplayed() && NoError.isDisplayed() && PartialError.isDisplayed() && NAError.isDisplayed())
		{
			String Expected_YesError = YesError.getText();
			String Actual_YesError = "Please enter a valid number.";
			Assert.assertEquals(Expected_YesError, Actual_YesError);

			String Expected_NoError = NoError.getText();
			String Actual_NoError = "Please enter a valid number.";
			Assert.assertEquals(Expected_NoError, Actual_NoError);

			String Expected_PartialError = PartialError.getText();
			String Actual_PartialError = "Please enter a valid number.";
			Assert.assertEquals(Expected_PartialError, Actual_PartialError);

			String Expected_NAError = PartialError.getText();
			String Actual_NAError = "Please enter a valid number.";
			Assert.assertEquals(Expected_NAError, Actual_NAError);

			System.out.println("Pass : Please enter a valid number. Error Message is Displayed");
		}

	}

	public void VerifyThisIsRequiredErrorMSGIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement YesError = driver.findElement(By.xpath("//label[@id='Yes-error']"));
		WebElement NoError = driver.findElement(By.xpath("//label[@id='No-error']"));
		WebElement PartialError = driver.findElement(By.xpath("//label[@id='Partial-error']"));
		WebElement NAError = driver.findElement(By.xpath("//label[@id='NA-error']"));
		if(YesError.isDisplayed() && NoError.isDisplayed() && PartialError.isDisplayed() && NAError.isDisplayed())
		{
			String Expected_YesError = YesError.getText();
			String Actual_YesError = "This field is required.";
			Assert.assertEquals(Expected_YesError, Actual_YesError);

			String Expected_NoError = NoError.getText();
			String Actual_NoError = "This field is required.";
			Assert.assertEquals(Expected_NoError, Actual_NoError);

			String Expected_PartialError = PartialError.getText();
			String Actual_PartialError = "This field is required.";
			Assert.assertEquals(Expected_PartialError, Actual_PartialError);

			String Expected_NAError = PartialError.getText();
			String Actual_NAError = "This field is required.";
			Assert.assertEquals(Expected_NAError, Actual_NAError);
			System.out.println("Pass : This field is required. Error Message is Displayed");
		}

	}

	public void ClearAllDispositions(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		//Clearing all Dispositions
		List<WebElement> Clear = driver.findElements(By.xpath("//div[@class='bootstrap-tagsinput']/span/span"));
		int count = Clear.size();
		System.out.println("Total Number os Dispositions are : " + count);
		//Assert.assertTrue(count==16);

		try
		{
			for(int i=0; i<Clear.size(); i++)
			{
				WebElement All = Clear.get(i);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", All);
			}

		}catch (StaleElementReferenceException e) {

		}
	}

	public void ClickSelectGroups() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(GroupName)).click();
		System.out.println("Select Group is Clicked");
		chiledTest.log(Status.INFO, "Select Group is Clicked");
	}


	public void VerifyCheckPointsView(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking Group Name
		wait.until(ExpectedConditions.visibilityOf(GroupName));
		String GP = Lib.getCellValue(XLPATH, "Group", 8, 0);
		String GroupName1 = GroupName.getText();
		Assert.assertEquals(GroupName1, GP, "Group Name is Wrong");
		System.out.println("Group Name is Displayed");
		chiledTest.log(Status.INFO, "Group Name is Displayed and it is in Read only Mode");

		//Checking the CHECK POINT INTENT Name
		wait.until(ExpectedConditions.visibilityOf(EnterCheckpointintent));
		String CIN = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		String CheckpointIntentName = EnterCheckpointintent.getAttribute("value");
		Assert.assertEquals(CheckpointIntentName, CIN, "CheckPoint Intent Name is Wrong");
		System.out.println("CheckPoint Intent Name is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Intent Name is Displayed");

		//Checking the DESCRIPTION 
		wait.until(ExpectedConditions.visibilityOf(Description));
		String DE = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		String Description1 = Description.getAttribute("value");
		Assert.assertEquals(Description1, DE, "CheckPoint Description is Wrong");
		System.out.println("CheckPoint Description is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Description is Displayed");

		//Checking Expected Action From Auditor
		String EAFA = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		WebElement ExpectedActionFromAuditor = driver.findElement(By.xpath("//*[@id='s2id_check_point_complaince_action_type']/a/span[1]"));
		String ExpectedActionFromAuditor1 = wait.until(ExpectedConditions.visibilityOf(ExpectedActionFromAuditor)).getText();
		Assert.assertEquals(ExpectedActionFromAuditor1, EAFA, "Expected Action From Auditor is Wrong");
		System.out.println("Expected Action From Auditor is Displayed");
		chiledTest.log(Status.INFO, "Expected Action From Auditor is Displayed");

		//Checking Positive Conformity 
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		String PositiveConformity1 = wait.until(ExpectedConditions.visibilityOf(PositiveConformity)).getText();
		Assert.assertEquals(PositiveConformity1, PC, "Positive Conformity is Wrong");
		System.out.println("Positive Conformity is Displayed");
		chiledTest.log(Status.INFO, "Positive Conformity is Displayed");


		//Checking Yes Compliance Score 
		String YS = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		Double YS1 = new Double(YS);

		String YesScore = wait.until(ExpectedConditions.visibilityOf(YestextBox)).getAttribute("value");
		Double YesScore1 = new Double(YesScore);
		Assert.assertEquals(YesScore1, YS1, "Yes Compliance Score is Worng");
		System.out.println("Yes Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Yes Compliance Score is Displyed");

		//Checking NO Compliance Score 
		String NO = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		Double NO1 = new Double(NO);

		wait.until(ExpectedConditions.visibilityOf(NoTextBox));
		String NOScore = NoTextBox.getAttribute("value");
		Double NOScore1 = new Double(NOScore);
		Assert.assertEquals(NOScore1, NO1, "No Compliance Score is Worng");
		System.out.println("No  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "No Compliance Score is Displyed");

		//Checking Partial Compliance Score 
		String PA = Lib.getCellValue(XLPATH, "Check Point", 33, 0);
		Double PA1 = new Double(PA);

		wait.until(ExpectedConditions.visibilityOf(PartialTextBox));
		String PAScore = PartialTextBox.getAttribute("value");
		Double PAScore1 = new Double(PAScore);
		Assert.assertEquals(PAScore1, PA1, "Partial Compliance Score is Worng");
		System.out.println("Partial  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Partial Compliance Score is Displyed");

		//Checking NA Compliance Score 
		String NA = Lib.getCellValue(XLPATH, "Check Point", 39, 0);
		Double NA1 = new Double(NA);

		wait.until(ExpectedConditions.visibilityOf(NATextBox));
		String NAScore = NATextBox.getAttribute("value");
		Double NAScore1 = new Double(NAScore);
		Assert.assertEquals(NAScore1, NA1, "NA Compliance Score is Worng");
		System.out.println("NA  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "NA Compliance Score is Displyed");

		//Checking Risk Level
		wait.until(ExpectedConditions.visibilityOf(RiskLevel));
		String RL = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		String RiskLevel1 = RiskLevel.getText();
		Assert.assertEquals(RiskLevel1, RL, "Risk Level is Worng");
		System.out.println("Risk Level is Displyed");
		chiledTest.log(Status.INFO, "Risk Level is Displyed");

		//Checking NOTES TO AUDITORS
		wait.until(ExpectedConditions.visibilityOf(NoticetoAuditors));
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		String NotesToAuditors = NoticetoAuditors.getText();
		Assert.assertEquals(NotesToAuditors, NTA, "Notes To Auditor is Worng");
		System.out.println("Notes To Auditor is Displyed");
		chiledTest.log(Status.INFO, "Notes To Auditor is Displyed");

	}

	public void InputCheckPointView(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking Group Name
		wait.until(ExpectedConditions.visibilityOf(GroupName));
		String GP = Lib.getCellValue(XLPATH, "Group", 8, 0);
		String GroupName1 = GroupName.getText();
		Assert.assertEquals(GroupName1, GP, "Group Name is Wrong");

		System.out.println("Group Name is Displayed");
		chiledTest.log(Status.INFO, "Group Name is Displayed and it is in Read only Mode");

		//Checking the CHECK POINT INTENT Name
		wait.until(ExpectedConditions.visibilityOf(EnterCheckpointintent));
		String CIN = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		String CheckpointIntentName = EnterCheckpointintent.getAttribute("value");
		Assert.assertEquals(CheckpointIntentName, CIN, "CheckPoint Intent Name is Wrong");
		System.out.println("CheckPoint Intent Name is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Intent Name is Displayed");

		//Checking the DESCRIPTION 
		wait.until(ExpectedConditions.visibilityOf(Description));
		String DE = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		String Description1 = Description.getAttribute("value");
		Assert.assertEquals(Description1, DE, "CheckPoint Description is Wrong");
		System.out.println("CheckPoint Description is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Description is Displayed");

		//Checking Expected Action From Auditor
		String EAFA = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
		WebElement ExpectedActionFromAuditor = driver.findElement(By.xpath("//*[@id='s2id_check_point_complaince_action_type']/a/span[1]"));
		String ExpectedActionFromAuditor1 = wait.until(ExpectedConditions.visibilityOf(ExpectedActionFromAuditor)).getText();
		Assert.assertEquals(ExpectedActionFromAuditor1, EAFA, "Expected Action From Auditor is Wrong");
		System.out.println("Expected Action From Auditor is Displayed");
		chiledTest.log(Status.INFO, "Expected Action From Auditor is Displayed");

		//Checking Positive Conformity
		wait.until(ExpectedConditions.visibilityOf(PositiveConformity));
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		String PositiveConformity1 = PositiveConformity.getText();
		Assert.assertEquals(PositiveConformity1, PC, "Positive Conformity is Wrong");
		System.out.println("Positive Conformity is Displayed");
		chiledTest.log(Status.INFO, "Positive Conformity is Displayed");

		//Checking Data Type
		wait.until(ExpectedConditions.visibilityOf(DataType));
		String DT = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		String DataType1 = DataType.getText().toLowerCase();
		Assert.assertEquals(DataType1, DT, "Data Type is Worng");
		System.out.println("Data Type is Displayed");
		chiledTest.log(Status.INFO, "Data Type is Displayed");

		//Checking Risk Level
		wait.until(ExpectedConditions.visibilityOf(RiskLevel));
		String RL = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
		String RiskLevel1 = RiskLevel.getText();
		Assert.assertEquals(RiskLevel1, RL, "Risk Level is Worng");
		System.out.println("Risk Level is Displyed");
		chiledTest.log(Status.INFO, "Risk Level is Displyed");

		//Checking NOTES TO AUDITORS
		wait.until(ExpectedConditions.visibilityOf(NoticetoAuditors));
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		String NotesToAuditors = NoticetoAuditors.getText();
		Assert.assertEquals(NotesToAuditors, NTA, "Notes To Auditor is Worng");
		System.out.println("Notes To Auditor is Displyed");
		chiledTest.log(Status.INFO, "Notes To Auditor is Displyed");

	}

	public void BothCheckpointView(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking Group Name
		wait.until(ExpectedConditions.visibilityOf(GroupName));
		String GP = Lib.getCellValue(XLPATH, "Group", 8, 0);
		String GroupName1 = GroupName.getText();
		Assert.assertEquals(GroupName1, GP, "Group Name is Wrong");
		System.out.println("Group Name is Displayed");
		chiledTest.log(Status.INFO, "Group Name is Displayed and it is in Read only Mode");

		//Checking the CHECK POINT INTENT Name
		wait.until(ExpectedConditions.visibilityOf(EnterCheckpointintent));
		String CIN = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		String CheckpointIntentName = EnterCheckpointintent.getAttribute("value");
		Assert.assertEquals(CheckpointIntentName, CIN, "CheckPoint Intent Name is Wrong");
		System.out.println("CheckPoint Intent Name is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Intent Name is Displayed");

		//Checking the DESCRIPTION 
		wait.until(ExpectedConditions.visibilityOf(Description));
		String DE = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		String Description1 = Description.getAttribute("value");
		Assert.assertEquals(Description1, DE, "CheckPoint Description is Wrong");
		System.out.println("CheckPoint Description is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Description is Displayed");

		//Checking Expected Action From Auditor
		String EAFA = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		WebElement ExpectedActionFromAuditor = driver.findElement(By.xpath("//*[@id='s2id_check_point_complaince_action_type']/a/span[1]"));
		String ExpectedActionFromAuditor1 = wait.until(ExpectedConditions.visibilityOf(ExpectedActionFromAuditor)).getText();
		Assert.assertEquals(ExpectedActionFromAuditor1, EAFA, "Expected Action From Auditor is Wrong");
		System.out.println("Expected Action From Auditor is Displayed");
		chiledTest.log(Status.INFO, "Expected Action From Auditor is Displayed");

		//Checking Positive Conformity
		wait.until(ExpectedConditions.visibilityOf(PositiveConformity));
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		String PositiveConformity1 = PositiveConformity.getText();
		Assert.assertEquals(PositiveConformity1, PC, "Positive Conformity is Wrong");
		System.out.println("Positive Conformity is Displayed");
		chiledTest.log(Status.INFO, "Positive Conformity is Displayed");

		//Checking Yes Compliance Score 
		String YS = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		Double YS1 = new Double(YS);

		wait.until(ExpectedConditions.visibilityOf(YestextBox));
		String YesScore = YestextBox.getAttribute("value");
		Double YesScore1 = new Double(YesScore);
		Assert.assertEquals(YesScore1, YS1, "Yes Compliance Score is Worng");
		System.out.println("Yes Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Yes Compliance Score is Displyed");

		//Checking NO Compliance Score 
		String NO = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		Double NO1 = new Double(NO);

		wait.until(ExpectedConditions.visibilityOf(NoTextBox));
		String NOScore = NoTextBox.getAttribute("value");
		Double NOScore1 = new Double(NOScore);
		Assert.assertEquals(NOScore1, NO1, "No Compliance Score is Worng");
		System.out.println("No  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "No Compliance Score is Displyed");

		//Checking Partial Compliance Score 
		String PA = Lib.getCellValue(XLPATH, "Check Point", 33, 0);
		Double PA1 = new Double(PA);

		wait.until(ExpectedConditions.visibilityOf(PartialTextBox));
		String PAScore = PartialTextBox.getAttribute("value");
		Double PAScore1 = new Double(PAScore);
		Assert.assertEquals(PAScore1, PA1, "Partial Compliance Score is Worng");
		System.out.println("Partial  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Partial Compliance Score is Displyed");

		//Checking NA Compliance Score 
		String NA = Lib.getCellValue(XLPATH, "Check Point", 39, 0);
		Double NA1 = new Double(NA);

		wait.until(ExpectedConditions.visibilityOf(NATextBox));
		String NAScore = NATextBox.getAttribute("value");
		Double NAScore1 = new Double(NAScore);
		Assert.assertEquals(NAScore1, NA1, "NA Compliance Score is Worng");
		System.out.println("NA  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "NA Compliance Score is Displyed");

		//Checking Data Type
		wait.until(ExpectedConditions.visibilityOf(DataType));
		String DT = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		String DataType1 = DataType.getText().toLowerCase();
		Assert.assertEquals(DataType1, DT, "Data Type is Worng");
		System.out.println("Data Type is Displayed");
		chiledTest.log(Status.INFO, "Data Type is Displayed");

		//Checking Risk Level
		wait.until(ExpectedConditions.visibilityOf(RiskLevel));
		String RL = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		String RiskLevel1 = RiskLevel.getText();
		Assert.assertEquals(RiskLevel1, RL, "Risk Level is Worng");
		System.out.println("Risk Level is Displyed");
		chiledTest.log(Status.INFO, "Risk Level is Displyed");

		//Checking NOTES TO AUDITORS
		wait.until(ExpectedConditions.visibilityOf(NoticetoAuditors));
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		String NotesToAuditors = NoticetoAuditors.getText();
		Assert.assertEquals(NotesToAuditors, NTA, "Notes To Auditor is Worng");
		System.out.println("Notes To Auditor is Displyed");
		chiledTest.log(Status.INFO, "Notes To Auditor is Displyed");

	}

	public void BothWithCondtionsCheckPointView(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking Group Name
		wait.until(ExpectedConditions.visibilityOf(GroupName));
		String GP = Lib.getCellValue(XLPATH, "Group", 8, 0);
		String GroupName1 = GroupName.getText();
		Assert.assertEquals(GroupName1, GP, "Group Name is Wrong");
		System.out.println("Group Name is Displayed");
		chiledTest.log(Status.INFO, "Group Name is Displayed and it is in Read only Mode");

		//Checking the CHECK POINT INTENT Name
		wait.until(ExpectedConditions.visibilityOf(EnterCheckpointintent));
		String CIN = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		String CheckpointIntentName = EnterCheckpointintent.getAttribute("value");
		Assert.assertEquals(CheckpointIntentName, CIN, "CheckPoint Intent Name is Wrong");
		System.out.println("CheckPoint Intent Name is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Intent Name is Displayed");

		//Checking the DESCRIPTION 
		wait.until(ExpectedConditions.visibilityOf(Description));
		String DE = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		String Description1 = Description.getAttribute("value");
		Assert.assertEquals(Description1, DE, "CheckPoint Description is Wrong");
		System.out.println("CheckPoint Description is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Description is Displayed");

		//Checking Expected Action From Auditor
		String EAFA = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		WebElement ExpectedActionFromAuditor = driver.findElement(By.xpath("//*[@id='s2id_check_point_complaince_action_type']/a/span[1]"));
		String ExpectedActionFromAuditor1 = wait.until(ExpectedConditions.visibilityOf(ExpectedActionFromAuditor)).getText();
		Assert.assertEquals(ExpectedActionFromAuditor1, EAFA, "Expected Action From Auditor is Wrong");
		System.out.println("Expected Action From Auditor is Displayed");
		chiledTest.log(Status.INFO, "Expected Action From Auditor is Displayed");

		wait.until(ExpectedConditions.visibilityOf(PositiveConformity));
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		String PositiveConformity1 = PositiveConformity.getText();
		Assert.assertEquals(PositiveConformity1, PC, "Positive Conformity is Wrong");
		System.out.println("Positive Conformity is Displayed");
		chiledTest.log(Status.INFO, "Positive Conformity is Displayed");

		//Checking Yes Compliance Score 
		String YS = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		Double YS1 = new Double(YS);

		wait.until(ExpectedConditions.visibilityOf(YestextBox));
		String YesScore = YestextBox.getAttribute("value");
		Double YesScore1 = new Double(YesScore);
		Assert.assertEquals(YesScore1, YS1, "Yes Compliance Score is Worng");
		System.out.println("Yes Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Yes Compliance Score is Displyed");

		//Checking NO Compliance Score 
		String NO = Lib.getCellValue(XLPATH, "Check Point", 24, 0);
		Double NO1 = new Double(NO);

		wait.until(ExpectedConditions.visibilityOf(NoTextBox));
		String NOScore = NoTextBox.getAttribute("value");
		Double NOScore1 = new Double(NOScore);
		Assert.assertEquals(NOScore1, NO1, "No Compliance Score is Worng");
		System.out.println("No  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "No Compliance Score is Displyed");

		//Checking Partial Compliance Score 
		String PA = Lib.getCellValue(XLPATH, "Check Point", 33, 0);
		Double PA1 = new Double(PA);

		wait.until(ExpectedConditions.visibilityOf(PartialTextBox));
		String PAScore = PartialTextBox.getAttribute("value");
		Double PAScore1 = new Double(PAScore);
		Assert.assertEquals(PAScore1, PA1, "Partial Compliance Score is Worng");
		System.out.println("Partial  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Partial Compliance Score is Displyed");

		//Checking NA Compliance Score 
		String NA = Lib.getCellValue(XLPATH, "Check Point", 39, 0);
		Double NA1 = new Double(NA);

		wait.until(ExpectedConditions.visibilityOf(NATextBox));
		String NAScore = NATextBox.getAttribute("value");
		Double NAScore1 = new Double(NAScore);
		Assert.assertEquals(NAScore1, NA1, "NA Compliance Score is Worng");
		System.out.println("NA  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "NA Compliance Score is Displyed");

		//Checking the 1st Data Type
		wait.until(ExpectedConditions.visibilityOf(FirstDataType));
		String FD = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		String FirstDataType1 = FirstDataType.getText().toLowerCase();
		Assert.assertEquals(FirstDataType1, FD, "First Data Type is Worng");
		System.out.println("Yes Data Type is Displayed");
		chiledTest.log(Status.INFO, "Yes Data Type is Displayed");

		//Checking the 2nd Data Type
		wait.until(ExpectedConditions.visibilityOf(SecondDataType));
		String SD = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		String SecondDataType1 = SecondDataType.getText().toLowerCase();
		Assert.assertEquals(SecondDataType1, SD, "Second Data Type is Worng");
		System.out.println("NO Data Type is Displayed");
		chiledTest.log(Status.INFO, "No Data Type is Displayed");

		//Checking the 3rd Data Type
		wait.until(ExpectedConditions.visibilityOf(ThirdDataType));
		String TD = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		String ThirdDataType1 = ThirdDataType.getText().toLowerCase();
		Assert.assertEquals(ThirdDataType1, TD, "Third Data Type is Worng");
		System.out.println("Partial Data Type is Displayed");
		chiledTest.log(Status.INFO, "Partial Data Type is Displayed");

		//Checking the 4th Data Type
		wait.until(ExpectedConditions.visibilityOf(FourthDataType));
		String FTD = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
		String FourthDataType1 = FourthDataType.getText().toLowerCase();
		Assert.assertEquals(FourthDataType1, FTD, "First Data Type is Worng");
		System.out.println("NA Data Type is Displayed");
		chiledTest.log(Status.INFO, "NA Data Type is Displayed");

		//Checking Risk Level
		wait.until(ExpectedConditions.visibilityOf(RiskLevel));
		String RL = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		String RiskLevel1 = RiskLevel.getText();
		Assert.assertEquals(RiskLevel1, RL, "Risk Level is Worng");
		System.out.println("Risk Level is Displyed");
		chiledTest.log(Status.INFO, "Risk Level is Displyed");

		//Checking NOTES TO AUDITORS
		wait.until(ExpectedConditions.visibilityOf(NoticetoAuditors));
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		String NotesToAuditors = NoticetoAuditors.getText();
		Assert.assertEquals(NotesToAuditors, NTA, "Notes To Auditor is Worng");
		System.out.println("Notes To Auditor is Displyed");
		chiledTest.log(Status.INFO, "Notes To Auditor is Displyed");

	}


	public void UpdatedBothWithCondtionsCheckPointView(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Checking Group Name
		wait.until(ExpectedConditions.visibilityOf(GroupName));
		String GP = Lib.getCellValue(XLPATH, "Group", 11, 0);
		String GroupName1 = GroupName.getText();
		Assert.assertEquals(GroupName1, GP, "Group Name is Wrong");
		System.out.println("Group Name is Displayed");
		chiledTest.log(Status.INFO, "Group Name is Displayed and it is in Read only Mode");

		//Checking the CHECK POINT INTENT Name
		wait.until(ExpectedConditions.visibilityOf(EnterCheckpointintent));
		String CIN = Lib.getCellValue(XLPATH, "Check Point", 59, 0);
		String CheckpointIntentName = EnterCheckpointintent.getAttribute("value");
		Assert.assertEquals(CheckpointIntentName, CIN, "CheckPoint Intent Name is Wrong");
		System.out.println("CheckPoint Intent Name is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Intent Name is Displayed");

		//Checking the DESCRIPTION 
		wait.until(ExpectedConditions.visibilityOf(Description));
		String DE = Lib.getCellValue(XLPATH, "Check Point", 65, 0);
		String Description1 = Description.getAttribute("value");
		Assert.assertEquals(Description1, DE, "CheckPoint Description is Wrong");
		System.out.println("CheckPoint Description is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Description is Displayed");

		//Checking Expected Action From Auditor
		String EAFA = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		WebElement ExpectedActionFromAuditor = driver.findElement(By.xpath("//*[@id='s2id_check_point_complaince_action_type']/a/span[1]"));
		String ExpectedActionFromAuditor1 = wait.until(ExpectedConditions.visibilityOf(ExpectedActionFromAuditor)).getText();
		Assert.assertEquals(ExpectedActionFromAuditor1, EAFA, "Expected Action From Auditor is Wrong");
		System.out.println("Expected Action From Auditor is Displayed");
		chiledTest.log(Status.INFO, "Expected Action From Auditor is Displayed");

		wait.until(ExpectedConditions.visibilityOf(PositiveConformity));
		String PC = Lib.getCellValue(XLPATH, "Check Point", 226, 0);
		String PositiveConformity1 = PositiveConformity.getText();
		Assert.assertEquals(PositiveConformity1, PC, "Positive Conformity is Wrong");
		System.out.println("Positive Conformity is Displayed");
		chiledTest.log(Status.INFO, "Positive Conformity is Displayed");

		//Checking Yes Compliance Score 
		String YS = Lib.getCellValue(XLPATH, "Check Point", 80, 0);
		double Ys1 = Double.parseDouble(YS);

		wait.until(ExpectedConditions.visibilityOf(YestextBox));
		String YesScore = YestextBox.getAttribute("value");
		double YesScore1 = Double.parseDouble(YesScore);
		Assert.assertEquals(Ys1, YesScore1, "Yes Compliance Score is Worng");
		System.out.println("Yes Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Yes Compliance Score is Displyed");

		//Checking NO Compliance Score 
		String NO = Lib.getCellValue(XLPATH, "Check Point", 77, 0);
		double NO1 = Double.parseDouble(NO);


		wait.until(ExpectedConditions.visibilityOf(NoTextBox));
		String NOScore = NoTextBox.getAttribute("value");
		double NOScore1 = Double.parseDouble(NOScore);
		Assert.assertEquals(NO1, NOScore1, "No Compliance Score is Worng");
		System.out.println("No  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "No Compliance Score is Displyed");

		//Checking Partial Compliance Score 
		String PA = Lib.getCellValue(XLPATH, "Check Point", 33, 0);
		double PA1 = Double.parseDouble(PA);

		wait.until(ExpectedConditions.visibilityOf(PartialTextBox));
		String PAScore = PartialTextBox.getAttribute("value");
		double PAScore1 = Double.parseDouble(PAScore);
		Assert.assertEquals(PA1, PAScore1, "Partial Compliance Score is Worng");
		System.out.println("Partial  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "Partial Compliance Score is Displyed");

		//Checking NA Compliance Score 
		String NA = Lib.getCellValue(XLPATH, "Check Point", 39, 0);
		double NA1 = Double.parseDouble(NA);

		wait.until(ExpectedConditions.visibilityOf(NATextBox));
		String NAScore = NATextBox.getAttribute("value");
		double NAScore1 = Double.parseDouble(NAScore);
		Assert.assertEquals(NAScore1, NA1, "NA Compliance Score is Worng");
		System.out.println("NA  Compliance Score is Displyed");
		chiledTest.log(Status.INFO, "NA Compliance Score is Displyed");

		//Checking the 1st Data Type
		wait.until(ExpectedConditions.visibilityOf(FirstDataType));
		String FD = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		String FirstDataType1 = FirstDataType.getText();
		FirstDataType1.equalsIgnoreCase(FD);
		System.out.println("Yes Data Type is Displayed");
		chiledTest.log(Status.INFO, "Yes Data Type is Displayed");

		//Checking the 2nd Data Type
		wait.until(ExpectedConditions.visibilityOf(SecondDataType));
		String SD = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		String SecondDataType1 = SecondDataType.getText();
		SecondDataType1.equalsIgnoreCase(SD);
		System.out.println("NO Data Type is Displayed");
		chiledTest.log(Status.INFO, "No Data Type is Displayed");

		//Checking the 3rd Data Type
		wait.until(ExpectedConditions.visibilityOf(ThirdDataType));
		String TD = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		String ThirdDataType1 = ThirdDataType.getText();
		ThirdDataType1.equalsIgnoreCase(TD);
		System.out.println("Partial Data Type is Displayed");
		chiledTest.log(Status.INFO, "Partial Data Type is Displayed");

		//Checking the 4th Data Type
		wait.until(ExpectedConditions.visibilityOf(FourthDataType));
		String FTD = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
		String FourthDataType1 = FourthDataType.getText();
		FourthDataType1.equalsIgnoreCase(FTD);
		System.out.println("NA Data Type is Displayed");
		chiledTest.log(Status.INFO, "NA Data Type is Displayed");

		//Checking Risk Level
		wait.until(ExpectedConditions.visibilityOf(RiskLevel));
		String RL = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		String RiskLevel1 = RiskLevel.getText();
		Assert.assertEquals(RiskLevel1, RL, "Risk Level is Worng");
		System.out.println("Risk Level is Displyed");
		chiledTest.log(Status.INFO, "Risk Level is Displyed");

		//Checking NOTES TO AUDITORS
		wait.until(ExpectedConditions.visibilityOf(NoticetoAuditors));
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 83, 0);
		String NotesToAuditors = NoticetoAuditors.getText();
		Assert.assertEquals(NotesToAuditors, NTA, "Notes To Auditor is Worng");
		System.out.println("Notes To Auditor is Displyed");
		chiledTest.log(Status.INFO, "Notes To Auditor is Displyed");

	}


	public void VerifyNoShouldhaveHigherscoresThanYesPartialAndNA(WebDriver driver)
	{

		WebDriverWait wait = new WebDriverWait(driver, 5);
		if(wait.until(ExpectedConditions.visibilityOf(ComplianceErrorMSG)).isDisplayed())
		{
			String Actual_Text = ComplianceErrorMSG.getText();
			String Expected_Text = "No should have higher scores than Yes, Partial and N/A";
			Assert.assertEquals(Actual_Text, Expected_Text, "Validation Message is Wrong");
			System.out.println("Pass : No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed");
			chiledTest.log(Status.INFO, "No should have higher or equal scores than Yes, Partial and N/A Error Message is Displayed");
		}	
	}


	public void VerifyYesShouldhaveHigherscoresThanNoPartialAndNA(WebDriver driver)
	{

		WebDriverWait wait = new WebDriverWait(driver, 5);
		if(wait.until(ExpectedConditions.visibilityOf(ComplianceErrorMSG)).isDisplayed())
		{
			String Actual_Text = ComplianceErrorMSG.getText();
			String Expected_Text = "Yes should have higher scores than No, Partial and N/A";
			Assert.assertEquals(Actual_Text, Expected_Text, "Validation Message is Wrong");
			System.out.println("Pass : Yes should have higher or equal scores than No, Partial and N/A Error Message is Displayed");
			chiledTest.log(Status.INFO, "Yes should have higher or equal scores than No, Partial and N/A Error Message is Displayed");
		}	
	}

	public void VerifyPartialComplianceIsReadonlyOrNot(WebDriver driver)
	{
		WebElement Partail = driver.findElement(By.xpath("//input[@id='Partial' and @value='0.0' and @readonly='readonly']"));
		Assert.assertTrue(Partail.isDisplayed(), "Partial Compliance is Not Working as Read only Mode");
		System.out.println("Partial Compliance is Read only");
		chiledTest.log(Status.INFO, "Partial Compliance is Read only");
	}

	public void VerifyNAComplianceIsReadonly(WebDriver driver)
	{
		WebElement NA = driver.findElement(By.xpath("//input[@id='NA_score' and @value='0.0' and @readonly='readonly']"));
		Assert.assertTrue(NA.isDisplayed(), "NA Compliance is Not Working as Read only Mode");
		System.out.println("NA Compliance is Read only");
		chiledTest.log(Status.INFO, "NA Compliance is Read only");

	}

	public void VerifyNOComplianceIsReadonly(WebDriver driver)
	{
		WebElement NA = driver.findElement(By.xpath("//input[@id='No' and @value='0.0' and @readonly='readonly']"));
		Assert.assertTrue(NA.isDisplayed(), "NO Compliance is Not Working as Read only Mode");
		System.out.println("NO Compliance is Read only");
		chiledTest.log(Status.INFO, "NO Compliance is Read only");
	}

	public void VerifyPartialDispositionIsReadOnly()
	{
		WebElement NA = driver.findElement(By.xpath("//input[@id='check_point_complaince_check_point_options_attributes_2_disposition_list' and @disabled='disabled']"));
		Assert.assertTrue(NA.isDisplayed(), "Partial Disposition is Not Working as Read only Mode");
		System.out.println("Partial Disposition is Read only");
		chiledTest.log(Status.INFO, "Partial Disposition is Read only");
	}


	public void VerifyNADispositionIsReadOnly()
	{
		WebElement NA = driver.findElement(By.xpath("//input[@id='check_point_complaince_check_point_options_attributes_3_disposition_list' and @disabled='disabled']"));
		Assert.assertTrue(NA.isDisplayed(), "NA Disposition is Not Working as Read only Mode");
		System.out.println("NA Disposition is Read only");
		chiledTest.log(Status.INFO, "NA Disposition is Read only");
	}
	
	public void VerifyGroupNameIsAlradyTakenErrorMsgIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement GroupError = driver.findElement(By.xpath("//span[text()='Group Name has already been taken.']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(GroupError)).isDisplayed(), "Group Name has already been taken. Error Message is not displayed");
		System.out.println("Group Name has already been taken. Error Message is Displayed");
		chiledTest.log(Status.INFO, "Group Name has already been taken. Error Message is Displayed");
	}
}



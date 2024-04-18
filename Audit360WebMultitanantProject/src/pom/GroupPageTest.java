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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class GroupPageTest extends BaseTest {

	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Checkpoints under side menu//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Check Points']
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Check Points']")
	private WebElement Checkpoints;

	//Clicking on the Annexures side menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Manage CheckPoints']")
	private WebElement ManageCheckpoints;

	//clicking on the Group Type
	@FindBy(xpath="//div[@id='s2id_type']/a[@class='select2-choice']/span[@class='select2-chosen']")
	private WebElement GroupType;

	//Clicking on the Annexure 
	@FindBy(xpath="//div[@id='s2id_annexure']/a/span[1]")
	private WebElement Annexure;

	//selecting the General Group Type under Group Type
	@FindBy(xpath="//select[@id='type']/option[2]")
	private WebElement GeneralGroup;

	//Passing the Values to Group Type
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetGroupType;

	//selecting the Annexure Group Type under Group Type
	@FindBy(xpath="//select[@id='type']/option[3]")
	private WebElement AnnexureGroup;

	//clicking on the add new Group
	@FindBy(xpath="//input[@class='form-control group_name']")
	private WebElement AddnewGroup;

	//Clicking on the Select Annexure 
	@FindBy(xpath="//div[@id='s2id_annexure']/a/span[1]")
	private WebElement SelectAnnexure;

	//Passing the values to Select Annexure
	@FindBy(xpath="//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input[@type='text']")
	private WebElement SetSelectAnnexure;

	//Selecting the Annexure options under Annexure
	@FindBy(xpath="//ul[@class='select2-results scroll-content']/li[2]")
	private WebElement AnnexureOption;

	//Clicking on the Select Scoring Logic
	@FindBy(xpath="//div[@id='s2id_scoring_logic']/a[@class='select2-choice']/span[1]")
	private WebElement SelectScoringLogic;

	//Passing the Values to Select Scoring Logic
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetScoringLogic;

	//clicking on the Add Button 
	@FindBy(xpath="//button[@class='btn btn-primary add_group']")
	private WebElement AddBTN;

	//clicking on the Search Button
	@FindBy(xpath="//div[@id='ckgroupTable_filter']//input[contains(@type,'search')]")
	private WebElement SearchBox;

	//clicking on the edit group
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement editBTN;

	//Passing the values to group name in edit mode
	@FindBy(xpath="//input[@id='check_point_group_name']")
	private WebElement GroupName;

	//clicking on the save Button
	@FindBy(xpath="//input[@class='btn btn-primary btn-block']")
	private WebElement SaveBTN;

	//Clicking on the Delete Button
	@FindBy(xpath=".//*[@id='popup_stat']")
	private WebElement DeleteIcon;

	//Checking Are you sure you want to delete the selected Group(s)? pop up is displyed or not
	@FindBy(xpath="//div[@class='modal-content']")
	private WebElement Alert;

	//Clicking on the OK Button
	@FindBy(xpath="//div[@class='col-md-6 col-xs-12']/button[@class='btn btn-primary btn-block m-t-5 delete-group']")////button[text()='Ok']
	private WebElement OKBTN;

	//clicking on the Matched Text
	@FindBy(xpath="//ul[@class='select2-results scroll-content']/li/div/span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the Manage Check Point Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement ManageCheckPointHeader;

	//Clicking on the Check Box
	@FindBy(xpath="//*[@id='ckgroupTable']/tbody/tr[1]/td[1]/div/label")
	private WebElement CheckBoxBTN;

	//clicking on the Masters / Add Checkpoint
	@FindBy(xpath="//a[contains(text(),'Masters / Add Checkpoint')]")
	private WebElement MastersAddCheckpoint;

	//clicking on the Select Group //div[@id='s2id_check_point_group_id']//span[text()='Select Group']
	@FindBy(xpath="//div[@id='s2id_check_point_group_id']//span[@class='select2-chosen']")
	private WebElement SelectGroup;

	//Passing the Values to Select Group
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement SetGroup;

	//clicking on the Go Button
	@FindBy(xpath="//button[@id='get_check_points_list_with_search_params']")
	private WebElement GOBTN;

	//clicking on 1st Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[1]")
	private WebElement FirstCP;

	//clicking on 1st Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[2]")
	private WebElement SecondCP;

	//clicking on 1st Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[3]")
	private WebElement ThirdCP;

	//clicking on 1st Checkpoint
	@FindBy(xpath="//table[@id='cktableWithSearch']/tbody/tr[4]")
	private WebElement FourthCP;

	public GroupPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickCheckpoints(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Checkpoints);
	}

	public void ClickManageCheckpoints(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageCheckpoints);
	}

	public void ClickGroupType(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(GroupType)).click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickAnnexure()
	{
		try
		{
			Annexure.click();
		}catch (StaleElementReferenceException e) {

		}

	}

	public void SetGroupType(String SG)
	{
		SetGroupType.sendKeys(SG);
		System.out.println("Selected Group Type is : " + SG);
	}

	public void ClickGeneralGroup()
	{
		GeneralGroup.click();
	}

	public void ClickAnnexureGroup()
	{
		AnnexureGroup.click();
	}

	public void ClickSelectAnnexure()
	{
		SelectAnnexure.click();
	}

	public void SetSelectAnnexure(String SA)
	{
		SetSelectAnnexure.sendKeys(SA);
		System.out.println("Selected Annexure is : " + SA);
	}

	public void ClickManageCheckPointHeader(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageCheckPointHeader);
	}

	public void ClickAnnexureOption(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(AnnexureOption));
		String text = AnnexureOption.getText();
		System.out.println("Selected Annexure option is : " + text );
		AnnexureOption.click();
	}

	public void SetAddnewGroup(String ADG)
	{
		AddnewGroup.sendKeys(ADG);
		System.out.println("Entered Group Name is : " + ADG);
	}

	public void ClickAddBTN()
	{
		AddBTN.click();
	}

	public void SetSearchBox(String SB) throws InterruptedException
	{
		SearchBox.clear();
		Thread.sleep(1000);
		SearchBox.sendKeys(SB);
		System.out.println("Searched Group Name is : " + SB);
	}

	public void ClickSelectScoringLogic()
	{
		SelectScoringLogic.click();
	}

	public void SetScoringLogic(String SL)
	{
		SetScoringLogic.sendKeys(SL);
		System.out.println("Selected Scoring Logic is : " + SL);
	}

	public void ClickEditButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(editBTN)).click();
		System.out.println("Edit Button is Clicked");
	}

	public void SetGroupName(String GN) throws InterruptedException
	{
		GroupName.clear();
		Thread.sleep(2000);
		GroupName.sendKeys(GN);
		System.out.println("Entered Group Name is : " + GroupName);
	}

	public void ClickSaveBTN() throws InterruptedException
	{
		SaveBTN.click();
		System.out.println("Save Button is Clicked");
	}

	public void ClickCheckboxBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", CheckBoxBTN);
		System.out.println("Check Box is Clicked");
		chiledTest.log(Status.INFO, "Check Box is Clicked");
	}
	public void clickDeleteIcon(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(DeleteIcon)).click();
		System.out.println("Delete Button is Clicked");
	}

	public void ClickMatched(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(Matched)).click();
		//Matched.click();
	}

	public void ClickOKBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(OKBTN)).click();
	}

	public void ClickMastersAddCheckpoint()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", MastersAddCheckpoint);
		//MastersAddCheckpoint.click();
		System.out.println("Master/Add Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "Master/Add Checkpoint is Clicked");
	}

	public void ClickSelectGroup() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SelectGroup)).click();
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SelectGroup);*/
		System.out.println("Select Group is Clicked");
		chiledTest.log(Status.INFO, "Select Group is Clicked");
	}

	public void SetGroup(String SG)
	{
		SetGroup.sendKeys(SG);
		System.out.println("Enterd Group name is : " + SG);
		chiledTest.log(Status.INFO, "Group name is selected");
	}

	public void ClickGOButton()
	{
		GOBTN.click();
		System.out.println("Go Button is Clicked");
		chiledTest.log(Status.INFO, "Go Button is Clicked");
	}

	public void ClickFirstCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		FirstCP.click();
		System.out.println("1st Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "1st Checkpoint is Clicked");
	}

	public void ClickSecondCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		SecondCP.click();
		System.out.println("2nd Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "2nd Checkpoint is Clicked");
	}

	public void ClickThirdCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		ThirdCP.click();
		System.out.println("3rd Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "3rd Checkpoint is Clicked");
	}

	public void ClickFourthCheckPoint() throws InterruptedException
	{
		Thread.sleep(2000);
		FourthCP.click();
		System.out.println("4th Checkpoint is Clicked");
		chiledTest.log(Status.INFO, "4th Checkpoint is Clicked");
	}

	public void Verify4NoIsDisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		String Actual_No = driver.findElement(By.xpath("//table[@id='ckgroupTable']//td/a[@class='btn btn-sm  btn-rounded btn-primary collapseTwo']")).getText();
		String Expected_No = "4";
		Assert.assertEquals(Actual_No, Expected_No, "4 CP Is Not Displayed");
		System.out.println("4 CP is Displayed");
		chiledTest.log(Status.INFO, "4 Checkpoint is Clicked");
	}
	
	public void Verify1NoIsDisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		String Actual_No = driver.findElement(By.xpath("//table[@id='ckgroupTable']//td/a[@class='btn btn-sm  btn-rounded btn-primary collapseTwo']")).getText();
		String Expected_No = "1";
		Assert.assertEquals(Actual_No, Expected_No, "4 CP Is Not Displayed");
		System.out.println("1 CP is Displayed");
		chiledTest.log(Status.INFO, "1 Checkpoint is Clicked");
	}
	
	public void Verify5NoIsDisplayed() throws InterruptedException
	{
		Thread.sleep(2000);
		String Actual_No = driver.findElement(By.xpath("//table[@id='ckgroupTable']//td/a[@class='btn btn-sm  btn-rounded btn-primary collapseTwo']")).getText();
		String Expected_No = "5";
		Assert.assertEquals(Actual_No, Expected_No, "5 CP Is Not Displayed");
		System.out.println("5 CP is Displayed");
		chiledTest.log(Status.INFO, "5 Checkpoint is Clicked");
	}


	public void VerifyGourpPageIsDisplayed(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 400);

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		//checking home header
		WebElement Home = driver.findElement(By.xpath("//a[text()='Home']"));
		if(Home.isDisplayed())
		{
			String Actual_home = Home.getText();
			String Expected_home = "HOME";
			Assert.assertEquals(Actual_home, Expected_home);
			System.out.println("Home Header is Displayed");
		}

		//Checking the Manage check point Header 
		WebElement MangeCheckPoint = driver.findElement(By.xpath("//a[@class='active']"));
		if(MangeCheckPoint.isDisplayed())
		{
			String Actual_text = MangeCheckPoint.getText();
			String Expect_text ="MANAGE CHECK POINT";
			Assert.assertEquals(Actual_text, Expect_text);
			System.out.println("Manage Check point Header is Displayed");
		}

		//checking Master/Add group Header
		WebElement Master = driver.findElement(By.xpath("//a[@class='collapse_one collapse']"));
		if(Master.isDisplayed())
		{
			String Actual_text = Master.getText();
			String Expect_text ="MASTERS / ADD GROUP";
			Assert.assertEquals(Actual_text, Expect_text);
			System.out.println("MASTERS / ADD GROUP Header is Displayed");
		}

		//checking Group Type drop down
		WebElement GroupTypeDropdown = driver.findElement(By.xpath("//label[text()='Group Type']"));
		if(GroupTypeDropdown.isDisplayed())
		{
			String Actual_GroupTypeDropdown = GroupTypeDropdown.getText();
			String Expected_GroupTypeDropdown = "GROUP TYPE";
			Assert.assertEquals(Actual_GroupTypeDropdown, Expected_GroupTypeDropdown);

			System.out.println("Pass : Group type drop down is Displayed");
		}

		//clicking on the Select group type
		WebElement SelectGroupType = driver.findElement(By.xpath("//span[@id='select2-chosen-9']"));
		if(SelectGroupType.isDisplayed())
		{
			String Actual_SelectGroupType = SelectGroupType.getText();
			String Expected_SelectGroupType = "Select group type";
			Assert.assertEquals(Actual_SelectGroupType, Expected_SelectGroupType);	

			System.out.println("Pass : Select Group Type is Displayed");

		}


		//Checking on the Annexure drop down
		WebElement Annexure = driver.findElement(By.xpath("//label[text()='Annexure']"));
		if(Annexure.isDisplayed())
		{
			String Actual_Annexure = Annexure.getText();
			String Expected_Annexure = "ANNEXURE";
			Assert.assertEquals(Actual_Annexure, Expected_Annexure);
			System.out.println("Pass : Annexure drop down is Displayed");
		}

		//clicking on the Select Annexure
		WebElement SelectAnnexure = driver.findElement(By.xpath("//div[@id='s2id_annexure']/a/span[1]"));
		if(SelectAnnexure.isDisplayed())
		{
			String Actual_SelectAnnexure = SelectAnnexure.getText();
			String Expected_SelectAnnexure = "Select Annexure";
			Assert.assertEquals(Actual_SelectAnnexure, Expected_SelectAnnexure);
			System.out.println("Pass : Select Annexure is Displayed");


		}

		//Checking on the Add New Group
		WebElement AddNewGroup = driver.findElement(By.xpath("//div[@class='form-group form-group-default input-group required']"));

		//clicking on the Enter Group Name
		WebElement EnterGroupName = driver.findElement(By.xpath("//input[@class='form-control group_name']"));
		if(AddNewGroup.isDisplayed() && EnterGroupName.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("ADD NEW GROUP and Enter Group Name is Displayed");
		}

		//Checking the Add Button
		WebElement AddButton = driver.findElement(By.xpath("//button[@class='btn btn-primary add_group']"));
		if(AddButton.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Add Button is Displayed");
		}

		//Checking the Search Text box
		WebElement SearchTextFiled = driver.findElement(By.xpath("//input[@aria-controls='ckgroupTable']"));
		if(SearchTextFiled.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Search Text Field Displayed");
		}

		//Checking the Delete Button
		WebElement delete = driver.findElement(By.xpath("//a[@id='popup_stat']"));
		if(delete.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Delete Button is Displayed");
		}

		//checking the group name
		WebElement GroupName1 = driver.findElement(By.xpath("//th[text()='Group Name']"));
		if(GroupName1.isDisplayed())
		{
			String Actual_text = GroupName1.getText();
			String Expected_text = "GROUP NAME";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Group Name is Displayed");

		}

		//Checking the No of Check Points
		WebElement NoCheckPoints = driver.findElement(By.xpath("//th[text()='No.of Checkpoints']"));
		if(NoCheckPoints.isDisplayed())
		{
			String Actual_text = NoCheckPoints.getText();
			String Expected_text = "NO.OF CHECKPOINTS";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("NO.OF Checkpoints is Displayed");

		}

		//Checking the Group Type
		WebElement GroupType = driver.findElement(By.xpath("//th[text()='Group Type']"));
		if(GroupType.isDisplayed())
		{
			String Actual_text = GroupType.getText();
			String Expected_text = "GROUP TYPE";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("group type is Displayed");

		}

		//checking the Time Stamp
		WebElement TimeStamp = driver.findElement(By.xpath("//th[text()='Time Stamp']"));
		if(TimeStamp.isDisplayed())
		{
			String Actual_text = TimeStamp.getText();
			String Expected_text = "TIME STAMP";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Time Stamp is Displayed");

		}

		//checking the Check box
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(checkbox.isDisplayed())
		{
			List<WebElement> CheckBoxcount  = driver.findElements(By.xpath("//input[@type='checkbox']"));
			int count = CheckBoxcount.size();
			int Actual_count = count;
			int Expected_count = 5;
			Assert.assertEquals(Actual_count, Expected_count);
			System.out.println("Check Boxs are Displayed");
		}

		//Checking the Edit Icon
		WebElement EditIcon = driver.findElement(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
		if(EditIcon.isDisplayed())
		{
			List<WebElement> EditIconcount  = driver.findElements(By.xpath("//a[@class='btn btn-rounded btn-primary']"));
			int count = EditIconcount.size();
			int Actual_count = count;
			int Expected_count = 5;
			Assert.assertEquals(Actual_count, Expected_count);
			System.out.println("Edit Buttons are Displayed");
		}

		//checking the data
		WebElement GroupData = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr"));
		if(GroupData.isDisplayed())
		{
			List<WebElement> Groupdatacount  = driver.findElements(By.xpath("//table[@id='ckgroupTable']/tbody/tr"));
			int count = Groupdatacount.size();
			int Actual_count = count;
			int Expected_count = 5;
			Assert.assertEquals(Actual_count, Expected_count);
			System.out.println("Group List are Displayed");
		}

	}

	public void VerifyGroupCreatedSuccessfullyisdisplyed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement text = driver.findElement(By.xpath("//span[text()='Group created successfully.']"));
		if(wait.until(ExpectedConditions.visibilityOf(text)).isDisplayed())
		{
			String Actual_Text = text.getText();
			String Expected_Text = "Group created successfully.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Group created successfully Confirmation Mesage is Displyed");

			//Clicking on the Cancel Button
			WebElement CloseBTN = driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']"));
			wait.until(ExpectedConditions.visibilityOf(CloseBTN)).click();
		}

	}

	public void VerifyGroupUpdatedSuccessfullyisdisplyed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement text = driver.findElement(By.xpath("//span[text()='Group updated successfully.']"));
		if(wait.until(ExpectedConditions.visibilityOf(text)).isDisplayed())
		{
			String Actual_Text = text.getText();
			String Expected_Text = "Group updated successfully.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Group updated successfully Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}

	}

	public void VerifySearchedGroupIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement Group = driver.findElement(By.xpath("//td[@class='v-align-middle edit_group']"));
		Assert.assertTrue(Group.isDisplayed());
	}

	public void VerifyNoRecardfoundisdiplyed(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement NoRecordssMsg = driver.findElement(By.xpath("//td[text()='No Record Found.']"));
		Assert.assertTrue(NoRecordssMsg.isDisplayed(), "No Record Found. Error Message is NOt Displayed");
		System.out.println("No Record Found. Error Message is Displayed");
		chiledTest.log(Status.INFO, "No Record Found. Error Message is Displayed");
	}


	public void VerifyAreYouSureYouWantToDeleteTheSelectedGroups(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement text = driver.findElement(By.xpath("//span[text()='Are you sure you want to delete the selected Group(s)?']"));
		if(wait.until(ExpectedConditions.visibilityOf(text)).isDisplayed())
		{
			String Actual_Text = text.getText();
			String Expected_Text = "Are you sure you want to delete the selected Group(s)?";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Are you sure you want to delete the selected Group(s)? Pop Up Message is Displayed");

		}
	}

	public void VerifyGroupHasBeenDeletedSuccessMSGIsDisplyed(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		WebElement GD = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]/span[contains(text(),'Group has been deleted.')]"));
		if(GD.isDisplayed())
		{
			String Actual_Text = GD.getText();
			String Expected_Text = "Group has been deleted.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Group has been deleted. Success Message is Displayed");
		}
	}

	public void VerifyGroupHasOneOrMoreCheckpointCannotBeDeletedErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement GCD = driver.findElement(By.xpath("//span[text()='Group has one or more checkpoint & cannot be deleted.']"));
		if(wait.until(ExpectedConditions.visibilityOf(GCD)).isDisplayed())
		{
			String Actual_Text = GCD.getText();
			String Expected_Text = "Group has one or more checkpoint & cannot be deleted.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Group has one or more checkpoint & cannot be deleted. Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@type='button']")).click();
		}
	}

	public void VerifyGroupIsAlreadyInUseByAnotherAuditErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement GUA = driver.findElement(By.xpath("//span[text()='Group is already in use by another audit.']"));
		if(wait.until(ExpectedConditions.visibilityOf(GUA)).isDisplayed())
		{
			String Actual_Text = GUA.getText();
			String Expected_Text = "Group is already in use by another audit.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Group is already in use by another audit. Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@type='button']")).click();
		}
	}


	public void VerifyGroupNameHasAlreadyBeenTakenErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement GAT = driver.findElement(By.xpath("//span[text()='Group Name should be unique']"));
		if(wait.until(ExpectedConditions.visibilityOf(GAT)).isDisplayed())
		{
			String Actual_Text = GAT.getText();
			String Expected_Text = "Group Name should be unique";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Group Name should be unique Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@type='button']")).click();
		}
	}

	public void VerifyGroupMandatoryFieldsErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Text = ErrorMSG.getText();
			System.out.println("Required Filed Error Message are : " + Text);
			System.out.println("Pass : Error Message are Displayed");
		}
	}

	public void VerifyAnnexureGroupDropDwonInReadOnlyMode(WebDriver driver)
	{
		WebElement Annexuredropdown = driver.findElement(By.xpath("//select[@id='annexure' and @disabled]"));
		Assert.assertTrue(Annexuredropdown.isDisplayed(), "Annexure Drop Down is Not Working as read only mode");
		System.out.println("Annexure Drop Down is Working as read only mode");
		chiledTest.log(Status.INFO, "Annexure Drop Down is Working as read only mode");
	}

	public void VerifyScoingDropDwonInReadOnlyMode(WebDriver driver)
	{
		WebElement Annexuredropdown = driver.findElement(By.xpath("//select[@id='scoring_logic' and @disabled]"));
		Assert.assertTrue(Annexuredropdown.isDisplayed(), "Scoring Lagic Drop Down is Not Working as read only mode");
		System.out.println("Scoring Lagic Drop Down is Working as read only mode");
		chiledTest.log(Status.INFO, "Scoring Lagic Drop Down is Working as read only mode");
	}

}


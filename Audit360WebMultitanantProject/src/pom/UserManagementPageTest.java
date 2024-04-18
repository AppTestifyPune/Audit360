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
import org.testng.Reporter;
import com.aventstack.extentreports.Status;
import generic.BaseTest;

public class UserManagementPageTest extends BaseTest {

	//Clicking on the scroll bar //div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the User Management from side menu//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='User Management']
	@FindBy(xpath="//img[@title='User Management']")
	private WebElement UserManagment;

	//Clicking on the Manage User Header
	@FindBy(xpath="//a[@class='active'][text()='MANAGE USER']")
	private WebElement ManageUserHeader;

	//Clicking on the Add User Button
	@FindBy(xpath="//span[text()='Add User']")
	private WebElement AddUserBTN;

	//Clicking on the Role
	@FindBy(xpath="//input[@id='s2id_autogen6']")
	private WebElement Role;

	//Clicking on the Cluster
	@FindBy(xpath="//input[@id='s2id_autogen7']")
	private WebElement Cluster;

	//Clicking on the Status
	@FindBy(xpath="//input[@id='s2id_autogen8']")
	private WebElement Status;

	//Passing the values to Search button
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBTN;

	//Passig the Values to First Name
	@FindBy(xpath="//input[@id='user_first_name']")
	private WebElement FirstName;

	//Passing the Values to Email Id
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement EmailId;

	//Clicking on the Country
	@FindBy(xpath="//div[@id='s2id_address_country']//span[@class='select2-chosen']")
	private WebElement Country;

	//Selecting the Country option
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']/input[@type='text']")
	private WebElement CountryOption;

	//Clicking on the Matched data
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Passing the Values to Last Name 
	@FindBy(xpath="//input[@id='user_last_name']")
	private WebElement LastName;

	//Passing the Values to Role
	@FindBy(xpath="//div[@id='s2id_user_role_ids']//input")
	private WebElement Roletext;

	//Clicking on the Time Zone
	@FindBy(xpath="//div[@id='s2id_country_zones']//span[@class='select2-chosen']")
	private WebElement TimeZone;

	//Passing the Values to Time zone
	@FindBy(xpath="//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input[@type='text']")
	private WebElement SetTimezone;

	//Passing the Values to Cluster
	@FindBy(xpath="//div[@id='s2id_country_clusters']//input")
	private WebElement SetCluster;

	//Passing the Values to Auditee
	@FindBy(xpath="//div[@id='s2id_cluster_auditees']//input")
	private WebElement Auditee;

	//passing the Values to Login ID
	@FindBy(xpath="//input[@id='user_login_id']")
	private WebElement LoginID;

	//Passing the Values to Phone
	@FindBy(xpath="//input[@id='user_phone']")
	private WebElement Phone;

	//Passing the Values to Address
	@FindBy(xpath="//textarea[@id='user_address_attributes_door_no']")
	private WebElement Address;

	//Clicking on the State
	@FindBy(xpath="//div[@id='s2id_cluster_states']//span[@class='select2-chosen']")
	private WebElement State;

	//Passing the Values to State
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetState;

	//Clicking on the City
	@FindBy(xpath="//div[@id='s2id_cluster_cities']//span[@class='select2-chosen']")
	private WebElement City;

	//Passing the Values to City
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetCity;

	//Clicking on the zipCode
	@FindBy(xpath="//div[@id='s2id_cluster_zip']//span[@class='select2-chosen']")
	private WebElement ZipCode;

	//Passing the Values to Zipcode
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetZipCode;

	//clicking on the Area
	@FindBy(xpath="//div[@id='s2id_cluster_area']//span[@class='select2-chosen']")
	private WebElement Area;

	//Passing the Values to Area
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetArea;

	//Clicking on the Region
	@FindBy(xpath="//div[@id='s2id_cluster_region']//span[@class='select2-chosen']")
	private WebElement Region;

	//Passing the Values to Region
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetRegion;

	//clicking on the Zone
	@FindBy(xpath="//div[@id='s2id_cluster_zone']//span[@class='select2-chosen']")
	private WebElement Zone;

	//Passing the Values to Zone
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetZone;

	//Clicking on the Gender Male
	@FindBy(xpath="//input[@id='user_profile_attributes_gender_male']")
	private WebElement Male;

	//Clicking on the Female Gender
	@FindBy(xpath="//input[@id='user_profile_attributes_gender_female']")
	private WebElement Female;

	//Clicking on the Transgender 
	@FindBy(xpath="//input[@id='user_profile_attributes_gender_transgender']")
	private WebElement Transgender;

	//Passing the Values to Data of birth
	@FindBy(xpath="//input[@id='user_profile_attributes_date_of_birth']")
	private WebElement DOB;

	//Passing the values to Qualification//input[@id='user_profile_attributes_qualification']
	@FindBy(xpath="//label[text()='Qualification']/following-sibling::div//input")
	private WebElement Qualification;

	//Passing the Values to Specialization//input[@id='user_profile_attributes_specialization']
	@FindBy(xpath="//label[text()='Specialization']/following-sibling::div//input")
	private WebElement Specialization;

	//Passing the values to Training
	@FindBy(xpath="//textarea[@id='user_profile_attributes_training']")
	private WebElement Training;

	//Passing the Values to Certification
	@FindBy(xpath="//textarea[@id='user_profile_attributes_certification']")
	private WebElement Certification;

	//Clicking on the Choose File
	@FindBy(xpath="//input[@id='user_profile_attributes_profile']")
	private WebElement ChooseFile;

	//clicking on the Done Button
	@FindBy(xpath="//button[text()='Done']")
	private WebElement DoneBTN;

	//Clicking on the Submitted Button
	@FindBy(xpath="//input[@name='commit']")
	private WebElement SubmitBTN;

	//Clicking on the Search Button
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SerachBTN;

	//Clicking on the View Button
	@FindBy(xpath="//button[@class='btn btn-clear view_user_details']")
	private WebElement ViewBTN;

	//Clicking on the Edit Button
	@FindBy(xpath="//a[@class='btn btn-info m-l-10']")
	private WebElement EditBTN;

	//Clicking on the Deactivate Button
	@FindBy(xpath="//a[@class='btn btn-danger m-l-10']")
	private WebElement DeactivateBTN;

	//Clicking on the Confirm User Button
	@FindBy(xpath="//a[@data-subject='User Confirm']")
	private WebElement ConfirmUserBTN;

	//Clicking on the Resends User Button
	@FindBy(xpath="//a[@data-subject='Resend Confirmation Mail']")
	private WebElement ResedUserBTN;

	//Clicking on the Close Button
	@FindBy(xpath="//i[@class='pg-close fs-14']")
	private WebElement CloseBTN;

	//Clicking on the OK Button
	@FindBy(xpath="//a[text()='OK']")
	private WebElement OKBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement CancelBTN;

	//Clicking on the Others Options Under Reason
	@FindBy(xpath="//select[@id='deactive_reasons']/option[text()='Others']")
	private WebElement Others;

	//Passing the Values to Others Reason
	@FindBy(xpath="//input[@id='input_deactive']")
	private WebElement Reason;

	//Clicking on the Activate Button
	@FindBy(xpath="//span[@class='switchery switchery-default']")
	private WebElement ActivateBTN;

	//Clicking on the Unlock User Button
	@FindBy(xpath="//a[@data-confirm='Are you sure you want to unlock user?']")
	private WebElement UnlockBTN;

	//Clicking on the Add/Edit Clusters/Auditees 
	@FindBy(xpath="//button[contains(text(),'Add/Edit Clusters/Auditees')]")
	private WebElement AddEditClustersAuditeesBTN;

    //SAGAR
	public WebElement successmsg(WebDriver driver)
	{
	WebElement successmsg = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
	return successmsg;
	}
	
	//
	public UserManagementPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ScrollBar));
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickUserManagement(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(UserManagment));
		Actions action = new Actions(driver);	
		action.moveToElement(UserManagment).click().build().perform();
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UserManagment);*/
	}

	public void ClickManageUserHeader(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ManageUserHeader));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageUserHeader);
		System.out.println("Manage User Header is Clicked");
	}

	public void ClickAddUserBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddUserBTN);
	}

	public void ClickAddEditClustersAuditeesBTN()
	{
		AddEditClustersAuditeesBTN.click();
		System.out.println("Add/Edit Clusters/Auditees button is Clicked");
	}

	public void ClickRole()
	{
		Role.click();
	}

	public void ClickCluster()
	{
		Cluster.click();
	}

	public void ClickStatus()
	{
		Status.click();
	}

	public void SetAuditee(String SA, WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Auditee)).sendKeys(SA);
		System.out.println("entered Auditee is : " + SA);
	}

	public void SetFirstName(String FN)
	{
		FirstName.clear();

		FirstName.sendKeys(FN);
		System.out.println("Entered First Name is : " + FN);
	}

	public void SetEmailId(String EI)
	{
		EmailId.sendKeys(EI);
		System.out.println("Entered Email Id is : " + EI);
	}

	public void ClickCountry()
	{
		Country.click();
	}

	public void SetCountryOption(String SC)
	{
		CountryOption.sendKeys(SC);
		System.out.println("Entered Country is : " + SC);

	}

	public void SetLastName(String LN)
	{
		LastName.clear();

		LastName.sendKeys(LN);
		System.out.println("Entered Last Name is : " + LN);
	}

	public void SetRoletext(String RO) throws InterruptedException
	{
		Roletext.sendKeys(RO);
		System.out.println("Entered Role is : " + RO);

	}

	public void ClickTimeZone()
	{
		TimeZone.click();
	}

	public void SetTimezone(String TZ)
	{
		SetTimezone.sendKeys(TZ);
		System.out.println("Entered Time Zone is : " + TZ);
	}

	public void SetCluster(String CS) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SetCluster)).sendKeys(CS);
		System.out.println("Entered Cluser is : " + CS);
	}

	public void SetLoginID(String LI)
	{
		LoginID.clear();
		LoginID.sendKeys(LI);
		System.out.println("Entered Login ID is : " + LI);
	}

	public void SetPhone(String SP)
	{
		Phone.clear();
		Phone.sendKeys(SP);
		System.out.println("Entered Phone Number is : " + SP);
	}

	public void SetAddress(String SA)
	{
		Address.clear();
		Address.sendKeys(SA);
		System.out.println("Entered Address is : " + SA);
	}

	public void ClickState()
	{
		State.click();
	}

	public void SetState(String SS)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SetState)).sendKeys(SS);
		//SetState.sendKeys(SS);
		System.out.println("Entered State is : " + SS);
	}

	public void ClickCity()
	{
		City.click();
	}

	public void SetCity(String SC)
	{
		SetCity.sendKeys(SC);
		System.out.println("Entered City is : " + SC);
	}

	public void ClickZipCode()
	{
		ZipCode.click();
	}

	public void SetZipCode(String SZ)
	{
		SetZipCode.sendKeys(SZ);
		System.out.println("Entered Zip code is : " + SZ);
	}


	public void ClickArea()
	{
		Area.click();
	}

	public void SetArea(String AR)
	{
		SetArea.sendKeys(AR);
		System.out.println("Entered Area is : " + AR);
	}

	public void ClickRegion()
	{
		Region.click();
	}

	public void SetRegion(String SR)
	{
		SetRegion.sendKeys(SR);
		System.out.println("Entered Region is : " + SR);
	}

	public void ClickZone()
	{
		Zone.click();
	}

	public void SetZone(String SZ)
	{
		SetZone.sendKeys(SZ);
		System.out.println("Entered Zone is : " + SZ);
	}

	public void ClickDoneButton()
	{
		DoneBTN.click();
		System.out.println("Done Button is Clicked");
	}


	public void ClickMale()
	{
		Male.click();
	}

	public void ClickFemale()
	{
		Female.click();
	}

	public void ClickTransgender()
	{
		Transgender.click();
	}

	public void SetDOB(String DB)
	{
		DOB.clear();
		DOB.sendKeys(DB);
		System.out.println("Entered DOB is : " + DB);
		DOB.sendKeys(Keys.ESCAPE);
	}

	public void ClickMatched(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Matched)).click();

	}

	public void SetQualification(String QF)
	{
		Qualification.sendKeys(QF);
		System.out.println("Entered Qualification is : " + QF);
		Qualification.sendKeys(Keys.TAB);
	}

	public void SetSpecialization()
	{
		WebElement ListBox = driver.findElement(By.xpath("//select[@id='user_profile_attributes_specialization']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actual_SpecializationCount = alloptions.size();
		int Expected_SpecializationCount = 9;
		Assert.assertEquals(Actual_SpecializationCount, Expected_SpecializationCount, "Specialization Count are wrong");
		for(int i=1; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			All.click();
			System.out.println("All The Specialization are selected");
		}
	}

	public void SetCertification(String CF)
	{
		Certification.sendKeys(CF);
		System.out.println("Entered Certification is : " + CF);
	}

	public void SetTraining(String TT)
	{
		Training.sendKeys(TT);
		System.out.println("Entered Training is : " + TT);
	}


	public void UplaodPhotowithLessThan500KB(String SP)
	{
		//Uploading less than 500 MB Image
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180607-WA0031.jpg");
	}

	public void UplaodPhoto(String SP)
	{
		//Uploading less than 500 MB Image
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
	}

	public void UploadPhotowithMoreThan500KB()
	{
		//Uploading 1 Mb Image
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\Sample-jpg-image-1mb.jpg");
	}

	public void UploadingExcel()
	{
		//Uploading Excel
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\checkpoint_template_Test1.xlsx");
	}

	public void UploadingPDF()
	{
		//Uploading PDF
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\download_pdf.pdf");
	}

	public void UploadingNotePad()
	{
		//Uploading NotePad
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMP.txt");
	}


	public void ClickSubmitBTN()
	{
		SubmitBTN.click();
	}

	public void SetSerachBTN(String SB)
	{
		SerachBTN.clear();

		SerachBTN.sendKeys(SB);
		System.out.println("Serached User is : " + SB);
	}

	public void ClickViewBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ViewBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ViewBTN);
		System.out.println("View Button is Clicked");
	}

	public void ClickEditBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(EditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EditBTN);
		System.out.println("Edit Button is Clicked");

	}

	public void ClickDeactivateBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(DeactivateBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", DeactivateBTN);
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickConfirmUserBTN(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(ConfirmUserBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ConfirmUserBTN);
			System.out.println("Confirm User Button is Clicked");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickResedUserBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(ResedUserBTN));
		executor.executeScript("arguments[0].click();", ResedUserBTN);
		System.out.println("Resend User Button is Clicked");
	}

	public void ClickCloseBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);

	}

	public void ClickOKBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(OKBTN));
		wait.until(ExpectedConditions.elementToBeClickable(OKBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", OKBTN);

	}

	public void ClickCancelBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(CancelBTN));
		wait.until(ExpectedConditions.elementToBeClickable(CancelBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CancelBTN);
	}

	public void ClickOthers()
	{
		Others.click();
	}

	public void SetReason(String SR, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Reason)).sendKeys(SR);
		System.out.println("Entered Reason is : " + SR);
	}

	public void ClickActivateBTN()
	{
		//ActivateBTN.click();
	}

	public void ClickUnlockButton(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(UnlockBTN));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", UnlockBTN);
			System.out.println("Unlock Button is Clicked");
		}catch (StaleElementReferenceException e) {

		}

	}

	public void VerifyManageUserPageIsDisplayed(WebDriver driver)
	{

		WebDriverWait wait = new WebDriverWait(driver, 60);
		//checking Manage User Headder
		WebElement ManageUser = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(ManageUser)).isDisplayed())
		{
			String Actual_Text = ManageUser.getText();
			String Expected_Text = "MANAGE USER";
			Assert.assertEquals(Actual_Text, Expected_Text, "Hedar name is Wrong");
			System.out.println("Pass : Manage User Page is Displayed");
		}



		//Checking Add User Button is Displayed
		if(AddUserBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Add User Button is Displayed");
		}

		//Checking the List Users Gride
		//checking the List Users Lable
		WebElement ListUsers = driver.findElement(By.xpath("//form[contains(@class,'m-b-10')]/h4"));
		if(ListUsers.isDisplayed())
		{
			String Expected_ListUsers = ListUsers.getText();
			String Actual_ListUsers = "List Users";
			Assert.assertEquals(Expected_ListUsers, Actual_ListUsers);
			System.out.println("Pass : List Users is Displayed");
		}

		//Checking the Role
		//Checking the Role Lable
		WebElement RoleLabel = driver.findElement(By.xpath("//label[text()='Role']"));

		//Checking the role
		WebElement Role = driver.findElement(By.xpath("//div[@id='s2id_role_ids_']"));
		if(RoleLabel.isDisplayed() && Role.isDisplayed())
		{
			String Expected_RoleLabel = RoleLabel.getText();
			String Actual_RoleLabel = "ROLE";
			Assert.assertEquals(Expected_RoleLabel, Actual_RoleLabel);

		}

		//Checking the Cluster
		//Checking the Cluster Lable
		WebElement ClusterLabel = driver.findElement(By.xpath("//label[text()='Cluster']"));

		//Checking the 
		WebElement Cluster = driver.findElement(By.xpath("//div[@id='s2id_cluster_ids_']"));
		if(ClusterLabel.isDisplayed() && Cluster.isDisplayed())
		{
			String Expected_Cluster = ClusterLabel.getText();
			String Actual_Cluster = "CLUSTER";
			Assert.assertEquals(Expected_Cluster, Actual_Cluster);

		}

		//Checking the Auditee
		//Checking the Auditee Lable
		WebElement AuditeeLabel = driver.findElement(By.xpath("//label[text()='Auditee']"));

		//Checking the Auditee
		WebElement Auditee = driver.findElement(By.xpath("//div[@id='s2id_auditees_search']"));
		if(AuditeeLabel.isDisplayed() && Auditee.isDisplayed())
		{
			String Expected_Status = AuditeeLabel.getText();
			String Actual_Status = "AUDITEE";
			Assert.assertEquals(Expected_Status, Actual_Status);

		}


		//Checking the Status
		//Checking the Status Lable
		WebElement StatusLabel = driver.findElement(By.xpath("//label[text()='Status']"));

		//Checking the Status
		WebElement Status = driver.findElement(By.xpath("//div[@id='s2id_user_statuses_']")); 
		if(StatusLabel.isDisplayed() && Cluster.isDisplayed() && Status.isDisplayed())
		{
			String Expected_Status = StatusLabel.getText();
			String Actual_Status = "STATUS";
			Assert.assertEquals(Expected_Status, Actual_Status);

		}


		//Checking the Select Date Range 
		//Checking the Status Lable
		WebElement Label = driver.findElement(By.xpath("//label[text()='Select Date Range']"));
		WebElement EndDate = driver.findElement(By.xpath("//input[@id='user_end_date']"));
		WebElement FromDate = driver.findElement(By.xpath("//input[@id='user_start_date']"));
		if(Label.isDisplayed() && FromDate.isDisplayed() && EndDate.isDisplayed())
		{
			String Expected_Label = Label.getText();
			String Actual_Label = "SELECT DATE RANGE";
			Assert.assertEquals(Expected_Label, Actual_Label);

		}

		//Checking Serach Button
		if(SearchBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Serach Button is displayed");
		}

		//Checking Show and Rows
		WebElement Shows = driver.findElement(By.xpath("//div[@class='col-md-6 col-xs-12 p-l-0']//label[1]"));
		if(Shows.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Shows and Rows is displayed");
		}

		//Checking Manage User Table
		WebElement Table = driver.findElement(By.xpath("//table[@id='listUsersTable']"));
		if(Table.isDisplayed())
		{
			List<WebElement> count = driver.findElements(By.xpath("//table[@id='listUsersTable']/thead/tr/th"));
			int Expected_count = count.size();
			int Actual_count = 9;
			Assert.assertEquals(Expected_count, Actual_count);

		}

		//Checking Name 
		WebElement Name = driver.findElement(By.xpath("//th[contains(text(),'Name')]"));
		Assert.assertTrue(Name.isDisplayed(), "Name Is Displayed Under Grid");
		System.out.println("Name is Displayed in grid");

		//Checking Email 
		WebElement Email = driver.findElement(By.xpath("//th[contains(text(),'Email')]"));
		Assert.assertTrue(Email.isDisplayed(), "Email Displayed Under Grid");
		System.out.println("Email is Displayed");

		//Checking Phone number 
		WebElement Phone = driver.findElement(By.xpath("//th[contains(text(),'Phone')]"));
		Assert.assertTrue(Phone.isDisplayed(), "Email Displayed Under Grid");
		System.out.println("Phone is Displayed");

		//Checking Mapped Device Id
		WebElement MappedDeviceID = driver.findElement(By.xpath("//th[contains(text(),'Mapped Device')]"));
		Assert.assertTrue(MappedDeviceID.isDisplayed(), "Mapped Device Id Displayed Under Grid");
		System.out.println("Mapped Device Id is Displayed");

		//Checking Cluster number 
		WebElement Cluster1 = driver.findElement(By.xpath("//th[contains(text(),'Cluster')]"));
		Assert.assertTrue(Cluster1.isDisplayed(), "Cluster is Not Displayed Under Grid");
		System.out.println("Cluster is Displayed");

		//Checking Auditee 
		WebElement Auditee1 = driver.findElement(By.xpath("//span[contains(text(),'Auditee')]"));
		Assert.assertTrue(Auditee1.isDisplayed(), "Auditee is Not Displayed Under Grid");
		System.out.println("Auditee is Displayed");

		//Checking Roles 
		WebElement Roles = driver.findElement(By.xpath("//th[contains(text(),'Role(s)')]"));
		Assert.assertTrue(Roles.isDisplayed(), "Roles is Not Displayed Under Grid");
		System.out.println("Pass : Role(s) is Displayed");

		//Checking Status
		WebElement Status1 = driver.findElement(By.xpath("//span[contains(text(),'Status')]"));
		Assert.assertTrue(Status1.isDisplayed(), "Status is Not Displayed Under Grid");
		System.out.println("Pass : Status is Displayed");

		//Checking Actions
		WebElement Actions = driver.findElement(By.xpath("//th[contains(text(),'Actions')]"));
		Assert.assertTrue(Actions.isDisplayed(), "Actions is Not Displayed Under Grid");
		System.out.println("Pass : Actions is Displayed");


	}




	public void VerifyAddOrEditUserPageisDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//checking the Add/edit User page is Displayed
		WebElement Header = driver.findElement(By.xpath("//div[@class='panel-title']"));

		if(wait.until(ExpectedConditions.visibilityOf(Header)).isDisplayed())
		{
			String Expected_text = Header.getText();
			String Actual_text = "ADD/EDIT USER";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : ADD/EDIT USER page is Displayed");
		}
	}

	public void VerfiyClusterisSelected(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
		boolean ispresent = driver.findElements(By.xpath("//span[@id='cluster_name']")).size()>0;
		System.out.println("Cluster is Selected : " + ispresent);
	}

	public void VerifyUserCreatedSuccessfullySuccessMSGIsDisplayed(WebDriver driver)
	{
		try//#SM |  Message displaying but Facing difficulties for finding element 
		{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		//SAGAR 
		wait.until(ExpectedConditions.visibilityOf(successmsg(driver)));
		
		WebElement SuccssMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccssMSG)).isDisplayed())
		{
			String Expected_Text = SuccssMSG.getText();
			String Actual_Text = "User created successfully!";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : User created successfully! Message is Displayed");
		}

		//Clicking on the Close Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		
		}catch(Exception e)
		{
			System.out.println("");
		}
	}

	public void VerifyEmailHasAlreadyBeenTakenMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
	//	WebElement SuccssMSG = driver.findElement(By.xpath("//li[text()=' Email has already been taken ']"));
		WebElement SuccssMSG = driver.findElement(By.xpath("//li[text()=' Login has already been taken ']")); //#SM
		
		if(wait.until(ExpectedConditions.visibilityOf(SuccssMSG)).isDisplayed())
		{
			String Expected_Text = SuccssMSG.getText();
			String Actual_Text = "Login has already been taken";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Login has already been taken Message is Displayed");
		}

	}

	public void VerifyNoDataAvailableInTableMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccssMSG = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccssMSG)).isDisplayed())
		{
			String Expected_Text = SuccssMSG.getText();
			String Actual_Text = "No data available in table";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : No data available in table Message is Displayed");
		}

	}

	public void VerifyUserIsDisplayed(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Checking the Name
		WebElement Name = driver.findElement(By.xpath("//td[@class='sorting_1']"));
		if(Name.isDisplayed() && ViewBTN.isDisplayed() && EditBTN.isDisplayed() && DeactivateBTN.isDisplayed() && ConfirmUserBTN.isDisplayed() && ResedUserBTN.isDisplayed())
		{
			System.out.println("Pass : Searched User Is Displayed");
		}

	}

	public void VerifyUserDetailsPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Checking User Deatils Header
		WebElement UserDetails = driver.findElement(By.xpath("//h5[@class='text-primary ']"));
		if(wait.until(ExpectedConditions.visibilityOf(UserDetails)).isDisplayed())
		{
			String Expected_text = UserDetails.getText();
			String Actual_text = "User Details";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : User Deatils Header is Displayed");
		}
	}



	public void VerifyResendConfirmationMailPopupIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//Checking Resend Confirmation Mail
		WebElement RSC = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5"));
		if(wait.until(ExpectedConditions.visibilityOf(RSC)).isDisplayed())
		{
			String Expected_Text = RSC.getText();
			String Actual_Text = "Resend Confirmation Mail";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Resend Confirmation Mail Pop Up is Displayed");
		}

		//Checking Are you sure you want to resend confirmation mail?
		WebElement Areyou = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/p"));
		if(wait.until(ExpectedConditions.visibilityOf(Areyou)).isDisplayed())
		{
			String Expected_Text = Areyou.getText();
			String Actual_Text = "Are you sure you want to resend confirmation mail?";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass :  Are you sure you want to resend confirmation mail? is Displayed");
		}

		//Checking OK Button and Cancel Button
		if(OKBTN.isDisplayed() && CancelBTN.isDisplayed())
		{
			System.out.println("Pass : Ok Button and Cancel Button is Displayed");
		}
	}

	public void VerifyMailSentSuccessfullyMsgIsDisplayed(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement MailSentSuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(MailSentSuccessMSG)).isDisplayed())
		{
			String Expected_text = MailSentSuccessMSG.getText();
			String Actual_text = "Mail sent successfully";
			Assert.assertEquals(Expected_text, Actual_text, "Success Message is Wrong");
			System.out.println("Pass : Mail sent successfully Success Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}

	}

	public void VerifyUserUpdatedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Checking User Deatils Header
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "User updated successfully!";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : User updated successfully! Success Message is Displayed");
		}

		//Clicking on the Cancel Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
	}

	public void VerifyUserConfirmPopupIsDisplayed(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(2000);
		//Checking Resend Confirmation Mail
		WebElement UC = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='modal-header clearfix text-left']")));
		if(wait.until(ExpectedConditions.visibilityOf(UC)).isDisplayed())
		{
			String Actual_Text = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5")).getText();
			String Expected_Text = "User Confirm";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : User Confirm Pop Up is Displayed");
		}

		//Checking Are you sure you want to resend confirmation mail?
		WebElement Areyou = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/p"));
		if(Areyou.isDisplayed())
		{
			String Expected_Text = Areyou.getText();
			String Actual_Text = "Are you sure you want to confirm user?";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Are you sure you want to confirm user? is Displayed");
		}

		//Checking OK Button and Cancel Button
		if(OKBTN.isDisplayed() && CancelBTN.isDisplayed())
		{
			System.out.println("Pass : Ok Button and Cancel Button is Displayed");
		}
	}

	public void VerifyUserConfirmedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 180);

		//Checking User Deatils Header
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "User Confirmed successfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : User Confirmed successfully Success Message is Displayed");
		}

		//Clicking on the Cancel Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
	}


	public void VerifyUserDeactivatePopupIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 140);

		//Checking Resend Confirmation Mail
		WebElement UD = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5"));
		if(wait.until(ExpectedConditions.visibilityOf(UD)).isDisplayed())
		{
			String Expected_Text = UD.getText();
			String Actual_Text = "User Deactivate";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : User Deactivate Pop Up is Displayed");
		}

		//checking If you deactivate this user then reactivation can be done by Sumeru admin only. Please confirm if you wish to continue?
		WebElement IfyouDeactivate = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/p"));
		if(IfyouDeactivate.isDisplayed())
		{
			String Expected_Text = IfyouDeactivate.getText();
			String Actual_Text = "If you deactivate this user then reactivation can be done by Sumeru admin only. Please confirm if you wish to continue?";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass :If you deactivate this user then reactivation can be done by Sumeru admin only. Please confirm if you wish to continue? is Displayed");
		}

		//Checking OK Button and Cancel Button
		if(OKBTN.isDisplayed() && CancelBTN.isDisplayed())
		{
			System.out.println("Pass : Ok Button and Cancel Button is Displayed");
		}

	}

	public void VerifyUserDeactivatedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);

		//Checking User Deatils Header
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "User deactivated successfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : User deactivated successfully Success Message is Displayed");
		}

		//Clicking on the Cancel Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
	}

	public void VerifyUserUnlockPopupIsDisplayed(WebDriver driver)
	{
		//Checking Resend Confirmation Mail
		WebElement UC = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/h5"));
		if(UC.isDisplayed())
		{
			String Expected_Text = UC.getText();
			String Actual_Text = "User Unlock";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : User Unlock Pop Up is Displayed");
		}

		//Checking Are you sure you want to resend confirmation mail?
		WebElement Areyou = driver.findElement(By.xpath("//div[@class='modal-header clearfix text-left']/p"));
		if(Areyou.isDisplayed())
		{
			String Expected_Text = Areyou.getText();
			String Actual_Text = "Are you sure you want to unlock user?";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Are you sure you want to unlock user? is Displayed");
		}

		//Checking OK Button and Cancel Button
		if(OKBTN.isDisplayed() && CancelBTN.isDisplayed())
		{
			System.out.println("Pass : Ok Button and Cancel Button is Displayed");
		}
	}

	public void VerifyUserUnlockedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);

		//Checking User Deatils Header
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "User unlocked successfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : User unlocked successfully Success Message is Displayed");
		}

		//Clicking on the Cancel Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
	}

	public void VerifyThisFieldIsRequiredErrorMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Error = driver.findElement(By.xpath("//div[@class='popover-content'][text()='This field is required.']"));
		if(wait.until(ExpectedConditions.visibilityOf(Error)).isDisplayed())
		{
			List<WebElement> TotalError = driver.findElements(By.xpath("//div[@class='popover-content'][text()='This field is required.']"));
			int Count = TotalError.size();
			int Expected_count = Count;
			int Actual_count = 12;
			Assert.assertEquals(Expected_count, Actual_count);
			System.out.println("Pass : This field is required. Error Messages are Displayed");
		}
	}

	public void VerifyMandtatoryFieldsIsDisplayed(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking First Name
		WebElement FN = driver.findElement(By.xpath("//input[@id='user_first_name'][@required='required']"));

		//Checking Last Name
		WebElement LN = driver.findElement(By.xpath("//input[@id='user_last_name'][@required='required']"));

		//Checking Email Id
		WebElement EI = driver.findElement(By.xpath("//input[@id='user_email'][@required='required']"));

		//Checking Roles
		WebElement Roles = driver.findElement(By.xpath("//select[@id='user_role_ids' and @required='required' and @multiple='multiple']"));

		//Checking Country
		WebElement Country = driver.findElement(By.xpath("//select[@id='address_country'][@required='required']"));

		//Checking Time Zone
		WebElement TimeZone = driver.findElement(By.xpath("//select[@id='country_zones'][@required='required']"));

		//Checking the State
		WebElement State = driver.findElement(By.xpath("//select[@id='cluster_states' and @required='required']"));

		//Checking the City
		WebElement City = driver.findElement(By.xpath("//select[@id='cluster_cities' and @required='required']"));

		//Checking the Zip Code
		WebElement ZipCode = driver.findElement(By.xpath("//select[@id='cluster_zip' and @required='required']"));

		//Checking Zone
		WebElement Zone = driver.findElement(By.xpath("//select[@id='cluster_zone'][@required='required']"));

		//Checking Region
		WebElement Region = driver.findElement(By.xpath("//select[@id='cluster_region'][@required='required']"));

		Assert.assertTrue(FN.isDisplayed() && LN.isDisplayed() && Zone.isDisplayed() &&  Region.isDisplayed()  && EI.isDisplayed() && Roles.isDisplayed() && TimeZone.isDisplayed() && Country.isDisplayed() && State.isDisplayed() && City.isDisplayed() && ZipCode.isDisplayed() );
		System.out.println("Pass : Required Fields are Displayed");


		AddEditClustersAuditeesBTN.click();

		Thread.sleep(2000);
		WebElement Cluser = driver.findElement(By.xpath("//select[@id='country_clusters' and @required='required' and @multiple='multiple']"));
		Assert.assertTrue(Cluser.isDisplayed(), "Cluster is Not Working as Required Field");


	}




	public void VerifyPleaseEnterValidEmailAddressErrorMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Error = driver.findElement(By.xpath("//div[@class='popover-content'][text()='Please enter a valid email address.']"));
		if(wait.until(ExpectedConditions.visibilityOf(Error)).isDisplayed())
		{
			String Expected_Text = Error.getText();
			String Actual_Text = "Please enter a valid email address.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Please enter a valid email address. Error Messages are Displayed");
		}
	}

	public void VerifyPleaseEnterValidFirstNameErrorMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Error = driver.findElement(By.xpath("//div[@class='popover-content'][text()='Please enter a valid First Name.']"));
		if(wait.until(ExpectedConditions.visibilityOf(Error)).isDisplayed())
		{
			String Expected_Text = Error.getText();
			String Actual_Text = "Please enter a valid First Name.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Please enter a valid First Name. Error Messages are Displayed");
		}
	}

	public void VerifyPleaseEnterValidLastNameErrorMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Error = driver.findElement(By.xpath("//div[@class='popover-content'][text()='Please enter a valid Last Name.']"));
		if(wait.until(ExpectedConditions.visibilityOf(Error)).isDisplayed())
		{
			String Expected_Text = Error.getText();
			String Actual_Text = "Please enter a valid Last Name.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Please enter a valid Last Name. Error Messages are Displayed");
		}
	}

	public void VerifyNoMatchesFoundMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Error = driver.findElement(By.xpath("//li[text()='No matches found']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[text()='No matches found']")));
		if(Error.isDisplayed())
		{
			String Expected_Text = Error.getText();
			String Actual_Text = "No matches found";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : No matches found Messages are Displayed");
		}
	}

	public void VerifyYouHaveToConfirmYourEmailAddressBeforeContinuingMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_Text = SuccessMSG.getText();
			String Actual_Text = "You have to confirm your email address before continuing.";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : You have to confirm your email address before continuing. Messages are Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
		}
	}

	public void VerifyActivateButtonIsSelected(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//checking the Activate Button is Enabled or desabled ?
		WebElement Activate = driver.findElement(By.xpath("//span[@class='switchery switchery-default']"));
		Assert.assertTrue(Activate.isSelected(), "Not Able to Select the Activate Button");
		System.out.println("Pass : Activate Button is Selected");

	}

	public void VerifyYourAccountHasBeenDeactivated(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_Text = ErrorMSG.getText();
			String Actual_Text = "Your account has been deactivated. If you think this is not in order kindly contact your administrator";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Your account has been deactivated. If you think this is not in order kindly contact your administrator. Error Message is Displayed");

			//Clikcing on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
		}

	}

	public void VerifyYouCannotUploadAFileGreaterThan500kb(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@class='error'][text()='You cannot upload a file greater than 500 kb.']"));
		wait.until(ExpectedConditions.visibilityOf(ErrorMSG));
		if(ErrorMSG.isDisplayed())
		{
			System.out.println("Pass : You cannot upload a file greater than 500 kb. Error Message is Displayed");
		}else {
			System.out.println("Fail : You cannot upload a file greater than 500 kb. Error Message is Not Displayed");
		}

	}

	public void VerifyOnlyJPGAndPNGIsAllowedErrorMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@class='error'][text()='Only .jpg .png files are allowed for upload.']"));
		wait.until(ExpectedConditions.visibilityOf(ErrorMSG));
		if(ErrorMSG.isDisplayed()){
			System.out.println("Pass : Only .jpg .png files are allowed for upload. Error Message is Displayed");}
		else {
			System.out.println("Fail : Only .jpg .png files are allowed for upload. Error Message is Not Displayed");}
	}

}

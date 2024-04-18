package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;

public class SuperAdminProfilePageTest extends BaseTest {

	//Clicking on the My Profile 
	@FindBy(xpath= "//span[@class='pull-left'][text()='My Profile']")
	private WebElement MyProfile;

	//Passing the Values to First Name
	@FindBy(xpath="//input[@id='user_first_name']")
	private WebElement FirstName;

	//Passing the Values to Last Name
	@FindBy(xpath="//input[@id='user_last_name']")
	private WebElement LastName;

	//Passing the Values to Email Id
	@FindBy(xpath="//input[@id='user_email']")
	private WebElement EmailId;

	//Passing the Values to Roles
	@FindBy(xpath="//div[@id='s2id_user_role_ids']//input")
	private WebElement SetRoles;

	//Clicking on the Country
	@FindBy(xpath="//div[@id='s2id_address_country']//span[@class='select2-chosen']")
	private WebElement Country;

	//Selecting the Country option
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetCountry;

	//Clicking on the Time Zone
	@FindBy(xpath="//div[@id='s2id_country_zones']//span[@class='select2-chosen']")
	private WebElement TimeZone;

	//Passing the Values to Time Zone
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetTimeZone;

	//Passing the Values to Cluster
	@FindBy(xpath="//input[@id='s2id_autogen11']")
	private WebElement SetCluster;

	//Passing the Values to Auditee
	@FindBy(xpath="//input[@id='s2id_autogen12']")
	private WebElement SetAuditee;

	//Passing the Values to Phone
	@FindBy(xpath="//input[@id='user_phone']")
	private WebElement Phone;

	//Passing the Values to Adress
	@FindBy(xpath="//textarea[@id='user_address_attributes_door_no']")
	private WebElement Adress;

	//Clicking on the state 
	@FindBy(xpath="//div[@id='s2id_cluster_states']//span[@class='select2-chosen']")
	private WebElement State;

	//Passing the values to State
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetState;

	//Clicking on the City 
	@FindBy(xpath="//div[@id='s2id_cluster_cities']//span[@class='select2-chosen']")
	private WebElement City;

	//Passing the values to City
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetCity;

	//Clicking on the ZipCode 
	@FindBy(xpath="//div[@id='s2id_cluster_zip']//span[@class='select2-chosen']")
	private WebElement ZipCode;

	//Passing the values to Zipcodw
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetZipCode;

	//Clicking on the Area 
	@FindBy(xpath="//div[@id='s2id_cluster_area']//span[@class='select2-chosen']")
	private WebElement Area;

	//Passing the values to Area
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetArea;

	//Clicking on the Region 
	@FindBy(xpath="//div[@id='s2id_cluster_region']//span[@class='select2-chosen']")
	private WebElement Region;

	//Passing the values to Region
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetRegion;

	//Clicking on the Zone 
	@FindBy(xpath="//div[@id='s2id_cluster_zone']//span[@class='select2-chosen']")
	private WebElement Zone;

	//Passing the values to Zone
	@FindBy(xpath="//div[@id='select2-drop']//div/input")
	private WebElement SetZone;

	//Clicking on the Male Radio Button
	@FindBy(xpath="//input[@id='user_profile_attributes_gender_male']")
	private WebElement MaleRadioBTN;

	//Clicking on the Female Radio Button
	@FindBy(xpath="//input[@id='user_profile_attributes_gender_female']")
	private WebElement FemaleRadioBTN;

	//Clicking on the Transgender Radio Button
	@FindBy(xpath="//input[@id='user_profile_attributes_gender_transgender']")
	private WebElement TransgenderRadioBTN;

	//Passing the Values to DOB
	@FindBy(xpath="//input[@name='user[profile_attributes][date_of_birth]']")
	private WebElement DateOfBirth;

	//passing the Values to Qualification
	@FindBy(xpath="//input[@id='s2id_autogen20']")
	private WebElement Qualification;

	//Clicking on the Choose File
	@FindBy(xpath="//input[@id='user_profile_attributes_profile']")
	private WebElement ChooseFile;

	//Clicking on the Submitted Button
	@FindBy(xpath="//input[@name='commit']")
	private WebElement SubmitBTN;

	//Clicking on the Matched data//span[@class='select2-match']
	@FindBy(xpath="//ul[@class='select2-results scroll-content']//li[1]/div/span")
	private WebElement Matched;

	//This Filed is Required Error Message
	@FindBy(xpath="//div[@class='popover-content'][text()='This field is required.']")
	private WebElement ThisError;

	//Checking First Name contain special characters
	@FindBy(xpath="//li[contains(text(),'First Name contain special characters')]")
	private WebElement FirstNameErrorMSG;

	//Checking Mobile number should contain 10 number
	@FindBy(xpath="//li[contains(text(),'Mobile number should contain 10 number')]")
	private WebElement MobileNuberErrorMSG1;

	//Checking First Name contain special characters
	@FindBy(xpath="//li[contains(text(),'Last Name contain special characters')]")
	private WebElement LastNameErrorMSG;

	//Checking Mobile Number contain special characters
	@FindBy(xpath="//li[contains(text(),'Mobile number should contain only number')]")
	private WebElement MobileNumberErrorMSG;

	public SuperAdminProfilePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickMyProfile()
	{
		MyProfile.click();
	}

	public void SetFirstName(String FN)
	{
		FirstName.clear();
		FirstName.sendKeys(FN);
		System.out.println("Entered First Name is : " + FN);
		chiledTest.log(Status.INFO, "First Name is Entered");
	}

	public void SetLastName(String LN)
	{
		LastName.clear();
		LastName.sendKeys(LN);
		System.out.println("Entered Last Name is : " + LN);
		chiledTest.log(Status.INFO, "Last Name is Entered");
	}

	public void ClearRols()
	{
		List<WebElement> ClearRoles = driver.findElements(By.xpath("//div[@id='s2id_user_role_ids']//a"));
		for(int i=0; i<=ClearRoles.size(); i++)
		{
			ClearRoles.get(i).click();
		}
	}

	public void ClearRoles()
	{
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> ClearRoles = driver.findElements(By.xpath("//div[@id='s2id_user_role_ids']//a"));
			for(int i=0; i<=ClearRoles.size(); i++)
			{
				ClearRoles.get(i).click();
			}
		}catch (Exception e) {
		}
	}

	public void SetRoles(String SR)
	{
		SetRoles.sendKeys(SR);
		System.out.println("Selected Roles is : " + SR);
		chiledTest.log(Status.INFO, "Roles is Selected");
	}

	public void SetTimeZone(String TZ)
	{
		//Clicking on the Time Zone
		TimeZone.click();

		//Passing the Values to Time Zone
		SetTimeZone.sendKeys(TZ);
		System.out.println("Entered Time Zone is : " + TZ);
		chiledTest.log(Status.INFO, "Time Zone is Selected");
	}
	public void SetCountryOption(String SC)
	{
		//Clicking on the Country 
		Country.click();

		//Passing the Values to Country
		SetCountry.sendKeys(SC);
		System.out.println("Entered Country is : " + SC);
		chiledTest.log(Status.INFO, "Country is Selected");
	}

	public void ClearCluster()
	{
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> ClearRoles = driver.findElements(By.xpath("//div[@id='s2id_country_clusters']//a"));
			for(int i=0; i<=ClearRoles.size(); i++)
			{
				ClearRoles.get(i).click();
			}
		}catch (Exception e) {
		}
	}

	public void SetCluster(String CL)
	{
		SetCluster.sendKeys(CL);
		System.out.println("Entered Cluster is : " + CL);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		Matched.click();

	}

	public void ClearAuditee()
	{
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> ClearRoles = driver.findElements(By.xpath("//div[@id='s2id_cluster_auditees']//a"));
			for(int i=0; i<=ClearRoles.size(); i++)
			{
				ClearRoles.get(i).click();
			}
		}catch (Exception e) {
		}
	}

	public void SetAuditee(String AU)
	{
		SetAuditee.sendKeys(AU);
		System.out.println("Entered Auditee is : " + AU);
		chiledTest.log(Status.INFO, "Auditee is Selected");

		Matched.click();
	}


	public void SetPhone(String SP)
	{
		Phone.clear();
		Phone.sendKeys(SP);
		System.out.println("Entered Phone Number is : " + SP);
		chiledTest.log(Status.INFO, "Phone Number is Entered");
	}

	public void SetAddress(String SA)
	{
		Adress.clear();
		Adress.sendKeys(SA);
		System.out.println("Entered Adress is : " + SA);
		chiledTest.log(Status.INFO, "Address is Enterd");
	}

	public void SetState(String ST)
	{
		State.click();
		SetState.sendKeys(ST);
		System.out.println("Entered State is : " + ST);
		chiledTest.log(Status.INFO, "State is Selected");

		Matched.click();
	}

	public void SetCity(String CT)
	{
		City.click();
		SetCity.sendKeys(CT);
		System.out.println("Entered City is : " + CT);
		chiledTest.log(Status.INFO, "City is Selected");

		Matched.click();

	}

	public void SetZipCode(String ZC)
	{
		ZipCode.click();
		SetZipCode.sendKeys(ZC);
		System.out.println("Entered Zip Code is : " + ZC);
		chiledTest.log(Status.INFO, "Zip Code is Selected");

		Matched.click();
	}

	public void SetArea(String AR)
	{
		Area.click();
		SetArea.sendKeys(AR);
		System.out.println("Entered Area is : " + AR);
		chiledTest.log(Status.INFO, "Area is Selected");

		Matched.click();
	}

	public void SetRegion(String RG)
	{
		Region.click();
		SetRegion.sendKeys(RG);
		System.out.println("Entered Region is : " + RG);
		chiledTest.log(Status.INFO, "Region is Selected");

		Matched.click();
	}

	public void SetZone(String ZO)
	{
		Zone.click();
		SetZone.sendKeys(ZO);
		System.out.println("Entered Zone is : " + ZO);
		chiledTest.log(Status.INFO, "Zone is Selected");

		Matched.click();
	}


	public void ClickMaleRadioButton()
	{
		MaleRadioBTN.click();
		System.out.println("Male Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Male Radio Button is Clicked");
	}

	public void ClickFemaleRadioButton()
	{
		FemaleRadioBTN.click();
		System.out.println("Female Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Female Radio Button is Clicked");
	}

	public void ClickTransgenderRadioButton()
	{
		TransgenderRadioBTN.click();
		System.out.println("Transgender Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Transgender Radio Button is Clicked");
	}

	public void SetDateOfBirth(String DOB)
	{
		DateOfBirth.clear();

		DateOfBirth.sendKeys(DOB);
		System.out.println("Enterd DOB is : " + DOB);
		chiledTest.log(Status.INFO, "DOB Is Enterd");

		DateOfBirth.sendKeys(Keys.ESCAPE);
	}

	public void ClearQualifications()
	{
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> ClearQualifications = driver.findElements(By.xpath("//label[text()='Qualification']/following-sibling::div//a"));
			for(int i=0; i<=ClearQualifications.size(); i++)
			{
				ClearQualifications.get(i).click();
			}
		}catch (Exception e) {
		}
	}

	public void ClearSpecializations()
	{
		try{
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			List<WebElement> ClearSpecialization = driver.findElements(By.xpath("//label[text()='Specialization']/following-sibling::div//a"));
			for(int i=0; i<=ClearSpecialization.size(); i++)
			{
				ClearSpecialization.get(i).click();
			}
		}catch (Exception e) {
		}
	}

	public void SetQualifications()
	{
		WebElement QualificationsListBox = driver.findElement(By.xpath("//label[text()='Qualification']/following-sibling::select"));
		Select select = new Select(QualificationsListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of Qualifications Options Are : " + count);
		for (int i=0; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			System.out.println("Displayed Qualifications Options are : " + All.getText());
			All.click();
		}

		System.out.println("Selected All Qualifications Options Under Qualifications Drop Down List");
		chiledTest.log(Status.INFO, "Selected All Qualifications Options Under Qualifications Drop Down List");
	}

	public void SetSpecializations()
	{
		WebElement SpecializationListBox = driver.findElement(By.xpath("//label[text()='Specialization']/following-sibling::select"));
		Select select = new Select(SpecializationListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number of Specializations Options Are : " + count);
		for (int i=0; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			System.out.println("Displayed Specializations Options are : " + All.getText());
			All.click();
		}

		System.out.println("Selected All Specialization Options Under Specialization Drop Down List");
		chiledTest.log(Status.INFO, "Selected All Specialization Options Under Specialization Drop Down List");
	}

	public void SetPhoto(String SP)
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180607-WA0031.jpg");
		System.out.println("Photo is Uploaded");
		chiledTest.log(Status.INFO, "Photo is Uploaded");
	}

	public void ClickMatched()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Matched)).click();
	}

	public void ClickSubmitBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SubmitBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitBTN);
		System.out.println("submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void VerifyingThisFieldisRequiredErrorMSG(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(ThisError.isDisplayed());
		System.out.println("Pass : This Field is Required Error Message is Displayed");
	}


	public void VerifyAddOrEditUserPageisDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//checking the Add/edit User page is Displayed
		WebElement Header = driver.findElement(By.xpath("//div[@class='panel-title']"));
		if(wait.until(ExpectedConditions.visibilityOf(Header)).isDisplayed())
		{
			String Expected_text = Header.getText();
			String Actual_text = "ADD / EDIT USER";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Add / Edit User page is Displayed");
		}
	}

	public void VerifyEmailIsReadonly(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement readOnly = driver.findElement(By.xpath("//input[@id='user_email']"));
		Assert.assertTrue(readOnly.getAttribute("readOnly").equals("true"), "Element ReadOnly");

	}

	public void VerifyUserUpdatedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "User updated successfully!";
			Assert.assertEquals(Actual_text, Expected_text, "Message is Wrong");
			System.out.println("Pass : User updated successfully! Success Message is Displayed");
			chiledTest.log(Status.INFO, "User updated successfully! Success Message is Displayed");

			//Clicking on the Cancel Button
			WebElement CloseBTN = driver.findElement(By.xpath("//div[@class='alert alert-success']/button"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", CloseBTN);
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


	public void VerifyMandtatoryFieldsIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking First Name
		WebElement FN = driver.findElement(By.xpath("//input[@id='user_first_name'][@required='required']"));
		Assert.assertTrue(FN.isDisplayed(), "First Name Is NOT Working As Required Field");
		System.out.println("First Name Is Required Field");
		chiledTest.log(Status.INFO, "First Name Is Required Field");

		//Checking Last Name
		WebElement LN = driver.findElement(By.xpath("//input[@id='user_last_name'][@required='required']"));
		Assert.assertTrue(LN.isDisplayed(), "Last Name Is NOT Working As Required Field");
		System.out.println("Last Name Is Required Field");
		chiledTest.log(Status.INFO, "Last Name Is Required Field");

		//Checking Email Id
		WebElement EI = driver.findElement(By.xpath("//input[@id='user_email'][@required='required']"));
		Assert.assertTrue(EI.isDisplayed(), "Email Id Is NOT Working As Required Field");
		System.out.println("Email Id Name Is Required Field");
		chiledTest.log(Status.INFO, "Email Id Name Is Required Field");

		//Checking Roles
		WebElement Roles = driver.findElement(By.xpath("//select[@id='user_role_ids'][@required='required']"));
		Assert.assertTrue(Roles.isDisplayed(), "Roles Is NOT Working As Required Field");
		System.out.println("Roles Is Required Field");
		chiledTest.log(Status.INFO, "Roles Is Required Field");

		//Checking Time Zone
		WebElement TimeZone = driver.findElement(By.xpath("//select[@id='country_zones'][@required='required']"));
		Assert.assertTrue(TimeZone.isDisplayed(), "Time Zone Is NOT Working As Required Field");
		System.out.println("Time Zone Is Required Field");
		chiledTest.log(Status.INFO, "Time Zone Is Required Field");

		//Checking Country
		WebElement Cuntry = driver.findElement(By.xpath("//select[@id='address_country'][@required='required']"));
		Assert.assertTrue(Cuntry.isDisplayed(), "Country Is NOT Working As Required Field");
		System.out.println("Country Is Required Field");
		chiledTest.log(Status.INFO, "Country Is Required Field");

		//Checking Cluster
		WebElement Cluster = driver.findElement(By.xpath("//select[@id='country_clusters'][@required='required']"));
		Assert.assertTrue(Cluster.isDisplayed(), "Cluster Is NOT Working As Required Field");
		System.out.println("Cluster Is Required Field");
		chiledTest.log(Status.INFO, "Cluster Is Required Field");

		//Checking Area
		WebElement Area = driver.findElement(By.xpath("//select[@id='cluster_area'][@required='required']"));
		Assert.assertTrue(Area.isDisplayed(), "Area Is NOT Working As Required Field");
		System.out.println("Area Is Required Field");
		chiledTest.log(Status.INFO, "Area Is Required Field");

		//Checking Zone
		WebElement Zone = driver.findElement(By.xpath("//select[@id='cluster_zone'][@required='required']"));
		Assert.assertTrue(Zone.isDisplayed(), "Zone Is NOT Working As Required Field");
		System.out.println("Zone Is Required Field");
		chiledTest.log(Status.INFO, "Zone Is Required Field");



		//Checking Region
		WebElement Region = driver.findElement(By.xpath("//select[@id='cluster_region'][@required='required']"));
		Assert.assertTrue(Region.isDisplayed(), "Region Is NOT Working As Required Field");
		System.out.println("Region Is Required Field");
		chiledTest.log(Status.INFO, "Region Is Required Field");

		//Checking State
		WebElement State = driver.findElement(By.xpath("//select[@id='cluster_states'][@required='required']"));
		Assert.assertTrue(State.isDisplayed(), "State Is NOT Working As Required Field");
		System.out.println("State Is Required Field");
		chiledTest.log(Status.INFO, "State Is Required Field");

		//Checking City
		WebElement City = driver.findElement(By.xpath("//select[@id='cluster_cities'][@required='required']"));
		Assert.assertTrue(City.isDisplayed(), "City Is NOT Working As Required Field");
		System.out.println("City Is Required Field");
		chiledTest.log(Status.INFO, "City Is Required Field");

		/*//Checking the Auditee
			WebElement Auditee = driver.findElement(By.xpath("//select[@id='cluster_auditees'][@required='required']"));
			Assert.assertTrue(Auditee.isDisplayed(), "Auditee Is NOT Working As Required Field");
			System.out.println("Auditee Is Required Field");
			chiledTest.log(Status.INFO, "Auditee Is Required Field");*/


	}

	public void VerifyErrorMessageAreDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking First Name Error Message
		if(wait.until(ExpectedConditions.visibilityOf(FirstNameErrorMSG)).isDisplayed()){
			System.out.println("Pass : First Name contain special characters Error Message is Displayed");
			chiledTest.log(Status.INFO, "First Name contain special characters Error Message is Displayed");}
		else {
			System.out.println("Pass : First Name contain special characters Error Message is Not Displayed");
			chiledTest.log(Status.INFO, "First Name contain special characters Error Message is Not Displayed");} 

		//Checking Last Name Error Message
		if(wait.until(ExpectedConditions.visibilityOf(LastNameErrorMSG)).isDisplayed()){
			System.out.println("Pass : Last Name contain special characters Error Message is Displayed");
			chiledTest.log(Status.INFO, "Last Name contain special characters Error Message is Displayed");}
		else {
			System.out.println("Pass : Last Name contain special characters Error Message is Not Displayed");
			chiledTest.log(Status.INFO, "Last Name contain special characters Error Message is Not Displayed");} 

		//Checking Mobile number Error Message
		if(wait.until(ExpectedConditions.visibilityOf(MobileNuberErrorMSG1)).isDisplayed()){
			System.out.println("Pass : Mobile number should contain 10 number Error Message is Displayed");
			chiledTest.log(Status.INFO, "Mobile number should contain 10 number Error Message is Displayed");}
		else {
			System.out.println("Pass : Mobile number should contain 10 number Error Message is Not Displayed");
			chiledTest.log(Status.INFO, "Mobile number should contain 10 number Error Message is Not Displayed");} 

		//Checking Mobile number should contain only number
		if(wait.until(ExpectedConditions.visibilityOf(MobileNumberErrorMSG)).isDisplayed()){
			System.out.println("Pass : Mobile number should contain only number Error Message is Displayed");
			chiledTest.log(Status.INFO, "Mobile number should contain only number Error Message is Displayed");}
		else {
			System.out.println("Pass : Mobile number should contain only number Error Message is Not Displayed");
			chiledTest.log(Status.INFO, "Mobile number should contain only number Error Message is Not Displayed");} 
	}

	public void VerifyUpdatedDetailsAreDisplayed()
	{
		//Checking First Name
		String Actual_FirstName = FirstName.getAttribute("value");
		String Expected_FirstName = Lib.getCellValue(XLPATH, "My Profile", 3, 0);
		Assert.assertEquals(Actual_FirstName, Expected_FirstName, "Displayed First Name is Wrong");
		System.out.println("First Name is Displayed");
		chiledTest.log(Status.INFO, "First Name is Displayed");

		//Checking Last Name
		String Actual_LastName = LastName.getAttribute("value");
		String Expected_LastName = Lib.getCellValue(XLPATH, "My Profile", 3, 1);
		Assert.assertEquals(Actual_LastName, Expected_LastName, "Displayed Last Name is Wrong");
		System.out.println("Last Name is Displayed");
		chiledTest.log(Status.INFO, "Last Name is Displayed");

		//Checking Email Id
		String Actual_EmailID= EmailId.getAttribute("value");
		String Expected_EmailID = Lib.getCellValue(XLPATH, "My Profile", 3, 2);
		Assert.assertEquals(Actual_EmailID, Expected_EmailID, "Displayed Email ID is Wrong");
		System.out.println("Email ID is Displayed");
		chiledTest.log(Status.INFO, "Email ID is Displayed");

		//Checking the Roles
		List<WebElement> RolesListBox = driver.findElements(By.xpath("//select[@id='user_role_ids']/option[@selected='selected']"));
		for(int i=0; i<RolesListBox.size(); i++)
		{
			int Actual_RoleCount = RolesListBox.size();
			int Expected_RoleCunt = 4;
			System.out.println("Displayed Roles are : " + Actual_RoleCount);
			Assert.assertEquals(Actual_RoleCount, Expected_RoleCunt, "Roles Options are Wrong");
			System.out.println("Selected Rols Options are" + RolesListBox.get(i).getText());
			chiledTest.log(Status.INFO, "Selected Rols Options are displayed");
		}



		//Checking the Country
		boolean Actual_Country = Country.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 4));
		Assert.assertTrue(Actual_Country, "Displayed Country is Wrong");
		System.out.println("Country is displayed");
		chiledTest.log(Status.INFO, "Country is displayed");

		//Checking the Time Zone
		boolean Actual_TimeZone = TimeZone.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 5));
		Assert.assertTrue(Actual_TimeZone, "Displayed Time Zone is Wrong");
		System.out.println("Time Zone is displayed");
		chiledTest.log(Status.INFO, "Time Zone is displayed");


		//Checking the Cluster
		List<WebElement> ClusterListBox = driver.findElements(By.xpath("//select[@id='country_clusters']//option[@selected='selected']"));
		for(int i=0; i<ClusterListBox.size(); i++)
		{
			int Actual_ClusterCount = ClusterListBox.size();
			int Expected_ClusterCunt = 2;
			System.out.println("Displayed Roles are : " + Actual_ClusterCount);
			Assert.assertEquals(Expected_ClusterCunt, Expected_ClusterCunt, "Cluster Options are Wrong");
			System.out.println("Displayed Cluster Options are" + RolesListBox.get(i).getText());
			chiledTest.log(Status.INFO, "Cluster Options are displayed");
		}

		//Checking the Auditee
		List<WebElement> AuditeeListBox = driver.findElements(By.xpath("//select[@id='cluster_auditees']//option[@selected='selected']"));
		for(int i=0; i<AuditeeListBox.size(); i++)
		{
			int Actual_AuditeeCount = AuditeeListBox.size();
			int Expected_AuditeeCunt = 2;
			System.out.println("Displayed Roles are : " + Actual_AuditeeCount);
			Assert.assertEquals(Actual_AuditeeCount, Expected_AuditeeCunt, "Auditee Options are Wrong");
			System.out.println("Displayed Auditee Options are" + RolesListBox.get(i).getText());
			chiledTest.log(Status.INFO, "Auditee Options are displayed");
		}

		//Checking the Phone Number
		String Atual_Phone = Phone.getAttribute("value");
		String Expected_Phone = Lib.getCellValue(XLPATH, "My Profile", 3, 8);
		Assert.assertEquals(Atual_Phone, Expected_Phone, "Displayed Phone Number is Wrong");
		System.out.println("Phone Number is Displayed");
		chiledTest.log(Status.INFO, "Phone Number is Displayed");

		//Checking the Adress
		String Atual_Adress = Adress.getText();
		String Expected_adress = Lib.getCellValue(XLPATH, "My Profile", 3, 9);
		Assert.assertEquals(Atual_Adress, Expected_adress, "Displayed Adress is Wrong");
		System.out.println("Phone Number is Displayed");
		chiledTest.log(Status.INFO, "Phone Number is Displayed");


		//Checking the State
		boolean Actual_State = State.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 10));
		Assert.assertTrue(Actual_State, "Displayed State is Wrong");
		System.out.println("State is displayed");
		chiledTest.log(Status.INFO, "State is displayed");


		//Checking the City
		boolean Actual_City = City.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 11));
		Assert.assertTrue(Actual_City, "Displayed City is Wrong");
		System.out.println("City is displayed");
		chiledTest.log(Status.INFO, "City is displayed");

		//Checking the ZipCode
		boolean Actual_Zipcode = ZipCode.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 12));
		Assert.assertTrue(Actual_Zipcode, "Displayed Zipcode is Wrong");
		System.out.println("Zipcode is displayed");
		chiledTest.log(Status.INFO, "Zipcode is displayed");

		//Checking the Area
		boolean Actual_Area = Area.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 13));
		Assert.assertTrue(Actual_Area, "Displayed Area is Wrong");
		System.out.println("Area is displayed");
		chiledTest.log(Status.INFO, "Area is displayed");

		//Checking the Region
		boolean Actual_Region = Region.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 14));
		Assert.assertTrue(Actual_Region, "Displayed Region is Wrong");
		System.out.println("Region is displayed");
		chiledTest.log(Status.INFO, "Region is displayed");

		//Checking the Zone
		boolean Actual_Zone = Zone.getText().equalsIgnoreCase(Lib.getCellValue(XLPATH, "My Profile", 3, 15));
		Assert.assertTrue(Actual_Zone, "Displayed Zone is Wrong");
		System.out.println("Zone is displayed");
		chiledTest.log(Status.INFO, "Zone is displayed");

		//Checking date Of Birth
		Assert.assertTrue(DateOfBirth.isDisplayed(), "DOB is NOT Diplayed");
		System.out.println("DOB is displayed");
		chiledTest.log(Status.INFO, "DOB is displayed");

		//Checking the Qualifications
		List<WebElement> QaulificationsListBox = driver.findElements(By.xpath("//label[text()='Qualification']/following-sibling::select/option[@selected='selected']"));
		for(int i=0; i<=QaulificationsListBox.size(); i++)
		{
			int Actual_QualificationCount = QaulificationsListBox.size();
			int Expected_QualificationCunt = 4;
			System.out.println("Displayed Qualifications are : " + Actual_QualificationCount);
			Assert.assertEquals(Actual_QualificationCount, Expected_QualificationCunt, "Qualification Options are Wrong");
			chiledTest.log(Status.INFO, "Auditee Qualification are displayed");
		}

		//Checking the Specialization
		List<WebElement> SpecializationListBox = driver.findElements(By.xpath("//label[text()='Specialization']/following-sibling::select/option[@selected='selected']"));
		for(int i=0; i<=SpecializationListBox.size(); i++)
		{
			int Actual_SpecializationCount = SpecializationListBox.size();
			int Expected_SpecializationCount = 4;
			System.out.println("Displayed Specialization are : " + Actual_SpecializationCount);
			Assert.assertEquals(Actual_SpecializationCount, Expected_SpecializationCount, "Specialization Options are Wrong");
			chiledTest.log(Status.INFO, "Specialization Options are displayed");
		}

	}
}

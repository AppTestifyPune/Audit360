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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;

public class AuditeeRespondentProfilePageTest extends BaseTest {

	//Clicking on the My Profile 
	@FindBy(xpath= "//span[@class='pull-left'][text()='My Profile']")
	private WebElement MyProfile;

	//Passing the Values to First Name
	@FindBy(xpath="//input[@id='user_first_name']")
	private WebElement FirstName;

	//Passing the Values to Last Name
	@FindBy(xpath="//input[@id='user_last_name']")
	private WebElement LastName;

	//Passing the Values to Phone
	@FindBy(xpath="//input[@id='user_phone']")
	private WebElement Phone;

	//Passing the Values to Adress
	@FindBy(xpath="//textarea[@id='user_address_attributes_door_no']")
	private WebElement Adress;

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

	//Clicking on the Choose File
	@FindBy(xpath="//input[@id='user_profile_attributes_profile']")
	private WebElement ChooseFile;

	//Clicking on the Submitted Button
	@FindBy(xpath="//input[@name='commit']")
	private WebElement SubmitBTN;

	//Clicking on the Matched data
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;


	public AuditeeRespondentProfilePageTest(WebDriver driver)
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


	public void SetPhoto(String SP)
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180607-WA0031.jpg");
		System.out.println("Photo is Uploaded");
		chiledTest.log(Status.INFO, "Photo is Uploaded");
	}

	public void ClickMatched()
	{
		Matched.click();
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
			System.out.println("Pass : Add / Edit User page is Displayed");
		}
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
	}


	public void VerifyUpdatedDetailsAreDisplayed()
	{
		//Checking First Name
		String Actual_FirstName = FirstName.getAttribute("value");
		String Expected_FirstName = Lib.getCellValue(XLPATH, "My Profile", 6, 0);
		Assert.assertEquals(Actual_FirstName, Expected_FirstName, "Displayed First Name is Wrong");
		System.out.println("First Name is Displayed");
		chiledTest.log(Status.INFO, "First Name is Displayed");

		//Checking Last Name
		String Actual_LastName = LastName.getAttribute("value");
		String Expected_LastName = Lib.getCellValue(XLPATH, "My Profile", 5, 1);
		Assert.assertEquals(Actual_LastName, Expected_LastName, "Displayed Last Name is Wrong");
		System.out.println("Last Name is Displayed");
		chiledTest.log(Status.INFO, "Last Name is Displayed");

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

		//Checking date Of Birth
				Assert.assertTrue(DateOfBirth.isDisplayed(), "DOB is NOT Diplayed");
				System.out.println("DOB is displayed");
				chiledTest.log(Status.INFO, "DOB is displayed");
	}

	public void VerifyReadOnlyFieldsAreDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Checking Email is Read Only or NOT
		WebElement EmailId = driver.findElement(By.xpath("//input[@id='user_email' and @readonly='readonly']"));
		Assert.assertTrue(EmailId.isDisplayed(), "Email NOT Read Only Mode");
		System.out.println("Email is Read only mode");
		chiledTest.log(Status.INFO, "Email is Read only mode");

		//Checking the Roles is Read only or NOT
		WebElement Roles = driver.findElement(By.xpath("//select[@id='user_role_ids' and @disabled='']"));
		Assert.assertTrue(Roles.isDisplayed(), "Roles NOT Read Only Mode");
		System.out.println("Roles is Read only mode");
		chiledTest.log(Status.INFO, "Roles is Read only mode");

		//Checking the Country is Read only or NOT
		WebElement Country = driver.findElement(By.xpath("//select[@id='address_country' and @disabled='']"));
		Assert.assertTrue(Country.isDisplayed(), "Country is NOT Read Only Mode");
		System.out.println("Country is Read only mode");
		chiledTest.log(Status.INFO, "Country is Read only mode");

		//Checking the Time Zone is Read only or NOT
		WebElement TimeZone = driver.findElement(By.xpath("//select[@id='country_zones' and @disabled='']"));
		Assert.assertTrue(TimeZone.isDisplayed(), "Time Zone NOT Read Only Mode");
		System.out.println("Time Zone is Read only mode");
		chiledTest.log(Status.INFO, "Time Zone is Read only mode");

		//Checking the Code is Read only or NOT
		WebElement Code = driver.findElement(By.xpath("//input[@id='user_code' and @readonly='readonly']"));
		Assert.assertTrue(Code.isDisplayed(), "Code is NOT Read Only Mode");
		System.out.println("Code is Read only mode");
		chiledTest.log(Status.INFO, "Code is Read only mode");

		//Checking the State is Read only or NOT
		WebElement State = driver.findElement(By.xpath("//select[@id='cluster_states' and @disabled='']"));
		Assert.assertTrue(State.isDisplayed(), "State is NOT Read Only Mode");
		System.out.println("State is Read only mode");
		chiledTest.log(Status.INFO, "State is Read only mode");

		//Checking the City is Read only or NOT
		WebElement City = driver.findElement(By.xpath("//select[@id='cluster_cities' and @disabled='']"));
		Assert.assertTrue(City.isDisplayed(), "City is NOT Read Only Mode");
		System.out.println("City is Read only mode");
		chiledTest.log(Status.INFO, "City is Read only mode");

		//Checking the ZipCode is Read only or NOT
		WebElement ZipCode = driver.findElement(By.xpath("//select[@id='cluster_zip' and @disabled='']"));
		Assert.assertTrue(ZipCode.isDisplayed(), "ZipCode is NOT Read Only Mode");
		System.out.println("ZipCode is Read only mode");
		chiledTest.log(Status.INFO, "ZipCode is Read only mode");

		//Checking the Area is Read only or NOT
		WebElement Area = driver.findElement(By.xpath("//select[@id='cluster_area' and @disabled='']"));
		Assert.assertTrue(Area.isDisplayed(), "Area is NOT Read Only Mode");
		System.out.println("Area is Read only mode");
		chiledTest.log(Status.INFO, "Area is Read only mode");

		//Checking the Region is Read only or NOT
		WebElement Region = driver.findElement(By.xpath("//select[@id='cluster_region' and @disabled='']"));
		Assert.assertTrue(Region.isDisplayed(), "Region is NOT Read Only Mode");
		System.out.println("Region is Read only mode");
		chiledTest.log(Status.INFO, "Region is Read only mode");

		//Checking the Zone is Read only or NOT
		WebElement Zone = driver.findElement(By.xpath("//select[@id='cluster_zone' and @disabled='']"));
		Assert.assertTrue(Zone.isDisplayed(), "Zone is NOT Read Only Mode");
		System.out.println("Zone is Read only mode");
		chiledTest.log(Status.INFO, "Zone is Read only mode");

		//Checking the Qualifications is Read only or NOT
		WebElement Qualifications = driver.findElement(By.xpath("//select[@name='user[profile_attributes][qualification][]' and @disabled='']"));
		Assert.assertTrue(Qualifications.isDisplayed(), "Qualifications is NOT Read Only Mode");
		System.out.println("Qualifications is Read only mode");
		chiledTest.log(Status.INFO, "Qualifications is Read only mode");

		//Checking the specialization is Read only or NOT
		WebElement specialization = driver.findElement(By.xpath("//select[@name='user[profile_attributes][specialization][]' and @disabled='']"));
		Assert.assertTrue(specialization.isDisplayed(), "specialization is NOT Read Only Mode");
		System.out.println("specialization is Read only mode");
		chiledTest.log(Status.INFO, "specialization is Read only mode");
	}




}

package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;

public class UpdatePasswordPageTest extends BaseTest {

	//Checking Home
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement Home;

	//Clicking on the Manage User header
	@FindBy(xpath="//a[@class='active' and text()='UPDATE PASSWORD']")
	private WebElement PageHeader;

	//Clicking on the Update Password
	@FindBy(xpath= "//span[text()='Update Password']")
	private WebElement UpdatePassword;

	//clicking on the Change my Password Button
	@FindBy(xpath="//input[@type='button'][@value='Change my password']")
	private WebElement ChangeMyPasswordBTN;

	//Passing the Values to Old Password
	@FindBy(xpath="//input[@id='old_password']")
	private WebElement OldPassword;

	//Passing the values to New Password
	@FindBy(xpath="//input[@id='new_password']")
	private WebElement NewPassword;

	//Passing the values to Re Enter New Password
	@FindBy(xpath="//input[@id='reenter_password']")
	private WebElement ReEnterPassword;

	//Checking Error Message
	@FindBy(xpath="//div[@class='alert alert-danger']/span")
	private WebElement ErrorMSG;

	//Clicking on the Error Message Close Button
	@FindBy(xpath="//div[@class='alert alert-danger']/button[@class='close']")
	private WebElement ErrorMSGCloseBTN;

	//Checking success Message 
	@FindBy(xpath="//div[@class='alert alert-success']/span")
	private WebElement SuccessMSG;

	//Clicking on the Success Message Close Button
	@FindBy(xpath="//div[@class='alert alert-success']/button[@class='close']")
	private WebElement SuccessMSGCloseBTN;

	public UpdatePasswordPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickUpdatePassword()
	{
		UpdatePassword.click();
	}

	public void SetOldPassword(String OP)
	{
		OldPassword.sendKeys(OP);
		System.out.println("Entered Old Password is : " + OP);
	}

	public void SetNewPassword(String NP)
	{
		NewPassword.sendKeys(NP);
		System.out.println("Entered New Password is : " + NP);
	}

	public void setReEnterPassword(String RP)
	{
		ReEnterPassword.sendKeys(RP);
		System.out.println("Entered Re Enter Password is : " + RP);
	}

	public void ClickChangeMyPasswordBTN()
	{
		ChangeMyPasswordBTN.click();
		System.out.println("Change My Password Button is Clicked");
	}


	public void VerifyUpdatePasswordPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Checking Home is Displayed
		Assert.assertTrue(Home.isDisplayed(), "Home is NOT Displayed");
		System.out.println("Home Header is Displayed");
		chiledTest.log(Status.INFO, "Home Header is Displayed");

		//Checking the User Management Header
		Assert.assertTrue(PageHeader.isDisplayed(), "Header of the Page is Wrong");
		System.out.println("Update Password Header is Displayed");
		chiledTest.log(Status.INFO, "Update Password Header is Displayed");

		//Checking the Old Password
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Old Password')]")).isDisplayed(), "Old Password Label is NOT Displayed");
		System.out.println("Old Passwod Label is Displayed");
		chiledTest.log(Status.INFO, "Old Passwod Label is Displayed");

		//Checking the New Password
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='New Password']")).isDisplayed(), "Old Password Label is NOT Displayed");
		System.out.println("New Passwod Label is Displayed");
		chiledTest.log(Status.INFO, "New Passwod Label is Displayed");

		//Checking the Re enter New Password
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Re enter New Password']")).isDisplayed(), "Old Password Label is NOT Displayed");
		System.out.println("Re enter New Passwod Label is Displayed");
		chiledTest.log(Status.INFO, "Re enter New Passwod Label is Displayed");

		//Checking Change My Password Button is Displayed
		Assert.assertTrue(ChangeMyPasswordBTN.isDisplayed(), "Change My Password Button is NOT Displayed");
		System.out.println("Change My Password Button is isplayed");
		chiledTest.log(Status.INFO, "Change My Password Button is Displayed");

		//Checking Old Password Input Field is Displayed
		Assert.assertTrue(OldPassword.isDisplayed(), "Old Password Button is NOT Displayed");
		System.out.println("Old Password Button is isplayed");
		chiledTest.log(Status.INFO, "Old Password Button is Displayed");

		//Checking New Password Input Field is Displayed
		Assert.assertTrue(NewPassword.isDisplayed(), "New Password Button is NOT Displayed");
		System.out.println("New Password Button is isplayed");
		chiledTest.log(Status.INFO, "New Password Button is Displayed");

		//Checking Re Enter New Password Input Field is Displayed
		Assert.assertTrue(ReEnterPassword.isDisplayed(), "Re Enter New Password Button is NOT Displayed");
		System.out.println("Re Enter New Password Button is isplayed");
		chiledTest.log(Status.INFO, "Re Enter New Password Button is Displayed");

	}

	public void VerifyOldPasswordEnteredIsInvalidErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "Old password you've entered is invalid";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Old password you've entered is invalid Error Message is Displayed");

			//Clicking on the Cancel Button
			ErrorMSGCloseBTN.click();
		}


	}

	public void VerifyPasswordConfirmationDoesnMatchPassword_PasswordIsTooShort_PasswordComplexityRequirementNotMet_PleaseUse1Uppercase1Lowercase1DigitAnd1SpecialCharacterErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "Password confirmation doesn't match Password, Password is too short (minimum is 8 characters), Password Complexity requirement not met. Please use: 1 uppercase, 1 lowercase , 1 digit and 1 special character";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Password confirmation doesn't match Password, Password is too short (minimum is 8 characters), Password Complexity requirement not met. Please use: 1 uppercase, 1 lowercase , 1 digit and 1 special character Error Message Is Displayed");

			//Clicking on the Cancel Button
			ErrorMSGCloseBTN.click();
		}

	}


	public void VerifyPasswordChangedSuccessfullySuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "Password changed successfully, please login with new password";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Password changed successfully, please login with new password Success Message is Displayed");

			//Clicking on the Cancel Button
			SuccessMSGCloseBTN.click();
		}

	}


}

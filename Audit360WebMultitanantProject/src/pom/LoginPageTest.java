package pom;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class LoginPageTest extends BaseTest {

	@FindBy(xpath="//label[text()='Login']/following-sibling::div/input")
	private WebElement UNTB;

	@FindBy(xpath="//input[@id='user_password']")
	private WebElement PWTB;

	//clicking on the Sign In button
	@FindBy(xpath ="//input[@class='btn btn-primary submit_button btn-cons m-t-10']")
	private WebElement SigninBTN;

	//checking the incorrect password error message 
	@FindBy(xpath="//div[@class='messages error']")
	private WebElement ErrorMasg;

	//clicking on the Profile Button
	@FindBy(xpath="//button[@class='profile-dropdown-toggle']")
	private WebElement ProfileBTN;

	//Clicking on the Logout Button
	@FindBy(xpath="//span[text()='Logout']")
	private WebElement LogoutBTN;

	//Checking Success Message
	@FindBy(xpath="//div[@class='alert alert-success']/span")
	private WebElement SuccessMSG;

	//Clicking on the Success Message Close BTN
	@FindBy(xpath="//div[@class='alert alert-success']/button")
	private WebElement SuccessMsgCloseBTN;


	public LoginPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void setusername(String un)
	{
		UNTB.sendKeys(un);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(UNTB)).clear();
		wait.until(ExpectedConditions.visibilityOf(UNTB)).sendKeys(un);
		System.out.println("Entered User Name is : " + un);
	}

	public void setpassword(String pw)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(PWTB)).clear();
		wait.until(ExpectedConditions.visibilityOf(PWTB)).sendKeys(pw);
		System.out.println("Entered User Name is : " + pw);
	}

	public void ClickProfileBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(ProfileBTN)).click();
	}

	public void ClickLogoutBTN()
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(LogoutBTN));
		LogoutBTN.click();
		System.out.println("Logout Button is Clicked");
	}

	public void ClickSigninBTN()
	{
		//driver.findElement(By.xpath("//input[@id='captcha']")).sendKeys("abcd");
		SigninBTN.click();
		System.out.println("Sign in Button is Clicked");
	}

	public void VerifyHomePageTitle(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("AMS"));
		Assert.assertEquals("AMS", driver.getTitle());
		System.out.println("Pass : Home Page Title is Matched");
	}


	public void verifySignedInSuccessMsgIsDisplayed(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed()){
			String Actual_PassMSG = SuccessMSG.getText();
			String Expected_PassMSG = "Signed in successfully.";
			Assert.assertEquals(Actual_PassMSG, Expected_PassMSG);
			System.out.println("Pass : Signed in successfully. Message is Displayed");

			//Clicking on the Cancel Button
			SuccessMsgCloseBTN.click();
		
			//driver.findElement(By.xpath("//div[@id='careMessage']//button")).click();
		
		}

	}


	public void verifyErrorMsgIsDisplayed(WebDriver driver)
	{

		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//span[contains(text(),'Invalid Credentials')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed(), "Invalid Credentials Error Message is Not Displayed");
		System.out.println("Invalid Credentials Error Message is Displayed");

		//Clicking on the Cancel Button
		driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@class='close']")).click();

	}

	public void VerifyYouHaveOneMoreAttemptErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement OneMoreAttempt = driver.findElement(By.xpath("//span[text()='You have one more attempt before your account gets locked.']"));
		if(wait.until(ExpectedConditions.visibilityOf(OneMoreAttempt)).isDisplayed())
		{
			String Actual_text = OneMoreAttempt.getText();
			String Expected_text = "You have one more attempt before your account gets locked.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : You have one more attempt before your account gets locked Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@class='close']")).click();
		}

	}

	public void VerifyAccountLockedErrorMSG(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement AccountLock = driver.findElement(By.xpath("//span[text()='Your account is locked.']"));
		if(wait.until(ExpectedConditions.visibilityOf(AccountLock)).isDisplayed())
		{
			String Actual_text = AccountLock.getText();
			String Expected_text = "Your account is locked.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Account Locked Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@class='close']")).click();
		}

	}

	public void VerifyYourAccountIsLockedErrorMSG(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement AccountLock = driver.findElement(By.xpath("//span[text()='Your account is locked.']"));
		if(wait.until(ExpectedConditions.visibilityOf(AccountLock)).isDisplayed())
		{
			String Actual_text = AccountLock.getText();
			String Expected_text = "Your account is locked.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Your Account Is Locked Error Message is Displayed");

			//Clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@class='close']")).click();
		}

	}

	public void VerifyUserNameIsRequiredFieldsOrNot(WebDriver driver)
	{
		//Checking the User Name Required Fields 
		List<WebElement> UserNameRequired = driver.findElements(By.xpath("//label[text()='Login']/following-sibling::div/input[@required='required']"));
		Assert.assertTrue(UserNameRequired.size()>=1, "User Name is Required Error Message is Not Displayed");
		System.out.println("User Name is Required Field");
		chiledTest.log(Status.INFO, "User Name is Required Field");
	}

	public void VerifyPasswordIsRequiredFieldsOrNot(WebDriver driver)
	{
		//Checking the Password Required Fields 
		List<WebElement> UserNameRequired = driver.findElements(By.xpath("//input[@id='user_password'][@required='required']"));
		Assert.assertTrue(UserNameRequired.size()>=1, "Password is Required Error Message is Not Displayed");
		System.out.println("Password is Required Field");
		chiledTest.log(Status.INFO, "Password is Required Field");
	}

	public void VerifyLoginPageIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//checking the Your Logo Here
		//WebElement Logo = driver.findElement(By.xpath("//img[@src='/assets/default-303e23a9d19aea58ead2487a99f83d75ebc2b96edc06dcb5875ed5572ca53213.png']"));

		//Checking Sign into your account
		WebElement signintoyouraccount = driver.findElement(By.xpath("//p[text()='Sign into your account']"));

		//checking the Login Password
		WebElement UserNameandPassword = driver.findElement(By.xpath("//form[@id='new_user']"));

		//checking the Forgot your Password
		WebElement ForgotPassword = driver.findElement(By.xpath("//a[@id='forgot_password_resources']"));

		//Checking the Audit360 logo
		//WebElement Audit360Logo = driver.findElement(By.xpath("//img[@src='/assets/logo-b1c3120c07f439ea8aa4b3e93335fddd6de0c7e344c713850ca570b9a31b79f0.svg']"));

		if(signintoyouraccount.isDisplayed() && UserNameandPassword.isDisplayed() && ForgotPassword.isDisplayed() && SigninBTN.isDisplayed())
		{
			String Actual_text = signintoyouraccount.getText();
			String Expected_text = "Sign into your account";
			Assert.assertEquals(Actual_text, Expected_text);

			String Actual_ForgotPassword = ForgotPassword.getText();
			String Expected_ForgotPassword = "Forgot your password?";
			Assert.assertEquals(Actual_ForgotPassword, Expected_ForgotPassword);

			System.out.println("Pass : User Is Navigated to Login Page");

		}
	}



}

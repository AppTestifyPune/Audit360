package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ForgotPasswordPageTest {


	//Clicking on the Forgot Password 
	@FindBy(xpath="//a[@class='text-info small m-t-30 sm-m-t-30']")
	private WebElement ForgotPassword;

	//clicking on the Reset Button
	@FindBy(xpath="//input[@class='btn btn-primary btn-cons m-t-10 m-b-20']")
	private WebElement ResetBTN;

	//Passing the Values to Email Id
	@FindBy(xpath="//input[@placeholder='Enter your registered email id']")
	private WebElement EmailId;


	public ForgotPasswordPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickForgotPassword()
	{
		ForgotPassword.click();
	}

	public void ClickResetBTN()
	{
		ResetBTN.click();
	}

	public void SetEmailId(String SE)
	{
		EmailId.clear();
		
		EmailId.sendKeys(SE);
		System.out.println("Entered Email Id Is :" + SE);
	}


	public void VerifyForgotPasswordPageisDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Forgot Password ? no issues
		WebElement Forgot = driver.findElement(By.xpath("//h3[text()='Forgot password? No issues :)']"));
		if(wait.until(ExpectedConditions.visibilityOf(Forgot)).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Forgot password? No issues :) is Displayed");

		}

		//Checking Email Label and Email Text filed
		WebElement EmailLabel = driver.findElement(By.xpath("//label[text()='Email']"));
		WebElement EmailText = driver.findElement(By.xpath("//input[@id='user_email']"));
		if(EmailLabel.isDisplayed() && EmailText.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Email is Displayed");
		}

		//Checking the Audit360 Image
		WebElement img = driver.findElement(By.xpath("//img[@src='/assets/logo-b1c3120c07f439ea8aa4b3e93335fddd6de0c7e344c713850ca570b9a31b79f0.svg']"));
		if(img.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Audit360 logo is Displayed");
		}

		//Checking Reset Button 
		Assert.assertTrue(ResetBTN.isDisplayed());
		System.out.println("Pass : Reset Button is Displayed");
	}

	public void VerfiyThisFiledIsRequiredErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@id='user_email-error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "This field is required.";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : This field is required. Error Message is Displayed");

		}

	}

	public void VerfiyEmailNotFoundErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "Email not found";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Email not found Error Message is Displayed");

			//clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
		}
	}
	
	public void VerfiyYouWillReceiveAnEmailSuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement SucsessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SucsessMSG)).isDisplayed())
		{
			String Expected_text = SucsessMSG.getText();
			String Actual_text = "You will receive an email with instructions on how to reset your password in a few minutes.";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : You will receive an email with instructions on how to reset your password in a few minutes. Success Message is Displayed");

			//clicking on the Cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/span")).click();
		}
	}
}

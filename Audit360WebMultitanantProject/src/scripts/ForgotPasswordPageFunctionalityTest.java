package scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.ForgotPasswordPageTest;

public class ForgotPasswordPageFunctionalityTest extends BaseTest  {

	//Testing the functionality of the User Account Lock
	@Test(priority=6)
	public void Forgot_Password_Mandatory_Field_Test() throws InterruptedException{

		ForgotPasswordPageTest FP = new ForgotPasswordPageTest(driver);

		parentTest = extent.createTest("Forgot Password Functionality Test", "Testing the Forgot Passowrd Page, Forgot Password Mandatory field Test, etc...");

		chiledTest = parentTest.createNode("Forgot Password Mandatory Field Test");

		System.out.println("Forgot Password Mandatory Field Test");

		//Clikcing on the Forgot Password
		FP.ClickForgotPassword();
		chiledTest.log(Status.INFO, "Forgot Password is Clicked");

		//Verfiying Forgot Password is Displayed
		FP.VerifyForgotPasswordPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Forgot Password Page is Displayed");

		//Clicking on the Rest Password Button
		FP.ClickResetBTN();
		chiledTest.log(Status.INFO, "Reset Password Button is Clicked");

		//Verifying Error Message is Displayed
		FP.VerfiyThisFiledIsRequiredErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "This field is required. Error Message is Displayed");
		
		System.out.println("**********************************************************************");

	}

	//Testing the functionality of the User Account Lock
	@Test(priority=7)
	public void Forgot_Password_Test() throws InterruptedException{

		ForgotPasswordPageTest FP = new ForgotPasswordPageTest(driver);

		chiledTest = parentTest.createNode("Forgot Password Test");

		System.out.println("Forgot Password Test");

		driver.navigate().refresh();

		//Passing the Values to Email id which is not Exists in the DB
		String SE = Lib.getCellValue(XLPATH, "Forgot Password", 3, 0);
		FP.SetEmailId(SE);
		chiledTest.log(Status.INFO, "Email Id which is Not Exist in the DB is Entered");

		//Clicking on the Rest Password Button
		FP.ClickResetBTN();
		chiledTest.log(Status.INFO, "Reset Password Button is Clicked");
		
		//Verifying Email not found Error Message is Displayed
		FP.VerfiyEmailNotFoundErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Email not found Error Message is Displayed");
		
		//Passing the Values to Email id
		String SE1 = Lib.getCellValue(XLPATH, "Forgot Password", 4, 0);
		FP.SetEmailId(SE1);
		chiledTest.log(Status.INFO, "Valid Email Id is Entered");

		//Clicking on the Rest Password Button
		FP.ClickResetBTN();
		chiledTest.log(Status.INFO, "Reset Password Button is Clicked");

		//Checking the You will receive an email with instructions on how to reset your password in a few minutes.
		FP.VerfiyYouWillReceiveAnEmailSuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "You will receive an email with instructions on how to reset your password in a few minutes. Success Message is Displayed");

		
		System.out.println("**********************************************************************");
		
		
	}

}

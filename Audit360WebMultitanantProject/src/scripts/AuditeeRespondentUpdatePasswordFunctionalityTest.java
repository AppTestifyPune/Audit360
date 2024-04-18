package scripts;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.UpdatePasswordPageTest;

public class AuditeeRespondentUpdatePasswordFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Update Password Page Test
	@Test(priority=1)
	public void Update_Password_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		UpdatePasswordPageTest UP = new UpdatePasswordPageTest(driver);

		parentTest = extent.createTest("Auditee Respondent Update Pasword Page Test", "Testing the Functionality of the Update Password");

		chiledTest = parentTest.createNode("Update Pasword Page Test");

		System.out.println("Update Pasword Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",60,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",60,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Clicking on the Profile Icon
		l.ClickProfileBTN(driver);

		//Clicking on the Update Password
		UP.ClickUpdatePassword();
		chiledTest.log(Status.INFO, "Update Password is Clicked");

		//Verifying the User Password Page is Displayed
		UP.VerifyUpdatePasswordPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Update Password Page is Displayed");

		System.out.println("******************************************************");

	}

	//Testing the Functionality of the invalid Old Password
	@Test(priority=2)
	public void While_Updating_The_Password_Entered_Invalid_Old_Password_Test() throws InterruptedException
	{
		chiledTest = parentTest.createNode("While Updating The Password Entered Invalid Old Password Test");

		System.out.println("While Updating The Password Entered Invalid Old Password Test");

		UpdatePasswordPageTest UP = new UpdatePasswordPageTest(driver);

		//Passing the Values to Old Password Text field
		String OP = Lib.getCellValue(XLPATH, "Update Password", 3, 0);
		UP.SetOldPassword(OP);
		chiledTest.log(Status.INFO, "Invalid Old Password is Entered");

		//Passing the Values to New Password
		String NP = Lib.getCellValue(XLPATH, "Update Password", 3, 3);
		UP.SetNewPassword(NP);
		chiledTest.log(Status.INFO, "Valid New Password is Entered");

		//Passing the Values to Re Enter New Password
		String RP = Lib.getCellValue(XLPATH, "Update Password", 3, 4);
		UP.setReEnterPassword(RP);
		chiledTest.log(Status.INFO, "Valid Re-Enter New Password is Entered");

		//Clicking on the Change My Password Button
		UP.ClickChangeMyPasswordBTN();
		chiledTest.log(Status.INFO, "Change My Password Button is Clicked");

		//Verify Old password you've entered is invalid Message is Displayed
		UP.VerifyOldPasswordEnteredIsInvalidErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Old password you've entered is invalid Message is Displayed");

		System.out.println("******************************************************");

	}

	@Test(priority=3, dependsOnMethods= {"While_Updating_The_Password_Entered_Invalid_Old_Password_Test"})
	public void While_Updating_The_Password_Passing_Invalid_Data_Test() throws InterruptedException
	{
		chiledTest = parentTest.createNode("While Updating The Password Passing Invalid Data Test");

		System.out.println("While Updating The Password Passing Invalid Data Test");

		LoginPageTest l=new LoginPageTest(driver);

		UpdatePasswordPageTest UP = new UpdatePasswordPageTest(driver);

		//Clicking on the Profile Icon
		l.ClickProfileBTN(driver);

		//Clicking on the Update Password
		UP.ClickUpdatePassword();
		chiledTest.log(Status.INFO, "Update Password is Clicked");

		//Passing the Values to Old Password Text field
		String OP1 = Lib.getCellValue(XLPATH, "Update Password", 3, 1);
		UP.SetOldPassword(OP1);
		chiledTest.log(Status.INFO, "Valid Old Password is Entered");

		//Passing the Values to New Password
		String NP1 = Lib.getCellValue(XLPATH, "Update Password", 3, 2);
		UP.SetNewPassword(NP1);
		chiledTest.log(Status.INFO, "Less Than 8 characters is Entered under New Password");

		//Passing the Values to Re Enter New Password
		String RP1 = Lib.getCellValue(XLPATH, "Update Password", 3, 4);
		UP.setReEnterPassword(RP1);
		chiledTest.log(Status.INFO, "Less Than 8 characters is Entered under Re-Enter Password");

		//Clicking on the Change My Password Button
		UP.ClickChangeMyPasswordBTN();
		chiledTest.log(Status.INFO, "Change My Password Button is Clicked");

		//Checking the Password is too short (minimum is 8 characters)
		UP.VerifyPasswordConfirmationDoesnMatchPassword_PasswordIsTooShort_PasswordComplexityRequirementNotMet_PleaseUse1Uppercase1Lowercase1DigitAnd1SpecialCharacterErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Password confirmation doesn't match Password, Password is too short (minimum is 8 characters), Password Complexity requirement not met. Please use: 1 uppercase, 1 lowercase , 1 digit and 1 special characterError Message is Displayed");

		System.out.println("******************************************************");
	}

	@Test(priority=4, dependsOnMethods= {"While_Updating_The_Password_Passing_Invalid_Data_Test"})
	public void Updating_Password_Test() throws InterruptedException
	{
		chiledTest = parentTest.createNode("Updating Password Test");

		System.out.println("Updating Password Test");

		LoginPageTest l=new LoginPageTest(driver);

		UpdatePasswordPageTest UP = new UpdatePasswordPageTest(driver);

		//Clicking on the Profile Icon
		l.ClickProfileBTN(driver);

		//Clicking on the Update Password
		UP.ClickUpdatePassword();
		chiledTest.log(Status.INFO, "Update Password is Clicked");

		//Passing the Values to Old Password Text field
		String OP1 = Lib.getCellValue(XLPATH, "Update Password", 3, 1);
		UP.SetOldPassword(OP1);
		chiledTest.log(Status.INFO, "Valid Old Password is Entered");

		//Passing the Values to New Password
		String NP1 = Lib.getCellValue(XLPATH, "Update Password", 3, 3);
		UP.SetNewPassword(NP1);
		chiledTest.log(Status.INFO, "Valid Password is Entered under New Password");

		//Passing the Values to Re Enter New Password
		String RP1 = Lib.getCellValue(XLPATH, "Update Password", 3, 5);
		UP.setReEnterPassword(RP1);
		chiledTest.log(Status.INFO, "Valid Password is Entered under Re-Enter Password");

		//Clicking on the Change My Password Button
		UP.ClickChangeMyPasswordBTN();
		chiledTest.log(Status.INFO, "Change My Password Button is Clicked");

		//Password changed successfully, please login with new password Success Message Is Displayed
		UP.VerifyPasswordChangedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Password changed successfully, please login with new password Success Message Is Displayed");

	}

}

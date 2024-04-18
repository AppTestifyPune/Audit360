package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;

public class LoginPageFunctionalityTest extends BaseTest {

	//Testing the functionality of the Invalid Login
	@Test(priority=0)
	public void Valid_Login_Test() throws InterruptedException{

		LoginPageTest l = new LoginPageTest(driver);

		System.out.println("Valid Login Test");

		parentTest = extent.createTest("Login Functionality Test", "Testing the Functionality of the Login Test");

		chiledTest = parentTest.createNode("valid Login Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		//Verifying Signed in successfully. Success Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Verifying the Home Page Title is Matching or not
		l.VerifyHomePageTitle(driver);
		chiledTest.log(Status.INFO, "Home Page Title is Matched");

		System.out.println("***********************************");


	}

	//Testing the Functionality of the Logout
	@Test(priority=1, dependsOnMethods= {"Valid_Login_Test"})
	public void Logout_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		System.out.println("Logout Test");

		chiledTest = parentTest.createNode("Logout Test");

		//clicking on the profile button
		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();
		chiledTest.log(Status.INFO, "Logged Out Button is Clicked");

		//Verifying User is Navigating back to Login Page
		l.VerifyLoginPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Login Page is Displayed");

		System.out.println("***********************************");

	}

	//Testing with the correct user name but incorrect password
	@Test(priority=2,dependsOnMethods= {"Logout_Test"})
	public void Invalid_Login_Test()
	{
		LoginPageTest l = new LoginPageTest(driver);

		System.out.println("Invalid Login Test");

		chiledTest = parentTest.createNode("Invalid Login Test");

		System.out.println("Entered Valid UserName, Invalid Password");
		chiledTest.log(Status.INFO, "Entered Valid UserName, Invalid Password");

		String un = Lib.getCellValue(XLPATH, "Login Credentials", 8, 0);
		l.setusername(un);
		System.out.println("Entered User name is " +un);

		String pw = Lib.getCellValue(XLPATH, "Login Credentials", 8, 1);
		l.setpassword(pw);
		System.out.println("Entered Password is " +pw);

		//Clicking on Sign In Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sign in Button is Clicked");

		//Verifying Error message is displayed 
		l.verifyErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Invalid email or password. Error Message is Displayed");

		driver.navigate().refresh();

		System.out.println("***********************************************");

		System.out.println("Entered Invalid UserName, Valid Password");

		chiledTest.log(Status.INFO, "Entered Invalid UserName, Valid Password");

		String un1 = Lib.getCellValue(XLPATH, "Login Credentials", 9, 0);
		l.setusername(un1);

		String pw1 = Lib.getCellValue(XLPATH, "Login Credentials", 9, 1);
		l.setpassword(pw1);

		//Clicking on Sign In Button
		l.ClickSigninBTN();

		//Verifying Error message is displayed 
		l.verifyErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Invalid email or password. Error Message is Displayed");

		driver.navigate().refresh();

		System.out.println("***********************************************");

		System.out.println("Entered the User Does Not Exist User Name and Password");

		chiledTest.log(Status.INFO, "Entered the User Does Not Exist User Name and Password");

		String un2 = Lib.getCellValue(XLPATH, "Login Credentials", 10, 0);
		l.setusername(un2);

		String pw2 = Lib.getCellValue(XLPATH, "Login Credentials", 10, 1);
		l.setpassword(pw2);

		//Clicking on Sign In Button
		l.ClickSigninBTN();

		//Verifying Error message is displayed 
		l.verifyErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Invalid email or password. Error Message is Displayed");

		driver.navigate().refresh();

		System.out.println("***********************************************");

		System.out.println("Valid UserName With Uppwercase and Valid Password with Uppercases");

		chiledTest.log(Status.INFO, "Valid UserName With Uppwercase and Valid Password with Uppercases");

		String un3 = Lib.getCellValue(XLPATH, "Login Credentials", 11, 0);
		l.setusername(un3);

		String pw3 = Lib.getCellValue(XLPATH, "Login Credentials", 11, 1);
		l.setpassword(pw3);

		//Clicking on Sign In Button
		l.ClickSigninBTN();

		//Verifying Error message is displayed 
		l.verifyErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Invalid email or password. Error Message is Displayed");

		driver.navigate().refresh();

		System.out.println("***********************************************");

		System.out.println("Empty User Name and Empty Password");

		String un4 = Lib.getCellValue(XLPATH, "Login Credentials", 12, 0);
		l.setusername(un4);

		String pw4 = Lib.getCellValue(XLPATH, "Login Credentials", 12, 1);
		l.setpassword(pw4);

		chiledTest.log(Status.INFO, "Empty User Name and Empty Password");

		//Clicking on Sign In Button
		l.ClickSigninBTN();

		//Checking User Name and Password are Required Fields are Not
		l.VerifyUserNameIsRequiredFieldsOrNot(driver);

		//Checking Password is Required Filed are Not
		l.VerifyPasswordIsRequiredFieldsOrNot(driver);

		driver.navigate().refresh();

		System.out.println("********************************************");

		System.out.println("Empty User Name, Valid Password");

		String un5 = Lib.getCellValue(XLPATH, "Login Credentials", 13, 0);
		l.setusername(un5);

		String pw5 = Lib.getCellValue(XLPATH, "Login Credentials", 13, 1);
		l.setpassword(pw5);

		chiledTest.log(Status.INFO, "Empty User Name, Valid Password");

		//Clicking on Sign In Button
		l.ClickSigninBTN();

		//Checking User Name is Required Filed are Not
		l.VerifyUserNameIsRequiredFieldsOrNot(driver);

		driver.navigate().refresh();

		System.out.println("********************************************");

		System.out.println("ValidUser Name, Enpty Password");

		String un6 = Lib.getCellValue(XLPATH, "Login Credentials", 14, 0);
		l.setusername(un6);

		String pw6 = Lib.getCellValue(XLPATH, "Login Credentials", 14, 1);
		l.setpassword(pw6);

		chiledTest.log(Status.INFO, "Valid User Name, Empty Password");

		//Clicking on Sign In Button
		l.ClickSigninBTN();

		//Checking Password is Required Filed are Not
		l.VerifyPasswordIsRequiredFieldsOrNot(driver);

		driver.navigate().refresh();

		System.out.println("********************************************");

	}

	//Testing the functionality of the User Account Lock
	@Test(priority=3, dependsOnMethods= {"Invalid_Login_Test"})
	public void User_Acount_Lock_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Account Lock Test");

		System.out.println("Account Lock Test");

		System.out.println("Entered The Valid User Name But Invalid Password for 1st Time");

		String un=Lib.getCellValue(XLPATH, "Login Credentials",26,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",26,1);
		l.setpassword(pw);

		chiledTest.log(Status.INFO, "Enterd The Valid UserName but Invalid Password for 1st Time");

		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Signin Button is Clicked");

		l.verifyErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Invalid email or password Error Message is displayed");

		System.out.println("**************************************************************");

		System.out.println("Entered the Invalid Password 2nd time");

		String pw1=Lib.getCellValue(XLPATH,"Login Credentials",27,1);
		l.setpassword(pw1);
		System.out.println("Entered Password is : "+ pw1);
		chiledTest.log(Status.INFO, "Enterd The Invalid Password for 2nd Time");

		//Clicking on the Sign in Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Signin Button is Clicked");

		l.VerifyYouHaveOneMoreAttemptErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "You have one more attempt before your account gets locked Error Message is Displayed");

		System.out.println("*******************************************************");

		System.out.println("Entered The Invalid Password for 3rd Time");

		String pw2=Lib.getCellValue(XLPATH,"Login Credentials",28,1);
		l.setpassword(pw2);

		chiledTest.log(Status.INFO, "Entered The Invalid Password for 3rd Time");

		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Signin Button is Clicked");

		l.VerifyAccountLockedErrorMSG(driver);
		chiledTest.log(Status.INFO, "Account Locked Error Message is Displayed");

		System.out.println("********************************************************");

		System.out.println("Entered The Valid Password");

		String pw3 =Lib.getCellValue(XLPATH,"Login Credentials",28,1);
		l.setpassword(pw3);

		chiledTest.log(Status.INFO, "Entered The Valid Password");

		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Signin Button is Clicked");

		//Verifying Your Account is Locked Error Message is Displayed
		l.VerifyYourAccountIsLockedErrorMSG(driver);
		chiledTest.log(Status.INFO, "Your account is locked. Error Message is Displayed");

		System.out.println("************************************************************");

	}
}


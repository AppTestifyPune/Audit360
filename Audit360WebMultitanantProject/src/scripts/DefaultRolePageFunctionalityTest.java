package scripts;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.DefaultRolePageTest;
import pom.LoginPageTest;


public class DefaultRolePageFunctionalityTest extends BaseTest {


	//Testing the Functionality of the Default Role
	@Test(priority= 595)
	public void Default_Role_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		DefaultRolePageTest DR = new DefaultRolePageTest(driver);

		parentTest = extent.createTest("Default Role Test", "Testing the Functionality of the Default Role");

		chiledTest = parentTest.createNode("Default Role Test");

		System.out.println("Default Role Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un);

		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Clicking on the Defult Roles
		DR.ClickDefaultRole();
		chiledTest.log(Status.INFO, "Defult Role is Clicked");

		//Verifying Default Role Options are Displayed
		DR.VerifyDefaultRolesAreDisplayed(driver);
		chiledTest.log(Status.INFO, "Defult Role Options are Displayed");

		//Passing the Values to Deafult Role 
		String SD = Lib.getCellValue(XLPATH, "Default Role", 1, 0);
		DR.SetDefaultRole(SD);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//Verifying Are You Sure ? Pop Up is Displayed
		DR.VerifyAreYouSurePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure ? Pop Up is Displayed");

		//Clicking on the No Button
		DR.ClickNoBTN();
		chiledTest.log(Status.INFO, "No Button is Clicked");



		//Clicking on the Defult Roles
		DR.ClickDefaultRole();
		chiledTest.log(Status.INFO, "Defult Role is Clicked");

		//Passing the Values to Deafult Role 
		String SD1 = Lib.getCellValue(XLPATH, "Default Role", 1, 0);
		DR.SetDefaultRole(SD1);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//Verifying Are You Sure ? Pop Up is Displayed
		DR.VerifyAreYouSurePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure ? Pop Up is Displayed");

		//Clicking on The Yes Button
		DR.ClickYesBTN();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		Thread.sleep(5000);

		//Clicking on the Profile Button
		l.ClickProfileBTN(driver);

		//Clikcing on the Logout Button
		l.ClickLogoutBTN();


		String un1=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw1=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un1);

		l.setpassword(pw1);

		//clicking on the Login Button
		l.ClickSigninBTN();


		System.out.println("***************************************");


		//Clicking on the Defult Roles
		DR.ClickDefaultRole();
		chiledTest.log(Status.INFO, "Defult Role is Clicked");

		//Passing the Values to Deafult Role 
		String SD2 = Lib.getCellValue(XLPATH, "Default Role", 2, 0);
		DR.SetDefaultRole(SD2);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//Verifying Are You Sure ? Pop Up is Displayed
		DR.VerifyAreYouSurePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure ? Pop Up is Displayed");

		//Clicking on the No Button
		DR.ClickNoBTN();
		chiledTest.log(Status.INFO, "No Button is Clicked");

		//Clicking on the Defult Roles
		DR.ClickDefaultRole();
		chiledTest.log(Status.INFO, "Defult Role is Clicked");

		//Passing the Values to Deafult Role 
		String SD3 = Lib.getCellValue(XLPATH, "Default Role", 2, 0);
		DR.SetDefaultRole(SD3);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//Verifying Are You Sure ? Pop Up is Displayed
		DR.VerifyAreYouSurePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure ? Pop Up is Displayed");

		//Clicking on The Yes Button
		DR.ClickYesBTN();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		Thread.sleep(5000);

		//Clicking on the Profile Button
		l.ClickProfileBTN(driver);

		//Clikcing on the Logout Button
		l.ClickLogoutBTN();


		String un2=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw2=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un2);

		l.setpassword(pw2);

		//clicking on the Login Button
		l.ClickSigninBTN();

		System.out.println("*******************************************");


		//Clicking on the Defult Roles
		DR.ClickDefaultRole();
		chiledTest.log(Status.INFO, "Defult Role is Clicked");

		//Passing the Values to Deafult Role 
		String SD4 = Lib.getCellValue(XLPATH, "Default Role", 6, 0);
		DR.SetDefaultRole(SD4);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//Verifying Are You Sure ? Pop Up is Displayed
		DR.VerifyAreYouSurePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure ? Pop Up is Displayed");

		//Clicking on the No Button
		DR.ClickNoBTN();
		chiledTest.log(Status.INFO, "No Button is Clicked");

		//Clicking on the Defult Roles
		DR.ClickDefaultRole();
		chiledTest.log(Status.INFO, "Defult Role is Clicked");

		//Passing the Values to Deafult Role 
		String SD5 = Lib.getCellValue(XLPATH, "Default Role", 6, 0);
		DR.SetDefaultRole(SD5);

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

		//Verifying Are You Sure ? Pop Up is Displayed
		DR.VerifyAreYouSurePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are You Sure ? Pop Up is Displayed");

		//Clicking on The Yes Button
		DR.ClickYesBTN();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");

		Thread.sleep(5000);

		//Clicking on the Profile Button
		l.ClickProfileBTN(driver);

		//Clikcing on the Logout Button
		l.ClickLogoutBTN();


		String un3=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw3=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un3);

		l.setpassword(pw3);

		//clicking on the Login Button
		l.ClickSigninBTN();



	}
}

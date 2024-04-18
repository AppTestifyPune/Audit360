package scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditeeUserProfilePageTest;
import pom.LoginPageTest;

public class AuditeeUserProfilePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the  My Profile Page
	@Test(priority=0)
	public void Profile_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditeeUserProfilePageTest AUP = new AuditeeUserProfilePageTest(driver);

		parentTest = extent.createTest("Auditee User Profile Functionality Test", "Testing the My Profile Page, Edit Profile Test, etc..");

		chiledTest = parentTest.createNode("My Profile Page Test");

		System.out.println("My Profile Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",52,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",52,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Clicking on the Profile Icon
		l.ClickProfileBTN(driver);

		//Clicking on the MYProfile 
		AUP.ClickMyProfile();
		chiledTest.log(Status.INFO, "My Profile is Clicked");

		AUP.VerifyAddOrEditUserPageisDisplayed(driver);

		System.out.println("**********************************");
	}

	//Testing the functionality of My Profile Read only Fields
	@Test(priority=1)
	public void My_Profile_Read_Only_Mode_Fields_Test()
	{
		AuditeeUserProfilePageTest AUP = new AuditeeUserProfilePageTest(driver);

		chiledTest = parentTest.createNode("My Profile Read Only Mode Fields Test");

		System.out.println("My Profile Read Only Mode Fields Test");

		AUP.VerifyReadOnlyFieldsAreDisplayed();

		System.out.println("***************************");

	}

	//Testing the functionality of Update My Profile Test
	@Test(priority=2)
	public void Update_Profile_Test()
	{
		AuditeeUserProfilePageTest AUP = new AuditeeUserProfilePageTest(driver);

		chiledTest = parentTest.createNode("Update Profile Test");

		System.out.println("Update Profile Test");

		//Passing the Values to First Name
		String FN = Lib.getCellValue(XLPATH, "My Profile", 5, 0);
		AUP.SetFirstName(FN);

		//Passing the Values to Last Name
		String LN = Lib.getCellValue(XLPATH, "My Profile", 5, 1);
		AUP.SetLastName(LN);

		//Passing the Values to Mobile Number
		String SP = Lib.getCellValue(XLPATH, "My Profile", 3, 8);
		AUP.SetPhone(SP);

		//Passing the Values to Address
		String SA = Lib.getCellValue(XLPATH, "My Profile", 3, 9);
		AUP.SetAddress(SA);

		//Uploading the Photo
		AUP.SetPhoto(SP);

		//Clicking on the Submit Button
		AUP.ClickSubmitBTN(driver);

		//User Updated Successfully Message is Displayed
		AUP.VerifyUserUpdatedSuccessfullyMsgIsDisplayed(driver);

		System.out.println("***************************");
	}

	//Testing the Functionality of the edit My Profile Page
	@Test(priority=3, dependsOnMethods= {"Update_Profile_Test"})
	public void View_Profile_Test() throws InterruptedException
	{
		AuditeeUserProfilePageTest AUP = new AuditeeUserProfilePageTest(driver);
		
		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("View Profile Test");

		System.out.println("View Profile Test");

		//Clicking on the Profile Icon
		l.ClickProfileBTN(driver);

		//Clicking on the MYProfile 
		AUP.ClickMyProfile();
		chiledTest.log(Status.INFO, "My Profile is Clicked");

		AUP.VerifyUpdatedDetailsAreDisplayed();

		System.out.println("*********************************");

	}


}

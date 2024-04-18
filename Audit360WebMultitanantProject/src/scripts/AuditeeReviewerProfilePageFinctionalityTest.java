package scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AuditeeRespondentProfilePageTest;
import pom.AuditeeReviewerProfilePageTest;
import pom.LoginPageTest;

public class AuditeeReviewerProfilePageFinctionalityTest extends BaseTest{

	//Testing the Functionality of the  My Profile Page
	@Test(priority=0)
	public void Profile_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditeeReviewerProfilePageTest RP = new AuditeeReviewerProfilePageTest(driver);

		parentTest = extent.createTest("Auditee Reviewer Profile Functionality Test", "Testing the My Profile Page, Edit Profile Test, etc..");

		chiledTest = parentTest.createNode("My Profile Page Test");

		System.out.println("My Profile Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",68,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",68,1);
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
		RP.ClickMyProfile();
		chiledTest.log(Status.INFO, "My Profile is Clicked");

		RP.VerifyAddOrEditUserPageisDisplayed(driver);

		System.out.println("**********************************");
	}

	//Testing the functionality of My Profile Read only Fields
	@Test(priority=1)
	public void My_Profile_Read_Only_Mode_Fields_Test()
	{
		AuditeeReviewerProfilePageTest RP = new AuditeeReviewerProfilePageTest(driver);

		chiledTest = parentTest.createNode("My Profile Read Only Mode Fields Test");

		System.out.println("My Profile Read Only Mode Fields Test");

		RP.VerifyReadOnlyFieldsAreDisplayed();

		System.out.println("***************************");

	}

	//Testing the functionality of Update My Profile Test
	@Test(priority=2)
	public void Update_Profile_Test()
	{
		AuditeeReviewerProfilePageTest RP = new AuditeeReviewerProfilePageTest(driver);

		chiledTest = parentTest.createNode("Update Profile Test");

		System.out.println("Update Profile Test");

		//Passing the Values to First Name
		String FN = Lib.getCellValue(XLPATH, "My Profile", 7, 0);
		RP.SetFirstName(FN);

		//Passing the Values to Last Name
		String LN = Lib.getCellValue(XLPATH, "My Profile", 7, 1);
		RP.SetLastName(LN);

		//Passing the Values to Mobile Number
		String SP = Lib.getCellValue(XLPATH, "My Profile", 3, 8);
		RP.SetPhone(SP);

		//Passing the Values to Address
		String SA = Lib.getCellValue(XLPATH, "My Profile", 3, 9);
		RP.SetAddress(SA);

		//Uploading the Photo
		RP.SetPhoto(SP);

		//Clicking on the Submit Button
		RP.ClickSubmitBTN(driver);

		//User Updated Successfully Message is Displayed
		RP.VerifyUserUpdatedSuccessfullyMsgIsDisplayed(driver);

		System.out.println("***************************");
	}

	//Testing the Functionality of the edit My Profile Page
	@Test(priority=3, dependsOnMethods= {"Update_Profile_Test"})
	public void View_Profile_Test() throws InterruptedException
	{
		AuditeeReviewerProfilePageTest RP = new AuditeeReviewerProfilePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("View Profile Test");

		System.out.println("View Profile Test");

		//Clicking on the Profile Icon
		l.ClickProfileBTN(driver);

		//Clicking on the MYProfile 
		RP.ClickMyProfile();
		chiledTest.log(Status.INFO, "My Profile is Clicked");

		RP.VerifyUpdatedDetailsAreDisplayed();

		System.out.println("*********************************");

	}


}

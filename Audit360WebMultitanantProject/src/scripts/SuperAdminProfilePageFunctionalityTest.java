package scripts;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.SuperAdminProfilePageTest;

public class SuperAdminProfilePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the My Profile Page
	@Test(priority=1)
	public void MyProfile_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		SuperAdminProfilePageTest SAP = new SuperAdminProfilePageTest(driver);

		parentTest = extent.createTest("Super Admin Profile Functionality Test", "Testing the My Profile Page, Edit Profile Test, etc..");

		chiledTest = parentTest.createNode("My Profile Page Test");

		System.out.println("My Profile Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
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
		SAP.ClickMyProfile();
		chiledTest.log(Status.INFO, "My Profile is Clicked");

		//Verifying Add/Edit User Page is Displayed
		SAP.VerifyAddOrEditUserPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add/Edit User Page is Displayed");

		System.out.println("***************************************************************");

	}

	//Testing the Functionality of the edit My Profile Page
	@Test(priority=2)
	public void MyProfile_Mandatory_Field_Test() throws InterruptedException
	{

		SuperAdminProfilePageTest SAP = new SuperAdminProfilePageTest(driver);

		chiledTest = parentTest.createNode("My Profile Mandatory Fields Test");

		System.out.println("My Profile Mandatory Fields Test");

		//Checking Mandatory fields are Displayed
		SAP.VerifyMandtatoryFieldsIsDisplayed(driver);

		System.out.println("**************************");

	}

	//Testing the Functionality of the edit My Profile Page
	@Test(priority=3)
	public void Profile_Update_Test() throws InterruptedException
	{
		SuperAdminProfilePageTest SAP = new SuperAdminProfilePageTest(driver);

		chiledTest = parentTest.createNode("Profile Update Test");

		System.out.println("Profile Update Test");

		//Passing the Values to First Name
		String FN = Lib.getCellValue(XLPATH, "My Profile", 3, 0);
		SAP.SetFirstName(FN);

		//Passing the Values to Last Name
		String LN = Lib.getCellValue(XLPATH, "My Profile", 3, 1);
		SAP.SetLastName(LN);

		SAP.ClearRoles();

		//Passing the Values to Roles
		String SR = Lib.getCellValue(XLPATH, "My Profile", 3, 3);
		SAP.SetRoles(SR);

		SAP.ClickMatched();

		//Passing the Values to Roles
		String SR1 = Lib.getCellValue(XLPATH, "My Profile", 4, 3);
		SAP.SetRoles(SR1);

		SAP.ClickMatched();

		//Passing the Values to Roles
		String SR2 = Lib.getCellValue(XLPATH, "My Profile", 5, 3);
		SAP.SetRoles(SR2);

		SAP.ClickMatched();

		//Passing the Values to Roles
		String SR4 = Lib.getCellValue(XLPATH, "My Profile", 7, 3);
		SAP.SetRoles(SR4);

		SAP.ClickMatched();

		//Passing the Values to Country
		String SC = Lib.getCellValue(XLPATH, "My Profile", 3, 4);
		SAP.SetCountryOption(SC);

		SAP.ClickMatched();

		//Passing the Values to Time Zone
		String TZ = Lib.getCellValue(XLPATH, "My Profile", 3, 5);
		SAP.SetTimeZone(TZ);

		SAP.ClickMatched();

		//Clearing all Selected Cluster
		SAP.ClearCluster();

		//Passing the Values to Cluster
		String CL = Lib.getCellValue(XLPATH, "My Profile", 3, 6);
		SAP.SetCluster(CL);

		//Passing the Values to Cluster
		String CL1 = Lib.getCellValue(XLPATH, "My Profile", 4, 6);
		SAP.SetCluster(CL1);

		//Clearing all Selected Auditee
		SAP.ClearAuditee();

		//Passing the Values to Cluster
		String AU = Lib.getCellValue(XLPATH, "My Profile", 3, 7);
		SAP.SetAuditee(AU);

		//Passing the Values to Cluster
		String AU1 = Lib.getCellValue(XLPATH, "My Profile", 4, 7);
		SAP.SetAuditee(AU1);

		//Passing the Values to Phone Number
		String SP = Lib.getCellValue(XLPATH, "My Profile", 3, 8);
		SAP.SetPhone(SP);

		//Passing the Values to Address
		String SA = Lib.getCellValue(XLPATH, "My Profile", 3, 9);
		SAP.SetAddress(SA);

		//Passing the Values to State
		String ST = Lib.getCellValue(XLPATH, "My Profile", 3, 10);
		SAP.SetState(ST);

		//Passing the Values to City
		String CT = Lib.getCellValue(XLPATH, "My Profile", 3, 11);
		SAP.SetCity(CT);

		//Passing the Values to ZipCode
		String ZC = Lib.getCellValue(XLPATH, "My Profile", 3, 12);
		SAP.SetZipCode(ZC);

		//Passing the Values to Area
		String AR = Lib.getCellValue(XLPATH, "My Profile", 3, 13);
		SAP.SetArea(AR);

		//Passing the Values to Region
		String RG = Lib.getCellValue(XLPATH, "My Profile", 3, 14);
		SAP.SetRegion(RG);

		//Passing the Values to Zone
		String ZO = Lib.getCellValue(XLPATH, "My Profile", 3, 15);
		SAP.SetZone(ZO);


		//clicking on the Male Radio Button
		SAP.ClickMaleRadioButton();

		//Passing the Values to DOB
		String DOB = Lib.getCellValue(XLPATH, "My Profile", 3, 16);
		SAP.SetDateOfBirth(DOB);

		//Clearing all Selected Options under Qualifications
		SAP.ClearQualifications();

		//Selecting All Options Under Qualifications
		SAP.SetQualifications();

		//Clearing all Selected Options under Specialization
		SAP.ClearSpecializations();

		//Selecting All Options Under Specialization
		SAP.SetSpecializations();

		//Uploading Photo
		SAP.SetPhoto(SP);;

		//Clicking on the Submit Button
		SAP.ClickSubmitBTN(driver);

		//Verifying User updated successfully! Success Message is Displayed
		SAP.VerifyUserUpdatedSuccessfullyMsgIsDisplayed(driver);

		System.out.println("***************************************************************");

	}

	//Testing the Functionality of the edit My Profile Page
	@Test(priority=4, dependsOnMethods= {"Profile_Update_Test"})
	public void View_Profile_Test() throws InterruptedException
	{
		SuperAdminProfilePageTest SAP = new SuperAdminProfilePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("View Profile Test");

		System.out.println("View Profile Test");

		//Clicking on the Profile Icon
		l.ClickProfileBTN(driver);

		//Clicking on the MYProfile 
		SAP.ClickMyProfile();
		chiledTest.log(Status.INFO, "My Profile is Clicked");

		SAP.VerifyUpdatedDetailsAreDisplayed();

	}

}

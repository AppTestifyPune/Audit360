package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.SuperAdminProfilePageTest;
import pom.UserManagementPageTest;

public class UserManagementPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Manage User Page Test
	@Test(priority=1)
	public void Manage_User_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		UserManagementPageTest UM = new UserManagementPageTest(driver);

		parentTest = extent.createTest("User Management Functionality Test", "Testing the Manage User Page, Add User Test, List User Test, Search User Test, etc..");

		chiledTest = parentTest.createNode("Manage User Page Test");

		System.out.println("Manage User Page Test");

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
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

		//clicking on Scroll Bar Under side menu
		UM.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		UM.ClickUserManagement(driver);
		chiledTest.log(Status.INFO, "User Management is Clicked");

		//Checking Manage User Page is Displayed 
		//UM.VerifyManageUserPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Manage User Page is Displayed");

		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Manage User Page Test
	@Test(priority=2, dependsOnMethods= {"Manage_User_Page_Test"})
	public void Add_User_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Add User Test");

		System.out.println("Add User Test");

		//Clicking on the Add User Button
		UM.ClickAddUserBTN(driver);
		chiledTest.log(Status.INFO, "Add User Button is Clicked");

		//Verifying Add/edit User page is Displayed
		UM.VerifyAddOrEditUserPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add/Edit User Page is Displayed");

		//Passing the Values to First name
		String FN = Lib.getCellValue(XLPATH, "User Management", 3, 0);
		UM.SetFirstName(FN);
		chiledTest.log(Status.INFO, "First Name is Entered");

		//Passing the Values to Email Id
		String EI = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetEmailId(EI);
		chiledTest.log(Status.INFO, "Email Id is Entered");

		//Clicking on the Country
		UM.ClickCountry();

		//Selecting Country Option
		String SC = Lib.getCellValue(XLPATH, "User Management", 16, 0);
		UM.SetCountryOption(SC);
		chiledTest.log(Status.INFO, "Country is Selected");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Last Name
		String LN = Lib.getCellValue(XLPATH, "User Management", 20, 0);
		UM.SetLastName(LN);
		chiledTest.log(Status.INFO, "Last Name is Entered");

		//Passing the Values to Role
		String RO5 = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		UM.SetRoletext(RO5);
		chiledTest.log(Status.INFO, "Role is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Time zone
		UM.ClickTimeZone();

		//Passing the Values to Time Zone
		String TZ = Lib.getCellValue(XLPATH, "User Management", 36, 0);
		UM.SetTimezone(TZ);
		chiledTest.log(Status.INFO, "Time Zone is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Add/Edit Clusters/Auditees button
		UM.ClickAddEditClustersAuditeesBTN();
		chiledTest.log(Status.INFO, "Add/Edit Clusters/Auditees button is Clicked");

		//Passing the Values to Cluster
		String CS = Lib.getCellValue(XLPATH, "User Management", 41, 0);
		UM.SetCluster(CS);
		chiledTest.log(Status.INFO, "Cluster is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Cluster
		String CS1 = Lib.getCellValue(XLPATH, "User Management", 42, 0);
		UM.SetCluster(CS1);
		chiledTest.log(Status.INFO, "Cluster is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Auditee
		String SA = Lib.getCellValue(XLPATH, "User Management", 31, 0);
		UM.SetAuditee(SA, driver);
		chiledTest.log(Status.INFO, "Auditee is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Auditee
		String SA1 = Lib.getCellValue(XLPATH, "User Management", 32, 0);
		UM.SetAuditee(SA1, driver);
		chiledTest.log(Status.INFO, "Auditee is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//clicking on the Done button
		UM.ClickDoneButton();
		chiledTest.log(Status.INFO, "Done button is Clicked");

		//Passing the Login ID
		String LI = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetLoginID(LI);
		chiledTest.log(Status.INFO, "Login ID is Entered");

		//Passing the Values to Phone
		String SP = Lib.getCellValue(XLPATH, "User Management", 48, 0);
		UM.SetPhone(SP);
		chiledTest.log(Status.INFO, "Phone Number is Entered");

		//Passing the Values to Address 
		String SA2 = Lib.getCellValue(XLPATH, "User Management", 53, 0);
		UM.SetAddress(SA2);
		chiledTest.log(Status.INFO, "Address is Entered");

		//Clicking on the State
		UM.ClickState();

		//Passing the Values to State
		String SS = Lib.getCellValue(XLPATH, "User Management", 58, 0);
		UM.SetState(SS);
		chiledTest.log(Status.INFO, "State is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the City
		UM.ClickCity();

		//Passing the Values to City
		String SC1 = Lib.getCellValue(XLPATH, "User Management", 62, 0);
		UM.SetCity(SC1);
		chiledTest.log(Status.INFO, "City is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the zip code
		UM.ClickZipCode();

		//Passing the Values to Zip code
		String SZ = Lib.getCellValue(XLPATH, "User Management", 66, 0);
		UM.SetZipCode(SZ);
		chiledTest.log(Status.INFO, "zip code is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Area
		UM.ClickArea();

		//Passing the Values to Area
		String AR = Lib.getCellValue(XLPATH, "User Management", 71, 0);
		UM.SetArea(AR);
		chiledTest.log(Status.INFO, "Area is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Region
		UM.ClickRegion();

		//Passing the Values to Region
		String SR = Lib.getCellValue(XLPATH, "User Management", 76, 0);
		UM.SetRegion(SR);
		chiledTest.log(Status.INFO, "Region is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Zone
		UM.ClickZone();

		//Passing the Values to Zone
		String SZ1 = Lib.getCellValue(XLPATH, "User Management", 81, 0);
		UM.SetZone(SZ1);
		chiledTest.log(Status.INFO, "Zone is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Male Gender
		UM.ClickMale();
		chiledTest.log(Status.INFO, "Gender is Selected");

		//Passing the Values to DOB
		String DB = Lib.getCellValue(XLPATH, "User Management", 86, 0);
		UM.SetDOB(DB);
		chiledTest.log(Status.INFO, "Date of Birth is Entered");

		//Passing the Values to Qualifications
		String QF1 = Lib.getCellValue(XLPATH, "User Management", 107, 0);
		UM.SetQualification(QF1);
		chiledTest.log(Status.INFO, "Qualifications is Entered");

		//Passing the Values to Qualifications
		String QF2 = Lib.getCellValue(XLPATH, "User Management", 108, 0);
		UM.SetQualification(QF2);
		chiledTest.log(Status.INFO, "Qualifications is Entered");

		//Selecting all Options under Specialization
		UM.SetSpecialization();

		//Passing the Values to Training
		String TT = Lib.getCellValue(XLPATH, "User Management", 119, 0);
		UM.SetTraining(TT);
		chiledTest.log(Status.INFO, "Training is Entered");

		//Passing the Values to Certification
		String CF = Lib.getCellValue(XLPATH, "User Management", 125, 0);
		UM.SetCertification(CF);
		chiledTest.log(Status.INFO, "Certification is Entered");

		//Uploading the Photo
		UM.UplaodPhotowithLessThan500KB(SP);
		chiledTest.log(Status.INFO, "Photo is Uploaded");

		//Clicking on the Submit Button'
		UM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying the User created successfully! Message is Displayed
		UM.VerifyUserCreatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User created successfully! Message is Displayed");


		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Manage User Page Test
	@Test(priority=3, dependsOnMethods= {"Add_User_Test"})
	public void Adding_Same_User_With_Same_EmailId_Test() throws InterruptedException
	{

		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Adding Same User with Same Emailid Test");

		System.out.println("Adding Same User with Same Emailid Test");

		//Clicking on the Add User Button
		UM.ClickAddUserBTN(driver);
		chiledTest.log(Status.INFO, "Add User Button is Clicked");

		//Verifying Add/edit User page is Displayed
		UM.VerifyAddOrEditUserPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add/Edit User Page is Displayed");

		//Passing the Values to First name
		String FN = Lib.getCellValue(XLPATH, "User Management", 3, 0);
		UM.SetFirstName(FN);
		chiledTest.log(Status.INFO, "First Name is Entered");

		//Passing the Values to Email Id
		String EI = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetEmailId(EI);
		chiledTest.log(Status.INFO, "Email Id is Entered");

		//clicking on the Country
		UM.ClickCountry();

		//Selecting Country Option
		String SC = Lib.getCellValue(XLPATH, "User Management", 16, 0);
		UM.SetCountryOption(SC);
		chiledTest.log(Status.INFO, "Country is Selected");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Last Name
		String LN = Lib.getCellValue(XLPATH, "User Management", 20, 0);
		UM.SetLastName(LN);
		chiledTest.log(Status.INFO, "Last Name is Entered");

		//Passing the Values to Role
		String RO5 = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		UM.SetRoletext(RO5);
		chiledTest.log(Status.INFO, "Role is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Time zone
		UM.ClickTimeZone();

		//Passing the Values to Time Zone
		String TZ = Lib.getCellValue(XLPATH, "User Management", 36, 0);
		UM.SetTimezone(TZ);
		chiledTest.log(Status.INFO, "Time Zone is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Add/Edit Clusters/Auditees button
		UM.ClickAddEditClustersAuditeesBTN();
		chiledTest.log(Status.INFO, "Add/Edit Clusters/Auditees button is Clicked");

		//Passing the Values to Cluster
		String CS = Lib.getCellValue(XLPATH, "User Management", 41, 0);
		UM.SetCluster(CS);
		chiledTest.log(Status.INFO, "Cluster is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Cluster
		String CS1 = Lib.getCellValue(XLPATH, "User Management", 42, 0);
		UM.SetCluster(CS1);
		chiledTest.log(Status.INFO, "Cluster is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Auditee
		String SA = Lib.getCellValue(XLPATH, "User Management", 31, 0);
		UM.SetAuditee(SA, driver);
		chiledTest.log(Status.INFO, "Auditee is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Auditee
		String SA1 = Lib.getCellValue(XLPATH, "User Management", 32, 0);
		UM.SetAuditee(SA1, driver);
		chiledTest.log(Status.INFO, "Auditee is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//clicking on the Done button
		UM.ClickDoneButton();
		chiledTest.log(Status.INFO, "Done button is Clicked");

		//Passing the Login ID
		String LI = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetLoginID(LI);
		chiledTest.log(Status.INFO, "Login ID is Entered");

		//Passing the Values to Phone
		String SP = Lib.getCellValue(XLPATH, "User Management", 48, 0);
		UM.SetPhone(SP);
		chiledTest.log(Status.INFO, "Phone Number is Entered");

		//Passing the Values to Address 
		String SA2 = Lib.getCellValue(XLPATH, "User Management", 53, 0);
		UM.SetAddress(SA2);
		chiledTest.log(Status.INFO, "Address is Entered");

		//Clicking on the State
		UM.ClickState();

		//Passing the Values to State
		String SS = Lib.getCellValue(XLPATH, "User Management", 58, 0);
		UM.SetState(SS);
		chiledTest.log(Status.INFO, "State is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the City
		UM.ClickCity();

		//Passing the Values to City
		String SC1 = Lib.getCellValue(XLPATH, "User Management", 62, 0);
		UM.SetCity(SC1);
		chiledTest.log(Status.INFO, "City is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the zip code
		UM.ClickZipCode();

		//Passing the Values to Zip code
		String SZ = Lib.getCellValue(XLPATH, "User Management", 66, 0);
		UM.SetZipCode(SZ);
		chiledTest.log(Status.INFO, "zip code is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Area
		UM.ClickArea();

		//Passing the Values to Area
		String AR = Lib.getCellValue(XLPATH, "User Management", 71, 0);
		UM.SetArea(AR);
		chiledTest.log(Status.INFO, "Area is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Region
		UM.ClickRegion();

		//Passing the Values to Region
		String SR = Lib.getCellValue(XLPATH, "User Management", 76, 0);
		UM.SetRegion(SR);
		chiledTest.log(Status.INFO, "Region is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Zone
		UM.ClickZone();

		//Passing the Values to Zone
		String SZ1 = Lib.getCellValue(XLPATH, "User Management", 81, 0);
		UM.SetZone(SZ1);
		chiledTest.log(Status.INFO, "Zone is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Male Gender
		UM.ClickMale();
		chiledTest.log(Status.INFO, "Gender is Selected");

		//Passing the Values to DOB
		String DB = Lib.getCellValue(XLPATH, "User Management", 86, 0);
		UM.SetDOB(DB);
		chiledTest.log(Status.INFO, "Date of Birth is Entered");

		//Passing the Values to Qualifications
		String QF1 = Lib.getCellValue(XLPATH, "User Management", 107, 0);
		UM.SetQualification(QF1);
		chiledTest.log(Status.INFO, "Qualifications is Entered");

		//Passing the Values to Qualifications
		String QF2 = Lib.getCellValue(XLPATH, "User Management", 108, 0);
		UM.SetQualification(QF2);
		chiledTest.log(Status.INFO, "Qualifications is Entered");

		//Selecting all Options under Specialization
		UM.SetSpecialization();

		//Passing the Values to Training
		String TT = Lib.getCellValue(XLPATH, "User Management", 119, 0);
		UM.SetTraining(TT);
		chiledTest.log(Status.INFO, "Training is Entered");

		//Passing the Values to Certification
		String CF = Lib.getCellValue(XLPATH, "User Management", 125, 0);
		UM.SetCertification(CF);
		chiledTest.log(Status.INFO, "Certification is Entered");

		//Uploading the Photo
		UM.UplaodPhotowithLessThan500KB(SP);
		chiledTest.log(Status.INFO, "Photo is Uploaded");

		//Clicking on the Submit Button'
		UM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying the Email has already been taken  Message is Displayed
		UM.VerifyEmailHasAlreadyBeenTakenMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Login has already been taken  Message is Displayed");


		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Search User
	@Test(priority=4, dependsOnMethods= {"Adding_Same_User_With_Same_EmailId_Test"})
	public void Search_User_Test() throws InterruptedException
	{

		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Search User Test");

		System.out.println("Search User Test");

		//Clicking on the header
		UM.ClickManageUserHeader(driver);

		//Passing the Values to Search Button
		String SB = Lib.getCellValue(XLPATH, "User Management", 91, 0);
		UM.SetSerachBTN(SB);
		chiledTest.log(Status.INFO, "User Which is Not Exists in the DB is Searched");

		//Verifying No data available in table
		UM.VerifyNoDataAvailableInTableMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "No data available in table Message is Displayed");

		//Passing the Values to Serach Button
		String SB1 = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetSerachBTN(SB1);
		chiledTest.log(Status.INFO, "User is Searched");

		Thread.sleep(3000);
		WebElement Name = driver.findElement(By.xpath("//td[@class='sorting_1']"));
		String Expected_text = SB1;
		String Actual_text = Name.getText();
		Assert.assertEquals(Expected_text, Actual_text);

		//Verifying Searched User is Displayed
		UM.VerifyUserIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Searched User is Displayed");

		System.out.println("***************************************************");


	}

	//Testing the Functionality of the Search User
	@Test(priority=5, dependsOnMethods= {"Search_User_Test"})
	public void View_User_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("View User Test");

		System.out.println("View User Test");

		driver.navigate().refresh();

		//Clicking on the View User Button
		UM.ClickViewBTN(driver);
		chiledTest.log(Status.INFO, "View User Button is Clicked");

		//Verify User details page is displayed
		UM.VerifyUserDetailsPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User Details Page is Displayed");

		//Clicking on the Close Button
		UM.ClickCloseBTN(driver);


		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Resend Confirmation Mail Test
	@Test(priority=6, dependsOnMethods= {"View_User_Test"})
	public void Resend_Confirmation_Mail_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Resend Confirmation Mail Test");

		System.out.println("Resend Confirmation Mail Test");

		driver.navigate().refresh();

		//Clicking on the Re send Confirmation Mail Button
		UM.ClickResedUserBTN(driver);
		chiledTest.log(Status.INFO, "Resend Mail Button is Clicked");

		//Verifying the Re send Confirmation Mail Pop Up is Displayed
		UM.VerifyResendConfirmationMailPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Resend Confirmation Mail Pop Up is Displayed");

		//Clicking on the OK Button
		UM.ClickOKBTN(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Verifying the Mail sent successfully Success Message is Displayed
		UM.VerifyMailSentSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Mail sent successfully Success Message is Displayed");


		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Edit User 
	@Test(priority=7, dependsOnMethods= {"Resend_Confirmation_Mail_Test"})
	public void Edit_User_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Edit User Test");

		System.out.println("Edit User Test");

		//Clicking on the Edit Button
		UM.ClickEditBTN(driver);
		chiledTest.log(Status.INFO, "Edit Button is Clicked");

		//Verifying Add/edit User page is Displayed
		UM.VerifyAddOrEditUserPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add/Edit User Page is Displayed");

		//Passing the Values to Phone
		String SP = Lib.getCellValue(XLPATH, "User Management", 49, 0);
		UM.SetPhone(SP);
		chiledTest.log(Status.INFO, "Phone Number is Entered");

		//Passing the Values to Address 
		String SA = Lib.getCellValue(XLPATH, "User Management", 54, 0);
		UM.SetAddress(SA);
		chiledTest.log(Status.INFO, "Address is Entered");

		//Passing the Values to DOB
		String DB = Lib.getCellValue(XLPATH, "User Management", 80, 0);
		UM.SetDOB(DB);
		chiledTest.log(Status.INFO, "Date of Birth is Entered");

		//Uploading Photo
		UM.UplaodPhoto(SP);
		chiledTest.log(Status.INFO, "Photo is Uploaded");

		//Clicking on the Submit Button
		UM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying User updated successfully! Message is Displayed
		UM.VerifyUserUpdatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User updated successfully! Message is Displayed");

		System.out.println("***************************************************");


	}

	//Testing the functionality of the Not Confirmed User Login
	@Test(priority=8, dependsOnMethods= {"Edit_User_Test"}, enabled=false)
	public void Not_Confirmed_User_Login_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Not Confirmed User Login Test");

		System.out.println("Not Confirmed User Login Test");

		//clicking on the profile button
		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		String un=Lib.getCellValue(XLPATH, "User Management",7,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",75,0);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		//Verifying Signed in successfully. Success Message is Displayed
		UM.VerifyYouHaveToConfirmYourEmailAddressBeforeContinuingMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "You have to confirm your email address before continuing. Success Message is Displayed");


		System.out.println("*****************************************************************");


	}

	//Testing the Functionality of the Confirm User
	@Test(priority=9, dependsOnMethods= {"Edit_User_Test"})
	public void confirm_User_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Confirm User Test");

		System.out.println("Confirm User Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
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

		//clicking on Scroll Bar Under side menu
		UM.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		UM.ClickUserManagement(driver);
		chiledTest.log(Status.INFO, "User Management is Clicked");

		//Passing the Values to Search Button
		String SB = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetSerachBTN(SB);
		chiledTest.log(Status.INFO, "User is Searched");

		//Clicking on the Confirm User Button
		UM.ClickConfirmUserBTN(driver);
		chiledTest.log(Status.INFO, "Confirm User Button is Clicked");

		//Verifying the User Confirm Pop Up is Displayed
		UM.VerifyUserConfirmPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User Confirm Pop Up is Displayed");

		//Clicking on the OK Button
		UM.ClickOKBTN(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Verifying User Confirmed Successfully Message is Displayed
		UM.VerifyUserConfirmedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User Confirmed Successfully Message is Displayed");

		System.out.println("***************************************************");

	}

	//Testing the functionality of the Not Confirmed User Login
	@Test(priority=10, dependsOnMethods= {"confirm_User_Test"}, enabled=false)
	public void Confirmed_User_Login_Test() throws InterruptedException{

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Confirmed User Login Test");

		System.out.println("Confirmed User Login Test");

		//clicking on the profile button
		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "User Management",7,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",75,0);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Login Button is Clicked");

		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in Success Message is Displayed");

		//Verifying Home Page Title of the page
		l.VerifyHomePageTitle(driver);
		chiledTest.log(Status.INFO, "Home Page Title is Displayed");

		//Checking the Logo is Displayed or Not under header 
		WebElement Logo = driver.findElement(By.xpath("//div[@class='brand inline m-l-100']/img[1]"));
		Assert.assertTrue(Logo.isEnabled(), "Logo is not Displayed");
		System.out.println("Pass : Logo is Dispalyed");
		chiledTest.log(Status.INFO, "Logo is Dispalyed");

		//Checking the Audit 360 Sign is Displayed or Not under header 
		WebElement Audit360 = driver.findElement(By.xpath("//div[@class='brand inline m-l-100']/img[2]"));
		Assert.assertTrue(Audit360.isEnabled(), "Audit 360 Sign is not Displayed");
		System.out.println("Pass : Audit 360 Sign is Dispalyed");
		chiledTest.log(Status.INFO, "Audit 360 Sign is Dispalyed");

		//Checking the Selected Time zone: Chennai, India (UTC +05:30) is Displayed
		WebElement TimeZone = driver.findElement(By.xpath("//label[contains(text(),'Timezone: Chennai, India (UTC +05:30)')]"));
		Assert.assertTrue(TimeZone.isEnabled(), "Audit 360 Sign is not Displayed");
		System.out.println("Pass : TimeZone Chennai, India (UTC +05:30) is Dispalyed");
		chiledTest.log(Status.INFO, "TimeZone Chennai, India (UTC +05:30) is Dispalyed");

		//Checking the Select Default role drop down is displayed or not
		WebElement DefaultRole = driver.findElement(By.xpath("//div[@class='form-group form-group-default form-group-default-select2 default_roles']/label[text()='Default Role']"));
		Assert.assertTrue(DefaultRole.isEnabled(), "Default Role Drop Down is not Displayed");
		System.out.println("Pass : Default Role Drop Down is Dispalyed");
		chiledTest.log(Status.INFO, "Default Role Drop Down is Dispalyed");

		//Checking Select Default role Option is Selected Under Default role drop down list
		WebElement SelectDefaultRoleOption = driver.findElement(By.xpath("//select[@id='default_roles']/option[text()='Select Default Role']"));
		Assert.assertTrue(SelectDefaultRoleOption.isSelected(), "Select Default Role option is not Selected under Default role drop down");
		System.out.println("Pass :Select Default Role option is Selected under Default role drop down");
		chiledTest.log(Status.INFO, "Select Default Role option is Selected under Default role drop down");

		//Checking the Select Switch role drop down is displayed or Not
		WebElement SwitchRole = driver.findElement(By.xpath("//div[@class='form-group form-group-default form-group-default-select2 default_roles']/label[text()='Switch Role']"));
		Assert.assertTrue(SwitchRole.isEnabled(), "Switch Role Drop Down is not Displayed");
		System.out.println("Pass : Switch Role Drop Down is Dispalyed");
		chiledTest.log(Status.INFO, "Switch Role Drop Down is Dispalyed");

		//Checking Select Default role Option is Selected Under Switch role drop down list
		WebElement SelectRoleOption = driver.findElement(By.xpath("//select[@id='swith_roles']/option[text()='Select Role']"));
		Assert.assertTrue(SelectRoleOption.isSelected(), "Select Role option is not Selected under Switch role drop down");
		System.out.println("Pass :Select Role option is Selected under Switch role drop down");
		chiledTest.log(Status.INFO, "Select Role option is Selected under Switch role drop down");

		//dash board should not be display
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> Dashboard = driver.findElements(By.xpath("//a[@class='active']"));
		Assert.assertTrue(Dashboard.size()<=0, "For New User Dashboard is Displayed");
		System.out.println("Pass : Dashboard is not displayed");
		chiledTest.log(Status.INFO, "Dashboard is not displayed");

		System.out.println("*****************************************************************");


	}

	//Testing the Functionality of the Deactivate User Test
	@Test(priority=11,dependsOnMethods= {"confirm_User_Test"})
	public void Deactivate_User_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Deactivate User Test");

		System.out.println("Deactivate User Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

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


		//clicking on Scroll Bar Under side menu
		UM.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		UM.ClickUserManagement(driver);
		chiledTest.log(Status.INFO, "User Management is Clicked");

		//Passing the Values to Search Button
		String SB = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetSerachBTN(SB);
		chiledTest.log(Status.INFO, "User is Searched");

		//Clicking on the Deactivate Button
		UM.ClickDeactivateBTN(driver);
		chiledTest.log(Status.INFO, "Deactivate Button is Clicked");

		//Verifying the User Deactivate Pop up Message is Displayed
		UM.VerifyUserDeactivatePopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User Deactivate Pop Up is Displayed");

		//Clicking on the Others Option Under Reason
		UM.ClickOthers();
		chiledTest.log(Status.INFO, "Others Option is Selected");

		//Passing the Values to Reason Text Field
		String SR = Lib.getCellValue(XLPATH, "User Management", 96, 0);
		UM.SetReason(SR, driver);
		chiledTest.log(Status.INFO, "Reason is Entered");

		//Clicking on the OK Button
		UM.ClickOKBTN(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Verifying User deactivated successfully Message is Displayed
		UM.VerifyUserDeactivatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User deactivated successfully Success Message is Displayed");

		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Deactivate User View Test
	@Test(priority=12,dependsOnMethods= {"Deactivate_User_Test"})
	public void Deactivated_User_View_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Deactivated User View Test");

		System.out.println("Deactivated User View Test");

		//Clicking on the View Button
		UM.ClickViewBTN(driver);
		chiledTest.log(Status.INFO, "View Button is Clicked");

		//Verify User details page is displayed
		UM.VerifyUserDetailsPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User Details Page is Displayed");
		chiledTest.log(Status.INFO, "DE ACTIVE HISTORY is Displayed");

		//Clicking on the Close Button
		UM.ClickCloseBTN(driver);

		System.out.println("***************************************************");

	}


	//Testing the Functionality of the Deactivated User Login Test
	@Test(priority=13, dependsOnMethods= {"Deactivate_User_Test"}, enabled=false)
	public void De_Activated_User_Login_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("De-Activated User Login Test");

		System.out.println("De-Activated User Login Test");

		Thread.sleep(2000);

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "User Management",7,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",75,0);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Your account has been deactivated. If you think this is not in order kindly contact your administrator Message is Displayed
		UM.VerifyYourAccountHasBeenDeactivated(driver);
		chiledTest.log(Status.INFO, "Your account has been deactivated. If you think this is not in order kindly contact your administrator. Message is Displayed");


		System.out.println("******************************************************************");
	}


	//Testing the Functionality of the Deactivate User View Test
	@Test(priority=14, dependsOnMethods= {"De_Activated_User_Login_Test"}, enabled=false)
	public void Activate_User_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Activate User Test");

		System.out.println("Activate User Test");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);

		l.setusername(un);

		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		l.verifySignedInSuccessMsgIsDisplayed(driver);

		//clicking on Scroll Bar Under side menu
		UM.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		UM.ClickUserManagement(driver);
		chiledTest.log(Status.INFO, "User Management is Clicked");

		//Passing the Values to Search Button
		String SB = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetSerachBTN(SB);
		chiledTest.log(Status.INFO, "User is Searched");

		//Clicking on the Edit Button
		UM.ClickEditBTN(driver);
		chiledTest.log(Status.INFO, "Edit Button is Clicked");

		//Verifying Add/edit User page is Displayed
		UM.VerifyAddOrEditUserPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add/Edit User Page is Displayed");

		//Clicking on the Activate Button
		UM.ClickActivateBTN();
		chiledTest.log(Status.INFO, "Activate Button is Clicked");

		//Checking the Activate Button is Selected
		UM.VerifyActivateButtonIsSelected(driver);


		System.out.println("***************************************************");


	}

	//Testing the Functionality of the Deactivate User View Test
	@Test(priority=15, dependsOnMethods= {"Deactivated_User_View_Test"})
	public void Unlock_User_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Unlock User Test");

		System.out.println("Unlock User Test");

		chiledTest = parentTest.createNode("Activate User Test");

		System.out.println("Activate User Test");

		UM.ClickManageUserHeader(driver);

		//Passing the Values to Search Button
		String SB = Lib.getCellValue(XLPATH, "Login Credentials", 26, 0);
		UM.SetSerachBTN(SB);
		chiledTest.log(Status.INFO, "User is Searched");

		//Clicking on the Unlock User button
		UM.ClickUnlockButton(driver);
		chiledTest.log(Status.INFO, "Unlock User Button is Clicked");

		//Verifying User Unlock Pop Up is Displayed
		UM.VerifyUserUnlockPopupIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User Unlock Pop Up is Displayed");

		//Clicking on the OK Button
		UM.ClickOKBTN(driver);
		chiledTest.log(Status.INFO, "OK Button is Clicked");

		//Verifying User unlocked successfully Success Message is Displayed
		UM.VerifyUserUnlockedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User unlocked successfully Success Message is Displayed");

		System.out.println("***************************************************");

	}

	//Testing the Functionality of the Mandatory Field Test
	@Test(priority=16, dependsOnMethods= {"Unlock_User_Test"})
	public void Add_User_Mandatory_Fields_Test() throws InterruptedException
	{
		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Add User Mandatory Fields Test");

		System.out.println("Add User Mandatory Fields Test");

		//Clicking on the Manage User Header
		UM.ClickManageUserHeader(driver);

		//Clicking on the Add User Button
		UM.ClickAddUserBTN(driver);

		//Verifying Add/edit User page is Displayed
		UM.VerifyAddOrEditUserPageisDisplayed(driver);
		chiledTest.log(Status.INFO, "Add/Edit User Page is Displayed");

		//Clicking on the Submit Button
		UM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Mandatory Fields is Displayed
		UM.VerifyMandtatoryFieldsIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Required Fields are Displayed");

		System.out.println("***************************************");

	}

	//Testing the Functionality of the Manage User Page Test
	@Test(priority=17, dependsOnMethods= {"Add_User_Mandatory_Fields_Test"})
	public void Upload_Photo_Test() throws InterruptedException
	{

		UserManagementPageTest UM = new UserManagementPageTest(driver);

		chiledTest = parentTest.createNode("Upload Photo Test");

		System.out.println("Upload Photo Test");

		driver.navigate().refresh();

		UM.ClickManageUserHeader(driver);

		//Clicking on the Add User Button
		UM.ClickAddUserBTN(driver);
		chiledTest.log(Status.INFO, "Add User Button is Clicked");

		//Passing the Values to First name
		String FN = Lib.getCellValue(XLPATH, "User Management", 3, 0);
		UM.SetFirstName(FN);
		chiledTest.log(Status.INFO, "First Name is Entered");

		//Passing the Values to Email Id
		String EI = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetEmailId(EI);
		chiledTest.log(Status.INFO, "Email Id is Entered");

		//Clicking on the Country
		UM.ClickCountry();

		//Selecting Country Option
		String SC = Lib.getCellValue(XLPATH, "User Management", 16, 0);
		UM.SetCountryOption(SC);
		chiledTest.log(Status.INFO, "Country is Selected");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Last Name
		String LN = Lib.getCellValue(XLPATH, "User Management", 20, 0);
		UM.SetLastName(LN);
		chiledTest.log(Status.INFO, "Last Name is Entered");

		//Passing the Values to Role
		String RO5 = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		UM.SetRoletext(RO5);
		chiledTest.log(Status.INFO, "Role is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Time zone
		UM.ClickTimeZone();

		//Passing the Values to Time Zone
		String TZ = Lib.getCellValue(XLPATH, "User Management", 36, 0);
		UM.SetTimezone(TZ);
		chiledTest.log(Status.INFO, "Time Zone is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Add/Edit Clusters/Auditees button
		UM.ClickAddEditClustersAuditeesBTN();
		chiledTest.log(Status.INFO, "Add/Edit Clusters/Auditees button is Clicked");

		//Passing the Values to Cluster
		String CS = Lib.getCellValue(XLPATH, "User Management", 41, 0);
		UM.SetCluster(CS);
		chiledTest.log(Status.INFO, "Cluster is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Cluster
		String CS1 = Lib.getCellValue(XLPATH, "User Management", 42, 0);
		UM.SetCluster(CS1);
		chiledTest.log(Status.INFO, "Cluster is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Auditee
		String SA = Lib.getCellValue(XLPATH, "User Management", 31, 0);
		UM.SetAuditee(SA, driver);
		chiledTest.log(Status.INFO, "Auditee is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Passing the Values to Auditee
		String SA1 = Lib.getCellValue(XLPATH, "User Management", 32, 0);
		UM.SetAuditee(SA1, driver);
		chiledTest.log(Status.INFO, "Auditee is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//clicking on the Done button
		UM.ClickDoneButton();
		chiledTest.log(Status.INFO, "Done button is Clicked");

		//Passing the Login ID
		String LI = Lib.getCellValue(XLPATH, "User Management", 7, 0);
		UM.SetLoginID(LI);
		chiledTest.log(Status.INFO, "Login ID is Entered");

		//Passing the Values to Phone
		String SP = Lib.getCellValue(XLPATH, "User Management", 48, 0);
		UM.SetPhone(SP);
		chiledTest.log(Status.INFO, "Phone Number is Entered");

		//Passing the Values to Address 
		String SA2 = Lib.getCellValue(XLPATH, "User Management", 53, 0);
		UM.SetAddress(SA2);
		chiledTest.log(Status.INFO, "Address is Entered");

		//Clicking on the State
		UM.ClickState();

		//Passing the Values to State
		String SS = Lib.getCellValue(XLPATH, "User Management", 58, 0);
		UM.SetState(SS);
		chiledTest.log(Status.INFO, "State is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the City
		UM.ClickCity();

		//Passing the Values to City
		String SC1 = Lib.getCellValue(XLPATH, "User Management", 62, 0);
		UM.SetCity(SC1);
		chiledTest.log(Status.INFO, "City is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the zip code
		UM.ClickZipCode();

		//Passing the Values to Zip code
		String SZ = Lib.getCellValue(XLPATH, "User Management", 66, 0);
		UM.SetZipCode(SZ);
		chiledTest.log(Status.INFO, "zip code is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Area
		UM.ClickArea();

		//Passing the Values to Area
		String AR = Lib.getCellValue(XLPATH, "User Management", 71, 0);
		UM.SetArea(AR);
		chiledTest.log(Status.INFO, "Area is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Region
		UM.ClickRegion();

		//Passing the Values to Region
		String SR = Lib.getCellValue(XLPATH, "User Management", 76, 0);
		UM.SetRegion(SR);
		chiledTest.log(Status.INFO, "Region is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Zone
		UM.ClickZone();

		//Passing the Values to Zone
		String SZ1 = Lib.getCellValue(XLPATH, "User Management", 81, 0);
		UM.SetZone(SZ1);
		chiledTest.log(Status.INFO, "Zone is Entered");

		//Clicking on the Matched data
		UM.ClickMatched(driver);

		//Clicking on the Male Gender
		UM.ClickMale();
		chiledTest.log(Status.INFO, "Gender is Selected");

		//Passing the Values to DOB
		String DB = Lib.getCellValue(XLPATH, "User Management", 86, 0);
		UM.SetDOB(DB);
		chiledTest.log(Status.INFO, "Date of Birth is Entered");

		//Passing the Values to Qualifications
		String QF1 = Lib.getCellValue(XLPATH, "User Management", 107, 0);
		UM.SetQualification(QF1);
		chiledTest.log(Status.INFO, "Qualifications is Entered");

		//Passing the Values to Qualifications
		String QF2 = Lib.getCellValue(XLPATH, "User Management", 108, 0);
		UM.SetQualification(QF2);
		chiledTest.log(Status.INFO, "Qualifications is Entered");

		//Selecting all Options under Specialization
		UM.SetSpecialization();

		//Passing the Values to Training
		String TT = Lib.getCellValue(XLPATH, "User Management", 119, 0);
		UM.SetTraining(TT);
		chiledTest.log(Status.INFO, "Training is Entered");

		//Passing the Values to Certification
		String CF = Lib.getCellValue(XLPATH, "User Management", 125, 0);
		UM.SetCertification(CF);
		chiledTest.log(Status.INFO, "Certification is Entered");

		//Uploading the Photo with More Than 500 KB 
		UM.UploadPhotowithMoreThan500KB();
		chiledTest.log(Status.INFO, "More Than 500 KB Photo is Uploaded");

		//Clicking on the Submit Button'
		UM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying You cant upload more than 500 Kb Error message is Displayed
		UM.VerifyYouCannotUploadAFileGreaterThan500kb(driver);
		chiledTest.log(Status.INFO, "You Can not Upload A File Greater Than 500 kb. Error Message is Displayed");

		//Uploading Excel Format
		UM.UploadingExcel();
		chiledTest.log(Status.INFO, "Excel is Uploaded");

		//Clicking on the Submit Button'
		UM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Only .jpg .png files are allowed for upload. Error Message is Displayed
		UM.VerifyOnlyJPGAndPNGIsAllowedErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Only .jpg .png files are allowed for upload. Error Message is Displayed");

		//Uploading PDF Format
		UM.UploadingPDF();
		chiledTest.log(Status.INFO, "PDF is Uploaded");

		//Clicking on the Submit Button'
		UM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Only .jpg .png files are allowed for upload. Error Message is Displayed
		UM.VerifyOnlyJPGAndPNGIsAllowedErrorMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Only .jpg .png files are allowed for upload. Error Message is Displayed");

		System.out.println("***************************************************");

	}


}

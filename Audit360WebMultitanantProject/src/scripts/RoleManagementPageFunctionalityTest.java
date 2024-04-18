package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;

import pom.RoleManagementPageTest;

public class RoleManagementPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Default Role
	@Test(priority=0)
	public void Role_Management_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		parentTest = extent.createTest("Role Management Page Test", "Testing the Functionality of Role Management Page, Adding role, view Role, Edit Role, Deleting the Roles Etc..");

		chiledTest = parentTest.createNode("Role Management Page Test");

		System.out.println("Role Management Page Test");

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

		RM.ClickScrollBar(driver);

		//Clicking on the Role Management
		RM.ClickRoleManagement(driver);
		chiledTest.log(Status.INFO, "Role Management is Clicked");

		//Clicking on the List Of Role
		RM.ClickRoles(driver);
		chiledTest.log(Status.INFO, "Roles is Clicked");

		//Verifying Manage Role Page is Displayed
		RM.VerifyRoleManagePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Role Management Page is Displayed");

		System.out.println("*************************************************************");

	}

	//Testing the Functionality of the Add Role  
	@Test(priority=1, dependsOnMethods= {"Role_Management_Page_Test"})
	public void Passing_Less_Than_Six_Characters_To_Name_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Passing Less Than Six Characters To Name Test");

		System.out.println("Passing Less Than Six Characters To Name Test");

		//Clicking on the Add Role Button
		RM.ClickAddRoleButton(driver);
		chiledTest.log(Status.INFO, "Add Role button is Clicked");

		//Verify Add Role Page is Displayed
		RM.VerifyAddRolePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Add Role Page is Clicked");

		//Passing the Values to Name
		String SN2 = Lib.getCellValue(XLPATH, "Role Management", 6, 0);
		RM.SetName(SN2, driver);
		chiledTest.log(Status.INFO, "Less Than 6 characters Name is Entered");

		//Clicking on the Level
		RM.ClickLevel(driver);

		//Passing the Values to Level
		String SL = Lib.getCellValue(XLPATH, "Role Management", 19, 0);
		RM.SetLevel(SL);
		chiledTest.log(Status.INFO, "Level is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//clicking on the Roles
		RM.ClickRoleType();

		//Passing the Roles
		String SR = Lib.getCellValue(XLPATH, "Role Management", 40, 0);
		RM.SetRolesType(SR);

		RM.ClickMatched();

		//Clicking on the Access
		RM.ClickAccess();

		//Passing the Values to Access
		String SA = Lib.getCellValue(XLPATH, "Role Management", 27, 0);
		RM.SetAccess(SA);
		chiledTest.log(Status.INFO, "Access is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the Submit Button
		RM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Name is too short (minimum is 6 characters) Error Message is Displayed
		RM.VerifyNameIsTooShortErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Name is too short (minimum is 6 characters) Error Message is Displayed");

		System.out.println("**********************************");
	}

	//Testing the Functionality of the Add Role
	@Test(priority=2, dependsOnMethods= {"Role_Management_Page_Test"})
	public void Add_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Add Role Test");

		System.out.println("Add Role Test");

		driver.navigate().refresh();

		//Clicking on the Add Role Button
		RM.ClickAddRoleButton(driver);
		chiledTest.log(Status.INFO, "Add Role button is Clicked");

		//Passing the Values to Name
		String SN = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		RM.SetName(SN, driver);
		chiledTest.log(Status.INFO, "Name is Entered");

		//Clicking on the Level
		RM.ClickLevel(driver);

		//Passing the Values to Level
		String SL = Lib.getCellValue(XLPATH, "Role Management", 19, 0);
		RM.SetLevel(SL);
		chiledTest.log(Status.INFO, "Level is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//clicking on the Roles
		RM.ClickRoleType();

		//Passing the Roles
		String SR = Lib.getCellValue(XLPATH, "Role Management", 40, 0);
		RM.SetRolesType(SR);

		RM.ClickMatched();

		//Clicking on the Access
		RM.ClickAccess();

		//Passing the Values to Access
		String SA = Lib.getCellValue(XLPATH, "Role Management", 27, 0);
		RM.SetAccess(SA);
		chiledTest.log(Status.INFO, "Access is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the Submit Button
		RM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Role created successfully Success Message is Displayed
		RM.VerifyRoleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Role created successfully Success Message is Displyed");

		//****************Adding One More Role*******************

		driver.navigate().refresh();

		chiledTest.log(Status.INFO, "************ Adding One More Role ************");
		System.out.println("************ Adding One More Role ************");

		//Clicking on the Add Role Button
		RM.ClickAddRoleButton(driver);
		chiledTest.log(Status.INFO, "Add Role button is Clicked");

		//Passing the Values to Name
		String SN4 = Lib.getCellValue(XLPATH, "Role Management", 7, 0);
		RM.SetName(SN4, driver);
		chiledTest.log(Status.INFO, "Name is Entered");

		//Clicking on the Level
		RM.ClickLevel(driver);

		//Passing the Values to Level
		String SL3 = Lib.getCellValue(XLPATH, "Role Management", 20, 0);
		RM.SetLevel(SL3);
		chiledTest.log(Status.INFO, "Level is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//clicking on the Roles
		RM.ClickRoleType();

		//Passing the Roles
		String SR1 = Lib.getCellValue(XLPATH, "Role Management", 40, 0);
		RM.SetRolesType(SR1);

		RM.ClickMatched();

		//Clicking on the Access
		RM.ClickAccess();

		//Passing the Values to Access
		String SA3 = Lib.getCellValue(XLPATH, "Role Management", 28, 0);
		RM.SetAccess(SA3);
		chiledTest.log(Status.INFO, "Access is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the Submit Button
		RM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Role created successfully Success Message is Displayed
		RM.VerifyRoleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Role created successfully Success Message is Displyed");

		System.out.println("*************************************************************");
	}

	//Testing the Functionality of the Adding the same name 
	@Test(priority=3, dependsOnMethods= {"Add_Role_Test"})
	public void Adding_Same_Name_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Add Same Name Test");

		System.out.println("Add Same Name Test");
		
		driver.navigate().refresh();

		//Clicking on the Add Role Button
		RM.ClickAddRoleButton(driver);
		chiledTest.log(Status.INFO, "Add Role button is Clicked");

		//Passing the Values to Name
		String SN = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		RM.SetName(SN, driver);
		chiledTest.log(Status.INFO, "Name is Entered");

		//Clicking on the Level
		RM.ClickLevel(driver);

		//Passing the Values to Level
		String SL = Lib.getCellValue(XLPATH, "Role Management", 20, 0);
		RM.SetLevel(SL);
		chiledTest.log(Status.INFO, "Level is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//clicking on the Roles
		RM.ClickRoleType();

		//Passing the Roles
		String SR = Lib.getCellValue(XLPATH, "Role Management", 40, 0);
		RM.SetRolesType(SR);

		RM.ClickMatched();

		//Clicking on the Access
		RM.ClickAccess();

		//Passing the Values to Level
		String SA = Lib.getCellValue(XLPATH, "Role Management", 28, 0);
		RM.SetAccess(SA);
		chiledTest.log(Status.INFO, "Access is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the submit Button
		RM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Name has already been taken Error Message is Displayed
		RM.VerifyNameHasAlreadyBeenTakenErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Name has already been taken Error Message is Displayed");

		//Clicking on the Close Button
		RM.ClickCloseBTN(driver);

		System.out.println("*************************************************************");

	}

	//Testing the Functionality of the Search Role
	@Test(priority=4, dependsOnMethods= {"Adding_Same_Name_Test"})
	public void Search_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Search Role Test");

		System.out.println("Search Role Test");

		//Passing Invalid Name to Search Text filed
		String SS1 = Lib.getCellValue(XLPATH, "Role Management", 4, 0);
		RM.SetSearchBTN(SS1);
		chiledTest.log(Status.INFO, "Invalid Name is Entered");

		//Verifying No Record Found. Error Message is Displayed
		RM.VerifyNoRecordsFoundMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "No Record Found. Error Message is Displayed");

		//Passing the Valid Name to Search Text Filed
		String SS = Lib.getCellValue(XLPATH, "Role Management", 7, 0);
		RM.SetSearchBTN(SS);
		chiledTest.log(Status.INFO, "Valid Name is Entered");

		Thread.sleep(2000);
		//Checking the Name
		WebElement Name = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr/td[@class='sorting_1']"));
		String NameTest = Name.getText();
		Assert.assertEquals(SS, NameTest);
		System.out.println("Pass : Searched Name is Displayed");

		//Verifying View, Edit and Delete Button's are displayed for newly created Role
		RM.VerifyDeleteViewEditButtonIsDisplayed(driver);
		chiledTest.log(Status.INFO, "View, Edit and Delete Button's are displayed for newly created Role");


		System.out.println("*************************************************************");

	}

	//Testing the Functionality of the View Role
	@Test(priority=5, dependsOnMethods= {"Search_Role_Test"})
	public void View_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("View Role Test");

		System.out.println("View Role Test");

		//Clicking on the View Button
		RM.ClickViewBTN();
		System.out.println("View Button is Clicked");

		//Verifying View Role Page is Displayed
		RM.VerifyViewRolePageIsDisplayed(driver);
		System.out.println("View Role Page is Displayed");

		//Clicking on the Cancel Button
		RM.ClickCloseBTN(driver);


		System.out.println("*********************************************************");
	}

	//Testing the Functionality of the Edit Role
	@Test(priority=6, dependsOnMethods= {"View_Role_Test"})
	public void Edit_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Edit Role Test");

		System.out.println("Edit Role Test");

		driver.navigate().refresh();

		//Clicking on the Edit Button
		RM.ClickEditBTN();
		System.out.println("Edit Button is Clicked");

		//Verifying Edit Role Page is Displayed
		RM.VerifyEditRolePageIsDisplayed(driver);
		System.out.println("Edit Role Page is Displayed");

		//Clearing the Name
		RM.ClearName();

		//Passing the Already Exist Name
		String SN = Lib.getCellValue(XLPATH, "Role Management", 3, 0);
		RM.SetName(SN, driver);
		chiledTest.log(Status.INFO, "Enterd Already Exsits Role Name");
		
		//Verifying the Level and Role is Read only mode in Edit Page
		RM.VerifyLevelAndRoleIsDisabledInEditRolePage();

		//Clicking on the Access
		RM.ClickAccess();

		//Passing the Values to Access
		String SA = Lib.getCellValue(XLPATH, "Role Management", 29, 0);
		RM.SetAccess(SA);
		chiledTest.log(Status.INFO, "Access is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the Submit Button
		RM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Name has already been taken Error Message is Displayed
		RM.VerifyNameHasAlreadyBeenTakenErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Name has already been taken Error Message is Displayed");

		//Clearing the Name
		RM.ClearName();

		//Passing the Values to Name
		String SN1 = Lib.getCellValue(XLPATH, "Role Management", 5, 0);
		RM.SetName(SN1, driver);
		chiledTest.log(Status.INFO, "Entered New Role Name");

		//Clicking on the Access
		RM.ClickAccess();

		//Passing the Values to Access
		String SA1 = Lib.getCellValue(XLPATH, "Role Management", 29, 0);
		RM.SetAccess(SA1);
		chiledTest.log(Status.INFO, "Access is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the Submit Button
		RM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Role updated successful Success Message is Displayed
		RM.VerifyRoleUpdatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Role updated successfuly Success Message is Dispalyed");

		System.out.println("*********************************************************");
	}

	//Testing the Functionality of the Delete  Role
	@Test(priority=6, dependsOnMethods= {"Edit_Role_Test"})
	public void Delete_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Delete Role Test");

		System.out.println("Delete Role Test");

		driver.navigate().refresh();

		//Passing Invalid Name to Search Text filed
		String SS = Lib.getCellValue(XLPATH, "Role Management", 5, 0);
		RM.SetSearchBTN(SS);
		chiledTest.log(Status.INFO, "Role Name is Entered");

		//Clicking on the Delete Role
		RM.ClickDeleteBTN();
		chiledTest.log(Status.INFO, "Delete Button is Clicked");

		//Verifying Delete Role? Pop Up is displayed
		RM.VerifyDeleteRolePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Delete Role? Pop up Is Displayed");

		//Clicking on the Ok Button
		RM.ClickOKBTN(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		//Verifying Role has been deleted Success Message is Displayed
		RM.VerifyRoleHasBeenDeletedMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Role has been deleted Success Message is Displayed");

		System.out.println("*********************************************************");

	}

	//Testing the Functionality of the Users have been assigned for the newly created 'Role' should not show Delete button  
	@Test(priority=7, dependsOnMethods= {"Delete_Role_Test"})
	public void Delete_Button_Should_Not_Show_for_User_Who_Has_Assigned_To_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Delete Button Should Not Show for User Who Has Assigned To Role Test");

		System.out.println("Delete Button Should Not Show for User Who Has Assigned To Role Test");

		driver.navigate().refresh();

		//Passing Users have been assigned for the newly created 'Role' to Search Text filed
		String SS = Lib.getCellValue(XLPATH, "Role Management", 37, 0);
		RM.SetSearchBTN(SS);
		chiledTest.log(Status.INFO, "User Who Has Assigned To the Role Searched");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> DeleteBTN = driver.findElements(By.xpath("//a[@class='btn btn-danger m-l-10']"));
		int Actual_DeleteBTNCount = DeleteBTN.size();
		int Expected_DeleteBTNCount = 0;
		Assert.assertEquals(Actual_DeleteBTNCount, Expected_DeleteBTNCount, "Delete Button is Displayed");
		System.out.println("Pass : Delete Button is Not Displayed");

		System.out.println("*********************************************************");

	}

	//Testing the Functionality of the Users have been assigned for the newly created 'Role' should not show Delete button  
	@Test(priority=7, dependsOnMethods= {"Delete_Button_Should_Not_Show_for_User_Who_Has_Assigned_To_Role_Test"})
	public void Edit_Delete_Button_Should_Not_Display_Default_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Edit And Delete Button Should Not Display Default Role Test");

		System.out.println("Edit And Delete Button Should Not Display Default Role Test");

		//Passing Default Roles to Search Text filed
		int RC = Lib.getRowcount(XLPATH, "Role Management");
		System.out.println("Total Number of Rows in Excel sheet is " + RC);
		String SS = null;
		for(int i=35; i<=RC; i++)
		{
			SS = Lib.getCellValue(XLPATH, "Role Management", i, 0);
			RM.SetSearchBTN(SS);
			chiledTest.log(Status.INFO, "Role is Searched");

			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			boolean Delete = driver.findElements(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[2]/a[@class='btn btn-danger m-l-10']")).size()>0;
			System.out.println("Delete Button is Displayed : " + Delete);
			chiledTest.log(Status.INFO, "Delete Button is Not Displayed");

			boolean View = driver.findElements(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[2]/a[@class='btn btn-clear']")).size()>0;
			System.out.println("View Button is Displayed : " + View);
			chiledTest.log(Status.INFO, "View Button is Displayed");

			boolean Edit = driver.findElements(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[2]/a[@class='btn btn-info m-l-10']")).size()>0;
			System.out.println("Edit Button is Displayed : " + Edit);
			chiledTest.log(Status.INFO, "Edit Button is Not Displayed");

			System.out.println("*********************************************************");

		}

	}


	//Testing the Functionality of the Add Role Mandatory Fields Test
	@Test(priority=9, dependsOnMethods= {"Edit_Delete_Button_Should_Not_Display_Default_Role_Test"})
	public void Add_Role_Mandatory_Fields_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Add Role Mandatory Fileds Test");

		System.out.println("Add Role Mandatory Fileds Test");

		//Clicking on the Add Role Button
		RM.ClickAddRoleButton(driver);
		chiledTest.log(Status.INFO, "Add Role Button is Clicked");

		//Verifying Mandatory Fields are Displayed 
		RM.VerifyAddRoleMandatoryFieldsIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Mandatory Fields are Displayed");

		System.out.println("*********************************************************");

	}


	//Testing the Functionality of the Add Role Mandatory Fields Test
	@Test(priority=10, dependsOnMethods= {"Add_Role_Mandatory_Fields_Test"})
	public void Passing_Invalid_Role_Name_While_Adding_The_Role_Test() throws InterruptedException
	{
		RoleManagementPageTest RM = new RoleManagementPageTest(driver);

		chiledTest = parentTest.createNode("Passing the Inavalid Role Name While Adding the Role Test");

		System.out.println("Passing the Inavalid Role Name While Adding the Role Test");

		//Passing the Values to Name
		String SN2 = Lib.getCellValue(XLPATH, "Role Management", 4, 0);
		RM.SetName(SN2, driver);
		chiledTest.log(Status.INFO, "Entered Name With Special Charecters");

		//Clicking on the Level
		RM.ClickLevel(driver);

		//Passing the Values to Level
		String SL = Lib.getCellValue(XLPATH, "Role Management", 19, 0);
		RM.SetLevel(SL);
		chiledTest.log(Status.INFO, "Level is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//clicking on the Roles
		RM.ClickRoleType();

		//Passing the Roles
		String SR = Lib.getCellValue(XLPATH, "Role Management", 40, 0);
		RM.SetRolesType(SR);

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the Access
		RM.ClickAccess();

		//Passing the Values to Access
		String SA = Lib.getCellValue(XLPATH, "Role Management", 27, 0);
		RM.SetAccess(SA);
		chiledTest.log(Status.INFO, "Access is Entered");

		//Clicking on the Matched Text
		RM.ClickMatched();

		//Clicking on the Submit Button
		RM.ClickSubmitBTN();
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Name < > and # characters should not be allowed. ,Name is invalid Error Message is Displayed
		RM.VerifyNameIsInvalidErrorMessageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Name < > and # characters should not be allowed. ,Name is invalid Error Message is Displayed");

		System.out.println("*********************************************************");

	}

}

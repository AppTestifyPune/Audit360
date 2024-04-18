package scripts;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import junit.framework.Assert;
import pom.LoginPageTest;
import pom.ManageRolePageTest;

public class ManageRolePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Default Role
	@Test(priority= 149)
	public void Manage_Role_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ManageRolePageTest MR = new ManageRolePageTest(driver);

		parentTest = extent.createTest("Manage Role Page Test", "Testing the Functionality of Manage Role Page, Adding role, Deleting the Roles Etc..");

		chiledTest = parentTest.createNode("Manage Role Page Test");

		System.out.println("Manage Role Page Test");

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

		MR.ClickScrollBar(driver);

		//Clicking on the Mange Role from side menu
		MR.ClickManageRole(driver);
		chiledTest.log(Status.INFO, "Manage Role Is Displayed");

		//Verifying Manage Role Page Is Displayed
		MR.VerifyManageRolePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Manage Role page Is Displayed");

		System.out.println("***********************************************************");

	}


	//Testing the Functionality of the Assign Role Test
	@Test(priority= 150)
	public void Assign_Role_Test() throws InterruptedException
	{

		ManageRolePageTest MR = new ManageRolePageTest(driver);

		chiledTest = parentTest.createNode("Assign Role Test");

		System.out.println("Assign Role Test");

		//Passing the Values to search Text field
		String SS = Lib.getCellValue(XLPATH, "Login Credentials", 18, 0);
		MR.SetSearchBTN(SS);
		chiledTest.log(Status.INFO, "User is Searched");

		//Clicking on the Check Box
		MR.ClickCheckBoxBTN(driver);
		chiledTest.log(Status.INFO, "Check Box is Clicked");

		//Verifying text is Present in the Users
		MR.VerifyTextisUpdatedinUsersOrNot(driver);
		chiledTest.log(Status.INFO, "Text is Updated in the Users");


		//Passing the Values to Roles
		String SR = Lib.getCellValue(XLPATH, "Manage Role", 9, 0);
		MR.SetRoles(SR);
		chiledTest.log(Status.INFO, "Role Is Entered");

		driver.switchTo().activeElement().sendKeys(Keys.TAB);


		//Clicking on the Assign Roles Button
		MR.ClickAssignRolesBTN();
		chiledTest.log(Status.INFO, "Assign Roles Button is Clicked");

		//Verifying User(s) roles updated Successfully Success Message is Displayed
		MR.VerifyUserRolesUpdatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User(s) roles updated Successfully Success Message is Displayed");

		System.out.println("***********************************************************");

	}

	//Testing the Functionality of the Assign Role Mandatory Fields Test
	@Test(priority= 151)
	public void Assign_Role_MandatoryFields_Test() throws InterruptedException
	{

		ManageRolePageTest MR = new ManageRolePageTest(driver);

		chiledTest = parentTest.createNode("Assign Role Mandatory Fields Test");

		System.out.println("Assign Role Mandatory Fields Test");

		//Clikcing on the Assign Roles Button
		MR.ClickAssignRolesBTN();
		chiledTest.log(Status.INFO, "Assign Roles Button is Clicked");

		//Verifying Mandtaory Fileds 
		MR.VerifyManageRolePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Roles is Required Field");

		System.out.println("***********************************************************");

	}

	//Testing the Functionality of the Select All Test
	@Test(priority= 152)
	public void Select_All_Test() throws InterruptedException
	{

		ManageRolePageTest MR = new ManageRolePageTest(driver);

		chiledTest = parentTest.createNode("Select All Test");

		System.out.println("Select All Test");

		MR.ClearSearchBTN();

		//Before clicks on Select All Check Box
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> Count = driver.findElements(By.xpath("//div[@id='s2id_selected_users']/ul/li/div"));
		int Expected_Count = Count.size();
		int Actual_Count = 0;
		Assert.assertEquals(Expected_Count, Actual_Count);
		System.out.println("Before click on Select All the Count of the Users is : " + Expected_Count);

		//Clikcing on the Select All Check Box
		MR.ClickSelectAllCheckBox();
		chiledTest.log(Status.INFO, "Select All Check Box is Clicked");

		//After clicks on Select All Check Box
		List<WebElement> Count1 = driver.findElements(By.xpath("//div[@id='s2id_selected_users']/ul/li/div"));
		int Expected_Count1 = Count1.size();
		System.out.println("After click on Select All the Count of the Users is : " + Expected_Count1);

		if(Expected_Count != Expected_Count1)
		{
			System.out.println("Pass : All the User's Name gets added under 'Users' Text Field");
			chiledTest.log(Status.INFO, "All the User's Name gets added under 'Users' Text Field");
		}

		System.out.println("***********************************************************");

	}

	//Testing the Functionality of the Remove Role
	@Test(priority= 153)
	public void Remove_Role_Test() throws InterruptedException
	{

		ManageRolePageTest MR = new ManageRolePageTest(driver);

		chiledTest = parentTest.createNode("Remove Role Test");

		System.out.println("Remove Role Test");

		MR.ClearSearchBTN();

		//Passing the Values to search Text field
		String SS = Lib.getCellValue(XLPATH, "Login Credentials", 18, 0);
		MR.SetSearchBTN(SS);
		chiledTest.log(Status.INFO, "User is Searched");

		//Checking the Count of the Roles
		List<WebElement> Count = driver.findElements(By.xpath("//div[@id='s2id_user_148_roles_']/ul/li/div"));
		int Expected_Count = Count.size();
		System.out.println("Before Deleting the Roles Count is : " + Expected_Count);


		//Clicking on the Delete Button
		MR.ClickDeleteBTN();
		chiledTest.log(Status.INFO, "Delete Button is Clicked");

		List<WebElement> deleteBTN = driver.findElements(By.xpath("//a[@class='select2-search-choice-close']"));
		if(deleteBTN.size()>0)
		{
			for(int i=0; i<=deleteBTN.size(); i++)
			{
				try
				{
					WebElement All = deleteBTN.get(i);
					All.click();
				}catch (Exception e) {
				}

			}
		}

		//Verifying Minimum one role should be assigned to a user. Success Message is Displayed
		MR.VerifyMinimumOneRoleShouldBeAssignedToUserMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Minimum one role should be assigned to a user. Success Message is Displayed");

		//Clicking on the Ok Button
		MR.ClickOkBTN();
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		System.out.println("************************************************");

	}


	//Testing the Functionality of the Search Role
	@Test(priority= 154)
	public void Search_Role_Test() throws InterruptedException
	{
		ManageRolePageTest MR = new ManageRolePageTest(driver);

		chiledTest = parentTest.createNode("Search Role Test");

		System.out.println("Search Role Test");

		MR.ClearSearchBTN();

		//Passing the Values to search Text field
		String SS = Lib.getCellValue(XLPATH, "Manage Role", 19, 0);
		MR.SetSearchBTN(SS);
		chiledTest.log(Status.INFO, "Searched Role is Displayed");

		//Serached Role is Displayed
		MR.VerifySearchedRoleIsDisplayed(driver);

		MR.ClearSearchBTN();

		//Passing the Values to search Text field
		String SS1 = Lib.getCellValue(XLPATH, "Manage Role", 20, 0);
		MR.SetSearchBTN(SS1);
		chiledTest.log(Status.INFO, "User is Searched");

		//No matching records found Error Message is Displayed
		MR.VerifyNoMatchingRecordsFoundErrorIsDisplayed(driver);
		chiledTest.log(Status.INFO, "No matching records found Error Message is Displayed");

		System.out.println("************************************************");

	}
}





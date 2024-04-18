package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.GroupPageTest;
import pom.LoginPageTest;

public class GroupPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Group List 
	@Test(priority=1)
	public void Group_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

		parentTest = extent.createTest("Group Functionality Test", "Testing the Functionality of the List Group, Add Group, Edit Group and Single Delete Group Test");

		chiledTest = parentTest.createNode("Group Page Test");

		System.out.println("Group Page Test");

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		l.ClickSigninBTN();

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

		//Verifying the Group list is Displaying or not
		//AG.VerifyGourpPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Group Page Is Displyed");

		System.out.println("*****************************************************");
	}

	//Testing the Functionality of the Adding the General Group Test
	@Test(priority=2, dependsOnMethods= {"Group_Page_Test"})
	public void Adding_General_Group_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Adding General Group Test");

		System.out.println("Creating General Group Test");

		chiledTest.log(Status.INFO, "Creating General Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type1
		String SG = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Redistribution Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG = Lib.getCellValue(XLPATH, "Group", 7, 0);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		//*********************Creating Redistribution Scoring Logic with more GP*****************

		System.out.println("Creating Redistribution Scoring Logic with General with one more Group Test");

		chiledTest.log(Status.INFO, "Creating Redistribution Scoring Logic With one more General Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG1 = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG1);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL1 = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL1);
		chiledTest.log(Status.INFO, "Redustrubution Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG1 = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AG.SetAddnewGroup(ADG1);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		//*********************Creating one more GP*********************************************

		System.out.println("Creating Fixed Scoring Logic with General with one more Group Test");

		chiledTest.log(Status.INFO, "Creating Fixed Scoring Logic With one more General Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG2 = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG2);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL2 = Lib.getCellValue(XLPATH, "Group", 40, 0);
		AG.SetScoringLogic(SL2);
		chiledTest.log(Status.INFO, "Fixed Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG2 = Lib.getCellValue(XLPATH, "Group", 9, 0);
		AG.SetAddnewGroup(ADG2);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		//*********************Creating one more GP*********************************************

		System.out.println("Creating Percentage Scoring Logic with General with one more Group Test");

		chiledTest.log(Status.INFO, "Creating Percentage Scoring Logic With one more General Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG3 = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG3);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL3 = Lib.getCellValue(XLPATH, "Group", 39, 0);
		AG.SetScoringLogic(SL3);
		chiledTest.log(Status.INFO, "Percentage Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG3 = Lib.getCellValue(XLPATH, "Group", 10, 0);
		AG.SetAddnewGroup(ADG3);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		//**********Creating one more Group***********

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type1
		String SG4 = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG4);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL4 = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL4);
		chiledTest.log(Status.INFO, "Redistribution Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG4 = Lib.getCellValue(XLPATH, "Group", 11, 0);
		AG.SetAddnewGroup(ADG4);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*****************************************************");

	}

	//Testing the Functionality of the Adding the General Group Test
	@Test(priority=3, dependsOnMethods={"Adding_General_Group_Test"})
	public void Creating_Dynamic_Annexure_Group_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Creating Dynamic Annexure Group Test");

		System.out.println("Creating Dynamic Annexure Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG1 = Lib.getCellValue(XLPATH, "Group", 4, 0);
		AG.SetGroupType(SG1);
		chiledTest.log(Status.INFO, "General Group is Selected");

		AG.ClickMatched(driver);

		//Clicking on the Select Annexure 
		AG.ClickSelectAnnexure();

		//Passing the Values to Select Annexure
		String SA = Lib.getCellValue(XLPATH, "Annexure", 3, 0);
		AG.SetSelectAnnexure(SA);
		chiledTest.log(Status.INFO, "Annexure is Selected");

		//clicking on the Matched text
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*****************************************************");
	}

	//Testing the Functionality of the Adding the General Group Test
	@Test(priority=4, dependsOnMethods= {"Creating_Dynamic_Annexure_Group_Test"})
	public void Creating_Static_Annexure_Group_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Creating Static Annexure Group Test");

		System.out.println("Creating Static Annexure Group Test");

		//driver.navigate().refresh();

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG1 = Lib.getCellValue(XLPATH, "Group", 4, 0);
		AG.SetGroupType(SG1);
		chiledTest.log(Status.INFO, "General Group is Selected");

		AG.ClickMatched(driver);

		//Clicking on the Select Annexure 
		AG.ClickSelectAnnexure();

		//Passing the Values to Select Annexure
		String SA = Lib.getCellValue(XLPATH, "Annexure", 4, 0);
		AG.SetSelectAnnexure(SA);
		chiledTest.log(Status.INFO, "Annexure is Selected");

		//clicking on the Matched text
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG = Lib.getCellValue(XLPATH, "Group", 18, 0);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*****************************************************");

	}

	//Testing the Functionality of the Adding the General Group Test
	@Test(priority=5, dependsOnMethods= {"Creating_Static_Annexure_Group_Test"})
	public void Creating_Exceptional_Group_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Creating Exceptional Group Test");

		System.out.println("Creating Exceptional Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the Exceptional Group under Group Type
		String SG1 = Lib.getCellValue(XLPATH, "Group", 5, 0);
		AG.SetGroupType(SG1);
		chiledTest.log(Status.INFO, "Exceptional Group is Selected");

		AG.ClickMatched(driver);

		//verifying Annexure Drop down is Read only mode
		AG.VerifyAnnexureGroupDropDwonInReadOnlyMode(driver);

		//verifying Scoring logic Drop down is Read only mode
		AG.VerifyScoingDropDwonInReadOnlyMode(driver);

		//Passing the Values to Add group from excel
		String ADG = Lib.getCellValue(XLPATH, "Group", 12, 0);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*********Creating One more Exceptional Group***************");

		chiledTest.log(Status.INFO, "*******Creating One more Exceptional Group************");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the Exceptional Group under Group Type
		String SG2 = Lib.getCellValue(XLPATH, "Group", 5, 0);
		AG.SetGroupType(SG2);
		chiledTest.log(Status.INFO, "Exceptional Group is Selected");

		AG.ClickMatched(driver);

		//verifying Annexure Drop down is Read only mode
		AG.VerifyAnnexureGroupDropDwonInReadOnlyMode(driver);

		//verifying Scoring logic Drop down is Read only mode
		AG.VerifyScoingDropDwonInReadOnlyMode(driver);

		//Passing the Values to Add group from excel
		String ADG2 = Lib.getCellValue(XLPATH, "Group", 13, 0);
		AG.SetAddnewGroup(ADG2);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("***********************************");

	}

	//Testing the Functionality of the Adding same Group Name
	@Test(priority=6, dependsOnMethods= {"Creating_Exceptional_Group_Test"})  
	public void Adding_Same_Group_Name_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Adding Same Group Name Test");

		System.out.println("Adding Same Group Name Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG = Lib.getCellValue(XLPATH, "Group", 3, 0);
		AG.SetGroupType(SG);
		chiledTest.log(Status.INFO, "General Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "Group", 38, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG = Lib.getCellValue(XLPATH, "Group", 7, 0);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupNameHasAlreadyBeenTakenErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Group Name has already been taken Error Message is Displayed");


		System.out.println("*****************************************************");
	}


	//Testing the Functionality of the Edit Group
	@Test(priority=7, dependsOnMethods= {"Adding_Same_Group_Name_Test"})
	public void Edit_Group_Test() throws InterruptedException{

		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Edit Group Test");

		System.out.println("Edit Group Test");

		//Passing the values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 7, 0);
		AG.SetSearchBox(SB1);

		//clicking on the Search Button
		AG.ClickEditButton(driver);
		chiledTest.log(Status.INFO, "Edit Button is Clicked");

		//Passing the values to Edit Text Box
		String GN1 = Lib.getCellValue(XLPATH, "Group", 23, 0);
		AG.SetGroupName(GN1);
		chiledTest.log(Status.INFO, "Entered the Group Name");

		//clicking on the save button 
		AG.ClickSaveBTN();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//checking the group updated successfully message is displaying or not 
		AG.VerifyGroupUpdatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Updated Successfully");

		System.out.println("*****************************************************");
	}

	//Testing the Functionality of the Single Group Delete
	@Test(priority=8, dependsOnMethods= {"Edit_Group_Test"})
	public void Delete_Group_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Delete Group Test");

		System.out.println("Delete Group Test");

		//passing the values to the Search Text Box
		String SB = Lib.getCellValue(XLPATH, "Group", 26, 0);
		AG.SetSearchBox(SB);

		//clicking on the Check Box
		AG.ClickCheckboxBTN(driver);

		//clicking on the Delete button
		AG.clickDeleteIcon(driver);
		chiledTest.log(Status.INFO, "Delete Icon is Clicked");

		AG.VerifyAreYouSureYouWantToDeleteTheSelectedGroups(driver);
		chiledTest.log(Status.INFO, "Are you sure you want to delete the selected Group(s)? Pop Up Message is Displayed");

		//clicking on the Ok Button 
		AG.ClickOKBTN(driver);
		chiledTest.log(Status.INFO, "Ok Button is Clicked");

		AG.VerifyGroupHasBeenDeletedSuccessMSGIsDisplyed(driver);
		chiledTest.log(Status.INFO, "Group Deleted Successfully");

		System.out.println("*****************************************************");
	}

	//Testing the Functionality of the Search Group
	@Test(priority=9, dependsOnMethods= {"Delete_Group_Test"}) 
	public void Search_Group_Test() throws InterruptedException
	{

		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Search Group Test");

		System.out.println("Search Group Test");

		//passing the values to the Search Text Box
		String SB = Lib.getCellValue(XLPATH, "Group", 26, 0);
		AG.SetSearchBox(SB);
		chiledTest.log(Status.INFO, "Deleted Group Name is Searched");

		//Verifying No matching records found
		AG.VerifyNoRecardfoundisdiplyed(driver);
		chiledTest.log(Status.INFO, "No matching records found Message is Displayed");

		//passing the values to the Search Text Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AG.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Valid Group Name is Searched");

		Thread.sleep(3000);
		String Actual_text = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[@class='v-align-middle edit_group']")).getText();
		Assert.assertEquals(SB1, Actual_text);
		System.out.println("Pass : Serached Group Name is Displayed");

		System.out.println("*****************************************************");

	}

	//Testing the Functionality of the Group has one or more checkpoint & cannot be deleted.
	@Test(priority=10, dependsOnMethods= {"Search_Group_Test"})
	public void Group_Has_One_Or_More_Checkpoint_Cannot_Be_Deleted_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Group Has One Or More Checkpoint & Cannot Be Deleted Test");

		System.out.println("Group Has One Or More Checkpoint & Cannot Be Deleted Test");

		//passing the values to the Search Text Box
		String SB = Lib.getCellValue(XLPATH, "Group", 29, 0);
		AG.SetSearchBox(SB);

		//clicking on the Check box
		AG.ClickCheckboxBTN(driver);

		//clicking on the Delete button
		AG.clickDeleteIcon(driver);
		chiledTest.log(Status.INFO, "Delete Icon is Clicked");

		//Verifying Group has one or more checkpoint & cannot be deleted. Error Message is displayed
		AG.VerifyGroupHasOneOrMoreCheckpointCannotBeDeletedErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Group has one or more checkpoint & cannot be deleted. Error Message is Displayed");

		System.out.println("*****************************************************");
	}

	//Testing the Functionality of the Group Is Already In Use By Another Audit Test
	@Test(priority=11, dependsOnMethods= {"Group_Has_One_Or_More_Checkpoint_Cannot_Be_Deleted_Test"})
	public void Group_Is_Already_In_Use_By_Another_Audit_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Group Is Already In Use By Another Audit Test");

		System.out.println("Group Is Already In Use By Another Audit Test");

		//clicking on the Manage checkpoint header
		AG.ClickManageCheckPointHeader(driver);

		//passing the values to the Search Text Box
		String SB = Lib.getCellValue(XLPATH, "Group", 32, 0);
		AG.SetSearchBox(SB);

		//clicking on the Check box
		AG.ClickCheckboxBTN(driver);

		//clicking on the Delete button
		AG.clickDeleteIcon(driver);
		chiledTest.log(Status.INFO, "Delete Icon is Clicked");

		//Verifying Group has one or more checkpoint & cannot be deleted. Error Message is displayed
		AG.VerifyGroupIsAlreadyInUseByAnotherAuditErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Group Is Already In Use By Another Audit. Error Message is Displayed");

		System.out.println("*****************************************************");
	}

	//Testing the Functionality of Mandatory Fields test
	@Test(priority=12, dependsOnMethods= {"Group_Is_Already_In_Use_By_Another_Audit_Test"})
	public void Group_MandatoryFields_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Group Mandatory Fields Test");

		System.out.println("Group Mandatory Fields Test");

		//clicking on the Manage Checkpoint Header
		AG.ClickManageCheckPointHeader(driver);

		//Clicking on the add Group Button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Without Filled the Deatils Add Button is Clicked");

		//Verifying Mandatory Fields Error Message are displayed
		AG.VerifyGroupMandatoryFieldsErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Error Messages are Displayed");

		//clicking on the Delete Button
		AG.clickDeleteIcon(driver);

		Alert alert = driver.switchTo().alert();
		String Actual_Msg = alert.getText();
		String Expected_Msg = "Please select groups to delete.";
		Assert.assertEquals(Actual_Msg, Expected_Msg, "Please select groups to delete Alert is Not Displayed");
		System.out.println("Please select groups to delete Alert is Displayed");
		chiledTest.log(Status.INFO, "Please select groups to delete Alert is Displayed");

		alert.accept();

		System.out.println("*****************************************************");

	}

}

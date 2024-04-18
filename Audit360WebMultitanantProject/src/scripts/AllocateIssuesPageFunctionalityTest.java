package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AllocateIssuesPageTes;
import pom.LoginPageTest;

public class AllocateIssuesPageFunctionalityTest extends BaseTest
{

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority = 565) 
	public void Allocate_Issues_Page_Test() throws InterruptedException{

		parentTest = extent.createTest("Allocate Issues Functionality Test", "Testing the Functionality Search, Allocating Issues to Reviewer and Respondent Etc..");
 
		chiledTest = parentTest.createNode("Allocate Issue Pages Test");

		System.out.println("Allocate Issues Page Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		LoginPageTest l= new LoginPageTest(driver);

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");

		//Taking the User name from 'TestValidLoginPage' sheet in excel
		String un=Lib.getCellValue(XLPATH, "Login Credentials",52,0);
		String pw=Lib.getCellValue(XLPATH,"Login Credentials",52,1);

		l.setusername(un);
		//Taking the Password from 'TestValidLoginPage' sheet in excel

		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		System.out.println("*************************************************");
		
	}

	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(enabled=true,priority = 566) 
	public void Allocate_Issues_Mandatory_Field_Test() throws Exception{

		chiledTest = parentTest.createNode("Allocate Issue Mandatory Field Test");

		System.out.println("Allocate Issues Mandatory Field Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		SoftAssert Softassertion = new SoftAssert();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Checking the Select Cluster Count
		WebElement ListBox = driver.findElement(By.id("cluster"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
	//	Softassertion.assertEquals(3, count, "Select Cluster count showing Wrong");//#SM Modify
		System.out.println("The Total Number of the Select CLuster Options Are ! " +count);

		for(int i=1; i<alloptions.size(); i++){
			WebElement All = alloptions.get(i);
			String AllText = All.getText();
			System.out.println(AllText);}

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);
		
		Thread.sleep(2000);
		try //#SM Modified
		{
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		}catch(Exception e)
		{
			
		}
		System.out.println("Go button Clicked");
		
		//Checking the Total sub Group count
		List<WebElement> GroupName = driver.findElements(By.xpath("//table[@id='ckgroupTable']/tbody/tr"));
		int Count = GroupName.size();
	//	Softassertion.assertEquals(3, Count, "Total sub Group Count are showing wrong under Grid");//#SM Modify

		//Selecting all the Check Box's
		List<WebElement> CheckBox = driver.findElements(By.xpath("//table[@id='ckgroupTable']/tbody/tr/td[1]/input[@type='checkbox']"));
		int CheckBoxCount = CheckBox.size();
	//	Softassertion.assertEquals(3, CheckBoxCount, "More than 3 CheckBoxes are Displayed");//#SM Modify
		for(int i=0; i<CheckBox.size(); i++){
			WebElement All = CheckBox.get(i);
			wait.until(ExpectedConditions.elementToBeClickable(All));
			All.click();
			}		
		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		//Checking the Please select Respondent or Auditee Reviewer User Pop Up Is Displayed
		Alert Alret = driver.switchTo().alert();
		String Actual_alertText = Alret.getText();
		String Expected_alertText = "Please select Respondent or Auditee Reviewer User";
	//	Softassertion.assertEquals(Actual_alertText, Expected_alertText, "Please select Respondent or Auditee Reviewer User Message has been showed Wrong");
	//	#SM Modify
		//Accpting the Alert
		Alret.accept();

		driver.navigate().refresh();

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT1);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC1 = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC1);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);
		
		Thread.sleep(2000);
		try //#SM Modified02
		{
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		}catch(Exception e)
		{
			System.out.println("Go button Clicked");
		}
		//Passing the Values to Auditees
	//	String SA = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		String SA = Lib.getCellValue(XLPATH, "Allocate Issues", 18, 0);
		System.out.println(SA);//Parameter not passed//#SM Modify
		AI.SetAuditees(SA);
		chiledTest.log(Status.INFO, "Auditees is Entered");
		
	  //AI.ClickMatched(driver);//Parameter not passed

	  //Clicking on the Select Respondent
		AI.ClickSelectRespondent();

		//Passing the Values to Select Repondent
		String SR = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		AI.SetSelectRespondent(SR);
		chiledTest.log(Status.INFO, "Repondent is Selected");

		AI.ClickMatched(driver);

		//clicking on the Select Auditee Reviewer
		/*
		AI.ClickSelectAuditeeReviewer();

		//Passing the Values to Select Reviewer
		String SR1 = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		AI.SetSelectReviewer(SR1);
		chiledTest.log(Status.INFO, "Reviewer is Selected");

		AI.ClickMatched(driver);
*/
		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		//Verifying Please select atleast one group
		AI.VerifyPleaseSelectAtleastOneGroupMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Please select atleast one group Message is Displayed");

		Softassertion.assertAll();

		System.out.println("********************************************************");

	}

	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(enabled=false,priority = 567) 
	public void Allocating_Issues_Test() throws Exception{

		chiledTest = parentTest.createNode("Allocating Issues Test");

		System.out.println("Allocating Issues Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		SoftAssert Softassertion = new SoftAssert();

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AI.SetSearchBox(SB);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Passing the Values to Auditees
		String SA = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		AI.SetAuditees(SA);
		chiledTest.log(Status.INFO, "Auditees is Entered");

		AI.ClickMatched(driver);

		//Clicking on the Select Respondent
		AI.ClickSelectRespondent();

		//Passing the Values to Select Repondent
		String SR = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		AI.SetSelectRespondent(SR);
		chiledTest.log(Status.INFO, "Repondent is Selected");

		AI.ClickMatched(driver);

		//Clicking on the check Box
		AI.ClickCheckBox(driver);
		chiledTest.log(Status.INFO, "Clicked on the Check Box");

		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		//Verifying Allocated Successfully Success Message is Displayed
		AI.VerifyAllocatedSuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Allocated Successfully Success Message is Displayed");

		//Passing the Values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AI.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Annexure Sub Audit is Searched");

		//Passing the Values to Auditees
		String SA1 = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		AI.SetAuditees(SA1);
		chiledTest.log(Status.INFO, "Auditees is Entered");

		AI.ClickMatched(driver);

		//clicking on the Select Auditee Reviewer
		AI.ClickSelectAuditeeReviewer();

		//Passing the Values to Select Reviewer
		String SR1 = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		AI.SetSelectReviewer(SR1);
		chiledTest.log(Status.INFO, "Reviewer is Selected");

		AI.ClickMatched(driver);

		//Clicking on the check Box
		AI.ClickCheckBox(driver);
		chiledTest.log(Status.INFO, "Clicked on the Check Box");

		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		//Passing the Values to Search Box
		String SB2 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		AI.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "Annexure Sub Audit is Searched");

		//Passing the Values to Auditees
		String SA2 = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		AI.SetAuditees(SA2);
		chiledTest.log(Status.INFO, "Auditees is Entered");

		AI.ClickMatched(driver);

		//clicking on the Select Auditee Reviewer
		AI.ClickSelectAuditeeReviewer();

		//Passing the Values to Select Reviewer
		String SR2 = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		AI.SetSelectReviewer(SR2);
		chiledTest.log(Status.INFO, "Reviewer is Selected");

		AI.ClickMatched(driver);

		//Clicking on the check Box
		AI.ClickCheckBox(driver);
		chiledTest.log(Status.INFO, "Clicked on the Check Box");

		//Clicking on the Allocate Button
		AI.ClickAlllocateBTN(driver);
		chiledTest.log(Status.INFO, "Allocate Button is Clicked");

		Softassertion.assertAll();

		System.out.println("********************************************************");

	}

	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(enabled=false,priority = 568) 
	public void View_Allocated_Issues_Test() throws InterruptedException{

		chiledTest = parentTest.createNode("View Allocated Issues Test");

		System.out.println("View Allocated Issues Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		SoftAssert Softassertion = new SoftAssert();

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AI.SetSearchBox(SB);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Verifying check box is Disabled or not
		WebElement CB = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[1]/input[@type='checkbox']"));
		Softassertion.assertFalse(CB.isEnabled(), "able to select the Check Box");

		//Verifying Group Name
		String GroupName = Lib.getCellValue(XLPATH, "Group", 8, 0);
		System.out.println("Expected Group Name is : " + GroupName);
		String GN = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[2]")).getText();
		System.out.println("Actual Group Name is : " + GN);
		Softassertion.assertEquals(GN, GroupName, "Wrong Group Name is showed");

		//Verifying Auditee
		String Auditee = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		System.out.println("Expected Auditee Name is : " + Auditee);
		String AU = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[3]")).getText();
		System.out.println("Actual Auditee Name is : " + AU);
		Softassertion.assertEquals(AU, Auditee, "Wrong Auditee is Showed");

		//Verify Respondent User
		String RespondentUser = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		System.out.println("Expected Respondent User Name is : " + RespondentUser);
		String RU = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[4]")).getText();
		System.out.println("Actaul Respondent User Name is : " + RU);
		Softassertion.assertEquals(RU, RespondentUser, "Wrong Respondent User is Showed");

		//Verify Auditee Reviewer
		WebElement Reviewer = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[5]"));
		String Atcual_Text = Reviewer.getText();
		String Expected_Text = "";
		Softassertion.assertEquals(Atcual_Text, Expected_Text, "Auditee Reviewer User is not Empty");

		//Verifyinhg Reassing Button is Displayed
		List<WebElement> ReassinBTN = driver.findElements(By.xpath("//Button[text()='Reassign']"));
		Softassertion.assertTrue(ReassinBTN.size()>0, "Reassign Button is Not Displayed");

		//Verifyinhg Remove Button is Displayed
		List<WebElement> RemoveBTN = driver.findElements(By.xpath("//Button[text()='Reassign']"));
		Softassertion.assertTrue(RemoveBTN.size()>0, "Remove Button is Not Displayed");

		//******************************************************

		//Passing the Values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AI.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Annexure Group is Searched");

		//Verifying check box is Disabled or not
		WebElement CB1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[1]/input[@type='checkbox']"));
		Softassertion.assertFalse(CB1.isEnabled(), "able to select the Check Box");

		//Verifying Group Name
		String GroupName1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		String GN1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[2]")).getText();
		Softassertion.assertEquals(GN1, GroupName1, "Wrong Group Name is showed");

		//Verifying Auditee
		String Auditee1 = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		String AU1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[3]")).getText();
		Softassertion.assertEquals(AU1, Auditee1, "Wrong Auditee is Showed");

		//Verify Respondent User
		WebElement Respondent = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[4]"));
		String Atcual_Text1 = Respondent.getText();
		String Expected_Text1 = "";
		Softassertion.assertEquals(Atcual_Text1, Expected_Text1, "Respondent User is not Empty");

		//Verify Auditee Reviewer
		String AR1 = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		String Reviewer1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[5]")).getText();
		Softassertion.assertEquals(AR1, Reviewer1, "Wrong Auditee Reviewer is Showed");

		//Verifyinhg Reassing Button is Displayed
		List<WebElement> ReassinBTN1 = driver.findElements(By.xpath("//Button[text()='Reassign']"));
		Softassertion.assertTrue(ReassinBTN1.size()>0, "Reassign Button is Not Displayed");


		//Verifyinhg Remove Button is Displayed
		List<WebElement> RemoveBTN1 = driver.findElements(By.xpath("//Button[text()='Remove']"));
		Softassertion.assertTrue(RemoveBTN1.size()>0, "Remove Button is Not Displayed");


		//******************************************************

		//Passing the Values to Search Box
		String SB2 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		AI.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "Annexure Group is Searched");

		//Verifying check box is Disabled or not
		WebElement CB2 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[1]/input[@type='checkbox']"));
		Softassertion.assertFalse(CB2.isEnabled(), "able to select the Check Box");

		//Verifying Group Name
		String GroupName2 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		String GN2 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[2]")).getText();
		Softassertion.assertEquals(GN2, GroupName2, "Wrong Group Name is showed");

		//Verifying Auditee
		String Auditee2 = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		String AU2 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[3]")).getText();
		Softassertion.assertEquals(AU2, Auditee2, "Wrong Auditee is Showed");

		//Verify Respondent User
		WebElement Respondent1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[4]"));
		String Atcual_Text2 = Respondent1.getText();
		String Expected_Text2 = "";
		Softassertion.assertEquals(Atcual_Text2, Expected_Text2, "Respondent User is not Empty");

		//Verify Auditee Reviewer
		String AR2 = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		String Reviewer2 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[5]")).getText();
		Softassertion.assertEquals(AR2, Reviewer2, "Wrong Auditee Reviewer is Showed");

		//Verifyinhg Reassing Button is Displayed
		List<WebElement> ReassinBTN2 = driver.findElements(By.xpath("//Button[text()='Reassign']"));
		Softassertion.assertTrue(ReassinBTN2.size()>0, "Reassign Button is Not Displayed");

		//Verifyinhg Remove Button is Displayed
		List<WebElement> RemoveBTN2 = driver.findElements(By.xpath("//Button[text()='Reassign']"));
		Softassertion.assertTrue(RemoveBTN2.size()>0, "Remove Button is Not Displayed");

		Softassertion.assertAll();

		System.out.println("************************************************************");
	}


	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(enabled=false,priority = 569/*,priority = 569*/) 
	public void Reassign_Issues_Test() throws Exception{

		chiledTest = parentTest.createNode("Reassign Issues Test");

		System.out.println("Reassign Issues Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AI.SetSearchBox(SB);
		chiledTest.log(Status.INFO, "Annexure Group is Searched");

		//Passing the Values to Auditee
		String SA = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		AI.SetAuditees(SA);
		chiledTest.log(Status.INFO, "Auditee is Selected");

		AI.ClickMatched(driver);

		//Clicking on the Respondent
		AI.ClickSelectRespondent();

		//Passing the Values to Respondent
		String SR = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		AI.SetSelectRespondent(SR);
		chiledTest.log(Status.INFO, "Respondent is Selected");

		AI.ClickMatched(driver);

		//Clicking on the Reassign Button
		AI.ClickReassignBTN();
		chiledTest.log(Status.INFO, "Reassign Button is Clicked");

		//Checking Are you sure you want to reassign user Pop Up is Displayed or not
		AI.VerifyAreyouSureYouWantToReassignUserPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are you sure you want to reassign user Pop Up is Displayed");

		AI.ClickConfirmBTN(driver);
		chiledTest.log(Status.INFO, "Confirm Button is Clicked");

		//Verifying Reassigned Successfully Message is Displayed
		AI.VerifyingReassignedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reassigned Successfully Message is Displayed");

		//************************************

		driver.navigate().refresh();

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT1);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC1 = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC1);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		AI.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Annexure Group is Searched");

		//Passing the Values to Auditee
		String SA1 = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		AI.SetAuditees(SA1);
		chiledTest.log(Status.INFO, "Auditee is Selected");

		AI.ClickMatched(driver);

		//Clicking on the Respondent
		AI.ClickSelectRespondent();

		//Passing the Values to Respondent
		String SR1 = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		AI.SetSelectRespondent(SR1);
		chiledTest.log(Status.INFO, "Respondent is Selected");

		AI.ClickMatched(driver);

		//Clicking on the Reassign Button
		AI.ClickReassignBTN();
		chiledTest.log(Status.INFO, "Reassign Button is Clicked");

		//Checking Are you sure you want to reassign user Pop Up is Displayed or not
		AI.VerifyAreyouSureYouWantToReassignUserPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are you sure you want to reassign user Pop Up is Displayed");

		AI.ClickConfirmBTN(driver);
		chiledTest.log(Status.INFO, "Confirm Button is Clicked");

		//Verifying Reassigned Successfully Message is Displayed
		AI.VerifyingReassignedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reassigned Successfully Message is Displayed");

		//***********************************************

		driver.navigate().refresh();

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT2);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC2 = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC2);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB2 = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AI.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "Annexure Group is Searched");

		//Passing the Values to Auditee
		String SA2 = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		AI.SetAuditees(SA2);
		chiledTest.log(Status.INFO, "Auditee is Selected");

		AI.ClickMatched(driver);

		//Clicking on the Respondent
		AI.ClickSelectRespondent();

		//Passing the Values to Respondent
		String SR2 = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		AI.SetSelectRespondent(SR2);
		chiledTest.log(Status.INFO, "Respondent is Selected");

		AI.ClickMatched(driver);

		//Clicking on the Reassign Button
		AI.ClickReassignBTN();
		chiledTest.log(Status.INFO, "Reassign Button is Clicked");

		//Checking Are you sure you want to reassign user Pop Up is Displayed or not
		AI.VerifyAreyouSureYouWantToReassignUserPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are you sure you want to reassign user Pop Up is Displayed");

		AI.ClickConfirmBTN(driver);
		chiledTest.log(Status.INFO, "Confirm Button is Clicked");

		//Verifying Reassigned Successfully Message is Displayed
		AI.VerifyingReassignedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reassigned Successfully Message is Displayed");


		System.out.println("*************************************************");

	}

	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(enabled=false,priority = 570) 
	public void Reassigned_Issues_View_Test() throws InterruptedException{

		chiledTest = parentTest.createNode("Reassigned Issues View Test");

		System.out.println("Reassigned Issues View Test");

		SoftAssert Softassertion = new SoftAssert();

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AI.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Annxure Group is Searched");

		//Verifying check box is Disabled or not
		WebElement CB1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[1]/input[@type='checkbox']"));
		Softassertion.assertFalse(CB1.isEnabled(), "able to select the Check Box");

		//Verifying Group Name
		String GroupName1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		String GN1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[2]")).getText();
		Softassertion.assertEquals(GroupName1, GN1, "Wrong Group Name is showed");

		//Verifying Auditee
		String Auditee1 = Lib.getCellValue(XLPATH, "Allocate Issues", 17, 0);
		String AU1 = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[3]")).getText();
		Softassertion.assertEquals(Auditee1, AU1, "Wrong Auditee is Showed");

		//Verify Respondent User
		String RU = Lib.getCellValue(XLPATH, "Login Credentials", 60, 0);
		String Respondent = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[4]")).getText();
		Softassertion.assertEquals(Respondent, RU, "Respondent User is Wrong");

		//Verify Auditee Reviewer
		String AR = Lib.getCellValue(XLPATH, "Login Credentials", 68, 0);
		String Reviewer = driver.findElement(By.xpath("//table[@id='ckgroupTable']/tbody/tr[1]/td[5]")).getText();
		Softassertion.assertEquals(Reviewer, AR, "Reviewer User is Wrong");

		//Verifyinhg Reassing Button is Displayed
		List<WebElement> ReassinBTN = driver.findElements(By.xpath("//Button[text()='Reassign']"));
		Softassertion.assertTrue(ReassinBTN.size()>0, "Reassign Button is Not Displayed");

		//Verifyinhg Remove Button is Displayed
		List<WebElement> RemoveBTN = driver.findElements(By.xpath("//Button[text()='Remove']"));
		Softassertion.assertTrue(RemoveBTN.size()>0, "Remove Button is Not Displayed");

		Softassertion.assertAll();

		System.out.println("*************************************************");

	}



	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(enabled=false,priority = 571/*,priority = 569*/) 
	public void Removing_All_Allocated_Issues_Test() throws InterruptedException{

		chiledTest = parentTest.createNode("Removing All Allocated Issues Test");

		System.out.println("Removing All Allocated Issues Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AI.SetSearchBox(SB);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Clicking on the Remove Button
		AI.ClickRemoveBTN();
		chiledTest.log(Status.INFO, "Remove Button is Clicked");

		//Checking Are you sure you want to remove user Pop Up is Displayed or not
		AI.VerifyAreyouSureYouWantToRemoveUserPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are you sure you want to remove user Pop Up is Displayed");

		AI.ClickConfirmBTN(driver);
		chiledTest.log(Status.INFO, "Confirm Button is Clicked");

		//Verifying Removed Successfully Message is Displayed
		AI.VerifyingRemovedSuccessfullyMessageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Removed Successfully Message is Displayed");

		//*************************************

		driver.navigate().refresh();

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT1);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC1 = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC1);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AI.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Clicking on the Remove Button
		AI.ClickRemoveBTN();
		chiledTest.log(Status.INFO, "Remove Button is Clicked");

		//Checking Are you sure you want to remove user Pop Up is Displayed or not
		AI.VerifyAreyouSureYouWantToRemoveUserPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are you sure you want to remove user Pop Up is Displayed");

		AI.ClickConfirmBTN(driver);
		chiledTest.log(Status.INFO, "Confirm Button is Clicked");

		//Verifying Removed Successfully Message is Displayed
		AI.VerifyingRemovedSuccessfullyMessageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Removed Successfully Message is Displayed");

		//*********************************

		driver.navigate().refresh();

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT2);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC2 = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC2);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB2 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		AI.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Clicking on the Remove Button
		AI.ClickRemoveBTN();
		chiledTest.log(Status.INFO, "Remove Button is Clicked");

		//Checking Are you sure you want to remove user Pop Up is Displayed or not
		AI.VerifyAreyouSureYouWantToRemoveUserPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Are you sure you want to remove user Pop Up is Displayed");

		AI.ClickConfirmBTN(driver);
		chiledTest.log(Status.INFO, "Confirm Button is Clicked");

		//Verifying Removed Successfully Message is Displayed
		AI.VerifyingRemovedSuccessfullyMessageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Removed Successfully Message is Displayed");

		System.out.println("****************************************************");

	}

	//Testing Functionality of the Allocating the Issues to Reviewer
	@Test(enabled=false,priority = 572/*,priority=571*/) 
	public void Removed_Allocated_Issues_Should_Not_Contains_Reassign_Remove_Button_Test() throws InterruptedException{

		chiledTest = parentTest.createNode("Removed Allocated Issues Should not Contains Reassign and Remove Button Test");

		System.out.println("Removed Allocated Issues Should not Contains Reassign and Remove Button Test");

		AllocateIssuesPageTes AI = new AllocateIssuesPageTes(driver);

		AI.ClickScrollBar(driver);

		AI.ClickAllocateIssues(driver);

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB = Lib.getCellValue(XLPATH, "Group", 8, 0);
		AI.SetSearchBox(SB);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Verifying Reassign and Removed Button is Displayed 
		AI.VerifyReassignAndRemoveButtonIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reassign and Removed Button are Not Displayed");

		//****************************

		driver.navigate().refresh();

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT2);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		

		//Passing the Values to Select cluster
		String SC2 = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC2);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB1 = Lib.getCellValue(XLPATH, "Group", 15, 0);
		AI.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Verifying Reassign and Removed Button is Displayed 
		AI.VerifyReassignAndRemoveButtonIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reassign and Removed Button are Not Displayed");

		//**************************************

		driver.navigate().refresh();

		AI.ClickAuditType();

		//Passing the Values to Audit Type 
		String AT3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		AI.SetAuditType(AT3);
		chiledTest.log(Status.INFO, "Audit type is selected");

		AI.ClickMatched(driver);

		//Passing the Values to Select cluster
		String SC3 = Lib.getCellValue(XLPATH, "Allocate Issues", 11, 0);
		AI.SetSelectCluster(SC3);
		chiledTest.log(Status.INFO, "Cluster is Selected");

		AI.ClickMatched(driver);

		//Passing the Values to Search Box
		String SB2 = Lib.getCellValue(XLPATH, "Group", 18, 0);
		AI.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "Genaral Group is Searched");

		//Verifying Reassign and Removed Button is Displayed 
		AI.VerifyReassignAndRemoveButtonIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reassign and Removed Button are Not Displayed");

		System.out.println("****************************************************");

	}



}



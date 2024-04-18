package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AnnexurePageTest;
import pom.AuditExecutionPageTest;
import pom.AuditSchedulePageTest;
import pom.AuditeeadminConfigurationPageTest;
import pom.CheckPointPageTest;
import pom.ConfigureAuditPageTest;
import pom.GroupPageTest;
import pom.LoginPageTest;
import pom.ReviewAuditPageTest;
import pom.SideMenuPageTest;
import pom.UploadAnnexureDocumentPageTest;

public class PercentageOfPositiveScoringLogicSubAuditsScenario1And1379Test extends BaseTest {

	//Testing the Functionality of the Annexure Page Test
	@Test(priority=1)
	public void Annexure_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AnnexurePageTest AT = new AnnexurePageTest(driver);

		parentTest = extent.createTest("Percentage Of Positive Scoring Sub Audits And 1379 Functionality Test", "NA Percentage of Positive Logic..");

		chiledTest = parentTest.createNode("Annexure Page Test");

		System.out.println("Annexure Page Test");

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

	    AT.ClickScrollBar(driver);

		//Clicking on the Annexure
		AT.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annexure is Clicked from Side Menu");

		//Clicking on the Annexures
		AT.ClickAddAnnexures(driver);
		chiledTest.log(Status.INFO, "Annexures is Clicked");

		System.out.println("*******************************************");

	}

   //Testing the Functionality of the Adding Static Annexure Test
   @Test(priority=2, dependsOnMethods= {"Annexure_Page_Test"})
	public void Adding_Static_Annexure_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Adding Static Annexure Test");

		System.out.println("Adding Static Annexure Test");

		//Clicking on the Add New Annexure Button
		AT.ClickAddNewAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Add New Annexure Button is Clicked");

		//Passing the Values to Annexure Name
		String AN = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 0);
		AT.SetAnnexureName(AN);
		chiledTest.log(Status.INFO, "Annexure Name Is Entered");

		//Clicking on the Static Radio button
		AT.ClickStaticRadioBTN();
		chiledTest.log(Status.INFO, "Static Radio Button is Selected");

		//passing the values to 1st Attribute index
		String FI = Lib.getCellValue(XLPATH, "Annexure", 29, 0);
		AT.SetFirstAttributeIndex(FI);

		//Passing the Values to 1st Attribute Name
		String FAN11 = Lib.getCellValue(XLPATH, "Annexure", 8, 0);
		AT.SetFirstAttributeName(FAN11);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Verify Option
		WebElement ListBox = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[1]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number Expected Action From Auditor is ! " + count);
		WebElement all = alloptions.get(1);
		all.click();

		//Clicking on the Add Button
		AT.ClickAddButton1();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//passing the values to2nd Attribute index
		String SI = Lib.getCellValue(XLPATH, "Annexure", 30, 0);
		AT.SetSecondAttributeIndex(SI);

		//Passing the Values to 2nd Attribute Name
		String SAN1 = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		AT.SetSecondAttributeName(SAN1);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Input Option
		WebElement ListBox1 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[2]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select1 = new Select(ListBox1);
		List<WebElement> alloptions1 = select1.getOptions();
		WebElement all1 = alloptions1.get(0);
		all1.click();

		//Clicking on the Add Button
		AT.ClickAddButton1();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//passing the values to 3rd Attribute index
		String TI = Lib.getCellValue(XLPATH, "Annexure", 31, 0);
		AT.SetThiredAttributeIndex(TI);

		//Passing the Values to 3rd Attribute Name
		String TAN1 = Lib.getCellValue(XLPATH, "Annexure", 10, 0);
		AT.SetThiredAttributeName(TAN1);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Both Option
		WebElement ListBox2 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[3]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select2 = new Select(ListBox2);
		List<WebElement> alloptions2 = select2.getOptions();
		WebElement all2 = alloptions2.get(2);
		all2.click();

		//Clicking on the Add Button
		AT.ClickAddButton1();
		chiledTest.log(Status.INFO, "Add Button is Clicked");


		//passing the values to 4th Attribute index
		String FHI = Lib.getCellValue(XLPATH, "Annexure", 32, 0);
		AT.SetFourthAttributIndex(FHI);

		//Passing the Values to 4th Attribute Name
		String FAN111 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		AT.SetFourthAttributeName(FAN111);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Both with condtions Option
		WebElement ListBox3 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[4]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select3 = new Select(ListBox3);
		List<WebElement> alloptions3 = select3.getOptions();
		WebElement all3 = alloptions3.get(3);
		all3.click();

		//Passing the Values to Configure Reason
		String SR1 = Lib.getCellValue(XLPATH, "Annexure", 20, 0);
		AT.SetReason1(SR1);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		//Clicking on the Configure Reason Add Button
		AT.ClickAddBTN2();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Passing the Values to Configure Reason
		String SR2 = Lib.getCellValue(XLPATH, "Annexure", 21, 0);
		AT.SetReason2(SR2);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		//Clicking on the Primary Identifier
		AT.ClickPrimaryIdentifier();

		//Passing the Values to Primary Identifier
		String PI = Lib.getCellValue(XLPATH, "Annexure", 8, 0);
		AT.SetPrimaryIdentifier(PI);
		chiledTest.log(Status.INFO, "Primary Identifier is Selected");

		AT.ClickMatched();

		//Clicking on the Save Button
		AT.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Annexure created successfully Success Message is Displayed
		AT.VerifyAnnexureCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Annexure created successfully Success Message is Displayed");

		System.out.println("*****************************************************************");

	}

	//Testing the Functionality of the Add Annexure Test
	@Test(priority=3, dependsOnMethods= {"Adding_Static_Annexure_Test"})
	public void Adding_Dynamic_Annexure_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Adding Dynamic Annexure Test");

		System.out.println("Adding Dynamic Annexure Test");

		//Clicking on the Add New Annexure Button
		AT.ClickAddNewAnnexureBTN(driver);

		//Passing the Values to Annexure
		String AN1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 0);
		AT.SetAnnexureName(AN1);
		chiledTest.log(Status.INFO, "Annexure Name Is Entered");

		//Passing the Values to 1st attribute index
		String FI = Lib.getCellValue(XLPATH, "Annexure", 29, 0);
		AT.SetFirstAttributeIndex(FI);

		//Passing the Values to 1st Attribute Name
		String FAN11 = Lib.getCellValue(XLPATH, "Annexure", 8, 0);
		AT.SetFirstAttributeName(FAN11);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Verify Option
		WebElement ListBox = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[1]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int count = alloptions.size();
		System.out.println("The Totle Number Expected Action From Auditor is ! " + count);
		WebElement all = alloptions.get(1);
		all.click();

		//Clicking on the Add Button
		AT.ClickAddButton1();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Passing the Values to 2nd attribute index
		String SI = Lib.getCellValue(XLPATH, "Annexure", 30, 0);
		AT.SetSecondAttributeIndex(SI);

		//Passing the Values to 2nd Attribute Name
		String SAN1 = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		AT.SetSecondAttributeName(SAN1);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Verify Option
		WebElement ListBox1 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[2]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select1 = new Select(ListBox1);
		List<WebElement> alloptions1 = select1.getOptions();
		WebElement all1 = alloptions1.get(0);
		all1.click();

		//Clicking on the Add Button
		AT.ClickAddButton1();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Passing the Values to 3rd attribute index
		String TI = Lib.getCellValue(XLPATH, "Annexure", 31, 0);
		AT.SetThiredAttributeIndex(TI);

		//Passing the Values to 3rd Attribute Name
		String TAN1 = Lib.getCellValue(XLPATH, "Annexure", 10, 0);
		AT.SetThiredAttributeName(TAN1);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Both Option
		WebElement ListBox2 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[3]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select2 = new Select(ListBox2);
		List<WebElement> alloptions2 = select2.getOptions();
		WebElement all2 = alloptions2.get(2);
		all2.click();

		//Clicking on the Add Button
		AT.ClickAddButton1();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Passing the Values to 4th attribute index
		String FHI = Lib.getCellValue(XLPATH, "Annexure", 32, 0);
		AT.SetFourthAttributIndex(FHI);

		//Passing the Values to 4th Attribute Name
		String FAN111 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		AT.SetFourthAttributeName(FAN111);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Both Option
		WebElement ListBox3 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[4]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select3 = new Select(ListBox3);
		List<WebElement> alloptions3 = select3.getOptions();
		WebElement all3 = alloptions3.get(3);
		all3.click();

		//Verifying Primary Identifier Options are Auto Selected
		AT.VerifyingPrimaryIdentifierOptionsAreAutoSelectd(driver);

		//Passing the Values to Configure Reason
		String SR3 = Lib.getCellValue(XLPATH, "Annexure", 20, 0);
		AT.SetReason1(SR3);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		//Clicking on the Configure Reason Add Button
		AT.ClickAddBTN2();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Passing the Values to Configure Reason
		String SR4 = Lib.getCellValue(XLPATH, "Annexure", 21, 0);
		AT.SetReason2(SR4);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		//Clicking on the Primary Identifier
		AT.ClickPrimaryIdentifier();

		//Passing the Values to Primary Identifier
		String PI = Lib.getCellValue(XLPATH, "Annexure", 8, 0);
		AT.SetPrimaryIdentifier(PI);
		chiledTest.log(Status.INFO, "Primary Identifier is Selected");

		AT.ClickMatched();

		//Clicking on the Save Button
		AT.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Annexure created successfully Success Message is Displayed
		AT.VerifyAnnexureCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Annexure created successfully Success Message is Displayed");

		System.out.println("*****************************************************************");


	}

	//Testing the Functionality of the Adding the Annexure Group Test
	@Test(priority=4, dependsOnMethods= {"Adding_Dynamic_Annexure_Test"})
	public void Creating_Annexures_Group_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Group Test");

		System.out.println("***Creating ststic Annexure Group Test****");

		chiledTest.log(Status.INFO, "****Creating Static Annexure Group Test");
		
		LoginPageTest l=new LoginPageTest(driver);
		
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

		AG.ClickScrollBar(driver);

		AG.ClickCheckpoints(driver);

		AG.ClickManageCheckpoints(driver);

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the Annexure Group under Group Type
		String SG = Lib.getCellValue(XLPATH, "Group", 4, 0);
		AG.SetGroupType(SG);
		chiledTest.log(Status.INFO, "Annexure Group is Selected");

		AG.ClickMatched(driver);

		//Clicking on the Select Annexure 
		AG.ClickSelectAnnexure();

		//Passing the Values to Select Annexure
		String SA = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 0);
		AG.SetSelectAnnexure(SA);
		chiledTest.log(Status.INFO, "Annexure is Selected");

		//clicking on the Matched text
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL = Lib.getCellValue(XLPATH, "Group", 39, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Percentage of Possitive Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 1);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*****************************************************");

		System.out.println("***Creating Dynamic Annexure Group Test****");

		chiledTest.log(Status.INFO, "****Creating Dynamic Annexure Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the Annexure Group under Group Type
		String SG1 = Lib.getCellValue(XLPATH, "Group", 4, 0);
		AG.SetGroupType(SG1);
		chiledTest.log(Status.INFO, "Annexure Group is Selected");

		AG.ClickMatched(driver);

		//Clicking on the Select Annexure 
		AG.ClickSelectAnnexure();

		//Passing the Values to Select Annexure
		String SA1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 0);
		AG.SetSelectAnnexure(SA1);
		chiledTest.log(Status.INFO, "Annexure is Selected");

		//clicking on the Matched text
		AG.ClickMatched(driver);

		//Clicking on the Select Scoring Logic
		AG.ClickSelectScoringLogic();

		//Passing the Values to Select Scoring Logic
		String SL1 = Lib.getCellValue(XLPATH, "Group", 39, 0);
		AG.SetScoringLogic(SL1);
		chiledTest.log(Status.INFO, "Percentage of Possitive Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group from excel
		String ADG1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 1);
		AG.SetAddnewGroup(ADG1);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*************************************");

	}

	@Test(priority=5, dependsOnMethods= {"Creating_Annexures_Group_Test"})
	public void Creating_General_Groups_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Creating Static Annexure Group Test");

		System.out.println("Creating Static Annexure Group Test");

		chiledTest.log(Status.INFO, "Creating Static Annexure Group Test");

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
		String SL = Lib.getCellValue(XLPATH, "Group", 39, 0);
		AG.SetScoringLogic(SL);
		chiledTest.log(Status.INFO, "Percentage of Possitive Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group 
		String ADG = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 1);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*************One more Group******************************");

		chiledTest.log(Status.INFO, "*************One more Group****************************");

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
		String SL1 = Lib.getCellValue(XLPATH, "Group", 39, 0);
		AG.SetScoringLogic(SL1);
		chiledTest.log(Status.INFO, "Percentage of Possitive Scoring Logic is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group 
		String ADG1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 1);
		AG.SetAddnewGroup(ADG1);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");


		System.out.println("*******************************");
	}

	//creating exceptional group
	@Test(priority=6, dependsOnMethods= {"Creating_General_Groups_Test"})
	public void Creating_Exceptional_Groups_Test() throws InterruptedException
	{
		GroupPageTest AG = new GroupPageTest(driver);

		chiledTest = parentTest.createNode("Creating Exceptional Group Test");

		System.out.println("Creating Exceptional Group Test");

		chiledTest.log(Status.INFO, "Creating Exceptional Group Test");

		//clicking on the Group Type
		AG.ClickGroupType(driver);

		//selecting the General Group under Group Type
		String SG = Lib.getCellValue(XLPATH, "Group", 5, 0);
		AG.SetGroupType(SG);
		chiledTest.log(Status.INFO, "Exceptional Group is Selected");

		//Clicking on the Matched
		AG.ClickMatched(driver);

		//Passing the Values to Add group 
		String ADG = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 1);
		AG.SetAddnewGroup(ADG);
		chiledTest.log(Status.INFO, "Group Name is Entered");

		//clicking on the Add button
		AG.ClickAddBTN();
		chiledTest.log(Status.INFO, "Add Button is Clicked");

		//Verifying Group is Created Success Message is Displayed or not
		AG.VerifyGroupCreatedSuccessfullyisdisplyed(driver);
		chiledTest.log(Status.INFO, "Group Created Successfully");

		System.out.println("*******************************");
	}

	//Adding the 4 types of checkpoints to Static annexure groups
	@Test(priority=7, dependsOnMethods= {"Creating_General_Groups_Test"})
	public void Adding_Four_CheckPoints_To_Static_Annexure_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding 4 Checkpoints to Static Annexure Group Test");

		chiledTest.log(Status.INFO, "Adding 4 Checkpoints to Static Annexure Group Test");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 1);
		CC.SetSearchBTN(SS);

		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD5);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to NA Disposition
		String ND115 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND115);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL5 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL5);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA5 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA5);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}


		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Verify Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI51 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CC.SetEnterCheckpointintent(ECI51, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS51 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		CC.SetDescription(DS51);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC1 = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC1);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA51 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA51);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 5);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB1);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD51 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD51);

		//Passing the Values to No Disposition
		String ND51 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND51);

		//Passing the Values to Partial Disposition
		String PD51 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD51);

		//Passing the Values to NA Disposition
		String ND1151 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);

		CC.SetNADisposition(ND1151);
		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL51 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL51);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA51 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA51);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Both Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC2 = Lib.getCellValue(XLPATH, "Annexure", 10, 0);
		CC.SetSelectAnnexureColumns(SAC2);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 8, 6);
		CC.SetNATextBox(NAB2);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both With Conditions Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Both With Conditions Checkpoint ****************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		CC.SetDescription(DS8);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC3 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		CC.SetSelectAnnexureColumns(SAC3);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB3);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD8);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD41);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL8 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL8);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected Under Risk Level");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");


		System.out.println("********************************************************************");

	}

	//Adding the 4 types of checkpoints to Static annexure groups
	@Test(priority=8, dependsOnMethods= {"Adding_Four_CheckPoints_To_Static_Annexure_Group_Test"})
	public void Adding_Four_CheckPoints_To_Dynamic_Annexure_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding 4 Checkpoints to Dynamic Annexure Group Test");

		chiledTest.log(Status.INFO, "Adding 4 Checkpoints to Dynamic Annexure Group Test");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 1);
		CC.SetSearchBTN(SS);

		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD5);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to NA Disposition
		String ND115 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND115);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL5 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL5);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA5 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA5);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}


		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Verify Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI51 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CC.SetEnterCheckpointintent(ECI51, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS51 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		CC.SetDescription(DS51);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC1 = Lib.getCellValue(XLPATH, "Annexure", 9, 0);
		CC.SetSelectAnnexureColumns(SAC1);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA51 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA51);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 5);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB1);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD51 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD51);

		//Passing the Values to No Disposition
		String ND51 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND51);

		//Passing the Values to Partial Disposition
		String PD51 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD51);

		//Passing the Values to NA Disposition
		String ND1151 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);

		CC.SetNADisposition(ND1151);
		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL51 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL51);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA51 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA51);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Both Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC2 = Lib.getCellValue(XLPATH, "Annexure", 10, 0);
		CC.SetSelectAnnexureColumns(SAC2);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 8, 6);
		CC.SetNATextBox(NAB2);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both With Conditions Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Both With Conditions Checkpoint ****************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		CC.SetDescription(DS8);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC3 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		CC.SetSelectAnnexureColumns(SAC3);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB3);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD8);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD41);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL8 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL8);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected Under Risk Level");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");


		System.out.println("********************************************************************");

	}

	//Adding the 4 types of Checkpoints
	@Test(priority=9, dependsOnMethods= {"Adding_Four_CheckPoints_To_Dynamic_Annexure_Group_Test"})
	public void Adding_Four_CheckPoints_To_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding 4 Checkpoints to Group");

		chiledTest.log(Status.INFO, "Adding 4 Checkpoints to Group");

		chiledTest = parentTest.createNode("Adding 4 Checkpoints to Group");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		CC.ClickManageCheckPointHeader(driver);
		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 1);
		CC.SetSearchBTN(SS);

		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 4);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD5);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to NA Disposition
		String ND115 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND115);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL5 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL5);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA5 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA5);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}


		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Verify Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI51 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CC.SetEnterCheckpointintent(ECI51, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS51 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		CC.SetDescription(DS51);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA51 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA51);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 4);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB1);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD51 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD51);

		//Passing the Values to No Disposition
		String ND51 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND51);

		//Passing the Values to Partial Disposition
		String PD51 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD51);

		//Passing the Values to NA Disposition
		String ND1151 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);

		CC.SetNADisposition(ND1151);
		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL51 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL51);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA51 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA51);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Both Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA7 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA7);
		chiledTest.log(Status.INFO, "Both Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 4);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 6);
		CC.SetNATextBox(NAB2);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both With Conditions Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Both With Conditions Checkpoint ****************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		CC.SetDescription(DS8);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA8 = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		CC.SetExpectedActionFromAuditor(EA8);
		chiledTest.log(Status.INFO, "Both with Condtions Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 4);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB3);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD8);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD41);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL8 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL8);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected Under Risk Level");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");


		System.out.println("********************************************************************");

	}

	//Adding the 4 types of Checkpoints
	@Test(priority=10, dependsOnMethods= {"Adding_Four_CheckPoints_To_Group_Test"})
	public void Adding_Four_CheckPoints_To_another_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Adding 4 Checkpoints to another Group");

		chiledTest.log(Status.INFO, "Adding 4 Checkpoints to another Group");

		chiledTest = parentTest.createNode("Adding 4 Checkpoints to another Group");

		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Verify Checkpoint ****************");

		WebDriverWait wait = new WebDriverWait(driver, 40);

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 1);
		CC.SetSearchBTN(SS);

		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 4);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB1);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD5);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to Partial Disposition
		String PD5 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD5);

		//Passing the Values to NA Disposition
		String ND115 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND115);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL5 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL5);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA5 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA5);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}


		System.out.println("************Creating Verify Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Verify Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI51 = Lib.getCellValue(XLPATH, "Check Point", 126, 0);
		CC.SetEnterCheckpointintent(ECI51, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS51 = Lib.getCellValue(XLPATH, "Check Point", 132, 0);
		CC.SetDescription(DS51);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA51 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA51);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 4);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 9, 6);
		CC.SetNATextBox(NAB2);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD51 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD51);

		//Passing the Values to No Disposition
		String ND51 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND51);

		//Passing the Values to Partial Disposition
		String PD51 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD51);

		//Passing the Values to NA Disposition
		String ND1151 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);

		CC.SetNADisposition(ND1151);
		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL51 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL51);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA51 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA51);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Creating Both Checkpoint ***************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 127, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 133, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA7 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA7);
		chiledTest.log(Status.INFO, "Both Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 4);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 10, 6);
		CC.SetNATextBox(NAB3);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		try{
			wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed();
			String Atcual_Text = SuccessMSG.getText();
			String Expected_Text = "Checkpoint created successfully.";
			Assert.assertEquals(Atcual_Text, Expected_Text);
			System.out.println("Checkpoint Created Successfully Message is Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");
		}catch (StaleElementReferenceException e) {
			System.out.println("Checkpoint Created Successfully Message is Not Displayed");
			chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Message is Not Displayed");
		}

		System.out.println("************Creating Both With Condtions Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Creating Both With Condtions Checkpoint ****************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 128, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 134, 0);
		CC.SetDescription(DS8);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA8 = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		CC.SetExpectedActionFromAuditor(EA8);
		chiledTest.log(Status.INFO, "Both with Condtions Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 4);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB4 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB4);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD8);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD41);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL8 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL8);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected Under Risk Level");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

		System.out.println("********************************************************************");

	}

	//Testing Functionality of the Create Check Point for Verify 
	@Test(priority=11, dependsOnMethods= {"Adding_Four_CheckPoints_To_another_Group_Test"}) 
	public void Adding_The_4_Types_Of_Checkpoints_To_Exceptional_Group_Test() throws InterruptedException
	{
		CheckPointPageTest CC = new CheckPointPageTest(driver);

		chiledTest = parentTest.createNode("Adding The 4 Types Of Checkpoints To Exceptional Group Test");

		System.out.println("Adding The 4 Types Of Checkpoints To Exceptional Group Test");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 1);
		CC.SetSearchBTN(SS);

		//Clicking on the Add Checkpoint Button
		CC.ClickAddCheckPointBTN(driver);
		chiledTest.log(Status.INFO, "Add Checkpoint Button is Clicked");

		//Passing the Values to the Enter Checkpoint intent
		String ECI5 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(ECI5, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS5 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS5);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB5 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB5);

		//Passing the Values to Yes Disposition
		String YD5 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD5);

		//Passing the Values to Yes Disposition
		String YD15 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD15);

		//Passing the Values to Yes Disposition
		String YD25 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD25);

		//Passing the Values to Yes Disposition
		String YD35 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD35);

		//Passing the Values to No Disposition
		String ND5 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND5);

		//Passing the Values to No Disposition
		String ND15 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND15);

		//Passing the Values to No Disposition
		String ND25 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND25);

		//Passing the Values to No Disposition
		String ND35 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND35);

		//Checking the NO Compliance is Read Only Mode or Not?
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking the Partial Compliance is Read Only Mode or Not?
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Checking the NA Compliance is Read Only Mode or Not?
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking the Partial Disposition is Read Only Mode or Not?
		CC.VerifyPartialDispositionIsReadOnly();

		//Checking the NA Disposition is Read Only Mode or Not?
		CC.VerifyNADispositionIsReadOnly();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL5 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL5);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA5 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA5);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
		System.out.println("Checkpoint Created Successfully Message is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");


		System.out.println("*********Creating Input Type Checkpoint**************************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI6 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		CC.SetEnterCheckpointintent(ECI6, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS6 = Lib.getCellValue(XLPATH, "Check Point", 13, 0);
		CC.SetDescription(DS6);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA6 = Lib.getCellValue(XLPATH, "Check Point", 216, 0);
		CC.SetExpectedActionFromAuditor(EA6);
		chiledTest.log(Status.INFO, "Input Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD6 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD6);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL6 = Lib.getCellValue(XLPATH, "Check Point", 207, 0);
		CC.SetRiskLevel(RL6);
		chiledTest.log(Status.INFO, "Medium Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA6 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA6);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG1 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG1)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
		System.out.println("Checkpoint Created Successfully Message is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");

		System.out.println("*********Creating Both Type Checkpoint**************************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 8, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 14, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA7 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA7);
		chiledTest.log(Status.INFO, "Both Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB7);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to Yes Disposition
		String YD17 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD17);

		//Passing the Values to Yes Disposition
		String YD27 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD27);

		//Passing the Values to Yes Disposition
		String YD37 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD37);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to No Disposition
		String ND17 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND17);

		//Passing the Values to No Disposition
		String ND27 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND27);

		//Passing the Values to No Disposition
		String ND37 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND37);

		//Checking the NO Compliance is Read Only Mode or Not?
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking the Partial Compliance is Read Only Mode or Not?
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Checking the NA Compliance is Read Only Mode or Not?
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking the Partial Disposition is Read Only Mode or Not?
		CC.VerifyPartialDispositionIsReadOnly();

		//Checking the NA Disposition is Read Only Mode or Not?
		CC.VerifyNADispositionIsReadOnly();

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//Passing the Values to Data type Values
		String SV17 = Lib.getCellValue(XLPATH, "Check Point", 140, 0);
		CC.SetDataTypeValues(SV17, driver);

		//Passing the Values to Data type Values
		String SV27 = Lib.getCellValue(XLPATH, "Check Point", 141, 0);
		CC.SetDataTypeValues(SV27, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit and Create new Button
		CC.ClickSubmitCreateBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		WebElement SuccessMSG2 = driver.findElement(By.xpath("//div[contains(text(),'Checkpoint created successfully.')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(SuccessMSG2)).isDisplayed(), "Checkpoint created successfully Message is Not Displayed");
		System.out.println("Checkpoint Created Successfully Message is Displayed");
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully. Success Message is Displayed");


		System.out.println("************Creating Check Point for Both with Condtions Type Test************");

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 15, 0);
		CC.SetDescription(DS8);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA8 = Lib.getCellValue(XLPATH, "Check Point", 218, 0);
		CC.SetExpectedActionFromAuditor(EA8);
		chiledTest.log(Status.INFO, "Both with Condtions Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB8);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to Yes Disposition
		String YD18 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD18);

		//Passing the Values to Yes Disposition
		String YD28 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD28);

		//Passing the Values to Yes Disposition
		String YD38 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD38);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to No Disposition
		String ND18 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND18);

		//Passing the Values to No Disposition
		String ND28 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND28);

		//Passing the Values to No Disposition
		String ND38 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND38);

		//Checking the NO Compliance is Read Only Mode or Not?
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking the Partial Compliance is Read Only Mode or Not?
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Checking the NA Compliance is Read Only Mode or Not?
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking the Partial Disposition is Read Only Mode or Not?
		CC.VerifyPartialDispositionIsReadOnly();

		//Checking the NA Disposition is Read Only Mode or Not?
		CC.VerifyNADispositionIsReadOnly();

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD8);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);//119
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 117, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 116, 0);
		CC.SetDataType(SD41);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL8 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL8);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected Under Risk Level");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

		System.out.println("********************************************************************");

	}

	//Testing the Functionality of the Creating Annexure Sub Audit Type For Dynamic Test
	@Test(priority=12, dependsOnMethods= {"Adding_The_4_Types_Of_Checkpoints_To_Exceptional_Group_Test"})
	public void Creating_Sub_AuditTypes_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("*****Creating Sub Audit Type For Annexure Static Test********");

		System.out.println("******Creating Sub Audit Type For Annexure Static Test*******");

		CA.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		CA.ClickConfigureAudit(driver);
		chiledTest.log(Status.INFO, "Configure Audit is Clicked");

		//Clicking on the configure Audit Sub menu
		CA.ClickConfigureAuditSubMenu();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 2);
		CA.SetAuditTypeName(ATN, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();


		//************************** Define Tab **************************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 28, 0);
		CA.SetSelectGrouptype(SGT);
		chiledTest.log(Status.INFO, "Annexure Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 1);
		CA.SetSelectCheckPointGroup(SCG, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		chiledTest = parentTest.createNode("*****Creating Sub Audit Type For Dynamic Annexure Test********");

		System.out.println("******Creating Sub Audit Type For Dynamic Annexure Test*******");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 2);
		CA.SetAuditTypeName(ATN2, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT2, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();


		//************************** Define Tab **************************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 28, 0);
		CA.SetSelectGrouptype(SGT2);
		chiledTest.log(Status.INFO, "Annexure Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 1);
		CA.SetSelectCheckPointGroup(SCG2, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("***********Creating Sub Audit Type For General Group Test*****************");

		chiledTest = parentTest.createNode("****************Creating Sub Audit Type For General Group Test**********");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 2);
		CA.SetAuditTypeName(ATN3, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT3, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();


		//************************** Define Tab **************************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT3);
		chiledTest.log(Status.INFO, "General Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 1);
		CA.SetSelectCheckPointGroup(SCG3, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG4 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 1);
		CA.SetSelectCheckPointGroup(SCG4, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");


		System.out.println("*****Creating Exceptional sub audit******");

		chiledTest.log(Status.INFO, "*****Creating Exceptional sub audit******");

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Creating General Audit Type Button is Clicked");

		//Passing the Values to Audit Type Name
		String ATN21 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 2);
		CA.SetAuditTypeName(ATN21, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT21 = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT21, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Define Tab ***********************

		//Clicking on the select Group type
		CA.ClickSelectGrouptype(driver);

		//Passing the Values to Select Group Type
		String SGT11 = Lib.getCellValue(XLPATH, "Configure Audit Type", 29, 0);
		CA.SetSelectGrouptype(SGT11);
		chiledTest.log(Status.INFO, "Select Group Type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG10 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 1);
		CA.SetSelectCheckPointGroup(SCG10, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully Success Message is Displayed");

		System.out.println("********************************************");
	}


	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=13, dependsOnMethods= {"Creating_Sub_AuditTypes_Test"})
	public void Creating_Parent_Audit_Type_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Creating Parent Audit Type Test");

		System.out.println("Creating Parent Audit Type Test");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		CA.SetAuditTypeName(ATN, driver);
		chiledTest.log(Status.INFO, "Audit Name is Entered");

		//Passing the values to Select Audit Type
		String SAT = Lib.getCellValue(XLPATH, "Configure Audit Type", 23, 0);
		CA.SetSelectAuditType(SAT, driver);
		chiledTest.log(Status.INFO, "Audit type is Selected");

		//clicking on the Matching
		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickBeginTabNextButton();


		//******* DEFINE TAB *****************************

		//Clicking on the Parent Type Audit Radio Button
		CA.ClickParentTypeAuditRadioBTN(driver);
		chiledTest.log(Status.INFO, "Parent audit type Radio Button is Clicked");

		//Clicking on the Sub Audit Type Radio Button
		CA.ClickSubAuditTypeRadioBTN();
		chiledTest.log(Status.INFO, "Sub Audit Type Radio Button is Clicked");

		//Passing the Values to select Group type
		String SA1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 2);
		CA.SetSelectSubAudittype(SA1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to select Group type
		String SA3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 2);
		CA.SetSelectSubAudittype(SA3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to select Group type
		String SA4 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 2);
		CA.SetSelectSubAudittype(SA4, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to select Group type
		String SA5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 2);
		CA.SetSelectSubAudittype(SA5, driver);

		//clicking on the Matching
		CA.ClickMatch();

		CA.SetShowAndRow(driver);

		Thread.sleep(3000);
		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int Actual_CPCount = CPSixze.size();
		int Expected_CPCount = 20;
		Assert.assertEquals(Actual_CPCount, Expected_CPCount, "Check Points Count are Wrong");
		System.out.println("Displayed Total Checkpoints counts is : " + Expected_CPCount);
		System.out.println("Total 20 Checkpoints are Displayed");
		chiledTest.log(Status.INFO, "Total 20 Checkpoints are Displayed");

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();


		// ********* EVALUATE  TAB ***************************

		//Passing the Values to Low Risk Scoring
		String LR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 10);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 8);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 9);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 11);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Talerence Risk Scoring is Entered");

		//Clicking on the Next Button
		CA.ClickEvaluteTabNextButton();


		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = driver.switchTo().alert();
		Alert.dismiss();

		//******** CONFIGURE  TAB **************

		//Clicking on the Eliminate Auditee Sign off Toggle button
		CA.ClickEliminateAuditeeSignoffTaggleBTN();
		chiledTest.log(Status.INFO, "Eliminate Auditee Sign off Toggle button is clicked");

		//Clicking on the Do you need annexure score ?
		CA.ClickAnnexureScoreTaggleBTN();
		chiledTest.log(Status.INFO, "Do you need annexure score ? Toggle button is clicked");

		//Clicking on the Annexure Sampling Toggle Button
		CA.ClickAnnexureSamplingTaggleBTN();
		chiledTest.log(Status.INFO, "Annexure Sampling Toggle Button is clicked");

		//Clicking on the Select verifier
		CA.clickSelectVerifier();

		//Passing the Values to Select Verifier
		String SV = Lib.getCellValue(XLPATH, "Configure Audit Type", 58, 0);
		CA.SetSelectVerifier(SV);
		chiledTest.log(Status.INFO, "Verifier is Selected");

		//Clicking on the Match
		CA.ClickMatch();

		//Passing the Values to Low Due Days
		String SL = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 10);
		CA.SetLowDueDays(SL);
		chiledTest.log(Status.INFO, "Low Due Days is Entered");

		//Passing the Values to Medium Due Days
		String SM = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 8);
		CA.SetMediumDueDays(SM);
		chiledTest.log(Status.INFO, "Medium Due Days is Entered");

		//Passing the Values to High Due Days
		String SH = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 9);
		CA.SetHighDueDays(SH);
		chiledTest.log(Status.INFO, "High Due Days is Entered");

		//Passing the Values to ZT Due Days
		String SZ = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 11);
		CA.SetZTDueDays(SZ);
		chiledTest.log(Status.INFO, "ZT Due Days is Entered");

		//Clicking on the Frequency
		CA.ClickFrequency(driver);

		//Passing the Values to Frequency
		String SF = Lib.getCellValue(XLPATH, "Configure Audit Type", 103, 0);
		CA.SetFrequency(SF);
		chiledTest.log(Status.INFO, "Frequency is Selected");

		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();


		//******************** Finalize Tab ************************

		Thread.sleep(5000);

		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger main-type']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		double d = 110.0;
		String Str = Double.toString(d);
		Assert.assertEquals(TotalScoreCount, Str, "Total Score count is showing Wrong");
		System.out.println("Diplayed Total Score is : " + Str);

		//Checking the To Count
		String Actual_TO = driver.findElement(By.xpath("//input[@id='audit_type_audit_ratings_attributes_0_to']")).getAttribute("value");
		System.out.println("TO Count is : " + Actual_TO);
		int d1 = 100;
		String Str1 = Integer.toString(d1);
		Assert.assertEquals(Actual_TO, Str1, "Total Score count is showing Wrong");

		//Passing the Valid Exceptional Max Deduction
		String MD1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 164, 0);
		CA.SetMaxDeduction(MD1);
		chiledTest.log(Status.INFO, "Valid Exceptional Max Deduction is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to First TO
		String FT = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 13);
		CA.SetFirstTo(FT, driver);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 14);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Second TO
		String ST1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 13);
		CA.SetSecondTo(ST1, driver);

		//Passing the Values to Second Out Come
		String SO = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 14);
		CA.SetSecondOutCome(SO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Passing the Values to Third Out Come
		String TO1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 14);
		CA.SetThirdOutCome(TO1, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully. Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully. Success Message is Displayed");

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Upload Document page
	@Test(priority=14, dependsOnMethods= {"Creating_Parent_Audit_Type_Test"})
	public void Uploading_Annexure_Documents_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Uploading Static Annexure Document Test");

		System.out.println("Uploading Static Annexure Documenet Test");

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

		UA.ClickScrollBar(driver);

		UA.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annecxure is Clicked");

		UA.ClickAnnexureDocuments(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents is Clicked");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(2000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'POPSL S1 Static Sub Audit Type')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(2000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		UA.VerifyStaticAnnexureTypeIsDisplayed();

		//Uploading Documents
		UA.UploadDocument();
		chiledTest.log(Status.INFO, "Document is Uploaded");

		//Clicking on the submit Button
		UA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Document Uploaded Successfully Message is Displayed 
		UA.VerifyDocumentUploadedSuccessfully(driver);
		chiledTest.log(Status.INFO, "Document Uploaded Successfully Message is Displayed");

		System.out.println("*********Uploading the Annexure Document for Dyanamic Annexure*******************");

		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Dyanamic Annexure*******************");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		UA.SetAuditType(SA1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'POPSL S1 Dynamic Sub Audit Type')]")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		UA.VerifyDynamicAnnexureTypeIsDisplayed();

		//Passing the values to From Date
		String FD = Lib.getCellValue(XLPATH, "Annexure Documents", 3, 0);
		UA.SetFromDate(FD, driver);
		chiledTest.log(Status.INFO, "From Date is Entered");

		//Passing the values to From Date
		String TD = Lib.getCellValue(XLPATH, "Annexure Documents", 4, 0);
		UA.SetToDate(TD, driver);
		chiledTest.log(Status.INFO, "TO Date is Entered");

		//Uploading Documents
		UA.UploadDocument();
		chiledTest.log(Status.INFO, "Document is Uploaded");

		//Clicking on the submit Button
		UA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Document Uploaded Successfully Message is Displayed 
		UA.VerifyDocumentUploadedSuccessfully(driver);
		chiledTest.log(Status.INFO, "Document Uploaded Successfully Message is Displayed");

		System.out.println("*************************************");

	}

	//Configuring the Auditee admin configuration
	@Test(priority=15, dependsOnMethods= {"Uploading_Annexure_Documents_Test"})
	public void Auditee_Admin_Configuration_Test() throws InterruptedException
	{
		SideMenuPageTest SM = new SideMenuPageTest(driver);

		AuditeeadminConfigurationPageTest AA = new AuditeeadminConfigurationPageTest(driver);

		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Auditee Admin Configuration Test");

		System.out.println("Auditee Admin Configuration Test");

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

		//clicking on the Scroll bar
		SM.ClickScrollBar();

		//clicking on the Configure audit
		SM.ClickConfigureAudit();

		//clicking on the Audoitee admin Configure under side menu
		SM.clickAuditeeAdminConfigure();

		AA.ClickSelectAuditType();

		//passing the values to Select Audit Type
		String SA = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		AA.SetSetAuditType(SA);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 3, 0);
		AA.SetIssueAssignment(IA);

		AA.ClickMatchedText();

		//passing the Values to Issue Assignment
		String IA1 = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 4, 0);
		AA.SetIssueAssignment(IA1);

		AA.ClickMatchedText();

		//Passing the Values to Respond issue
		String RI = Lib.getCellValue(XLPATH, "Auditee Admin Configuration", 3, 1);
		AA.SetRespondIssue(RI);

		AA.ClickMatchedText();

		//clicking on the Save button
		AA.ClickSaveBTN();

		//Verifying Auditee configuration successfully done message is Displayed
		AA.VerifyAuditeeConfigurationSuccessfullyDoneMsGIsDisplayed();

		System.out.println("******************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=16, dependsOnMethods= {"Auditee_Admin_Configuration_Test"})
	public void Creating_Audit_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Audit Schedule Test");

		System.out.println("Creating Audit Schedule Test");

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

		SP.ClickScrollBar(driver);

		//Clicking on the Schedule 
		SP.ClickSchedule(driver);

		//Clicking on the Audit Schedule
		SP.ClickAuditSchedule(driver);
		chiledTest.log(Status.INFO, "Audit Schedule is Clicked");

		//Clicking on the Create New Schedule Button
		SP.ClickCreateNewSheduleBTN();
		chiledTest.log(Status.INFO, "Create New Schedule Button is clicked");

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		SP.SetSelectAuditType(SAT1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Vendor Option Under Select Auditee Type Drop Down List
		SP.ClickVendorOption(driver);

		//Clicking on the Select country/State/Location
		SP.ClickSelectCountryStateLocation(driver);

		//Passing the Values to Select country/State/Location
		String CSL1 = Lib.getCellValue(XLPATH, "Schedule", 6, 0);
		SP.SetCountryStateLocation(CSL1, driver);
		chiledTest.log(Status.INFO, "Country/State/Location is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Select Auditee
		SP.ClickSelectAuditee(driver);

		//Passing the Values to Select Auditee
		String SA2 = Lib.getCellValue(XLPATH, "Schedule", 9, 0);
		SP.SetSelectAuditeeText(SA2, driver);
		chiledTest.log(Status.INFO, "Select Auditee is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Start Date
		SP.ClickStartDate();

		//Selecting the today Date under Start Date
		SP.ClickTodayStartDate(driver);

		//Clicking on the End date
		SP.ClickEndDate();

		//Selecting the Today date under End Date
		SP.ClickTodayEndDate(driver);

		//Selecting Auditor
		String SA3 = Lib.getCellValue(XLPATH, "Schedule", 33, 0);
		SP.SetSetSelectAuditor(SA3);
		chiledTest.log(Status.INFO, "Auditor is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Save Button
		SP.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Schedule created successfully Success Message is Displayed
		SP.VerifyScheduleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Schedule created successfully. Success Message is displayed");

		System.out.println("****************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=17, dependsOnMethods= {"Creating_Audit_Schedule_Test"})
	public void Audit_Execution_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Audit Execution Test");

		System.out.println("Audit Execution Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",42,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",42,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		//Passing the General Parent Audit type to Audit Type
		String AT2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		AE.SetAuditType(AT2, driver);
		chiledTest.log(Status.INFO, "Audit Type is Searched");

		AE.ClickMatched();

		//Clicking on the Accept Button
		AE.ClickAcceptBTN(driver);
		chiledTest.log(Status.INFO, "Accept Button is Clicked");

		//Verifying Audit accepted successfully Success Message is Displayed
		AE.VerifyAuditAcceptedSuccesfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit accepted successfully Success Message is Displayed");

		driver.navigate().refresh();

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		System.out.println("************** Executing the 1st General Sub Audit Type *****************");

		chiledTest.log(Status.INFO, "************** Executing the 1st General  Sub Audit Type *****************");

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 2);
		AE.SetSearchBTN(SB11);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		AE.Clicknormal(driver);

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER1 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER1);


		//Passing the Values to Enter confidential Remarks
		String ECR1 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR1);


		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER2 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER2);


		//Passing the Values to Enter confidential Remarks
		String ECR2 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR2);


		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER3 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER3);


		//Passing the Values to Enter confidential Remarks
		String ECR3 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR3);


		//Clicking on the NA Button
		AE.ClickNAButton();

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER4 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER4);


		//Passing the Values to Enter confidential Remarks
		String ECR4 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR4);

		//Clicking on the Partial Button
		AE.ClickPartialButton();

		//Passing the Values to Max values
		String MV1 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 102, 0);
		AE.SetMaxValues(MV1, driver);
		chiledTest.log(Status.INFO, "100 is enterd under MAX values");

		//Moving slider to 50%
		AE.MoveSlider(driver);

		//Passing the Values to Enter Input Values
		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV1, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("************** Executing the 2nd Group *****************");

		chiledTest.log(Status.INFO, "************** Executing the 2nd Group *****************");

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER5 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER5);


		//Passing the Values to Enter confidential Remarks
		String ECR5 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR5);


		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER6 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER6);


		//Passing the Values to Enter confidential Remarks
		String ECR6 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR6);


		//Clicking on the NA Button
		AE.ClickNAButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER7 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER7);


		//Passing the Values to Enter confidential Remarks
		String ECR7 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR7);


		//Clicking on the NA Button
		AE.ClickNAButton();

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER8 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER8);


		//Passing the Values to Enter confidential Remarks
		String ECR8 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR8);


		//Clicking on the Partial Button
		AE.ClickPartialButton();
		
		//Passing the Values to Max values
		String MV2 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 102, 0);
		AE.SetMaxValues(MV2, driver);
		chiledTest.log(Status.INFO, "100 is enterd under MAX values");

		//Moving slider to 50%
		AE.MoveSlider(driver);

		//Passing the Values to Enter Input Values
		String IV2 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV2, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//clicking on the Finish Button
		AE.ClickFinishBTN(driver);


		//Verifying Audit Submitted Successfully message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Successfully message is Displayed");


		System.out.println("*************Exceuting Exceptional Sub Audits Through Normal Mode**********");

		chiledTest.log(Status.INFO, "*********Exceuting Exceptional Sub Audits Through Normal Mode*******");

		//Passing the Values to Search Text Filed
		String SB3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 2); 
		AE.SetSearchBTN(SB3);
		chiledTest.log(Status.INFO, "General Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		AE.Clicknormal(driver);

		System.out.println("***********************1st Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER26 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER26);


		//Passing the Values to Enter confidential Remarks
		String ECR26 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR26);


		//Clicking on the Yes Button
		AE.ClickYesButton();
		chiledTest.log(Status.INFO, "Yes Button is Clicked");


		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER27 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER27);


		//Passing the Values to Enter confidential Remarks
		String ECR27 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR27);


		//Passing the Values to Enter Input Values
		String IV12 = Lib.getCellValue(XLPATH, "Audit Execution", 42, 0);
		AE.SetEnterInputValues(IV12, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER28 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER28);


		//Passing the Values to Enter confidential Remarks
		String ECR28 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR28);


		//Clicking on the No Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "No Button is Clicked");

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("***********************4th Check Point***********************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER29 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER29);


		//Passing the Values to Enter confidential Remarks
		String ECR29 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR29);


		//Clicking on the No Button
		AE.ClickNoButton();
		chiledTest.log(Status.INFO, "No Button is Clicked");

		//Passing the Values to Enter Input Values
		String IV13 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV13, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//clicking on the Finish Button
		AE.ClickFinishBTN(driver);


		//Verifying Audit Submitted Successfully message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Successfully message is Displayed");

		System.out.println("************** Executing the Dyanamic Annexure Sub Audit Type *****************");

		chiledTest.log(Status.INFO, "************** Executing the Dyanamic Annexure Sub Audit Type *****************");

		//Passing the Values to Search Text Filed
		String SB13 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 2);
		AE.SetSearchBTN(SB13);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		System.out.println("*******Adding New PI*****");

		chiledTest.log(Status.INFO, "**** Executing 1st PI ****");

		//Clicking on the Add New PI Button
		AE.ClickAddNewPIBTN(driver);
		chiledTest.log(Status.INFO, "Add New PI Button is Clicked");

		//Passing the Values to Primary Identifier Name
		String PIN11 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN11, driver);
		chiledTest.log(Status.INFO, "Primary Identifier Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);


		System.out.println("**** Executing 1st PI ****");

		chiledTest.log(Status.INFO, "**** Executing 1st PI ****");

		//Passing the Values to Search Button
		String SB4 = Lib.getCellValue(XLPATH, "Audit Execution", 58, 0);
		AE.SetPiSearchBTN(SB4);

		//Clicking on the Started Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Normal Mode
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");


		System.out.println("**********1st Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER9 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER9);


		//Passing the Values to Enter confidential Remarks
		String ECR9 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR9);


		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER10 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER10);


		//Passing the Values to Enter confidential Remarks
		String ECR10 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR10);


		//Clicking on the NO Button
		AE.ClickNoButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER11);


		//Passing the Values to Enter confidential Remarks
		String ECR11 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR11);

		//Clicking on the NA Button
		AE.ClickNAButton();

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER12 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER12);


		//Passing the Values to Enter confidential Remarks
		String ECR12 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR12);


		//Clicking on the Partial Button
		AE.ClickPartialButton();

		//Passing the Values to Max values
		String MV3 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 102, 0);
		AE.SetMaxValues(MV3, driver);
		chiledTest.log(Status.INFO, "100 is enterd under MAX values");

		//Moving slider to 50%
		AE.MoveSlider(driver);

		//Passing the Values to Enter Input Values
		String IV3 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV3, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//clicking on the Finish Button
		AE.ClickFinishBTN(driver);


		//Verifying Audit Submitted Successfully message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Successfully message is Displayed");

		System.out.println("**** Executing 2nd PI ****");

		chiledTest.log(Status.INFO, "**** Executing 2nd PI ****");

		//Passing the Values to Search Button
		String SB5 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPiSearchBTN(SB5);

		//Clicking on the Started Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Normal Mode
		AE.Clicknormal(driver);
		chiledTest.log(Status.INFO, "Normal Button is Clicked");

		System.out.println("**********1st Check Point*************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER13 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER13);


		//Passing the Values to Enter confidential Remarks
		String ECR13 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR13);


		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************2nd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER14 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER14);


		//Passing the Values to Enter confidential Remarks
		String ECR14 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR14);


		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("***********************3rd Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER15 = Lib.getCellValue(XLPATH, "Audit Execution", 13, 0);
		AE.SetEnterRemarks(ER15);


		//Passing the Values to Enter confidential Remarks
		String ECR15 = Lib.getCellValue(XLPATH, "Audit Execution", 28, 0);
		AE.SetEnterConfidentalRemarks(ECR15);


		//Clicking on the NA Button
		AE.ClickNAButton();

		//Selecting the 1st Values from the Input Values drop down
		AE.SelectingValues(driver);
		chiledTest.log(Status.INFO, "Values is selected");

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("***********************4th Check Point*************************");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER16 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER16);


		//Passing the Values to Enter confidential Remarks
		String ECR16 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR16);


		//Clicking on the Partial Button
		AE.ClickPartialButton();

		//Passing the Values to Max values
		String MV4 = Lib.getCellValue(XLPATH, "FXSL Scenarios 1", 102, 0);
		AE.SetMaxValues(MV4, driver);
		chiledTest.log(Status.INFO, "100 is enterd under MAX values");

		//Moving slider to 50%
		AE.MoveSlider(driver);

		//Passing the Values to Enter Input Values
		String IV4 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV4, driver);
		chiledTest.log(Status.INFO, "Input Value is Entered");

		//clicking on the Finish Button
		AE.ClickFinishBTN(driver);


		//Verifying Audit Submitted Successfully message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Successfully message is Displayed");

		System.out.println("******Executing 2nd PI Has NOT Found****");

		chiledTest.log(Status.INFO, "******Executing 2nd PI Has NOT Found****");


		//Passing the Values to Search Button
		String SB721 = Lib.getCellValue(XLPATH, "Audit Execution", 59, 0);
		AE.SetPiSearchBTN(SB721);

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Selecting Other Option Under Reason
		String SR121 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR121);
		chiledTest.log(Status.INFO, "Others Option is Selected Under Reason Drop down");

		AE.ClickMatched();

		//Passing the Values to Reason
		String NFR2 = Lib.getCellValue(XLPATH, "Audit Execution", 49, 0);
		AE.SetNOTFoundReason(NFR2);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("*****Exceuting the Remaining PI Has Mark Pending PI*****");

		chiledTest.log(Status.INFO, "Submit audit button is Clicked");

		AE.ClearPiSearchBTN();

		//Clicking on the Mark Pending Pi as Not Executed
		AE.ClickMarkPendingPIAsNotExecuted();

		//clicking on the OK Button
		AE.ClickOKBTN1(driver);

		System.out.println("*****Exceuting Dynamic Annexure sub audits****");

		chiledTest.log(Status.INFO, "*****Exceuting Dynamic Annexure sub audits****");

		//Passing the Values to Search Text Filed
		String SB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 2);
		AE.SetSearchBTN(SB7);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		System.out.println("***Exceuting 1st PI Has Not Found***");

		chiledTest.log(Status.INFO, "***Exceuting 1st PI Has Not Found***");

		//Passing the Values to Search Button
		String SB8 = Lib.getCellValue(XLPATH, "Audit Execution", 58, 0);
		AE.SetPiSearchBTN(SB8);
		chiledTest.log(Status.INFO, "1st PI is Searched");

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR);

		AE.ClickMatched();

		//Entering the Reason
		String NFR = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***Exceuting 2nd PI Has Not Found***");

		chiledTest.log(Status.INFO, "***Exceuting 2nd PI Has Not Found***");

		//Passing the Values to Search Button
		String SB9 = Lib.getCellValue(XLPATH, "Audit Execution", 59, 0);
		AE.SetPiSearchBTN(SB9);
		chiledTest.log(Status.INFO, "2nd PI is Searched");

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR2 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR2);

		AE.ClickMatched();

		//Entering the Reason
		String NFR3= Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR3);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***Exceuting 3rd PI Has Not Found***");

		chiledTest.log(Status.INFO, "***Exceuting 3rd PI Has Not Found***");

		//Passing the Values to Search Button
		String SB10 = Lib.getCellValue(XLPATH, "Audit Execution", 60, 0);
		AE.SetPiSearchBTN(SB10);
		chiledTest.log(Status.INFO, "1st PI is Searched");

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR10 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR10);

		AE.ClickMatched();

		//Entering the Reason
		String NFR10 = Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR10);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		System.out.println("***Exceuting 4th PI Has Not Found***");

		chiledTest.log(Status.INFO, "***Exceuting 4th PI Has Not Found***");

		//Passing the Values to Search Button
		String SB12 = Lib.getCellValue(XLPATH, "Audit Execution", 61, 0);
		AE.SetPiSearchBTN(SB12);
		chiledTest.log(Status.INFO, "2nd PI is Searched");

		//Clicking on the Not Found Button
		AE.ClickNotFoundBTN(driver);
		chiledTest.log(Status.INFO, "Not Found Button");

		//Verifying Reason Pop Up is Displayed
		AE.VerifyingReasonPopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Reason Pop Up is Displayed is Displayed");

		//Clicking on the Please Select
		AE.ClickPleaseSelect();

		//Passing the Values to Reason
		String SR11 = Lib.getCellValue(XLPATH, "Audit Execution", 48, 0);
		AE.SetReason(SR11);

		AE.ClickMatched();

		//Entering the Reason
		String NFR11= Lib.getCellValue(XLPATH, "Audit Execution", 100, 0);
		AE.SetNOTFoundReason(NFR11);

		//Clicking on the Submit Button
		AE.ClickSubmitButton();

		//clicking on the OK Button
		AE.ClickOKBTN1(driver);

		//Passing the Values to Audit Level Recommendation 
		String AR = Lib.getCellValue(XLPATH, "Audit Execution", 115, 0);
		AE.SetAuditLevelRecommendation(AR);

		//Passing the Values to Audit level Observation
		String AO = Lib.getCellValue(XLPATH, "Audit Execution", 118, 0);
		AE.SetAuditLevelObservations(AO);

		//Clicking on the Submit audit button
		AE.ClickSubmitAuditBTN(driver);
		chiledTest.log(Status.INFO, "Submit audit button is Clicked");

		//verifying submitted successfully Success Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Submitted successfully Success Message is Displayed");

		System.out.println("*******************************");

	}

	//Testing the Functionality of the Finalize Audit
	@Test(priority=18, dependsOnMethods= {"Audit_Execution_Test"})
	public void Finalize_Audit_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Finalize Audit Test");

		System.out.println("Finalize Audit Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

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

		//Clicking on the Scroll Bar
		RA.ClickScrollBar(driver);

		//Clicking on the Review Audit side menu
		RA.ClickReviewAudit(driver);
		chiledTest.log(Status.INFO, "Review Audit is Clicked");

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****************Reviewing and Finalizing Static Annxure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Static Annxure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 2);
		RA.SetSubAudits(SA);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing Dynamic Annxure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Dynamic Annxure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA4 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 2);
		RA.SetSubAudits(SA4);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//Checking Review button should not be display
		RA.VerifyReviewButtonShouldNotDisplay();

		System.out.println("*****************Reviewing and Finalizing 1st general Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing 1st general Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 2);
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 1);
		RA.SetGroup(SA2);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 1);
		RA.SetGroup(SA3);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing Execptional Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Execptional Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 2);
		RA.SetSubAudits(SA5);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		//Clicking on the Main Audit Finalize button
		RA.ClickMainAuditFinalizeBTN();

		//verifying Audit Finalized Successfully message is displayed
		RA.VerifyAuditFinalizedSuccessfullySuccessMsgIsDisplayed(driver);

		System.out.println("**************************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=19, dependsOnMethods= {"Finalize_Audit_Test"})
	public void Validating_The_Scores_Test() throws InterruptedException
	{

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		System.out.println("Validating the Score Test");

		chiledTest = parentTest.createNode("Validating the Score Test");

		RA.ClickReviewAuditHeader(driver);

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		//clicking on the summary button
		RA.ClickSummaryBTN();

		Thread.sleep(2000);

		//Checking the Total Score
		String Actual_TotalScore = driver.findElement(By.xpath("//div[@class='recalc_total_score']")).getText();
		System.out.println("Actual Total Score is : " + Actual_TotalScore);
		String Expected_TotalScore = "70.5 / 110.0"; 
		System.out.println("Expected Total Score is : " + Expected_TotalScore);
		Assert.assertEquals(Actual_TotalScore, Expected_TotalScore, "Total Score is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Total score are Matched");

		//Checking the Audit rating
		String Actual_AuditRating = driver.findElement(By.xpath("//div[@class='recalc_rating']")).getText();
		System.out.println("Actual Rating is : " + Actual_AuditRating);
		String Expected_AuditRating = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 14);
		System.out.println("Expected Rating is : " + Expected_AuditRating);
		Assert.assertEquals(Actual_AuditRating, Expected_AuditRating, "Audit Rating is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual ratings are Matched");

		//Checking the Compliances %
		String Actual_Compliances = driver.findElement(By.xpath("//div[@class='recalc_compliance_percentage']")).getText();
		System.out.println("Actual Rating is : " + Actual_Compliances);
		String Expected_Compliances = "64.09";
		System.out.println("Expected Compliance is : " + Expected_Compliances);
		Assert.assertEquals(Actual_Compliances, Expected_Compliances, "Compliances % is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Compliances % are Matched");

		RA.ClickSummaryCloseBTN();

		System.out.println("********************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=20, dependsOnMethods= {"Finalize_Audit_Test"})
	public void Update_Annexure_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AnnexurePageTest AT = new AnnexurePageTest(driver);

		System.out.println("Update Annexure Test");

		chiledTest = parentTest.createNode("Update Annexure Test");

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

		AT.ClickScrollBar(driver);

		//Clicking on the Annexure
		AT.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annexure is Clicked from Side Menu");

		//Clicking on the Add Annexure
		AT.ClickAddAnnexures(driver);
		chiledTest.log(Status.INFO, "Add Annexure is Clicked from Side Menu");

		//Clicking on the Annexures
		AT.ClickAnnexureNameDropDown();
		chiledTest.log(Status.INFO, "Annexures is Clicked");

		System.out.println("***************Updating Static Annexure ***************");

		chiledTest.log(Status.INFO, "*************Updating Static Annexure **************");

		AT.ClickAnnexureNameDropDown();

		//Passing the values to Annexure name drop down
		String AN = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 0);
		AT.SetAnnexureNameDropDown(AN);

		AT.ClickMatched();

		//clicking on the Edit Button
		AT.ClickEditButton();

		//In activating 1st columns
		WebElement CH1 = driver.findElement(By.xpath("//input[@id='annexure_annexure_configurations_attributes_1_active']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CH1);

		//adding new Configure columns
		AT.ClickAddButton1();

		//passing the Values to 5th attribute index
		String FHI = Lib.getCellValue(XLPATH, "Annexure", 33, 0);
		AT.SetFifthAttributIndex(FHI);

		//Passing the Values to 5th Attribute Name
		String FAN = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		AT.SetFifthAttributeName(FAN);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Both with condition Option
		WebElement ListBox3 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[5]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select3 = new Select(ListBox3);
		List<WebElement> alloptions3 = select3.getOptions();
		WebElement all3 = alloptions3.get(3);
		all3.click();

		//Updating the Reason
		String SR = Lib.getCellValue(XLPATH, "Annexure", 22, 0);
		AT.SetReason1(SR);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		AT.ClickAddBTN2();

		//Passing the Values to the Reason
		String SR1 = Lib.getCellValue(XLPATH, "Annexure", 23, 0);
		AT.SetReason3(SR1);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		//Clicking on the Save Button
		AT.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Annexure created successfully Success Message is Displayed
		AT.VerifyAnnexureWasSuccessfullyUpdatedMSGIsDisplayed(driver);

		System.out.println("***************Updating Dynamic Annexure ***************");

		chiledTest.log(Status.INFO, "*************Updating Dynamic Annexure **************");

		AT.ClickAnnexureNameDropDown();

		//Passing the values to Annexure name drop down
		String AN1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 0);
		AT.SetAnnexureNameDropDown(AN1);

		AT.ClickMatched();

		//clicking on the Edit Button
		AT.ClickEditButton();

		//In activating 3rd columns
		WebElement CH4 = driver.findElement(By.xpath("//input[@id='annexure_annexure_configurations_attributes_3_active']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", CH4);

		//************adding new Configure columns*************
		AT.ClickAddButton1();

		//passing the Values to 5th attribute index
		String FHI1 = Lib.getCellValue(XLPATH, "Annexure", 33, 0);
		AT.SetFifthAttributIndex(FHI1);

		//Passing the Values to 5th Attribute Name
		String FAN1 = Lib.getCellValue(XLPATH, "Annexure", 12, 0);
		AT.SetFifthAttributeName(FAN1);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Both with condition Option
		WebElement ListBox31 = driver.findElement(By.xpath("//table[@id='annexure_table']/tbody/tr[5]//select[@class='full-width select2-drop-multi select2-offscreen']"));
		Select select31 = new Select(ListBox31);
		List<WebElement> alloptions31 = select31.getOptions();
		WebElement all31 = alloptions31.get(2);
		all31.click();

		//Updating the Reason
		String SR2 = Lib.getCellValue(XLPATH, "Annexure", 22, 0);
		AT.SetReason1(SR2);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		AT.ClickAddBTN2();

		//Passing the Values to the Reason
		String SR3 = Lib.getCellValue(XLPATH, "Annexure", 23, 0);
		AT.SetReason3(SR3);
		chiledTest.log(Status.INFO, "Configure Reason is Entered");

		//Clicking on the Save Button
		AT.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Annexure created successfully Success Message is Displayed
		AT.VerifyAnnexureWasSuccessfullyUpdatedMSGIsDisplayed(driver);

		System.out.println("***********************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=21, dependsOnMethods= {"Update_Annexure_Test"})
	public void Updating_Annexure_Groups_Checkpoints_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Updating Annexure Groups Checkpoints Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest = parentTest.createNode("Updating Annexure Groups Checkpoints Test");

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

		System.out.println("********Updating the Static Annexure Group Checkpoints**********");

		chiledTest.log(Status.INFO, "********Updating the Static Annexure Group Checkpoints**********");

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 1);
		CC.SetSearchBTN(SS);

		CC.ClickNumberOfCheckBoxButton(driver);

		//Validating 1check points should show Inactive
		List<WebElement> inactiveststus = driver.findElements(By.xpath("//td[text()='Inactive']"));
		int Actaul_Count = inactiveststus.size();
		int Expected_count = 2;
		Assert.assertEquals(Actaul_Count, Expected_count, "2 Checkpoints are not showed as inactive status");
		System.out.println("2 Checkpoint is showing as inactive");
		chiledTest.log(Status.INFO, "2 Checkpoint is showing as inactive");

		System.out.println("************Adding new Both With Conditions Type Checkpoint *****************");

		chiledTest.log(Status.INFO, "***********Adding new Both With Conditions Type Checkpoint ****************");

		//clicking on the add new checkpoint button
		CC.ClickAddNewcheckpointBTN(driver);

		//Passing the Values to the Enter Checkpoint intent
		String ECI8 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI8, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS8 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS8);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Checking the Selected annexure Columns should show only active columns
		List<WebElement> Annexurescolumns = driver.findElements(By.xpath("//select[@id='check_point_complaince_annexure_configuration_id']/option"));
		int Actual_Columnscount = Annexurescolumns.size();
		int Expected_Columnscount = 4;
		Assert.assertEquals(Actual_Columnscount, Expected_Columnscount, "inactivated Annexure columns are showing while adding the new checkpoints");
		System.out.println("Inactivated annexure columns are not showing");
		chiledTest.log(Status.INFO, "Inactivated annexure columns are not showing");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC3 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		CC.SetSelectAnnexureColumns(SAC3);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB3);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD8 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD8);

		//Passing the Values to No Disposition
		String ND8 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND8);

		//Passing the Values to Partial Disposition
		String PD8 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD8);

		//Passing the Values to NA Disposition
		String ND118 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND118);

		//clicking on the 1st data type	
		CC.ClickFirstDataType(driver);

		//Passing the Values to Data Type 
		String SD8 = Lib.getCellValue(XLPATH, "Check Point", 119, 0);
		CC.SetDataType(SD8);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 2st data type
		CC.ClickSecondDataType(driver);

		//Passing the Values to Data Type 
		String SD11 = Lib.getCellValue(XLPATH, "Check Point", 114, 0);
		CC.SetDataType(SD11);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 3rd data type
		CC.ClickThirdDataType(driver);

		//Passing the Values to Data Type 
		String SD31 = Lib.getCellValue(XLPATH, "Check Point", 115, 0);
		CC.SetDataType(SD31);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the 4th data type
		CC.ClickFourthDataType(driver);

		//Passing the Values to Data Type 
		String SD41 = Lib.getCellValue(XLPATH, "Check Point", 113, 0);
		CC.SetDataType(SD41);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL8 = Lib.getCellValue(XLPATH, "Check Point", 209, 0);
		CC.SetRiskLevel(RL8);
		chiledTest.log(Status.INFO, "Zero Tolerance Option is Selected Under Risk Level");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA8 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA8);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

		System.out.println("********Updating the Dynamic Annexure Group Checkpoints**********");

		chiledTest.log(Status.INFO, "********Updating the Dynamic Annexure Group Checkpoints**********");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 1);
		CC.SetSearchBTN(SS1);

		CC.ClickNumberOfCheckBoxButton(driver);

		//Validating 1 check points should show inactive
		List<WebElement> inactiveststus1 = driver.findElements(By.xpath("//td[text()='Inactive']"));
		int Actaul_Count1 = inactiveststus1.size();
		int Expected_count1 = 1;
		Assert.assertEquals(Actaul_Count1, Expected_count1, "1 Inactive checkpoints are Not Displayed displayed");
		System.out.println("1 Inactive checkpoints is displayed");
		chiledTest.log(Status.INFO, "1 Inactive checkpoints is displayed");

		System.out.println("************Adding new Both Type of Checkpoint *****************");

		chiledTest.log(Status.INFO, "************Adding new Both Type of Checkpoint ***************");

		//clicking on the add new checkpoint button
		CC.ClickAddNewcheckpointBTN(driver);

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//Checking the Selected annexure Columns should show only active columns
		List<WebElement> Annexurescolumns1 = driver.findElements(By.xpath("//select[@id='check_point_complaince_annexure_configuration_id']/option"));
		int Actual_Columnscount1 = Annexurescolumns1.size();
		int Expected_Columnscount1 = 4;
		Assert.assertEquals(Actual_Columnscount1, Expected_Columnscount1, "inactivated Annexure columns are showing while adding the new checkpoints");
		System.out.println("Inactivated annexure columns are not showing");
		chiledTest.log(Status.INFO, "Inactivated annexure columns are not showing");

		//Clicking on the Select Annexure Columns 
		CC.ClickSelectAnnexureColumns(driver);

		//Passing the values to select Annexure Columns
		String SAC2 = Lib.getCellValue(XLPATH, "Annexure", 12, 0);
		CC.SetSelectAnnexureColumns(SAC2);
		chiledTest.log(Status.INFO, "select Annexure Columns is Selected");

		//Clicking on the Matched text
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 5);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 6);
		CC.SetNATextBox(NAB2);

		//Checking the Partial Text is not Editable 
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to Partial Disposition
		String PD7 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD7);

		//Passing the Values to NA Disposition
		String ND117 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND117);

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

		System.out.println("***********Inactivating Newly added Checkpoint*********");

		chiledTest.log(Status.INFO, "*********Inactivating Newly added Checkpoint*******");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 1);
		CC.SetSearchBTN(SS2);

		try{
			Thread.sleep(2000);
			//checking the No of Checkpoints count
			WebElement NoOfCPcount = driver.findElement(By.xpath("//a[text()='5']"));
			Assert.assertTrue(NoOfCPcount.isDisplayed(), "No Of Checkpoint count is showing wrong");
			System.out.println("No Of Checkpoint count is showing 5");
			chiledTest.log(Status.INFO, "No Of Checkpoint count is showing 5");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
		}

		//clicking on the No of Checkpoint
		CC.ClickNumberOfCheckBoxButton(driver);

		//clicking on the 5th Checkpoint
		CC.ClickFifthcheckpoint(driver);

		//clicking on the Activate Button
		CC.ClickEditPageActivateBTN();

		//Clicking on the submit button
		CC.ClickEditPageSubmitButton();

		//checkpoint updated successfully message is displayed
		CC.VerifyCheckpointUpdatedSuccessfullySuccessMSGIsDisplayed(driver);

		System.out.println("*********************************");


	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=22, dependsOnMethods= {"Updating_Annexure_Groups_Checkpoints_Test"})
	public void Updating_General_Groups_Checkpoints_Test() throws InterruptedException
	{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Updating General Groups Checkpoints Test");

		chiledTest = parentTest.createNode("Updating General Groups Checkpoints Test");

		System.out.println("***********Inactivating 2nd Checkpoint in 1st General Group*********");

		chiledTest.log(Status.INFO, "*********Inactivating 2nd Checkpoint 1st General Group*******");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 1);
		CC.SetSearchBTN(SS);

		CC.ClickNumberOfCheckBoxButton(driver);

		//clicking on the 2nd Checkpoint
		CC.ClickSecondCheckpoint(driver);

		//clicking on the Activate Button
		CC.ClickEditPageActivateBTN();

		//Clicking on the submit button
		CC.ClickEditPageSubmitButton();

		//checkpoint updated successfully message is displayed
		CC.VerifyCheckpointUpdatedSuccessfullySuccessMSGIsDisplayed(driver);

		System.out.println("***********Inactivating 1st Checkpoint in 1st General Group*********");

		chiledTest.log(Status.INFO, "*********Inactivating 1st Checkpoint 1st General Group*******");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 1);
		CC.SetSearchBTN(SS1);

		CC.ClickNumberOfCheckBoxButton(driver);

		//clicking on the 1st Checkpoint
		CC.ClickFirstCheckpoint(driver);

		//clicking on the Activate Button
		CC.ClickEditPageActivateBTN();

		//Clicking on the submit button
		CC.ClickEditPageSubmitButton();

		//checkpoint updated successfully message is displayed
		CC.VerifyCheckpointUpdatedSuccessfullySuccessMSGIsDisplayed(driver);

		System.out.println("***************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=23, dependsOnMethods= {"Updating_General_Groups_Checkpoints_Test"})
	public void Updating_Exceptional_Groups_Checkpoints_Test() throws InterruptedException
	{

		CheckPointPageTest CC = new CheckPointPageTest(driver);

		System.out.println("Updating Exceptional Groups Checkpoints Test");

		chiledTest = parentTest.createNode("Updating Exceptional Groups Checkpoints Test");

		System.out.println("***********Inactivating 3rd checkpoint*********");

		chiledTest.log(Status.INFO, "*********Inactivating 3rd checkpoint*******");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 1);
		CC.SetSearchBTN(SS1);

		CC.ClickNumberOfCheckBoxButton(driver);

		//clicking on the 3rd Checkpoint
		CC.ClickThirdCheckpoint(driver);

		//clicking on the Activate Button
		CC.ClickEditPageActivateBTN();

		//Clicking on the submit button
		CC.ClickEditPageSubmitButton();

		//checkpoint updated successfully message is displayed
		CC.VerifyCheckpointUpdatedSuccessfullySuccessMSGIsDisplayed(driver);

		System.out.println("*********Adding new Both Type Checkpoint*******");

		chiledTest.log(Status.INFO, "*********Adding new Both Type Checkpoint*******");

		CC.ClickManageCheckPointHeader(driver);

		//Passing the Values to Search Button
		String SS2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 1);
		CC.SetSearchBTN(SS2);

		CC.ClickNumberOfCheckBoxButton(driver);

		//clicking on the add new Checkpoint button
		CC.ClickAddNewcheckpointBTN(driver);

		//Passing the Values to the Enter Checkpoint intent
		String ECI7 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI7, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS7 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS7);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected action from auditor
		String EA7 = Lib.getCellValue(XLPATH, "Check Point", 217, 0);
		CC.SetExpectedActionFromAuditor(EA7);
		chiledTest.log(Status.INFO, "Both Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched
		CC.ClickMatched();

		//Passing Values to Yes Text Box
		String YB7 = Lib.getCellValue(XLPATH, "Check Point", 18, 0);
		CC.SetYestextBox(YB7);

		//Passing the Values to Yes Disposition
		String YD7 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD7);

		//Passing the Values to Yes Disposition
		String YD17 = Lib.getCellValue(XLPATH, "Check Point", 149, 0);
		CC.SetYesDisposition(YD17);

		//Passing the Values to Yes Disposition
		String YD27 = Lib.getCellValue(XLPATH, "Check Point", 150, 0);
		CC.SetYesDisposition(YD27);

		//Passing the Values to Yes Disposition
		String YD37 = Lib.getCellValue(XLPATH, "Check Point", 151, 0);
		CC.SetYesDisposition(YD37);

		//Passing the Values to No Disposition
		String ND7 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND7);

		//Passing the Values to No Disposition
		String ND17 = Lib.getCellValue(XLPATH, "Check Point", 156, 0);
		CC.SetNoDisposition(ND17);

		//Passing the Values to No Disposition
		String ND27 = Lib.getCellValue(XLPATH, "Check Point", 157, 0);
		CC.SetNoDisposition(ND27);

		//Passing the Values to No Disposition
		String ND37 = Lib.getCellValue(XLPATH, "Check Point", 158, 0);
		CC.SetNoDisposition(ND37);

		//Checking the NO Compliance is Read Only Mode or Not?
		CC.VerifyNOComplianceIsReadonly(driver);

		//Checking the Partial Compliance is Read Only Mode or Not?
		CC.VerifyPartialComplianceIsReadonlyOrNot(driver);

		//Checking the NA Compliance is Read Only Mode or Not?
		CC.VerifyNAComplianceIsReadonly(driver);

		//Checking the Partial Disposition is Read Only Mode or Not?
		CC.VerifyPartialDispositionIsReadOnly();

		//Checking the NA Disposition is Read Only Mode or Not?
		CC.VerifyNADispositionIsReadOnly();

		//Clicking on the Data Type
		CC.ClickDataType(driver);

		//Passing the Values to Data Type 
		String SD7 = Lib.getCellValue(XLPATH, "Check Point", 118, 0);
		CC.SetDataType(SD7);
		chiledTest.log(Status.INFO, "Data Type is Selected");

		//Clicking on the Matching
		CC.ClickMatched();

		//Passing the Values to Data type Values
		String SV7 = Lib.getCellValue(XLPATH, "Check Point", 139, 0);
		CC.SetDataTypeValues(SV7, driver);

		//Passing the Values to Data type Values
		String SV17 = Lib.getCellValue(XLPATH, "Check Point", 140, 0);
		CC.SetDataTypeValues(SV17, driver);

		//Passing the Values to Data type Values
		String SV27 = Lib.getCellValue(XLPATH, "Check Point", 141, 0);
		CC.SetDataTypeValues(SV27, driver);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL7 = Lib.getCellValue(XLPATH, "Check Point", 208, 0);
		CC.SetRiskLevel(RL7);
		chiledTest.log(Status.INFO, "Low Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA7 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA7);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//verifying Checkpoint created successfully. massage is displayed or not after clicks on Submit create button
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);
		chiledTest.log(Status.INFO, "CheckPoint Created Successfully Success Message is Displayed");

		System.out.println("*********************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=24, dependsOnMethods= {"Updating_Exceptional_Groups_Checkpoints_Test"})
	public void Updating_SubAudits_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Updating SubAudits Test");

		System.out.println("Updating SubAudits Test");

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
		CA.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		CA.ClickConfigureAudit(driver);
		chiledTest.log(Status.INFO, "Configure Audit is Clicked");

		//Clicking on the configure Audit Sub menu
		CA.ClickConfigureAuditSubMenu();

		System.out.println("********Updating General Sub Audit Type*************");

		chiledTest.log(Status.INFO, "********Updating General Sub Audit Type*************");

		//Passing the Values to Search Text box
		String SB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 2);
		CA.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "General subAudit Type is Serached");

		CA.ClickFirstAuditType(driver);

		//Clearing the groups
		CA.ClearSelectCheckpointGroup();

		//Passing the Values to Select Checkpoint
		String SCG = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 1);
		CA.SetSelectCheckPointGroup(SCG, driver);

		CA.ClickMatch();

		//selecting 100 under Show and Row
		CA.SetShowAndRow(driver);

		//Checking the Count of the Check Points
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 3;
		Assert.assertEquals(CPCount, CPCount1, "Check Points Counts are Wrong");

		//In activating 1st Check point
		List<WebElement> ActivateBTN = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']//tbody/tr/td/input[@type='checkbox']"));
		ActivateBTN.get(0).click();

		//In activating 2nd Check point
		ActivateBTN.get(1).click();

		//clicking on the save button
		CA.ClickSaveBTN();

		//verifying Audit type updated successfully Message is displayed
		CA.VerifyAuditTypeUpdatedSuccessfullyMsgIsDisplayed(driver);

		System.out.println("********Updating Static Annexure Sub Audit Type*************");

		chiledTest.log(Status.INFO, "********Updating Static Annexure Sub Audit Type*************");

		//Passing the Values to Search Text box
		String SB1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 2);
		CA.SetSearchBTN(SB1);
		chiledTest.log(Status.INFO, "General subAudit Type is Serached");

		CA.ClickFirstAuditType(driver);

		//Clearing the groups
		CA.ClearSelectCheckpointGroup();

		//Passing the Values to Select Checkpoint
		String SCG1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 1);
		CA.SetSelectCheckPointGroup(SCG1, driver);

		CA.ClickMatch();

		//selecting 100 under Show and Row
		CA.SetShowAndRow(driver);

		//Checking the Count of the Check Points
		List<WebElement> CPSixze2 = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount2 = CPSixze2.size();
		int CPCount3 = 3;
		Assert.assertEquals(CPCount2, CPCount3, "Check Points Counts are Wrong");

		//In activating 1st Check point
		List<WebElement> ActivateBTN1 = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']//tbody/tr/td/input[@type='checkbox']"));
		ActivateBTN1.get(0).click();

		//In activating 2nd Check point
		ActivateBTN1.get(1).click();

		//clicking on the save button
		CA.ClickSaveBTN();

		//verifying Audit type updated successfully Message is displayed
		CA.VerifyAuditTypeUpdatedSuccessfullyMsgIsDisplayed(driver);


		System.out.println("********Updating Dynamic Annexure Sub Audit Type*************");

		chiledTest.log(Status.INFO, "********Updating Dynamic Annexure Sub Audit Type*************");

		//Passing the Values to Search Text box
		String SB2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 2);
		CA.SetSearchBTN(SB2);
		chiledTest.log(Status.INFO, "General subAudit Type is Serached");

		CA.ClickFirstAuditType(driver);

		//Clearing the groups
		CA.ClearSelectCheckpointGroup();

		//Passing the Values to Select Checkpoint
		String SCG2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 1);
		CA.SetSelectCheckPointGroup(SCG2, driver);

		CA.ClickMatch();

		//selecting 100 under Show and Row
		CA.SetShowAndRow(driver);

		//Checking the Count of the Check Points
		List<WebElement> CPSixze3 = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount4 = CPSixze3.size();
		int CPCount5 = 3;
		Assert.assertEquals(CPCount4, CPCount5, "Check Points Counts are Wrong");

		//In activating 3rd Check point
		List<WebElement> ActivateBTN2 = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']//tbody/tr/td/input[@type='checkbox']"));
		ActivateBTN2.get(2).click();

		//clicking on the save button
		CA.ClickSaveBTN();

		//verifying Audit type updated successfully Message is displayed
		CA.VerifyAuditTypeUpdatedSuccessfullyMsgIsDisplayed(driver);

		System.out.println("********Updating Exceptional Sub Audit Type*************");

		chiledTest.log(Status.INFO, "********Updating Exceptional Sub Audit Type*************");

		//Passing the Values to Search Text box
		String SB3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 2);
		CA.SetSearchBTN(SB3);
		chiledTest.log(Status.INFO, "General subAudit Type is Serached");

		CA.ClickFirstAuditType(driver);

		//Clearing the groups
		CA.ClearSelectCheckpointGroup();

		//Passing the Values to Select Checkpoint
		String SCG3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 1);
		CA.SetSelectCheckPointGroup(SCG3, driver);

		CA.ClickMatch();

		//selecting 100 under Show and Row
		CA.SetShowAndRow(driver);

		//Checking the Count of the Check Points
		List<WebElement> CPSixze4 = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount7 = CPSixze4.size();
		int CPCount8 = 4;
		Assert.assertEquals(CPCount7, CPCount8, "Check Points Counts are Wrong");

		//In activating 2nd Check point
		List<WebElement> ActivateBTN3 = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']//tbody/tr/td/input[@type='checkbox']"));
		ActivateBTN3.get(1).click();

		//clicking on the save button
		CA.ClickSaveBTN();

		//verifying Audit type updated successfully Message is displayed
		CA.VerifyAuditTypeUpdatedSuccessfullyMsgIsDisplayed(driver);

		System.out.println("***************************************");


	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=25, dependsOnMethods= {"Updating_SubAudits_Test"})
	public void Updating_Parent_AuditType_Test() throws InterruptedException
	{
		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		chiledTest = parentTest.createNode("Updating Parent Audit Type Test");

		System.out.println("Updating Parent Audit Type Test");

		//clicking on the Header
		CA.ClickAuditTypeHeader(driver);

		//Passing the Values to Search Text box
		String SB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		CA.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "General subAudit Type is Serached");

		CA.ClickFirstAuditType(driver);

		//selecting 100 under Show and Row
		CA.SetShowAndRow(driver);

		//Checking the Count of the Check Points
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 7;
		Assert.assertEquals(CPCount, CPCount1, "Check Points Counts are Wrong");
		System.out.println("Total 8 Checkpoints are displayed");
		chiledTest.log(Status.INFO, "Total 8 Checkpoints are displayed");

		//Passing the Values to Low Risk Scoring
		String LR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 10);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 8);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 9);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 11);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Tolerance Risk Scoring is Entered");

		//Enabling Should capturing image be mandatory for main audit ? toggle button
		CA.ClickImageMandatoryTaggleBTN();

		//enabling Do you need to finalize audits in bulk ? Toggle Button
		CA.ClickBulkFinalizeTaggleBTN();

		//enabling Do you need mandatory remarks from auditor at a checkpoint level? (enabling this will disable express and lightening mode of execution)
		CA.ClickAuditorRemarksTaggleBTN();

		//enabling Do you wish to add selfie? Toggle Button
		CA.ClickAddSelfieTaggleBTN();

		//enabling Do you wish to add digital signatures? Toggle button
		CA.ClickAddDigitalSignatureTaggleBTN();

		//Passing the Values to Low Due Days
		String SL = Lib.getCellValue(XLPATH, "Configure Audit Type", 74, 0);
		CA.SetLowDueDays(SL);
		chiledTest.log(Status.INFO, "Low Due Days is Entered");

		//Passing the Values to Medium Due Days
		String SM = Lib.getCellValue(XLPATH, "Configure Audit Type", 80, 0);
		CA.SetMediumDueDays(SM);
		chiledTest.log(Status.INFO, "Medium Due Days is Entered");

		//Passing the Values to High Due Days
		String SH = Lib.getCellValue(XLPATH, "Configure Audit Type", 86, 0);
		CA.SetHighDueDays(SH);
		chiledTest.log(Status.INFO, "High Due Days is Entered");

		//Passing the Values to ZT Due Days
		String SZ = Lib.getCellValue(XLPATH, "Configure Audit Type", 92, 0);
		CA.SetZTDueDays(SZ);
		chiledTest.log(Status.INFO, "ZT Due Days is Entered");

		//Passing the Valid Exceptional Max Deduction
		String MD1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 165, 0);
		CA.SetMaxDeduction(MD1);
		chiledTest.log(Status.INFO, "Valid Exceptional Max Deduction is Entered");

		//Checking the Total score
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement TotalScore = driver.findElement(By.xpath("//input[@class='audit_type_total_score form-control text-danger']"));
		String TotalScoreCount = wait.until(ExpectedConditions.visibilityOf(TotalScore)).getAttribute("value");
		double d = 125.0;
		String Str = Double.toString(d);
		Assert.assertEquals(TotalScoreCount, Str, "Total Score count is showing Wrong");
		System.out.println("Diplayed Total Score is : " + Str);

		//Updating the Percentage based slab to Actual score slab
		CA.ClickActualScoreSlabRadioBTN(driver);

		//Checking the To Count
		String Actual_TOCount = driver.findElement(By.xpath("//input[@id='audit_type_audit_ratings_attributes_2_to']")).getAttribute("value");
		System.out.println("TO Count is : " + Actual_TOCount);
		double Expected_ToCount = 125.0;
		String Str1 = Double.toString(Expected_ToCount);
		Assert.assertEquals(Actual_TOCount, Str1, "Total Score count is showing Wrong");

		//clicking on the save button
		CA.ClickSaveBTN();

		//Verifying Audit Type Updated successfully message
		CA.VerifyAuditTypeUpdatedSuccessfullyMsgIsDisplayed(driver);

		System.out.println("********************************");

	}

	//Testing the Functionality of the Create Audit Schedule for General Group  AuditType Test
	@Test(priority=26, dependsOnMethods= {"Updating_Parent_AuditType_Test"})
	public void Self_Schedule_Test() throws InterruptedException
	{
		AuditSchedulePageTest SP = new AuditSchedulePageTest(driver);

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Self Schedule Test");

		System.out.println("Self Schedule Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials", 42, 0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials", 42, 1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		//Clicking on the Create New Schedule Button
		AE.ClickCreateScheduleButton();

		//Clicking on the Select Audit Type
		SP.ClickSelectAuditType(driver);

		//Passing the Values to Select Audit type from "Configure Audit Type" sheet
		String SAT1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		SP.SetSelectAuditType(SAT1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Selecting Vendor Option Under Select Auditee Type Drop Down List
		SP.ClickVendorOption(driver);

		//Clicking on the Select Auditee
		SP.ClickSelectAuditee(driver);

		//Passing the Values to Select Auditee
		String SA2 = Lib.getCellValue(XLPATH, "Schedule", 9, 0);
		SP.SetSelectAuditeeText(SA2, driver);
		chiledTest.log(Status.INFO, "Select Auditee is Entered");

		//Clicking on the Matched 
		SP.ClickMatched();

		//Clicking on the Start Date
		SP.ClickStartDate();

		//Selecting the today Date under Start Date
		SP.ClickTodayStartDate(driver);

		//Clicking on the End date
		SP.ClickEndDate();

		//Selecting the Today date under End Date
		SP.ClickTodayEndDate(driver);

		//Clicking on the Save Button
		SP.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Schedule created successfully Success Message is Displayed
		SP.VerifyScheduleCreatedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Schedule created successfully. Success Message is displayed");

		System.out.println("****************************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=27, dependsOnMethods= {"Self_Schedule_Test"})
	public void Schedule_Execution_Tets() throws InterruptedException
	{
		AuditExecutionPageTest AE = new AuditExecutionPageTest(driver);

		chiledTest = parentTest.createNode("Schedule Execution Test");

		System.out.println("Schedule Execution Test");

		//Passing the General Parent Audit type to Audit Type
		String AT3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the start Button
		AE.ClickStartBTN(driver);

		System.out.println("************** Executing the General Sub audit Type *****************");

		chiledTest.log(Status.INFO, "************** Executing the General Sub audit Type *****************");

		//Passing the Values to Search Text Filed
		String SB1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 2);
		AE.SetSearchBTN(SB1);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);

		//Verifying Express Button is Enabled or Disabssled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);

		System.out.println("******Executing 1st CP*********");

		chiledTest.log(Status.INFO, "******Executing 1st CP********");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText);

		String CP = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP);
		Assert.assertEquals(CPText, CP);

		//Clicking on the NO Button
		AE.ClickNoButton();

		//Passing the Number under to Input Text fields
		String IV1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV1, driver);
		chiledTest.log(Status.INFO, "Number is Entered");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER1 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER1);

		//Passing the Values to Enter confidential Remarks
		String ECR1 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR1);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("************** Executing the Static Annexure Sub audit Type *****************");

		chiledTest.log(Status.INFO, "************** Executing the Static Annexure Sub audit Type *****************");

		//Passing the Values to Search Text FiledW
		String SB2= Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 2);
		AE.SetSearchBTN(SB2);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);

		System.out.println("******Excecuting the 1st PI Engine101*******");

		chiledTest.log(Status.INFO, "******Excecuting the 1st PI Engine101*******");

		//Passing the Values to Search Button
		String SB3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 135, 0);
		AE.SetSearchBTN(SB3);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);

		System.out.println("******Executing 1st CP*********");

		chiledTest.log(Status.INFO, "******Executing 1st CP********");


		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText2 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText2);

		String CP2 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP2);
		Assert.assertEquals(CPText2, CP2);

		//Clicking on the NO Button
		AE.ClickNoButton();

		//Passing the number to Input Values
		String IV2 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV2, driver);
		chiledTest.log(Status.INFO, "Text and Number is Entered under Input Values");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER2 = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER2);

		//Passing the Values to Enter confidential Remarks
		String ECR2 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR2);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Audit submitted successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("************* Adding New PI ************");

		chiledTest.log(Status.INFO, "*********** Adding New PI ***********");

		//clicking on the Add new Pi Button
		AE.ClickAddNewPIBTN(driver);

		//Passing the Values to Pi Name
		String PIN = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN, driver);
		chiledTest.log(Status.INFO, "PI Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);

		System.out.println("******Excecuting the newly added PI Engine105*******");

		chiledTest.log(Status.INFO, "******Excecuting the newly added PI Engine105*******");

		//Passing the Values to Search Button
		String SB4 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetSearchBTN(SB4);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);

		System.out.println("******Executing 1st CP*********");

		chiledTest.log(Status.INFO, "******Executing 1st CP********");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText21 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText21);

		String CP21 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP21);
		Assert.assertEquals(CPText21, CP21);

		//Clicking on the NO Button
		AE.ClickNoButton();

		//Passing the number to Input Values
		String IV21 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV21, driver);
		chiledTest.log(Status.INFO, "Text and Number is Entered under Input Values");

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER21 = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER21);

		//Passing the Values to Enter confidential Remarks
		String ECR21 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR21);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Audit submitted successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		AE.ClearPiSearchBTN();

		//clicking on the Mark Pending PI As Not Executed
		AE.ClickMarkPendingPIAsNotExecuted();

		//Clicking on the OK Button
		AE.ClickOKBTN1(driver);

		//Checking Tick button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("************** Executing the Dynamic Annexure Sub audit Type *****************");

		chiledTest.log(Status.INFO, "************** Executing the Dynamic Annexure Sub audit Type *****************");

		//Passing the Values to Search Text FiledW
		String SB5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 2);
		AE.SetSearchBTN(SB5);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);

		System.out.println("******Excecuting the 1st PI Engine102*******");

		chiledTest.log(Status.INFO, "******Excecuting the 1st PI Engine102*******");

		//Passing the Values to Search Button
		String SB6 = Lib.getCellValue(XLPATH, "Configure Audit Type", 136, 0);
		AE.SetSearchBTN(SB6);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);

		//**********executing the 1st checkpoint**********
		System.out.println("******Executing 1st CP*********");

		chiledTest.log(Status.INFO, "******Executing 1st CP********");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText5 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText5);

		String CP5 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP5);
		Assert.assertEquals(CPText5, CP5);

		//Clicking on the Yes Button
		AE.ClickYesButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER41 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER41);

		//Passing the Values to Enter confidential Remarks
		String ECR41 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR41);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);


		System.out.println("******Executing 2nd CP*********");

		chiledTest.log(Status.INFO, "******Executing 2nd CP********");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText6 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText6);

		String CP6 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP6);
		Assert.assertEquals(CPText6, CP6);

		//Clicking on the NA Button
		AE.ClickNAButton();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER5 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER5);

		//Passing the Values to Enter confidential Remarks
		String ECR5 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR5);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Audit submitted successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("************* Adding New PI ************");

		chiledTest.log(Status.INFO, "*********** Adding New PI ***********");

		//clicking on the Add new Pi Button
		AE.ClickAddNewPIBTN(driver);

		//Passing the Values to Pi Name
		String PIN11 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPrimaryIdentifierName(PIN11, driver);
		chiledTest.log(Status.INFO, "PI Name is Entered");

		//Clicking on the Save Button
		AE.ClickSaveBTN(driver);
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Sub auditee added and scheduled successfully Success Message is Displayed
		AE.VerifySubAuditeeAddedAndScheduledSuccessfully(driver);

		System.out.println("******Excecuting the new PI Engine105*******");

		chiledTest.log(Status.INFO, "******Excecuting the new PI Engine105*******");

		//Passing the Values to Search Button
		String SB7 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetSearchBTN(SB7);

		//clicking on the Start Button
		AE.ClickPIStartButton(driver);

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);

		System.out.println("******Executing 1st CP*********");

		chiledTest.log(Status.INFO, "******Executing 1st CP********");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText7 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText7);

		String CP7 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP7);
		Assert.assertEquals(CPText7, CP7);

		//Clicking on the No Button
		AE.ClickNoButton();

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER6 = Lib.getCellValue(XLPATH, "Audit Execution", 11, 0);
		AE.SetEnterRemarks(ER6);

		//Passing the Values to Enter confidential Remarks
		String ECR6 = Lib.getCellValue(XLPATH, "Audit Execution", 26, 0);
		AE.SetEnterConfidentalRemarks(ECR6);

		//Clicking on the Next Button
		AE.ClickNextButton(driver);

		System.out.println("******Executing 2nd CP*********");

		chiledTest.log(Status.INFO, "******Executing 2nd CP********");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText8 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText8);

		String CP8 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP8);
		Assert.assertEquals(CPText8, CP8);

		//Clicking on the Partial Button
		AE.ClickPartialButton();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER7 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER7);

		//Passing the Values to Enter confidential Remarks
		String ECR8 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR8);

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);

		//Verifying Audit submitted successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		AE.ClearPiSearchBTN();

		//clicking on the Mark Pending PI As Not Executed
		AE.ClickMarkPendingPIAsNotExecuted();

		//Clicking on the OK Button
		AE.ClickOKBTN1(driver);

		//Checking Tick button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("************** Executing the Exceptional Sub audit Type *****************");

		chiledTest.log(Status.INFO, "************** Executing the Exceptional Annexure Sub audit Type *****************");

		//Passing the Values to Search Text FiledW
		String SB8 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 2);
		AE.SetSearchBTN(SB8);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);

		//Verifying Express Button is Enabled or Disabled
		AE.VerifyExpressButtonIsDisabled();

		//Clicking on the Normal Button
		AE.Clicknormal(driver);

		//******** Executing 1st CP*************

		System.out.println("******Executing 1st CP****");

		chiledTest.log(Status.INFO, "******Executing 1st CP****");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText9 = Lib.getCellValue(XLPATH, "Check Point", 7, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText9);

		String CP9 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP9);
		Assert.assertEquals(CPText9, CP9);

		//checking only Yes and NO button should display
		AE.VerifyOnlyYesAndNoButtonsDisplayed(driver);

		//Clicking on the NO Button
		AE.ClickNoButton();

		//clicking on the next button
		AE.ClickNextButton(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER9 = Lib.getCellValue(XLPATH, "Audit Execution", 12, 0);
		AE.SetEnterRemarks(ER9);

		//Passing the Values to Enter confidential Remarks
		String ECR9 = Lib.getCellValue(XLPATH, "Audit Execution", 27, 0);
		AE.SetEnterConfidentalRemarks(ECR9);

		//clicking on the next button
		AE.ClickNextButton(driver);

		System.out.println("******Executing 2nd CP****");

		chiledTest.log(Status.INFO, "******Executing 2nd CP****");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText10 = Lib.getCellValue(XLPATH, "Check Point", 9, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText10);

		String CP10 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP10);
		Assert.assertEquals(CPText10, CP10);

		//checking only Yes and NO button should display
		AE.VerifyOnlyYesAndNoButtonsDisplayed(driver);

		//Clicking on the NO Button
		AE.ClickNoButton();

		//Passing the number to vlues
		String IV11 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetEnterInputValues(IV11, driver);
		chiledTest.log(Status.INFO, "Number is Entered under input values");

		//clicking on the next button
		AE.ClickNextButton(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER10 = Lib.getCellValue(XLPATH, "Audit Execution", 14, 0);
		AE.SetEnterRemarks(ER10);

		//Passing the Values to Enter confidential Remarks
		String ECR10 = Lib.getCellValue(XLPATH, "Audit Execution", 29, 0);
		AE.SetEnterConfidentalRemarks(ECR10);

		//clicking on the next button
		AE.ClickNextButton(driver);


		System.out.println("******Executing 3rd CP****");

		chiledTest.log(Status.INFO, "******Executing 3rd CP****");

		Thread.sleep(4000);

		//Checking Checkpoint Intent name 
		String CPText11 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		System.out.println("Entered CheckPoint Intent Name is : " + CPText11);

		String CP11 = driver.findElement(By.xpath("//h3[@class='p-l-15 p-r-15 bold']")).getText();
		System.out.println("Displayed CheckPoint Intent Name is : " + CP11);
		Assert.assertEquals(CPText11, CP11);

		//checking only Yes and NO button should display
		AE.VerifyOnlyYesAndNoButtonsDisplayed(driver);

		//Clicking on the yes Button
		AE.ClickYesButton();

		//selecting the 1st values under 
		AE.SelectingValues(driver);

		//clicking on the Finish button
		AE.ClickFinishBTN(driver);

		//Verifying Enter Remarks Is Required filed for all the Checkpoints
		AE.VerifyEnterRemarksIsMandatory(driver);

		//Passing the Values to Enter Remarks
		String ER11 = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER11);

		//Passing the Values to Enter confidential Remarks
		String ECR11 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR11);

		//clicking on the Finish button
		AE.ClickFinishBTN(driver);

		//Verifying Audit submitted successfully Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);

		//Checking Tick button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		//Clicking on the Submit Audit Button
		AE.ClickSubmitAuditBTN(driver);

		//Passing the Values to Audit Level Recommendation 
		String AR = Lib.getCellValue(XLPATH, "Audit Execution", 115, 0);
		AE.SetAuditLevelRecommendation(AR);

		//Passing the Values to Audit level Observation
		String AO = Lib.getCellValue(XLPATH, "Audit Execution", 118, 0);
		AE.SetAuditLevelObservations(AO);

		//Uploading the Documents
		AE.ImageMandatoryUploadDocuments();

		//Verifying Submitted successfully success Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Submitted successfully success Message is Displayed");

		System.out.println("*************************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=28, dependsOnMethods= {"Schedule_Execution_Tets"})
	public void Schedule_Finalization_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Schedule Finalization Test");

		System.out.println("Schedule Finalization Test");

		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

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

		//Clicking on the Scroll Bar
		RA.ClickScrollBar(driver);

		//Clicking on the Review Audit side menu
		RA.ClickReviewAudit(driver);
		chiledTest.log(Status.INFO, "Review Audit is Clicked");

		//Passing the Values to Search Text field
		String SB = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//clicking on the Accepted Status
		RA.ClickAcceptedStatus();

		System.out.println("*****************Reviewing and Finalizing Static Annxure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Static Annxure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 5, 2);
		RA.SetSubAudits(SA);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		// Validating 1 checkpoint should display
		RA.Verify1CheckpointsAreDisplayed();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing Dynamic Annxure Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Dynamic Annxure Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA4 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 6, 2);
		RA.SetSubAudits(SA4);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		// Validating only Two checkpoint should display
		RA.Verify2CheckpointsAreDisplayed();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing general Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing general Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA1 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 2);
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA2 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 1);
		RA.SetGroup(SA2);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		// Validating only one checkpoint should display
		RA.Verify1CheckpointsAreDisplayed();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();


		System.out.println("*****************Reviewing and Finalizing Expectional Sub Audit Type**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Expectional Sub Audit Type******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA3 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 2);
		RA.SetSubAudits(SA3);

		RA.ClickMatchedTextOption(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA5 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 7, 1);
		RA.SetGroup(SA5);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		// Validating only 3 checkpoint should display
		RA.Verify3CheckpointsAreDisplayed();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		//Clicking on the Main Audit Finalize button
		RA.ClickMainAuditFinalizeBTN();

		//verifying Audit Finalized Successfully message is displayed
		RA.VerifyAuditFinalizedSuccessfullySuccessMsgIsDisplayed(driver);

		//Passing the Values to Search Text field
		String SB6 = Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 3, 3);
		RA.SetSearchTextBox(SB6);

		RA.ClickRefreshButton();

		//Clicking on the 2nd Audit Type
		RA.ClickSecondTR(driver);

		//clicking on the summary button
		RA.ClickSummaryBTN();

		Thread.sleep(2000);

		//Checking the Total Score
		String Actual_TotalScore = driver.findElement(By.xpath("//div[@class='recalc_total_score']")).getText();
		System.out.println("Actual Total Score is : " + Actual_TotalScore);
		String Expected_TotalScore = "-10.0 / 125.0"; //-7.5/125.0
		System.out.println("Expected Total Score is : " + Expected_TotalScore);
		Assert.assertEquals(Actual_TotalScore, Expected_TotalScore, "Total Score is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Total score are Matched");

		//Checking the Audit rating
		String Actual_AuditRating = driver.findElement(By.xpath("//div[@class='recalc_rating']")).getText();
		System.out.println("Actual Rating is : " + Actual_AuditRating);
		String Expected_AuditRating = "in progress";//Lib.getCellValue(XLPATH, "POPSL SubAudits Scenario 1", 4, 14);
		System.out.println("Expected Rating is : " + Expected_AuditRating);
		Assert.assertEquals(Actual_AuditRating, Expected_AuditRating, "Audit Rating is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual ratings are Matched");

		//Checking the Compliances %
		String Actual_Compliances = driver.findElement(By.xpath("//div[@class='recalc_compliance_percentage']")).getText();
		System.out.println("Actual Rating is : " + Actual_Compliances);
		String Expected_Compliances = "73";
		System.out.println("Expected Compliance is : " + Expected_Compliances);
		Assert.assertEquals(Actual_Compliances, Expected_Compliances, "Compliances % is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Compliances % are Matched");
		
		Assert.fail("Dependeny ticket CTRL-5730");

		System.out.println("********************************");

	}



}

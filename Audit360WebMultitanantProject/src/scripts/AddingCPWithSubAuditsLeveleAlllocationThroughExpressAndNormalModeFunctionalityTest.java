package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
import pom.ReviewCheckpointsPageTest;
import pom.SideMenuPageTest;
import pom.UploadAnnexureDocumentPageTest;

public class AddingCPWithSubAuditsLeveleAlllocationThroughExpressAndNormalModeFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Annexure Page Test
	@Test(priority=1)
	public void Annexure_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AnnexurePageTest AT = new AnnexurePageTest(driver);

		parentTest = extent.createTest("Adding CP Which is Mapped With Subaudits Functionality Test", "Testing the Functionality of Adding CP during Execution which is maped with Subsudits through Express and Normal Mode");

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
		String AN = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 0);
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
		String AN1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 0);
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

		LoginPageTest l=new LoginPageTest(driver);

		chiledTest = parentTest.createNode("Creating Annexure Group Test");

		System.out.println("***Creating ststic Annexure Group Test****");

		chiledTest.log(Status.INFO, "****Creating Static Annexure Group Test");

		l.ClickProfileBTN(driver);

		l.ClickLogoutBTN();

		chiledTest.log(Status.INFO, "Entered User Name and Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Singin Button is Clicked");

		//Verifying sign in successful message is displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Message is Displayed");

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
		String SA = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 0);
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
		String ADG = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 1);
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
		String SA1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 0);
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
		String ADG1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 1);
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
		String ADG = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 1);
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
		String ADG1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 1);
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
		String ADG = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 1);
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
		String SS = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 1);
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
		String YB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 5);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String YB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 5);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String YB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 5);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 8, 6);
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
		String YB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 5);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String SS = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 1);
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
		String YB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 5);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String YB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 5);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String YB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 5);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 8, 6);
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
		String YB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 5);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String SS = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 1);
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
		String YB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 4);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String YB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 4);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String YB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 4);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 6);
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
		String YB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 4);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String SS = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 1);
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
		String YB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 4);
		CC.SetYestextBox(YB5);

		//Passing Values to No Text Box
		String NB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB5);

		//Passing Values to NA Text Box
		String NAB1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String YB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 4);
		CC.SetYestextBox(YB51);

		//Passing Values to No Text Box
		String NB51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB51);

		//Passing Values to NA Text Box
		String NAB2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 9, 6);
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
		String YB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 4);
		CC.SetYestextBox(YB7);

		//Passing Values to No Text Box
		String NB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB7);

		//Passing Values to NA Text Box
		String NAB3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 10, 6);
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
		String YB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 4);
		CC.SetYestextBox(YB8);

		//Passing Values to No Text Box
		String NB8 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 5);
		CC.SetNoTextBox(NB8);

		//Passing Values to NA Text Box
		String NAB4 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 6);
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
		String SS = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 1);
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
		String ATN = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 2);
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
		String SCG = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 1);
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
		String ATN2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 2);
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
		String SCG2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 1);
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
		String ATN3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 2);
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
		String SCG3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 1);
		CA.SetSelectCheckPointGroup(SCG3, driver);
		chiledTest.log(Status.INFO, "Select CheckPoint Group is Entered");

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint Group
		String SCG4 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 1);
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
		String ATN21 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 2);
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
		String SCG10 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 1);
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
		String ATN = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
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
		String SA1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 2);
		CA.SetSelectSubAudittype(SA1, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to select Group type
		String SA3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 2);
		CA.SetSelectSubAudittype(SA3, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to select Group type
		String SA4 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 2);
		CA.SetSelectSubAudittype(SA4, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to select Group type
		String SA5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 2);
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
		String LR = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 10);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 8);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 9);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 11);
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
		String SL = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 10);
		CA.SetLowDueDays(SL);
		chiledTest.log(Status.INFO, "Low Due Days is Entered");

		//Passing the Values to Medium Due Days
		String SM = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 8);
		CA.SetMediumDueDays(SM);
		chiledTest.log(Status.INFO, "Medium Due Days is Entered");

		//Passing the Values to High Due Days
		String SH = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 9);
		CA.SetHighDueDays(SH);
		chiledTest.log(Status.INFO, "High Due Days is Entered");

		//Passing the Values to ZT Due Days
		String SZ = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 11);
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
		String FT = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 13);
		CA.SetFirstTo(FT, driver);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 14);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Add Row Button
		CA.ClickAddRow(driver);
		chiledTest.log(Status.INFO, "Add Row Button is Clicked");

		//Passing the Values to Second TO
		String ST1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 13);
		CA.SetSecondTo(ST1, driver);

		//Passing the Values to Second Out Come
		String SO = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 14);
		CA.SetSecondOutCome(SO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Passing the Values to Third Out Come
		String TO1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 14);
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
		String SA = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(2000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'ACP Static Sub Audit Type Test')]")).click();

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
		String SA1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
		UA.SetAuditType(SA1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'ACP Dynamic Sub Audit Type Test')]")).click();

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
		String SA = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
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
		String SAT1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
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

		Actions action = new Actions(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		CheckPointPageTest CC = new CheckPointPageTest(driver);

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
		String AT2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
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
		String AT3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
		AE.SetAuditType(AT3, driver);

		AE.ClickMatched();

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);

		System.out.println("************** Executing the 1st General Sub Audit Type Through Normal Mode*****************");

		chiledTest.log(Status.INFO, "************** Executing the 1st General  Sub Audit Type Through Normal Mode*****************");

		//Passing the Values to Search Text Filed
		String SB11 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 2);
		AE.SetSearchBTN(SB11);

		//Clicking on the Started Button
		AE.ClickStartBTN(driver);

		AE.Clicknormal(driver);

		//Verifying only 2 Groups are Displayed
		AE.Verify2GroupsAreDisplayed();

		System.out.println("*** Passing already Exist Group name****");
		chiledTest.log(Status.INFO, "**** Passing already Exist Group name*****");

		//clicking on the Add checkpoint button
		AE.ClickAddCheckpointButton();

		//Clicking on the add new Group Toggle button
		CC.ClickAddNewGroupToggleButton();

		//Passing the Already Existing Group name
		String EN = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 1);
		CC.SetEnterNewGroup(EN);

		//Passing the Values to the Enter Checkpoint intent
		String EC = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(EC, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing the Values to Yes Disposition
		String YD = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD);

		//Passing the Values to No Disposition
		String NO = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(NO);

		//Passing the Values to Partial Disposition
		String PD = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD);

		//Passing the Values to NA Disposition
		String ND = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);

		//Checking Group Name has already been taken. Error Message is Displayed Error message is displayed or not
		CC.VerifyGroupNameIsAlradyTakenErrorMsgIsDisplayed();

		System.out.println("*** Passing the New Group name****");

		chiledTest.log(Status.INFO, "**** Passing The new Group name*****");

		//clicking on the Add checkpoint button
		AE.ClickAddCheckpointButton();

		//Clicking on the add new Group Toggle button
		CC.ClickAddNewGroupToggleButton();

		//Passing the new Group name which is not Exist in DB
		String EN1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 8, 1);
		CC.SetEnterNewGroup(EN1);

		//Passing the Values to the Enter Checkpoint intent
		String EC1 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(EC1, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS1 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS1);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing the Values to Yes Disposition
		String YD1 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD1);

		//Passing the Values to No Disposition
		String NO1 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(NO1);

		//Passing the Values to Partial Disposition
		String PD1 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD1);

		//Passing the Values to NA Disposition
		String ND1 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND1);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL1 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL1);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA1 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA1);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);

		//checking Checkpoint Created Successfully Message is Displayed or not
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);

		//Verifying only 3 Groups are Displayed
		AE.Verify3GroupsAreDisplayed();

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

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*** Executing newly added Groups CP*****");

		chiledTest.log(Status.INFO, "*** Executing newly added Groups CP*****");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the No Button
		AE.ClickNoButton();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		//Verify Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("*************Exceuting Exceptional Sub Audits Through Normal Mode**********");

		chiledTest.log(Status.INFO, "*********Exceuting Exceptional Sub Audits Through Normal Mode*******");

		//Passing the Values to Search Text Filed
		String SB3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 2); 
		AE.SetSearchBTN(SB3);
		chiledTest.log(Status.INFO, "General Audit type Is Entered");

		//Clicking on the start Button
		AE.ClickStartBTN(driver);
		chiledTest.log(Status.INFO, "Start Button Is Clicked");

		AE.Clicknormal(driver);

		//Verifying only 1 Groups are Displayed
		AE.Verify1GroupsAreDisplayed();

		//verify 4 CP are Displayed
		AE.Verify4CPIsDisplayed();

		System.out.println("***Creating New CP ****");
		chiledTest.log(Status.INFO, "*****Creating New CP *****");

		//clicking on the Add checkpoint button
		AE.ClickAddCheckpointButton();

		//clicking on the Select Group
		CC.ClickSelectGroups();

		//Passing the Values to Select Group
		String SG1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 1);
		CC.SetSelectGroup(SG1);

		CC.ClickMatched();

		//Passing the Values to the Enter Checkpoint intent
		String ECI51 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI51, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS51 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS51);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA511 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA511);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

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

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);

		//checking Checkpoint Created Successfully Message is Displayed or not
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);

		//Checking 5 Cp's are displayed
		AE.Verify5CPIsDisplayed();

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

		//Clicking on the Next Button
		AE.ClickNextButton(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		System.out.println("*** Executing newly added Groups CP*****");

		chiledTest.log(Status.INFO, "*** Executing newly added Groups CP*****");

		Thread.sleep(5000);

		//Passing the Values to Enter Remarks
		String ER30 = Lib.getCellValue(XLPATH, "Audit Execution", 15, 0);
		AE.SetEnterRemarks(ER30);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Passing the Values to Enter confidential Remarks
		String ECR30 = Lib.getCellValue(XLPATH, "Audit Execution", 30, 0);
		AE.SetEnterConfidentalRemarks(ECR30);
		chiledTest.log(Status.INFO, "Confidential Remarks is Entered");

		//Clicking on the No Button
		AE.ClickNoButton();

		//Clicking on the Finish Button
		AE.ClickFinishBTN(driver);
		chiledTest.log(Status.INFO, "Finish Button is Clicked");

		//verifying Audit submitted successfully Success Message is Displayed
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit submitted successfully Success Message is Displayed");

		//Verifying Tick Button is Displayed
		AE.VerifyInstedOfCompleteBTNTickBTNisDisplayed(driver);

		System.out.println("************** Executing the Dyanamic Annexure Sub Audit Type *****************");

		chiledTest.log(Status.INFO, "************** Executing the Dyanamic Annexure Sub Audit Type *****************");

		//Passing the Values to Search Text Filed
		String SB13 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 2);
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

		System.out.println("**** Executing newly added PI ****");

		chiledTest.log(Status.INFO, "**** Executing newly added PI ****");

		//Passing the Values to Search Button
		String SB4 = Lib.getCellValue(XLPATH, "Audit Execution", 56, 0);
		AE.SetPiSearchBTN(SB4);

		//Clicking on the Started Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Clicking on the Express Mode
		AE.ClickExpress(driver);

		System.out.println("**** Adding the CP Intent Which not exsit ****");

		chiledTest.log(Status.INFO, "**** Adding the CP Intent Which not exsit ****");

		//clicking on the Add checkpoint button
		AE.ClickAddCheckpointButton();

		//clicking on the Select Group
		CC.ClickSelectGroups();

		//Passing the Values to Select Group
		String SG11 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 1);
		CC.SetSelectGroup(SG11);

		CC.ClickMatched();

		//Passing the Values to the Enter Checkpoint intent
		String ECI511 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI511, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS511 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS511);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5111 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5111);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing the Values to Yes Disposition
		String YD511 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD511);

		//Passing the Values to No Disposition
		String ND511 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND511);

		//Passing the Values to Partial Disposition
		String PD511 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD511);

		//Passing the Values to NA Disposition
		String ND11511 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND11511);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL511 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL511);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA511 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA511);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);

		//checking Checkpoint Created Successfully Message is Displayed or not
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);

		//Validating Total 5 Checkpoints are Displayed or Not
		List<WebElement> NoOfCheckpoints = driver.findElements(By.xpath("//ul[@id='sortable1']/li"));
		int Actual_NoOfCheckpoints = NoOfCheckpoints.size();
		int Expected_NoOfCheckpoints = 5;
		Assert.assertEquals(Actual_NoOfCheckpoints, Expected_NoOfCheckpoints, "Total 5 Checkpoints are NOT Displayed");

		System.out.println("*****Dragging 1st checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 1st checkpoint to No Compliance********");

		WebElement CP1 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP1));
		WebElement NO11 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO11));
		action.dragAndDrop(CP1, NO11).build(). perform();
		System.out.println("First Checkpoint is Dragged to NO");
		chiledTest.log(Status.INFO, "First Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 2nd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 2nd checkpoint to NO Compliance********");

		WebElement CP2 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP2));
		WebElement NO2 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO2));
		action.dragAndDrop(CP2, NO2).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to NO");
		System.out.println("Second Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 3rd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 3rd checkpoint to NO Compliance********");

		WebElement CP3 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP3));
		WebElement NO3 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO3));
		action.dragAndDrop(CP3, NO3).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to NO");
		System.out.println("Third Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 4th checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 4th checkpoint to NO Compliance********");

		WebElement CP4 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP4));
		WebElement NO4 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO4));
		action.dragAndDrop(CP4, NO4).build(). perform();
		chiledTest.log(Status.INFO, "Fourth Checkpoint is Dragged to NO");
		System.out.println("Fourth Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 5th checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 5th checkpoint to NO Compliance********");

		WebElement CP5 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP5));
		WebElement NO5 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO5));
		action.dragAndDrop(CP5, NO5).build(). perform();
		chiledTest.log(Status.INFO, "Fifth Checkpoint is Dragged to NO");
		System.out.println("Fifth Checkpoint is Dragged to NO");

		//Clicking on the Next Button
		AE.ClickExpressModeVerifyTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Input Tab ***************************

		Thread.sleep(5000);

		//Selecting the 1st Values under 1st Values Drop down list
		WebElement SelectValues = driver.findElement(By.xpath("//ul[@class='cps inputs']/li[2]//select[@id='input_value']/option[2]"));
		wait.until(ExpectedConditions.visibilityOf(SelectValues)).click();

		//Passing the Values to number
		String NU1 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetFirstNumber(NU1, driver);

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Butto is Clicked");

		//******** Summary Tab *******

		//Passing the Values to Remarks
		String ER15 = Lib.getCellValue(XLPATH, "Audit Execution", 107, 0);
		AE.SetExpressRemarks(ER15);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Clicking on the Submit Button
		AE.ClickExpressModeSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Butto is Clicked");

		//Checking Audit Submitted Success Message is Displayed or not
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Success Message is Displayed");

		//**********Remaining PI are making as not Executed*********

		System.out.println("*** Making Not Found for Remaining PI's****");

		chiledTest.log(Status.INFO, "*** Making Not Found for Remaining PI's***");

		//clicking on the Mark Pending PI As Not Executed button
		AE.ClickMarkPendingPIAsNotExecuted();

		//clicking on OK Button
		AE.ClickOKBTN1(driver);

		System.out.println("*****Exceuting Static Annexure sub audits****");

		chiledTest.log(Status.INFO, "*****Exceuting Static Annexure sub audits****");

		//Passing the Values to Search Text Filed
		String SB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 2);
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

		//Clicking on the Started Button
		AE.ClickPIStartButton(driver);
		chiledTest.log(Status.INFO, "Started Button is Clicked");

		//Verifying Choose execution Type Pop Up is Displayed
		AE.VerifyChooseExecutionTypePopUpIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Choose execution Type Pop Up is Displayed");

		//Clicking on the Express Mode
		AE.ClickExpress(driver);

		System.out.println("*** Passing already Exist Group name****");

		chiledTest.log(Status.INFO, "**** Passing already Exist Group name*****");

		//clicking on the Add checkpoint button
		AE.ClickAddCheckpointButton();

		//Clicking on the add new Group Toggle button
		CC.ClickAddNewGroupToggleButton();

		//Passing the Already Existing Group name
		String EN4 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 8, 1);
		CC.SetEnterNewGroup(EN4);

		//Passing the Values to the Enter Checkpoint intent
		String EC4 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(EC4, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS4 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS4);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA4 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA4);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing the Values to Yes Disposition
		String YD4 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD4);

		//Passing the Values to No Disposition
		String NO41 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(NO41);

		//Passing the Values to Partial Disposition
		String PD4 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD4);

		//Passing the Values to NA Disposition
		String ND4 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND4);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL4 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL4);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA4 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA4);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);

		//Checking Group Name has already been taken. Error Message is Displayed Error message is displayed or not
		CC.VerifyGroupNameIsAlradyTakenErrorMsgIsDisplayed();

		System.out.println("*** Passing the New Group name****");

		chiledTest.log(Status.INFO, "**** Passing The new Group name*****");

		//clicking on the Add checkpoint button
		AE.ClickAddCheckpointButton();

		//Clicking on the add new Group Toggle button
		CC.ClickAddNewGroupToggleButton();

		//Passing the new Group name which is not Exist in DB
		String EN14 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 9, 1);
		CC.SetEnterNewGroup(EN14);

		//Passing the Values to the Enter Checkpoint intent
		String EC14 = Lib.getCellValue(XLPATH, "Check Point", 6, 0);
		CC.SetEnterCheckpointintent(EC14, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS14 = Lib.getCellValue(XLPATH, "Check Point", 12, 0);
		CC.SetDescription(DS14);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA14 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA14);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing the Values to Yes Disposition
		String YD14 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD14);

		//Passing the Values to No Disposition
		String NO14 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(NO14);

		//Passing the Values to Partial Disposition
		String PD14 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD14);

		//Passing the Values to NA Disposition
		String ND14 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND14);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL14 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL14);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA14 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA14);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);

		//checking Checkpoint Created Successfully Message is Displayed or not
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);

		System.out.println("*** Adding new CP to Static Annexure****");

		chiledTest.log(Status.INFO, "*** Adding new CP to Static Annexure****");

		//clicking on the Add checkpoint button
		AE.ClickAddCheckpointButton();

		//clicking on the Select Group
		CC.ClickSelectGroups();

		//Passing the Values to Select Group
		String SG15 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 1);
		CC.SetSelectGroup(SG15);

		CC.ClickMatched();

		//Passing the Values to the Enter Checkpoint intent
		String ECI515 = Lib.getCellValue(XLPATH, "Check Point", 125, 0);
		CC.SetEnterCheckpointintent(ECI515, driver);
		chiledTest.log(Status.INFO, "Checkpoint intent is Entered");

		//Passing the Values to the Description
		String DS515 = Lib.getCellValue(XLPATH, "Check Point", 131, 0);
		CC.SetDescription(DS515);
		chiledTest.log(Status.INFO, "Description is Entered");

		//clicking on the Expected action from auditor
		CC.ClickExpectedactionfromauditor(driver);

		//Passing the Values to Expected Action From Auditor
		String EA5115 = Lib.getCellValue(XLPATH, "Check Point", 215, 0);
		CC.SetExpectedActionFromAuditor(EA5115);
		chiledTest.log(Status.INFO, "Verify Option is Selected Under Expected Action From Auditor");

		//Clicking on the Matched Text
		CC.ClickMatched();

		//Passing the Values to Yes Disposition
		String YD515 = Lib.getCellValue(XLPATH, "Check Point", 148, 0);
		CC.SetYesDisposition(YD515);

		//Passing the Values to No Disposition
		String ND515 = Lib.getCellValue(XLPATH, "Check Point", 155, 0);
		CC.SetNoDisposition(ND515);

		//Passing the Values to Partial Disposition
		String PD515 = Lib.getCellValue(XLPATH, "Check Point", 162, 0);
		CC.SetPartialDisposition(PD515);

		//Passing the Values to NA Disposition
		String ND11515 = Lib.getCellValue(XLPATH, "Check Point", 169, 0);
		CC.SetNADisposition(ND11515);

		//clicking on the Risk level 
		CC.ClickRiskLevel(driver);

		//Passing the Values to Risk Level
		String RL515 = Lib.getCellValue(XLPATH, "Check Point", 206, 0);
		CC.SetRiskLevel(RL515);
		chiledTest.log(Status.INFO, "High Option is Selected Under Risk Level");

		CC.ClickMatched();

		//Passing the Values to Notes to auditors description
		String NTA515 = Lib.getCellValue(XLPATH, "Check Point", 42, 0);
		CC.SetNoticetoAuditors(NTA515);
		chiledTest.log(Status.INFO, "Notes to auditors is Entered");

		//Clicking on the Submit Button
		CC.ClickSubmitButton(driver);

		//checking Checkpoint Created Successfully Message is Displayed or not
		CC.VerifyCheckPointCreatedSuccessfullyMessageisDisplyedorNot(driver);

		//Validating Total 5 Checkpoints are Displayed or Not
		List<WebElement> NoOfCheckpoints1 = driver.findElements(By.xpath("//ul[@id='sortable1']/li"));
		int Actual_NoOfCheckpoints1 = NoOfCheckpoints1.size();
		int Expected_NoOfCheckpoints1 = 6;
		Assert.assertEquals(Actual_NoOfCheckpoints1, Expected_NoOfCheckpoints1, "Total 5 Checkpoints are NOT Displayed");

		System.out.println("*****Dragging 1st checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 1st checkpoint to No Compliance********");

		WebElement CP11 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP11));
		WebElement NO111 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO111));
		action.dragAndDrop(CP11, NO111).build(). perform();
		System.out.println("First Checkpoint is Dragged to No");
		chiledTest.log(Status.INFO, "First Checkpoint is Dragged to No");

		Thread.sleep(2000);

		System.out.println("*****Dragging 2nd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 2nd checkpoint to NO Compliance********");

		WebElement CP21 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP21));
		WebElement NO21 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO21));
		action.dragAndDrop(CP21, NO21).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to NO");
		System.out.println("Second Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 3rd checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 3rd checkpoint to NO Compliance********");

		WebElement CP31 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP31));
		WebElement NO31 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO31));
		action.dragAndDrop(CP31, NO31).build(). perform();
		chiledTest.log(Status.INFO, "Third Checkpoint is Dragged to No");
		System.out.println("Third Checkpoint is Dragged to NO");

		Thread.sleep(2000);

		System.out.println("*****Dragging 4th checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 4th checkpoint to NO Compliance********");

		WebElement CP41 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP41));
		WebElement NO411 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO411));
		action.dragAndDrop(CP41, NO411).build(). perform();
		chiledTest.log(Status.INFO, "Fourth Checkpoint is Dragged to No");
		System.out.println("Fourth Checkpoint is Dragged to No");

		Thread.sleep(2000);

		System.out.println("*****Dragging 5th checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 5th checkpoint to NO Compliance********");

		WebElement CP51 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP51));
		WebElement NO51 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO51));
		action.dragAndDrop(CP51, NO51).build(). perform();
		chiledTest.log(Status.INFO, "Fifth Checkpoint is Dragged to No");
		System.out.println("Fifth Checkpoint is Dragged to NO");

		System.out.println("*****Dragging 5th checkpoint to NO Compliance********");

		chiledTest.log(Status.INFO, "*****Dragging 5th checkpoint to NO Compliance********");

		WebElement CP6 = driver.findElement(By.xpath("//ul[@id='sortable1']/li[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(CP6));
		WebElement NO6 = driver.findElement(By.xpath("//ul[@id='sortable4']"));
		wait.until(ExpectedConditions.visibilityOf(NO6));
		action.dragAndDrop(CP6, NO6).build(). perform();
		chiledTest.log(Status.INFO, "Fifth Checkpoint is Dragged to No");
		System.out.println("Fifth Checkpoint is Dragged to No");

		//Clicking on the Next Button
		AE.ClickExpressModeVerifyTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//*************** Input Tab ***************************

		Thread.sleep(5000);

		//Selecting the 1st Values under 1st Values Drop down list
		WebElement SelectValues1 = driver.findElement(By.xpath("//ul[@class='cps inputs']/li[2]//select[@id='input_value']/option[2]"));
		wait.until(ExpectedConditions.visibilityOf(SelectValues1)).click();

		//Passing the Values to number
		String NU11 = Lib.getCellValue(XLPATH, "Audit Execution", 40, 0);
		AE.SetFirstNumber(NU11, driver);

		//Clicking on the Next Button
		AE.ClickExpressModeInputTabNextBTN(driver);
		chiledTest.log(Status.INFO, "Next Butto is Clicked");

		//******** Summary Tab *******

		//Passing the Values to Remarks
		String ER151 = Lib.getCellValue(XLPATH, "Audit Execution", 107, 0);
		AE.SetExpressRemarks(ER151);
		chiledTest.log(Status.INFO, "Remarks is Entered");

		//Clicking on the Submit Button
		AE.ClickExpressModeSubmitButton(driver);
		chiledTest.log(Status.INFO, "Submit Butto is Clicked");

		//Checking Audit Submitted Success Message is Displayed or not
		AE.VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit Submitted Success Message is Displayed");

		//clicking on the OK Button
		AE.ClickOKBTN1(driver);

		//clicking on the Submit Audit Button
		AE.ClickSubmitAuditBTN(driver);

		//verifying submitted successfully Success Message is Displayed
		AE.VerifySubmittedSuccessfullyMSGIsDisplayed(driver);

		System.out.println("*************************************");

	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=18, dependsOnMethods= {"Audit_Execution_Test"})
	public void Before_Approval_CP_And_Groups_Should_Not_Display_Test() throws InterruptedException
	{
		chiledTest = parentTest.createNode("Before Approval CP And Groups Should Not Display Test");

		System.out.println("Before Approval CP And Groups Should Not Display Test");

		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

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

		//passing the values to the Search Text Box
		String SB1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 1);
		AG.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "1st Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 1);
		AG.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "2nd Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 1);
		AG.SetSearchBox(SB3);
		chiledTest.log(Status.INFO, "3rd Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB4 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 1);
		AG.SetSearchBox(SB4);
		chiledTest.log(Status.INFO, "4th Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 1);
		AG.SetSearchBox(SB5);
		chiledTest.log(Status.INFO, "5th Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB6 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 8, 1);
		AG.SetSearchBox(SB6);
		chiledTest.log(Status.INFO, "6th Group Name is Searched");

		//Checking no records found Error Message should display
		AG.VerifyNoRecardfoundisdiplyed(driver);

		//passing the values to the Search Text Box
		String SB7 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 9, 1);
		AG.SetSearchBox(SB7);
		chiledTest.log(Status.INFO, "7th Group Name is Searched");

		//Checking no records found Error Message should display
		AG.VerifyNoRecardfoundisdiplyed(driver);

		System.out.println("************************");

	}

	//Testing the Functionality of the Finalize Audit
	@Test(priority=19, dependsOnMethods= {"Before_Approval_CP_And_Groups_Should_Not_Display_Test"})
	public void Reviewing_AddingCP_Finalize_Audit_Test() throws Exception
	{
		chiledTest = parentTest.createNode("Reviwing Adding CP And Finalize Audit Test");

		System.out.println("Reviwing Adding CP And Finalize Audit Test");

		ReviewCheckpointsPageTest RC = new ReviewCheckpointsPageTest(driver);

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
		String SB = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
		RA.SetSearchTextBox(SB);

		RA.ClickRefreshButton();

		//Clicking on the 1st Audit Type
		RA.ClickFirstTR(driver);

		System.out.println("*****Reviwing And Adding New CP and Finalzating 1st Group under Static Sub audit***");
		chiledTest.log(Status.INFO, "*****Reviwing And Adding New CP And Finalzating 1st Group under Static Sub audit***");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 2);
		RA.SetSubAudits(SA);

		RA.ClickMatchedTextOption(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 1);
		RA.SetGroup(SA2);

		RA.ClickMatchedTextOption(driver);

		//checking 5 CP are Displayed
		RA.Verify5CheckPointAreDisplayed(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		System.out.println("*****Adding New CP and Finalzating 2nd Group under Static Sub audit***");

		chiledTest.log(Status.INFO, "*****Adding New CP And Finalzating 2nd Group under Static Sub audit***");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA11 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 2);
		RA.SetSubAudits(SA11);

		RA.ClickMatchedTextOption(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA21 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 9, 1);
		RA.SetGroup(SA21);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//clicking on the New Checkpoint Legends
		RA.ClickNewCheckpointLegends();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//clicking on the add Checkpoint button
		RC.ClickAddCheckpointButton();

		//checking Do you wish to add this checkpoint permanently pop up is displayed
		RA.VerifyDoYouWishToAddThisCheckpointPermenantlyPopUpIsDisplayed();

		//clicking on the Yes Button
		RA.ClickYesButton();

		//Verifying CloseCheckpoint added successfully Message is displayed
		RA.verifyCheckpointAddedSuccessfullyMsgIsDisplayed();

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA123 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 2);
		RA.SetSubAudits(SA123);

		RA.ClickMatchedTextOption(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA211 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 9, 1);
		RA.SetGroup(SA211);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing Dynamic Annxure Sub Audit Type Without Not Adding CP**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Dynamic Annxure Sub Audit Type Without Not Ading CP******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA4 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 2);
		RA.SetSubAudits(SA4);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select all Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Select All Auditees
		RA.ClickSelectAllAuditees();

		//checking 5 CP Are Displayed
		RA.Verify5CheckPointAreDisplayed(driver);

		//clicking on the Review Button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing general Sub Audit Type But Not Adding CP**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing general Sub Audit Type Not Adding CP******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 2);		
		RA.SetSubAudits(SA1);

		RA.ClickMatchedTextOption(driver);

		//Removing the Already Selected Group from the Select Group
		RA.ClickRemoveBTN();

		//Passing the 1st group
		String SA212 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 1);
		RA.SetGroup(SA212);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 1);
		RA.SetGroup(SA3);

		RA.ClickMatchedTextOption(driver);

		//Passing the 2nd group
		String SA31 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 8, 1);
		RA.SetGroup(SA31);

		RA.ClickMatchedTextOption(driver);

		//clicking on the Select All Checkpoints
		RA.ClickSelectAllCheckpoints();

		//clicking on the Reviewed button
		RA.ClickReviewedBTN();

		//clicking on the Finalize button
		RA.ClickSubAuditFinalizeButton();

		System.out.println("*****************Reviewing and Finalizing Execptional Sub Audit Type Adding new CP**********************");

		chiledTest.log(Status.INFO, "**************Reviewing and Finalizing Execptional Sub Audit Type Adding New CP******************");

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 2);
		RA.SetSubAudits(SA5);

		RA.ClickMatchedTextOption(driver);

		//clicking on the 5th CP
		RA.ClickfifthCheckPoint();

		//clicking on the New Checkpoint Legends
		RA.ClickNewCheckpointLegends();

		//clicking on the Checkpoint Edit Button
		RA.ClickCheckpointEditBTN();

		//clicking on the add Checkpoint button
		RC.ClickAddCheckpointButton();

		//checking Do you wish to add this checkpoint permanently pop up is displayed
		RA.VerifyDoYouWishToAddThisCheckpointPermenantlyPopUpIsDisplayed();

		//clicking on the Yes Button
		RA.ClickYesButton();

		//Verifying CloseCheckpoint added successfully Message is displayed
		RA.verifyCheckpointAddedSuccessfullyMsgIsDisplayed();

		//clicking on the Select sub audit Type drop down
		RA.ClickSelectSubAuditType();

		//Passing the Values to Sub Audit under Select Sub audit Type drop down
		String SA51 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 2);
		RA.SetSubAudits(SA51);

		RA.ClickMatchedTextOption(driver);

		//checking 5 CP Are Displayed
		RA.Verify5CheckPointAreDisplayed(driver);

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

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=20, dependsOnMethods= {"Reviewing_AddingCP_Finalize_Audit_Test"})
	public void Post_Approval_CP_And_Groups_Should_Not_Display_Test() throws InterruptedException
	{
		chiledTest = parentTest.createNode("Post Approval CP And Groups Should Not Display Test");

		System.out.println("Post Approval CP And Groups Should Not Display Test");

		LoginPageTest l=new LoginPageTest(driver);

		GroupPageTest AG = new GroupPageTest(driver);

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

		//passing the values to the Search Text Box
		String SB1 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 1);
		AG.SetSearchBox(SB1);
		chiledTest.log(Status.INFO, "1st Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB2 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 4, 1);
		AG.SetSearchBox(SB2);
		chiledTest.log(Status.INFO, "2nd Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB3 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 1);
		AG.SetSearchBox(SB3);
		chiledTest.log(Status.INFO, "3rd Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB4 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 6, 1);
		AG.SetSearchBox(SB4);
		chiledTest.log(Status.INFO, "4th Group Name is Searched");

		//Checking total 4 Cp is Displayed
		AG.Verify4NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB5 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 7, 1);
		AG.SetSearchBox(SB5);
		chiledTest.log(Status.INFO, "5th Group Name is Searched");

		//Checking total 5 Cp is Displayed
		AG.Verify5NoIsDisplayed();

		//passing the values to the Search Text Box
		String SB9 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 8, 1);
		AG.SetSearchBox(SB9);
		chiledTest.log(Status.INFO, "6th Group Name is Searched");

		//Checking no records found Error Message should display
		AG.VerifyNoRecardfoundisdiplyed(driver);

		//passing the values to the Search Text Box
		String SB10 = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 9, 1);
		AG.SetSearchBox(SB10);
		chiledTest.log(Status.INFO, "7th Group Name is Searched");

		//checking 1 CP is Displayed
		AG.Verify1NoIsDisplayed();

		System.out.println("************************");

	}

	//Testing the Functionality of the Audit Execution page
	@Test(priority=21, dependsOnMethods= {"Post_Approval_CP_And_Groups_Should_Not_Display_Test"})
	public void Validating_The_Scores_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ReviewAuditPageTest RA = new ReviewAuditPageTest(driver);

		System.out.println("Validating the Score Test");

		chiledTest = parentTest.createNode("Validating the Score Test");

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
		String SB = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 3, 3);
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
		String Expected_TotalScore = "30.0 / 110.0"; 
		System.out.println("Expected Total Score is : " + Expected_TotalScore);
		Assert.assertEquals(Actual_TotalScore, Expected_TotalScore, "Total Score is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Total score are Matched");

		//Checking the Audit rating
		String Actual_AuditRating = driver.findElement(By.xpath("//div[@class='recalc_rating']")).getText();
		System.out.println("Actual Rating is : " + Actual_AuditRating);
		String Expected_AuditRating = Lib.getCellValue(XLPATH, "Adding CP With SubAudits", 5, 14);
		System.out.println("Expected Rating is : " + Expected_AuditRating);
		Assert.assertEquals(Actual_AuditRating, Expected_AuditRating, "Audit Rating is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual ratings are Matched");

		//Checking the Compliances %
		String Actual_Compliances = driver.findElement(By.xpath("//div[@class='recalc_compliance_percentage']")).getText();
		System.out.println("Actual Rating is : " + Actual_Compliances);
		String Expected_Compliances = "27.27";
		System.out.println("Expected Compliance is : " + Expected_Compliances);
		Assert.assertEquals(Actual_Compliances, Expected_Compliances, "Compliances % is Wrong");
		chiledTest.log(Status.INFO, "Expected and Actual Compliances % are Matched");

		RA.ClickSummaryCloseBTN();

		System.out.println("********************************");

	}




}

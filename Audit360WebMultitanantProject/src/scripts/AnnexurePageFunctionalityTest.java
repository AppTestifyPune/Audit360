package scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AnnexurePageTest;
import pom.LoginPageTest;

public class AnnexurePageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Annexure Page Test
	@Test(priority=1)
	public void Annexure_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AnnexurePageTest AT = new AnnexurePageTest(driver);

		parentTest = extent.createTest("Annexure Functionality Test", "Adding Dynamic Annexure Test, Adding Static Annexure, Search Annexure, Annexure Manadatroy Fileds Test Etc..");

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

	//Testing the Functionality of the Add Annexure Test
	@Test(priority=2,dependsOnMethods= {"Annexure_Page_Test"})
	public void Adding_Dynamic_Annexure_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Adding Dynamic Annexure Test");

		System.out.println("Adding Dynamic Annexure Test");

		//Clicking on the Add New Annexure Button
		AT.ClickAddNewAnnexureBTN(driver);

		//Passing the Values to Annexure
		String AN1 = Lib.getCellValue(XLPATH, "Annexure", 3, 0);
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
		

		System.out.println("*****************************************************************");


	}

	//Testing the Functionality of the Adding Static Annexure Test
	@Test(priority=3, dependsOnMethods= {"Adding_Dynamic_Annexure_Test"})
	public void Adding_Static_Annexure_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Adding Static Annexure Test");

		System.out.println("Adding Static Annexure Test");

		//Clicking on the Add New Annexure Button
		AT.ClickAddNewAnnexureBTN(driver);

		//Passing the Values to Annexure Name
		String AN = Lib.getCellValue(XLPATH, "Annexure", 4, 0);
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

		System.out.println("*****************************************************************");

	}

	//Testing the Functionality of the Adding same Annexure Test
	@Test(priority=4, dependsOnMethods= {"Adding_Static_Annexure_Test"})
	public void Adding_Same_Annexure_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Adding Same Annexure Test");

		System.out.println("Adding Same Annexure Test");

		//Clicking on the Add New Annexure Button
		AT.ClickAddNewAnnexureBTN(driver);
		
		//Passing the Values to Annexure
		String AN1 = Lib.getCellValue(XLPATH, "Annexure", 3, 0);
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

		//Verifying Name has already been taken Message is Displayed
		AT.VerifyNameHasAlreadyBeenTakenMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Name has already been taken Message is Displayed");


		System.out.println("*****************************************************************");

	}

	//Testing the Functionality of the Adding Static Annexure Test
	@Test(priority=5, dependsOnMethods= {"Adding_Same_Annexure_Test"})
	public void Edit_Annexure_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Edit Annexure Test");

		System.out.println("Edit Annexure Test");

		AT.ClickAddNewAnnexureBTN(driver);

		//Passing the Values to Annexure
		String AN1 = Lib.getCellValue(XLPATH, "Annexure", 5, 0);
		AT.SetAnnexureName(AN1);
		chiledTest.log(Status.INFO, "Annexure Name Is Entered");

		//passing the Values to 1st attribute index
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

		//passing the Values to 1st attribute index
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

		//passing the Values to 3rd attribute index
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

		//passing the Values to 4th attribute index
		String FHI = Lib.getCellValue(XLPATH, "Annexure", 32, 0);
		AT.SetFourthAttributIndex(FHI);
		
		//Passing the Values to 4th Attribute Name
		String FAN111 = Lib.getCellValue(XLPATH, "Annexure", 11, 0);
		AT.SetFourthAttributeName(FAN111);
		chiledTest.log(Status.INFO, "Attribute Name Is Entered");

		//Selecting the Both with condition Option
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
		
		AT.ClickAddNewAnnexureBTN(driver);

		driver.navigate().refresh();

		Thread.sleep(2000);

		AT.ClickAnnexureNameDropDown();

		//Passing the values to Annexure name drop down
		String AN = Lib.getCellValue(XLPATH, "Annexure", 5, 0);
		AT.SetAnnexureNameDropDown(AN);

		AT.ClickMatched();

		//clicking on the Edit Button
		AT.ClickEditButton();

		//Passing the already exist annexure name while editing the annexure
		String AN2 = Lib.getCellValue(XLPATH, "Annexure", 4, 0);
		AT.SetAnnexureName(AN2);

		//Clicking on the Save Button
		AT.ClickSaveBTN(driver);

		//verifying Name has already been Taken message is Displayed
		AT.VerifyNameHasAlreadyBeenTakenMSGIsDisplayed(driver);

		System.out.println("********************************************");

	}

	//Testing the Functionality of the Add Annexure Mandatory Fields Test
	@Test(priority=6, dependsOnMethods= {"Edit_Annexure_Test"})
	public void Delete_Annexure_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Delete Annexure Test");

		System.out.println("Delete Annexure Test");

		driver.navigate().refresh();

		AT.ClickAnnexureNameDropDown();

		//Passing the values to Annexure name drop down
		String AN = Lib.getCellValue(XLPATH, "Annexure", 5, 0);
		AT.SetAnnexureNameDropDown(AN);

		AT.ClickMatched();

		//clicking on the Delete button
		AT.ClickDeleteButton();

		//verifying are you sure you delete
		AT.VerifyAreYouSurePopUpIsDisplayed();

		//clicking on OK Button
		AT.ClickOKButton();

		//verifying Annexure was Successfully deleted Message is Displayed
		AT.VerifyAnnexureWasSuccessfullyDeletedMSGIsDisplayed();

		System.out.println("**************************************");

	}

	//Testing the Functionality of the Add Annexure Mandatory Fileds Test
	@Test(priority=7, dependsOnMethods= {"Delete_Annexure_Test"})
	public void Add_Annexure_MandatoryFileds_Test() throws InterruptedException
	{
		AnnexurePageTest AT = new AnnexurePageTest(driver);

		chiledTest = parentTest.createNode("Add Annexure Mandatory Fields Test");

		System.out.println("Add Annexure Mandatory Fields Test");

		//Clicking on the Add New Annexure Button
		AT.ClickAddNewAnnexureBTN(driver);

		//Checking Mandatory Fields
		AT.VerifyMandatoryFieldsAreDisplayed(driver);
		chiledTest.log(Status.INFO, "Please Fill Out This Filed Message is Displayed");

		//Clicking on the Cancel Button
		AT.ClickCancelBTN(driver);
		chiledTest.log(Status.INFO, "Cancel Button is Clicked");

		System.out.println("*****************************************************************");

	}


}

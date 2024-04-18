package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;
import pom.AdditionalInformationPageTest;
import pom.ConfigureAuditPageTest;
import pom.LoginPageTest;

public class AdditionalInformationsFunctinalityTest extends BaseTest {

	//Testing the Functionality of the Configure Audit page
	@Test(priority=1)
	public void Configure_Audit_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		parentTest = extent.createTest("Additional Informations Functionality Test", "Testing the Configure Audit Page, Creating Audit Type, Search, Edit, etc..");

		chiledTest = parentTest.createNode("Additional Informations Functionality Test");

		System.out.println("Additional Informations Functionality Test");

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
		
		CA.ClickConfigureAuditSubMenu();

		//Verifying Audit type Page is Displayed
		CA.VerifyAuditTypePageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type Page is Displayed");

		System.out.println("**************************************************************");


	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	@Test(priority=2)
	public void Additional_Info_While_Creating_The_AuditType_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		AdditionalInformationPageTest AI = new AdditionalInformationPageTest(driver);

		chiledTest = parentTest.createNode("Additional Informations Test");

		System.out.println("Additional Informations Test");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******* DEFINE TAB *****************************

		//Clicking on the Parent Type Audit Radio Button
		CA.ClickParentTypeAuditRadioBTN(driver);
		chiledTest.log(Status.INFO, "Parent audit type Radio Button is Clicked");

		//Clicking on the select Group 
		CA.ClickSelectGrouptype(driver);

		//Passing the values to  select Group type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Checking the Select Check Point group is Selected or not
		List<WebElement> SCG1 = driver.findElements(By.xpath("//div[@id='s2id_groups_']/ul[@class='select2-choices']"));
		int SCGCount = SCG1.size();
		Assert.assertTrue(SCGCount>0, "Check Point group is Not Selected");

		//Checking the Check Point table is displayed
		boolean Table = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']")).isDisplayed();
		System.out.println("Check Point grid is Displayed : " + Table);

		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 4;
		Assert.assertEquals(CPCount, CPCount1, "Check Points Count are Wrong");

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* EVALUATE  TAB ***************************

		//Passing the Values to Low Risk Scoring
		String LR = Lib.getCellValue(XLPATH, "Configure Audit Type", 37, 0);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "Configure Audit Type", 41, 0);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "Configure Audit Type", 45, 0);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "Configure Audit Type", 49, 0);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Tolerance Risk Scoring is Entered");

		//Clicking on the Next Button
		CA.ClickEvaluteTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = driver.switchTo().alert();
		Alert.dismiss();


		//******** CONFIGURE  TAB **************

		// clicking on the Do you wish to add additional information at checkpoint level? Toggle Button
		//CA.ClickAdditionalInfoToggleBTN();

		//checking All Additional Informations are Displayed
		AI.VerifyAdditionalInformationsAreIsDisplayedPostEnabledToggleBTN();

		//*** Before Selecting Any Check box checking all 12 Is Mandatory Check box are in Read only mode or NOT**
		List<WebElement> IsMandatoryCKB = driver.findElements(By.xpath("//input[@class='is_mandetory' and @disabled='disabled']"));
		Assert.assertTrue(IsMandatoryCKB.size()==12, "All 12 Is Mandatory Check Box are NOT in Read only mode");
		System.out.println("All 12 is mandatory check box are in Read only mode");
		chiledTest.log(Status.INFO, "All 12 is mandatory check box are in Read only mode");

		//*** Before Selecting Any Check box checking all 12 Input Type are in Read only mode or NOT**
		List<WebElement> InputType = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype' and @disabled='disabled']"));
		Assert.assertTrue(InputType.size()==12, "All 12 Input Type are NOT in Read only mode");
		System.out.println("All 12 Input Type are are in Read only mode");
		chiledTest.log(Status.INFO, "All 12 Input Type are are in Read only mode");

		//*** Before Selecting Any Check box checking all 12 Input Values are in Read only mode or NOT**
		List<WebElement> InputValues = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		Assert.assertTrue(InputValues.size()==12, "All 12 Input Values are NOT in Read only mode");
		System.out.println("All 12 Input Values are are in Read only mode");
		chiledTest.log(Status.INFO, "All 12 Input Valuesype are are in Read only mode");


		//Selecting All the Check Box 
		List<WebElement> ALLCKBTN = driver.findElements(By.xpath("//input[@class='info_flag']"));
		for(int i=0; i<ALLCKBTN.size(); i++)
		{
			ALLCKBTN.get(i).click();
		}
		System.out.println("All Check Box are Clicked");
		chiledTest.log(Status.INFO, "All Check Box are Clicked");

		//*** After Selecting All Check box checking all 12 Is Mandatory Check box are in Enabled mode or NOT**
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> IsMandatoryCKB1 = driver.findElements(By.xpath("//input[@class='is_mandetory' and @disabled='disabled']"));
		Assert.assertTrue(IsMandatoryCKB1.size()==0, "All 12 Is Mandatory Check Box are NOT in Enabled mode");
		System.out.println("All 12 is mandatory check box are in Enabled mode");
		chiledTest.log(Status.INFO, "All 12 is mandatory check box are in Enabled mode");

		//*** After Selecting All Check box checking all 12 Input Type are in Enabled mode or NOT**
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> IT = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype' and @disabled='disabled']"));
		Assert.assertTrue(IT.size()==0, "All 12 Input Type are NOT in Enabled mode");
		System.out.println("All 12 Input Type are are in Enabled mode");
		chiledTest.log(Status.INFO, "All 12 Input Type are are in Enabled mode");


		//** If We select Number under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType1 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Number']"));
		List<WebElement> InputValues1 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType1.size(); i++)
		{
			WebElement AllInputType1 = InputType1.get(i);
			String Text1 = AllInputType1.getText();
			System.out.println("Selected Input Type Option is : " + Text1);
			InputType1.get(i).click();

			boolean IV1 = InputValues1.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV1);
			Assert.assertFalse(InputValues1.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Text under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType2 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Text']"));
		List<WebElement> InputValues2 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType1.size(); i++)
		{
			WebElement AllInputType2 = InputType2.get(i);
			String Text2 = AllInputType2.getText();
			System.out.println("Selected Input Type Option is : " + Text2);
			InputType2.get(i).click();

			boolean IV2 = InputValues2.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV2);
			Assert.assertFalse(InputValues2.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Text and numbers under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType3 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Text and numbers']"));
		List<WebElement> InputValues3 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType3.size(); i++)
		{
			WebElement AllInputType3 = InputType3.get(i);
			String Text3 = AllInputType3.getText();
			System.out.println("Selected Input Type Option is : " + Text3);
			InputType3.get(i).click();

			boolean IV3 = InputValues3.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV3);
			Assert.assertFalse(InputValues3.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Date under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType4 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Date']"));
		List<WebElement> InputValues4 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType4.size(); i++)
		{
			WebElement AllInputType4 = InputType3.get(i);
			String Text4 = AllInputType4.getText();
			System.out.println("Selected Input Type Option is : " + Text4);
			InputType4.get(i).click();

			boolean IV4 = InputValues4.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV4);
			Assert.assertFalse(InputValues4.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Date and Range under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType5 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Date and range']"));
		List<WebElement> InputValues5 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType5.size(); i++)
		{
			WebElement AllInputType5 = InputType5.get(i);
			String Text5 = AllInputType5.getText();
			System.out.println("Selected Input Type Option is : " + Text5);
			InputType5.get(i).click();

			boolean IV5 = InputValues5.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV5);
			Assert.assertFalse(InputValues5.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Values under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType6 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Values']"));
		List<WebElement> InputValues6 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType6.size(); i++)
		{
			WebElement AllInputType6 = InputType6.get(i);
			String Text6 = AllInputType6.getText();
			System.out.println("Selected Input Type Option is : " + Text6);
			InputType6.get(i).click();

			boolean IV6 = InputValues6.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV6);
			Assert.assertTrue(InputValues6.size()>0, "Input Values Text Field is NOT in Read only mode");

		}


		/*//** If We select Percentage under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType7 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Percentage']"));
		List<WebElement> InputValues7 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<=InputType7.size(); i++)
		{
			WebElement AllInputType7 = InputType7.get(i);
			String Text7 = AllInputType7.getText();
			System.out.println("Selected Input Type Option is : " + Text7);
			InputType7.get(i).click();
			Thread.sleep(2000);
			boolean IV7 = InputValues7.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV7);
			Assert.assertFalse(InputValues7.size()<=0, "Input Values Text Field is NOT in Read only mode");


		}*/


	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	//@Test(priority=3)
	public void Additional_Info_While_Editing_The_Audit_Type_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		AdditionalInformationPageTest AI = new AdditionalInformationPageTest(driver);

		chiledTest = parentTest.createNode("Additional Informations Test");

		System.out.println("Additional Informations Test");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.navigate().refresh();

		//Passing the Values to Search Text box
		String SB = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
		CA.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Created the Audit Type is Serached");

		//Clicking on the First Audit Type
		CA.ClickFirstAuditType(driver);

		// clicking on the Do you wish to add additional information at checkpoint level? Toggle Button
		//CA.ClickAdditionalInfoToggleBTN();

		//*** Before Selecting Any Check box checking all 12 Is Mandatory Check box are in Read only mode or NOT**
		List<WebElement> IsMandatoryCKB = driver.findElements(By.xpath("//input[@class='is_mandetory' and @disabled='disabled']"));
		Assert.assertTrue(IsMandatoryCKB.size()==12, "All 12 Is Mandatory Check Box are NOT in Read only mode");
		System.out.println("All 12 is mandatory check box are in Read only mode");
		chiledTest.log(Status.INFO, "All 12 is mandatory check box are in Read only mode");

		//*** Before Selecting Any Check box checking all 12 Input Type are in Read only mode or NOT**
		List<WebElement> InputType = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype' and @disabled='disabled']"));
		Assert.assertTrue(InputType.size()==12, "All 12 Input Type are NOT in Read only mode");
		System.out.println("All 12 Input Type are are in Read only mode");
		chiledTest.log(Status.INFO, "All 12 Input Type are are in Read only mode");

		//*** Before Selecting Any Check box checking all 12 Input Values are in Read only mode or NOT**
		List<WebElement> InputValues = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		Assert.assertTrue(InputValues.size()==12, "All 12 Input Values are NOT in Read only mode");
		System.out.println("All 12 Input Values are are in Read only mode");
		chiledTest.log(Status.INFO, "All 12 Input Valuesype are are in Read only mode");


		//Selecting All the Check Box 
		List<WebElement> ALLCKBTN = driver.findElements(By.xpath("//input[@class='info_flag']"));
		for(int i=0; i<ALLCKBTN.size(); i++)
		{
			ALLCKBTN.get(i).click();
		}
		System.out.println("All Check Box are Clicked");
		chiledTest.log(Status.INFO, "All Check Box are Clicked");

		//*** After Selecting All Check box checking all 12 Is Mandatory Check box are in Enabled mode or NOT**
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> IsMandatoryCKB1 = driver.findElements(By.xpath("//input[@class='is_mandetory' and @disabled='disabled']"));
		Assert.assertTrue(IsMandatoryCKB1.size()==0, "All 12 Is Mandatory Check Box are NOT in Enabled mode");
		System.out.println("All 12 is mandatory check box are in Enabled mode");
		chiledTest.log(Status.INFO, "All 12 is mandatory check box are in Enabled mode");

		//*** After Selecting All Check box checking all 12 Input Type are in Enabled mode or NOT**
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> IT = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype' and @disabled='disabled']"));
		Assert.assertTrue(IT.size()==0, "All 12 Input Type are NOT in Enabled mode");
		System.out.println("All 12 Input Type are are in Enabled mode");
		chiledTest.log(Status.INFO, "All 12 Input Type are are in Enabled mode");


		//** If We select Number under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType1 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Number']"));
		List<WebElement> InputValues1 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType1.size(); i++)
		{
			WebElement AllInputType1 = InputType1.get(i);
			String Text1 = AllInputType1.getText();
			System.out.println("Selected Input Type Option is : " + Text1);
			InputType1.get(i).click();

			boolean IV1 = InputValues1.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV1);
			Assert.assertFalse(InputValues1.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Text under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType2 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Text']"));
		List<WebElement> InputValues2 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType1.size(); i++)
		{
			WebElement AllInputType2 = InputType2.get(i);
			String Text2 = AllInputType2.getText();
			System.out.println("Selected Input Type Option is : " + Text2);
			InputType2.get(i).click();

			boolean IV2 = InputValues2.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV2);
			Assert.assertFalse(InputValues2.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Text and numbers under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType3 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Text and numbers']"));
		List<WebElement> InputValues3 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType3.size(); i++)
		{
			WebElement AllInputType3 = InputType3.get(i);
			String Text3 = AllInputType3.getText();
			System.out.println("Selected Input Type Option is : " + Text3);
			InputType3.get(i).click();

			boolean IV3 = InputValues3.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV3);
			Assert.assertFalse(InputValues3.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Date under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType4 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Date']"));
		List<WebElement> InputValues4 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType4.size(); i++)
		{
			WebElement AllInputType4 = InputType3.get(i);
			String Text4 = AllInputType4.getText();
			System.out.println("Selected Input Type Option is : " + Text4);
			InputType4.get(i).click();

			boolean IV4 = InputValues4.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV4);
			Assert.assertFalse(InputValues4.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Date and Range under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType5 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Date and range']"));
		List<WebElement> InputValues5 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType5.size(); i++)
		{
			WebElement AllInputType5 = InputType5.get(i);
			String Text5 = AllInputType5.getText();
			System.out.println("Selected Input Type Option is : " + Text5);
			InputType5.get(i).click();

			boolean IV5 = InputValues5.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV5);
			Assert.assertFalse(InputValues5.size()<=0, "Input Values Text Field is NOT in Read only mode");

		}

		//** If We select Values under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType6 = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option[text()='Values']"));
		List<WebElement> InputValues6 = driver.findElements(By.xpath("//input[@id='data_type_value' and @disabled='disabled']"));
		for (int i=0; i<InputType6.size(); i++)
		{
			WebElement AllInputType6 = InputType6.get(i);
			String Text6 = AllInputType6.getText();
			System.out.println("Selected Input Type Option is : " + Text6);
			InputType6.get(i).click();

			boolean IV6 = InputValues6.get(i).isEnabled();
			System.out.println("Input Value Text field is Enabled : " + IV6);
			Assert.assertTrue(InputValues6.size()>0, "Input Values Text Field is NOT in Read only mode");

		}
	}

	//Testing the Functionality of the Creating Parent Audit Type Test
	//@Test(priority=4)
	public void Creating_The_AuditType_With_12_Addtional_Parameters_Test() throws InterruptedException
	{

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		AdditionalInformationPageTest AI = new AdditionalInformationPageTest(driver);

		chiledTest = parentTest.createNode("Additional Informations Test");

		System.out.println("Additional Informations Test");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Configure Audit Type", 12, 0);
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
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******* DEFINE TAB *****************************

		//Clicking on the Parent Type Audit Radio Button
		CA.ClickParentTypeAuditRadioBTN(driver);
		chiledTest.log(Status.INFO, "Parent audit type Radio Button is Clicked");

		//Clicking on the select Group 
		CA.ClickSelectGrouptype(driver);

		//Passing the values to  select Group type
		String SGT = Lib.getCellValue(XLPATH, "Configure Audit Type", 27, 0);
		CA.SetSelectGrouptype(SGT);

		//clicking on the Matching
		CA.ClickMatch();

		//Passing the Values to Select CheckPoint 
		String SCG = Lib.getCellValue(XLPATH, "Group", 8, 0);
		CA.SetSelectCheckPointGroup(SCG, driver);

		//clicking on the Matching
		CA.ClickMatch();

		//Checking the Select Check Point group is Selected or not
		List<WebElement> SCG1 = driver.findElements(By.xpath("//div[@id='s2id_groups_']/ul[@class='select2-choices']"));
		int SCGCount = SCG1.size();
		Assert.assertTrue(SCGCount>0, "Check Point group is Not Selected");

		//Checking the Check Point table is displayed
		boolean Table = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']")).isDisplayed();
		System.out.println("Check Point grid is Displayed : " + Table);

		//Checking the Count of the Check Points
		WebElement CheckPointsCounts = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		wait.until(ExpectedConditions.visibilityOf(CheckPointsCounts));
		List<WebElement> CPSixze = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr"));
		int CPCount = CPSixze.size();
		int CPCount1 = 4;
		Assert.assertEquals(CPCount, CPCount1, "Check Points Count are Wrong");

		//Clicking on the Next Button
		CA.ClickDefineTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		// ********* EVALUATE  TAB ***************************

		//Passing the Values to Low Risk Scoring
		String LR = Lib.getCellValue(XLPATH, "Configure Audit Type", 37, 0);
		CA.SetLowRiskScoring(LR);
		chiledTest.log(Status.INFO, "Low Risk Scoring is Entered");

		//Passing the Values to Medium Risk Scoring
		String MR = Lib.getCellValue(XLPATH, "Configure Audit Type", 41, 0);
		CA.SetMeadiumRiskScroring(MR);
		chiledTest.log(Status.INFO, "Medium Risk Scoring is Entered");

		//Passing the Values to High Risk Scoring
		String HR = Lib.getCellValue(XLPATH, "Configure Audit Type", 45, 0);
		CA.SetHighRiskScoring(HR);
		chiledTest.log(Status.INFO, "High Risk Scoring is Entered");

		//Passing the Values to Zero Tolerance Risk Scoring
		String ZR = Lib.getCellValue(XLPATH, "Configure Audit Type", 49, 0);
		CA.SetZeroTaleranceRiskScoring(ZR);
		chiledTest.log(Status.INFO, "Zero Tolerance Risk Scoring is Entered");

		//Clicking on the Next Button
		CA.ClickEvaluteTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//Verifying Would you like to configure Roles for this Audit Type? Alert is Displayed
		Alert Alert = driver.switchTo().alert();
		Alert.dismiss();


		//******** CONFIGURE  TAB **************

		// clicking on the Do you wish to add additional information at checkpoint level? Toggle Button
		//CA.ClickAdditionalInfoToggleBTN();

		//Selecting All the Check Box 
		List<WebElement> ALLCKBTN = driver.findElements(By.xpath("//input[@class='info_flag']"));
		for(int i=0; i<ALLCKBTN.size(); i++)
		{
			ALLCKBTN.get(i).click();
		}
		System.out.println("All Check Box are Clicked");
		chiledTest.log(Status.INFO, "All Check Box are Clicked");

		//Selecting the Number 
		//driver.findElement(By.xpath("//select[@id='audit_type_additional_informations_attributes_0_datatype']/option[@value='number']")).click();

		//** If We select Values under Input Type drop down than Input Values should be in Read only Mode**
		List<WebElement> InputType = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']"));
		List<WebElement> InputValuesOptions = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']/option"));
		for (int i=1; i<InputType.size(); i++)
		{
			WebElement AllInputType = InputType.get(i);
		}
		for (int i=0; i<InputValuesOptions.size(); i++)
		{
			InputValuesOptions.get(1).click();
		}

	}


}


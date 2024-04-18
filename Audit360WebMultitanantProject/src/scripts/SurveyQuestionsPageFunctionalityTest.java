package scripts;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.ConfigureAuditPageTest;
import pom.LoginPageTest;
import pom.SurveyQuestionsPageTest;

public class SurveyQuestionsPageFunctionalityTest extends BaseTest {

	//Creating the Configure Audit Type
	@Test(priority=1)
	public void Creating_Configure_Audit_Type_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ConfigureAuditPageTest CA = new ConfigureAuditPageTest(driver);

		parentTest = extent.createTest("Survey Questions Page Test", "Testing the Functionality of Survey Questions Page, Adding Questions Etc..");

		chiledTest = parentTest.createNode("Creating Configure Audit Type Test");

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

		//clicking on Scroll Bar Under side menu
		CA.ClickScrollBar(driver);

		//Clicking on the User Manage from side menu
		CA.ClickConfigureAudit(driver);
		chiledTest.log(Status.INFO, "Configure Audit is Clicked");

		//Clicking on the configure Audit Sub menu
		CA.ClickConfigureAuditSubMenu();

		//Clicking on the Create Audit Type Button
		CA.ClickCreateAuditTypeBTN(driver);
		chiledTest.log(Status.INFO, "Create Audit Type Button is Clicked");

		//******* Begin Tab *****************************

		//Passing the Values to Audit Type Name
		String ATN = Lib.getCellValue(XLPATH, "Survey Questions", 3, 0);
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

		//Clicking on the Select verifier
		CA.clickSelectVerifier();

		//Passing the Values to Select Verifier
		String SV = Lib.getCellValue(XLPATH, "Configure Audit Type", 58, 0);
		CA.SetSelectVerifier(SV);
		chiledTest.log(Status.INFO, "Verifier is Selected");

		//Clicking on the Match
		CA.ClickMatch();

		//Clicking on the Select TAT
		CA.ClickSelectTATType();

		//Passing the Values to Select TAT
		String ST = Lib.getCellValue(XLPATH, "Configure Audit Type", 66, 0);
		CA.SetSelectTATType(ST);
		chiledTest.log(Status.INFO, "Proposed By Auditee is Selected under Select TAT Type");

		CA.ClickMatch();

		//Clicking on the Next Button
		CA.ClickConfigureTabNextButton();
		chiledTest.log(Status.INFO, "Next Button is Clicked");

		//******************** Finalize Tab ************************

		Thread.sleep(5000);

		//Passing the Values to First Out Come
		String FO = Lib.getCellValue(XLPATH, "Configure Audit Type", 99, 0);
		CA.SetFirstOutCome(FO, driver);
		chiledTest.log(Status.INFO, "Out Come is Entered");

		//Clicking on the Submit Button
		CA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Audit type created successfully. Success Message is Displayed
		CA.VerifyAuditTypeCreatedSuccessfullyMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Audit type created successfully. Success Message is Displayed");

		System.out.println("**************************************************************");

	}


	//Testing the Functionality of the Survey Questions Page Test
	@Test(priority=2, dependsOnMethods= {"Creating_Configure_Audit_Type_Test"})
	public void Survey_Questions_Page_Test() throws InterruptedException
	{

		SurveyQuestionsPageTest SQ = new SurveyQuestionsPageTest(driver);

		chiledTest = parentTest.createNode("Survey Questions Page Test");

		System.out.println("Survey Questions Page Test");

		SQ.ClickScrollBar(driver);

		//Clicking on the Auditor Survey from side menu
		SQ.ClickAuditorSurvey(driver);
		chiledTest.log(Status.INFO, "Auditor Survey is Clicked");

		//Clicking on the Survey Questions
		SQ.ClickSurveryQuestions(driver);
		chiledTest.log(Status.INFO, "Survey Questions is Clicked");

		//Verifying Auditor Survey Page is Displayed
		SQ.VerifyAuditorSurveyPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Auditor Survey Page is Displayed");

		System.out.println("*********************************************************************");

	}

	//Testing the Functionality of the Add Survey Questions Test
	@Test(priority=3, dependsOnMethods= {"Creating_Configure_Audit_Type_Test"})
	public void Add_Survey_Questions_Manadatory_Fields_Test() throws InterruptedException
	{

		SurveyQuestionsPageTest SQ = new SurveyQuestionsPageTest(driver);

		chiledTest = parentTest.createNode("Add Survey Questions Manadtaory Fields Test");

		System.out.println("Add Survey Questions Manadtaory Fields Test");

		//Clicking on the Select Audit Type
		SQ.ClickSelectAuditType();

		//Passing the Values to Select Audit Type 
		String SA = Lib.getCellValue(XLPATH, "Survey Questions", 3, 0);
		SQ.SetSelectAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched text
		SQ.ClickMatch();

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		SQ.VerifyPleaseSelectAtleastOneSurveyQuestionAlertMessageIsDisplayed(driver);

		//Clicking on the Add a Questions
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Questions Button is Clicked");

		//Verifying Add new Question Page is Displayed
		SQ.VerifyAddNewQuestionPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Add new Question Page is Displayed");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Question Can't be Blank Error Message is Displayed
		SQ.VerifyQuestionCantBeBlankErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Question Can't be blank Error Message is Displayed");

		//Clicking on the Close Button
		SQ.ClickCloseBTN();
		chiledTest.log(Status.INFO, "Close Button is Clicked");

		System.out.println("**************************************************************************");

	}

	//Testing the Functionality of the Adding 10 Survey Questions Test
	@Test(priority=4, dependsOnMethods= {"Creating_Configure_Audit_Type_Test"})
	public void Adding_10_Survey_Questions_Test() throws InterruptedException
	{
		
		Thread.sleep(3000);
		
		SurveyQuestionsPageTest SQ = new SurveyQuestionsPageTest(driver);

		chiledTest = parentTest.createNode("Adding 10 Survey Questions Test");

		System.out.println("Adding 10 Survey Questions Test");

		//Clicking on the Select Audit Type
		SQ.ClickSelectAuditType();

		//Passing the Values to Select Audit Type 
		String SA = Lib.getCellValue(XLPATH, "Survey Questions", 3, 0);
		SQ.SetSelectAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched text
		SQ.ClickMatch();

		//Clicking on the Add a Questions
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Questions Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS = Lib.getCellValue(XLPATH, "Auditor Survey", 9, 0);
		SQ.SetQuestion(SS, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("********************1st Question is Added***********************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS1 = Lib.getCellValue(XLPATH, "Auditor Survey", 10, 0);
		SQ.SetQuestion(SS1, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("*******************2nd Question is Added***********************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS2 = Lib.getCellValue(XLPATH, "Auditor Survey", 11, 0);
		SQ.SetQuestion(SS2, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("*************************3rd Question is Added*******************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS3 = Lib.getCellValue(XLPATH, "Auditor Survey", 12, 0);
		SQ.SetQuestion(SS3, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("*******************4th Question is Added*******************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS4 = Lib.getCellValue(XLPATH, "Auditor Survey", 13, 0);
		SQ.SetQuestion(SS4, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("*******************5th Question is Added***************************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS5 = Lib.getCellValue(XLPATH, "Auditor Survey", 14, 0);
		SQ.SetQuestion(SS5, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("*****************6th Question is Added******************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS6 = Lib.getCellValue(XLPATH, "Auditor Survey", 15, 0);
		SQ.SetQuestion(SS6, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("******************7th Question is Added**********************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS7 = Lib.getCellValue(XLPATH, "Auditor Survey", 16, 0);
		SQ.SetQuestion(SS7, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("***********************8th Question is Added***********************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS8 = Lib.getCellValue(XLPATH, "Auditor Survey", 17, 0);
		SQ.SetQuestion(SS8, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("**************9th Question is Added********************");

		//Clicking on the Add a Question Button
		SQ.ClickAddQuestionBTN(driver);
		chiledTest.log(Status.INFO, "Add a Question Button is Clicked");

		//Passing the New Question to Question Text Filed
		String SS9 = Lib.getCellValue(XLPATH, "Auditor Survey", 18, 0);
		SQ.SetQuestion(SS9, driver);
		chiledTest.log(Status.INFO, "Question is Entered");

		//Clicking on the Submit Button
		SQ.ClickSubmitBTN1(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Custom Question saved successfully Success Message is Displayed
		SQ.VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Custom Question saved successfully Success Message is Displayed");

		System.out.println("********************10th Question is Added***********************");

	}

	//Testing the Functionality of the After Adding 10 Questions Add New Question Button Should Hide Test
	@Test(priority=5, dependsOnMethods= {"Adding_10_Survey_Questions_Test"})
	public void After_Adding_10_Questions_Add_New_Question_Button_Should_Hide_Test() throws InterruptedException
	{
		chiledTest = parentTest.createNode("After Adding 10 Questions Add New Question Button Should Hide Test");

		System.out.println("After Adding 10 Questions Add New Question Button Should Hide Test");

		List<WebElement> AddQuestionBTN1 = driver.findElements(By.xpath("//a[@class='nested_survey_question']"));
		Assert.assertTrue(AddQuestionBTN1.size()>0, "Add New Question Button is Displayed");
		System.out.println("Pass : Add a New Question Button is  Not Displayed");
		chiledTest.log(Status.INFO, "Add a New Question Button is  Not Displayed");

		System.out.println("*********************************************************************");

	}

	//Testing the Functionality of the Removing All Added Survey Questions Test
	@Test(priority=6, dependsOnMethods= {"After_Adding_10_Questions_Add_New_Question_Button_Should_Hide_Test"})
	public void Selecting_More_Than_10_Questions_Test() throws InterruptedException
	{

		SurveyQuestionsPageTest SQ = new SurveyQuestionsPageTest(driver);

		chiledTest = parentTest.createNode("Selecting More Than 10 Questions Test");

		System.out.println("Selecting More Than 10 Questions Test");

		//Clicking on the Select Audit Type
		SQ.ClickSelectAuditType();

		//Passing the Values to Select Audit Type 
		String SA = Lib.getCellValue(XLPATH, "Survey Questions", 3, 0);
		SQ.SetSelectAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched text
		SQ.ClickMatch();

		//Clicking on the Check Box's
		List<WebElement> checkBox = driver.findElements(By.xpath("//table[@id='question_table']/tbody/tr/td[1]/input[@type='checkbox']"));
		int count = checkBox.size();
		System.out.println("Total Number of CheckBox are : " + count);
		for(int i=0; i<checkBox.size(); i++)
		{
			WebElement AllCB = checkBox.get(i);
			AllCB.click();
		}

		System.out.println("All Check Box are Clicked");
		chiledTest.log(Status.INFO, "All Check Box are Clicked");

		boolean C1 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[1]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("1st Question CheckBox is Enabled : " + C1);
		chiledTest.log(Status.INFO, "Question No 1 is Enabled");

		boolean C2 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[2]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("2nd Question CheckBox is Enabled : " + C2);

		boolean C3 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[3]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("3rd Question CheckBox is Enabled : " + C3);

		boolean C4 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[4]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("4th Question CheckBox is Enabled : " + C4);

		boolean C5 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[5]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("5th Question CheckBox is Enabled : " + C5);

		boolean C6 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[6]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("6th Question CheckBox is Enabled : " + C6);

		boolean C7 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[7]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("7th Question CheckBox is Enabled : " + C7);

		boolean C8 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[8]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("8th Question CheckBox is Enabled : " + C8);

		boolean C9 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[9]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("9th Question CheckBox is Enabled : " + C9);

		boolean C10 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[10]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("10th Question CheckBox is Enabled : " + C10);

		boolean C11 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[11]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("11th Question CheckBox is Enabled : " + C11);

		boolean C12 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[12]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("12th Question CheckBox is Enabled : " + C12);

		boolean C13 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[13]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("13th Question CheckBox is Enabled : " + C13);

		boolean C14 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[14]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("14th Question CheckBox is Enabled : " + C14);

		boolean C15 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[15]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("15th Question CheckBox is Enabled : " + C15);

		boolean C16 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[16]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("16th Question CheckBox is Enabled : " + C16);

		boolean C17 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[17]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("17th Question CheckBox is Enabled : " + C17);

		boolean C18 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[18]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("18th Question CheckBox is Enabled : " + C18);

		boolean C19 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[19]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("19th Question CheckBox is Enabled : " + C19);

		boolean C20 = driver.findElement(By.xpath("//table[@id='question_table']/tbody/tr[20]/td[1]/input[@type='checkbox']")).isEnabled();
		System.out.println("20th Question CheckBox is Enabled : " + C20);
		chiledTest.log(Status.INFO, "Question No 20 is Disabled");

		System.out.println("*****************************************************************");


	}

	//Testing the Functionality of the Removing All Added Survey Questions Test
	@Test(priority=7, dependsOnMethods= {"Selecting_More_Than_10_Questions_Test"})
	public void Delete_All_Added_Survey_Questions_Test() throws InterruptedException
	{
		SurveyQuestionsPageTest SQ = new SurveyQuestionsPageTest(driver);

		chiledTest = parentTest.createNode("Delete All Added Survey Questions Test");

		System.out.println("Delete All added Survey Questions Test");

		//Checking the Count of Delete Buttons
		List<WebElement> DeleteBTN = driver.findElements(By.xpath("//table[@id='question_table']/tbody/tr/td[3]/a[@class='btn btn-danger m-l-10']"));
		int count = DeleteBTN.size();
		System.out.println("Total number of Delete Buttons are : " + count);
		Assert.assertTrue(DeleteBTN.size()==10, "Delete button Count is Wrong");
		for(int i=0; i<DeleteBTN.size(); i++)
		{
			try
			{
				WebElement Delete = DeleteBTN.get(i);
				Delete.click();
				System.out.println("Delete Button is Clicked");

				//Clicking on the Ok Button
				driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block m-t-5 confirm'][text()='OK']")).click();

				//Checking Custom Question removed successfully Message is Displayed
				SQ.VeriftyCustomQuestionRemovedSuccessfullyMsgIsDisplayed(driver);
				chiledTest.log(Status.INFO, "Custom Question removed successfully Message is Displayed");

			}catch (StaleElementReferenceException e) {

			}
		}

		//Checking Add a new Button is Displayed or Not
		List<WebElement> AddQuestionBTN1 = driver.findElements(By.xpath("//a[@class='nested_survey_question']"));
		Assert.assertTrue(AddQuestionBTN1.size()>0, "Add New Question Button is Displayed");
		System.out.println("Add a New Question Button is Displayed");
		chiledTest.log(Status.INFO, "Add a New Question Button is Displayed");

		System.out.println("************************************************************************");

	}

}


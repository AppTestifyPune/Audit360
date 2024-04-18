package scripts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.ProcessesAndPoliciesPageTest;

public class ProcessesAndPoliciesPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the POLICY DOCUMENT Page
	@Test(priority=1)
	public void Policy_Document_List_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		parentTest = extent.createTest("Processes And Policies Functionality Test", "Testing the Functionality of the Policy Document List Test, Policy Document Upload Test");

		chiledTest = parentTest.createNode("Policy Document List Test");

		System.out.println("Policy Document List Test");

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

		//Clikcing on the scroll bar
		PP.ClickScrollBar(driver);

		//Clicking on the Processes And Policies from side menu
		PP.ClickProcessAndPolicies(driver);
		chiledTest.log(Status.INFO, "Processes And Policies is Clicked");

		//Verify Policy Document Header is Displayed
		PP.VerifyPolicydocumentPageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "User is Navigated to Policy Document Page");


		System.out.println("****************************************************************************");
	}

	//Testing the Functionality of the Policy Document Upload Test
	@Test(priority=2)
	public void Upload_Policy_Document_Test() throws InterruptedException
	{
		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		chiledTest = parentTest.createNode("Upload Policy Document Test");

		System.out.println("Upload Policy Document Test");

		//Passing the values to Document Name
		String DN = Lib.getCellValue(XLPATH, "Processes And Policies", 3, 0);
		PP.SetDocumentName(DN);
		chiledTest.log(Status.INFO, "Document Name is Entered ");

		//Passing the values to Description
		String SD = Lib.getCellValue(XLPATH, "Processes And Policies", 7, 0);
		PP.SetDescription(SD);
		chiledTest.log(Status.INFO, "Description is Entered ");

		//Passing the values to Version
		String SV = Lib.getCellValue(XLPATH, "Processes And Policies", 10, 0);
		PP.SetVersion(SV);

		//Passing the values to Approved By
		String AB = Lib.getCellValue(XLPATH, "Processes And Policies", 16, 0);
		PP.SetApprovedBy(AB);
		chiledTest.log(Status.INFO, "Approved By is Entered ");

		//Passing the values to Document Circulation
		String DC = Lib.getCellValue(XLPATH, "Processes And Policies", 19, 0);
		PP.SetDocumentCirculation(DC);
		chiledTest.log(Status.INFO, "Document Circulation is Entered ");

		//Passing the Values to From Date
		String FD = Lib.getCellValue(XLPATH, "Processes And Policies", 22, 0);
		PP.ClickFromDate(FD);
		chiledTest.log(Status.INFO, "From Date is Entered ");

		//Passing the Values to To Date
		String TD = Lib.getCellValue(XLPATH, "Processes And Policies", 25, 0);
		PP.ClickToDate(TD);
		chiledTest.log(Status.INFO, "To Date is Entered ");		

		//Uploading the PDF files
		PP.SetPDFDocument();

		//Clicking on the Save Button
		PP.ClickSaveButton();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Checking the Document Saved Successfully Message is Displayed
		PP.VerifyDocumentSavedSuccessfullySucessMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Document Saved Successfully Message is Displayed");


		System.out.println("****************************************************************************");
	}

	//Testing the Functionality of the Policy Document Upload Test
	@Test(priority=3, dependsOnMethods= {"Upload_Policy_Document_Test"})
	public void Search_Uploaded_Policy_Document_Test() throws InterruptedException
	{
		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		chiledTest = parentTest.createNode("Search Uploaded Policy Document Test");

		System.out.println("Search Uploaded Policy Document Test");

		String SB = Lib.getCellValue(XLPATH, "Processes And Policies", 3, 0);
		PP.SetSearchBTN(SB);
		chiledTest.log(Status.INFO, "Document is serached");

		//Checking the Document is uploaded under policy document
		PP.VerifyNumberOfVersion1(driver);
		chiledTest.log(Status.INFO, "Searched Document is Displayed");

		System.out.println("****************************************************************************");

	}

	//Testing the Functionality of the Policy Document Upload Test
	@Test(priority=4,dependsOnMethods= {"Upload_Policy_Document_Test"})
	public void Upload_Same_Policy_Document_With_Same_Version_Test() throws InterruptedException
	{
		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		chiledTest = parentTest.createNode("Upload Same Policy Document Test");

		System.out.println("Upload Same Policy Document Test");

		//Passing the values to Document Name
		String DN = Lib.getCellValue(XLPATH, "Processes And Policies", 3, 0);
		PP.SetDocumentName(DN);
		chiledTest.log(Status.INFO, "Document Name is Entered ");

		//Passing the values to Description
		String SD = Lib.getCellValue(XLPATH, "Processes And Policies", 7, 0);
		PP.SetDescription(SD);
		chiledTest.log(Status.INFO, "Description is Entered ");

		//Passing the values to Version
		String SV = Lib.getCellValue(XLPATH, "Processes And Policies", 10, 0);
		PP.SetVersion(SV);

		//Passing the values to Approved By
		String AB = Lib.getCellValue(XLPATH, "Processes And Policies", 16, 0);
		PP.SetApprovedBy(AB);
		chiledTest.log(Status.INFO, "Approved By is Entered ");

		//Passing the values to Document Circulation
		String DC = Lib.getCellValue(XLPATH, "Processes And Policies", 19, 0);
		PP.SetDocumentCirculation(DC);
		chiledTest.log(Status.INFO, "Document Circulation is Entered ");

		//Passing the Values to From Date
		String FD = Lib.getCellValue(XLPATH, "Processes And Policies", 22, 0);
		PP.ClickFromDate(FD);
		chiledTest.log(Status.INFO, "From Date is Entered ");

		//Passing the Values to To Date
		String TD = Lib.getCellValue(XLPATH, "Processes And Policies", 25, 0);
		PP.ClickToDate(TD);
		chiledTest.log(Status.INFO, "To Date is Entered ");

		//Uploading the files
		PP.SetPDFDocument();

		//Clicking on the Save Button
		PP.ClickSaveButton();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//verifying Version no already exist for the same document
		PP.VerfiyVersionNoAlreadyExistForTheSameDocument();

		System.out.println("****************************************************************************");
	}

	//Testing the Functionality of the Upload different Types of Documents Test
	@Test(priority=5)
	public void Upload_Different_Types_Of_Document_Test() throws Exception
	{
		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		chiledTest = parentTest.createNode("Upload Different Types of Document Test");

		System.out.println("Upload Different Types of Document Test");

		PP.ClickPolicyDocumentHeader();

		//Passing the values to Document Name
		String DN = Lib.getCellValue(XLPATH, "Processes And Policies", 3, 0);
		PP.SetDocumentName(DN);
		chiledTest.log(Status.INFO, "Document Name is Entered ");

		//Passing the values to Description
		String SD = Lib.getCellValue(XLPATH, "Processes And Policies", 7, 0);
		PP.SetDescription(SD);
		chiledTest.log(Status.INFO, "Description is Entered ");

		//Passing the values to Version
		String SV = Lib.getCellValue(XLPATH, "Processes And Policies", 10, 0);
		PP.SetVersion(SV);

		
		//Passing the values to Approved By
		String AB = Lib.getCellValue(XLPATH, "Processes And Policies", 17, 0);
		PP.SetApprovedBy(AB);
		chiledTest.log(Status.INFO, "Approved By is Entered ");

		//Passing the values to Document Circulation
		String DC = Lib.getCellValue(XLPATH, "Processes And Policies", 19, 0);
		PP.SetDocumentCirculation(DC);
		chiledTest.log(Status.INFO, "Document Circulation is Entered ");

		//Passing the Values to From Date
		String FD = Lib.getCellValue(XLPATH, "Processes And Policies", 22, 0);
		PP.ClickFromDate(FD);
		chiledTest.log(Status.INFO, "From Date is Entered ");

		//Passing the Values to To Date
		String TD = Lib.getCellValue(XLPATH, "Processes And Policies", 25, 0);
		PP.ClickToDate(TD);
		chiledTest.log(Status.INFO, "To Date is Entered ");

		PP.UploadJPGDocument();
		chiledTest.log(Status.INFO, ".JPG File is Uploaded");

		PP.ClickSaveButton();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		PP.VerifyOnlyPDFFilesErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Only .pdf files are allowed for upload. Error  Message is Displayed");

		PP.UploadXlxDocument();
		chiledTest.log(Status.INFO, ".Xlsx File is Uploaded");

		PP.ClickSaveButton();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		PP.VerifyOnlyPDFFilesErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Only .pdf files are allowed for upload. Error  Message is Displayed");

		PP.UploadTXTDocument();
		chiledTest.log(Status.INFO, ".TXT File is Uploaded");

		PP.ClickSaveButton();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		PP.VerifyOnlyPDFFilesErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Only .pdf files are allowed for upload. Error  Message is Displayed");

		System.out.println("****************************************************************************");
	}

	//Testing the Functionality of the Upload document Name  With LowerCase Test
	@Test(priority=6)
	public void Upload_Document_Name_With_Lowercase_Test() throws InterruptedException
	{
		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		chiledTest = parentTest.createNode("Upload document Name  With LowerCase Test");

		System.out.println("Upload document Name  With LowerCase Test");

		PP.ClickPolicyDocumentHeader();

		//Passing the values to Document Name
		String DN = Lib.getCellValue(XLPATH, "Processes And Policies", 4, 0);
		PP.SetDocumentName(DN);
		chiledTest.log(Status.INFO, "Document Name is Entered  with Lowercase");

		//Passing the values to Description
		String SD = Lib.getCellValue(XLPATH, "Processes And Policies", 7, 0);
		PP.SetDescription(SD);
		chiledTest.log(Status.INFO, "Description is Entered ");

		//Passing the values to Version
		String SV = Lib.getCellValue(XLPATH, "Processes And Policies", 11, 0);
		PP.SetVersion(SV);
		chiledTest.log(Status.INFO, "Version is Entered ");

		//Passing the values to Approved By
		String AB = Lib.getCellValue(XLPATH, "Processes And Policies", 16, 0);
		PP.SetApprovedBy(AB);
		chiledTest.log(Status.INFO, "Approved By is Entered ");

		//Passing the values to Document Circulation
		String DC = Lib.getCellValue(XLPATH, "Processes And Policies", 19, 0);
		PP.SetDocumentCirculation(DC);
		chiledTest.log(Status.INFO, "Document Circulation is Entered ");

		//Passing the Values to From Date
		String FD = Lib.getCellValue(XLPATH, "Processes And Policies", 22, 0);
		PP.ClickFromDate(FD);
		chiledTest.log(Status.INFO, "From Date is Entered ");

		//Passing the Values to To Date
		String TD = Lib.getCellValue(XLPATH, "Processes And Policies", 25, 0);
		PP.ClickToDate(TD);
		chiledTest.log(Status.INFO, "To Date is Entered ");

		//Uploading the PDF files
		PP.SetPDFDocument();
		chiledTest.log(Status.INFO, ".PDF File is Uploaded");

		//Clicking on the Save Button
		PP.ClickSaveButton();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//Verifying Only capital letters are allowed for document name Error  Message is Displayed
		PP.VerifyOnlyCapitalLattersAreAllowedForDocumentNameErrorMSGIsDisplayed(driver);

		System.out.println("*************************************************************");

	}


	//Testing the Functionality of the Upload document More Than 1 mb
	@Test(priority=7)
	public void Upload_Document_With_MoreThan_25_MB_File_Test() throws InterruptedException
	{
		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		chiledTest = parentTest.createNode("Upload document With More Than 25 MB File Test");

		System.out.println("Upload document With More Than 25 MB File Test");

		PP.ClickPolicyDocumentHeader();

		//Passing the values to Document Name
		String DN = Lib.getCellValue(XLPATH, "Processes And Policies", 3, 0);
		PP.SetDocumentName(DN);
		chiledTest.log(Status.INFO, "Document Name is Entered ");

		//Passing the values to Description
		String SD = Lib.getCellValue(XLPATH, "Processes And Policies", 7, 0);
		PP.SetDescription(SD);
		chiledTest.log(Status.INFO, "Description is Entered ");

		//Passing the values to Version
		String SV = Lib.getCellValue(XLPATH, "Processes And Policies", 12, 0);
		PP.SetVersion(SV);
		chiledTest.log(Status.INFO, "Already Exist Version is Entered ");

		//Passing the values to Approved By
		String AB = Lib.getCellValue(XLPATH, "Processes And Policies", 16, 0);
		PP.SetApprovedBy(AB);
		chiledTest.log(Status.INFO, "Approved By is Entered ");

		//Passing the values to Document Circulation
		String DC = Lib.getCellValue(XLPATH, "Processes And Policies", 19, 0);
		PP.SetDocumentCirculation(DC);
		chiledTest.log(Status.INFO, "Document Circulation is Entered ");

		//Passing the Values to From Date
		String FD = Lib.getCellValue(XLPATH, "Processes And Policies", 22, 0);
		PP.ClickFromDate(FD);
		chiledTest.log(Status.INFO, "From Date is Entered ");

		//Passing the Values to To Date
		String TD = Lib.getCellValue(XLPATH, "Processes And Policies", 25, 0);
		PP.ClickToDate(TD);
		chiledTest.log(Status.INFO, "To Date is Entered ");

		//Uploading the More Than 1 Mb PDF files
		PP.SetUploadMoreThan25MBDocument();
		chiledTest.log(Status.INFO, "5 MB PDF File is Uploaded");

		//Clicking on the Save Button
		PP.ClickSaveButton();
		chiledTest.log(Status.INFO, "Save Button is Clicked");

		//verifying You cannot upload a file greater than 1MB. error Message is Displayed
		PP.VerifyTheFileSizeShouldBeLessThan25MBErrorMSGIsDisplayed(driver);

		System.out.println("*************************************************************");

	}

	//Testing the Functionality of the Mandatory Fields Test
	@Test(priority=8)
	public void Upload_Document_MandatoryFields_Test() throws InterruptedException
	{
		ProcessesAndPoliciesPageTest PP = new ProcessesAndPoliciesPageTest(driver);

		chiledTest = parentTest.createNode("Upload document Mandatory Fields Test");

		System.out.println("Upload document Mandatory Fields Test");

		PP.ClickPolicyDocumentHeader();

		//Checking Document Name
		WebElement DocumentName = driver.findElement(By.xpath("//input[@id='policy_document_name'][@required='required']"));
		Assert.assertTrue(DocumentName.isDisplayed());
		System.out.println("Document Name is Required Field");
		chiledTest.log(Status.INFO, "Document Name is Required Field");

		//Checking Version Number
		WebElement Version = driver.findElement(By.xpath("//input[@name='policy_document[version_no]'][@required='required']"));
		Assert.assertTrue(Version.isDisplayed());
		System.out.println("Version Number is Required Field");
		chiledTest.log(Status.INFO, "Version Number is Required Field");

		//Checking Description
		WebElement Description = driver.findElement(By.xpath("//input[@id='policy_document_description'][@required='required']"));
		Assert.assertTrue(Description.isDisplayed());
		System.out.println("Description is Required Field");
		chiledTest.log(Status.INFO, "Description is Required Field");

		//Checking From Date
		WebElement FromDate = driver.findElement(By.xpath("//input[@id='policy_document_active_from'][@required='required']"));
		Assert.assertTrue(FromDate.isDisplayed());
		System.out.println("From Date is Required Field");
		chiledTest.log(Status.INFO, "Document Circulation is Required Field");

		//Checking TO Date
		WebElement ToDate = driver.findElement(By.xpath("//input[@id='policy_document_active_to'][@required='required']"));
		Assert.assertTrue(ToDate.isDisplayed());
		System.out.println("To Date is Required Field");
		chiledTest.log(Status.INFO, "To Date is Required Field");

		//Checking Choose File
		WebElement ChooseFile = driver.findElement(By.xpath("//input[@name='policy_document[document]'][@required='required']"));
		Assert.assertTrue(ChooseFile.isDisplayed());
		System.out.println("Upload Document is Required Field");
		chiledTest.log(Status.INFO, "Upload Document is Required Field");

		try// #SM
		{
	//	Assert.fail("*****Dependency Ticket CTRL-5982*****");
		}catch(Exception e)
		{
		 // This field is required?
		}
		
		//Checking Document Circulation
		WebElement DC = driver.findElement(By.xpath("//input[@id='policy_document_circulation'][@required='required']"));
		Assert.assertTrue(DC.isDisplayed());
		System.out.println("Document Circulation is Required Field");
		chiledTest.log(Status.INFO, "Document Circulation is Required Field");

		System.out.println("*************************************************************");

	}
}

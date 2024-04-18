package scripts;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.LoginPageTest;
import pom.UploadAnnexureDocumentPageTest;

public class UploadAnnexureDocumentPageFunctionalityTest extends BaseTest {

	//Testing the Functionality of the Upload Document page
	@Test(priority=1)
	public void Uploading_Annexure_Documnet_Page_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		parentTest = extent.createTest("Upload Annexure Documents Test", "Testing the Upload document, Search Documnets etc..");

		chiledTest = parentTest.createNode("Uploading Annexure Documenet Page Test");

		System.out.println("Uploading Annexure Documenet Page Test");

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

		UA.ClickScrollBar(driver);

		UA.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annecxure is Clicked");

		UA.ClickAnnexureDocuments(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents is Clicked");

		System.out.println("******************************************************");

	}

	//Testing the Functionality of the Uploading Annexure Document for Audit Type
    @Test(priority=2, enabled=false)
	public void Uploading_Annexure_Documenet_Test() throws InterruptedException
	{
		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Uploading Annexure Document Test");

		System.out.println("Uploading Annexure Documenet Test");
		
		System.out.println("*********Uploading the Annexure Document for Static Annexure*******************");

		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Static Annexure*******************");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Static Annexure SAT')]")).click();
	
		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		UA.VerifyStaticAnnexureTypeIsDisplayed();

		//Uploading Documnets
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
		String SA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		UA.SetAuditType(SA1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Dynamic Annexure SAT')]")).click();

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

		System.out.println("*************************************************************************");



	}

	//Testing the Functionality of the Uploading Annexure Documnet for Audit Type
    @Test(priority=3)
	public void Uploading_Annexure_Documenet_For_Another_Audit_Type_Test() throws InterruptedException
	{

		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Uploading Annexure Document For Another Audit Type Test");

		System.out.println("Uploading Annexure Documenet Another Audit Type Test");

		System.out.println("*********Uploading the Annexure Document for Static Annexure*******************");

		chiledTest.log(Status.INFO, "*********Uploading the Annexure Document for Static Annexure*******************");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Static Annexure SAT')]")).click();
		
		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Checking the Annexure Type Text
		UA.VerifyStaticAnnexureTypeIsDisplayed();

		//Uploading Documnets
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
		String SA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		UA.SetAuditType(SA1);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='sub_audit_types']/option[contains(text(),'Dynamic Annexure SAT')]")).click();	
		
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

		//Uploading Documnets
		UA.UploadDocument();
		chiledTest.log(Status.INFO, "Document is Uploaded");

		//Clicking on the submit Button
		UA.ClickSubmitBTN(driver);
		chiledTest.log(Status.INFO, "Submit Button is Clicked");

		//Verifying Document Uploaded Successfully Message is Displayed 
		UA.VerifyDocumentUploadedSuccessfully(driver);
		chiledTest.log(Status.INFO, "Document Uploaded Successfully Message is Displayed");

		System.out.println("*************************************************************************");

	}

	//Testing the Functionality of the Validating The Uploaded Documnets Test
	@Test(priority=4)
	public void Validating_The_Uploaded_Documents_Test() throws InterruptedException
	{
		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Validating The Uploaded Documnets Test");

		System.out.println("Validating The Uploaded Documnets Test");

		//Passing the Values to Sub Audit Type
		String SA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 7, 0);
		UA.SetSubAuditType(SA1, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the No Of Files Uploaded 
		UA.ClickNOofFiles(driver);
		chiledTest.log(Status.INFO, "No Of Files Uploaded Link");

		//Verify File Uploaded Page is Displayed or Not
		UA.VerifyFilesUploadedPageIssDisplayed(driver);
		chiledTest.log(Status.INFO, "No Error Files and Proccess Status is Displayed");

		driver.navigate().refresh();

		//Passing the Values to Sub Audit Type
		String SA3 = Lib.getCellValue(XLPATH, "Configure Audit Type", 9, 0);
		UA.SetSubAuditType(SA3, driver);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the No Of Files Uploaded 
		UA.ClickNOofFiles(driver);
		chiledTest.log(Status.INFO, "No Of Files Uploaded Link");

		//Verify File Uploaded Page is Displayed or Not
		UA.VerifyFilesUploadedPageIssDisplayed(driver);
		chiledTest.log(Status.INFO, "No Error Files and Proccess Status is Displayed");

		System.out.println("*****************************************");

	}

	//Testing the Functionality of the Uploading Dynamic Annexure Documnet Test
	@Test(priority=5, enabled=false)
	public void Search_Functionality_Test() throws InterruptedException
	{
		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Search Functionality Test");

		System.out.println("Search Functionality Test");

		//Passing the Value to Sub Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 3, 0);
		UA.SetSubAuditType(SA, driver);
		chiledTest.log(Status.INFO, "Entered the Parent Audit Type under Sub Audit Type");

		//Verifying No Match Found Error Message is Displayed
		UA.VerifyNoMatchFoundErrorMessageIsDisplayed(driver);
		chiledTest.log(Status.INFO, "No Match Found Error Message is Displayed");

		UA.ClearSubAuditType();

		//Passing the Value to Sub Audit Type
		String SA1 = Lib.getCellValue(XLPATH, "Configure Audit Type", 6, 0);
		UA.SetSubAuditType(SA1, driver);
		chiledTest.log(Status.INFO, "Sub Audit Type is Entered");

		UA.ClickMatched();

		//Passing the Value to Sub Audit Type
		String SA2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 8, 0);
		UA.SetSubAuditType(SA2, driver);
		chiledTest.log(Status.INFO, "Sub Audit Type is Entered");

		UA.ClickMatched();

		//Checking the Table
		String AuditType1 = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[1]")).getText();
		//String SubAuditType1 = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[2]")).getText();
		String FilesUploaded1 = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[3]")).getText();
		String Expected_text = FilesUploaded1;
		String Actual_text = "1";
		Assert.assertEquals(Expected_text, Actual_text);

		String AuditType2 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);

		Assert.assertEquals(AuditType1, AuditType2);

		Thread.sleep(2000);


		String AuditType3 = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[2]/td[1]")).getText();
		//String SubAuditType3 = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[2]/td[2]")).getText();
		String FilesUploaded3 = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[2]/td[3]")).getText();
		String Expected_text1 = FilesUploaded3;
		String Actual_text1 = "1";
		Assert.assertEquals(Expected_text1, Actual_text1);

		String AuditType4 = Lib.getCellValue(XLPATH, "Configure Audit Type", 10, 0);
		//String SubAuditType4 = Lib.getCellValue(XLPATH, "Configure Audit Type", 5, 0);

		Assert.assertEquals(AuditType3, AuditType4);
		//Assert.assertEquals(SubAuditType3, SubAuditType4);
		System.out.println("Pass : Searched Audit Types are Displayed");
		chiledTest.log(Status.INFO, "Searched Audit Types are Displayed");


		System.out.println("*******************************************************");

	}


	//Testing the Functionality of the Uploading Dynamic Annexure Documnet Test
	@Test(priority=6, enabled=false)
	public void Document_Already_Present_Test() throws InterruptedException
	{
		UploadAnnexureDocumentPageTest UA = new UploadAnnexureDocumentPageTest(driver);

		chiledTest = parentTest.createNode("Document Already Present Test");

		System.out.println("Document Already Present Test");

		//Clicking on the Upload Annexure Button
		UA.ClickUploadAnnexureBTN(driver);
		chiledTest.log(Status.INFO, "Annecxure Documents Button is Clicked");

		//Clicking on the Audit Type
		UA.ClickAuditType();

		//Passing the Values to Audit Type
		String SA = Lib.getCellValue(XLPATH, "Configure Audit Type", 11, 0);
		UA.SetAuditType(SA);
		chiledTest.log(Status.INFO, "Audit Type is Selected");

		//Clicking on the Matched
		UA.ClickMatched();

		//Clicking on the Sub Audit Type
		UA.ClickSAT(driver);

		Thread.sleep(1000);
		//Selecting 1st option under Sub Audit type
		driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div")).click();

		//Clicking on the Annexure
		UA.ClickAnnexure1(driver);

		Thread.sleep(1000);
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

		//Verifying Document already present Error Message is Displayed
		UA.VerifyDocumentAlreadyPresentErrorMSGIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Document already present Error Message is Displayed");

		System.out.println("**************************************************");

	}

}

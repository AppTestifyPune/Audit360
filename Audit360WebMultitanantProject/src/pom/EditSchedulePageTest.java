package pom;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class EditSchedulePageTest extends BaseTest {

	//Clicking on the Attach Audit Reference button
	@FindBy(xpath="//a[text()='Attach Audit Reference']")
	private WebElement AttachAuditReferenceBTN;

	//Clicking on the View Audit Reference button
	@FindBy(xpath="//a[text()='View Audit Reference']")
	private WebElement ViewAuditReferenceBTN;

	//clicking on the General Radio Button
	@FindBy(xpath="//label[contains(text(),'Genral')]")
	private WebElement GeneralRadioBTN;

	//clicking on the Confidential Radio Button
	@FindBy(xpath="//label[contains(text(),'Confidential')]")
	private WebElement ConfidentialRadioBTN;

	//passing the value to Choose File
	@FindBy(xpath="//input[@id='uploaded_file_name' and @required='required']")
	private WebElement ChooseFileBTN;

	//clicking on the Submit Button
	@FindBy(xpath="//input[@class='btn btn-primary reference_upload_doc']")
	private WebElement SubmitBTN;

	//clicking on the Close Button
	@FindBy(xpath="//div[@id='add-document']//button[@class='close']")
	private WebElement CloseBTN;

	//Clicking on the Update Button
	@FindBy(xpath="//input[@value='Update']")
	private WebElement UpdateBTN;

	public EditSchedulePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickUpdateBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UpdateBTN);
		System.out.println("Update Button is Clicked");
		chiledTest.log(Status.INFO, "Update Button is Clicked");
	}

	public void ClickAttachAuditReferenceButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(AttachAuditReferenceBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AttachAuditReferenceBTN);
		System.out.println("Attach Audit Reference Button is Clicked");
		chiledTest.log(Status.INFO, "Attach Audit Reference Button is Clicked");
	}

	public void ClickViewAuditReferenceButton(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ViewAuditReferenceBTN);
		System.out.println("View Audit Reference Button is Clicked");
		chiledTest.log(Status.INFO, "View Audit Reference Button is Clicked");
	}

	public void ClickCloseBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);
		System.out.println("Close Button is Clicked");
		chiledTest.log(Status.INFO, "Close Button is Clicked");
	}

	public void ClickGeneralRadioButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(GeneralRadioBTN)).click();
		System.out.println("General Radio Button is Clicked");
		chiledTest.log(Status.INFO, "General Radio Button is Clicked");
	}

	public void ClickConfidentialRadioBTNRadioButton() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ConfidentialRadioBTN)).click();
		System.out.println("Confidential Radio Button is Clicked");
		chiledTest.log(Status.INFO, "Confidential Radio Button is Clicked");
	}

	public void ClickSubmitButton() throws InterruptedException
	{
		SubmitBTN.click();
		System.out.println("Submit Button is Clicked");
		chiledTest.log(Status.INFO, "Submit Button is Clicked");
	}

	public void VerifyAddAuditReferencePopUpIsDisplayed()
	{
		//Checking by Default General Radio button is enabled 
		WebElement GeneralRadioBTNIsSelected = driver.findElement(By.xpath("//input[@id='yes' and @checked='checked']"));
		Assert.assertTrue(GeneralRadioBTNIsSelected.isEnabled(), "By Defult General Radio button is not selected");	
		System.out.println("By Defult Genereal Radio button is Selected");
		chiledTest.log(Status.INFO, "By Defult Genereal Radio button is Selected");

		//checking the Notes is displayed
		WebElement Notes = driver.findElement(By.xpath("//strong[contains(text(),'Note: Audio and video files are not allowed')]"));
		Assert.assertTrue(Notes.isDisplayed(), "Note: Audio and video files are not allowed. is Not Displayed");	
		System.out.println("Note: Audio and video files are not allowed is Displayed");
		chiledTest.log(Status.INFO, "Note: Audio and video files are not allowed is Displayed");

		//checking the Max upload limit: 25MB is displayed
		WebElement MaxUpload = driver.findElement(By.xpath("//li[contains(text(),'Max upload limit: 25MB')]"));
		Assert.assertTrue(MaxUpload.isDisplayed(), "Max upload limit: 25MB is Not Displayed");	
		System.out.println("Max upload limit: 25MB is Displayed");
		chiledTest.log(Status.INFO, "Max upload limit: 25MB is Displayed");

	}

	public void VerifyDocumentUploadedSuccessfullyPopUpIsDisplayed() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert Alert = driver.switchTo().alert();
		String Actual_Alert = Alert.getText();
		String Expected_Alert = "Document Uploaded successfully";
		Assert.assertEquals(Actual_Alert, Expected_Alert, "Document Uploaded successfully Pop Up Is not displayed");
		System.out.println("Document Uploaded successfully Pop Up is Displayed");
		chiledTest.log(Status.INFO, "Document Uploaded successfully Pop Up is Displayed");

		Alert.accept();

	}

	public void UploadingMP4FileType() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\sample-mp4-file.mp4");
		System.out.println("MP4 File Type is Uploaded");
		chiledTest.log(Status.INFO, "MP4 File Type is Uploaded");
	}

	public void UploadingMP3FileType() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\beeptest.mp3");
		System.out.println("MP3 File Type is Uploaded");
		chiledTest.log(Status.INFO, "MP3 File Type is Uploaded");
	}

	public void UploadingJPGDocuments() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\Sample-jpg-image-1mb.jpg");
		System.out.println("JPG File Type is Uploaded");
		chiledTest.log(Status.INFO, "JPG File Type is Uploaded");
	}

	public void UploadingJPGDocuments1() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\download.jpg");
		System.out.println("JPG File Type is Uploaded");
		chiledTest.log(Status.INFO, "JPG File Type is Uploaded");
	}

	public void UploadingJPGDocuments2() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
		System.out.println("JPG File Type is Uploaded");
		chiledTest.log(Status.INFO, "JPG File Type is Uploaded");
	}

	public void UploadingCSVDocuments() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\Annexuretemplate2.csv");
		System.out.println("CSV File Type is Uploaded");
		chiledTest.log(Status.INFO, "CSV File Type is Uploaded");
	}

	public void UploadingCSVDocuments1() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\Annexure_Template_For_Scoring_Logic.csv");
		System.out.println("CSV File Type is Uploaded");
		chiledTest.log(Status.INFO, "CSV File Type is Uploaded");
	}

	public void UploadMoroThan25MBFileType() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\30_MB_PDF_document.pdf");
		System.out.println("More Than 25 MB File Type is Uploaded");
		chiledTest.log(Status.INFO, "More Than 25 MB File Type is Uploaded");
	}

	public void UploadingPDFFileType() throws InterruptedException
	{
		Thread.sleep(2000);
		ChooseFileBTN.sendKeys("D:\\Audit-360 Upload Document Test\\download_pdf.pdf");
		System.out.println("PDF File Type is Uploaded");
		chiledTest.log(Status.INFO, "PDF File Type is Uploaded");
	}

	public void VerifyAudioVideoFilesAreNotPermittedErrorMSGISDisplayed() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[text()='Not a valid file: Audio/Video files are not permitted.']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed(), "Not a valid file: Audio/Video files are not permitted Error Message is Not Displayed");
		System.out.println("Not a valid file: Audio/Video files are not permitted Error Message is Displayed");
		chiledTest.log(Status.INFO, "Not a valid file: Audio/Video files are not permitted Error Message is Displayed");
	}

	public void VerifyFileSizeShouldBeLessThan25MBErrorMSGISDisplayed() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[text()='The file size should be less than 25MB.']"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed(), "Not a valid file: Audio/Video files are not permitted Error Message is Not Displayed");
		System.out.println("File size should be less than 25mb Error Message is Displayed");
		chiledTest.log(Status.INFO, "File size should be less than 25mb Error Message is Displayed");

	}
	
	public void ChangeAuditstartDate() throws Exception
	{
		Thread.sleep(3000);
		try // Dismissing the pop up 
		{
		driver.findElement(By.xpath("//button[@aria-label='Dismiss']")).click();
		}catch(Exception e)
		{	
		}
		Thread.sleep(9000);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
	    WebElement AuditstartDate = driver.findElement(By.xpath("//input[@name='audit_schedule[start_date]']"));
	    wait.until(ExpectedConditions.visibilityOf(AuditstartDate));
	    System.out.println("ChangeAuditstartDate visible");
	    
	    AuditstartDate.click();
	    Thread.sleep(3000);
	    LocalDate date = LocalDate.now();
	    LocalDate nextDate = date.plusDays(1);

	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	    String text = date.format(formatters);
	    LocalDate parsedDate = LocalDate.parse(text, formatters);
	    
	    String NEXTDATE = nextDate.format(formatters);               
	    LocalDate parsedDate1 = LocalDate.parse(NEXTDATE, formatters); 
	    
	    AuditstartDate.clear();
	    AuditstartDate.sendKeys(NEXTDATE);
	    System.out.println("Schesule start date  Enterd:"+NEXTDATE);
	    
            
	}

	//input[@name='audit_schedule[end_date]']
	public void ChangeAuditEndDate() throws Exception
	{   
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 40);
	    WebElement AuditEndDate = driver.findElement(By.xpath("//input[@name='audit_schedule[end_date]']"));
	    wait.until(ExpectedConditions.visibilityOf(AuditEndDate));
	    System.out.println("ChangeAuditEndDate visible");
	    
	    AuditEndDate.click();
	    Thread.sleep(3000);
	    LocalDate date = LocalDate.now();
	    LocalDate nextDate = date.plusDays(1);

	    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
	    String text = date.format(formatters);
	    LocalDate parsedDate = LocalDate.parse(text, formatters);
	    
	    String NEXTDATE = nextDate.format(formatters);               
	    LocalDate parsedDate1 = LocalDate.parse(NEXTDATE, formatters); 
	    
	    AuditEndDate.clear();
	    Thread.sleep(2000);
	    AuditEndDate.sendKeys(NEXTDATE);
	    System.out.println("Schesule End date  Enterd:"+NEXTDATE);
  
	}
}


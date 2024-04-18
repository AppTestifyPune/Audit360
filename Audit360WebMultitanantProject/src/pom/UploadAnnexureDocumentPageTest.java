package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class UploadAnnexureDocumentPageTest extends BaseTest{

	//Clicking on the scroll bar//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Annexure under side menu //
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Annexures']")
	private WebElement Annexures;

	//Clicking on the Annexures side menu
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Annexure Documents']")
	private WebElement AnnexureDocuments;

	//Clicking on the Upload Annexure Button
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement UploadAnnexureBTN;

	//Clicking on the Audit Type
	@FindBy(xpath="//div[@id='s2id_audit_types']/a/span[text()='Please Select']")
	private WebElement AuditType;

	//Passing the Values to Audit Type
	@FindBy(xpath="//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input[@type='text']")
	private WebElement SetAuditType;

	//Clicking on the Matched
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//clicking on the Choose Button
	@FindBy(xpath="//input[@id='uploaded_file_name']")
	private WebElement ChooseBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@type='submit']")
	private WebElement SubmitBTN;

	//Passing the Values to From Date
	@FindBy(xpath="//input[@id='annexure_document_start_date']")
	private WebElement FromDate;

	//Passing the Values to TO Date
	@FindBy(xpath="//input[@id='annexure_document_end_date']")
	private WebElement ToDate;

	//Passing the Values to SubAudit Type
	@FindBy(xpath="//div[@id='s2id_filter_audit_types']/ul/li/input[@type='text']")
	private WebElement SubAuditType;

	//Clicking on the Sub Audit Type
	@FindBy(xpath="//div[@id='s2id_sub_audit_types']/a/span[@class='select2-chosen']")
	private WebElement SAT;

	//Clicking on the Annexure 
	@FindBy(xpath="//div[@class='form-group form-group-default required']/div[@id='s2id_get_annexure']")
	private WebElement Annexure1;

	//Clicking on the No of Files Uploaded
	@FindBy(xpath="//table[@id='tableWithSearch']/tbody/tr[1]/td[3]/a")
	private WebElement NOofFiles;


	public UploadAnnexureDocumentPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void ClickScrollBar(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ScrollBar));
		
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickAnnexure(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Annexures));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Annexures);
	}

	public void ClickAnnexureDocuments(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(AnnexureDocuments)).click();
	}

	public void ClickSubmitBTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SubmitBTN);
		System.out.println("submit Button is Clicked");
	}


	public void ClickUploadAnnexureBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(UploadAnnexureBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UploadAnnexureBTN);
	}

	public void ClickAuditType()
	{
		AuditType.click();
	}

	public void SetAuditType(String SA)
	{
		SetAuditType.sendKeys(SA);
		System.out.println("Entered Audit Type is : " + SA);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void ClickSAT(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SAT)).click();

	}

	public void ClickAnnexure1(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(Annexure1)).click();
	}

	public void UploadDocument()
	{
		ChooseBTN.sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\Annexuretemplate2.csv");
		System.out.println("Document is Uploaded");
	}
	
	public void UploadAnnexureDocumentforScoringLogic()
	{
	//ChooseBTN.sendKeys("D:\\Audit-360 Upload Document Test\\Annexure_Template_For_Scoring_Logic.csv");   //#SM OLD
		ChooseBTN.sendKeys("C:\\Users\\HP\\eclipse-workspace\\Audit-360 Upload Document Test\\Annexure_Template_For_Scoring_Logic.csv");		
		System.out.println("Document is Uploaded");
		
	}

	public void UploadingMoreThan5MBDocument()
	{
		ChooseBTN.sendKeys("D:\\Audit-360 Upload Document Test\\Sample.xls");
	}

	public void SetFromDate(String FD, WebDriver driver)
	{
		FromDate.sendKeys(FD);
		System.out.println("Entered From Date is : " + FD);
		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

	}

	public void SetToDate(String TD, WebDriver driver)
	{
		ToDate.sendKeys(TD);
		System.out.println("Entered To Date is : " + TD);

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
	}

	public void SetSubAuditType(String SA, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SubAuditType)).sendKeys(SA);
		System.out.println("Entered Sub Audit Type is : " + SA);
	}

	public void ClearSubAuditType()
	{
		SubAuditType.clear();
	}

	public void ClickNOofFiles(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(NOofFiles)).click();
		System.out.println("Clicked on the No Of files Uploaded Link");

	}


	public void VerifyDocumentUploadedSuccessfully(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		SoftAssert SoftAssert = new SoftAssert();
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).getText();
		String Expected_text = SuccessMSG.getText();
		String Actual_text = "Document Uploaded Successfully";
		SoftAssert.assertEquals(Expected_text, Actual_text, "Document Uploaded Successfully success Message is Displayed is Not Displayed");
		System.out.println("Pass : Document Uploaded Successfully success Message is Displayed");

		//Clicking on the Close Button
		driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();


	}

	public void VerifyDocumentAlreadyPresentErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMsg)).isDisplayed())
		{
			String Expected_text = ErrorMsg.getText();
			String Actual_text = "Document already present";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Document already present. Error Message is Displayed");
		}

		//Clicking on the Close Button
		driver.findElement(By.xpath("//div[@class='alert alert-danger']/button")).click();
	}

	public void VerifyNoMatchFoundErrorMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement NoMatch = driver.findElement(By.xpath("//ul[@class='select2-results']/li[@class='select2-no-results']"));
		if(wait.until(ExpectedConditions.visibilityOf(NoMatch)).isDisplayed())
		{
			System.out.println("Pass : No Match found Error Message is Displayed");
		}
	}


	public void VerifyMandatoryFiledsTest(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		//Checking Audit Type 
		WebElement AuditType1 = driver.findElement(By.xpath("//select[@id='audit_types'][@required='required']"));

		//Checking Sub Audit Type
		WebElement SubAuditType = driver.findElement(By.xpath("//select[@id='get_annexure'][@required='required']"));

		//Checking the Annexure
		WebElement Annexure = driver.findElement(By.xpath("//select[@id='get_annexure'][@required='required']"));

		//Checking Choose File
		WebElement ChooseFile = driver.findElement(By.xpath("//input[@id='annexure_document_document'][@required='required']"));

		//checking from Date 
		WebElement FromDate1 = driver.findElement(By.xpath("//input[@id='annexure_document_start_date'][@required='required']"));

		//checking TO Date
		WebElement ToDate1 = driver.findElement(By.xpath("//input[@id='annexure_document_end_date'][@required='required']"));

		if(AuditType1.isDisplayed() && SubAuditType.isDisplayed() && ChooseFile.isDisplayed() && Annexure.isDisplayed() && FromDate1.isDisplayed() && ToDate1.isDisplayed())
		{
			System.out.println("Pass : Mandatory Fileds are Displayed");
		}else
		{
			System.out.println("Fail : Mandatory fileds are Not Displayed");
		}
	}

	public void VerifyFilesUploadedPageIssDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking File Uploaded Page is Displayed
		WebElement FileUploaded = driver.findElement(By.xpath("//h5[text()='Files Uploaded']"));
		if(wait.until(ExpectedConditions.visibilityOf(FileUploaded)).isDisplayed())
		{
			//Checking the Th Count 
			List<WebElement> THCount = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/thead/tr[1]/th"));
			int Actual_Count = THCount.size();
			int Expected_Count = 6;
			Assert.assertEquals(Actual_Count, Expected_Count, "File Upload Header is count is Wrong");	

			//Checking File
			WebElement File = driver.findElement(By.xpath("//th[contains(text(),'File')]"));
			Assert.assertTrue(File.isDisplayed(), "File Header is Not Displayed");
			System.out.println("File Header is Displayed");
			chiledTest.log(Status.INFO, "File Header is Displayed");

			//Checking Date & Time
			WebElement DateAndTime = driver.findElement(By.xpath("//th[contains(text(),'Date & Time')]"));
			Assert.assertTrue(DateAndTime.isDisplayed(), "Date and Time Header is NOT Displayed");
			System.out.println("Date and Time Header is Displayed");
			chiledTest.log(Status.INFO, "Date and Time Header is Displayed");

			//Checking Validity Period
			WebElement ValidityPeriod = driver.findElement(By.xpath("//th[contains(text(),'Validity Period')]"));
			Assert.assertTrue(ValidityPeriod.isDisplayed(), "Validity Period Header is NOT Displayed");
			System.out.println("Validity Period Header is Displayed");
			chiledTest.log(Status.INFO, "Validity Period Header is Displayed");

			//Checking Error Doc
			WebElement ErrorDoc = driver.findElement(By.xpath("//th[contains(text(),'Error Doc')]"));
			Assert.assertTrue(ErrorDoc.isDisplayed(), "Error Doc Header is NOT Displayed");
			System.out.println("Error Doc Header is Displayed");
			chiledTest.log(Status.INFO, "Error Doc Header is Displayed");

			//Checking Status
			WebElement Status1 = driver.findElement(By.xpath("//th[contains(text(),'Status')]"));
			Assert.assertTrue(Status1.isDisplayed(), "Status Header is NOT Displayed");
			System.out.println("Status Header is Displayed");
			chiledTest.log(Status.INFO, "Status Header is Displayed");

			//Checking Uploaded by
			WebElement Uploadedby = driver.findElement(By.xpath("//th[contains(text(),'Uploaded by')]"));
			Assert.assertTrue(Uploadedby.isDisplayed(), "Uploaded by Header is NOT Displayed");
			System.out.println("Uploaded by Header is Displayed");
			chiledTest.log(Status.INFO, "Uploaded by Header is Displayed");


			//Validating the Fiel Name
			WebElement FileName = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr[1]/td[1]/a"));
			String Actual_FileName = FileName.getText();
			String Expected_FileName = "Annexuretemplate2.csv";
			Assert.assertEquals(Actual_FileName, Expected_FileName, "File Name is Wrong");

			//Validating date & Time
			List<WebElement> DateAndTime1 = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr[1]/td[2]/b"));
			Assert.assertTrue(DateAndTime1.size()>0, "Date and Time is Not Showed");

			//Validating Validity Period
			List<WebElement> ValidityFromDate = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr[1]/td[3]"));
			Assert.assertTrue(ValidityFromDate.size()>0, "Validity Period is Not Showed");

			//Validating the Error Doc
			WebElement ErrorDocumnetName = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr[1]/td[4]"));
			String Actual_ErrorDocumnetName = ErrorDocumnetName.getText();
			String Expected_ErrorDocumnetName = "-";
			Assert.assertEquals(Actual_ErrorDocumnetName, Expected_ErrorDocumnetName, "Error Documnet Name is Wrong");

			//Validating the status
			WebElement Status11 = driver.findElement(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr[1]/td[5]"));
			String Actual_Status1 = Status11.getText();
			String Expected_Status1 = "Processed";
			Assert.assertEquals(Actual_Status1, Expected_Status1, "Proccessed status is Not Showed");

			//Validating Uploaded By
			List<WebElement> UploadedBy = driver.findElements(By.xpath("//table[@id='tableWithSearchInner']/tbody/tr[1]/td[6]"));
			Assert.assertTrue(UploadedBy.size()>0, "Uploaded By is Not Showed");

			System.out.println("No Error Files and Proccess Status is Displayed");

			System.out.println("*******************************************");
		}
	}
	
	public void VerifyStaticAnnexureTypeIsDisplayed() throws InterruptedException
	{
		Thread.sleep(1000);
		String AnnexureType = driver.findElement(By.xpath("//div[@class='form-group form-group-default annexure_type block']/span[@id='annexure_type']")).getText();
		System.out.println("Displayed Annexure Type is : " + AnnexureType);
		String Static = "static";
		Assert.assertEquals(AnnexureType, Static);
	}
	
	public void VerifyDynamicAnnexureTypeIsDisplayed() throws InterruptedException
	{
		Thread.sleep(1000);
		String AnnexureType1 = driver.findElement(By.xpath("//div[@class='form-group form-group-default annexure_type block']/span[@id='annexure_type']")).getText();
		System.out.println("Displayed Annexure Type is : " + AnnexureType1);
		String Dynamic = "dynamic";
		Assert.assertEquals(AnnexureType1, Dynamic);
	}
}

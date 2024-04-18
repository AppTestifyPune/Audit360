package pom;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
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

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import junit.framework.Assert;

public class ProcessesAndPoliciesPageTest extends BaseTest {

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//body[contains(@class,'windows desktop pace-done')]/nav[1]/div[1]")
	private WebElement ScrollBar;

	//Clicking on the Processes & Policies 
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Processes & Policies']")
	private WebElement ProcessAndPolicies;
	
	//clicking on the Policy document header
	@FindBy(xpath="//a[text()='POLICY DOCUMENT']")
	private WebElement PolicyDocumentHeader;

	//Passing the Values to Document Name
	@FindBy(xpath="//input[@id='policy_document_name']")
	private WebElement DocumentName;

	//Passing the Values to Descriptions
	@FindBy(xpath="//input[@id='policy_document_description']")
	private WebElement Description;

	//Passing the Values to Version No
	@FindBy(xpath="//input[@id='policy_document_version_no']")
	private WebElement Version;

	//Passing the Values to Approved By
	@FindBy(xpath="//input[@id='policy_document_approved_by']")
	private WebElement ApprovedBy;

	//Passing the Values to Document circulation
	@FindBy(xpath="//input[@id='policy_document_circulation']")
	private WebElement DocumentCirculation;

	//Clicking on the From Date
	@FindBy(xpath="//input[@id='policy_document_active_from']")
	private WebElement FromDate;

	//Selecting the From Date
	@FindBy(xpath="//table[@class=' table-condensed']/tbody/tr/td[@class='day'][text()='27']")
	private WebElement FromDateOption;

	//Clicking on the To Date
	@FindBy(xpath="//input[@id='policy_document_active_to']")
	private WebElement ToDate;

	//Selecting the To Date
	@FindBy(xpath="//table[@class=' table-condensed']/tbody/tr/td[@class='day'][text()='27']")
	private WebElement ToDateOption;

	//Clicking on the Upload Button
	@FindBy(xpath="//input[@id='policy_document_document']")
	private WebElement UploadBTN;

	//Clicking on the Save Button
	@FindBy(xpath="//input[@class='btn btn-primary m-t-10']")
	private WebElement SaveBTN;

	//Clicking on the Search Box
	@FindBy(xpath="//input[@type='search']")
	private WebElement SearchBTN;



	public ProcessesAndPoliciesPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickProcessAndPolicies(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ProcessAndPolicies);
	}
	
	public void ClickPolicyDocumentHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PolicyDocumentHeader);
	}


	public void SetDocumentName(String DN)
	{
		DocumentName.sendKeys(DN);
		System.out.println("Entered Document Name is : " + DN);
	}

	public void SetDescription(String SD)
	{
		Description.sendKeys(SD);
		System.out.println("Entered Description is : " + SD);
	}

	public void SetVersion(String SV)
	{
		Version.sendKeys(SV);
		System.out.println("Enetred Version is : " + SV);
	}

	public void SetApprovedBy(String AB)
	{
		ApprovedBy.sendKeys(AB);
		System.out.println("Enetered Approved By : " + AB);
	}

	public void SetDocumentCirculation(String DC)
	{
		DocumentCirculation.sendKeys(DC);
		System.out.println("Enetred Document Circulation is : " + DC);
	}

	public void ClickFromDate(String FD)
	{
		FromDate.sendKeys(FD);
		System.out.println("Entered From Date is : " + FD);
		
		FromDate.sendKeys(Keys.ESCAPE);
	}

	public void ClickFromDateOption()
	{
		FromDateOption.click();
	}

	public void ClickToDate(String TD)
	{
		ToDate.sendKeys(TD);
		System.out.println("Entered To Date is : " + TD);
		
		ToDate.sendKeys(Keys.ESCAPE);
	}

	public void ClickToDateOption()
	{
		ToDateOption.click();
	}

	public void SetPDFDocument() throws InterruptedException
	{
	//	UploadBTN.sendKeys("F:\\Audit-360 Upload Document Test\\download_pdf.pdf");
		UploadBTN.sendKeys("C:\\Users\\Sumanth\\Downloads\\sample.pdf");
		chiledTest.log(Status.INFO, ".PDF File is Uploaded");
	}

	public void SetUploadMoreThan25MBDocument() throws InterruptedException
	{
	//	UploadBTN.sendKeys("F:\\Audit-360 Upload Document Test\\30_MB_PDF_document.pdf");
		UploadBTN.sendKeys("C:\\Users\\Sumanth\\Downloads\\30MB-TESTFILE.ORG.pdf");
		
	}

	public void UploadXlxDocument() throws InterruptedException
	{
	//	UploadBTN.sendKeys("F:\\Audit-360 Upload Document Test\\\\checkpoint_template_Test1.xlsx");
		UploadBTN.sendKeys("C:\\Users\\Sumanth\\Downloads\\SampleSheet.xlsx");	
	}

	public void UploadPNGDocument() throws InterruptedException
	{
		UploadBTN.sendKeys("F:\\Audit-360 Upload Document Test\\Address.PNG");
	}

	public void UploadJPGDocument() throws InterruptedException
	{
	//	UploadBTN.sendKeys("F:\\Audit-360 Upload Document Test\\IMG-20180606-WA0023.jpg");
		UploadBTN.sendKeys("C:\\Users\\Sumanth\\Downloads\\file_example_JPG_100kB.jpg");
		
	}

	public void UploadTXTDocument() throws InterruptedException
	{
		UploadBTN.sendKeys("C:\\Users\\Sumanth\\Downloads\\DWSample3-TXT.txt");
		
	}



	public void ClickSaveButton()
	{
		SaveBTN.click();
	}

	public void SetSearchBTN(String SB)
	{
		SearchBTN.clear();
		SearchBTN.sendKeys(SB);
		System.out.println("Serached Name is : " + SB);
	}

	public void VerifyPolicydocumentPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Policy Document Header 
		WebElement Header = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(Header)).isDisplayed())
		{
			String Actual_Text = Header.getText();
			String Expected_Text = "POLICY DOCUMENT";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : POLICY DOCUMENT Header is Displayed");
		}

		//Checking the Policy Document Grid
		WebElement Policydocgrid = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th"));
		if(Policydocgrid.isDisplayed())
		{
			List<WebElement> PolicydocgridOptions = driver.findElements(By.xpath("//table[@id='tableWithSearch']/thead/tr/th"));
			int count = PolicydocgridOptions.size();
			int Actual_count = count;
			int Expected_count = 3;
			Assert.assertEquals(Actual_count, Expected_count);
			System.out.println("Pass : Policy Document grid is Displayed");
		}

		//Checking the Policy Document name
		WebElement PDN = driver.findElement(By.xpath("//th[@class='sorting_asc']"));
		if(wait.until(ExpectedConditions.visibilityOf(PDN)).isDisplayed())
		{
			String Actual_Text = PDN.getText();
			String Expected_Text = "POLICY DOCUMENT NAME";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Policy Document Name is Displayed");
		}

		//Checking the Short Description
		WebElement SD = driver.findElement(By.xpath("//th[text()='Short Description']"));
		if(wait.until(ExpectedConditions.visibilityOf(SD)).isDisplayed())
		{
			String Actual_Text = SD.getText();
			String Expected_Text = "SHORT DESCRIPTION";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Short Description is Displayed");
		}

		//Checking the No of Versions
		WebElement NV = driver.findElement(By.xpath("//th[text()='No of Versions']"));
		if(wait.until(ExpectedConditions.visibilityOf(NV)).isDisplayed())
		{
			String Actual_Text = NV.getText();
			String Expected_Text = "NO OF VERSIONS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : No of Versionsn is Displayed");
		}

		//Checking the data
		WebElement data = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr"));
		if(data.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Policy Document Data is Displayed");
		}

		//Checking the Upload document Header
		WebElement UploadDoc = driver.findElement(By.xpath("//div[@class='panel panel-transparent']/h4"));
		if(UploadDoc.isDisplayed())
		{
			String Actual_Text = UploadDoc.getText();
			String Expected_Text = "Upload Document";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Upload Document Header is Displayed");
		}

		//Checking the Document Name
		WebElement DocName = driver.findElement(By.xpath("//form[@id='new_policy_document']/div[1]/div[1]"));
		if(DocName.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Document Name is Displayed");
		}

		//Checking the Descriptions
		WebElement Descriptions = driver.findElement(By.xpath("//form[@id='new_policy_document']/div[2]/div[1]"));
		if(Descriptions.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Descriptions is Displayed");
		}

		//Checking the Version Number
		WebElement VN = driver.findElement(By.xpath("//form[@id='new_policy_document']/div[3]/div[1]"));
		if(VN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Version Number is Displayed");
		}

		//Checking the Approved By
		WebElement AB = driver.findElement(By.xpath("//form[@id='new_policy_document']/div[4]/div[1]"));
		if(AB.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Approved By is Displayed");
		}

		//Checking the Document circulation
		WebElement DC = driver.findElement(By.xpath("//form[@id='new_policy_document']/div[5]/div[1]"));
		if(DC.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Document circulation is Displayed");
		}

		//Checking the Active
		WebElement Active = driver.findElement(By.xpath("//form[@id='new_policy_document']/div[6]/div[1]"));
		if(Active.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Active is Displayed");
		}

		//checking the Choose File button
		WebElement ChooseBTN = driver.findElement(By.xpath("//input[@id='policy_document_document']"));
		if(ChooseBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Choose Button is Displayed");
		}

		//checking the Submit Button
		WebElement SubmitBTN = driver.findElement(By.xpath("//input[@type='submit']"));
		if(SubmitBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Submit Button is Displayed");
		}

		//checking the (Allowed file format : PDF and Max. file size : 1 MB)
		WebElement Allowed = driver.findElement(By.xpath("//div[contains(@class,'col-md-4 col-xs-12 sm-p-b-15 p-l-0 sm-p-l-15 sm-p-r-15 p-b-20 m-t-20')]/p"));
		if(Allowed.isDisplayed())
		{
			String Actual_Text = Allowed.getText();
			String Expected_Text = "(Allowed file format : PDF and Max. file size : 25 MB)";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : (Allowed file format : PDF and Max. file size : 25 MB) is Displayed");
		}

	}

	public void VerifyDocumentSavedSuccessfullySucessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement SuccessMSG = driver.findElement(By.xpath("//span[text()='Document Saved Successfully']"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Document Saved Successfully";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Document Saved Successfully Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();

		}
	}

	public void VerifyOnlyPDFFilesErrorMSGIsDisplayed(WebDriver driver) throws Exception
	{
	//	Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement SuccessMSG = driver.findElement(By.xpath("(//label[text()='Only .pdf files are allowed for upload.'])[1]"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Only .pdf files are allowed for upload.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Only .pdf files are allowed for upload. Error  Message is Displayed");

		}
	}

	public void VerifyNumberOfVersion1(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement data = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]"));
		WebElement version = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[3]"));
		if(data.isDisplayed() && version.isDisplayed())
		{
			Assert.assertTrue(true);

			String Actual_version = version.getText();
			String Expected_version = "1";
			Assert.assertEquals(Actual_version, Expected_version);
			System.out.println("Pass : Uploaded document is Displayed");
		}

	}

	public void VerifyNumberOfVersion2(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement data = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]"));
		WebElement version = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[3]"));
		if(data.isDisplayed() && version.isDisplayed())
		{
			Assert.assertTrue(true);

			String Actual_version = version.getText();
			String Expected_version = "2";
			Assert.assertEquals(Actual_version, Expected_version);
			System.out.println("Pass : Uploaded document is Displayed");
		}

	}

	public void VerifyNumberOfVersion3(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement data = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]"));
		WebElement version = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr[1]/td[3]"));
		if(data.isDisplayed() && version.isDisplayed())
		{
			Assert.assertTrue(true);

			String Actual_version = version.getText();
			String Expected_version = "3";
			Assert.assertEquals(Actual_version, Expected_version);
			System.out.println("Pass : Uploaded document is Displayed");
		}

	}

	public void AlertIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Alert Alert = driver.switchTo().alert();
		Alert.accept();
	}


	public void VerifyOnlyCapitalLattersAreAllowedForDocumentNameErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@class='error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_Text = ErrorMSG.getText();
			String Expected_Text = "Only capital letters are allowed for document name";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Only capital letters are allowed for document name Error  Message is Displayed");

		}
	}

	public void VerifyVersionNoAlreadyExistForTheSameDocumentErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@class='error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_Text = ErrorMSG.getText();
			String Expected_Text = "Version no already exist for the same document";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Version no already exist for the same document Error  Message is Displayed");

		}
	}

	public void VerifyTheFileSizeShouldBeLessThan25MBErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@class='error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_Text = ErrorMSG.getText();
			String Expected_Text = "The file size should be less than 25MB.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : The file size should be less than 25MB. Error  Message is Displayed");
			chiledTest.log(Status.INFO, "The file size should be less than 25MB. Error  Message is Displayed");

		}
	}
	
	public void VerfiyVersionNoAlreadyExistForTheSameDocument()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@class='error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_Text = ErrorMSG.getText();
			String Expected_Text = "Version no already exist for the same document";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Version no already exist for the same document Error  Message is Displayed");
			chiledTest.log(Status.INFO, "Version no already exist for the same document Error  Message is Displayed");

		}
	}
}

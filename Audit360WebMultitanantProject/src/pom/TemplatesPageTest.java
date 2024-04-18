package pom;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import junit.framework.Assert;

public class TemplatesPageTest extends BaseTest {

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clicking on the Processes & Policies 
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='System Settings']")
	private WebElement SystemSettings;

	//Clicking on the Templates Under System Settings
	@FindBy(xpath="//ul[@style='display: block;']/li/a[text()='Templates']")
	private WebElement Templates;

	//Clicking on the Auditee Document under Drop down list
	@FindBy(xpath="//ul[@class='select2-results']/li[2]")
	private WebElement AuditeeDocument;

	//Clicking on the Auditor Document under Drop down list
	@FindBy(xpath="//ul[@class='select2-results']/li[3]")
	private WebElement AuditorDocument;

	//Clicking on the cluster Document under Drop down list
	@FindBy(xpath="//ul[@class='select2-results']/li[4]")
	private WebElement ClusterDocument;

	//Clicking on the Schedule Document under Drop down list
	@FindBy(xpath="//ul[@class='select2-results']/li[5]")
	private WebElement ScheduleDocument;

	//Clicking on the AuditeeUserDocument under Drop down list
	@FindBy(xpath="//ul[@class='select2-results']/li[6]")
	private WebElement AuditeeUserDocument;

	//Clicking on the CheckpointDocument under Drop down list
	@FindBy(xpath="//ul[@class='select2-results']/li[7]")
	private WebElement CheckpointDocument;

	//Clicking on the Select Document Type
	@FindBy(xpath="//span[@id='select2-chosen-3']")
	private WebElement SelectDocType;

	//Clicking on the Cluster Template
	@FindBy(xpath="//a[text()='Cluster Template']")
	private WebElement ClusterTemplate;

	//Clicking on the Auditor Template
	@FindBy(xpath="//a[text()='Auditor Template']")
	private WebElement AuditorTemplate;

	//Clicking on the Auditee Template
	@FindBy(xpath="//a[text()='Auditee Template']")
	private WebElement AuditeeTemplate;

	//Clicking on the schedule Template
	@FindBy(xpath="//a[text()='Schedule Template']")
	private WebElement scheduleTemplate;

	//Clicking on the Auditee User Template
	@FindBy(xpath="//a[text()='Auditee User Template']")
	private WebElement AUT;

	//Clicking on the Checkpoint Template
	@FindBy(xpath="//a[text()='Checkpoint Template']")
	private WebElement CheckpointTemplate;

	@FindBy(xpath="//input[@class='btn btn-primary m-t-10 upload_doc']")
	private WebElement UploadDocumentBTN;
	
	//Passing the Values to Select Document Type
	@FindBy(xpath="//div[@id='select2-drop']/div/input")
	private WebElement SetSelectDocumnetType;
	
	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;
	
	//Passing the Values to Choose File
	@FindBy(xpath="//input[@id='uploaded_file_name']")
	private WebElement ChooseFile;
	
	//Checking the Success Messages
	@FindBy(xpath="//div[@class='alert alert-success']/span")
	private WebElement SuccessMSG;
	
	//Clicking on the Success Message Close Button
	@FindBy(xpath="//div[@class='alert alert-success']/button")
	private WebElement SuccessMSGCloseBTN;
	


	public TemplatesPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickSystemAndSettings(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SystemSettings);
		System.out.println("System and Setting is Clicked");
		chiledTest.log(Status.INFO, "System and Setting is Clicked");
	}
	
	public void ClickTemplates(WebDriver driver) throws InterruptedException
	{
		Actions action = new Actions(driver);	
		action.moveToElement(Templates).click().build().perform();	
	}
	
	public void SetSelectDocumnetType(String DT)
	{
		SetSelectDocumnetType.sendKeys(DT);
		System.out.println("Selected Documnet Type is : " + DT);
		chiledTest.log(Status.INFO, "Documnet is Selected");
	}
	
	public void ClickMatched()
	{
		Matched.click();
	}


	public void ClickAuditeeDocument()
	{
		AuditeeDocument.click();
	}

	public void ClickAuditorDocument()
	{
		AuditorDocument.click();
	}

	public void ClickClusterDocument()
	{
		ClusterDocument.click();
	}

	public void ClickScheduleDocument()
	{
		ScheduleDocument.click();
	}

	public void ClickAuditeeUserDocument()
	{
		AuditeeUserDocument.click();
	}

	public void ClickCheckpointDocument()
	{
		CheckpointDocument.click();
	}


	public void ClickSelectDocType()
	{
		SelectDocType.click();
	}

	public void ClickClusterTemplate()
	{
		ClusterTemplate.click();
	}

	public void ClickAuditorTemplate()
	{
		AuditorTemplate.click();
	}

	public void ClickAuditeeTemplate()
	{
		AuditeeTemplate.click();
	}

	public void ClickscheduleTemplate()
	{
		scheduleTemplate.click();
	}

	public void ClickAuditeeUserTemplate()
	{
		AUT.click();
	}

	public void ClickCheckpointTemplate()
	{
		CheckpointTemplate.click();
	}

	public void ClickUploadDocumentButton()
	{
		UploadDocumentBTN.click();
	}
	
	public void UploadScheduleDocument()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\FS_Schedule_Template.xlsx");
		System.out.println("Schedule Document is Uploaded");
	
	}
	
	public void UploadClusterDocument()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\cluster_template.csv");
		System.out.println("Cluster Document is Uploaded");
		chiledTest.log(Status.INFO, "Cluster Document is Uploaded");	
	}
	
	public void UploadAuditeeDocument()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\auditee_template.csv");
		System.out.println("Auditee Document is Uploaded");
		chiledTest.log(Status.INFO, "Auditee Document is Uploaded");	
	}
	
	public void UploadAuditorDocument()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\auditor_template.csv");
		System.out.println("Auditor Document is Uploaded");
		chiledTest.log(Status.INFO, "Auditor Document is Uploaded");	
	}
	
	public void UploadAuditeeUserDocument()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\auditee_user_template.csv");
		System.out.println("Auditee User Document is Uploaded");
		chiledTest.log(Status.INFO, "Auditee User Document is Uploaded");	
	}
	
	public void UploadAuditeeReviewerDocument()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\Reviewer_template.csv");
		System.out.println("Auditee Reviewer Document is Uploaded");
		chiledTest.log(Status.INFO, "Auditee Reviewer Document is Uploaded");	
	}
	
	public void UploadAuditeeRespondentDocument()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\Respondent_template.csv");
		System.out.println("Auditee Respondent Document is Uploaded");
		chiledTest.log(Status.INFO, "Auditee Respondent Document is Uploaded");	
	}

	

	public void VerifyTemplatePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Template Header
		WebElement header = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(header)).isDisplayed())
		{
			String Actual_Text = header.getText();
			String Expected_Text = "TEMPLATE";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : TEMPLATE Page is Displayed");
		}

		//Checking Select Document type
		WebElement SDT = driver.findElement(By.xpath("//div[@id='s2id_get_annexure']"));
		if(SDT.isDisplayed())
		{
			SDT.click();
			List<WebElement> SDTOptions = driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
			int count = SDTOptions.size();
			int Actual_count = count;
			int Expected_count = 9;
			Assert.assertEquals(Actual_count, Expected_count);
			System.out.println("Pass : Select Document Type Options are Displayed");

			//Clicking on the Please select option
			driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]")).click();

		}

		//Checking Download Excel Templates Here:
		WebElement DownloadExcelHere = driver.findElement(By.xpath("//div[@class='row col-md-12 m-b-10']/div[3]/label/b"));
		if(DownloadExcelHere.isDisplayed())
		{
			String Actual_Text = DownloadExcelHere.getText();
			String Expected_Text = "Download Excel templates here:";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Download Excel templates here: is Displayed");
		}

		//Checking Cluster Template
		WebElement CT = driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-12 sm-p-b-15 p-l-0 sm-p-l-15 sm-p-r-15 p-b-20 m-t-20']/a[1]"));
		if(CT.isDisplayed())
		{
			String Actual_Text = CT.getText();
			String Expected_Text = "Cluster Template";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Cluster Template is Displayed");
		}

		//Checking Auditor Template
		WebElement AT = driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-12 sm-p-b-15 p-l-0 sm-p-l-15 sm-p-r-15 p-b-20 m-t-20']/a[2]"));
		if(AT.isDisplayed())
		{
			String Actual_Text = AT.getText();
			String Expected_Text = "Auditor Template";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Auditor Template is Displayed");
		}

		//Checking Auditee Template
		WebElement AE = driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-12 sm-p-b-15 p-l-0 sm-p-l-15 sm-p-r-15 p-b-20 m-t-20']/a[3]"));
		if(AE.isDisplayed())
		{
			String Actual_Text = AE.getText();
			String Expected_Text = "Auditee Template";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Auditee Template is Displayed");
		}

		//Checking Schedule Template
		WebElement ST = driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-12 sm-p-b-15 p-l-0 sm-p-l-15 sm-p-r-15 p-b-20 m-t-20']/a[4]"));
		if(ST.isDisplayed())
		{
			String Actual_Text = ST.getText();
			String Expected_Text = "Schedule Template";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Schedule Template is Displayed");
		}

		//Checking Auditee User Template
		WebElement AUT = driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-12 sm-p-b-15 p-l-0 sm-p-l-15 sm-p-r-15 p-b-20 m-t-20']/a[5]"));
		if(AUT.isDisplayed())
		{
			String Actual_Text = AUT.getText();
			String Expected_Text = "Auditee User Template";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Auditee User Template is Displayed");
		}

		//Checking Checkpoint Template 
		WebElement CT1 = driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-12 sm-p-b-15 p-l-0 sm-p-l-15 sm-p-r-15 p-b-20 m-t-20']/a[6]"));
		if(CT1.isDisplayed())
		{
			String Actual_Text = CT1.getText();
			String Expected_Text = "Checkpoint Template";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Checkpoint Template is Displayed");
		}

		//Checking the Notes
		WebElement Note = driver.findElement(By.xpath("//b[text()='Note: Allowed file types for upload: xls,xlsx,ods,csv ']"));
		if(Note.isDisplayed())
		{
			String Actual_Text = Note.getText();
			String Expected_Text = "Note: Allowed file types for upload: xls,xlsx,ods,csv";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Note: Allowed file types for upload: xls,xlsx,ods,csv is Displayed");
		}

		//Checking the Allowed upload file size : 25 MB
		WebElement Allowed = driver.findElement(By.xpath("//b[text()='Allowed upload file size: 25 MB']"));
		if(Allowed.isDisplayed())
		{
			String Actual_Text = Allowed.getText();
			String Expected_Text = "Allowed upload file size: 25 MB";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Allowed upload file size: 25 MB is Displayed");
		}

		//Checking Choose file
		WebElement Choosefile = driver.findElement(By.xpath("//input[@id='document_document']"));
		if(Choosefile.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Choose File is Displayed");
		}

		//Checking Upload Document 
		WebElement UploadDocument = driver.findElement(By.xpath("//input[@class='btn btn-primary m-t-10']"));
		if(UploadDocument.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Upload Document button is Displayed");
		}

		//Checking the Search Button
		WebElement SearchBox = driver.findElement(By.xpath("//input[@class='form-control']"));
		if(SearchBox.isDisplayed())	
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Search Text Field is Disaplayed");
		}

		//Template Count List is Displayed
		WebElement data = driver.findElement(By.xpath("//table[@id='tableWithSearch']/tbody/tr"));
		if(data.isDisplayed())	
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Configure Execution List is Disaplayed");
		}

		//Checking the Show
		WebElement Show = driver.findElement(By.xpath("//label[text()='Show ']"));
		if(Show.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Show and Rows are Disaplayed");
		}

		//Checking the Configure Execution Count List
		WebElement TableHeader = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th"));
		if(TableHeader.isDisplayed())
		{
			List<WebElement> All = driver.findElements(By.xpath("//table[@id='tableWithSearch']/thead/tr/th"));
			int count = All.size();
			int Actual_count = count;
			int Expected_count = 5;
			Assert.assertEquals(Actual_count, Expected_count);
		}

		//Checking the Document Name
		WebElement DN = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[1]"));
		if(DN.isDisplayed())
		{
			String Actual_Text = DN.getText();
			String Expected_Text = "DOCUMENT NAME";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Document Name is Disaplayed");
		}

		//Checking the Document Type
		WebElement DT = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[2]"));
		if(DT.isDisplayed())
		{
			String Actual_Text = DT.getText();
			String Expected_Text = "DOCUMENT TYPE";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Document Type is Disaplayed");
		}

		//Checking the Status
		WebElement Status = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[3]"));
		if(Status.isDisplayed())
		{
			String Actual_Text = Status.getText();
			String Expected_Text = "STATUS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Status is Disaplayed");
		}

		//Checking the Download Error Doc
		WebElement DED = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[4]"));
		if(DED.isDisplayed())
		{
			String Actual_Text = DED.getText();
			String Expected_Text = "DOWNLOAD ERROR DOC";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Download Document Error is Disaplayed");
		}

		//Checking the Created At
		WebElement Created = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[5]"));
		if(Created.isDisplayed())
		{
			String Actual_Text = Created.getText();
			String Expected_Text = "CREATED AT";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Created At is Disaplayed");
		}

	}

	public void VerifyDocumentSavedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_text = SuccessMSG.getText();
			String Expected_text = "Document Processed Successfully.";
			Assert.assertEquals("Success Message is Wrong", Expected_text, Actual_text);
			System.out.println("Document Saved successfully message is Displayed");
			chiledTest.log(Status.INFO, "Document Saved successfully message is Displayed");
			
			//Clicking on the Close Button
			SuccessMSGCloseBTN.click();
		}
	}

	public void VerifyNotValidFileFormatErrorMessage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())

		{
			String Actual_Text = ErrorMSG.getText();
			String Expected_text = "Not a valid file format";
			Assert.assertEquals(Actual_Text, Expected_text);
			System.out.println("Pass : Not a valid file format Error Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@class='close']")).click();

		}

	}




	public void VerifyClusterTemplateisDownload(WebDriver driver)
	{
		File folder;

		folder = new File(UUID.randomUUID().toString());
		folder.mkdirs();

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_setting.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);

		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.setCapability(ChromeOptions.CAPABILITY, options);




		//Make sure  
		File listOffiles[] = folder.listFiles();
		//Assert.assertEquals(listOffiles.length, actual);

		Assert.assertTrue(listOffiles.length>0);

		for(File file : listOffiles )
		{
			Assert.assertTrue(file.length()>0);
		}



	}


}



package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;

public class ReviewCheckpointsPageTest extends BaseTest {

	//Clicking on the Handle Issues Here button
	@FindBy(xpath="//a[contains(text(),'Handle Issues Here')]")
	private WebElement HandleIssuesHereBTN;

	//Clicking on the Retain Issue Button
	@FindBy(xpath="//input[@value='Retain Issue']")
	private WebElement RetainIssueBTN;

	//Clicking on the Drop Issue Button
	@FindBy(xpath="//input[@value='Drop Issue']")
	private WebElement DropIssueBTN;

	//Passing the Values to Comments
	@FindBy(xpath="//textarea[@id='drop_retain_remarks' and @required='required']")
	private WebElement SetComments;

	//Clicking on the Reaudit Button
	@FindBy(xpath="//input[@value='Reaudit']")
	private WebElement ReauditBTN;

	//Passing the Value to Reaudit Remarks text field
	@FindBy(xpath="//input[@id='review_audit_compliance_reaudit_comments']")
	private WebElement ReauditRemarks;

	//clicking on the Compliance
	@FindBy(xpath="//div[@id='s2id_review_audit_compliance_value']//a//span[@class='select2-chosen']")
	private WebElement Compliance;

	//Passing the Values to Compliance
	@FindBy(xpath="//div[@id='select2-drop']//div[@class='select2-search']//input")
	private WebElement SetCompliance;

	//clicking on the Matched
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//clicking on the Update Button
	@FindBy(xpath="//input[@value='Update']")
	private WebElement UpdateBTN;

	//Moving the slider
	@FindBy(xpath="//div[@id='slider']/div/div")
	private WebElement Slider;

	//passing the values to Sample Reviewed
	@FindBy(xpath="//input[@class='form-control max_value_show max_value_show1']")
	private WebElement SetSampleReviewed;

	//Clicking on the Review Checkpoint Cancel Button
	@FindBy(xpath="//button[@class='btn btn-default btn-block']")
	private WebElement CancelBTN;

	//clicking on the Add Checkpoint button
	@FindBy(xpath="//button[text()='Add Check Point']")
	private WebElement AddCheckpointBTN;

	//clicking on the close button//input[@class='btn btn-primary btn-block review_close_issue']
	@FindBy(xpath="//input[@value='Close']")
	private WebElement CloseBTN;

	//clicking on the Reopen button//input[@class='btn btn-primary btn-block update_details reopen_resolution']
	@FindBy(xpath="//input[@value='Reopen']")
	private WebElement ReopenBTN;

	//Passing the values to the Direct Resolution score
	@FindBy(xpath="//input[@id='direct_score']")
	private WebElement DirectResolutionScore;

	


	public ReviewCheckpointsPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickHandleIssuesHereBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(HandleIssuesHereBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", HandleIssuesHereBTN);
		System.out.println("Handle Issues Here Button is Clicked");
	}

	public void ClickRetainIssueBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", RetainIssueBTN);
		System.out.println("Retain Issue Button is Clicked");
		chiledTest.log(Status.INFO, "Retain Issue Button is Clicked");
	}

	public void ClickDropIssueBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DropIssueBTN);
		System.out.println("Drop Issue Button is Clicked");
		chiledTest.log(Status.INFO, "Drop Issue Button is Clicked");
	}

	public void SetComments(String SC)
	{
		SetComments.sendKeys(SC);
		System.out.println("Entered Comments is : " + SC);
		chiledTest.log(Status.INFO, "Comments is Enterd");
	}

	public void VerifyCommentIsRequiredFields()
	{
		List<WebElement> Comments = driver.findElements(By.xpath("//textarea[@id='drop_retain_remarks' and @required='required']"));
		Assert.assertTrue(Comments.size()>0, "Comments is Not Working as Required Fields");
		System.out.println("Comments is Required Fields");
		chiledTest.log(Status.INFO, "Comments is Required Fields");
	}


	public void ClickReAuditButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(ReauditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReauditBTN);
		System.out.println("Reaudit Button is Clicked");
	}


	public void SetReauditRemarks(String RR, WebDriver driver)
	{
		ReauditRemarks.sendKeys(RR);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		System.out.println("Entered ReAudit Remarks is : " + RR);
	}

	public void VerifyReAuditRemarksIsRequiredFiled(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ReauditRemarks = driver.findElement(By.xpath("//input[@id='review_audit_compliance_reaudit_comments'][@required='required']"));
		if(wait.until(ExpectedConditions.visibilityOf(ReauditRemarks)).isDisplayed()){
			System.out.println("Pass :  Reaudit Remarks is Required Field");}
	}

	public void VerifyColor(WebDriver driver)
	{
		String BlueColor = Lib.getCellValue(XLPATH, "Review Audit", 56, 0);
		String color = driver.findElement(By.xpath("//table[@id='tableWithSearchSummary']/tbody/tr[1]")).getCssValue("background-color");
		String hex = Color.fromString(color).asHex();
		//Validating the color
		Assert.assertEquals(hex, BlueColor, "Color of the Checkpoint is wrong");
		chiledTest.log(Status.INFO, "color is Displayed for Reopened Checkpoint");
		System.out.println("Color is Displayed for Reopened Checkpoint");

	}

	public void VerifyIssueIsRetainedSuccessMSGISDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement IssueIsRetainedMSG = driver.findElement(By.xpath("//span[contains(text(),'Issue is retained')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(IssueIsRetainedMSG)).isDisplayed(), "Issue is retained Success Message is Not Displayed");
		System.out.println("Issue is retained Success Message is Displayed");
		chiledTest.log(Status.INFO, "Issue is retained Success Message is Displayed");
	}

	public void VerifyIssueIsDropedSuccessMSGISDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement IssueIsRetainedMSG = driver.findElement(By.xpath("//span[contains(text(),'Issue is dropped')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(IssueIsRetainedMSG)).isDisplayed(), "Issue is dropped Success Message is Not Displayed");
		System.out.println("Issue is dropped Success Message is Displayed");
		chiledTest.log(Status.INFO, "Issue is dropped Success Message is Displayed");
	}

	public void ClickUpdateButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", UpdateBTN);
		System.out.println("Update Button is Clicked");
		chiledTest.log(Status.INFO, "Update Button is Clicked");
	}

	public void ClickAddCheckpointButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddCheckpointBTN);
		System.out.println("Add checkpoint Button is Clicked");
		chiledTest.log(Status.INFO, "Add checkpoint Button is Clicked");
	}

	public void ClickCompliance()
	{
		Compliance.click();
	}

	public void SetCompliance(String SC)
	{
		SetCompliance.sendKeys(SC);
		System.out.println("Entered compliance is : " + SC);
		chiledTest.log(Status.INFO, "compliance is Entered");
	}

	public void ClickMatched()
	{
		Matched.click();
	}


	public void SetSampleReviewed(String SR)
	{
		SetSampleReviewed.clear();
		SetSampleReviewed.sendKeys(SR);
		System.out.println("Sample Reviewed is Entered : " + SR);
	}

	public void ClicKCancelBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CancelBTN);
		System.out.println("Cancel button is Clicked");
		chiledTest.log(Status.INFO, "Cancel button is Clicked");
	}

	public void SelectAllDispositions() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement ListBox = driver.findElement(By.xpath("//select[@id='review_audit_compliance_compliance_dispositions']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		for(int i=0; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			All.click();
			System.out.println("Selected all Dispositions");
		}
	}


	public void MoveSlider(WebDriver driver) throws InterruptedException
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(Slider));
			Actions act = new Actions(driver);
			act.dragAndDropBy(Slider, 1000, 0).perform();

			//checking after slider is moved to 50 Observed Value is showing 50 or not
			String Actual_ObservedValues = driver.findElement(By.xpath("//span[@id='observed_val']")).getText();
			String Expected_ObservedValues = "50.00";
			Assert.assertEquals(Actual_ObservedValues, Expected_ObservedValues, "Observed Values is Showing Wrong");
			System.out.println("Actual Observed Values is : " + Actual_ObservedValues);
			System.out.println("Expected Observed Values is : " + Expected_ObservedValues);
			System.out.println("Slider is Moved to 50");
			chiledTest.log(Status.INFO, "Slider is moved to 50");
		}catch (MoveTargetOutOfBoundsException e) {

		}
	}

	public void VerifyingAuditorDigitalEvidencesFilesAreDisplayed()
	{
		//*******Checking the auditor Digital Evidence documents*****
		System.out.println("*******Checking the auditor Digital Evidence documents*****");
		chiledTest.log(Status.INFO, "*******Checking the auditor Digital Evidence documents*****");

		WebElement file1 = driver.findElement(By.xpath("//label[text()='Digital Evidences']/following-sibling::div//table/tbody/tr//a[text()='IMG-20180606-WA0023.jpg']"));
		Assert.assertTrue(file1.isDisplayed(), "IMG-20180606-WA0023.jpg file is not displayed");
		System.out.println("added IMG-20180606-WA0023.jpg file is Displayed");
		chiledTest.log(Status.INFO, "added IMG-20180606-WA0023.jpg file is Displayed");

		WebElement file2 = driver.findElement(By.xpath("//label[text()='Digital Evidences']/following-sibling::div//table/tbody/tr//span[text()='kurai-onrum-illai.mp3']"));
		Assert.assertTrue(file2.isDisplayed(), "kurai-onrum-illai.mp3 file is not displayed");
		System.out.println("added kurai-onrum-illai.mp3 file is Displayed");
		chiledTest.log(Status.INFO, "added kurai-onrum-illai.mp3 file is Displayed");

		WebElement file3 = driver.findElement(By.xpath("//label[text()='Digital Evidences']/following-sibling::div//table/tbody/tr//a[text()='download.pdf']"));
		Assert.assertTrue(file3.isDisplayed(), "download.pdf file is not displayed");
		System.out.println("added download.pdf file is Displayed");
		chiledTest.log(Status.INFO, "added download.pdf file is Displayed");

		WebElement file4 = driver.findElement(By.xpath("//label[text()='Digital Evidences']/following-sibling::div//table/tbody/tr//a[text()='fp_dc_setup_guide.pdf']"));
		Assert.assertTrue(file4.isDisplayed(), "fp_dc_setup_guide.pdf file is not displayed");
		System.out.println("added fp_dc_setup_guide.pdf file is Displayed");
		chiledTest.log(Status.INFO, "added fp_dc_setup_guide.pdf file is Displayed");
	}

	public void VerifyingAuditorConfidentialDigitalEvidencesFilesAreDisplayed()
	{
		//*******Checking the Auditor Confidential Digital Evidences documents*****
		System.out.println("*******Checking the Auditor Confidential Digital Evidences documents*****");
		chiledTest.log(Status.INFO, "*******Checking the Auditor Confidential Digital Evidences documents*****");

		WebElement file5 = driver.findElement(By.xpath("//label[text()='Auditor Confidential Digital Evidences']/following-sibling::div//table/tbody/tr//a[text()='IMG-20180607-WA0031.jpg']"));
		Assert.assertTrue(file5.isDisplayed(), "IMG-20180607-WA0031 file is not displayed");
		System.out.println("added IMG-20180607-WA0031.jpg file is Displayed");
		chiledTest.log(Status.INFO, "added IMG-20180607-WA0031.jpg file is Displayed");

		WebElement file6 = driver.findElement(By.xpath("//label[text()='Auditor Confidential Digital Evidences']/following-sibling::div//table/tbody/tr//span[text()='kurai-onrum-illai.mp3']"));
		Assert.assertTrue(file6.isDisplayed(), "kurai-onrum-illai.mp3 file is not displayed");
		System.out.println("added kurai-onrum-illai.mp3 file is Displayed");
		chiledTest.log(Status.INFO, "added kurai-onrum-illai.mp3 file is Displayed");

		WebElement file7 = driver.findElement(By.xpath("//label[text()='Auditor Confidential Digital Evidences']/following-sibling::div//table/tbody/tr//a[text()='VID_20200213_170644.mp4']"));
		Assert.assertTrue(file7.isDisplayed(), "VID_20200213_170644.mp4 file is not displayed");
		System.out.println("added VID_20200213_170644.mp4 file is Displayed");
		chiledTest.log(Status.INFO, "added VID_20200213_170644.mp4 file is Displayed");

		WebElement file8 = driver.findElement(By.xpath("//label[text()='Auditor Confidential Digital Evidences']/following-sibling::div//table/tbody/tr//a[text()='IMG-20180606-WA0023.jpg']"));
		Assert.assertTrue(file8.isDisplayed(), "IMG-20180606-WA0023.jpg file is not displayed");
		System.out.println("added IMG-20180606-WA0023.jpg file is Displayed");
		chiledTest.log(Status.INFO, "added IMG-20180606-WA0023.jpg file is Displayed");
	}

	public void VerifyYesComplianceIsDisplayed()
	{
		//checking Yes Compliances
		List<WebElement> Yes = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='Yes']"));
		Assert.assertTrue(Yes.size()>0, "Yes Complaince is not Displayed");
		System.out.println("Yes Complaince is Displayed");
		chiledTest.log(Status.INFO, "Yes Complaince is Displayed");
	}

	public void VerifyNoComplianceIsDisplayed()
	{
		//checking NO Compliances
		List<WebElement> NO = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='No']"));
		Assert.assertTrue(NO.size()>0, "NO Complaince is not Displayed");
		System.out.println("NO Complaince is Displayed");
		chiledTest.log(Status.INFO, "NO Complaince is Displayed");
	}

	public void VerifyPartialComplianceIsDisplayed()
	{
		//checking Partial Compliances
		List<WebElement> Partial = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='Partial']"));
		Assert.assertTrue(Partial.size()>0, "Partial Complaince is not Displayed");
		System.out.println("Partial Complaince is Displayed");
		chiledTest.log(Status.INFO, "Partial Complaince is Displayed");
	}

	public void VerifyNAComplianceIsDisplayed()
	{	
		List<WebElement> NA = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='NA']"));
		Assert.assertTrue(NA.size()>0, "NA Complaince is not Displayed");
		System.out.println("NA Complaince is Displayed");
		chiledTest.log(Status.INFO, "NA Complaince is Displayed");
	}

	public void VerifyYesComplianceIsNotDisplayed()
	{
		//checking Yes Compliances
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> Yes = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='Yes']"));
		Assert.assertFalse(Yes.size()>0, "Yes Complaince is Displayed");
		System.out.println("Yes Complaince is Not Displayed");
		chiledTest.log(Status.INFO, "Yes Complaince is Not Displayed");
	}

	public void VerifyNoComplianceIsNotDisplayed()
	{
		//checking NO Compliances
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> NO = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='No']"));
		Assert.assertFalse(NO.size()>0, "NO Complaince is Displayed");
		System.out.println("NO Complaince is Not Displayed");
		chiledTest.log(Status.INFO, "NO Complaince is Not Displayed");
	}

	public void VerifyPartialComplianceIsNotDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//checking Partial Compliances
		List<WebElement> Partial = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='Partial']"));
		Assert.assertFalse(Partial.size()>0, "Partial Complaince is Displayed");
		System.out.println("Partial Complaince is Not Displayed");
		chiledTest.log(Status.INFO, "Partial Complaince is Not Displayed");
	}

	public void VerifyNAComplianceIsNotDisplayed()
	{	
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> NA = driver.findElements(By.xpath("//select[@id='review_audit_compliance_value']/option[@value='NA']"));
		Assert.assertFalse(NA.size()>0, "NA Complaince is Displayed");
		System.out.println("NA Complaince is Not Displayed");
		chiledTest.log(Status.INFO, "NA Complaince is Not Displayed");
	}

	public void VerifyUpdateReauditCancelButtonsShouldDisplay()
	{
		//Checking Update Button is Displayed
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(UpdateBTN));
		Assert.assertTrue(UpdateBTN.isDisplayed(), "Update Button is Not Displayed");
		System.out.println("Update Button is Displayed");
		chiledTest.log(Status.INFO, "Update Button is Displayed");

		//Checking Reaudit Button is Displayed
		Assert.assertTrue(ReauditBTN.isDisplayed(), "Reaudit Button is Not Displayed");
		System.out.println("Reaudit Button is Displayed");
		chiledTest.log(Status.INFO, "Reaudit Button is Displayed");

		//Checking Cancel Button is Displayed
		Assert.assertTrue(CancelBTN.isDisplayed(), "Cancel Button is Not Displayed");
		System.out.println("Cancel Button is Displayed");
		chiledTest.log(Status.INFO, "Cancel Button is Displayed");
	}
	
	public void ClickCloseButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CloseBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);
		System.out.println("Close Button is Clicked");
		chiledTest.log(Status.INFO, "Close Button is Clicked");
	}

	public void ClickReopenButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReopenBTN);
		System.out.println("Reopen Button is Clicked");
		chiledTest.log(Status.INFO, "Reopen Button is Clicked");
	}

	public void SetDirectResolutionScore(String DRS)
	{
		DirectResolutionScore.sendKeys(DRS);
		System.out.println("Entered Direct Resolution score is : " + DRS);
		chiledTest.log(Status.INFO, "Direct Resolution Score is Entred");
	}

	public void VerifyDirectResolutionScoreIsRequiredFiled()
	{
		WebElement DR = driver.findElement(By.xpath("//input[@id='direct_score' and @required='required']"));
		Assert.assertTrue(DR.isDisplayed(), "Direct Resolution Score is Not working as required Field");
		System.out.println("Direct Resolution Score is Required Field");
		chiledTest.log(Status.INFO, "Direct Resolution Score is Required Field");
	}


}

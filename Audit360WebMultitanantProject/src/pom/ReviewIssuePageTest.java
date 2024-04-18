package pom;

import java.lang.Character.UnicodeScript;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import generic.Lib;

public class ReviewIssuePageTest extends BaseTest {

	//Clicking on the Retain Issue Button
	@FindBy(xpath="//input[@value='Retain Issue']")
	private WebElement RetainIssueBTN;

	//Clicking on the Drop Issue Button
	@FindBy(xpath="//input[@value='Drop Issue']")
	private WebElement DropIssueBTN;

	//Passing the Values to Comments
	@FindBy(xpath="//textarea[@id='issue_issue_comments_attributes_0_description']")
	private WebElement SetComments;

	//clicking on the Reopen issues button
	@FindBy(xpath="//input[@value='Reopen Issue']")
	private WebElement ReopenIssueBTN;

	//clicking on the Close issues button
	@FindBy(xpath="//div[text()='Close Issue']")
	private WebElement CloseIssueBTN;

	//passing the values to Comments
	@FindBy(xpath="//div[@class='fields']//textarea[@placeholder='Enter comments']")
	private WebElement Comments;

	//clicking on the Resolve Issue button
	@FindBy(xpath="//input[@class='btn btn-primary btn-block auditee_result']")
	private WebElement ResloveIssueBTN;

	//clicking on the Add digital Evidence button
	@FindBy(xpath="//a[text()='Add a Digital Evidence']")
	private WebElement AddADigitalEvidenceBTN;

	//Passing the Files to choose
	@FindBy(xpath="//div[@class='fields']//input[@type='file']")
	private WebElement ChooseFile;

	//clicking on the Review issue page close button
	@FindBy(xpath="//div[@id='modalSlideLeftIssue']//button[@class='close']")
	private WebElement CloseBTN;

	//clicking on the Do you want to choose the final auditee remarks for this issue ? Yes Button
	@FindBy(xpath="//div[text()='Yes']")
	private WebElement YesBTN;

	//clicking on the Do you want to choose the final auditee remarks for this issue ? No Button
	@FindBy(xpath="//input[@value='No']")
	private WebElement NOBTN;


	public ReviewIssuePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
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

	public void SetComments(String SC) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SetComments)).sendKeys(SC);
		System.out.println("Entered Comments is : " + SC);
		chiledTest.log(Status.INFO, "Comments is Enterd");
	}

	public void clickResoveIssueButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ResloveIssueBTN);
		System.out.println("Reslove issue button is clicked");
		chiledTest.log(Status.INFO, "Reslove issue button is clicked");
	}

	public void VerifyCommentIsRequiredFields()
	{
		List<WebElement> Comments = driver.findElements(By.xpath("//textarea[@placeholder='Enter comments' and @required='required']"));
		Assert.assertTrue(Comments.size()>0, "Comments is Not Working as Required Fields");
		System.out.println("Comments is Required Fields");
		chiledTest.log(Status.INFO, "Comments is Required Fields");
	}

	public void ClickReopenIssuesButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReopenIssueBTN);
		System.out.println("Reopen issue button is clicked");
		chiledTest.log(Status.INFO, "Reopen issue button is clicked");
	}

	public void ClickAddADigitalEvidenceButton()
	{
		AddADigitalEvidenceBTN.click();
		System.out.println("Add Digital Evidence button is clicked");
		chiledTest.log(Status.INFO, "Add Digital Evidence button is clicked");
	}

	public void PassingPDFFile()
	{
		ChooseFile.sendKeys("D:\\Audit-360 Upload Document Test\\download_pdf.pdf");
		System.out.println(".PDF File is Added");
		chiledTest.log(Status.INFO, ".PDF File is Added");
	}


	public void ClickCloseIssueButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseIssueBTN);
		System.out.println("Close issue button is clicked");
		chiledTest.log(Status.INFO, "Close issue button is clicked");
	}

	public void ClickCloseBTN()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CloseBTN);
	}

	public void VerifyReopenAndCloseButtonIsDisabled()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Checking Post Closing the Issue Reopen and Close buttons should not show
		List<WebElement> ReopenBTN = driver.findElements(By.xpath("//input[@value='Reopen Issue']"));
		Assert.assertTrue(ReopenBTN.size()>=0, "Reopen Button is Displayed");
		System.out.println("Reopen Button is Not Displayed post closing the Issue");
		chiledTest.log(Status.INFO, "Reopen Button is Not Displayed post closing the Issue");

		List<WebElement> CloseBTN = driver.findElements(By.xpath("//input[@value='Close Issue']"));
		Assert.assertTrue(CloseBTN.size()>=0, "Close Button is Displayed");
		System.out.println("Close Button is Not Displayed post closing the Issue");
		chiledTest.log(Status.INFO, "Close Button is Not Displayed post closing the Issue");
	}

	public void VerifySignificanceIsDisabledOrNot() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement SignificanceDisabled = driver.findElement(By.xpath("//select[@name='issue_significance_list[]' and @disabled]"));
		Assert.assertTrue(SignificanceDisabled.isDisplayed(), "Signifiance is editable");
		System.out.println("Significance is Read only mode");
		chiledTest.log(Status.INFO, "Significance is Read only mode");

	}

	public void VerifyIssueSignificanceAreDisplayed() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> Significancelists = driver.findElements(By.xpath("//select[@name='issue_significance_list[]']//option"));
		String Actaul_1stSignifance = Significancelists.get(0).getText();
		String Expected_1stSignificance = Lib.getCellValue(XLPATH, "Configure Audit Type", 192, 0);
		Assert.assertEquals(Actaul_1stSignifance, Expected_1stSignificance, "The 1st significane is worng");
		System.out.println("Diplayed 1st Actaul Significance is : " + Actaul_1stSignifance);
		System.out.println("Displayed 1st Expected Significance is :  " + Expected_1stSignificance);

		String Actaul_2ndSignifance = Significancelists.get(1).getText();
		String Expected_2ndSignificance = Lib.getCellValue(XLPATH, "Configure Audit Type", 193, 0);
		Assert.assertEquals(Actaul_2ndSignifance, Expected_2ndSignificance, "The 2nd significane is worng");
		System.out.println("Diplayed 2nd Actaul Significance is : " + Actaul_2ndSignifance);
		System.out.println("Displayed 2nd Expected Significance is :  " + Expected_2ndSignificance);

		String Actaul_3rdSignifance = Significancelists.get(2).getText();
		String Expected_3rdSignificance = Lib.getCellValue(XLPATH, "Configure Audit Type", 194, 0);
		Assert.assertEquals(Actaul_3rdSignifance, Expected_3rdSignificance, "The 3rd significane is worng");
		System.out.println("Diplayed 3rd Actaul Significance is : " + Actaul_3rdSignifance);
		System.out.println("Displayed 3rd Expected Significance is :  " + Expected_3rdSignificance);

		String Actaul_4thSignifance = Significancelists.get(3).getText();
		String Expected_4thSignificance = Lib.getCellValue(XLPATH, "Configure Audit Type", 195, 0);
		Assert.assertEquals(Actaul_4thSignifance, Expected_4thSignificance, "The 1st significane is worng");
		System.out.println("Diplayed 4th Actaul Significance is : " + Actaul_4thSignifance);
		System.out.println("Displayed 4th Expected Significance is :  " + Expected_4thSignificance);

		String Actaul_5thignifance = Significancelists.get(4).getText();
		String Expected_5thSignificance = Lib.getCellValue(XLPATH, "Configure Audit Type", 196, 0);
		Assert.assertEquals(Actaul_5thignifance, Expected_5thSignificance, "The 5th significane is worng");
		System.out.println("Diplayed 5th Actaul Significance is : " + Actaul_5thignifance);
		System.out.println("Displayed 5th Expected Significance is :  " + Expected_5thSignificance);
	}

	public void SelectAllIssueSignificances()
	{
		//Selecting all the Options under select execution status drop down list
		WebElement ListBox = driver.findElement(By.xpath("//select[@name='issue_significance_list[]']"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		int Actual_Count = alloptions.size();
		int Expected_Count = 5;
		System.out.println("The Totle Number of Issue Siginificance is ! " + Actual_Count);
		Assert.assertEquals(Actual_Count, Expected_Count, "Issue Status Drop down list Count is Wrong");
		for (int i=0; i<alloptions.size(); i++)
		{
			WebElement All = alloptions.get(i);
			String AllText = All.getText();
			System.out.println(AllText);
			All.click();

		}
	}

	public void ClickYesButton()
	{
		YesBTN.click();
		System.out.println("Yes Button Is Clicked");
		chiledTest.log(Status.INFO, "Yes Button is Clicked");
	}

	public void ClickNoButton()
	{
		NOBTN.click();
		System.out.println("No Button Is Clicked");
		chiledTest.log(Status.INFO, "No Button is Clicked");
	}


	public void VerifyDoYouWantToChooseTheFinalAuditeeRemarksForThisIssue()
	{
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement PopUp = driver.findElement(By.xpath("//div[text()='Do you want to choose the final auditee remarks for this issue ?']"));
			Assert.assertTrue(PopUp.isDisplayed(), "Do you want to choose the final auditee remarks for this issue ? is NOT Displayed");
			System.out.println("Do you want to choose the final auditee remarks for this issue ? Pop Up Is Displayed");
			chiledTest.log(Status.INFO, "Do you want to choose the final auditee remarks for this issue ? Pop Up Is Displayed");
		}catch (Exception e) {
			WebElement PopUp = driver.findElement(By.xpath("//div[text()='Do you want to cho0se the final auditee remarks for this issue ?']"));
			Assert.assertTrue(PopUp.isDisplayed(), "Do you want to cho0se the final auditee remarks for this issue ? is NOT Displayed");
			System.out.println("Do you want to cho0se the final auditee remarks for this issue ? Pop Up Is Displayed");
			chiledTest.log(Status.INFO, "Do you want to cho0se the final auditee remarks for this issue ? Pop Up Is Displayed");
		}

	}

}


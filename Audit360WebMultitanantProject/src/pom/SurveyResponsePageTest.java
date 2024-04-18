package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SurveyResponsePageTest extends BaseTest {

	//Clicking on the scroll bar
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clicking on the Auditor Survey under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Auditor Survey']")
	private WebElement AuditorSurvey;

	//Clicking on the Survey Questions
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Survey Responses']")
	private WebElement SurveryResponses;

	//Passing the Values to Select Audit Type
	@FindBy(xpath="//input[@id='s2id_autogen4']")
	private WebElement SelectAuditType;

	//Passing the Values to Select Auditee
	@FindBy(xpath="//input[@id='s2id_autogen5']")
	private WebElement SelectAuditee;

	//Passing the Values to Select Auditor
	@FindBy(xpath="//input[@id='s2id_autogen1']")
	private WebElement SelectAuditor;

	//Passing the Values to Search Text Filed
	@FindBy(xpath="//input[@type='search']")
	private WebElement SearchBTN;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Clicking on the survey Response Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement SurveyResponseHeader;

	//Clicking on the View Button
	@FindBy(xpath="//table[@id='surveyResponseTable']/tbody/tr[1]/td/button[@class='btn btn-clear view_question_details']")
	private WebElement ViewBTN;





	public SurveyResponsePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickAuditorSurvey(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AuditorSurvey);
	}

	public void ClickSuveryResponseHeader()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SurveyResponseHeader);
		System.out.println("Survey Response Header is Clicked");
	}

	public void ClickSurveryResponses(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SurveryResponses);
	}

	public void ClickViewBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ViewBTN);
		System.out.println("View Button is Clicked");
	}


	public void SetSelectAuditType(String AT)
	{
		SelectAuditType.sendKeys(AT);
		System.out.println("Entered Select Audit Type is : " + AT);
	}

	public void SetSelectAuditee(String SA)
	{
		SelectAuditee.sendKeys(SA);
		System.out.println("Entered Select Auditee is : " + SA);
	}

	public void SetSelectAuditor(String SAA)
	{
		SelectAuditor.sendKeys(SAA);
		System.out.println("Entered Select Auditor is : " + SAA);
	}

	public void SetSearchBTN(String SB)
	{
		SearchBTN.clear();

		SearchBTN.sendKeys(SB);
		System.out.println("Searched Name is : " + SB);
	}

	public void ClickMatched()
	{
		Matched.click();
	}



	public void VerifySuveryResponsesPageIsDisplayed(WebDriver driver)
	{


		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//checking Suvery Responses Header is Displayed
		WebElement Header = driver.findElement(By.xpath("//a[@class='active']"));

		if(Header.isDisplayed())
		{
			String Expected_Text = Header.getText();
			String Actual_Text = "SURVEY RESPONSE";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Suvery Responses Header is Displayed");
		}

		//Checking the Suvery Responses Label
		WebElement Label = driver.findElement(By.xpath("//h4[contains(text(),'Survey response')]"));
		if(Label.isDisplayed())
		{
			String Expected_Text = Label.getText();
			String Actual_Text = "Survey response";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Survey response Text is Displayed");
		}

		//Checking Select Audit Type
		WebElement SAT = driver.findElement(By.xpath("//div[@id='s2id_search_audit_types']"));

		//Checking Select Audit Type Label
		WebElement SATLabel = driver.findElement(By.xpath("//label[contains(text(),'Select Audit Type')]"));
		if(SAT.isDisplayed() && SATLabel.isDisplayed() && SelectAuditType.isDisplayed())
		{
			System.out.println("Select Audit Type Search Text Filed is Displayed");
		}

		//checking The Select Auditee
		WebElement SA = driver.findElement(By.xpath("//div[@id='s2id_search_auditees']"));

		//Checking the Select Auditee
		WebElement SALabel = driver.findElement(By.xpath("//label[contains(text(),'Select Auditee')]"));
		if(SA.isDisplayed() && SALabel.isDisplayed() && SelectAuditee.isDisplayed())
		{
			System.out.println("Select Auditee search Text Filed is Displayed");
		}

		//Checking the Select Auditor
		WebElement SAA = driver.findElement(By.xpath("//div[@id='s2id_search_auditor']"));

		//Checking the Select Auditor
		WebElement SAALabel = driver.findElement(By.xpath("//label[contains(text(),'Select Auditor')]"));
		if(SAA.isDisplayed() && SAALabel.isDisplayed() && SelectAuditor.isDisplayed())
		{
			System.out.println("Select Auditor Search Text Filed is Displayed");
		}

		//Checking the Shows and Rows
		WebElement Shows = driver.findElement(By.xpath("//div[contains(@class,'col-md-6 col-xs-12 p-l-0')]//label[1]"));
		if(Shows.isDisplayed())
		{
			System.out.println("Shows and Rows is Displayed");
		}

		//Checking the Table
		WebElement Tabel = driver.findElement(By.xpath("//table[@id='surveyResponseTable']"));
		if(Tabel.isDisplayed())
		{
			System.out.println("Pass : Grid is Displayed");
		}

	}


	public void verifyNoDataAvailableInTableMSGIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement NoData = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(NoData.isDisplayed())
		{
			String Expected_Text = NoData.getText();
			String Actual_Text = "No data available in table";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : No data available in table Message is Displayd");
		}
	}

	public void VerifyViewSurveyResponsePageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ViewSurveyResponsePage = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']//h4[contains(text(),'Survey response')]"));
		if(wait.until(ExpectedConditions.visibilityOf(ViewSurveyResponsePage)).isDisplayed())
		{
			String Actual_Text = ViewSurveyResponsePage.getText();
			String Expected_Text = "Survey response";
			Assert.assertEquals("Page Name is Wrong", Expected_Text, Actual_Text);
			System.out.println("Pass : Survey response page is Displayd");
			chiledTest.log(Status.INFO, "Survey response page is Displayd");
		}
	}

	public void VerifyDataIsShownInGrid(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		try{
			WebDriverWait wait = new WebDriverWait(driver, 3);
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sorting_1']"))).isDisplayed()){
				System.out.println("Searched Audit Type is Displayed");
				chiledTest.log(Status.INFO, "Searched Audit Type is Displayed");}
			}catch (Exception e) {
				driver.findElement(By.xpath("//td[@class='dataTables_empty']")).isDisplayed();
				System.out.println("No data available in table Message is Displayed");
				chiledTest.log(Status.INFO, "No data available in table Message is Displayed");
			}

	}

	public void VerifyNoMatchFoundIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement NoMatchFoundMSG = driver.findElement(By.xpath("//li[@class='select2-no-results']"));
		if(wait.until(ExpectedConditions.visibilityOf(NoMatchFoundMSG)).isDisplayed()){	
			String Actual_text = NoMatchFoundMSG.getText();
			String Expected_text = "No matches found";
			Assert.assertEquals("Error Message is Wrong", Expected_text, Actual_text);
			System.out.println("No matches found Error Message is Displayed");
			chiledTest.log(Status.INFO, "No matches found Error Message is Displayed");}
	}
}

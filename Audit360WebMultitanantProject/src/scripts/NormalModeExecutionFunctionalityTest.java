package scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class NormalModeExecutionFunctionalityTest extends BaseTest {

	//Passing the Values to Enter Remarks
	@FindBy(xpath="//textarea[@placeholder='Enter Remarks']")
	private WebElement EnterRemarks;
	
	//Passing the Values to Enter Confidental Remarks
		@FindBy(xpath="//textarea[@placeholder='Enter Confidential Remarks...']")
		private WebElement EnterConfidentalRemarks;
		
		//Clicking on the Yes Button
		@FindBy(xpath="//input[@value='Yes']/ancestor::label")
		private WebElement YesButton;

		//Clicking on the No Button
		@FindBy(xpath="//input[@value='No']/ancestor::label")
		private WebElement NoButton;

		//Clicking on the Partial Button//input[@value='Partial']/ancestor::label
		@FindBy(xpath="//input[@value='Partial']/ancestor::label") 
		private WebElement PartialButton;

		//Clicking on the NA Button//input[@value='NA']/ancestor::label
		@FindBy(xpath="//input[@value='NA']/ancestor::label")
		private WebElement NAButton;

		//Clicking on the Dispositions
		@FindBy(xpath="//ul[@class='select2-choices']")
		private WebElement Dispositions;

		//Clicking on the Next Button
		@FindBy(xpath="//input[@id='valid_btn'][@value='Next']")
		private WebElement NextBTN;

		//Clicking on the Please Select
		@FindBy(xpath="//div[@id='s2id_audit_compliance_input_value']")
		private WebElement ValuesDropDownList;

		//Passing the Values to Enter Input Values text fields  //input[@id='audit_compliance_input_value']
		@FindBy(xpath="//input[@placeholder='Enter Input values']")    
		private WebElement EnterInputValues1;

		//Passing the Values to Enter Input Values text fields
		@FindBy(xpath="//textarea[@id='audit_compliance_input_value']")
		private WebElement EnterInputValues2;

		//Passing the Values to Search Button
		@FindBy(xpath="//label[contains(text(),'Search')]/input")
		private WebElement SearchBTN;

		//Passing the values to search 
		@FindBy(xpath="//div[@id='tableWithSearchSummary_filter']//input[@class='form-control']")
		private WebElement PiSearchBTN;

		//Clicking on the Ok Button
		@FindBy(xpath="//a[contains(text(),'Ok')]")
		private WebElement OKBTN1;

		//Clicking on the Complete Button
		@FindBy(xpath="//a[contains(text(),'completed')]")
		private WebElement CompleteBTN;

		//Clicking on the Submitted Button
		@FindBy(xpath="//button[@class='btn btn-primary prime-btn btn-block all-caps']")
		private WebElement SubmittedBTN;

	public NormalModeExecutionFunctionalityTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void SetEnterRemarks(String ER)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(EnterRemarks)).clear();
		wait.until(ExpectedConditions.visibilityOf(EnterRemarks)).sendKeys(ER);
		System.out.println("Entered Remarks is : " + ER);
		chiledTest.log(Status.INFO, "Remarks is Entered");

	}
	
	public void SetEnterConfidentalRemarks(String ECR)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(EnterConfidentalRemarks)).clear();
		EnterConfidentalRemarks.sendKeys(ECR);
		System.out.println("Entered Confidental Remarks is : " + ECR);
		chiledTest.log(Status.INFO, "Confidental Remarks is Entered");

	}

	public void ClickYesButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", YesButton);
		System.out.println("Yes Button is Clicked");
		chiledTest.log(Status.INFO, "Yes Button is Clicked");
	}

	public void ClickNoButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", NoButton);
		System.out.println("No Button is Clicked");
		chiledTest.log(Status.INFO, "NO Button is Clicked");
	}

	public void ClickPartialButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", PartialButton);
		System.out.println("Partial Button is Clicked");
		chiledTest.log(Status.INFO, "Partial Button is Clicked");
	}

	public void ClickNAButton()
	{
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", NAButton);
		System.out.println("NA Button is Clicked");
		chiledTest.log(Status.INFO, "NA Button is Clicked");
	}

	public void ClickDispositions(WebDriver driver) throws InterruptedException
	{
		try{
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(Dispositions));
			JavascriptExecutor JS = (JavascriptExecutor)driver;
			JS.executeScript("arguments[0].click();", Dispositions);
			System.out.println("Dispossion is Clicked");
		}catch (StaleElementReferenceException e) {

		}
	}
	
	public void ClickNextButton(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBTN);
		System.out.println("Next Button is Clicked");
		chiledTest.log(Status.INFO, "Next Button is Clicked");
	}
	
	public void ClickValuesDropDownList()
	{
		ValuesDropDownList.click();
	}

	public void SetSearchBTN(String SB) throws InterruptedException
	{
		try{
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(SearchBTN)).clear();
			wait.until(ExpectedConditions.visibilityOf(SearchBTN)).sendKeys(SB);
			System.out.println("Searched Audit Type is : " + SB);
			chiledTest.log(Status.INFO, "Audit Type is Searched");
		}catch (StaleElementReferenceException e) {
		}

	}

	public void SetPiSearchBTN(String SB) throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(PiSearchBTN)).clear();
		wait.until(ExpectedConditions.visibilityOf(PiSearchBTN)).sendKeys(SB);
		System.out.println("Searched Sub Audit Type is : " + SB);
		chiledTest.log(Status.INFO, "PI is Searched");
	}

	public void ClearPiSearchBTN()
	{
		PiSearchBTN.clear();
	}
	
	public void ClickOKBTN1(WebDriver driver)
	{
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(OKBTN1)).click();
		System.out.println("Ok Button is Clicked");
		chiledTest.log(Status.INFO, "Ok Button is Clicked");
	}

	public void ClickCompletedButton()
	{
		CompleteBTN.click();
		System.out.println("Complete Button is Clicked");
		chiledTest.log(Status.INFO, "Complete Button is Clicked");
	}


}

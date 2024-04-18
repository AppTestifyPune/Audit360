package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;


public class SurveyQuestionsPageTest extends BaseTest{

	//Clicking on the scroll bar
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clicking on the Auditor Survey under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Auditor Survey']")
	private WebElement AuditorSurvey;

	//Clicking on the Survey Questions
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Survey Questions']")
	private WebElement SurveryQuestions;

	//Clicking on the Auditor Suvery Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement AuditorSuveryHeader;

	//Clicking on the Select Audit Type drop down list
	@FindBy(xpath="//span[@id='select2-chosen-3']")
	private WebElement SelectAuditType;

	//Passing the Values to Select Audit Type
	@FindBy(xpath="//input[@id='s2id_autogen3_search']")
	private WebElement SetSelectAuditType;

	//Clicking on the Add a Question
	@FindBy(xpath="//a[@class='nested_survey_question']")
	private WebElement AddQuestionBTN;

	//Clicking on the Response Required Check Box
	@FindBy(xpath="//input[@id='audit_type_survey_question_response_required']")
	private WebElement ResponseRequiredCheckBoxBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//input[@type='submit']")
	private WebElement SubmitBTN;

	//Clicking on the Submit Button
	@FindBy(xpath="//form[@id='new_survey_question']//div[@class='modal-footer']/input[@type='submit']")
	private WebElement SubmitBTN1;

	//Passing the values to Question
	@FindBy(xpath="//textarea[@id='survey_question_question']")
	private WebElement Question;

	//Clicking on the Close Button
	@FindBy(xpath="//i[@class='pg-close fs-14']")
	private WebElement CloseBTN;

	//Clicking on the Matching Data
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Match;

	//Checking the Notes
	@FindBy(xpath="//p[text()='Note: Each question will have 5 options in the following format. 1 being low and 5 being the highest score: ']")
	private WebElement Notes;

	//Passing the Values to Audit Type
	@FindBy(xpath="//input[@id='s2id_autogen6']")
	private WebElement AuditType;

	//Clicking on the Accept Button
	@FindBy(xpath="//a[text()='Accept']")
	private WebElement AcceptBTN;	

	//Clicking on the Not Started Button
	@FindBy(xpath="//a[@class='btn btn-primary prime-btn btn-block all-caps choose_execution_type']")
	private WebElement NotStartedBTN;

	//Clicking on the Normal Button
	@FindBy(xpath="//a[@class='btn btn-primary btn-cons btn-lg activate_normal_mode'][text()='Normal']")
	private WebElement NormalBTN;

	//Clicking on the Yes Button
	@FindBy(xpath="//label[@class='btn btn-balanced no_round-btn col-md-6 p-t-15 yes_compliance']")
	private WebElement YesBTN;

	//Clicking on the No Button
	@FindBy(xpath="//label[@class='btn btn-danger no_round-btn col-md-6 p-t-15']")
	private WebElement NOBTN;

	//Clicking on the Partial Button
	@FindBy(xpath="//label[@class='btn btn-warning no_round-btn col-md-6 p-t-15']")
	private WebElement PartialBTN;
	
	//Clicking on the NA Button
	@FindBy(xpath="//label[@class='btn btn-Blue no_round-btn col-md-6 p-t-15']")
	private WebElement NABTN;

	//Clicking on the Disposition
	@FindBy(xpath="//li[@class='select2-search-field']/input[@type='text']")
	private WebElement Disposition;

	//Selecting the 1st Options Under Dispositions
	@FindBy(xpath="//div[@id='select2-drop']//ul[@class='select2-results']/li[1]/div")
	private WebElement DispositionsOption;

	//Clicking on the Next Button
	@FindBy(xpath="//input[@id='valid_btn']")
	private WebElement NextBTN;

	//Passing the Values to Enter Input values
	@FindBy(xpath="//textarea[@id='audit_compliance_input_value']")
	private WebElement InputValues;

	//Clicking on the Finish Button
	@FindBy(xpath="//input[@class='btn btn-primary finish_audit']")
	private WebElement FinishBTN;



	

	public SurveyQuestionsPageTest(WebDriver driver)
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


	public void ClickSurveryQuestions(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SurveryQuestions);
	}

	public void ClickAuditorSuveryHeader()
	{
		AuditorSuveryHeader.click();
	}

	public void ClickSelectAuditType()
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(SelectAuditType));
		SelectAuditType.click();
	}

	public void SetSelectAuditType(String SA)
	{
		SetSelectAuditType.sendKeys(SA);
		System.out.println("Selected Audit Type is : " + SA);
	}

	public void ClickAddQuestionBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddQuestionBTN);
	}

	public void ClickResponseRequiredCheckBoxBTN()
	{
		ResponseRequiredCheckBoxBTN.click();
		System.out.println("Response Required Check box is Clicked");
	}

	public void ClickSubmitBTN(WebDriver driver)
	{
		//#SM
	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	executor.executeScript("arguments[0].click();", SubmitBTN);
		SubmitBTN.click();
	}

	public void ClickSubmitBTN1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(SubmitBTN1)).click();
	}

	public void ClickMatch()
	{
		Match.click();
	}

	public void SetAuditType(String AT)
	{
		AuditType.sendKeys(AT);
		System.out.println("Entered Audit Type : " + AT);
	}

	public void ClickAcceptBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(4000);
		AcceptBTN.click();
	}

	public void ClickNotStartedBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(4000);
		NotStartedBTN.click();
	}

	public void ClickNormalBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(NormalBTN)).click();
	}
	
	public void ClickYesButton(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", YesBTN);
	}


	public void ClickNoButton(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NOBTN);
	}

	public void ClickPartialBTN(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PartialBTN);
	}
	
	public void ClickNABTN(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NABTN);
	}

	public void ClickDisposition(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Disposition.click();
	}

	public void ClickDispositionsOption()
	{
		DispositionsOption.click();
	}

	public void ClickNextBTN()
	{
		NextBTN.click();
	}

	public void SetInputValues(String IV)
	{
		InputValues.sendKeys(IV);
		System.out.println("Entered Input Values is : " + IV);
	}

	public void ClickFinishBTN()
	{
		FinishBTN.click();
	}

	public void SetQuestion(String SS, WebDriver driver) throws InterruptedException
	{
		try
		{
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(Question)).sendKeys(SS);
			System.out.println("Entered Question is : " + SS);
		}catch (StaleElementReferenceException e) {

		}

	}

	public void ClickCloseBTN()
	{
		CloseBTN.click();
	}


	public void VerifyAuditorSurveyPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		//Checking the Audit Type Header
		WebElement AuditType = driver.findElement(By.xpath("//label[text()='Audit Type']"));

		if(wait.until(ExpectedConditions.visibilityOf(AuditorSuveryHeader)).isDisplayed())
		{
			String Expected_AuditorSurevy = AuditorSuveryHeader.getText();
			String Actual_AuditorSuveryHeader = "AUDITOR SURVEY";
			Assert.assertEquals(Expected_AuditorSurevy, Actual_AuditorSuveryHeader);
			System.out.println("Pass : Auditor Suvery Page is Displayed");
		}

		if(AuditType.isDisplayed())
		{
			String Expected_Text = AuditType.getText();
			String Actual_Text = "Audit Type";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Audit Type is Displayed");
		}

		if(SelectAuditType.isDisplayed())
		{
			System.out.println("Pass : Select Audit Type Drop down is Displayed");
		}

	}

	public void VerifySelectAuditTypeOptionsAreDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> SelectAuditTypeOptions = driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
		int Count = SelectAuditTypeOptions.size();
		System.out.println("Total Number of Select Audit Type Options is : " + Count);
		if(Count>1)
		{
			System.out.println("Pass : Select Audit Type Options are displayed");
		}

		driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
	}



	public void VerifyQuestionsTableIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);

		//Checking the Quetions Tabel
		WebElement QTabel = driver.findElement(By.xpath("//table[@id='question_table']"));
		if(wait.until(ExpectedConditions.visibilityOf(QTabel)).isDisplayed())
		{
			System.out.println("Pass : Questions Tabel is Displayed" );
		}

		//Checking Question Header
		WebElement QuestionLabel = driver.findElement(By.xpath("//table[@id='question_table']/caption"));
		if(QuestionLabel.isDisplayed())
		{
			String Expected_text = QuestionLabel.getText();
			String Atual_Text = "Questions";
			Assert.assertEquals(Expected_text, Atual_Text);
			System.out.println("Pass : Questions caption is Displayed");
		}

		//Checking Questions Should not be > 10
		List<WebElement> QuestionsCount = driver.findElements(By.xpath("//table[@id='question_table']/tbody/tr"));
		int TotalQuestionsCount = QuestionsCount.size();
		System.out.println("Total Count of Questions are : " + TotalQuestionsCount);
		Assert.assertEquals(TotalQuestionsCount, 10);
		System.out.println("Pass : Pre defined 10 Survey Questions are displayed");


		if(AddQuestionBTN.isDisplayed() && Notes.isDisplayed() && ResponseRequiredCheckBoxBTN.isDisplayed() && SubmitBTN.isDisplayed())
		{
			System.out.println("Pass : Add A Question Button is Displayed");
			System.out.println("Pass : Note: Each question will have 5 options in the following format. 1 being low and 5 being the highest score: is Displayed");
			System.out.println("Pass : Response Required Check Box is Displayed");
			System.out.println("Pass : Submit button is Displayed");
		}

		//Checking 5 Radio buttons are displayed
		List<WebElement> RadioBTNs = driver.findElements(By.xpath("//input[@type='radio']"));
		int RadioBTNsCount = RadioBTNs.size();
		Assert.assertEquals(5, RadioBTNsCount);
		System.out.println("Pass : 5 Radio Buttons are Displayed");

		//Checking the Response Required
		WebElement ResposeRequired = driver.findElement(By.xpath("//label[text()='Response Required']"));
		if(ResposeRequired.isDisplayed())
		{
			System.out.println("Pass : Response Required is Displayed");
		}
	}


	public void VerifyAddNewQuestionPageIsDisplayed(WebDriver driver)
	{

		try
		{
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			WebElement AddNewQuestion = driver.findElement(By.xpath("//div[@class='modal-body col-xs-height p-t-10']/h3[contains(text(),'Add New Question')]"));
			if(AddNewQuestion.isDisplayed())
			{
				String Expected_text = AddNewQuestion.getText();
				String Actual_text = "Add New Question";
				Assert.assertEquals(Expected_text, Actual_text);
			}

			//Question Label
			WebElement QuestionLabel = driver.findElement(By.xpath("//label[@for='survey_question_question']"));
			if(QuestionLabel.isDisplayed())
			{
				System.out.println("Pass : Question Text Box is Displayed");
			}

			if(Question.isDisplayed() && SubmitBTN1.isDisplayed())
			{
				System.out.println("Pass : Add New Question Page is Displayed");
			}
		}catch (StaleElementReferenceException e) {

			System.out.println(e);
		}

	}

	public void VerifyCustomQuestionSavedsuccessfullySuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccssMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccssMSG)).isDisplayed())
		{
			String Expected_Text = SuccssMSG.getText();
			String Actual_Text = "Custom Question saved successfully";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Custom Question saved successfully Success Message is Displayed");

		}
	}

	public void VerifyQuestionCantBeBlankErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		SoftAssert softAssertion= new SoftAssert();
		WebElement ErrorMSG = driver.findElement(By.xpath("//label[@class='error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "Question can't be blank";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Question can't be blank Error Message is Displayed");
		}
		softAssertion.assertTrue(false);
	}

	public void VeriftyCustomQuestionRemovedSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		SoftAssert softAssertion= new SoftAssert();
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Expected_text = ErrorMSG.getText();
			String Actual_text = "Custom Question removed successfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Custom Question removed successfully. Error Message is Displayed");

			//Clicking on the cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}
		softAssertion.assertTrue(false);
	}

	public void VeriftyQuestionsAddedToAuditTypeSuccessfullyMsgIsDisplayed(WebDriver driver)
	{
		SoftAssert softAssertion= new SoftAssert();
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(SuccessMSG.isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "Questions added to audit type successfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Questions added to audit type successfully Success Message is Displayed");

			//Clicking on the cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}

		softAssertion.assertTrue(false);
	}

	public void VerifyAuditAcceptedSuccesfullyMSGIsDisplayed(WebDriver driver)
	{
		SoftAssert softAssertion= new SoftAssert();
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(SuccessMSG.isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "Audit accepted succesfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Audit accepted succesfully Success Message is Displayed");

			//Clicking on the cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}

		softAssertion.assertTrue(false);
	}

	public void VerifyAuditSubmittedSuccessfullyMSGIsDisplayed(WebDriver driver)
	{
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(SuccessMSG.isDisplayed())
		{
			String Expected_text = SuccessMSG.getText();
			String Actual_text = "Audit submitted successfully";
			Assert.assertEquals(Expected_text, Actual_text);
			System.out.println("Pass : Audit submitted successfully Success Message is Displayed");

			//Clicking on the cancel Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button")).click();
		}

	}
	
	public void VerifyPleaseSelectAtleastOneSurveyQuestionAlertMessageIsDisplayed(WebDriver driver)
	{
		WebDriverWait  wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String Actual_Text = alert.getText();
		String Expected_Text = "Please select atleast one survey question";
		Assert.assertEquals(Actual_Text, Expected_Text, "Alert Message is Wrong");
		System.out.println("Pass : Please select atleast one survey question Alert Message is Displayed");
		chiledTest.log(Status.INFO, "Please select atleast one survey question Alert Message is Displayed");
		
		//Accepting Alert
		alert.accept();
	
	}
	
	
}

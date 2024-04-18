package pom;


import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class PredefinedCheckListPageTest {

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clicking on the Check Point Under Side Menu//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Check Points']
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='Check Points']")
	private WebElement CheckPoints;

	//Clicking on the Predefined Checklist from side menu
	@FindBy(xpath="//li[@class='open active']/ul/li/a/span[text()='Predefined Checklists']")
	private WebElement PredefinedChecklist;

	//Passing the Values to Search Box
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBTN;

	//Clicking on the first Predefined checklist view Button
	@FindBy(xpath="//table[@id='tableWithSearch']/tbody/tr[1]/td[5]/a[1]")
	private WebElement FirstViewBTN;

	//Clicking on the first Predefined checklist Add My Account Button
	@FindBy(xpath="//table[@id='tableWithSearch']/tbody/tr[1]/td[5]/a[2]")
	private WebElement FirstAddMyAccountBTN;

	//Clicking on the CloseButton
	@FindBy(xpath="//i[@class='pg-close fs-14']")
	private WebElement CloseBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//button[@class='btn btn-default btn-block cancel']")
	private WebElement CancelBTN;

	//clicking on the Ok Button
	@FindBy(xpath="//button[@class='btn btn-primary btn-block merge_group']")
	private WebElement OKBTN;

	//Passing the values to Add to My account as text field
	@FindBy(xpath="//input[@id='group_name']")
	private WebElement TextBox;

	public PredefinedCheckListPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickCheckPoints(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CheckPoints)).click();
	}
	
	public void ClickPredefinedChecklist(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PredefinedChecklist));
		Actions action = new Actions(driver);	
		action.moveToElement(PredefinedChecklist).click().build().perform();	
	}

	public void SetSearchButton(String SP)
	{
		SearchBTN.clear();
		SearchBTN.sendKeys(SP);
		System.out.println("Searched Predefined Checklist is : " + SP);
	}

	public void ClickFirstViewBTN()
	{
		FirstViewBTN.click();
	}

	public void ClickFirstAddMyAccountBTN()
	{
		FirstAddMyAccountBTN.click();
	}

	public void ClickCloseBTN()
	{
		CloseBTN.click();
	}

	public void ClickCancelBTN()
	{
		CancelBTN.click();
	}

	public void ClickOKBTN() throws InterruptedException
	{
		Thread.sleep(1000);
		OKBTN.click();
	}

	public void SetTextBox(String AT) throws InterruptedException
	{
		Thread.sleep(2000);
		TextBox.sendKeys(AT);
		System.out.println("Entered Add the checklist to my account as is : " + AT);	
	}

	public void VerifyPredefinedChecklistPageIsDisplayed(WebDriver driver)
	{
		SoftAssert softAssertion= new SoftAssert();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Checking the Predefined Checklist header is displayed
		WebElement PredefinedHeader = driver.findElement(By.xpath("//a[text()='PREDEFINED CHECKLIST']"));
		if(PredefinedHeader.isDisplayed())
		{
			String Actual_text = PredefinedHeader.getText();
			String Expected_text = "PREDEFINED CHECKLIST";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : PREDEFINED CHECKLIST Header is Dispalyed");
		}

		//Checking the Search Button
		WebElement SearchBTN = driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block']"));
		if(SearchBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Search Button is Displayed");
		}

		//Checking select Country drop down is displaying
		WebElement SelectCountry = driver.findElement(By.xpath("//div[@id='s2id_predefined_check_point_country_id']//a[contains(@class,'select2-choice')]"));
		if(SelectCountry.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Country drop down is Displayed");
		}

		//Checking Select industry drop down is displaying
		WebElement SelectIndustry = driver.findElement(By.xpath("//div[@id='s2id_predefined_check_point_industry_id']//a[contains(@class,'select2-choice')]"));
		if(SelectIndustry.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Industry drop down is Displayed");
		}

		//checking Select Sector drop down is displaying
		WebElement SelectSector = driver.findElement(By.xpath("//div[@id='s2id_predefined_check_point_sector_id']//a[contains(@class,'select2-choice')]"));
		if(SelectSector.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Sector drop down is Displayed");
		}

		//Checking Search Text field is displayed
		WebElement SearchTextField = driver.findElement(By.xpath("//input[@class='form-control']"));
		if(SearchTextField.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Search Text Field is Displayed");
		}

		//Checking Search Row text field is Displayed
		WebElement Row = driver.findElement(By.xpath("//select[@name='tableWithSearch_length']"));
		if(Row.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Row Search Text Field is Displayed");
		}

		//checking option 5 is displaying 
		WebElement FiveOption = driver.findElement(By.xpath("//select[@class='form-control']/option[@value='5']"));
		if(FiveOption.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Option five is Displayed");
		}

		//Checking Show text is displaying
		WebElement show = driver.findElement(By.xpath("//label[text()='Show ']"));
		if(show.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Show Text is Displayed");
		}

		//Checking the Row Text is displaying
		WebElement Rows = driver.findElement(By.xpath("//label[text()=' Rows']"));
		if(Rows.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Rows is Displayed");
		}


		//Checking Country in header
		WebElement Country = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[1]"));
		if(Country.isDisplayed())
		{
			String Actual_Text = Country.getText();
			String Expected_Text = "COUNTRY";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Country is Displayed");
		}

		//Checking Industry in header
		WebElement Industry = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[2]"));
		if(Industry.isDisplayed())
		{
			String Actual_Text = Industry.getText();
			String Expected_Text = "INDUSTRY";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Industry is Displayed");
		}

		//Checking Sector in header
		WebElement Sector = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[3]"));
		if(Sector.isDisplayed())
		{
			String Actual_Text = Sector.getText();
			String Expected_Text = "SECTOR";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Sector is Displayed");
		}

		//Checking Checklist 
		WebElement Checklist = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[4]"));
		if(Checklist.isDisplayed())
		{
			String Actual_Text = Checklist.getText();
			String Expected_Text = "CHECKLIST";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Checklist is Displayed");
		}

		//Checking Actions 
		WebElement Actions = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[5]"));
		if(Actions.isDisplayed())
		{
			String Actual_Text = Actions.getText();
			String Expected_Text = "ACTIONS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Actions is Displayed");
		}

		//Checking view button
		WebElement ViewBTN = driver.findElement(By.xpath("//a[@title='Check list details']"));
		if(ViewBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : view Buttons are displyed");
		}

		//Checking view button
		WebElement AddToMyAccountBTN = driver.findElement(By.xpath("//a[@class='btn grop_name_popup']"));
		if(AddToMyAccountBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Add to My Account Buttons are displyed");
		}

		//checking Select country options are displayed
		driver.findElement(By.xpath("//span[text()='Select Country']")).click();
		WebElement Selectcountryoptions = driver.findElement(By.xpath("//ul[@id='select2-results-5']/li[2]"));
		if(wait.until(ExpectedConditions.visibilityOf(Selectcountryoptions)).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Country options are Displyed");
		}

		//Clicking on the Select country 1st option

		WebElement first = driver.findElement(By.xpath("//ul[@id='select2-results-5']/li[1]"));
		wait.until(ExpectedConditions.visibilityOf(first)).click();


		//checking Select industry options are displayed
		driver.findElement(By.xpath("//span[text()='Select Industry']")).click();

		WebElement SelectIndustryOptions = driver.findElement(By.xpath("//ul[@id='select2-results-6']/li[2]"));
		if(wait.until(ExpectedConditions.visibilityOf(SelectIndustryOptions)).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Country options are Displyed");
		}

		//Clicking on the Select country 1st option

		WebElement firstOption = driver.findElement(By.xpath("//ul[@id='select2-results-6']/li[1]"));
		wait.until(ExpectedConditions.visibilityOf(firstOption)).click();


		//checking Select Sector options are displayed
		driver.findElement(By.xpath("//span[text()='Select Sector']")).click();

		WebElement SelectSector1 = driver.findElement(By.xpath("//ul[@id='select2-results-7']/li[2]"));
		if(wait.until(ExpectedConditions.visibilityOf(SelectSector1)).isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Select Country options are Displyed");
		}

		//Clicking on the Select country 1st option

		WebElement ClickfirstOption = driver.findElement(By.xpath("//ul[@id='select2-results-7']/li[1]"));
		wait.until(ExpectedConditions.visibilityOf(ClickfirstOption)).click();

		softAssertion.assertTrue(false);
	}	



	public void VerifyPredefinedGroupPageIsDisplayed(WebDriver driver)
	{
		SoftAssert softAssertion= new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Predefined Group Header
		WebElement PG = driver.findElement(By.xpath("//h5[@class='text-primary ']"));
		if(wait.until(ExpectedConditions.visibilityOf(PG)).isDisplayed())
		{
			String Actual_Text = PG.getText();
			String Expected_Text = "Predefined Group";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Predefined Group page is Displayed");
		}

		//Checking the group type
		WebElement GT = driver.findElement(By.xpath("//div[@class='form-group form-group-default']"));
		WebElement GTLabel = driver.findElement(By.xpath("//div[@class='form-group form-group-default']/label"));
		WebElement GT2 = driver.findElement(By.xpath("//div[@class='form-group form-group-default']/label/following-sibling::div"));
		if(GT.isDisplayed() && GTLabel.isDisplayed() && GT2.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Group Type is Displayed");
		}

		//Checking the group Name
		WebElement GN = driver.findElement(By.xpath("//div[contains(@class,'modal-body col-xs-height p-t-10')]"));
		WebElement GNLabel = driver.findElement(By.xpath("//div[@class='form-group form-group-default ']/label"));

		if(GN.isDisplayed() && GNLabel.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Group Type is Displayed");
		}

		//checking the show
		WebElement show = driver.findElement(By.xpath("//div[@id='modalSlideLeft']//div[@id='tableWithSearch_length']//label[1]"));
		if(show.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Show and Rows are Displayed");
		}

		//checking the Search Box
		WebElement Search = driver.findElement(By.xpath("//div[contains(@class,'show_group')]//input[contains(@type,'search')]"));
		if(Search.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Search Text Filed is Displayed");
		}

		//Checking the checklist table
		WebElement Checklist = driver.findElement(By.xpath("//div[contains(@class,'show_group')]//table[@id='tableWithSearch']"));
		if(Checklist.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Checklist are Displayed");
		}

		//Checking the Close Button 
		WebElement CloseBTN = driver.findElement(By.xpath("//i[@class='pg-close fs-14']"));
		if(CloseBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : CloseBTN is Displayed");
		}

		softAssertion.assertTrue(false);

	}


	public void VerifyAddtheChecklistToMyAccountAsisDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//checking the  Add the checklist to my account as header
		WebElement header = driver.findElement(By.xpath("//div[@class='modal-header']/h5"));
		if(wait.until(ExpectedConditions.visibilityOf(header)).isDisplayed())
		{
			String  Actual_Text = header.getText();
			String Expected_Text = "Add the checklist to my account as";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass :  Add the checklist to my account as pop up is Displayed");
		}

		//Checking the Text filed
		WebElement textfield = driver.findElement(By.xpath("//div[@class='form-group form-group-default required']"));
		if(textfield.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Text Field is Dispalyed");
		}

		//Checking the Ok Button
		WebElement OKBTN = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block merge_group']"));
		if(OKBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Ok Button is Dispalyed");
		}

		//Checking the Cancel Button
		WebElement CancelBTN = driver.findElement(By.xpath("//button[@class='btn btn-default btn-block cancel']"));
		if(CancelBTN.isDisplayed())
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Cancel Button is Dispalyed");
		}
	}

	public void VerifyMandatoryErrorMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//checking this is Required Error Message
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@id='group_name_error']"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_text = ErrorMSG.getText();
			String Expected_text = "This field is required.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : This field is required. Error Message is Displayed");
		}
	}

	public void VerifyGroupCreatedSuccessfullySuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_text = SuccessMSG.getText();
			String Expected_text = "Group created successfully.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : Group created successfully. Success Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-success']/button[@class='close']")).click();
		}

	}

	public void VerifyGroupNotCreatedSuccessfullySuccessMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//checking this is Required Error Message
		WebElement ErrorMSG = driver.findElement(By.xpath("//div[@class='alert alert-danger']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(ErrorMSG)).isDisplayed())
		{
			String Actual_text = ErrorMSG.getText();
			String Expected_text = "Please enter a unique name.";
			Assert.assertEquals(Actual_text, Expected_text);
			System.out.println("Pass : .success Message is Displayed");

			//clicking on the Close Button
			driver.findElement(By.xpath("//div[@class='alert alert-danger']/button[@class='close']")).click();
		}

	}
}


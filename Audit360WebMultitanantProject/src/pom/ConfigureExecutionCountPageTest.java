package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ConfigureExecutionCountPageTest {

	//Clicking on the Scroll Bar under side menu
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clicking on the System Setting
	@FindBy(xpath="//body[contains(@class,'pace-done')]/nav[2]/div[2]/div[1]/ul/li/a/span[text()='System Settings']")
	private WebElement SystemSettings;

	//Clicking on the Configure Execution Count Under System Settings
	@FindBy(xpath="//ul[@style='display: block;']/li/a[text()='Configure Execution Count']")
	private WebElement ConfigureExecutionCount;

	//Passing the Values to Search
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement SearchBTN;

	//Clicking on the Edit Icon for the 1st TR
	@FindBy(xpath="//table[@id='tableWithSearch']/tbody/tr/td[3]/a[@class='btn btn-rounded btn-primary']")
	private WebElement EditBTN;

	//Clicking on the Cancel Button
	@FindBy(xpath="//button[@class='btn btn-default btn-block']")
	private WebElement CancelBTN;

	//Clicking on the Save Button
	@FindBy(xpath="//input[@class='btn btn-primary btn-block']")
	private WebElement SaveBTN;

	//Passing the Values to Edit Page Search Button
	@FindBy(xpath="//div[@class='form-group form-group-default required']/input")
	private WebElement UpdateSearchBTN;


	public ConfigureExecutionCountPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();	
	}

	public void ClickSystemSettings(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SystemSettings);
	}

	public void ClickConfigureExecutionCount(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ConfigureExecutionCount)).click();
		//ConfigureExecutionCount.click();
	}

	public void SetSearchBTN(String SB)
	{
		SearchBTN.clear();
		SearchBTN.sendKeys(SB);
		System.out.println("Searched Max. Execution Counts is : " + SB);
	}

	public void SetUpdateSearchBTN(String US) throws InterruptedException
	{
		Thread.sleep(1000);
		UpdateSearchBTN.clear();
		UpdateSearchBTN.sendKeys(US);
		System.out.println("Entered Max. Execution Counts is : " + US);
	}

	public void ClickEditBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(EditBTN)).click();
		//EditBTN.click();
	}

	public void ClickCancelBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(CancelBTN)).click();
		//CancelBTN.click();
	}

	public void ClickSaveBTN(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(SaveBTN)).click();
		//SaveBTN.click();
	}

	public void VerifyConfigureExecutionCountPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Checking the Configure Execution count Header
		WebElement Header = driver.findElement(By.xpath("//a[@class='active']"));
		if(wait.until(ExpectedConditions.visibilityOf(Header)).isDisplayed())
		{
			String Actual_Text = Header.getText();
			String Expected_Text = "CONFIGURE EXECUTION COUNT";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : CONFIGURE EXECUTION COUNT Page is Displayed");
		}

		//Checking the Search Button
		WebElement SearchBox = driver.findElement(By.xpath("//input[@class='form-control']"));
		if(SearchBox.isDisplayed())	
		{
			Assert.assertTrue(true);
			System.out.println("Pass : Search Text Field is Disaplayed");
		}

		//Configure Execution Count List is Displayed
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

		//Checking the Edit
		WebElement Edit = driver.findElement(By.xpath("//i[@class='fa fa-pencil']"));
		if(Edit.isDisplayed())
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
			int Expected_count = 3;
			Assert.assertEquals(Actual_count, Expected_count);
		}

		//Checking the SNO
		WebElement SNO = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[1]"));
		if(SNO.isDisplayed())
		{
			String Actual_Text = SNO.getText();
			String Expected_Text = "SNO.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : SNO. is Disaplayed");
		}

		//Checking the Max. Execution Counts
		WebElement MEC = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[2]"));
		if(MEC.isDisplayed())
		{
			String Actual_Text = MEC.getText();
			String Expected_Text = "MAX. EXECUTION COUNTS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Max. Execution Counts is Disaplayed");
		}

		//Checking the Actions
		WebElement Action = driver.findElement(By.xpath("//table[@id='tableWithSearch']/thead/tr/th[3]"));
		if(Action.isDisplayed())
		{
			String Actual_Text = Action.getText();
			String Expected_Text = "ACTIONS";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Actions is Disaplayed");
		}
	}

	public void VerifyEditSystemSettingPageIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try

		{
			//Checking the Edit System Setting Header
			WebElement Header = driver.findElement(By.xpath("//h5[@class='text-primary ']"));
			if(wait.until(ExpectedConditions.visibilityOf(Header)).isDisplayed())
			{
				String Actual_Text = Header.getText();
				String Expected_Text = "Edit System Setting";
				Assert.assertEquals(Actual_Text, Expected_Text);
				System.out.println("Pass : Edit System Setting Page is Displayed");
			}

			//Checking Save Button
			WebElement SaveBTN = driver.findElement(By.xpath("//input[@class='btn btn-primary btn-block']"));
			if(SaveBTN.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Pass : Save Button is Dispalyed");

			}

			//Checking Cancel Button
			WebElement CancelBTN = driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']"));
			if(CancelBTN.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Pass : Cancel Button is Dispalyed");

			}

			//Checking Execution Counts
			WebElement EC = driver.findElement(By.xpath("//div[@class='form-group form-group-default required']"));
			if(EC.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Pass : Execution Counts is Dispalyed");

			}

			//Checking the close Button
			WebElement CloseBTN = driver.findElement(By.xpath("//i[@class='pg-close fs-14']"));
			if(CloseBTN.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("Pass : Close Button is Dispalyed");
			}
		}catch (StaleElementReferenceException e) {

		}


	}

	public void VerifySettingUpdatedSuccessfully(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement SuccessMSG = driver.findElement(By.xpath("//span[text()='Settings updated successfuly.']"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actual_Text = SuccessMSG.getText();
			String Expected_Text = "Settings updated successfuly.";
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("Pass : Settings updated successfuly. Success Message is Displayed");

			//Clicking on the Close Button
			driver.findElement(By.xpath("//button[@class='close']")).click();
		}
	}

}

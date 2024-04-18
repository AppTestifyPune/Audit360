package scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.BaseTest;
import generic.Lib;
import pom.AnnexurePageTest;
import pom.LoginPageTest;

public class AnnexurePageSearchFunctonalityTest extends BaseTest {

	//Testing the Functionality of the Adding same Annexure Test
	@Test(priority=1)
	public void Search_Annexure_Test() throws InterruptedException
	{
		LoginPageTest l=new LoginPageTest(driver);

		AnnexurePageTest AT = new AnnexurePageTest(driver);

		parentTest = extent.createTest("Annexure Page Search Functionality Test", "Searching the Annexure Test");

		chiledTest = parentTest.createNode("Search Annexure Test");

		System.out.println("Search Annexure Test");

		WebDriverWait wait = new WebDriverWait(driver, 20);

		chiledTest.log(Status.INFO, "Entered Valid UserName and Valid Password");
		String un=Lib.getCellValue(XLPATH, "Login Credentials",3,0);
		l.setusername(un);

		String pw=Lib.getCellValue(XLPATH,"Login Credentials",3,1);
		l.setpassword(pw);

		//clicking on the Login Button
		l.ClickSigninBTN();
		chiledTest.log(Status.INFO, "Sigin Button is Clicked");

		//Verify Signed in Successfully Message is Displayed
		l.verifySignedInSuccessMsgIsDisplayed(driver);
		chiledTest.log(Status.INFO, "Signed in successfully. Success Message is Displayed");

		AT.ClickScrollBar(driver);

		//Clicking on the Annexure
		AT.ClickAnnexure(driver);
		chiledTest.log(Status.INFO, "Annexure is Clicked from Side Menu");

		//Clicking on the Annexures
		AT.ClickAddAnnexures(driver);
		chiledTest.log(Status.INFO, "Annexures is Clicked");

		//Clicking on the Annexure name drop down list
		AT.ClickAnnexureNameDropDown();

		//Passing the Values to Annexure Name
		String AN = Lib.getCellValue(XLPATH, "Annexure", 3, 0);
		AT.SetAnnexureNameDropDown(AN);

		AT.ClickMatched();

		//Verifying Annexures is Displayed
		AT.VerifyAnnexuresDisplayed();

		driver.navigate().refresh();

		//Selecting all the Groups name under Applied in Groups
		WebElement ListBox = driver.findElement(By.id("applied_groups"));
		Select select = new Select(ListBox);
		List<WebElement> alloptions = select.getOptions();
		for(int i=1; i<alloptions.size(); i++)
		{
			WebElement ClickAllOptions = alloptions.get(i);
			String AllText = ClickAllOptions.getText();
			System.out.println("Selected Group name is : " + AllText);

			ClickAllOptions.click();

		}

		//Verifying Annexures is Displayed
		AT.VerifyAnnexuresDisplayed();

		driver.navigate().refresh();

		//Selecting all the Audit Type name under Applied in Audit Type
		WebElement ListBox1 = driver.findElement(By.id("applied_audit_types"));
		Select select1 = new Select(ListBox1);
		List<WebElement> alloptions1 = select1.getOptions();
		for(int i=1; i<alloptions1.size(); i++)
		{
			WebElement ClickAllOptions = alloptions1.get(i);
			String AllText = ClickAllOptions.getText();
			System.out.println("Selected Group name is : " + AllText);

			ClickAllOptions.click();

		}

		//Verifying Annexures is Displayed
		AT.VerifyAnnexuresDisplayed();


		System.out.println("********************************");

	}
}

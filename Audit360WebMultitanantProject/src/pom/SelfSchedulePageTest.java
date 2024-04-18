package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.BaseTest;

public class SelfSchedulePageTest extends BaseTest {
	
	//Clicking on the Create Scedule Button
		@FindBy(xpath="//a[@class='btn btn-primary']/b[text()='Create Schedule']")
		private WebElement CreateSceduleBTN;

		//Passing the Values to Audit Type
		@FindBy(xpath="//div[@id='s2id_my_audits_audit_types']//input[@type='text']")
		private WebElement AuditType;

		//Passing the Values to Auditee 
		@FindBy(xpath="//div[@id='s2id_my_audits_auditee_ids']//input[@type='text']")
		private WebElement Auditee;

		//Passing the Values to Execution Status
		@FindBy(xpath="//div[@id='s2id_my_audits_execution_status']//input[@type='text']")
		private WebElement ExecutionStatus;

		//Passing the Values to From Date
		@FindBy(xpath="//input[@id='my_audits_start_date']")
		private WebElement FromDate;

		//Passing the Values to From Date
		@FindBy(xpath="//input[@id='my_audits_end_date']")
		private WebElement EndDate;

		//Clicking on the Matched
		@FindBy(xpath="//span[@class='select2-match']")
		private WebElement Matched;
		
		

}

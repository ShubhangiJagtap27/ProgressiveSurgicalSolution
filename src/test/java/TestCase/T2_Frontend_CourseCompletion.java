package TestCase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestBase.BaseClass;
import PageObject.Frontend_CourseCompletion;

public class T2_Frontend_CourseCompletion extends BaseClass {
	
	Actions ac;
	String BaseURL;
	String adminUsername;
	String adminPassword;
	Frontend_CourseCompletion fl;
	
	@Parameters({ "SiteURL","AdminUsername", "AdminPassword" })
	@BeforeClass
	public void BeforeClass(String SiteURL, String AdminUsername, String AdminPassword) {
		fl = new Frontend_CourseCompletion(driver);
		adminUsername = AdminUsername;
	    adminPassword = AdminPassword;	
	    BaseURL = SiteURL;
	    
		
	}
@Test
    public void T2_Frontend_Course_Completion() throws Exception {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	SoftAssert softAssert = new SoftAssert();
	fl.loginToUser(driver, BaseURL, adminUsername, adminPassword);
	driver.get(BaseURL + "course-progress-certificates/");
	fl.SearchIcon.click();
	String Name = "Annual Training"; 
	fl.SearchCourseName.sendKeys(Name);
	executor.executeScript("window.scrollBy(0,250)");
	Thread.sleep(1000);
	fl.SearchBtnCouses.click();
	Thread.sleep(500);
	executor.executeScript("arguments[0].click();",fl.AnnualTrainingSelect);
	
	executor.executeScript("arguments[0].click();",fl.StartAnnualTrainingQuiz);

	executor.executeScript("arguments[0].click();",fl.AT_Quiz1);

	executor.executeScript("arguments[0].click();",fl.AT_Quiz2);

	executor.executeScript("arguments[0].click();",fl.AT_Quiz3);

	executor.executeScript("arguments[0].click();",fl.AT_Quiz4);

	executor.executeScript("arguments[0].click();",fl.AT_Quiz5);

	fl.FinishCourseExam.click();
	Thread.sleep(1000);
	executor.executeScript("arguments[0].click();",fl.CompleteCourseCert);

	executor.executeScript("arguments[0].click();",fl.DownloadCert);
	
	
//	driver.get(BaseURL + "course-progress-certificates/");
	
	System.out.println("download Certificate Successfully.");
	driver.get(BaseURL + "course-progress-certificates/");
	Actions action = new Actions(driver);
	action.moveToElement(fl.AnnualTrainingSelect).build().perform();
	
	
	softAssert.assertTrue(fl.DownloadCert.size() == 1, "Certifcate is Valid");


	softAssert.assertAll();
}
}

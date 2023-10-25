package LD;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.Frontend_CourseCompletion;
import PageObject.LD_Lesson_Builder_POM;
import TestBase.BaseClass;

public class LD_Create_Lesson {

	WebDriver driver;
	LD_Lesson_Builder_POM LD_LB;
	Frontend_CourseCompletion fl;
	String baseURL;
	String adminU;
	String adminP;

	String LessonTitle = "Z_IR_Automation_LD_Lesson";

	@Parameters({"SiteURL", "AdminUsername", "AdminPassword" })
	@BeforeClass

	public void DriverSetUp(String siteURL, String username, String password)
			throws Exception {
		driver = BaseClass.driver;

		// Initializing LD_Lesson Page Object
		LD_LB = new LD_Lesson_Builder_POM(driver);

		// Initializing Overview Settings Object

		fl = new Frontend_CourseCompletion(driver);
		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;

		// Admin Login
		fl.loginToUser(driver, baseURL, adminU, adminP);

	}

	/**
	 * Create LD Lesson with Video Progression Setting Enabled
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Create_LD_New_Lesson_Video_Progression() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// Visit_Profile_Tabin Settings
		LD_LB.Visit_Lesson_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-lessons");

		LD_LB.Add_New_LD_Lesson.click();
		Thread.sleep(2000);

		LD_LB.LD_Lesson_Title_Input.sendKeys(LessonTitle + " : Video");
		LD_LB.LD_Lesson_Content.sendKeys("This is Lesson Content");

		LD_LB.LD_Lesson_Settings_Tab.click();
		LD_LB.LD_LessonMaterial.click();
		Thread.sleep(1500);
		// For adding the content to the Lesson Material need to use iframe

		// Video Progression
		LD_LB.LD_Video_Progression.click();
		LD_LB.LD_Video_URL.clear();
		LD_LB.LD_Video_URL.sendKeys("https://www.youtube.com/embed/4Fu_gXdOMWM");
		LD_LB.LD_Display_Timing_AFTER.click();
		LD_LB.LD_Lesson_Auto_Complete.click();
		LD_LB.LD_Completion_delay.sendKeys("10");
		LD_LB.LD_Mark_Complete_Button.click();
		LD_LB.LD_Autostart.click();
		LD_LB.LD_Video_Controls_Display.click();
		LD_LB.LD_Video_Unfocused.click();
		LD_LB.LD_Video_Resume.click();

		// Lesson Access Settings
		LD_LB.LD_Sample_Lesson.click();
		LD_LB.LD_Lesson_Enrollment_Based.click();
		LD_LB.LD_Lesson_Enrollment_Based_days.clear();
		LD_LB.LD_Lesson_Enrollment_Based_days.sendKeys("30");

		// Publish Lesson
		executor.executeScript("arguments[0].click();",LD_LB.LD_Lesson_Publish_Button);
//		LD_LB.LD_Lesson_Publish_Button.click();
		
		softAssert.assertTrue(LD_LB.Lesson_Live_Text.size() == 1, "Lesson Not Published");

		// Navigate to Lesson List Page
		// driver.get("https://qa-ir.wisdmlabs.net/wp-admin/edit.php?post_type=sfwd-lesson");
		LD_LB.Visit_Lesson_List(baseURL);

		// Confirm if the created new course is added to course list
		LD_LB.LD_Search_Lesson.sendKeys(LessonTitle);
		LD_LB.LD_Search_Lesson_Button.click();

		softAssert.assertTrue(LD_LB.LD_LessonList(LessonTitle + " : Video").size() == 1,
				"Lesson Not Present in the Lesson List");

		softAssert.assertAll();

	}

	/**
	 * Create LD Lesson with Assignment Upload Setting Enabled
	 * 
	 * @throws Exception
	 */
	@Test(priority = 2)
	public void Create_LD_New_Lesson_Assignment_Upload() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		// Visit_Profile_Tabin Settings
		LD_LB.Visit_Lesson_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-lessons");
		

		LD_LB.Add_New_LD_Lesson.click();
		Thread.sleep(2000);

		LD_LB.LD_Lesson_Title_Input.sendKeys(LessonTitle + " : Assignment");
		LD_LB.LD_Lesson_Content.sendKeys("This is Lesson Content");

		LD_LB.LD_Lesson_Settings_Tab.click();
		LD_LB.LD_LessonMaterial.click();
		Thread.sleep(1500);
		// For adding the content to the Lesson Material need to use iframe

		// Assignment uploads
		Thread.sleep(1200);
		LD_LB.LD_Assignment_Upload.click();
		LD_LB.LD_File_Extensions.clear();
		LD_LB.LD_File_Extensions.sendKeys("PDF, CSV, XLS");
		LD_LB.LD_File_Size.clear();
		LD_LB.LD_File_Size.sendKeys("5MB");
		LD_LB.LD_Points_Switch.click();
		LD_LB.LD_Points.clear();
		LD_LB.LD_Points.sendKeys("10");
		LD_LB.LD_Manual_Grading.click();
		Thread.sleep(300);
		LD_LB.LD_Number_Of_Files.clear();
		LD_LB.LD_Number_Of_Files.sendKeys("3");
		LD_LB.LD_Allow_File_Deletion.click();

		// Lesson Access Settings
		LD_LB.LD_Lesson_Immediately.click();

		// Publish Lesson
//		LD_LB.LD_Lesson_Publish_Button.click();
		executor.executeScript("arguments[0].click();",LD_LB.LD_Lesson_Publish_Button);
		Thread.sleep(1000);
//		
		softAssert.assertTrue(LD_LB.Lesson_Live_Text.size() == 1, "Lesson Not Published");

		// Navigate to Lesson List Page
		// driver.get("https://qa-ir.wisdmlabs.net/wp-admin/edit.php?post_type=sfwd-lesson");
		LD_LB.Visit_Lesson_List(baseURL);

		// Confirm if the created new course is added to course list
		LD_LB.LD_Search_Lesson.sendKeys(LessonTitle);
		LD_LB.LD_Search_Lesson_Button.click();

		softAssert.assertTrue(LD_LB.LD_LessonList(LessonTitle + " : Assignment").size() == 1,
				"Lesson Not Present in the Lesson List");

		softAssert.assertAll();

	}

	/**
	 * Create LD Lesson with Timer Setting Enabled
	 * 
	 * @throws Exception
	 */
	@Test(priority = 3)
	public void Create_LD_New_Lesson_Timer() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// Visit_Profile_Tabin Settings
		LD_LB.Visit_Lesson_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-lessons");

		LD_LB.Add_New_LD_Lesson.click();
		Thread.sleep(2000);

		LD_LB.LD_Lesson_Title_Input.sendKeys(LessonTitle + " : Timer");
		LD_LB.LD_Lesson_Content.sendKeys("This is Lesson Content");

		LD_LB.LD_Lesson_Settings_Tab.click();
		LD_LB.LD_LessonMaterial.click();
		Thread.sleep(1500);
		// For adding the content to the Lesson Material need to use iframe

		Thread.sleep(1200);
		LD_LB.LD_Forced_Lesson_Timer.click();
		LD_LB.LD_FLT_Hours.clear();
		LD_LB.LD_FLT_Hours.sendKeys("1");
		LD_LB.LD_FLT_Minutes.clear();
		LD_LB.LD_FLT_Minutes.sendKeys("45");
		LD_LB.LD_FLT_Seconds.clear();
		LD_LB.LD_FLT_Seconds.sendKeys("30");

		// Lesson Access Settings
		LD_LB.LD_Lesson_Specific_date.click();
		Select select = new Select(LD_LB.LD_Lesson_SD_MM);
		select.selectByVisibleText("04-Apr");
		LD_LB.LD_Lesson_SD_DD.clear();
		LD_LB.LD_Lesson_SD_DD.sendKeys("07");
		LD_LB.LD_Lesson_SD_YYYY.clear();
		LD_LB.LD_Lesson_SD_YYYY.sendKeys("2024");
		LD_LB.LD_Lesson_SD_HH.clear();
		LD_LB.LD_Lesson_SD_HH.sendKeys("09");
		LD_LB.LD_Lesson_SD_MN.clear();
		LD_LB.LD_Lesson_SD_MN.sendKeys("30");

		// Publish Lesson
//		LD_LB.LD_Lesson_Publish_Button.click();
		executor.executeScript("arguments[0].click();",LD_LB.LD_Lesson_Publish_Button);
		softAssert.assertTrue(LD_LB.Lesson_Live_Text.size() == 1, "Lesson Not Published");

		// Navigate to Lesson List Page
		LD_LB.Visit_Lesson_List(baseURL);

		// Confirm if the created new course is added to course list
		LD_LB.LD_Search_Lesson.sendKeys(LessonTitle);
		LD_LB.LD_Search_Lesson_Button.click();

		softAssert.assertTrue(LD_LB.LD_LessonList(LessonTitle + " : Timer").size() == 1,
				"Lesson Not Present in the Lesson List");

		softAssert.assertAll();

	}
}

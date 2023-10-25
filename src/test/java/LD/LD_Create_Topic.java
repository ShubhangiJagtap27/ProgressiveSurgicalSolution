package LD;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestBase.BaseClass;
import PageObject.Frontend_CourseCompletion;
import PageObject.LD_Topic_Builder_POM;


public class LD_Create_Topic {
	
	WebDriver driver;
	LD_Topic_Builder_POM LD_TB;
	Frontend_CourseCompletion fl;
	String baseURL;
	String adminU;
	String adminP;
	String IRU;
	String IRP;
	String CourseTitle = "IR_Automation_LD_Course";
	String LessonTitle = "IR_Automation_Lesson 1";
	String TopicTitle = "A_IR_Automation_LD_Topic";
	
	
	@Parameters({ "SiteURL", "AdminUsername", "AdminPassword" })
	@BeforeClass
	public void DriverSetUp(String siteURL, String username, String password)
			throws Exception {
		driver = BaseClass.driver;

		
		// Initializing LD_Lesson Page Object
		LD_TB = new LD_Topic_Builder_POM(driver);

		fl = new Frontend_CourseCompletion(driver);
		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;

		// Admin Login
		fl.loginToUser(driver, baseURL, adminU, adminP);
		
	}
	
	@Test(priority = 1)
	public void Create_LD_New_Topic_Video() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		// Visit_Profile_Tab in Settings
		LD_TB.Visit_Topic_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-topic");
		
		LD_TB.Add_New_LD_Topic.click();
		Thread.sleep(2000);
		
		LD_TB.LD_Topic_Title_Input.sendKeys(TopicTitle+" : Video");
		LD_TB.LD_Topic_Content.sendKeys("This is Lesson Content");
		
		LD_TB.LD_Topic_Settings_Tab.click();
		LD_TB.LD_Topic_Material.click();
		Thread.sleep(1500);
		//For adding the content to the Topic Material need to use iframe
		
		//Video Progression
		LD_TB.LD_Topic_Video_Progression.click();
		LD_TB.LD_Topic_Video_URL.clear();
		LD_TB.LD_Topic_Video_URL.sendKeys("https://www.youtube.com/embed/4Fu_gXdOMWM");
		LD_TB.LD_Topic_Display_Timing_AFTER.click();
		LD_TB.LD_Topic_Auto_Complete.click();
		LD_TB.LD_Topic_Completion_delay.sendKeys("10");
		LD_TB.LD_Topic_Mark_Complete_Button.click();
		LD_TB.LD_Topic_Autostart.click();
		LD_TB.LD_Topic_Video_Controls_Display.click();
		LD_TB.LD_Topic_Video_Unfocused.click();
		LD_TB.LD_Topic_Video_Resume.click();
		
		//Topic Access Settings
//		LD_TB.LD_Topic_Associated_Course.click();
//		LD_TB.LD_Search_Topic_Associated_Course.sendKeys(CourseTitle);
//		LD_TB.LD_SelectSearched_Topic_Associated_Course(CourseTitle).click();
//		Thread.sleep(2000);
//		LD_TB.LD_Topic_Associated_Lesson.click();
//		LD_TB.LD_Search_Topic_Associated_Lesson.sendKeys(LessonTitle);
//		LD_TB.LD_SelectSearched_Topic_Associated_Lesson(LessonTitle).click();
		
		LD_TB.LD_Topic_Enrollment_Based.click();
		LD_TB.LD_Topic_Enrollment_Based_days.sendKeys("30");
		
		//Publish Lesson
//		LD_TB.LD_Topic_Publish_Button.click();
		executor.executeScript("arguments[0].click();",LD_TB.LD_Topic_Publish_Button);
		
		softAssert.assertTrue(LD_TB.Topic_Live_Text.size() == 1, "Topic Not Published");
		
		LD_TB.Visit_Topic_List(baseURL);
		
		//Confirm if the created new course is added to course list
		LD_TB.LD_Search_Topic.sendKeys(TopicTitle);
		LD_TB.LD_Search_Topic_Button.click();
		Thread.sleep(1500);
				
		softAssert.assertTrue(LD_TB.LD_TopicList(TopicTitle+" : Video").size() == 1, "Topic Not Present in the Topic List");
		
		softAssert.assertAll();

	}
	
	@Test(priority = 2)
	public void Create_LD_New_Topic_Assignment() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		// Visit_Profile_Tab in Settings
		LD_TB.Visit_Topic_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-topic");
		
		LD_TB.Add_New_LD_Topic.click();
		Thread.sleep(2000);
		
		LD_TB.LD_Topic_Title_Input.sendKeys(TopicTitle+" : Assignment");
		LD_TB.LD_Topic_Content.sendKeys("This is Lesson Content");
		
		LD_TB.LD_Topic_Settings_Tab.click();
		LD_TB.LD_Topic_Material.click();
		Thread.sleep(1500);
		//For adding the content to the Topic Material need to use iframe
		
		//Assignment Upload
		LD_TB.LD_Topic_Assignment_Upload.click();
		LD_TB.LD_Topic_File_Extensions.clear();
		LD_TB.LD_Topic_File_Extensions.sendKeys("PDF, CSV, XLS");
		LD_TB.LD_Topic_File_Size.clear();
		LD_TB.LD_Topic_File_Size.sendKeys("5MB");
		LD_TB.LD_Topic_Points_Switch.click();
		LD_TB.LD_Topic_Points.clear();
		LD_TB.LD_Topic_Points.sendKeys("10");
		LD_TB.LD_Topic_Manual_Grading.click();
		LD_TB.LD_Topic_Number_Of_Files.clear();
		LD_TB.LD_Topic_Number_Of_Files.sendKeys("3");
		LD_TB.LD_Topic_Allow_File_Deletion.click();
		
//		//Topic Access Settings
//		LD_TB.LD_Topic_Associated_Course.click();
//		LD_TB.LD_Search_Topic_Associated_Course.sendKeys(CourseTitle);
//		LD_TB.LD_SelectSearched_Topic_Associated_Course(CourseTitle).click();
//		Thread.sleep(2000);
//		LD_TB.LD_Topic_Associated_Lesson.click();
//		LD_TB.LD_Search_Topic_Associated_Lesson.sendKeys(LessonTitle);
//		LD_TB.LD_SelectSearched_Topic_Associated_Lesson(LessonTitle).click();
		
		LD_TB.LD_Topic_Immediately.click();
		
		//Publish Lesson
//		LD_TB.LD_Topic_Publish_Button.click();
		executor.executeScript("arguments[0].click();",LD_TB.LD_Topic_Publish_Button);
		
		softAssert.assertTrue(LD_TB.Topic_Live_Text.size() == 1, "Topic Not Published");
		
		LD_TB.Visit_Topic_List(baseURL);
		
		//Confirm if the created new course is added to course list
		LD_TB.LD_Search_Topic.sendKeys(TopicTitle);
		LD_TB.LD_Search_Topic_Button.click();
		Thread.sleep(1500);
				
		softAssert.assertTrue(LD_TB.LD_TopicList(TopicTitle+" : Assignment").size() == 1, "Topic Not Present in the Topic List");
		
		softAssert.assertAll();

	}
	
	@Test(priority = 3)
	public void Create_LD_New_Topic_Timer() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		// Visit_Profile_Tab in Settings
		LD_TB.Visit_Topic_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-topic");
		
		LD_TB.Add_New_LD_Topic.click();
		Thread.sleep(2000);
		
		LD_TB.LD_Topic_Title_Input.sendKeys(TopicTitle+" : Timer");
		LD_TB.LD_Topic_Content.sendKeys("This is Lesson Content");
		
		LD_TB.LD_Topic_Settings_Tab.click();
		LD_TB.LD_Topic_Material.click();
		Thread.sleep(1500);
		//For adding the content to the Topic Material need to use iframe

		//Forced Lesson Timer
		LD_TB.LD_Topic_Forced_Lesson_Timer.click();
		LD_TB.LD_Topic_FLT_Hours.clear();
		LD_TB.LD_Topic_FLT_Hours.sendKeys("1");
		LD_TB.LD_Topic_FLT_Minutes.clear();
		LD_TB.LD_Topic_FLT_Minutes.sendKeys("45");
		LD_TB.LD_Topic_FLT_Seconds.clear();
		LD_TB.LD_Topic_FLT_Seconds.sendKeys("30");
		
//		//Topic Access Settings
//		LD_TB.LD_Topic_Associated_Course.click();
//		LD_TB.LD_Search_Topic_Associated_Course.sendKeys(CourseTitle);
//		LD_TB.LD_SelectSearched_Topic_Associated_Course(CourseTitle).click();
//		Thread.sleep(2000);
//		LD_TB.LD_Topic_Associated_Lesson.click();
//		LD_TB.LD_Search_Topic_Associated_Lesson.sendKeys(LessonTitle);
//		LD_TB.LD_SelectSearched_Topic_Associated_Lesson(LessonTitle).click();
		
		LD_TB.LD_Topic_Specific_date.click();
		Select select = new Select(LD_TB.LD_Topic_SD_MM);
		select.selectByVisibleText("04-Apr");
		LD_TB.LD_Topic_SD_DD.clear();
		LD_TB.LD_Topic_SD_DD.sendKeys("07");
		LD_TB.LD_Topic_SD_YYYY.clear();
		LD_TB.LD_Topic_SD_YYYY.sendKeys("2024");
		LD_TB.LD_Topic_SD_HH.clear();
		LD_TB.LD_Topic_SD_HH.sendKeys("09");
		LD_TB.LD_Topic_SD_MN.clear();
		LD_TB.LD_Topic_SD_MN.sendKeys("30");
		//Publish Lesson
//		LD_TB.LD_Topic_Publish_Button.click();
		executor.executeScript("arguments[0].click();",LD_TB.LD_Topic_Publish_Button);
		softAssert.assertTrue(LD_TB.Topic_Live_Text.size() == 1, "Topic Not Published");
		
		LD_TB.Visit_Topic_List(baseURL);
		
		//Confirm if the created new course is added to course list
		LD_TB.LD_Search_Topic.sendKeys(TopicTitle);
		LD_TB.LD_Search_Topic_Button.click();
		Thread.sleep(1500);
				
		softAssert.assertTrue(LD_TB.LD_TopicList(TopicTitle+" : Timer").size() == 1, "Topic Not Present in the Topic List");
		
		softAssert.assertAll();

	}


}

package LD;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObject.Frontend_CourseCompletion;
import PageObject.LD_Quiz_Builder_POM;
import TestBase.BaseClass;

public class LD_Create_Quiz {

	WebDriver driver;
	LD_Quiz_Builder_POM LD_QB;
	Frontend_CourseCompletion fl;
	String baseURL;
	String adminU;
	String adminP;
	
	String CourseTitle = "PSS_Automation_LD_Course"; 
	String LessonTitle = "PSS_Automation_Lesson 1";
	String TopicTitle = "PSS_Automation_LD_Topic";
	String QuizTitle = "PSS_Automation_LD_Quiz";

	@Parameters({ "SiteURL", "AdminUsername", "AdminPassword" })
	@BeforeClass
	public void DriverSetUp(String SiteURL, String username, String password)
			throws Exception {
		driver = BaseClass.driver;

		fl = new Frontend_CourseCompletion(driver);
		// Setting User Details
		baseURL = SiteURL;
		adminU = username;
		adminP = password;

		// Admin Login
//		fl.loginToUser(driver, baseURL, adminU, adminP);

		// Initializing LD_Lesson Page Object
		LD_QB = new LD_Quiz_Builder_POM(driver);

	}

	@Test(priority = 1)
	public void Create_LD_New_Quiz() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		// Visit_Profile_Tab in Settings
		LD_QB.Visit_Quiz_List(baseURL);
		SoftAssert softAssert = new SoftAssert();
		driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-quiz");

		LD_QB.Add_New_LD_Quiz.click();
		Thread.sleep(2000);

		LD_QB.LD_Quiz_Title_Input.sendKeys(QuizTitle);
		LD_QB.LD_Quiz_Content.sendKeys("This is Quiz Content");

		LD_QB.LD_Quiz_Settings_Tab.click();

		/***** Quiz Access Settings *****/

//		//Associate Course
		LD_QB.LD_Quiz_Associated_Course.click();
		LD_QB.LD_Search_Quiz_Associated_Course.sendKeys(CourseTitle);
		LD_QB.LD_SelectSearched_Quiz_Associated_Course(CourseTitle).click();
		Thread.sleep(5000);
//		
//		//Associate Lesson/Topic
		LD_QB.LD_Quiz_Associated_Lesson.click();
		LD_QB.LD_Search_Quiz_Associated_Lesson.sendKeys(LessonTitle);
		LD_QB.LD_SelectSearched_Quiz_Associated_Lesson(LessonTitle).click();

		// Quiz Release Schedule
		LD_QB.LD_Quiz_Enrollment_Based.click();
		LD_QB.LD_Quiz_Enrollment_Based_days.sendKeys("30");

		// Quiz Prerequisites
		LD_QB.LD_Quiz_Prerequisite.click();
		LD_QB.LD_Quiz_Prerequisite.sendKeys("Annual Training");
		LD_QB.LD_SelectSearched_Quiz_Prerequisite("Annual Training").click();

		// Allowed Users
		LD_QB.LD_Quiz_Allow_Users.click();

		/***** Progression and Restriction Settings *****/

		// Passing Score
		Thread.sleep(500);
		LD_QB.LD_Quiz_Passing_Score.clear();
		LD_QB.LD_Quiz_Passing_Score.sendKeys("75");

		// Quiz Certificate
		LD_QB.LD_QuizCertificate.click();
		LD_QB.LD_SearchQuizCertificate.sendKeys("Annual Training (Licensed)");
		LD_QB.LD_SelectSearchedQuizCertificate("Annual Training (Licensed)").click();
//		executor.executeScript("arguments[0].click();",LD_QB.LD_SelectSearchedQuizCertificate("Annual training (Licensed)"));

		// Enabling Quiz Saving
		LD_QB.LD_Quiz_EnableQuizSaving.click();
		LD_QB.LD_Quiz_SaveQuizAfter.clear();
		LD_QB.LD_Quiz_SaveQuizAfter.sendKeys("30");

		// Restrict Quiz Retakes
		LD_QB.LD_Quiz_RestrictQuizRetake.click();
		LD_QB.LD_Quiz_NumberofRetries.sendKeys("2");
		LD_QB.LD_Quiz_RetriesApplicabletoDropdown.click();
		LD_QB.LD_SelectSearchedRetriesOption("Registered users only").click();

		// Question Completion
		LD_QB.LD_Quiz_QuestionCompletion.click();

		// Time Limit
		LD_QB.LD_Quiz_TimeLimit.click();
		LD_QB.LD_QLT_Hours.sendKeys("01");
		LD_QB.LD_QLT_Minutes.sendKeys("30");
		LD_QB.LD_QLT_Seconds.sendKeys("00");

		/***** Display and Content Option *****/

		// Quiz Material
		LD_QB.LD_Quiz_Material.click();
		LD_QB.LD_Quiz_MaterialArea.sendKeys("This is Quiz Material");

		// AutoStart
		LD_QB.LD_Topic_AutoStart.click();

		// Question Display
		LD_QB.LD_Question_Display.click();
		LD_QB.LD_One_Question_At_Once.click();
		LD_QB.LD_DisplayResultatEndOnly.click();
		LD_QB.LD_DisplayBackButton.click();
		LD_QB.LD_DisplayResultaftersumbittion.click();

		// Question Overview Table
		LD_QB.LD_Overview_Table.click();
		LD_QB.LD_Quiz_Summary.click();
		LD_QB.LD_Skip_Question.click();

		// Custom Question Ordering
		LD_QB.LD_Custom_Question_Ordering.click();
		Thread.sleep(1000);
		LD_QB.LD_Sort_By_Category.click();
		LD_QB.LD_Randomize_Order.click();
		LD_QB.LD_Display_all_Questions.click();

		// Additional Question Options
		LD_QB.LD_Additional_Question_Options.click();
		LD_QB.LD_Point_Value.click();
		LD_QB.LD_Question_Category.click();
		LD_QB.LD_Question_Position.click();
		LD_QB.LD_Question_Numbering.click();
		LD_QB.LD_Number_Answers.click();
		LD_QB.LD_Randomize_Answers.click();

		// Question Title
		LD_QB.LD_Quiz_Title.click();

		/***** Results Page Display *****/

		// Result Messages
		LD_QB.LD_Result_Messages.click();
		Thread.sleep(1000);

		// Restart Quiz Button
		LD_QB.LD_Restart_Quiz_Button.click();

		// Custom Results Display
		// LD_QB.LD_Custom_Results_Display.click(); // Default Enabled
		LD_QB.LD_Average_Score.click();
		LD_QB.LD_Category_Score.click();
		// LD_QB.LD_Overall_Score.click(); // Default Enabled
		// LD_QB.LD_No_of_Correct_Answers.click(); // Default Enabled
		// LD_QB.LD_Time_Spent.click(); // Default Enabled

		// Custom Answer FeedBack
		LD_QB.LD_Custom_Answers_FeedBack.click(); // By clicking the Custom Answers Feedback it will disable it as
													// Default Enabled
		// LD_QB.LD_Correct_Incorrect_Messages.click();
		// LD_QB.LD_Correct_Incorrect_Answers_Marks.click();
		// LD_QB.LD_View_Question_Button.click();

		// Publish Quiz
//		LD_QB.LD_Quiz_Publish_Button.click();
		executor.executeScript("arguments[0].click();",LD_QB.LD_Quiz_Publish_Button);
		softAssert.assertTrue(LD_QB.Quiz_Live_Text.size() == 1, "Quiz Not Published");

		LD_QB.Visit_Quiz_List(baseURL);

		// Confirm if the created new Quiz is added to Quiz list
		LD_QB.LD_Search_Quiz.sendKeys(QuizTitle);
		LD_QB.LD_Search_Quiz_Button.click();
		Thread.sleep(1500);

		
		softAssert.assertTrue(LD_QB.LD_QuizList(QuizTitle).size() == 1, "Quiz Not Present in the Quiz List");

		softAssert.assertAll();

	}

}

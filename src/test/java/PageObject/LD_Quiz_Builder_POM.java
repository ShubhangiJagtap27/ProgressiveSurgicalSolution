package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LD_Quiz_Builder_POM {
	
	WebDriver driver;

	// Constructor
	public LD_Quiz_Builder_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Visit Quiz List
	public void Visit_Quiz_List(String BaseURL) {
		driver.get("https://progtechops.wpengine.com/wp-admin/edit.php?post_type=sfwd-quiz");
	}
	
	// Add New Quiz via LD Course Creator Button
	@FindBy(xpath = "//a[@class='global-new-entity-button ']")
	public WebElement Add_New_LD_Quiz;

	//Search Quiz in List
	@FindBy(xpath = "//input[@id='post-search-input']")
	public WebElement LD_Search_Quiz;
	
	//Search Quiz button
	@FindBy(xpath = "//input[@id='search-submit']")
	public WebElement LD_Search_Quiz_Button;
	
	//Quiz in Quiz List
	public List<WebElement> LD_QuizList(String Quiz) {
		return driver.findElements(By.xpath("//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='" + Quiz + "']"));
	}
	
	//To click the course in the course list
	public WebElement LD_QuizSelector(String QuizTitle) {
		return driver.findElement(By.xpath("//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='" + QuizTitle + "']"));
	}
	
	// Quiz Page Tab
	@FindBy(xpath = "//button[@id='tab-post-body-content']")
	public WebElement LD_Topic_TopicPage_Tab;

	// Quiz Settings Tab
	@FindBy(xpath = "//button[@id='tab-sfwd-quiz-settings']")
	public WebElement LD_Quiz_Settings_Tab;
	
	// Quiz Builder Tab
	@FindBy(xpath = "//button[@id='tab-learndash_quiz_builder']")
	public WebElement LD_Quiz_Builder_Tab;

	// Quiz Publish Button
	@FindBy(xpath = "//input[@id='publish']")
	public WebElement LD_Quiz_Publish_Button;

	// This is Publish button which gets displayed after clicking on publish once
	@FindBy(xpath = "//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")
	public WebElement LD_Quiz_Publish_Button2;

	// Course Published Text(Course is now Live)
	@FindBy(xpath = "//div[@id='message']//p")
	public List<WebElement> Quiz_Live_Text;
	
	/*
	 * Quiz Page Tab
	 */

	// Quiz Title Input
	@FindBy(xpath = "//input[@id='title']")
	public WebElement LD_Quiz_Title_Input;

	// Add Quiz Content(When we navigate to Lessons edit page)
	@FindBy(xpath = "//iframe[@id='content_ifr']")
	public WebElement LD_Quiz_Content;
	
	/*
	 * Settings Tab
	 */
	
	/********Quiz Access Settings********/

	// Quiz Associated Course
	@FindBy(xpath = "//span[@title='Search or select a Course…']")
	public WebElement LD_Quiz_Associated_Course;

	// Search Quiz Associated Course
	@FindBy(xpath = "//body/span/span/span/input[1]")
	public WebElement LD_Search_Quiz_Associated_Course;

	// Select from searched Quiz Associated Courses
	public WebElement LD_SelectSearched_Quiz_Associated_Course(String AssociatedCourse) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + AssociatedCourse + "']"));
	}
	
	// Quiz Associated Lesson
	@FindBy(xpath = "//span[@title='Search or select a Lesson or Topic…']")
	public WebElement LD_Quiz_Associated_Lesson;

	// Search Quiz Associated Lesson
	@FindBy(xpath = "//body/span/span/span/input[1]")
	public WebElement LD_Search_Quiz_Associated_Lesson;

	// Select from searched Quiz Associated Lesson
	public WebElement LD_SelectSearched_Quiz_Associated_Lesson(String AssociatedLesson) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + AssociatedLesson + "']"));
	}
	
	// Quiz Release Schedule : Immediately
	@FindBy(xpath = "//label[@for='learndash-quiz-access-settings_lesson_schedule-']")
	public WebElement LD_Quiz_Immediately;

	// Quiz Release Schedule : Enrollement based
	@FindBy(xpath = "//label[@for='learndash-quiz-access-settings_lesson_schedule-visible_after']")
	public WebElement LD_Quiz_Enrollment_Based;
	// Enrollment based days
	@FindBy(xpath = "//input[@id='learndash-quiz-access-settings_visible_after']")
	public WebElement LD_Quiz_Enrollment_Based_days;
	
	//Quiz Prerequisites for this drop down we can search the Quiz on this same element
	@FindBy(xpath = "//textarea[@placeholder='Select an option']")
	public WebElement LD_Quiz_Prerequisite;
	
	// Select from searched Quiz Prerequisites
	public WebElement LD_SelectSearched_Quiz_Prerequisite(String QuizPrerequisite) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + QuizPrerequisite + "']"));
	}
	
	//Allow User Access
	@FindBy(xpath = "//label[@for='learndash-quiz-access-settings_startOnlyRegisteredUser-on']")
	public WebElement LD_Quiz_Allow_Users;
	
	/********Progression and Restriction Settings********/
	
	//Passing Score
	@FindBy(xpath = "//input[@id='learndash-quiz-progress-settings_passingpercentage']")
	public WebElement LD_Quiz_Passing_Score;
	
	// Quiz Certificate
	@FindBy(xpath = "//span[contains(text(),'Search or select a certificate…')]")
	public WebElement LD_QuizCertificate;

	// Search Quiz Certificate
	@FindBy(xpath = "//span[@title='Search or select a certificate…']") 
	public WebElement LD_SearchQuizCertificate;

	// Select from searched Certificates
	public WebElement LD_SelectSearchedQuizCertificate(String Certificate) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + Certificate + "']"));
	}
	
	//Enable Quiz Saving
	@FindBy(xpath = "//input[@id='learndash-quiz-progress-settings_quiz_resume']")
	public WebElement LD_Quiz_EnableQuizSaving;
	
	//Save Quiz data to the server every
	@FindBy(xpath = "//input[@id='learndash-quiz-progress-settings_quiz_resume_cookie_send_timer']")
	public WebElement LD_Quiz_SaveQuizAfter;
	
	//Restrict Quiz Retake
	@FindBy(xpath = "//input[@id='learndash-quiz-progress-settings_retry_restrictions']")
	public WebElement LD_Quiz_RestrictQuizRetake;
	
	//Number of Retries allowed
	@FindBy(xpath = "//input[@id='learndash-quiz-progress-settings_repeats']")
	public WebElement LD_Quiz_NumberofRetries;
	
	//Retries applicable to
	@FindBy(xpath = "//div[@data-parent-field='learndash-quiz-progress-settings_retry_restrictions_field']//div//div//span//span[@role='combobox']")
	public WebElement LD_Quiz_RetriesApplicabletoDropdown;

	// Search Retries option
	@FindBy(xpath = "//body/span/span/span/input[1]")
	public WebElement LD_Quiz_SearchRetriesOption;

	// Select from searched Retries
	public WebElement LD_SelectSearchedRetriesOption(String RetriesOption) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + RetriesOption + "']"));
	}
	
	//Question Completion
	@FindBy(xpath = "//label[@for='learndash-quiz-progress-settings_forcingQuestionSolve-on']")
	public WebElement LD_Quiz_QuestionCompletion;
	
	//Quiz Time Limit
	@FindBy(xpath = "//input[@id='learndash-quiz-progress-settings_quiz_time_limit_enabled']")
	public WebElement LD_Quiz_TimeLimit;
	// Timer Hours
	@FindBy(xpath = "(//input[@placeholder='HH'])[2]")
	public WebElement LD_QLT_Hours;

	// Timer Minutes
	@FindBy(xpath = "//input[@placeholder='MM']")
	public WebElement LD_QLT_Minutes;

	// Timer Seconds
	@FindBy(xpath = "//input[@placeholder='SS']")
	public WebElement LD_QLT_Seconds;
	
	/********Display and Content Option********/
	
	//Quiz Material
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_quiz_materials_enabled']")
	public WebElement LD_Quiz_Material;
	
	//Quiz Material Area
	@FindBy(xpath = "//textarea[@id='learndash-quiz-display-content-settings_quiz_materials']")
	public WebElement LD_Quiz_MaterialArea;
	
	//Topic AutoStart
	@FindBy(xpath = "//label[@for='learndash-quiz-display-content-settings_autostart-on']")
	public WebElement LD_Topic_AutoStart;
	
	//Question Display
	////div[@id='learndash-quiz-display-content-settings_quizModus_field']//div//span//span[@role='combobox']
	@FindBy(xpath = "//span[@title='One question at a time']")
	public WebElement LD_Question_Display;
	//Display Result at end only
	@FindBy(xpath = "//label[@for='learndash-quiz-display-content-settings_quizModus_single_feedback-end']")
	public WebElement LD_DisplayResultatEndOnly;
	//Display Back Button
	@FindBy(xpath = "//label[@for='learndash-quiz-display-content-settings_quizModus_single_back_button-on']")
	public WebElement LD_DisplayBackButton;
	//Display Result after each submitted answer
	@FindBy(xpath = "//label[@for='learndash-quiz-display-content-settings_quizModus_single_feedback-each']")
	public WebElement LD_DisplayResultaftersumbittion;
	
	//Question Display Option: One Question at a Time
	@FindBy(xpath = "//li[normalize-space()='One question at a time']")
	public WebElement LD_One_Question_At_Once;
	
	//Question Display Option: All questions at once
	@FindBy(xpath = "//li[normalize-space()='All questions at once (or paginated)']")
	public WebElement LD_All_Questions_At_Once;
	//Questions Per Page
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_quizModus_multiple_questionsPerPage']")
	public WebElement LD_Question_Per_Page;
	
	//Question Overview Table
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_showReviewQuestion']")
	public WebElement LD_Overview_Table;
	//Quiz Summary
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_quizSummaryHide']")
	public WebElement LD_Quiz_Summary;
	//Skip Question
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_skipQuestionDisabled']")
	public WebElement LD_Skip_Question;
	
	//Custom Question Ordering
	@FindBy(xpath = "//input[contains(@data-settings-sub-trigger,'ld-settings-sub-custom_sorting')]")
	public WebElement LD_Custom_Question_Ordering;
	//Sort By Category
	@FindBy(xpath = "//label[@for='learndash-quiz-display-content-settings_sortCategories-on']")
	public WebElement LD_Sort_By_Category;
	//Randomize Order
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_questionRandom']")
	public WebElement LD_Randomize_Order;
	//Display all Questions
	@FindBy(xpath = "//label[@for='learndash-quiz-display-content-settings_showMaxQuestion-']")
	public WebElement LD_Display_all_Questions;
	//Display Subset of Questions
	@FindBy(xpath = "//label[@for='learndash-quiz-display-content-settings_showMaxQuestion-on']")
	public WebElement LD_Display_Subset_of_Questions;
	
	//Additional Question Options
	@FindBy(xpath = "//input[@data-settings-sub-trigger='ld-settings-sub-custom_question_elements']")
	public WebElement LD_Additional_Question_Options;
	//Point Value
	@FindBy(xpath = "//input[contains(@data-settings-sub-trigger,'ld-settings-sub-showPoints')]")
	public WebElement LD_Point_Value;
	//Question Category
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_showCategory']")
	public WebElement LD_Question_Category;
	//Question Position
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_hideQuestionPositionOverview']")
	public WebElement LD_Question_Position;
	//Question Numbering
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_hideQuestionNumbering']")
	public WebElement LD_Question_Numbering;
	//Number Answers
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_numberedAnswer']")
	public WebElement LD_Number_Answers;
	//Randomize Answers
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_answerRandom']")
	public WebElement LD_Randomize_Answers;
	
	//Quiz Title
	@FindBy(xpath = "//input[@id='learndash-quiz-display-content-settings_titleHidden']")
	public WebElement LD_Quiz_Title;
	
	/********Results Page Display********/
	
	//Result Messages
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_resultGradeEnabled']")
	public WebElement LD_Result_Messages;
	
	//Restart Quiz Button
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_btnRestartQuizHidden']")
	public WebElement LD_Restart_Quiz_Button;
	//Custom Results Display
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_custom_result_data_display']")
	public WebElement LD_Custom_Results_Display;
	//Average Score
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_showAverageResult']")
	public WebElement LD_Average_Score;
	//Category Score
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_showCategoryScore']")
	public WebElement LD_Category_Score;
	//Overall Score
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_hideResultPoints']")
	public WebElement LD_Overall_Score;
	//No. of Correct Answers
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_hideResultCorrectQuestion']")
	public WebElement LD_No_of_Correct_Answers;
	//Time Spent
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_hideResultQuizTime']")
	public WebElement LD_Time_Spent;
	
	//Custom Answers FeedBack
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_custom_answer_feedback']")
	public WebElement LD_Custom_Answers_FeedBack;
	//Correct/Incorrect Messages
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_hideAnswerMessageBox']")
	public WebElement LD_Correct_Incorrect_Messages;
	//Correct/Incorrect Answers Marks
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_disabledAnswerMark']")
	public WebElement LD_Correct_Incorrect_Answers_Marks;
	//View Question Button
	@FindBy(xpath = "//input[@id='learndash-quiz-results-options_btnViewQuestionHidden']")
	public WebElement LD_View_Question_Button;
	

}

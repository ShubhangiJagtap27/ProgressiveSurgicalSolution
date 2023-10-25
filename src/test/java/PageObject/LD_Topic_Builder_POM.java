package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LD_Topic_Builder_POM {

	WebDriver driver;

	// Constructor
	public LD_Topic_Builder_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Visit Topic List
	public void Visit_Topic_List(String BaseURL) {
		driver.get(BaseURL + "wp-admin/edit.php?post_type=sfwd-topic");
	}

	// Add New Topic via LD Course Creator Button
	@FindBy(xpath = "//a[@class='global-new-entity-button ']")
	public WebElement Add_New_LD_Topic;

	// Search Topic in List
	@FindBy(xpath = "//input[@id='post-search-input']")
	public WebElement LD_Search_Topic;

	// Search Topic button
	@FindBy(xpath = "//input[@id='search-submit']")
	public WebElement LD_Search_Topic_Button;

	// Lesson in Topic List
	public List<WebElement> LD_TopicList(String Topic) {
		return driver.findElements(By.xpath("//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='" + Topic + "']"));
	}

	// To click the topic in the topic list
	public WebElement LD_TopicSelector(String TopicTitle) {
		return driver.findElement(By.xpath("//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='" + TopicTitle + "']"));
	}
	
	// Topic Page Tab
	@FindBy(xpath = "//button[@id='tab-post-body-content']")
	public WebElement LD_Topic_TopicPage_Tab;

	// Topic Settings Tab
	@FindBy(xpath = "//button[@id='tab-sfwd-topic-settings']")
	public WebElement LD_Topic_Settings_Tab;
	
	// Lesson Publish Button
	@FindBy(xpath = "//input[@id='publish']")
	public WebElement LD_Topic_Publish_Button;

	// This is Publish button which gets displayed after clicking on publish once
//	@FindBy(xpath = "//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")
//	public WebElement LD_Topic_Publish_Button2;

	// Course Published Text(Course is now Live)
	@FindBy(xpath = "//div[@id='message']//p")
	public List<WebElement> Topic_Live_Text;
	
	
	/*
	 * Topic Page Tab
	 */

	// Topic Title Input
	@FindBy(xpath = "//input[@id='title']") 
	public WebElement LD_Topic_Title_Input;

	// Add Topic Content(When we navigate to Lessons edit page)
	@FindBy(xpath = "//iframe[@id='content_ifr']")
	public WebElement LD_Topic_Content;

	// Settings Icon to open Topic Categories-Tags
	@FindBy(xpath = "//button[@aria-label='Settings']")
	public WebElement Topic_Settings_Icon;

	// Course Tab in Settings area
	@FindBy(xpath = "//button[@aria-label='Topic']")
	public WebElement Topic_Tab;
	
	/*
	 * Settings Tab
	 */

	// Topic Material
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_topic_materials_enabled']")
	public WebElement LD_Topic_Material;
	
	// Video Progression Switch
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_enabled']")
	public WebElement LD_Topic_Video_Progression;

	// Video URL
	@FindBy(xpath = "//textarea[@id='learndash-topic-display-content-settings_lesson_video_url']")
	public WebElement LD_Topic_Video_URL;

	// Display Timing - BEFORE
	@FindBy(xpath = "//label[@for='learndash-topic-display-content-settings_lesson_video_shown-BEFORE']")
	public WebElement LD_Topic_Display_Timing_BEFORE;

	// Display Timing - AFTER
	@FindBy(xpath = "//label[@for='learndash-topic-display-content-settings_lesson_video_shown-AFTER']")
	public WebElement LD_Topic_Display_Timing_AFTER;
	
	// Topic Auto Complete
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_auto_complete']")
	public WebElement LD_Topic_Auto_Complete;

	// Completion delay Input
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_auto_complete_delay']")
	public WebElement LD_Topic_Completion_delay;

	// Mark Complete Button
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_show_complete_button']")
	public WebElement LD_Topic_Mark_Complete_Button;

	// Autostart
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_auto_start']")
	public WebElement LD_Topic_Autostart;

	// Video Controls Display
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_show_controls']")
	public WebElement LD_Topic_Video_Controls_Display;

	// Video Pause on Window Unfocused
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_focus_pause']")
	public WebElement LD_Topic_Video_Unfocused;

	// Video resume
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_video_track_time']")
	public WebElement LD_Topic_Video_Resume;
	
	// Assignment Upload Switch
	@FindBy(xpath = "//label[@for='learndash-topic-display-content-settings_lesson_assignment_upload']//div")
	public WebElement LD_Topic_Assignment_Upload;

	// File Extensions
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_assignment_upload_limit_extensions']")
	public WebElement LD_Topic_File_Extensions;

	// File Size Limit
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_assignment_upload_limit_size']")
	public WebElement LD_Topic_File_Size;

	// Points Switch
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_assignment_points_enabled']")
	public WebElement LD_Topic_Points_Switch;

	// Points
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_assignment_points_amount']")
	public WebElement LD_Topic_Points;

	// Auto_Aprove_Grading
	@FindBy(xpath = "//label[@for='learndash-topic-display-content-settings_auto_approve_assignment-on']")
	public WebElement LD_Topic_Auto_Aprove_Grading;

	// Manual Grading
	@FindBy(xpath = "//label[@for='learndash-topic-display-content-settings_auto_approve_assignment-']")
	public WebElement LD_Topic_Manual_Grading;

	// Number Of Files
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_assignment_upload_limit_count']")
	public WebElement LD_Topic_Number_Of_Files;

	// Allow File Deletion
	@FindBy(xpath = "//input[@id='learndash-topic-display-content-settings_lesson_assignment_deletion_enabled']")
	public WebElement LD_Topic_Allow_File_Deletion;
	
	// Forced Lesson Timer
	@FindBy(xpath = "//label[@for='learndash-topic-display-content-settings_forced_lesson_time_enabled']//div")
	public WebElement LD_Topic_Forced_Lesson_Timer;

	// Timer Hours
	@FindBy(xpath = "//input[@name='learndash-topic-display-content-settings[forced_lesson_time][hh]']")
	public WebElement LD_Topic_FLT_Hours;

	// Timer Minutes
	@FindBy(xpath = "//input[@name='learndash-topic-display-content-settings[forced_lesson_time][mn]']")
	public WebElement LD_Topic_FLT_Minutes;

	// Timer Seconds
	@FindBy(xpath = "//input[@name='learndash-topic-display-content-settings[forced_lesson_time][ss]']")
	public WebElement LD_Topic_FLT_Seconds;
	
	//Topic Associated Course
	@FindBy(xpath = "//div[@id='learndash-topic-access-settings_course_field']//div//span//span[@role='combobox']")
	public WebElement LD_Topic_Associated_Course;

	// Search Associated Course
	@FindBy(xpath = "//body/span/span/span/input[1]")
	public WebElement LD_Search_Topic_Associated_Course;

	// Select from searched Associated Course
	public WebElement LD_SelectSearched_Topic_Associated_Course(String TopicAssociatedCourse) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + TopicAssociatedCourse + "']"));
	}
	
	// Topic Associated Lesson
	@FindBy(xpath = "//div[@id='learndash-topic-access-settings_lesson_field']//div//span//span[@role='combobox']")
	public WebElement LD_Topic_Associated_Lesson;

	// Search Associated Lesson
	@FindBy(xpath = "//body/span/span/span/input[1]")
	public WebElement LD_Search_Topic_Associated_Lesson;

	// Select from searched Associated Lesson
	public WebElement LD_SelectSearched_Topic_Associated_Lesson(String TopicAssociatedLesson) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + TopicAssociatedLesson + "']"));
	}

	// Topic Release Schedule : Immediately
	@FindBy(xpath = "//label[@for='learndash-topic-access-settings_lesson_schedule-']")
	public WebElement LD_Topic_Immediately;

	// Topic Release Schedule : Enrollement based
	@FindBy(xpath = "//label[@for='learndash-topic-access-settings_lesson_schedule-visible_after']")
	public WebElement LD_Topic_Enrollment_Based;
	// Enrollement based days
	@FindBy(xpath = "//input[@id='learndash-topic-access-settings_visible_after']")
	public WebElement LD_Topic_Enrollment_Based_days;
	
	// Lesson Release Schedule : Specific date
	@FindBy(xpath = "//label[@for='learndash-topic-access-settings_lesson_schedule-visible_after_specific_date']")
	public WebElement LD_Topic_Specific_date;
	@FindBy(xpath = "//select[@name='learndash-topic-access-settings[visible_after_specific_date][mm]']")
	public WebElement LD_Topic_SD_MM;
	@FindBy(xpath = "//input[@placeholder='DD']")
	public WebElement LD_Topic_SD_DD;
	@FindBy(xpath = "//input[@placeholder='YYYY']")
	public WebElement LD_Topic_SD_YYYY;
	@FindBy(xpath = "//input[@name='learndash-topic-access-settings[visible_after_specific_date][hh]']")
	public WebElement LD_Topic_SD_HH;
	@FindBy(xpath = "//input[@placeholder='MN']")
	public WebElement LD_Topic_SD_MN;

}

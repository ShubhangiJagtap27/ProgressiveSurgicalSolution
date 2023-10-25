package PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LD_Lesson_Builder_POM {

	WebDriver driver;

	// Constructor
	public LD_Lesson_Builder_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Visit Lessons List
	public void Visit_Lesson_List(String BaseURL) {
		driver.get(BaseURL + "wp-admin/edit.php?post_type=sfwd-lessons");
	}

	// Add New Lesson via LD Course Creator Button
	@FindBy(xpath = "//a[@class='global-new-entity-button ']")
	public WebElement Add_New_LD_Lesson;
	
	//Search Lesson in List
	@FindBy(xpath = "//input[@id='post-search-input']")
	public WebElement LD_Search_Lesson;
	
	//Search Lesson button
	@FindBy(xpath = "//input[@id='search-submit']")
	public WebElement LD_Search_Lesson_Button;
	
	//Lesson in Lesson List
	public List<WebElement> LD_LessonList(String Lesson) {
		return driver.findElements(By.xpath("//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='" + Lesson + "']"));
	}
	
	//To click the course in the course list
	public WebElement LD_LessonSelector(String LessonTitle) {
		return driver.findElement(By.xpath("//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='" + LessonTitle + "']"));
	}

	// Lesson Page Tab
	@FindBy(xpath = "//button[@id='tab-post-body-content']")
	public WebElement LD_Lesson_LessonPage_Tab;

	// Lesson Settings Tab
	@FindBy(xpath = "//button[@id='tab-sfwd-lessons-settings']")
	public WebElement LD_Lesson_Settings_Tab;

	// Lesson Publish Button
	@FindBy(xpath = "//input[@id='publish']")
	public WebElement LD_Lesson_Publish_Button;

	

	// Course Published Text(Course is now Live)
	@FindBy(xpath = "//div[@id='message']//p")
	public List<WebElement> Lesson_Live_Text;

	/*
	 * Lesson Page Tab
	 */

	// Lesson Title Input
	@FindBy(xpath = "//body/div/div/div[@role='main']/div/div/form[@action='post.php']/div/div/div/div/div/input[1]")
	public WebElement LD_Lesson_Title_Input;

	// Add Lesson Content(When we navigate to Lessons edit page)
	@FindBy(xpath = "//iframe[@id='content_ifr']")
	public WebElement LD_Lesson_Content;

	// Lesson Page Container(When we click on the Add Lesson Content )
	@FindBy(xpath = "//p[@aria-label='Empty block; start writing or type forward slash to choose a block']")
	public WebElement LD_Lesson_Content1;

	// Settings Icon to open Lesson Categories-Tags
	@FindBy(xpath = "//button[@aria-label='Settings']")
	public WebElement Lesson_Settings_Icon;

	// Course Tab in Settings area
	@FindBy(xpath = "//button[@aria-label='Lesson']")
	public WebElement Lesson_Tab;

	/*
	 * Settings Tab
	 */

	// Lesson Material
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_materials_enabled']")
	public WebElement LD_LessonMaterial;

	// Video Progression Switch
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_enabled']")
	public WebElement LD_Video_Progression;

	// Video URL
	@FindBy(xpath = "//textarea[@id='learndash-lesson-display-content-settings_lesson_video_url']")
	public WebElement LD_Video_URL;

	// Display Timing - BEFORE
	@FindBy(xpath = "//label[@for='learndash-lesson-display-content-settings_lesson_video_shown-BEFORE']")
	public WebElement LD_Display_Timing_BEFORE;

	// Display Timing - AFTER
	@FindBy(xpath = "//label[@for='learndash-lesson-display-content-settings_lesson_video_shown-AFTER']")
	public WebElement LD_Display_Timing_AFTER;

	// Lesson Auto Complete
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_auto_complete']")
	public WebElement LD_Lesson_Auto_Complete;

	// Completion delay Input
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_auto_complete_delay']")
	public WebElement LD_Completion_delay;

	// Mark Complete Button
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_show_complete_button']")
	public WebElement LD_Mark_Complete_Button;

	// Autostart
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_auto_start']")
	public WebElement LD_Autostart;

	// Video Controls Display
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_show_controls']")
	public WebElement LD_Video_Controls_Display;

	// Video Pause on Window Unfocused
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_focus_pause']")
	public WebElement LD_Video_Unfocused;

	// Video resume
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_video_track_time']")
	public WebElement LD_Video_Resume;

	// Assignment Upload Switch
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_assignment_upload']")
	public WebElement LD_Assignment_Upload;

	// File Extensions
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_assignment_upload_limit_extensions']")
	public WebElement LD_File_Extensions;

	// File Size Limit
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_assignment_upload_limit_size']")
	public WebElement LD_File_Size;

	// Points Switch
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_assignment_points_enabled']")
	public WebElement LD_Points_Switch;

	// Points
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_assignment_points_amount']")
	public WebElement LD_Points;

	// Auto_Aprove_Grading
	@FindBy(xpath = "//label[@for='learndash-lesson-display-content-settings_auto_approve_assignment-on']")
	public WebElement LD_Auto_Aprove_Grading;

	// Manual Grading
	@FindBy(xpath = "//label[@for='learndash-lesson-display-content-settings_auto_approve_assignment-']")
	public WebElement LD_Manual_Grading;

	// Number Of Files
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_assignment_upload_limit_count']")
	public WebElement LD_Number_Of_Files;

	// Allow File Deletion
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_lesson_assignment_deletion_enabled']")
	public WebElement LD_Allow_File_Deletion;

	// Forced Lesson Timer
	@FindBy(xpath = "//input[@id='learndash-lesson-display-content-settings_forced_lesson_time_enabled']")
	public WebElement LD_Forced_Lesson_Timer;

	// Timer Hours
	@FindBy(xpath = "//input[@placeholder='HH']")
	public WebElement LD_FLT_Hours;

	// Timer Minutes
	@FindBy(xpath = "//input[@placeholder='MM']")
	public WebElement LD_FLT_Minutes;

	// Timer Seconds
	@FindBy(xpath = "//input[@placeholder='SS']")
	public WebElement LD_FLT_Seconds;

	// Sample Lesson
	@FindBy(xpath = "//input[@id='learndash-lesson-access-settings_sample_lesson']")
	public WebElement LD_Sample_Lesson;

	// Lesson Release Schedule : Immediately
	@FindBy(xpath = "//label[@for='learndash-lesson-access-settings_lesson_schedule-']")
	public WebElement LD_Lesson_Immediately;

	// Lesson Release Schedule : Enrollement based
	@FindBy(xpath = "//label[@for='learndash-lesson-access-settings_lesson_schedule-visible_after']")
	public WebElement LD_Lesson_Enrollment_Based;
	// Enrollement based days
	@FindBy(xpath = "//input[@id='learndash-lesson-access-settings_visible_after']")
	public WebElement LD_Lesson_Enrollment_Based_days;
	
	// Lesson Release Schedule : Specific date
	@FindBy(xpath = "//label[@for='learndash-lesson-access-settings_lesson_schedule-visible_after_specific_date']")
	public WebElement LD_Lesson_Specific_date;
	@FindBy(xpath = "//select[@name='learndash-lesson-access-settings[visible_after_specific_date][mm]']")
	public WebElement LD_Lesson_SD_MM;
	@FindBy(xpath = "//input[@placeholder='DD']")
	public WebElement LD_Lesson_SD_DD;
	@FindBy(xpath = "//input[@placeholder='YYYY']")
	public WebElement LD_Lesson_SD_YYYY;
	@FindBy(xpath = "//input[@name='learndash-lesson-access-settings[visible_after_specific_date][hh]']")
	public WebElement LD_Lesson_SD_HH;
	@FindBy(xpath = "//input[@placeholder='MN']")
	public WebElement LD_Lesson_SD_MN;
	

}

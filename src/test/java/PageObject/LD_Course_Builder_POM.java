package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LD_Course_Builder_POM {

	WebDriver driver;

	// Constructor
	public LD_Course_Builder_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Visit Courses List
	public void Visit_Courses_List(String BaseURL) {
		driver.get(BaseURL + "wp-admin/edit.php?post_type=sfwd-courses");
	}

	// Search Course in List
	@FindBy(xpath = "//input[@id='post-search-input']")
	public WebElement LD_Search_Course;

	// Search Course button
	@FindBy(xpath = "//input[@id='search-submit']")
	public WebElement LD_Search_Course_Button;

	// Course in Course List
	public List<WebElement> LD_CourseList(String Course) {
		return driver.findElements(By.xpath(
				"//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='"+ Course + "']"));
	}

	// To click the course in the course list
	public WebElement LD_CourseSelector(String CourseTitle) {
		return driver.findElement(By.xpath(
				"//tbody[@id='the-list']//tr//td[@class='title column-title has-row-actions column-primary page-title']//strong//a[text()='"+ CourseTitle + "']"));
	}

	// Add New Course via LD Course Creator Button
	@FindBy(xpath = "//a[@class='global-new-entity-button ']")
	public WebElement Add_New_LD_Course;

	// Course Page Tab
	@FindBy(xpath = "//button[@id='tab-post-body-content']")
	public WebElement LD_Course_CoursePage_Tab;

	// Course Builder Tab
	@FindBy(xpath = "//button[@id='tab-learndash_course_builder']")
	public WebElement LD_Course_CourseBuilder_Tab;

	// Course Settings Tab
	@FindBy(xpath = "//button[@id='tab-sfwd-courses-settings']")
	public WebElement LD_Course_Settings_Tab;

	// Course Groups Tab
	@FindBy(xpath = "//button[@id='tab-learndash_course_groups']")
	public WebElement LD_Course_Group_Tab;

	/*
	 * Course Page Tab
	 */

	// Course Title Input
	
	@FindBy(xpath = "//body/div/div/div[@role='main']/div/div/form[@action='post.php']/div/div/div/div/div/input[1]")
	public WebElement LD_Course_Title_Input;

	// Course Page Container
	@FindBy(xpath = "//iframe[@id='content_ifr']")
	public WebElement LD_Course_Content;

	// Shared Course Option
//	@FindBy(xpath = "//span[@dir='ltr']//span//ul")
//	public WebElement LD_Shared_Course;

	
//	// Course Tab in Settings area
//	@FindBy(xpath = "//button[normalize-space()='Course']")
//	public WebElement Course_Tab;

	// Course Publish Button
	@FindBy(xpath = "//input[@id='publish']")
	public WebElement LD_Course_Publish_Button;

	// This is Publish button which gets displayed after clicking on publish once
	@FindBy(xpath = "//button[@class='components-button editor-post-publish-button editor-post-publish-button__button is-primary']")
	public WebElement LD_Course_Publish_Button2;

	// Course Published Text(Course is now Live)
	@FindBy(xpath = "//div[@id='message']//p")
	public List<WebElement> Course_Live_Text;

	// Category Accordion
	@FindBy(xpath = "//button[normalize-space()='Course Categories']//*[name()='svg']")
	public WebElement LD_CategoryAccordion;

	// Select Category
	public WebElement LD_SelectCategory(String Category) {
		return driver.findElement(By.xpath(
				"//div[@aria-label='Course Categories']//div//div//div//label[normalize-space()='" + Category + "']"));
	}

	// Tag Accordion
	@FindBy(xpath = "//button[normalize-space()='Course Tags']//*[name()='svg']")
	public WebElement LD_TagAccordion;

	// Select Tag
	@FindBy(xpath = "//input[@role='combobox']")
	public WebElement LD_SelectTag;

	/*
	 * Builder Tab
	 */

	// Add New Section Button
	@FindBy(xpath = "//button[normalize-space()='New Section Heading']")
	public WebElement LD_AddNewSection;

	// Add Section, Lesson, Topic, Quizzes Name Input
	@FindBy(xpath = "//input[@placeholder='Enter a title']")
	public WebElement LD_Add_name;

	// Add Section Button
	@FindBy(xpath = "//input[@value='Add Section Heading']")
	public WebElement LD_Add_Button_For_Section;

	// Add New Lesson Button
	@FindBy(xpath = "//button[normalize-space()='New Lesson']")
	public WebElement LD_AddNewLesson;

	// Add Lesson Button
	@FindBy(xpath = "//input[@value='Add Lesson']")
	public WebElement LD_Add_Button_For_Lesson;

	// Add New Topic Button
	@FindBy(xpath = "//button[normalize-space()='New Topic']")
	public WebElement LD_AddNewTopic;

	// Add Topic Button
	@FindBy(xpath = "//input[@value='Add Topic']")
	public WebElement LD_Add_Button_For_Topic;

	public WebElement LD_LessonAccordian(String LessonName) {
		return driver.findElement(
				By.xpath("//span[text()='" + LessonName + "']/../../../..//button[@class='ld-button-reset toggle']"));
	}

	// Add New Quiz
	@FindBy(xpath = "//div[@class='ld__builder--child -expanded']//div[1]//button[1]")
	public WebElement LD_AddNewQuiz;

	// Add Quiz Button
	@FindBy(xpath = "//input[@value='Add Quiz']")
	public WebElement LD_Add_Button_For_Quiz;

	// Final Quizzes-> Add Quiz
	@FindBy(xpath = "//div[@class='ld__builder--final-quizzes']//div//button[@class='ld__builder--new-entity-add-button']")
	public WebElement LD_Add_Final_Quiz_Button;

	// Find Section
	public WebElement LD_CheckSection(String SectionName) {
		return driver.findElement(By.xpath("//span[normalize-space()='" + SectionName + "']"));
	}

	// Existing Lessons Accordion
	@FindBy(xpath = "//div[@id='sfwd-course-lessons']//span[@class='toggle-indicator']")
	public WebElement LD_LessonsAccordion;
	// Existing Topics Accordion
	@FindBy(xpath = "//div[@id='sfwd-course-topics']//span[@class='toggle-indicator']")
	public WebElement LD_TopicsAccordion;
	// Existing Quizzes Accordion
	@FindBy(xpath = "//div[@id='sfwd-course-quizzes']//span[@class='toggle-indicator']")
	public WebElement LD_QuizzesAccordion;

	// Search Existing Lessons
	@FindBy(xpath = "//input[@placeholder='Search Lessons']")
	public WebElement LD_SearchLessons;
	// Search Existing Topics
	@FindBy(xpath = "//input[@placeholder='Search Topics']")
	public WebElement LD_SearchTopics;
	// Search Existing Quizzes
	@FindBy(xpath = "//input[@placeholder='Search Quizzes']")
	public WebElement LD_SearchQuizzes;

	// Search Lesson Topic and Quiz

	// Add Button for Searched Lesson Topic and Quiz
	public WebElement LD_SearchedItem(String Name) {
		return driver.findElement(By.xpath("//label[text()='" + Name + "']/../../..//button[text()='Add']"));
	}

	// Added Lesson Topic and Quiz to Course

	// Remove Lesson Topic Quiz
	public WebElement LD_RemoveItems(String Name) {
		return driver.findElement(By.xpath("//span[text()='" + Name
				+ "']/../../../..//div[@class='row-actions -right']//span[2]//button[text()='Remove']"));
	}

	// Remove Section
	public WebElement LD_RemoveSection(String SectionName) {
		return driver.findElement(By.xpath("//span[text()='" + SectionName
				+ "']/../../../..//div[@class='row-actions -right']//span//button[text()='Remove']"));
	}

	/*
	 * Settings Tab
	 */

	@FindBy(xpath = "//label[@for='learndash-course-access-settings_course_price_type-open']")
	public WebElement LD_AM_Open;
	@FindBy(xpath = "//label[@for='learndash-course-access-settings_course_price_type-free']")
	public WebElement LD_AM_Free;
	@FindBy(xpath = "//label[@for='learndash-course-access-settings_course_price_type-paynow']")
	public WebElement LD_AM_BuyNow;
	@FindBy(xpath = "//label[@for='learndash-course-access-settings_course_price_type-subscribe']")
	public WebElement LD_AM_Recurring;
	@FindBy(xpath = "//label[@for='learndash-course-access-settings_course_price_type-closed']")
	public WebElement LD_AM_Closed;

	// BuyNow Course Price
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_course_price_type_paynow_price']")
	public WebElement LD_Course_Price;

	// Course Prerequisites
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_course_prerequisite_enabled']")
	public WebElement LD_CoursePrerequistiesSlider;

	// Prerequisite Any Selected
	@FindBy(xpath = "//label[@for='learndash-course-access-settings_course_prerequisite_compare-ANY']")
	public WebElement LD_PrerequisiteAnySelected;
	// Prerequisite All Selected
	@FindBy(xpath = "//label[@for='learndash-course-access-settings_course_prerequisite_compare-ALL']")
	public WebElement LD_PrerequisiteAllSelected;

	// Search Prerequisite Course
	@FindBy(xpath = "//input[@placeholder='Search or select a Course']")
	public WebElement Search_Pre_Course;

	// Select Prerequisite Course

	// Course Points
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_course_points_enabled']")
	public WebElement LD_CoursePointsSlider;

	// Points Required for access
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_course_points_access']")
	public WebElement LD_PointsForAccess;

	// Points Awarded on completion
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_course_points']")
	public WebElement LD_PointsOnCompletion;

	// Course Access Expiration
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_expire_access']")
	public WebElement LD_CourseAccessExpirationSlider;

	// Access Period
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_expire_access_days']")
	public WebElement LD_Access_Period;

	// Course Data Deletion
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_expire_access_delete_progress']")
	public WebElement LD_dataDeletion;

	// Student Limit
	@FindBy(xpath = "//input[@id='learndash-course-access-settings_course_seats_limit']")
	public WebElement LD_StudentLimit;

	/*
	 * Display and Content Options
	 */

	// Course Material
	@FindBy(xpath = "//input[@id='learndash-course-display-content-settings_course_materials_enabled']")
	public WebElement LD_CourseMaterial;

	// Course Material Text Area
	@FindBy(xpath = "//textarea[@id='learndash-course-display-content-settings_course_materials']")
	public WebElement LD_CourseMaterialArea;

	// Course Certificate
	@FindBy(xpath = "//span[@title='Search or select a certificate…']")
	public WebElement LD_CourseCertificate;

	// Search Course Certificate
	@FindBy(xpath = "//input[@aria-label='Search']")
	public WebElement LD_SearchCourseCertificate;

	// Select from searched Certificates
	public WebElement LD_SelectSearchedCertificate(String Certificate) {
		return driver.findElement(By.xpath("//li[normalize-space()='" + Certificate + "']"));
	}

	// Course Content Always Visible
	@FindBy(xpath = "//label[@for='learndash-course-display-content-settings_course_disable_content_table-']")
	public WebElement LD_CourseContent_AlwaysVisible;

	// Course Content Only visible to enrollees
	//label[@for='learndash-course-display-content-settings_course_disable_content_table-on']
	@FindBy(xpath = "//span[normalize-space()='Only visible to enrollees']")
	public WebElement LD_CourseContent_OnlyVisibletoEnroll;
	
	// Custom Pagination
	@FindBy(xpath = "//input[@id='learndash-course-display-content-settings_course_lesson_per_page']")
	public WebElement LD_CustomPagination;

	// Custom Pagination: Lessons
	@FindBy(xpath = "//input[@id='learndash-course-display-content-settings_course_lesson_per_page_custom']")
	public WebElement CP_Lessons;

	// Custom Pagination: Topics
	@FindBy(xpath = "//input[@id='learndash-course-display-content-settings_course_topic_per_page_custom']")
	public WebElement CP_Topics;

	/*
	 * Course Navigation
	 */

	// Course Progress: Linear
	@FindBy(xpath = "//input[@id='learndash-course-display-content-settings_course_topic_per_page_custom']")
	public WebElement CP_Linear;

	// Course Progress: Free form
	@FindBy(xpath = "//label[@for='learndash-course-navigation-settings_course_disable_lesson_progression-on']")
	public WebElement CP_FreeForm;

	/*
	 * Course Groups Tab
	 */

	// Search Groups Input
	@FindBy(xpath = "//input[@placeholder='Search All Groups']")
	public WebElement LD_Search_Group;

	// Select Group
	public WebElement LD_SelectGroup(String Group) {
		return driver.findElement(By.xpath("//option[normalize-space()='"+Group+"']"));
	}
	
	//Left Search Area
	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/select[1]")
	public WebElement LD_LeftGroupSearchedArea;

	// Arrow pointing right
	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[4]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]/img[1]")
	public WebElement LD_ArrowtoRight;

	
	//New course examination
	@FindBy(xpath = "//div[@role='textbox']//div//div//div//button[contains(text(),'New COURSE EXAMINATION')]")
	public WebElement LD_NewCourseExam;
	
	@FindBy(xpath = "//input[@placeholder='Enter a title']")
	public WebElement LD_EnterTitle;
	
	
	@FindBy(xpath = "//input[@value='Add COURSE EXAMINATION']")
	public WebElement LD_AddCourseExam;
	
	
	
	
}

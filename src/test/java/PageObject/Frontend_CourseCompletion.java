package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Frontend_CourseCompletion extends BasePage  {

	public Frontend_CourseCompletion(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// TODO Auto-generated constructor stub
	
public void loginToUser(WebDriver driver, String baseURL, String username, String password)
		throws Exception {
	// Get the User login page first
	
	driver.get(baseURL);
	
	
	loginbutton.click();
	Thread.sleep(500);
	Username.clear();
	Username.sendKeys(username);
	Password.clear();
	Password.sendKeys(password);
	signinbutton.click();		
}

//public FrontendLogin(WebDriver driver) {
		
//		super(driver);
//		
//	}
	Actions actions = new Actions(driver);
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	public WebElement loginbutton;
	
	@FindBy(id="user_login")
	public WebElement Username;
	
	
	@FindBy(xpath="//input[@id='user_pass']")
	public WebElement Password;
	
	@FindBy(xpath="//input[@id='wp-submit']")
	public WebElement signinbutton;
	
	@FindBy(xpath="//span[normalize-space()='Education']")
	public WebElement Education_Menue;
	
//	@FindBy(xpath="//a[@href='https://progtechops.wpengine.com/courses/annual-training/']\r\n"
//			+ "	")
//	public WebElement CP_Certificate_Menue;
	
	@FindBy(xpath="//span[normalize-space()='My CE Progress & Certificates']")
	public WebElement CP_Certificate_Title;
	

//	@FindBy(xpath="//a[@href='https://progtechops.wpengine.com/courses/annual-training/']")
//	public WebElement Your_Courses;
	
//	@FindBy(xpath="//a[@href='https://progtechops.wpengine.com/quizzes/annual-training-unlicensed/']")
//	public WebElement Course_Content;
	
//	@FindBy(xpath="//div[@data-ld-expand-list='true']//div[2]//div[1]//a[1]")
//	public WebElement PSSTest_Courses;
//	
//	@FindBy(xpath="//div[contains(text(),'PSS_CourseExam')]")
//	public WebElement PSS_CourseContent;
//	
//	@FindBy(xpath="//input[@name='startQuiz']")
//	public WebElement Start_CourseExam;
//	
//	@FindBy(xpath="//label[normalize-space()='A & B']")
//	public WebElement Quiz1;
//	
//	@FindBy(xpath="//div//div//div//li[1]//input[2]")
//	public WebElement NextBtn ;
//	
//	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/article[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[14]/ol[1]/li[2]/div[2]/ul[1]/li[2]/label[1]")
//	public WebElement Quiz2;
//	
//	@FindBy(xpath="//div[@id='wrap_all']//li[1]//input[2]")
//	public WebElement NextBtn2;
//	
//	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/article[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[14]/ol[1]/li[3]/div[2]/ul[1]/li[2]/label[1]")
//	public WebElement Quiz3;
//	
//	@FindBy(xpath="//label[normalize-space()='All of the above']")
//	public WebElement Quiz4;
//	

	@FindBy(xpath="//li[4]//input[3]")
	public WebElement Finish_CourseExamBtn;
	

	@FindBy(xpath="//a[@id='quiz_continue_link']")
	public WebElement ClickheretoProcessCertificate_Btn;
	

	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/article[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]")
	public WebElement PSSLesson_Markcomplete;
	

	@FindBy(xpath="//input[@value='Mark Complete']")
	public WebElement Lesson_MarkCompleteBtn;
	

//	@FindBy(xpath="//body/div/div/div/div/main[@role='main']/article[@itemscope='itemscope']/div/div[@itemprop='text']/div/div/div/div/a[1]")
//	public WebElement Download_Certificate;
	
	@FindBy(xpath="//button[@data-ld-expands='ld-course-search']")
	public WebElement SearchIcon;
	
	@FindBy(xpath="//input[@name='ld-profile-search']")
	public WebElement SearchCourseName;
	
	@FindBy(xpath="//input[@class='ld-button']")
	public WebElement SearchBtnCouses;
	
	@FindBy(xpath="//span[normalize-space()='Annual Training']")
	public WebElement AnnualTrainingSelect;
	
	@FindBy(xpath="//a[@href='https://progtechops.wpengine.com/quizzes/annual-training-unlicensed/']")
	public WebElement StartAnnualTrainingQuiz;
	
	@FindBy(xpath="//li[1]//div[2]//ul[1]//li[1]//label[1]")
	public WebElement AT_Quiz1;
	
	@FindBy(xpath="//label[normalize-space()='All of the above']")
	public WebElement AT_Quiz2;
	
	@FindBy(xpath="//label[normalize-space()='In writing']")
	public WebElement AT_Quiz3;
	
	@FindBy(xpath="//body[1]/div[2]/div[1]/div[1]/div[1]/main[1]/article[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[14]/ol[1]/li[4]/div[2]/ul[1]/li[2]/label[1]/input[1]")
	public WebElement AT_Quiz4;
	
	@FindBy(xpath="//label[normalize-space()='True']")
	public WebElement AT_Quiz5;
	
	@FindBy(xpath="//input[@name='checkSingle']")
	public WebElement FinishCourseExam;
	
	@FindBy(xpath="//a[@id='quiz_continue_link']")
	public WebElement CompleteCourseCert;
	
	@FindBy(xpath="//a[normalize-space()='Download Certificate']")
	public List<WebElement> DownloadCert;
	
	
	
	
	
	
	
	

}
package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackendListings {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public BackendListings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Search Input
	@FindBy(xpath = "//input[@id='post-search-input']")
	public WebElement Search_Post;

	// Search Submit
	@FindBy(id = "search-submit")
	public WebElement SearchSubmit;

	// Select All Checkbox
	@FindBy(xpath = "//input[@id='cb-select-all-1']")
	public WebElement Select_All;

	// Bulk Action
	@FindBy(id = "bulk-action-selector-top")
	public WebElement Bulk_Action;

	@FindBy(id = "bulk-action-selector-top")
	public List<WebElement> Bulk_Action_Check;

	// Bulk Action Select
	public Select BulkAction() {
		Select BA = new Select(Bulk_Action);
		return BA;
	}

	// Apply Action
	@FindBy(id = "doaction")
	public WebElement Apply;

	// Trash Link
	@FindBy(xpath = "//li[@class='trash']/a")
	public WebElement TrashTab;

}

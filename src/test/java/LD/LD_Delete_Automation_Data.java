package LD;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestBase.BaseClass;

import PageObject.BackendListings;
import PageObject.Frontend_CourseCompletion;

public class LD_Delete_Automation_Data {
	WebDriver driver;
	Frontend_CourseCompletion fl;
	BackendListings BL;
	String baseURL;
	String adminU;
	String adminP;
	
	/**
	 * Before Class: This Method does Admin Login
	 * 
	 * @param siteURL
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	@Parameters({ "SiteURL", "AdminUsername", "AdminPassword" })
	@BeforeClass
	public void DriverSetUp(String siteURL, String username, String password) throws Exception {
		driver = BaseClass.driver;

		// Initializing Overview Settings Object

		fl = new Frontend_CourseCompletion(driver);

		// Initializing Backend Listing Page Object
		BL = new BackendListings(driver);

		// Setting User Details
		baseURL = siteURL;
		adminU = username;
		adminP = password;

		// Admin Login
		fl.loginToUser(driver, baseURL, adminU, adminP);
	}

	/**
	 * Delete Data Created By Automation
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void Delete_Data() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		try {
			// Visit Courses Listing
			driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-courses");
			Search_and_Delete();
		} catch (Exception e) {
			softAssert.assertTrue(false, "Courses Not Deleted.");
		}
		try {
			// Visit Lesson Listing
			driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-lessons");
			Search_and_Delete();
		} catch (Exception e) {
			softAssert.assertTrue(false, "Lessons Not Deleted.");
		}

		try {
			// Visit Topic Listing
			driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-topic");
			Search_and_Delete();
		} catch (Exception e) {
			softAssert.assertTrue(false, "Topics Not Deleted.");
		}

		try {
			// Visit Quizzes Listing
			driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-quiz");
			Search_and_Delete();
		} catch (Exception e) {
			softAssert.assertTrue(false, "Quizzes Not Deleted.");
		}

		try {
			// Visit Questions Listing
			driver.get(baseURL + "wp-admin/edit.php?post_type=sfwd-question");
			Search_and_Delete();
		} catch (Exception e) {
			softAssert.assertTrue(false, "Questions Not Deleted.");
		}

		
		

		softAssert.assertAll();
	}

	public void Search_and_Delete() throws Exception {
		BL.Search_Post.clear();
		BL.Search_Post.sendKeys("Automation");
		BL.SearchSubmit.click();
		Thread.sleep(1500);
		if (BL.Bulk_Action_Check.size() > 0) {
			BL.Select_All.click();
			BL.BulkAction().selectByValue("trash");
			BL.Apply.click();
			Thread.sleep(2000);
			BL.TrashTab.click();
			BL.Search_Post.clear();
			BL.Search_Post.sendKeys("Automation");
			BL.SearchSubmit.click();
			if (BL.Bulk_Action_Check.size() > 0) {
				BL.Select_All.click();
				BL.BulkAction().selectByValue("delete");
				BL.Apply.click();
				Thread.sleep(2000);
			}
		}
	}
}

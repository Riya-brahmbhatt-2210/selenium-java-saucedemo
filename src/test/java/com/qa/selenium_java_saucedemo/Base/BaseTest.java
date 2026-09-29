package com.qa.selenium_java_saucedemo.Base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

	protected WebDriver driver;
	protected ChromeOptions options;
	protected Map<String, Object> prefs;
	
	
	@BeforeMethod
	public void setUp() {
		// Initialize ChromeOptions
        options = new ChromeOptions();
        
        // This explicitly instructs Selenium to launch the dedicated 
        // "Chrome for Testing" binary instead of your local commercial Chrome
        options.setBrowserVersion("153"); 

        // 1. Create a preference map to disable the password service and autofill
        prefs = new HashMap<>();
        
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.password_manager_leak_detection_enabled", false);
        
        // COMPLETELY TURNS OFF SAFE BROWSING (Disables the breach lookup engine)
        prefs.put("safebrowsing.enabled", false);
        prefs.put("safebrowsing.enhanced", false);
        options.setExperimentalOption("prefs", prefs);

        // 2. Completely eliminate the popup window infrastructure from showing up
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito"); // Isolates the storage profile
        
        // Force Chrome to hide specific automated notification channels
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));

        // 3. Add aggressive test environment feature-flags
        options.addArguments("--disable-features=" +
            "PasswordLeakDetection," +
            "PasswordCheck," +
            "SafetyCheckUnusedSitePermissions," +
            "AutofillServerCommunication"
        );
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

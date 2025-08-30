package com.balsam.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");   // maximize
                    options.addArguments("--incognito");        // incognito mode
                    options.addArguments("--disable-notifications"); // optional: disable popups
                    driver = new ChromeDriver(options);
                    break;

                // add other browsers if needed
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }




    // Get driver based on browser name
	/*
	 * public static WebDriver getDriver(String browser) { if (driverThread.get() ==
	 * null) { WebDriver driver;
	 * 
	 * switch (browser.toLowerCase()) { case "chrome":
	 * WebDriverManager.chromedriver().setup(); ChromeOptions chromeOptions = new
	 * ChromeOptions(); chromeOptions.addArguments("--start-maximized"); driver =
	 * new ChromeDriver(chromeOptions); break;
	 * 
	 * case "firefox": WebDriverManager.firefoxdriver().setup(); FirefoxOptions
	 * firefoxOptions = new FirefoxOptions();
	 * firefoxOptions.addArguments("--start-maximized"); driver = new
	 * FirefoxDriver(firefoxOptions); break;
	 * 
	 * case "ie": case "internet explorer": WebDriverManager.iedriver().setup();
	 * InternetExplorerOptions ieOptions = new InternetExplorerOptions(); driver =
	 * new InternetExplorerDriver(ieOptions); break;
	 * 
	 * default: throw new RuntimeException("Unsupported browser: " + browser); }
	 * 
	 * driverThread.set(driver); }
	 * 
	 * return driverThread.get(); }
	 */


}

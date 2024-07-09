package com.naveenautomationlabs.Testbase;

import java.time.Duration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.Browsers.Browsers;
import com.naveenautomationlabs.listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	private final Browsers BROWSER = Browsers.CHROME;
	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static Logger logger;
	public WebdriverEvents events;
	@SuppressWarnings("deprecation")
	public EventFiringWebDriver eDriver;
	 protected WebDriverWait wait;
	// This method intialise the Webdriver instance
	public void intialise() {

		intialiseWebdriver();
		// Maximise Window
		driver.manage().window().maximize();
		// Manage Timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Load Webpage
		driver.get(URL);
		   wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	private void intialiseWebdriver() {
		switch (BROWSER) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new InvalidArgumentException("Pass Correct Browser name");
		}

		eDriver = new EventFiringWebDriver(driver);
		events = new WebdriverEvents();

		eDriver.register(events);
		driver = eDriver;
		
	}

	// Method to close the browser
	public void tearDown() {
		driver.quit();
	}


    public void selectDropdownByValueOrText(WebElement element, String value, String text) {
        Select select = new Select(element);
        try {
            select.selectByValue(value);
        } catch (Exception e) {
            select.selectByVisibleText(text);
        }
    }

  
}

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import com.naveenautomationlabs.Browsers.Browsers;
import com.naveenautomationlabs.listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	private static Browsers DEFAULT_BROWSER = Browsers.CHROME;
	private static String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
	public static Logger logger;
	private WebdriverEvents events;
//	//@SuppressWarnings("deprecation")
//	private EventFiringDecorator eDriver;
	
	@BeforeClass
	public void setUpLogger() {
		logger=Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}
	public void initialise() {
		initialiseWebdriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);

	}

	private void initialiseWebdriver() {
		switch (DEFAULT_BROWSER) {
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
			throw new InvalidArgumentException("enter correct browser name");
		}
//		eDriver = new EventFiringDecorator(driver);
//		events = new WebdriverEvents();
//
//		 eDriver.register(events);
//		driver = eDriver;	
		events = new WebdriverEvents();
        EventFiringDecorator<WebDriver> eventDriver = new EventFiringDecorator<>(events);
        driver = eventDriver.decorate(driver);
	}
	
	
	

	public void tearDown() {
		driver.quit();
	}
	public void selectDropdownByValueorText(WebElement element, String value, String text) {
		Select select= new Select(element);
		try {
			select.selectByValue(value);
		}catch(Exception e) {
			select.selectByVisibleText(text);
		}
	}
		
	
	}


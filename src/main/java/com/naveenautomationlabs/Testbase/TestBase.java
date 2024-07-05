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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.naveenautomationlabs.Browsers.Browsers;
import com.naveenautomationlabs.listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    protected static WebDriver driver;
    private static final Browsers DEFAULT_BROWSER = Browsers.CHROME;
    private static final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
    protected static Logger logger;
    private WebdriverEvents events;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUpLogger() {
        logger = Logger.getLogger(TestBase.class);
        PropertyConfigurator.configure("log4j.properties");
        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);
    }

    @BeforeMethod
    public void initialise() {
        initialiseWebdriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(URL);
     // Initialize WebDriverWait with a default timeout of 20 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private void initialiseWebdriver() {
        if (driver == null) {
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
                    throw new InvalidArgumentException("Enter correct browser name");
            }

            // Decorate driver with event listener
            events = new WebdriverEvents();
            EventFiringDecorator<WebDriver> eventDriver = new EventFiringDecorator<>(events);
            driver = eventDriver.decorate(driver);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                logger.info("Attempting to quit the driver.");
                driver.quit();
                logger.info("Driver quit successfully.");
            } catch (Exception e) {
                logger.error("Error occurred while quitting the driver: ", e);
            } finally {
                driver = null;
            }
        }
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

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlabs.Browsers.Browsers;
import com.naveenautomationlabs.listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static WebDriver driver;
    private Browsers BROWSER;
    private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";
    public static Logger logger;
    public WebdriverEvents events;
    @SuppressWarnings("deprecation")
    public EventFiringWebDriver eDriver;
    protected WebDriverWait wait;

    // This method initializes the WebDriver instance
    public void intialise() {
        setBrowser();
        initializeWebDriver();
        // Maximize Window
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

    private void setBrowser() {
        String browser = System.getProperty("browser", "CHROME").toUpperCase();
        try {
            BROWSER = Browsers.valueOf(browser);
        } catch (IllegalArgumentException e) {
            throw new InvalidArgumentException("Pass Correct Browser name");
        }
    }

    private void initializeWebDriver() {
        switch (BROWSER) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                setBrowserOptions(chromeOptions);
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                setBrowserOptions(firefoxOptions);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                setBrowserOptions(edgeOptions);
                driver = new EdgeDriver(edgeOptions);
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new InvalidArgumentException("Pass Correct Browser name");
        }

        eDriver = new EventFiringWebDriver(driver);
        events = new WebdriverEvents();
        eDriver.register(events);
        driver = eDriver;
    }

    // set options for different browsers
    private void setBrowserOptions(Object options) {
        if (System.getProperty("incognito", "false").equals("true")) {
            if (options instanceof ChromeOptions) {
                ((ChromeOptions) options).addArguments("--incognito");
            } else if (options instanceof FirefoxOptions) {
                ((FirefoxOptions) options).addArguments("-private");
            } else if (options instanceof EdgeOptions) {
                ((EdgeOptions) options).addArguments("--inprivate");
            }
        }
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

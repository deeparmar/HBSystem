package testcases;

import junit.framework.TestResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseWebDriverTestCase {


    protected static WebDriver driver;

    @Rule
    public TestName testName = new TestName();
    public TestResult testResult = new TestResult();

    @Before
    public void BaseWebDriverSetup() throws IOException {

        String webBrowser = "Firefox";
        File file = new File("src/test/java/driver/geckodriver_v0.23.0.exe");
        System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://hotel-test.equalexperts.io/");
        driver.manage().window().maximize();

    }


    @After
    public void TearDown() throws Exception {
        CloseBrowser();
       // BDD.report.flush();
    }


    public void CloseBrowser() {

        driver.quit();
    }


}

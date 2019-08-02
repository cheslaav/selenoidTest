package runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
                features = "src/test/resources",
                glue = "steps",
                tags = "@prodTest"
        )
public class TestRunner {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);



    @Before
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("75.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        try {
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://selenoid:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Configuration.startMaximized = false;
        Configuration.reportsFolder = "target/surefire-reports";
    }
}

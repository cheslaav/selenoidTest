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
import java.net.URL;

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
        Configuration.startMaximized = false;
        Configuration.browser = "firefox";
        Configuration.reportsFolder = "target/surefire-reports";
    }
}

package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utils.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke", // Default tag to run
        plugin = {
            "pretty",
            "html:target/cucumber-reports.html",
            "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestRunner {
    
    @AfterClass
    public static void tearDown() {
        WebDriverManager.quitDriver();
    }
}
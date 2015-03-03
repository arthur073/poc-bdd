import cucumber.api.*;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

/**
 * Created by averger on 26/02/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,format = "json:reports/cucumber-json-report.json")
public class RunCukesTest {

}

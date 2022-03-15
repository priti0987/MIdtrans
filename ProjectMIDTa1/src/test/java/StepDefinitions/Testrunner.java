package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue="StepDefinitions"
,monochrome = true
, publish = true
,dryRun=false
,plugin = {"json","html:target/HTMLReports"})
public class Testrunner {

}

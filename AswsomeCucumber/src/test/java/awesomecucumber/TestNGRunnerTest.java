package awesomecucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests; import
        io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = "message:target/cucumber-report.ndjson") public
class TestNGRunnerTest extends AbstractTestNGCucumberTests{

}
 
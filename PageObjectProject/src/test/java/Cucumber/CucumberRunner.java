package Cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import practiceProject.test.TestRunner;

@CucumberOptions(
    features = "src/test/java/Cucumber",
    glue = "runners.stepDefinations",
    tags = "@Regression",
    monochrome=true,
    plugin = {"html:target/cucumber.html"}
)



public class CucumberRunner extends AbstractTestNGCucumberTests  {

}

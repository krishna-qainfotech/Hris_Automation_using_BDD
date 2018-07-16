package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features ="/home/qainfotech/eclipse-workspace/HRIS_USING_BDD_FRAMEWORK/src/test/java/Feature/Hris.feature"
		,glue={"StepDefination"}
		)

public class RunnerClass {

}

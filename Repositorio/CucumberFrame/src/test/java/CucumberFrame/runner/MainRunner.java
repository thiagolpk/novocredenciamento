package CucumberFrame.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"src/test/java/CucumberFrame/featureFiles/"},
	glue = {"CucumberFrame.stepsFiles"},
	plugin = {//"pretty", "html:target/cucumber", 
		//	"json:target/cucumber.json", 
			"com.cucumber.listener.ExtentCucumberFormatter:target/Resultado.html"}
	//, tags = {"@BRA", "@CPF"}
	 ,tags = {"@Esquemadecenario"}
)
public class MainRunner {

}

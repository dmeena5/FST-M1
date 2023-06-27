import org.junit.runner.RunWith;
        import io.cucumber.junit.Cucumber;
        import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity5",
        plugin = {"html: test-reports"},
        monochrome = true
        )

public class ActivitiesRunner {
    //empty
}
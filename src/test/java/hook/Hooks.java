package hook;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    @Before
    public void setUp() {
        System.out.println("Method calisti");
    }

    @After
    public void tearDown(Scenario scenario) { //
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {

            scenario.attach(screenshot, "image/png", "screenshots" + scenario.getName());

        }
        Driver.closeDriver();
    }
}

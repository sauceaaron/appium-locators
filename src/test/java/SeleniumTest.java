import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTest extends SauceTestBase
{
	RemoteWebDriver driver;

	@Before
	public void setup() throws MalformedURLException
	{
		driver = createBrowserDriver("Windows 10", "chrome");
	}

	@Test
	public void loginTest()
	{
		driver.get("https://www.saucedemo.com");

		WebElement usernameField = driver.findElementById("user-name");
		usernameField.sendKeys("standard_user");

		assertThat(usernameField.getText()).isEqualTo("standard_user");
	}

	@After
	public void teardown()
	{
		driver.quit();
	}
}

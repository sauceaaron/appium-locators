import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class SeleniumLocators extends SauceTestBase
{
	RemoteWebDriver driver;

	@Before
	public void setup() throws MalformedURLException
	{
		driver = createBrowserDriver("Windows 10", "chrome");
	}

	@After
	public void teardown()
	{
		driver.quit();
	}

	public void locators()
	{
		driver.findElement(By.id(""));
		driver.findElement(By.name(""));
		driver.findElement(By.tagName(""));
		driver.findElement(By.className(""));
		driver.findElement(By.cssSelector(""));
		driver.findElement(By.xpath(""));
		driver.findElement(By.linkText(""));
		driver.findElement(By.partialLinkText(""));
	}
}

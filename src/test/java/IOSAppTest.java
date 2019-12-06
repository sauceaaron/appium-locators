import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class IOSAppTest extends SauceTestBase
{
	IOSDriver<MobileElement> driver;

	@Before
	public void setup() throws IOException
	{
//		uploadToSauceStorage(IOS_APP);
		driver = createIPhoneDriver();
	}

	@Test
	public void testLocatingByAccessibilityId()
	{
		MobileElement usernameField = driver.findElement(LoginScreen.ByAccessibilityId.username);
		usernameField.sendKeys("standard_user");

		assertThat(usernameField.getText()).isEqualTo("standard_user");
	}

	@Test
	public void testLocatingByClassName()
	{
		List<MobileElement> elements =
				driver.findElements(MobileBy.className("XCUIElementTypeSecureTextField"));

		assertThat(elements.size()).isEqualTo(1);

	}

	@Test
	public void testLocatingByIOSPredicateString()
	{
		MobileElement usernameField =
				driver.findElementByIosNsPredicate(
						"value == 'Username'");

		usernameField.sendKeys("hello");
	}

	@After
	public void teardown()
	{
		driver.quit();
	}
}
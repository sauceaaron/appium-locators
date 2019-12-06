import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class IOSAppTest extends SauceTestBase
{
	IOSDriver<MobileElement> driver;

	@Before
	public void setup() throws IOException
	{
		uploadToSauceStorage(IOS_APP);
		driver = createIPhoneDriver();
	}

	@Test
	public void testLocatingByAccessibilityId()
	{
		MobileElement usernameField = driver.findElement(LoginScreen.ByAccessibilityId.username);
		usernameField.sendKeys("standard_user");

		assertThat(usernameField.getText()).isEqualTo("standard_user");
	}

	@After
	public void teardown()
	{
		driver.quit();
	}
}
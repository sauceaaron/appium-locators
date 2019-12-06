import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;


public class AndroidAppTest extends SauceTestBase
{
	AndroidDriver<MobileElement> driver;

	@Before
	public void setup() throws IOException
	{
		uploadToSauceStorage(ANDROID_APP);
		driver = createAndroidDriver();
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
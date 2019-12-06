import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Test;

import java.net.MalformedURLException;

public class AppiumLocators extends SauceTestBase
{
	@Test
	public void AppiumLocators() throws MalformedURLException
	{
		AppiumDriver<MobileElement> appium = createAndroidDriver();

		appium.findElementByAccessibilityId("");
		appium.findElementByClassName("");

		appium.findElement(MobileBy.AccessibilityId(""));
		appium.findElement(MobileBy.className(""));

		appium.findElementByName("");
		appium.findElementById("");

		appium.findElementByImage("");
		appium.findElementByCustom("");
	}
	@Test
	public void IOSLocators() throws MalformedURLException
	{
		IOSDriver<MobileElement> ios = createIPhoneDriver();

		ios.findElementByIosClassChain("");
		ios.findElementByIosNsPredicate("");

		ios.quit();
	}

	@Test
	public void AndroidLocators() throws MalformedURLException
	{
		AndroidDriver<MobileElement> android = createAndroidDriver();

		android.findElementByAndroidDataMatcher("");
		android.findElementByAndroidUIAutomator("");
		android.findElementByAndroidViewTag("");


		android.quit();
	}
}

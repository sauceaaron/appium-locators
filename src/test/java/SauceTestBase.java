import com.saucelabs.saucerest.SauceREST;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;

public abstract class SauceTestBase
{
	String BUILD_TAG = System.getenv("BUILD_TAG");
	String APP_URL = System.getenv("APP_URL");

	SauceREST api;

	String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
	String SAUCE_URL = "https://ondemand.saucelabs.com/wd/hub";

	String RESOURCES_PATH = System.getenv("user.dir") + "/src/main/resources/";

	String IOS_APP = "SauceDemo-iOS-Simulator.zip";
	String ANDROID_APP = "SauceDemo-Android.apk";

	DesiredCapabilities SauceLabsCapabilities = new DesiredCapabilities()
	{{
		setCapability("username", SAUCE_USERNAME);
		setCapability("accessKey", SAUCE_ACCESS_KEY);
		setCapability("build", BUILD_TAG);
	}};

	DesiredCapabilities iPhoneSimulatorCapabilities = new DesiredCapabilities()
	{{
		setCapability("platformName", "iOS");
		setCapability("platformVersion", "12.2");
		setCapability("deviceName", "iPhone Simulator");
		setCapability("deviceOrientation", "portrait");
		setCapability("browserName", "");
		setCapability("app", "sauce-storage:" + IOS_APP);
	}};

	DesiredCapabilities AndroidEmulatorCapabilities = new DesiredCapabilities()
	{{
		setCapability("platformName", "Android");
		setCapability("platformVersion", "9.0");
		setCapability("deviceName","Android GoogleAPI Emulator");
		setCapability("deviceOrientation", "portrait");
		setCapability("browserName", "");
		setCapability("app", "sauce-storage:" + ANDROID_APP);
	}};

	DesiredCapabilities WindowsChromeCapabilities = new DesiredCapabilities()
	{{
		setCapability("platform", "Windows 10");
		setCapability("browserName", "Chrome");
		setCapability("version","latest");
	}};

	@Rule
	public TestName testName = new TestName();

	public SauceTestBase()
	{
		api = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
	}

	void uploadToSauceStorage(String APP_NAME) throws IOException
	{
		URL resource = getClass().getClassLoader().getResource(APP_NAME);
		String filename = resource.getFile();
		System.out.println(filename);
		File file = new File(filename);

		String upload = api.uploadFile(file, APP_NAME, false);
		System.out.println(upload);
	}

	public IOSDriver<MobileElement> createIPhoneDriver() throws MalformedURLException
	{
		URL url = new URL(SAUCE_URL);

		DesiredCapabilities capabilities = new DesiredCapabilities()
			.merge(SauceLabsCapabilities)
			.merge(iPhoneSimulatorCapabilities);

		capabilities.setCapability("name", getTestName());
		return new IOSDriver<>(url, capabilities);
	}

	public AndroidDriver<MobileElement> createAndroidDriver() throws MalformedURLException
	{
		URL url = new URL(SAUCE_URL);

		DesiredCapabilities capabilities = new DesiredCapabilities()
				.merge(SauceLabsCapabilities)
				.merge(AndroidEmulatorCapabilities);

		capabilities.setCapability("name", getTestName());

		return new AndroidDriver<>(url, capabilities);
	}

	public RemoteWebDriver createBrowserDriver(String platform, String browser) throws MalformedURLException
	{
		URL url = new URL(SAUCE_URL);

		DesiredCapabilities capabilities = new DesiredCapabilities()
				.merge(SauceLabsCapabilities);

		capabilities.setCapability("platform", platform);
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("name", getTestName());

		return new RemoteWebDriver(url, capabilities);
	}

	protected String getTestName()
	{
		return this.getClass().getSimpleName() + "_" + testName.getMethodName();
	}
}

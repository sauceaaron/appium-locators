import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginScreen
{
	public static class ByAccessibilityId
	{
		static By logo = MobileBy.AccessibilityId("assets/src/img/swag-labs-logo.png");
		static By username = MobileBy.AccessibilityId("test-Username");
		static By password = MobileBy.AccessibilityId("test-Password");
		static By loginButton = MobileBy.AccessibilityId("test-LOGIN");
	}

	public static class ByXPath_IOS
	{
		static By logo = MobileBy.xpath("//XCUIElementTypeImage[@name=\"assets/src/img/swag-labs-logo.png\"]");
		static By username = MobileBy.xpath("//XCUIElementTypeTextField[@name=\"test-Username\"]");
		static By password = MobileBy.xpath("//XCUIElementTypeSecureTextField[@name=\"test-Password\"]");
		static By loginButton = MobileBy.xpath("//XCUIElementTypeOther[@name=\"test-LOGIN\"]");
		static By bot = MobileBy.xpath("//XCUIElementTypeImage[@name=\"assets/src/img/login-bot.png\"]");
	}

	public static class ByXPath_Android
	{
		static By logo = MobileBy.xpath("//XCUIElementTypeImage[@name=\"assets/src/img/swag-labs-logo.png\"]");
		static By username = MobileBy.xpath("//XCUIElementTypeTextField[@name=\"test-Username\"]");
		static By password = MobileBy.xpath("//XCUIElementTypeSecureTextField[@name=\"test-Password\"]");
		static By loginButton = MobileBy.xpath("//XCUIElementTypeOther[@name=\"test-LOGIN\"]");
		static By bot = MobileBy.xpath("//XCUIElementTypeImage[@name=\"assets/src/img/login-bot.png\"]");
	}
}

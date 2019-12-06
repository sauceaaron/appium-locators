import com.saucelabs.saucerest.SauceREST;

import java.io.File;
import java.io.IOException;

public class UploadToSauceStorage
{
	static String USER_DIR = System.getProperty("user.dir");
	static String APP_PATH = USER_DIR +
			"/src/main/resources/SauceDemo-iOS-Simulator.zip";

	static String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
	static String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

	public static void main(String[] args) throws IOException
	{
		if (args.length > 0)
		{
			APP_PATH = args[0];
		}
		else if (System.getenv("APP_PATH") != null)
		{
			APP_PATH = System.getenv("APP_PATH");
		}

		System.out.println(APP_PATH);

		File file = new File(APP_PATH);
		SauceREST sauce = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);

		sauce.uploadFile(file);
		System.out.println(sauce.getStoredFiles());
	}
}

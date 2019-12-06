set APP_PATH src\main\resources\iOS.Simulator.SauceLabs.Mobile.Sample.app.2.1.0.zip

dir %APP_PATH%

curl -u %SAUCE_USERNAME%:%SAUCE_ACCESS_KEY% _
-H "Content-Type: application/octet-stream" _
-X POST https://saucelabs.com/rest/v1/storage/$SAUCE_USERNAME/SampleAppIOS?overwrite=true _
--data-binary @%APP_PATH%

curl -u %SAUCE_USERNAME%:%SAUCE_ACCESS_KEY% \
-X GET https://saucelabs.com/rest/v1/storage/%SAUCE_USERNAME%
#!/usr/bin/env bash

export APP_PATH=src/main/resources/SauceDemo-iOS-Simulator.zip

ls $APP_PATH

curl -u $SAUCE_USERNAME:$SAUCE_ACCESS_KEY \
-H "Content-Type: application/octet-stream" \
-X POST https://saucelabs.com/rest/v1/storage/$SAUCE_USERNAME/SampleAppIOS?overwrite=true \
--data-binary @$APP_PATH

curl -u $SAUCE_USERNAME:$SAUCE_ACCESS_KEY \
-X GET https://saucelabs.com/rest/v1/storage/$SAUCE_USERNAME
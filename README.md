FunnyJokes
==========

Discover and have a laugh at funny jokes

Build Instructions (Mac OS X)
-----------------------------

- Clone the repository
- Install [Java](https://java.com/en/download/help/download_options.xml)
- Install [Android Studio](http://developer.android.com/sdk/index.html) with Android SDK Tools
- Install [Genymotion](https://www.genymotion.com/)
- Add the local.properties file with `sdk.dir=<path_to_your_android_sdk>`
- Start Genymotion Emulator
- Run the local web server using `./gradlew backend:appengineRun -PisDaemonEnabled=false`
- If you wish to see ads while debugging, change the DEVICE_ID field in `gradle.properties`
  to match your device / emulator's device id
- change the value of `base_url` in `app/src/debug/res/values/strings.xml:3` to use your ip address instead of `192.168.0.101`
- Run the App using Android Studio

Running Tests
-------------

#### Unit Tests
- `cd` to the cloned repository
- Run `./gradlew tasks` to see the available tasks
- Run `./gradlew testDebugUnitTest` to run the unit tests for debug build type
- Run `./gradlew testReleaseUnitTest` to run the unit tests for release build type

#### Instrumentation tests
- `cd` to the cloned repository
- Run `./gradlew tasks` to see the available tasks
- Run `ifconfig en0` to fetch your ip address from the `inet` field
- Change the ip address value in `base_url` located in `app/src/debug/res/values/strings.xml:3` to use your ip address instead of `192.168.0.101`
- Change the DEVICE_ID field in root level `gradle.properties` to be able to see ads in testing.
  Refer [this](http://www.androidbegin.com/tutorial/integrating-new-google-admob-banner-interstitial-ads/) to set up your device id.
- For the test to be able to verify that the interstecial ad is shown, switch on the internet connection
- Run `./gradlew runConnectedAndroidTests` to start the backend server, run connected android tests and close the server

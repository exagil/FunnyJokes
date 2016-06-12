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
- Run the App using Android Studio

Running Tests
-------------

#### Unit Tests
- `cd` to the cloned repository
- run `./gradlew tasks` to see the available tasks
- run `./gradlew test` to run the unit tests

#### Instrumentation tests
- `cd` to the cloned repository
- run `./gradlew tasks` to see the available tasks
- run `ifconfig en0` to fetch your ip address from the `inet` field
- change the value of `base_url` in `app/src/debug/res/values/strings.xml:3` to use your ip address instead of `192.168.0.101`
- run `./gradlew runConnectedAndroidTests` to start the backend server, run connected android tests and close the server

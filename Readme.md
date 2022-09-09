# Overview of Java Appium Framework with App Center Integration
````
- Java based Framework for mobile automation on Android and iOS with Appium integrated with Visual Studio App Center.
- Supports web browser automation and mobile with test cases and page objects (POM).
````

# Preconditions
- __Any IDE__ *(IntelliJ Preferred)*
- __Java__ *(Preferred version 8)*
- __Node JS__ *(Preferred version 14.17.0+)*
- __Git Bash__ *(https://git-scm.com/downloads)*
- __Android Studio__ *(https://developer.android.com/studio#downloads)*
- __Appium Desktop App__ *(https://github.com/appium/appium-desktop/releases/tag/v1.20.2-4)*
- __Appium Server__ ``npm install -g appium``
- __Appium Doctor__ ``npm install appium-doctor -g``
- __Maven__ ``npm install mvn -g``
- __Android Platform Tools__ ``npm install -g android-platform-tools``

# Local Environment Setup for Android Testing
If you haven't previously set up Appium, you can do so by following these steps:

1. Install Node.js/NPM: https://www.npmjs.com/get-npm

2. Install Appium:

Windows This guide shows how to install Appium on Windows: https://www.edgewordstraining.co.uk/2017/07/05/install-appium-server-windows/

OSX Use this command in the Terminal (This may require additional permission arguments to work: npm/npm#17268):

sudo npm install -g appium

3. Install Maven: https://maven.apache.org/install.html

4. Set the ANDROID_HOME path enviroment variable. https://stackoverflow.com/questions/28296237/set-android-home-environment-variable-in-mac

By default typically the Android SDK is located at ~/Library/Android/sdk (Mac) or %LOCALAPPDATA%\Android\sdk (Windows)

# Local Environment Setup for iOS Testing
If you haven't previously set up Appium, you can do so by following these steps:

1. Install Node.js/NPM: https://www.npmjs.com/get-npm
2. Install Appium by using this command in the Terminal (it may require additional permission arguments to work: npm/npm#17268):

sudo npm install -g appium

3. Install Maven: https://maven.apache.org/install.html

4. Install carthage:

brew install carthage

5. Install ios-deploy
npm install -g ios-deploy



# Building and Running Tests on Android
(Note: The author of this repo used Maven as the build tool, JDK version 8, and language level 8. You will be required to modify the project tab and modules in the 
Project Structure of IntelliJ IDE.

Provide the absolute path to *.apk. 

Build the Maven project using your perferred method. Your IDE may prompt you to auto-apply some settings, in which case confirm them.
If you are running tests locally against an Andrid Emulator, make sure to start the local Appium server and emulator in Android Studio 
before running tests, otherwise the tests will fail.

If running against, you will need to start the local Appium server before running tests, otherwise the tests will fail.

# Building and Running Tests on Android
(Note: The author of this repo used Maven as the build tool, JDK version 8, and language level 8. You will be required to modify the project tab and modules in the 
Project Structure of IntelliJ IDE.)


(Note: The author of this repo used an absolute path to the repo. Modify path to be relative path to the app)

Provide the path to *.apk. 

Build the Maven project using your perferred method. Your IDE may prompt you to auto-apply some settings, in which case confirm them.
If you are running tests locally against an Andrid Emulator, make sure to start the local Appium server and emulator in Android Studio 
before running tests, otherwise the tests will fail.

If running against App Center, you will need to start the local Appium server before running tests, otherwise the tests will fail.

# Building and Running Tests on iOS
(Note: The author of this repo used an absolute path to the repo. Modify path to be relative path to the app)
(Note: Only .IPA files are compatible in App Center Test, because physical iOS devices are used, not simulators)

Provide the path to *.ipa. 

You have to make some setup specific modifications to the tests to make them runnable locally. Those are documented here:
Initial / Simulator setup: http://appium.io/docs/en/drivers/ios-xcuitest/index.html
Additional steps for real devices: http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/
The sample code also has commented lines on how you can modify it to run locally: src/test/java/com/agilethought/Utils/DriverManager.java
Build the Maven project using your perferred method. Your IDE may prompt you to auto-apply some settings, in which case confirm them.

If you are running tests locally against an iOS Emulator, make sure to start the local Appium server and emulator in xCode 
before running tests, otherwise the tests will fail.

If running against App Center, you will need to start the local Appium server before running tests, otherwise the tests will fail.
(Note: Only .IPA files are compatible in App Center Test, because physical iOS devices are used, not simulators)

# Uploading Apps and Tests
Build the Maven project.
Generate a command line for upload. Directions (https://github.com/King-of-Spades/AppCenter-Samples/#upload-commands)

Run the upload command with project-specific arguments:
OS X paste your command as the value for 'AppCenter_Test_Command' in 'upload.sh'. In terminal navigate to the Maven folder and run 'sh upload.sh' to generate the 'test/upload' folder and then upload to AppCenter/Test
Windows The 'upload.sh' file is not technically compatible with Windows, however it shows how to modify the generated command to upload this sample manually.
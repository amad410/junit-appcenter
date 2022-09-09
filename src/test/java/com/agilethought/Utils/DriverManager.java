package com.agilethought.Utils;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Driver Manager class to initialize driver based on
 * platform (i.e., Android or iOS).
 */
public class DriverManager {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<EnhancedAndroidDriver<MobileElement>> _edriver = new ThreadLocal<>();
    public AppiumDriver getDriver(){
        return driver.get();
    }


    /*public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }*/

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver(String platformName) throws Exception {
        //AppiumDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if(this.driver.get()== null){
            try{
                switch(platformName){
                    case "Android":
                        EnhancedAndroidDriver<MobileElement> driver = null;

                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
                        ///TODO: The MobileCapabilityType.App should point to the location of the released *.apk file within the application solution
                        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Antwan.Maddox\\source\\repos\\junit-appcentertest\\apps\\weather-app-debug.apk");
                        ///TODO: Alternatively, the MobileCapabilityType.App should point to the repo URL location of the released *.apk file within the application solution
                        //capabilities.setCapability(MobileCapabilityType.APP, "[path to local repo]/[*.apk]");
                        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
                        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
                        driver = Factory.createAndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                        this.driver.set(driver);
                        break;
                    case "iOS":
                        EnhancedIOSDriver<MobileElement> iOSDriver = null;
                        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
                        /***
                         Commented Out lines below are only used for running local tests, not in App Center where they will be ignored
                         1. Run 'xcrun instruments -s devices' in terminal
                         2. Uncomment & paste the device or simulator ID you need to replace <Device ID> below
                            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "<Device ID>");
                            capabilities.setCapability(MobileCapabilityType.UDID, "<Device ID>");

                          3. (Use only when running on a local device) Set your Team ID for your signing identity and uncomment below
                             capabilities.setCapability("xcodeOrgId", "<Team ID>");
                             capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                             capabilities.setCapability("showXcodeLog", true);

                           4. Uncomment the lines for either the iOS simulator or iOS device below
                              (Simulator) *Make sure to unzip the included file
                              String appPath = "/Users/kentgreen/Projects/AppCenter-Test-Samples/Appium/iOS/UITestDemo.iOS.app";
                              capabilities.setCapability(MobileCapabilityType.APP, appPath);
                             (Device)
                             String ipaPath = "/Users/kentgreen/Projects/AppCenter-Test-Samples/Appium/iOS/UITestDemo.ipa";
                             capabilities.setCapability(MobileCapabilityType.APP, ipaPath);
                        ***/
                        ///TODO: The MobileCapabilityType.App should point to the location of the released *.app file within the application solution
                        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Antwan.Maddox\\source\\repos\\junit-appcentertest\\apps\\[*.app]");
                        ///TODO: Alternatively, the MobileCapabilityType.App should point to the repo URL location of the released *.app file within the application solution
                        //capabilities.setCapability(MobileCapabilityType.APP, "[path to local repo]/[*.app]");
                        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
                        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                        iOSDriver = Factory.createIOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                        this.driver.set(iOSDriver);
                        break;
                }
                if(driver == null){
                    throw new Exception("driver is null. ABORT!!!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

    }

}

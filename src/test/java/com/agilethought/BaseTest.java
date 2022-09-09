package com.agilethought;

import com.agilethought.Utils.DriverManager;
import com.agilethought.Utils.TestUtils;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.logging.log4j.ThreadContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class BaseTest {

    protected static ThreadLocal<AppiumDriver> _driver = new ThreadLocal<AppiumDriver>();
    private static AppiumDriverLocalService _server;
    protected static ThreadLocal <Properties> props = new ThreadLocal<Properties>();
    protected static ThreadLocal <HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    protected static ThreadLocal <String> platform = new ThreadLocal<String>();
    protected static ThreadLocal <String> dateTime = new ThreadLocal<String>();
    protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
    private DriverManager _driverManager;
    private static TestUtils utils;
    InputStream inputStream;
    public AppiumDriver getDriver() {
        return _driver.get();
    }
    public void setDriver(AppiumDriver driver) {
        _driver.set(driver);
    }

    @Before
    public void beforeTest() throws Exception {

        utils = new TestUtils();
        ThreadContext.put("ROUTINGKEY", "ServerLogs");
        setDateTime(utils.dateTime());
        setPlatform(System.getProperty("platformName"));
        InputStream inputStream = null;
        InputStream stringsis = null;

        String strFile = "logs" + File.separator + System.getProperty("platformName");
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        ThreadContext.put("ROUTINGKEY", strFile);
        utils.log().info("log path: " + strFile);

        try{

            switch(System.getProperty("platformName")) {
                case "Android":
                    Android_setUp();
                    break;
                case "iOS":
                    iOS_setUp();
                    break;
                default:
                    throw new Exception("Invalid platform! - " + System.getProperty("platformName"));
            }
        }
        catch (Exception e) {
            utils.log().fatal("driver initialization failure. ABORT!!!\n" + e.toString());
            throw e;
        } finally {
            if(inputStream != null) {
                inputStream.close();
            }
            if(stringsis != null) {
                stringsis.close();
            }
        }
    }

    public void takeScreenshot(String actionDesc){

        switch(System.getProperty("platformName")) {
            case "Android":
                EnhancedAndroidDriver<MobileElement> androidDriver = (EnhancedAndroidDriver<MobileElement>) getDriver();
                androidDriver.label(actionDesc);
                break;
            case "iOS":
                EnhancedIOSDriver<MobileElement> iOSDriver = (EnhancedIOSDriver<MobileElement>) getDriver();
                iOSDriver.label(actionDesc);
                break;
        }
    }


    public void Android_setUp() throws Exception {
        AppiumDriver driver;
        Properties prop = new Properties();
        _driverManager =  new DriverManager();
        _driverManager.initializeDriver( System.getProperty("platformName"));

         setDriver(_driverManager.getDriver());
    }

    public void iOS_setUp() throws Exception {
        AppiumDriver driver;
        Properties prop = new Properties();
        String propFileName = System.getProperty("user.dir")+"/src/main/resources/configs/iOS.properties";

        utils.log().info("load " + propFileName);
        inputStream = new FileInputStream(propFileName);
        setProps(prop);
        props.get().load(inputStream);
        _driverManager =  new DriverManager();
        _driverManager.initializeDriver( System.getProperty("platformName"));
        setDriver(_driverManager.getDriver());
    }

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }


    public String getPlatform() {
        return platform.get();
    }
    public void setProps(Properties props2) {
        props.set(props2);
    }
    public ThreadLocal<Properties> getProps() {
        return props;
    }
    public HashMap<String, String> getStrings() {
        return strings.get();
    }

    public void setStrings(HashMap<String, String> strings2) {
        strings.set(strings2);
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public void setDateTime(String dateTime2) {
        dateTime.set(dateTime2);
    }

    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    public void closeApp() {
        ((InteractsWithApps) getDriver()).closeApp();
    }

    public void launchApp() {
        ((InteractsWithApps) getDriver()).launchApp();
    }
   /* @After
    public void tearDown() {
        if(getDriver() != null){
            getDriver().quit();
        }
    }*/
}

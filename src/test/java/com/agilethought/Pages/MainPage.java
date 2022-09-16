package com.agilethought.Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MainPage extends BasePage {

    @AndroidFindBy(id = "com.weatherapp:id/spinner")
    @iOSXCUITFindBy(id = "com.weatherapp:id/spinner")
    MobileElement locationDropDown;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
    MobileElement londonOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
    MobileElement ryhadhOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
    @iOSXCUITFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
    MobileElement abuDhabiOption;

    @AndroidFindBy(id = "com.weatherapp:id/btn_view_weather")
    @iOSXCUITFindBy(id = "com.weatherapp:id/btn_view_weather")
    MobileElement weatherBtn;

    @AndroidFindBy(id = "com.weatherapp:id/tv_temperature")
    @iOSXCUITFindBy(id = "com.weatherapp:id/tv_temperature")
    MobileElement temperature;

    @AndroidFindBy(id = "com.weatherapp:id/tv_weather_condition")
    @iOSXCUITFindBy(id = "com.weatherapp:id/tv_weather_condition")
    MobileElement weatherCondition;

    @AndroidFindBy(id = "com.weatherapp:id/tv_humidity_value")
    @iOSXCUITFindBy(id = "com.weatherapp:id/tv_humidity_value")
    MobileElement humidity;

    @AndroidFindBy(id = "com.weatherapp:id/tv_pressure_value")
    @iOSXCUITFindBy(id = "com.weatherapp:id/tv_pressure_value")
    MobileElement pressure;

    @AndroidFindBy(id = "com.weatherapp:id/tv_visibility_value")
    @iOSXCUITFindBy(id = "com.weatherapp:id/tv_visibility_value")
    MobileElement visibility;

    @AndroidFindBy(id = "com.weatherapp:id/tv_sunrise_time")
    @iOSXCUITFindBy(id = "com.weatherapp:id/tv_sunrise_time")
    MobileElement timeToSunrise;

    @AndroidFindBy(id = "com.weatherapp:id/tv_sunset_time")
    @iOSXCUITFindBy(id = "com.weatherapp:id/tv_sunset_time")
    MobileElement timeToSunset;

    public void selectLondon(){
        click(locationDropDown);
        click(londonOption);
    }
    public void selectRiyadh(){
        click(locationDropDown);
        click(ryhadhOption);
    }
    public void selectAbuDhabi(){
        click(locationDropDown);
        click(abuDhabiOption);
    }
    public void selectWeatherBtn(){
        click(weatherBtn,20);
    }

    public void closeApp(){
        closeApplication();
    }

    public Boolean isTempDisplayed()
    {
        waitForVisibility(temperature,5);

        return temperature.isDisplayed();

    }

    public Boolean isWeatherConditionDisplayed()
    {
        waitForVisibility(weatherCondition,5);
        return weatherCondition.isDisplayed();

    }
    public Boolean isHumidityDisplayed()
    {
        waitForVisibility(humidity,5);
        return humidity.isDisplayed();

    }
    public Boolean isPressureDisplayed()
    {
        waitForVisibility(pressure,5);
        return pressure.isDisplayed();

    }

    public Boolean isVisibilityDisplayed()
    {
        waitForVisibility(visibility,5);
        return visibility.isDisplayed();

    }
    public Boolean istimeToSunriseDisplayed()
    {
        waitForVisibility(timeToSunrise,5);
        return timeToSunrise.isDisplayed();

    }
    public Boolean istimeToSunsetDisplayed()
    {
        waitForVisibility(timeToSunset,5);
        return timeToSunset.isDisplayed();

    }

}

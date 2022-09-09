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
        return temperature.isDisplayed();

    }

    public Boolean isWeatherConditionDisplayed()
    {
        return weatherCondition.isDisplayed();

    }
    public Boolean isHumidityDisplayed()
    {
        return humidity.isDisplayed();

    }
    public Boolean isPressureDisplayed()
    {
        return pressure.isDisplayed();

    }

    public Boolean isVisibilityDisplayed()
    {
        return visibility.isDisplayed();

    }
    public Boolean istimeToSunriseDisplayed()
    {
        return timeToSunrise.isDisplayed();

    }
    public Boolean istimeToSunsetDisplayed()
    {
        return timeToSunset.isDisplayed();

    }

}

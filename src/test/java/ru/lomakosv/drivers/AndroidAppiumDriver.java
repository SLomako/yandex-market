package ru.lomakosv.drivers;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nonnull;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import ru.lomakosv.configs.ConfigReader;

public class AndroidAppiumDriver implements WebDriverProvider {

    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String VERSION = ConfigReader.emulatorConfig.version();
    private static final String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static final String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setLanguage("en")
                .setLocale("US")
                .setPlatformName(ANDROID)
                .setPlatformVersion(VERSION)
                .setDeviceName(DEVICE_NAME)
                .setAppPackage(APP_PACKAGE)
                .setAppActivity(APP_ACTIVITY)
                .setApp(getAppPath())
                .setNoReset(false)
                .setFullReset(true);

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private static URL getAppiumServerUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        File app = new File(APP);
        if (!app.exists()) {
            throw new AssertionError("Application file not found: " + app.getAbsolutePath());
        }
        return app.getAbsolutePath();
    }
}


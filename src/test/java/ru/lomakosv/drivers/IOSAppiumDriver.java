package ru.lomakosv.drivers;


import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nonnull;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import ru.lomakosv.configs.ConfigReader;

public class IOSAppiumDriver implements WebDriverProvider {

    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String VERSION = ConfigReader.emulatorConfig.version();
    private static final String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();
    private static final String UDID = ConfigReader.emulatorConfig.udid();

    public static IOSDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        XCUITestOptions options = new XCUITestOptions()
                .setUdid(UDID)
                .setPlatformName("iOS")
                .setDeviceName(DEVICE_NAME)
                .autoDismissAlerts()
                .setPlatformVersion(VERSION)
                .setAutomationName("XCUITest")
                .setBundleId(APP_PACKAGE);
        driver = new IOSDriver(getAppiumServerUrl(), options);
        return driver;
    }

    private static URL getAppiumServerUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}


package ru.lomakosv.drivers;


import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nonnull;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import ru.lomakosv.configs.ConfigReader;

public class LocalDriver implements WebDriverProvider {

    private static final String DEVICE_NAME = ConfigReader.emulatorConfig.deviceName();
    private static final String VERSION = ConfigReader.emulatorConfig.version();
    private static final String APP_PACKAGE = ConfigReader.emulatorConfig.appPackage();
    private static final String APP_ACTIVITY = ConfigReader.emulatorConfig.appActivity();
    private static final String APP = ConfigReader.emulatorConfig.app();
    private static final String URL = ConfigReader.emulatorConfig.remoteURL();


    public static IOSDriver driver;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
//        UiAutomator2Options options = new UiAutomator2Options();
//
//        options.setAutomationName(ANDROID_UIAUTOMATOR2)
//                .setLanguage("en")
//                .setLocale("US")
//                .setPlatformName(ANDROID)
//                .setPlatformVersion(VERSION)
//                .setDeviceName(DEVICE_NAME)
//                .setAppPackage(APP_PACKAGE)
//                .setAppActivity(APP_ACTIVITY)
//                .setApp(getAppPath())
//                .setNoReset(false)
//                .setFullReset(true);
//
//        return new AndroidDriver(getAppiumServerUrl(), options);
//    }

        XCUITestOptions options = new XCUITestOptions()
                .setUdid("00008020-000E2CC91E12002E")
                .setPlatformName("iOS")
                .setDeviceName("iPhone")
                .autoDismissAlerts()
//                .setApp(getAppPath())

                .setPlatformVersion("17.2")
                .setAutomationName("XCUITest")
                .setBundleId("ru.yandex.blue.market");
        driver = new IOSDriver(getAppiumServerUrl(), options);
        return driver;
    }


//    XCUITestOptions options = new XCUITestOptions()
//            .setUdid("2526A5B0-F56C-48E9-8D53-69C228E1E86F")
//            .setPlatformName("iOS")
//            .setDeviceName("iPhone SE")
////            .setApp("/Users/slomako/Downloads/1/extracted_app/Payload/Beru.app")
//            .setPlatformVersion("17.2")
//            .setNoReset(false)
//            .setFullReset(true)
//            .setAutomationName("XCUITest");
//        IOSDriver driver = new IOSDriver(getAppiumServerUrl(), options);

    // После создания экземпляра драйвера устанавливаем приложение, если оно еще не установлено
//        if (!isAppInstalled(driver, "ru.yandex.blue.market")) {
//            //installApp(driver, "/Users/slomako/Downloads/1/extracted_app/Payload/Beru.app");
//            installApp(driver, "/Users/slomako/StudioProjects/yandex-market/src/test/resources/apps/ru.yandex.blue.market_5.6.6_und3fined.ipa");
//        }
//
//        return driver;
//    }
//
//    // Проверка установлено ли приложение
//    private boolean isAppInstalled(IOSDriver driver, String bundleId) {
//        Map<String, Object> args = new HashMap<>();
//        args.put("bundleId", bundleId);
//        return (boolean) driver.executeScript("mobile: isAppInstalled", args);
//    }
//
//    // Установка приложения
//    private void installApp(IOSDriver driver, String appPath) {
//        Map<String, Object> args = new HashMap<>();
//        args.put("app", appPath);
//        driver.executeScript("mobile: installApp", args);
//    }

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


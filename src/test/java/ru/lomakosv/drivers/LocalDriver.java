package ru.lomakosv.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class LocalDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion("14.0")
                .setDeviceName("Pixel_3a_API_34_extension_level_7_arm64-v8a")
                .setApp(getAppPath())
                .setNoReset(false)
                .setFullReset(true)
                .setAppPackage("ru.beru.android")
                .setAppActivity("ru.yandex.market.ui.splash.MarketSplashActivity");

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appVersion = "yandex-market.apk";
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            throw new AssertionError("Application file not found: " + app.getAbsolutePath());
        }
        return app.getAbsolutePath();
    }
}


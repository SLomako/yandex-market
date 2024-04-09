package ru.lomakosv.iostest.utils;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.iOSClassChain;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class AppInitializationManager {

    public void closeInitialPopupsIfNeeded() {
        closePopup();
        confirmLocation();
    }


    private void closePopup() {
        SelenideElement closeButton = $(accessibilityId("WelcomeOnboardingAccessibility.crossButton"));
        if (closeButton.is(visible, Duration.ofSeconds(3))) {
            closeButton.click();
        }
    }

    private void confirmLocation() {
        SelenideElement locationConfirmation = $(iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Да, всё так'`]"));
        if (locationConfirmation.is(visible, Duration.ofSeconds(3))) {
            locationConfirmation.click();
        }
    }
}

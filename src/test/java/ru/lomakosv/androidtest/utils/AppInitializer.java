package ru.lomakosv.androidtest.utils;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

public class AppInitializer {

    public void openApp() {
        open();
        waitForAppToBeReady();
    }

    private void waitForAppToBeReady() {
        Selenide.$(androidUIAutomator("new UiSelector().text(\"Cancel\")"))
                .shouldBe(visible)
                .should(disappear);
    }
}

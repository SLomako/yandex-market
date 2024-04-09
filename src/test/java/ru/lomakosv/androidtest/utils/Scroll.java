package ru.lomakosv.androidtest.utils;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

import com.codeborne.selenide.Selenide;

import java.util.Map;

import io.qameta.allure.Step;

public class Scroll {

    @Step("Прокрутить страницу до элемента с текстом '{0}' и кликнуть по нему")
    public static void scrollToAndClick(String text) {
        Selenide.executeJavaScript("mobile: scroll", Map.of(
                "strategy", "-android uiautomator",
                "selector", "new UiSelector().text(\"" + text + "\")",
                "action", "scroll"
        ));
        $(androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + text + "\")")).click();
    }
}

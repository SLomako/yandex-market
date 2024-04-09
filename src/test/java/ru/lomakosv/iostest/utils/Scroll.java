package ru.lomakosv.iostest.utils;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.iOSClassChain;

import io.qameta.allure.Step;

public class Scroll {

    @Step("Прокрутить страницу до элемента с текстом '{0}' и кликнуть по нему")
    public static void scrollToAndClick(String text) {

//        //Сделать скролл до элемента если его нет на экране
//        Map<String, Object> scrollObject = new HashMap<>();
//        scrollObject.put("direction", "down");
//        driver.executeScript("mobile: scroll", scrollObject);
//        $(androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + text + "\")")).click();

        $(iOSClassChain("**/XCUIElementTypeStaticText[`name == '" + text + "'`]")).click();
    }
}

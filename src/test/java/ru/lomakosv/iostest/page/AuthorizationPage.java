package ru.lomakosv.iostest.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class AuthorizationPage {

    private final SelenideElement backButton = $(accessibilityId("Назад"));

    @Step("Нажать на стрелку 'Назад'")
    public void clickBackArrow() {
        backButton.shouldBe(visible).click();
    }
}
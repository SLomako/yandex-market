package ru.lomakosv.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class AuthorizationPage {

    private final SelenideElement backButton = $(accessibilityId("Назад"));

    //todo проверить что страница авторизации загрузилась
    public void navigateBackToAuthorizationPage() {
        backButton.shouldBe(visible).click();
    }
}

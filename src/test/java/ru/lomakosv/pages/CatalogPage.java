package ru.lomakosv.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Map;

import io.qameta.allure.Step;

public class CatalogPage {

    private final SelenideElement cartButton = $(androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/cartButtonDecIncButtons\").instance(0)"));

    @Step("Добавить первый товар в корзину")
    public String addFirstProductToCart() {
        scrollToCartButtonIfNeeded();

        String productName = $(id("ru.beru.android:id/description")).text();
        cartButton.shouldBe(visible).click();
        return productName;
    }

    private void scrollToCartButtonIfNeeded() {
        if (!cartButton.is(visible, Duration.ofSeconds(8))) {
            Selenide.executeJavaScript("mobile: scroll", Map.of(
                    "strategy", "-android uiautomator",
                    "selector", "new UiSelector().resourceId(\"ru.beru.android:id/cartButtonDecIncButtons\")", // todo глянуть может как то из утил сделать
                    "action", "scroll"
            ));
        }
    }
}
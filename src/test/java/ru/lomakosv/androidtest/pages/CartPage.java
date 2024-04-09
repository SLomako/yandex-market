package ru.lomakosv.androidtest.pages;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

import io.qameta.allure.Step;

public class CartPage {

    @Step("Проверить наличие продукта '{0}' в корзине")
    public boolean isProductPresentInCart(String productName) {
        return $(androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + productName + "\")"))
                .exists();
    }
}

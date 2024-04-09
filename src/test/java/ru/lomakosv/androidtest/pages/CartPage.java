package ru.lomakosv.androidtest.pages;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import io.qameta.allure.Step;

public class CartPage {

    @Step("Проверить наличие продукта '{0}' в корзине")
    public boolean isProductPresentInCart(String productName) {
        return $(androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + productName + "\")"))
                .exists();
    }

    @Step("Удалить выбранные товары")
    public void deleteSelectedItems() {
        $(androidUIAutomator("new UiSelector().text(\"Удалить выбранные\")")).click();
    }

    @Step("Подтвердить удаление всех выбранных товаров из корзины")
    public void confirmDeletionOfAllItemsInCart() {
        $(androidUIAutomator("new UiSelector().text(\"Удалить товары из корзины\")")).click();
    }

    @Step("Проверить, что корзина пуста")
    public boolean isCartEmpty() {
        return $(androidUIAutomator("new UiSelector().text(\"Корзина пустая\")"))
                .shouldBe(Condition.visible, Duration.ofSeconds(8))
                .exists();
    }
}

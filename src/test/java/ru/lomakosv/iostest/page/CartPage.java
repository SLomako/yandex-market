package ru.lomakosv.iostest.page;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import io.qameta.allure.Step;

public class CartPage {

    @Step("Проверить наличие продукта '{0}' в корзине")
    public boolean isProductPresentInCart(String productName) {
        return $(accessibilityId(productName)).shouldBe(Condition.visible, Duration.ofSeconds(8)).exists();
    }

    @Step("Удалить выбранные товары")
    public void deleteSelectedItems() {
        $(accessibilityId("Удалить выбранные")).click();
    }

    @Step("Подтвердить удаление всех выбранных товаров из корзины")
    public void confirmDeletionOfAllItemsInCart() {
        $(accessibilityId("Удалить товары из корзины")).click();
    }

    @Step("Проверить, пуста ли корзина")
    public boolean isCartEmpty() {
        return $(accessibilityId("Корзина пустая"))
                .shouldBe(Condition.visible, Duration.ofSeconds(8))
                .exists();
    }
}

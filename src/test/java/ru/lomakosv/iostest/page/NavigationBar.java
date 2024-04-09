package ru.lomakosv.iostest.page;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

import io.qameta.allure.Step;

public class NavigationBar {

    @Step("Нажать на иконку каталога")
    public void clickOnCatalog() {
        $(accessibilityId("TabBarAccessibility.catalogTab")).click();
    }

    @Step("Нажать на иконку корзины")
    public void clickOnCart() {
        $(accessibilityId("TabBarAccessibility.cartTab")).click();
    }
}

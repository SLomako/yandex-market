package ru.lomakosv.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

public class NavigationBar {

    private final SelenideElement cartIcon = $(androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(4)"));

    @Step("Нажать на иконку каталога и проверить видимость поля поиска")
    public void clickOnCatalog() {
        $(androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(1)")).click();
        $(androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/viewSearchAppBarLayoutInput\")"))
                .shouldHave(visible, text("Найти товары"));
    }

    @Step("Нажать на иконку корзины и проверить видимость страницы корзины")
    public void clickOnCart() {
        cartIcon.click();
        cartIcon.click();
        $(androidUIAutomator("new UiSelector().text(\"Корзина\")"))
                .shouldHave(visible, text("Корзина"));
    }
}

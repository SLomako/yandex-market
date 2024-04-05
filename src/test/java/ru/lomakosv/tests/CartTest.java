package ru.lomakosv.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest extends TestBase {

    private String bookName;

    @Test
    void testCaseOne() {
        step("Закрыть окно авторизации для выбора Яндекс аккаунта", () -> {
            $(accessibilityId("Назад")).shouldBe(visible).click();

            $(id("ru.beru.android:id/closeButton")).click();
            $(id("com.android.permissioncontroller:id/permission_deny_button")).click();
            $(id("ru.beru.android:id/closeButton")).click();
            $(id("ru.beru.android:id/closeButton")).click();
            $(id("ru.beru.android:id/negativeButton")).click();
        });
        step("Перейти в каталог, во вторую вкладку для выбора разделов", () -> {
            $(androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(1)")).click();
        });

        step("Перейти в раздел 'Книги'", () -> {
            Selenide.sleep(1000);
            Selenide.executeJavaScript("mobile: scroll", Map.of(
                    "strategy", "-android uiautomator",
                    "selector", "new UiSelector().text(\"Книги\")",
                    "action", "scroll"
            ));
            Selenide.sleep(1000);
            //$(androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(8)")).click();
            $(androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"Книги\")")).click();
        });

        step("Добавить первый предложенный товар в корзину по кнопке 'В корзину'", () -> {
            SelenideElement cartButton = $(androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/cartButtonDecIncButtons\").instance(0)"));

            if (!cartButton.exists()) {
                Selenide.executeJavaScript("mobile: scroll", Map.of(
                        "strategy", "-android uiautomator",
                        "selector", "new UiSelector().resourceId(\"ru.beru.android:id/cartButtonDecIncButtons\")",
                        "action", "scroll"
                ));
            }

            bookName = $(id("ru.beru.android:id/description")).text();
            System.out.println("Название книги: " + bookName);
            cartButton.shouldBe(visible).click();

        });

        step("Перейти в корзину и проверить, что выбранный товар отображается в корзине", () -> {
            SelenideElement cartIcon = $(androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(4)"));
            cartIcon.shouldBe(visible).click();
            cartIcon.shouldBe(visible).click();

            boolean isBookPresent = $(androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + bookName + "\")")).exists();

            assertTrue(isBookPresent, "Книга с названием '" + bookName + "' не найдена на странице!");

        });
    }
}
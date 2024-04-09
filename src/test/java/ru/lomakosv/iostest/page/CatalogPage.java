package ru.lomakosv.iostest.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.iOSClassChain;
import static ru.lomakosv.drivers.IOSAppiumDriver.driver;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.qameta.allure.Step;

public class CatalogPage {

    private final SelenideElement firstCell = $(iOSClassChain("**/XCUIElementTypeOther[`name == 'TabBarAccessibility.tabBar'`]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeScrollView[1]/XCUIElementTypeCell[1]"));
    private final SelenideElement bookButton = firstCell.$(iOSClassChain("**/XCUIElementTypeOther[`name == 'RedesignedSnippetViewAccessebility.descriptionView'`][1]/XCUIElementTypeOther/XCUIElementTypeButton"));

    @Step("Добавить первый товар в корзину")
    public String addFirstProductToCart() {
        scrollToCartButtonIfNeeded();

        String productName = bookButton.getAttribute("name");
        $(iOSClassChain("**/XCUIElementTypeStaticText[`name == \"В корзину\"`][1]")).click();
        return productName;
    }

    private void scrollToCartButtonIfNeeded() {
        if (!firstCell.is(visible, Duration.ofSeconds(8))) {
            Map<String, Object> scrollObject = new HashMap<>();
            scrollObject.put("direction", "down");
            driver.executeScript("mobile: scroll", scrollObject);
        }
    }
}
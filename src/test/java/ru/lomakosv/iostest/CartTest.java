package ru.lomakosv.iostest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.AllureId;
import ru.lomakosv.iostest.page.AuthorizationPage;
import ru.lomakosv.iostest.page.CartPage;
import ru.lomakosv.iostest.page.CatalogPage;
import ru.lomakosv.iostest.page.NavigationBar;
import ru.lomakosv.iostest.utils.AppInitializationManager;
import ru.lomakosv.iostest.utils.Scroll;

public class CartTest extends TestBase {

    AppInitializationManager appInitializationHandler = new AppInitializationManager();

    AuthorizationPage authorizationPage = new AuthorizationPage();

    NavigationBar navigationBar = new NavigationBar();

    CatalogPage catalogPage = new CatalogPage();

    CartPage cartPage = new CartPage();

    @Test
    @AllureId("0002")
    @DisplayName("Тест-кейс №2:")
    void testAddAndDeleteProductInCart() {

        step("Закрыть окно авторизации для выбора Яндекс аккаунта", () -> {
            authorizationPage.clickBackArrow();
            appInitializationHandler.closeInitialPopupsIfNeeded();
        });

        step("Перейти в каталог, во вторую вкладку для выбора разделов", () -> {
            navigationBar.clickOnCatalog();
        });

        step("Перейти в раздел 'Книги'", () -> {
            Scroll.scrollToAndClick("Книги");
        });

        step("Добавить первый предложенный товар в корзину по кнопке 'В корзину'", () -> {
            catalogPage.addFirstProductToCart();
        });

        step("Перейти в корзину, удалить выбранный товар и проверить, что корзина пуста", () -> {
            navigationBar.clickOnCart();
            cartPage.deleteSelectedItems();
            cartPage.confirmDeletionOfAllItemsInCart();
            assertTrue(cartPage.isCartEmpty(), "Корзина не пуста!");
        });
    }
}

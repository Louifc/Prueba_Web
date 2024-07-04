package com.nttdata.steps;

import com.nttdata.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class CompraSteps {

    private WebDriver driver;
    private ProductPage productPage;

    // Constructor para inicializar WebDriver y ProductPage
    public CompraSteps(WebDriver driver) {
        this.driver = driver;
        this.productPage = new ProductPage(driver);
    }

    // Navegar a la página de la tienda
    public void abrirPaginaDeLaTienda() {
        driver.get("https://tu-pagina-de-tienda.com");
    }

    // Iniciar sesión en la tienda
    public void iniciarSesion(String usuario, String clave) {
        productPage.login(usuario, clave);
    }

    // Navegar a una categoría y subcategoría específica
    public void navegarACategoriaYSubcategoria(String categoria, String subcategoria) {
        productPage.navigateToCategory(categoria, subcategoria);
    }

    // Agregar productos al carrito
    public void agregarProductoAlCarrito(int cantidad) {
        productPage.addFirstProductToCart(cantidad);
    }

    // Validar la confirmación de producto agregado en el popup
    public void validarConfirmacionProductoAgregado() {
        assert productPage.isProductAddedConfirmationDisplayed();
    }

    // Validar el monto total en el popup
    public void validarMontoTotalEnPopup() {
        double totalAmount = productPage.getTotalAmountFromPopup();
        // Aquí se debe añadir lógica para comparar el monto total esperado
    }

    // Finalizar la compra
    public void finalizarCompra() {
        productPage.proceedToCheckout();
    }

    // Validar el título de la página del carrito
    public void validarTituloPaginaCarrito() {
        assert productPage.isCartPageTitleDisplayed();
    }

    // Validar el cálculo de precios en el carrito
    public void validarCalculoPreciosEnCarrito() {
        assert productPage.areCartPricesValid();
    }
}

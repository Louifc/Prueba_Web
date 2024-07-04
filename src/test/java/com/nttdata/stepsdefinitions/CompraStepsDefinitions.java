package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CompraSteps;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompraStepsDefinitions {

    private WebDriver driver;
    private CompraSteps compraSteps;

    public CompraStepsDefinitions() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        compraSteps = new CompraSteps(driver);
    }

    @Given("me encuentro en la página de la tienda")
    public void me_encuentro_en_la_página_de_la_tienda() {
        compraSteps.abrirPaginaDeLaTienda();
    }

    @Given("me logueo con mi usuario {string} y clave {string}")
    public void me_logueo_con_mi_usuario_y_clave(String usuario, String clave) {
        compraSteps.iniciarSesion(usuario, clave);
    }

    @When("navego a la categoría {string} y subcategoría {string}")
    public void navego_a_la_categoría_y_subcategoría(String categoria, String subcategoria) {
        compraSteps.navegarACategoriaYSubcategoria(categoria, subcategoria);
    }

    @When("agrego {int} unidades del primer producto al carrito")
    public void agrego_unidades_del_primer_producto_al_carrito(Integer cantidad) {
        compraSteps.agregarProductoAlCarrito(cantidad);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void valido_en_el_popup_la_confirmación_del_producto_agregado() {
        compraSteps.validarConfirmacionProductoAgregado();
    }

    @Then("valido en el popup que el monto total sea calculado correctamente")
    public void valido_en_el_popup_que_el_monto_total_sea_calculado_correctamente() {
        compraSteps.validarMontoTotalEnPopup();
    }

    @When("finalizo la compra")
    public void finalizo_la_compra() {
        compraSteps.finalizarCompra();
    }

    @Then("valido el título de la página del carrito")
    public void valido_el_título_de_la_página_del_carrito() {
        compraSteps.validarTituloPaginaCarrito();
    }

    @Then("vuelvo a validar el cálculo de precios en el carrito")
    public void vuelvo_a_validar_el_cálculo_de_precios_en_el_carrito() {
        compraSteps.validarCalculoPreciosEnCarrito();
    }
}

Feature: Validación del Carrito de Compras

  @compras
  Scenario: Validación del Precio de un Producto
    Given me encuentro en la página de la tienda
    And me logueo con mi usuario "usuario_ejemplo" y clave "clave_ejemplo"
    When navego a la categoría "Clothes" y subcategoría "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el título de la página del carrito
    And vuelvo a validar el cálculo de precios en el carrito

@test
Feature: Formulario de Contacto

  Yo como PO
  Quiero un formulario de Contacto
  Para que mis clientes/ proveedores tengan un canal de comunicación con la empresa


  Background: el usuario se encuentra en el formulario de contacto
    Given que el usuario esta en la opcion Contact us

  Scenario Outline: Deberia enviar el mensaje de contacto cuando enviamos todos los campos requeridos
    When el usuario completa el formulario con los campos requeridos
      | tituloAsunto   | email   | ordenReferencia   | mensaje   | archivoAdjunto   |
      | <tituloAsunto> | <email> | <ordenReferencia> | <mensaje> | <archivoAdjunto> |

    Then el usuario deberia poder ver el mensaje <mensajeConfirmacion>
    Examples:
      | tituloAsunto     | email        | ordenReferencia | mensaje                                         | archivoAdjunto | mensajeConfirmacion                                  |
      | Customer service | pepito@g.com | 01356222        | Por favor enviar la orden lo mas rapido posible |                | Your message has been successfully sent to our team. |
      | Webmaster | pepito@g.com | 01356222        | Por favor enviar la orden lo mas rapido posible |                | Your message has been successfully sent to our team. |

#    Examples:
#      | cabecera         | email            | ordenReferencia | mensaje                                                      |
#      | Customer service | pepito@g.com     | 01356222        | Por favor enviar la orden lo mas rapido posible              |
#      | Webmaster        | pepito@perez.com | 54448410        | Por favor habilitar la opcion de pago con tarjeta de credito |

#  Scenario Outline: El campo orden referencia solo debe admitir valores numericos
#    When el usuario ingresa el valor <"03121544"> en campo orden referencia
#    Then el usuario deberia poder ver que el color del campo es <"verde">
#    Examples:
#      | "03121544" | "verde" |
#      | "@#$%."    | "rojo"  |
#      | "prueba"   | "rojo"  |
#


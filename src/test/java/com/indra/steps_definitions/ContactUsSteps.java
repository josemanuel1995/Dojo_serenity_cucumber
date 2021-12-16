package com.indra.steps_definitions;


import com.indra.Acciones;
import com.indra.models.FormularioContacto;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class ContactUsSteps extends PageObject {

    @Managed
    WebDriver driver;

    @Given("^que el usuario esta en la opcion (.*)$")
    public void queElUsuarioEstaEnLaOpcion(String opcionDelMenu) throws Throwable {
        driver.get("http://automationpractice.com/");
        Acciones.irALaOpcion(driver, opcionDelMenu);
    }

    @When("el usuario completa el formulario con los campos requeridos")
    public void elUsuarioCompletaElFormularioConLosCamposRequeridos(List<FormularioContacto> formularioContactos) {
//        Select tituloAsunto = new Select(driver.findElement(By.id("id_contact")));
//        tituloAsunto.selectByVisibleText(formularioContactos.get(0).getTituloAsunto());
        selectFromDropdown(getDriver().findElement(By.id("id_contact")), formularioContactos.get(0).getTituloAsunto());

//        driver.findElement(By.id("email")).sendKeys(formularioContactos.get(0).getEmail());
        enter(formularioContactos.get(0).getEmail()).into(By.id("email"));

        driver.findElement(By.id("id_order")).sendKeys(formularioContactos.get(0).getOrdenReferencia());
        driver.findElement(By.id("message")).sendKeys(formularioContactos.get(0).getMensaje());
        Serenity.takeScreenshot();
        driver.findElement(By.id("submitMessage")).click();
    }

    @Then("^el usuario deberia poder ver el mensaje (.*)$")
    public void elUsuarioDeberiaPoderVerElMensaje(String mensaje) {
        Assert.assertEquals("El mensaje debe coincidir", mensaje, driver.findElement(By.xpath("//p[contains(.,'Your message has been successfully sent to our team.')]")).getText());
    }
}

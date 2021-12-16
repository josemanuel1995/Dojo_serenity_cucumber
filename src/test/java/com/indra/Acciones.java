package com.indra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Acciones {
    public static void irALaOpcion(WebDriver driver,String opcion){
        driver.findElement(By.xpath("//nav//a[contains(text(),'"+opcion+"')]")).click();
    }
}

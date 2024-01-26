/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.enums;

/**
 *
 * @author Julian_Velasco
 */
public enum Seccion {
    BIBLIOTECA("Biblioteca"), DECANATO("Decanato"), SECRETARIA("Secretaria"), CAFETERIA("Cafeteria"), SEGURIDAD("Seguridad");
    public String seccion;

    Seccion(String seccion) {
        this.seccion = seccion;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.enums;

/**
 *
 * @author Julian_Velasco
 */
public enum EstadoCivil {
    SOLTERO("Soltero"), UNION_LIBRE("Unión libre"), CASADO("Casado"), VIUDO("Viudo"), DIVORCIADO("Divorciado");
    public String estado;

    EstadoCivil(String estado) {
        this.estado = estado;
    }
}
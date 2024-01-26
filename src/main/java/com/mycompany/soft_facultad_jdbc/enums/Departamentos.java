/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.enums;

/**
 *
 * @author Julian_Velasco
 */
public enum Departamentos {
    MATEMATICAS("Matematicas"), LENGUAJES("Lenguajes"), ARQUITECTURA("Arquitectura"), CIENCIAS("Ciencias"), DERECHO("Derecho"), PROGRAMACION("Programacion");

    public String departamento;

    Departamentos(String departamento) {
        this.departamento = departamento;
    }
}
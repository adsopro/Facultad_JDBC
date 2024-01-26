/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.enums;

/**
 *
 * @author Julian_Velasco
 */
public enum Cursos {
    ALGEBRA("Algebra"), GEOMETRIA("Geometria"), LENGUAS("Lenguas"), ESPANOL("Español"), DISENO("Diseño");
    public String materia;

    Cursos(String materia) {
        this.materia = materia;
    }
}

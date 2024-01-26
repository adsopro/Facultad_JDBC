/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.entidades;

/**
 *
 * @author Julian_Velasco
 */
public final class PersonalDeServicio extends Empleado {

    private String seccion;

    public PersonalDeServicio(String seccion, String anioIncorporacipn, String nDespacho, Integer Id, String nombre, String numero_identificacion, String apellido, String estadoCivil) {
        super(anioIncorporacipn, nDespacho, Id, nombre, numero_identificacion, apellido, estadoCivil);
        this.seccion = seccion;
    }
    

    public PersonalDeServicio() {

    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return super.toString() + "PersonalDeServicio{" + "seccion=" + seccion + '}';
    }

}

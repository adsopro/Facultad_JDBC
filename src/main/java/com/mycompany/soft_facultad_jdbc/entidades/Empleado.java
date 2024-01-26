/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.entidades;

/**
 *
 * @author Julian_Velasco
 */
public class Empleado extends Persona {

    protected String anioIncorporacion, nDespacho;

    public Empleado(String anioIncorporacion, String nDespacho, Integer Id, String nombre, String numero_identificacion, String apellido, String estadoCivil) {
        super(Id, nombre, numero_identificacion, apellido, estadoCivil);
        this.anioIncorporacion = anioIncorporacion;
        this.nDespacho = nDespacho;
    }

    public Empleado(String anioIncorporacion, String nDespacho) {
        this.anioIncorporacion = anioIncorporacion;
        this.nDespacho = nDespacho;
    }

    public Empleado() {
    }

    public String getAnioIncorporacion() {
        return anioIncorporacion;
    }

    public void setAnioIncorporacion(String anioIncorporacion) {
        this.anioIncorporacion = anioIncorporacion;
    }

    public String getnDespacho() {
        return nDespacho;
    }

    public void setnDespacho(String nDespacho) {
        this.nDespacho = nDespacho;
    }
   

}

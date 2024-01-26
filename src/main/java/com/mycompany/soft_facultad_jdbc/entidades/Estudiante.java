/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.entidades;
import java.util.ArrayList;


public final class Estudiante extends Persona {

    protected ArrayList<String> cursos = new ArrayList<>();

    public Estudiante(Integer Id, String nombre, String numero_identificacion, String apellido, String estadoCivil) {
        super(Id, nombre, numero_identificacion, apellido, estadoCivil);
    }

    
    public Estudiante() {
    }

    public ArrayList<String> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<String> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return super.toString() + "Estudiante{" + "cursos=" + cursos + '}';
    }

    
}

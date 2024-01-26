/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.persistencia.pEntidades;

/**
 *
 * @author Julian_Velasco
 */
import com.mycompany.soft_facultad_jdbc.enums.Cursos;
import com.mycompany.soft_facultad_jdbc.persistencia.Dao;
import java.util.ArrayList;

public class CursoDao extends Dao {

    public void crearCursos() {
        try {
            ArrayList <String> cursos = new ArrayList();
            String sql = "";
            sql = "SELECT nombre from Curso";
            consultarBase(sql);
            while(resultado.next()){
                cursos.add(resultado.getString("nombre"));
            }
            for (int i = 0; i < Cursos.values().length; i++) {
                if(!cursos.get(i).equalsIgnoreCase(Cursos.values()[i].materia)){
                sql = "INSERT INTO Curso (nombre) VALUES ('" + Cursos.values()[i].materia + "');";
                insertarModificarEliminar(sql);
                }
            }
           
        } catch (Exception e) {
            System.out.println("No se pueden crear los cursos");;
        }
    }

}
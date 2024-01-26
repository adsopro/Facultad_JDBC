/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.persistencia.pEntidades;

import com.mycompany.soft_facultad_jdbc.entidades.Estudiante;
import com.mycompany.soft_facultad_jdbc.persistencia.Dao;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author migue
 */
public class EstudianteDao extends Dao {

    public void guardarEstudiante(Estudiante estudiante) throws Exception {
        try {
            if (estudiante == null) {
                throw new Exception("Debe indicar un Estudiante");
            }
            
            if(validarPersonaCreadaPorDocumento(estudiante.getNumero_identificacion())){
                System.out.println("La persona ya existe en la base de datos");
            }else{
            String sql = "INSERT INTO Persona (nombre, apellido, numero_identificacion, estado_civil) "
                    + "VALUES ('" + estudiante.getNombre() + "', '" + estudiante.getApellido() + "', '" + estudiante.getNumero_identificacion() + "','" + estudiante.getEstadoCivil() + "');";

            insertarModificarEliminar(sql);

            sql = "SELECT id from persona where numero_identificacion = '" + estudiante.getNumero_identificacion() + "';";
            consultarBase(sql);
            if (resultado.next()) {
                sql = "INSERT INTO Estudiante (id) VALUES (" + resultado.getInt("id") + ");";
                insertarModificarEliminar(sql);
            }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarEstudiante(Estudiante estudiante) throws Exception {
        try {
            if (estudiante == null) {
                throw new Exception("Debe indicar el estudiante que desea modificar");
            }
            String sql = "Select * from estudiante where id = " + estudiante.getId() + ";";
            consultarBase(sql);
            if (!resultado.next()) {
                System.out.println("La persona que desea modificar no es un estudiante");
            } else {
                sql = "UPDATE Persona SET "
                        + "nombre = '" + estudiante.getNombre() + "', apellido = '" + estudiante.getApellido() + "', estado_civil = '" + estudiante.getEstadoCivil() + "' "
                        + "WHERE id = '" + estudiante.getId() + "';";
                insertarModificarEliminar(sql);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarEstudiante(Integer id) throws Exception {
        try {
            if (id == null) {
                throw new Exception("Debe indicar el id de el estudiante");
            }
            String sql = "delete from matricula where estudiante_id = " + id + ";";
            insertarModificarEliminar(sql);

            sql = "DELETE Estudiante, Persona "
                    + "FROM Estudiante "
                    + "NATURAL JOIN Persona "
                    + "WHERE Estudiante.id = " + id;
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Estudiante> listarEstsudiantes() throws Exception {
        try {
            String sql = "SELECT p.id, p.nombre, apellido, numero_identificacion, estado_civil FROM \n"
                    + "PERSONA p NATURAL JOIN estudiante e ;";

            consultarBase(sql);

            Estudiante estudiante = null;
            Collection<Estudiante> estudiantes = new ArrayList();
            ArrayList<String> cursos = new ArrayList();
            while (resultado.next()) {
                estudiante = new Estudiante();
                estudiante.setId(resultado.getInt("id"));
                estudiante.setNombre(resultado.getString("p.nombre"));
                estudiante.setApellido(resultado.getString("apellido"));
                estudiante.setNumero_identificacion(resultado.getString("numero_identificacion"));
                estudiante.setEstadoCivil(resultado.getString("estado_civil"));
                // cursos.add(resultado.getString("c.nombre"));
                for (Estudiante aux : estudiantes) {
                    if (resultado.getInt("id") == aux.getId()) {
                        cursos.add(resultado.getString("c.nombre"));
                    }
                }
                estudiante.setCursos(cursos);
                estudiantes.add(estudiante);
            }
            return estudiantes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error en el procedimiento");
        } finally {
            desconectarBase();
        }
    }

    public Integer buscarEstudiantePorId(Integer id) throws Exception {
        try {
            String sql = "SELECT * FROM PERSONA NATURAL JOIN ESTUDIANTE WHERE ID = " + id + ";";
            consultarBase(sql);
            if (!resultado.next()) {
                return null;
            } else {
                System.out.println("Estudiante encontrado con exito");
                return id;
            }
        } catch (Exception e) {
            throw new Exception("Error al buscar estudiante");
        }
    }

    public void matricularEstudianteaCurso(Estudiante estudiante, String curso) throws Exception {
        try {
            if (estudiante == null || curso.isEmpty()) {
                throw new Exception("Debe indicar el estudiante que desea matricular y el curso al que lo desea matricular");
            }
            String sql = "select id from Curso where nombre = '" + curso + "';";
            consultarBase(sql);
            int id = 0;
            if (resultado.next()) {
                id = resultado.getInt("id");
            }

            sql = "select e.id from estudiante e natural join persona where numero_identificacion = '" + estudiante.getNumero_identificacion() + "';";
            consultarBase(sql);
            if (estudiante.getNumero_identificacion() == null) {
                sql = "INSERT INTO Matricula (estudiante_id, curso_id) VALUES (" + estudiante.getId() + "," + id + ")";
                insertarModificarEliminar(sql);
            } else {
                if (resultado.next()) {
                    sql = "INSERT INTO Matricula (estudiante_id, curso_id) VALUES (" + resultado.getInt("id") + "," + id + ")";
                    insertarModificarEliminar(sql);
                }
            }
            System.out.println("Terminamos");
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }


    public void retirarEstudianteDeCursoPorIdyNombre(Integer id, String nombre) throws Exception {
        try {
            if (id == null && nombre == null) {
                throw new Exception("Verifique que el id o el nombre del curso no esten vacíos");
            }
            int id2 = 0;
            String sql = "SELECT id from curso where nombre = '" + nombre + "';";
            consultarBase(sql);

            if (resultado.next()) {
                id2 = resultado.getInt("id");
            }
            sql = "delete from matricula where estudiante_id = " + id + " and curso_id= '" + id2 + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
      
     public Boolean validarPersonaCreadaPorDocumento(String documento) throws Exception {
        try {
            String sql = "Select * from persona where numero_identificacion = '" + documento + "';";
            consultarBase(sql);
            return resultado.next();
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}

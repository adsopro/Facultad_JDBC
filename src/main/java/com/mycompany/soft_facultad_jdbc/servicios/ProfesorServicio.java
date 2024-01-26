/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soft_facultad_jdbc.servicios;

import com.mycompany.soft_facultad_jdbc.entidades.Profesor;
import com.mycompany.soft_facultad_jdbc.enums.Departamentos;
import com.mycompany.soft_facultad_jdbc.enums.EstadoCivil;
import com.mycompany.soft_facultad_jdbc.persistencia.pEntidades.ProfesorDao;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfesorServicio {

    ProfesorDao prd = new ProfesorDao();
    Profesor profesor = null;
    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void crearProfesor() {
        System.out.println("Bienvenido a la creación de profesores");
        try {
            profesor = new Profesor();
            System.out.println("Ingrese el nombre del profesor");
            profesor.setNombre(sc.next());
            System.out.println("Ingrese el apellido del profesor");
            profesor.setApellido(sc.next());
            System.out.println("Ingrese el numero de identificación del profesor");
            profesor.setNumero_identificacion(sc.next());
            System.out.println("Ingrese el año de incorporación del profesor");
            profesor.setAnioIncorporacion(sc.next());
            System.out.println("Ingrese el número de despacho del profesor");
            profesor.setnDespacho(sc.next());
            profesor.setEstadoCivil(estadoCivil());
            profesor.setDepartamento(departamento());

            prd.guardarProfesor(profesor);

        } catch (Exception e) {
            System.err.println("Error al crear profesor");
            System.err.println(e);
        }
    }

    public void modificarProfesor() {
        System.out.println("Bienvenido a la modificación de profesores");
        try {
            profesor = new Profesor();
            System.out.println("Ingrese el ID de el profesor que desea modificar");
            profesor.setId(sc.nextInt());

            if (prd.buscarProfesorPorId(profesor.getId()) == null) {
                throw new Exception();
            } else {
                System.out.println("Ingrese el nuevo nombre del profesor");
                profesor.setNombre(sc.next());
                System.out.println("Ingrese el nuevo apellido del profesor");
                profesor.setApellido(sc.next());
                System.out.println("Ingrese el año de incorporación del profesor");
                profesor.setAnioIncorporacion(sc.next());
                System.out.println("Ingrese el nuevo número de despacho del profesor");
                profesor.setnDespacho(sc.next());
                profesor.setEstadoCivil(estadoCivil());
                profesor.setDepartamento(departamento());   
                prd.modificarProfesor(profesor);
            }
        } catch (Exception e) {
            System.err.println("Error al crear profesor");
            System.err.println(e);
        }
    }

    public void eliminarProfesor() {
        try {
            System.out.println("Bienvenido a la eliminación de profesores");
            System.out.println("Ingrese el Id del profesor que desea eliminar");
            Integer id = sc.nextInt();
            if (prd.buscarProfesorPorId(id) == null) {
                throw new Exception();
            } else {
                prd.eliminarProfesor(id);
            }
        } catch (Exception e) {
            System.err.println("Error al eliminar profesor");

        }
    }

    public void listarProfesores() {
        System.out.println("Bienvenido a la lista de profesores");
        try {
            ArrayList<Profesor> profesores = (ArrayList<Profesor>) prd.listarProfesores();
            if (profesores.isEmpty()) {
                System.out.println("No hay profesores agregados");
            } else {
                for (Profesor aux : profesores) {
                    System.out.println(aux.toString());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al listar profesores");
        }
    }

    
    public void cambiarDepartamento(){
        try {
            System.out.println("Panel de cambio de departamento");
                profesor = new Profesor();
                System.out.println("Ingrese el ID del profesor que desea cambiar de departamento");
                profesor.setId(sc.nextInt());
                if (prd.buscarProfesorPorId(profesor.getId()) == null) {
                    throw new Exception();
                } else {
                    prd.cambiarDepartamento(profesor.getId(), departamento());
                }
            }catch (Exception e) {
            System.out.println("Error al cambiar de deoartamento");
            }
    }



    public String estadoCivil() {
        System.out.println("Elija el estado civil");
        int cont = 1;
        for (EstadoCivil aux : EstadoCivil.values()) {
            System.out.println((cont++) + ". " + aux.estado);
        }
        int opcion = sc.nextInt();
        validarOpcion(opcion);
        switch (opcion) {
            case 1:
                return EstadoCivil.values()[0].estado;
            case 2:
                return EstadoCivil.values()[1].estado;
            case 3:
                return EstadoCivil.values()[2].estado;
            case 4:
                return EstadoCivil.values()[3].estado;
            case 5:
                return EstadoCivil.values()[4].estado;

        }
        return null;
    }

    public String departamento() {
        System.out.println("Elija el departamento");
        int cont = 1;
        for (Departamentos aux : Departamentos.values()) {
            System.out.println((cont++) + ". " + aux.departamento);
        }
        int opcion = sc.nextInt();
        while (opcion < 1 || opcion > 6) {
            System.out.println("Elija una opción correcta");
            opcion = sc.nextInt();
        }
        switch (opcion) {
            case 1:
                return Departamentos.values()[0].departamento;
            case 2:
                return Departamentos.values()[1].departamento;
            case 3:
                return Departamentos.values()[2].departamento;
            case 4:
                return Departamentos.values()[3].departamento;
            case 5:
                return Departamentos.values()[4].departamento;
            case 6:
                return Departamentos.values()[5].departamento;

        }
        return null;
    }

    public void validarOpcion(int opcion) {
        while (opcion < 1 || opcion > 5) {
            System.out.println("Elija una opción correcta");
            opcion = sc.nextInt();
        }
    }

}

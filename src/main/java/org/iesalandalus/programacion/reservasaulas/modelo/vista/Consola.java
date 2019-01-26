/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.vista;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Tramo;
import java.time.LocalDate;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Permanencia;
import static org.iesalandalus.programacion.rervasaulas.modelo.dominio.Tramo.MANANA;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private static final DateTimeFormatter FORMATO_DIA= new DateTimeFormatter("28/02/2018");
	
	private Consola() {
		//Evito que se cree el constructor por defecto
	}
	
	public static void mostrarMenu() {
		mostrarCabecera("Gestión de Reservas de aulas");
		for (Opcion opcion: Opcion.values()) {
			System.out.println(opcion);
		}
	}
	
	public static void mostrarCabecera(String mensaje) {
		System.out.printf("%n%s%n", mensaje);
		String cadena = "%0" + mensaje.length() + "d%n";
		System.out.println(String.format(cadena, 0).replace("0", "-"));
	}
	
	public static int elegirOpcion() {
		int ordinalOpcion;
		do {
			System.out.print("\nElige una opción: ");
			ordinalOpcion = Entrada.entero();
		} while (!Opcion.esOrdinalValido(ordinalOpcion));
		return ordinalOpcion;
	}
	
	public static Aula leerAula() {
		System.out.print("Introduce el nombre: ");
		String nombre = Entrada.cadena();
		Aula aula = new Aula(nombre);
		return new Aula(nombre);
	}
        
              
        public static Aula leerNombreAula() {
        	String nombre;
		do {
			System.out.print("Introduce el nombre del aula: ");
			nombre = Entrada.cadena();
		} while (nombre.trim().equals(""));
		Aula aulaNombre = new Aula(nombre);
		return new Aula(nombre);
	}
        
        public static Profesor leerProfesor() {
		System.out.print("Introduce el nombre: ");
		String nombre = Entrada.cadena();
                System.out.print("Introduce el correo: ");
		String correo = Entrada.cadena();
                System.out.print("Introduce el teléfono: ");
		String telefono = Entrada.cadena();
		
		Profesor profesor = new Profesor(nombre, telefono, correo);
		
		return new Profesor(nombre, telefono, correo);
	}
	
	 public static Profesor leerNombreProfesor() {
        	String nombre;
		do {
			System.out.print("Introduce el nombre del profesor: ");
			nombre = Entrada.cadena();
		} while (nombre.trim().equals(""));
		Profesor profesorNombre= new Profesor(nombre, "correo@gmail.com", "950000000");
		
                return new Profesor(profesorNombre,"correo@gmail.com", "950000000" );
	}
         
         
          
        public static Tramo leerTramo() {
                
                TRAMO tramo;
                
                System.out.print("Introduce el tramo: ");
                Tramo = Entrada.entero();
		Tramo tramo = new Tramo(tramo);
		return new Tramo(tramo);
	}
        
        
        public static Permanencia LeerDia();{
    
               	LocalDate dia;
		
                do {
			System.out.print("Introduce el día: ");
			dia = Entrada.localDate();
		} while (dia == null);
		Permanencia permanenciaDia = new Permanencia(dia,MANANA);
		return new Permanencia(permanenciaDia,MANANA);
	}
                
    
      
      
        	
}











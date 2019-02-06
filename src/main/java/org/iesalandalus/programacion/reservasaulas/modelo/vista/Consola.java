/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.vista;


import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Tramo;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.utilidades.Entrada;


public class Consola {
	
	private static final DateTimeFormatter FORMATO_DIA= DateTimeFormatter.ofPattern("dd/mm/yyyy");

   	
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
         
         
          
        public static int leerTramo() {
                
      
               int opcion;
               int i;
               
               do{

                  i=1;

                for(Tramo t:Tramo.values()){            

                System.out.println(i+"."+t);

                i++;
                }        

                System.out.println("Elija una opción:");

                opcion=Entrada.entero();

                }while(opcion<=0 || opcion>Tramo.values().length);
            
       
               
              
        public static voidLocalDate LeerDia(){      
        
                        
    
      // Se puede hacer de dos maneras:
      
            LocalDate fecha=null;
            boolean fechaValida=true;
            int dia, mes, anio;
            
            do
            {
                System.out.println("Introduce el día");
                dia=Entrada.entero();
        
                System.out.println("Introduce el mes");
                mes=Entrada.entero();
        
                System.out.println("Introduce el año");
                anio=Entrada.entero();
        
                try
                {
                    fecha=LocalDate.of(anio,mes,dia);
                    fechaValida=true;
                }
                catch(DateTimeException e)
                {
                    System.out.println("Fecha no válida");
                    fechaValida=false;
                }
            }while(!fechaValida);
        
            String fechaFormato=fecha.format(FORMATO_DIA);
        
            LocalDate fechaFormateada=LocalDate.parse(fechaFormato,FORMATO_DIA);
        
            return fechaFormateada;
            
            
            
        } 
         //Segunda opción:
        
               /* String dia;
		boolean diaCorrecto = false;
		do {
			System.out.print("Introduce el día (dd/mm/aaaa): ");
			dia = Entrada.cadena();
			try {
				LocalDate.parse(dia, FORMATO_DIA);
				diaCorrecto = true;
			} catch (DateTimeParseException e) {
				diaCorrecto = false;
			}
		} while (!diaCorrecto);
		
                LocalDate f=LocalDate.parse(dia, FORMATO_DIA);
                
                return dia; 
                
         
    }*/
           
    }










package org.iesalandalus.programacion.reservasaulas.modelo.vista;


import java.time.LocalDate;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Tramo;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.utilidades.Entrada;


public class IUTextual {
    
        private static final String ERROR = "ERROR: ";
        private static final String NOMBRE_VALIDO="Pedro Perez";
        private static final String CORREO_VALIDO="pedro@gmail.com";
        private ModeloReservasAulas modelo;
   

	public IUTextual() {
		modelo = new ModeloReservasAulas();
		Opcion.setVista(this);
	}
        
        public void comenzar() {
		int ordinalOpcion;
		do {
			Consola.mostrarMenu();
			ordinalOpcion = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(ordinalOpcion);
			opcion.ejecutar();
		} while (ordinalOpcion != Opcion.SALIR.ordinal());
	}
	
	public void salir() {
		System.out.println("Hasta luego!");
	}
	
	public void insertaraAula() {
		Consola.mostrarCabecera("Insertar aula");
		try {
			Aula aula = Consola.leerAula();
			modelo.insertarAula(aula);
			System.out.println("Aula insertada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void borrarAula() {
		Consola.mostrarCabecera("Borrar aula");
		try {
			Aula aula = Consola.leerAula();
			modelo.borrarAula(aula);
			System.out.println("Aula borrada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void buscarAula() {
		Consola.mostrarCabecera("Buscar aula");
		Aula aula  = null;
		try {
			aula = Consola.leerNombreAula();
			aula = modelo.buscarAula(aula);
			if (aula != null) {
				System.out.println("La aula buscada es: " + aula);
			} else {
				System.out.println("No existe ninguna aula con dicho nombre.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void listarAlulas() {
		Consola.mostrarCabecera("Listar aulas");
		String[] aulas = modelo.representarAulas();
		if (aulas.length > 0) {
			for (String aula : aulas) {
				System.out.println(aulas);
			}
		} else {
			System.out.println("No hay aulas que listar.");
		}
	}
        
        public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			modelo.insertarProfesor(profesor);
			System.out.println("Profesor insertado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void borrarProfesor() {
		Consola.mostrarCabecera("Borrar profesor");
		try {
			Profesor profesor = Consola.leerProfesor();
			modelo.borrarProfesor(profesor);
			System.out.println("Profesor borrado correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar profesor");
		Profesor profesor  = null;
		try {
			profesor = Consola.leerNombreProfesor();
			profesor = modelo.buscarProfesor(profesor);
			if (profesor != null) {
				System.out.println("El profesor buscado es: " + profesor);
			} else {
				System.out.println("No existe ningún profesor con dicho nombre.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void listarProfesores() {
		Consola.mostrarCabecera("Listar profesores");
		String[] profesores = modelo.representarProfesores();
		if (profesores.length > 0) {
			for (String profesor : profesores) {
				System.out.println(profesores);
			}
		} else {
			System.out.println("No hay profesores que listar.");
		}
	}
        
        
        public void realizarReserva() {
		Consola.mostrarCabecera("Realizar reserva");
		try {
			Reserva reserva =leerReserva();
			modelo.realizarReserva(reserva);
			System.out.println("Reserva realizada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
        //Reserva (Profesor profesor, Aula aula, Permanencia permanencia){
            
        private Reserva leerReserva() {
            
                       
		System.out.print("Introduce el nombre del profesor: ");
                String nombre=Entrada.cadena();
		System.out.print("Introduce el teléfono: ");
		String telefono = Entrada.cadena();
		System.out.print("Introduce el correo: ");
		String correo = Entrada.cadena();
		System.out.print("Introduce el nombre del aula: ");
		String nombre = Entrada.cadena();
		System.out.print("Introduce el día: ");
		dia = Entrada.localDate();
		System.out.print("Introduce el tramo: ");
		Tramo = Entrada.entero();
		Aula aula = new Aula(nombre);
		Profesor profesor = new Profesor(nombre, correo, telefono);
		Permanencia permanencia = new Permanencia (dia, tramo);
		return new Reserva reserva(aula, profesor, permanencia);
            
	}
	
	public void AnularReserva() {
		Consola.mostrarCabecera("Anular aula");
		try {
			Reserva reserva = Consola.leerReserva();
			modelo.anularReserva(reserva);
			System.out.println("Reserva anulada correctamente.");
		} catch (OperationNotSupportedException|IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}
	
	public void listarReservas() {
		Consola.mostrarCabecera("Listar reservas");
		String[] reservas = modelo.representarReservas();
		if (reservas.length > 0) {
			for (String reserva : reservas) {
				System.out.println(reservas);
			}
		} else {
			System.out.println("No hay reservas que listar.");
		}
	}
        
        public void listarReservasAula() {
		Consola.mostrarCabecera("Listar reservas aula");
		String[] aulas = modelo.getReservasAula(aula);
		if (aulas.length > 0) {
			for (String aula: aulas) {
				System.out.println(aulas);
			}
		} else {
			System.out.println("No hay reservas de aulas que listar.");
		}
	}
        
         public void listarReservasProfesor() {
		Consola.mostrarCabecera("Listar reservas profesor");
		String[] profesores = modelo.getReservasProfesores(profesor);
		if (profesores.length > 0) {
			for (String profesor: profesores) {
				System.out.println(profesores);
			}
		} else {
			System.out.println("No hay reservas de profesores que listar.");
		}
	}
        
         
         //Pendiente
         
          public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar reservas permanencia");
		
                
          }    

         public void consultarDisponibilidad() {
		Consola.mostrarCabecera("Consultar Disponibilidad");
		
			Reseva reserva = Consola.leerReserva();
			modelo.consultarDisponibilidad(aula, permanencia);
			System.out.println("Consulta de disponibilidad.");
		
	}
          
          
	
}

        
    
    
    
    
    
   

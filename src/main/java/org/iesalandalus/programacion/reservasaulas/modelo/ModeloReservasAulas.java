/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo;

import javax.naming.OperationNotSupportedException;


import org.iesalandalus.programacion.rervasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.rervasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.rervasaulas.modelo.dao.Reservas;

import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.rervasaulas.modelo.dominio.Reserva;

/**
 *
 * @author usuario
 */
public class ModeloReservasAulas {
    
        private Aulas aulas;
        private Profesores profesores;
        private Reservas reservas;
	
	public ModeloReservasAulas() {
		aulas = new Aulas();
                profesores= new Profesores();
                reservas= new Reservas();
	}
	
        //Aulas
        //Revisar gett
        
        public Aula[] getAulas() {
		return aulas.copiaProfundaAulas(coleccionAulas);
	}
        
	public int getNumAulas() {
		return aulas.numAulas;
	}
        
	
        public String[] representarAulas() {
		return aulas.representar();
	}
        public Aula buscarAula(Aula aula) {
		return aulas.buscar(aula);
	}
        public void insertarAulas(Aula aula) throws OperationNotSupportedException {
		aulas.insertar(aula);
	}
	
	public void borrarAulas(Aula aula) throws OperationNotSupportedException {
		aulas.borrar(aula);
	}
	
        //Profesores
        
        public Profesor[] getProfesores() {
		return profesores.copiaProfundaProfesores(coleccionProfesores);
	}
	
	public int getNumProfesores() {
		return profesores.numProfesores;
	}
        
	 public String[] representarProfesores() {
		return profesores.representar();
	}
        public Aula buscarProfesor(Profesor profesor) {
		return profesores.buscar(profesor);
	}
        public void insertarProfesores(Profesor profesor) throws OperationNotSupportedException {
		profesores.insertar(profesor);
	}
	
	public void borrarProfesores(Profesor profesor) throws OperationNotSupportedException {
		profesores.borrar(profesor);
	}
        
        // Reservas
        
        public Reserva[] getReservas() {
		return reservas.copiaProfundaReservas(coleccionReservas);
	}
	
	public int getNumReservas() {
		return reservas.numReservas;
	}
        
         public String[] representarReservas() {
		return reservas.representar();
	}
        public Aula buscarReserva(Reserva reserva) {
		return reservas.buscar(reserva);
	}
        public void insertarReservas(Reserva reserva) throws OperationNotSupportedException {
		reservas.insertar(reserva);
	}
	
	public void borrarReservas(Reserva reserva) throws OperationNotSupportedException {
		reservas.borrar(reserva);
	}
        
                     
        public Reserva[] getReservasAula( Aula aula){
            
                return reservas.getReservasAula(aula);
        }
            
        public Reserva[] getReservasProfesores(Profesor profesor ) {
		return reservas.getReservasProfesores(profesor);
        }
	
	public Reserva[] getReservasPermanencia ( Permanencia permanencia){
                
                return reservas.getReservasPermanencia(permanencia);
        }
        
        public boolean consultarDisponibilidad ( Aula aula, Permanencia permanencia){
            
                return reservas.consultarDisponibilidad(aula, permanencia);
        }
        
	
}

    
    
    
    

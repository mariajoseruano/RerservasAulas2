/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaula.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author usuario
 */
public class Reservas {
    
        private static final int MAX_RESERVAS = 10;
	private Reserva[] coleccionReservas;
	private int numReservas;
	
	        
        //Se crea el constructor
        
        
        public Reservas() {
		coleccionReservas = new Reserva[MAX_RESERVAS];
		numReservas = 0;
	}
	
	public Reservas(Reservas reservas) {
		setReservas(reservas);
	}
	
	private void setReservas(Reservas reservas) {
		if (reservas == null) {
			throw new IllegalArgumentException("No se puede realizar una reserva nula.");
		}
		coleccionReservas = copiaProfundaReservas(reservas.coleccionReservas);
		numReservas = reservas.numReservas;
	}
	
	private Reserva[] copiaProfundaReservas(Reserva[] reservas) {
		Reserva[] otrasReservas = new Reserva[reservas.length];
		for (int i = 0; i < reservas.length && reservas[i] != null; i++) {
			otrasReservas[i] = new Reserva(reservas[i]);
		}
		return otrasReservas;
	}
	
	public Reserva[] getReservas() {
		return copiaProfundaReservas(coleccionReservas);
	}
	
	public int getNumReservas() {
		return numReservas;
	}
	
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		
                if (reserva == null) {
                    throw new IllegalArgumentException("No se puede realizar una reserva nula.");
		}
		int indice = buscarIndiceReserva(reserva);
		if (!indiceNoSuperaTamano(indice)) {
			coleccionReservas[indice] = reserva;
			numReservas++;
		} else {
			
                    throw new OperationNotSupportedException("La reserva ya existe..");
			
			
			}		
	}
	
	private int buscarIndiceReserva(Reserva reserva) {
		int indice = 0;
		boolean reservaEncontrada = false;
		while (indiceNoSuperaTamano(indice) && !reservaEncontrada) {
			if (coleccionReservas[indice].equals(reserva)) {
				reservaEncontrada = true;
			} else {
				indice++;
			}
		}
		return indice;
	}
	
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < numReservas;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) {
		return indice < MAX_RESERVAS;
	}
	
	public Reserva buscar(Reserva reserva) {
		int indice = 0;
		indice = buscarIndiceReserva(reserva);
		if (indiceNoSuperaTamano(indice)) {
			return coleccionReservas[indice];
		} else {
			return null;
		}
	}
	
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) {
			throw new IllegalArgumentException("No se puede anular una reserva nula.");
		}
		int indice = buscarIndiceReserva(reserva);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new OperationNotSupportedException("La reserva a anular no existe.");
		}
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < numReservas - 1; i++) {
			coleccionReservas[i] = coleccionReservas[i+1];
		}
		coleccionReservas[numReservas] = null;
		numReservas--;
	}
	
	public String[] representar() {
		String[] representacion = new String[numReservas];
		for (int i = 0; indiceNoSuperaTamano(i); i++) {
			representacion[i] = coleccionReservas[i].toString();
		}
		return representacion;
	}
        
        
        /*public Reserva[] getReservasProfesores(Profesor profesor ) {
		return   ;

                */
        
        
        /*public Reserva[] getReservasAula( Aula aula){
            
                return   ;
            
        }*/
        
        /*public Reserva[] gesReservasPermanencia ( Permanencia permanencia)
                
                return ;*/
        
        /*public boolean consultarDisponibilidad ( Aula aula, Permanencia permanencia){
            
            
        }*/
        
        
        
                
}

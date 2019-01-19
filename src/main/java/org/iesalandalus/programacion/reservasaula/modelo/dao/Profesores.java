/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaula.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasula.modelo.dominio.Profesor;.
/**
 *
 * @author usuario
 */
public class Profesores {
    
    
    	
	private static final int MAX_PROFESORES = 20;
	
	private Profesor[] coleccionProfesores;
	private int numProfesores;
	
	public Profesores() {
		coleccionProfesores = new Profesor[MAX_PROFESORES];
		numProfesores = 0;
	}
	
	public Profesores(Profesores profesores) {
		setProfesores(profesores);
	}
	
	private void setProfesores(Profesores profesores) {
		if (profesores == null) {
			throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
		}
		coleccionProfesores = copiaProfundaClientes(profesores.coleccionProfesores);
		numProfesores = profesores.numProfesores;
	}
	
	private Profesor[] copiaProfundaProfesores(Profesor[] profesores) {
		Profesor[] otrosProfesores = new Profesor[profesores.length];
		for (int i = 0; i < profesores.length && profesores[i] != null; i++) {
			otrosProfesores[i] = new Profesor(profesores[i]);
		}
		return otrosProfesores;
	}
	
	public Profesor[] getProfesores() {
		return copiaProfundaProfesores(coleccionProfesores);
	}
	
	public int getNumProfesores() {
		return numProfesores;
	}
	
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new IllegalArgumentException("No se puede insertar un profesor nulo");
		}
		int indice = buscarIndiceProfesor(profesor);
		if (!indiceNoSuperaTamano(indice)) {
			coleccionProfesores[indice] = profesor;
			numProfesores++;
		} else {
			
                    throw new OperationNotSupportedException("El profesor ya existe.");
			
		}		
	}
	
	private int buscarIndiceCliente(Profesor profesor) {
		int indice = 0;
		boolean profesorEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !profesorEncontrado) {
			if (coleccionProfesores[indice].equals(profesor)) {
				profesorEncontrado = true;
			} else {
				indice++;
			}
		}
		return indice;
	}
	
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < numProfesores;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) {
		return indice < MAX_PROFESORES;
	}
	
	public Profesor buscar(Profesor profesor) {
		int indice = 0;
		indice = buscarIndiceProfesor(profesor);
		if (indiceNoSuperaTamano(indice)) {
			return coleccionProfesores[indice];
		} else {
			return null;
		}
	}
	
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor == null) {
			throw new IllegalArgumentException("o se puede borrar un profesor nulo.");
		}
		int indice = buscarIndiceProfesor(profesor);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new OperationNotSupportedException("El profesor a borrar no existe.");
		}
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < numProfesores - 1; i++) {
			coleccionProfesores[i] = coleccionProfesores[i+1];
		}
		coleccionProfesores[numProfesores] = null;
		numProfesores--;
	}
	
	public String[] representar() {
		String[] representacion = new String[numProfesores];
		for (int i = 0; indiceNoSuperaTamano(i); i++) {
			representacion[i] = coleccionProfesores[i].toString();
		}
		return representacion;
	}
}

    

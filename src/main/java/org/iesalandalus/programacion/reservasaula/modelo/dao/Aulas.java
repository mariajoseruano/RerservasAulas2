/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaula.modelo.dao;

import javax.naming.OperationNotSupportedException;


import org.iesalandalus.programacion.reservasula.modelo.dominio.Aula;

/**
 *
 * @author usuario
 */
public class Aulas {
    
        //Declaración de varibales.
    
    
        private static final int MAX_AULAS = 10;
	private Aula[] coleccionAulas;
	private int numAulas;
        
       
        // Se crea Constructor.
        
        private Aulas (){
            
            coleccionAulas= new Aula[MAX_AULAS];
            numAulas=0;
            
        }
        
        //Se crea el constructor copia
        
        public Aulas (Aulas aulas) {
		setAulas(aulas);
	}
	
	private void setAulas(Aulas aulas) {
            
		if (aulas == null) {
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		}
		coleccionAulas = copiaProfundaAulas(aulas.coleccionAulas);
		numAulas =aulas.numAulas;
	}
	
        // Se crea copiaprofunda
        
	private Aula[] copiaProfundaAulas(Aula[] aulas) {
		Aula[] otrasAulas = new Aula[aulas.length];
		for (int i = 0; i < aulas.length && aulas[i] != null; i++) {
			otrasAulas[i] = new Aula(aulas[i]);
		}
		return otrasAulas;
	}
	
	
        	
	//GETTER
	
        public Aula[] getAulas() {
		return copiaProfundaAulas(coleccionAulas);
	}
        
	public int getNumAulas() {
		return numAulas;
	}
	
        // Método Insertar
        
	public void insertar(Aula aula) throws OperationNotSupportedException {
           
		if (aula == null) {
                    
                    throw new IllegalArgumentException("No se puede insertar un aula nula.");
		}
		int indice = buscarIndiceAulas(aula);
		if (!indiceNoSuperaTamano(indice)) {
			coleccionAulas[indice] = aula;
			numAulas++;
		} else {
		
                    throw new OperationNotSupportedException("El aula ya existe.");
			
		}		
	}
        
        private int buscarIndiceAulas(Aula aula) {
		int indice = 0;
		boolean aulaEncontrado = false;
		while (indiceNoSuperaTamano(indice) && !aulaEncontrado) {
			if (coleccionAulas[indice].equals(aula)) {
				aulaEncontrado = true;
			} else {
				indice++;
			}
		}
		return indice;
	}
	
	private boolean indiceNoSuperaTamano(int indice) {
		return indice < numAulas;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) {
		return indice < MAX_AULAS;
	}
        
        
        public Aula buscar(Aula aula) {
		int indice = 0;
		indice = buscarIndiceAulas(aula);
		if (indiceNoSuperaTamano(indice)) {
			return coleccionAulas[indice];
		} else {
			return null;
		}
	}
	
	public void borrar(Aula aula) throws OperationNotSupportedException {
		if (aula == null) {
			throw new IllegalArgumentException("No se puede borrar un aula nula.");
		}
		int indice = buscarIndiceAulas(aula);
		if (indiceNoSuperaTamano(indice)) {
			desplazarUnaPosicionHaciaIzquierda(indice);
		}
		else {
			throw new OperationNotSupportedException("El aula a borrar no existe.");
		}
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < numAulas - 1; i++) {
			coleccionAulas[i] = coleccionAulas[i+1];
		}
		coleccionAulas[numAulas] = null;
		numAulas--;
	}
	
	public String[] representar() {
		String[] representacion = new String[numAulas];
		for (int i = 0; indiceNoSuperaTamano(i); i++) {
			representacion[i] = coleccionAulas[i].toString();
		}
		return representacion;
	}
}

        
        




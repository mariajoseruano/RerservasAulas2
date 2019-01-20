/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.rervasaulas.modelo.dominio;

   
import java.util.Objects;

/**
 *
 * @author usuario
 */
public class Profesor {
    
        private static final String ER_TELEFONO="[69][0-9]{8}";
        private static final String ER_CORREO="^[A-Za-z0-9-_]+(\\.[A-Za-z0-9-_]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        private String nombre;
        private String correo;
        private String telefono;
        
         /* Se crea el constructor*/
        
        public Profesor (String nombre , String correo, String telefono){
            
            setNombre(nombre);
            setCorreo(correo);
            setTelefono(telefono);
                       
        }
        
        /*Se crea el constructor copia */
        
        public Profesor (Profesor profesor){
            
            if (profesor==null)
                    
                    throw new IllegalArgumentException("No se puede copiar un profesor nulo.");
           
            setNombre(profesor.nombre);
            setCorreo(profesor.correo);
            setTelefono(profesor.telefono);
                       
        }
    
        /* Se crea los métodos Setter y Getter*/
        
        private void setNombre( String nombre){
            
            if  (nombre == null) {
                    throw new IllegalArgumentException("El nombre del profesor no puede ser nulo.");
            }
            if (nombre.trim().equals("")) {
                    throw new IllegalArgumentException("El nombre del profesor no puede estar vacío.");
            }
            
            this.nombre = nombre;
                
        }
        
         public void setTelefono ( String telefono)
        {
           
            if (!(telefono.matches(ER_TELEFONO)))
            
                throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido");
            
            
            this.telefono=telefono;
        }  
         
        public void setCorreo ( String correo)
        
        {
           
            if (correo==null)
        
                throw new IllegalArgumentException("ERROR:El correo del profesor no puede ser nulo.");
            
             if (!(correo.matches(ER_CORREO)))
            
                    throw new IllegalArgumentException("ERROR: El correo no tiene un formato válido");
            
            this.correo=correo;
        }  
        
        
        
        public String getNombre(){
            return nombre;
        }
        
        public String getTelefono(){
            return telefono;
        } 
     
        public String getCorreo(){
            return correo;
        } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        hash = 73 * hash + Objects.hashCode(this.correo);
        hash = 73 * hash + Objects.hashCode(this.telefono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profesor{" + "nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono + '}';
    }

        
}
















    


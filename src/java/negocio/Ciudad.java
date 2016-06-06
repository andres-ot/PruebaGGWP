/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.Conexion;

/**
 *
 * @author ricardotoledo
 */
public class Ciudad {
    private int ciudad_id;
    private String nombre;
    private String estado;
    Conexion con;
    
    public Ciudad(){
    con = new Conexion();
    }
    
    public int getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(int ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        }
    public void setEstado(String estad){
        this.estado=estado;
    }
    public String getEstado(){
        return this.estado;
    }
    
        
    public void crear(){
       con.setInsertar("insert into Ciudades(nombre,estado) values('"+this.getNombre()+"','Activo')");
    }
    //SE CREAR EL METODO ELIMINAR PARA HACER UN INSERT UTILIZANDO LOS METODOS GET DE LA CLASE
    public void eliminar(){
      con.setInsertar("update Ciudades set estado='Pasivo' where usuario_id='"+this.getCiudad_id()+"'");
    }
    //SE CREAR EL ACTUALIZARCREAR PARA HACER UN INSERT UTILIZANDO LOS METODOS GET DE LA CLASE
    public void actualizar(){
      con.setInsertar("update Ciudades set nombre='"+this.getNombre()+"' where ciudad_id='"+this.ciudad_id+"'");
    }
    
}

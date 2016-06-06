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
public class Usuario {
    
    //SE CREA LA CAPA DE NEGOCIO USUARIO CON TODOS LOS CAMPOS DE LA TABLA Y SUS METODOS SET Y GET
    private int usuario_id;
    private String nombre;
    private String apepat;
    private String apemat;
    private int ciudad_id;
    private String estado;
    //SE CREA LA CONECCION PARA QUE AL MOMENTO DE CREAR EL OBJETO SEA ESTABLECIDA LA CONECCION CON LA BDD
    Conexion con;
    public Usuario(){
        con=new Conexion();
    }
    
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepat() {
        return apepat;
    }

    public void setApepat(String apepat) {
        this.apepat = apepat;
    }

    public String getApemat() {
        return apemat;
    }

    public void setApemat(String apemat) {
        this.apemat = apemat;
    }

    public int getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(int ciudad_id) {
        this.ciudad_id = ciudad_id;
    }
    
    public void setEstado(String estado){
        this.estado=estado;
    }
    public String getEstado(){
        return this.estado;
    }
    
    //SE CREAR EL METODO CREAR PARA HACER UN INSERT UTILIZANDO LOS METODOS GET DE LA CLASE
    public void crear(){
       con.setInsertar("insert into Usuarios(nombre,apepat,apemat,ciudad_id,estado) values('"+this.getNombre()+"','"+this.getApepat()+"','"+this.getApemat()+"','"+this.getCiudad_id()+"','activo')");
    }
    //SE CREAR EL METODO ELIMINAR PARA HACER UN INSERT UTILIZANDO LOS METODOS GET DE LA CLASE
    public void eliminar(){
      con.setInsertar("update Usuarios set estado='pasivo' where usuario_id='"+this.getUsuario_id()+"'");
    }
    //SE CREAR EL ACTUALIZARCREAR PARA HACER UN INSERT UTILIZANDO LOS METODOS GET DE LA CLASE
    public void actualizar(){
      con.setInsertar("update Usuarios set nombre='"+this.getNombre()+"',apepat='"+this.getApepat()+"',apemat='"+this.getApemat()+"',ciudad_id='"+this.getCiudad_id()+"' where usuario_id='"+this.usuario_id+"'");
    }
   
    
    
}

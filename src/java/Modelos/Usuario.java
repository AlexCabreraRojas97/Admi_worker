/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author AdminSena
 */
public class Usuario {
    
    int id,tipodocumento;
    String documento,celular, tipousuario;
    String nombre,apellido, correo, password, fecha;

    public Usuario() {
    }
//ID, STATUS, FIRST_NAME, LAST_NAME, IDENTITY_DOC_TYPE, DOCUMENT, EMAIL, CELL_PHONE, CREATED_DATETIME, UPDATED_DATETIME, CREATED_USER, UPDATED_USER, USER_PASSWORD
    public Usuario(int id, String documento, String nombre, String apellido,int tipodocumento,String celular, String correo, String password, String fecha, String tipousuario) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodocumento=tipodocumento;
        this.celular=celular;
        this.correo = correo;        
        this.password = password;
        this.fecha=fecha;
        this.tipousuario=tipousuario;
        
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
   


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

    
}

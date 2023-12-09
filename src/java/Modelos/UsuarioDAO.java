package Modelos;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
   
    public Usuario Validar(String documento, String password) {
    Usuario usuario = new Usuario();
    String consulta = "SELECT * FROM A_USER WHERE DOCUMENT = ? AND USER_PASSWORD = ?";
    con = cn.conectar();
    try {
        ps = con.prepareStatement(consulta);
        ps.setString(1, documento);
        ps.setString(2, password);
        rs = ps.executeQuery();
        if (rs.next()) {
            usuario.setId(rs.getInt("ID"));
            usuario.setNombre(rs.getString("FIRST_NAME"));
            usuario.setApellido(rs.getString("LAST_NAME"));
            usuario.setTipodocumento(rs.getInt("IDENTITY_DOC_TYPE"));
            usuario.setDocumento(rs.getString("DOCUMENT"));
            usuario.setCelular(rs.getString("CELL_PHONE"));
            usuario.setCorreo(rs.getString("EMAIL"));
            usuario.setPassword(rs.getString("USER_PASSWORD"));
            usuario.setFecha(rs.getString("CREATED_DATETIME"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return usuario;
}

 //STATUS,FIRST_NAME, LAST_NAME, IDENTITY_DOC_TYPE, DOCUMEN,EMAIL, CELL_PHONE,USER_PASSWORD,ROL,CREATED_DATETIME
        
public List Listar() {
    String consulta = "SELECT * FROM A_USER";
    List <Usuario> lista = new ArrayList<>();
    try {
        con = cn.conectar();
        ps = con.prepareStatement(consulta);
        rs = ps.executeQuery();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("ID"));
            usuario.setNombre(rs.getString("FIRST_NAME"));
            usuario.setApellido(rs.getString("LAST_NAME"));
            usuario.setTipodocumento(rs.getInt("IDENTITY_DOC_TYPE"));
            usuario.setDocumento(rs.getString("DOCUMENT"));
            usuario.setCorreo(rs.getString("EMAIL"));
            usuario.setPassword(rs.getString("USER_PASSWORD"));
            usuario.setFecha(rs.getString("CREATED_DATETIME"));
            usuario.setTipousuario(rs.getString("CREATED_USER"));
            lista.add(usuario);
        }
    } catch (SQLException ex) {
         Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lista;
}


    public int Agregar(Usuario usuario) {
    int r = 0; // Variable para controlar el resultado de la inserción
    String sentencia = "INSERT INTO A_USER (FIRST_NAME, LAST_NAME, IDENTITY_DOC_TYPE, DOCUMENT, EMAIL, CELL_PHONE, CREATED_DATETIME,CREATED_USER, USER_PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
    try {
        con = cn.conectar();
        ps = con.prepareStatement(sentencia);
        
        //ps.setString(1, usuario.getEstado());
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getApellido());
        ps.setInt(3, usuario.getTipodocumento());
        ps.setString(4, usuario.getDocumento());
        ps.setString(5, usuario.getCorreo());
        ps.setString(6, usuario.getCelular());
        ps.setString(7, usuario.getFecha()); // Cambiado a CREATED_DATETIME
        ps.setString(8, usuario.getTipousuario());
         ps.setString(9, usuario.getPassword ()); //cambiando a USER_PASSWORD

        r = ps.executeUpdate(); // Ejecuta la actualización y devuelve el número de filas afectadas
        
    } catch (Exception e) {
        //Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
    }
    return r;
}




public Usuario ListarPorId(int id){
    Usuario usuario = new Usuario();
    String consulta = "SELECT * FROM A_USER WHERE ID = ?";
    con = cn.conectar();
    try {
        ps = con.prepareStatement(consulta);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
            usuario.setId(rs.getInt("ID"));
            usuario.setNombre(rs.getString("FIRST_NAME"));
            usuario.setApellido(rs.getString("LAST_NAME"));
            usuario.setTipodocumento(rs.getInt("IDENTITY_DOC_TYPE"));
            usuario.setDocumento(rs.getString("DOCUMENT"));
            usuario.setCorreo(rs.getString("EMAIL"));
            usuario.setCelular(rs.getString("CELL_PHONE"));
            usuario.setFecha(rs.getString("CREATED_DATETIME"));
            usuario.setTipousuario(rs.getString("CREATED_USER"));
            usuario.setPassword(rs.getString("USER_PASSWORD"));
        }
    } catch (SQLException e) {
        // Manejar la excepción adecuadamente
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
    } finally {
        // Cerrar recursos (ResultSet, PreparedStatement, Connection)
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return usuario;
}

    
    public int Actualizar(Usuario usuario) {
    int rowsAffected = 0;
    String query = "UPDATE A_USER SET FIRST_NAME=?, LAST_NAME=?, IDENTITY_DOC_TYPE=?, DOCUMENT=?, EMAIL=?, CELL_PHONE=?, CREATED_DATETIME=?, CREATED_USER=?, USER_PASSWORD=? WHERE ID=?";
    
    try (Connection connection = cn.conectar();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setString(1, usuario.getNombre());
        preparedStatement.setString(2, usuario.getApellido());
        preparedStatement.setInt(3, usuario.getTipodocumento());
        preparedStatement.setString(4, usuario.getDocumento());
        preparedStatement.setString(5, usuario.getCorreo());
        preparedStatement.setString(6, usuario.getCelular());
        preparedStatement.setString(7, usuario.getFecha());
        preparedStatement.setString(8, usuario.getTipousuario());
        preparedStatement.setString(9, usuario.getPassword());
        preparedStatement.setInt(10, usuario.getId());

        rowsAffected = preparedStatement.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "Error al actualizar usuario", ex);
    }
    
    return rowsAffected;
}




    public void Eliminar(int id) {

        String sql = "DELETE FROM A_USER WHERE ID=" + id;
        
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            //Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioM {
    private static final String SQL_SELECT = "SELECT * FROM usuario;";
    private static final String SQL_INSERT = "INSERT INTO usuario (contrasena, imagen, cellphone, nombre) VALUES (?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE usuario SET %s = ? WHERE id_usuario = ?;";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?;";
    
    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usua = null;
        List<Usuario> verbos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String contrasena = rs.getString("contrasena");
                String imagen = rs.getString("imagen");
                String cellphone = rs.getString("cellphone");
                String nombre = rs.getString("nombre");
                
                usua = new Usuario(id, contrasena, imagen, cellphone, nombre);

                verbos.add(usua);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return verbos;
    }
    
    public int insertar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_INSERT);
            stmt.setString(1, usuario.getContrasena());
            stmt.setString(2, usuario.getImagen());
            stmt.setString(3, usuario.getCellphone());
            stmt.setString(4, usuario.getNombre());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }        
        return registros;
    }
    
    public int actualizar(Usuario usuario, String columna){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            String sql = String.format(SQL_UPDATE, columna);
            stmt = conn.prepareCall(sql);
            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getId_usuario());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }        
        return registros;
    }
     
    public int eliminar(Usuario usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_DELETE);
            stmt.setInt(1, usuario.getId_usuario());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }        
        return registros;
    }
}

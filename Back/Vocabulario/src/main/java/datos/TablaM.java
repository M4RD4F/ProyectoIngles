package datos;

import domain.Tabla;
import java.sql.*;
import java.util.*;

public class TablaM {
    private static final String SQL_SELECT = "SELECT * FROM tabla";
    private static final String SQL_INSERT = "INSERT INTO tabla (color, nombre) VALUES (?,?);";
    private static final String SQL_UPDATE = "UPDATE tabla SET %s = ? WHERE id_tabla = ?;";
    private static final String SQL_DELETE = "DELETE FROM tabla WHERE id_tabla = ?;";
    
    public List<Tabla> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tabla tabla = null;
        List<Tabla> tablas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_tabla");
                String color = rs.getString("color");
                String name = rs.getString("nombre");
                
                tabla = new Tabla(color, name, id);

                tablas.add(tabla);
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

        return tablas;
    }
    
    public int insertar(Tabla tabla){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_INSERT);
            stmt.setString(1, tabla.getColor());
            stmt.setString(2, tabla.getName());
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
    
    public int actualizar(Tabla verbo, String columna){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            String sql = String.format(SQL_UPDATE, columna);
            stmt = conn.prepareCall(sql);
            stmt.setString(1, verbo.getName());
            stmt.setInt(2, verbo.getId_tabla());   
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
     
    public int eliminar(Tabla verbo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_DELETE);
            stmt.setInt(1, verbo.getId_tabla());
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

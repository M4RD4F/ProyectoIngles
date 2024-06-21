package datos;

import domain.Verbo;
import java.sql.*;
import java.util.*;

public class Movimiento {
    private static final String SQL_SELECT = "SELECT * FROM vocabulario";
    private static final String SQL_INSERT = "INSERT INTO vocabulario (id_tabla, infinitivo, pasado_simple, pasado_participio, gerundio) VALUES (?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE vocabulario SET %s = ? WHERE id_vocabulario = ?;";
    private static final String SQL_DELETE = "DELETE FROM vocabulario WHERE id_vocabulario = ?;";
    
    public List<Verbo> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Verbo verbo = null;
        List<Verbo> verbos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_verbo");
                int id_tabla = rs.getInt("id_tabla");
                String infinitivo = rs.getString("infinitivo");
                String pasado_simple = rs.getString("pasado_simple");
                String pasado_participio = rs.getString("pasado_participio");
                String gerundio = rs.getString("gerundio");
                
                verbo = new Verbo(id, id_tabla, infinitivo, pasado_simple, pasado_participio, gerundio);

                verbos.add(verbo);
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
    
    public int insertar(Verbo verbo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_INSERT);
            stmt.setInt(1, verbo.getId_tabla());
            stmt.setString(2, verbo.getInfinitivo());
            stmt.setString(3, verbo.getPasado_simple());
            stmt.setString(4, verbo.getPasado_participio());
            stmt.setString(5, verbo.getGerundio());
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
    
    public int actualizar(Verbo verbo, String columna){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            String sql = String.format(SQL_UPDATE, columna);
            stmt = conn.prepareCall(sql);
            stmt.setString(1, verbo.getGerundio());
            stmt.setInt(2, verbo.getId_vocabulario());
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
     
    public int eliminar(Verbo verbo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_DELETE);
            stmt.setInt(1, verbo.getId_vocabulario());
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

/*
    Se puede ver todo el vocabulario de una tabla
*/

package datos;

import domain.Verb;
import java.sql.*;
import java.util.*;

public class Movement {
    private static final String SQL_SELECT = "SELECT * FROM vocabulary";
    private static final String SQL_INSERT = "INSERT INTO vocabulary (id_table, infinitive, simple_past, past_participle, gerund) VALUES (?,?,?,?,?);";
    private static final String SQL_UPDATE = "UPDATE vocabulary SET %s = ? WHERE id_vocabulary = ?;";
    private static final String SQL_DELETE = "DELETE FROM vocabulary WHERE id_vocabulary = ?;";
    
    public List<Verb> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Verb verb = null;
        List<Verb> verbos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_verb");
                int id_tabla = rs.getInt("id_table");
                String infinitive = rs.getString("infinitive");
                String simple_past = rs.getString("simple_past");
                String past_participle = rs.getString("past_participle");
                String gerund = rs.getString("gerund");
                
                verb = new Verb(id, id_tabla, infinitive, simple_past, past_participle, gerund);

                verbos.add(verb);
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
    
    public int insertar(Verb verbo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_INSERT);
            stmt.setInt(1, verbo.getId_table());
            stmt.setString(2, verbo.getInfinitive());
            stmt.setString(3, verbo.getSimple_past());
            stmt.setString(4, verbo.getPast_participle());
            stmt.setString(5, verbo.getGerund());
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
    
    public int actualizar(Verb verbo, String columna){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            String sql = String.format(SQL_UPDATE, columna);
            stmt = conn.prepareCall(sql);
            stmt.setString(1, verbo.getGerund());
            stmt.setInt(2, verbo.getId_vocabulary());
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
     
    public int eliminar(Verb verbo){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_DELETE);
            stmt.setInt(1, verbo.getId_vocabulary());
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

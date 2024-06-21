package domain;

public class Verbo {    //clase de entidad llamada Verbo

    private int id_vocabulario;     //Deben ser equivalentes los valores de la BD y las variables
    private int id_tabla;
    private String infinitivo;  //VARCHAR es equivalente a String
    private String pasado_simple;
    private String pasado_participio;
    private String gerundio;
        //constructor vacio
    public Verbo() {  
    }
        //constructor de un parametro
    public Verbo(int id) { 
        this.id_vocabulario = id;
    }
    public Verbo(String infinitivo, String gerundio, int id){
        this.id_vocabulario = id;
        this.infinitivo = infinitivo;
        this.gerundio = gerundio;
    }
    public Verbo(int id, String infinitivo, String pasado_simple, String pasado_participio, String gerundio) {    //constructor de casi todos los parametros
        this.id_vocabulario = id;
        this.infinitivo = infinitivo;
        this.pasado_simple = pasado_simple;
        this.pasado_participio = pasado_participio;
        this.gerundio = gerundio;
    }
        //constructor de todos los parametros
    public Verbo(int id, int id_tabla, String infinitivo, String pasado_simple, String pasado_participio, String gerundio) {    //constructor de casi todos los parametros
        this.id_vocabulario = id;
        this.id_tabla = id_tabla;
        this.infinitivo = infinitivo;
        this.pasado_simple = pasado_simple;
        this.pasado_participio = pasado_participio;
        this.gerundio = gerundio;
    }

    //Getter and Setter
    public String getInfinitivo() { return infinitivo; }
    public void setInfinitivo(String infinitivo) { this.infinitivo = infinitivo; }
    public String getPasado_simple() { return pasado_simple; }
    public void setPasado_simple(String pasado_simple) { this.pasado_simple = pasado_simple; }
    public String getPasado_participio() { return pasado_participio; }
    public void setPasado_participio(String pasado_participio) { this.pasado_participio = pasado_participio; }
    public String getGerundio() { return gerundio; }
    public void setGerundio(String gerundio) { this.gerundio = gerundio; }
    public int getId_vocabulario() { return id_vocabulario; }
    public void setId_vocabulario(int id_vocabulario) { this.id_vocabulario = id_vocabulario; }
    public int getId_tabla() { return id_tabla; }
    public void setId_tabla(int id_tabla) { this.id_tabla = id_tabla; }

    @Override
    public String toString() {
        return "Verbo{" + "id_vocabulario=" + id_vocabulario + ", id_tabla=" + id_tabla + ", infinitivo=" + infinitivo + ", pasado_simple=" + pasado_simple + ", pasado_participio=" + pasado_participio + ", gerundio=" + gerundio + '}';
    }
    
    
}

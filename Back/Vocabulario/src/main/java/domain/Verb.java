package domain;

public class Verb {    //clase de entidad llamada Verb

    private int id_verb;     //Deben ser equivalentes los valores de la BD y las variables
    private int id_table;
    private String infinitive;  //VARCHAR es equivalente a String
    private String simple_past;
    private String past_participle;
    private String gerund;
        //constructor vacio
    public Verb() {  
    }
        //constructor de un parametro
    public Verb(int id) { 
        this.id_verb = id;
    }
    public Verb(String infinitive, String gerund, int id){
        this.id_verb = id;
        this.infinitive = infinitive;
        this.gerund = gerund;
    }
    public Verb(int id, String infinitivo, String pasado_simple, String pasado_participio, String gerundio) {    //constructor de casi todos los parametros
        this.id_verb = id;
        this.infinitive = infinitivo;
        this.simple_past = pasado_simple;
        this.past_participle = pasado_participio;
        this.gerund = gerundio;
    }
        //constructor de todos los parametros
    public Verb(int id, int id_table, String infinitivo, String pasado_simple, String pasado_participio, String gerundio) {    //constructor de casi todos los parametros
        this.id_verb = id;
        this.id_table = id_table;
        this.infinitive = infinitivo;
        this.simple_past = pasado_simple;
        this.past_participle = pasado_participio;
        this.gerund = gerundio;
    }

    //Getter and Setter
    
    public String getInfinitive() { return infinitive; }
    public void setInfinitive(String infinitive) { this.infinitive = infinitive; }
    public String getSimple_past() { return simple_past; }
    public void setSimple_past(String simple_past) { this.simple_past = simple_past; }
    public String getPast_participle() { return past_participle; }
    public void setPast_participle(String past_participle) { this.past_participle = past_participle; }
    public String getGerund() { return gerund; }
    public void setGerund(String gerund) { this.gerund = gerund; }
    public int getId_vocabulary() { return id_verb; }
    public void setId_vocabulary(int id_vocabulary) { this.id_verb = id_vocabulary; }
    public int getId_table() { return id_table; }
    public void setId_table(int id_tabla) { this.id_table = id_tabla; }

    @Override
    public String toString() {
        return "Verb{" + "id_vocabulary=" + id_verb + ", id_tabla=" + id_table + ", infinitive=" + infinitive + ", simple_past=" + simple_past + ", past_participle=" + past_participle + ", gerund=" + gerund + '}';
    }
    
    
}

package domain;

public class Tabla {
    private int id_tabla;
    private String color;
    private String name;

    //Constructores
    public Tabla(){}
    
    public Tabla(int id){
        this.id_tabla = id;
    }
    public Tabla(String color, String name){
        this.color = color;
        this.name = name;
    }
    public Tabla(String color, String name, int id){
        this.color = color;
        this.name = name;
        this.id_tabla = id;
    }
    
    //Getter and setter
    public int getId_tabla() { return id_tabla; }
    public void setId_tabla(int id_tabla) { this.id_tabla = id_tabla; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    //Mostrar datos

    @Override
    public String toString() {
        return "Tabla{" + "id_tabla=" + id_tabla + ", color=" + color + ", name=" + name + '}';
    }
    
}

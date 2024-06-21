package domain;

public class Usuario {
    private int id_usuario;
    private String contrasena;
    private String imagen;
    private String cellphone;
    private String nombre;
    
    //constructores
    public Usuario(){}
    public Usuario(int id_usuario){
        this.id_usuario = id_usuario;
    }
    public Usuario(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
    public Usuario(String contrasena, String imagen, String cellphone, String nombre){
        this.contrasena = contrasena;
        this.imagen = imagen;
        this.nombre = nombre;
        this.cellphone = cellphone;
    }
    public Usuario(int id_usuario, String contrasena, String imagen, String cellphone, String nombre){
        this.contrasena = contrasena;
        this.id_usuario = id_usuario;
        this.imagen = imagen;
        this.nombre = nombre;
        this.cellphone = cellphone;
    }

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public String getCellphone() { return cellphone; }
    public void setCellphone(String cellphone) { this.cellphone = cellphone; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", contrasena=" + contrasena + ", imagen=" + imagen + ", cellphone=" + cellphone + ", nombre=" + nombre + '}';
    }
    
}

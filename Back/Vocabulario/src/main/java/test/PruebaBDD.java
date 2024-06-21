package test;

import datos.*;
import domain.*;
import java.util.List;

public class PruebaBDD {
    public static void main(String[] args) {
        
        /*Movimiento con = new Movimiento();
        Verbo verbo = new Verbo();*/
        
        /*Movement con = new Movement();
        Verb verb = new Verb();*/
        
        /*TablaM con = new TablaM();
        Tabla tabla = new Tabla();*/
        
        UsuarioM con = new UsuarioM();
        Usuario usuario = new Usuario();
        
        
        //      Insertar info
        /*usuario.setContrasena("12345");
        usuario.setImagen("photo.png");
        usuario.setCellphone("2212707277");
        usuario.setNombre("Juan Alberto Pancho de Jesus");
        con.insertar(usuario);*/
        
        /*tabla.setColor("RED");
        tabla.setName("Verb list 1");
        con.insertar(tabla);*/
        
        /*verbo.setInfinitivo("to swing");
        verbo.setPasado_simple("swung");
        verbo.setPasado_participio("swung");
        verbo.setGerundio("swinging");
        con.insertar(verbo);*/
        
        /*verb.setInfinitive("to burnnn");
        verb.setSimple_past("burned");
        verb.setPast_participle("burned");
        verb.setGerund("burning");
        con.insertar(verb);*/
        
        
        //      Prueba update
        /*String columna = "nombre";  //columna a modificar
        usuario.setNombre("Jose Alberto Pancho");          //dato nuevo
        usuario.setId_usuario(1);                       //id a modificar
        con.actualizar(usuario, columna);*/
        
        /*String columna = "color";  //columna a modificar
        tabla.setName("ORANGE");          //dato nuevo
        tabla.setId_tabla(1);                       //id a modificar
        con.actualizar(tabla, columna);*/
        
        /*String columna = "nombre";  //columna a modificar
        tabla.setName("List 2");          //dato nuevo
        tabla.setId_tabla(2);                       //id a modificar
        con.actualizar(tabla, columna);*/
        
        /*String columna = "id_tabla";  //columna a modificar
        verbo.setGerundio("1");          //dato nuevo
        verbo.setId_vocabulario(1);                       //id a modificar
        con.actualizar(verbo, columna);*/
        
        /*String columna = "id_tabla";  //columna a modificar
        verb.setGerund("3");          //dato nuevo
        verb.setId_vocabulary(3);                       //id a modificar
        con.actualizar(verb, columna);*/
        
        
        //      Prueba delete 
        /*usuario.setId_usuario(2);
        con.eliminar(usuario);*/
        
        /*tabla.setId_tabla(2);
        con.eliminar(tabla);*/
        
        /*verbo.setId_vocabulario(3);
        con.eliminar(verbo);*/
        
        /*verb.setId_vocabulary(3);
        con.eliminar(verb);*/
          
        //      Mostrar info
        /*List<Verb> vr = con.seleccionar();
        for (Verb v : vr){
            System.out.println("Verbo: " + v);
        }*/
        
        /*List<Verbo> vr = con.seleccionar();
        for (Verbo v : vr){
            System.out.println("Verbo: " + v);
        }*/
        
        /*List<Tabla> vr = con.seleccionar();
        for (Tabla v : vr){
            System.out.println("Tabla: " + v);
        }*/
        
        List<Usuario> vr = con.seleccionar();
        for (Usuario v : vr){
            System.out.println("Usuario: " + v);
        }
        
    }
    
}

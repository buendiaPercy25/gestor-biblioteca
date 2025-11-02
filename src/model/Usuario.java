package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nombre;
    private List<Libro> libros;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Libro> getLibros() {
        return libros;
    }
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void agregarlibro(Libro libro){
        libros.add(libro);
    }

    public void mostraInfo(){
        System.out.println("------------DATOS DE USUARIOS------------");
        System.out.println("NOMBRE : " + nombre);
        for (Libro libro : libros) {
            System.out.println("------------DATOS DEL LIBRO------------");
            System.out.println("AUTOR : " + libro.getAutor());
            System.out.println("TITULO : " + libro.getTitulo());
            System.out.println("CATEGORIA : " + libro.getCategoria());
        }
        System.out.println("-----------------------------------------");
    }

    
    
}

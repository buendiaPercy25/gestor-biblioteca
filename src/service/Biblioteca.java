package service;

import java.util.ArrayList;
import java.util.List;

import model.Libro;
import model.Usuario;

public class Biblioteca {
    private List<Libro> catalogo;
    private List<Usuario> usuarios;

    public Biblioteca(){
        this.catalogo = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    };

    // Registrar objeto y confirmar si el objeto ya existe.
    public void registrarLibro(Libro libro){
        if (!catalogo.contains(libro)) {
            catalogo.add(libro);
        }
    }

    public void registrarUsuario(Usuario usuario){
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public void mostrarCatalogo(){
        for (Libro libro : catalogo) {
            System.out.println("Catalogo de Libros: ");
            System.out.println(libro.getAutor());
            System.out.println(libro.getTitulo());
            System.out.println(libro.getCategoria());
        }
    }

    public void buscarLibroPorId(int id){
        for (Libro libro : catalogo) {
            if (libro.getId() == id) {
                System.out.println("Libro Encontrado : ");
                System.out.println(libro.getAutor());
                System.out.println(libro.getTitulo());
                System.out.println(libro.getCategoria());
                break;
            }
        }
    }
    
    public void buscarUsuarioPorId(int id){
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.println("Usuario Encontrado : ");
                System.out.println(usuario.getNombre());
                break;
            }
        }

    }

    public void buscarLibroPorTitulo(String titulo){
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equals(titulo)) {
                System.out.println("Libro Encontrado : ");
                System.out.println(libro.getAutor());
                System.out.println(libro.getTitulo());
                System.out.println(libro.getCategoria());
                break;
            }
        }
    }

}

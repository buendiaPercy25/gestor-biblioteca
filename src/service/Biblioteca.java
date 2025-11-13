package service;

import java.util.ArrayList;
import java.util.List;

import exceptions.LibroNoDisponibleException;
import exceptions.LibroNoEncontradoException;
import exceptions.UsuarioNoEncontradoException;
import model.Libro;
import model.Usuario;

public class Biblioteca {
    private List<Libro> catalogo;
    private List<Usuario> usuarios;

    public Biblioteca() {
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

    public void devolverLibro(int idUsuario, int idLibro)throws UsuarioNoEncontradoException , LibroNoEncontradoException{
        
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
               List<Libro> listaDeLibros = usuario.getLibros();
                for (Libro libro : listaDeLibros) {
                    if (libro.getId() == idLibro) {
                        libro.setEstado(true);
                        listaDeLibros.remove(libro);
                        usuario.mostraInfo();
                        return;
                    }
                }
                throw new LibroNoEncontradoException ("-----EN LA LISTA DEL USUARIO NO EXISTE EL LIBRO. ");
            }
        }
        throw new UsuarioNoEncontradoException("------EL USUARIO NO EXISTE EN LA LISTA.");
    }

    public void prestarLibro(int idUsuario, int idLibro) throws UsuarioNoEncontradoException, LibroNoEncontradoException , LibroNoDisponibleException {

        for (Usuario usuario : usuarios) {
            if (usuario.getId()== idUsuario) {
                for (Libro libro : catalogo) {
                    if (libro.getId() == idLibro) {
                        if ((libro.isEstado())) {
                            libro.setEstado(false);
                            usuario.agregarlibro(libro);
                            usuario.mostraInfo();
                            return;
                        }
                        throw new LibroNoDisponibleException("-----EL LIBRO NO ESTA DISPONIBLE.");
                    }
                }
                throw new LibroNoEncontradoException("-----EL LIBRO NO EXISTE EN LA LISTA.");
            }
        }
        throw new UsuarioNoEncontradoException("----EL USUARIO NO EXISTE EN LA LISTA.");


    }

    // Registrar objeto y confirmar si el objeto ya existe.
    public void registrarLibro(Libro libro) {
        if (!catalogo.contains(libro)) {
            catalogo.add(libro);
        }
    }

    public void registrarUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    public void mostrarCatalogo() {
        System.out.println("Catalogo de Libros: ");
        for (Libro libro : catalogo) {
            System.out.println("ID : " + libro.getId() + " - TITULO : " + libro.getTitulo() + " - AUTOR : " + libro.getAutor() + " - ESTADO : " + libro.isEstado());
        }
    }

    public void mostraUsuarios(){
        for (Usuario usuario : usuarios) {
            System.out.println("ID : " + usuario.getId() + " NOMBRE : " + usuario.getNombre());
        }
    }

    public void buscarLibroPorId(int id) {
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

    public void buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.println("Usuario Encontrado : ");
                System.out.println(usuario.getNombre());
                break;
            }
        }

    }

    public void buscarLibroPorTitulo(String titulo) {
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
 
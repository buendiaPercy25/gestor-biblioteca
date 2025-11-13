package app;

import java.util.Scanner;

import exceptions.LibroNoDisponibleException;
import exceptions.LibroNoEncontradoException;
import exceptions.UsuarioNoEncontradoException;
import model.Categoria;
import model.Libro;
import model.Usuario;
import service.Biblioteca;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        for (Categoria categoria : Categoria.values()) {
            System.out.println(categoria);
        }

        System.out.print("Ingresar Categoria :");
        String valor = scanner.next();
        scanner.nextLine();

        Categoria cat = Categoria.valueOf(valor.toUpperCase());

        // LIBROS
        Libro libro1 = new Libro(1, "Culpa Nuestra", "Mercedes Room", cat, true);
        Libro libro2 = new Libro(2, "El Principito", "Antoine de Saint-Exupéry", cat, false);
        Libro libro3 = new Libro(3, "Cien años de soledad", "Gabriel García Márquez", cat, true);
        Libro libro4 = new Libro(4, "Clean Code", "Robert C. Martin", cat, true);
        Libro libro5 = new Libro(5, "Harry Potter y la piedra filosofal", "J.K. Rowling", cat, true);
        Libro libro6 = new Libro(6, "Los cuatro acuerdos", "Don Miguel Ruiz", cat, true);

        // USUARIO
        Usuario usuario1 = new Usuario(1, "Antonella");
        Usuario usuario2 = new Usuario(2, "Ana Torres");
        Usuario usuario3 = new Usuario(3, "Luis Gómez");
        Usuario usuario4 = new Usuario(4, "María Quispe");
        Usuario usuario5 = new Usuario(5, "Carlos Rivas");
        Usuario usuario6 = new Usuario(6, "Sofía Mendoza");

        // AGREGAR USUAIOR Y LIBROS

        biblioteca.registrarLibro(libro1);
        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarLibro(libro2);
        biblioteca.registrarUsuario(usuario2);
        biblioteca.registrarLibro(libro3);
        biblioteca.registrarUsuario(usuario3);
        biblioteca.registrarLibro(libro4);
        biblioteca.registrarUsuario(usuario4);
        biblioteca.registrarLibro(libro5);
        biblioteca.registrarUsuario(usuario5);
        biblioteca.registrarLibro(libro6);
        biblioteca.registrarUsuario(usuario6);

        // LISTA DE LIBROS PRESTADO SEGUN EL USUARIO
        try {
            biblioteca.prestarLibro(1, 3);
            biblioteca.prestarLibro(1, 4);

        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoDisponibleException e) {
            System.out.println(e.getMessage());
        }

        // BUSCASR LIBRO MEDIANTE ID O TITULO , ADEMAS PUEDE BUSCAR USUARIO MEDIANTE ID

        System.out.println("1: Buscar Libro por ID");
        System.out.println("2: Buscar usuario por ID");
        System.out.println("3: Buscar Libro por TItulo");
        System.out.println("4: Prestar Libro :");
        System.out.println("5: Devolver Libro :");
        System.out.println("************* Ingresar Opcion : ******************** ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        int id = 0;
        String titulo;
        int idUsuario;
        int idLibro;
        switch (opcion) {
            case 1:
                System.out.println("INGRESAR ID DE LIBRO: ");
                id = scanner.nextInt();
                scanner.nextLine();
                biblioteca.buscarLibroPorId(id);
                break;
            case 2:
                System.out.println("INGRESAR ID DE USUARIO : ");
                id = scanner.nextInt();
                scanner.nextLine();
                biblioteca.buscarUsuarioPorId(id);
                break;
            case 3:
                System.out.println("INGRESAR TITULO DE LIBRO: ");
                titulo = scanner.nextLine();
                biblioteca.buscarLibroPorTitulo(titulo);
                break;
            case 4:
            
            try {
                    System.out.println("LISTA DE LIBROS: ");
                    biblioteca.mostrarCatalogo();
                    System.out.println("LISTA DE USUARIOS: ");
                    biblioteca.mostraUsuarios();
                    System.out.println("PRESTAR LIBRO:");
                    idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    idLibro = scanner.nextInt();
                    scanner.nextLine();

                    biblioteca.prestarLibro(idUsuario, idLibro);

                } catch (UsuarioNoEncontradoException e) {
                    System.out.println(e.getMessage());
                } catch (LibroNoEncontradoException e) {
                    System.out.println(e.getMessage());
                } catch (LibroNoDisponibleException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                System.out.println("DEVOLVER LIBRO ");
                try {
                    idUsuario = scanner.nextInt();
                    idLibro = scanner.nextInt();
                    biblioteca.devolverLibro(idUsuario, idLibro);

                } catch (LibroNoEncontradoException e) {
                    System.out.println(e.getMessage());
                } catch (UsuarioNoEncontradoException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }

    }
}
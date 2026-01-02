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

        Biblioteca biblioteca = new Biblioteca();
        boolean condicional = true;
        int opcion = 0;
        do {

            Scanner scanner = new Scanner(System.in);
            menu();
            System.out.print("INGRESAR UNA OPCION : ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    biblioteca.registrarLibro(registrarLibro());
                    break;
                case 2:
                    biblioteca.registrarUsuario(registrarUsuario());
                    break;
                case 3:
                    listaDeLibros(biblioteca);
                    break;
                case 4:
                    listaDeUsuarios(biblioteca);
                    break;
                case 5:
                    buscarUsuarioPorId(biblioteca);
                    break;
                case 6:
                    buscarLibroPorId(biblioteca);
                    break;
                case 7:
                    buscarLibroPorTitulo(biblioteca);
                    break;
                case 8:
                    prestarLibro(biblioteca);
                    break;
                case 9:
                    devolverLibro(biblioteca);
                    break;

                default:
                    System.out.println("====  CERRANDO SISTEMA  ====");
                    condicional = false;
                    break;
            }

            if (condicional) {
                System.out.println("========================================================");
                System.out.println("========   DESEAS CONTINUAR CON OTRA CONSULTA   ========");
                System.out.println("========================================================");

                System.out.print("INGRESAR (true/ false) : ");
                condicional = scanner.nextBoolean();
                scanner.nextLine();
            }

        } while (condicional);

    }

    public static void menu() {
        System.out.println("========================================================");
        System.out.println("=====             MENÚ DE BIBLIOTECA               =====");
        System.out.println("========================================================");

        System.out.println("========================================================");
        System.out.println("========================================================");
        System.out.println("1.- Registrar Libro");
        System.out.println("2.- Registrar Usuario");
        System.out.println("3.- Mostrar Catalogo de Libros");
        System.out.println("4.- Mostrar Usuarios");
        System.out.println("5.- Buscar Usuarios por ID");
        System.out.println("6.- Buscar Libro por ID");
        System.out.println("7.- Buscar Libro por Titulo");
        System.out.println("8.- Prestar Libro");
        System.out.println("9.- Devolver Libro");
        System.out.println("10.- Salir");
        System.out.println("========================================================");
        System.out.println("========================================================");

    }

    public static void listaCategorias(){

        System.out.println("========================================================");
        System.out.println("=====              LISTA DE CATEGIRIAS             =====");
        System.out.println("========================================================");

        int posicion = 0;
        
        for (Categoria  categoria : Categoria.values()) {
            posicion++;
            System.out.println( posicion + " : "  + categoria);
        }
        System.out.println("========================================================");
    }

    public static Libro registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================================================");
        System.out.println("=====           INGRESAR DATOS DEL LIBRO           =====");
        System.out.println("========================================================");

        listaCategorias();

        System.out.print("INGRESAR ID LIBRO                 : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("INGRESAR EL TITULO                : ");
        String titulo = scanner.nextLine();
        System.out.print("INGRESAR EL AUTOR                 : ");
        String autor = scanner.nextLine();
        System.out.print("INGRESAR CATEGORIA                : ");
        String tipoCategoria = scanner.nextLine();
        Categoria categoria = Categoria.valueOf(tipoCategoria.toUpperCase());
        System.out.print("INGRESAR ESTADO ( true / false )  : ");
        boolean estado = scanner.nextBoolean();

        Libro libro = new Libro(id, titulo, autor, categoria, estado);
        return libro;
    }

    public static Usuario registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================================================");
        System.out.println("=====           INGRESAR DATOS DEL USUARIO         =====");
        System.out.println("========================================================");

        System.out.print("INGRESAR ID DE USUARIO : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("INGRESAR NOMBRE        : ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = new Usuario(id, nombreUsuario);
        return usuario;

    }

    public static void listaDeLibros(Biblioteca biblioteca) {
        System.out.println("========================================================");
        System.out.println("=====              LISTA DE LIBROS                 =====");
        System.out.println("========================================================");
        biblioteca.mostrarCatalogo();
    }

    public static void listaDeUsuarios(Biblioteca biblioteca) {
        System.out.println("========================================================");
        System.out.println("=====              LISTA DE USUARIOS               =====");
        System.out.println("========================================================");
        biblioteca.mostraUsuarios();
    }

    public static void buscarUsuarioPorId(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================================================");
        System.out.println("=====          BUSCAR USUARIO POR ID               =====");
        System.out.println("========================================================");
        System.out.print("INGRESAR ID : ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine();
        biblioteca.buscarUsuarioPorId(idUsuario);
    }

    public static void buscarLibroPorId(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================================================");
        System.out.println("=====            BUSCAR LIBRO POR ID               =====");
        System.out.println("========================================================");
        System.out.print("INGRESAR ID : ");
        int idLibro = scanner.nextInt();
        scanner.nextLine();
        biblioteca.buscarLibroPorId(idLibro);
    }

    public static void buscarLibroPorTitulo(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========================================================");
        System.out.println("=====            BUSCAR LIBRO POR TITULO           =====");
        System.out.println("========================================================");
        System.out.print("INGRESAR TITULO : ");
        String tituloLibro = scanner.nextLine();

        biblioteca.buscarLibroPorTitulo(tituloLibro);
    }

    public static void prestarLibro(Biblioteca biblioteca) {
        try {
            Scanner scanner = new Scanner(System.in);
            biblioteca.mostrarCatalogo();
            biblioteca.mostraUsuarios();
            System.out.println("========================================================");
            System.out.println("=====                  PRESTAR LIBRO               =====");
            System.out.println("========================================================");
            System.out.print("INGRESAR ID DE LIBRO   : ");
            int idCatalogo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("INGRESAR ID DE USUARIO : ");
            int idUsuario = scanner.nextInt();
            scanner.nextLine();

            biblioteca.prestarLibro(idUsuario, idCatalogo);

        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoDisponibleException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void devolverLibro(Biblioteca biblioteca) {
        try {
            Scanner scanner = new Scanner(System.in);
            biblioteca.mostrarCatalogo();
            biblioteca.mostraUsuarios();
            System.out.println("========================================================");
            System.out.println("=====                  DEVOLVER LIBRO              =====");
            System.out.println("========================================================");
            System.out.print("INGRESAR ID DE LIBRO   : ");
            int idCatalogo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("INGRESAR ID DE USUARIO : ");
            int idUsuario = scanner.nextInt();
            scanner.nextLine();

            biblioteca.devolverLibro(idUsuario, idCatalogo);

        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (LibroNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

}
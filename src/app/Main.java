package app;


import java.util.Scanner;

import model.Categoria; 
import model.Libro;
import model.Usuario;
import service.Biblioteca;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        for (Categoria categoria :Categoria.values()) {
            System.out.println(categoria);
        }

        System.out.print("Ingresar Categoria :");
        String valor  = scanner.next();
        scanner.nextLine();

        Categoria cat = Categoria.valueOf(valor.toUpperCase());
        Libro libro1 = new Libro(1, "Culpa Nuestra", "Mercedes Room", cat, true);
        Usuario usuario1 = new Usuario(1, "Antonella");

        // BUSCASR LIBRO MEDIANTE ID O TITULO , ADEMAS PUEDE BUSCAR USUARIO MEDIANTE ID

        System.out.println("1: Buscar Libro por ID");
        System.out.println("2: Buscar usuario por ID");
        System.out.println("3: Buscar Libro por TItulo");
        System.out.println("************* Ingresar Opcion : ******************** ");
        biblioteca.registrarLibro(libro1);
        biblioteca.registrarUsuario(usuario1);
        usuario1.agregarlibro(libro1);
        int opcion = scanner.nextInt();
        scanner.nextLine();
        int id = 0 ; 
        String titulo; 
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
                scanner.nextLine();
                titulo = scanner.nextLine();
                biblioteca.buscarLibroPorTitulo(titulo);
                break;
                
        }




    }
}
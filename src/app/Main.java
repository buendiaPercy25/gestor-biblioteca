package app;


import java.util.Scanner;

import model.Categoria; 
import model.Libro;
import model.Usuario;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (Categoria categoria :Categoria.values()) {
            System.out.println(categoria);
        }
        System.out.print("Ingresar Categoria :");
        String valor  = scanner.next();

        Categoria cat = Categoria.valueOf(valor.toUpperCase());
        Libro libro1 = new Libro(1, "Culpa Nuestra", "Mercedes Room", cat, true);
        
        Usuario usuario1 = new Usuario(1, "Antonella");

        usuario1.agregarlibro(libro1);
        usuario1.mostraInfo();


    }
}
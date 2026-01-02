package model;

public enum Categoria {
    NOVELA("novela"),
    CIENCIA("ciencia"),
    HISTORIA("historia"),
    TECNOLOGIA("tecnologia"),
    INFANTIL("infantil");

    private String nombreCategoria;

    Categoria(String nombreCategirua){
        this.nombreCategoria = nombreCategirua;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    
}


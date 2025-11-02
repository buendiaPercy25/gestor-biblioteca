package model;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private Categoria categoria;
    private boolean estado;

    public Libro(int id, String titulo, String autor, Categoria categoria, boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "ID : " + id + " - TITULO : " + titulo + " - AUTOR : " + categoria + " - ESTADO : " + estado;
    }
    
}

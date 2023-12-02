/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogramacion2;

import java.util.List;

public class Pelicula {

    private String titulo;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private List<String> generos;

    public Pelicula(String titulo, String originalTitle, String overview, String posterPath) {
        this.titulo = titulo;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    Pelicula() {
    }

    public Pelicula(String titulo, String originalTitle, String overview, String posterPath, List<String> generos) {
        this.titulo = titulo;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
        this.generos = generos;
    }



    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the originalTitle
     */
    public String getOriginalTitle() {
        return originalTitle;
    }

    /**
     * @param originalTitle the originalTitle to set
     */
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    /**
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview the overview to set
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return the posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * @param posterPath the posterPath to set
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    
    /**
     * @return the generos
     */
    public List<String> getGeneros() {
        return generos;
    }

    /**
     * @param generos the generos to set
     */
    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", originalTitle=" + originalTitle + ", overview=" + overview + ", posterPath=" + posterPath + ", generos=" + generos + '}';
    }
    
    


   
}

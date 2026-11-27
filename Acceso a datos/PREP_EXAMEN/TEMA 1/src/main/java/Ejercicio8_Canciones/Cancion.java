package Ejercicio8_Canciones;

public class Cancion {
    String titulo;
    String cantante;

    public Cancion(String titulo, String cantante) {
        this.titulo = titulo;
        this.cantante = cantante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "Cancion: "+
                "titulo: " + titulo + '\'' +
                ", cantante: " + cantante;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Cancion c)){
            return false;
        }
        return java.util.Objects.equals(titulo,c.titulo) &&
                java.util.Objects.equals(cantante,c.cantante);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(titulo,cantante);
    }
}

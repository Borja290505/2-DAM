package Comun;

import java.io.Serializable;

public class RespuestaFichero implements Serializable {
    private static final long serialVersionUID = 2L;

    private final PeticionFichero peticion;
    private final boolean correcto;
    private final String contenido;

    public RespuestaFichero(PeticionFichero peticion, boolean correcto, String contenido) {
        this.peticion = peticion;
        this.correcto = correcto;
        this.contenido = contenido;
    }

    public PeticionFichero getPeticion() {
        return peticion;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public String getContenido() {
        return contenido;
    }
}

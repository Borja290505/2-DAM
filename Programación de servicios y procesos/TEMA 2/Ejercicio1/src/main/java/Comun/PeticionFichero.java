package Comun;

import java.io.Serializable;

public class PeticionFichero implements Serializable {
    private static final long seralVersionUID = 1L;

    public enum TipoPeticion{
        LISTAR(1), MOSTRAR(2), SALIR(3);

        public final int valor;

        private TipoPeticion(int valor) {
            this.valor = valor;
        }

        public static TipoPeticion obtenerTipo(int opcion){
            for (TipoPeticion tp : values()){
                if (tp.valor == opcion){
                    return tp;
                }
            }
            return null;
        }
    }
    public static final String MENU = "\n--- MENÚ DE OPCIONES ---\n"
            + TipoPeticion.LISTAR.valor + " - Listar ficheros\n"
            + TipoPeticion.MOSTRAR.valor + " - Mostrar fichero\n"
            + TipoPeticion.SALIR.valor + " - Salir";

    private final TipoPeticion tipoPeticion;
    private final String tipoFichero;

    public PeticionFichero(TipoPeticion tipoPeticion, String tipoFichero) {
        this.tipoPeticion = tipoPeticion;
        this.tipoFichero = tipoFichero;
    }

    public TipoPeticion getTipoPeticion() {
        return tipoPeticion;
    }

    public String getTipoFichero() {
        return tipoFichero;
    }
}

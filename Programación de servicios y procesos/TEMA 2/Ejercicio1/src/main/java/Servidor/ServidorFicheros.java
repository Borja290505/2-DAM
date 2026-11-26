package Servidor;

public class ServidorFicheros {
    public static final String DIRECTORIO_TRABAJO = "./archivos_servidor";


    static void main(String[] args) {
        int puerto;
        try {
            puerto = Integer.parseInt(args[0]);
        }catch (Exception e){
            System.out.println("Falta indicar el puerto por el que se va ha conectar");
            e.printStackTrace();
        }
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            ProcessBuilder ej1 = new ProcessBuilder("C:\\Program Files\\Notepad++\\notepad++.exe","C:\\Users\\dam2\\Documents\\mi_archivo.txt");

            ej1.start();

            System.out.println("Proceso lanzado con éxito.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
